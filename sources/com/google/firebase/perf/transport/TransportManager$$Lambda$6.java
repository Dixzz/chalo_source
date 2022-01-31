package com.google.firebase.perf.transport;

import com.google.firebase.perf.v1.ApplicationProcessState;
import com.google.firebase.perf.v1.GaugeMetric;
import com.google.firebase.perf.v1.PerfMetric;

/* compiled from: TransportManager */
public final /* synthetic */ class TransportManager$$Lambda$6 implements Runnable {
    private final TransportManager arg$1;
    private final GaugeMetric arg$2;
    private final ApplicationProcessState arg$3;

    private TransportManager$$Lambda$6(TransportManager transportManager, GaugeMetric gaugeMetric, ApplicationProcessState applicationProcessState) {
        this.arg$1 = transportManager;
        this.arg$2 = gaugeMetric;
        this.arg$3 = applicationProcessState;
    }

    public static Runnable lambdaFactory$(TransportManager transportManager, GaugeMetric gaugeMetric, ApplicationProcessState applicationProcessState) {
        return new TransportManager$$Lambda$6(transportManager, gaugeMetric, applicationProcessState);
    }

    public void run() {
        this.arg$1.syncLog(PerfMetric.newBuilder().setGaugeMetric(this.arg$2), this.arg$3);
    }
}
