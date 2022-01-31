package defpackage;

import android.text.Editable;
import android.text.TextWatcher;
import app.zophop.ui.fragments.BasicUserDetailsFragment;
import app.zophop.ui.views.ZophopFormInput;

/* renamed from: ht0  reason: default package */
/* compiled from: TextView.kt */
public final class ht0 implements TextWatcher {
    public final /* synthetic */ BasicUserDetailsFragment f;
    public final /* synthetic */ ZophopFormInput g;

    public ht0(BasicUserDetailsFragment basicUserDetailsFragment, ZophopFormInput zophopFormInput) {
        this.f = basicUserDetailsFragment;
        this.g = zophopFormInput;
    }

    public void afterTextChanged(Editable editable) {
        a81 j = this.f.j();
        String text = this.g.getText();
        j.e = text;
        j.c.b("keyFullName", text);
        j.d();
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
