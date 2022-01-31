package defpackage;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Set;

/* renamed from: vz5  reason: default package */
/* compiled from: ActivityLifecycleManager */
public class vz5 {

    /* renamed from: a  reason: collision with root package name */
    public final Application f3698a;
    public a b;

    /* renamed from: vz5$a */
    /* compiled from: ActivityLifecycleManager */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final Set<Application.ActivityLifecycleCallbacks> f3699a = new HashSet();
        public final Application b;

        public a(Application application) {
            this.b = application;
        }
    }

    /* renamed from: vz5$b */
    /* compiled from: ActivityLifecycleManager */
    public static abstract class b {
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public abstract void onActivityStarted(Activity activity);

        public void onActivityStopped(Activity activity) {
        }
    }

    public vz5(Context context) {
        Application application = (Application) context.getApplicationContext();
        this.f3698a = application;
        this.b = new a(application);
    }

    public boolean a(b bVar) {
        boolean z;
        a aVar = this.b;
        if (aVar == null) {
            return false;
        }
        Application application = aVar.b;
        if (application != null) {
            uz5 uz5 = new uz5(aVar, bVar);
            application.registerActivityLifecycleCallbacks(uz5);
            aVar.f3699a.add(uz5);
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return true;
        }
        return false;
    }
}
