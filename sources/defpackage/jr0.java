package defpackage;

import android.os.RemoteException;
import app.zophop.ui.activities.HomeScreenMapActivity;
import app.zophop.ui.fragments.HomeScreenMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.RuntimeRemoteException;

/* renamed from: jr0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class jr0 implements g44 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HomeScreenMapFragment f1972a;

    public /* synthetic */ jr0(HomeScreenMapFragment homeScreenMapFragment) {
        this.f1972a = homeScreenMapFragment;
    }

    @Override // defpackage.g44
    public final void a(e44 e44) {
        j44 j44;
        e44 e442;
        j44 f;
        HomeScreenMapFragment homeScreenMapFragment = this.f1972a;
        int i = HomeScreenMapFragment.U;
        n86.e(homeScreenMapFragment, "this$0");
        e44.f().a(false);
        homeScreenMapFragment.v = e44;
        e44.h(ui1.T(homeScreenMapFragment.getContext(), "android.permission.ACCESS_FINE_LOCATION"));
        e44.f().c(false);
        LatLng g = homeScreenMapFragment.g();
        e44 e443 = homeScreenMapFragment.v;
        n86.c(e443);
        e443.g(hd3.k2(g, homeScreenMapFragment.S));
        ib1 ib1 = homeScreenMapFragment.I;
        n86.c(ib1);
        ib1.setGoogleMap(homeScreenMapFragment.v);
        ib1 ib12 = homeScreenMapFragment.I;
        n86.c(ib12);
        ib12.setVisibility(8);
        homeScreenMapFragment.h();
        e44 e444 = homeScreenMapFragment.v;
        if (e444 != null) {
            homeScreenMapFragment.c();
            vn.V0(e444);
        }
        e44 e445 = homeScreenMapFragment.v;
        if (e445 == null) {
            j44 = null;
        } else {
            j44 = e445.f();
        }
        if (j44 != null) {
            j44.d(false);
        }
        if (!((homeScreenMapFragment.c() instanceof HomeScreenMapActivity) || (e442 = homeScreenMapFragment.v) == null || (f = e442.f()) == null)) {
            try {
                f.f1874a.m2(false);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        e44 e446 = homeScreenMapFragment.v;
        n86.c(e446);
        try {
            e446.f924a.z2(new z54(new hr0(homeScreenMapFragment)));
            homeScreenMapFragment.A = true;
            homeScreenMapFragment.h();
            ib1 ib13 = homeScreenMapFragment.I;
            n86.c(ib13);
            ib13.setVisibility(0);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }
}
