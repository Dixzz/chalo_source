package com.google.firebase.perf.metrics;

import com.google.firebase.perf.v1.PerfSession;
import com.google.firebase.perf.v1.TraceMetric;
import java.util.Arrays;
import java.util.List;

public class TraceMetricBuilder {
    private final Trace mTrace;

    public TraceMetricBuilder(Trace trace) {
        this.mTrace = trace;
    }

    public TraceMetric build() {
        TraceMetric.Builder durationUs = TraceMetric.newBuilder().setName(this.mTrace.getName()).setClientStartTimeUs(this.mTrace.getStartTime().getMicros()).setDurationUs(this.mTrace.getStartTime().getDurationMicros(this.mTrace.getEndTime()));
        for (Counter counter : this.mTrace.getCounters().values()) {
            durationUs.putCounters(counter.getName(), counter.getCount());
        }
        List<Trace> subtraces = this.mTrace.getSubtraces();
        if (!subtraces.isEmpty()) {
            for (Trace trace : subtraces) {
                durationUs.addSubtraces(new TraceMetricBuilder(trace).build());
            }
        }
        durationUs.putAllCustomAttributes(this.mTrace.getAttributes());
        PerfSession[] buildAndSort = com.google.firebase.perf.internal.PerfSession.buildAndSort(this.mTrace.getSessions());
        if (buildAndSort != null) {
            durationUs.addAllPerfSessions(Arrays.asList(buildAndSort));
        }
        return (TraceMetric) durationUs.build();
    }
}
