package defpackage;

import android.view.View;
import app.zophop.ui.views.ZophopFormInput;

/* renamed from: yb1  reason: default package */
/* compiled from: ZophopFormInput */
public class yb1 implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ZophopFormInput f4027a;

    public yb1(ZophopFormInput zophopFormInput) {
        this.f4027a = zophopFormInput;
    }

    public void onFocusChange(View view, boolean z) {
        ZophopFormInput zophopFormInput = this.f4027a;
        zophopFormInput.i = zophopFormInput.f.getText().toString();
        if (!z) {
            this.f4027a.b();
            return;
        }
        ZophopFormInput zophopFormInput2 = this.f4027a;
        vn.Z0(zophopFormInput2.f, zophopFormInput2.getContext());
    }
}
