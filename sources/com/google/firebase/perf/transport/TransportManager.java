package com.google.firebase.perf.transport;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.freshchat.consumer.sdk.beans.config.DefaultRefreshIntervals;
import com.google.firebase.FirebaseApp;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.perf.BuildConfig;
import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.internal.AppStateMonitor;
import com.google.firebase.perf.internal.PerfMetricValidator;
import com.google.firebase.perf.internal.SessionManager;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.util.Constants;
import com.google.firebase.perf.v1.AndroidApplicationInfo;
import com.google.firebase.perf.v1.ApplicationInfo;
import com.google.firebase.perf.v1.ApplicationProcessState;
import com.google.firebase.perf.v1.GaugeMetric;
import com.google.firebase.perf.v1.NetworkRequestMetric;
import com.google.firebase.perf.v1.PerfMetric;
import com.google.firebase.perf.v1.PerfMetricOrBuilder;
import com.google.firebase.perf.v1.TraceMetric;
import com.razorpay.AnalyticsConstants;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

public class TransportManager implements AppStateMonitor.AppStateCallback {
    private static final int CORE_POOL_SIZE = 0;
    private static final String KEY_AVAILABLE_GAUGES_FOR_CACHING = "KEY_AVAILABLE_GAUGES_FOR_CACHING";
    private static final String KEY_AVAILABLE_NETWORK_REQUESTS_FOR_CACHING = "KEY_AVAILABLE_NETWORK_REQUESTS_FOR_CACHING";
    private static final String KEY_AVAILABLE_TRACES_FOR_CACHING = "KEY_AVAILABLE_TRACES_FOR_CACHING";
    private static final int MAX_GAUGE_METRICS_CACHE_SIZE = 50;
    private static final int MAX_NETWORK_REQUEST_METRICS_CACHE_SIZE = 50;
    private static final int MAX_POOL_SIZE = 1;
    private static final int MAX_TRACE_METRICS_CACHE_SIZE = 50;
    private static final TransportManager instance = new TransportManager();
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private Context appContext;
    private AppStateMonitor appStateMonitor;
    private final ApplicationInfo.Builder applicationInfoBuilder = ApplicationInfo.newBuilder();
    private final Map<String, Integer> cacheMap;
    private CctTransport cctTransport;
    private ConfigResolver configResolver;
    private ExecutorService executorService = new ThreadPoolExecutor(0, 1, 10, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private FirebaseApp firebaseApp;
    private FirebaseInstallationsApi firebaseInstallationsApi;
    private FirebasePerformance firebasePerformance;
    private FlgTransport flgTransport;
    private Provider<eu1> flgTransportFactoryProvider;
    private boolean isForegroundState = false;
    private final AtomicBoolean isTransportInitialized = new AtomicBoolean(false);
    private final ConcurrentLinkedQueue<PendingPerfEvent> pendingEventsQueue = new ConcurrentLinkedQueue<>();
    private RateLimiter rateLimiter;

    private TransportManager() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.cacheMap = concurrentHashMap;
        concurrentHashMap.put(KEY_AVAILABLE_TRACES_FOR_CACHING, 50);
        concurrentHashMap.put(KEY_AVAILABLE_NETWORK_REQUESTS_FOR_CACHING, 50);
        concurrentHashMap.put(KEY_AVAILABLE_GAUGES_FOR_CACHING, 50);
    }

    private void dispatchLog(PerfMetric perfMetric) {
        logger.info("Logging %s", getLogcatMsg(perfMetric));
        if (this.configResolver.isDispatchToFlg(perfMetric.getApplicationInfo().getAppInstanceId())) {
            this.flgTransport.log(perfMetric);
        } else {
            this.cctTransport.log(perfMetric);
        }
    }

    private void finishInitialization() {
        this.appStateMonitor.registerForAppState(new WeakReference<>(instance));
        this.applicationInfoBuilder.setGoogleAppId(this.firebaseApp.getOptions().getApplicationId()).setAndroidAppInfo(AndroidApplicationInfo.newBuilder().setPackageName(this.appContext.getPackageName()).setSdkVersion(BuildConfig.FIREPERF_VERSION_NAME).setVersionName(getVersionName(this.appContext)));
        this.isTransportInitialized.set(true);
        while (!this.pendingEventsQueue.isEmpty()) {
            PendingPerfEvent poll = this.pendingEventsQueue.poll();
            if (poll != null) {
                this.executorService.execute(TransportManager$$Lambda$2.lambdaFactory$(this, poll));
            }
        }
    }

