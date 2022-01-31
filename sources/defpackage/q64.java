package defpackage;

import com.freshchat.consumer.sdk.beans.config.DefaultRefreshIntervals;
import com.freshchat.consumer.sdk.beans.config.DefaultUserEventsConfig;
import com.google.firebase.appindexing.Indexable;
import com.rabbitmq.client.AMQP;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import server.zophop.Constants;

/* renamed from: q64  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class q64 {
    public static ka4<Long> A;
    public static ka4<Boolean> A0;
    public static ka4<Long> B = a("measurement.upload.retry_time", 1800000L, 1800000L, l74.f2182a);
    public static ka4<Boolean> B0;
    public static ka4<Integer> C = a("measurement.upload.retry_count", 6, 6, o74.f2661a);
    public static ka4<Boolean> C0;
    public static ka4<Long> D = a("measurement.upload.max_queue_time", 2419200000L, 2419200000L, n74.f2520a);
    public static ka4<Boolean> D0;
    public static ka4<Integer> E = a("measurement.lifetimevalue.max_currency_tracked", 4, 4, q74.f2910a);
    public static ka4<Long> E0 = a("measurement.sdk.attribution.cache.ttl", 604800000L, 604800000L, u94.f3472a);
    public static ka4<Integer> F;
    public static ka4<Boolean> F0;
    public static ka4<Integer> G = a("measurement.upload.max_public_user_properties", 25, 25, null);
    public static ka4<Boolean> G0;
    public static ka4<Integer> H = a("measurement.upload.max_event_name_cardinality", 500, 500, null);
    public static ka4<Boolean> H0;
    public static ka4<Integer> I = a("measurement.upload.max_public_event_params", 25, 25, null);
    public static ka4<Boolean> I0;
    public static ka4<Long> J = a("measurement.service_client.idle_disconnect_millis", 5000L, 5000L, r74.f3054a);
    public static ka4<Boolean> J0;
    public static ka4<Boolean> K;
    public static ka4<Integer> K0 = a("measurement.service.storage_consent_support_version", 203590, 203590, z94.f4148a);
    public static ka4<String> L = a("measurement.test.string_flag", "---", "---", t74.f3316a);
    public static ka4<Boolean> L0;
    public static ka4<Long> M = a("measurement.test.long_flag", -1L, -1L, w74.f3740a);
    public static ka4<Boolean> M0;
    public static ka4<Integer> N = a("measurement.test.int_flag", -2, -2, v74.f3613a);
    public static ka4<Boolean> N0;
    public static ka4<Double> O;
    public static ka4<Boolean> O0;
    public static ka4<Integer> P = a("measurement.experiment.max_ids", 50, 50, x74.f3898a);
    public static ka4<Integer> Q = a("measurement.max_bundles_per_iteration", 100, 100, b84.f397a);
    public static ka4<Boolean> R;
    public static ka4<Boolean> S;
    public static ka4<Boolean> T;
    public static ka4<Boolean> U;
    public static ka4<Boolean> V;
    public static ka4<Boolean> W;
    public static ka4<Boolean> X;
    public static ka4<Boolean> Y;
    public static ka4<Boolean> Z;

    /* renamed from: a  reason: collision with root package name */
    public static List<ka4<?>> f2906a = Collections.synchronizedList(new ArrayList());
    public static ka4<Boolean> a0;
    public static ka4<Long> b;
    public static ka4<Boolean> b0;
    public static ka4<Long> c = a("measurement.monitoring.sample_period_millis", 86400000L, 86400000L, s64.f3192a);
    public static ka4<Boolean> c0;
    public static ka4<Long> d = a("measurement.config.cache_time", 86400000L, 3600000L, g74.f1223a);
    public static ka4<Boolean> d0;
    public static ka4<String> e = a("measurement.config.url_scheme", "https", "https", p74.f2777a);
    public static ka4<Boolean> e0;
    public static ka4<String> f = a("measurement.config.url_authority", "app-measurement.com", "app-measurement.com", d84.f808a);
    public static ka4<Boolean> f0;
    public static ka4<Integer> g = a("measurement.upload.max_bundles", 100, 100, m84.f2339a);
    public static ka4<Boolean> g0;
    public static ka4<Integer> h = a("measurement.upload.max_batch_size", 65536, 65536, z84.f4145a);
    public static ka4<Boolean> h0;
    public static ka4<Integer> i = a("measurement.upload.max_bundle_size", 65536, 65536, j94.f1894a);
    public static ka4<Boolean> i0;
    public static ka4<Integer> j;
    public static ka4<Boolean> j0;
    public static ka4<Integer> k = a("measurement.upload.max_events_per_day", 100000, 100000, ha4.f1352a);
    public static ka4<Boolean> k0;
    public static ka4<Integer> l;
    public static ka4<Boolean> l0;
    public static ka4<Integer> m = a("measurement.upload.max_public_events_per_day", 50000, 50000, u64.f3463a);
    public static ka4<Boolean> m0;
    public static ka4<Integer> n = a("measurement.upload.max_conversions_per_day", 10000, 10000, x64.f3892a);
    public static ka4<Boolean> n0;
    public static ka4<Integer> o = a("measurement.upload.max_realtime_events_per_day", 10, 10, w64.f3735a);
    public static ka4<Boolean> o0;
    public static ka4<Integer> p = a("measurement.store.max_stored_events_per_app", 100000, 100000, a74.f130a);
    public static ka4<Boolean> p0;
    public static ka4<String> q = a("measurement.upload.url", "https://app-measurement.com/a", "https://app-measurement.com/a", z64.f4138a);
    public static ka4<Boolean> q0;
    public static ka4<Long> r = a("measurement.upload.backoff_period", 43200000L, 43200000L, c74.f529a);
    public static ka4<Boolean> r0;
    public static ka4<Long> s = a("measurement.upload.window_interval", 3600000L, 3600000L, b74.f390a);
    public static ka4<Boolean> s0;
    public static ka4<Long> t = a("measurement.upload.interval", 3600000L, 3600000L, e74.f938a);
    public static ka4<Boolean> t0;
    public static ka4<Long> u;
    public static ka4<Boolean> u0;
    public static ka4<Long> v = a("measurement.upload.debug_upload_interval", 1000L, 1000L, f74.f1098a);
    public static ka4<Boolean> v0;
    public static ka4<Long> w = a("measurement.upload.minimum_delay", 500L, 500L, i74.f1487a);
    public static ka4<Boolean> w0;
    public static ka4<Long> x;
    public static ka4<Boolean> x0;
    public static ka4<Long> y = a("measurement.upload.stale_data_deletion_interval", 86400000L, 86400000L, k74.f2033a);
    public static ka4<Boolean> y0;
    public static ka4<Long> z = a("measurement.upload.refresh_blacklisted_config_interval", 604800000L, 604800000L, j74.f1889a);
    public static ka4<Boolean> z0;

    static {
        Boolean bool = Boolean.FALSE;
        Collections.synchronizedSet(new HashSet());
        Long valueOf = Long.valueOf((long) Constants.THRESHOLD_TIMESTAMP);
        b = a("measurement.ad_id_cache_time", valueOf, valueOf, t64.f3314a);
        Integer valueOf2 = Integer.valueOf((int) Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL);
        j = a("measurement.upload.max_events_per_bundle", valueOf2, valueOf2, w94.f3747a);
        l = a("measurement.upload.max_error_events_per_day", valueOf2, valueOf2, v64.f3610a);
        u = a("measurement.upload.realtime_upload_interval", valueOf, valueOf, d74.f804a);
        Long valueOf3 = Long.valueOf((long) DefaultRefreshIntervals.ACTIVE_CONV_MAX_FETCH_INTERVAL);
        x = a("measurement.alarm_manager.minimum_interval", valueOf3, valueOf3, h74.f1345a);
        Long valueOf4 = Long.valueOf((long) DefaultUserEventsConfig.MAX_DELAY_IN_MILLIS_UNTIL_UPLOAD);
        A = a("measurement.upload.initial_upload_delay_time", valueOf4, valueOf4, m74.f2334a);
        Integer valueOf5 = Integer.valueOf((int) AMQP.REPLY_SUCCESS);
        F = a("measurement.audience.filter_result_max_count", valueOf5, valueOf5, s74.f3195a);
        K = a("measurement.test.boolean_flag", bool, bool, u74.f3465a);
        Double valueOf6 = Double.valueOf(-3.0d);
        O = a("measurement.test.double_flag", valueOf6, valueOf6, y74.f4014a);
        R = a("measurement.validation.internal_limits_internal_event_params", bool, bool, a84.f134a);
        Boolean bool2 = Boolean.TRUE;
        S = a("measurement.collection.firebase_global_collection_flag_enabled", bool2, bool2, c84.f533a);
        T = a("measurement.collection.efficient_engagement_reporting_enabled_2", bool2, bool2, f84.f1101a);
        U = a("measurement.collection.redundant_engagement_removal_enabled", bool, bool, e84.f940a);
        V = a("measurement.client.freeride_engagement_fix", bool2, bool2, h84.f1347a);
        W = a("measurement.collection.log_event_and_bundle_v2", bool2, bool2, g84.f1225a);
        X = a("measurement.quality.checksum", bool, bool, null);
        Y = a("measurement.sdk.dynamite.allow_remote_dynamite3", bool2, bool2, j84.f1890a);
        Z = a("measurement.sdk.collection.validate_param_names_alphabetical", bool2, bool2, i84.f1490a);
        a0 = a("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", bool, bool, l84.f2185a);
        b0 = a("measurement.audience.refresh_event_count_filters_timestamp", bool, bool, k84.f2035a);
        c0 = a("measurement.audience.use_bundle_timestamp_for_event_count_filters", bool, bool, n84.f2522a);
        d0 = a("measurement.sdk.collection.retrieve_deeplink_from_bow_2", bool2, bool2, p84.f2779a);
        e0 = a("measurement.sdk.collection.last_deep_link_referrer2", bool2, bool2, o84.f2663a);
        f0 = a("measurement.sdk.collection.last_deep_link_referrer_campaign2", bool, bool, r84.f3058a);
        g0 = a("measurement.sdk.collection.last_gclid_from_referrer2", bool, bool, q84.f2912a);
        h0 = a("measurement.sdk.collection.enable_extend_user_property_size", bool2, bool2, t84.f3318a);
        i0 = a("measurement.upload.file_lock_state_check", bool, bool, s84.f3196a);
        j0 = a("measurement.ga.ga_app_id", bool, bool, v84.f3617a);
        k0 = a("measurement.lifecycle.app_in_background_parameter", bool, bool, u84.f3469a);
        l0 = a("measurement.integration.disable_firebase_instance_id", bool, bool, x84.f3901a);
        m0 = a("measurement.lifecycle.app_backgrounded_engagement", bool, bool, w84.f3745a);
        n0 = a("measurement.collection.service.update_with_analytics_fix", bool, bool, y84.f4020a);
        o0 = a("measurement.service.use_appinfo_modified", bool, bool, c94.f539a);
        p0 = a("measurement.client.firebase_feature_rollout.v1.enable", bool2, bool2, b94.f399a);
        q0 = a("measurement.client.sessions.check_on_reset_and_enable2", bool2, bool2, e94.f947a);
        r0 = a("measurement.scheduler.task_thread.cleanup_on_exit", bool, bool, d94.f811a);
        s0 = a("measurement.upload.file_truncate_fix", bool, bool, g94.f1227a);
        t0 = a("measurement.sdk.referrer.delayed_install_referrer_api", bool, bool, f94.f1105a);
        u0 = a("measurement.sdk.screen.disabling_automatic_reporting", bool2, bool2, i94.f1497a);
        v0 = a("measurement.sdk.screen.manual_screen_view_logging", bool2, bool2, h94.f1351a);
        a("measurement.collection.synthetic_data_mitigation", bool, bool, k94.f2037a);
        w0 = a("measurement.service.configurable_service_limits", bool2, bool2, m94.f2342a);
        x0 = a("measurement.client.configurable_service_limits", bool2, bool2, l94.f2191a);
        y0 = a("measurement.androidId.delete_feature", bool2, bool2, o94.f2667a);
        z0 = a("measurement.client.global_params", bool2, bool2, n94.f2525a);
        A0 = a("measurement.service.global_params", bool2, bool2, q94.f2915a);
        B0 = a("measurement.service.global_params_in_payload", bool2, bool2, p94.f2784a);
        C0 = a("measurement.client.string_reader", bool2, bool2, s94.f3199a);
        D0 = a("measurement.sdk.attribution.cache", bool2, bool2, r94.f3061a);
        F0 = a("measurement.service.database_return_empty_collection", bool2, bool2, t94.f3322a);
        G0 = a("measurement.service.ssaid_removal", bool2, bool2, v94.f3621a);
        H0 = a("measurement.client.consent_state_v1", bool2, bool2, y94.f4023a);
        I0 = a("measurement.client.3p_consent_state_v1", bool2, bool2, x94.f3906a);
        J0 = a("measurement.service.consent_state_v1_W36", bool, bool, aa4.f140a);
        L0 = a("measurement.client.ad_impression", bool2, bool2, da4.f814a);
        M0 = a("measurement.service.ad_impression", bool2, bool2, ca4.f540a);
        N0 = a("measurement.service.separate_public_internal_event_blacklisting", bool2, bool2, fa4.f1108a);
        O0 = a("measurement.service.directly_maybe_log_error_events", bool, bool, ea4.f949a);
    }

    public static <V> ka4<V> a(String str, V v2, V v3, ia4<V> ia4) {
        ka4<V> ka4 = new ka4<>(str, v2, v3, ia4, null);
        f2906a.add(ka4);
        return ka4;
    }
}