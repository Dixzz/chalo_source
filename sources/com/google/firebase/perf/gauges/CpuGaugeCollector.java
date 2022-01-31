package com.google.firebase.perf.gauges;

import android.os.Process;
import android.system.Os;
import android.system.OsConstants;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.v1.CpuMetricReading;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class CpuGaugeCollector {
    private static final int CSTIME_POSITION_IN_PROC_PID_STAT = 16;
    private static final int CUTIME_POSITION_IN_PROC_PID_STAT = 15;
    public static final long INVALID_CPU_COLLECTION_FREQUENCY = -1;
    private static final int INVALID_SC_PER_CPU_CLOCK_TICK = -1;
    private static final long MICROSECONDS_PER_SECOND = TimeUnit.SECONDS.toMicros(1);
    private static final int STIME_POSITION_IN_PROC_PID_STAT = 14;
    private static final int UNSET_CPU_METRIC_COLLECTION_RATE = -1;
    private static final int UTIME_POSITION_IN_PROC_PID_STAT = 13;
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private static CpuGaugeCollector sharedInstance = null;
    private final long clockTicksPerSecond;
    private long cpuMetricCollectionRateMs;
    private final ScheduledExecutorService cpuMetricCollectorExecutor;
    private ScheduledFuture cpuMetricCollectorJob;
    public final ConcurrentLinkedQueue<CpuMetricReading> cpuMetricReadings;
    private final String procFileName;

    private CpuGaugeCollector() {
        this.cpuMetricCollectorJob = null;
        this.cpuMetricCollectionRateMs = -1;
        this.cpuMetricReadings = new ConcurrentLinkedQueue<>();
        this.cpuMetricCollectorExecutor = Executors.newSingleThreadScheduledExecutor();
        int myPid = Process.myPid();
        StringBuilder i0 = hj1.i0("/proc/");
        i0.append(Integer.toString(myPid));
        i0.append("/stat");
        this.procFileName = i0.toString();
        this.clockTicksPerSecond = getClockTicksPerSecond();
    }

    private long convertClockTicksToMicroseconds(long j) {
        return Math.round((((double) j) / ((double) this.clockTicksPerSecond)) * ((double) MICROSECONDS_PER_SECOND));
    }

    private long getClockTicksPerSecond() {
        return Os.sysconf(OsConstants._SC_CLK_TCK);
    }

    public static CpuGaugeCollector getInstance() {
        if (sharedInstance == null) {
            sharedInstance = new CpuGaugeCollector();
        }
        return sharedInstance;
    }

    public static boolean isInvalidCollectionFrequency(long j) {
        return j <= 0;
    }

    public static /* synthetic */ void lambda$scheduleCpuMetricCollectionOnce$1(CpuGaugeCollector cpuGaugeCollector, Timer timer) {
        CpuMetricReading syncCollectCpuMetric = cpuGaugeCollector.syncCollectCpuMetric(timer);
        if (syncCollectCpuMetric != null) {
            cpuGaugeCollector.cpuMetricReadings.add(syncCollectCpuMetric);
        }
    }

    public static /* synthetic */ void lambda$scheduleCpuMetricCollectionWithRate$0(CpuGaugeCollector cpuGaugeCollector, Timer timer) {
        CpuMetricReading syncCollectCpuMetric = cpuGaugeCollector.syncCollectCpuMetric(timer);
        if (syncCollectCpuMetric != null) {
            cpuGaugeCollector.cpuMetricReadings.add(syncCollectCpuMetric);
        }
    }

    private synchronized void scheduleCpuMetricCollectionOnce(Timer timer) {
        try {
            this.cpuMetricCollectorExecutor.schedule(CpuGaugeCollector$$Lambda$2.lambdaFactory$(this, timer), 0, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e) {
            AndroidLogger androidLogger = logger;
            androidLogger.warn("Unable to collect Cpu Metric: " + e.getMessage(), new Object[0]);
        }
        return;
    }

    private synchronized void scheduleCpuMetricCollectionWithRate(long j, Timer timer) {
        this.cpuMetricCollectionRateMs = j;
        try {
            this.cpuMetricCollectorJob = this.cpuMetricCollectorExecutor.scheduleAtFixedRate(CpuGaugeCollector$$Lambda$1.lambdaFactory$(this, timer), 0, j, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e) {
            AndroidLogger androidLogger = logger;
            androidLogger.warn("Unable to start collecting Cpu Metrics: " + e.getMessage(), new Object[0]);
        }
    }

    private CpuMetricReading syncCollectCpuMetric(Timer timer) {
        if (timer == null) {
            return null;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(this.procFileName));
            try {
                long currentTimestampMicros = timer.getCurrentTimestampMicros();
                String[] split = bufferedReader.readLine().split(" ");
                long parseLong = Long.parseLong(split[13]);
                long parseLong2 = Long.parseLong(split[15]);
                CpuMetricReading cpuMetricReading = (CpuMetricReading) CpuMetricReading.newBuilder().setClientTimeUs(currentTimestampMicros).setSystemTimeUs(convertClockTicksToMicroseconds(Long.parseLong(split[14]) + Long.parseLong(split[16]))).setUserTimeUs(convertClockTicksToMicroseconds(parseLong + parseLong2)).build();
                bufferedReader.close();
                return cpuMetricReading;
            } catch (Throwable unused) {
            }
        } catch (IOException e) {
            AndroidLogger androidLogger = logger;
            StringBuilder i0 = hj1.i0("Unable to read 'proc/[pid]/stat' file: ");
            i0.append(e.getMessage());
            androidLogger.warn(i0.toString(), new Object[0]);
            return null;
        } catch (ArrayIndexOutOfBoundsException | NullPointerException | NumberFormatException e2) {
            AndroidLogger androidLogger2 = logger;
            StringBuilder i02 = hj1.i0("Unexpected '/proc/[pid]/stat' file format encountered: ");
            i02.append(e2.getMessage());
            androidLogger2.warn(i02.toString(), new Object[0]);
            return null;
        }
        throw th;
    }

    public void collectOnce(Timer timer) {
        scheduleCpuMetricCollectionOnce(timer);
    }

    public void startCollecting(long j, Timer timer) {
        long j2 = this.clockTicksPerSecond;
        if (j2 != -1 && j2 != 0 && !isInvalidCollectionFrequency(j)) {
            if (this.cpuMetricCollectorJob == null) {
                scheduleCpuMetricCollectionWithRate(j, timer);
            } else if (this.cpuMetricCollectionRateMs != j) {
                stopCollecting();
                scheduleCpuMetricCollectionWithRate(j, timer);
            }
        }
    }

    public void stopCollecting() {
        ScheduledFuture scheduledFuture = this.cpuMetricCollectorJob;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            this.cpuMetricCollectorJob = null;
            this.cpuMetricCollectionRateMs = -1;
        }
    }

    public CpuGaugeCollector(ScheduledExecutorService scheduledExecutorService, String str, long j) {
        this.cpuMetricCollectorJob = null;
        this.cpuMetricCollectionRateMs = -1;
        this.cpuMetricReadings = new ConcurrentLinkedQueue<>();
        this.cpuMetricCollectorExecutor = scheduledExecutorService;
        this.procFileName = str;
        this.clockTicksPerSecond = j;
    }
}
