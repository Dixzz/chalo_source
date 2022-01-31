package app.zophop.ui.activities;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import app.zophop.R;
import app.zophop.ui.fragments.HomeScreenMapFragment;
import app.zophop.ui.views.MapCustomMyLocation;
import com.google.android.gms.location.LocationRequest;
import com.google.android.material.appbar.MaterialToolbar;
import defpackage.wd1;

/* compiled from: HomeScreenMapActivity.kt */
public final class HomeScreenMapActivity extends ol0<dy> implements wd1.a {
    public static final /* synthetic */ int o = 0;
    public final r<Intent> k;
    public final j56 l = hd3.a2(new a(this));
    public final r<String> m;
    public boolean n;

    /* compiled from: HomeScreenMapActivity.kt */
    public static final class a extends o86 implements h76<ah1> {
        public final /* synthetic */ HomeScreenMapActivity f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(HomeScreenMapActivity homeScreenMapActivity) {
            super(0);
            this.f = homeScreenMapActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public ah1 invoke() {
            return new ah1(this.f, xt.f3961a.B().a());
        }
    }

    public HomeScreenMapActivity() {
        r<Intent> registerForActivityResult = registerForActivityResult(new w(), p90.f2782a);
        n86.d(registerForActivityResult, "registerForActivityResul…rtActivityForResult()) {}");
        this.k = registerForActivityResult;
        r<String> registerForActivityResult2 = registerForActivityResult(new v(), new v90(this));
        n86.d(registerForActivityResult2, "registerForActivityResul…g.show()\n        }\n\n    }");
        this.m = registerForActivityResult2;
        this.n = true;
    }

    @Override // defpackage.wd1.a
    public void b0() {
        HomeScreenMapFragment p0 = p0();
        if (p0 != null && p0.v != null) {
            Handler handler = p0.x;
            n86.c(handler);
            handler.sendEmptyMessageDelayed(p0.j, 5);
            Handler handler2 = p0.x;
            n86.c(handler2);
            handler2.removeMessages(p0.l);
            Handler handler3 = p0.x;
            n86.c(handler3);
            handler3.sendEmptyMessageDelayed(p0.l, p0.q);
            Handler handler4 = p0.x;
            n86.c(handler4);
            handler4.sendEmptyMessageDelayed(p0.k, p0.q);
        }
    }

    @Override // defpackage.wd1.a
    public void c0() {
        new Handler().postDelayed(new r90(this), 350);
    }

    /* Return type fixed from 'qo' to match base method */
    @Override // defpackage.ol0
    public dy g0() {
        View inflate = getLayoutInflater().inflate(R.layout.home_screen_map_activity, (ViewGroup) null, false);
        int i = R.id.home_map_custom_my_loc;
        MapCustomMyLocation mapCustomMyLocation = (MapCustomMyLocation) inflate.findViewById(R.id.home_map_custom_my_loc);
        if (mapCustomMyLocation != null) {
            i = R.id.map_container;
            FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.map_container);
            if (frameLayout != null) {
                i = R.id.toolbar;
                MaterialToolbar materialToolbar = (MaterialToolbar) inflate.findViewById(R.id.toolbar);
                if (materialToolbar != null) {
                    dy dyVar = new dy((ConstraintLayout) inflate, mapCustomMyLocation, frameLayout, materialToolbar);
                    n86.d(dyVar, "inflate(layoutInflater)");
                    return dyVar;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // defpackage.ol0
    public void h0(Bundle bundle) {
        o0();
        HomeScreenMapFragment p0 = p0();
        if (p0 != null) {
            p0.d(new t90(this));
        }
        ((dy) f0()).c.setNavigationOnClickListener(new u90(this));
    }

    @Override // defpackage.ol0
    public void i0() {
    }

    @Override // defpackage.ol0
    public void j0() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.location.MODE_CHANGED");
        intentFilter.addAction("android.location.PROVIDER_CHANGED_ACTION");
        registerReceiver(d0(), intentFilter);
        registerReceiver(e0(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    @Override // defpackage.ol0
    public void m0() {
    }

    @Override // defpackage.ol0
    public void n0() {
        unregisterReceiver(d0());
        unregisterReceiver(e0());
    }

    public final void o0() {
        if (ui1.T(this, "android.permission.ACCESS_FINE_LOCATION")) {
            r0();
        } else if (Build.VERSION.SDK_INT >= 23) {
            this.m.a("android.permission.ACCESS_FINE_LOCATION", null);
            jz5.b().g(hj1.l("permission_popup", Long.MIN_VALUE, "element", "home_location"));
        }
    }

    @Override // androidx.activity.ComponentActivity, defpackage.ve
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 99) {
            q0(new ce0(this));
        }
    }

    public final void onEvent(qd1 qd1) {
        n86.e(qd1, "networkConnectivityEvent");
        boolean z = qd1.f2931a;
        if (z != this.n) {
            if (z) {
                o0();
                k0();
            } else {
                l0(((dy) f0()).f902a);
            }
            this.n = z;
        }
        jz5.b().m(qd1);
    }

    @Override // defpackage.f0, defpackage.ve, defpackage.ol0
    public void onStart() {
        super.onStart();
        jz5 b = jz5.b();
        b.k(this, b.e, true, 0);
        q0(new ce0(this));
    }

    @Override // defpackage.f0, defpackage.ve, defpackage.ol0
    public void onStop() {
        super.onStop();
        jz5.b().o(this);
    }

    public final HomeScreenMapFragment p0() {
        return (HomeScreenMapFragment) getSupportFragmentManager().I("live_map");
    }

    public final void q0(g34 g34) {
        if (vn.M0(this) && ui1.T(this, "android.permission.ACCESS_FINE_LOCATION")) {
            je1 B = xt.f3961a.B();
            LocationRequest locationRequest = new LocationRequest();
            locationRequest.m1(100);
            locationRequest.l1(1000);
            B.b(locationRequest, g34);
        }
    }

    public final void r0() {
        if (!vn.J0(this)) {
            ((ah1) this.l.getValue()).b(getString(R.string.gps_not_available_toast));
        } else {
            q0(new ce0(this));
        }
    }

    public final void onEvent(pd1 pd1) {
        n86.e(pd1, "event");
        o0();
        jz5.b().m(pd1);
    }
}
