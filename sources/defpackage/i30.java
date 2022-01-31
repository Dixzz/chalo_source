package defpackage;

import android.content.Context;
import app.zophop.models.Favourites.BusFavourite;
import app.zophop.models.Favourites.Favourite;
import app.zophop.models.Favourites.RouteStoreType;
import app.zophop.models.Favourites.StopFavourite;
import app.zophop.models.RouteInfo;
import app.zophop.models.Stop;
import app.zophop.models.TransitMode;
import app.zophop.pubsub.eventbus.events.CityChangedEvent;
import app.zophop.pubsub.eventbus.events.DatabaseSyncEvent;
import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import defpackage.ut;
import defpackage.xt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import server.zophop.Constants;

/* renamed from: i30  reason: default package */
/* compiled from: LocalDataManager */
public class i30 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1469a;
    public final xj1 b;
    public Map<TransitMode, HashMap<String, Stop>> c;
    public Map<TransitMode, HashMap<String, JSONObject>> d;
    public Map<TransitMode, HashMap<String, DataSnapshot>> e;
    public List<RouteInfo> f;
    public List<RouteInfo> g;
    public HashMap<String, HashSet<String>> h;

    public i30(Context context, xj1 xj1) {
        this.f1469a = context;
        this.b = xj1;
        o();
        jz5 b2 = jz5.b();
        b2.k(this, b2.e, true, Integer.MAX_VALUE);
    }

    public final void a(String str, TransitMode transitMode) {
        Stop stop;
        if (ui1.W()) {
            try {
                JSONObject jSONObject = ai1.c(this.f1469a, this.b, Constants.STOPS).getJSONObject(transitMode.name().toUpperCase());
                if (jSONObject != null) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(str);
                    try {
                        stop = new Stop(str, jSONObject2.getString("name"), new LatLng(Double.valueOf(jSONObject2.getDouble("lat")).doubleValue(), Double.valueOf(jSONObject2.getDouble("lon")).doubleValue()), transitMode);
                    } catch (JSONException e2) {
                        b00 b00 = b00.f358a;
                        b00.a().b(new Throwable(e2));
                        stop = null;
                    }
                    this.c.get(transitMode).put(str, stop);
                }
            } catch (JSONException e3) {
                b00 b002 = b00.f358a;
                hj1.X0(e3, b00.a());
            }
        } else {
            DataSnapshot b2 = ai1.b(h().child(transitMode.toString().toUpperCase()).child(str));
            if (ai1.a(b2)) {
                this.c.get(transitMode).put(str, new Stop(str, (String) b2.child("name").getValue(), new LatLng(Double.valueOf(Double.parseDouble(b2.child("lat").getValue().toString())).doubleValue(), Double.valueOf(Double.parseDouble(b2.child("lon").getValue().toString())).doubleValue()), transitMode));
                return;
            }
            b00 b003 = b00.f358a;
            c00 a2 = b00.a();
            StringBuilder l0 = hj1.l0("stop not found even in firebase, stop Id =  ", str, " city = ");
            l0.append(xt.f3961a.k().d().getName());
            a2.b(new Throwable(l0.toString()));
        }
    }

    public final DatabaseReference b() {
        ut.a aVar = ut.f3552a;
        return FirebaseDatabase.getInstance().getReference(ut.h);
    }

    public HashSet<String> c(String str) {
        if (this.h.containsKey(str)) {
            return this.h.get(str);
        }
        b00 b00 = b00.f358a;
        c00 a2 = b00.a();
        StringBuilder l0 = hj1.l0("No routes found for stop Id ", str, " in city = ");
        l0.append(xt.f3961a.k().d().getName());
        a2.b(new Throwable(l0.toString()));
        return new HashSet<>();
    }

    public DatabaseReference d() {
        return b().child(xt.f3961a.k().d().getName().toLowerCase()).child(Constants.ROUTES);
    }

    public Stop e(String str, TransitMode transitMode) {
        Stop stop = this.c.get(transitMode).get(str);
        if (stop != null) {
            return stop;
        }
        b00 b00 = b00.f358a;
        c00 a2 = b00.a();
        StringBuilder l0 = hj1.l0("Stop not found, fetching from firebase, stop Id = ", str, " in city = ");
        l0.append(xt.f3961a.k().d().getName());
        a2.b(new Throwable(l0.toString()));
        a(str, transitMode);
        return this.c.get(transitMode).get(str);
    }

    public Stop f(String str, TransitMode transitMode, RouteInfo routeInfo) {
        Stop stop = this.c.get(transitMode).get(str);
        if (stop != null) {
            return stop;
        }
        b00 b00 = b00.f358a;
        c00 a2 = b00.a();
        StringBuilder l0 = hj1.l0("Stop not found, fetching from firebase, stop Id = ", str, " in city = ");
        l0.append(xt.f3961a.k().d().getName());
        l0.append(routeInfo.getRouteId());
        l0.append(routeInfo.getRouteName());
        a2.b(new Throwable(l0.toString()));
        a(str, transitMode);
        return this.c.get(transitMode).get(str);
    }

    public HashMap<String, Stop> g(TransitMode transitMode) {
        if (!TransitMode.ALL.equals(transitMode)) {
            return this.c.get(transitMode);
        }
        System.currentTimeMillis();
        HashMap<String, Stop> hashMap = new HashMap<>();
        for (TransitMode transitMode2 : xt.f3961a.k().d().getModes()) {
            Map<TransitMode, HashMap<String, Stop>> map = this.c;
            if (!(map == null || map.get(transitMode2) == null)) {
                hashMap.putAll(this.c.get(transitMode2));
            }
        }
        System.currentTimeMillis();
        return hashMap;
    }

    public DatabaseReference h() {
        return b().child(xt.f3961a.k().d().getName().toLowerCase()).child(Constants.STOPS);
    }

    public DatabaseReference i() {
        return b().child(xt.f3961a.k().d().getName().toLowerCase()).child("Trips");
    }

    public boolean j() {
        if (ui1.Y()) {
            if (this.f == null || this.c == null || this.h == null || ((this.d == null && this.e == null) || this.g == null)) {
                return false;
            }
            return true;
        } else if (this.f == null || this.c == null || this.h == null || this.g == null) {
            return false;
        } else {
            return true;
        }
    }

    public boolean k() {
        String optString = xt.f3961a.l().h.optString("first_sync_status", null);
        return optString != null && optString.equals(DatabaseSyncEvent.STATUS.DONE.toString());
    }

    public boolean l() {
        if (!(this.c != null) || !k()) {
            return false;
        }
        return true;
    }

    public final void m(Map<TransitMode, HashMap<String, Stop>> map, List list, List list2, HashMap<String, HashSet<String>> hashMap, Map<TransitMode, HashMap<String, JSONObject>> map2, Map<TransitMode, HashMap<String, DataSnapshot>> map3) {
        if (map != null && list != null && hashMap != null) {
            this.c = map;
            this.f = list;
            this.h = hashMap;
            this.g = list2;
            this.d = map2;
            this.e = map3;
        } else if (this.c == null && map != null) {
            this.c = map;
        }
    }

    public final void n(boolean z, String str) {
        new m10(this.f1469a, this.b).g(str, d(), i(), h(), z);
    }

    public void o() {
        xt.t1 t1Var = xt.f3961a;
        if (t1Var.k().d() == null) {
            return;
        }
        if (!k()) {
            t1Var.N().b(true);
            n(true, t1Var.k().d().getName().toLowerCase());
            return;
        }
        n(false, t1Var.k().d().getName().toLowerCase());
    }

    public void onEvent(CityChangedEvent cityChangedEvent) {
        xt.f3961a.l().remove("first_sync_status");
        this.f = null;
        this.c = null;
        this.h = null;
        this.g = null;
        this.d = null;
        o();
    }

    public final void p(boolean z, DatabaseSyncEvent.STATUS status) {
        status.toString();
        if (z) {
            xt.f3961a.l().put("first_sync_status", status.toString());
            return;
        }
        xt.t1 t1Var = xt.f3961a;
        t1Var.l().put("syn_status", status.toString());
        t1Var.N().b(true);
    }

    public void onEvent(DatabaseSyncEvent databaseSyncEvent) {
        HashMap<String, Stop> hashMap;
        xt.t1 t1Var = xt.f3961a;
        if (t1Var.k().d() != null && hj1.B(t1Var).equalsIgnoreCase(databaseSyncEvent.getCityName())) {
            DatabaseSyncEvent.STATUS status = databaseSyncEvent.getStatus();
            status.toString();
            int ordinal = status.ordinal();
            if (ordinal == 0) {
                p(databaseSyncEvent.isFirstTimeSync(), status);
            } else if (ordinal == 1) {
                p(databaseSyncEvent.isFirstTimeSync(), status);
                m(databaseSyncEvent.getStops(), null, null, null, null, null);
            } else if (ordinal == 2) {
                p(databaseSyncEvent.isFirstTimeSync(), status);
                if (ui1.W()) {
                    m(databaseSyncEvent.getStops(), databaseSyncEvent.getRouteInfos(), databaseSyncEvent.getRouteInfoForMode(), databaseSyncEvent.getStopRouteMap(), databaseSyncEvent.getTrips(), null);
                } else {
                    m(databaseSyncEvent.getStops(), databaseSyncEvent.getRouteInfos(), databaseSyncEvent.getRouteInfoForMode(), databaseSyncEvent.getStopRouteMap(), null, databaseSyncEvent.getTripsSnapshot());
                }
                List<RouteInfo> routeInfos = databaseSyncEvent.getRouteInfos();
                try {
                    HashSet hashSet = new HashSet();
                    if (routeInfos != null) {
                        for (RouteInfo routeInfo : routeInfos) {
                            hashSet.add(routeInfo.getRouteId());
                        }
                    }
                    List<Favourite> j = xt.f3961a.r().j(TransitMode.bus, RouteStoreType.RECENT);
                    int i = 0;
                    while (true) {
                        ArrayList arrayList = (ArrayList) j;
                        if (i >= arrayList.size()) {
                            break;
                        }
                        BusFavourite busFavourite = (BusFavourite) arrayList.get(i);
                        if (!hashSet.contains(busFavourite.getRouteId())) {
                            xt.f3961a.r().r(busFavourite, RouteStoreType.RECENT);
                        }
                        i++;
                    }
                } catch (Exception e2) {
                    b00 b00 = b00.f358a;
                    b00.a().b(e2);
                }
                Map<TransitMode, HashMap<String, Stop>> stops = databaseSyncEvent.getStops();
                if (stops != null) {
                    try {
                        List<StopFavourite> c2 = xt.f3961a.b0().c(RouteStoreType.RECENT);
                        if (c2 != null) {
                            for (StopFavourite stopFavourite : c2) {
                                if (stopFavourite != null) {
                                    if (!(stops.containsKey(stopFavourite.getMode()) && (hashMap = stops.get(stopFavourite.getMode())) != null && hashMap.containsKey(stopFavourite.getStop().getId()))) {
                                        xt.f3961a.b0().e(stopFavourite);
                                    }
                                }
                            }
                        }
                    } catch (Exception e3) {
                        b00 b002 = b00.f358a;
                        b00.a().b(e3);
                    }
                }
            } else if (ordinal == 3) {
                p(databaseSyncEvent.isFirstTimeSync(), status);
            }
        }
    }
}
