package defpackage;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.util.Pair;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.internal.location.zzbh;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.zzal;
import com.google.android.gms.maps.model.LatLng;
import com.razorpay.AnalyticsConstants;
import defpackage.a32;
import defpackage.x22;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/* renamed from: le1  reason: default package */
/* compiled from: LocationsProvider */
public class le1 implements je1 {

    /* renamed from: a  reason: collision with root package name */
    public final xj1 f2201a;
    public String b;
    public List<Pair<LocationRequest, g34>> c = new ArrayList();
    public Context d;
    public a32 e;

    /* renamed from: le1$a */
    /* compiled from: LocationsProvider */
    public class a implements a32.c {
        public a() {
        }

        @Override // defpackage.w32
        public void F(ConnectionResult connectionResult) {
            le1.this.e.f();
        }
    }

    /* renamed from: le1$b */
    /* compiled from: LocationsProvider */
    public class b implements a32.b {
        public b() {
        }

        @Override // defpackage.n32
        public void C(int i) {
            jz5.b().i(ke1.DISCONNECTED);
        }

        @Override // defpackage.n32
        public synchronized void L(Bundle bundle) {
            for (Pair<LocationRequest, g34> pair : le1.this.c) {
                hn3 hn3 = h34.d;
                a32 a32 = le1.this.e;
                Objects.requireNonNull(hn3);
                gj1.l(Looper.myLooper(), "Calling thread must be a prepared Looper thread.");
                a32.j(new in3(a32, (LocationRequest) pair.first, (g34) pair.second));
            }
            le1.this.c.clear();
            jz5.b().i(ke1.CONNECTED);
        }
    }

    /* renamed from: le1$c */
    /* compiled from: LocationsProvider */
    public class c implements ti4<Void> {

        /* renamed from: le1$c$a */
        /* compiled from: LocationsProvider */
        public class a implements vi4<Void> {
            public a(c cVar) {
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // defpackage.vi4
            public void onSuccess(Void r1) {
            }
        }

        /* renamed from: le1$c$b */
        /* compiled from: LocationsProvider */
        public class b implements ui4 {
            public b(c cVar) {
            }

            @Override // defpackage.ui4
            public void onFailure(Exception exc) {
            }
        }

        public c(le1 le1) {
        }

        @Override // defpackage.ti4
        public void onComplete(yi4<Void> yi4) {
            yi4.f(new a(this));
            yi4.d(new b(this));
        }
    }

    public le1(Context context, xj1 xj1, String str) {
        this.d = context;
        this.f2201a = xj1;
        this.b = str;
        a aVar = new a();
        b bVar = new b();
        a32.a aVar2 = new a32.a(context);
        aVar2.b(bVar);
        aVar2.c(aVar);
        aVar2.a(h34.c);
        this.e = aVar2.d();
        this.e.f();
    }

    @Override // defpackage.je1
    public a32 a() {
        return this.e;
    }

    @Override // defpackage.je1
    public void b(LocationRequest locationRequest, g34 g34) {
        if (this.e.n()) {
            hn3 hn3 = h34.d;
            a32 a32 = this.e;
            Objects.requireNonNull(hn3);
            gj1.l(Looper.myLooper(), "Calling thread must be a prepared Looper thread.");
            a32.j(new in3(a32, locationRequest, g34));
            return;
        }
        this.c.add(new Pair<>(locationRequest, g34));
    }

    @Override // defpackage.je1
    public String c(String str) {
        Uri.Builder j = j();
        j.appendQueryParameter("address", str);
        j.appendQueryParameter(AnalyticsConstants.KEY, this.b);
        Uri build = j.build();
        build.toString();
        String uri = build.toString();
        String uuid = UUID.randomUUID().toString();
        this.f2201a.a(new lk1(uri, null, new me1(this, str, uuid), new ne1(this, str, uuid)));
        return uuid;
    }

    @Override // defpackage.je1
    public void d(g34 g34) {
        if (this.e.n()) {
            hn3 hn3 = h34.d;
            a32 a32 = this.e;
            Objects.requireNonNull(hn3);
            a32.j(new jn3(a32, g34));
        }
    }

