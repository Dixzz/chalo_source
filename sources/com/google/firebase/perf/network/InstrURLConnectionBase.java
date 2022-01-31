package com.google.firebase.perf.network;

import android.os.Build;
import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.perf.impl.NetworkRequestMetricBuilder;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.util.Timer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.security.Permission;
import java.util.List;
import java.util.Map;

public class InstrURLConnectionBase {
    private static final String USER_AGENT_PROPERTY = "User-Agent";
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private final NetworkRequestMetricBuilder mBuilder;
    private final HttpURLConnection mHttpUrlConnection;
    private long mTimeRequested = -1;
    private long mTimeToResponseInitiated = -1;
    private final Timer mTimer;

    public InstrURLConnectionBase(HttpURLConnection httpURLConnection, Timer timer, NetworkRequestMetricBuilder networkRequestMetricBuilder) {
        this.mHttpUrlConnection = httpURLConnection;
        this.mBuilder = networkRequestMetricBuilder;
        this.mTimer = timer;
        networkRequestMetricBuilder.setUrl(httpURLConnection.getURL().toString());
    }

    private void updateRequestInfo() {
        if (this.mTimeRequested == -1) {
            this.mTimer.reset();
            long micros = this.mTimer.getMicros();
            this.mTimeRequested = micros;
            this.mBuilder.setRequestStartTimeMicros(micros);
        }
        String requestMethod = getRequestMethod();
        if (requestMethod != null) {
            this.mBuilder.setHttpMethod(requestMethod);
        } else if (getDoOutput()) {
            this.mBuilder.setHttpMethod(FirebasePerformance.HttpMethod.POST);
        } else {
            this.mBuilder.setHttpMethod(FirebasePerformance.HttpMethod.GET);
        }
    }

    public void addRequestProperty(String str, String str2) {
        this.mHttpUrlConnection.addRequestProperty(str, str2);
    }

    public void connect() throws IOException {
        if (this.mTimeRequested == -1) {
            this.mTimer.reset();
            long micros = this.mTimer.getMicros();
            this.mTimeRequested = micros;
            this.mBuilder.setRequestStartTimeMicros(micros);
        }
        try {
            this.mHttpUrlConnection.connect();
        } catch (IOException e) {
            this.mBuilder.setTimeToResponseCompletedMicros(this.mTimer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.mBuilder);
            throw e;
        }
    }

    public void disconnect() {
        this.mBuilder.setTimeToResponseCompletedMicros(this.mTimer.getDurationMicros());
        this.mBuilder.build();
        this.mHttpUrlConnection.disconnect();
    }

    public boolean equals(Object obj) {
        return this.mHttpUrlConnection.equals(obj);
    }

    public boolean getAllowUserInteraction() {
        return this.mHttpUrlConnection.getAllowUserInteraction();
    }

    public int getConnectTimeout() {
        return this.mHttpUrlConnection.getConnectTimeout();
    }

    public Object getContent() throws IOException {
        updateRequestInfo();
        this.mBuilder.setHttpResponseCode(this.mHttpUrlConnection.getResponseCode());
        try {
            Object content = this.mHttpUrlConnection.getContent();
            if (content instanceof InputStream) {
                this.mBuilder.setResponseContentType(this.mHttpUrlConnection.getContentType());
                return new InstrHttpInputStream((InputStream) content, this.mBuilder, this.mTimer);
            }
            this.mBuilder.setResponseContentType(this.mHttpUrlConnection.getContentType());
            this.mBuilder.setResponsePayloadBytes((long) this.mHttpUrlConnection.getContentLength());
            this.mBuilder.setTimeToResponseCompletedMicros(this.mTimer.getDurationMicros());
            this.mBuilder.build();
            return content;
        } catch (IOException e) {
            this.mBuilder.setTimeToResponseCompletedMicros(this.mTimer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.mBuilder);
            throw e;
        }
    }

    public String getContentEncoding() {
        updateRequestInfo();
        return this.mHttpUrlConnection.getContentEncoding();
    }

    public int getContentLength() {
        updateRequestInfo();
        return this.mHttpUrlConnection.getContentLength();
    }

    public long getContentLengthLong() {
        updateRequestInfo();
        if (Build.VERSION.SDK_INT >= 24) {
            return this.mHttpUrlConnection.getContentLengthLong();
        }
        return 0;
    }

    public String getContentType() {
        updateRequestInfo();
        return this.mHttpUrlConnection.getContentType();
    }

