package defpackage;

import android.view.View;
import app.zophop.ui.activities.CabBookingActivity;

/* renamed from: bd0  reason: default package */
/* compiled from: CabBookingActivity */
public class bd0 implements View.OnClickListener {
    public final /* synthetic */ CabBookingActivity f;

    public bd0(CabBookingActivity cabBookingActivity) {
        this.f = cabBookingActivity;
    }

    public void onClick(View view) {
        CabBookingActivity cabBookingActivity = this.f;
        if (!cabBookingActivity.J) {
            cabBookingActivity.L0();
        } else {
            cabBookingActivity.r0();
        }
        this.f.J0();
    }
}
