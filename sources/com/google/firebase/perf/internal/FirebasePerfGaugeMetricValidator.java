package com.google.firebase.perf.internal;

import com.google.firebase.perf.v1.GaugeMetric;

public final class FirebasePerfGaugeMetricValidator extends PerfMetricValidator {
    private final GaugeMetric gaugeMetric;

    public FirebasePerfGaugeMetricValidator(GaugeMetric gaugeMetric2) {
        this.gaugeMetric = gaugeMetric2;
    }

    @Override // com.google.firebase.perf.internal.PerfMetricValidator
    public boolean isValidPerfMetric() {
        return this.gaugeMetric.hasSessionId() && (this.gaugeMetric.getCpuMetricReadingsCount() > 0 || this.gaugeMetric.getAndroidMemoryReadingsCount() > 0 || (this.gaugeMetric.hasGaugeMetadata() && this.gaugeMetric.getGaugeMetadata().hasMaxAppJavaHeapMemoryKb()));
    }
}
