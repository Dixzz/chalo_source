package com.google.firebase.perf.internal;

import android.content.Context;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.util.URLWhitelist;
import com.google.firebase.perf.v1.NetworkRequestMetric;
import java.net.URI;

public final class FirebasePerfNetworkValidator extends PerfMetricValidator {
    private static final int EMPTY_PORT = -1;
    private static final String HTTPS = "https";
    private static final String HTTP_SCHEMA = "http";
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private final Context context;
    private final NetworkRequestMetric mNetworkMetric;

    public FirebasePerfNetworkValidator(NetworkRequestMetric networkRequestMetric, Context context2) {
        this.context = context2;
        this.mNetworkMetric = networkRequestMetric;
    }

    private URI getResultUrl(String str) {
        if (str == null) {
            return null;
        }
        try {
            return URI.create(str);
        } catch (IllegalArgumentException | IllegalStateException e) {
            logger.warn(String.format("getResultUrl throws exception %s", e.getMessage()), new Object[0]);
            return null;
        }
    }

    private boolean isBlank(String str) {
        if (str == null) {
            return true;
        }
        return str.trim().isEmpty();
    }

    private boolean isEmptyUrl(String str) {
        return isBlank(str);
    }

    private boolean isValidHost(String str) {
        return str != null && !isBlank(str) && str.length() <= 255;
    }

    private boolean isValidHttpResponseCode(int i) {
        return i > 0;
    }

    private boolean isValidPayload(long j) {
        return j >= 0;
    }

    private boolean isValidPort(int i) {
        return i == -1 || i > 0;
    }

    private boolean isValidScheme(String str) {
        if (str == null) {
            return false;
        }
        return HTTP_SCHEMA.equalsIgnoreCase(str) || HTTPS.equalsIgnoreCase(str);
    }

    private boolean isValidTime(long j) {
        return j >= 0;
    }

    private boolean isValidUserInfo(String str) {
        return str == null;
    }

    private boolean isWhitelisted(URI uri, Context context2) {
        if (uri == null) {
            return false;
        }
        return URLWhitelist.isURLWhitelisted(uri, context2);
    }

    public boolean isValidHttpMethod(NetworkRequestMetric.HttpMethod httpMethod) {
        return (httpMethod == null || httpMethod == NetworkRequestMetric.HttpMethod.HTTP_METHOD_UNKNOWN) ? false : true;
    }

    @Override // com.google.firebase.perf.internal.PerfMetricValidator
    public boolean isValidPerfMetric() {
        if (isEmptyUrl(this.mNetworkMetric.getUrl())) {
            AndroidLogger androidLogger = logger;
            StringBuilder i0 = hj1.i0("URL is missing:");
            i0.append(this.mNetworkMetric.getUrl());
            androidLogger.info(i0.toString(), new Object[0]);
            return false;
        }
        URI resultUrl = getResultUrl(this.mNetworkMetric.getUrl());
        if (resultUrl == null) {
            logger.info("URL cannot be parsed", new Object[0]);
            return false;
        } else if (!isWhitelisted(resultUrl, this.context)) {
            AndroidLogger androidLogger2 = logger;
            androidLogger2.info("URL fails whitelist rule: " + resultUrl, new Object[0]);
            return false;
        } else if (!isValidHost(resultUrl.getHost())) {
            logger.info("URL host is null or invalid", new Object[0]);
            return false;
        } else if (!isValidScheme(resultUrl.getScheme())) {
            logger.info("URL scheme is null or invalid", new Object[0]);
            return false;
        } else if (!isValidUserInfo(resultUrl.getUserInfo())) {
            logger.info("URL user info is null", new Object[0]);
            return false;
        } else if (!isValidPort(resultUrl.getPort())) {
            logger.info("URL port is less than or equal to 0", new Object[0]);
            return false;
        } else {
            if (!isValidHttpMethod(this.mNetworkMetric.hasHttpMethod() ? this.mNetworkMetric.getHttpMethod() : null)) {
                AndroidLogger androidLogger3 = logger;
                StringBuilder i02 = hj1.i0("HTTP Method is null or invalid: ");
                i02.append(this.mNetworkMetric.getHttpMethod());
                androidLogger3.info(i02.toString(), new Object[0]);
                return false;
            } else if (this.mNetworkMetric.hasHttpResponseCode() && !isValidHttpResponseCode(this.mNetworkMetric.getHttpResponseCode())) {
                AndroidLogger androidLogger4 = logger;
                StringBuilder i03 = hj1.i0("HTTP ResponseCode is a negative value:");
                i03.append(this.mNetworkMetric.getHttpResponseCode());
                androidLogger4.info(i03.toString(), new Object[0]);
                return false;
            } else if (this.mNetworkMetric.hasRequestPayloadBytes() && !isValidPayload(this.mNetworkMetric.getRequestPayloadBytes())) {
                AndroidLogger androidLogger5 = logger;
                StringBuilder i04 = hj1.i0("Request Payload is a negative value:");
                i04.append(this.mNetworkMetric.getRequestPayloadBytes());
                androidLogger5.info(i04.toString(), new Object[0]);
                return false;
            } else if (this.mNetworkMetric.hasResponsePayloadBytes() && !isValidPayload(this.mNetworkMetric.getResponsePayloadBytes())) {
                AndroidLogger androidLogger6 = logger;
                StringBuilder i05 = hj1.i0("Response Payload is a negative value:");
                i05.append(this.mNetworkMetric.getResponsePayloadBytes());
                androidLogger6.info(i05.toString(), new Object[0]);
                return false;
            } else if (!this.mNetworkMetric.hasClientStartTimeUs() || this.mNetworkMetric.getClientStartTimeUs() <= 0) {
                AndroidLogger androidLogger7 = logger;
                StringBuilder i06 = hj1.i0("Start time of the request is null, or zero, or a negative value:");
                i06.append(this.mNetworkMetric.getClientStartTimeUs());
                androidLogger7.info(i06.toString(), new Object[0]);
                return false;
            } else if (this.mNetworkMetric.hasTimeToRequestCompletedUs() && !isValidTime(this.mNetworkMetric.getTimeToRequestCompletedUs())) {
                AndroidLogger androidLogger8 = logger;
                StringBuilder i07 = hj1.i0("Time to complete the request is a negative value:");
                i07.append(this.mNetworkMetric.getTimeToRequestCompletedUs());
                androidLogger8.info(i07.toString(), new Object[0]);
                return false;
            } else if (this.mNetworkMetric.hasTimeToResponseInitiatedUs() && !isValidTime(this.mNetworkMetric.getTimeToResponseInitiatedUs())) {
                AndroidLogger androidLogger9 = logger;
                StringBuilder i08 = hj1.i0("Time from the start of the request to the start of the response is null or a negative value:");
                i08.append(this.mNetworkMetric.getTimeToResponseInitiatedUs());
                androidLogger9.info(i08.toString(), new Object[0]);
                return false;
            } else if (!this.mNetworkMetric.hasTimeToResponseCompletedUs() || this.mNetworkMetric.getTimeToResponseCompletedUs() <= 0) {
                AndroidLogger androidLogger10 = logger;
                StringBuilder i09 = hj1.i0("Time from the start of the request to the end of the response is null, negative or zero:");
                i09.append(this.mNetworkMetric.getTimeToResponseCompletedUs());
                androidLogger10.info(i09.toString(), new Object[0]);
                return false;
            } else if (this.mNetworkMetric.hasHttpResponseCode()) {
                return true;
            } else {
                logger.info("Did not receive a HTTP Response Code", new Object[0]);
                return false;
            }
        }
    }
}
