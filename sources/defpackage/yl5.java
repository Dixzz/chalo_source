package defpackage;

import android.app.Activity;
import android.os.Bundle;

/* renamed from: yl5  reason: default package */
/* compiled from: FilteredActivityListener */
public class yl5 implements vl5 {
    public final vl5 f;
    public final dk5<Activity> g;

    public yl5(vl5 vl5, dk5<Activity> dk5) {
        this.f = vl5;
        this.g = dk5;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (this.g.apply(activity)) {
            this.f.onActivityCreated(activity, bundle);
        }
    }

    public void onActivityDestroyed(Activity activity) {
        if (this.g.apply(activity)) {
            this.f.onActivityDestroyed(activity);
        }
    }

    public void onActivityPaused(Activity activity) {
        if (this.g.apply(activity)) {
            this.f.onActivityPaused(activity);
        }
    }

    public void onActivityResumed(Activity activity) {
        if (this.g.apply(activity)) {
            this.f.onActivityResumed(activity);
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        if (this.g.apply(activity)) {
            this.f.onActivitySaveInstanceState(activity, bundle);
        }
    }

    public void onActivityStarted(Activity activity) {
        if (this.g.apply(activity)) {
            this.f.onActivityStarted(activity);
        }
    }

    public void onActivityStopped(Activity activity) {
        if (this.g.apply(activity)) {
            this.f.onActivityStopped(activity);
        }
    }
}
