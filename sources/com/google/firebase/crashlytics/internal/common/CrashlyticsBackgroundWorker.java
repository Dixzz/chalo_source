package com.google.firebase.crashlytics.internal.common;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

public class CrashlyticsBackgroundWorker {
    private final Executor executor;
    private ThreadLocal<Boolean> isExecutorThread = new ThreadLocal<>();
    private yi4<Void> tail = hd3.W0(null);
    private final Object tailLock = new Object();

    public CrashlyticsBackgroundWorker(Executor executor2) {
        this.executor = executor2;
        executor2.execute(new Runnable() {
            /* class com.google.firebase.crashlytics.internal.common.CrashlyticsBackgroundWorker.AnonymousClass1 */

            public void run() {
                CrashlyticsBackgroundWorker.this.isExecutorThread.set(Boolean.TRUE);
            }
        });
    }

    private <T> yi4<Void> ignoreResult(yi4<T> yi4) {
        return yi4.i(this.executor, new qi4<T, Void>() {
            /* class com.google.firebase.crashlytics.internal.common.CrashlyticsBackgroundWorker.AnonymousClass4 */

            @Override // defpackage.qi4
            public Void then(yi4<T> yi4) throws Exception {
                return null;
            }
        });
    }

    private boolean isRunningOnThread() {
        return Boolean.TRUE.equals(this.isExecutorThread.get());
    }

    private <T> qi4<Void, T> newContinuation(final Callable<T> callable) {
        return new qi4<Void, T>() {
            /* class com.google.firebase.crashlytics.internal.common.CrashlyticsBackgroundWorker.AnonymousClass3 */

            @Override // defpackage.qi4
            public T then(yi4<Void> yi4) throws Exception {
                return (T) callable.call();
            }
        };
    }

    public void checkRunningOnThread() {
        if (!isRunningOnThread()) {
            throw new IllegalStateException("Not running on background worker thread as intended.");
        }
    }

    public Executor getExecutor() {
        return this.executor;
    }

    public yi4<Void> submit(final Runnable runnable) {
        return submit(new Callable<Void>() {
            /* class com.google.firebase.crashlytics.internal.common.CrashlyticsBackgroundWorker.AnonymousClass2 */

            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                runnable.run();
                return null;
            }
        });
    }

    public <T> yi4<T> submitTask(Callable<yi4<T>> callable) {
        yi4<T> k;
        synchronized (this.tailLock) {
            k = this.tail.k(this.executor, newContinuation(callable));
            this.tail = ignoreResult(k);
        }
        return k;
    }

    public <T> yi4<T> submit(Callable<T> callable) {
        yi4<T> i;
        synchronized (this.tailLock) {
            i = this.tail.i(this.executor, newContinuation(callable));
            this.tail = ignoreResult(i);
        }
        return i;
    }
}
