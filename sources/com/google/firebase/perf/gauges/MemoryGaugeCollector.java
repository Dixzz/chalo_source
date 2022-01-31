package com.google.firebase.perf.gauges;

import android.annotation.SuppressLint;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.util.StorageUnit;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.util.Utils;
import com.google.firebase.perf.v1.AndroidMemoryReading;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class MemoryGaugeCollector {
    public static final long INVALID_MEMORY_COLLECTION_FREQUENCY = -1;
    private static final int UNSET_MEMORY_METRIC_COLLECTION_RATE = -1;
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    @SuppressLint({"StaticFieldLeak"})
    private static final MemoryGaugeCollector sharedInstance = new MemoryGaugeCollector();
    private long memoryMetricCollectionRateMs;
    private final ScheduledExecutorService memoryMetricCollectorExecutor;
    private ScheduledFuture memoryMetricCollectorJob;
    public final ConcurrentLinkedQueue<AndroidMemoryReading> memoryMetricReadings;
    private final Runtime runtime;

    private MemoryGaugeCollector() {
        this(Executors.newSingleThreadScheduledExecutor(), Runtime.getRuntime());
    }

    private int getCurrentUsedAppJavaHeapMemoryKb() {
        return Utils.saturatedIntCast(StorageUnit.BYTES.toKilobytes(this.runtime.totalMemory() - this.runtime.freeMemory()));
    }

    public static MemoryGaugeCollector getInstance() {
        return sharedInstance;
    }

    public static boolean isInvalidCollectionFrequency(long j) {
        return j <= 0;
    }

    public static /* synthetic */ void lambda$scheduleMemoryMetricCollectionOnce$1(MemoryGaugeCollector memoryGaugeCollector, Timer timer) {
        AndroidMemoryReading syncCollectMemoryMetric = memoryGaugeCollector.syncCollectMemoryMetric(timer);
        if (syncCollectMemoryMetric != null) {
            memoryGaugeCollector.memoryMetricReadings.add(syncCollectMemoryMetric);
        }
    }

    public static /* synthetic */ void lambda$scheduleMemoryMetricCollectionWithRate$0(MemoryGaugeCollector memoryGaugeCollector, Timer timer) {
        AndroidMemoryReading syncCollectMemoryMetric = memoryGaugeCollector.syncCollectMemoryMetric(timer);
        if (syncCollectMemoryMetric != null) {
            memoryGaugeCollector.memoryMetricReadings.add(syncCollectMemoryMetric);
        }
    }

    private synchronized void scheduleMemoryMetricCollectionOnce(Timer timer) {
        try {
            this.memoryMetricCollectorExecutor.schedule(MemoryGaugeCollector$$Lambda$4.lambdaFactory$(this, timer), 0, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e) {
            AndroidLogger androidLogger = logger;
            androidLogger.warn("Unable to collect Memory Metric: " + e.getMessage(), new Object[0]);
        }
        return;
    }

    private synchronized void scheduleMemoryMetricCollectionWithRate(long j, Timer timer) {
        this.memoryMetricCollectionRateMs = j;
        try {
            this.memoryMetricCollectorJob = this.memoryMetricCollectorExecutor.scheduleAtFixedRate(MemoryGaugeCollector$$Lambda$1.lambdaFactory$(this, timer), 0, j, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e) {
            AndroidLogger androidLogger = logger;
            androidLogger.warn("Unable to start collecting Memory Metrics: " + e.getMessage(), new Object[0]);
        }
    }

    private AndroidMemoryReading syncCollectMemoryMetric(Timer timer) {
        if (timer == null) {
            return null;
        }
        return (AndroidMemoryReading) AndroidMemoryReading.newBuilder().setClientTimeUs(timer.getCurrentTimestampMicros()).setUsedAppJavaHeapMemoryKb(getCurrentUsedAppJavaHeapMemoryKb()).build();
    }

    public void collectOnce(Timer timer) {
        scheduleMemoryMetricCollectionOnce(timer);
    }

    public void startCollecting(long j, Timer timer) {
        if (!isInvalidCollectionFrequency(j)) {
            if (this.memoryMetricCollectorJob == null) {
                scheduleMemoryMetricCollectionWithRate(j, timer);
            } else if (this.memoryMetricCollectionRateMs != j) {
                stopCollecting();
                scheduleMemoryMetricCollectionWithRate(j, timer);
            }
        }
    }

    public void stopCollecting() {
        ScheduledFuture scheduledFuture = this.memoryMetricCollectorJob;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            this.memoryMetricCollectorJob = null;
            this.memoryMetricCollectionRateMs = -1;
        }
    }

    public MemoryGaugeCollector(ScheduledExecutorService scheduledExecutorService, Runtime runtime2) {
        this.memoryMetricCollectorJob = null;
        this.memoryMetricCollectionRateMs = -1;
        this.memoryMetricCollectorExecutor = scheduledExecutorService;
        this.memoryMetricReadings = new ConcurrentLinkedQueue<>();
        this.runtime = runtime2;
    }
}
