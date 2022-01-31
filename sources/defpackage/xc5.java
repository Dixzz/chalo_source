package defpackage;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.json.JSONObject;

@SuppressLint({"CommitPrefEdits"})
/* renamed from: xc5  reason: default package */
/* compiled from: PersistentIdentity */
public class xc5 {
    public static Integer p = null;
    public static Boolean q = null;
    public static boolean r = true;
    public static final Object s = new Object();

    /* renamed from: a  reason: collision with root package name */
    public final Future<SharedPreferences> f3912a;
    public final Future<SharedPreferences> b;
    public final Future<SharedPreferences> c;
    public final Future<SharedPreferences> d;
    public final SharedPreferences.OnSharedPreferenceChangeListener e;
    public JSONObject f;
    public Object g = new Object();
    public Map<String, String> h;
    public boolean i;
    public String j;
    public boolean k;
    public String l;
    public String m;
    public boolean n;
    public Boolean o;

    /* renamed from: xc5$a */
    /* compiled from: PersistentIdentity */
    public class a implements SharedPreferences.OnSharedPreferenceChangeListener {
        public a() {
        }

        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
            Integer num = xc5.p;
            synchronized (xc5.s) {
                xc5.this.f();
                xc5.r = false;
            }
        }
    }

    public xc5(Future<SharedPreferences> future, Future<SharedPreferences> future2, Future<SharedPreferences> future3, Future<SharedPreferences> future4) {
        this.b = future;
        this.f3912a = future2;
        this.c = future3;
        this.d = future4;
        this.f = null;
        this.h = null;
        this.i = false;
        this.e = new a();
    }

    public synchronized String a() {
        if (!this.i) {
            e();
        }
        return this.j;
    }

    public synchronized boolean b() {
        if (!this.i) {
            e();
        }
        return this.n;
    }

    public synchronized String c() {
        if (!this.i) {
            e();
        }
        return this.l;
    }

    public final JSONObject d() {
        if (this.f == null) {
            g();
        }
        return this.f;
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0011 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0012  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void e() {
        /*
            r4 = this;
            r0 = 0
            java.util.concurrent.Future<android.content.SharedPreferences> r1 = r4.f3912a     // Catch:{ ExecutionException -> 0x000a, InterruptedException -> 0x000e }
            java.lang.Object r1 = r1.get()     // Catch:{ ExecutionException -> 0x000a, InterruptedException -> 0x000e }
            android.content.SharedPreferences r1 = (android.content.SharedPreferences) r1     // Catch:{ ExecutionException -> 0x000a, InterruptedException -> 0x000e }
            goto L_0x000f
        L_0x000a:
            r1 = move-exception
            r1.getCause()
        L_0x000e:
            r1 = r0
        L_0x000f:
            if (r1 != 0) goto L_0x0012
            return
        L_0x0012:
            java.lang.String r2 = "events_distinct_id"
            java.lang.String r2 = r1.getString(r2, r0)
            r4.j = r2
            java.lang.String r2 = "events_user_id_present"
            r3 = 0
            boolean r2 = r1.getBoolean(r2, r3)
            r4.k = r2
            java.lang.String r2 = "people_distinct_id"
            java.lang.String r2 = r1.getString(r2, r0)
            r4.l = r2
            java.lang.String r2 = "anonymous_id"
            java.lang.String r0 = r1.getString(r2, r0)
            r4.m = r0
            java.lang.String r0 = "had_persisted_distinct_id"
            boolean r0 = r1.getBoolean(r0, r3)
            r4.n = r0
            java.lang.String r0 = r4.j
            if (r0 != 0) goto L_0x0050
            java.util.UUID r0 = java.util.UUID.randomUUID()
            java.lang.String r0 = r0.toString()
            r4.m = r0
            r4.j = r0
            r4.k = r3
            r4.k()
        L_0x0050:
            r0 = 1
            r4.i = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xc5.e():void");
    }

    public final void f() {
        this.h = new HashMap();
        try {
            SharedPreferences sharedPreferences = this.b.get();
            sharedPreferences.unregisterOnSharedPreferenceChangeListener(this.e);
            sharedPreferences.registerOnSharedPreferenceChangeListener(this.e);
            for (Map.Entry<String, ?> entry : sharedPreferences.getAll().entrySet()) {
                Object value = entry.getValue();
                this.h.put(entry.getKey(), value.toString());
            }
        } catch (ExecutionException e2) {
            e2.getCause();
        } catch (InterruptedException unused) {
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0021 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void g() {
        /*
            r3 = this;
            java.util.concurrent.Future<android.content.SharedPreferences> r0 = r3.f3912a     // Catch:{ ExecutionException -> 0x003a, InterruptedException -> 0x002e, JSONException -> 0x0021 }
            java.lang.Object r0 = r0.get()     // Catch:{ ExecutionException -> 0x003a, InterruptedException -> 0x002e, JSONException -> 0x0021 }
            android.content.SharedPreferences r0 = (android.content.SharedPreferences) r0     // Catch:{ ExecutionException -> 0x003a, InterruptedException -> 0x002e, JSONException -> 0x0021 }
            java.lang.String r1 = "super_properties"
            java.lang.String r2 = "{}"
            java.lang.String r0 = r0.getString(r1, r2)     // Catch:{ ExecutionException -> 0x003a, InterruptedException -> 0x002e, JSONException -> 0x0021 }
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ ExecutionException -> 0x003a, InterruptedException -> 0x002e, JSONException -> 0x0021 }
            r1.<init>(r0)     // Catch:{ ExecutionException -> 0x003a, InterruptedException -> 0x002e, JSONException -> 0x0021 }
            r3.f = r1     // Catch:{ ExecutionException -> 0x003a, InterruptedException -> 0x002e, JSONException -> 0x0021 }
            if (r1 != 0) goto L_0x0048
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            goto L_0x0037
        L_0x001f:
            r0 = move-exception
            goto L_0x0049
        L_0x0021:
            r3.j()     // Catch:{ all -> 0x001f }
            org.json.JSONObject r0 = r3.f
            if (r0 != 0) goto L_0x0048
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            goto L_0x0037
        L_0x002e:
            org.json.JSONObject r0 = r3.f
            if (r0 != 0) goto L_0x0048
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
        L_0x0037:
            r3.f = r0
            goto L_0x0048
        L_0x003a:
            r0 = move-exception
            r0.getCause()
            org.json.JSONObject r0 = r3.f
            if (r0 != 0) goto L_0x0048
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            goto L_0x0037
        L_0x0048:
            return
        L_0x0049:
            org.json.JSONObject r1 = r3.f
            if (r1 != 0) goto L_0x0054
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            r3.f = r1
        L_0x0054:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xc5.g():void");
    }

    public synchronized void h(String str) {
        try {
            SharedPreferences.Editor edit = this.d.get().edit();
            edit.putBoolean("has_launched_" + str, true);
            edit.apply();
        } catch (ExecutionException e2) {
            e2.getCause();
        } catch (InterruptedException unused) {
        }
        return;
    }

    public synchronized void i(String str) {
        try {
            SharedPreferences.Editor edit = this.d.get().edit();
            edit.putBoolean(str, true);
            edit.apply();
        } catch (ExecutionException e2) {
            e2.getCause();
        } catch (InterruptedException unused) {
        }
        return;
    }

    public final void j() {
        JSONObject jSONObject = this.f;
        if (jSONObject != null) {
            String jSONObject2 = jSONObject.toString();
            try {
                SharedPreferences.Editor edit = this.f3912a.get().edit();
                edit.putString("super_properties", jSONObject2);
                edit.apply();
            } catch (ExecutionException e2) {
                e2.getCause();
            } catch (InterruptedException unused) {
            }
        }
    }

    public final void k() {
        try {
            SharedPreferences.Editor edit = this.f3912a.get().edit();
            edit.putString("events_distinct_id", this.j);
            edit.putBoolean("events_user_id_present", this.k);
            edit.putString("people_distinct_id", this.l);
            edit.putString("anonymous_id", this.m);
            edit.putBoolean("had_persisted_distinct_id", this.n);
            edit.apply();
        } catch (ExecutionException e2) {
            e2.getCause();
        } catch (InterruptedException unused) {
        }
    }

    public final void l(String str) {
        try {
            SharedPreferences.Editor edit = this.d.get().edit();
            edit.putBoolean("opt_out_" + str, this.o.booleanValue());
            edit.apply();
        } catch (ExecutionException e2) {
            e2.getCause();
        } catch (InterruptedException unused) {
        }
    }
}
