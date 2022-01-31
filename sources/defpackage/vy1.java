package defpackage;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* renamed from: vy1  reason: default package */
public final class vy1 extends cz1 {
    public static List<Runnable> j = new ArrayList();
    public boolean f;
    public Set<a> g = new HashSet();
    public boolean h;
    public boolean i;

    /* renamed from: vy1$a */
    public interface a {
        void a(Activity activity);

        void h(Activity activity);
    }

    @TargetApi(14)
    /* renamed from: vy1$b */
    public class b implements Application.ActivityLifecycleCallbacks {
        public b() {
        }

        public final void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public final void onActivityDestroyed(Activity activity) {
        }

        public final void onActivityPaused(Activity activity) {
        }

        public final void onActivityResumed(Activity activity) {
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public final void onActivityStarted(Activity activity) {
            vy1.this.b(activity);
        }

        public final void onActivityStopped(Activity activity) {
            vy1.this.c(activity);
        }
    }

    public vy1(ac3 ac3) {
        super(ac3);
    }

    public static vy1 a(Context context) {
        return ac3.b(context).f();
    }

    public final void b(Activity activity) {
        for (a aVar : this.g) {
            aVar.a(activity);
        }
    }

    public final void c(Activity activity) {
        for (a aVar : this.g) {
            aVar.h(activity);
        }
    }
}
