package com.google.firebase.database.core;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolEventTarget implements EventTarget {
    private final ThreadPoolExecutor executor;

    public ThreadPoolEventTarget(final ThreadFactory threadFactory, final ThreadInitializer threadInitializer) {
        this.executor = new ThreadPoolExecutor(1, 1, 3, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() {
            /* class com.google.firebase.database.core.ThreadPoolEventTarget.AnonymousClass1 */

            public Thread newThread(Runnable runnable) {
                Thread newThread = threadFactory.newThread(runnable);
                threadInitializer.setName(newThread, "FirebaseDatabaseEventTarget");
                threadInitializer.setDaemon(newThread, true);
                return newThread;
            }
        });
    }

    @Override // com.google.firebase.database.core.EventTarget
    public void postEvent(Runnable runnable) {
        this.executor.execute(runnable);
    }

    @Override // com.google.firebase.database.core.EventTarget
    public void restart() {
        this.executor.setCorePoolSize(1);
    }

    @Override // com.google.firebase.database.core.EventTarget
    public void shutdown() {
        this.executor.setCorePoolSize(0);
    }
}
