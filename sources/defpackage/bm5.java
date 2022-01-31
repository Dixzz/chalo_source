package defpackage;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* renamed from: bm5  reason: default package */
/* compiled from: GlobalActivityMonitor */
public class bm5 implements wl5 {
    public static bm5 i;

    /* renamed from: a  reason: collision with root package name */
    public final Handler f450a = new Handler(Looper.getMainLooper());
    public final Runnable b = new b();
    public int c = 0;
    public long d;
    public boolean e;
    public final List<Activity> f = new ArrayList();
    public final am5 g = new am5();
    public final zl5 h = new a();

    /* renamed from: bm5$a */
    /* compiled from: GlobalActivityMonitor */
    public class a extends zl5 {
        public a() {
        }

        @Override // defpackage.zl5
        public void onActivityPaused(Activity activity) {
            bm5.this.f.remove(activity);
            super.onActivityPaused(activity);
        }

        @Override // defpackage.zl5
        public void onActivityResumed(Activity activity) {
            bm5.this.f.add(activity);
            super.onActivityResumed(activity);
        }

        @Override // defpackage.zl5
        public void onActivityStarted(Activity activity) {
            bm5 bm5 = bm5.this;
            bm5.f450a.removeCallbacks(bm5.b);
            bm5 bm52 = bm5.this;
            bm52.c++;
            if (!bm52.e) {
                bm52.e = true;
                bm52.g.a(System.currentTimeMillis());
            }
            super.onActivityStarted(activity);
        }

        @Override // defpackage.zl5
        public void onActivityStopped(Activity activity) {
            bm5 bm5 = bm5.this;
            int i = bm5.c;
            if (i > 0) {
                bm5.c = i - 1;
            }
            if (bm5.c == 0 && bm5.e) {
                bm5.d = System.currentTimeMillis() + 200;
                bm5 bm52 = bm5.this;
                bm52.f450a.postDelayed(bm52.b, 200);
            }
            super.onActivityStopped(activity);
        }
    }

    /* renamed from: bm5$b */
    /* compiled from: GlobalActivityMonitor */
    public class b implements Runnable {
        public b() {
        }

        public void run() {
            bm5 bm5 = bm5.this;
            bm5.e = false;
            bm5.g.b(bm5.d);
        }
    }

    public static bm5 f(Context context) {
        bm5 bm5 = i;
        if (bm5 != null) {
            return bm5;
        }
        synchronized (bm5.class) {
            if (i == null) {
                bm5 bm52 = new bm5();
                i = bm52;
                Objects.requireNonNull(bm52);
                ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(bm52.h);
            }
        }
        return i;
    }

    @Override // defpackage.wl5
    public void a(xl5 xl5) {
        am5 am5 = this.g;
        synchronized (am5.f180a) {
            am5.f180a.add(xl5);
        }
    }

    @Override // defpackage.wl5
    public void b(xl5 xl5) {
        am5 am5 = this.g;
        synchronized (am5.f180a) {
            am5.f180a.remove(xl5);
        }
    }

    @Override // defpackage.wl5
    public List<Activity> c(dk5<Activity> dk5) {
        ArrayList arrayList = new ArrayList();
        for (Activity activity : this.f) {
            if (dk5.apply(activity)) {
                arrayList.add(activity);
            }
        }
        return arrayList;
    }

    @Override // defpackage.wl5
    public boolean d() {
        return this.e;
    }

    @Override // defpackage.wl5
    public void e(vl5 vl5) {
        zl5 zl5 = this.h;
        synchronized (zl5.f) {
            zl5.f.add(vl5);
        }
    }
}
