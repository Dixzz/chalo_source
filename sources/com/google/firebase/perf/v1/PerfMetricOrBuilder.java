package com.google.firebase.perf.v1;

public interface PerfMetricOrBuilder extends k15 {
    ApplicationInfo getApplicationInfo();

    @Override // defpackage.k15
    /* synthetic */ j15 getDefaultInstanceForType();

    GaugeMetric getGaugeMetric();

    NetworkRequestMetric getNetworkRequestMetric();

    TraceMetric getTraceMetric();

    TransportInfo getTransportInfo();

    boolean hasApplicationInfo();

    boolean hasGaugeMetric();

    boolean hasNetworkRequestMetric();

    boolean hasTraceMetric();

    boolean hasTransportInfo();

    @Override // defpackage.k15
    /* synthetic */ boolean isInitialized();
}
