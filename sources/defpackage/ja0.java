package defpackage;

import android.view.View;
import app.zophop.ui.activities.SuperPassBookingSuccessActivity;

/* renamed from: ja0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class ja0 implements View.OnClickListener {
    public final /* synthetic */ SuperPassBookingSuccessActivity f;

    public /* synthetic */ ja0(SuperPassBookingSuccessActivity superPassBookingSuccessActivity) {
        this.f = superPassBookingSuccessActivity;
    }

    public final void onClick(View view) {
        SuperPassBookingSuccessActivity superPassBookingSuccessActivity = this.f;
        int i = SuperPassBookingSuccessActivity.n;
        n86.e(superPassBookingSuccessActivity, "this$0");
        ed1 ed1 = new ed1("booking success view booking details clicked", Long.MIN_VALUE);
        superPassBookingSuccessActivity.s0(ed1);
        ui1.m0(ed1);
        superPassBookingSuccessActivity.u0();
    }
}
