package com.google.firebase.perf.network;

import com.google.firebase.perf.impl.NetworkRequestMetricBuilder;
import com.google.firebase.perf.util.Timer;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;

public class InstrumentApacheHttpResponseHandler<T> implements ResponseHandler<T> {
    private final NetworkRequestMetricBuilder mBuilder;
    private final ResponseHandler<? extends T> mResponseHandlerDelegate;
    private final Timer mTimer;

    public InstrumentApacheHttpResponseHandler(ResponseHandler<? extends T> responseHandler, Timer timer, NetworkRequestMetricBuilder networkRequestMetricBuilder) {
        this.mResponseHandlerDelegate = responseHandler;
        this.mTimer = timer;
        this.mBuilder = networkRequestMetricBuilder;
    }

    public T handleResponse(HttpResponse httpResponse) throws IOException {
        this.mBuilder.setTimeToResponseCompletedMicros(this.mTimer.getDurationMicros());
        this.mBuilder.setHttpResponseCode(httpResponse.getStatusLine().getStatusCode());
        Long apacheHttpMessageContentLength = NetworkRequestMetricBuilderUtil.getApacheHttpMessageContentLength(httpResponse);
        if (apacheHttpMessageContentLength != null) {
            this.mBuilder.setResponsePayloadBytes(apacheHttpMessageContentLength.longValue());
        }
        String apacheHttpResponseContentType = NetworkRequestMetricBuilderUtil.getApacheHttpResponseContentType(httpResponse);
        if (apacheHttpResponseContentType != null) {
            this.mBuilder.setResponseContentType(apacheHttpResponseContentType);
        }
        this.mBuilder.build();
        return (T) this.mResponseHandlerDelegate.handleResponse(httpResponse);
    }
}
