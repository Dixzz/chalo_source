package defpackage;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import defpackage.vz5;

/* renamed from: uz5  reason: default package */
/* compiled from: ActivityLifecycleManager */
public class uz5 implements Application.ActivityLifecycleCallbacks {
    public final /* synthetic */ vz5.b f;

    public uz5(vz5.a aVar, vz5.b bVar) {
        this.f = bVar;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        this.f.onActivityCreated(activity, bundle);
    }

    public void onActivityDestroyed(Activity activity) {
        this.f.onActivityDestroyed(activity);
    }

    public void onActivityPaused(Activity activity) {
        this.f.onActivityPaused(activity);
    }

    public void onActivityResumed(Activity activity) {
        this.f.onActivityResumed(activity);
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.f.onActivitySaveInstanceState(activity, bundle);
    }

    public void onActivityStarted(Activity activity) {
        this.f.onActivityStarted(activity);
    }

    public void onActivityStopped(Activity activity) {
        this.f.onActivityStopped(activity);
    }
}
