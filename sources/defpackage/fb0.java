package defpackage;

import android.view.inputmethod.InputMethodManager;
import app.zophop.ui.activities.AccountLoginActivity;

/* renamed from: fb0  reason: default package */
/* compiled from: AccountLoginActivity */
public class fb0 implements Runnable {
    public final /* synthetic */ AccountLoginActivity f;

    public fb0(AccountLoginActivity accountLoginActivity) {
        this.f = accountLoginActivity;
    }

    public void run() {
        this.f._mobileTextInput.requestFocus();
        this.f.getApplicationContext();
        ((InputMethodManager) this.f.getSystemService("input_method")).showSoftInput(this.f._mobileTextInput, 1);
        this.f.getWindow().setSoftInputMode(4);
    }
}
