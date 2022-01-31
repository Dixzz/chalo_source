package com.google.firebase.messaging;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
public class FcmExecutors {
    private static Executor newCachedSingleThreadExecutor(String str) {
        return new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), new jb2("Firebase-Messaging-Trigger-Topics-Io"));
    }

    public static ScheduledExecutorService newInitExecutor() {
        return new ScheduledThreadPoolExecutor(1, new jb2("Firebase-Messaging-Init"));
    }

    public static ExecutorService newIntentHandleExecutor() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new jb2("Firebase-Messaging-Intent-Handle"));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return Executors.unconfigurableExecutorService(threadPoolExecutor);
    }

    public static ExecutorService newNetworkIOExecutor() {
        return Executors.newSingleThreadExecutor(new jb2("Firebase-Messaging-Network-Io"));
    }

    public static ExecutorService newTaskExecutor() {
        return Executors.newSingleThreadExecutor(new jb2("Firebase-Messaging-Task"));
    }

    public static ScheduledExecutorService newTopicsSyncExecutor() {
        return new ScheduledThreadPoolExecutor(1, new jb2("Firebase-Messaging-Topics-Io"));
    }

    public static Executor newTopicsSyncTriggerExecutor() {
        return newCachedSingleThreadExecutor("Firebase-Messaging-Trigger-Topics-Io");
    }
}
