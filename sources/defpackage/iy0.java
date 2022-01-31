package defpackage;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import app.zophop.ui.fragments.cardRecharge.CardDetailsFragment;
import app.zophop.ui.views.ZophopFormInput;

/* renamed from: iy0  reason: default package */
/* compiled from: TextView.kt */
public final class iy0 implements TextWatcher {
    public final /* synthetic */ CardDetailsFragment f;
    public final /* synthetic */ ZophopFormInput g;

    public iy0(CardDetailsFragment cardDetailsFragment, ZophopFormInput zophopFormInput) {
        this.f = cardDetailsFragment;
        this.g = zophopFormInput;
    }

    public void afterTextChanged(Editable editable) {
        CardDetailsFragment cardDetailsFragment = this.f;
        int i = CardDetailsFragment.l;
        T t = cardDetailsFragment.f;
        n86.c(t);
        TextView textView = ((hx) t).g;
        n86.d(textView, "viewBinding.errorText");
        textView.setVisibility(8);
        h91 j = this.f.j();
        String text = this.g.getText();
        if (text == null) {
            text = new String();
        }
        n86.e(text, "lCardNoString");
        hd3.Y1(h.Z(j), j.e, null, new i91(j, text, null), 2, null);
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
