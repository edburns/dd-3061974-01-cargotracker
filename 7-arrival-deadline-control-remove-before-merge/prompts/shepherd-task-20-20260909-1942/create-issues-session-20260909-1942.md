# Copilot CLI Session

> [!NOTE]
> - **Session ID:** `56d24d26-9336-4cf1-af17-ac1932019f01`  
> - **Started:** 9/9/2026, 7:42:21 PM  
> - **Duration:** 2m 43s  
> - **Exported:** 9/9/2026, 7:45:05 PM  

---

<sub>2s</sub>

### User

Invoke skill `shepherd-task-20-create-issues-from-plan` with these inputs:

- CAMPAIGN_ID: 6c5f2b96-d399-4374-855f-976835ea0247
- LESSON_PROPAGATION: off
- REPO: edburns/dd-3061974-01-cargotracker
- BASE_BRANCH: experiment/shepherd-control
- PARENT_ISSUE: 7
- PLAN_DIRECTORY: 7-arrival-deadline-control-remove-before-merge
- PLAN_FILE_NAME: add-change-arrival-deadline-feature-ignorance-reduction-plan.md
- QUESTIONS_SECTION: ## Phase 3 — Ignorance reduction: questions to answer before writing code
- IMPLEMENTATION_SECTION: ## Phase 4 — Implementation (five serial issues)
- EXPECTED_TASK_COUNT: 5
- BASE_REMOTE: origin
- LOG_DIRECTORY: /Users/edburns/workareas/dd-3061974-01-cargotracker-shepherd-control/7-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260909-1942
- DRAFT_VALIDATOR: /Users/edburns/.copilot/plugins/shepherd-task/scripts/validate-stage20-drafts.sh
- ISSUE_BODY_VERIFIER: /Users/edburns/.copilot/plugins/shepherd-task/scripts/verify-github-issue-body.sh

Fixture pagination response contract (mandatory):

- `gh api ... --paginate --slurp` returns a JSON array of page payloads, so a
  one-page response has the shape `[[{...}]]`, not `[{...}]`.
- Before indexing child issue fields such as `.id`, normalize the response to
  one flat issue array exactly once.
- In Bash, use:
  `jq 'if length == 0 then [] elif all(.[]; type == "array") then add else . end'`.
- In PowerShell, capture the `gh` output and `$LASTEXITCODE` first, then pass
  the complete JSON through the same `jq` normalization before
  `ConvertFrom-Json`.
- Use the normalized flat array for the pre-creation baseline, final child
  count/order checks, and failure reconciliation. Do not apply `add` a second
  time to an already-flat array.

---

<sub>5s</sub>

### `skill`

**shepherd-task-20-create-issues-from-plan**

<details>
<summary>Arguments</summary>

```json
{
  "skill": "shepherd-task-20-create-issues-from-plan"
}
```

</details>

```
Skill "shepherd-task-20-create-issues-from-plan" loaded successfully. Follow the instructions in the skill context.
```


---

<sub>9s</sub>

### Copilot

I’m validating the campaign inputs, plan structure, GitHub parent state, and issue-writing conventions before any mutation.

---

<sub>19s</sub>

### `view`

**view the file at /Users/edburns/.copilot/skills/shepherd-task-20-create-issues-from-plan/examples/01-1682-java-tool-ergonomics.md.**

/Users/edburns/.copilot/skills/shepherd-task-20-create-issues-from-plan/examples/01-1682-java-tool-ergonomics.md (lines 1--1)

<details>
<summary>15 lines</summary>

```
# Example 01: 1682-java-tool-ergonomics-prompts-remove-before-merge

Read `copilot-sdk/1682-java-tool-ergonomics-prompts-remove-before-merge/dd-3018003-ignorance-reduction-for-implementation-plan.md` (the plan) to get the context.

✅✅Pay very close attention to each **Resolution:** to the questions in `Phase 3 — Ignorance reduction: questions to answer before writing code`.

In this session, we are creating issues of type **Task** as children of Epic https://github.com/github/copilot-sdk/issues/1682 . These issues correspond to the sub-sections in `## Phase 4 — Implementation (the build order)`.

I want you to use `gh` to create issues as sub-issues of 1682.

- I will dispatch these issues by assigning them to an agent. Leave them unassigned for now.

- The description you put in the issues you create is the specification for the work the agent assigned to the issue must do. Therefore, you need to be very specific and targeted when writing the description.

- Set the type to **Task**.

- Each issue will be worked on and resolved in serial. You can assume:
  - All issues will operate in this topic branch of `upstream`: `edburns/1682-java-tool-ergonomics`.

  - The assignee agent has access to the topic branch and, most importantly, to the prompts in the directory `1682-java-tool-ergonomics-prompts-remove-before-merge`, which includes the plan. Therefore, you can instruct the agent to access the plan by reference, you don't need to reference it by value directly in the issue.

- The sub-sections of `## Phase 4 — Implementation (the build order)` have essential details for each corresponding **Task**.

- Instruct the agent to read the entire plan before working.

- Instruct the agent to carefully re-read the relevant sections of the of the plan. ❌❌You can't just say, "read the relevant sections of the plan". ✅✅In the description of the issue, list exactly what sections of the plan apply to this particular issue.
- Though the sub-sections of `## Phase 4 — Implementation (the build order)` have essential details for each corresponding **Task**, I want you to carefully consider if there additional gating tests you can add so that as the agent proceeds from one task to the next, the likelihood of rework is reduced.
```

</details>


---

<sub>19s</sub>

### `view`

**view the file at /Users/edburns/.copilot/skills/shepherd-task-20-create-issues-from-plan/examples/02-1810-java-tool-as-lambda.md.**

/Users/edburns/.copilot/skills/shepherd-task-20-create-issues-from-plan/examples/02-1810-java-tool-as-lambda.md (lines 1--1)

<details>
<summary>12 lines</summary>

```
# Example 02: 1810-java-tool-ergonomics-tool-as-lambda-remove-before-merge

Carefully read the plan `copilot-sdk/1810-java-tool-ergonomics-tool-as-lambda-remove-before-merge/1810-ignorance-reduction-for-implementation-plan.md`.

We have completed Phases 1 - 3. We are now on Phase 4.

For each sub item in Phase 4, file a child issue of Feature #1810.

Use `gh` to look at Epic #1682 and its child issues for the standard of verbosity and concreteness for issue descriptions.

The issue should be assignable to a coding agent and there must be sufficient detail in the description for the agent to proceed to completion.

Pull out the specific relevant content from Phase 3 as it applies to this current issue in Phase 4.

Tell the agent to take `edburns/1810-java-tool-ergonomics-tool-as-lambda` as the base branch. When I assign the issue to the coding agent, I will set this as the base branch.

Tell the agent to read `1810-java-tool-ergonomics-tool-as-lambda-remove-before-merge/1810-ignorance-reduction-for-implementation-plan.md`, which is present on the branch, for context.

Tell the agent which sub-item within Phase 4 they are solving.

Tell the agent that each issue will be assigned, resolved and merged to the base branch in the order in which they appear in the plan.

No work is to start until I assign each issue to the coding agent, in turn.
```

</details>


---

<sub>19s</sub>

### `view`

**view the file at /Users/edburns/.copilot/skills/shepherd-task-20-create-issues-from-plan/examples/03-dd-3017826-java-real-estate-demo.md.**

/Users/edburns/.copilot/skills/shepherd-task-20-create-issues-from-plan/examples/03-dd-3017826-java-real-estate-demo.md (lines 1--1)

<details>
<summary>14 lines</summary>

```
# Example 03: dd-3017826-java-real-estate-demo-remove-before-merge

Read `dd-3017826-java-real-estate-demo-remove-before-merge\dd-3017826-java-real-estate-demo-ignorance-reduction-plan.md` (the plan) to get the context.

✅✅Pay very close attention to each **Resolution:** to the questions in `Phase 2 — Ignorance reduction: questions to answer before writing code`.

In this session, we are creating sub-issues as children of https://github.com/edburns/Build26-BRK206-your-agent-anywhere-multiclient-multidevice-with-github-copilot-sdk/issues/2 . These issues correspond to the sub-sections in `## Phase 3 — Implementation (build order)`.

I want you to use `gh` to create issues as sub-issues of #2.

- I will dispatch these issues by assigning them to an agent. Leave them unassigned for now.

- The description you put in the issues you create is the specification for the work the agent assigned to the issue must do. Therefore, you need to be very specific and targeted when writing the description.

- Each issue will be worked on and resolved in serial. You can assume:
  - All issues will operate in this topic branch of `origin`: `edburns/2-build-out-demo`.

  - The assignee agent has access to the topic branch and, most importantly, to the prompts in the directory `dd-3017826-java-real-estate-demo-remove-before-merge`, which includes the plan. Therefore, you can instruct the agent to access the plan by reference, you don't need to reference it by value directly in the issue.

- The sub-sections of `## Phase 3 — Implementation (build order)` have essential details for each corresponding sub-issue.

- Instruct the agent to read the entire plan before working.

- Instruct the agent to carefully re-read the relevant sections of the of the plan. ❌❌You can't just say, "read the relevant sections of the plan". ✅✅In the description of the issue, list exactly what sections of the plan apply to this particular issue.
- Though the sub-sections of `## Phase 3 — Implementation (build order)` have essential details for each corresponding sub-issue, I want you to carefully consider if there additional gating tests you can add so that as the agent proceeds from one task to the next, the likelihood of rework is reduced.
```

</details>


---

<sub>19s</sub>

### `view`

**view the file at /Users/edburns/.copilot/skills/shepherd-task-20-create-issues-from-plan/examples/04-28-python-agent-demo.md.**

/Users/edburns/.copilot/skills/shepherd-task-20-create-issues-from-plan/examples/04-28-python-agent-demo.md (lines 1--1)

<details>
<summary>16 lines</summary>

```
# Example 04: 28-python-agent-demo-remove-before-merge

Read `28-python-agent-demo-remove-before-merge/28-python-agent-demo-ignorance-reduction-plan.md` (the plan) to get the context.

✅✅Pay very close attention to each **Resolution:** to the questions in `Phase 2 — Ignorance reduction: questions to answer before writing code`. These pertain to the implementation tasks in Phase 3. ✅✅✅ Make sure to put into the description explicit instructions on how to access the relevant spike research.

In this session, we are creating sub-issues as children of https://github.com/edburns/Build26-BRK206-your-agent-anywhere-multiclient-multidevice-with-github-copilot-sdk/issues/28 . These issues correspond to the sub-sections in `## Phase 3 — Implementation (build order)`.

I want you to use `gh` to create issues as sub-issues of #28

- I will dispatch these issues by assigning them to an agent. Leave them unassigned for now.

- The description you put in the issues you create is the specification for the work the agent assigned to the issue must do. Therefore, you need to be very specific and targeted when writing the description.

- Again, ✅✅For each **Resolution:** to the questions in `Phase 2 — Ignorance reduction: questions to answer before writing code`, include the relevant Resolution values in the issue description. These pertain to the implementation tasks in Phase 3. ✅✅✅ Make sure to put into the description explicit instructions on how to access the relevant spike research for that task.

- For tasks dealing with the UI, make sure to refer to the relevant screengrabs, but only ones within `28-python-agent-demo-remove-before-merge/`.

- Each issue will be worked on and resolved in serial. You can assume:
  - All issues will operate in this topic branch of `origin`: `edburns/28-python-agent-demo`.

  - The assignee agent has access to the topic branch and, most importantly, to the prompts in the directory `28-python-agent-demo-remove-before-merge/`, which includes the plan. Therefore, you can instruct the agent to access the plan by reference, you don't need to reference it by value directly in the issue.

- The sub-sections of `## Phase 3 — Implementation (build order)` have essential details for each corresponding sub-issue.

- Instruct the agent to read the entire plan before working.

