package com.urbanairship;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Looper;
import android.os.SystemClock;
import com.freshchat.consumer.sdk.beans.config.DefaultRefreshIntervals;
import com.razorpay.BaseConstants;
import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.modules.Module;
import defpackage.lq5;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class UAirship {
    public static final Object t = new Object();
    public static volatile boolean u = false;
    public static volatile boolean v = false;
    public static Application w;
    public static UAirship x;
    public static final List<uj5> y = new ArrayList();
    public static boolean z = true;

    /* renamed from: a  reason: collision with root package name */
    public vz f716a;
    public final Map<Class, oj5> b = new HashMap();
    public final List<oj5> c = new ArrayList();
    public qk5 d;
    public AirshipConfigOptions e;
    public fl5 f;
    public sj5 g;
    public hk5 h;
    public vv5 i;
    public kp5 j;
    public wt5 k;
    public wx5 l;
    public ux5 m;
    public vj5 n;
    public up5 o;
    public it5 p;
    public kq5 q;
    public ku5 r;
    public ik5 s;

    public static class a implements Runnable {
        public final /* synthetic */ Application f;
        public final /* synthetic */ AirshipConfigOptions g;
        public final /* synthetic */ c h;

        public a(Application application, AirshipConfigOptions airshipConfigOptions, c cVar) {
            this.f = application;
            this.g = airshipConfigOptions;
            this.h = cVar;
        }

        public void run() {
            Application application = this.f;
            AirshipConfigOptions airshipConfigOptions = this.g;
            c cVar = this.h;
            Object obj = UAirship.t;
            if (airshipConfigOptions == null) {
                AirshipConfigOptions.b bVar = new AirshipConfigOptions.b();
                Context applicationContext = application.getApplicationContext();
                try {
                    bVar.a(applicationContext, az5.a(applicationContext, "airshipconfig.properties"));
                } catch (Exception e) {
                    yj5.e(e, "AirshipConfigOptions - Unable to apply config.", new Object[0]);
                }
                airshipConfigOptions = bVar.b();
            }
            String str = airshipConfigOptions.B ? "production" : BaseConstants.DEVELOPMENT;
            Pattern pattern = AirshipConfigOptions.D;
            if (!pattern.matcher(airshipConfigOptions.f711a).matches()) {
                throw new IllegalArgumentException(hj1.c0(hj1.i0("AirshipConfigOptions: "), airshipConfigOptions.f711a, " is not a valid ", str, " app key"));
            } else if (pattern.matcher(airshipConfigOptions.b).matches()) {
                long j = airshipConfigOptions.q;
                if (j < DefaultRefreshIntervals.ACTIVE_CONV_MAX_FETCH_INTERVAL) {
                    yj5.i("AirshipConfigOptions - The backgroundReportingIntervalMS %s may decrease battery life.", Long.valueOf(j));
                } else if (j > 86400000) {
                    yj5.i("AirshipConfigOptions - The backgroundReportingIntervalMS %s may provide less detailed analytic reports.", Long.valueOf(j));
                }
                yj5.f4059a.b = airshipConfigOptions.r;
                StringBuilder sb = new StringBuilder();
                sb.append(UAirship.b());
                sb.append(" - ");
                ak5 ak5 = yj5.f4059a;
                sb.append("UALib");
                yj5.f4059a.f175a = sb.toString();
                yj5.f("Airship taking off!", new Object[0]);
                yj5.f("Airship log level: %s", Integer.valueOf(airshipConfigOptions.r));
                yj5.f("UA Version: %s / App key = %s Production = %s", "14.6.0", airshipConfigOptions.f711a, Boolean.valueOf(airshipConfigOptions.B));
                yj5.h("!SDK-VERSION-STRING!:com.urbanairship.android:urbanairship-core:14.6.0", new Object[0]);
                UAirship.x = new UAirship(airshipConfigOptions);
                synchronized (obj) {
                    UAirship.u = true;
                    UAirship.v = false;
                    UAirship.x.i();
                    yj5.f("Airship ready!", new Object[0]);
                    if (cVar != null) {
                        cVar.a(UAirship.x);
                    }
                    for (oj5 oj5 : UAirship.x.c) {
                        oj5.d(UAirship.x);
                    }
                    List<uj5> list = UAirship.y;
                    synchronized (list) {
                        UAirship.z = false;
                        for (uj5 uj5 : list) {
                            uj5.run();
                        }
                        UAirship.y.clear();
                    }
                    Intent addCategory = new Intent("com.urbanairship.AIRSHIP_READY").setPackage(UAirship.g()).addCategory(UAirship.g());
                    UAirship uAirship = UAirship.x;
                    if (uAirship.q.b.w) {
                        addCategory.putExtra("channel_id", uAirship.j.l());
                        addCategory.putExtra("app_key", UAirship.x.q.b.f711a);
                        addCategory.putExtra("payload_version", 1);
                    }
                    application.sendBroadcast(addCategory);
                    obj.notifyAll();
                }
            } else {
                throw new IllegalArgumentException(hj1.c0(hj1.i0("AirshipConfigOptions: "), airshipConfigOptions.b, " is not a valid ", str, " app secret"));
            }
        }
    }

    public class b implements lq5.c {
        public b() {
        }

        @Override // defpackage.lq5.c
        public void a() {
            for (oj5 oj5 : UAirship.this.c) {
                oj5.h();
            }
        }
    }

    public interface c {
        void a(UAirship uAirship);
    }

    public UAirship(AirshipConfigOptions airshipConfigOptions) {
        this.e = airshipConfigOptions;
    }

    @SuppressLint({"UnknownNullness"})
    public static ApplicationInfo a() {
        return d().getApplicationInfo();
    }

    @SuppressLint({"UnknownNullness"})
    public static String b() {
        return a() != null ? f().getApplicationLabel(a()).toString() : "";
    }

    public static long c() {
        PackageInfo e2 = e();
        if (e2 != null) {
            return h.O(e2);
        }
        return -1;
    }

    public static Context d() {
        Application application = w;
        if (application != null) {
            return application.getApplicationContext();
        }
        throw new IllegalStateException("TakeOff must be called first.");
    }

    public static PackageInfo e() {
        try {
            return f().getPackageInfo(g(), 0);
        } catch (PackageManager.NameNotFoundException e2) {
            yj5.j(e2, "UAirship - Unable to get package info.", new Object[0]);
            return null;
        }
    }

    public static PackageManager f() {
        return d().getPackageManager();
    }

    @SuppressLint({"UnknownNullness"})
    public static String g() {
        return d().getPackageName();
    }

    public static UAirship l() {
        UAirship n2;
        synchronized (t) {
            if (!v) {
                if (!u) {
                    throw new IllegalStateException("Take off must be called before shared()");
                }
            }
            n2 = n(0);
        }
        return n2;
    }

    public static void m(Application application, AirshipConfigOptions airshipConfigOptions, c cVar) {
        if (application != null) {
            if (Looper.myLooper() == null || Looper.getMainLooper() != Looper.myLooper()) {
                yj5.c("takeOff() must be called on the main thread!", new Object[0]);
            }
            synchronized (t) {
                if (!u) {
                    if (!v) {
                        yj5.f("Airship taking off!", new Object[0]);
                        v = true;
                        w = application;
                        pj5.f2814a.execute(new a(application, airshipConfigOptions, cVar));
                        return;
                    }
                }
                yj5.c("You can only call takeOff() once.", new Object[0]);
                return;
            }
        }
        throw new IllegalArgumentException("Application argument must not be null");
    }

    public static UAirship n(long j2) {
        Object obj = t;
        synchronized (obj) {
            if (u) {
                return x;
            }
            if (j2 > 0) {
                try {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    long j3 = j2;
                    while (!u && j3 > 0) {
                        obj.wait(j3);
                        j3 = j2 - (SystemClock.elapsedRealtime() - elapsedRealtime);
                    }
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
            } else {
                while (!u) {
                    obj.wait();
                }
            }
            if (u) {
                return x;
            }
            return null;
        }
    }

    public int h() {
        return this.q.a();
    }

    /* JADX WARNING: Removed duplicated region for block: B:107:0x03ff A[Catch:{ Exception -> 0x0404 }] */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0427 A[Catch:{ Exception -> 0x042c }] */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x044f A[Catch:{ Exception -> 0x0454 }] */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x047f A[Catch:{ Exception -> 0x0486 }] */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x04a9 A[Catch:{ Exception -> 0x04ae }] */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x04d3 A[Catch:{ Exception -> 0x04d8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x04ef A[LOOP:5: B:151:0x04e9->B:153:0x04ef, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void i() {
        /*
        // Method dump skipped, instructions count: 1274
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.UAirship.i():void");
    }

    public final void j(Module module) {
        if (module != null) {
            this.c.addAll(module.f737a);
            Application application = w;
            qk5 qk5 = this.d;
            int i2 = module.b;
            if (i2 != 0) {
                qk5.b(application, i2);
            }
        }
    }

    public <T extends oj5> T k(Class<T> cls) {
        oj5 oj5 = this.b.get(cls);
        T t2 = null;
        if (oj5 == null) {
            Iterator<oj5> it = this.c.iterator();
            while (true) {
                if (!it.hasNext()) {
                    oj5 = null;
                    break;
                }
                oj5 next = it.next();
                if (next.getClass().equals(cls)) {
                    this.b.put(cls, next);
                    oj5 = next;
                    break;
                }
            }
        }
        if (oj5 != null) {
            t2 = (T) oj5;
        }
        if (t2 != null) {
            return t2;
        }
        throw new IllegalArgumentException("Unable to find component " + cls);
    }
}
