package defpackage;

import android.view.View;

/* renamed from: gy0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class gy0 implements View.OnClickListener {
    public final /* synthetic */ vy0 f;

    public /* synthetic */ gy0(vy0 vy0) {
        this.f = vy0;
    }

    public final void onClick(View view) {
        vy0 vy0 = this.f;
        n86.e(vy0, "this$0");
        ui1.m0(new ed1("ocr tutorial bottomsheet next clicked", Long.MIN_VALUE));
        vy0.h.invoke();
        xt.f3961a.l().put("keyWasOnlineCardRechargeTutorialShown", "true");
        vy0.dismiss();
    }
}
