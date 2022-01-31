package defpackage;

import android.view.View;
import app.zophop.ui.views.PassDurationFormInput;

/* renamed from: kb1  reason: default package */
/* compiled from: PassDurationFormInput */
public class kb1 implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PassDurationFormInput f2042a;

    public kb1(PassDurationFormInput passDurationFormInput) {
        this.f2042a = passDurationFormInput;
    }

    public void onFocusChange(View view, boolean z) {
        PassDurationFormInput passDurationFormInput = this.f2042a;
        passDurationFormInput.i = passDurationFormInput.f.getText().toString();
        if (!z) {
            this.f2042a.a();
            return;
        }
        PassDurationFormInput passDurationFormInput2 = this.f2042a;
        vn.Z0(passDurationFormInput2.f, passDurationFormInput2.getContext());
    }
}
