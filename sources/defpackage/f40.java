package defpackage;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import app.zophop.models.DataInfo;
import app.zophop.models.EtaInfo;
import app.zophop.models.SocketModels.ConnectionData;
import app.zophop.models.SocketModels.PollingInfo;
import app.zophop.models.SocketModels.RetryPolicy;
import app.zophop.models.StreamInfo;
import app.zophop.models.mTicketing.ProductDiscountsObject;
import app.zophop.pubsub.eventbus.events.RealTimeSocketDataEvent;
import com.google.firebase.appindexing.Indexable;
import com.google.gson.Gson;
import com.razorpay.AnalyticsConstants;
import defpackage.m36;
import defpackage.r26;
import defpackage.sd1;
import defpackage.ut;
import defpackage.xt;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;
import server.zophop.models.Point;

/* renamed from: f40  reason: default package */
/* compiled from: RealTimeSocketFeature */
public class f40 {

    /* renamed from: a  reason: collision with root package name */
    public Map<String, Map<String, DataInfo>> f1072a;
    public Map<String, Map<String, DataInfo>> b;
    public Map<String, List<DataInfo>> c;
    public Map<String, Runnable> d;
    public Map<String, Runnable> e;
    public Handler f;
    public Handler g;
    public e36 h;
    public AtomicInteger i;
    public Context j;
    public final Object k = new Object();
    public Map<String, Map<Integer, ji1<Object, String>>> l;
    public xj1 m;
    public boolean n;
    public ConnectionData o;
    public String p;

    /* renamed from: f40$a */
    /* compiled from: RealTimeSocketFeature */
    public class a implements m36.a {
        public a() {
        }

        @Override // defpackage.m36.a
        public void a(Object... objArr) {
            f40.a(f40.this, "crts connect timeout", objArr);
        }
    }

    /* renamed from: f40$b */
    /* compiled from: RealTimeSocketFeature */
    public class b implements m36.a {
        public b() {
        }

        @Override // defpackage.m36.a
        public void a(Object... objArr) {
            f40.a(f40.this, "crts error", objArr);
        }
    }

    /* renamed from: f40$c */
    /* compiled from: RealTimeSocketFeature */
    public class c implements m36.a {
        public c() {
        }

        @Override // defpackage.m36.a
        public void a(Object... objArr) {
            f40.a(f40.this, "crts reconnect", objArr);
        }
    }

    /* renamed from: f40$d */
    /* compiled from: RealTimeSocketFeature */
    public class d implements m36.a {
        public d() {
        }

        @Override // defpackage.m36.a
        public void a(Object... objArr) {
            f40.a(f40.this, "crts reconnect attempt", objArr);
        }
    }

    /* renamed from: f40$e */
    /* compiled from: RealTimeSocketFeature */
    public class e implements m36.a {
        public e() {
        }

        @Override // defpackage.m36.a
        public void a(Object... objArr) {
            f40.a(f40.this, "crts reconnect failed", objArr);
        }
    }

    /* renamed from: f40$f */
    /* compiled from: RealTimeSocketFeature */
    public class f implements m36.a {
        public f() {
        }

        @Override // defpackage.m36.a
        public void a(Object... objArr) {
            f40.a(f40.this, "crts reconnect error", objArr);
        }
    }

    /* renamed from: f40$g */
    /* compiled from: RealTimeSocketFeature */
    public class g implements Runnable {
        public final /* synthetic */ PollingInfo f;
        public final /* synthetic */ String g;

        public g(PollingInfo pollingInfo, String str) {
            this.f = pollingInfo;
            this.g = str;
        }

        public void run() {
            double randomizationFactor = this.f.getRandomizationFactor();
            if (!this.f.isPollingStatus()) {
                int resyncFrequency = this.f.getResyncFrequency();
                if (resyncFrequency != -1) {
                    e36 e36 = f40.this.h;
                    if (e36 != null && e36.b) {
                        f40.this.h.a("once", this.g);
                    }
                    f40 f40 = f40.this;
                    f40.g.postDelayed(this, f40.c(resyncFrequency, randomizationFactor) * 1000);
                    return;
                }
                return;
            }
            int pollingFrequency = this.f.getPollingFrequency();
            e36 e362 = f40.this.h;
            if (e362 != null && e362.b) {
                f40.this.h.a("once", this.g);
            }
            f40 f402 = f40.this;
            f402.g.postDelayed(this, f402.c(pollingFrequency, randomizationFactor) * 1000);
        }
    }

