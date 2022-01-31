package defpackage;

import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Pair;
import app.zophop.models.LiveFeed;
import app.zophop.models.Route;
import app.zophop.models.RouteInfo;
import app.zophop.models.Stop;
import app.zophop.models.TimeInterval;
import app.zophop.models.TransitMode;
import app.zophop.models.mTicketing.ProductDiscountsObject;
import app.zophop.pubsub.eventbus.events.LiveFeedDetailsEvent;
import app.zophop.pubsub.eventbus.events.RouteDetailsEvent;
import com.google.firebase.database.DataSnapshot;
import defpackage.n00;
import defpackage.xt;
import defpackage.yj1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import zophop.models.SPECIAL_FEATURE;

/* renamed from: v40  reason: default package */
/* compiled from: RouteFeature */
public class v40 {
    public static final String d = ut.n;

    /* renamed from: a  reason: collision with root package name */
    public final xj1 f3592a;
    public List<RouteInfo> b;
    public final rv c;

    /* renamed from: v40$a */
    /* compiled from: RouteFeature */
    public class a implements n00.z0 {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f3593a;

        public a(v40 v40, String str) {
            this.f3593a = str;
        }

        @Override // defpackage.n00.z0
        public void a(dk1 dk1) {
            jz5.b().i(new RouteDetailsEvent(ad1.FAILED, this.f3593a, null));
        }
    }

    /* renamed from: v40$b */
    /* compiled from: RouteFeature */
    public class b implements yj1.b<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f3594a;
        public final /* synthetic */ n00.z0 b;

        public b(String str, n00.z0 z0Var) {
            this.f3594a = str;
            this.b = z0Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.yj1.b
        public void a(JSONObject jSONObject) {
            try {
                Route b2 = v40.this.c.b(jSONObject);
                if (v40.a(v40.this, b2)) {
                    b2.setLive(false);
                }
                jz5.b().i(new RouteDetailsEvent(ad1.SUCCESS, this.f3594a, b2));
            } catch (JSONException unused) {
                this.b.a(new dk1("malformed json"));
            }
        }
    }

    static {
        String str = ut.d;
    }

    /* JADX WARN: Incorrect args count in method signature: (Lxj1;Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;Landroid/content/Context;)V */
    public v40(xj1 xj1, Map map) {
        this.f3592a = xj1;
        rv rvVar = new rv();
        this.c = rvVar;
        try {
            String optString = ((sf1) map).h.optString(ProductDiscountsObject.KEY_ROUTES, null);
            if (optString != null) {
                this.b = rvVar.d(new JSONArray(optString));
            }
        } catch (JSONException unused) {
        }
    }

    public static boolean a(v40 v40, Route route) {
        Objects.requireNonNull(v40);
        if (ui1.E0()) {
            return !route.isLive();
        }
        return false;
    }

    public static void b(v40 v40, String str, JSONObject jSONObject) {
        Objects.requireNonNull(v40);
        try {
            v40.r(str, new nv().a(jSONObject), ad1.SUCCESS);
        } catch (JSONException unused) {
            v40.r(str, null, ad1.FAILED);
        }
    }

    public void c(String str, TransitMode transitMode, String str2) {
        xt.t1 t1Var = xt.f3961a;
        String B = hj1.B(t1Var);
        if (!B.equalsIgnoreCase(str2)) {
            f(str, str2);
        } else if (!t1Var.A().j()) {
            f(str, B);
        } else {
            HandlerThread handlerThread = new HandlerThread("route details");
            handlerThread.start();
            Handler handler = new Handler(handlerThread.getLooper());
            handler.post(new l40(this, transitMode, str, handler));
        }
    }

