package defpackage;

import android.annotation.SuppressLint;
import com.urbanairship.PreferenceDataDatabase;
import com.urbanairship.json.JsonValue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* renamed from: hk5  reason: default package */
/* compiled from: PreferenceDataStore */
public final class hk5 {
    public static final String[] f = {"com.urbanairship.TAG_GROUP_HISTORIAN_RECORDS", "com.urbanairship.push.iam.PENDING_IN_APP_MESSAGE", "com.urbanairship.push.iam.AUTO_DISPLAY_ENABLED", "com.urbanairship.push.iam.LAST_DISPLAYED_ID"};

    /* renamed from: a  reason: collision with root package name */
    public Executor f1384a = pj5.a();
    public final Map<String, a> b = new HashMap();
    public final fk5 c;
    public final PreferenceDataDatabase d;
    public final List<b> e = new ArrayList();

    /* renamed from: hk5$a */
    /* compiled from: PreferenceDataStore */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f1385a;
        public String b;

        /* renamed from: hk5$a$a  reason: collision with other inner class name */
        /* compiled from: PreferenceDataStore */
        public class RunnableC0025a implements Runnable {
            public final /* synthetic */ String f;

            public RunnableC0025a(String str) {
                this.f = str;
            }

            public void run() {
                a.this.d(this.f);
            }
        }

        public a(String str, String str2) {
            this.f1385a = str;
            this.b = str2;
        }

        public String a() {
            String str;
            synchronized (this) {
                str = this.b;
            }
            return str;
        }

        public void b(String str) {
            if (c(str)) {
                hk5.this.f1384a.execute(new RunnableC0025a(str));
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            r5 = r5.e.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x002c, code lost:
            if (r5.hasNext() == false) goto L_0x0038;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
            r5.next().a(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0038, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0039, code lost:
            return true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x000f, code lost:
            defpackage.yj5.h("Preference updated: %s", r4.f1385a);
            r5 = r4.c;
            r1 = r4.f1385a;
            r2 = r5.e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0021, code lost:
            monitor-enter(r2);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean c(java.lang.String r5) {
            /*
                r4 = this;
                monitor-enter(r4)
                java.lang.String r0 = r4.b     // Catch:{ all -> 0x003d }
                boolean r0 = defpackage.hd3.R0(r5, r0)     // Catch:{ all -> 0x003d }
                r1 = 0
                if (r0 == 0) goto L_0x000c
                monitor-exit(r4)     // Catch:{ all -> 0x003d }
                return r1
            L_0x000c:
                r4.b = r5     // Catch:{ all -> 0x003d }
                monitor-exit(r4)     // Catch:{ all -> 0x003d }
                java.lang.String r5 = "Preference updated: %s"
                r0 = 1
                java.lang.Object[] r2 = new java.lang.Object[r0]
                java.lang.String r3 = r4.f1385a
                r2[r1] = r3
                defpackage.yj5.h(r5, r2)
                hk5 r5 = defpackage.hk5.this
                java.lang.String r1 = r4.f1385a
                java.util.List<hk5$b> r2 = r5.e
                monitor-enter(r2)
                java.util.List<hk5$b> r5 = r5.e     // Catch:{ all -> 0x003a }
                java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x003a }
            L_0x0028:
                boolean r3 = r5.hasNext()     // Catch:{ all -> 0x003a }
                if (r3 == 0) goto L_0x0038
                java.lang.Object r3 = r5.next()     // Catch:{ all -> 0x003a }
                hk5$b r3 = (defpackage.hk5.b) r3     // Catch:{ all -> 0x003a }
                r3.a(r1)     // Catch:{ all -> 0x003a }
                goto L_0x0028
            L_0x0038:
                monitor-exit(r2)     // Catch:{ all -> 0x003a }
                return r0
            L_0x003a:
                r5 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x003a }
                throw r5
            L_0x003d:
                r5 = move-exception
                monitor-exit(r4)
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.hk5.a.c(java.lang.String):boolean");
        }

        public final boolean d(String str) {
            synchronized (this) {
                if (str == null) {
                    try {
                        yj5.h("Removing preference: %s", this.f1385a);
                        hk5.this.c.a(this.f1385a);
                    } catch (Exception e) {
                        yj5.e(e, "Failed to write preference %s:%s", this.f1385a, str);
                        return false;
                    } catch (Throwable th) {
                        throw th;
                    }
                } else {
                    yj5.h("Saving preference: %s value: %s", this.f1385a, str);
                    hk5.this.c.f(new ek5(this.f1385a, str));
                }
            }
            return true;
        }
    }

    /* renamed from: hk5$b */
    /* compiled from: PreferenceDataStore */
    public interface b {
        void a(String str);
    }

    public hk5(PreferenceDataDatabase preferenceDataDatabase) {
        this.d = preferenceDataDatabase;
        this.c = preferenceDataDatabase.a();
    }

    public final void a(List<a> list) {
        for (a aVar : list) {
            this.b.put(aVar.f1385a, aVar);
        }
        for (String str : f) {
            l(str);
        }
    }

    public boolean b(String str, boolean z) {
        String a2 = f(str).a();
        return a2 == null ? z : Boolean.parseBoolean(a2);
    }

    public int c(String str, int i) {
        String a2 = f(str).a();
        if (a2 == null) {
            return i;
        }
        try {
            return Integer.parseInt(a2);
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    public JsonValue d(String str) {
        try {
            return JsonValue.p(f(str).a());
        } catch (xt5 e2) {
            yj5.b(e2, "Unable to parse preference value: %s", str);
            return JsonValue.g;
        }
    }

    public long e(String str, long j) {
        String a2 = f(str).a();
        if (a2 == null) {
            return j;
        }
        try {
            return Long.parseLong(a2);
        } catch (NumberFormatException unused) {
            return j;
        }
    }

    public final a f(String str) {
        a aVar;
        synchronized (this.b) {
            aVar = this.b.get(str);
            if (aVar == null) {
                aVar = new a(str, null);
                this.b.put(str, aVar);
            }
        }
        return aVar;
    }

    @SuppressLint({"UnknownNullness"})
    public String g(String str, String str2) {
        String a2 = f(str).a();
        return a2 == null ? str2 : a2;
    }

    public boolean h(String str) {
        return f(str).a() != null;
    }

    public void i(String str, cu5 cu5) {
        if (cu5 == null) {
            l(str);
        } else {
            j(str, cu5.b());
        }
    }

    public void j(String str, JsonValue jsonValue) {
        if (jsonValue == null) {
            l(str);
        } else {
            f(str).b(jsonValue.toString());
        }
    }

    public void k(String str, boolean z) {
        f(str).b(String.valueOf(z));
    }

    public void l(String str) {
        a aVar;
        synchronized (this.b) {
            aVar = this.b.containsKey(str) ? this.b.get(str) : null;
        }
        if (aVar != null) {
            aVar.b(null);
        }
    }
}
