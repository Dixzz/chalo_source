package defpackage;

import android.app.Activity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: zl5  reason: default package */
/* compiled from: ForwardingActivityListener */
public class zl5 implements vl5 {
    public final List<vl5> f = new ArrayList();

    public void onActivityCreated(Activity activity, Bundle bundle) {
        Iterator it = new ArrayList(this.f).iterator();
        while (it.hasNext()) {
            ((vl5) it.next()).onActivityCreated(activity, bundle);
        }
    }

    public void onActivityDestroyed(Activity activity) {
        Iterator it = new ArrayList(this.f).iterator();
        while (it.hasNext()) {
            ((vl5) it.next()).onActivityDestroyed(activity);
        }
    }

    public void onActivityPaused(Activity activity) {
        Iterator it = new ArrayList(this.f).iterator();
        while (it.hasNext()) {
            ((vl5) it.next()).onActivityPaused(activity);
        }
    }

    public void onActivityResumed(Activity activity) {
        Iterator it = new ArrayList(this.f).iterator();
        while (it.hasNext()) {
            ((vl5) it.next()).onActivityResumed(activity);
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Iterator it = new ArrayList(this.f).iterator();
        while (it.hasNext()) {
            ((vl5) it.next()).onActivitySaveInstanceState(activity, bundle);
        }
    }

    public void onActivityStarted(Activity activity) {
        Iterator it = new ArrayList(this.f).iterator();
        while (it.hasNext()) {
            ((vl5) it.next()).onActivityStarted(activity);
        }
    }

    public void onActivityStopped(Activity activity) {
        Iterator it = new ArrayList(this.f).iterator();
        while (it.hasNext()) {
            ((vl5) it.next()).onActivityStopped(activity);
        }
    }
}
