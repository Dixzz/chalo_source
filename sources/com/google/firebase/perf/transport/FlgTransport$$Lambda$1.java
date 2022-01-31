package com.google.firebase.perf.transport;

import com.google.firebase.perf.v1.PerfMetric;

/* compiled from: FlgTransport */
public final /* synthetic */ class FlgTransport$$Lambda$1 implements cu1 {
    private static final FlgTransport$$Lambda$1 instance = new FlgTransport$$Lambda$1();

    private FlgTransport$$Lambda$1() {
    }

    public static cu1 lambdaFactory$() {
        return instance;
    }

    @Override // defpackage.cu1
    public Object apply(Object obj) {
        return ((PerfMetric) obj).toByteArray();
    }
}
