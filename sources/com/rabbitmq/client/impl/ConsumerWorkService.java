package com.rabbitmq.client.impl;

import com.rabbitmq.client.Channel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public final class ConsumerWorkService {
    private static final int DEFAULT_NUM_THREADS = (Runtime.getRuntime().availableProcessors() * 2);
    private static final int MAX_RUNNABLE_BLOCK_SIZE = 16;
    private final ExecutorService executor;
    private final boolean privateExecutor;
    private final int shutdownTimeout;
    private final WorkPool<Channel, Runnable> workPool;

    public final class WorkPoolRunnable implements Runnable {
        private WorkPoolRunnable() {
        }

        public void run() {
            ArrayList arrayList = new ArrayList(16);
            try {
                Channel channel = (Channel) ConsumerWorkService.this.workPool.nextWorkBlock(arrayList, 16);
                if (channel != null) {
                    try {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            ((Runnable) it.next()).run();
                        }
                    } finally {
                        if (ConsumerWorkService.this.workPool.finishWorkBlock(channel)) {
                            ConsumerWorkService.this.executor.execute(new WorkPoolRunnable());
                        }
                    }
                }
            } catch (RuntimeException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public ConsumerWorkService(ExecutorService executorService, ThreadFactory threadFactory, int i) {
        this.privateExecutor = executorService == null;
        this.executor = executorService == null ? Executors.newFixedThreadPool(DEFAULT_NUM_THREADS, threadFactory) : executorService;
        this.workPool = new WorkPool<>();
        this.shutdownTimeout = i;
    }

    public void addWork(Channel channel, Runnable runnable) {
        if (this.workPool.addWorkItem(channel, runnable)) {
            this.executor.execute(new WorkPoolRunnable());
        }
    }

    public int getShutdownTimeout() {
        return this.shutdownTimeout;
    }

    public void registerKey(Channel channel) {
        this.workPool.registerKey(channel);
    }

    public void setUnlimited(Channel channel, boolean z) {
        if (z) {
            this.workPool.unlimit(channel);
        } else {
            this.workPool.limit(channel);
        }
    }

    public void shutdown() {
        this.workPool.unregisterAllKeys();
        if (this.privateExecutor) {
            this.executor.shutdown();
        }
    }

    public void stopWork(Channel channel) {
        this.workPool.unregisterKey(channel);
    }

    public boolean usesPrivateExecutor() {
        return this.privateExecutor;
    }
}