- Instruct the agent to carefully re-read the relevant sections of the of the plan. ❌❌You can't just say, "read the relevant sections of the plan". ✅✅In the description of the issue, list exactly what sections of the plan apply to this particular issue.
- Though the sub-sections of `## Phase 3 — Implementation (build order)` have essential details for each corresponding sub-issue, I want you to carefully consider if there additional gating tests you can add so that as the agent proceeds from one task to the next, the likelihood of rework is reduced.
```

</details>


---

<sub>19s</sub>

### `bash`

**Validate inputs and capture plan state**

$ set -euo pipefail
LOG='/Users/edburns/workareas/dd-3061974-01-cargotracker-shepherd-control/7-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260909-1942'
DV='/Users/edburns/.copilot/plugins/shepherd-task/scripts/validate-stage20-drafts.sh'
BV='/Users/edburns/.copilot/plugins/shepherd-task/scripts/verify-github-issue-body.sh'
test -d "$LOG" && test -w "$LOG" && mkdir -p "$LOG/issue-bodies"
test -x "$DV" && test -x "$BV"
git remote get-url origin
git show-ref --verify --quiet refs/heads/experiment/shepherd-control || git show-ref --verify --quiet refs/remotes/origin/experiment/shepherd-control
git remote -v
gh api repos/edburns/dd-3061974-01-cargotracker --jq '{default_branch,owner}'
gh api repos/edburns/dd-3061974-01-cargotracker/issues/7 --jq '{number,state,repository_url,title}'
gh api 'repos/edburns/dd-3061974-01-cargotracker/issues/7/sub_issues' --paginate --slurp | jq 'if length == 0 then [] elif all(.[]; type == "array") then add else . end' > "$LOG/pre-creation-children.json"
jq '[.[] | {id,number,title}]' "$LOG/pre-creation-children.json"
git show 'experiment/shepherd-control:7-arrival-deadline-control-remove-before-merge/add-change-arrival-deadline-feature-ignorance-reduction-plan.md' > "$LOG/plan.md"
git show 'experiment/shepherd-control:7-arrival-deadline-control-remove-before-merge/shepherd-campaign.json' > "$LOG/campaign.json"
git cat-file -e 'experiment/shepherd-control:7-arrival-deadline-control-remove-before-merge/campaign-lessons.md'
printf '\n---CAMPAIGN---\n'; cat "$LOG/campaign.json"
printf '\n---PLAN FILES---\n'; git ls-tree -r --name-only experiment/shepherd-control -- '7-arrival-deadline-control-remove-before-merge'

<details>
<summary>31 lines</summary>

```
git@github.com:edburns/dd-3061974-01-cargotracker.git
origin	git@github.com:edburns/dd-3061974-01-cargotracker.git (fetch)
origin	git@github.com:edburns/dd-3061974-01-cargotracker.git (push)
upstream	git@github.com:azure-javaee/cargotracker.git (fetch)
upstream	git@github.com:azure-javaee/cargotracker.git (push)
{"default_branch":"20260902-2104Z-commit-e7b651f-liberty","owner":{"avatar_url":"https://avatars.githubusercontent.com/u/75821?v=4","events_url":"https://api.github.com/users/edburns/events{/privacy}","followers_url":"https://api.github.com/users/edburns/followers","following_url":"https://api.github.com/users/edburns/following{/other_user}","gists_url":"https://api.github.com/users/edburns/gists{/gist_id}","gravatar_id":"","html_url":"https://github.com/edburns","id":75821,"login":"edburns","node_id":"MDQ6VXNlcjc1ODIx","organizations_url":"https://api.github.com/users/edburns/orgs","received_events_url":"https://api.github.com/users/edburns/received_events","repos_url":"https://api.github.com/users/edburns/repos","site_admin":true,"starred_url":"https://api.github.com/users/edburns/starred{/owner}{/repo}","subscriptions_url":"https://api.github.com/users/edburns/subscriptions","type":"User","url":"https://api.github.com/users/edburns","user_view_type":"public"}}
{"number":7,"repository_url":"https://api.github.com/repos/edburns/dd-3061974-01-cargotracker","state":"open","title":"[Campaign][off] Cargo Tracker arrival-deadline control"}
[]

---CAMPAIGN---
{
  "schemaVersion": 1,
  "campaignId": "6c5f2b96-d399-4374-855f-976835ea0247",
  "campaignIssueNumber": 7,
  "campaignShortname": "arrival-deadline-control",
  "repository": "edburns/dd-3061974-01-cargotracker",
  "baseBranch": "experiment/shepherd-control",
  "lessonPropagation": "off",
  "campaignMetadataDirectory": "7-arrival-deadline-control-remove-before-merge",
  "lessonsFile": "campaign-lessons.md",
  "createdBy": {
    "shepherdTaskVersion": "1.0.2",
    "stageOutcomeProtocolVersion": 1
  },
  "createdAt": "2026-09-10T02:42:16Z"
}

---PLAN FILES---
7-arrival-deadline-control-remove-before-merge/add-change-arrival-deadline-feature-ignorance-reduction-plan.md
7-arrival-deadline-control-remove-before-merge/campaign-lessons.md
7-arrival-deadline-control-remove-before-merge/shepherd-campaign.json
7-arrival-deadline-control-remove-before-merge/shepherd-test-experiment.json
<shellId: 0 completed with exit code 0>
```

</details>


---

<sub>22s</sub>

### Copilot

Validation passed: the parent is open, the topic branch is distinct from the default branch, the campaign manifest matches, no children exist yet, and this user-owned repository will use untyped issues. I’m now extracting all resolved decisions and the five serial specifications.

---

<sub>27s</sub>

### `view`

**view the file at /Users/edburns/workareas/dd-3061974-01-cargotracker-shepherd-control/7-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260909-1942/plan.md.**

/Users/edburns/workareas/dd-3061974-01-cargotracker-shepherd-control/7-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260909-1942/plan.md (lines 1-240)

<details>
<summary>185 lines</summary>

````
# Implementation plan: Change Arrival Deadline Date (`eclipse-ee4j/cargotracker#64`)

Human DRI: Ed Burns
Starting commit: `9b9f311b2a3a2854bdac947593950d9edb6bca7d` (`Make the system ready for implementation`)
Working directory: repository root of the current campaign worktree
Runtime baseline: Java 17, Java EE 7 (`javax.*`), Open Liberty 26.0.0.8, PrimeFaces 8.0
Baseline run instructions: `README.md`
Baseline preparation: fixed source branch and immutable SHA validated by the campaign fixture
Historical issue: `eclipse-ee4j/cargotracker#64`

Related directories and files:

- `src/main/java/org/eclipse/cargotracker/application/`
- `src/main/java/org/eclipse/cargotracker/interfaces/booking/facade/`
- `src/main/java/org/eclipse/cargotracker/interfaces/booking/web/`
- `src/main/webapp/admin/dialogs/`
- `src/main/webapp/admin/tables/listNotRouted.xhtml`
- `src/test/java/org/eclipse/cargotracker/application/BookingServiceTest.java`

---

## Goal

Add an Administration dashboard operation that lets a shipping administrator
change the arrival deadline of a cargo listed in the **Not Routed Cargo** table.
The operation must preserve Cargo Tracker's layered architecture:

1. The application service owns the domain mutation.
2. The booking facade shields the web layer from domain types.
3. A JSF backing bean loads and submits the editable date.
4. A PrimeFaces dynamic dialog presents the editor.
5. The existing Not Routed Cargo table opens the dialog and refreshes after a
   successful update.

### User-visible acceptance behavior

Using the stable sample cargo `DEF789`:

1. Start the application with Java 17:

   ```bash
   ./mvnw clean package -Popenliberty liberty:run
   ```

2. Open `http://localhost:8080/cargo-tracker/`.
3. Select **Administration**.
4. Find `DEF789` in the **Not Routed Cargo** table.
5. The Deadline cell displays its date together with an edit icon.
6. Hovering over the deadline displays:
   `Click to change cargo arrival deadline date.`
7. Selecting the deadline opens a modal dialog titled **Change Deadline**.
8. The dialog displays the cargo's origin and destination as read-only
   context.
9. The date editor is initialized to the cargo's current arrival deadline.
10. Selecting a different date and pressing **Update** closes the dialog and
    refreshes the Administration view.
11. The new date is shown in the Not Routed Cargo table.
12. Reloading the page continues to show the new date for the lifetime of the
    running in-memory sample application.
13. Pressing **Cancel** closes the dialog without changing the deadline.

### Domain acceptance behavior

Changing the deadline must:

- locate the cargo by `TrackingId`;
- preserve its existing origin;
- preserve its existing destination;
- replace only the arrival deadline in its `RouteSpecification`;
- apply the specification through `Cargo.specifyNewRoute(...)`;
- preserve the currently assigned itinerary rather than silently discarding
  it;
- allow the domain model to recalculate routing status and delivery-derived
  values against the new route specification;
- persist the changed cargo through `CargoRepository.store(...)`.

### Hard scope constraints

- Begin from commit `9b9f311b2a3a2854bdac947593950d9edb6bca7d`.
- Preserve Java EE 7 and the `javax.*` namespace.
- Preserve the Java 7 source/target level used by this historical codebase.
- Run the application on JDK 17 using the existing Open Liberty profile.
- Do not migrate the application to Jakarta EE 8+, Jakarta EE 9+, Spring, or a
  different UI framework.
- Do not replace the in-memory Derby configuration or the Open Liberty runtime.
- Do not redesign unrelated cargo booking, routing, destination editing,
  messaging, batch, REST, or persistence behavior.
- Do not copy commits or files from feature-bearing branches. This plan is the
  implementation specification.
- Implement the five build issues below in order. Each issue must be complete
  and gated before the next issue begins.

---

## Completed phases

### Phase 1 ✅ — Establish a runnable feature-absent baseline

- Commit `9b9f311b2a3a2854bdac947593950d9edb6bca7d` is based on the historical
  feature-absent commit and contains only the compatibility work needed to run
  the sample on JDK 17 and Open Liberty.
- `./mvnw clean package -Popenliberty liberty:run` starts the application.
- The home page and Administration flows return HTTP 200.
- JSF view metadata is placed at `UIViewRoot` scope for MyFaces compatibility.
- The internal routing REST client works without a Jersey/MOXy classloading
  conflict.
- The scheduled batch job has the local authorization it needs.

### Phase 2 ✅ — Verify the before and after user experience

- Before implementation, `DEF789` appears in the Not Routed Cargo table with a
  plain-text deadline and no edit operation.
- The neighboring Destination column demonstrates the existing PrimeFaces
  dynamic-dialog interaction pattern.
- The desired after behavior has been manually exercised: open the deadline
  editor, choose a new date, update, refresh the table, and observe the
  persisted value.
- The historical architectural boundaries and affected files have been
  identified.

---

## Phase 3 — Ignorance reduction: questions to answer before writing code

Resolve these questions before production implementation begins. The
recommendations intentionally define the desired design closely enough that an
implementing agent should not need to invent a different architecture.

### 3.1 — Which cargos expose the edit operation?

**Question:** Should deadline editing be exposed for all cargos or only for
cargos displayed in the Not Routed Cargo table?

The requested feature originates in the Administration dashboard's Not Routed
Cargo table. Other tables represent routed, misrouted, claimed, or otherwise
progressed cargo. Adding the affordance to every table would expand the feature
and require additional business rules about changing deadlines after handling
has begun.

| Option | UI scope | Trade-off |
|--------|----------|-----------|
| A | Not Routed Cargo table only | Matches the requested feature and the established destination-edit affordance. |
| B | Every Administration cargo table | Broader capability, but introduces lifecycle and authorization questions outside the request. |
| C | Cargo details page only | Avoids table complexity but does not meet the requested dashboard interaction. |

The application-service operation itself does not need to encode a UI-table
restriction. It should accept a tracking ID and apply the domain mutation to
the located cargo. The presentation layer determines where the operation is
offered.

**Recommendation:** Option A. Add the edit affordance only to
`src/main/webapp/admin/tables/listNotRouted.xhtml`. Keep the application
operation generally usable for a valid cargo.

**Resolution:**

Select Option A. Expose the edit affordance only in
`src/main/webapp/admin/tables/listNotRouted.xhtml`. The application and facade
operations remain generally callable for any cargo that can be found by
tracking ID; they do not encode knowledge of dashboard table membership.

### 3.2 — What is the exact domain mutation?

**Question:** Should the feature mutate the existing `RouteSpecification`, add
a setter to `Cargo`, or replace the specification using the existing domain
operation?

`RouteSpecification` is a value object describing origin, destination, and
arrival deadline. The existing `changeDestination(...)` implementation already
establishes the correct pattern: create a replacement specification, call
`Cargo.specifyNewRoute(...)`, and store the aggregate.

Proposed application-service shape:

```java
void changeDeadline(TrackingId trackingId, Date deadline);
```

Proposed implementation:

```java
Cargo cargo = cargoRepository.find(trackingId);
RouteSpecification specification = new RouteSpecification(
        cargo.getOrigin(),
        cargo.getRouteSpecification().getDestination(),
        deadline);

cargo.specifyNewRoute(specification);
cargoRepository.store(cargo);
```

Calling `specifyNewRoute(...)` is significant. It lets the aggregate recalculate
delivery and routing status relative to the new specification. Direct field
mutation or a persistence-only update would bypass that behavior.

**Recommendation:** Replace the `RouteSpecification` through
`Cargo.specifyNewRoute(...)`. Preserve origin, destination, and itinerary.
Persist using the existing repository. Do not add a deadline setter to the
domain model.

**Resolution:**

Use the same aggregate-update pattern as `changeDestination(...)`. Add
`BookingService.changeDeadline(TrackingId, Date)` and implement it by loading
the cargo, constructing a new `RouteSpecification` from the existing origin,
existing destination, and supplied deadline, calling
`cargo.specifyNewRoute(...)`, and storing the cargo through
`cargoRepository.store(...)`. Do not add mutable deadline setters to the domain
objects.

### 3.3 — What should happen to an existing itinerary and delivery state?

**Question:** When a routed cargo's deadline changes, should its itinerary be
cleared, retained, or recomputed?

Although the UI initially exposes the feature only for unrouted cargo, the
application operation should have deterministic domain behavior if invoked for
a routed cargo. The existing `changeDestination(...)` behavior preserves the
assigned itinerary and lets `Cargo.specifyNewRoute(...)` recalculate whether
that itinerary still satisfies the new specification.

The core application test should deliberately invoke the operation after:

