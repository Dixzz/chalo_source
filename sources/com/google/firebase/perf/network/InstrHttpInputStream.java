package com.google.firebase.perf.network;

import com.google.firebase.perf.impl.NetworkRequestMetricBuilder;
import com.google.firebase.perf.util.Timer;
import java.io.IOException;
import java.io.InputStream;

public final class InstrHttpInputStream extends InputStream {
    private final NetworkRequestMetricBuilder mBuilder;
    private long mBytesRead = -1;
    private final InputStream mInputStream;
    private long mTimeToResponseInitiated;
    private long mTimeToResponseLastRead = -1;
    private final Timer mTimer;

    public InstrHttpInputStream(InputStream inputStream, NetworkRequestMetricBuilder networkRequestMetricBuilder, Timer timer) {
        this.mTimer = timer;
        this.mInputStream = inputStream;
        this.mBuilder = networkRequestMetricBuilder;
        this.mTimeToResponseInitiated = networkRequestMetricBuilder.getTimeToResponseInitiatedMicros();
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        try {
            return this.mInputStream.available();
        } catch (IOException e) {
            this.mBuilder.setTimeToResponseCompletedMicros(this.mTimer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.mBuilder);
            throw e;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
    public void close() throws IOException {
        long durationMicros = this.mTimer.getDurationMicros();
        if (this.mTimeToResponseLastRead == -1) {
            this.mTimeToResponseLastRead = durationMicros;
        }
        try {
            this.mInputStream.close();
            long j = this.mBytesRead;
            if (j != -1) {
                this.mBuilder.setResponsePayloadBytes(j);
            }
            long j2 = this.mTimeToResponseInitiated;
            if (j2 != -1) {
                this.mBuilder.setTimeToResponseInitiatedMicros(j2);
            }
            this.mBuilder.setTimeToResponseCompletedMicros(this.mTimeToResponseLastRead);
            this.mBuilder.build();
        } catch (IOException e) {
            this.mBuilder.setTimeToResponseCompletedMicros(this.mTimer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.mBuilder);
            throw e;
        }
    }

    public void mark(int i) {
        this.mInputStream.mark(i);
    }

    public boolean markSupported() {
        return this.mInputStream.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        try {
            int read = this.mInputStream.read();
            long durationMicros = this.mTimer.getDurationMicros();
            if (this.mTimeToResponseInitiated == -1) {
                this.mTimeToResponseInitiated = durationMicros;
            }
            if (read == -1 && this.mTimeToResponseLastRead == -1) {
                this.mTimeToResponseLastRead = durationMicros;
                this.mBuilder.setTimeToResponseCompletedMicros(durationMicros);
                this.mBuilder.build();
            } else {
                long j = this.mBytesRead + 1;
                this.mBytesRead = j;
                this.mBuilder.setResponsePayloadBytes(j);
            }
            return read;
        } catch (IOException e) {
            this.mBuilder.setTimeToResponseCompletedMicros(this.mTimer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.mBuilder);
            throw e;
        }
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        try {
            this.mInputStream.reset();
        } catch (IOException e) {
            this.mBuilder.setTimeToResponseCompletedMicros(this.mTimer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.mBuilder);
            throw e;
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        try {
            long skip = this.mInputStream.skip(j);
            long durationMicros = this.mTimer.getDurationMicros();
            if (this.mTimeToResponseInitiated == -1) {
                this.mTimeToResponseInitiated = durationMicros;
            }
            if (skip == -1 && this.mTimeToResponseLastRead == -1) {
                this.mTimeToResponseLastRead = durationMicros;
                this.mBuilder.setTimeToResponseCompletedMicros(durationMicros);
            } else {
                long j2 = this.mBytesRead + skip;
                this.mBytesRead = j2;
                this.mBuilder.setResponsePayloadBytes(j2);
            }
            return skip;
        } catch (IOException e) {
            this.mBuilder.setTimeToResponseCompletedMicros(this.mTimer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.mBuilder);
            throw e;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        try {
            int read = this.mInputStream.read(bArr, i, i2);
            long durationMicros = this.mTimer.getDurationMicros();
            if (this.mTimeToResponseInitiated == -1) {
                this.mTimeToResponseInitiated = durationMicros;
            }
            if (read == -1 && this.mTimeToResponseLastRead == -1) {
                this.mTimeToResponseLastRead = durationMicros;
                this.mBuilder.setTimeToResponseCompletedMicros(durationMicros);
                this.mBuilder.build();
            } else {
                long j = this.mBytesRead + ((long) read);
                this.mBytesRead = j;
                this.mBuilder.setResponsePayloadBytes(j);
            }
            return read;
        } catch (IOException e) {
            this.mBuilder.setTimeToResponseCompletedMicros(this.mTimer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.mBuilder);
            throw e;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        try {
            int read = this.mInputStream.read(bArr);
            long durationMicros = this.mTimer.getDurationMicros();
            if (this.mTimeToResponseInitiated == -1) {
                this.mTimeToResponseInitiated = durationMicros;
            }
            if (read == -1 && this.mTimeToResponseLastRead == -1) {
                this.mTimeToResponseLastRead = durationMicros;
                this.mBuilder.setTimeToResponseCompletedMicros(durationMicros);
                this.mBuilder.build();
            } else {
                long j = this.mBytesRead + ((long) read);
                this.mBytesRead = j;
                this.mBuilder.setResponsePayloadBytes(j);
            }
            return read;
        } catch (IOException e) {
            this.mBuilder.setTimeToResponseCompletedMicros(this.mTimer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.mBuilder);
            throw e;
        }
    }
}
