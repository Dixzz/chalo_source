package defpackage;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import defpackage.nc5;
import java.lang.ref.WeakReference;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(14)
/* renamed from: qc5  reason: default package */
/* compiled from: MixpanelActivityLifecycleCallbacks */
public class qc5 implements Application.ActivityLifecycleCallbacks {
    public static Double m;
    public Handler f = new Handler(Looper.getMainLooper());
    public Runnable g;
    public boolean h = false;
    public boolean i = true;
    public final nc5 j;
    public final jc5 k;
    public WeakReference<Activity> l;

    /* renamed from: qc5$a */
    /* compiled from: MixpanelActivityLifecycleCallbacks */
    public class a implements Runnable {
        public a() {
        }

        public void run() {
            qc5 qc5 = qc5.this;
            if (qc5.h && qc5.i) {
                qc5.h = false;
                try {
                    double currentTimeMillis = ((double) System.currentTimeMillis()) - qc5.m.doubleValue();
                    jc5 jc5 = qc5.this.k;
                    if (currentTimeMillis >= ((double) jc5.x) && currentTimeMillis < ((double) jc5.y)) {
                        double round = ((double) Math.round((currentTimeMillis / 1000.0d) * 10.0d)) / 10.0d;
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("$ae_session_length", round);
                        qc5.this.j.e.e("$ae_total_app_sessions", 1.0d);
                        qc5.this.j.e.e("$ae_total_app_session_length", round);
                        qc5.this.j.s("$ae_session", jSONObject, true);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                nc5 nc5 = qc5.this.j;
                if (nc5.c.c) {
                    nc5.f();
                }
                nc5.f.f();
            }
        }
    }

    public qc5(nc5 nc5, jc5 jc5) {
        this.j = nc5;
        this.k = jc5;
        if (m == null) {
            m = Double.valueOf((double) System.currentTimeMillis());
        }
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
        this.i = true;
        Runnable runnable = this.g;
        if (runnable != null) {
            this.f.removeCallbacks(runnable);
        }
        this.l = null;
        Handler handler = this.f;
        a aVar = new a();
        this.g = aVar;
        handler.postDelayed(aVar, 500);
    }

    public void onActivityResumed(Activity activity) {
        if (this.k.q) {
            this.j.e.f();
        }
        this.l = new WeakReference<>(activity);
        this.i = false;
        boolean z = !this.h;
        this.h = true;
        Runnable runnable = this.g;
        if (runnable != null) {
            this.f.removeCallbacks(runnable);
        }
        if (z) {
            m = Double.valueOf((double) System.currentTimeMillis());
            this.j.n.b();
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        Intent intent = activity.getIntent();
        if (intent != null && intent.hasExtra("mp_campaign_id") && intent.hasExtra("mp_message_id")) {
            nc5.u(this.j.f2534a, intent, "$app_open", new JSONObject());
        }
        if (this.k.q) {
            nc5.e eVar = this.j.e;
            Objects.requireNonNull(eVar);
            activity.runOnUiThread(new pc5(eVar, null, activity));
        }
    }

    public void onActivityStopped(Activity activity) {
    }
}
