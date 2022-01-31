package defpackage;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: sd1  reason: default package */
/* compiled from: Foreground */
public class sd1 implements Application.ActivityLifecycleCallbacks {
    public static final String k = sd1.class.getName();
    public static sd1 l;
    public boolean f = false;
    public boolean g = true;
    public Handler h = new Handler();
    public List<b> i = new CopyOnWriteArrayList();
    public Runnable j;

    /* renamed from: sd1$a */
    /* compiled from: Foreground */
    public class a implements Runnable {
        public a() {
        }

        public void run() {
            sd1 sd1 = sd1.this;
            if (!sd1.f || !sd1.g) {
                String str = sd1.k;
                return;
            }
            sd1.f = false;
            String str2 = sd1.k;
            for (b bVar : sd1.i) {
                try {
                    bVar.a();
                } catch (Exception unused) {
                    String str3 = sd1.k;
                }
            }
        }
    }

    /* renamed from: sd1$b */
    /* compiled from: Foreground */
    public interface b {
        void a();

        void b();
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
        this.g = true;
        Runnable runnable = this.j;
        if (runnable != null) {
            this.h.removeCallbacks(runnable);
        }
        Handler handler = this.h;
        a aVar = new a();
        this.j = aVar;
        handler.postDelayed(aVar, 500);
    }

    public void onActivityResumed(Activity activity) {
        this.g = false;
        boolean z = !this.f;
        this.f = true;
        Runnable runnable = this.j;
        if (runnable != null) {
            this.h.removeCallbacks(runnable);
        }
        if (z) {
            for (b bVar : this.i) {
                try {
                    bVar.b();
                } catch (Exception unused) {
                }
            }
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }
}