    /* renamed from: f40$h */
    /* compiled from: RealTimeSocketFeature */
    public class h implements q26 {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f1079a;

        public h(String str) {
            this.f1079a = str;
        }

        @Override // defpackage.q26
        public void a(Object... objArr) {
            f40 f40 = f40.this;
            f40.g.removeCallbacks(f40.e.get(this.f1079a));
            f40.this.e.remove(this.f1079a);
        }
    }

    /* renamed from: f40$i */
    /* compiled from: RealTimeSocketFeature */
    public class i implements sd1.b {
        public i() {
        }

        @Override // defpackage.sd1.b
        public void a() {
            f40.this.d();
        }

        @Override // defpackage.sd1.b
        public void b() {
            e36 e36 = f40.this.h;
            if (e36 == null || !e36.b) {
                f40 f40 = f40.this;
                xt.t1 t1Var = xt.f3961a;
                f40.j(t1Var.k().d() != null ? hj1.B(t1Var) : null);
            }
        }
    }

    /* renamed from: f40$j */
    /* compiled from: RealTimeSocketFeature */
    public class j implements Runnable {
        public j() {
        }

        public void run() {
            f40 f40 = f40.this;
            if (f40.h == null) {
                xt.t1 t1Var = xt.f3961a;
                f40.j(t1Var.k().d() != null ? hj1.B(t1Var) : null);
            }
        }
    }

    /* renamed from: f40$k */
    /* compiled from: RealTimeSocketFeature */
    public class k implements q26 {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f1081a;

        public k(String str) {
            this.f1081a = str;
        }

        @Override // defpackage.q26
        public void a(Object... objArr) {
            f40 f40 = f40.this;
            f40.g.removeCallbacks(f40.e.remove(this.f1081a));
            f40.this.e.remove(this.f1081a);
        }
    }

    /* renamed from: f40$l */
    /* compiled from: RealTimeSocketFeature */
    public class l implements m36.a {
        public l() {
        }

        @Override // defpackage.m36.a
        public void a(Object... objArr) {
            f40.a(f40.this, "crts disconnect", objArr);
        }
    }

    /* renamed from: f40$m */
    /* compiled from: RealTimeSocketFeature */
    public class m implements m36.a {
        public m() {
        }

        @Override // defpackage.m36.a
        public void a(Object... objArr) {
            f40.a(f40.this, "crts connect", objArr);
            synchronized (f40.this.k) {
                for (String str : f40.this.l.keySet()) {
                    e36 e36 = f40.this.h;
                    if (e36 != null && e36.b) {
                        for (Map.Entry<Integer, ji1<Object, String>> entry : f40.this.l.get(str).entrySet()) {
                            f40.this.e(vn.x(str, entry.getKey().intValue()));
                        }
                        String str2 = str + " " + f40.this.i;
                    }
                }
            }
        }
    }

    /* renamed from: f40$n */
    /* compiled from: RealTimeSocketFeature */
    public class n implements m36.a {

        /* renamed from: f40$n$a */
        /* compiled from: RealTimeSocketFeature */
        public class a implements Runnable {
            public final /* synthetic */ Object[] f;

            public a(n nVar, Object[] objArr) {
                this.f = objArr;
            }

            public void run() {
                jz5.b().g(new RealTimeSocketDataEvent(String.valueOf(this.f[0])));
            }
        }

        public n() {
        }

        @Override // defpackage.m36.a
        public void a(Object... objArr) {
            f40.this.f.post(new a(this, objArr));
        }
    }

    /* renamed from: f40$o */
    /* compiled from: RealTimeSocketFeature */
    public class o implements m36.a {
        public o() {
        }

        @Override // defpackage.m36.a
        public void a(Object... objArr) {
            f40.a(f40.this, "crts connect error", objArr);
        }
    }

