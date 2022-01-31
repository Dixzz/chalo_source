package com.google.firebase.perf.transport;

/* compiled from: TransportManager */
public final /* synthetic */ class TransportManager$$Lambda$2 implements Runnable {
    private final TransportManager arg$1;
    private final PendingPerfEvent arg$2;

    private TransportManager$$Lambda$2(TransportManager transportManager, PendingPerfEvent pendingPerfEvent) {
        this.arg$1 = transportManager;
        this.arg$2 = pendingPerfEvent;
    }

    public static Runnable lambdaFactory$(TransportManager transportManager, PendingPerfEvent pendingPerfEvent) {
        return new TransportManager$$Lambda$2(transportManager, pendingPerfEvent);
    }

    public void run() {
        PendingPerfEvent pendingPerfEvent;
        this.arg$1.syncLog(pendingPerfEvent.perfMetricBuilder, this.arg$2.appState);
    }
}
