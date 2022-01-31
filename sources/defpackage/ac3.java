package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.SystemClock;
import java.util.List;
import java.util.Objects;

@SuppressLint({"StaticFieldLeak"})
/* renamed from: ac3  reason: default package */
public class ac3 {
    public static volatile ac3 p;

    /* renamed from: a  reason: collision with root package name */
    public final Context f146a;
    public final Context b;
    public final cb2 c = db2.f817a;
    public final ad3 d = new ad3(this);
    public final sd3 e;
    public final jz1 f;
    public final sb3 g;
    public final fd3 h;
    public final je3 i;
    public final vd3 j;
    public final vy1 k;
    public final sc3 l;
    public final rb3 m;
    public final lc3 n;
    public final ed3 o;

    public ac3(cc3 cc3) {
        Context context = cc3.f547a;
        gj1.l(context, "Application context can't be null");
        Context context2 = cc3.b;
        Objects.requireNonNull(context2, "null reference");
        this.f146a = context;
        this.b = context2;
        sd3 sd3 = new sd3(this);
        sd3.Z();
        this.e = sd3;
        sd3 c2 = c();
        String str = zb3.f4152a;
        c2.j(4, hj1.y(hj1.g0(str, 134), "Google Analytics ", str, " is starting up. To enable debug logging on a device run:\n  adb shell setprop log.tag.GAv4 DEBUG\n  adb logcat -s GAv4"), null, null, null);
        vd3 vd3 = new vd3(this);
        vd3.Z();
        this.j = vd3;
        je3 je3 = new je3(this);
        je3.Z();
        this.i = je3;
        sb3 sb3 = new sb3(this, cc3);
        sc3 sc3 = new sc3(this);
        rb3 rb3 = new rb3(this);
        lc3 lc3 = new lc3(this);
        ed3 ed3 = new ed3(this);
        if (jz1.f == null) {
            synchronized (jz1.class) {
                if (jz1.f == null) {
                    jz1.f = new jz1(context);
                }
            }
        }
        jz1 jz1 = jz1.f;
        jz1.e = new bc3(this);
        this.f = jz1;
        vy1 vy1 = new vy1(this);
        sc3.Z();
        this.l = sc3;
        rb3.Z();
        this.m = rb3;
        lc3.Z();
        this.n = lc3;
        ed3.Z();
        this.o = ed3;
        fd3 fd3 = new fd3(this);
        fd3.Z();
        this.h = fd3;
        sb3.Z();
        this.g = sb3;
        ac3 ac3 = vy1.d;
        a(ac3.i);
        je3 je32 = ac3.i;
        je32.g0();
        je32.g0();
        if (je32.l) {
            je32.g0();
            vy1.i = je32.m;
        }
        je32.g0();
        vy1.f = true;
        this.k = vy1;
        mc3 mc3 = sb3.h;
        mc3.g0();
        gj1.o(!mc3.h, "Analytics backend already started");
        mc3.h = true;
        mc3.w().b(new pc3(mc3));
    }

    public static void a(yb3 yb3) {
        gj1.l(yb3, "Analytics service not created/initialized");
        gj1.c(yb3.X(), "Analytics service not initialized");
    }

    public static ac3 b(Context context) {
        Objects.requireNonNull(context, "null reference");
        if (p == null) {
            synchronized (ac3.class) {
                if (p == null) {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    ac3 ac3 = new ac3(new cc3(context));
                    p = ac3;
                    synchronized (vy1.class) {
                        List<Runnable> list = vy1.j;
                        if (list != null) {
                            for (Runnable runnable : list) {
                                runnable.run();
                            }
                            vy1.j = null;
                        }
                    }
                    long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
                    long longValue = id3.D.f1906a.longValue();
                    if (elapsedRealtime2 > longValue) {
                        ac3.c().r("Slow initialization (ms)", Long.valueOf(elapsedRealtime2), Long.valueOf(longValue));
                    }
                }
            }
        }
        return p;
    }

    public final sd3 c() {
        a(this.e);
        return this.e;
    }

    public final jz1 d() {
        Objects.requireNonNull(this.f, "null reference");
        return this.f;
    }

    public final sb3 e() {
        a(this.g);
        return this.g;
    }

    public final vy1 f() {
        Objects.requireNonNull(this.k, "null reference");
        gj1.c(this.k.f, "Analytics instance not initialized");
        return this.k;
    }

    public final sc3 g() {
        a(this.l);
        return this.l;
    }
}
