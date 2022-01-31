package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.urbanairship.automation.R;
import com.urbanairship.iam.DisplayHandler;
import com.urbanairship.iam.InAppMessage;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: es5  reason: default package */
/* compiled from: BannerAdapter */
public class es5 extends ur5 {
    public static final Map<Class, Integer> j = new HashMap();
    public final hs5 d;
    public final dk5<Activity> e;
    public final vl5 f;
    public WeakReference<Activity> g;
    public WeakReference<is5> h;
    public DisplayHandler i;

    /* renamed from: es5$a */
    /* compiled from: BannerAdapter */
    public class a implements dk5<Activity> {
        public a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.dk5
        public boolean apply(Activity activity) {
            if (es5.this.f(activity) != null) {
                return true;
            }
            yj5.c("BannerAdapter - Unable to display in-app message. No view group found.", new Object[0]);
            return false;
        }
    }

    /* renamed from: es5$b */
    /* compiled from: BannerAdapter */
    public class b extends cm5 {
        public b() {
        }

        @Override // defpackage.cm5
        public void onActivityPaused(Activity activity) {
            is5 g;
            es5 es5 = es5.this;
            if (activity == es5.h() && (g = es5.g()) != null) {
                g.l = false;
                g.getTimer().c();
            }
        }

        public void onActivityResumed(Activity activity) {
            es5 es5 = es5.this;
            is5 g = es5.g();
            if (g != null) {
                AtomicInteger atomicInteger = r8.f3055a;
                if (g.isAttachedToWindow()) {
                    if (activity == es5.h()) {
                        g.l = true;
                        if (!g.k) {
                            g.getTimer().b();
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            es5.e(activity);
        }

        @Override // defpackage.cm5
        public void onActivityStopped(Activity activity) {
            is5 g;
            es5 es5 = es5.this;
            if (activity == es5.h() && (g = es5.g()) != null) {
                es5.h = null;
                es5.g = null;
                g.d(false);
                es5.e(activity.getApplicationContext());
            }
        }
    }

    public es5(InAppMessage inAppMessage, hs5 hs5) {
        super(inAppMessage, hs5.h);
        a aVar = new a();
        this.e = aVar;
        this.f = new yl5(new b(), aVar);
        this.d = hs5;
    }

    @Override // defpackage.ur5, defpackage.gr5
    public boolean c(Context context) {
        if (!super.c(context)) {
            return false;
        }
        return !er5.f(context).c(this.e).isEmpty();
    }

    @Override // defpackage.gr5
    public void d(Context context, DisplayHandler displayHandler) {
        yj5.f("BannerAdapter - Displaying in-app message.", new Object[0]);
        this.i = displayHandler;
        er5.f(context).e(this.f);
        e(context);
    }

    public final void e(Context context) {
        Activity activity;
        ViewGroup f2;
        List<Activity> c = er5.f(context).c(this.e);
        if (!c.isEmpty() && (f2 = f((activity = c.get(0)))) != null) {
            is5 is5 = new is5(activity, this.d, this.c);
            if (h() != activity) {
                if ("bottom".equals(this.d.k)) {
                    int i2 = R.animator.ua_iam_slide_in_bottom;
                    int i3 = R.animator.ua_iam_slide_out_bottom;
                    is5.i = i2;
                    is5.j = i3;
                } else {
                    int i4 = R.animator.ua_iam_slide_in_top;
                    int i5 = R.animator.ua_iam_slide_out_top;
                    is5.i = i4;
                    is5.j = i5;
                }
            }
            is5.setListener(new fs5(this));
            if (is5.getParent() == null) {
                if (f2.getId() == 16908290) {
                    float f3 = 0.0f;
                    for (int i6 = 0; i6 < f2.getChildCount(); i6++) {
                        f3 = Math.max(f2.getChildAt(0).getZ(), f3);
                    }
                    is5.setZ(f3 + 1.0f);
                    f2.addView(is5, 0);
                } else {
                    f2.addView(is5);
                }
            }
            this.g = new WeakReference<>(activity);
            this.h = new WeakReference<>(is5);
        }
    }

    public ViewGroup f(Activity activity) {
        int i2;
        Bundle bundle;
        Map<Class, Integer> map = j;
        synchronized (map) {
            Integer num = map.get(activity.getClass());
            if (num != null) {
                i2 = num.intValue();
            } else {
                i2 = 0;
                ActivityInfo Z0 = hd3.Z0(activity.getClass());
                if (!(Z0 == null || (bundle = Z0.metaData) == null)) {
                    i2 = bundle.getInt("com.urbanairship.iam.banner.BANNER_CONTAINER_ID", 0);
                }
                map.put(activity.getClass(), Integer.valueOf(i2));
            }
        }
        View findViewById = i2 != 0 ? activity.findViewById(i2) : null;
        if (findViewById == null) {
            findViewById = activity.findViewById(16908290);
        }
        if (findViewById instanceof ViewGroup) {
            return (ViewGroup) findViewById;
        }
        return null;
    }

    public final is5 g() {
        WeakReference<is5> weakReference = this.h;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public final Activity h() {
        WeakReference<Activity> weakReference = this.g;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public void i(Context context) {
        er5 f2 = er5.f(context);
        vl5 vl5 = this.f;
        zl5 zl5 = f2.e;
        synchronized (zl5.f) {
            zl5.f.remove(vl5);
        }
    }
}
