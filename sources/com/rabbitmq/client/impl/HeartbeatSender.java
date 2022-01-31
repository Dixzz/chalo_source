package com.rabbitmq.client.impl;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public final class HeartbeatSender {
    private ScheduledExecutorService executor;
    private final FrameHandler frameHandler;
    private ScheduledFuture<?> future;
    private volatile long lastActivityTime;
    private final Object monitor = new Object();
    private final boolean privateExecutor;
    private boolean shutdown;
    private final ThreadFactory threadFactory;

    public final class HeartbeatRunnable implements Runnable {
        private final long heartbeatNanos;

        public void run() {
            try {
                if (System.nanoTime() > HeartbeatSender.this.lastActivityTime + this.heartbeatNanos) {
                    HeartbeatSender.this.frameHandler.writeFrame(new Frame(8, 0));
                    HeartbeatSender.this.frameHandler.flush();
                }
            } catch (IOException unused) {
            }
        }

        private HeartbeatRunnable(long j) {
            this.heartbeatNanos = j;
        }
    }

    public HeartbeatSender(FrameHandler frameHandler2, ScheduledExecutorService scheduledExecutorService, ThreadFactory threadFactory2) {
        boolean z = false;
        this.shutdown = false;
        this.frameHandler = frameHandler2;
        this.privateExecutor = scheduledExecutorService == null ? true : z;
        this.executor = scheduledExecutorService;
        this.threadFactory = threadFactory2;
    }

    private ScheduledExecutorService createExecutorIfNecessary() {
        ScheduledExecutorService scheduledExecutorService;
        synchronized (this.monitor) {
            if (this.executor == null) {
                this.executor = Executors.newSingleThreadScheduledExecutor(this.threadFactory);
            }
            scheduledExecutorService = this.executor;
        }
        return scheduledExecutorService;
    }

    public void setHeartbeat(int i) {
        synchronized (this.monitor) {
            if (!this.shutdown) {
                ScheduledFuture<?> scheduledFuture = this.future;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(true);
                    this.future = null;
                }
                if (i > 0) {
                    long nanos = TimeUnit.SECONDS.toNanos((long) i) / 2;
                    this.future = createExecutorIfNecessary().scheduleAtFixedRate(new HeartbeatRunnable(nanos), nanos, nanos, TimeUnit.NANOSECONDS);
                }
            }
        }
    }

    public void shutdown() {
        ScheduledExecutorService scheduledExecutorService;
        synchronized (this.monitor) {
            ScheduledFuture<?> scheduledFuture = this.future;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
                this.future = null;
            }
            scheduledExecutorService = this.privateExecutor ? this.executor : null;
            this.executor = null;
            this.shutdown = true;
        }
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdown();
        }
    }

    public void signalActivity() {
        this.lastActivityTime = System.nanoTime();
    }
}
