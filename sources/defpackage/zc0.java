package defpackage;

import app.zophop.ui.activities.BusEtaFrequencyActivity;
import app.zophop.ui.activities.WebViewActivity;
import defpackage.gw0;
import java.util.Objects;

/* renamed from: zc0  reason: default package */
/* compiled from: BusEtaFrequencyActivity */
public class zc0 implements gw0.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BusEtaFrequencyActivity f4154a;

    public zc0(BusEtaFrequencyActivity busEtaFrequencyActivity) {
        this.f4154a = busEtaFrequencyActivity;
    }

    @Override // defpackage.gw0.a
    public void a() {
        ed1 ed1 = new ed1("seat occupancy bottomsheet rendered on demand busRouteFragment", Long.MIN_VALUE);
        ed1.a("seat occupancy api mode", Integer.valueOf(this.f4154a.m.getSeatAvailability()));
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
        BusEtaFrequencyActivity busEtaFrequencyActivity = this.f4154a;
        Objects.requireNonNull(busEtaFrequencyActivity);
        busEtaFrequencyActivity.startActivity(WebViewActivity.i0(busEtaFrequencyActivity, str, "Live Passenger Indicator", false, false));
    }
}
