package defpackage;

import android.text.Editable;
import android.text.TextWatcher;
import app.zophop.ui.fragments.UserDetailsFragment;

/* renamed from: gx0  reason: default package */
/* compiled from: UserDetailsFragment */
public class gx0 implements TextWatcher {
    public final /* synthetic */ String f;

    public gx0(UserDetailsFragment userDetailsFragment, String str) {
        this.f = str;
    }

    public void afterTextChanged(Editable editable) {
        ed1 ed1 = new ed1("edit text changed", 86400000);
        hj1.K0(ed1, "type", this.f, ed1);
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
