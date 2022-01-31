package defpackage;

import android.location.Location;
import app.zophop.models.City;
import app.zophop.ui.activities.HomeScreenMapActivity;
import app.zophop.ui.fragments.HomeScreenMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.analytics.FirebaseAnalytics;
import defpackage.xt;

/* renamed from: ce0  reason: default package */
/* compiled from: HomeScreenMapActivity.kt */
public final class ce0 implements g34 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HomeScreenMapActivity f555a;

    public ce0(HomeScreenMapActivity homeScreenMapActivity) {
        this.f555a = homeScreenMapActivity;
    }

    @Override // defpackage.g34
    public void a(Location location) {
        e44 e44;
        n86.e(location, FirebaseAnalytics.Param.LOCATION);
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        xt.t1 t1Var = xt.f3961a;
        City d = t1Var.k().d();
        n86.c(d);
        if (d.containsLocation(latLng)) {
            HomeScreenMapActivity homeScreenMapActivity = this.f555a;
            int i = HomeScreenMapActivity.o;
            HomeScreenMapFragment p0 = homeScreenMapActivity.p0();
            if (!(p0 == null || (e44 = p0.v) == null)) {
                e44.b(hd3.i2(latLng));
            }
            HomeScreenMapFragment p02 = this.f555a.p0();
            if (p02 != null) {
                p02.k(latLng, false);
            }
        }
        t1Var.B().d(this);
    }
}
