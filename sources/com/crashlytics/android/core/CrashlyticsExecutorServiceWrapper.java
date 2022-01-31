package com.crashlytics.android.core;

import android.os.Looper;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

public class CrashlyticsExecutorServiceWrapper {
    private final ExecutorService executorService;

    public CrashlyticsExecutorServiceWrapper(ExecutorService executorService2) {
        this.executorService = executorService2;
    }

    public Future<?> executeAsync(final Runnable runnable) {
        try {
            return this.executorService.submit(new Runnable() {
                /* class com.crashlytics.android.core.CrashlyticsExecutorServiceWrapper.AnonymousClass1 */

                public void run() {
                    try {
                        runnable.run();
                    } catch (Exception unused) {
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
            return null;
        }
    }

    public <T> T executeSyncLoggingException(Callable<T> callable) {
        try {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                return this.executorService.submit(callable).get(4, TimeUnit.SECONDS);
            }
            return this.executorService.submit(callable).get();
        } catch (Exception | RejectedExecutionException unused) {
            return null;
        }
    }

    public <T> Future<T> executeAsync(final Callable<T> callable) {
        try {
            return this.executorService.submit(new Callable<T>() {
                /* class com.crashlytics.android.core.CrashlyticsExecutorServiceWrapper.AnonymousClass2 */

                @Override // java.util.concurrent.Callable
                public T call() throws Exception {
                    try {
                        return (T) callable.call();
                    } catch (Exception unused) {
                        return null;
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
            return null;
        }
    }
}
