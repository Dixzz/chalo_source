package defpackage;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import app.zophop.models.CardInfo;
import app.zophop.models.DismissConditions;
import app.zophop.models.GeoElement;
import app.zophop.models.HeaderObj;
import app.zophop.models.LiveTripInfo;
import app.zophop.models.mTicketing.ProductPromotionsObject;
import app.zophop.pubsub.eventbus.events.CardInfoFetchEvent;
import com.firebase.geofire.GeoLocation;
import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.crashlytics.internal.settings.SettingsJsonConstants;
import com.google.gson.Gson;
import com.razorpay.AnalyticsConstants;
import defpackage.n00;
import defpackage.xt;
import defpackage.yj1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import server.zophop.models.GeoRealTimeInfo;

/* renamed from: b20  reason: default package */
/* compiled from: GeoSpatialRequestHandlerWithPolling */
public class b20 {
    public static final Object w = new Object();

    /* renamed from: a  reason: collision with root package name */
    public HandlerThread f367a;
    public final Runnable b = new a20(this);
    public final String c;
    public LatLng d;
    public final double e;
    public Handler f;
    public final xj1 g;
    public final String h = ut.y;
    public boolean i = true;
    public Map<String, GeoElement> j = new HashMap();
    public long k;
    public final long l;
    public final long m;
    public final long n;
    public int o;
    public Context p;
    public String q;
    public boolean r;
    public boolean s;
    public boolean t;
    public final rf1 u;
    public boolean v;

    /* renamed from: b20$a */
    /* compiled from: GeoSpatialRequestHandlerWithPolling */
    public class a implements n00.z0 {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LatLng f368a;

        public a(LatLng latLng) {
            this.f368a = latLng;
        }

        @Override // defpackage.n00.z0
        public void a(dk1 dk1) {
            LatLng latLng;
            b20 b20 = b20.this;
            rf1 rf1 = b20.u;
            xt.t1 t1Var = xt.f3961a;
            if (rf1.a(t1Var.k().d().getName().toLowerCase())) {
                String f = b20.u.f(t1Var.k().d().getName().toLowerCase(), null);
                if (!TextUtils.isEmpty(f)) {
                    try {
                        if (!b20.v) {
                            b20.m(f);
                            b20.v = true;
                        }
                    } catch (JSONException e) {
                        b00 b00 = b00.f358a;
                        hj1.W0(e);
                    }
                }
            }
            b20 b202 = b20.this;
            if (b202.i && (latLng = b202.d) != null && latLng.equals(this.f368a)) {
                dk1.getMessage();
                b20.this.h(true, false);
            }
        }
    }

    /* renamed from: b20$b */
    /* compiled from: GeoSpatialRequestHandlerWithPolling */
    public class b implements yj1.b<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LatLng f369a;
        public final /* synthetic */ ni1 b;
        public final /* synthetic */ String c;

        public b(LatLng latLng, ni1 ni1, String str) {
            this.f369a = latLng;
            this.b = ni1;
            this.c = str;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.yj1.b
        public void a(JSONObject jSONObject) {
            LatLng latLng;
            JSONObject jSONObject2 = jSONObject;
            b20 b20 = b20.this;
            if (b20.i && (latLng = b20.d) != null && latLng.equals(this.f369a)) {
                int i = 0;
                if (0 < this.b.f2559a) {
                    HashMap hashMap = new HashMap();
                    ni1 ni1 = this.b;
                    long j = ni1.f2559a;
                    if (0 < j) {
                        i = ni1.a(j);
                    }
                    hashMap.put("response time", String.valueOf(i));
                    hashMap.put("network type", vn.Y(b20.this.p));
                    this.b.b("geo spatial request response time", hashMap);
                    ni1 ni12 = this.b;
                    ni12.f2559a = 0;
                    ni12.b = 0;
                }
                try {
                    b20.a(b20.this, jSONObject2, this.c);
                } catch (Exception e) {
                    e.getMessage();
                    b00 b00 = b00.f358a;
                    b00.a().b(e);
                }
                b20.this.h(true, true);
            }
        }
    }

