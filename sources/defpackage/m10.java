package defpackage;

import android.content.Context;
import android.os.Process;
import app.zophop.models.RouteInfo;
import app.zophop.models.Stop;
import app.zophop.models.TransitMode;
import app.zophop.pubsub.eventbus.events.CityChangedEvent;
import app.zophop.pubsub.eventbus.events.DatabaseSyncEvent;
import app.zophop.room.CityDataRepository;
import com.google.firebase.crashlytics.internal.settings.SettingsJsonConstants;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import server.zophop.Constants;
import zophop.models.SPECIAL_FEATURE;

/* renamed from: m10  reason: default package */
/* compiled from: FirebaseCityDataFetcher */
public class m10 {

    /* renamed from: a  reason: collision with root package name */
    public Context f2307a;
    public xj1 b;
    public ExecutorService c = Executors.newSingleThreadExecutor();
    public rv d = new rv();
    public CityDataRepository e;

    /* renamed from: m10$a */
    /* compiled from: FirebaseCityDataFetcher */
    public class a implements Runnable {
        public final /* synthetic */ String f;
        public final /* synthetic */ DatabaseReference g;
        public final /* synthetic */ DatabaseReference h;
        public final /* synthetic */ DatabaseReference i;
        public final /* synthetic */ boolean j;

        public a(String str, DatabaseReference databaseReference, DatabaseReference databaseReference2, DatabaseReference databaseReference3, boolean z) {
            this.f = str;
            this.g = databaseReference;
            this.h = databaseReference2;
            this.i = databaseReference3;
            this.j = z;
        }

