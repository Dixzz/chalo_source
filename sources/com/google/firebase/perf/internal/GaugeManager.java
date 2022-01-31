package com.google.firebase.perf.internal;

import android.content.Context;
import androidx.annotation.Keep;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.gauges.CpuGaugeCollector;
import com.google.firebase.perf.gauges.MemoryGaugeCollector;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.v1.ApplicationProcessState;
import com.google.firebase.perf.v1.GaugeMetadata;
import com.google.firebase.perf.v1.GaugeMetric;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

@Keep
public class GaugeManager {
    private static final long APPROX_NUMBER_OF_DATA_POINTS_PER_GAUGE_METRIC = 20;
    private static final long INVALID_GAUGE_COLLECTION_FREQUENCY = -1;
    private static final long TIME_TO_WAIT_BEFORE_FLUSHING_GAUGES_QUEUE_MS = 20;
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private static GaugeManager sharedInstance = new GaugeManager();
    private ApplicationProcessState applicationProcessState;
    private final ConfigResolver configResolver;
    private final CpuGaugeCollector cpuGaugeCollector;
    private ScheduledFuture gaugeManagerDataCollectionJob;
    private final ScheduledExecutorService gaugeManagerExecutor;
    private GaugeMetadataManager gaugeMetadataManager;
    private final MemoryGaugeCollector memoryGaugeCollector;
    private String sessionId;
    private final TransportManager transportManager;