    private Map<String, String> getGlobalCustomAttributes() {
        updateFirebasePerformanceIfPossibleAndNeeded();
        FirebasePerformance firebasePerformance2 = this.firebasePerformance;
        if (firebasePerformance2 != null) {
            return firebasePerformance2.getAttributes();
        }
        return Collections.emptyMap();
    }

    public static TransportManager getInstance() {
        return instance;
    }

    private static String getLogcatMsg(PerfMetricOrBuilder perfMetricOrBuilder) {
        if (perfMetricOrBuilder.hasTraceMetric()) {
            return getLogcatMsg(perfMetricOrBuilder.getTraceMetric());
        }
        if (perfMetricOrBuilder.hasNetworkRequestMetric()) {
            return getLogcatMsg(perfMetricOrBuilder.getNetworkRequestMetric());
        }
        return perfMetricOrBuilder.hasGaugeMetric() ? getLogcatMsg(perfMetricOrBuilder.getGaugeMetric()) : AnalyticsConstants.LOG;
    }

    private static String getVersionName(Context context) {
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            if (str == null) {
                return "";
            }
            return str;
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    private void incrementDropCount(PerfMetric perfMetric) {
        if (perfMetric.hasTraceMetric()) {
            this.appStateMonitor.incrementCount(Constants.CounterNames.TRACE_EVENT_RATE_LIMITED.toString(), 1);
        } else if (perfMetric.hasNetworkRequestMetric()) {
            this.appStateMonitor.incrementCount(Constants.CounterNames.NETWORK_TRACE_EVENT_RATE_LIMITED.toString(), 1);
        }
    }

    private boolean isAllowedToCache(PerfMetricOrBuilder perfMetricOrBuilder) {
        int intValue = this.cacheMap.get(KEY_AVAILABLE_TRACES_FOR_CACHING).intValue();
        int intValue2 = this.cacheMap.get(KEY_AVAILABLE_NETWORK_REQUESTS_FOR_CACHING).intValue();
        int intValue3 = this.cacheMap.get(KEY_AVAILABLE_GAUGES_FOR_CACHING).intValue();
        if (perfMetricOrBuilder.hasTraceMetric() && intValue > 0) {
            this.cacheMap.put(KEY_AVAILABLE_TRACES_FOR_CACHING, Integer.valueOf(intValue - 1));
            return true;
        } else if (perfMetricOrBuilder.hasNetworkRequestMetric() && intValue2 > 0) {
            this.cacheMap.put(KEY_AVAILABLE_NETWORK_REQUESTS_FOR_CACHING, Integer.valueOf(intValue2 - 1));
            return true;
        } else if (!perfMetricOrBuilder.hasGaugeMetric() || intValue3 <= 0) {
            logger.debug("%s is not allowed to cache. Cache exhausted the limit (availableTracesForCaching: %d, availableNetworkRequestsForCaching: %d, availableGaugesForCaching: %d).", getLogcatMsg(perfMetricOrBuilder), Integer.valueOf(intValue), Integer.valueOf(intValue2), Integer.valueOf(intValue3));
            return false;
        } else {
            this.cacheMap.put(KEY_AVAILABLE_GAUGES_FOR_CACHING, Integer.valueOf(intValue3 - 1));
            return true;
        }
    }

    private boolean isAllowedToDispatch(PerfMetric perfMetric) {
        if (!this.configResolver.isPerformanceMonitoringEnabled()) {
            logger.info("Performance collection is not enabled, dropping %s", getLogcatMsg(perfMetric));
            return false;
        } else if (!perfMetric.getApplicationInfo().hasAppInstanceId()) {
            logger.warn("App Instance ID is null or empty, dropping %s", getLogcatMsg(perfMetric));
            return false;
        } else if (!PerfMetricValidator.isValid(perfMetric, this.appContext)) {
            logger.warn("Unable to process the PerfMetric (%s) due to missing or invalid values. See earlier log statements for additional information on the specific missing/invalid values.", getLogcatMsg(perfMetric));
            return false;
        } else if (this.rateLimiter.check(perfMetric)) {
            return true;
        } else {
            incrementDropCount(perfMetric);
            if (perfMetric.hasTraceMetric()) {
                logger.info("Rate Limited - %s", getLogcatMsg(perfMetric.getTraceMetric()));
            } else if (perfMetric.hasNetworkRequestMetric()) {
                logger.info("Rate Limited - %s", getLogcatMsg(perfMetric.getNetworkRequestMetric()));
            }
            return false;
        }
    }

    private PerfMetric setApplicationInfoAndBuild(PerfMetric.Builder builder, ApplicationProcessState applicationProcessState) {
        updateFirebaseInstallationIdIfPossibleAndNeeded();
        ApplicationInfo.Builder applicationProcessState2 = this.applicationInfoBuilder.setApplicationProcessState(applicationProcessState);
        if (builder.hasTraceMetric()) {
            applicationProcessState2 = ((ApplicationInfo.Builder) applicationProcessState2.clone()).putAllCustomAttributes(getGlobalCustomAttributes());
        }
        return (PerfMetric) builder.setApplicationInfo(applicationProcessState2).build();
    }

    /* access modifiers changed from: private */
    public void syncInit() {
        this.appContext = this.firebaseApp.getApplicationContext();
        this.configResolver = ConfigResolver.getInstance();
        this.rateLimiter = new RateLimiter(this.appContext, 100.0d, 500);
        this.appStateMonitor = AppStateMonitor.getInstance();
        this.cctTransport = new CctTransport(this.appContext, this.configResolver.getAndCacheLogSourceName());
        this.flgTransport = new FlgTransport(this.flgTransportFactoryProvider, this.configResolver.getAndCacheLogSourceName());
        finishInitialization();
    }

    /* access modifiers changed from: private */
    public void syncLog(PerfMetric.Builder builder, ApplicationProcessState applicationProcessState) {
        if (isInitialized()) {
            PerfMetric applicationInfoAndBuild = setApplicationInfoAndBuild(builder, applicationProcessState);
            if (isAllowedToDispatch(applicationInfoAndBuild)) {
                dispatchLog(applicationInfoAndBuild);
                SessionManager.getInstance().updatePerfSessionIfExpired();
            }
        } else if (isAllowedToCache(builder)) {
            logger.debug("Transport is not initialized yet, %s will be queued for to be dispatched later", getLogcatMsg(builder));
            this.pendingEventsQueue.add(new PendingPerfEvent(builder, applicationProcessState));
        }
    }

    private void updateFirebaseInstallationIdIfPossibleAndNeeded() {
        if (!this.configResolver.isPerformanceMonitoringEnabled()) {
            return;
        }
        if (!this.applicationInfoBuilder.hasAppInstanceId() || this.isForegroundState) {
            String str = null;
            try {
                str = (String) hd3.v(this.firebaseInstallationsApi.getId(), DefaultRefreshIntervals.ACTIVE_CONV_MAX_FETCH_INTERVAL, TimeUnit.MILLISECONDS);
            } catch (ExecutionException e) {
                logger.error("Unable to retrieve Installation Id: %s", e.getMessage());
            } catch (InterruptedException e2) {
                logger.error("Task to retrieve Installation Id is interrupted: %s", e2.getMessage());
            } catch (TimeoutException e3) {
                logger.error("Task to retrieve Installation Id is timed out: %s", e3.getMessage());
            }
            if (!TextUtils.isEmpty(str)) {
                this.applicationInfoBuilder.setAppInstanceId(str);
            } else {
                logger.warn("Firebase Installation Id is empty, contact Firebase Support for debugging.", new Object[0]);
            }
        }
    }

    private void updateFirebasePerformanceIfPossibleAndNeeded() {
        if (this.firebasePerformance == null && isInitialized()) {
            this.firebasePerformance = FirebasePerformance.getInstance();
        }
    }

    public void clearAppInstanceId() {
        this.applicationInfoBuilder.clearAppInstanceId();
    }

    public ConcurrentLinkedQueue<PendingPerfEvent> getPendingEventsQueue() {
        return new ConcurrentLinkedQueue<>(this.pendingEventsQueue);
    }

    public void initialize(FirebaseApp firebaseApp2, FirebaseInstallationsApi firebaseInstallationsApi2, Provider<eu1> provider) {
        this.firebaseApp = firebaseApp2;
        this.firebaseInstallationsApi = firebaseInstallationsApi2;
        this.flgTransportFactoryProvider = provider;
        this.executorService.execute(TransportManager$$Lambda$1.lambdaFactory$(this));
    }

    public void initializeForTest(FirebaseApp firebaseApp2, FirebasePerformance firebasePerformance2, FirebaseInstallationsApi firebaseInstallationsApi2, Provider<eu1> provider, ConfigResolver configResolver2, RateLimiter rateLimiter2, AppStateMonitor appStateMonitor2, CctTransport cctTransport2, FlgTransport flgTransport2, ExecutorService executorService2) {
        this.firebaseApp = firebaseApp2;
        this.appContext = firebaseApp2.getApplicationContext();
        this.firebasePerformance = firebasePerformance2;
        this.firebaseInstallationsApi = firebaseInstallationsApi2;
        this.flgTransportFactoryProvider = provider;
        this.configResolver = configResolver2;
        this.rateLimiter = rateLimiter2;
        this.appStateMonitor = appStateMonitor2;
        this.cctTransport = cctTransport2;
        this.flgTransport = flgTransport2;
        this.executorService = executorService2;
        this.cacheMap.put(KEY_AVAILABLE_TRACES_FOR_CACHING, 50);
        this.cacheMap.put(KEY_AVAILABLE_NETWORK_REQUESTS_FOR_CACHING, 50);
        this.cacheMap.put(KEY_AVAILABLE_GAUGES_FOR_CACHING, 50);
        finishInitialization();
    }

    public boolean isInitialized() {
        return this.isTransportInitialized.get();
    }

    public void log(TraceMetric traceMetric) {
        log(traceMetric, ApplicationProcessState.APPLICATION_PROCESS_STATE_UNKNOWN);
    }

    @Override // com.google.firebase.perf.internal.AppStateMonitor.AppStateCallback
    public void onUpdateAppState(ApplicationProcessState applicationProcessState) {
        this.isForegroundState = applicationProcessState == ApplicationProcessState.FOREGROUND;
        if (isInitialized()) {
            this.executorService.execute(TransportManager$$Lambda$3.lambdaFactory$(this));
        }
    }

    public void setInitialized(boolean z) {
        this.isTransportInitialized.set(z);
    }

    public void log(TraceMetric traceMetric, ApplicationProcessState applicationProcessState) {
        this.executorService.execute(TransportManager$$Lambda$4.lambdaFactory$(this, traceMetric, applicationProcessState));
    }

    public void log(NetworkRequestMetric networkRequestMetric) {
        log(networkRequestMetric, ApplicationProcessState.APPLICATION_PROCESS_STATE_UNKNOWN);
    }

    public void log(NetworkRequestMetric networkRequestMetric, ApplicationProcessState applicationProcessState) {
        this.executorService.execute(TransportManager$$Lambda$5.lambdaFactory$(this, networkRequestMetric, applicationProcessState));
    }

    public void log(GaugeMetric gaugeMetric) {
        log(gaugeMetric, ApplicationProcessState.APPLICATION_PROCESS_STATE_UNKNOWN);
    }

    public void log(GaugeMetric gaugeMetric, ApplicationProcessState applicationProcessState) {
        this.executorService.execute(TransportManager$$Lambda$6.lambdaFactory$(this, gaugeMetric, applicationProcessState));
    }

    private static String getLogcatMsg(TraceMetric traceMetric) {
        long durationUs = traceMetric.getDurationUs();
        return String.format(Locale.ENGLISH, "trace metric: %s (duration: %.4fms)", traceMetric.getName(), Double.valueOf(((double) durationUs) / 1000.0d));
    }

    private static String getLogcatMsg(NetworkRequestMetric networkRequestMetric) {
        return String.format(Locale.ENGLISH, "network request trace: %s (responseCode: %s, responseTime: %.4fms)", networkRequestMetric.getUrl(), networkRequestMetric.hasHttpResponseCode() ? String.valueOf(networkRequestMetric.getHttpResponseCode()) : "UNKNOWN", Double.valueOf(((double) (networkRequestMetric.hasTimeToResponseCompletedUs() ? networkRequestMetric.getTimeToResponseCompletedUs() : 0)) / 1000.0d));
    }

    private static String getLogcatMsg(GaugeMetric gaugeMetric) {
        return String.format(Locale.ENGLISH, "gauges (hasMetadata: %b, cpuGaugeCount: %d, memoryGaugeCount: %d)", Boolean.valueOf(gaugeMetric.hasGaugeMetadata()), Integer.valueOf(gaugeMetric.getCpuMetricReadingsCount()), Integer.valueOf(gaugeMetric.getAndroidMemoryReadingsCount()));
    }
}
