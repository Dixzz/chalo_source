package com.google.firebase.perf.config;

import com.google.firebase.perf.BuildConfig;
import com.google.firebase.perf.util.Constants;
import j$.util.Map;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Function;
import java.util.Collections;
import java.util.Map;

public final class ConfigurationConstants {

    public static final class CollectionDeactivated extends ConfigurationFlag<Boolean> {
        private static CollectionDeactivated instance;

        private CollectionDeactivated() {
        }

        public static synchronized CollectionDeactivated getInstance() {
            CollectionDeactivated collectionDeactivated;
            synchronized (CollectionDeactivated.class) {
                if (instance == null) {
                    instance = new CollectionDeactivated();
                }
                collectionDeactivated = instance;
            }
            return collectionDeactivated;
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public String getMetadataFlag() {
            return "firebase_performance_collection_deactivated";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Boolean getDefault() {
            return Boolean.FALSE;
        }
    }

    public static final class CollectionEnabled extends ConfigurationFlag<Boolean> {
        private static CollectionEnabled instance;

        private CollectionEnabled() {
        }

        public static synchronized CollectionEnabled getInstance() {
            CollectionEnabled collectionEnabled;
            synchronized (CollectionEnabled.class) {
                if (instance == null) {
                    instance = new CollectionEnabled();
                }
                collectionEnabled = instance;
            }
            return collectionEnabled;
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public String getDeviceCacheFlag() {
            return Constants.ENABLE_DISABLE;
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public String getMetadataFlag() {
            return "firebase_performance_collection_enabled";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Boolean getDefault() {
            return Boolean.TRUE;
        }
    }

    public static final class LogSourceName extends ConfigurationFlag<String> {
        private static final Map<Long, String> LOG_SOURCE_MAP = Collections.unmodifiableMap(new j$.util.Map() {
            /* class com.google.firebase.perf.config.ConfigurationConstants.LogSourceName.AnonymousClass1 */

            {
                put(461L, "FIREPERF_AUTOPUSH");
                put(462L, "FIREPERF");
                put(675L, "FIREPERF_INTERNAL_LOW");
                put(676L, "FIREPERF_INTERNAL_HIGH");
            }

            @Override // j$.util.Map
            public /* synthetic */ Object compute(Object obj, BiFunction biFunction) {
                return Map.CC.$default$compute(this, obj, biFunction);
            }

            @Override // j$.util.Map
            public /* synthetic */ Object computeIfAbsent(Object obj, Function function) {
                return Map.CC.$default$computeIfAbsent(this, obj, function);
            }

            @Override // j$.util.Map
            public /* synthetic */ Object computeIfPresent(Object obj, BiFunction biFunction) {
                return Map.CC.$default$computeIfPresent(this, obj, biFunction);
            }

            @Override // j$.util.Map
            public /* synthetic */ void forEach(BiConsumer biConsumer) {
                Map.CC.$default$forEach(this, biConsumer);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // java.util.Map, j$.util.Map, java.util.HashMap
            public /* synthetic */ String getOrDefault(Object obj, String str) {
                return Map.CC.$default$getOrDefault(this, obj, str);
            }

            @Override // j$.util.Map
            public /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
                return Map.CC.$default$merge(this, obj, obj2, biFunction);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // java.util.Map, j$.util.Map, java.util.HashMap
            public /* synthetic */ String putIfAbsent(Long l, String str) {
                return Map.CC.$default$putIfAbsent(this, l, str);
            }

            @Override // j$.util.Map
            public /* synthetic */ boolean remove(Object obj, Object obj2) {
                return Map.CC.$default$remove(this, obj, obj2);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // java.util.Map, j$.util.Map, java.util.HashMap
            public /* synthetic */ String replace(Long l, String str) {
                return Map.CC.$default$replace(this, l, str);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
            @Override // java.util.Map, j$.util.Map, java.util.HashMap
            public /* synthetic */ boolean replace(Long l, String str, String str2) {
                return Map.CC.$default$replace(this, l, str, str2);
            }

            @Override // j$.util.Map
            public /* synthetic */ void replaceAll(BiFunction biFunction) {
                Map.CC.$default$replaceAll(this, biFunction);
            }
        });
        private static LogSourceName instance;

        private LogSourceName() {
        }

        public static synchronized LogSourceName getInstance() {
            LogSourceName logSourceName;
            synchronized (LogSourceName.class) {
                if (instance == null) {
                    instance = new LogSourceName();
                }
                logSourceName = instance;
            }
            return logSourceName;
        }

        public static String getLogSourceName(long j) {
            return LOG_SOURCE_MAP.get(Long.valueOf(j));
        }

        public static boolean isLogSourceKnown(long j) {
            return LOG_SOURCE_MAP.containsKey(Long.valueOf(j));
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public String getDeviceCacheFlag() {
            return "com.google.firebase.perf.LogSourceName";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public String getRemoteConfigFlag() {
            return "fpr_log_source";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public String getDefault() {
            return BuildConfig.TRANSPORT_LOG_SRC;
        }
    }

    public static final class NetworkEventCountBackground extends ConfigurationFlag<Long> {
        private static NetworkEventCountBackground instance;

        private NetworkEventCountBackground() {
        }

        public static synchronized NetworkEventCountBackground getInstance() {
            NetworkEventCountBackground networkEventCountBackground;
            synchronized (NetworkEventCountBackground.class) {
                if (instance == null) {
                    instance = new NetworkEventCountBackground();
                }
                networkEventCountBackground = instance;
            }
            return networkEventCountBackground;
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public String getDeviceCacheFlag() {
            return "com.google.firebase.perf.NetworkEventCountBackground";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public String getRemoteConfigFlag() {
            return "fpr_rl_network_event_count_bg";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Long getDefault() {
            return 70L;
        }
    }

    public static final class NetworkEventCountForeground extends ConfigurationFlag<Long> {
        private static NetworkEventCountForeground instance;

        private NetworkEventCountForeground() {
        }

        public static synchronized NetworkEventCountForeground getInstance() {
            NetworkEventCountForeground networkEventCountForeground;
            synchronized (NetworkEventCountForeground.class) {
                if (instance == null) {
                    instance = new NetworkEventCountForeground();
                }
                networkEventCountForeground = instance;
            }
            return networkEventCountForeground;
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public String getDeviceCacheFlag() {
            return "com.google.firebase.perf.NetworkEventCountForeground";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public String getRemoteConfigFlag() {
            return "fpr_rl_network_event_count_fg";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Long getDefault() {
            return 700L;
        }
    }

    public static final class NetworkRequestSamplingRate extends ConfigurationFlag<Float> {
        private static NetworkRequestSamplingRate instance;

        private NetworkRequestSamplingRate() {
        }

        public static synchronized NetworkRequestSamplingRate getInstance() {
            NetworkRequestSamplingRate networkRequestSamplingRate;
            synchronized (NetworkRequestSamplingRate.class) {
                if (instance == null) {
                    instance = new NetworkRequestSamplingRate();
                }
                networkRequestSamplingRate = instance;
            }
            return networkRequestSamplingRate;
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public String getDeviceCacheFlag() {
            return "com.google.firebase.perf.NetworkRequestSamplingRate";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public String getRemoteConfigFlag() {
            return "fpr_vc_network_request_sampling_rate";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Float getDefault() {
            return Float.valueOf(1.0f);
        }
    }

    public static final class RateLimitSec extends ConfigurationFlag<Long> {
        private static RateLimitSec instance;

        private RateLimitSec() {
        }

        public static synchronized RateLimitSec getInstance() {
            RateLimitSec rateLimitSec;
            synchronized (RateLimitSec.class) {
                if (instance == null) {
                    instance = new RateLimitSec();
                }
                rateLimitSec = instance;
            }
            return rateLimitSec;
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public String getDeviceCacheFlag() {
            return "com.google.firebase.perf.TimeLimitSec";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public String getRemoteConfigFlag() {
            return "fpr_rl_time_limit_sec";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Long getDefault() {
            return 600L;
        }
    }

    public static final class SdkDisabledVersions extends ConfigurationFlag<String> {
        private static SdkDisabledVersions instance;

        public static synchronized SdkDisabledVersions getInstance() {
            SdkDisabledVersions sdkDisabledVersions;
            synchronized (SdkDisabledVersions.class) {
                if (instance == null) {
                    instance = new SdkDisabledVersions();
                }
                sdkDisabledVersions = instance;
            }
            return sdkDisabledVersions;
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public String getDefault() {
            return "";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public String getDeviceCacheFlag() {
            return "com.google.firebase.perf.SdkDisabledVersions";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public String getRemoteConfigFlag() {
            return "fpr_disabled_android_versions";
        }
    }

    public static final class SdkEnabled extends ConfigurationFlag<Boolean> {
        private static SdkEnabled instance;

        public static synchronized SdkEnabled getInstance() {
            SdkEnabled sdkEnabled;
            synchronized (SdkEnabled.class) {
                if (instance == null) {
                    instance = new SdkEnabled();
                }
                sdkEnabled = instance;
            }
            return sdkEnabled;
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public String getDeviceCacheFlag() {
            return "com.google.firebase.perf.SdkEnabled";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public String getRemoteConfigFlag() {
            return "fpr_enabled";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Boolean getDefault() {
            return Boolean.TRUE;
        }
    }

    public static final class SessionsCpuCaptureFrequencyBackgroundMs extends ConfigurationFlag<Long> {
        private static SessionsCpuCaptureFrequencyBackgroundMs instance;

        private SessionsCpuCaptureFrequencyBackgroundMs() {
        }

        public static synchronized SessionsCpuCaptureFrequencyBackgroundMs getInstance() {
            SessionsCpuCaptureFrequencyBackgroundMs sessionsCpuCaptureFrequencyBackgroundMs;
            synchronized (SessionsCpuCaptureFrequencyBackgroundMs.class) {
                if (instance == null) {
                    instance = new SessionsCpuCaptureFrequencyBackgroundMs();
                }
                sessionsCpuCaptureFrequencyBackgroundMs = instance;
            }
            return sessionsCpuCaptureFrequencyBackgroundMs;
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public String getDeviceCacheFlag() {
            return "com.google.firebase.perf.SessionsCpuCaptureFrequencyBackgroundMs";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public String getMetadataFlag() {
            return "sessions_cpu_capture_frequency_bg_ms";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public String getRemoteConfigFlag() {
            return "fpr_session_gauge_cpu_capture_frequency_bg_ms";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Long getDefault() {
            return 0L;
        }
    }

    public static final class SessionsCpuCaptureFrequencyForegroundMs extends ConfigurationFlag<Long> {
        private static SessionsCpuCaptureFrequencyForegroundMs instance;

        private SessionsCpuCaptureFrequencyForegroundMs() {
        }

        public static synchronized SessionsCpuCaptureFrequencyForegroundMs getInstance() {
            SessionsCpuCaptureFrequencyForegroundMs sessionsCpuCaptureFrequencyForegroundMs;
            synchronized (SessionsCpuCaptureFrequencyForegroundMs.class) {
                if (instance == null) {
                    instance = new SessionsCpuCaptureFrequencyForegroundMs();
                }
                sessionsCpuCaptureFrequencyForegroundMs = instance;
            }
            return sessionsCpuCaptureFrequencyForegroundMs;
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public String getDeviceCacheFlag() {
            return "com.google.firebase.perf.SessionsCpuCaptureFrequencyForegroundMs";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public String getMetadataFlag() {
            return "sessions_cpu_capture_frequency_fg_ms";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public String getRemoteConfigFlag() {
            return "fpr_session_gauge_cpu_capture_frequency_fg_ms";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Long getDefault() {
            return 100L;
        }
    }

    public static final class SessionsMaxDurationMinutes extends ConfigurationFlag<Long> {
        private static SessionsMaxDurationMinutes instance;

        private SessionsMaxDurationMinutes() {
        }

        public static synchronized SessionsMaxDurationMinutes getInstance() {
            SessionsMaxDurationMinutes sessionsMaxDurationMinutes;
            synchronized (SessionsMaxDurationMinutes.class) {
                if (instance == null) {
                    instance = new SessionsMaxDurationMinutes();
                }
                sessionsMaxDurationMinutes = instance;
            }
            return sessionsMaxDurationMinutes;
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public String getDeviceCacheFlag() {
            return "com.google.firebase.perf.SessionsMaxDurationMinutes";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public String getMetadataFlag() {
            return "sessions_max_length_minutes";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public String getRemoteConfigFlag() {
            return "fpr_session_max_duration_min";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Long getDefault() {
            return 240L;
        }
    }

    public static final class SessionsMemoryCaptureFrequencyBackgroundMs extends ConfigurationFlag<Long> {
        private static SessionsMemoryCaptureFrequencyBackgroundMs instance;

        private SessionsMemoryCaptureFrequencyBackgroundMs() {
        }

        public static synchronized SessionsMemoryCaptureFrequencyBackgroundMs getInstance() {
            SessionsMemoryCaptureFrequencyBackgroundMs sessionsMemoryCaptureFrequencyBackgroundMs;
            synchronized (SessionsMemoryCaptureFrequencyBackgroundMs.class) {
                if (instance == null) {
                    instance = new SessionsMemoryCaptureFrequencyBackgroundMs();
                }
                sessionsMemoryCaptureFrequencyBackgroundMs = instance;
            }
            return sessionsMemoryCaptureFrequencyBackgroundMs;
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public String getDeviceCacheFlag() {
            return "com.google.firebase.perf.SessionsMemoryCaptureFrequencyBackgroundMs";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public String getMetadataFlag() {
            return "sessions_memory_capture_frequency_bg_ms";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public String getRemoteConfigFlag() {
            return "fpr_session_gauge_memory_capture_frequency_bg_ms";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Long getDefault() {
            return 0L;
        }
    }

    public static final class SessionsMemoryCaptureFrequencyForegroundMs extends ConfigurationFlag<Long> {
        private static SessionsMemoryCaptureFrequencyForegroundMs instance;

        private SessionsMemoryCaptureFrequencyForegroundMs() {
        }

        public static synchronized SessionsMemoryCaptureFrequencyForegroundMs getInstance() {
            SessionsMemoryCaptureFrequencyForegroundMs sessionsMemoryCaptureFrequencyForegroundMs;
            synchronized (SessionsMemoryCaptureFrequencyForegroundMs.class) {
                if (instance == null) {
                    instance = new SessionsMemoryCaptureFrequencyForegroundMs();
                }
                sessionsMemoryCaptureFrequencyForegroundMs = instance;
            }
            return sessionsMemoryCaptureFrequencyForegroundMs;
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public String getDeviceCacheFlag() {
            return "com.google.firebase.perf.SessionsMemoryCaptureFrequencyForegroundMs";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public String getMetadataFlag() {
            return "sessions_memory_capture_frequency_fg_ms";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public String getRemoteConfigFlag() {
            return "fpr_session_gauge_memory_capture_frequency_fg_ms";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Long getDefault() {
            return 100L;
        }
    }

    public static final class SessionsSamplingRate extends ConfigurationFlag<Float> {
        private static SessionsSamplingRate instance;

        private SessionsSamplingRate() {
        }

        public static synchronized SessionsSamplingRate getInstance() {
            SessionsSamplingRate sessionsSamplingRate;
            synchronized (SessionsSamplingRate.class) {
                if (instance == null) {
                    instance = new SessionsSamplingRate();
                }
                sessionsSamplingRate = instance;
            }
            return sessionsSamplingRate;
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public String getDeviceCacheFlag() {
            return "com.google.firebase.perf.SessionSamplingRate";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public String getMetadataFlag() {
            return "sessions_sampling_percentage";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public String getRemoteConfigFlag() {
            return "fpr_vc_session_sampling_rate";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Float getDefault() {
            return Float.valueOf(0.01f);
        }
    }

    public static final class TraceEventCountBackground extends ConfigurationFlag<Long> {
        private static TraceEventCountBackground instance;

        private TraceEventCountBackground() {
        }

        public static synchronized TraceEventCountBackground getInstance() {
            TraceEventCountBackground traceEventCountBackground;
            synchronized (TraceEventCountBackground.class) {
                if (instance == null) {
                    instance = new TraceEventCountBackground();
                }
                traceEventCountBackground = instance;
            }
            return traceEventCountBackground;
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public String getDeviceCacheFlag() {
            return "com.google.firebase.perf.TraceEventCountBackground";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public String getRemoteConfigFlag() {
            return "fpr_rl_trace_event_count_bg";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Long getDefault() {
            return 30L;
        }
    }

    public static final class TraceEventCountForeground extends ConfigurationFlag<Long> {
        private static TraceEventCountForeground instance;

        private TraceEventCountForeground() {
        }

        public static synchronized TraceEventCountForeground getInstance() {
            TraceEventCountForeground traceEventCountForeground;
            synchronized (TraceEventCountForeground.class) {
                if (instance == null) {
                    instance = new TraceEventCountForeground();
                }
                traceEventCountForeground = instance;
            }
            return traceEventCountForeground;
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public String getDeviceCacheFlag() {
            return "com.google.firebase.perf.TraceEventCountForeground";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public String getRemoteConfigFlag() {
            return "fpr_rl_trace_event_count_fg";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Long getDefault() {
            return 300L;
        }
    }

    public static final class TraceSamplingRate extends ConfigurationFlag<Float> {
        private static TraceSamplingRate instance;

        private TraceSamplingRate() {
        }

        public static synchronized TraceSamplingRate getInstance() {
            TraceSamplingRate traceSamplingRate;
            synchronized (TraceSamplingRate.class) {
                if (instance == null) {
                    instance = new TraceSamplingRate();
                }
                traceSamplingRate = instance;
            }
            return traceSamplingRate;
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public String getDeviceCacheFlag() {
            return "com.google.firebase.perf.TraceSamplingRate";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public String getRemoteConfigFlag() {
            return "fpr_vc_trace_sampling_rate";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Float getDefault() {
            return Float.valueOf(1.0f);
        }
    }

    public static final class TransportRolloutPercentage extends ConfigurationFlag<Float> {
        private static final float CCT_PERCENTAGE = 0.0f;
        private static final float FLG_PERCENTAGE = 100.0f;
        private static TransportRolloutPercentage instance;

        private TransportRolloutPercentage() {
        }

        public static float getCctPercentage() {
            return 0.0f;
        }

        public static float getFlgPercentage() {
            return FLG_PERCENTAGE;
        }

        public static synchronized TransportRolloutPercentage getInstance() {
            TransportRolloutPercentage transportRolloutPercentage;
            synchronized (TransportRolloutPercentage.class) {
                if (instance == null) {
                    instance = new TransportRolloutPercentage();
                }
                transportRolloutPercentage = instance;
            }
            return transportRolloutPercentage;
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public String getDeviceCacheFlag() {
            return "com.google.firebase.perf.TransportRolloutPercentage";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public String getRemoteConfigFlag() {
            return "fpr_log_transport_android_percent";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Float getDefault() {
            return Float.valueOf(0.0f);
        }
    }
}
