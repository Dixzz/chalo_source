package defpackage;

import android.view.View;
import app.zophop.ui.views.ZophopFormInput;

/* renamed from: zb1  reason: default package */
/* compiled from: ZophopFormInput */
public class zb1 implements View.OnClickListener {
    public final /* synthetic */ ZophopFormInput f;

    public zb1(ZophopFormInput zophopFormInput) {
        this.f = zophopFormInput;
    }

    public void onClick(View view) {
        ZophopFormInput zophopFormInput = this.f;
        if (!zophopFormInput.o && zophopFormInput.k) {
            zophopFormInput.h.setVisibility(0);
            this.f.f.setVisibility(0);
            this.f.f.requestFocus();
            this.f.f.getText();
            this.f.requestLayout();
            this.f.invalidate();
        }
    }
}
