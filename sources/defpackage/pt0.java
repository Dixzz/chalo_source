package defpackage;

import android.app.Activity;
import app.zophop.ui.activities.WebViewActivity;
import defpackage.gw0;

/* renamed from: pt0  reason: default package */
/* compiled from: BusRouteFragment */
public class pt0 implements gw0.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ mt0 f2846a;

    public pt0(mt0 mt0) {
        this.f2846a = mt0;
    }

    @Override // defpackage.gw0.a
    public void a() {
        ed1 ed1 = new ed1("seat occupancy bottomsheet rendered on demand busRouteFragment", Long.MIN_VALUE);
        ed1.a("seat occupancy api mode", Integer.valueOf(this.f2846a.g.getSeatAvailability()));
        jz5.b().g(ed1);
    }

    @Override // defpackage.gw0.a
    public void b() {
        jz5.b().g(new ed1("seat occupancy bottomsheet got it clicked", Long.MIN_VALUE));
        xt.f3961a.l().put("seatOccupancyDialogShown", "true");
    }

    @Override // defpackage.gw0.a
    public void c(String str) {
        xt.f3961a.l().put("seatOccupancyDialogShown", "true");
        jz5.b().g(new ed1("seat occupancy bottomsheet learn more clicked", Long.MIN_VALUE));
        mt0 mt0 = this.f2846a;
        Activity activity = mt0.getActivity();
        if (activity != null) {
            mt0.startActivity(WebViewActivity.i0(activity, str, "Live Passenger Indicator", false, false));
        }
    }
}
