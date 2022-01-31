package com.google.firebase.perf.impl;

import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.perf.internal.AppStateMonitor;
import com.google.firebase.perf.internal.AppStateUpdateHandler;
import com.google.firebase.perf.internal.GaugeManager;
import com.google.firebase.perf.internal.PerfSession;
import com.google.firebase.perf.internal.SessionAwareObject;
import com.google.firebase.perf.internal.SessionManager;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.network.NetworkRequestMetricBuilderUtil;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.Constants;
import com.google.firebase.perf.util.Utils;
import com.google.firebase.perf.v1.NetworkRequestMetric;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class NetworkRequestMetricBuilder extends AppStateUpdateHandler implements SessionAwareObject {
    private static final char HIGHEST_ASCII_CHAR = 127;
    private static final char HIGHEST_CONTROL_CHAR = 31;
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private final GaugeManager gaugeManager;
    private boolean isManualNetworkRequestMetric;
    private boolean isReportSent;
    private final NetworkRequestMetric.Builder networkRequestMetricBuilder;
    private final List<PerfSession> sessions;
    private final TransportManager transportManager;
    private String userAgent;
    private final WeakReference<SessionAwareObject> weakReference;

    private NetworkRequestMetricBuilder(TransportManager transportManager2) {
        this(transportManager2, AppStateMonitor.getInstance(), GaugeManager.getInstance());
    }

    public static NetworkRequestMetricBuilder builder(TransportManager transportManager2) {
        return new NetworkRequestMetricBuilder(transportManager2);
    }

    private boolean hasStarted() {
        return this.networkRequestMetricBuilder.hasClientStartTimeUs();
    }

    private boolean isStopped() {
        return this.networkRequestMetricBuilder.hasTimeToResponseCompletedUs();
    }

    private static boolean isValidContentType(String str) {
        if (str.length() > 128) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt <= 31 || charAt > 127) {
                return false;
            }
        }
        return true;
    }

    public NetworkRequestMetric build() {
        SessionManager.getInstance().unregisterForSessionUpdates(this.weakReference);
        unregisterForAppState();
        com.google.firebase.perf.v1.PerfSession[] buildAndSort = PerfSession.buildAndSort(getSessions());
        if (buildAndSort != null) {
            this.networkRequestMetricBuilder.addAllPerfSessions(Arrays.asList(buildAndSort));
        }
        NetworkRequestMetric networkRequestMetric = (NetworkRequestMetric) this.networkRequestMetricBuilder.build();
        if (!NetworkRequestMetricBuilderUtil.isAllowedUserAgent(this.userAgent)) {
            logger.debug("Dropping network request from a 'User-Agent' that is not allowed", new Object[0]);
            return networkRequestMetric;
        } else if (!this.isReportSent) {
            this.transportManager.log(networkRequestMetric, getAppState());
            this.isReportSent = true;
            return networkRequestMetric;
        } else {
            if (this.isManualNetworkRequestMetric) {
                logger.info("This metric has already been queued for transmission.  Please create a new HttpMetric for each request/response", new Object[0]);
            }
            return networkRequestMetric;
        }
    }

    public void clearBuilderFields() {
        this.networkRequestMetricBuilder.clear();
    }

    public List<PerfSession> getSessions() {
        List<PerfSession> unmodifiableList;
        synchronized (this.sessions) {
            ArrayList arrayList = new ArrayList();
            for (PerfSession perfSession : this.sessions) {
                if (perfSession != null) {
                    arrayList.add(perfSession);
                }
            }
            unmodifiableList = Collections.unmodifiableList(arrayList);
        }
        return unmodifiableList;
    }

    public long getTimeToResponseInitiatedMicros() {
        return this.networkRequestMetricBuilder.getTimeToResponseInitiatedUs();
    }

    public String getUrl() {
        return this.networkRequestMetricBuilder.getUrl();
    }

    public boolean hasHttpResponseCode() {
        return this.networkRequestMetricBuilder.hasHttpResponseCode();
    }

    public boolean isReportSent() {
        return this.isReportSent;
    }

    public NetworkRequestMetricBuilder setCustomAttributes(Map<String, String> map) {
        this.networkRequestMetricBuilder.clearCustomAttributes().putAllCustomAttributes(map);
        return this;
    }

    public NetworkRequestMetricBuilder setHttpMethod(String str) {
        if (str != null) {
            NetworkRequestMetric.HttpMethod httpMethod = NetworkRequestMetric.HttpMethod.HTTP_METHOD_UNKNOWN;
            String upperCase = str.toUpperCase();
            upperCase.hashCode();
            char c = 65535;
            switch (upperCase.hashCode()) {
                case -531492226:
                    if (upperCase.equals(FirebasePerformance.HttpMethod.OPTIONS)) {
                        c = 0;
                        break;
                    }
                    break;
                case 70454:
                    if (upperCase.equals(FirebasePerformance.HttpMethod.GET)) {
                        c = 1;
                        break;
                    }
                    break;
                case 79599:
                    if (upperCase.equals(FirebasePerformance.HttpMethod.PUT)) {
                        c = 2;
                        break;
                    }
                    break;
                case 2213344:
                    if (upperCase.equals("HEAD")) {
                        c = 3;
                        break;
                    }
                    break;
                case 2461856:
                    if (upperCase.equals(FirebasePerformance.HttpMethod.POST)) {
                        c = 4;
                        break;
                    }
                    break;
                case 75900968:
                    if (upperCase.equals(FirebasePerformance.HttpMethod.PATCH)) {
                        c = 5;
                        break;
                    }
                    break;
                case 80083237:
                    if (upperCase.equals(FirebasePerformance.HttpMethod.TRACE)) {
                        c = 6;
                        break;
                    }
                    break;
                case 1669334218:
                    if (upperCase.equals(FirebasePerformance.HttpMethod.CONNECT)) {
                        c = 7;
                        break;
                    }
                    break;
                case 2012838315:
                    if (upperCase.equals(FirebasePerformance.HttpMethod.DELETE)) {
                        c = '\b';
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    httpMethod = NetworkRequestMetric.HttpMethod.OPTIONS;
                    break;
                case 1:
                    httpMethod = NetworkRequestMetric.HttpMethod.GET;
                    break;
                case 2:
                    httpMethod = NetworkRequestMetric.HttpMethod.PUT;
                    break;
                case 3:
                    httpMethod = NetworkRequestMetric.HttpMethod.HEAD;
                    break;
                case 4:
                    httpMethod = NetworkRequestMetric.HttpMethod.POST;
                    break;
                case 5:
                    httpMethod = NetworkRequestMetric.HttpMethod.PATCH;
                    break;
                case 6:
                    httpMethod = NetworkRequestMetric.HttpMethod.TRACE;
                    break;
                case 7:
                    httpMethod = NetworkRequestMetric.HttpMethod.CONNECT;
                    break;
                case '\b':
                    httpMethod = NetworkRequestMetric.HttpMethod.DELETE;
                    break;
            }
            this.networkRequestMetricBuilder.setHttpMethod(httpMethod);
        }
        return this;
    }

    public NetworkRequestMetricBuilder setHttpResponseCode(int i) {
        this.networkRequestMetricBuilder.setHttpResponseCode(i);
        return this;
    }

    public void setManualNetworkRequestMetric() {
        this.isManualNetworkRequestMetric = true;
    }

    public NetworkRequestMetricBuilder setNetworkClientErrorReason() {
        this.networkRequestMetricBuilder.setNetworkClientErrorReason(NetworkRequestMetric.NetworkClientErrorReason.GENERIC_CLIENT_ERROR);
        return this;
    }

    public void setReportSent() {
        this.isReportSent = true;
    }

    public NetworkRequestMetricBuilder setRequestPayloadBytes(long j) {
        this.networkRequestMetricBuilder.setRequestPayloadBytes(j);
        return this;
    }

    public NetworkRequestMetricBuilder setRequestStartTimeMicros(long j) {
        PerfSession perfSession = SessionManager.getInstance().perfSession();
        SessionManager.getInstance().registerForSessionUpdates(this.weakReference);
        this.networkRequestMetricBuilder.setClientStartTimeUs(j);
        updateSession(perfSession);
        if (perfSession.isGaugeAndEventCollectionEnabled()) {
            this.gaugeManager.collectGaugeMetricOnce(perfSession.getTimer());
        }
        return this;
    }

    public NetworkRequestMetricBuilder setResponseContentType(String str) {
        if (str == null) {
            this.networkRequestMetricBuilder.clearResponseContentType();
            return this;
        }
        if (isValidContentType(str)) {
            this.networkRequestMetricBuilder.setResponseContentType(str);
        } else {
            logger.info(hj1.S("The content type of the response is not a valid content-type:", str), new Object[0]);
        }
        return this;
    }

    public NetworkRequestMetricBuilder setResponsePayloadBytes(long j) {
        this.networkRequestMetricBuilder.setResponsePayloadBytes(j);
        return this;
    }

    public NetworkRequestMetricBuilder setTimeToRequestCompletedMicros(long j) {
        this.networkRequestMetricBuilder.setTimeToRequestCompletedUs(j);
        return this;
    }

    public NetworkRequestMetricBuilder setTimeToResponseCompletedMicros(long j) {
        this.networkRequestMetricBuilder.setTimeToResponseCompletedUs(j);
        if (SessionManager.getInstance().perfSession().isGaugeAndEventCollectionEnabled()) {
            this.gaugeManager.collectGaugeMetricOnce(SessionManager.getInstance().perfSession().getTimer());
        }
        return this;
    }

    public NetworkRequestMetricBuilder setTimeToResponseInitiatedMicros(long j) {
        this.networkRequestMetricBuilder.setTimeToResponseInitiatedUs(j);
        return this;
    }

    public NetworkRequestMetricBuilder setUrl(String str) {
        if (str != null) {
            this.networkRequestMetricBuilder.setUrl(Utils.truncateURL(Utils.stripSensitiveInfo(str), Constants.MAX_URL_LENGTH));
        }
        return this;
    }

    public NetworkRequestMetricBuilder setUserAgent(String str) {
        this.userAgent = str;
        return this;
    }

    @Override // com.google.firebase.perf.internal.SessionAwareObject
    public void updateSession(PerfSession perfSession) {
        if (perfSession == null) {
            logger.info("Unable to add new SessionId to the Network Trace. Continuing without it.", new Object[0]);
        } else if (hasStarted() && !isStopped()) {
            this.sessions.add(perfSession);
        }
    }

    public NetworkRequestMetricBuilder(TransportManager transportManager2, AppStateMonitor appStateMonitor, GaugeManager gaugeManager2) {
        super(appStateMonitor);
        this.networkRequestMetricBuilder = NetworkRequestMetric.newBuilder();
        this.weakReference = new WeakReference<>(this);
        this.transportManager = transportManager2;
        this.gaugeManager = gaugeManager2;
        this.sessions = Collections.synchronizedList(new ArrayList());
        registerForAppState();
    }
}
