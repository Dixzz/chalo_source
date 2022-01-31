package defpackage;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.razorpay.AnalyticsConstants;
import defpackage.ae5;
import defpackage.id5;
import defpackage.je5;
import defpackage.nc5;
import defpackage.xd5;
import defpackage.yd5;
import defpackage.zc5;
import defpackage.zd5;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.net.ssl.SSLSocketFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(16)
/* renamed from: ge5  reason: default package */
/* compiled from: ViewCrawler */
public class ge5 implements fe5, de5, je5.j {

    /* renamed from: a  reason: collision with root package name */
    public final jc5 f1245a;
    public final Context b;
    public final nc5 c;
    public final wd5 d;
    public final yd5 e = new yd5();
    public final id5 f;
    public final Map<String, String> g;
    public final g h;
    public final float i;
    public final Set<vc5> j;

    /* renamed from: ge5$a */
    /* compiled from: ViewCrawler */
    public class a implements id5.a {
        public a() {
        }

        @Override // defpackage.id5.a
        public void a() {
            ge5.this.h.sendMessage(ge5.this.h.obtainMessage(4));
        }
    }

    /* renamed from: ge5$b */
    /* compiled from: ViewCrawler */
    public class b implements zd5.b {
        public b(a aVar) {
        }
    }

    /* renamed from: ge5$c */
    /* compiled from: ViewCrawler */
    public class c implements Runnable {
        public volatile boolean f = true;

        public c() {
        }

        public void run() {
            if (!this.f) {
                ge5.this.h.sendMessage(ge5.this.h.obtainMessage(1));
            }
            ge5.this.h.postDelayed(this, 30000);
        }
    }

    /* renamed from: ge5$d */
    /* compiled from: ViewCrawler */
    public class d implements Application.ActivityLifecycleCallbacks, ae5.a {
        public final ae5 f = new ae5(this);
        public final c g;

        public d() {
            this.g = new c();
        }

        public final boolean a() {
            String str = Build.HARDWARE;
            if (!str.toLowerCase().equals("goldfish") && !str.toLowerCase().equals("ranchu")) {
                return false;
            }
            String str2 = Build.BRAND;
            if ((str2.toLowerCase().startsWith("generic") || str2.toLowerCase().equals("android") || str2.toLowerCase().equals("google")) && Build.DEVICE.toLowerCase().startsWith("generic") && Build.PRODUCT.toLowerCase().contains(AnalyticsConstants.SDK) && Build.MODEL.toLowerCase(Locale.US).contains(AnalyticsConstants.SDK)) {
                return true;
            }
            return false;
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
            yd5 yd5 = ge5.this.e;
            Objects.requireNonNull(yd5);
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                yd5.f966a.remove(activity);
                if (a() && !ge5.this.f1245a.h) {
                    c cVar = this.g;
                    cVar.f = true;
                    ge5.this.h.removeCallbacks(cVar);
                } else if (!ge5.this.f1245a.g) {
                    ((SensorManager) activity.getSystemService("sensor")).unregisterListener(this.f);
                }
            } else {
                throw new RuntimeException("Can't remove an activity when not on the UI thread");
            }
        }

        public void onActivityResumed(Activity activity) {
            if (a() && !ge5.this.f1245a.h) {
                c cVar = this.g;
                cVar.f = false;
                ge5.this.h.post(cVar);
            } else if (!ge5.this.f1245a.g) {
                SensorManager sensorManager = (SensorManager) activity.getSystemService("sensor");
                sensorManager.registerListener(this.f, sensorManager.getDefaultSensor(1), 3);
            }
            yd5 yd5 = ge5.this.e;
            Objects.requireNonNull(yd5);
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                yd5.f966a.add(activity);
                yd5.c();
                return;
            }
            throw new RuntimeException("Can't add an activity when not on the UI thread");
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    /* renamed from: ge5$e */
    /* compiled from: ViewCrawler */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public final String f1248a;
        public final String b;
        public final JSONObject c;
        public final sd5<Integer, Integer> d;

