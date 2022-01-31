package com.google.firebase.perf.transport;

/* compiled from: TransportManager */
public final /* synthetic */ class TransportManager$$Lambda$1 implements Runnable {
    private final TransportManager arg$1;

    private TransportManager$$Lambda$1(TransportManager transportManager) {
        this.arg$1 = transportManager;
    }

    public static Runnable lambdaFactory$(TransportManager transportManager) {
        return new TransportManager$$Lambda$1(transportManager);
    }

    public void run() {
        this.arg$1.syncInit();
    }
}
