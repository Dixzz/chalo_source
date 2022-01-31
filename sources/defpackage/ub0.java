package defpackage;

import android.app.FragmentManager;
import android.view.View;
import android.widget.TextView;
import app.zophop.R;
import app.zophop.models.mTicketing.MPass;
import app.zophop.ui.activities.ActivatePassScreen;
import com.google.android.gms.maps.model.LatLng;
import defpackage.xt;
import java.util.HashMap;
import java.util.Objects;

/* renamed from: ub0  reason: default package */
/* compiled from: ActivatePassScreen */
public class ub0 implements View.OnClickListener {
    public final /* synthetic */ ActivatePassScreen f;

    /* renamed from: ub0$a */
    /* compiled from: ActivatePassScreen */
    public class a implements View.OnClickListener {
        public final /* synthetic */ lm0 f;

        /* renamed from: ub0$a$a  reason: collision with other inner class name */
        /* compiled from: ActivatePassScreen */
        public class View$OnClickListenerC0058a implements View.OnClickListener {
            public final /* synthetic */ lm0 f;

            public View$OnClickListenerC0058a(a aVar, lm0 lm0) {
                this.f = lm0;
            }

            public void onClick(View view) {
                this.f.dismiss();
            }
        }

        public a(lm0 lm0) {
            this.f = lm0;
        }

        public void onClick(View view) {
            String str;
            this.f.dismiss();
            ActivatePassScreen activatePassScreen = ub0.this.f;
            MPass mPass = ActivatePassScreen.K;
            Objects.requireNonNull(activatePassScreen);
            ActivatePassScreen.K.getBookingPassId();
            int B0 = vn.B0(activatePassScreen.q, ActivatePassScreen.K.getPunches());
            int J = vn.J(activatePassScreen.q);
            ed1 ed1 = new ed1("pass activated", Long.MIN_VALUE);
            vn.b(ed1, ActivatePassScreen.K);
            zz zzVar = new zz("pass activated", new HashMap());
            zzVar.a("date", jh1.c(ui1.Q()));
            zzVar.a("time", jh1.g(ui1.Q()));
            ui1.l0(zzVar);
            xt.t1 t1Var = xt.f3961a;
            if (t1Var.B().h() != null) {
                LatLng h = t1Var.B().h();
                ed1.a("long", hj1.U(hj1.f0(ed1, "lat", hj1.U(new StringBuilder(), h.latitude, "")), h.longitude, ""));
            }
            ed1.a("userId", ActivatePassScreen.K.getUserProfile().getUserId());
            ed1.a("ss total trip count available", Integer.valueOf(B0));
            ed1.a("ss daily trip count available", Integer.valueOf(J));
            ed1.a("time", jh1.g(ui1.Q()));
            ed1.a("date", jh1.c(ui1.Q()));
            jz5.b().g(ed1);
            if (!(B0 < ActivatePassScreen.K.get_maxTrips() && (J < ActivatePassScreen.K.get_maxTripsPerDay() || ActivatePassScreen.K.get_maxTripsPerDay() == -1))) {
                int B02 = vn.B0(ub0.this.f.q, ActivatePassScreen.K.getPunches());
                FragmentManager fragmentManager = ub0.this.f.getFragmentManager();
                String string = ub0.this.f.getString(B02 <= 0 ? R.string.dialog_all_ride_over_header : R.string.dialog_ride_over_header);
                if (B02 <= 0) {
                    str = ub0.this.f.getString(R.string.dialog_all_ride_over_desc);
                } else {
                    str = ub0.this.f.getString(R.string.dialog_ride_over_desc);
                }
                lm0 a2 = lm0.a(fragmentManager, string, str, ub0.this.f.getResources().getString(R.string.okay), null);
                View$OnClickListenerC0058a aVar = new View$OnClickListenerC0058a(this, a2);
                TextView textView = a2.i;
                if (textView != null) {
                    textView.setOnClickListener(aVar);
                } else {
                    a2.q = aVar;
                }
            } else {
                ActivatePassScreen.h0(ub0.this.f);
            }
        }
    }

    /* renamed from: ub0$b */
    /* compiled from: ActivatePassScreen */
    public class b implements View.OnClickListener {
        public final /* synthetic */ lm0 f;

        public b(ub0 ub0, lm0 lm0) {
            this.f = lm0;
        }

        public void onClick(View view) {
            this.f.dismiss();
        }
    }

    public ub0(ActivatePassScreen activatePassScreen) {
        this.f = activatePassScreen;
    }

    public void onClick(View view) {
        if (ActivatePassScreen.K.get_productType() == null || !ActivatePassScreen.K.get_productType().equals("superSaver")) {
            ActivatePassScreen.h0(this.f);
            return;
        }
        lm0 a2 = lm0.a(this.f.getFragmentManager(), this.f.getString(R.string.dialog_message_confirm_pass_activation_header), this.f.getString(R.string.dialog_trip_info), this.f.getResources().getString(R.string.yes), this.f.getResources().getString(R.string.cancel));
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