    public void d(String str, String str2) {
        xt.t1 t1Var = xt.f3961a;
        String B = hj1.B(t1Var);
        if (B.equalsIgnoreCase(str2)) {
            str2 = B;
        }
        Uri.Builder builder = new Uri.Builder();
        if (str2 == null) {
            str2 = hj1.B(t1Var);
        }
        builder.encodedPath(ut.d).appendPath(str2).appendPath("routedetailslive").appendQueryParameter("route_id", str).appendQueryParameter("day", vn.I()).appendQueryParameter("meta", ui1.K0().toString());
        String uri = builder.build().toString();
        t40 t40 = new t40(this, str);
        d70 d70 = new d70(uri, null, new u40(this, str, t40), t40);
        d70.n = false;
        this.f3592a.a(d70);
    }

    public final String e(String str, TransitMode transitMode, String str2, String str3) {
        Uri.Builder builder = new Uri.Builder();
        builder.encodedPath(d).appendPath(str).appendPath(transitMode.toString()).appendPath(str2).appendPath(str3).appendQueryParameter("meta", ui1.K0().toString());
        return builder.build().toString();
    }

    public final void f(String str, String str2) {
        Uri.Builder builder = new Uri.Builder();
        if (str2 == null) {
            str2 = hj1.B(xt.f3961a);
        }
        builder.encodedPath(ut.d).appendPath(str2).appendPath("routedetails").appendQueryParameter("route_id", str).appendQueryParameter("day", vn.I()).appendQueryParameter("meta", ui1.K0().toString());
        String uri = builder.build().toString();
        a aVar = new a(this, str);
        d70 d70 = new d70(uri, null, new b(str, aVar), aVar);
        d70.n = true;
        this.f3592a.a(d70);
    }

