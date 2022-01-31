package defpackage;

import android.content.Context;
import app.zophop.models.City;
import app.zophop.models.LiveTripInfo;
import app.zophop.pubsub.eventbus.events.CityChangedEvent;
import app.zophop.pubsub.eventbus.events.GeoFireEvent;
import com.firebase.geofire.GeoFire;
import com.firebase.geofire.GeoLocation;
import com.firebase.geofire.GeoQuery;
import com.firebase.geofire.GeoQueryEventListener;
import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import defpackage.xt;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;
import server.zophop.models.GeoRealTimeInfo;

/* renamed from: y10  reason: default package */
/* compiled from: GeoFireFeature */
public class y10 implements o20 {
    public static double d;
    public static double e;
    public static float f;

    /* renamed from: a  reason: collision with root package name */
    public GeoFire f3988a;
    public final Context b;
    public final Map<String, GeoQuery> c = new HashMap();

    /* renamed from: y10$a */
    /* compiled from: GeoFireFeature */
    public class a implements GeoQueryEventListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f3989a;
        public final /* synthetic */ LatLng b;

        public a(String str, LatLng latLng) {
            this.f3989a = str;
            this.b = latLng;
        }

        @Override // com.firebase.geofire.GeoQueryEventListener
        public void onGeoQueryError(DatabaseError databaseError) {
            databaseError.toString();
        }

        @Override // com.firebase.geofire.GeoQueryEventListener
        public void onGeoQueryReady() {
        }

        @Override // com.firebase.geofire.GeoQueryEventListener
        public void onKeyEntered(String str, GeoLocation geoLocation) {
            jz5.b().i(new GeoFireEvent(this.f3989a, GeoFireEvent.Type.ENTERED, y10.this.e(str, geoLocation), this.b));
        }

        @Override // com.firebase.geofire.GeoQueryEventListener
        public void onKeyExited(String str) {
            jz5.b().i(new GeoFireEvent(this.f3989a, GeoFireEvent.Type.EXITED, y10.this.e(str, null), this.b));
        }

        @Override // com.firebase.geofire.GeoQueryEventListener
        public void onKeyMoved(String str, GeoLocation geoLocation) {
            jz5.b().i(new GeoFireEvent(this.f3989a, GeoFireEvent.Type.MOVED, y10.this.e(str, geoLocation), this.b));
        }
    }

    public y10(Context context, xj1 xj1) {
        this.b = context;
        g();
        if (xt.f3961a.k().d() != null) {
            f();
        }
        jz5 b2 = jz5.b();
        b2.k(this, b2.e, true, 0);
    }

    public static void g() {
        String name;
        String f2;
        xt.t1 t1Var = xt.f3961a;
        d = t1Var.t().e("mapOverlayRadius");
        e = t1Var.t().e("homeScreenGeofireNewQueryThreshold");
        f = (float) t1Var.t().e("homeScreenMapZoomLevel");
        City d2 = t1Var.k().d();
        if (d2 != null && (name = d2.getName()) != null && (f2 = t1Var.t().f("homeScreenGeoFireParams")) != null) {
            try {
                JSONObject jSONObject = new JSONObject(f2);
                if (jSONObject.has(name.toLowerCase())) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(name.toLowerCase());
                    if (jSONObject2.has("radius")) {
                        d = jSONObject2.getDouble("radius");
                    }
                    if (jSONObject2.has("nqt")) {
                        e = jSONObject2.getDouble("nqt");
                    }
                    if (jSONObject2.has("zoom")) {
                        f = (float) jSONObject2.getDouble("zoom");
                    }
                }
            } catch (Exception e2) {
                e2.getMessage();
                b00 b00 = b00.f358a;
                b00.a().b(e2);
            }
        }
    }

    @Override // defpackage.o20
    public void a(String str) {
        GeoQuery geoQuery = this.c.get(str);
        if (geoQuery != null) {
            geoQuery.removeAllListeners();
            this.c.remove(geoQuery);
        }
    }

    @Override // defpackage.o20
    public boolean b(String str, LatLng latLng) {
        Map<String, GeoQuery> map = this.c;
        if (map == null || !map.containsKey(str) || this.c.get(str) == null) {
            return false;
        }
        this.c.get(str).setCenter(new GeoLocation(latLng.latitude, latLng.longitude, null));
        return true;
    }

    @Override // defpackage.o20
    public void c(int i) {
    }

    @Override // defpackage.o20
    public String d(LatLng latLng, double d2, int i) {
        if (!vn.K0(this.b)) {
            return null;
        }
        String uuid = UUID.randomUUID().toString();
        GeoQuery queryAtLocation = this.f3988a.queryAtLocation(new GeoLocation(latLng.latitude, latLng.longitude, null), d2 / 1000.0d);
        queryAtLocation.addGeoQueryEventListener(new a(uuid, latLng));
        this.c.put(uuid, queryAtLocation);
        return uuid;
    }

    public LiveTripInfo e(String str, GeoLocation geoLocation) {
        GeoRealTimeInfo geoRealTimeInfo = (GeoRealTimeInfo) hj1.s(str, GeoRealTimeInfo.class);
        return new LiveTripInfo(geoRealTimeInfo.getStreamId(), geoRealTimeInfo.getRouteId(), geoLocation, geoRealTimeInfo, str);
    }

    public final void f() {
        City d2 = xt.f3961a.k().d();
        this.f3988a = new GeoFire(FirebaseDatabase.getInstance(d2.getLiveDataUrl()).getReference(ut.g.name()).child("geofire").child(d2.getName().toUpperCase()));
    }

    public void onEvent(CityChangedEvent cityChangedEvent) {
        g();
        f();
    }
}