    public b20(Context context, xj1 xj1, String str, LatLng latLng, double d2, int i2) {
        this.c = str;
        this.d = latLng;
        this.e = d2;
        this.g = xj1;
        this.p = context;
        xt.t1 t1Var = xt.f3961a;
        long c2 = t1Var.t().c("geoSpatialPollingDelayInMillis");
        this.l = c2;
        this.m = t1Var.t().c("geoSpatialPollingDelayStepCount");
        this.n = t1Var.t().c("geoSpatialInitialRequestBurst");
        this.o = i2;
        this.u = new rf1(context, "cardInfo");
        this.r = false;
        this.s = false;
        this.k = c2;
        HandlerThread handlerThread = new HandlerThread(hj1.S("geoSpatialThread", str));
        this.f367a = handlerThread;
        handlerThread.start();
        this.f = new Handler(this.f367a.getLooper());
        b();
    }

    /* JADX WARNING: Removed duplicated region for block: B:125:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x02ab  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x02e5  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0366  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(defpackage.b20 r21, org.json.JSONObject r22, java.lang.String r23) {
        /*
        // Method dump skipped, instructions count: 1089
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.b20.a(b20, org.json.JSONObject, java.lang.String):void");
    }

    public final void b() {
        synchronized (w) {
            if (this.d != null) {
                LatLng latLng = this.d;
                LatLng latLng2 = new LatLng(latLng.latitude, latLng.longitude);
                String lowerCase = xt.f3961a.k().d().getName().toLowerCase();
                ni1 ni1 = new ni1();
                a aVar = new a(latLng2);
                d70 d70 = new d70(g(lowerCase), this.q, (yj1.b<JSONObject>) new b(latLng2, ni1, lowerCase), (n00.z0) aVar, true);
                if (this.t) {
                    long currentTimeMillis = System.currentTimeMillis();
                    ni1.f2559a = currentTimeMillis;
                    ni1.b = currentTimeMillis;
                }
                d70.n = false;
                d70.s = f();
                d70.q = new nj1(10000, 1, 0.25f);
                this.g.a(d70);
            }
        }
    }

    public final GeoElement c(JSONObject jSONObject) throws JSONException {
        GeoRealTimeInfo geoRealTimeInfo = (GeoRealTimeInfo) new Gson().fromJson(jSONObject.getString(SettingsJsonConstants.SESSION_KEY), GeoRealTimeInfo.class);
        String streamId = geoRealTimeInfo.getStreamId();
        String string = jSONObject.getString("parameters");
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject2 = new JSONObject(string);
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject2.getString(next));
            }
        } catch (JSONException e2) {
            b00 b00 = b00.f358a;
            hj1.W0(e2);
        }
        double parseDouble = Double.parseDouble(hashMap.get("lat").toString());
        double parseDouble2 = Double.parseDouble(hashMap.get("lon").toString());
        hashMap.remove("lat");
        hashMap.remove("lon");
        return new GeoElement(jSONObject.getString(SettingsJsonConstants.SESSION_KEY), streamId, geoRealTimeInfo, new GeoLocation(parseDouble, parseDouble2, hashMap));
    }

    public final LiveTripInfo d(GeoElement geoElement) {
        return new LiveTripInfo(geoElement.getStreamId(), geoElement.getGeoRealTimeInfo().getRouteId(), geoElement.getGeoLocation(), geoElement.getGeoRealTimeInfo(), geoElement.getKey());
    }

    public final ProductPromotionsObject e(JSONObject jSONObject, boolean z) {
        xt.t1 t1Var = xt.f3961a;
        if (t1Var.k().d() == null) {
            return null;
        }
        ProductPromotionsObject t2 = t1Var.c().t(ProductPromotionsObject.KEY_DEFAULT_USER, jSONObject.toString(), z);
        t1Var.c().t(ProductPromotionsObject.KEY_NEW_USER, jSONObject.toString(), z);
        t1Var.c().t(ProductPromotionsObject.KEY_REPEAT_USER, jSONObject.toString(), z);
        return t2;
    }

    public final String f() {
        StringBuilder i0 = hj1.i0("gqp");
        i0.append(this.c);
        return i0.toString();
    }

    public final String g(String str) {
        String str2;
        String userId;
        this.t = this.o == 1;
        Uri.Builder builder = new Uri.Builder();
        builder.encodedPath(this.h).appendEncodedPath("nearbybus").appendEncodedPath("v2").appendEncodedPath("city").appendEncodedPath(str);
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            xt.t1 t1Var = xt.f3961a;
            String a2 = t1Var.n().a();
            jSONObject2.put(AnalyticsConstants.LOCALE, t1Var.z().b());
            jSONObject2.put("appVer", 764);
            jSONObject2.put("deviceId", a2);
            if (t1Var.L().m() && (userId = t1Var.L().getUserId()) != null) {
                jSONObject2.put("userId", userId);
            }
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("lat", String.valueOf(this.d.latitude));
            jSONObject4.put("lng", String.valueOf(this.d.longitude));
            jSONObject4.put("radius", String.valueOf(this.e));
            jSONObject3.put("nearbyBuses", jSONObject4);
            if (this.o == 1) {
                Object jSONObject5 = new JSONObject();
                jSONObject3.put("cityInfo", jSONObject5);
                jSONObject3.put("cardsInfo", jSONObject5);
            }
            i(jSONObject3);
            j(jSONObject3, str);
            l(jSONObject3, str);
            k(jSONObject3, str);
            jSONObject.put("metaData", jSONObject2);
            jSONObject.put("requiredFields", jSONObject3);
            str2 = jSONObject.toString();
        } catch (JSONException e2) {
            b00 b00 = b00.f358a;
            hj1.W0(e2);
            str2 = null;
        }
        this.q = str2;
        if (this.o == 1) {
            this.o = 0;
        }
        xt.f3961a.x().c(this.o);
        builder.build().toString();
        return builder.build().toString();
    }

    public final void h(boolean z, boolean z2) {
        long j2;
        if (this.i) {
            this.f.removeCallbacks(this.b);
            if (z) {
                Handler handler = this.f;
                Runnable runnable = this.b;
                if (Long.compare(this.n, 0) > 0) {
                    if (!this.r) {
                        if (z2) {
                            this.r = true;
                        }
                        j2 = this.n;
                    } else if (!this.s) {
                        if (z2) {
                            this.s = true;
                        }
                        j2 = this.n;
                    }
                    handler.postDelayed(runnable, j2);
                    return;
                }
                if (z2) {
                    this.k += this.m;
                }
                j2 = this.k;
                handler.postDelayed(runnable, j2);
                return;
            }
            this.f.post(this.b);
        }
    }

    public final void i(JSONObject jSONObject) {
        boolean z;
        xt.t1 t1Var = xt.f3961a;
        String str = t1Var.G().f2889a.get("keyNpsCacheTTL");
        String str2 = t1Var.G().f2889a.get("keyLastNpsCacheUpdateTime");
        if (!(str == null || str2 == null)) {
            if (ui1.Q() - Long.parseLong(str2) <= Long.parseLong(str)) {
                z = false;
                if (z && this.o == 1) {
                    try {
                        jSONObject.put("npsSurvey", new JSONObject());
                        q30.g("NPS survey request sent", "time stamp " + ui1.Q());
                        return;
                    } catch (JSONException e2) {
                        b00 b00 = b00.f358a;
                        hj1.W0(e2);
                        return;
                    }
                }
            }
        }
        z = true;
        if (z) {
        }
    }

    public final void j(JSONObject jSONObject, String str) {
        if (this.o == 1) {
            xt.t1 t1Var = xt.f3961a;
            String e2 = t1Var.R().e();
            String a2 = t1Var.R().a();
            if (e2 == null || !str.equalsIgnoreCase(a2)) {
                t1Var.R().d(str);
                e2 = "noVersionCached";
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("cachedVersionCode", e2);
                jSONObject.put("reportProblem", jSONObject2);
                String str2 = "time stamp " + ui1.Q();
                n86.e("Report Problem request sent", "eventName");
                if (t1Var.v().f) {
                    ed1 ed1 = new ed1("Report Problem request sent", Long.MIN_VALUE);
                    if (str2 != null) {
                        ed1.a("Report Problem feature event description ", str2);
                    }
                    jz5.b().g(ed1);
                }
            } catch (JSONException e3) {
                b00 b00 = b00.f358a;
                hj1.W0(e3);
            }
        }
    }

    public final void k(JSONObject jSONObject, String str) {
        if (this.o == 1) {
            String S = hj1.S(str, "cachedVersionCode");
            xt.t1 t1Var = xt.f3961a;
            String a2 = t1Var.V().containsKey(S) ? t1Var.V().a(S) : "noVersionCached";
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("cachedVersionCode", a2);
                jSONObject.put("bannerInfo", jSONObject2);
            } catch (JSONException e2) {
                b00 b00 = b00.f358a;
                hj1.W0(e2);
            }
        }
    }

    public final void l(JSONObject jSONObject, String str) {
        if (this.o == 1) {
            xt.t1 t1Var = xt.f3961a;
            String g2 = t1Var.F().g(str);
            String str2 = "noVersionCached";
            String a2 = t1Var.l().containsKey(g2) ? t1Var.l().a(g2) : str2;
            if (a2 != null) {
                str2 = a2;
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("cachedVersionCode", str2);
                jSONObject.put("silentAlerts", jSONObject2);
            } catch (JSONException e2) {
                b00 b00 = b00.f358a;
                hj1.W0(e2);
            }
        }
    }

    public final void m(String str) throws JSONException {
        ArrayList arrayList;
        JSONArray optJSONArray = new JSONObject(str).optJSONArray("cards");
        if (optJSONArray != null) {
            arrayList = new ArrayList();
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                CardInfo cardInfo = new CardInfo();
                JSONObject jSONObject = optJSONArray.getJSONObject(i2);
                JSONObject optJSONObject = jSONObject.optJSONObject("header");
                JSONObject optJSONObject2 = jSONObject.optJSONObject("dismissConditions");
                String string = jSONObject.getString("type");
                String optString = jSONObject.optString("id");
                int optInt = jSONObject.optInt(CardInfo.KEY_POS, 0);
                int optInt2 = jSONObject.optInt("width", -1);
                int optInt3 = jSONObject.optInt("height", -1);
                boolean optBoolean = jSONObject.optBoolean("enabled", true);
                int optInt4 = jSONObject.optInt("version", 0);
                JSONArray optJSONArray2 = jSONObject.optJSONArray("content");
                cardInfo.setType(string);
                cardInfo.setPosition(optInt);
                cardInfo.setWidth(optInt2);
                cardInfo.setHeight(optInt3);
                cardInfo.setEnabled(optBoolean);
                cardInfo.setVersion(optInt4);
                cardInfo.setCardId(optString);
                if (optJSONObject != null) {
                    String optString2 = optJSONObject.optString("text");
                    String optString3 = optJSONObject.optString(CardInfo.KEY_HOOK_TEXT);
                    String optString4 = optJSONObject.optString(CardInfo.KEY_HOOK_CTA);
                    HeaderObj headerObj = new HeaderObj(optString2);
                    headerObj.setHookText(optString3);
                    headerObj.setHookCta(optString4);
                    cardInfo.setHeaderObj(headerObj);
                }
                if (optJSONObject2 != null) {
                    Iterator<String> keys = optJSONObject2.keys();
                    HashMap hashMap = new HashMap();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (optJSONObject2.get(next) instanceof JSONObject) {
                            hashMap.put(next, Integer.valueOf(optJSONObject2.getJSONObject(next).getInt("displayThreshold")));
                        }
                    }
                    DismissConditions dismissConditions = new DismissConditions();
                    dismissConditions.setDismissConditions(hashMap);
                    cardInfo.setDismissConditions(dismissConditions);
                }
                ArrayList arrayList2 = new ArrayList();
                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                    arrayList2.add(e(optJSONArray2.getJSONObject(i3), optBoolean));
                }
                cardInfo.setContentList(arrayList2);
                arrayList.add(cardInfo);
            }
        } else {
            arrayList = null;
        }
        CardInfoFetchEvent cardInfoFetchEvent = new CardInfoFetchEvent();
        cardInfoFetchEvent.setCardsList(arrayList);
        jz5.b().i(cardInfoFetchEvent);
    }

    public final void n(JSONObject jSONObject) throws JSONException {
        ArrayList arrayList;
        JSONArray optJSONArray = jSONObject.optJSONArray("cards");
        if (optJSONArray != null) {
            arrayList = new ArrayList();
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                CardInfo cardInfo = new CardInfo();
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                JSONObject optJSONObject = jSONObject2.optJSONObject("header");
                JSONObject optJSONObject2 = jSONObject2.optJSONObject("dismissConditions");
                String string = jSONObject2.getString("type");
                String optString = jSONObject2.optString("id");
                int optInt = jSONObject2.optInt(CardInfo.KEY_POS, 0);
                int optInt2 = jSONObject2.optInt("width", -1);
                int optInt3 = jSONObject2.optInt("height", -1);
                boolean optBoolean = jSONObject2.optBoolean("enabled", true);
                int optInt4 = jSONObject2.optInt("version", 0);
                JSONArray optJSONArray2 = jSONObject2.optJSONArray("content");
                cardInfo.setType(string);
                cardInfo.setPosition(optInt);
                cardInfo.setWidth(optInt2);
                cardInfo.setHeight(optInt3);
                cardInfo.setEnabled(optBoolean);
                cardInfo.setVersion(optInt4);
                cardInfo.setCardId(optString);
                if (optJSONObject != null) {
                    String optString2 = optJSONObject.optString("text");
                    String optString3 = optJSONObject.optString(CardInfo.KEY_HOOK_TEXT);
                    String optString4 = optJSONObject.optString(CardInfo.KEY_HOOK_CTA);
                    HeaderObj headerObj = new HeaderObj(optString2);
                    headerObj.setHookText(optString3);
                    headerObj.setHookCta(optString4);
                    cardInfo.setHeaderObj(headerObj);
                }
                if (optJSONObject2 != null) {
                    Iterator<String> keys = optJSONObject2.keys();
                    HashMap hashMap = new HashMap();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (optJSONObject2.get(next) instanceof JSONObject) {
                            hashMap.put(next, Integer.valueOf(optJSONObject2.getJSONObject(next).getInt("displayThreshold")));
                        }
                    }
                    DismissConditions dismissConditions = new DismissConditions();
                    dismissConditions.setDismissConditions(hashMap);
                    cardInfo.setDismissConditions(dismissConditions);
                }
                ArrayList arrayList2 = new ArrayList();
                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                    arrayList2.add(e(optJSONArray2.getJSONObject(i3), optBoolean));
                }
                cardInfo.setContentList(arrayList2);
                arrayList.add(cardInfo);
            }
        } else {
            arrayList = null;
        }
        CardInfoFetchEvent cardInfoFetchEvent = new CardInfoFetchEvent();
        cardInfoFetchEvent.setCardsList(arrayList);
        jz5.b().i(cardInfoFetchEvent);
    }
}