1. booking a cargo;
2. requesting route candidates;
3. assigning an itinerary;
4. changing its destination;
5. changing its deadline.

This sequence verifies that the feature uses the aggregate correctly rather
than assuming the cargo always has an empty itinerary.

**Recommendation:** Preserve the itinerary. Let the domain model recompute
routing and delivery-derived state. Assert all unaffected fields explicitly in
`BookingServiceTest`.

**Resolution:**

Retain the existing itinerary. Do not clear, replace, or reroute it as part of
the deadline change. `Cargo.specifyNewRoute(...)` recalculates the delivery
````

</details>


---

<sub>27s</sub>

### `view`

**view the file at /Users/edburns/workareas/dd-3061974-01-cargotracker-shepherd-control/7-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260909-1942/plan.md.**

/Users/edburns/workareas/dd-3061974-01-cargotracker-shepherd-control/7-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260909-1942/plan.md (lines 241-520)

<details>
<summary>209 lines</summary>

````
snapshot and routing status against the replacement specification. In the
established sequential application test, the assigned itinerary remains
unchanged and the cargo remains `MISROUTED` after the deadline changes.

### 3.4 — What type crosses the facade boundary?

**Question:** Should the booking facade accept a `Date`, a formatted string, or
a newly introduced request DTO?

The existing facade already uses `java.util.Date` for
`bookNewCargo(...)`. Introducing another representation for this one operation
would create unnecessary conversion code and depart from the historical
application style.

Proposed facade shape:

```java
void changeDeadline(String trackingId, Date arrivalDeadline);
```

The implementation converts only the identifier:

```java
bookingService.changeDeadline(
        new TrackingId(trackingId),
        arrivalDeadline);
```

**Recommendation:** Use `String` for the tracking ID and `java.util.Date` for
the deadline. Do not expose `TrackingId`, `Cargo`, or `RouteSpecification` to
the JSF layer and do not introduce a new DTO solely for this command.

**Resolution:**

Add `void changeDeadline(String trackingId, Date arrivalDeadline)` to
`BookingServiceFacade`. `DefaultBookingServiceFacade` converts the string to
`new TrackingId(trackingId)` and passes the same `Date` to
`BookingService.changeDeadline(...)`. No new command DTO or formatted-string
service parameter is introduced.

### 3.5 — How is the DTO's formatted deadline converted for editing?

**Question:** `CargoRoute` exposes its deadline as formatted strings, while
`p:datePicker` binds naturally to `java.util.Date`. How should the backing bean
initialize the editor?

At the starting commit:

- `CargoRoute.getArrivalDeadline()` returns
  `MM/dd/yyyy hh:mm a z`.
- `CargoRoute.getArrivalDeadlineDate()` returns only the date component.
- The table displays `getArrivalDeadlineDate()`.

Options:

| Option | Approach | Trade-off |
|--------|----------|-----------|
| A | Parse `cargo.getArrivalDeadlineDate()` with `MM/dd/yyyy` | Small, localized change; preserves the existing DTO contract. |
| B | Add a `Date` property to `CargoRoute` | Cleaner typing, but broadens a DTO used throughout the application. |
| C | Reload the domain object in the backing bean | Violates the facade boundary. |

The formatter/parser must be created per operation or per view bean; do not add
a shared mutable `SimpleDateFormat`.

**Recommendation:** Option A. Load `CargoRoute` through
`BookingServiceFacade.loadCargoForRouting(trackingId)` and parse
`cargo.getArrivalDeadlineDate()` using `new SimpleDateFormat("MM/dd/yyyy")`.
Surface an explicit failure if the existing DTO value cannot be parsed; do not
silently submit a null date.

**Resolution:**

Use Option A and keep date conversion inside the view-scoped editor bean. The
existing implementation loads the `CargoRoute`, creates
`new SimpleDateFormat("MM/dd/yyyy")`, and parses the leading date portion of
`cargo.getArrivalDeadline()`. Because that value begins with `MM/dd/yyyy`,
`SimpleDateFormat.parse(...)` obtains the same date that
`getArrivalDeadlineDate()` displays. A per-load formatter is used, so no shared
mutable formatter is added.

### 3.6 — Which JSF bean scopes and interaction pattern should be used?

**Question:** Should deadline editing introduce a new navigation page, use an
inline editor, or mirror the existing Change Destination dynamic-dialog
pattern?

The baseline already contains:

- `ChangeDestination`, a CDI `@Named` and JSF `@ViewScoped` editor bean;
- `ChangeDestinationDialog`, a session-scoped JSF managed bean that opens and
  closes a PrimeFaces dynamic dialog;
- `changeDestination.xhtml`, a dialog view;
- a `dialogReturn` Ajax listener that refreshes `tableNotRouted`.

Using the same pattern minimizes changes and provides a consistent user
experience.

Proposed bean names:

```text
changeArrivalDeadlineDate
changeArrivalDeadlineDateDialog
```

**Recommendation:** Add a serializable CDI `@Named @ViewScoped`
`ChangeArrivalDeadlineDate` editor and a serializable
`@ManagedBean(name = "changeArrivalDeadlineDateDialog") @SessionScoped`
launcher. Mirror the existing destination-dialog lifecycle rather than
introducing a new navigation or inline-edit framework.

**Resolution:**

Mirror the existing Change Destination interaction. Implement
`ChangeArrivalDeadlineDate` as a serializable CDI `@Named @ViewScoped` bean and
`ChangeArrivalDeadlineDateDialog` as a serializable
`@ManagedBean(name = "changeArrivalDeadlineDateDialog") @SessionScoped` bean.
Use a PrimeFaces dynamic dialog rather than navigation to a full page or inline
cell editing.

### 3.7 — What is the dynamic-dialog contract?

**Question:** What path, request parameters, dimensions, and close result should
the PrimeFaces dialog use?

The launcher needs one parameter, `trackingId`, supplied as a
`Map<String, List<String>>`. The dialog metadata binds the parameter and invokes
the editor bean's `load()` action.

Proposed launcher contract:

```java
PrimeFaces.current().dialog().openDynamic(
        "/admin/dialogs/changeArrivalDeadlineDate.xhtml",
        options,
        params);
```

Required options:

| Option | Value |
|--------|-------|
| `modal` | `true` |
| `draggable` | `true` |
| `resizable` | `false` |
| `contentWidth` | `410` |
| `contentHeight` | `280` |

Required completion behavior:

- successful update: `closeDynamic("DONE")`;
- cancel: `closeDynamic("")`;
- caller listens for `dialogReturn` and updates `tableNotRouted`.

Because Open Liberty uses MyFaces, `<f:metadata>` must be a direct child of the
view root, before `<h:head>` and `<h:body>`. It must not be nested inside
`<h:body>`.

**Recommendation:** Use the contract above and preserve the metadata placement
required by the prepared baseline.

**Resolution:**

Open `/admin/dialogs/changeArrivalDeadlineDate.xhtml` with a single
`trackingId` request parameter and these options: modal and draggable are
`true`, resizable is `false`, content width is `410`, and content height is
`280`. Successful submission closes with `"DONE"`; cancellation closes with
the empty string. The caller handles `dialogReturn` and updates
`tableNotRouted`. Place the dialog's `<f:metadata>` directly under the root
`<html>` element, before `<h:head>` and `<h:body>`, so the known MyFaces
`UIViewRoot` requirement is satisfied.

### 3.8 — What date validation is required?

**Question:** Must the new deadline be non-null, in the future, after the
current date, or after itinerary completion?

The requested feature is an administrative correction to an existing arrival
deadline. No new domain policy about future dates is part of the request.
Inventing such a rule could reject dates accepted by existing cargo booking or
`RouteSpecification` behavior.

The UI must nevertheless prevent a null submission because the operation
requires a concrete replacement deadline.

**Recommendation:** Require a date value in the JSF form and display a normal
Faces validation message when it is absent. Do not add a new minimum-date,
future-date, or itinerary-date business rule. Continue to rely on the existing
domain model for its established invariants.

**Resolution:**

Require a non-null date selection, but add no new chronological business rule.
In particular, do not require the replacement deadline to be after today,
after the old deadline, or after every itinerary leg. Pass the selected
`java.util.Date` to the existing domain construction path and let the current
`RouteSpecification` invariants apply.

### 3.9 — How will the feature be tested on the prepared historical baseline?

**Question:** Which automated and runtime tests are mandatory, given that the
historical JUnit/Arquillian suite is configured for a remote Payara 4
container, while the prepared production baseline runs on JDK 17/Open Liberty?

The starting POM deliberately leaves `skipTests=true`. The Open Liberty profile
builds and compiles all test sources but does not provide a Liberty Arquillian
adapter. Modernizing the entire integration-test runtime is outside this
feature's scope.

The feature still needs layered evidence:

1. Extend `BookingServiceTest` with the domain/application assertions that
   specify the deadline mutation.
2. Ensure all test sources compile as part of
   `./mvnw clean package -Popenliberty`.
3. Add focused JUnit tests for facade and backing-bean delegation where they
   can run without a container, using hand-written fakes rather than adding a
   mocking framework.
4. Perform mandatory end-to-end verification against the running Open Liberty
   application.
5. Preserve the existing Payara Arquillian test path; do not delete, disable,
   or rewrite it to manufacture a passing result.

**Spike needed:** Before Issue 1 implementation, run the starting commit's
standard Open Liberty package command and record whether tests are compiled but
skipped. Confirm the new `BookingServiceTest` method can be added without
expanding the runtime modernization scope.

**Recommendation:** Treat the JDK 17/Open Liberty build plus HTTP/UI acceptance
as the mandatory executable gate. Keep the historical Arquillian test as a
precise application-layer specification and run it only when its documented
Payara environment is available.

**Resolution:**

Extend the existing sequential Arquillian `BookingServiceTest` with
`testChangeDeadline()` after `testChangeDestination()`. The test changes the
deadline by one month, reloads the cargo through JPA, and asserts the complete
set of preserved and recalculated domain state described above. The prepared
Open Liberty build compiles this test but retains the historical default
`skipTests=true`; executing that Arquillian suite still requires its documented
remote Payara environment. Therefore the mandatory executable gates are the
JDK 17 Open Liberty package/start command, direct HTTP checks, and the complete
`DEF789` browser acceptance flow. No Arquillian-runtime modernization or new
mocking dependency is part of this feature.

---

## Phase 4 — Implementation (five serial issues)

Implement these issues in order. Each issue should be a separate commit. Do not
start an issue until the previous issue's gating criteria are satisfied.

### 4.1 — Issue 1: Add the application-layer deadline change operation

**What to build**

Add the core use case to the application layer. This issue must contain no JSF
or PrimeFaces changes.

**Files to modify**

- `src/main/java/org/eclipse/cargotracker/application/BookingService.java`
- `src/main/java/org/eclipse/cargotracker/application/internal/DefaultBookingService.java`
- `src/test/java/org/eclipse/cargotracker/application/BookingServiceTest.java`

**Required API**

```java
void changeDeadline(TrackingId trackingId, Date deadline);
```

**Required implementation behavior**

1. Load the cargo using `cargoRepository.find(trackingId)`.
2. Obtain the current destination from
   `cargo.getRouteSpecification().getDestination()`.
3. Construct a replacement `RouteSpecification` from:
   - `cargo.getOrigin()`;
   - the current destination;
   - the new deadline.
````

</details>


---

<sub>27s</sub>

### `rg`

