package defpackage;

import android.text.Editable;
import android.text.TextWatcher;
import app.zophop.ui.views.ZophopFormInput;
import defpackage.su;

/* renamed from: tu  reason: default package */
/* compiled from: TextView.kt */
public final class tu implements TextWatcher {
    public final /* synthetic */ su f;
    public final /* synthetic */ ZophopFormInput g;

    public tu(su suVar, ZophopFormInput zophopFormInput) {
        this.f = suVar;
        this.g = zophopFormInput;
    }

    public void afterTextChanged(Editable editable) {
        su.a aVar = this.f.g;
        if (aVar != null) {
            String text = this.g.getText();
            n86.d(text, "text");
            aVar.a(text);
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
