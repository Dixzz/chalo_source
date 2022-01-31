package com.google.firebase.perf.v1;

import com.google.firebase.perf.v1.NetworkRequestMetric;
import java.util.List;
import java.util.Map;

public interface NetworkRequestMetricOrBuilder extends k15 {
    boolean containsCustomAttributes(String str);

    long getClientStartTimeUs();

    @Deprecated
    Map<String, String> getCustomAttributes();

    int getCustomAttributesCount();

    Map<String, String> getCustomAttributesMap();

    String getCustomAttributesOrDefault(String str, String str2);

    String getCustomAttributesOrThrow(String str);

    @Override // defpackage.k15
    /* synthetic */ j15 getDefaultInstanceForType();

    NetworkRequestMetric.HttpMethod getHttpMethod();

    int getHttpResponseCode();

    NetworkRequestMetric.NetworkClientErrorReason getNetworkClientErrorReason();

    PerfSession getPerfSessions(int i);

    int getPerfSessionsCount();

    List<PerfSession> getPerfSessionsList();

    long getRequestPayloadBytes();

    String getResponseContentType();

    a05 getResponseContentTypeBytes();

    long getResponsePayloadBytes();

    long getTimeToRequestCompletedUs();

    long getTimeToResponseCompletedUs();

    long getTimeToResponseInitiatedUs();

    String getUrl();

    a05 getUrlBytes();

    boolean hasClientStartTimeUs();

    boolean hasHttpMethod();

    boolean hasHttpResponseCode();

    boolean hasNetworkClientErrorReason();

    boolean hasRequestPayloadBytes();

    boolean hasResponseContentType();

    boolean hasResponsePayloadBytes();

    boolean hasTimeToRequestCompletedUs();

    boolean hasTimeToResponseCompletedUs();

    boolean hasTimeToResponseInitiatedUs();

    boolean hasUrl();

    @Override // defpackage.k15
    /* synthetic */ boolean isInitialized();
}
