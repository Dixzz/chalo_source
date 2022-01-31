package defpackage;

import android.view.View;
import android.widget.Toast;
import app.zophop.R;
import app.zophop.ui.activities.CabBookingActivity;
import defpackage.xt;

/* renamed from: fd0  reason: default package */
/* compiled from: CabBookingActivity */
public class fd0 implements View.OnClickListener {
    public final /* synthetic */ CabBookingActivity f;

    public fd0(CabBookingActivity cabBookingActivity) {
        this.f = cabBookingActivity;
    }

    public void onClick(View view) {
        if (!CabBookingActivity.t0(this.f.o)) {
            Toast.makeText(view.getContext(), this.f.getResources().getString(R.string.cab_improper_from), 1).show();
            CabBookingActivity.i0(this.f, "failed", "start location not set");
            return;
        }
        CabBookingActivity cabBookingActivity = this.f;
        if (cabBookingActivity.B == null) {
            CabBookingActivity.i0(cabBookingActivity, "failed", "cabs unavailable");
            Toast.makeText(view.getContext(), this.f.getString(R.string.cab_no_cab_nearby), 1).show();
            return;
        }
        xt.t1 t1Var = xt.f3961a;
        if (t1Var.H().e(this.f.v)) {
            CabBookingActivity.i0(this.f, "succeeded", "");
            this.f.B0(null);
            return;
        }
        CabBookingActivity.i0(this.f, "oauth initiated", "user needs to login");
        t1Var.H().c(this.f.v, view.getContext());
        this.f.G = true;
    }
}
