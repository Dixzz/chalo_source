package defpackage;

import androidx.recyclerview.widget.RecyclerView;
import com.freshchat.consumer.sdk.beans.config.DefaultRefreshIntervals;
import com.google.firebase.appindexing.Indexable;
import com.google.firebase.crashlytics.internal.settings.SettingsJsonConstants;
import com.google.firebase.perf.util.Constants;
import com.rabbitmq.client.ConnectionFactory;
import java.util.Objects;

/* renamed from: id3  reason: default package */
public final class id3 {
    public static jd3<Long> A = jd3.b("analytics.service_client.connect_timeout_millis", 5000, 5000);
    public static jd3<Long> B = jd3.b("analytics.service_client.reconnect_throttle_millis", 1800000, 1800000);
    public static jd3<Long> C = jd3.b("analytics.monitoring.sample_period_millis", 86400000, 86400000);
    public static jd3<Long> D = jd3.b("analytics.initialization_warning_threshold", 5000, 5000);
    public static jd3<Boolean> E = jd3.d("analytics.gcm_task_service", false, false);

    /* renamed from: a  reason: collision with root package name */
    public static jd3<Boolean> f1506a = jd3.d("analytics.service_client_enabled", true, true);
    public static jd3<String> b = jd3.c("analytics.log_tag", "GAv4", "GAv4-SVC");
    public static jd3<Integer> c = jd3.a("analytics.max_stored_hits", Constants.MAX_URL_LENGTH, Indexable.MAX_STRING_LENGTH);
    public static jd3<Long> d = jd3.b("analytics.local_dispatch_millis", 1800000, 120000);
    public static jd3<Long> e = jd3.b("analytics.initial_local_dispatch_millis", 5000, 5000);
    public static jd3<Long> f = jd3.b("analytics.dispatch_alarm_millis", 7200000, 7200000);
    public static jd3<Long> g = jd3.b("analytics.max_dispatch_alarm_millis", 32400000, 32400000);
    public static jd3<Integer> h = jd3.a("analytics.max_hits_per_dispatch", 20, 20);
    public static jd3<Integer> i = jd3.a("analytics.max_hits_per_batch", 20, 20);
    public static jd3<String> j = jd3.c("analytics.insecure_host", "http://www.google-analytics.com", "http://www.google-analytics.com");
    public static jd3<String> k = jd3.c("analytics.secure_host", "https://ssl.google-analytics.com", "https://ssl.google-analytics.com");
    public static jd3<String> l = jd3.c("analytics.simple_endpoint", "/collect", "/collect");
    public static jd3<String> m = jd3.c("analytics.batching_endpoint", "/batch", "/batch");
    public static jd3<Integer> n = jd3.a("analytics.max_get_length", 2036, 2036);
    public static jd3<String> o;
    public static jd3<String> p;
    public static jd3<Integer> q = jd3.a("analytics.max_hit_length.k", RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST, RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST);
    public static jd3<Integer> r = jd3.a("analytics.max_post_length.k", RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST, RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST);
    public static jd3<Integer> s = jd3.a("analytics.max_batch_post_length", RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST, RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST);
    public static jd3<String> t = jd3.c("analytics.fallback_responses.k", "404,502", "404,502");
    public static jd3<Integer> u = jd3.a("analytics.batch_retry_interval.seconds.k", SettingsJsonConstants.SETTINGS_CACHE_DURATION_DEFAULT, SettingsJsonConstants.SETTINGS_CACHE_DURATION_DEFAULT);
    public static jd3<Integer> v = jd3.a("analytics.http_connection.connect_timeout_millis", ConnectionFactory.DEFAULT_CONNECTION_TIMEOUT, ConnectionFactory.DEFAULT_CONNECTION_TIMEOUT);
    public static jd3<Integer> w = jd3.a("analytics.http_connection.read_timeout_millis", 61000, 61000);
    public static jd3<Long> x = jd3.b("analytics.campaigns.time_limit", 86400000, 86400000);
    public static jd3<Boolean> y = jd3.d("analytics.test.disable_receiver", false, false);
    public static jd3<Long> z = jd3.b("analytics.service_client.idle_disconnect_millis", server.zophop.Constants.THRESHOLD_TIMESTAMP, server.zophop.Constants.THRESHOLD_TIMESTAMP);

    static {
        jd3.d("analytics.service_enabled", false, false);
        jd3.b("analytics.max_tokens", 60, 60);
        Objects.requireNonNull(new s72("analytics.tokens_per_sec", Float.valueOf(0.5f)), "null reference");
        jd3.a("analytics.max_stored_hits_per_app", Constants.MAX_URL_LENGTH, Constants.MAX_URL_LENGTH);
        jd3.a("analytics.max_stored_properties_per_app", 100, 100);
        jd3.b("analytics.min_local_dispatch_millis", 120000, 120000);
        jd3.b("analytics.max_local_dispatch_millis", 7200000, 7200000);
        rc3 rc3 = rc3.BATCH_BY_COUNT;
        o = jd3.c("analytics.batching_strategy.k", rc3.name(), rc3.name());
        String name = wc3.GZIP.name();
        p = jd3.c("analytics.compression_strategy.k", name, name);
        jd3.a("analytics.max_hits_per_request.k", 20, 20);
        jd3.b("analytics.service_monitor_interval", 86400000, 86400000);
        jd3.c("analytics.first_party_experiment_id", "", "");
        jd3.a("analytics.first_party_experiment_variant", 0, 0);
        jd3.b("analytics.service_client.second_connect_delay_millis", 5000, 5000);
        jd3.b("analytics.service_client.unexpected_reconnect_millis", DefaultRefreshIntervals.ACTIVE_CONV_MAX_FETCH_INTERVAL, DefaultRefreshIntervals.ACTIVE_CONV_MAX_FETCH_INTERVAL);
    }
}