        /* JADX WARNING: Removed duplicated region for block: B:136:0x03df  */
        /* JADX WARNING: Removed duplicated region for block: B:86:0x02c5  */
        /* JADX WARNING: Removed duplicated region for block: B:87:0x02d1  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            // Method dump skipped, instructions count: 1012
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.m10.a.run():void");
        }
    }

    public m10(Context context, xj1 xj1) {
        this.f2307a = context;
        this.b = xj1;
        this.e = new CityDataRepository(context);
        jz5 b2 = jz5.b();
        b2.k(this, b2.e, false, 0);
    }

    public final void a(String str, Map<TransitMode, HashMap<String, Stop>> map, boolean z) {
        DatabaseSyncEvent databaseSyncEvent = new DatabaseSyncEvent(DatabaseSyncEvent.STATUS.STOPS_DONE, str);
        databaseSyncEvent.setStops(map);
        Process.getThreadPriority(Process.myTid());
        databaseSyncEvent.setIsFirstTime(z);
        jz5.b().i(databaseSyncEvent);
    }

    public final void b(boolean z, String str, Map<TransitMode, HashMap<String, Stop>> map, List<RouteInfo> list, List<RouteInfo> list2, HashMap<String, HashSet<String>> hashMap, Map<TransitMode, HashMap<String, DataSnapshot>> map2, Map<TransitMode, HashMap<String, JSONObject>> map3, boolean z2) {
        DatabaseSyncEvent databaseSyncEvent;
        if (z) {
            databaseSyncEvent = new DatabaseSyncEvent(DatabaseSyncEvent.STATUS.FAILURE, str);
        } else {
            databaseSyncEvent = new DatabaseSyncEvent(DatabaseSyncEvent.STATUS.DONE, str);
            databaseSyncEvent.setStops(map);
            databaseSyncEvent.setRouteInfos(list);
            databaseSyncEvent.setStopRouteMap(hashMap);
            databaseSyncEvent.setRouteForMode(list2);
            if (ui1.W()) {
                databaseSyncEvent.setTripsObj(map3);
            } else {
                databaseSyncEvent.setTripsSnapshot(map2);
            }
        }
        databaseSyncEvent.setIsFirstTime(z2);
        jz5.b().i(databaseSyncEvent);
    }

    public final boolean c(DataSnapshot dataSnapshot) {
        if (dataSnapshot == null || !dataSnapshot.hasChild("o")) {
            return true;
        }
        ArrayList arrayList = (ArrayList) dataSnapshot.child("o").getValue();
        if (arrayList != null) {
            for (int i = 0; i < arrayList.size(); i++) {
                if (((String) arrayList.get(i)).equalsIgnoreCase(SettingsJsonConstants.APP_KEY)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean d(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.has("o")) {
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("o");
                if (jSONArray != null) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        if (jSONArray.getString(i).equalsIgnoreCase(SettingsJsonConstants.APP_KEY)) {
                            return true;
                        }
                    }
                }
                return false;
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return true;
    }

    public final boolean e(DataSnapshot dataSnapshot) {
        if (dataSnapshot == null || !dataSnapshot.hasChild("o")) {
            return true;
        }
        List list = (List) dataSnapshot.child("o").getValue();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                if (((String) list.get(i)).equalsIgnoreCase(SettingsJsonConstants.APP_KEY)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean f(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.has("o")) {
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("o");
                if (jSONArray != null) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        if (jSONArray.getString(i).equalsIgnoreCase(SettingsJsonConstants.APP_KEY)) {
                            return true;
                        }
                    }
                }
                return false;
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return true;
    }

    public void g(String str, DatabaseReference databaseReference, DatabaseReference databaseReference2, DatabaseReference databaseReference3, boolean z) {
        this.c.shutdownNow();
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        this.c = newSingleThreadExecutor;
        newSingleThreadExecutor.execute(new a(str, databaseReference, databaseReference2, databaseReference3, z));
        DatabaseSyncEvent databaseSyncEvent = new DatabaseSyncEvent(DatabaseSyncEvent.STATUS.STARTED, str);
        databaseSyncEvent.setIsFirstTime(z);
        jz5.b().i(databaseSyncEvent);
    }

    /* JADX WARN: Incorrect args count in method signature: (Lcom/google/firebase/database/DatabaseReference;Ljava/util/List<Lapp/zophop/models/RouteInfo;>;Ljava/util/List<Lapp/zophop/models/RouteInfo;>;Ljava/util/HashMap<Ljava/lang/String;Ljava/util/HashSet<Ljava/lang/String;>;>;Z)Z */
    public final boolean h(DatabaseReference databaseReference, List list, List list2, HashMap hashMap) {
        System.currentTimeMillis();
        if (xt.f3961a.t().b("syncStopsAndRoutesRef") && !ui1.W()) {
            databaseReference.keepSynced(true);
        }
        if (ui1.W()) {
            JSONObject c2 = ai1.c(this.f2307a, this.b, Constants.ROUTES);
            if (c2 != null) {
                Iterator<String> keys = c2.keys();
                while (keys.hasNext()) {
                    try {
                        String next = keys.next();
                        if (next.equalsIgnoreCase(TransitMode.bus.toString())) {
                            i(next, c2.getJSONObject(next), hashMap, list);
                        } else {
                            k(next, c2.getJSONObject(next), hashMap, list2);
                        }
                    } catch (JSONException e2) {
                        b00 b00 = b00.f358a;
                        b00.a().b(e2);
                    }
                }
            }
            return false;
        }
        DataSnapshot b2 = ai1.b(databaseReference);
        System.currentTimeMillis();
        if (!ai1.a(b2)) {
            return false;
        }
        for (DataSnapshot dataSnapshot : b2.getChildren()) {
            if (dataSnapshot.getKey().equalsIgnoreCase(TransitMode.bus.toString())) {
                TransitMode transitMode = TransitMode.getTransitMode(dataSnapshot.getKey());
                for (DataSnapshot dataSnapshot2 : dataSnapshot.getChildren()) {
                    dataSnapshot2.getKey();
                    if (c(dataSnapshot2)) {
                        l(dataSnapshot2, hashMap);
                        list.add(this.d.c(dataSnapshot2, dataSnapshot2.getKey(), transitMode));
                    }
                }
            } else {
                TransitMode transitMode2 = TransitMode.getTransitMode(dataSnapshot.getKey());
                for (DataSnapshot dataSnapshot3 : dataSnapshot.getChildren()) {
                    dataSnapshot3.getKey();
                    if (c(dataSnapshot3)) {
                        l(dataSnapshot3, hashMap);
                        list2.add(this.d.c(dataSnapshot3, dataSnapshot3.getKey(), transitMode2));
                    }
                }
            }
        }
        System.currentTimeMillis();
        return true;
    }

    public final void i(String str, JSONObject jSONObject, HashMap<String, HashSet<String>> hashMap, List<RouteInfo> list) {
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            try {
                String next = keys.next();
                if (d(jSONObject.getJSONObject(next))) {
                    m(next, jSONObject.getJSONObject(next), hashMap);
                    j(next, jSONObject.getJSONObject(next), list, TransitMode.getTransitMode(str));
                }
            } catch (JSONException e2) {
                b00 b00 = b00.f358a;
                hj1.X0(e2, b00.a());
                return;
            }
        }
    }

