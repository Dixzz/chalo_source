package defpackage;

import android.text.TextUtils;
import android.view.View;
import app.zophop.R;
import app.zophop.models.TransitMode;
import app.zophop.ui.activities.NearbyStopsActivity;
import app.zophop.ui.views.MapCustomMyLocation;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import defpackage.e44;
import java.util.Objects;

/* renamed from: ye0  reason: default package */
/* compiled from: NearbyStopsActivity */
public class ye0 implements g44 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NearbyStopsActivity f4034a;

    /* renamed from: ye0$a */
    /* compiled from: NearbyStopsActivity */
    public class a implements e44.c {
        public a() {
        }

        @Override // defpackage.e44.c
        public void a(CameraPosition cameraPosition) {
            ye0.this.f4034a.c0();
        }
    }

    /* renamed from: ye0$b */
    /* compiled from: NearbyStopsActivity */
    public class b implements e44.h {
        public b() {
        }

        @Override // defpackage.e44.h
        public boolean a(Marker marker) {
            ye0.this.f4034a.p0(marker);
            return true;
        }
    }

    /* renamed from: ye0$c */
    /* compiled from: NearbyStopsActivity */
    public class c implements e44.g {
        public c() {
        }

        @Override // defpackage.e44.g
        public void a() {
            ye0.this.f4034a.c0();
        }
    }

    /* renamed from: ye0$d */
    /* compiled from: NearbyStopsActivity */
    public class d implements View.OnClickListener {
        public d() {
        }

        public void onClick(View view) {
            NearbyStopsActivity nearbyStopsActivity = ye0.this.f4034a;
            Objects.requireNonNull(nearbyStopsActivity);
            if (!ui1.T(nearbyStopsActivity, "android.permission.ACCESS_FINE_LOCATION")) {
                NearbyStopsActivity nearbyStopsActivity2 = ye0.this.f4034a;
                Objects.requireNonNull(nearbyStopsActivity2);
                String[] strArr = {"android.permission.ACCESS_FINE_LOCATION"};
                if (!ui1.T(nearbyStopsActivity2, strArr)) {
                    nearbyStopsActivity2.requestPermissions(strArr, 123);
                }
            } else if (!vn.J0(ye0.this.f4034a)) {
                NearbyStopsActivity nearbyStopsActivity3 = ye0.this.f4034a;
                nearbyStopsActivity3.O.b(nearbyStopsActivity3.getString(R.string.gps_not_available_toast));
            }
        }
    }

    public ye0(NearbyStopsActivity nearbyStopsActivity) {
        this.f4034a = nearbyStopsActivity;
    }

    @Override // defpackage.g44
    public void a(e44 e44) {
        this.f4034a.l = e44;
        e44.f().d(false);
        this.f4034a.l.f().b(false);
        NearbyStopsActivity nearbyStopsActivity = this.f4034a;
        nearbyStopsActivity.l.h(nearbyStopsActivity.I);
        this.f4034a.l.f().c(false);
        this.f4034a.l.g(hd3.k2(NearbyStopsActivity.h0(this.f4034a), 12.0f));
        this.f4034a.l.i(new a());
        this.f4034a.l.k(new b());
        this.f4034a.l.j(new c());
        f44.a(this.f4034a);
        NearbyStopsActivity nearbyStopsActivity2 = this.f4034a;
        LatLng h = nearbyStopsActivity2.m.h();
        if (h != null) {
            if (!nearbyStopsActivity2.k.d().containsLocation(h)) {
                ui1.c(nearbyStopsActivity2, nearbyStopsActivity2.k, h, NearbyStopsActivity.class, false, NearbyStopsActivity.class.getSimpleName());
            } else if (TextUtils.isEmpty(nearbyStopsActivity2.x)) {
                TransitMode transitMode = nearbyStopsActivity2.w;
                if (transitMode == null) {
                    transitMode = nearbyStopsActivity2.p.get(0);
                }
                nearbyStopsActivity2.o0(transitMode, h);
            }
        }
        NearbyStopsActivity nearbyStopsActivity3 = this.f4034a;
        TransitMode transitMode2 = nearbyStopsActivity3.w;
        nearbyStopsActivity3.u.a(transitMode2 != null ? nearbyStopsActivity3.p.indexOf(transitMode2) : 0, 0);
        if (nearbyStopsActivity3.y != null) {
            nearbyStopsActivity3.k0(nearbyStopsActivity3.y, nearbyStopsActivity3.o.get(nearbyStopsActivity3.w), true);
        }
        e44 e442 = this.f4034a.l;
        if (e442 != null) {
            vn.V0(e442);
        }
        NearbyStopsActivity nearbyStopsActivity4 = this.f4034a;
        nearbyStopsActivity4.N = (MapCustomMyLocation) nearbyStopsActivity4.findViewById(R.id.home_map_custom_my_loc);
        NearbyStopsActivity nearbyStopsActivity5 = this.f4034a;
        if (nearbyStopsActivity5.I) {
            nearbyStopsActivity5.N.setMap(nearbyStopsActivity5.l);
        }
        this.f4034a.N.setOnClickListener(new d());
    }
}