    /* renamed from: f40$p */
    /* compiled from: RealTimeSocketFeature */
    public class p implements Runnable {
        public int f;
        public float g;
        public int h;
        public int i = 0;
        public String j;
        public String k;

        /* renamed from: f40$p$a */
        /* compiled from: RealTimeSocketFeature */
        public class a implements q26 {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Runnable f1086a;

            public a(Runnable runnable) {
                this.f1086a = runnable;
            }

            @Override // defpackage.q26
            public void a(Object... objArr) {
                f40.this.g.removeCallbacks(this.f1086a);
            }
        }

        public p(int i2, int i3, float f2, String str, String str2) {
            this.h = i2;
            this.f = i3;
            this.g = f2;
            this.k = str;
            this.j = str2;
        }

        public void run() {
            int i2 = this.i;
            if (i2 < this.h) {
                this.i = i2 + 1;
                f40 f40 = f40.this;
                int i3 = this.f;
                float f2 = this.g;
                Objects.requireNonNull(f40);
                float f3 = (float) i3;
                long j2 = (long) ((f2 * f3) + f3);
                this.i = this.i;
                this.f = (int) j2;
                f40.this.h.a(this.k, this.j, new a(this));
                f40.this.g.postDelayed(this, j2);
                return;
            }
            f40.this.g.removeCallbacks(this);
        }
    }

    public f40(Context context, xj1 xj1) {
        this.j = context;
        jz5 b2 = jz5.b();
        b2.k(this, b2.e, false, 0);
        this.l = new HashMap();
        this.f1072a = new HashMap();
        this.b = new HashMap();
        this.c = new HashMap();
        this.m = xj1;
        this.f = new Handler();
        this.g = new Handler();
        this.i = new AtomicInteger();
        this.d = new HashMap();
        this.e = new HashMap();
        sd1 v = xt.f3961a.v();
        v.i.add(new i());
    }

    public static void a(f40 f40, String str, Object[] objArr) {
        Objects.requireNonNull(f40);
        try {
            ed1 ed1 = new ed1(str, Long.MIN_VALUE);
            StringBuilder sb = new StringBuilder();
            if (objArr != null) {
                for (Object obj : objArr) {
                    if (obj != null) {
                        if (obj instanceof Exception) {
                            if (((Exception) obj).getCause() != null) {
                                ed1.a("exception message", ((Exception) obj).getCause().getMessage());
                            }
                            b00 b00 = b00.f358a;
                            b00.a().b(new Throwable((Exception) obj));
                        }
                        sb.append(obj);
                    }
                }
            }
            ed1.a("reason", sb.toString());
            ed1.a(AnalyticsConstants.NETWORK, Boolean.valueOf(vn.L0(f40.j)));
            ed1.a("network type", vn.Y(f40.j));
            ed1.a("time", Long.valueOf(ui1.Q()));
            jz5.b().g(ed1);
        } catch (Exception e2) {
            b00 b002 = b00.f358a;
            b00.a().b(new Throwable(e2));
        }
    }

    public final void b() {
        e36 e36 = this.h;
        if (e36 != null) {
            e36.d("connect_error", new o());
            this.h.d("connect_timeout", new a());
            this.h.d("error", new b());
            this.h.d("reconnect", new c());
            this.h.d("reconnect_attempt", new d());
            this.h.d("reconnect_failed", new e());
            this.h.d("reconnect_error", new f());
        }
    }

    public final long c(int i2, double d2) {
        int i3 = i2 / Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL;
        int i4 = (int) (((double) i3) * d2);
        int i5 = i3 - i4;
        return (long) (new Random().nextInt(((i3 + i4) - i5) + 1) + i5);
    }

    public void d() {
        Handler handler = this.f;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        e36 e36 = this.h;
        if (e36 != null) {
            e36.f2318a.clear();
            e36 e362 = this.h;
            Objects.requireNonNull(e362);
            c56.a(new j36(e362));
        }
        this.l.clear();
        this.f1072a.clear();
        this.b.clear();
        this.c.clear();
        this.g.removeCallbacksAndMessages(null);
        this.d.clear();
        this.e.clear();
    }