    @Override // defpackage.je1
    public String f(LatLng latLng) {
        Uri.Builder j = j();
        j.appendQueryParameter("latlng", latLng.latitude + "," + latLng.longitude);
        j.appendQueryParameter(AnalyticsConstants.KEY, this.b);
        String uri = j.build().toString();
        String uuid = UUID.randomUUID().toString();
        this.f2201a.a(new lk1(uri, null, new oe1(this, latLng, uuid), new pe1(this, latLng, uuid)));
        return uuid;
    }

    @Override // defpackage.je1
    public void g(c34 c34, Class cls) {
        PendingIntent broadcast = PendingIntent.getBroadcast(this.d, 0, new Intent(this.d, cls), 134217728);
        if (this.e.n()) {
            Context context = this.d;
            x22.g<sm3> gVar = h34.f1335a;
            e34 e34 = new e34(context);
            List<c34> singletonList = Collections.singletonList(c34);
            ArrayList arrayList = new ArrayList();
            if (singletonList != null && !singletonList.isEmpty()) {
                for (c34 c342 : singletonList) {
                    if (c342 != null) {
                        gj1.l(c342, "geofence can't be null.");
                        gj1.c(c342 instanceof zzbh, "Geofence must be created using Geofence.Builder.");
                        arrayList.add((zzbh) c342);
                    }
                }
            }
            gj1.c(!arrayList.isEmpty(), "No geofence has been added to this request.");
            GeofencingRequest geofencingRequest = new GeofencingRequest(arrayList, 5, "");
            d34 d34 = h34.e;
            a32 asGoogleApiClient = e34.asGoogleApiClient();
            Objects.requireNonNull((am3) d34);
            l32 j = asGoogleApiClient.j(new bm3(asGoogleApiClient, geofencingRequest, broadcast));
            r92 r92 = new r92();
            o92 o92 = h82.f1346a;
            zi4 zi4 = new zi4();
            j.c(new p92(j, zi4, r92, o92));
            zi4.f4178a.b(new c(this));
        }
    }

    @Override // defpackage.je1
    public LatLng h() {
        Location location;
        if (!this.e.n()) {
            return null;
        }
        hn3 hn3 = h34.d;
        a32 a32 = this.e;
        Objects.requireNonNull(hn3);
        boolean z = true;
        gj1.c(a32 != null, "GoogleApiClient parameter is required.");
        sm3 sm3 = (sm3) a32.k(h34.f1335a);
        if (sm3 == null) {
            z = false;
        }
        gj1.o(z, "GoogleApiClient is not configured to use the LocationServices.API Api. Pass thisinto GoogleApiClient.Builder#addApi() to use this feature.");
        try {
            nm3 nm3 = sm3.c;
            nm3.f2575a.f1004a.checkConnected();
            location = ((jm3) nm3.f2575a.a()).zza(nm3.b.getPackageName());
        } catch (Exception unused) {
            location = null;
        }
        if (location != null) {
            return new LatLng(location.getLatitude(), location.getLongitude());
        }
        return null;
    }

    @Override // defpackage.je1
    public void i(String str) {
        if (this.e.n()) {
            Context context = this.d;
            x22.g<sm3> gVar = h34.f1335a;
            e34 e34 = new e34(context);
            List singletonList = Collections.singletonList(str);
            d34 d34 = h34.e;
            a32 asGoogleApiClient = e34.asGoogleApiClient();
            Objects.requireNonNull((am3) d34);
            gj1.l(singletonList, "geofence can't be null.");
            gj1.c(!singletonList.isEmpty(), "Geofences must contains at least one id.");
            l32 j = asGoogleApiClient.j(new cm3(asGoogleApiClient, new zzal(singletonList, null, "")));
            j.c(new p92(j, new zi4(), new r92(), h82.f1346a));
        }
    }

    public final Uri.Builder j() {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https").encodedAuthority("maps.googleapis.com/maps/api/geocode/json").appendQueryParameter("sensor", "false");
        return builder;
    }

    public void k(String str, LatLng latLng, ad1 ad1, boolean z, String str2) {
        if (z) {
            jz5.b().i(new ie1(str, latLng, ad1, str2));
        } else {
            jz5.b().i(new qe1(str, latLng, ad1, str2));
        }
    }
}
