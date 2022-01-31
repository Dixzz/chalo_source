package defpackage;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import app.zophop.ui.fragments.cardRecharge.CardRechargeAmountFragment;
import app.zophop.ui.views.ZophopFormInput;

/* renamed from: py0  reason: default package */
/* compiled from: TextView.kt */
public final class py0 implements TextWatcher {
    public final /* synthetic */ ZophopFormInput f;
    public final /* synthetic */ CardRechargeAmountFragment g;

    public py0(ZophopFormInput zophopFormInput, CardRechargeAmountFragment cardRechargeAmountFragment) {
        this.f = zophopFormInput;
        this.g = cardRechargeAmountFragment;
    }

    public void afterTextChanged(Editable editable) {
        String text = this.f.getText();
        if (text == null || text.length() == 0) {
            this.f.setText("₹");
        }
        CardRechargeAmountFragment cardRechargeAmountFragment = this.g;
        int i = CardRechargeAmountFragment.j;
        T t = cardRechargeAmountFragment.f;
        n86.c(t);
        TextView textView = ((ix) t).e;
        n86.d(textView, "viewBinding.errorText");
        textView.setVisibility(8);
        m91 j = this.g.j();
        String text2 = this.f.getText();
        if (text2 == null) {
            text2 = new String();
        }
        j.e(text2);
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
