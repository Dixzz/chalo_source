package defpackage;

import android.view.View;
import android.widget.TextView;
import app.zophop.R;
import app.zophop.models.autoCabBooking.BookingDetails;
import app.zophop.ui.activities.CabBookingActivity;
import defpackage.xt;

/* renamed from: gd0  reason: default package */
/* compiled from: CabBookingActivity */
public class gd0 implements View.OnClickListener {
    public final /* synthetic */ CabBookingActivity f;

    /* renamed from: gd0$a */
    /* compiled from: CabBookingActivity */
    public class a implements View.OnClickListener {
        public final /* synthetic */ lm0 f;

        public a(lm0 lm0) {
            this.f = lm0;
        }

        public void onClick(View view) {
            xt.t1 t1Var = xt.f3961a;
            BookingDetails b = t1Var.f().b();
            if (b != null) {
                t1Var.g().f(b.getProvider(), b.getRequestId(), t1Var.H().f(b.getProvider()));
                CabBookingActivity cabBookingActivity = gd0.this.f;
                cabBookingActivity.I.show(cabBookingActivity.getFragmentManager(), "TAG");
            }
            this.f.dismiss();
        }
    }

    /* renamed from: gd0$b */
    /* compiled from: CabBookingActivity */
    public class b implements View.OnClickListener {
        public final /* synthetic */ lm0 f;

        public b(gd0 gd0, lm0 lm0) {
            this.f = lm0;
        }

        public void onClick(View view) {
            this.f.dismiss();
        }
    }

    public gd0(CabBookingActivity cabBookingActivity) {
        this.f = cabBookingActivity;
    }

    public void onClick(View view) {
        lm0 a2 = lm0.a(this.f.getFragmentManager(), null, this.f.getString(R.string.cab_end_ride_prompt), this.f.getResources().getString(R.string.yes), this.f.getString(R.string.cab_no));
        a aVar = new a(a2);
        TextView textView = a2.i;
        if (textView != null) {
            textView.setOnClickListener(aVar);
        } else {
            a2.q = aVar;
        }
        b bVar = new b(this, a2);
        TextView textView2 = a2.j;
        if (textView2 != null) {
            textView2.setOnClickListener(bVar);
        } else {
            a2.r = bVar;
        }
    }
}