    public final void e(String str) {
        PollingInfo pollingInfo = this.o.getPollingInfoMap().get(g(str));
        RetryPolicy retryPolicy = pollingInfo.getRetryPolicy();
        g gVar = new g(pollingInfo, str);
        if (!pollingInfo.isPollingStatus()) {
            int resyncFrequency = pollingInfo.getResyncFrequency();
            double randomizationFactor = pollingInfo.getRandomizationFactor();
            if (retryPolicy == null) {
                this.h.a("subscribe", str);
            } else {
                p pVar = new p(retryPolicy.getMaxRetries(), retryPolicy.getTimeout(), retryPolicy.getBackoffMultiplier(), "subscribe", str);
                this.e.put(str, pVar);
                this.h.a("subscribe", str, new h(str));
                this.g.postDelayed(pVar, (long) retryPolicy.getTimeout());
            }
            this.g.postDelayed(gVar, c(resyncFrequency, randomizationFactor) * 1000);
        } else {
            this.g.post(gVar);
        }
        if (this.d.get(str) != null) {
            this.g.removeCallbacks(this.d.get(str));
            this.d.remove(str);
        }
        this.d.put(str, gVar);
    }

    public final EtaInfo f(String str, String str2) {
        JSONException e2;
        EtaInfo etaInfo = null;
        try {
            JSONObject jSONObject = new JSONObject(str2);
            String string = jSONObject.getString("vNo");
            Long valueOf = Long.valueOf(jSONObject.getLong("tS"));
            Integer valueOf2 = Integer.valueOf(jSONObject.getInt("eta"));
            Integer valueOf3 = Integer.valueOf(jSONObject.optInt("minEta", -1));
            Integer valueOf4 = Integer.valueOf(jSONObject.optInt("maxEta", -1));
            EtaInfo etaInfo2 = new EtaInfo(str, valueOf2.intValue(), string, valueOf.longValue());
            try {
                etaInfo2.set_maxEta(valueOf4.intValue());
                etaInfo2.set_minEta(valueOf3.intValue());
                return etaInfo2;
            } catch (JSONException e3) {
                e2 = e3;
                etaInfo = etaInfo2;
            }
        } catch (JSONException e4) {
            e2 = e4;
            b00 b00 = b00.f358a;
            hj1.X0(e2, b00.a());
            return etaInfo;
        }
    }

    public final String g(String str) {
        try {
            return new JSONObject(str).getString("ref").split(ProductDiscountsObject.KEY_DELIMITER)[0];
        } catch (JSONException e2) {
            b00 b00 = b00.f358a;
            hj1.X0(e2, b00.a());
            return null;
        }
    }

