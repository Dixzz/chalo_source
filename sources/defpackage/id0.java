package defpackage;

import android.view.inputmethod.InputMethodManager;
import app.zophop.R;
import app.zophop.ui.activities.CardActivity;

/* renamed from: id0  reason: default package */
/* compiled from: CardActivity */
public class id0 implements Runnable {
    public final /* synthetic */ InputMethodManager f;
    public final /* synthetic */ CardActivity g;

    public id0(CardActivity cardActivity, InputMethodManager inputMethodManager) {
        this.g = cardActivity;
        this.f = inputMethodManager;
    }

    public void run() {
        this.g.findViewById(R.id.cvv_saved).requestFocus();
        this.f.showSoftInput(this.g.findViewById(R.id.cvv_saved), 0);
    }
}
