package defpackage;

import com.freshchat.consumer.sdk.beans.config.DefaultRefreshIntervals;
import com.freshchat.consumer.sdk.beans.config.DefaultUserEventsConfig;
import server.zophop.Constants;

/* renamed from: qy3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class qy3 implements ny3 {
    public static final is3<Long> A;
    public static final is3<Long> B;
    public static final is3<Long> C;
    public static final is3<Long> D;
    public static final is3<Long> E;
    public static final is3<String> F;
    public static final is3<Long> G;

    /* renamed from: a  reason: collision with root package name */
    public static final is3<Long> f3007a;
    public static final is3<Long> b;
    public static final is3<String> c;
    public static final is3<String> d;
    public static final is3<Long> e;
    public static final is3<Long> f;
    public static final is3<Long> g;
    public static final is3<Long> h;
    public static final is3<Long> i;
    public static final is3<Long> j;
    public static final is3<Long> k;
    public static final is3<Long> l;
    public static final is3<Long> m;
    public static final is3<Long> n;
    public static final is3<Long> o;
    public static final is3<Long> p;
    public static final is3<Long> q;
    public static final is3<Long> r;
    public static final is3<Long> s;
    public static final is3<Long> t;
    public static final is3<Long> u;
    public static final is3<Long> v;
    public static final is3<Long> w;
    public static final is3<Long> x;
    public static final is3<Long> y;
    public static final is3<Long> z;

    static {
        ns3 ns3 = new ns3(fs3.a("com.google.android.gms.measurement"));
        f3007a = ns3.a("measurement.ad_id_cache_time", Constants.THRESHOLD_TIMESTAMP);
        b = ns3.a("measurement.config.cache_time", 86400000);
        ns3.b("measurement.log_tag", "FA");
        c = ns3.b("measurement.config.url_authority", "app-measurement.com");
        d = ns3.b("measurement.config.url_scheme", "https");
        e = ns3.a("measurement.upload.debug_upload_interval", 1000);
        f = ns3.a("measurement.lifetimevalue.max_currency_tracked", 4);
        g = ns3.a("measurement.store.max_stored_events_per_app", 100000);
        h = ns3.a("measurement.experiment.max_ids", 50);
        i = ns3.a("measurement.audience.filter_result_max_count", 200);
        j = ns3.a("measurement.alarm_manager.minimum_interval", DefaultRefreshIntervals.ACTIVE_CONV_MAX_FETCH_INTERVAL);
        k = ns3.a("measurement.upload.minimum_delay", 500);
        l = ns3.a("measurement.monitoring.sample_period_millis", 86400000);
        m = ns3.a("measurement.upload.realtime_upload_interval", Constants.THRESHOLD_TIMESTAMP);
        n = ns3.a("measurement.upload.refresh_blacklisted_config_interval", 604800000);
        ns3.a("measurement.config.cache_time.service", 3600000);
        o = ns3.a("measurement.service_client.idle_disconnect_millis", 5000);
        ns3.b("measurement.log_tag.service", "FA-SVC");
        p = ns3.a("measurement.upload.stale_data_deletion_interval", 86400000);
        q = ns3.a("measurement.upload.backoff_period", 43200000);
        r = ns3.a("measurement.upload.initial_upload_delay_time", DefaultUserEventsConfig.MAX_DELAY_IN_MILLIS_UNTIL_UPLOAD);
        s = ns3.a("measurement.upload.interval", 3600000);
        t = ns3.a("measurement.upload.max_bundle_size", 65536);
        u = ns3.a("measurement.upload.max_bundles", 100);
        v = ns3.a("measurement.upload.max_conversions_per_day", 500);
        w = ns3.a("measurement.upload.max_error_events_per_day", 1000);
        x = ns3.a("measurement.upload.max_events_per_bundle", 1000);
        y = ns3.a("measurement.upload.max_events_per_day", 100000);
        z = ns3.a("measurement.upload.max_public_events_per_day", 50000);
        A = ns3.a("measurement.upload.max_queue_time", 2419200000L);
        B = ns3.a("measurement.upload.max_realtime_events_per_day", 10);
        C = ns3.a("measurement.upload.max_batch_size", 65536);
        D = ns3.a("measurement.upload.retry_count", 6);
        E = ns3.a("measurement.upload.retry_time", 1800000);
        F = ns3.b("measurement.upload.url", "https://app-measurement.com/a");
        G = ns3.a("measurement.upload.window_interval", 3600000);
    }

    @Override // defpackage.ny3
    public final long A() {
        return B.d().longValue();
    }

    @Override // defpackage.ny3
    public final long a() {
        return r.d().longValue();
    }

    @Override // defpackage.ny3
    public final long b() {
        return j.d().longValue();
    }

    @Override // defpackage.ny3
    public final long c() {
        return k.d().longValue();
    }

    @Override // defpackage.ny3
    public final long d() {
        return o.d().longValue();
    }

    @Override // defpackage.ny3
    public final long e() {
        return l.d().longValue();
    }

    @Override // defpackage.ny3
    public final long f() {
        return p.d().longValue();
    }

    @Override // defpackage.ny3
    public final long g() {
        return q.d().longValue();
    }

    @Override // defpackage.ny3
    public final long h() {
        return i.d().longValue();
    }

    @Override // defpackage.ny3
    public final long i() {
        return h.d().longValue();
    }

    @Override // defpackage.ny3
    public final long j() {
        return n.d().longValue();
    }

    @Override // defpackage.ny3
    public final long k() {
        return w.d().longValue();
    }

    @Override // defpackage.ny3
    public final long l() {
        return E.d().longValue();
    }

    @Override // defpackage.ny3
    public final long m() {
        return m.d().longValue();
    }

    @Override // defpackage.ny3
    public final String n() {
        return F.d();
    }

    @Override // defpackage.ny3
    public final long o() {
        return u.d().longValue();
    }

    @Override // defpackage.ny3
    public final long p() {
        return v.d().longValue();
    }

    @Override // defpackage.ny3
    public final long q() {
        return D.d().longValue();
    }

    @Override // defpackage.ny3
    public final long r() {
        return t.d().longValue();
    }

    @Override // defpackage.ny3
    public final long s() {
        return y.d().longValue();
    }

    @Override // defpackage.ny3
    public final long t() {
        return G.d().longValue();
    }

    @Override // defpackage.ny3
    public final long u() {
        return z.d().longValue();
    }

    @Override // defpackage.ny3
    public final long v() {
        return x.d().longValue();
    }

    @Override // defpackage.ny3
    public final long w() {
        return C.d().longValue();
    }

    @Override // defpackage.ny3
    public final long x() {
        return g.d().longValue();
    }

    @Override // defpackage.ny3
    public final long y() {
        return A.d().longValue();
    }

    @Override // defpackage.ny3
    public final long z() {
        return s.d().longValue();
    }

    @Override // defpackage.ny3
    public final long zza() {
        return f3007a.d().longValue();
    }

    @Override // defpackage.ny3
    public final long zzb() {
        return b.d().longValue();
    }

    @Override // defpackage.ny3
    public final String zzc() {
        return c.d();
    }

    @Override // defpackage.ny3
    public final String zzd() {
        return d.d();
    }

    @Override // defpackage.ny3
    public final long zze() {
        return e.d().longValue();
    }

    @Override // defpackage.ny3
    public final long zzf() {
        return f.d().longValue();
    }
}
