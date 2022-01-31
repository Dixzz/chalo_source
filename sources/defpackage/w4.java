package defpackage;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* renamed from: w4  reason: default package */
/* compiled from: ActivityRecreator */
public final class w4 {

    /* renamed from: a  reason: collision with root package name */
    public static final Class<?> f3716a;
    public static final Field b;
    public static final Field c;
    public static final Method d;
    public static final Method e;
    public static final Method f;
    public static final Handler g = new Handler(Looper.getMainLooper());

    /* renamed from: w4$a */
    /* compiled from: ActivityRecreator */
    public class a implements Runnable {
        public final /* synthetic */ c f;
        public final /* synthetic */ Object g;

        public a(c cVar, Object obj) {
            this.f = cVar;
            this.g = obj;
        }

        public void run() {
            this.f.f = this.g;
        }
    }

    /* renamed from: w4$b */
    /* compiled from: ActivityRecreator */
    public class b implements Runnable {
        public final /* synthetic */ Application f;
        public final /* synthetic */ c g;

        public b(Application application, c cVar) {
            this.f = application;
            this.g = cVar;
        }

        public void run() {
            this.f.unregisterActivityLifecycleCallbacks(this.g);
        }
    }

    /* renamed from: w4$c */
    /* compiled from: ActivityRecreator */
    public static final class c implements Application.ActivityLifecycleCallbacks {
        public Object f;
        public Activity g;
        public final int h;
        public boolean i = false;
        public boolean j = false;
        public boolean k = false;

        public c(Activity activity) {
            this.g = activity;
            this.h = activity.hashCode();
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
            if (this.g == activity) {
                this.g = null;
                this.j = true;
            }
        }

        public void onActivityPaused(Activity activity) {
            if (this.j && !this.k && !this.i) {
                Object obj = this.f;
                int i2 = this.h;
                boolean z = false;
                try {
                    Object obj2 = w4.c.get(activity);
                    if (obj2 == obj) {
                        if (activity.hashCode() == i2) {
                            w4.g.postAtFrontOfQueue(new x4(w4.b.get(activity), obj2));
                            z = true;
                        }
                    }
                } catch (Throwable unused) {
                }
                if (z) {
                    this.k = true;
                    this.f = null;
                }
            }
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
            if (this.g == activity) {
                this.i = true;
            }
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x005d A[SYNTHETIC, Splitter:B:25:0x005d] */
    static {
        /*
        // Method dump skipped, instructions count: 174
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.w4.<clinit>():void");
    }

    public static boolean a() {
        int i = Build.VERSION.SDK_INT;
        return i == 26 || i == 27;
    }

    public static boolean b(Activity activity) {
        Object obj;
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
            return true;
        } else if (a() && f == null) {
            return false;
        } else {
            if (e == null && d == null) {
                return false;
            }
            try {
                Object obj2 = c.get(activity);
                if (obj2 == null || (obj = b.get(activity)) == null) {
                    return false;
                }
                Application application = activity.getApplication();
                c cVar = new c(activity);
                application.registerActivityLifecycleCallbacks(cVar);
                Handler handler = g;
                handler.post(new a(cVar, obj2));
                try {
                    if (a()) {
                        Method method = f;
                        Boolean bool = Boolean.FALSE;
                        method.invoke(obj, obj2, null, null, 0, bool, null, null, bool, bool);
                    } else {
                        activity.recreate();
                    }
                    handler.post(new b(application, cVar));
                    return true;
                } catch (Throwable th) {
                    g.post(new b(application, cVar));
                    throw th;
                }
            } catch (Throwable unused) {
                return false;
            }
        }
    }
}
