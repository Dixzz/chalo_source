package defpackage;

import android.app.DialogFragment;

/* renamed from: sn0  reason: default package */
/* compiled from: ZophopOrderedDialogFragment */
public class sn0 extends DialogFragment {
    public String f;

    public sn0() {
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (this.f != null) {
            xt.f3961a.o().a(this.f, true);
        }
    }

    public sn0(String str) {
        this.f = str;
    }
}
