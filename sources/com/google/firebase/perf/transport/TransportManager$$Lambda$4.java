package com.google.firebase.perf.transport;

import com.google.firebase.perf.v1.ApplicationProcessState;
import com.google.firebase.perf.v1.PerfMetric;
import com.google.firebase.perf.v1.TraceMetric;

/* compiled from: TransportManager */
public final /* synthetic */ class TransportManager$$Lambda$4 implements Runnable {
    private final TransportManager arg$1;
    private final TraceMetric arg$2;
    private final ApplicationProcessState arg$3;

    private TransportManager$$Lambda$4(TransportManager transportManager, TraceMetric traceMetric, ApplicationProcessState applicationProcessState) {
        this.arg$1 = transportManager;
        this.arg$2 = traceMetric;
        this.arg$3 = applicationProcessState;
    }

    public static Runnable lambdaFactory$(TransportManager transportManager, TraceMetric traceMetric, ApplicationProcessState applicationProcessState) {
        return new TransportManager$$Lambda$4(transportManager, traceMetric, applicationProcessState);
    }

    public void run() {
        this.arg$1.syncLog(PerfMetric.newBuilder().setTraceMetric(this.arg$2), this.arg$3);
    }
}
