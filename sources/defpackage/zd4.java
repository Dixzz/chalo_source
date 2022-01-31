package defpackage;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import java.util.Objects;

@TargetApi(14)
/* renamed from: zd4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zd4 implements Application.ActivityLifecycleCallbacks {
    public final /* synthetic */ dd4 f;

    public zd4(dd4 dd4, ed4 ed4) {
        this.f = dd4;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        try {
            this.f.g().n.a("onActivityCreated");
            Intent intent = activity.getIntent();
            if (intent != null) {
                Uri data = intent.getData();
                if (data == null || !data.isHierarchical()) {
                    this.f.o().x(activity, bundle);
                    return;
                }
                this.f.h();
                this.f.f().u(new de4(this, bundle == null, data, ug4.U(intent) ? "gs" : "auto", data.getQueryParameter("referrer")));
                this.f.o().x(activity, bundle);
            }
        } catch (Exception e) {
            this.f.g().f.b("Throwable caught in onActivityCreated", e);
        } finally {
            this.f.o().x(activity, bundle);
        }
    }

    public final void onActivityDestroyed(Activity activity) {
        ie4 o = this.f.o();
        synchronized (o.l) {
            if (activity == o.g) {
                o.g = null;
            }
        }
        if (o.f3331a.g.y().booleanValue()) {
            o.f.remove(activity);
        }
    }

    public final void onActivityPaused(Activity activity) {
        ie4 o = this.f.o();
        if (o.f3331a.g.l(q64.v0)) {
            synchronized (o.l) {
                o.k = false;
                o.h = true;
            }
        }
        Objects.requireNonNull((db2) o.f3331a.n);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (!o.f3331a.g.l(q64.u0) || o.f3331a.g.y().booleanValue()) {
            je4 D = o.D(activity);
            o.d = o.c;
            o.c = null;
            o.f().u(new pe4(o, D, elapsedRealtime));
        } else {
            o.c = null;
            o.f().u(new me4(o, elapsedRealtime));
        }
        xf4 q = this.f.q();
        Objects.requireNonNull((db2) q.f3331a.n);
        q.f().u(new zf4(q, SystemClock.elapsedRealtime()));
    }

    public final void onActivityResumed(Activity activity) {
        xf4 q = this.f.q();
        Objects.requireNonNull((db2) q.f3331a.n);
        q.f().u(new wf4(q, SystemClock.elapsedRealtime()));
        ie4 o = this.f.o();
        if (o.f3331a.g.l(q64.v0)) {
            synchronized (o.l) {
                o.k = true;
                if (activity != o.g) {
                    synchronized (o.l) {
                        o.g = activity;
                        o.h = false;
                    }
                    if (o.f3331a.g.l(q64.u0) && o.f3331a.g.y().booleanValue()) {
                        o.i = null;
                        o.f().u(new oe4(o));
                    }
                }
            }
        }
        if (!o.f3331a.g.l(q64.u0) || o.f3331a.g.y().booleanValue()) {
            o.y(activity, o.D(activity), false);
            b64 j = o.j();
            Objects.requireNonNull((db2) j.f3331a.n);
            j.f().u(new ba4(j, SystemClock.elapsedRealtime()));
            return;
        }
        o.c = o.i;
        o.f().u(new ne4(o));
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        je4 je4;
        ie4 o = this.f.o();
        if (o.f3331a.g.y().booleanValue() && bundle != null && (je4 = o.f.get(activity)) != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putLong("id", je4.c);
            bundle2.putString("name", je4.f1911a);
            bundle2.putString("referrer_name", je4.b);
            bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
        }
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }
}
