package defpackage;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Pair;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import server.zophop.Constants;

/* renamed from: oo3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
public class oo3 {
    public static volatile oo3 i;
    public static Boolean j;

    /* renamed from: a  reason: collision with root package name */
    public final String f2719a;
    public final cb2 b;
    public final ExecutorService c;
    public final a64 d;
    public final List<Pair<ad4, d>> e;
    public int f;
    public boolean g;
    public volatile f24 h;

    /* renamed from: oo3$a */
    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
    public static class a extends jo3 {
        public final xc4 f;

        public a(xc4 xc4) {
            this.f = xc4;
        }

        @Override // defpackage.ko3
        public final void a2(String str, String str2, Bundle bundle, long j) {
            ((AppMeasurementDynamiteService.a) this.f).a(str, str2, bundle, j);
        }

        @Override // defpackage.ko3
        public final int zza() {
            return System.identityHashCode(this.f);
        }
    }

    /* renamed from: oo3$b */
    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
    public abstract class b implements Runnable {
        public final long f = System.currentTimeMillis();
        public final long g;
        public final boolean h;

        public b(boolean z) {
            Objects.requireNonNull((db2) oo3.this.b);
            Objects.requireNonNull((db2) oo3.this.b);
            this.g = SystemClock.elapsedRealtime();
            this.h = z;
        }

        public abstract void a() throws RemoteException;

        public void b() {
        }

        public void run() {
            if (oo3.this.g) {
                b();
                return;
            }
            try {
                a();
            } catch (Exception e) {
                oo3.this.d(e, false, this.h);
                b();
            }
        }
    }

    /* renamed from: oo3$c */
    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
    public class c implements Application.ActivityLifecycleCallbacks {
        public c() {
        }

        public final void onActivityCreated(Activity activity, Bundle bundle) {
            oo3 oo3 = oo3.this;
            oo3.c.execute(new wp3(this, bundle, activity));
        }

        public final void onActivityDestroyed(Activity activity) {
            oo3 oo3 = oo3.this;
            oo3.c.execute(new bq3(this, activity));
        }

        public final void onActivityPaused(Activity activity) {
            oo3 oo3 = oo3.this;
            oo3.c.execute(new xp3(this, activity));
        }

        public final void onActivityResumed(Activity activity) {
            oo3 oo3 = oo3.this;
            oo3.c.execute(new yp3(this, activity));
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            d24 d24 = new d24();
            oo3 oo3 = oo3.this;
            oo3.c.execute(new zp3(this, activity, d24));
            Bundle C1 = d24.C1(50);
            if (C1 != null) {
                bundle.putAll(C1);
            }
        }

        public final void onActivityStarted(Activity activity) {
            oo3 oo3 = oo3.this;
            oo3.c.execute(new vp3(this, activity));
        }

        public final void onActivityStopped(Activity activity) {
            oo3 oo3 = oo3.this;
            oo3.c.execute(new aq3(this, activity));
        }
    }

    /* renamed from: oo3$d */
    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
    public static class d extends jo3 {
        public final ad4 f;

        public d(ad4 ad4) {
            this.f = ad4;
        }

        @Override // defpackage.ko3
        public final void a2(String str, String str2, Bundle bundle, long j) {
            this.f.onEvent(str, str2, bundle, j);
        }

        @Override // defpackage.ko3
        public final int zza() {
            return System.identityHashCode(this.f);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005b, code lost:
        if (r1 == false) goto L_0x005e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0063  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public oo3(android.content.Context r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, android.os.Bundle r13) {
        /*
        // Method dump skipped, instructions count: 137
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.oo3.<init>(android.content.Context, java.lang.String, java.lang.String, java.lang.String, android.os.Bundle):void");
    }

    public static oo3 a(Context context, String str, String str2, String str3, Bundle bundle) {
        Objects.requireNonNull(context, "null reference");
        if (i == null) {
            synchronized (oo3.class) {
                if (i == null) {
                    i = new oo3(context, null, null, null, bundle);
                }
            }
        }
        return i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0032  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void h(android.content.Context r7) {
        /*
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            java.lang.Class<oo3> r1 = defpackage.oo3.class
            monitor-enter(r1)
            java.lang.Boolean r2 = defpackage.oo3.j     // Catch:{ Exception -> 0x0054 }
            if (r2 == 0) goto L_0x000b
            monitor-exit(r1)     // Catch:{ all -> 0x0052 }
            goto L_0x0057
        L_0x000b:
            java.lang.String r2 = "app_measurement_internal_disable_startup_flags"
            defpackage.gj1.j(r2)
            r3 = 0
            nb2 r4 = defpackage.ob2.a(r7)     // Catch:{ NameNotFoundException -> 0x002b }
            java.lang.String r5 = r7.getPackageName()     // Catch:{ NameNotFoundException -> 0x002b }
            r6 = 128(0x80, float:1.794E-43)
            android.content.pm.ApplicationInfo r4 = r4.a(r5, r6)     // Catch:{ NameNotFoundException -> 0x002b }
            if (r4 == 0) goto L_0x002b
            android.os.Bundle r4 = r4.metaData     // Catch:{ NameNotFoundException -> 0x002b }
            if (r4 != 0) goto L_0x0026
            goto L_0x002b
        L_0x0026:
            boolean r2 = r4.getBoolean(r2)     // Catch:{ NameNotFoundException -> 0x002b }
            goto L_0x002c
        L_0x002b:
            r2 = 0
        L_0x002c:
            if (r2 == 0) goto L_0x0032
            defpackage.oo3.j = r0
            monitor-exit(r1)
            goto L_0x0057
        L_0x0032:
            java.lang.String r2 = "com.google.android.gms.measurement.prefs"
            android.content.SharedPreferences r7 = r7.getSharedPreferences(r2, r3)
            java.lang.String r2 = "allow_remote_dynamite"
            r3 = 1
            boolean r2 = r7.getBoolean(r2, r3)
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            defpackage.oo3.j = r2
            android.content.SharedPreferences$Editor r7 = r7.edit()
            java.lang.String r2 = "allow_remote_dynamite"
            r7.remove(r2)
            r7.apply()
            goto L_0x0056
        L_0x0052:
            r7 = move-exception
            goto L_0x0058
        L_0x0054:
            defpackage.oo3.j = r0
        L_0x0056:
            monitor-exit(r1)
        L_0x0057:
            return
        L_0x0058:
            monitor-exit(r1)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.oo3.h(android.content.Context):void");
    }

    public static boolean i(String str, String str2) {
        boolean z;
        if (!(str2 == null || str == null)) {
            try {
                Class.forName("com.google.firebase.analytics.FirebaseAnalytics");
                z = true;
            } catch (ClassNotFoundException unused) {
                z = false;
            }
            if (!z) {
                return true;
            }
        }
        return false;
    }

    public final Map<String, Object> b(String str, String str2, boolean z) {
        d24 d24 = new d24();
        this.c.execute(new ip3(this, str, str2, z, d24));
        Bundle C1 = d24.C1(5000);
        if (C1 == null || C1.size() == 0) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap(C1.size());
        for (String str3 : C1.keySet()) {
            Object obj = C1.get(str3);
            if ((obj instanceof Double) || (obj instanceof Long) || (obj instanceof String)) {
                hashMap.put(str3, obj);
            }
        }
        return hashMap;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0038, code lost:
        if (r4.h == null) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r4.h.registerOnMeasurementEventListener(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003f, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0040, code lost:
        r4.c.execute(new defpackage.sp3(r4, r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(defpackage.ad4 r5) {
        /*
            r4 = this;
            java.lang.String r0 = "null reference"
            java.util.Objects.requireNonNull(r5, r0)
            java.util.List<android.util.Pair<ad4, oo3$d>> r0 = r4.e
            monitor-enter(r0)
            r1 = 0
        L_0x0009:
            java.util.List<android.util.Pair<ad4, oo3$d>> r2 = r4.e     // Catch:{ all -> 0x004b }
            int r2 = r2.size()     // Catch:{ all -> 0x004b }
            if (r1 >= r2) goto L_0x0026
            java.util.List<android.util.Pair<ad4, oo3$d>> r2 = r4.e     // Catch:{ all -> 0x004b }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x004b }
            android.util.Pair r2 = (android.util.Pair) r2     // Catch:{ all -> 0x004b }
            java.lang.Object r2 = r2.first     // Catch:{ all -> 0x004b }
            boolean r2 = r5.equals(r2)     // Catch:{ all -> 0x004b }
            if (r2 == 0) goto L_0x0023
            monitor-exit(r0)     // Catch:{ all -> 0x004b }
            return
        L_0x0023:
            int r1 = r1 + 1
            goto L_0x0009
        L_0x0026:
            oo3$d r1 = new oo3$d     // Catch:{ all -> 0x004b }
            r1.<init>(r5)     // Catch:{ all -> 0x004b }
            java.util.List<android.util.Pair<ad4, oo3$d>> r2 = r4.e     // Catch:{ all -> 0x004b }
            android.util.Pair r3 = new android.util.Pair     // Catch:{ all -> 0x004b }
            r3.<init>(r5, r1)     // Catch:{ all -> 0x004b }
            r2.add(r3)     // Catch:{ all -> 0x004b }
            monitor-exit(r0)     // Catch:{ all -> 0x004b }
            f24 r5 = r4.h
            if (r5 == 0) goto L_0x0040
            f24 r5 = r4.h     // Catch:{ BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException -> 0x0040 }
            r5.registerOnMeasurementEventListener(r1)     // Catch:{ BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException -> 0x0040 }
            return
        L_0x0040:
            sp3 r5 = new sp3
            r5.<init>(r4, r1)
            java.util.concurrent.ExecutorService r0 = r4.c
            r0.execute(r5)
            return
        L_0x004b:
            r5 = move-exception
            monitor-exit(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.oo3.c(ad4):void");
    }

    public final void d(Exception exc, boolean z, boolean z2) {
        this.g |= z;
        if (!z && z2) {
            this.c.execute(new kp3(this, "Error with data collection. Data lost.", exc));
        }
    }

    public final void e(String str, String str2, Bundle bundle, boolean z, boolean z2, Long l) {
        this.c.execute(new up3(this, l, str, str2, bundle, z, z2));
    }

    public final void f(String str, String str2, Object obj, boolean z) {
        this.c.execute(new tp3(this, str, str2, obj, z));
    }

    public final List<Bundle> g(String str, String str2) {
        d24 d24 = new d24();
        this.c.execute(new so3(this, str, str2, d24));
        List<Bundle> list = (List) d24.F(d24.C1(5000), List.class);
        return list == null ? Collections.emptyList() : list;
    }

    public final int j(String str) {
        d24 d24 = new d24();
        this.c.execute(new lp3(this, str, d24));
        Integer num = (Integer) d24.F(d24.C1(Constants.THRESHOLD_TIMESTAMP), Integer.class);
        if (num == null) {
            return 25;
        }
        return num.intValue();
    }
}
