#!/usr/bin/env bash
set -euo pipefail

REPO='edburns/dd-3061974-01-cargotracker'
PARENT=7
LOG='/Users/edburns/workareas/dd-3061974-01-cargotracker-shepherd-control/7-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260909-1942'
VERIFIER='/Users/edburns/.copilot/plugins/shepherd-task/scripts/verify-github-issue-body.sh'
LEDGER="$LOG/creation-ledger.json"
RESULT="$LOG/stage-20-result.json"
BASELINE="$LOG/pre-creation-children.json"

atomic_write() {
    local destination="$1"
    local temporary
    temporary="$(mktemp "$LOG/.stage20.XXXXXX")"
    cat > "$temporary"
    mv "$temporary" "$destination"
}

reconcile_and_fail() {
    local operation="$1"
    local error="$2"
    local children_output normalized ledger_tmp

    if children_output="$(gh api "repos/$REPO/issues/$PARENT/sub_issues" --paginate --slurp 2>&1)"; then
        normalized="$(printf '%s' "$children_output" | jq 'if length == 0 then [] elif all(.[]; type == "array") then add else . end')"
        ledger_tmp="$(jq --argjson children "$normalized" \
            'map(.linked = ([ $children[] | select(.id == .id) ] | length > 0))' "$LEDGER")"
        # Re-evaluate with explicit ledger/server ID comparison; jq's nested scope otherwise shadows the ledger item.
        ledger_tmp="$(jq --argjson children "$normalized" \
            'map(. as $entry | .linked = any($children[]; .id == $entry.id))' "$LEDGER")"
        printf '%s\n' "$ledger_tmp" | atomic_write "$LEDGER"
    else
        error="$error; reconciliation query also failed: $children_output"
    fi

    jq -n --arg error "$operation: $error" \
        '{schemaVersion:1,status:"failed",ledgerFile:"creation-ledger.json",operationError:$error}' |
        atomic_write "$RESULT"

    printf 'FAILED_OPERATION=%s\nERROR=%s\n' "$operation" "$error" >&2
    jq -r '.[] | "ISSUE=\(.number)\tTITLE=\(.title)\tURL=\(.url)\tBODY=\(.bodyFile)\tBODY_VERIFIED=\(.body_verified)\tLINKED=\(.linked)"' "$LEDGER" >&2
    jq -r --arg repo "$REPO" '.[] | "gh issue delete \(.number) --repo \"\($repo)\" --yes"' "$LEDGER" >&2
    exit 1
}

printf '[]\n' | atomic_write "$LEDGER"
jq -n '{schemaVersion:1,status:"in_progress",ledgerFile:"creation-ledger.json",operationError:null}' |
    atomic_write "$RESULT"

subsections=(
    '4.1 — Issue 1: Add the application-layer deadline change operation'
    '4.2 — Issue 2: Expose deadline changes through the booking facade'
    '4.3 — Issue 3: Implement the deadline editor backing model'
    '4.4 — Issue 4: Implement the PrimeFaces deadline dialog'
    '4.5 — Issue 5: Integrate deadline editing into the Administration dashboard'
)
titles=(
    '4.1 — Add the application-layer deadline change operation'
    '4.2 — Expose deadline changes through the booking facade'
    '4.3 — Implement the deadline editor backing model'
    '4.4 — Implement the PrimeFaces deadline dialog'
    '4.5 — Integrate deadline editing into the Administration dashboard'
)
body_files=(
    "$LOG/issue-bodies/01-4-1-body.md"
    "$LOG/issue-bodies/02-4-2-body.md"
    "$LOG/issue-bodies/03-4-3-body.md"
    "$LOG/issue-bodies/04-4-4-body.md"
    "$LOG/issue-bodies/05-4-5-body.md"
)