    public long getDate() {
        updateRequestInfo();
        return this.mHttpUrlConnection.getDate();
    }

    public boolean getDefaultUseCaches() {
        return this.mHttpUrlConnection.getDefaultUseCaches();
    }

    public boolean getDoInput() {
        return this.mHttpUrlConnection.getDoInput();
    }

    public boolean getDoOutput() {
        return this.mHttpUrlConnection.getDoOutput();
    }

    public InputStream getErrorStream() {
        updateRequestInfo();
        try {
            this.mBuilder.setHttpResponseCode(this.mHttpUrlConnection.getResponseCode());
        } catch (IOException unused) {
            logger.debug("IOException thrown trying to obtain the response code", new Object[0]);
        }
        InputStream errorStream = this.mHttpUrlConnection.getErrorStream();
        return errorStream != null ? new InstrHttpInputStream(errorStream, this.mBuilder, this.mTimer) : errorStream;
    }

    public long getExpiration() {
        updateRequestInfo();
        return this.mHttpUrlConnection.getExpiration();
    }

    public String getHeaderField(int i) {
        updateRequestInfo();
        return this.mHttpUrlConnection.getHeaderField(i);
    }

    public long getHeaderFieldDate(String str, long j) {
        updateRequestInfo();
        return this.mHttpUrlConnection.getHeaderFieldDate(str, j);
    }

    public int getHeaderFieldInt(String str, int i) {
        updateRequestInfo();
        return this.mHttpUrlConnection.getHeaderFieldInt(str, i);
    }

    public String getHeaderFieldKey(int i) {
        updateRequestInfo();
        return this.mHttpUrlConnection.getHeaderFieldKey(i);
    }

    public long getHeaderFieldLong(String str, long j) {
        updateRequestInfo();
        if (Build.VERSION.SDK_INT >= 24) {
            return this.mHttpUrlConnection.getHeaderFieldLong(str, j);
        }
        return 0;
    }

    public Map<String, List<String>> getHeaderFields() {
        updateRequestInfo();
        return this.mHttpUrlConnection.getHeaderFields();
    }

    public long getIfModifiedSince() {
        return this.mHttpUrlConnection.getIfModifiedSince();
    }

    public InputStream getInputStream() throws IOException {
        updateRequestInfo();
        this.mBuilder.setHttpResponseCode(this.mHttpUrlConnection.getResponseCode());
        this.mBuilder.setResponseContentType(this.mHttpUrlConnection.getContentType());
        try {
            return new InstrHttpInputStream(this.mHttpUrlConnection.getInputStream(), this.mBuilder, this.mTimer);
        } catch (IOException e) {
            this.mBuilder.setTimeToResponseCompletedMicros(this.mTimer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.mBuilder);
            throw e;
        }
    }

    public boolean getInstanceFollowRedirects() {
        return this.mHttpUrlConnection.getInstanceFollowRedirects();
    }

    public long getLastModified() {
        updateRequestInfo();
        return this.mHttpUrlConnection.getLastModified();
    }

    public OutputStream getOutputStream() throws IOException {
        try {
            return new InstrHttpOutputStream(this.mHttpUrlConnection.getOutputStream(), this.mBuilder, this.mTimer);
        } catch (IOException e) {
            this.mBuilder.setTimeToResponseCompletedMicros(this.mTimer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.mBuilder);
            throw e;
        }
    }

    public Permission getPermission() throws IOException {
        try {
            return this.mHttpUrlConnection.getPermission();
        } catch (IOException e) {
            this.mBuilder.setTimeToResponseCompletedMicros(this.mTimer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.mBuilder);
            throw e;
        }
    }

    public int getReadTimeout() {
        return this.mHttpUrlConnection.getReadTimeout();
    }

    public String getRequestMethod() {
        return this.mHttpUrlConnection.getRequestMethod();
    }

    public Map<String, List<String>> getRequestProperties() {
        return this.mHttpUrlConnection.getRequestProperties();
    }

    public String getRequestProperty(String str) {
        return this.mHttpUrlConnection.getRequestProperty(str);
    }

    public int getResponseCode() throws IOException {
        updateRequestInfo();
        if (this.mTimeToResponseInitiated == -1) {
            long durationMicros = this.mTimer.getDurationMicros();
            this.mTimeToResponseInitiated = durationMicros;
            this.mBuilder.setTimeToResponseInitiatedMicros(durationMicros);
        }
        try {
            int responseCode = this.mHttpUrlConnection.getResponseCode();
            this.mBuilder.setHttpResponseCode(responseCode);
            return responseCode;
        } catch (IOException e) {
            this.mBuilder.setTimeToResponseCompletedMicros(this.mTimer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.mBuilder);
            throw e;
        }
    }

