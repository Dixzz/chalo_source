package defpackage;

import android.app.Dialog;
import android.os.Bundle;

/* renamed from: o0  reason: default package */
/* compiled from: AppCompatDialogFragment */
public class o0 extends ue {
    @Override // defpackage.ue
    public Dialog onCreateDialog(Bundle bundle) {
        return new n0(getContext(), getTheme());
    }

    @Override // defpackage.ue
    public void setupDialog(Dialog dialog, int i) {
        if (dialog instanceof n0) {
            n0 n0Var = (n0) dialog;
            if (!(i == 1 || i == 2)) {
                if (i == 3) {
                    dialog.getWindow().addFlags(24);
                } else {
                    return;
                }
            }
            n0Var.c(1);
            return;
        }
        super.setupDialog(dialog, i);
    }
}
