package defpackage;

import android.os.Handler;
import android.view.View;
import app.zophop.ui.activities.CabBookingActivity;

/* renamed from: hd0  reason: default package */
/* compiled from: CabBookingActivity */
public class hd0 implements View.OnClickListener {
    public final /* synthetic */ CabBookingActivity f;

    /* renamed from: hd0$a */
    /* compiled from: CabBookingActivity */
    public class a implements Runnable {
        public a() {
        }

        public void run() {
            CabBookingActivity.h0(hd0.this.f);
        }
    }

    public hd0(CabBookingActivity cabBookingActivity) {
        this.f = cabBookingActivity;
    }

    public void onClick(View view) {
        if (xt.f3961a.f().c()) {
            CabBookingActivity.h0(this.f);
        } else {
            new Handler().postDelayed(new a(), 5000);
        }
        CabBookingActivity cabBookingActivity = this.f;
        int i = CabBookingActivity.K;
        cabBookingActivity.s0();
    }
}
