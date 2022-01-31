package com.crashlytics.android.answers;

import java.util.Objects;

public class RetryManager {
    private static final long NANOSECONDS_IN_MS = 1000000;
    public long lastRetry;
    private f16 retryState;

    public RetryManager(f16 f16) {
        Objects.requireNonNull(f16, "retryState must not be null");
        this.retryState = f16;
    }

    public boolean canRetry(long j) {
        f16 f16 = this.retryState;
        return j - this.lastRetry >= f16.b.getDelayMillis(f16.f1061a) * NANOSECONDS_IN_MS;
    }

    public void recordRetry(long j) {
        this.lastRetry = j;
        f16 f16 = this.retryState;
        this.retryState = new f16(f16.f1061a + 1, f16.b, f16.c);
    }

    public void reset() {
        this.lastRetry = 0;
        f16 f16 = this.retryState;
        this.retryState = new f16(f16.b, f16.c);
    }
}