    /* renamed from: com.google.firebase.perf.internal.GaugeManager$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$google$firebase$perf$v1$ApplicationProcessState;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000e */
        static {
            /*
                com.google.firebase.perf.v1.ApplicationProcessState.values()
                r0 = 4
                int[] r0 = new int[r0]
                com.google.firebase.perf.internal.GaugeManager.AnonymousClass1.$SwitchMap$com$google$firebase$perf$v1$ApplicationProcessState = r0
                r1 = 1
                r2 = 2
                com.google.firebase.perf.v1.ApplicationProcessState r3 = com.google.firebase.perf.v1.ApplicationProcessState.BACKGROUND     // Catch:{ NoSuchFieldError -> 0x000e }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000e }
            L_0x000e:
                int[] r0 = com.google.firebase.perf.internal.GaugeManager.AnonymousClass1.$SwitchMap$com$google$firebase$perf$v1$ApplicationProcessState     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.google.firebase.perf.v1.ApplicationProcessState r3 = com.google.firebase.perf.v1.ApplicationProcessState.FOREGROUND     // Catch:{ NoSuchFieldError -> 0x0014 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.internal.GaugeManager.AnonymousClass1.<clinit>():void");
        }
    }

    private GaugeManager() {
        this(Executors.newSingleThreadScheduledExecutor(), TransportManager.getInstance(), ConfigResolver.getInstance(), null, CpuGaugeCollector.getInstance(), MemoryGaugeCollector.getInstance());
    }

    private long getCpuGaugeCollectionFrequencyMs(ApplicationProcessState applicationProcessState2) {
        long j;
        int ordinal = applicationProcessState2.ordinal();
        if (ordinal == 1) {
            j = this.configResolver.getSessionsCpuCaptureFrequencyForegroundMs();
        } else if (ordinal != 2) {
            j = -1;
        } else {
            j = this.configResolver.getSessionsCpuCaptureFrequencyBackgroundMs();
        }
        if (CpuGaugeCollector.isInvalidCollectionFrequency(j)) {
            return -1;
        }
        return j;
    }

    private GaugeMetadata getGaugeMetadata() {
        return (GaugeMetadata) GaugeMetadata.newBuilder().setProcessName(this.gaugeMetadataManager.getProcessName()).setDeviceRamSizeKb(this.gaugeMetadataManager.getDeviceRamSizeKb()).setMaxAppJavaHeapMemoryKb(this.gaugeMetadataManager.getMaxAppJavaHeapMemoryKb()).setMaxEncouragedAppJavaHeapMemoryKb(this.gaugeMetadataManager.getMaxEncouragedAppJavaHeapMemoryKb()).build();
    }

    public static synchronized GaugeManager getInstance() {
        GaugeManager gaugeManager;
        synchronized (GaugeManager.class) {
            gaugeManager = sharedInstance;
        }
        return gaugeManager;
    }

    private long getMemoryGaugeCollectionFrequencyMs(ApplicationProcessState applicationProcessState2) {
        long j;
        int ordinal = applicationProcessState2.ordinal();
        if (ordinal == 1) {
            j = this.configResolver.getSessionsMemoryCaptureFrequencyForegroundMs();
        } else if (ordinal != 2) {
            j = -1;
        } else {
            j = this.configResolver.getSessionsMemoryCaptureFrequencyBackgroundMs();
        }
        if (MemoryGaugeCollector.isInvalidCollectionFrequency(j)) {
            return -1;
        }
        return j;
    }

    private boolean startCollectingCpuMetrics(long j, Timer timer) {
        if (j == -1) {
            logger.debug("Invalid Cpu Metrics collection frequency. Did not collect Cpu Metrics.", new Object[0]);
            return false;
        }
        this.cpuGaugeCollector.startCollecting(j, timer);
        return true;
    }

    private boolean startCollectingMemoryMetrics(long j, Timer timer) {
        if (j == -1) {
            logger.debug("Invalid Memory Metrics collection frequency. Did not collect Memory Metrics.", new Object[0]);
            return false;
        }
        this.memoryGaugeCollector.startCollecting(j, timer);
        return true;
    }

    /* access modifiers changed from: private */
    public void syncFlush(String str, ApplicationProcessState applicationProcessState2) {
        GaugeMetric.Builder newBuilder = GaugeMetric.newBuilder();
        while (!this.cpuGaugeCollector.cpuMetricReadings.isEmpty()) {
            newBuilder.addCpuMetricReadings(this.cpuGaugeCollector.cpuMetricReadings.poll());
        }
        while (!this.memoryGaugeCollector.memoryMetricReadings.isEmpty()) {
            newBuilder.addAndroidMemoryReadings(this.memoryGaugeCollector.memoryMetricReadings.poll());
        }
        newBuilder.setSessionId(str);
        this.transportManager.log((GaugeMetric) newBuilder.build(), applicationProcessState2);
    }

    public void collectGaugeMetricOnce(Timer timer) {
        collectGaugeMetricOnce(this.cpuGaugeCollector, this.memoryGaugeCollector, timer);
    }

    public boolean logGaugeMetadata(String str, ApplicationProcessState applicationProcessState2) {
        if (this.gaugeMetadataManager == null) {
            return false;
        }
        this.transportManager.log((GaugeMetric) GaugeMetric.newBuilder().setSessionId(str).setGaugeMetadata(getGaugeMetadata()).build(), applicationProcessState2);
        return true;
    }

    public void setApplicationContext(Context context) {
        this.gaugeMetadataManager = new GaugeMetadataManager(context);
    }

    public void startCollectingGauges(PerfSession perfSession, ApplicationProcessState applicationProcessState2) {
        if (this.sessionId != null) {
            stopCollectingGauges();
        }
        long startCollectingGauges = startCollectingGauges(applicationProcessState2, perfSession.getTimer());
        if (startCollectingGauges == -1) {
            logger.warn("Invalid gauge collection frequency. Unable to start collecting Gauges.", new Object[0]);
            return;
        }
        String sessionId2 = perfSession.sessionId();
        this.sessionId = sessionId2;
        this.applicationProcessState = applicationProcessState2;
        try {
            long j = startCollectingGauges * 20;
            this.gaugeManagerDataCollectionJob = this.gaugeManagerExecutor.scheduleAtFixedRate(GaugeManager$$Lambda$1.lambdaFactory$(this, sessionId2, applicationProcessState2), j, j, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e) {
            AndroidLogger androidLogger = logger;
            StringBuilder i0 = hj1.i0("Unable to start collecting Gauges: ");
            i0.append(e.getMessage());
            androidLogger.warn(i0.toString(), new Object[0]);
        }
    }

    public void stopCollectingGauges() {
        String str = this.sessionId;
        if (str != null) {
            ApplicationProcessState applicationProcessState2 = this.applicationProcessState;
            this.cpuGaugeCollector.stopCollecting();
            this.memoryGaugeCollector.stopCollecting();
            ScheduledFuture scheduledFuture = this.gaugeManagerDataCollectionJob;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            this.gaugeManagerExecutor.schedule(GaugeManager$$Lambda$2.lambdaFactory$(this, str, applicationProcessState2), 20, TimeUnit.MILLISECONDS);
            this.sessionId = null;
            this.applicationProcessState = ApplicationProcessState.APPLICATION_PROCESS_STATE_UNKNOWN;
        }
    }

    private static void collectGaugeMetricOnce(CpuGaugeCollector cpuGaugeCollector2, MemoryGaugeCollector memoryGaugeCollector2, Timer timer) {
        cpuGaugeCollector2.collectOnce(timer);
        memoryGaugeCollector2.collectOnce(timer);
    }

    public GaugeManager(ScheduledExecutorService scheduledExecutorService, TransportManager transportManager2, ConfigResolver configResolver2, GaugeMetadataManager gaugeMetadataManager2, CpuGaugeCollector cpuGaugeCollector2, MemoryGaugeCollector memoryGaugeCollector2) {
        this.applicationProcessState = ApplicationProcessState.APPLICATION_PROCESS_STATE_UNKNOWN;
        this.sessionId = null;
        this.gaugeManagerDataCollectionJob = null;
        this.gaugeManagerExecutor = scheduledExecutorService;
        this.transportManager = transportManager2;
        this.configResolver = configResolver2;
        this.gaugeMetadataManager = gaugeMetadataManager2;
        this.cpuGaugeCollector = cpuGaugeCollector2;
        this.memoryGaugeCollector = memoryGaugeCollector2;
    }

    private long startCollectingGauges(ApplicationProcessState applicationProcessState2, Timer timer) {
        long cpuGaugeCollectionFrequencyMs = getCpuGaugeCollectionFrequencyMs(applicationProcessState2);
        if (!startCollectingCpuMetrics(cpuGaugeCollectionFrequencyMs, timer)) {
            cpuGaugeCollectionFrequencyMs = -1;
        }
        long memoryGaugeCollectionFrequencyMs = getMemoryGaugeCollectionFrequencyMs(applicationProcessState2);
        if (startCollectingMemoryMetrics(memoryGaugeCollectionFrequencyMs, timer)) {
            return cpuGaugeCollectionFrequencyMs == -1 ? memoryGaugeCollectionFrequencyMs : Math.min(cpuGaugeCollectionFrequencyMs, memoryGaugeCollectionFrequencyMs);
        }
        return cpuGaugeCollectionFrequencyMs;
    }
}
