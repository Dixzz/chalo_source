package defpackage;

import android.os.Bundle;
import com.google.android.gms.measurement.internal.zzku;
import com.google.android.gms.measurement.internal.zzz;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Objects;

/* renamed from: od4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class od4 implements Runnable {
    public final /* synthetic */ Bundle f;
    public final /* synthetic */ dd4 g;

    public od4(dd4 dd4, Bundle bundle) {
        this.g = dd4;
        this.f = bundle;
    }

    public final void run() {
        dd4 dd4 = this.g;
        Bundle bundle = this.f;
        dd4.b();
        dd4.s();
        Objects.requireNonNull(bundle, "null reference");
        gj1.j(bundle.getString("name"));
        gj1.j(bundle.getString(FirebaseAnalytics.Param.ORIGIN));
        Objects.requireNonNull(bundle.get(FirebaseAnalytics.Param.VALUE), "null reference");
        if (!dd4.f3331a.d()) {
            dd4.g().n.a("Conditional property not set since app measurement is disabled");
            return;
        }
        try {
            dd4.n().x(new zzz(bundle.getString("app_id"), bundle.getString(FirebaseAnalytics.Param.ORIGIN), new zzku(bundle.getString("name"), bundle.getLong("triggered_timestamp"), bundle.get(FirebaseAnalytics.Param.VALUE), bundle.getString(FirebaseAnalytics.Param.ORIGIN)), bundle.getLong("creation_timestamp"), false, bundle.getString("trigger_event_name"), dd4.h().A(bundle.getString("app_id"), bundle.getString("timed_out_event_name"), bundle.getBundle("timed_out_event_params"), bundle.getString(FirebaseAnalytics.Param.ORIGIN), 0, true, yx3.a() && dd4.f3331a.g.l(q64.L0)), bundle.getLong("trigger_timeout"), dd4.h().A(bundle.getString("app_id"), bundle.getString("triggered_event_name"), bundle.getBundle("triggered_event_params"), bundle.getString(FirebaseAnalytics.Param.ORIGIN), 0, true, yx3.a() && dd4.f3331a.g.l(q64.L0)), bundle.getLong("time_to_live"), dd4.h().A(bundle.getString("app_id"), bundle.getString("expired_event_name"), bundle.getBundle("expired_event_params"), bundle.getString(FirebaseAnalytics.Param.ORIGIN), 0, true, yx3.a() && dd4.f3331a.g.l(q64.L0))));
        } catch (IllegalArgumentException unused) {
        }
    }
}
