package defpackage;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.Constants;
import com.mixpanel.android.mpmetrics.InAppNotification;
import com.razorpay.AnalyticsConstants;
import defpackage.ac5;
import defpackage.ec5;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: nc5  reason: default package */
/* compiled from: MixpanelAPI */
public class nc5 {
    public static final Map<String, Map<Context, nc5>> o = new HashMap();
    public static final cd5 p = new cd5();
    public static final id5 q = new id5();
    public static Future<SharedPreferences> r;

    /* renamed from: a  reason: collision with root package name */
    public final Context f2534a;
    public final ac5 b;
    public final jc5 c;
    public final String d;
    public final e e = new e(null);
    public final fe5 f;
    public final xc5 g;
    public final g h;
    public final de5 i;
    public final ec5 j;
    public final Map<String, String> k;
    public final Map<String, Long> l;
    public qc5 m;
    public final bd5 n;

    /* renamed from: nc5$a */
    /* compiled from: MixpanelAPI */
    public class a extends BroadcastReceiver {
        public a() {
        }

        public void onReceive(Context context, Intent intent) {
            JSONObject jSONObject = new JSONObject();
            Bundle bundleExtra = intent.getBundleExtra("event_args");
            if (bundleExtra != null) {
                for (String str : bundleExtra.keySet()) {
                    try {
                        jSONObject.put(str, bundleExtra.get(str));
                    } catch (JSONException unused) {
                    }
                }
            }
            nc5 nc5 = nc5.this;
            StringBuilder i0 = hj1.i0("$");
            i0.append(intent.getStringExtra("event_name"));
            nc5.r(i0.toString(), jSONObject);
        }
    }

    /* renamed from: nc5$b */
    /* compiled from: MixpanelAPI */
    public interface b {
        void a(nc5 nc5);
    }

    /* renamed from: nc5$c */
    /* compiled from: MixpanelAPI */
    public class c implements fe5 {
        public c(nc5 nc5, id5 id5) {
        }

        @Override // defpackage.fe5
        public void a(vc5 vc5) {
        }

        @Override // defpackage.fe5
        public void c(JSONArray jSONArray) {
        }

        @Override // defpackage.fe5
        public void d(JSONArray jSONArray) {
        }

        @Override // defpackage.fe5
        public void e() {
        }

        @Override // defpackage.fe5
        public void f() {
        }

        @Override // defpackage.fe5
        public void g(vc5 vc5) {
        }

        @Override // defpackage.fe5
        public void h(JSONArray jSONArray) {
        }
    }

    /* renamed from: nc5$d */
    /* compiled from: MixpanelAPI */
    public interface d {
        void a(String str);
    }

    /* renamed from: nc5$e */
    /* compiled from: MixpanelAPI */
    public class e implements d {
        public e(lc5 lc5) {
        }

        @Override // defpackage.nc5.d
        public void a(String str) {
            if (!nc5.this.m() && str != null) {
                synchronized (nc5.this.g) {
                    xc5 xc5 = nc5.this.g;
                    synchronized (xc5) {
                        if (!xc5.i) {
                            xc5.e();
                        }
                        xc5.l = str;
                        xc5.k();
                    }
                    nc5.this.j.c(str);
                }
                nc5.b(nc5.this, str);
            }
        }

        public void b(String str, Object obj) {
            if (!nc5.this.m()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(str, obj);
                    nc5.a(nc5.this, j("$append", jSONObject));
                } catch (JSONException unused) {
                }
            }
        }

        public String c() {
            return nc5.this.g.c();
        }

        public InAppNotification d() {
            nc5 nc5 = nc5.this;
            ec5 ec5 = nc5.j;
            boolean z = nc5.c.f;
            synchronized (ec5) {
                if (ec5.d.isEmpty()) {
                    return null;
                }
                InAppNotification remove = ec5.d.remove(0);
                if (z) {
                    ec5.d.add(remove);
                } else {
                    String str = "Recording notification " + remove + " as seen.";
                }
                return remove;
            }
        }

        public void e(String str, double d) {
            if (!nc5.this.m()) {
                HashMap hashMap = new HashMap();
                hashMap.put(str, Double.valueOf(d));
                if (!nc5.this.m()) {
                    try {
                        nc5.a(nc5.this, j("$add", new JSONObject(hashMap)));
                    } catch (JSONException unused) {
                    }
                }
            }
        }