    public Route g(RouteInfo routeInfo, JSONObject jSONObject, TransitMode transitMode) {
        Route.RouteTiming l;
        transitMode.toString().toLowerCase();
        ArrayList<Stop> o = o(routeInfo.getStopSeq(), transitMode, routeInfo);
        ArrayList arrayList = new ArrayList();
        int D0 = vn.D0();
        if (jSONObject.optJSONObject("Trips") != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("Trips");
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                try {
                    String next = keys.next();
                    JSONObject jSONObject2 = optJSONObject.getJSONObject(next);
                    if (ii1.t(jSONObject2.getString("wd"), D0) && (l = l(jSONObject2, next)) != null) {
                        arrayList.add(l);
                    }
                } catch (JSONException e) {
                    b00 b00 = b00.f358a;
                    hj1.X0(e, b00.a());
                }
            }
        }
        if (jSONObject.optJSONObject("ft") != null) {
            try {
                JSONObject jSONObject3 = jSONObject.getJSONObject("ft");
                Iterator<String> keys2 = jSONObject3.keys();
                while (true) {
                    if (!keys2.hasNext()) {
                        break;
                    }
                    String next2 = keys2.next();
                    if (ii1.t(next2, D0)) {
                        JSONObject jSONObject4 = jSONObject3.getJSONObject(next2);
                        JSONArray optJSONArray = jSONObject4.optJSONArray("fd");
                        if (optJSONArray == null) {
                            break;
                        }
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            Route.RouteTiming k = k(optJSONArray.getJSONObject(i));
                            k.duration = Integer.parseInt(jSONObject4.getString("d"));
                            arrayList.add(k);
                        }
                    }
                }
            } catch (JSONException e2) {
                b00 b002 = b00.f358a;
                hj1.X0(e2, b00.a());
            }
        }
        Collections.sort(arrayList, new m40());
        Route route = new Route(routeInfo, o, o.get(o.size() - 1), arrayList);
        int optInt = jSONObject.optInt("ttStatus", 0);
        if (!x61.r(optInt)) {
            optInt = x61.o(optInt);
        }
        int optInt2 = jSONObject.optInt("ttSid", 0);
        route.setTtStatus(optInt);
        route.setTtStatusId(optInt2);
        return route;
    }

    public Route h(DataSnapshot dataSnapshot, DataSnapshot dataSnapshot2, TransitMode transitMode) {
        transitMode.toString().toLowerCase();
        RouteInfo i = i(dataSnapshot, transitMode);
        DataSnapshot child = dataSnapshot.child("seq");
        ArrayList arrayList = new ArrayList((int) child.getChildrenCount());
        i30 A = xt.f3961a.A();
        for (DataSnapshot dataSnapshot3 : child.getChildren()) {
            arrayList.add(Integer.parseInt(dataSnapshot3.getKey()), A.f(dataSnapshot3.getValue().toString(), transitMode, i));
        }
        List<Route.RouteTiming> m = m(dataSnapshot2);
        Collections.sort(m, new m40());
        boolean z = true;
        Route route = new Route(i, arrayList, (Stop) arrayList.get(arrayList.size() - 1), m);
        if (dataSnapshot.hasChild("availabilityLevel")) {
            route.setAvailabilityStatus(((Long) dataSnapshot.child("availabilityLevel").getValue()).longValue());
        }
        if (dataSnapshot.hasChild("d")) {
            route.setDisruption(((Boolean) dataSnapshot.child("d").getValue()).booleanValue());
        }
        if (dataSnapshot.hasChild("so")) {
            route.setSeatAvailability((int) ((Long) dataSnapshot.child("so").getValue()).longValue());
        }
        if (ui1.E0() && dataSnapshot.child("il").exists()) {
            z = ((Boolean) dataSnapshot.child("il").getValue()).booleanValue();
        }
        if (!z) {
            route.setLive(false);
        }
        return route;
    }

    public RouteInfo i(DataSnapshot dataSnapshot, TransitMode transitMode) {
        String str;
        String str2;
        try {
            return this.c.c(dataSnapshot, dataSnapshot.getKey(), transitMode);
        } catch (Exception unused) {
            String B = hj1.B(xt.f3961a);
            if (dataSnapshot == null) {
                str = "";
                str2 = "routeSnap is null";
            } else {
                String dataSnapshot2 = dataSnapshot.toString();
                str2 = dataSnapshot.getKey();
                str = dataSnapshot2;
            }
            b00 b00 = b00.f358a;
            c00 a2 = b00.a();
            StringBuilder l0 = hj1.l0("error while processing routeId ", B, " ");
            l0.append(transitMode.toString());
            l0.append(" ");
            l0.append(str2);
            l0.append("  ");
            l0.append(str);
            a2.b(new Throwable(l0.toString()));
            return null;
        }
    }

    public DataSnapshot j(String str, TransitMode transitMode) {
        return ai1.b(xt.f3961a.A().d().child(transitMode.toString().toUpperCase()).child(str));
    }

    public final Route.RouteTiming k(JSONObject jSONObject) throws JSONException {
        return new Route.RouteTiming(new Pair(new TimeInterval(Integer.valueOf((int) Long.parseLong(jSONObject.getString("s"))), Integer.valueOf((int) Long.parseLong(jSONObject.getString("e")))), Integer.valueOf((int) Long.parseLong(jSONObject.getString("f")))));
    }

    public final Route.RouteTiming l(JSONObject jSONObject, String str) throws JSONException {
        long parseLong = !TextUtils.isEmpty(jSONObject.optString("d")) ? Long.parseLong(jSONObject.getString("d")) : -1;
        if (!TextUtils.isEmpty(jSONObject.optString("st"))) {
            Route.RouteTiming routeTiming = new Route.RouteTiming((int) Long.parseLong(jSONObject.getString("st")), str);
            routeTiming.duration = (int) parseLong;
            return routeTiming;
        } else if (jSONObject.optJSONObject("tt") == null) {
            return null;
        } else {
            Route.RouteTiming routeTiming2 = new Route.RouteTiming((int) Long.parseLong(jSONObject.getJSONObject("tt").optString("s")), str);
            routeTiming2.duration = (int) parseLong;
            return routeTiming2;
        }
    }

    public final List<Route.RouteTiming> m(DataSnapshot dataSnapshot) {
        Route.RouteTiming routeTiming;
        ArrayList arrayList = new ArrayList();
        int D0 = vn.D0();
        if (dataSnapshot.hasChild("Trips")) {
            Iterator q0 = hj1.q0(dataSnapshot, "Trips");
            while (q0.hasNext()) {
                DataSnapshot dataSnapshot2 = (DataSnapshot) q0.next();
                if (ii1.t((String) dataSnapshot2.child("wd").getValue(), D0)) {
                    long parseLong = dataSnapshot2.hasChild("d") ? Long.parseLong(dataSnapshot2.child("d").getValue().toString()) : -1;
                    if (dataSnapshot2.hasChild("st")) {
                        routeTiming = new Route.RouteTiming((int) Long.parseLong(dataSnapshot2.child("st").getValue().toString()), dataSnapshot2.getKey());
                        routeTiming.duration = (int) parseLong;
                    } else if (dataSnapshot2.hasChild("tt")) {
                        routeTiming = new Route.RouteTiming((int) Long.parseLong(dataSnapshot2.child("tt").child("s").getValue().toString()), dataSnapshot2.getKey());
                        routeTiming.duration = (int) parseLong;
                    } else {
                        routeTiming = null;
                    }
                    if (routeTiming != null) {
                        arrayList.add(routeTiming);
                    }
                }
            }
        }
        if (dataSnapshot.hasChild("ft")) {
            Iterator q02 = hj1.q0(dataSnapshot, "ft");
            while (q02.hasNext()) {
                DataSnapshot dataSnapshot3 = (DataSnapshot) q02.next();
                if (ii1.t(dataSnapshot3.getKey(), D0)) {
                    Iterator q03 = hj1.q0(dataSnapshot3, "fd");
                    while (q03.hasNext()) {
                        DataSnapshot dataSnapshot4 = (DataSnapshot) q03.next();
                        Route.RouteTiming routeTiming2 = new Route.RouteTiming(new Pair(new TimeInterval(Integer.valueOf((int) Long.parseLong(dataSnapshot4.child("s").getValue().toString())), Integer.valueOf((int) Long.parseLong(dataSnapshot4.child("e").getValue().toString()))), Integer.valueOf((int) Long.parseLong(dataSnapshot4.child("f").getValue().toString()))));
                        routeTiming2.duration = Integer.parseInt(dataSnapshot3.child("d").getValue().toString());
                        arrayList.add(routeTiming2);
                    }
                }
            }
        }
        return arrayList;
    }

    public List<SPECIAL_FEATURE> n(DataSnapshot dataSnapshot) {
        if (!dataSnapshot.hasChild("sf")) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator q0 = hj1.q0(dataSnapshot, "sf");
        while (q0.hasNext()) {
            arrayList.add(SPECIAL_FEATURE.valueOf(((DataSnapshot) q0.next()).getValue().toString()));
        }
        return arrayList;
    }

    public final ArrayList<Stop> o(List<String> list, TransitMode transitMode, RouteInfo routeInfo) {
        ArrayList<Stop> arrayList = new ArrayList<>(list.size());
        i30 A = xt.f3961a.A();
        for (String str : list) {
            arrayList.add(A.f(str, transitMode, routeInfo));
        }
        return arrayList;
    }

    public ArrayList<String> p(DataSnapshot dataSnapshot) {
        return (ArrayList) dataSnapshot.child("seq").getValue();
    }

    public JSONObject q(String str, TransitMode transitMode) {
        i30 A = xt.f3961a.A();
        HashMap hashMap = new HashMap();
        Map<TransitMode, HashMap<String, JSONObject>> map = A.d;
        if (map != null) {
            hashMap.putAll(map.get(transitMode));
        }
        return (JSONObject) hashMap.get(str);
    }

    public final void r(String str, LiveFeed liveFeed, ad1 ad1) {
        jz5.b().i(new LiveFeedDetailsEvent(str, liveFeed, ad1));
    }
}