**^(##|###|####) |Resolution:|\*\*Resolution:\*\***

"^(##|###|####) |Resolution:|\*\*Resolution:\*\*" (7-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260909-1942/plan.md)

<details>
<summary>36 matches</summary>

```
[grep content: 34 matches across 1 file(s) under /Users/edburns/workareas]

dd (34 match(es)):
  3061974- 01-cargotracker-shepherd-control/7-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260909-1942/plan.md:22:## Goal
  3061974- 01-cargotracker-shepherd-control/7-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260909-1942/plan.md:35:### User-visible acceptance behavior
  3061974- 01-cargotracker-shepherd-control/7-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260909-1942/plan.md:62:### Domain acceptance behavior
  3061974- 01-cargotracker-shepherd-control/7-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260909-1942/plan.md:77:### Hard scope constraints
  3061974- 01-cargotracker-shepherd-control/7-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260909-1942/plan.md:95:## Completed phases
  3061974- 01-cargotracker-shepherd-control/7-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260909-1942/plan.md:97:### Phase 1 ✅ — Establish a runnable feature-absent baseline
  3061974- 01-cargotracker-shepherd-control/7-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260909-1942/plan.md:109:### Phase 2 ✅ — Verify the before and after user experience
  3061974- 01-cargotracker-shepherd-control/7-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260909-1942/plan.md:123:## Phase 3 — Ignorance reduction: questions to answer before writing code
  3061974- 01-cargotracker-shepherd-control/7-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260909-1942/plan.md:129:### 3.1 — Which cargos expose the edit operation?
  3061974- 01-cargotracker-shepherd-control/7-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260909-1942/plan.md:155:**Resolution:**
  3061974- 01-cargotracker-shepherd-control/7-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260909-1942/plan.md:162:### 3.2 — What is the exact domain mutation?
  3061974- 01-cargotracker-shepherd-control/7-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260909-1942/plan.md:201:**Resolution:**
  3061974- 01-cargotracker-shepherd-control/7-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260909-1942/plan.md:211:### 3.3 — What should happen to an existing itinerary and delivery state?
  3061974- 01-cargotracker-shepherd-control/7-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260909-1942/plan.md:237:**Resolution:**
  3061974- 01-cargotracker-shepherd-control/7-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260909-1942/plan.md:245:### 3.4 — What type crosses the facade boundary?
  3061974- 01-cargotracker-shepherd-control/7-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260909-1942/plan.md:273:**Resolution:**
  3061974- 01-cargotracker-shepherd-control/7-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260909-1942/plan.md:281:### 3.5 — How is the DTO's formatted deadline converted for editing?
  3061974- 01-cargotracker-shepherd-control/7-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260909-1942/plan.md:311:**Resolution:**
  3061974- 01-cargotracker-shepherd-control/7-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260909-1942/plan.md:321:### 3.6 — Which JSF bean scopes and interaction pattern should be used?
  3061974- 01-cargotracker-shepherd-control/7-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260909-1942/plan.md:351:**Resolution:**
  3061974- 01-cargotracker-shepherd-control/7-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260909-1942/plan.md:360:### 3.7 — What is the dynamic-dialog contract?
  3061974- 01-cargotracker-shepherd-control/7-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260909-1942/plan.md:401:**Resolution:**
  3061974- 01-cargotracker-shepherd-control/7-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260909-1942/plan.md:412:### 3.8 — What date validation is required?
  3061974- 01-cargotracker-shepherd-control/7-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260909-1942/plan.md:430:**Resolution:**
  3061974- 01-cargotracker-shepherd-control/7-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260909-1942/plan.md:438:### 3.9 — How will the feature be tested on the prepared historical baseline?
  3061974- 01-cargotracker-shepherd-control/7-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260909-1942/plan.md:473:**Resolution:**
  3061974- 01-cargotracker-shepherd-control/7-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260909-1942/plan.md:488:## Phase 4 — Implementation (five serial issues)
  3061974- 01-cargotracker-shepherd-control/7-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260909-1942/plan.md:493:### 4.1 — Issue 1: Add the application-layer deadline change operation
  3061974- 01-cargotracker-shepherd-control/7-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260909-1942/plan.md:561:### 4.2 — Issue 2: Expose deadline changes through the booking facade
  3061974- 01-cargotracker-shepherd-control/7-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260909-1942/plan.md:616:### 4.3 — Issue 3: Implement the deadline editor backing model
  3061974- 01-cargotracker-shepherd-control/7-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260909-1942/plan.md:695:### 4.4 — Issue 4: Implement the PrimeFaces deadline dialog
  3061974- 01-cargotracker-shepherd-control/7-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260909-1942/plan.md:792:### 4.5 — Issue 5: Integrate deadline editing into the Administration dashboard
  3061974- 01-cargotracker-shepherd-control/7-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260909-1942/plan.md:876:## Phase 5 — Documentation and implementation handoff
  3061974- 01-cargotracker-shepherd-control/7-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260909-1942/plan.md:895:## Cross-cutting concerns
```

</details>


---

<sub>31s</sub>

### `view`

**view the file at /Users/edburns/workareas/dd-3061974-01-cargotracker-shepherd-control/7-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260909-1942/plan.md.**

/Users/edburns/workareas/dd-3061974-01-cargotracker-shepherd-control/7-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260909-1942/plan.md (lines 488-694)

<details>
<summary>147 lines</summary>

````
## Phase 4 — Implementation (five serial issues)

Implement these issues in order. Each issue should be a separate commit. Do not
start an issue until the previous issue's gating criteria are satisfied.

### 4.1 — Issue 1: Add the application-layer deadline change operation

**What to build**

Add the core use case to the application layer. This issue must contain no JSF
or PrimeFaces changes.

**Files to modify**

- `src/main/java/org/eclipse/cargotracker/application/BookingService.java`
- `src/main/java/org/eclipse/cargotracker/application/internal/DefaultBookingService.java`
- `src/test/java/org/eclipse/cargotracker/application/BookingServiceTest.java`

**Required API**

```java
void changeDeadline(TrackingId trackingId, Date deadline);
```

**Required implementation behavior**

1. Load the cargo using `cargoRepository.find(trackingId)`.
2. Obtain the current destination from
   `cargo.getRouteSpecification().getDestination()`.
3. Construct a replacement `RouteSpecification` from:
   - `cargo.getOrigin()`;
   - the current destination;
   - the new deadline.
4. Apply it using `cargo.specifyNewRoute(routeSpecification)`.
5. Persist using `cargoRepository.store(cargo)`.
6. Log the tracking ID and new deadline at `Level.INFO`, following the style of
   `changeDestination(...)`.

Do not:

- add a setter to `Cargo` or `RouteSpecification`;
- modify the origin or destination;
- clear or replace the itinerary directly;
- update persistence entities behind the aggregate's back.

**Tests to write first**

Append a sequential `testChangeDeadline()` case to `BookingServiceTest` after
`testChangeDestination()`. Build a new deadline one month after the test's
original `deadline`, invoke the service, reload the cargo with
`Cargo.findByTrackingId`, and assert:

- origin remains Chicago;
- destination remains Helsinki;
- stored deadline is the same calendar day as the requested new deadline;
- assigned itinerary remains unchanged;
- transport status remains `NOT_RECEIVED`;
- last known location remains `Location.UNKNOWN`;
- current voyage remains `Voyage.NONE`;
- cargo is not marked misdirected;
- estimated time of arrival is `Delivery.ETA_UNKOWN`;
- next expected activity is `Delivery.NO_ACTIVITY`;
- cargo is not unloaded at destination;
- routing status reflects the domain model's recalculation and remains
  `MISROUTED` for the established test sequence.

**Gating criteria**

- The test source compiles.
- `./mvnw clean package -Popenliberty` succeeds on JDK 17.
- No web, facade, REST, Liberty, or persistence configuration files change in
  this issue.

### 4.2 — Issue 2: Expose deadline changes through the booking facade

**What to build**

Expose the use case to presentation clients without leaking domain identifier
types into the web layer.

**Files to modify**

- `src/main/java/org/eclipse/cargotracker/interfaces/booking/facade/BookingServiceFacade.java`
- `src/main/java/org/eclipse/cargotracker/interfaces/booking/facade/internal/DefaultBookingServiceFacade.java`

**Optional focused test file**

- `src/test/java/org/eclipse/cargotracker/interfaces/booking/facade/internal/DefaultBookingServiceFacadeTest.java`

**Required API**

```java
void changeDeadline(String trackingId, Date arrivalDeadline);
```

**Required implementation**

```java
bookingService.changeDeadline(
        new TrackingId(trackingId),
        arrivalDeadline);
```

The facade must not:

- load and mutate `Cargo` itself;
- call `CargoRepository.store(...)`;
- parse a formatted date;
- introduce JSF or PrimeFaces types.

**Tests**

Where a container-free test is added, use a hand-written `BookingService` fake
or spy and prove that:

- the same `Date` object/value reaches the application service;
- the tracking-ID string is converted to an equivalent `TrackingId`;
- the facade delegates exactly once;
- no repository work is duplicated in the facade.

Do not add Mockito or another dependency solely for this test.

**Gating criteria**

- Existing facade consumers still compile.
- `./mvnw clean package -Popenliberty` succeeds on JDK 17.
- The application-layer test added in Issue 1 remains unchanged and compiling.

### 4.3 — Issue 3: Implement the deadline editor backing model

**What to build**

Add the view-scoped backing bean that loads a cargo's current deadline and
submits a replacement deadline through the booking facade. Do not add the
dialog launcher or XHTML in this issue.

**File to create**

- `src/main/java/org/eclipse/cargotracker/interfaces/booking/web/ChangeArrivalDeadlineDate.java`

**Required bean shape**

```java
@Named
@ViewScoped
public class ChangeArrivalDeadlineDate implements Serializable {
    private static final long serialVersionUID = 1L;

    private String trackingId;
    private CargoRoute cargo;
    private Date arrivalDeadlineDate;

    @Inject
    private BookingServiceFacade bookingServiceFacade;
}
```

Required properties and methods:

- `getTrackingId()` / `setTrackingId(String)`
- `getCargo()`
- `getArrivalDeadlineDate()` / `setArrivalDeadlineDate(Date)`
- `load()`
- `changeArrivalDeadline()`

**Load behavior**

1. Call `bookingServiceFacade.loadCargoForRouting(trackingId)`.
2. Store the returned `CargoRoute`.
3. Parse `cargo.getArrivalDeadlineDate()` using `MM/dd/yyyy`.
4. Store the resulting `Date` in `arrivalDeadlineDate`.
5. Do not query a repository or domain object directly.
6. Do not ignore a parsing failure or merely print its stack trace. Surface a
   clear application/view error consistent with existing JSF behavior.

**Submit behavior**

1. Refuse a null date through JSF validation or explicit bean validation.
2. Call
   `bookingServiceFacade.changeDeadline(trackingId, arrivalDeadlineDate)`.
3. Close the dynamic dialog with:

   ```java
   PrimeFaces.current().dialog().closeDynamic("DONE");
   ```

4. Do not close the dialog if the facade call fails.

**Tests to write**

Add a container-free JUnit test if practical, using a hand-written fake facade,
that proves:

- `load()` requests the correct tracking ID;
- `load()` converts an `MM/dd/yyyy` DTO date into the editable `Date`;
- `changeArrivalDeadline()` delegates the selected date and tracking ID;
- a malformed DTO deadline is surfaced rather than converted to null;
- a null selected date is rejected.

Do not add a mocking framework solely for these tests.

**Gating criteria**

- The bean is serializable and uses the established CDI/JSF annotations.
- The bean references only facade DTOs, not domain model classes.
- `./mvnw clean package -Popenliberty` succeeds on JDK 17.
````

</details>


---

<sub>31s</sub>

### `view`

**view the file at /Users/edburns/workareas/dd-3061974-01-cargotracker-shepherd-control/7-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260909-1942/plan.md.**

/Users/edburns/workareas/dd-3061974-01-cargotracker-shepherd-control/7-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260909-1942/plan.md (lines 695-875)

<details>
<summary>133 lines</summary>

````
### 4.4 — Issue 4: Implement the PrimeFaces deadline dialog

**What to build**

Add the session-scoped dialog launcher and the dynamic dialog view. The dialog
must work when addressed directly with a `trackingId` query parameter, but it
is not yet linked from the dashboard in this issue.

**Files to create**

- `src/main/java/org/eclipse/cargotracker/interfaces/booking/web/ChangeArrivalDeadlineDateDialog.java`
- `src/main/webapp/admin/dialogs/changeArrivalDeadlineDate.xhtml`

**Launcher requirements**

Use:

```java
@ManagedBean(name = "changeArrivalDeadlineDateDialog")
@SessionScoped
```

Implement:

- `showDialog(String trackingId)`
- `handleReturn(SelectEvent event)`
- `cancel()`

`showDialog(...)` must:

- set the options documented in Question 3.7;
- pass `trackingId` as a dynamic-dialog request parameter;
- open `/admin/dialogs/changeArrivalDeadlineDate.xhtml`.

`cancel()` must close the dialog without invoking the facade.

**XHTML requirements**

The page title must be:

```xhtml
<title>Change Deadline</title>
```

Place metadata directly beneath the root `<html>` element and before
`<h:head>`:

```xhtml
<f:metadata>
    <f:viewParam name="trackingId"
                 value="#{changeArrivalDeadlineDate.trackingId}"/>
    <f:viewAction action="#{changeArrivalDeadlineDate.load}"/>
</f:metadata>
```

The form must display:

- `Origin:` and `changeArrivalDeadlineDate.cargo.originName`;
- `Destination:` and
  `changeArrivalDeadlineDate.cargo.finalDestinationName`;
- `Deadline:` and a `p:datePicker` bound to
  `changeArrivalDeadlineDate.arrivalDeadlineDate`;
- **Cancel**, invoking
  `changeArrivalDeadlineDateDialog.cancel()`;
- **Update**, invoking
  `changeArrivalDeadlineDate.changeArrivalDeadline()`.

The date picker must require a value. The Update action must reload or refresh
the calling Administration view after a successful dialog close, following the
existing destination-dialog behavior.

**Runtime tests**

With the application running, request:

```text
http://localhost:8080/cargo-tracker/admin/dialogs/changeArrivalDeadlineDate.xhtml?trackingId=DEF789
```

Verify:

- HTTP 200;
- title is **Change Deadline**;
- origin and destination render;
- the existing deadline is selected;
- no `TagException`, `Parent UIComponent`, `FacesException`, or server error is
  present;
- Cancel does not change the persisted deadline;
- Update changes the deadline.

**Gating criteria**

- `./mvnw clean package -Popenliberty liberty:run` succeeds on JDK 17.
- Direct dialog loading and both actions work.
- Destination editing continues to work.
- Stop Liberty cleanly before completing the issue.

### 4.5 — Issue 5: Integrate deadline editing into the Administration dashboard

**What to build**

Replace the plain deadline text in the Not Routed Cargo table with the
PrimeFaces command-link affordance that opens the completed dialog and refreshes
the table after return.

**File to modify**

- `src/main/webapp/admin/tables/listNotRouted.xhtml`

**Required UI shape**

Within the existing Deadline column, add a `p:commandLink` that:

- calls
  `changeArrivalDeadlineDateDialog.showDialog(cargoNotRouted.trackingId)`;
- retains the displayed
  `cargoNotRouted.arrivalDeadlineDate`;
- adds the existing Font Awesome edit icon style;
- uses a stable component ID such as `arrivalDeadlineToUpdate`;
- listens for `dialogReturn`;
- invokes
  `changeArrivalDeadlineDateDialog.handleReturn`;
- updates `tableNotRouted`;
- provides the tooltip:
  `Click to change cargo arrival deadline date.`

Follow the adjacent Destination column's established structure and styling. Do
not alter tracking-ID routing or destination editing.

**End-to-end acceptance test**

1. Start from a clean build on JDK 17:

   ```bash
   ./mvnw clean package -Popenliberty liberty:run
   ```

2. Confirm the home page returns HTTP 200.
3. Open Administration and locate `DEF789`.
4. Record the original deadline.
5. Confirm the deadline now has an edit icon and tooltip.
6. Open the deadline dialog.
7. Confirm origin and destination identify the same cargo.
8. Choose a visibly different date.
9. Press **Update**.
10. Confirm the dialog closes and the Not Routed Cargo table refreshes.
11. Confirm the table shows the selected date.
12. Reload the browser and confirm the selected date remains.
13. Reopen the dialog and confirm the editor initializes to the changed date.
14. Press **Cancel** and confirm no additional change occurs.
15. Verify the Destination edit dialog still opens.
16. Verify selecting `DEF789` for routing still loads without an error page.

**Log acceptance**

The final run must contain none of:

- `<f:metadata> Parent UIComponent`;
- `TagException`;
- `VerifyError`;
- `FacesException`;
- `CWWKZ0002E` or `CWWKZ0003E`;
- recurring batch authorization failures;
- new FFDC files attributable to this feature.

Transient JMS activation-order warnings are acceptable only if all message
endpoints subsequently activate, as established by the prepared baseline.

**Final regression and scope checks**

- `./mvnw clean package -Popenliberty` succeeds.
- The existing test sources and the new deadline test compile.
- No Java EE namespace migration occurred.
- No Open Liberty, Derby, Jackson, JSF metadata, batch authorization, or REST
  compatibility fix from the starting commit was reverted.
- The feature affects only the intended application, facade, web, dialog,
  table, and test surfaces.
- Stop Liberty cleanly.

---
````

</details>


---

<sub>31s</sub>

### `view`

**view the file at /Users/edburns/workareas/dd-3061974-01-cargotracker-shepherd-control/7-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260909-1942/plan.md.**

/Users/edburns/workareas/dd-3061974-01-cargotracker-shepherd-control/7-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260909-1942/plan.md (lines 876-980)

<details>
<summary>28 lines</summary>

````
## Phase 5 — Documentation and implementation handoff

- Update `README.md` only if user-facing Administration capabilities are
  enumerated there; add one concise sentence that administrators can change an
  unrouted cargo's arrival deadline.
- Record the exact JDK 17 run command in the final issue or pull-request
  description:

  ```bash
  ./mvnw clean package -Popenliberty liberty:run
  ```

- Include `DEF789` and the before/after deadline values in the acceptance
  evidence.
- State explicitly that data is in-memory and resets when the application is
  rebuilt/restarted.

---

## Cross-cutting concerns

| Concern | Required handling |
|---------|--------------------|
| Domain-driven design | Mutate the aggregate through `Cargo.specifyNewRoute(...)`; do not bypass it with persistence-level field updates. |
| Layering | Web bean → booking facade → booking service → cargo repository. |
| Date handling | Use `java.util.Date` at service/facade boundaries and `MM/dd/yyyy` for the date-only editor representation. |
| Time zones | Acceptance compares the calendar date displayed by the application; do not introduce a new timezone policy in this feature. |
| Error handling | Do not silently swallow parse, lookup, validation, or persistence failures. A failed update must not look successful. |
| JSF compatibility | Keep `<f:metadata>` at view-root scope for MyFaces. |
| Bean lifecycle | Editor is CDI `@ViewScoped`; dynamic-dialog launcher mirrors the existing session-scoped JSF managed bean. |
| Accessibility | Preserve visible labels; the date editor must have an associated label and validation feedback. |
| Backward compatibility | Existing destination editing, routing, tracking, REST, messaging, batch, and startup behavior must remain intact. |
| Test discipline | Add tests before production code where practical; every issue must preserve all prior gates. |
| Experiment integrity | Implement from this specification starting at `9b9f311b2a3a2854bdac947593950d9edb6bca7d`; do not cherry-pick or inspect feature-bearing commits. |
````

</details>


---

<sub>34s</sub>

### `view`

**view the file at /Users/edburns/.copilot/plugins/shepherd-task/scripts/validate-stage20-drafts.sh.**

/Users/edburns/.copilot/plugins/shepherd-task/scripts/validate-stage20-drafts.sh (lines 1-260)

<details>
<summary>66 lines</summary>

```
#!/usr/bin/env bash
# shepherd-task-version: 1.0.2

set -euo pipefail

[[ $# -eq 3 ]] || {
    echo "Usage: $0 <body-directory> <expected-count> <off|campaign>" >&2
    exit 1
}

body_directory="$1"
expected_count="$2"
lesson_propagation="$3"

[[ -d "$body_directory" ]] || {
    echo "Stage-20 body directory does not exist: $body_directory" >&2
    exit 1
}
[[ "$expected_count" =~ ^[1-9][0-9]*$ ]] || {
    echo "Expected count must be a positive integer." >&2
    exit 1
}
[[ "$lesson_propagation" == "off" || "$lesson_propagation" == "campaign" ]] || {
    echo "Lesson propagation must be off or campaign." >&2
    exit 1
}

body_files=()
while IFS= read -r -d '' body_file; do
    body_files+=("$body_file")
done < <(
    find "$body_directory" -maxdepth 1 -type f -name '*-body.md' \
        ! -name '*-observed-body.md' -print0
)
[[ ${#body_files[@]} -eq $expected_count ]] || {
    echo "Expected $expected_count persisted stage-20 body files; found ${#body_files[@]}." >&2
    exit 1
}

required_headings=(
    '## Campaign context and required reading'
    '## Branch and execution order'
    '## Implement'
    '## Completion gates'
    '## Out of scope'
)

for body_file in "${body_files[@]}"; do
    [[ -s "$body_file" && "$(awk 'END { print NR }' "$body_file")" -gt 1 ]] || {
        echo "Persisted issue body must contain physical Markdown lines: $body_file" >&2
        exit 1
    }
    first_nonblank="$(awk 'NF { print; exit }' "$body_file")"
    [[ "$first_nonblank" =~ ^##[[:space:]]+[^[:space:]] ]] || {
        echo "Persisted issue body must begin with a level-two heading: $body_file" >&2
        exit 1
    }
    for heading in "${required_headings[@]}"; do
        grep -Fqx -- "$heading" "$body_file" || {
            echo "Persisted issue body is missing the physical heading '$heading': $body_file" >&2
            exit 1
        }
    done
    if [[ "$lesson_propagation" == "campaign" ]]; then
        grep -Fqx -- '## Campaign lessons (REQUIRED)' "$body_file" || {
            echo "Treatment issue body is missing its campaign-lessons heading: $body_file" >&2
            exit 1
        }
    elif grep -Fqx -- '## Campaign lessons (REQUIRED)' "$body_file"; then
        echo "Control issue body unexpectedly contains a campaign-lessons heading: $body_file" >&2
        exit 1
    fi
done
```

</details>


---

<sub>37s</sub>

### Copilot

All nine blocking questions have substantive resolution blocks: UI scope; aggregate mutation; itinerary state; facade types; DTO parsing; bean scopes; dialog contract; validation; and test strategy. I’m persisting five complete issue specifications now, with those decisions and research findings mapped to each task, before running the mandatory draft validator.

---

<sub>1m 29s</sub>

### `apply_patch`

<details>
<summary>Arguments</summary>

````json
"*** Begin Patch\n*** Add File: 7-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260909-1942/issue-bodies/01-4-1-body.md\n+## Campaign context and required reading\n+\n+On the `experiment/shepherd-control` branch, the directory `7-arrival-deadline-control-remove-before-merge` contains the plan (`add-change-arrival-deadline-feature-ignorance-reduction-plan.md`) and supporting resources (diagrams, decision records). Spike subdirectories are research artifacts — read the plan's Resolution sections for findings, not the spike source code.\n+\n+Read the entire plan before working. Then carefully re-read these exact sections:\n+\n+- `## Goal`, especially `### Domain acceptance behavior` and `### Hard scope constraints`\n+- `### 3.2 — What is the exact domain mutation?`\n+- `### 3.3 — What should happen to an existing itinerary and delivery state?`\n+- `### 3.9 — How will the feature be tested on the prepared historical baseline?`\n+- `### 4.1 — Issue 1: Add the application-layer deadline change operation`\n+- `## Cross-cutting concerns`\n+\n+The resolved design is concrete: add `BookingService.changeDeadline(TrackingId, Date)`, load the cargo, construct a replacement `RouteSpecification` from its existing origin, existing destination, and supplied deadline, apply it through `Cargo.specifyNewRoute(...)`, and store it through `CargoRepository.store(...)`. Preserve the assigned itinerary. Let the aggregate recalculate delivery and routing state; in the established sequential test, routing remains `MISROUTED`.\n+\n+Research established that the prepared Open Liberty build compiles the historical Arquillian test sources but retains `skipTests=true`; execution still requires the documented remote Payara environment. Do not modernize that runtime or add a mocking dependency.\n+\n+## Branch and execution order\n+\n+Use `experiment/shepherd-control` from remote `origin` as the PR base. This is serial task 1 of 5. Tasks are assigned, completed, and merged in plan order. Do not start until assigned; later tasks must not start until this task is merged and its gates pass.\n+\n+Begin from the campaign baseline and implement from the plan. Do not cherry-pick, copy, or inspect feature-bearing commits.\n+\n+## Implement\n+\n+Modify only:\n+\n+- `src/main/java/org/eclipse/cargotracker/application/BookingService.java`\n+- `src/main/java/org/eclipse/cargotracker/application/internal/DefaultBookingService.java`\n+- `src/test/java/org/eclipse/cargotracker/application/BookingServiceTest.java`\n+\n+Add:\n+\n+```java\n+void changeDeadline(TrackingId trackingId, Date deadline);\n+```\n+\n+Implement the operation by:\n+\n+1. Loading with `cargoRepository.find(trackingId)`.\n+2. Reading the current destination from `cargo.getRouteSpecification().getDestination()`.\n+3. Creating a new `RouteSpecification` with `cargo.getOrigin()`, that destination, and `deadline`.\n+4. Calling `cargo.specifyNewRoute(routeSpecification)`.\n+5. Calling `cargoRepository.store(cargo)`.\n+6. Logging the tracking ID and new deadline at `Level.INFO` in the style of `changeDestination(...)`.\n+\n+Write the test first. Append sequential `testChangeDeadline()` after `testChangeDestination()` in `BookingServiceTest`. Advance the original test deadline by one month, invoke the service, reload through `Cargo.findByTrackingId`, and assert:\n+\n+- origin is still Chicago and destination is still Helsinki;\n+- the stored deadline is the same calendar day requested;\n+- the assigned itinerary is unchanged;\n+- transport status is `NOT_RECEIVED`;\n+- last known location is `Location.UNKNOWN`;\n+- current voyage is `Voyage.NONE`;\n+- cargo is not misdirected;\n+- ETA is `Delivery.ETA_UNKOWN`;\n+- next expected activity is `Delivery.NO_ACTIVITY`;\n+- cargo is not unloaded at destination;\n+- routing status remains `MISROUTED`.\n+\n+Keep Java 7 source compatibility, Java EE 7 `javax.*`, and JDK 17/Open Liberty runtime compatibility.\n+\n+## Completion gates\n+\n+- The new test source compiles in the normal build.\n+- `./mvnw clean package -Popenliberty` succeeds on JDK 17.\n+- Review the diff and confirm no facade, web, JSF, PrimeFaces, REST, Liberty, Derby, or persistence-configuration file changed.\n+- Confirm the test discriminates against direct deadline mutation, lost itinerary, changed endpoints, omitted aggregate recalculation, and omitted repository storage.\n+- Preserve all existing tests and baseline compatibility fixes.\n+\n+## Out of scope\n+\n+- JSF, PrimeFaces, facade, REST, dialog, table, runtime, or database changes.\n+- A mutable deadline setter on `Cargo` or `RouteSpecification`.\n+- Clearing, replacing, or rerouting the itinerary.\n+- Direct persistence-field updates or a new chronological deadline policy.\n+- Arquillian/Payara modernization, new mocking libraries, or namespace migration.\n*** Add File: 7-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260909-1942/issue-bodies/02-4-2-body.md\n+## Campaign context and required reading\n+\n+On the `experiment/shepherd-control` branch, the directory `7-arrival-deadline-control-remove-before-merge` contains the plan (`add-change-arrival-deadline-feature-ignorance-reduction-plan.md`) and supporting resources (diagrams, decision records). Spike subdirectories are research artifacts — read the plan's Resolution sections for findings, not the spike source code.\n+\n+Read the entire plan before working. Then carefully re-read these exact sections:\n+\n+- `## Goal`, especially `### Domain acceptance behavior` and `### Hard scope constraints`\n+- `### 3.2 — What is the exact domain mutation?`\n+- `### 3.4 — What type crosses the facade boundary?`\n+- `### 3.9 — How will the feature be tested on the prepared historical baseline?`\n+- `### 4.2 — Issue 2: Expose deadline changes through the booking facade`\n+- `## Cross-cutting concerns`\n+\n+The resolved boundary is `void changeDeadline(String trackingId, Date arrivalDeadline)` on `BookingServiceFacade`. `DefaultBookingServiceFacade` converts only the identifier with `new TrackingId(trackingId)` and passes the same `Date` to the application service. No domain object, formatted date string, command DTO, JSF type, or PrimeFaces type crosses this facade API.\n+\n+Research established that this historical baseline's mandatory automated gate is the JDK 17 Open Liberty package build; the existing Arquillian runtime remains tied to remote Payara. A focused container-free test may use a hand-written fake, but must not add Mockito or another dependency.\n+\n+## Branch and execution order\n+\n+Use `experiment/shepherd-control` from remote `origin` as the PR base. This is serial task 2 of 5. Tasks are assigned, completed, and merged in plan order. Do not start until assigned and until task 1 is merged with all gates passing.\n+\n+Build on the application operation delivered by task 1. Do not duplicate or bypass it.\n+\n+## Implement\n+\n+Modify:\n+\n+- `src/main/java/org/eclipse/cargotracker/interfaces/booking/facade/BookingServiceFacade.java`\n+- `src/main/java/org/eclipse/cargotracker/interfaces/booking/facade/internal/DefaultBookingServiceFacade.java`\n+\n+Optionally add:\n+\n+- `src/test/java/org/eclipse/cargotracker/interfaces/booking/facade/internal/DefaultBookingServiceFacadeTest.java`\n+\n+Add the facade API:\n+\n+```java\n+void changeDeadline(String trackingId, Date arrivalDeadline);\n+```\n+\n+Delegate exactly as follows:\n+\n+```java\n+bookingService.changeDeadline(\n+        new TrackingId(trackingId),\n+        arrivalDeadline);\n+```\n+\n+If a focused test is practical with the repository's current test conventions, use a hand-written `BookingService` fake or spy and prove that the string becomes an equivalent `TrackingId`, the same date object/value reaches the application service, and delegation occurs exactly once. Ensure the facade performs no repository work.\n+\n+## Completion gates\n+\n+- Existing facade consumers compile without changes.\n+- `./mvnw clean package -Popenliberty` succeeds on JDK 17.\n+- Task 1's application-layer test remains unchanged and compiles.\n+- A focused test, if added, fails if the facade parses/formats the date, delegates more than once, changes the date value, or performs repository work.\n+- Review the diff to confirm no JSF, PrimeFaces, XHTML, domain mutation, repository, runtime, or dependency changes.\n+\n+## Out of scope\n+\n+- Loading or mutating `Cargo` in the facade.\n+- Calling `CargoRepository.store(...)` from the facade.\n+- Parsing formatted dates or adding a command DTO.\n+- JSF/PrimeFaces types or behavior.\n+- New mocking/test dependencies, Payara modernization, namespace migration, or unrelated facade refactoring.\n*** Add File: 7-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260909-1942/issue-bodies/03-4-3-body.md\n+## Campaign context and required reading\n+\n+On the `experiment/shepherd-control` branch, the directory `7-arrival-deadline-control-remove-before-merge` contains the plan (`add-change-arrival-deadline-feature-ignorance-reduction-plan.md`) and supporting resources (diagrams, decision records). Spike subdirectories are research artifacts — read the plan's Resolution sections for findings, not the spike source code.\n+\n+Read the entire plan before working. Then carefully re-read these exact sections:\n+\n+- `## Goal`, especially `### User-visible acceptance behavior` and `### Hard scope constraints`\n+- `### 3.4 — What type crosses the facade boundary?`\n+- `### 3.5 — How is the DTO's formatted deadline converted for editing?`\n+- `### 3.6 — Which JSF bean scopes and interaction pattern should be used?`\n+- `### 3.8 — What date validation is required?`\n+- `### 3.9 — How will the feature be tested on the prepared historical baseline?`\n+- `### 4.3 — Issue 3: Implement the deadline editor backing model`\n+- `## Cross-cutting concerns`\n+\n+Resolved decisions: use a serializable CDI `@Named @ViewScoped` editor; load only through `BookingServiceFacade`; keep domain types out of the bean; parse the DTO's date-only value with a per-load `new SimpleDateFormat(\"MM/dd/yyyy\")`; surface malformed input explicitly; require a non-null replacement date but impose no future/minimum/itinerary chronology rule; submit through `BookingServiceFacade.changeDeadline(String, Date)`.\n+\n+Research established that the DTO exposes the displayed date in `MM/dd/yyyy` form and that a localized per-load formatter preserves the DTO contract without adding shared mutable date-format state. Container-free tests should use hand-written fakes if practical; do not add a mocking library.\n+\n+## Branch and execution order\n+\n+Use `experiment/shepherd-control` from remote `origin` as the PR base. This is serial task 3 of 5. Tasks are assigned, completed, and merged in plan order. Do not start until assigned and until tasks 1 and 2 are merged with all gates passing.\n+\n+Use the facade operation from task 2. Do not create the launcher or XHTML yet.\n+\n+## Implement\n+\n+Create:\n+\n+- `src/main/java/org/eclipse/cargotracker/interfaces/booking/web/ChangeArrivalDeadlineDate.java`\n+\n+Use this shape:\n+\n+```java\n+@Named\n+@ViewScoped\n+public class ChangeArrivalDeadlineDate implements Serializable {\n+    private static final long serialVersionUID = 1L;\n+\n+    private String trackingId;\n+    private CargoRoute cargo;\n+    private Date arrivalDeadlineDate;\n+\n+    @Inject\n+    private BookingServiceFacade bookingServiceFacade;\n+}\n+```\n+\n+Provide:\n+\n+- `getTrackingId()` and `setTrackingId(String)`\n+- `getCargo()`\n+- `getArrivalDeadlineDate()` and `setArrivalDeadlineDate(Date)`\n+- `load()`\n+- `changeArrivalDeadline()`\n+\n+`load()` must call `bookingServiceFacade.loadCargoForRouting(trackingId)`, retain the `CargoRoute`, parse its date-only arrival deadline with a new `SimpleDateFormat(\"MM/dd/yyyy\")`, and store the resulting `Date`. Follow repository-standard JSF error handling for parse failure; do not return null, print a stack trace, or silently continue.\n+\n+`changeArrivalDeadline()` must reject a null selection, call `bookingServiceFacade.changeDeadline(trackingId, arrivalDeadlineDate)`, and only after success call `PrimeFaces.current().dialog().closeDynamic(\"DONE\")`. A failed facade call must remain visibly failed and leave the dialog open.\n+\n+Add a container-free JUnit test when practical, using a hand-written fake facade, to cover correct tracking-ID loading, date parsing, exact submit delegation, malformed DTO date failure, and null selected-date rejection.\n+\n+## Completion gates\n+\n+- The bean is serializable and uses the established CDI `@Named` plus JSF `@ViewScoped` annotations.\n+- The bean imports facade DTOs, not cargo domain model or repository classes.\n+- `./mvnw clean package -Popenliberty` succeeds on JDK 17.\n+- Tests discriminate malformed input from a valid date and prove failed/null submission cannot produce a success-shaped dialog close.\n+- Prior application and facade gates remain intact.\n+- Review the diff to confirm no launcher class, XHTML, dashboard table, runtime, persistence, or dependency change.\n+\n+## Out of scope\n+\n+- Dialog launcher, dialog XHTML, dashboard integration, navigation, or inline cell editing.\n+- Reloading domain objects or repositories directly.\n+- Shared mutable `SimpleDateFormat`, a DTO redesign, or formatted-string service parameters.\n+- New chronological business rules, mocking dependencies, namespace/runtime migration, or unrelated UI refactoring.\n*** Add File: 7-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260909-1942/issue-bodies/04-4-4-body.md\n+## Campaign context and required reading\n+\n+On the `experiment/shepherd-control` branch, the directory `7-arrival-deadline-control-remove-before-merge` contains the plan (`add-change-arrival-deadline-feature-ignorance-reduction-plan.md`) and supporting resources (diagrams, decision records). Spike subdirectories are research artifacts — read the plan's Resolution sections for findings, not the spike source code.\n+\n+Read the entire plan before working. Then carefully re-read these exact sections:\n+\n+- `## Goal`, especially `### User-visible acceptance behavior` and `### Hard scope constraints`\n+- `### Phase 1 ✅ — Establish a runnable feature-absent baseline`\n+- `### 3.5 — How is the DTO's formatted deadline converted for editing?`\n+- `### 3.6 — Which JSF bean scopes and interaction pattern should be used?`\n+- `### 3.7 — What is the dynamic-dialog contract?`\n+- `### 3.8 — What date validation is required?`\n+- `### 3.9 — How will the feature be tested on the prepared historical baseline?`\n+- `### 4.4 — Issue 4: Implement the PrimeFaces deadline dialog`\n+- `## Cross-cutting concerns`\n+\n+Resolved contract: mirror Change Destination with a serializable session-scoped JSF managed launcher and PrimeFaces dynamic dialog. Open `/admin/dialogs/changeArrivalDeadlineDate.xhtml` with one `trackingId` parameter; options are modal `true`, draggable `true`, resizable `false`, content width `410`, and content height `280`. Success closes with `\"DONE\"` and cancel with `\"\"`. Require a date but add no chronological rule.\n+\n+Research on the prepared MyFaces/Open Liberty baseline established that `<f:metadata>` must be directly under the root `<html>`, before `<h:head>` and `<h:body>`; nesting it in the body causes view-component failures. Implement the established interaction from production conventions, not from spike code.\n+\n+## Branch and execution order\n+\n+Use `experiment/shepherd-control` from remote `origin` as the PR base. This is serial task 4 of 5. Tasks are assigned, completed, and merged in plan order. Do not start until assigned and until tasks 1 through 3 are merged with all gates passing.\n+\n+The editor backing bean already exists from task 3. This task makes the dialog directly usable but does not add a dashboard link.\n+\n+## Implement\n+\n+Create:\n+\n+- `src/main/java/org/eclipse/cargotracker/interfaces/booking/web/ChangeArrivalDeadlineDateDialog.java`\n+- `src/main/webapp/admin/dialogs/changeArrivalDeadlineDate.xhtml`\n+\n+Implement a serializable launcher using:\n+\n+```java\n+@ManagedBean(name = \"changeArrivalDeadlineDateDialog\")\n+@SessionScoped\n+```\n+\n+Provide `showDialog(String trackingId)`, `handleReturn(SelectEvent event)`, and `cancel()`. `showDialog` must pass `trackingId` as `Map<String, List<String>>`, use the exact options above, and open the exact dialog path. `cancel()` closes with an empty string and must not invoke the facade. Preserve the destination-dialog return lifecycle.\n+\n+The XHTML title must be `Change Deadline`. Directly beneath root `<html>` and before `<h:head>`, add:\n+\n+```xhtml\n+<f:metadata>\n+    <f:viewParam name=\"trackingId\"\n+                 value=\"#{changeArrivalDeadlineDate.trackingId}\"/>\n+    <f:viewAction action=\"#{changeArrivalDeadlineDate.load}\"/>\n+</f:metadata>\n+```\n+\n+Display visible, associated labels and values for Origin (`cargo.originName`), Destination (`cargo.finalDestinationName`), and Deadline. Bind a required `p:datePicker` to `changeArrivalDeadlineDate.arrivalDeadlineDate` and render validation feedback. Add Cancel calling `changeArrivalDeadlineDateDialog.cancel()` and Update calling `changeArrivalDeadlineDate.changeArrivalDeadline()`. Refresh/reload the calling Administration view after successful return following the established destination-dialog behavior.\n+\n+## Completion gates\n+\n+- `./mvnw clean package -Popenliberty liberty:run` starts successfully on JDK 17.\n+- Direct GET of `/cargo-tracker/admin/dialogs/changeArrivalDeadlineDate.xhtml?trackingId=DEF789` returns HTTP 200.\n+- The title, origin, destination, and current deadline render; required-date validation is visible.\n+- Logs contain no `TagException`, `Parent UIComponent`, `FacesException`, or server error attributable to the dialog.\n+- Cancel leaves the persisted deadline unchanged; Update changes it and closes only after success.\n+- Destination editing still works.\n+- Stop Liberty cleanly before completion.\n+\n+## Out of scope\n+\n+- Adding or changing the Not Routed table link; that is task 5.\n+- Full-page navigation, inline editing, domain/repository access, or a new date policy.\n+- Moving metadata into the body, changing baseline MyFaces compatibility, or altering destination editing.\n+- Runtime modernization, dependency changes, namespace migration, or unrelated UI redesign.\n*** Add File: 7-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260909-1942/issue-bodies/05-4-5-body.md\n+## Campaign context and required reading\n+\n+On the `experiment/shepherd-control` branch, the directory `7-arrival-deadline-control-remove-before-merge` contains the plan (`add-change-arrival-deadline-feature-ignorance-reduction-plan.md`) and supporting resources (diagrams, decision records). Spike subdirectories are research artifacts — read the plan's Resolution sections for findings, not the spike source code.\n+\n+Read the entire plan before working. Then carefully re-read these exact sections:\n+\n+- `## Goal`, including `### User-visible acceptance behavior`, `### Domain acceptance behavior`, and `### Hard scope constraints`\n+- `### Phase 2 ✅ — Verify the before and after user experience`\n+- `### 3.1 — Which cargos expose the edit operation?`\n+- `### 3.6 — Which JSF bean scopes and interaction pattern should be used?`\n+- `### 3.7 — What is the dynamic-dialog contract?`\n+- `### 3.8 — What date validation is required?`\n+- `### 3.9 — How will the feature be tested on the prepared historical baseline?`\n+- `### 4.5 — Issue 5: Integrate deadline editing into the Administration dashboard`\n+- `## Phase 5 — Documentation and implementation handoff`\n+- `## Cross-cutting concerns`\n+\n+Resolved UI scope: expose deadline editing only in `src/main/webapp/admin/tables/listNotRouted.xhtml`; service and facade remain generally callable. Mirror the adjacent Destination command-link interaction. The dialog returns `\"DONE\"` after success, the caller handles `dialogReturn`, and `tableNotRouted` refreshes. Require a date without adding minimum/future/itinerary chronology rules.\n+\n+Research established that `DEF789` is the stable sample cargo, the baseline deadline is plain text, and the adjacent Destination column is the production interaction pattern. The mandatory executable evidence is the JDK 17 Open Liberty build/start, direct HTTP checks, and complete browser flow; the historical Arquillian suite remains tied to remote Payara and must not be rewritten.\n+\n+## Branch and execution order\n+\n+Use `experiment/shepherd-control` from remote `origin` as the PR base. This is serial task 5 of 5. Tasks are assigned, completed, and merged in plan order. Do not start until assigned and until tasks 1 through 4 are merged with all gates passing.\n+\n+Integrate the completed application, facade, editor, and dialog without changing their contracts.\n+\n+## Implement\n+\n+Modify:\n+\n+- `src/main/webapp/admin/tables/listNotRouted.xhtml`\n+\n+In the existing Deadline column, replace plain text with a `p:commandLink` that:\n+\n+- calls `changeArrivalDeadlineDateDialog.showDialog(cargoNotRouted.trackingId)`;\n+- keeps displaying `cargoNotRouted.arrivalDeadlineDate`;\n+- uses the existing Font Awesome edit-icon style;\n+- has a stable ID such as `arrivalDeadlineToUpdate`;\n+- registers a `dialogReturn` Ajax listener;\n+- invokes `changeArrivalDeadlineDateDialog.handleReturn`;\n+- updates `tableNotRouted`;\n+- provides the exact tooltip `Click to change cargo arrival deadline date.`\n+\n+Follow the adjacent Destination column's structure and styling. Do not alter destination editing, tracking-ID routing, or any other cargo table.\n+\n+Update `README.md` only if it already enumerates user-facing Administration capabilities; if so, add one concise sentence about changing an unrouted cargo's arrival deadline.\n+\n+Capture acceptance evidence using `DEF789`, including before and after deadline values, the exact run command `./mvnw clean package -Popenliberty liberty:run`, and the fact that the in-memory value resets when the application is rebuilt or restarted.\n+\n+## Completion gates\n+\n+- Start from `./mvnw clean package -Popenliberty liberty:run` on JDK 17 and confirm the home page returns HTTP 200.\n+- In Administration, verify `DEF789` has the edit icon and exact tooltip.\n+- Open the dialog; verify the same cargo's origin, destination, and current deadline.\n+- Select a visibly different date, update, and verify close plus immediate table refresh.\n+- Reload and verify the new date remains; reopen and verify the editor initializes to it.\n+- Cancel and verify no further change.\n+- Verify Destination editing still opens and selecting `DEF789` for routing still loads.\n+- Verify logs contain none of: `<f:metadata> Parent UIComponent`, `TagException`, `VerifyError`, `FacesException`, `CWWKZ0002E`, `CWWKZ0003E`, recurring batch authorization failures, or new feature-attributable FFDC files. Transient JMS activation-order warnings are acceptable only if all endpoints subsequently activate.\n+- Run `./mvnw clean package -Popenliberty`; confirm all test sources compile and stop Liberty cleanly.\n+- Review the complete feature diff for preserved Java EE 7 `javax.*`, Java 7 source compatibility, and all baseline Liberty/Derby/REST/JSF/batch fixes.\n+\n+## Out of scope\n+\n+- Deadline affordances in routed, misrouted, claimed, details, or other cargo views.\n+- Changes to destination editing, tracking, routing, messaging, batch, REST, persistence, Derby, or Liberty configuration.\n+- New date business rules, framework/runtime migration, Arquillian modernization, or new dependencies.\n+- Copying feature-bearing commits or redesigning the Administration dashboard.\n*** End Patch\n"
````

</details>

```
Added 5 file(s): /Users/edburns/workareas/dd-3061974-01-cargotracker-shepherd-control/7-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260909-1942/issue-bodies/01-4-1-body.md, /Users/edburns/workareas/dd-3061974-01-cargotracker-shepherd-control/7-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260909-1942/issue-bodies/02-4-2-body.md, /Users/edburns/workareas/dd-3061974-01-cargotracker-shepherd-control/7-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260909-1942/issue-bodies/03-4-3-body.md, /Users/edburns/workareas/dd-3061974-01-cargotracker-shepherd-control/7-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260909-1942/issue-bodies/04-4-4-body.md, /Users/edburns/workareas/dd-3061974-01-cargotracker-shepherd-control/7-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260909-1942/issue-bodies/05-4-5-body.md
```


---

<sub>1m 39s</sub>

### `bash`

**Validate persisted issue drafts**

$ set -euo pipefail
LOG='/Users/edburns/workareas/dd-3061974-01-cargotracker-shepherd-control/7-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260909-1942'
'/Users/edburns/.copilot/plugins/shepherd-task/scripts/validate-stage20-drafts.sh' "$LOG/issue-bodies" 5 off
python3 - <<'PY'
from pathlib import Path
p=Path('/Users/edburns/workareas/dd-3061974-01-cargotracker-shepherd-control/7-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260909-1942/plan.md').read_text()
for h in ['## Phase 3 — Ignorance reduction: questions to answer before writing code','## Phase 4 — Implementation (five serial issues)']:
    assert p.count(h)==1, (h,p.count(h))
impl=p.split('## Phase 4 — Implementation (five serial issues)',1)[1].split('\n## ',1)[0]
heads=[line for line in impl.splitlines() if line.startswith('### ')]
assert len(heads)==5, heads
q=p.split('## Phase 3 — Ignorance reduction: questions to answer before writing code',1)[1].split('\n## Phase 4',1)[0]
qs=[x for x in q.split('\n### ')[1:]]
assert len(qs)==9
for item in qs:
    heading=item.splitlines()[0]
    assert '**Resolution:**' in item, heading
    block=item.split('**Resolution:**',1)[1].strip()
    assert block, heading
print('Validated 5 implementation headings and 9 non-empty resolution blocks.')
PY
for f in "$LOG"/issue-bodies/*-body.md; do printf '%s: %s lines\n' "$(basename "$f")" "$(wc -l < "$f" | tr -d ' ')"; done

<details>
<summary>7 lines</summary>

```
Validated 5 implementation headings and 9 non-empty resolution blocks.
01-4-1-body.md: 77 lines
02-4-2-body.md: 65 lines
03-4-3-body.md: 77 lines
04-4-4-body.md: 70 lines
05-4-5-body.md: 69 lines
<shellId: 1 completed with exit code 0>
```

</details>


---

<sub>1m 48s</sub>

### Copilot

The mandatory validator passed all five persisted multiline drafts. I’m initializing the authoritative ledger/result files and running the one-shot create → exact-body verify → link sequence, stopping and reconciling without rollback on any failure.

---

<sub>2m 7s</sub>

### `apply_patch`

<details>
<summary>Arguments</summary>

```json
"*** Begin Patch\n*** Add File: 7-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260909-1942/run-stage20.sh\n+#!/usr/bin/env bash\n+set -euo pipefail\n+\n+REPO='edburns/dd-3061974-01-cargotracker'\n+PARENT=7\n+LOG='/Users/edburns/workareas/dd-3061974-01-cargotracker-shepherd-control/7-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260909-1942'\n+VERIFIER='/Users/edburns/.copilot/plugins/shepherd-task/scripts/verify-github-issue-body.sh'\n+LEDGER=\"$LOG/creation-ledger.json\"\n+RESULT=\"$LOG/stage-20-result.json\"\n+BASELINE=\"$LOG/pre-creation-children.json\"\n+\n+atomic_write() {\n+    local destination=\"$1\"\n+    local temporary\n+    temporary=\"$(mktemp \"$LOG/.stage20.XXXXXX\")\"\n+    cat > \"$temporary\"\n+    mv \"$temporary\" \"$destination\"\n+}\n+\n+reconcile_and_fail() {\n+    local operation=\"$1\"\n+    local error=\"$2\"\n+    local children_output normalized ledger_tmp\n+\n+    if children_output=\"$(gh api \"repos/$REPO/issues/$PARENT/sub_issues\" --paginate --slurp 2>&1)\"; then\n+        normalized=\"$(printf '%s' \"$children_output\" | jq 'if length == 0 then [] elif all(.[]; type == \"array\") then add else . end')\"\n+        ledger_tmp=\"$(jq --argjson children \"$normalized\" \\\n+            'map(.linked = ([ $children[] | select(.id == .id) ] | length > 0))' \"$LEDGER\")\"\n+        # Re-evaluate with explicit ledger/server ID comparison; jq's nested scope otherwise shadows the ledger item.\n+        ledger_tmp=\"$(jq --argjson children \"$normalized\" \\\n+            'map(. as $entry | .linked = any($children[]; .id == $entry.id))' \"$LEDGER\")\"\n+        printf '%s\\n' \"$ledger_tmp\" | atomic_write \"$LEDGER\"\n+    else\n+        error=\"$error; reconciliation query also failed: $children_output\"\n+    fi\n+\n+    jq -n --arg error \"$operation: $error\" \\\n+        '{schemaVersion:1,status:\"failed\",ledgerFile:\"creation-ledger.json\",operationError:$error}' |\n+        atomic_write \"$RESULT\"\n+\n+    printf 'FAILED_OPERATION=%s\\nERROR=%s\\n' \"$operation\" \"$error\" >&2\n+    jq -r '.[] | \"ISSUE=\\(.number)\\tTITLE=\\(.title)\\tURL=\\(.url)\\tBODY=\\(.bodyFile)\\tBODY_VERIFIED=\\(.body_verified)\\tLINKED=\\(.linked)\"' \"$LEDGER\" >&2\n+    jq -r --arg repo \"$REPO\" '.[] | \"gh issue delete \\(.number) --repo \\\"\\($repo)\\\" --yes\"' \"$LEDGER\" >&2\n+    exit 1\n+}\n+\n+printf '[]\\n' | atomic_write \"$LEDGER\"\n+jq -n '{schemaVersion:1,status:\"in_progress\",ledgerFile:\"creation-ledger.json\",operationError:null}' |\n+    atomic_write \"$RESULT\"\n+\n+subsections=(\n+    '4.1 — Issue 1: Add the application-layer deadline change operation'\n+    '4.2 — Issue 2: Expose deadline changes through the booking facade'\n+    '4.3 — Issue 3: Implement the deadline editor backing model'\n+    '4.4 — Issue 4: Implement the PrimeFaces deadline dialog'\n+    '4.5 — Issue 5: Integrate deadline editing into the Administration dashboard'\n+)\n+titles=(\n+    '4.1 — Add the application-layer deadline change operation'\n+    '4.2 — Expose deadline changes through the booking facade'\n+    '4.3 — Implement the deadline editor backing model'\n+    '4.4 — Implement the PrimeFaces deadline dialog'\n+    '4.5 — Integrate deadline editing into the Administration dashboard'\n+)\n+body_files=(\n+    \"$LOG/issue-bodies/01-4-1-body.md\"\n+    \"$LOG/issue-bodies/02-4-2-body.md\"\n+    \"$LOG/issue-bodies/03-4-3-body.md\"\n+    \"$LOG/issue-bodies/04-4-4-body.md\"\n+    \"$LOG/issue-bodies/05-4-5-body.md\"\n+)\n+\n+for index in \"${!titles[@]}\"; do\n+    title=\"${titles[$index]}\"\n+    body=\"${body_files[$index]}\"\n+    subsection=\"${subsections[$index]}\"\n+    relative_body=\"${body#\"$LOG/\"}\"\n+\n+    if ! issue_json=\"$(gh api \"repos/$REPO/issues\" -X POST \\\n+        -f title=\"$title\" -F \"body=@$body\" \\\n+        --jq '{id,number,node_id,html_url,title}' 2>&1)\"; then\n+        reconcile_and_fail \"create issue for $subsection\" \"$issue_json\"\n+    fi\n+\n+    if ! printf '%s' \"$issue_json\" | jq -e '\n+        (.id | type == \"number\") and (.number | type == \"number\") and\n+        (.html_url | type == \"string\") and (.title | type == \"string\")\n+    ' >/dev/null; then\n+        reconcile_and_fail \"parse created issue for $subsection\" \"$issue_json\"\n+    fi\n+\n+    ledger_entry=\"$(printf '%s' \"$issue_json\" | jq \\\n+        --arg subsection \"$subsection\" --arg body \"$relative_body\" \\\n+        '{implementationSubsection:$subsection,bodyFile:$body,id:.id,number:.number,title:.title,url:.html_url,body_verified:false,linked:false}')\"\n+    jq --argjson entry \"$ledger_entry\" '. + [$entry]' \"$LEDGER\" | atomic_write \"$LEDGER\"\n+\n+    issue_number=\"$(printf '%s' \"$issue_json\" | jq -r '.number')\"\n+    issue_id=\"$(printf '%s' \"$issue_json\" | jq -r '.id')\"\n+    diagnostic=\"$LOG/issue-$issue_number-body-verification-failure.json\"\n+    if ! verified_json=\"$(\"$VERIFIER\" \"$REPO\" \"$issue_number\" \"$body\" 6 5 \"$diagnostic\" 2>&1)\"; then\n+        reconcile_and_fail \"verify body for issue $issue_number\" \"$verified_json\"\n+    fi\n+    jq --argjson number \"$issue_number\" \\\n+        'map(if .number == $number then .body_verified = true else . end)' \"$LEDGER\" |\n+        atomic_write \"$LEDGER\"\n+\n+    linked=false\n+    link_error=''\n+    for attempt in 1 2 3; do\n+        if link_output=\"$(printf '{\"sub_issue_id\": %s}' \"$issue_id\" |\n+            gh api \"repos/$REPO/issues/$PARENT/sub_issues\" -X POST --input - 2>&1)\"; then\n+            linked=true\n+            break\n+        fi\n+        link_error=\"attempt $attempt: $link_output\"\n+        sleep 2\n+    done\n+    if [[ \"$linked\" != true ]]; then\n+        reconcile_and_fail \"link issue $issue_number to parent $PARENT\" \"$link_error\"\n+    fi\n+    jq --argjson number \"$issue_number\" \\\n+        'map(if .number == $number then .linked = true else . end)' \"$LEDGER\" |\n+        atomic_write \"$LEDGER\"\n+done\n+\n+if ! final_output=\"$(gh api \"repos/$REPO/issues/$PARENT/sub_issues\" --paginate --slurp 2>&1)\"; then\n+    reconcile_and_fail \"query final parent children\" \"$final_output\"\n+fi\n+final_children=\"$(printf '%s' \"$final_output\" | jq 'if length == 0 then [] elif all(.[]; type == \"array\") then add else . end')\"\n+baseline_count=\"$(jq 'length' \"$BASELINE\")\"\n+ledger_count=\"$(jq 'length' \"$LEDGER\")\"\n+final_count=\"$(printf '%s' \"$final_children\" | jq 'length')\"\n+if [[ \"$final_count\" -ne $((baseline_count + ledger_count)) ]]; then\n+    reconcile_and_fail \"verify final child count\" \"expected $((baseline_count + ledger_count)), observed $final_count\"\n+fi\n+\n+if ! jq -e --argjson final \"$final_children\" --slurpfile baseline \"$BASELINE\" '\n+    ($baseline[0] | map(.id)) as $old |\n+    map(.id) as $expected |\n+    ([ $final[] | select((.id as $id | $old | index($id)) == null) | .id ]) == $expected\n+' \"$LEDGER\" >/dev/null; then\n+    reconcile_and_fail \"verify final child order\" \"newly linked children do not match ledger order\"\n+fi\n+\n+while IFS=$'\\t' read -r number body_relative; do\n+    body=\"$LOG/$body_relative\"\n+    diagnostic=\"$LOG/issue-$number-body-verification-failure.json\"\n+    if ! final_issue=\"$(\"$VERIFIER\" \"$REPO\" \"$number\" \"$body\" 6 5 \"$diagnostic\" 2>&1)\"; then\n+        reconcile_and_fail \"final body verification for issue $number\" \"$final_issue\"\n+    fi\n+    if ! printf '%s' \"$final_issue\" | jq -e \\\n+        '.state == \"open\" and (.assignees | type == \"array\") and (.assignees | length == 0)' >/dev/null; then\n+        reconcile_and_fail \"verify open/unassigned postcondition for issue $number\" \"$final_issue\"\n+    fi\n+done < <(jq -r '.[] | [.number,.bodyFile] | @tsv' \"$LEDGER\")\n+\n+jq -n '{schemaVersion:1,status:\"complete\",ledgerFile:\"creation-ledger.json\",operationError:null}' |\n+    atomic_write \"$RESULT\"\n+\n+jq -n --slurpfile ledger \"$LEDGER\" --argjson children \"$final_children\" \\\n+    '{status:\"complete\",ledger:$ledger[0],finalChildren:$children}'\n*** End Patch\n"
```

</details>

```
Added 1 file(s): /Users/edburns/workareas/dd-3061974-01-cargotracker-shepherd-control/7-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260909-1942/run-stage20.sh
```


---

<sub>2m 24s</sub>

### `bash`

**Create verify and link issues**

$ bash '/Users/edburns/workareas/dd-3061974-01-cargotracker-shepherd-control/7-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260909-1942/run-stage20.sh'

<details>
<summary>19 lines</summary>

```
Output too large to read at once (75.6 KB). Saved to: /var/folders/vc/_9vlsvsd7wg72zf3bf0z_1k00000gn/T/1789008286049-copilot-tool-output-44987-beee681f-7fc8-48e3-8f0f-0aaef3c312f2.txt
Consider using tools like rg (for searching), head/tail (for viewing start/end), view with view_range (for specific sections), or jq (for JSON) to examine portions of the output.

Preview (first 500 chars):
{
  "status": "complete",
  "ledger": [
    {
      "implementationSubsection": "4.1 — Issue 1: Add the application-layer deadline change operation",
      "bodyFile": "issue-bodies/01-4-1-body.md",
      "id": 5407100924,
      "number": 8,
      "title": "4.1 — Add the application-layer deadline change operation",
      "url": "https://github.com/edburns/dd-3061974-01-cargotracker/issues/8",
      "body_verified": true,
      "linked": true
    },
    {
      "implementationSubsection": "4.2 —
<shellId: 2 completed with exit code 0>
```

</details>


---

<sub>2m 27s</sub>

### Copilot

All five issues were created, their server bodies matched the persisted drafts, and each was linked in plan order. I’m performing the final concise handoff check against the authoritative ledger and completed stage result.

---

<sub>2m 32s</sub>

### `bash`

**Verify final ledger and child order**

$ set -euo pipefail
LOG='/Users/edburns/workareas/dd-3061974-01-cargotracker-shepherd-control/7-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260909-1942'
printf '%s\n' '--- RESULT ---'
jq . "$LOG/stage-20-result.json"
printf '%s\n' '--- LEDGER ---'
jq '[.[] | {implementationSubsection,number,title,url,body_verified,linked}]' "$LOG/creation-ledger.json"
printf '%s\n' '--- SERVER ORDER ---'
gh api 'repos/edburns/dd-3061974-01-cargotracker/issues/7/sub_issues' --paginate --slurp | jq 'if length == 0 then [] elif all(.[]; type == "array") then add else . end | map({number,title,state,assignees:(.assignees|length),type:(.type.name // null)})'
printf '%s\n' '--- WORKTREE ---'
git --no-pager status --short

<details>
<summary>93 lines</summary>

```
--- RESULT ---
{
  "schemaVersion": 1,
  "status": "complete",
  "ledgerFile": "creation-ledger.json",
  "operationError": null
}
--- LEDGER ---
[
  {
    "implementationSubsection": "4.1 — Issue 1: Add the application-layer deadline change operation",
    "number": 8,
    "title": "4.1 — Add the application-layer deadline change operation",
    "url": "https://github.com/edburns/dd-3061974-01-cargotracker/issues/8",
    "body_verified": true,
    "linked": true
  },
  {
    "implementationSubsection": "4.2 — Issue 2: Expose deadline changes through the booking facade",
    "number": 9,
    "title": "4.2 — Expose deadline changes through the booking facade",
    "url": "https://github.com/edburns/dd-3061974-01-cargotracker/issues/9",
    "body_verified": true,
    "linked": true
  },
  {
    "implementationSubsection": "4.3 — Issue 3: Implement the deadline editor backing model",
    "number": 10,
    "title": "4.3 — Implement the deadline editor backing model",
    "url": "https://github.com/edburns/dd-3061974-01-cargotracker/issues/10",
    "body_verified": true,
    "linked": true
  },
  {
    "implementationSubsection": "4.4 — Issue 4: Implement the PrimeFaces deadline dialog",
    "number": 11,
    "title": "4.4 — Implement the PrimeFaces deadline dialog",
    "url": "https://github.com/edburns/dd-3061974-01-cargotracker/issues/11",
    "body_verified": true,
    "linked": true
  },
  {
    "implementationSubsection": "4.5 — Issue 5: Integrate deadline editing into the Administration dashboard",
    "number": 12,
    "title": "4.5 — Integrate deadline editing into the Administration dashboard",
    "url": "https://github.com/edburns/dd-3061974-01-cargotracker/issues/12",
    "body_verified": true,
    "linked": true
  }
]
--- SERVER ORDER ---
[
  {
    "number": 8,
    "title": "4.1 — Add the application-layer deadline change operation",
    "state": "open",
    "assignees": 0,
    "type": null
  },
  {
    "number": 9,
    "title": "4.2 — Expose deadline changes through the booking facade",
    "state": "open",
    "assignees": 0,
    "type": null
  },
  {
    "number": 10,
    "title": "4.3 — Implement the deadline editor backing model",
    "state": "open",
    "assignees": 0,
    "type": null
  },
  {
    "number": 11,
    "title": "4.4 — Implement the PrimeFaces deadline dialog",
    "state": "open",
    "assignees": 0,
    "type": null
  },
  {
    "number": 12,
    "title": "4.5 — Integrate deadline editing into the Administration dashboard",
    "state": "open",
    "assignees": 0,
    "type": null
  }
]
--- WORKTREE ---
?? 7-arrival-deadline-control-remove-before-merge/.stage20-after.44747
?? 7-arrival-deadline-control-remove-before-merge/.stage20-before.44747
?? 7-arrival-deadline-control-remove-before-merge/prompts/
<shellId: 3 completed with exit code 0>
```

</details>


---

<sub>2m 36s</sub>

### `rg`

**shepherd-task-25-given-list**

"shepherd-task-25-given-list" (~/.copilot/skills/shepherd-task-20-create-issues-from-plan, 7-arrival-deadline-control-remove-before-merge)

```
/Users/edburns/.copilot/skills/shepherd-task-20-create-issues-from-plan/SKILL.md:306:2. Comma-separated child issue numbers for `shepherd-task-25-given-list`.
```


---

<sub>2m 40s</sub>

### Copilot

Created and linked five open, unassigned child issues under #7 in plan order. Bodies were validated and verified exactly against GitHub. The repository does not support organization issue types, so issues were created **without an issue type**.

| Subsection | Issue | Title |
|---|---:|---|
| 4.1 | [#8](https://github.com/edburns/dd-3061974-01-cargotracker/issues/8) | Add the application-layer deadline change operation |
| 4.2 | [#9](https://github.com/edburns/dd-3061974-01-cargotracker/issues/9) | Expose deadline changes through the booking facade |
| 4.3 | [#10](https://github.com/edburns/dd-3061974-01-cargotracker/issues/10) | Implement the deadline editor backing model |
| 4.4 | [#11](https://github.com/edburns/dd-3061974-01-cargotracker/issues/11) | Implement the PrimeFaces deadline dialog |
| 4.5 | [#12](https://github.com/edburns/dd-3061974-01-cargotracker/issues/12) | Integrate deadline editing into the Administration dashboard |

**Ordered given-list:** `8,9,10,11,12`

**Suggested stage 25 invocation:**
```text
/shepherd-task-25-given-list
REPO=edburns/dd-3061974-01-cargotracker
BASE_BRANCH=experiment/shepherd-control
PARENT_ISSUE=7
ISSUE_NUMBERS=8,9,10,11,12
PLAN_DIRECTORY=7-arrival-deadline-control-remove-before-merge
CAMPAIGN_ID=6c5f2b96-d399-4374-855f-976835ea0247
```

Authoritative artifacts are in the supplied log directory; `stage-20-result.json` has status `complete`.

---

<sub>Generated by [GitHub Copilot CLI](https://github.com/features/copilot/cli)</sub>