        public e(String str, String str2, JSONObject jSONObject, sd5<Integer, Integer> sd5) {
            this.f1248a = str;
            this.b = str2;
            this.c = jSONObject;
            this.d = sd5;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof e) || obj.hashCode() != hashCode()) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.f1248a.hashCode();
        }
    }

    /* renamed from: ge5$f */
    /* compiled from: ViewCrawler */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public final String f1249a;
        public final JSONObject b;
        public final sd5<Integer, Integer> c;

        public f(String str, JSONObject jSONObject, sd5<Integer, Integer> sd5) {
            this.f1249a = str;
            this.b = jSONObject;
            this.c = sd5;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof f) || obj.hashCode() != hashCode()) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.f1249a.hashCode();
        }
    }

    /* renamed from: ge5$g */
    /* compiled from: ViewCrawler */
    public class g extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public zd5 f1250a;
        public ie5 b = null;
        public final String c;
        public final Lock d;
        public final xd5 e;
        public final qd5 f;
        public final Map<String, sd5<String, JSONObject>> g;
        public final Map<String, sd5<String, Object>> h;
        public final List<String> i;
        public final Map<String, sd5<String, JSONObject>> j;
        public final Set<e> k;
        public final Set<f> l;
        public final Set<sd5<Integer, Integer>> m;
        public final Set<sd5<String, JSONObject>> n;
        public final Set<sd5<String, JSONObject>> o;
        public final Set<sd5<Integer, Integer>> p;

        public g(Context context, String str, Looper looper, je5.j jVar) {
            super(looper);
            this.c = str;
            String str2 = ge5.this.f1245a.s;
            zc5.b bVar = new zc5.b(str2 == null ? context.getPackageName() : str2, context);
            qd5 qd5 = new qd5(context, "ViewCrawler");
            this.f = qd5;
            this.e = new xd5(context, bVar, qd5, jVar);
            this.o = new HashSet();
            this.g = new HashMap();
            this.h = new HashMap();
            this.i = new ArrayList();
            this.j = new HashMap();
            this.k = new HashSet();
            this.l = new HashSet();
            this.m = new HashSet();
            this.n = new HashSet();
            this.p = new HashSet();
            ReentrantLock reentrantLock = new ReentrantLock();
            this.d = reentrantLock;
            reentrantLock.lock();
        }

        public final void a() {
            List list;
            HashMap hashMap;
            HashMap hashMap2;
            ArrayList arrayList = new ArrayList();
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            for (e eVar : this.k) {
                try {
                    arrayList.add(new sd5(eVar.b, this.e.c(eVar.c).f3918a));
                    if (!this.p.contains(eVar.d)) {
                        hashSet.add(eVar.d);
                    }
                } catch (xd5.b | xd5.c unused) {
                } catch (xd5.e e2) {
                    e2.getMessage();
                }
            }
            for (f fVar : this.l) {
                try {
                    sd5<String, Object> h2 = this.e.h(fVar.b);
                    if (!this.p.contains(fVar.c)) {
                        hashSet.add(fVar.c);
                        hashSet2.add(((Pair) h2).first);
                    } else if (ge5.this.f.b((String) ((Pair) h2).first, ((Pair) h2).second)) {
                        hashSet2.add(((Pair) h2).first);
                    }
                    id5 id5 = ge5.this.f;
                    synchronized (id5) {
                        hashMap2 = new HashMap(id5.f1507a);
                    }
                    if (!hashMap2.containsKey(((Pair) h2).first)) {
                        id5.b a2 = id5.b.a(fVar.b);
                        id5 id52 = ge5.this.f;
                        String str = (String) ((Pair) h2).first;
                        Objects.requireNonNull(id52);
                        if (!(str == null || a2 == null)) {
                            id52.c.put(str, a2);
                        }
                    } else {
                        ge5.this.f.c((String) ((Pair) h2).first, ((Pair) h2).second);
                    }
                } catch (xd5.b unused2) {
                }
            }
            if (this.l.size() == 0) {
                id5 id53 = ge5.this.f;
                synchronized (id53) {
                    hashMap = new HashMap(id53.b);
                }
                for (Map.Entry entry : hashMap.entrySet()) {
                    id5.b bVar = (id5.b) entry.getValue();
                    String str2 = (String) entry.getKey();
                    if (ge5.this.f.b(str2, bVar.b)) {
                        ge5.this.f.c(str2, bVar.b);
                        hashSet2.add(str2);
                    }
                }
            }
            for (sd5<String, JSONObject> sd5 : this.g.values()) {
                try {
                    xd5.d c2 = this.e.c((JSONObject) ((Pair) sd5).second);
                    arrayList.add(new sd5(((Pair) sd5).first, c2.f3918a));
                    this.i.addAll(c2.b);
                } catch (xd5.b | xd5.c unused3) {
                } catch (xd5.e e3) {
                    e3.getMessage();
                }
            }
            for (sd5<String, Object> sd52 : this.h.values()) {
                if (ge5.this.f.b((String) ((Pair) sd52).first, ((Pair) sd52).second)) {
                    hashSet2.add(((Pair) sd52).first);
                }
                ge5.this.f.c((String) ((Pair) sd52).first, ((Pair) sd52).second);
            }
            if (this.j.size() == 0 && this.o.size() == 0) {
                for (sd5<String, JSONObject> sd53 : this.n) {
                    try {
                        arrayList.add(new sd5(((Pair) sd53).first, this.e.d((JSONObject) ((Pair) sd53).second, ge5.this.d)));
                    } catch (xd5.e e4) {
                        e4.getMessage();
                    } catch (xd5.b unused4) {
                    }
                }
            }
            for (sd5<String, JSONObject> sd54 : this.j.values()) {
                try {
                    arrayList.add(new sd5(((Pair) sd54).first, this.e.d((JSONObject) ((Pair) sd54).second, ge5.this.d)));
                } catch (xd5.e e5) {
                    e5.getMessage();
                } catch (xd5.b unused5) {
                }
            }
            HashMap hashMap3 = new HashMap();
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                sd5 sd55 = (sd5) arrayList.get(i2);
                if (hashMap3.containsKey(((Pair) sd55).first)) {
                    list = (List) hashMap3.get(((Pair) sd55).first);
                } else {
                    list = new ArrayList();
                    hashMap3.put(((Pair) sd55).first, list);
                }
                list.add(((Pair) sd55).second);
            }
            yd5 yd5 = ge5.this.e;
            synchronized (yd5.d) {
                for (yd5.b bVar2 : yd5.d) {
                    bVar2.f = true;
                    bVar2.j.post(bVar2);
                }
                yd5.d.clear();
            }
            synchronized (yd5.c) {
                yd5.c.clear();
                yd5.c.putAll(hashMap3);
            }
            yd5.c();
            for (sd5<Integer, Integer> sd56 : this.m) {
                if (!this.p.contains(sd56)) {
                    hashSet.add(sd56);
                }
            }
            this.p.addAll(hashSet);
            if (hashSet.size() > 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        sd5 sd57 = (sd5) it.next();
                        int intValue = ((Integer) ((Pair) sd57).first).intValue();
                        int intValue2 = ((Integer) ((Pair) sd57).second).intValue();
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("$experiment_id", intValue);
                        jSONObject2.put("$variant_id", intValue2);
                        jSONObject.put(Integer.toString(intValue), intValue2);
                        nc5.e eVar2 = ge5.this.c.e;
                        if (!nc5.this.m()) {
                            JSONObject jSONObject3 = new JSONObject();
                            try {
                                jSONObject3.put("$experiments", jSONObject);
                                nc5.a(nc5.this, eVar2.j("$merge", jSONObject3));
                            } catch (JSONException unused6) {
                            }
                        }
                        ge5.this.c.v(new he5(this, jSONObject));
                        nc5 nc5 = ge5.this.c;
                        if (!nc5.m()) {
                            nc5.s("$experiment_started", jSONObject2, false);
                        }
                    }
                } catch (JSONException e6) {
                    if (rd5.a(6)) {
                        Log.wtf("MixpanelAPI.ViewCrawler", "Could not build JSON for reporting experiment start", e6);
                    }
                }
            }
            this.m.clear();
            if (hashSet2.size() > 0) {
                for (vc5 vc5 : ge5.this.j) {
                    vc5.a(hashSet2);
                }
            }
        }

        public final void b() {
            SSLSocketFactory c2;
            zd5 zd5 = this.f1250a;
            if ((zd5 == null || !zd5.c()) && (c2 = ge5.this.f1245a.c()) != null) {
                try {
                    this.f1250a = new zd5(new URI(jc5.b(ge5.this.b).r + this.c), new b(null), c2.createSocket());
                } catch (IOException | URISyntaxException | zd5.d unused) {
                }
            }
        }

        public final SharedPreferences c() {
            StringBuilder i0 = hj1.i0("mixpanel.viewcrawler.changes");
            i0.append(this.c);
            return ge5.this.b.getSharedPreferences(i0.toString(), 0);
        }

        public final void d(JSONObject jSONObject) {
            try {
                JSONArray jSONArray = jSONObject.getJSONObject("payload").getJSONArray(AnalyticsConstants.EVENTS);
                int length = jSONArray.length();
                this.j.clear();
                if (!this.n.isEmpty() && this.o.isEmpty()) {
                    this.o.addAll(this.n);
                    for (sd5<String, JSONObject> sd5 : this.n) {
                        try {
                            this.j.put(((JSONObject) ((Pair) sd5).second).get("path").toString(), sd5);
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                    this.n.clear();
                }
                for (int i2 = 0; i2 < length; i2++) {
                    try {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                        this.j.put(jSONObject2.get("path").toString(), new sd5<>(hd3.n2(jSONObject2, "target_activity"), jSONObject2));
                    } catch (JSONException unused) {
                        jSONArray.toString();
                    }
                }
                a();
            } catch (JSONException unused2) {
            }
        }

        public final void e(JSONObject jSONObject) {
            try {
                JSONArray jSONArray = jSONObject.getJSONObject("payload").getJSONArray("actions");
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    String n2 = hd3.n2(jSONObject2, "target_activity");
                    this.g.put(jSONObject2.getString("name"), new sd5<>(n2, jSONObject2));
                }
                a();
            } catch (JSONException unused) {
            }
        }

        public final void f() {
            this.g.clear();
            this.j.clear();
            this.h.clear();
            this.n.addAll(this.o);
            this.o.clear();
            this.b = null;
            a();
            for (String str : this.i) {
                File c2 = this.f.c(str);
                if (c2 != null) {
                    c2.delete();
                    synchronized (qd5.e) {
                        qd5.e.remove(str);
                    }
                }
            }
        }

        public final void g(String str) {
            if (str != null) {
                try {
                    JSONArray jSONArray = new JSONArray(str);
                    this.n.clear();
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i2);
                        this.n.add(new sd5<>(hd3.n2(jSONObject, "target_activity"), jSONObject));
                    }
                } catch (JSONException unused) {
                    SharedPreferences.Editor edit = c().edit();
                    edit.remove("mixpanel.viewcrawler.bindings");
                    edit.apply();
                }
            }
        }

        public final void h() {
            SharedPreferences c2 = c();
            String string = c2.getString("mixpanel.viewcrawler.changes", null);
            String string2 = c2.getString("mixpanel.viewcrawler.bindings", null);
            this.k.clear();
            this.l.clear();
            this.p.clear();
            i(string, false);
            this.n.clear();
            g(string2);
            a();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v2, resolved type: java.util.Map<java.lang.String, sd5<java.lang.String, java.lang.Object>> */
        /* JADX WARN: Multi-variable type inference failed */
        public void handleMessage(Message message) {
            this.d.lock();
            try {
                int i2 = 0;
                switch (message.what) {
                    case 0:
                        h();
                        break;
                    case 1:
                        b();
                        break;
                    case 2:
                        n((JSONObject) message.obj);
                        break;
                    case 3:
                        e((JSONObject) message.obj);
                        break;
                    case 4:
                        j();
                        break;
                    case 5:
                        JSONArray jSONArray = (JSONArray) message.obj;
                        SharedPreferences.Editor edit = c().edit();
                        edit.putString("mixpanel.viewcrawler.bindings", jSONArray.toString());
                        edit.apply();
                        g(jSONArray.toString());
                        a();
                        break;
                    case 6:
                        d((JSONObject) message.obj);
                        break;
                    case 7:
                        m((String) message.obj);
                        break;
                    case 8:
                        f();
                        break;
                    case 9:
                        JSONArray jSONArray2 = (JSONArray) message.obj;
                        SharedPreferences.Editor edit2 = c().edit();
                        edit2.putString("mixpanel.viewcrawler.changes", jSONArray2.toString());
                        edit2.apply();
                        i(jSONArray2.toString(), true);
                        a();
                        break;
                    case 10:
                        try {
                            JSONArray jSONArray3 = ((JSONObject) message.obj).getJSONObject("payload").getJSONArray("actions");
                            while (i2 < jSONArray3.length()) {
                                this.g.remove(jSONArray3.getString(i2));
                                i2++;
                            }
                        } catch (JSONException unused) {
                        }
                        a();
                        break;
                    case 11:
                        try {
                            JSONArray jSONArray4 = ((JSONObject) message.obj).getJSONObject("payload").getJSONArray("tweaks");
                            int length = jSONArray4.length();
                            while (i2 < length) {
                                sd5<String, Object> h2 = this.e.h(jSONArray4.getJSONObject(i2));
                                this.h.put(((Pair) h2).first, h2);
                                i2++;
                            }
                        } catch (JSONException | xd5.b unused2) {
                        }
                        a();
                        break;
                    case 12:
                        l((je5.f) message.obj);
                        break;
                    case 13:
                        SharedPreferences.Editor edit3 = c().edit();
                        edit3.putString("mixpanel.viewcrawler.changes", ((JSONArray) message.obj).toString());
                        edit3.apply();
                        break;
                }
            } finally {
                this.d.unlock();
            }
        }

        public final void i(String str, boolean z) {
            if (str != null) {
                try {
                    JSONArray jSONArray = new JSONArray(str);
                    int length = jSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i2);
                        sd5<Integer, Integer> sd5 = new sd5<>(Integer.valueOf(jSONObject.getInt("experiment_id")), Integer.valueOf(jSONObject.getInt("id")));
                        JSONArray jSONArray2 = jSONObject.getJSONArray("actions");
                        int length2 = jSONArray2.length();
                        for (int i3 = 0; i3 < length2; i3++) {
                            JSONObject jSONObject2 = jSONArray2.getJSONObject(i3);
                            this.k.add(new e(jSONObject2.getString("name"), hd3.n2(jSONObject2, "target_activity"), jSONObject2, sd5));
                        }
                        JSONArray jSONArray3 = jSONObject.getJSONArray("tweaks");
                        int length3 = jSONArray3.length();
                        for (int i4 = 0; i4 < length3; i4++) {
                            JSONObject jSONObject3 = jSONArray3.getJSONObject(i4);
                            this.l.add(new f(jSONObject3.getString("name"), jSONObject3, sd5));
                        }
                        if (!z) {
                            this.p.add(sd5);
                        }
                        if (length3 == 0 && length2 == 0) {
                            this.m.add(sd5);
                        }
                    }
                } catch (JSONException unused) {
                    SharedPreferences.Editor edit = c().edit();
                    edit.remove("mixpanel.viewcrawler.changes");
                    edit.apply();
                }
            }
        }

        /* JADX WARNING: Missing exception handler attribute for start block: B:54:0x0211 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void j() {
            /*
            // Method dump skipped, instructions count: 533
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.ge5.g.j():void");
        }

        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003e */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void k(java.lang.String r3) {
            /*
                r2 = this;
                zd5 r0 = r2.f1250a
                if (r0 == 0) goto L_0x0047
                boolean r0 = r0.c()
                if (r0 == 0) goto L_0x0047
                zd5 r0 = r2.f1250a
                boolean r0 = r0.b()
                if (r0 != 0) goto L_0x0013
                goto L_0x0047
            L_0x0013:
                org.json.JSONObject r0 = new org.json.JSONObject
                r0.<init>()
                java.lang.String r1 = "error_message"
                r0.put(r1, r3)     // Catch:{ JSONException -> 0x001d }
            L_0x001d:
                java.io.OutputStreamWriter r3 = new java.io.OutputStreamWriter
                zd5 r1 = r2.f1250a
                java.io.BufferedOutputStream r1 = r1.a()
                r3.<init>(r1)
                java.lang.String r1 = "{\"type\": \"error\", "
                r3.write(r1)     // Catch:{ IOException -> 0x003e, all -> 0x0042 }
                java.lang.String r1 = "\"payload\": "
                r3.write(r1)     // Catch:{ IOException -> 0x003e, all -> 0x0042 }
                java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x003e, all -> 0x0042 }
                r3.write(r0)     // Catch:{ IOException -> 0x003e, all -> 0x0042 }
                java.lang.String r0 = "}"
                r3.write(r0)     // Catch:{ IOException -> 0x003e, all -> 0x0042 }
            L_0x003e:
                r3.close()     // Catch:{ IOException -> 0x0047 }
                goto L_0x0047
            L_0x0042:
                r0 = move-exception
                r3.close()     // Catch:{ IOException -> 0x0046 }
            L_0x0046:
                throw r0
            L_0x0047:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.ge5.g.k(java.lang.String):void");
        }

        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x004a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void l(defpackage.je5.f r4) {
            /*
                r3 = this;
                zd5 r0 = r3.f1250a
                if (r0 == 0) goto L_0x0053
                boolean r0 = r0.c()
                if (r0 == 0) goto L_0x0053
                zd5 r0 = r3.f1250a
                boolean r0 = r0.b()
                if (r0 != 0) goto L_0x0013
                goto L_0x0053
            L_0x0013:
                zd5 r0 = r3.f1250a
                java.io.BufferedOutputStream r0 = r0.a()
                java.io.OutputStreamWriter r1 = new java.io.OutputStreamWriter
                r1.<init>(r0)
                android.util.JsonWriter r0 = new android.util.JsonWriter
                r0.<init>(r1)
                r0.beginObject()     // Catch:{ IOException -> 0x004a, all -> 0x004e }
                java.lang.String r1 = "type"
                android.util.JsonWriter r1 = r0.name(r1)     // Catch:{ IOException -> 0x004a, all -> 0x004e }
                java.lang.String r2 = "layout_error"
                r1.value(r2)     // Catch:{ IOException -> 0x004a, all -> 0x004e }
                java.lang.String r1 = "exception_type"
                android.util.JsonWriter r1 = r0.name(r1)     // Catch:{ IOException -> 0x004a, all -> 0x004e }
                java.lang.String r2 = r4.f1914a     // Catch:{ IOException -> 0x004a, all -> 0x004e }
                r1.value(r2)     // Catch:{ IOException -> 0x004a, all -> 0x004e }
                java.lang.String r1 = "cid"
                android.util.JsonWriter r1 = r0.name(r1)     // Catch:{ IOException -> 0x004a, all -> 0x004e }
                java.lang.String r4 = r4.b     // Catch:{ IOException -> 0x004a, all -> 0x004e }
                r1.value(r4)     // Catch:{ IOException -> 0x004a, all -> 0x004e }
                r0.endObject()     // Catch:{ IOException -> 0x004a, all -> 0x004e }
            L_0x004a:
                r0.close()     // Catch:{ IOException -> 0x0053 }
                goto L_0x0053
            L_0x004e:
                r4 = move-exception
                r0.close()     // Catch:{ IOException -> 0x0052 }
            L_0x0052:
                throw r4
            L_0x0053:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.ge5.g.l(je5$f):void");
        }

        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x004b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void m(java.lang.String r4) {
            /*
                r3 = this;
                zd5 r0 = r3.f1250a
                if (r0 == 0) goto L_0x0054
                boolean r0 = r0.c()
                if (r0 == 0) goto L_0x0054
                zd5 r0 = r3.f1250a
                boolean r0 = r0.b()
                if (r0 != 0) goto L_0x0013
                goto L_0x0054
            L_0x0013:
                zd5 r0 = r3.f1250a
                java.io.BufferedOutputStream r0 = r0.a()
                java.io.OutputStreamWriter r1 = new java.io.OutputStreamWriter
                r1.<init>(r0)
                android.util.JsonWriter r0 = new android.util.JsonWriter
                r0.<init>(r1)
                r0.beginObject()     // Catch:{ IOException -> 0x004b, all -> 0x004f }
                java.lang.String r1 = "type"
                android.util.JsonWriter r1 = r0.name(r1)     // Catch:{ IOException -> 0x004b, all -> 0x004f }
                java.lang.String r2 = "track_message"
                r1.value(r2)     // Catch:{ IOException -> 0x004b, all -> 0x004f }
                java.lang.String r1 = "payload"
                r0.name(r1)     // Catch:{ IOException -> 0x004b, all -> 0x004f }
                r0.beginObject()     // Catch:{ IOException -> 0x004b, all -> 0x004f }
                java.lang.String r1 = "event_name"
                android.util.JsonWriter r1 = r0.name(r1)     // Catch:{ IOException -> 0x004b, all -> 0x004f }
                r1.value(r4)     // Catch:{ IOException -> 0x004b, all -> 0x004f }
                r0.endObject()     // Catch:{ IOException -> 0x004b, all -> 0x004f }
                r0.endObject()     // Catch:{ IOException -> 0x004b, all -> 0x004f }
                r0.flush()     // Catch:{ IOException -> 0x004b, all -> 0x004f }
            L_0x004b:
                r0.close()     // Catch:{ IOException -> 0x0054 }
                goto L_0x0054
            L_0x004f:
                r4 = move-exception
                r0.close()     // Catch:{ IOException -> 0x0053 }
            L_0x0053:
                throw r4
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.ge5.g.m(java.lang.String):void");
        }

        /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0068 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void n(org.json.JSONObject r7) {
            /*
            // Method dump skipped, instructions count: 129
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.ge5.g.n(org.json.JSONObject):void");
        }
    }

    public ge5(Context context, String str, nc5 nc5, id5 id5) {
        this.f1245a = jc5.b(context);
        this.b = context;
        this.f = id5;
        this.g = nc5.k;
        this.i = Resources.getSystem().getDisplayMetrics().scaledDensity;
        this.j = Collections.newSetFromMap(new ConcurrentHashMap());
        HandlerThread handlerThread = new HandlerThread(ge5.class.getCanonicalName());
        handlerThread.setPriority(10);
        handlerThread.start();
        g gVar = new g(context, str, handlerThread.getLooper(), this);
        this.h = gVar;
        this.d = new wd5(nc5, gVar);
        this.c = nc5;
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new d());
        a aVar = new a();
        synchronized (id5) {
            id5.d.add(aVar);
        }
    }

    @Override // defpackage.fe5
    public void a(vc5 vc5) {
        this.j.remove(vc5);
    }

    @Override // defpackage.de5
    public void b(String str) {
        Message obtainMessage = this.h.obtainMessage();
        obtainMessage.what = 7;
        obtainMessage.obj = str;
        this.h.sendMessage(obtainMessage);
    }

    @Override // defpackage.fe5
    public void c(JSONArray jSONArray) {
        if (jSONArray != null) {
            Message obtainMessage = this.h.obtainMessage(5);
            obtainMessage.obj = jSONArray;
            this.h.sendMessage(obtainMessage);
        }
    }

    @Override // defpackage.fe5
    public void d(JSONArray jSONArray) {
        if (jSONArray != null) {
            Message obtainMessage = this.h.obtainMessage(13);
            obtainMessage.obj = jSONArray;
            this.h.sendMessage(obtainMessage);
        }
    }

    @Override // defpackage.fe5
    public void e() {
        this.h.d.unlock();
        g gVar = this.h;
        gVar.sendMessage(gVar.obtainMessage(0));
    }

    @Override // defpackage.fe5
    public void f() {
        g gVar = this.h;
        gVar.sendMessage(gVar.obtainMessage(0));
    }

    @Override // defpackage.fe5
    public void g(vc5 vc5) {
        Objects.requireNonNull(vc5, "Listener cannot be null");
        this.j.add(vc5);
    }

    @Override // defpackage.fe5
    public void h(JSONArray jSONArray) {
        if (jSONArray != null) {
            Message obtainMessage = this.h.obtainMessage(9);
            obtainMessage.obj = jSONArray;
            this.h.sendMessage(obtainMessage);
        }
    }
}
