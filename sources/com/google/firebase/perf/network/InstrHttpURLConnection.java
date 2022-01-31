package com.google.firebase.perf.network;

import com.google.firebase.perf.impl.NetworkRequestMetricBuilder;
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

public final class InstrHttpURLConnection extends HttpURLConnection {
    private final InstrURLConnectionBase mDelegate;

    public InstrHttpURLConnection(HttpURLConnection httpURLConnection, Timer timer, NetworkRequestMetricBuilder networkRequestMetricBuilder) {
        super(httpURLConnection.getURL());
        this.mDelegate = new InstrURLConnectionBase(httpURLConnection, timer, networkRequestMetricBuilder);
    }

    public void addRequestProperty(String str, String str2) {
        this.mDelegate.addRequestProperty(str, str2);
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        this.mDelegate.connect();
    }

    public void disconnect() {
        this.mDelegate.disconnect();
    }

    public boolean equals(Object obj) {
        return this.mDelegate.equals(obj);
    }

    public boolean getAllowUserInteraction() {
        return this.mDelegate.getAllowUserInteraction();
    }

    public int getConnectTimeout() {
        return this.mDelegate.getConnectTimeout();
    }

    @Override // java.net.URLConnection
    public Object getContent() throws IOException {
        return this.mDelegate.getContent();
    }

    public String getContentEncoding() {
        return this.mDelegate.getContentEncoding();
    }

    public int getContentLength() {
        return this.mDelegate.getContentLength();
    }

    public long getContentLengthLong() {
        return this.mDelegate.getContentLengthLong();
    }

    public String getContentType() {
        return this.mDelegate.getContentType();
    }

    public long getDate() {
        return this.mDelegate.getDate();
    }

    public boolean getDefaultUseCaches() {
        return this.mDelegate.getDefaultUseCaches();
    }

    public boolean getDoInput() {
        return this.mDelegate.getDoInput();
    }

    public boolean getDoOutput() {
        return this.mDelegate.getDoOutput();
    }

    public InputStream getErrorStream() {
        return this.mDelegate.getErrorStream();
    }

    public long getExpiration() {
        return this.mDelegate.getExpiration();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public String getHeaderField(int i) {
        return this.mDelegate.getHeaderField(i);
    }

    public long getHeaderFieldDate(String str, long j) {
        return this.mDelegate.getHeaderFieldDate(str, j);
    }

    public int getHeaderFieldInt(String str, int i) {
        return this.mDelegate.getHeaderFieldInt(str, i);
    }

    public String getHeaderFieldKey(int i) {
        return this.mDelegate.getHeaderFieldKey(i);
    }

    public long getHeaderFieldLong(String str, long j) {
        return this.mDelegate.getHeaderFieldLong(str, j);
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        return this.mDelegate.getHeaderFields();
    }

    public long getIfModifiedSince() {
        return this.mDelegate.getIfModifiedSince();
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        return this.mDelegate.getInputStream();
    }

    public boolean getInstanceFollowRedirects() {
        return this.mDelegate.getInstanceFollowRedirects();
    }

    public long getLastModified() {
        return this.mDelegate.getLastModified();
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        return this.mDelegate.getOutputStream();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public Permission getPermission() throws IOException {
        return this.mDelegate.getPermission();
    }

    public int getReadTimeout() {
        return this.mDelegate.getReadTimeout();
    }

    public String getRequestMethod() {
        return this.mDelegate.getRequestMethod();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getRequestProperties() {
        return this.mDelegate.getRequestProperties();
    }

    public String getRequestProperty(String str) {
        return this.mDelegate.getRequestProperty(str);
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        return this.mDelegate.getResponseCode();
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        return this.mDelegate.getResponseMessage();
    }

    public URL getURL() {
        return this.mDelegate.getURL();
    }

    public boolean getUseCaches() {
        return this.mDelegate.getUseCaches();
    }

    public int hashCode() {
        return this.mDelegate.hashCode();
    }

    public void setAllowUserInteraction(boolean z) {
        this.mDelegate.setAllowUserInteraction(z);
    }

    public void setChunkedStreamingMode(int i) {
        this.mDelegate.setChunkedStreamingMode(i);
    }

    public void setConnectTimeout(int i) {
        this.mDelegate.setConnectTimeout(i);
    }

    public void setDefaultUseCaches(boolean z) {
        this.mDelegate.setDefaultUseCaches(z);
    }

    public void setDoInput(boolean z) {
        this.mDelegate.setDoInput(z);
    }

    public void setDoOutput(boolean z) {
        this.mDelegate.setDoOutput(z);
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(int i) {
        this.mDelegate.setFixedLengthStreamingMode(i);
    }

    public void setIfModifiedSince(long j) {
        this.mDelegate.setIfModifiedSince(j);
    }

    public void setInstanceFollowRedirects(boolean z) {
        this.mDelegate.setInstanceFollowRedirects(z);
    }

    public void setReadTimeout(int i) {
        this.mDelegate.setReadTimeout(i);
    }

    @Override // java.net.HttpURLConnection
    public void setRequestMethod(String str) throws ProtocolException {
        this.mDelegate.setRequestMethod(str);
    }

    public void setRequestProperty(String str, String str2) {
        this.mDelegate.setRequestProperty(str, str2);
    }

    public void setUseCaches(boolean z) {
        this.mDelegate.setUseCaches(z);
    }

    public String toString() {
        return this.mDelegate.toString();
    }

    public boolean usingProxy() {
        return this.mDelegate.usingProxy();
    }

    @Override // java.net.URLConnection
    public Object getContent(Class[] clsArr) throws IOException {
        return this.mDelegate.getContent(clsArr);
    }

    @Override // java.net.URLConnection
    public String getHeaderField(String str) {
        return this.mDelegate.getHeaderField(str);
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(long j) {
        this.mDelegate.setFixedLengthStreamingMode(j);
    }
}