for index in "${!titles[@]}"; do
    title="${titles[$index]}"
    body="${body_files[$index]}"
    subsection="${subsections[$index]}"
    relative_body="${body#"$LOG/"}"

    if ! issue_json="$(gh api "repos/$REPO/issues" -X POST \
        -f title="$title" -F "body=@$body" \
        --jq '{id,number,node_id,html_url,title}' 2>&1)"; then
        reconcile_and_fail "create issue for $subsection" "$issue_json"
    fi

    if ! printf '%s' "$issue_json" | jq -e '
        (.id | type == "number") and (.number | type == "number") and
        (.html_url | type == "string") and (.title | type == "string")
    ' >/dev/null; then
        reconcile_and_fail "parse created issue for $subsection" "$issue_json"
    fi

    ledger_entry="$(printf '%s' "$issue_json" | jq \
        --arg subsection "$subsection" --arg body "$relative_body" \
        '{implementationSubsection:$subsection,bodyFile:$body,id:.id,number:.number,title:.title,url:.html_url,body_verified:false,linked:false}')"
    jq --argjson entry "$ledger_entry" '. + [$entry]' "$LEDGER" | atomic_write "$LEDGER"

    issue_number="$(printf '%s' "$issue_json" | jq -r '.number')"
    issue_id="$(printf '%s' "$issue_json" | jq -r '.id')"
    diagnostic="$LOG/issue-$issue_number-body-verification-failure.json"
    if ! verified_json="$("$VERIFIER" "$REPO" "$issue_number" "$body" 6 5 "$diagnostic" 2>&1)"; then
        reconcile_and_fail "verify body for issue $issue_number" "$verified_json"
    fi
    jq --argjson number "$issue_number" \
        'map(if .number == $number then .body_verified = true else . end)' "$LEDGER" |
        atomic_write "$LEDGER"

    linked=false
    link_error=''
    for attempt in 1 2 3; do
        if link_output="$(printf '{"sub_issue_id": %s}' "$issue_id" |
            gh api "repos/$REPO/issues/$PARENT/sub_issues" -X POST --input - 2>&1)"; then
            linked=true
            break
        fi
        link_error="attempt $attempt: $link_output"
        sleep 2
    done
    if [[ "$linked" != true ]]; then
        reconcile_and_fail "link issue $issue_number to parent $PARENT" "$link_error"
    fi
    jq --argjson number "$issue_number" \
        'map(if .number == $number then .linked = true else . end)' "$LEDGER" |
        atomic_write "$LEDGER"
done

if ! final_output="$(gh api "repos/$REPO/issues/$PARENT/sub_issues" --paginate --slurp 2>&1)"; then
    reconcile_and_fail "query final parent children" "$final_output"
fi
final_children="$(printf '%s' "$final_output" | jq 'if length == 0 then [] elif all(.[]; type == "array") then add else . end')"
baseline_count="$(jq 'length' "$BASELINE")"
ledger_count="$(jq 'length' "$LEDGER")"
final_count="$(printf '%s' "$final_children" | jq 'length')"
if [[ "$final_count" -ne $((baseline_count + ledger_count)) ]]; then
    reconcile_and_fail "verify final child count" "expected $((baseline_count + ledger_count)), observed $final_count"
fi

if ! jq -e --argjson final "$final_children" --slurpfile baseline "$BASELINE" '
    ($baseline[0] | map(.id)) as $old |
    map(.id) as $expected |
    ([ $final[] | select((.id as $id | $old | index($id)) == null) | .id ]) == $expected
' "$LEDGER" >/dev/null; then
    reconcile_and_fail "verify final child order" "newly linked children do not match ledger order"
fi

while IFS=$'\t' read -r number body_relative; do
    body="$LOG/$body_relative"
    diagnostic="$LOG/issue-$number-body-verification-failure.json"
    if ! final_issue="$("$VERIFIER" "$REPO" "$number" "$body" 6 5 "$diagnostic" 2>&1)"; then
        reconcile_and_fail "final body verification for issue $number" "$final_issue"
    fi
    if ! printf '%s' "$final_issue" | jq -e \
        '.state == "open" and (.assignees | type == "array") and (.assignees | length == 0)' >/dev/null; then
        reconcile_and_fail "verify open/unassigned postcondition for issue $number" "$final_issue"
    fi
done < <(jq -r '.[] | [.number,.bodyFile] | @tsv' "$LEDGER")

jq -n '{schemaVersion:1,status:"complete",ledgerFile:"creation-ledger.json",operationError:null}' |
    atomic_write "$RESULT"

jq -n --slurpfile ledger "$LEDGER" --argjson children "$final_children" \
    '{status:"complete",ledger:$ledger[0],finalChildren:$children}'