    public final void j(String str, JSONObject jSONObject, List<RouteInfo> list, TransitMode transitMode) {
        RouteInfo routeInfo;
        String str2;
        Objects.requireNonNull(this.d);
        try {
            String string = jSONObject.getString("name");
            String string2 = jSONObject.getString("ag");
            String string3 = jSONObject.getString("f");
            String string4 = jSONObject.getString("l");
            ArrayList arrayList = new ArrayList(1);
            ArrayList arrayList2 = new ArrayList(1);
            ArrayList arrayList3 = new ArrayList();
            if (jSONObject.has("seq")) {
                JSONArray jSONArray = jSONObject.getJSONArray("seq");
                str2 = "d";
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList3.add(String.valueOf(jSONArray.get(i)));
                }
            } else {
                str2 = "d";
            }
            if (jSONObject.has("sf")) {
                JSONArray jSONArray2 = jSONObject.getJSONArray("sf");
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    arrayList.add(SPECIAL_FEATURE.valueOf(String.valueOf(jSONArray2.get(i2))));
                }
            }
            if (jSONObject.has("spf")) {
                JSONArray jSONArray3 = jSONObject.getJSONArray("spf");
                for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                    arrayList2.add(String.valueOf(jSONArray3.get(i3)));
                }
            }
            boolean z = jSONObject.has("mobileTicketing") ? jSONObject.getBoolean("mobileTicketing") : false;
            boolean z2 = jSONObject.has("mTicketEnabled") ? jSONObject.getBoolean("mTicketEnabled") : false;
            boolean z3 = jSONObject.has("isFreeRide") ? jSONObject.getBoolean("isFreeRide") : false;
            String str3 = "";
            if (jSONObject.has("poly")) {
                str3 = jSONObject.getString("poly");
            }
            routeInfo = new RouteInfo(str, transitMode, string, string3, string4, string4, string2, arrayList, arrayList2, arrayList3, z, z2, z3, jSONObject.has("routePassEnabled") ? jSONObject.getBoolean("routePassEnabled") : false, str3);
            if (jSONObject.has("availabilityLevel")) {
                routeInfo.set_availabilityLevel(jSONObject.getLong("availabilityLevel"));
            }
            if (jSONObject.has("so")) {
                routeInfo.set_seatOccupancy(jSONObject.getInt("so"));
            }
            if (jSONObject.has(str2)) {
                routeInfo.set_isRouteDisrupted(jSONObject.getBoolean(str2));
            }
        } catch (JSONException e2) {
            b00 b00 = b00.f358a;
            hj1.X0(e2, b00.a());
            routeInfo = null;
        }
        list.add(routeInfo);
    }

    public final void k(String str, JSONObject jSONObject, HashMap<String, HashSet<String>> hashMap, List<RouteInfo> list) {
        TransitMode transitMode = TransitMode.getTransitMode(str);
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            try {
                String next = keys.next();
                if (d(jSONObject.getJSONObject(next))) {
                    m(next, jSONObject.getJSONObject(next), hashMap);
                    j(next, jSONObject.getJSONObject(next), list, transitMode);
                }
            } catch (JSONException e2) {
                b00 b00 = b00.f358a;
                hj1.X0(e2, b00.a());
                return;
            }
        }
    }

    public final void l(DataSnapshot dataSnapshot, HashMap<String, HashSet<String>> hashMap) {
        ArrayList<String> p = xt.f3961a.U().p(dataSnapshot);
        if (p != null) {
            for (String str : p) {
                if (hashMap.containsKey(str)) {
                    hashMap.get(str).add(dataSnapshot.getKey());
                } else {
                    HashSet<String> hashSet = new HashSet<>();
                    hashSet.add(dataSnapshot.getKey());
                    hashMap.put(str, hashSet);
                }
            }
        }
    }

    public final void m(String str, JSONObject jSONObject, HashMap<String, HashSet<String>> hashMap) {
        Objects.requireNonNull(xt.f3961a.U());
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("seq");
            if (jSONArray != null) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(String.valueOf(jSONArray.get(i)));
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
            b00 b00 = b00.f358a;
            hj1.X0(e2, b00.a());
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            if (hashMap.containsKey(str2)) {
                hashMap.get(str2).add(str);
            } else {
                HashSet<String> hashSet = new HashSet<>();
                hashSet.add(str);
                hashMap.put(str2, hashSet);
            }
        }
    }

    public void onEvent(CityChangedEvent cityChangedEvent) {
        ai1.f166a.clear();
        this.e.removeCityData();
    }
}
