package defpackage;

import android.location.Location;
import app.zophop.ui.fragments.HomeScreenMainFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.analytics.FirebaseAnalytics;
import defpackage.d81;
import java.util.Objects;

/* renamed from: hu0  reason: default package */
/* compiled from: HomeScreenMainFragment.kt */
public final class hu0 implements g34 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HomeScreenMainFragment f1427a;

    public hu0(HomeScreenMainFragment homeScreenMainFragment) {
        this.f1427a = homeScreenMainFragment;
    }

    @Override // defpackage.g34
    public void a(Location location) {
        n86.e(location, FirebaseAnalytics.Param.LOCATION);
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        HomeScreenMainFragment homeScreenMainFragment = this.f1427a;
        HomeScreenMainFragment.a aVar = HomeScreenMainFragment.v;
        ((oh) homeScreenMainFragment.o().p.getValue()).j(latLng);
        d81 o = this.f1427a.o();
        Objects.requireNonNull(o);
        o.j = d81.a.NOT_QUERIED;
        o.r();
        xt.f3961a.B().d(this);
    }
}
