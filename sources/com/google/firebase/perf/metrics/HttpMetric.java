package com.google.firebase.perf.metrics;

import com.google.firebase.perf.FirebasePerformanceAttributable;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.impl.NetworkRequestMetricBuilder;
import com.google.firebase.perf.internal.PerfMetricValidator;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.Timer;
import j$.util.concurrent.ConcurrentHashMap;
import java.net.URL;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class HttpMetric implements FirebasePerformanceAttributable {
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private boolean isDisabled;
    private boolean isStopped;
    private final Map<String, String> mAttributes;
    private NetworkRequestMetricBuilder mMetricBuilder;
    private Timer mTimer;

    public HttpMetric(String str, String str2, TransportManager transportManager, Timer timer) {
        this.isStopped = false;
        this.isDisabled = false;
        this.mAttributes = new ConcurrentHashMap();
        this.mTimer = timer;
        NetworkRequestMetricBuilder httpMethod = NetworkRequestMetricBuilder.builder(transportManager).setUrl(str).setHttpMethod(str2);
        this.mMetricBuilder = httpMethod;
        httpMethod.setManualNetworkRequestMetric();
        if (!ConfigResolver.getInstance().isPerformanceMonitoringEnabled()) {
            logger.info(String.format(Locale.ENGLISH, "HttpMetric feature is disabled. URL %s", str), new Object[0]);
            this.isDisabled = true;
        }
    }

    private void checkAttribute(String str, String str2) {
        if (this.isStopped) {
            throw new IllegalArgumentException("HttpMetric has been logged already so unable to modify attributes");
        } else if (str == null || str2 == null) {
            throw new IllegalArgumentException("Attribute must not have null key or value.");
        } else if (this.mAttributes.containsKey(str) || this.mAttributes.size() < 5) {
            String validateAttribute = PerfMetricValidator.validateAttribute(new AbstractMap.SimpleEntry(str, str2));
            if (validateAttribute != null) {
                throw new IllegalArgumentException(validateAttribute);
            }
        } else {
            throw new IllegalArgumentException(String.format(Locale.ENGLISH, "Exceeds max limit of number of attributes - %d", 5));
        }
    }

    @Override // com.google.firebase.perf.FirebasePerformanceAttributable
    public String getAttribute(String str) {
        return this.mAttributes.get(str);
    }

    @Override // com.google.firebase.perf.FirebasePerformanceAttributable
    public Map<String, String> getAttributes() {
        return new HashMap(this.mAttributes);
    }

    public void markRequestComplete() {
        this.mMetricBuilder.setTimeToRequestCompletedMicros(this.mTimer.getDurationMicros());
    }

    public void markResponseStart() {
        this.mMetricBuilder.setTimeToResponseInitiatedMicros(this.mTimer.getDurationMicros());
    }

    @Override // com.google.firebase.perf.FirebasePerformanceAttributable
    public void putAttribute(String str, String str2) {
        boolean z = true;
        try {
            str = str.trim();
            str2 = str2.trim();
            checkAttribute(str, str2);
            logger.debug(String.format(Locale.ENGLISH, "Setting attribute '%s' to %s on network request '%s'", str, str2, this.mMetricBuilder.getUrl()), new Object[0]);
        } catch (Exception e) {
            logger.error(String.format(Locale.ENGLISH, "Cannot set attribute '%s' with value '%s' (%s)", str, str2, e.getMessage()), new Object[0]);
            z = false;
        }
        if (z) {
            this.mAttributes.put(str, str2);
        }
    }

    @Override // com.google.firebase.perf.FirebasePerformanceAttributable
    public void removeAttribute(String str) {
        if (this.isStopped) {
            logger.error("Can't remove a attribute from a HttpMetric that's stopped.", new Object[0]);
        } else {
            this.mAttributes.remove(str);
        }
    }

    public void setHttpResponseCode(int i) {
        this.mMetricBuilder.setHttpResponseCode(i);
    }

    public void setRequestPayloadSize(long j) {
        this.mMetricBuilder.setRequestPayloadBytes(j);
    }

    public void setResponseContentType(String str) {
        this.mMetricBuilder.setResponseContentType(str);
    }

    public void setResponsePayloadSize(long j) {
        this.mMetricBuilder.setResponsePayloadBytes(j);
    }

    public void start() {
        this.mTimer.reset();
        this.mMetricBuilder.setRequestStartTimeMicros(this.mTimer.getMicros());
    }

    public void stop() {
        if (!this.isDisabled) {
            this.mMetricBuilder.setTimeToResponseCompletedMicros(this.mTimer.getDurationMicros()).setCustomAttributes(this.mAttributes).build();
            this.isStopped = true;
        }
    }

    public HttpMetric(URL url, String str, TransportManager transportManager, Timer timer) {
        this(url.toString(), str, transportManager, timer);
    }
}
