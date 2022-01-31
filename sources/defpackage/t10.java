package defpackage;

import android.os.Handler;
import android.os.HandlerThread;
import app.zophop.models.DataInfo;
import app.zophop.models.EtaInfo;
import app.zophop.models.StreamInfo;
import app.zophop.pubsub.eventbus.events.FirebaseEtaUpdateEvent;
import app.zophop.pubsub.eventbus.events.FirebaseRouteUpdateEvent;
import com.google.firebase.remoteconfig.internal.Personalization;
import com.google.gson.Gson;
import defpackage.ut;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;
import server.zophop.models.Point;

/* renamed from: t10  reason: default package */
/* compiled from: FirebasePollingRequestHandler */
public class t10 {

    /* renamed from: a  reason: collision with root package name */
    public HandlerThread f3292a;
    public Runnable b;
    public final String c;
    public Handler d;
    public final String e;
    public final xj1 f;
    public boolean g = true;
    public final List<StreamInfo> h;
    public final Map<String, StreamInfo> i;
    public final List<DataInfo> j;

    public t10(xj1 xj1, String str, String str2) {
        this.c = str;
        this.f = xj1;
        this.e = str2;
        this.h = new ArrayList();
        this.i = new HashMap();
        this.j = new ArrayList();
        new HashMap();
    }

    public static void a(t10 t10, ad1 ad1, String str, String str2) {
        Objects.requireNonNull(t10);
        ed1 ed1 = new ed1("firebase polling event", Long.MIN_VALUE);
        ed1.a("response", ad1.name());
        ed1.a("reference type", str);
        hj1.K0(ed1, "uri", str2, ed1);
    }

    public static void b(t10 t10, JSONObject jSONObject) {
        Objects.requireNonNull(t10);
        try {
            Iterator<String> keys = jSONObject.keys();
            jSONObject.toString();
            t10.i.clear();
            t10.h.clear();
            while (keys.hasNext()) {
                String next = keys.next();
                if (jSONObject.get(next) instanceof String) {
                    String str = (String) jSONObject.get(next);
                    JSONObject jSONObject2 = new JSONObject(str);
                    String string = jSONObject2.getString("_vehicleNumber");
                    Long valueOf = Long.valueOf(jSONObject2.getLong("_time"));
                    Integer valueOf2 = Integer.valueOf(jSONObject2.getInt("_eta"));
                    String string2 = jSONObject2.getString("_stopId");
                    boolean optBoolean = jSONObject2.optBoolean("_isHalted");
                    StreamInfo streamInfo = new StreamInfo(next, valueOf2.intValue(), string2, (Point) new Gson().fromJson(str, Point.class), valueOf.longValue());
                    streamInfo.setHaltedStatus(optBoolean);
                    ut.a aVar = ut.f3552a;
                    if (ui1.Y() || ui1.X()) {
                        streamInfo.setVehicleNumber(string);
                    }
                    t10.i.put(next, streamInfo);
                    t10.h.add(streamInfo);
                }
            }
            FirebaseRouteUpdateEvent firebaseRouteUpdateEvent = new FirebaseRouteUpdateEvent();
            firebaseRouteUpdateEvent.set_requestId(t10.c);
            firebaseRouteUpdateEvent.setStreamInfoMap(t10.i);
            firebaseRouteUpdateEvent.set_responseType(ad1.SUCCESS);
            firebaseRouteUpdateEvent.setStreamInfoList(t10.h);
            jz5.b().g(firebaseRouteUpdateEvent);
        } catch (JSONException unused) {
        }
    }

    public static void c(t10 t10, JSONObject jSONObject) {
        Objects.requireNonNull(t10);
        try {
            Iterator<String> keys = jSONObject.keys();
            jSONObject.toString();
            t10.j.clear();
            while (keys.hasNext()) {
                String next = keys.next();
                if (jSONObject.get(next) instanceof JSONObject) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                    String string = jSONObject2.getString("_vehicleNo");
                    Long valueOf = Long.valueOf(jSONObject2.getLong("_timeStamp"));
                    Integer valueOf2 = Integer.valueOf(jSONObject2.getInt("_eta"));
                    Integer valueOf3 = Integer.valueOf(jSONObject2.optInt("_minEta", -1));
                    Integer valueOf4 = Integer.valueOf(jSONObject2.optInt("_maxEta", -1));
                    EtaInfo etaInfo = new EtaInfo(next, valueOf2.intValue(), string, valueOf.longValue());
                    etaInfo.set_maxEta(valueOf4.intValue());
                    etaInfo.set_minEta(valueOf3.intValue());
                    t10.j.add(etaInfo);
                }
            }
            FirebaseEtaUpdateEvent firebaseEtaUpdateEvent = new FirebaseEtaUpdateEvent();
            firebaseEtaUpdateEvent.set_requestId(t10.c);
            firebaseEtaUpdateEvent.set_responseType(ad1.SUCCESS);
            firebaseEtaUpdateEvent.set_etaInfoList(t10.j);
            jz5.b().g(firebaseEtaUpdateEvent);
        } catch (JSONException unused) {
        }
    }

    public void d() {
        this.g = false;
        xj1 xj1 = this.f;
        StringBuilder i0 = hj1.i0(Personalization.ANALYTICS_ORIGIN_PERSONALIZATION);
        i0.append(this.c);
        xj1.c(i0.toString());
        this.d.removeCallbacks(this.b);
        this.d.removeCallbacksAndMessages(null);
        this.f3292a.quit();
    }
}
