package defpackage;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.annotation.RecentlyNonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.GuardedBy;

/* renamed from: k32  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class k32 implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {
    public static final k32 j = new k32();
    public final AtomicBoolean f = new AtomicBoolean();
    public final AtomicBoolean g = new AtomicBoolean();
    @GuardedBy("sInstance")
    public final ArrayList<a> h = new ArrayList<>();
    @GuardedBy("sInstance")
    public boolean i = false;

    /* renamed from: k32$a */
    /* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
    public interface a {
        void onBackgroundStateChanged(boolean z);
    }

    public static void b(@RecentlyNonNull Application application) {
        k32 k32 = j;
        synchronized (k32) {
            if (!k32.i) {
                application.registerActivityLifecycleCallbacks(k32);
                application.registerComponentCallbacks(k32);
                k32.i = true;
            }
        }
    }

    public void a(@RecentlyNonNull a aVar) {
        synchronized (j) {
            this.h.add(aVar);
        }
    }

    public boolean c() {
        return this.f.get();
    }

    public final void d(boolean z) {
        synchronized (j) {
            Iterator<a> it = this.h.iterator();
            while (it.hasNext()) {
                it.next().onBackgroundStateChanged(z);
            }
        }
    }

    public final void onActivityCreated(@RecentlyNonNull Activity activity, Bundle bundle) {
        boolean compareAndSet = this.f.compareAndSet(true, false);
        this.g.set(true);
        if (compareAndSet) {
            d(false);
        }
    }

    public final void onActivityDestroyed(@RecentlyNonNull Activity activity) {
    }

    public final void onActivityPaused(@RecentlyNonNull Activity activity) {
    }

    public final void onActivityResumed(@RecentlyNonNull Activity activity) {
        boolean compareAndSet = this.f.compareAndSet(true, false);
        this.g.set(true);
        if (compareAndSet) {
            d(false);
        }
    }

    public final void onActivitySaveInstanceState(@RecentlyNonNull Activity activity, @RecentlyNonNull Bundle bundle) {
    }

    public final void onActivityStarted(@RecentlyNonNull Activity activity) {
    }

    public final void onActivityStopped(@RecentlyNonNull Activity activity) {
    }

    public final void onConfigurationChanged(@RecentlyNonNull Configuration configuration) {
    }

    public final void onLowMemory() {
    }

    public final void onTrimMemory(int i2) {
        if (i2 == 20 && this.f.compareAndSet(false, true)) {
            this.g.set(true);
            d(true);
        }
    }
}