        public void f() {
            JSONArray jSONArray;
            ec5 ec5 = nc5.this.j;
            synchronized (ec5) {
                jSONArray = ec5.h;
            }
            nc5.this.f.h(jSONArray);
        }

        public void g(JSONObject jSONObject) {
            if (!nc5.this.m()) {
                try {
                    JSONObject jSONObject2 = new JSONObject(nc5.this.k);
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        jSONObject2.put(next, jSONObject.get(next));
                    }
                    nc5.a(nc5.this, j("$set", jSONObject2));
                } catch (JSONException unused) {
                }
            }
        }

        public void h(String str, Object obj) {
            if (!nc5.this.m()) {
                try {
                    JSONObject put = new JSONObject().put(str, obj);
                    if (!nc5.this.m()) {
                        nc5.a(nc5.this, j("$set_once", put));
                    }
                } catch (JSONException unused) {
                }
            }
        }

        public void i(String str) {
            synchronized (nc5.this.g) {
                xc5 xc5 = nc5.this.g;
                synchronized (xc5) {
                    try {
                        SharedPreferences.Editor edit = xc5.f3912a.get().edit();
                        edit.putString("push_id", str);
                        edit.apply();
                    } catch (ExecutionException e) {
                        e.getCause();
                    } catch (InterruptedException unused) {
                    }
                }
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(str);
                if (!nc5.this.m()) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("$android_devices", jSONArray);
                        nc5.a(nc5.this, j("$union", jSONObject));
                    } catch (JSONException unused2) {
                    }
                }
            }
            return;
        }

        public final JSONObject j(String str, Object obj) throws JSONException {
            boolean z;
            JSONObject jSONObject = new JSONObject();
            String c = c();
            String i = nc5.this.i();
            jSONObject.put(str, obj);
            jSONObject.put("$token", nc5.this.d);
            jSONObject.put("$time", System.currentTimeMillis());
            xc5 xc5 = nc5.this.g;
            synchronized (xc5) {
                if (!xc5.i) {
                    xc5.e();
                }
                z = xc5.n;
            }
            jSONObject.put("$had_persisted_distinct_id", z);
            if (i != null) {
                jSONObject.put("$device_id", i);
            }
            if (c != null) {
                jSONObject.put("$distinct_id", c);
                jSONObject.put("$user_id", c);
            }
            jSONObject.put("$mp_metadata", nc5.this.n.a(false));
            return jSONObject;
        }

        public void k(String str, InAppNotification inAppNotification, JSONObject jSONObject) {
            if (!nc5.this.m()) {
                JSONObject a2 = inAppNotification.a();
                if (jSONObject != null) {
                    try {
                        Iterator<String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            a2.put(next, jSONObject.get(next));
                        }
                    } catch (JSONException unused) {
                    }
                }
                nc5 nc5 = nc5.this;
                if (!nc5.m()) {
                    nc5.s(str, a2, false);
                }
            }
        }

        public void l(InAppNotification inAppNotification) {
            if (inAppNotification != null) {
                xc5 xc5 = nc5.this.g;
                Integer valueOf = Integer.valueOf(inAppNotification.h);
                synchronized (xc5) {
                    try {
                        SharedPreferences sharedPreferences = xc5.f3912a.get();
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        String string = sharedPreferences.getString("seen_campaign_ids", "");
                        edit.putString("seen_campaign_ids", string + valueOf + ",");
                        edit.apply();
                    } catch (ExecutionException e) {
                        e.getCause();
                    } catch (InterruptedException unused) {
                    }
                }
                if (!nc5.this.m()) {
                    oc5 oc5 = null;
                    k("$campaign_delivery", inAppNotification, null);
                    e eVar = nc5.this.e;
                    String c = c();
                    Objects.requireNonNull(eVar);
                    if (c != null) {
                        oc5 = new oc5(eVar, c);
                    }
                    if (oc5 != null) {
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
                        JSONObject a2 = inAppNotification.a();
                        try {
                            a2.put("$time", simpleDateFormat.format(new Date()));
                        } catch (JSONException unused2) {
                        }
                        oc5.b("$campaigns", Integer.valueOf(inAppNotification.h));
                        oc5.b("$notifications", a2);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
    }

    /* renamed from: nc5$f */
    /* compiled from: MixpanelAPI */
    public class f implements g, Runnable {
        public final Set<wc5> f = Collections.newSetFromMap(new ConcurrentHashMap());
        public final Executor g = Executors.newSingleThreadExecutor();

        public f(lc5 lc5) {
        }

        public void run() {
            for (wc5 wc5 : this.f) {
                wc5.a();
            }
        }
    }

    /* renamed from: nc5$g */
    /* compiled from: MixpanelAPI */
    public interface g extends ec5.a {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x015f, code lost:
        if (r10 != false) goto L_0x0164;
     */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x02c4 A[SYNTHETIC, Splitter:B:121:0x02c4] */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x032b  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0211  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0227 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public nc5(android.content.Context r10, java.util.concurrent.Future<android.content.SharedPreferences> r11, java.lang.String r12, boolean r13, org.json.JSONObject r14) {
        /*
        // Method dump skipped, instructions count: 971
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.nc5.<init>(android.content.Context, java.util.concurrent.Future, java.lang.String, boolean, org.json.JSONObject):void");
    }

    public static void a(nc5 nc5, JSONObject jSONObject) {
        if (!nc5.m()) {
            ac5 ac5 = nc5.b;
            ac5.e eVar = new ac5.e(jSONObject, nc5.d);
            Objects.requireNonNull(ac5);
            Message obtain = Message.obtain();
            obtain.what = 0;
            obtain.obj = eVar;
            ac5.f147a.b(obtain);
        }
    }

    public static void b(nc5 nc5, String str) {
        ac5 ac5 = nc5.b;
        ac5.f fVar = new ac5.f(str, nc5.d);
        Objects.requireNonNull(ac5);
        Message obtain = Message.obtain();
        obtain.what = 4;
        obtain.obj = fVar;
        ac5.f147a.b(obtain);
    }

    public static void c(b bVar) {
        Map<String, Map<Context, nc5>> map = o;
        synchronized (map) {
            for (Map<Context, nc5> map2 : map.values()) {
                for (nc5 nc5 : map2.values()) {
                    bVar.a(nc5);
                }
            }
        }
    }

    public static fd5<Boolean> d(String str, boolean z) {
        id5 id5 = q;
        id5.a(str, Boolean.valueOf(z), null, null, 1);
        return new gd5(id5, str);
    }

    public static void e(Context context) {
        if (context instanceof Activity) {
            try {
                Class<?> cls = Class.forName("bolts.AppLinks");
                Intent intent = ((Activity) context).getIntent();
                cls.getMethod("getTargetUrlFromInboundIntent", Context.class, Intent.class).invoke(null, context, intent);
            } catch (InvocationTargetException unused) {
            } catch (ClassNotFoundException e2) {
                e2.getMessage();
            } catch (NoSuchMethodException e3) {
                e3.getMessage();
            } catch (IllegalAccessException e4) {
                e4.getMessage();
            }
        }
    }

    public static nc5 k(Context context, String str) {
        nc5 nc5 = null;
        if (!(str == null || context == null)) {
            Map<String, Map<Context, nc5>> map = o;
            synchronized (map) {
                Context applicationContext = context.getApplicationContext();
                if (r == null) {
                    r = p.a(context, "com.mixpanel.android.mpmetrics.ReferralInfo", null);
                }
                Map<Context, nc5> map2 = map.get(str);
                if (map2 == null) {
                    map2 = new HashMap<>();
                    map.put(str, map2);
                }
                nc5 nc52 = map2.get(applicationContext);
                if (nc52 == null) {
                    PackageManager packageManager = applicationContext.getPackageManager();
                    String packageName = applicationContext.getPackageName();
                    boolean z = false;
                    if (packageManager != null) {
                        if (packageName != null) {
                            if (packageManager.checkPermission("android.permission.INTERNET", packageName) == 0) {
                                z = true;
                            }
                        }
                    }
                    if (z) {
                        nc5 nc53 = new nc5(applicationContext, r, str, false, null);
                        o(context, nc53);
                        map2.put(applicationContext, nc53);
                        if (cc5.a(applicationContext)) {
                            try {
                                int i2 = sc5.f;
                                FirebaseInstanceId.getInstance().getInstanceId().b(new rc5());
                            } catch (Exception unused) {
                            }
                        }
                        nc5 = nc53;
                        e(context);
                    }
                }
                nc5 = nc52;
                e(context);
            }
        }
        return nc5;
    }

    public static nc5 l(Context context, String str) {
        try {
            String optString = new JSONObject(str).optString(AnalyticsConstants.TOKEN);
            if (optString == null) {
                return null;
            }
            return k(context, optString);
        } catch (JSONException unused) {
            return null;
        }
    }

    public static void o(Context context, nc5 nc5) {
        try {
            Class<?> cls = Class.forName("ni");
            Method method = cls.getMethod("getInstance", Context.class);
            cls.getMethod("registerReceiver", BroadcastReceiver.class, IntentFilter.class).invoke(method.invoke(null, context), new a(), new IntentFilter("com.parse.bolts.measurement_event"));
        } catch (InvocationTargetException unused) {
        } catch (ClassNotFoundException e2) {
            e2.getMessage();
        } catch (NoSuchMethodException e3) {
            e3.getMessage();
        } catch (IllegalAccessException e4) {
            e4.getMessage();
        }
    }

    public static fd5<String> q(String str, String str2) {
        id5 id5 = q;
        id5.a(str, str2, null, null, 4);
        return new hd5(id5, str);
    }

    public static void t(Context context, Integer num, Integer num2, String str, String str2, String str3, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject(str2);
            if (jSONObject2.optString(AnalyticsConstants.TOKEN) != null) {
                jSONObject2.remove(AnalyticsConstants.TOKEN);
                if (jSONObject2.optString("distinct_id") != null) {
                    jSONObject2.remove("distinct_id");
                    try {
                        Iterator<String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            jSONObject2.put(next, jSONObject.get(next));
                        }
                        jSONObject2.put(Constants.MessagePayloadKeys.MSGID_SERVER, num2);
                        jSONObject2.put("campaign_id", num);
                        jSONObject2.put("$android_notification_id", str);
                    } catch (JSONException unused) {
                    }
                    nc5 l2 = l(context, str2);
                    if (l2 != null) {
                        if (!l2.m()) {
                            l2.s(str3, jSONObject2, false);
                        }
                        l2.g();
                    }
                }
            }
        } catch (JSONException unused2) {
        }
    }

    public static void u(Context context, Intent intent, String str, JSONObject jSONObject) {
        if (intent.hasExtra("mp") && intent.hasExtra("mp_campaign_id") && intent.hasExtra("mp_message_id")) {
            String stringExtra = intent.getStringExtra("mp_message_id");
            String stringExtra2 = intent.getStringExtra("mp_campaign_id");
            t(context, Integer.valueOf(stringExtra2), Integer.valueOf(stringExtra), intent.getStringExtra("mp_canonical_notification_id"), intent.getStringExtra("mp"), str, jSONObject);
        }
    }

    public void f() {
        if (!m()) {
            ac5 ac5 = this.b;
            String str = this.d;
            Message obtain = Message.obtain();
            obtain.what = 2;
            obtain.obj = str;
            obtain.arg1 = 1;
            ac5.f147a.b(obtain);
        }
    }

    public void g() {
        if (!m()) {
            ac5 ac5 = this.b;
            String str = this.d;
            Message obtain = Message.obtain();
            obtain.what = 2;
            obtain.obj = str;
            obtain.arg1 = 0;
            ac5.f147a.b(obtain);
        }
    }

    public ac5 h() {
        ac5 ac5;
        Context context = this.f2534a;
        Map<Context, ac5> map = ac5.d;
        synchronized (map) {
            Context applicationContext = context.getApplicationContext();
            if (!map.containsKey(applicationContext)) {
                ac5 = new ac5(applicationContext);
                map.put(applicationContext, ac5);
            } else {
                ac5 = map.get(applicationContext);
            }
        }
        return ac5;
    }

    public String i() {
        String str;
        xc5 xc5 = this.g;
        synchronized (xc5) {
            if (!xc5.i) {
                xc5.e();
            }
            str = xc5.m;
        }
        return str;
    }

    public String j() {
        return this.g.a();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x001a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean m() {
        /*
            r5 = this;
            xc5 r0 = r5.g
            java.lang.String r1 = r5.d
            monitor-enter(r0)
            java.lang.Boolean r2 = r0.o     // Catch:{ all -> 0x003e }
            if (r2 != 0) goto L_0x0036
            java.util.concurrent.Future<android.content.SharedPreferences> r2 = r0.d     // Catch:{ ExecutionException -> 0x0012, InterruptedException -> 0x0016 }
            java.lang.Object r2 = r2.get()     // Catch:{ ExecutionException -> 0x0012, InterruptedException -> 0x0016 }
            android.content.SharedPreferences r2 = (android.content.SharedPreferences) r2     // Catch:{ ExecutionException -> 0x0012, InterruptedException -> 0x0016 }
            goto L_0x0017
        L_0x0012:
            r2 = move-exception
            r2.getCause()
        L_0x0016:
            r2 = 0
        L_0x0017:
            if (r2 != 0) goto L_0x001a
            goto L_0x0036
        L_0x001a:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "opt_out_"
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r3 = 0
            boolean r1 = r2.getBoolean(r1, r3)
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            r0.o = r1
        L_0x0036:
            java.lang.Boolean r1 = r0.o
            boolean r1 = r1.booleanValue()
            monitor-exit(r0)
            return r1
        L_0x003e:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.nc5.m():boolean");
    }

    public void n() {
        ac5 h2 = h();
        ac5.c cVar = new ac5.c(this.d);
        Objects.requireNonNull(h2);
        Message obtain = Message.obtain();
        obtain.what = 6;
        obtain.obj = cVar;
        h2.f147a.b(obtain);
        if (this.e.c() != null) {
            e eVar = this.e;
            Objects.requireNonNull(eVar);
            try {
                a(nc5.this, eVar.j("$delete", JSONObject.NULL));
            } catch (JSONException unused) {
            }
            e eVar2 = this.e;
            if (!nc5.this.m()) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put("$transactions");
                    a(nc5.this, eVar2.j("$unset", jSONArray));
                } catch (JSONException unused2) {
                }
            }
        }
        xc5 xc5 = this.g;
        synchronized (xc5) {
            try {
                SharedPreferences.Editor edit = xc5.f3912a.get().edit();
                edit.clear();
                edit.apply();
                xc5.g();
                xc5.e();
            } catch (ExecutionException e2) {
                throw new RuntimeException(e2.getCause());
            } catch (InterruptedException e3) {
                throw new RuntimeException(e3.getCause());
            }
        }
        synchronized (this.l) {
            this.l.clear();
            xc5 xc52 = this.g;
            Objects.requireNonNull(xc52);
            try {
                SharedPreferences.Editor edit2 = xc52.c.get().edit();
                edit2.clear();
                edit2.apply();
            } catch (InterruptedException e4) {
                e4.printStackTrace();
            } catch (ExecutionException e5) {
                e5.printStackTrace();
            }
        }
        xc5 xc53 = this.g;
        Objects.requireNonNull(xc53);
        synchronized (xc5.s) {
            try {
                SharedPreferences.Editor edit3 = xc53.b.get().edit();
                edit3.clear();
                edit3.apply();
            } catch (ExecutionException e6) {
                e6.getCause();
            } catch (InterruptedException unused3) {
            }
        }
        xc5 xc54 = this.g;
        String str = this.d;
        synchronized (xc54) {
            xc54.o = Boolean.TRUE;
            xc54.l(str);
        }
    }

    public void p(JSONObject jSONObject) {
        if (!m()) {
            xc5 xc5 = this.g;
            synchronized (xc5.g) {
                JSONObject d2 = xc5.d();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    try {
                        d2.put(next, jSONObject.get(next));
                    } catch (JSONException unused) {
                    }
                }
                xc5.j();
            }
        }
    }

    public void r(String str, JSONObject jSONObject) {
        if (!m()) {
            s(str, jSONObject, false);
        }
    }

    public void s(String str, JSONObject jSONObject, boolean z) {
        Long l2;
        Activity activity;
        String str2;
        boolean z2;
        if (!m()) {
            if (z) {
                Boolean bool = this.j.i;
                if (bool == null) {
                    z2 = true;
                } else {
                    z2 = bool.booleanValue();
                }
                if (!z2) {
                    return;
                }
            }
            synchronized (this.l) {
                l2 = this.l.get(str);
                this.l.remove(str);
                xc5 xc5 = this.g;
                Objects.requireNonNull(xc5);
                try {
                    SharedPreferences.Editor edit = xc5.c.get().edit();
                    edit.remove(str);
                    edit.apply();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                } catch (ExecutionException e3) {
                    e3.printStackTrace();
                }
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                xc5 xc52 = this.g;
                Objects.requireNonNull(xc52);
                synchronized (xc5.s) {
                    if (xc5.r || xc52.h == null) {
                        xc52.f();
                        xc5.r = false;
                    }
                }
                for (Map.Entry<String, String> entry : xc52.h.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
                xc5 xc53 = this.g;
                synchronized (xc53.g) {
                    JSONObject d2 = xc53.d();
                    Iterator<String> keys = d2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        try {
                            jSONObject2.put(next, d2.get(next));
                        } catch (JSONException unused) {
                        }
                    }
                }
                double currentTimeMillis = ((double) System.currentTimeMillis()) / 1000.0d;
                long j2 = (long) currentTimeMillis;
                String j3 = j();
                String i2 = i();
                xc5 xc54 = this.g;
                synchronized (xc54) {
                    if (!xc54.i) {
                        xc54.e();
                    }
                    activity = null;
                    str2 = xc54.k ? xc54.j : null;
                }
                jSONObject2.put("time", j2);
                jSONObject2.put("distinct_id", j3);
                jSONObject2.put("$had_persisted_distinct_id", this.g.b());
                if (i2 != null) {
                    jSONObject2.put("$device_id", i2);
                }
                if (str2 != null) {
                    jSONObject2.put("$user_id", str2);
                }
                if (l2 != null) {
                    jSONObject2.put("$duration", currentTimeMillis - (((double) l2.longValue()) / 1000.0d));
                }
                if (jSONObject != null) {
                    Iterator<String> keys2 = jSONObject.keys();
                    while (keys2.hasNext()) {
                        String next2 = keys2.next();
                        jSONObject2.put(next2, jSONObject.get(next2));
                    }
                }
                ac5.a aVar = new ac5.a(str, jSONObject2, this.d, z, this.n.a(true));
                ac5 ac5 = this.b;
                Objects.requireNonNull(ac5);
                Message obtain = Message.obtain();
                obtain.what = 1;
                obtain.obj = aVar;
                ac5.f147a.b(obtain);
                WeakReference<Activity> weakReference = this.m.l;
                if ((weakReference != null ? weakReference.get() : null) != null) {
                    e eVar = this.e;
                    InAppNotification a2 = this.j.a(aVar, this.c.f);
                    WeakReference<Activity> weakReference2 = this.m.l;
                    if (weakReference2 != null) {
                        activity = weakReference2.get();
                    }
                    Objects.requireNonNull(eVar);
                    if (a2 != null) {
                        activity.runOnUiThread(new pc5(eVar, a2, activity));
                    }
                }
                de5 de5 = this.i;
                if (de5 != null) {
                    de5.b(str);
                }
            } catch (JSONException unused2) {
            }
        }
    }

    public void v(dd5 dd5) {
        if (!m()) {
            xc5 xc5 = this.g;
            synchronized (xc5.g) {
                JSONObject d2 = xc5.d();
                JSONObject jSONObject = new JSONObject();
                try {
                    Iterator<String> keys = d2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        jSONObject.put(next, d2.get(next));
                    }
                    try {
                        jSONObject.put("$experiments", ((he5) dd5).f1363a);
                    } catch (JSONException e2) {
                        if (rd5.a(6)) {
                            Log.wtf("MixpanelAPI.ViewCrawler", "Can't write $experiments super property", e2);
                        }
                    }
                    xc5.f = jSONObject;
                    xc5.j();
                } catch (JSONException unused) {
                }
            }
        }
    }
}