    public final Map<String, List<EtaInfo>> h(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                Iterator<String> keys2 = jSONObject2.keys();
                ArrayList arrayList = new ArrayList();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    arrayList.add(f(next2, jSONObject2.getString(next2)));
                }
                hashMap.put(next, arrayList);
            }
        } catch (JSONException e2) {
            b00 b00 = b00.f358a;
            hj1.X0(e2, b00.a());
        }
        return hashMap;
    }

    public final void i(ConnectionData connectionData) {
        try {
            r26.a aVar = new r26.a();
            aVar.o = connectionData.getReconnectionDelay();
            aVar.p = connectionData.getReconnectionDelayMax();
            aVar.q = connectionData.getRandomizationFactor();
            aVar.b = connectionData.getPath();
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("city=");
            xt.t1 t1Var = xt.f3961a;
            sb2.append(t1Var.k().d().getDisplayName());
            sb.append(sb2.toString());
            sb.append("&deviceId=" + t1Var.D());
            if (t1Var.L() != null && t1Var.L().m()) {
                sb.append("&userId=" + t1Var.m0());
            }
            aVar.n = sb.toString();
            if (connectionData.getTimeout() >= 0) {
                aVar.r = connectionData.getTimeout();
            }
            if (connectionData.getTransports() != null) {
                aVar.l = connectionData.getTransports();
            }
            e36 a2 = r26.a(connectionData.getBaseUrl(), aVar);
            this.h = a2;
            boolean z = true;
            if (a2.b("disconnect").size() <= 1) {
                this.h.d("disconnect", new l());
            }
            if (this.h.b("connect").size() <= 1) {
                this.h.d("connect", new m());
            }
            ConcurrentLinkedQueue<m36.a> concurrentLinkedQueue = this.h.f2318a.get("message");
            if (concurrentLinkedQueue == null || concurrentLinkedQueue.isEmpty()) {
                z = false;
            }
            if (!z) {
                this.h.d("message", new n());
            }
            b();
            e36 e36 = this.h;
            Objects.requireNonNull(e36);
            c56.a(new g36(e36));
        } catch (URISyntaxException e2) {
            b00 b00 = b00.f358a;
            b00.a().b(new Throwable(e2));
            e2.getMessage();
            e2.getReason();
        } catch (ConcurrentModificationException e3) {
            b00 b002 = b00.f358a;
            b00.a().b(new Throwable(e3));
            e3.getMessage();
        }
    }

    public void j(String str) {
        xt.t1 t1Var = xt.f3961a;
        t1Var.v();
        if (xt.p && t1Var.v().f && str != null) {
            ConnectionData connectionData = this.o;
            if (connectionData != null) {
                i(connectionData);
                return;
            }
            Uri.Builder builder = new Uri.Builder();
            builder.encodedPath(ut.H).appendPath(str).appendQueryParameter("meta", ui1.K0().toString());
            d70 d70 = new d70(builder.build().toString(), null, new h40(this), new g40(this));
            d70.q = new nj1(10000, Integer.MAX_VALUE, 1.0f);
            d70.n = false;
            this.m.a(d70);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v1, resolved type: java.util.Map<java.lang.String, java.util.Map<java.lang.Integer, ji1<java.lang.Object, java.lang.String>>> */
    /* JADX WARN: Multi-variable type inference failed */
    public int k(String str, ji1<Object, String> ji1) {
        int incrementAndGet;
        HashMap hashMap;
        synchronized (this.k) {
            incrementAndGet = this.i.incrementAndGet();
            String x = vn.x(str, incrementAndGet);
            if (this.l.get(str) != null) {
                Map<Integer, ji1<Object, String>> map = this.l.get(str);
                map.put(Integer.valueOf(incrementAndGet), ji1);
                hashMap = map;
            } else {
                HashMap hashMap2 = new HashMap();
                hashMap2.put(Integer.valueOf(incrementAndGet), ji1);
                hashMap = hashMap2;
            }
            this.l.put(str, hashMap == 1 ? 1 : 0);
            e36 e36 = this.h;
            if (e36 == null || !e36.b) {
                ed1 ed1 = new ed1("socket connection error", Long.MIN_VALUE);
                e36 e362 = this.h;
                if (e362 == null) {
                    ed1.a("socket initialized", Boolean.FALSE);
                } else {
                    ed1.a("socket not connected", Boolean.valueOf(e362.b));
                }
                jz5.b().g(ed1);
            } else {
                e(x);
            }
        }
        return incrementAndGet;
    }

    public void l(String str, int i2) {
        try {
            Map<String, Map<Integer, ji1<Object, String>>> map = this.l;
            if (map != null && map.containsKey(str)) {
                String x = vn.x(str, i2);
                Map<Integer, ji1<Object, String>> map2 = this.l.get(str);
                if (map2 != null && map2.containsKey(Integer.valueOf(i2))) {
                    map2.remove(Integer.valueOf(i2));
                    if (map2.size() == 0) {
                        this.l.remove(str);
                    }
                    String g2 = g(x);
                    if (this.o.getPollingInfoMap().get(g2).isPollingStatus()) {
                        this.g.removeCallbacks(this.d.get(x));
                        this.d.remove(x);
                        return;
                    }
                    RetryPolicy retryPolicy = this.o.getPollingInfoMap().get(g2).getRetryPolicy();
                    p pVar = new p(retryPolicy.getMaxRetries(), retryPolicy.getTimeout(), retryPolicy.getBackoffMultiplier(), "unsubscribe", x);
                    this.e.put(x, pVar);
                    e36 e36 = this.h;
                    if (e36 != null && e36.b) {
                        this.h.a("unsubscribe", x, new k(x));
                        this.g.postDelayed(pVar, (long) retryPolicy.getTimeout());
                        if (this.o.getPollingInfoMap().get(g2).getResyncFrequency() != -1) {
                            this.g.removeCallbacks(this.d.get(x));
                            this.d.remove(x);
                        }
                    }
                }
            }
        } catch (NullPointerException e2) {
            b00 b00 = b00.f358a;
            b00.a().b(new Throwable(e2));
        }
    }

    public void onEvent(qd1 qd1) {
        boolean z;
        boolean z2 = qd1.f2931a;
        if (!vn.L0(this.j) || this.n == (z = qd1.f2931a)) {
            this.n = qd1.f2931a;
            return;
        }
        ed1 ed1 = new ed1("crts network changed", Long.MIN_VALUE);
        hj1.d(z, ed1, AnalyticsConstants.NETWORK, ed1);
        if (xt.f3961a.v().f) {
            j jVar = new j();
            this.f.removeCallbacksAndMessages(null);
            this.f.postDelayed(jVar, 2000);
        }
        this.n = qd1.f2931a;
    }

    public void onEvent(RealTimeSocketDataEvent realTimeSocketDataEvent) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        String referenceType = realTimeSocketDataEvent.getReferenceType();
        int requestId = realTimeSocketDataEvent.getRequestId();
        if (this.e != null) {
            String x = vn.x(referenceType, requestId);
            if (this.e.containsKey(x)) {
                this.g.removeCallbacks(this.e.get(x));
                this.e.remove(x);
            }
        }
        realTimeSocketDataEvent.getReferenceType();
        String lowerCase = xt.f3961a.k().d().getDisplayName().toLowerCase();
        DataInfo dataInfo = null;
        if (referenceType.startsWith("routes:" + lowerCase)) {
            String data = realTimeSocketDataEvent.getData();
            boolean isPollingStatus = this.o.getPollingInfoMap().get(ProductDiscountsObject.KEY_ROUTES).isPollingStatus();
            Map<String, DataInfo> map = this.f1072a.get(referenceType);
            if (map == null) {
                ed1 ed1 = new ed1("crts response", Long.MIN_VALUE);
                ed1.a("time", Long.valueOf(ui1.Q()));
                ed1.a("reference type", referenceType);
                jz5.b().g(ed1);
                map = new HashMap<>();
            }
            try {
                JSONObject jSONObject3 = new JSONObject(data);
                Iterator<String> keys = jSONObject3.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (!(jSONObject3.get(next) instanceof String)) {
                        if (!(jSONObject3.get(next) instanceof JSONObject)) {
                            map.put(next, dataInfo);
                        }
                    }
                    if (jSONObject3.get(next) instanceof String) {
                        jSONObject2 = new JSONObject((String) jSONObject3.get(next));
                    } else {
                        jSONObject2 = (JSONObject) jSONObject3.get(next);
                    }
                    String string = jSONObject2.getString("vNo");
                    Long valueOf = Long.valueOf(jSONObject2.getLong("tS"));
                    Integer valueOf2 = Integer.valueOf(jSONObject2.getInt("eta"));
                    String string2 = jSONObject2.getString("sId");
                    boolean optBoolean = jSONObject2.optBoolean("_isHalted");
                    StreamInfo streamInfo = new StreamInfo(next, valueOf2.intValue(), string2, (Point) new Gson().fromJson(jSONObject2.toString(), Point.class), valueOf.longValue());
                    streamInfo.setHaltedStatus(optBoolean);
                    ut.a aVar = ut.f3552a;
                    if (ui1.Y() || ui1.X()) {
                        streamInfo.setVehicleNumber(string);
                    }
                    if (!map.containsKey(next) || isPollingStatus) {
                        map.put(next, streamInfo);
                    } else if (streamInfo.getTimeStamp() > ((StreamInfo) map.get(next)).getTimeStamp()) {
                        map.remove(next);
                        map.put(next, streamInfo);
                    }
                    dataInfo = null;
                    keys = keys;
                }
            } catch (JSONException e2) {
                b00 b00 = b00.f358a;
                hj1.X0(e2, b00.a());
            }
            this.f1072a.remove(referenceType);
            this.f1072a.put(referenceType, map);
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, DataInfo> entry : this.f1072a.get(referenceType).entrySet()) {
                if (entry.getValue() != null) {
                    arrayList.add(entry.getValue());
                }
            }
            if (this.l.get(referenceType) == null) {
                b00 b002 = b00.f358a;
                hj1.Q0(referenceType, b00.a());
                return;
            }
            for (Map.Entry<Integer, ji1<Object, String>> entry2 : this.l.get(referenceType).entrySet()) {
                entry2.getValue().onSuccess(arrayList);
            }
            return;
        }
        if (referenceType.startsWith("etas:" + lowerCase)) {
            String data2 = realTimeSocketDataEvent.getData();
            boolean isPollingStatus2 = this.o.getPollingInfoMap().get("etas").isPollingStatus();
            Map<String, DataInfo> map2 = this.f1072a.get(referenceType);
            if (map2 == null) {
                ed1 ed12 = new ed1("crts response", Long.MIN_VALUE);
                ed12.a("time", Long.valueOf(ui1.Q()));
                ed12.a("reference type", referenceType);
                jz5.b().g(ed12);
                map2 = new HashMap<>();
            }
            try {
                JSONObject jSONObject4 = new JSONObject(data2);
                Iterator<String> keys2 = jSONObject4.keys();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    if (!(jSONObject4.get(next2) instanceof JSONObject)) {
                        if (!(jSONObject4.get(next2) instanceof String)) {
                            map2.put(next2, null);
                        }
                    }
                    if (jSONObject4.get(next2) instanceof JSONObject) {
                        jSONObject = jSONObject4.getJSONObject(next2);
                    } else {
                        jSONObject = new JSONObject((String) jSONObject4.get(next2));
                    }
                    String string3 = jSONObject.getString("vNo");
                    Long valueOf3 = Long.valueOf(jSONObject.getLong("tS"));
                    Integer valueOf4 = Integer.valueOf(jSONObject.getInt("eta"));
                    Integer valueOf5 = Integer.valueOf(jSONObject.optInt("minEta", -1));
                    Integer valueOf6 = Integer.valueOf(jSONObject.optInt("maxEta", -1));
                    EtaInfo etaInfo = new EtaInfo(next2, valueOf4.intValue(), string3, valueOf3.longValue());
                    etaInfo.set_maxEta(valueOf6.intValue());
                    etaInfo.set_minEta(valueOf5.intValue());
                    if (!map2.containsKey(next2) || isPollingStatus2) {
                        map2.put(next2, etaInfo);
                    } else if (map2.get(next2) != null && etaInfo.get_timeStamp() > ((EtaInfo) map2.get(next2)).get_timeStamp()) {
                        map2.remove(next2);
                        map2.put(next2, etaInfo);
                    }
                    keys2 = keys2;
                }
            } catch (JSONException e3) {
                b00 b003 = b00.f358a;
                hj1.X0(e3, b00.a());
            }
            this.f1072a.remove(referenceType);
            this.f1072a.put(referenceType, map2);
            ArrayList arrayList2 = new ArrayList();
            for (Map.Entry<String, DataInfo> entry3 : this.f1072a.get(referenceType).entrySet()) {
                if (entry3.getValue() != null) {
                    arrayList2.add(entry3.getValue());
                }
            }
            if (this.l.get(referenceType) == null) {
                b00 b004 = b00.f358a;
                hj1.Q0(referenceType, b00.a());
                return;
            }
            for (Map.Entry<Integer, ji1<Object, String>> entry4 : this.l.get(referenceType).entrySet()) {
                entry4.getValue().onSuccess(arrayList2);
            }
            return;
        }
        if (referenceType.startsWith("allRoutesEtas:" + lowerCase)) {
            try {
                Map<String, List<EtaInfo>> h2 = h(new JSONObject(realTimeSocketDataEvent.getData()));
                if (this.l.get(referenceType) == null) {
                    b00 b005 = b00.f358a;
                    b00.a().b(new Throwable(referenceType));
                } else {
                    for (Map.Entry<Integer, ji1<Object, String>> entry5 : this.l.get(referenceType).entrySet()) {
                        entry5.getValue().onSuccess(h2);
                    }
                }
                String.valueOf(h2);
            } catch (JSONException e4) {
                b00 b006 = b00.f358a;
                hj1.X0(e4, b00.a());
            }
        }
    }
}
