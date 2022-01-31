package defpackage;

import android.text.Editable;
import android.text.TextWatcher;
import app.zophop.ui.fragments.cardRecharge.CardDetailsFragment;
import app.zophop.ui.views.ZophopFormInput;

/* renamed from: jy0  reason: default package */
/* compiled from: TextView.kt */
public final class jy0 implements TextWatcher {
    public final /* synthetic */ CardDetailsFragment f;
    public final /* synthetic */ ZophopFormInput g;

    public jy0(CardDetailsFragment cardDetailsFragment, ZophopFormInput zophopFormInput) {
        this.f = cardDetailsFragment;
        this.g = zophopFormInput;
    }

    public void afterTextChanged(Editable editable) {
        h91 j = this.f.j();
        String text = this.g.getText();
        if (text == null) {
            text = new String();
        }
        n86.e(text, "lCardNoString");
        hd3.Y1(h.Z(j), j.e, null, new j91(j, text, null), 2, null);
        n86.j("setupCardNumberInputViews: ", this.g.getText());
        n86.j("setupCardNumberInputViews: size = ", Integer.valueOf(this.g.getText().length()));
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
