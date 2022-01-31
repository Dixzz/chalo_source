package com.google.firebase.perf.gauges;

import com.google.firebase.perf.util.Timer;

/* compiled from: CpuGaugeCollector */
public final /* synthetic */ class CpuGaugeCollector$$Lambda$2 implements Runnable {
    private final CpuGaugeCollector arg$1;
    private final Timer arg$2;

    private CpuGaugeCollector$$Lambda$2(CpuGaugeCollector cpuGaugeCollector, Timer timer) {
        this.arg$1 = cpuGaugeCollector;
        this.arg$2 = timer;
    }

    public static Runnable lambdaFactory$(CpuGaugeCollector cpuGaugeCollector, Timer timer) {
        return new CpuGaugeCollector$$Lambda$2(cpuGaugeCollector, timer);
    }

    public void run() {
        CpuGaugeCollector.lambda$scheduleCpuMetricCollectionOnce$1(this.arg$1, this.arg$2);
    }
}
