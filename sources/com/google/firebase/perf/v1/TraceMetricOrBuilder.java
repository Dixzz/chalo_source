package com.google.firebase.perf.v1;

import java.util.List;
import java.util.Map;

public interface TraceMetricOrBuilder extends k15 {
    boolean containsCounters(String str);

    boolean containsCustomAttributes(String str);

    long getClientStartTimeUs();

    @Deprecated
    Map<String, Long> getCounters();

    int getCountersCount();

    Map<String, Long> getCountersMap();

    long getCountersOrDefault(String str, long j);

    long getCountersOrThrow(String str);

    @Deprecated
    Map<String, String> getCustomAttributes();

    int getCustomAttributesCount();

    Map<String, String> getCustomAttributesMap();

    String getCustomAttributesOrDefault(String str, String str2);

    String getCustomAttributesOrThrow(String str);

    @Override // defpackage.k15
    /* synthetic */ j15 getDefaultInstanceForType();

    long getDurationUs();

    boolean getIsAuto();

    String getName();

    a05 getNameBytes();

    PerfSession getPerfSessions(int i);

    int getPerfSessionsCount();

    List<PerfSession> getPerfSessionsList();

    TraceMetric getSubtraces(int i);

    int getSubtracesCount();

    List<TraceMetric> getSubtracesList();

    boolean hasClientStartTimeUs();

    boolean hasDurationUs();

    boolean hasIsAuto();

    boolean hasName();

    @Override // defpackage.k15
    /* synthetic */ boolean isInitialized();
}
