package com.google.firebase.perf.transport;

/* compiled from: TransportManager */
public final /* synthetic */ class TransportManager$$Lambda$3 implements Runnable {
    private final TransportManager arg$1;

    private TransportManager$$Lambda$3(TransportManager transportManager) {
        this.arg$1 = transportManager;
    }

    public static Runnable lambdaFactory$(TransportManager transportManager) {
        return new TransportManager$$Lambda$3(transportManager);
    }

    public void run() {
        TransportManager transportManager;
        transportManager.rateLimiter.changeRate(this.arg$1.isForegroundState);
    }
}
