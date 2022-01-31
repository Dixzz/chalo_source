package defpackage;

import android.text.Editable;
import android.text.TextWatcher;
import app.zophop.ui.fragments.superpassPurchase.SuperPassBasicUserDetailsFragment;
import app.zophop.ui.views.ZophopFormInput;

/* renamed from: b61  reason: default package */
/* compiled from: TextView.kt */
public final class b61 implements TextWatcher {
    public final /* synthetic */ SuperPassBasicUserDetailsFragment f;
    public final /* synthetic */ ZophopFormInput g;

    public b61(SuperPassBasicUserDetailsFragment superPassBasicUserDetailsFragment, ZophopFormInput zophopFormInput) {
        this.f = superPassBasicUserDetailsFragment;
        this.g = zophopFormInput;
    }

    public void afterTextChanged(Editable editable) {
        da1 j = this.f.j();
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
