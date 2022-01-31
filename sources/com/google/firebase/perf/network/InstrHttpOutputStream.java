package com.google.firebase.perf.network;

import com.google.firebase.perf.impl.NetworkRequestMetricBuilder;
import com.google.firebase.perf.util.Timer;
import java.io.IOException;
import java.io.OutputStream;

public final class InstrHttpOutputStream extends OutputStream {
    public NetworkRequestMetricBuilder mBuilder;
    public long mBytesWritten = -1;
    private OutputStream mOutputStream;
    private final Timer mTimer;

    public InstrHttpOutputStream(OutputStream outputStream, NetworkRequestMetricBuilder networkRequestMetricBuilder, Timer timer) {
        this.mOutputStream = outputStream;
        this.mBuilder = networkRequestMetricBuilder;
        this.mTimer = timer;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        long j = this.mBytesWritten;
        if (j != -1) {
            this.mBuilder.setRequestPayloadBytes(j);
        }
        this.mBuilder.setTimeToRequestCompletedMicros(this.mTimer.getDurationMicros());
        try {
            this.mOutputStream.close();
        } catch (IOException e) {
            this.mBuilder.setTimeToResponseCompletedMicros(this.mTimer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.mBuilder);
            throw e;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        try {
            this.mOutputStream.flush();
        } catch (IOException e) {
            this.mBuilder.setTimeToResponseCompletedMicros(this.mTimer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.mBuilder);
            throw e;
        }
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        try {
            this.mOutputStream.write(i);
            long j = this.mBytesWritten + 1;
            this.mBytesWritten = j;
            this.mBuilder.setRequestPayloadBytes(j);
        } catch (IOException e) {
            this.mBuilder.setTimeToResponseCompletedMicros(this.mTimer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.mBuilder);
            throw e;
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        try {
            this.mOutputStream.write(bArr);
            long length = this.mBytesWritten + ((long) bArr.length);
            this.mBytesWritten = length;
            this.mBuilder.setRequestPayloadBytes(length);
        } catch (IOException e) {
            this.mBuilder.setTimeToResponseCompletedMicros(this.mTimer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.mBuilder);
            throw e;
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        try {
            this.mOutputStream.write(bArr, i, i2);
            long j = this.mBytesWritten + ((long) i2);
            this.mBytesWritten = j;
            this.mBuilder.setRequestPayloadBytes(j);
        } catch (IOException e) {
            this.mBuilder.setTimeToResponseCompletedMicros(this.mTimer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.mBuilder);
            throw e;
        }
    }
}
