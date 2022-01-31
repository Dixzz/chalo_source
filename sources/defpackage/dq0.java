package defpackage;

import app.zophop.models.City;
import app.zophop.ui.activities.HomeActivity;
import app.zophop.ui.fragments.HomeScreenMainFragment;
import app.zophop.ui.fragments.HomeScreenMapFragment;
import com.google.android.gms.maps.model.LatLng;
import defpackage.xt;

/* renamed from: dq0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class dq0 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HomeScreenMainFragment f880a;

    public /* synthetic */ dq0(HomeScreenMainFragment homeScreenMainFragment) {
        this.f880a = homeScreenMainFragment;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        e44 e44;
        HomeScreenMainFragment homeScreenMainFragment = this.f880a;
        LatLng latLng = (LatLng) obj;
        HomeScreenMainFragment.a aVar = HomeScreenMainFragment.v;
        n86.e(homeScreenMainFragment, "this$0");
        if (latLng != null) {
            xt.t1 t1Var = xt.f3961a;
            City d = t1Var.k().d();
            n86.c(d);
            if (d.containsLocation(latLng)) {
                HomeScreenMapFragment homeScreenMapFragment = (HomeScreenMapFragment) homeScreenMainFragment.getChildFragmentManager().I("home_screen_map");
                if (!(homeScreenMapFragment == null || (e44 = homeScreenMapFragment.v) == null)) {
                    e44.b(hd3.i2(latLng));
                }
                HomeScreenMapFragment homeScreenMapFragment2 = (HomeScreenMapFragment) homeScreenMainFragment.getChildFragmentManager().I("home_screen_map");
                if (homeScreenMapFragment2 != null) {
                    homeScreenMapFragment2.k(latLng, false);
                }
            }
            if (!t1Var.k().a() && ui1.Z(latLng)) {
                LatLng h = t1Var.B().h();
                City city = null;
                if (h != null) {
                    for (City city2 : t1Var.k().e()) {
                        if (city2.containsLocation(h)) {
                            city = city2;
                        }
                    }
                }
                if (city == null) {
                    i20 o = xt.f3961a.o();
                    HomeActivity.a aVar2 = HomeActivity.k;
                    o.b("Home Screen", new rn0(90, new gp0(homeScreenMainFragment)));
                } else {
                    xt.t1 t1Var2 = xt.f3961a;
                    City d2 = t1Var2.k().d();
                    n86.c(d2);
                    String g = vn.g(d2.getDisplayName());
                    i20 o2 = t1Var2.o();
                    HomeActivity.a aVar3 = HomeActivity.k;
                    o2.b("Home Screen", new rn0(90, new tp0(homeScreenMainFragment, g)));
                }
                xt.f3961a.k().b();
            }
        }
    }
}
