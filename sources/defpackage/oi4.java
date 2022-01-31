package defpackage;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.PowerManager;
import android.os.WorkSource;
import android.util.Log;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* renamed from: oi4  reason: default package */
public class oi4 {
    public static ScheduledExecutorService k;

    /* renamed from: a  reason: collision with root package name */
    public final Object f2694a;
    public final PowerManager.WakeLock b;
    public WorkSource c;
    public final int d;
    public final String e;
    public final Context f;
    public boolean g;
    public final Map<String, Integer[]> h;
    public int i;
    public AtomicInteger j;

    public oi4(Context context, int i2, String str) {
        xa2 xa2;
        WorkSource workSource = null;
        String packageName = context == null ? null : context.getPackageName();
        this.f2694a = this;
        this.g = true;
        this.h = new HashMap();
        Collections.synchronizedSet(new HashSet());
        this.j = new AtomicInteger(0);
        gj1.l(context, "WakeLock: context must not be null");
        gj1.i(str, "WakeLock: wakeLockName must not be empty");
        this.d = i2;
        this.f = context.getApplicationContext();
        if (!"com.google.android.gms".equals(context.getPackageName())) {
            this.e = str.length() != 0 ? "*gcore*:".concat(str) : new String("*gcore*:");
        } else {
            this.e = str;
        }
        this.b = ((PowerManager) context.getSystemService("power")).newWakeLock(i2, str);
        if (ib2.a(context)) {
            packageName = hb2.b(packageName) ? context.getPackageName() : packageName;
            if (!(context.getPackageManager() == null || packageName == null)) {
                try {
                    ApplicationInfo applicationInfo = ob2.a(context).f2531a.getPackageManager().getApplicationInfo(packageName, 0);
                    if (applicationInfo != null) {
                        int i3 = applicationInfo.uid;
                        workSource = new WorkSource();
                        Method method = ib2.b;
                        if (method != null) {
                            try {
                                method.invoke(workSource, Integer.valueOf(i3), packageName);
                            } catch (Exception e2) {
                                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
                            }
                        } else {
                            Method method2 = ib2.f1501a;
                            if (method2 != null) {
                                try {
                                    method2.invoke(workSource, Integer.valueOf(i3));
                                } catch (Exception e3) {
                                    Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e3);
                                }
                            }
                        }
                    } else if (packageName.length() != 0) {
                        "Could not get applicationInfo from package: ".concat(packageName);
                    } else {
                        new String("Could not get applicationInfo from package: ");
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                    if (packageName.length() != 0) {
                        "Could not find package: ".concat(packageName);
                    } else {
                        new String("Could not find package: ");
                    }
                }
            }
            this.c = workSource;
            if (workSource != null && ib2.a(this.f)) {
                WorkSource workSource2 = this.c;
                if (workSource2 != null) {
                    workSource2.add(workSource);
                } else {
                    this.c = workSource;
                }
                try {
                    this.b.setWorkSource(this.c);
                } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e4) {
                    Log.wtf("WakeLock", e4.toString());
                }
            }
        }
        if (k == null) {
            synchronized (gj1.class) {
                if (gj1.f1270a == null) {
                    gj1.f1270a = new ya2();
                }
                xa2 = gj1.f1270a;
            }
            Objects.requireNonNull((ya2) xa2);
            k = Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0057, code lost:
        if (r3 == false) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005f, code lost:
        if (r7.i == 0) goto L_0x0061;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0061, code lost:
        defpackage.gj1.H(r7.b, null);
        c();
        r7.i++;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(long r8) {
        /*
        // Method dump skipped, instructions count: 138
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.oi4.a(long):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004b, code lost:
        if (r4 == false) goto L_0x004d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0053, code lost:
        if (r6.i == 1) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0055, code lost:
        defpackage.gj1.H(r6.b, null);
        c();
        r6.i--;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b() {
        /*
        // Method dump skipped, instructions count: 106
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.oi4.b():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<java.lang.String> c() {
        /*
            r12 = this;
            android.os.WorkSource r0 = r12.c
            java.lang.reflect.Method r1 = defpackage.ib2.f1501a
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.lang.String r2 = "null reference"
            java.lang.String r3 = "Unable to assign blame through WorkSource"
            java.lang.String r4 = "WorkSourceUtil"
            r5 = 0
            if (r0 != 0) goto L_0x0013
            goto L_0x002b
        L_0x0013:
            java.lang.reflect.Method r6 = defpackage.ib2.c
            if (r6 == 0) goto L_0x002b
            java.lang.Object[] r7 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x0027 }
            java.lang.Object r6 = r6.invoke(r0, r7)     // Catch:{ Exception -> 0x0027 }
            java.util.Objects.requireNonNull(r6, r2)     // Catch:{ Exception -> 0x0027 }
            java.lang.Integer r6 = (java.lang.Integer) r6     // Catch:{ Exception -> 0x0027 }
            int r6 = r6.intValue()     // Catch:{ Exception -> 0x0027 }
            goto L_0x002c
        L_0x0027:
            r6 = move-exception
            android.util.Log.wtf(r4, r3, r6)
        L_0x002b:
            r6 = 0
        L_0x002c:
            if (r6 == 0) goto L_0x005a
            r7 = 0
        L_0x002f:
            if (r7 >= r6) goto L_0x005a
            java.lang.reflect.Method r8 = defpackage.ib2.d
            r9 = 0
            if (r8 == 0) goto L_0x004b
            r10 = 1
            java.lang.Object[] r10 = new java.lang.Object[r10]     // Catch:{ Exception -> 0x0047 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r7)     // Catch:{ Exception -> 0x0047 }
            r10[r5] = r11     // Catch:{ Exception -> 0x0047 }
            java.lang.Object r8 = r8.invoke(r0, r10)     // Catch:{ Exception -> 0x0047 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ Exception -> 0x0047 }
            r9 = r8
            goto L_0x004b
        L_0x0047:
            r8 = move-exception
            android.util.Log.wtf(r4, r3, r8)
        L_0x004b:
            boolean r8 = defpackage.hb2.b(r9)
            if (r8 != 0) goto L_0x0057
            java.util.Objects.requireNonNull(r9, r2)
            r1.add(r9)
        L_0x0057:
            int r7 = r7 + 1
            goto L_0x002f
        L_0x005a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.oi4.c():java.util.List");
    }

    public final void d() {
        if (this.b.isHeld()) {
            try {
                this.b.release();
            } catch (RuntimeException e2) {
                if (e2.getClass().equals(RuntimeException.class)) {
                    String.valueOf(this.e).concat(" was already released!");
                } else {
                    throw e2;
                }
            }
            this.b.isHeld();
        }
    }
}