    public String getResponseMessage() throws IOException {
        updateRequestInfo();
        if (this.mTimeToResponseInitiated == -1) {
            long durationMicros = this.mTimer.getDurationMicros();
            this.mTimeToResponseInitiated = durationMicros;
            this.mBuilder.setTimeToResponseInitiatedMicros(durationMicros);
        }
        try {
            String responseMessage = this.mHttpUrlConnection.getResponseMessage();
            this.mBuilder.setHttpResponseCode(this.mHttpUrlConnection.getResponseCode());
            return responseMessage;
        } catch (IOException e) {
            this.mBuilder.setTimeToResponseCompletedMicros(this.mTimer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.mBuilder);
            throw e;
        }
    }

    public URL getURL() {
        return this.mHttpUrlConnection.getURL();
    }

    public boolean getUseCaches() {
        return this.mHttpUrlConnection.getUseCaches();
    }

    public int hashCode() {
        return this.mHttpUrlConnection.hashCode();
    }

    public void setAllowUserInteraction(boolean z) {
        this.mHttpUrlConnection.setAllowUserInteraction(z);
    }

    public void setChunkedStreamingMode(int i) {
        this.mHttpUrlConnection.setChunkedStreamingMode(i);
    }

    public void setConnectTimeout(int i) {
        this.mHttpUrlConnection.setConnectTimeout(i);
    }

    public void setDefaultUseCaches(boolean z) {
        this.mHttpUrlConnection.setDefaultUseCaches(z);
    }

    public void setDoInput(boolean z) {
        this.mHttpUrlConnection.setDoInput(z);
    }

    public void setDoOutput(boolean z) {
        this.mHttpUrlConnection.setDoOutput(z);
    }

    public void setFixedLengthStreamingMode(int i) {
        this.mHttpUrlConnection.setFixedLengthStreamingMode(i);
    }

    public void setIfModifiedSince(long j) {
        this.mHttpUrlConnection.setIfModifiedSince(j);
    }

    public void setInstanceFollowRedirects(boolean z) {
        this.mHttpUrlConnection.setInstanceFollowRedirects(z);
    }

    public void setReadTimeout(int i) {
        this.mHttpUrlConnection.setReadTimeout(i);
    }

    public void setRequestMethod(String str) throws ProtocolException {
        this.mHttpUrlConnection.setRequestMethod(str);
    }

    public void setRequestProperty(String str, String str2) {
        if ("User-Agent".equalsIgnoreCase(str)) {
            this.mBuilder.setUserAgent(str2);
        }
        this.mHttpUrlConnection.setRequestProperty(str, str2);
    }

    public void setUseCaches(boolean z) {
        this.mHttpUrlConnection.setUseCaches(z);
    }

    public String toString() {
        return this.mHttpUrlConnection.toString();
    }

    public boolean usingProxy() {
        return this.mHttpUrlConnection.usingProxy();
    }

    public void setFixedLengthStreamingMode(long j) {
        this.mHttpUrlConnection.setFixedLengthStreamingMode(j);
    }

    public String getHeaderField(String str) {
        updateRequestInfo();
        return this.mHttpUrlConnection.getHeaderField(str);
    }

    public Object getContent(Class[] clsArr) throws IOException {
        updateRequestInfo();
        this.mBuilder.setHttpResponseCode(this.mHttpUrlConnection.getResponseCode());
        try {
            Object content = this.mHttpUrlConnection.getContent(clsArr);
            if (content instanceof InputStream) {
                this.mBuilder.setResponseContentType(this.mHttpUrlConnection.getContentType());
                return new InstrHttpInputStream((InputStream) content, this.mBuilder, this.mTimer);
            }
            this.mBuilder.setResponseContentType(this.mHttpUrlConnection.getContentType());
            this.mBuilder.setResponsePayloadBytes((long) this.mHttpUrlConnection.getContentLength());
            this.mBuilder.setTimeToResponseCompletedMicros(this.mTimer.getDurationMicros());
            this.mBuilder.build();
            return content;
        } catch (IOException e) {
            this.mBuilder.setTimeToResponseCompletedMicros(this.mTimer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.mBuilder);
            throw e;
        }
    }
}
