package com.google.firebase.perf.transport;

import com.google.firebase.perf.v1.ApplicationProcessState;
import com.google.firebase.perf.v1.NetworkRequestMetric;
import com.google.firebase.perf.v1.PerfMetric;

/* compiled from: TransportManager */
public final /* synthetic */ class TransportManager$$Lambda$5 implements Runnable {
    private final TransportManager arg$1;
    private final NetworkRequestMetric arg$2;
    private final ApplicationProcessState arg$3;

    private TransportManager$$Lambda$5(TransportManager transportManager, NetworkRequestMetric networkRequestMetric, ApplicationProcessState applicationProcessState) {
        this.arg$1 = transportManager;
        this.arg$2 = networkRequestMetric;
        this.arg$3 = applicationProcessState;
    }

    public static Runnable lambdaFactory$(TransportManager transportManager, NetworkRequestMetric networkRequestMetric, ApplicationProcessState applicationProcessState) {
        return new TransportManager$$Lambda$5(transportManager, networkRequestMetric, applicationProcessState);
    }

    public void run() {
        this.arg$1.syncLog(PerfMetric.newBuilder().setNetworkRequestMetric(this.arg$2), this.arg$3);
    }
}
