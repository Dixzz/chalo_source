package com.crashlytics.android.answers;

import java.io.File;
import java.util.List;

public class AnswersRetryFilesSender implements l16 {
    private static final int BACKOFF_MS = 1000;
    private static final int BACKOFF_POWER = 8;
    private static final double JITTER_PERCENT = 0.1d;
    private static final int MAX_RETRIES = 5;
    private final SessionAnalyticsFilesSender filesSender;
    private final RetryManager retryManager;

    public AnswersRetryFilesSender(SessionAnalyticsFilesSender sessionAnalyticsFilesSender, RetryManager retryManager2) {
        this.filesSender = sessionAnalyticsFilesSender;
        this.retryManager = retryManager2;
    }

    public static AnswersRetryFilesSender build(SessionAnalyticsFilesSender sessionAnalyticsFilesSender) {
        return new AnswersRetryFilesSender(sessionAnalyticsFilesSender, new RetryManager(new f16(new RandomBackoff(new e16(1000, 8), JITTER_PERCENT), new d16(5))));
    }

    @Override // defpackage.l16
    public boolean send(List<File> list) {
        long nanoTime = System.nanoTime();
        if (this.retryManager.canRetry(nanoTime)) {
            if (this.filesSender.send(list)) {
                this.retryManager.reset();
                return true;
            }
            this.retryManager.recordRetry(nanoTime);
        }
        return false;
    }
}
