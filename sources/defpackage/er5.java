package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/* renamed from: er5  reason: default package */
/* compiled from: InAppActivityMonitor */
public class er5 implements wl5 {
    public static er5 g;

    /* renamed from: a  reason: collision with root package name */
    public final wl5 f1021a;
    public final Set<Class> b = new HashSet();
    public final Set<Class> c = new HashSet();
    public final dk5<Activity> d;
    public final zl5 e;
    public final yl5 f;

    /* renamed from: er5$a */
    /* compiled from: InAppActivityMonitor */
    public class a implements dk5<Activity> {
        public a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.dk5
        public boolean apply(Activity activity) {
            boolean z;
            Bundle bundle;
            Activity activity2 = activity;
            if (!er5.this.b.contains(activity2.getClass())) {
                if (er5.this.c.contains(activity2.getClass())) {
                    return false;
                }
                Objects.requireNonNull(er5.this);
                ActivityInfo Z0 = hd3.Z0(activity2.getClass());
                if (Z0 == null || (bundle = Z0.metaData) == null || !bundle.getBoolean("com.urbanairship.push.iam.EXCLUDE_FROM_AUTO_SHOW", false)) {
                    z = false;
                } else {
                    yj5.h("Activity contains metadata to exclude it from auto showing an in-app message", new Object[0]);
                    z = true;
                }
                if (z) {
                    er5.this.c.add(activity2.getClass());
                    return false;
                }
                er5.this.b.add(activity2.getClass());
            }
            return true;
        }
    }

    /* renamed from: er5$b */
    /* compiled from: InAppActivityMonitor */
    public class b implements dk5<Activity> {
        public final /* synthetic */ dk5 f;

        public b(dk5 dk5) {
            this.f = dk5;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.dk5
        public boolean apply(Activity activity) {
            Activity activity2 = activity;
            return er5.this.d.apply(activity2) && this.f.apply(activity2);
        }
    }

    public er5(wl5 wl5) {
        a aVar = new a();
        this.d = aVar;
        this.f1021a = wl5;
        zl5 zl5 = new zl5();
        this.e = zl5;
        this.f = new yl5(zl5, aVar);
    }

    public static er5 f(Context context) {
        if (g == null) {
            synchronized (er5.class) {
                if (g == null) {
                    er5 er5 = new er5(bm5.f(context));
                    g = er5;
                    er5.f1021a.e(er5.f);
                }
            }
        }
        return g;
    }

    @Override // defpackage.wl5
    public void a(xl5 xl5) {
        this.f1021a.a(xl5);
    }

    @Override // defpackage.wl5
    public void b(xl5 xl5) {
        this.f1021a.b(xl5);
    }

    @Override // defpackage.wl5
    public List<Activity> c(dk5<Activity> dk5) {
        return this.f1021a.c(new b(dk5));
    }

    @Override // defpackage.wl5
    public boolean d() {
        return this.f1021a.d();
    }

    @Override // defpackage.wl5
    public void e(vl5 vl5) {
        zl5 zl5 = this.e;
        synchronized (zl5.f) {
            zl5.f.add(vl5);
        }
    }
}
