package com.google.firebase.perf.gauges;

import com.google.firebase.perf.util.Timer;

/* compiled from: MemoryGaugeCollector */
public final /* synthetic */ class MemoryGaugeCollector$$Lambda$1 implements Runnable {
    private final MemoryGaugeCollector arg$1;
    private final Timer arg$2;

    private MemoryGaugeCollector$$Lambda$1(MemoryGaugeCollector memoryGaugeCollector, Timer timer) {
        this.arg$1 = memoryGaugeCollector;
        this.arg$2 = timer;
    }

    public static Runnable lambdaFactory$(MemoryGaugeCollector memoryGaugeCollector, Timer timer) {
        return new MemoryGaugeCollector$$Lambda$1(memoryGaugeCollector, timer);
    }

    public void run() {
        MemoryGaugeCollector.lambda$scheduleMemoryMetricCollectionWithRate$0(this.arg$1, this.arg$2);
    }
}
