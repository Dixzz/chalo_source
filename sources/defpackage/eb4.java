package defpackage;

import android.content.SharedPreferences;
import android.util.Pair;
import server.zophop.Constants;

/* renamed from: eb4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class eb4 extends sc4 {
    public static final Pair<String, Long> D = new Pair<>("", 0L);
    public final kb4 A = new kb4(this, "deferred_attribution_cache");
    public final ib4 B = new ib4(this, "deferred_attribution_cache_timestamp", 0);
    public final jb4 C = new jb4(this, "default_event_parameters");
    public SharedPreferences c;
    public lb4 d;
    public final ib4 e = new ib4(this, "last_upload", 0);
    public final ib4 f = new ib4(this, "last_upload_attempt", 0);
    public final ib4 g = new ib4(this, "backoff", 0);
    public final ib4 h = new ib4(this, "last_delete_stale", 0);
    public final ib4 i = new ib4(this, "midnight_offset", 0);
    public final ib4 j = new ib4(this, "first_open_time", 0);
    public final ib4 k = new ib4(this, "app_install_time", 0);
    public final kb4 l = new kb4(this, "app_instance_id");
    public String m;
    public boolean n;
    public long o;
    public final ib4 p = new ib4(this, "time_before_start", Constants.THRESHOLD_TIMESTAMP);
    public final ib4 q = new ib4(this, "session_timeout", 1800000);
    public final gb4 r = new gb4(this, "start_new_session", true);
    public final kb4 s = new kb4(this, "non_personalized_ads");
    public final gb4 t = new gb4(this, "allow_remote_dynamite", false);
    public final ib4 u = new ib4(this, "last_pause_time", 0);
    public boolean v;
    public gb4 w = new gb4(this, "app_backgrounded", false);
    public gb4 x = new gb4(this, "deep_link_retrieval_complete", false);
    public ib4 y = new ib4(this, "deep_link_retrieval_attempts", 0);
    public final kb4 z = new kb4(this, "firebase_feature_rollouts");

    public eb4(vb4 vb4) {
        super(vb4);
    }

    @Override // defpackage.sc4
    public final void j() {
        SharedPreferences sharedPreferences = this.f3331a.f3627a.getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.c = sharedPreferences;
        boolean z2 = sharedPreferences.getBoolean("has_been_opened", false);
        this.v = z2;
        if (!z2) {
            SharedPreferences.Editor edit = this.c.edit();
            edit.putBoolean("has_been_opened", true);
            edit.apply();
        }
        this.d = new lb4(this, "health_monitor", Math.max(0L, q64.c.a(null).longValue()), null);
    }

    @Override // defpackage.sc4
    public final boolean p() {
        return true;
    }

    public final void q(Boolean bool) {
        b();
        SharedPreferences.Editor edit = v().edit();
        if (bool != null) {
            edit.putBoolean("measurement_enabled", bool.booleanValue());
        } else {
            edit.remove("measurement_enabled");
        }
        edit.apply();
    }

    public final boolean s(int i2) {
        return e64.e(i2, v().getInt("consent_source", 100));
    }

    public final boolean t(long j2) {
        return j2 - this.q.a() > this.u.a();
    }

    public final void u(boolean z2) {
        b();
        g().n.b("App measurement setting deferred collection", Boolean.valueOf(z2));
        SharedPreferences.Editor edit = v().edit();
        edit.putBoolean("deferred_analytics_collection", z2);
        edit.apply();
    }

    public final SharedPreferences v() {
        b();
        l();
        return this.c;
    }

    public final Boolean w() {
        b();
        if (v().contains("measurement_enabled")) {
            return Boolean.valueOf(v().getBoolean("measurement_enabled", true));
        }
        return null;
    }

    public final e64 x() {
        b();
        return e64.b(v().getString("consent_settings", "G1"));
    }
}
