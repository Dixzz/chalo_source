package defpackage;

import android.os.Handler;
import android.os.Message;
import app.zophop.models.LiveTripInfo;
import app.zophop.models.TransitMode;
import app.zophop.ui.activities.HomeScreenMapActivity;
import app.zophop.ui.fragments.HomeScreenMapFragment;
import defpackage.xt;
import java.util.List;
import server.zophop.Constants;

/* renamed from: ir0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class ir0 implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HomeScreenMapFragment f1562a;

    public /* synthetic */ ir0(HomeScreenMapFragment homeScreenMapFragment) {
        this.f1562a = homeScreenMapFragment;
    }

    public final boolean handleMessage(Message message) {
        HomeScreenMapFragment homeScreenMapFragment = this.f1562a;
        int i = HomeScreenMapFragment.U;
        n86.e(homeScreenMapFragment, "this$0");
        n86.e(message, "message");
        xt.t1 t1Var = xt.f3961a;
        int c = (int) t1Var.t().c("homeScreenStopsMarkerCount");
        if (message.what == homeScreenMapFragment.n) {
            e44 e44 = homeScreenMapFragment.v;
            if (e44 != null) {
                n86.c(e44);
                if (e44.d().zoom > ((float) ((int) t1Var.t().c("maxZoomForStopMarker")))) {
                    homeScreenMapFragment.R = t1Var.c0().e(vn.G(homeScreenMapFragment.v), TransitMode.bus, c, t1Var.t().f("nearbyStopsRadius"));
                }
            }
            homeScreenMapFragment.f();
        }
        int i2 = message.what;
        if (i2 == homeScreenMapFragment.k) {
            if (homeScreenMapFragment.c() != null) {
                homeScreenMapFragment.k(null, false);
            }
        } else if (i2 == homeScreenMapFragment.j) {
            if (homeScreenMapFragment.v != null) {
                ib1 ib1 = homeScreenMapFragment.I;
                n86.c(ib1);
                ib1.a(y10.d);
            }
            Handler handler = homeScreenMapFragment.x;
            n86.c(handler);
            handler.sendEmptyMessageDelayed(homeScreenMapFragment.j, 5);
        } else if (i2 == homeScreenMapFragment.l) {
            Handler handler2 = homeScreenMapFragment.x;
            n86.c(handler2);
            handler2.removeMessages(homeScreenMapFragment.j);
        } else if (i2 == homeScreenMapFragment.m) {
            List<LiveTripInfo> list = homeScreenMapFragment.C;
            n86.c(list);
            String str = "geofire";
            if (list.isEmpty()) {
                ed1 ed1 = new ed1("home screen no live vehicles loaded", 3600000);
                ed1.a("hourOfEvent", n86.j("", Integer.valueOf(jh1.j(System.currentTimeMillis()))));
                if (!xt.y0) {
                    str = Constants.ELASTIC_SEARCH_BASIC_AUTH_USERNAME;
                }
                hj1.K0(ed1, "geoSpatialSrc", str, ed1);
            } else {
                ed1 ed12 = new ed1("home screen live vehicles shown on map", 3600000);
                StringBuilder sb = new StringBuilder();
                List<LiveTripInfo> list2 = homeScreenMapFragment.C;
                n86.c(list2);
                sb.append(list2.size());
                sb.append("");
                ed12.a("totalMarkers", sb.toString());
                ed12.a("hourOfEvent", jh1.j(System.currentTimeMillis()) + "");
                ed12.a("firstLoadTimeMillis", n86.j("", Long.valueOf(homeScreenMapFragment.P)));
                if (!xt.y0) {
                    str = Constants.ELASTIC_SEARCH_BASIC_AUTH_USERNAME;
                }
                hj1.K0(ed12, "geoSpatialSrc", str, ed12);
            }
        } else if (i2 != homeScreenMapFragment.p) {
            return false;
        } else {
            if (!homeScreenMapFragment.O && homeScreenMapFragment.isAdded() && homeScreenMapFragment.isVisible() && vn.K0(homeScreenMapFragment.c()) && vn.M0(homeScreenMapFragment.c())) {
                boolean z = homeScreenMapFragment.c() instanceof HomeScreenMapActivity;
            }
        }
        return true;
    }
}
