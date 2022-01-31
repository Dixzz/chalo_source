package defpackage;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import app.zophop.models.RouteInfo;
import app.zophop.models.Stop;
import app.zophop.models.TransitMode;
import app.zophop.models.UniversalSearchItem;
import app.zophop.models.mTicketing.ProductDiscountsObject;
import app.zophop.models.mTicketing.ProductPromotionsObject;
import app.zophop.models.mTicketing.digitalTripReceipt.DigitalTripReceiptJsonKeys;
import app.zophop.pubsub.eventbus.events.TripPlannerEvent;
import app.zophop.pubsub.eventbus.events.UniversalSearchResponseEvent;
import defpackage.k30;
import defpackage.xt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: q50  reason: default package */
/* compiled from: UniversalSearchFeature */
public class q50 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f2897a;
    public final xj1 b;
    public final n50 c = new n50();
    public final Handler d = new Handler(Looper.getMainLooper());
    public final Handler e;
    public wj1 f;

    /* renamed from: q50$a */
    /* compiled from: UniversalSearchFeature */
    public class a implements Runnable {
        public a() {
        }

        public void run() {
            q50 q50 = q50.this;
            q50.b.a(q50.f);
        }
    }

    /* renamed from: q50$b */
    /* compiled from: UniversalSearchFeature */
    public class b implements Runnable {
        public final /* synthetic */ String f;
        public final /* synthetic */ long g;
        public final /* synthetic */ Exception h;
        public final /* synthetic */ String i;

        public b(String str, long j2, Exception exc, String str2) {
            this.f = str;
            this.g = j2;
            this.h = exc;
            this.i = str2;
        }

        public void run() {
            q50.a(q50.this, this.f, this.g, this.h.getMessage(), this.i);
        }
    }

    /* renamed from: q50$c */
    /* compiled from: UniversalSearchFeature */
    public class c implements k30.a<Stop> {
        public c(q50 q50) {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.k30.a
        public String a(Stop stop) {
            return stop.getName();
        }
    }

    /* renamed from: q50$d */
    /* compiled from: UniversalSearchFeature */
    public class d implements k30.a<RouteInfo> {
        public d(q50 q50) {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.k30.a
        public String a(RouteInfo routeInfo) {
            return routeInfo.getRouteName();
        }
    }

    public q50(Context context, xj1 xj1) {
        this.f2897a = context;
        this.b = xj1;
        HandlerThread handlerThread = new HandlerThread(ProductPromotionsObject.KEY_BACKGROUND);
        handlerThread.start();
        this.e = new Handler(handlerThread.getLooper());
    }

    public static void a(q50 q50, String str, long j, String str2, String str3) {
        Objects.requireNonNull(q50);
        UniversalSearchResponseEvent universalSearchResponseEvent = new UniversalSearchResponseEvent(new ArrayList(), str, TripPlannerEvent.ResponseType.FAILED, str3);
        universalSearchResponseEvent.setErrorMessage(str2);
        universalSearchResponseEvent.setQueryTimeMillis(System.currentTimeMillis() - j);
        jz5.b().i(universalSearchResponseEvent);
    }

    public static void b(q50 q50, JSONObject jSONObject, String str, long j, String str2) throws Exception {
        String str3;
        String optString;
        n50 n50 = q50.c;
        String jSONObject2 = jSONObject.toString();
        Objects.requireNonNull(n50);
        System.currentTimeMillis();
        JSONObject jSONObject3 = new JSONObject(jSONObject2);
        JSONArray jSONArray = jSONObject3.getJSONArray(ProductDiscountsObject.KEY_ROUTES);
        JSONArray jSONArray2 = jSONObject3.getJSONArray("places");
        JSONArray jSONArray3 = jSONObject3.getJSONArray("stops");
        JSONObject optJSONObject = jSONObject3.optJSONObject(DigitalTripReceiptJsonKeys.KEY_TRIPS);
        List<UniversalSearchItem> arrayList = new ArrayList<>();
        List<UniversalSearchItem> arrayList2 = new ArrayList<>();
        if (!(optJSONObject == null || (optString = optJSONObject.optString("source")) == null)) {
            if (optString.equals("google")) {
                arrayList = n50.c(UniversalSearchItem.UniversalSearchItemType.TRIPS_LOCATIONS, optJSONObject.getJSONArray("data"));
            } else if (optString.equals("database")) {
                arrayList2 = n50.c(UniversalSearchItem.UniversalSearchItemType.TRIPS_STOPS, optJSONObject.getJSONArray("data"));
            }
        }
        ArrayList arrayList3 = new ArrayList();
        List<UniversalSearchItem> c2 = n50.c(UniversalSearchItem.UniversalSearchItemType.ROUTE, jSONArray);
        List<UniversalSearchItem> c3 = n50.c(UniversalSearchItem.UniversalSearchItemType.STOP, jSONArray3);
        List<UniversalSearchItem> c4 = n50.c(UniversalSearchItem.UniversalSearchItemType.LOCATION, jSONArray2);
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        ArrayList arrayList7 = new ArrayList();
        Iterator it = ((ArrayList) c4).iterator();
        while (it.hasNext()) {
            UniversalSearchItem universalSearchItem = (UniversalSearchItem) it.next();
            md1 md1 = (md1) universalSearchItem.getData();
            String str4 = md1.f2356a;
            int indexOf = str4.indexOf(",");
            if (indexOf != -1) {
                str3 = str4.substring(0, indexOf).trim();
            } else {
                str3 = str4.trim();
            }
            if (str3.toLowerCase().equals(str.toLowerCase())) {
                arrayList7.add(universalSearchItem);
            } else if (md1.f2356a.toLowerCase().startsWith(str.toLowerCase())) {
                arrayList4.add(universalSearchItem);
            } else {
                arrayList6.add(universalSearchItem);
            }
        }
        ArrayList arrayList8 = new ArrayList();
        Iterator it2 = ((ArrayList) c3).iterator();
        while (it2.hasNext()) {
            UniversalSearchItem universalSearchItem2 = (UniversalSearchItem) it2.next();
            Stop stop = (Stop) universalSearchItem2.getData();
            if (stop.getName().toLowerCase().equals(str.toLowerCase())) {
                arrayList7.add(universalSearchItem2);
            } else if (stop.getName().toLowerCase().startsWith(str.toLowerCase())) {
                arrayList8.add(universalSearchItem2);
            } else {
                arrayList5.add(universalSearchItem2);
            }
        }
        arrayList3.addAll(c2);
        arrayList3.addAll(arrayList7);
        arrayList3.addAll(arrayList8);
        arrayList3.addAll(arrayList4);
        arrayList3.addAll(arrayList5);
        arrayList3.addAll(arrayList6);
        arrayList3.addAll(arrayList2);
        arrayList3.addAll(arrayList);
        System.currentTimeMillis();
        UniversalSearchResponseEvent universalSearchResponseEvent = new UniversalSearchResponseEvent(arrayList3, str, TripPlannerEvent.ResponseType.SUCCESS, str2);
        universalSearchResponseEvent.setQueryTimeMillis(System.currentTimeMillis() - j);
        jz5.b().i(universalSearchResponseEvent);
    }

    public final void c(List list, List<UniversalSearchItem> list2, UniversalSearchItem.UniversalSearchItemType universalSearchItemType) {
        int i = 0;
        for (Object obj : list) {
            if (i < Integer.MAX_VALUE) {
                list2.add(new UniversalSearchItem(universalSearchItemType, obj));
                i++;
            } else {
                return;
            }
        }
    }

    public final String d(String str, Map<String, String> map) {
        if (str == null) {
            return null;
        }
        Uri.Builder encodedPath = new Uri.Builder().encodedPath(str);
        for (String str2 : map.keySet()) {
            if (!(str2 == null || map.get(str2) == null)) {
                encodedPath.appendQueryParameter(str2, map.get(str2));
            }
        }
        return encodedPath.build().toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00a4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<app.zophop.models.UniversalSearchItem> e(java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20) {
        /*
        // Method dump skipped, instructions count: 170
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.q50.e(java.lang.String, java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    public List<UniversalSearchItem> f(String str) {
        xt.t1 t1Var = xt.f3961a;
        if (!t1Var.A().j()) {
            return new ArrayList();
        }
        List<RouteInfo> g = g(str);
        List a2 = new k30().a(str, new ArrayList(t1Var.A().g(TransitMode.ALL).values()), new c(this));
        ArrayList arrayList = new ArrayList();
        c(g, arrayList, UniversalSearchItem.UniversalSearchItemType.ROUTE);
        c(a2, arrayList, UniversalSearchItem.UniversalSearchItemType.STOP);
        return arrayList;
    }

    public final List<RouteInfo> g(String str) {
        if (ui1.Y()) {
            return new ArrayList();
        }
        List<RouteInfo> list = xt.f3961a.A().f;
        k30 k30 = new k30();
        d dVar = new d(this);
        String lowerCase = str.toLowerCase();
        ArrayList arrayList = new ArrayList();
        for (RouteInfo routeInfo : list) {
            if (dVar.a(routeInfo).toLowerCase().startsWith(lowerCase)) {
                arrayList.add(routeInfo);
            }
        }
        Collections.sort(arrayList, new j30(k30, dVar));
        return arrayList;
    }
}
