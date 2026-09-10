package org.eclipse.cargotracker.interfaces.booking.web;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ChangeArrivalDeadlineDateDialogTest {

    @Test
    public void showDialogUsesTheDeadlineDialogContract() {
        RecordingDialog dialog = new RecordingDialog();

        dialog.showDialog("ABC123");

        assertEquals("/admin/dialogs/changeArrivalDeadlineDate.xhtml",
                dialog.outcome);
        assertEquals(true, dialog.options.get("modal"));
        assertEquals(true, dialog.options.get("draggable"));
        assertEquals(false, dialog.options.get("resizable"));
        assertEquals(410, dialog.options.get("contentWidth"));
        assertEquals(280, dialog.options.get("contentHeight"));
        assertEquals(1, dialog.params.size());
        assertEquals(1, dialog.params.get("trackingId").size());
        assertEquals("ABC123", dialog.params.get("trackingId").get(0));
    }

    @Test
    public void cancelClosesWithAnEmptyResult() {
        RecordingDialog dialog = new RecordingDialog();

        dialog.cancel();

        assertEquals("", dialog.result);
    }

    private static final class RecordingDialog
            extends ChangeArrivalDeadlineDateDialog {

        private static final long serialVersionUID = 1L;
        private String outcome;
        private Map<String, Object> options;
        private Map<String, List<String>> params;
        private Object result;

        @Override
        protected void openDialog(String outcome, Map<String, Object> options,
                                  Map<String, List<String>> params) {
            this.outcome = outcome;
            this.options = options;
            this.params = params;
        }

        @Override
        protected void closeDialog(Object result) {
            this.result = result;
        }
    }
}
