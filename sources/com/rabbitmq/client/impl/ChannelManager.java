package com.rabbitmq.client.impl;

import com.rabbitmq.client.ShutdownSignalException;
import com.rabbitmq.utility.IntAllocator;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class ChannelManager {
    private final Map<Integer, ChannelN> _channelMap;
    private final int _channelMax;
    private final IntAllocator channelNumberAllocator;
    private final Object monitor;
    private ExecutorService shutdownExecutor;
    private final Set<CountDownLatch> shutdownSet;
    private final ThreadFactory threadFactory;
    private final ConsumerWorkService workService;

    public ChannelManager(ConsumerWorkService consumerWorkService, int i) {
        this(consumerWorkService, i, Executors.defaultThreadFactory());
    }

    private ChannelN addNewChannel(AMQConnection aMQConnection, int i) throws IOException {
        if (!this._channelMap.containsKey(Integer.valueOf(i))) {
            ChannelN instantiateChannel = instantiateChannel(aMQConnection, i, this.workService);
            this._channelMap.put(Integer.valueOf(instantiateChannel.getChannelNumber()), instantiateChannel);
            return instantiateChannel;
        }
        throw new IllegalStateException("We have attempted to create a channel with a number that is already in use. This should never happen. Please report this as a bug.");
    }

    private void scheduleShutdownProcessing() {
        final HashSet hashSet = new HashSet(this.shutdownSet);
        final ConsumerWorkService consumerWorkService = this.workService;
        AnonymousClass1 r2 = new Runnable() {
            /* class com.rabbitmq.client.impl.ChannelManager.AnonymousClass1 */

            public void run() {
                for (CountDownLatch countDownLatch : hashSet) {
                    try {
                        int shutdownTimeout = consumerWorkService.getShutdownTimeout();
                        if (shutdownTimeout == 0) {
                            countDownLatch.await();
                        } else {
                            countDownLatch.await((long) shutdownTimeout, TimeUnit.MILLISECONDS);
                        }
                    } catch (Throwable unused) {
                    }
                }
                consumerWorkService.shutdown();
            }
        };
        ExecutorService executorService = this.shutdownExecutor;
        if (executorService != null) {
            executorService.execute(r2);
        } else {
            Environment.newThread(this.threadFactory, r2, "ConsumerWorkService shutdown monitor", true).start();
        }
    }

    public ChannelN createChannel(AMQConnection aMQConnection) throws IOException {
        synchronized (this.monitor) {
            int allocate = this.channelNumberAllocator.allocate();
            if (allocate == -1) {
                return null;
            }
            ChannelN addNewChannel = addNewChannel(aMQConnection, allocate);
            addNewChannel.open();
            return addNewChannel;
        }
    }

    public ChannelN getChannel(int i) {
        ChannelN channelN;
        synchronized (this.monitor) {
            channelN = this._channelMap.get(Integer.valueOf(i));
            if (channelN == null) {
                throw new UnknownChannelException(i);
            }
        }
        return channelN;
    }

    public int getChannelMax() {
        return this._channelMax;
    }

    public ExecutorService getShutdownExecutor() {
        return this.shutdownExecutor;
    }

    public void handleSignal(ShutdownSignalException shutdownSignalException) {
        HashSet hashSet;
        synchronized (this.monitor) {
            hashSet = new HashSet(this._channelMap.values());
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ChannelN channelN = (ChannelN) it.next();
            releaseChannelNumber(channelN);
            channelN.processShutdownSignal(shutdownSignalException, true, true);
            this.shutdownSet.add(channelN.getShutdownLatch());
            channelN.notifyListeners();
        }
        scheduleShutdownProcessing();
    }

    public ChannelN instantiateChannel(AMQConnection aMQConnection, int i, ConsumerWorkService consumerWorkService) {
        return new ChannelN(aMQConnection, i, consumerWorkService);
    }

    public void releaseChannelNumber(ChannelN channelN) {
        synchronized (this.monitor) {
            int channelNumber = channelN.getChannelNumber();
            ChannelN remove = this._channelMap.remove(Integer.valueOf(channelNumber));
            if (remove != null) {
                if (remove != channelN) {
                    this._channelMap.put(Integer.valueOf(channelNumber), remove);
                } else {
                    this.channelNumberAllocator.free(channelNumber);
                }
            }
        }
    }

    public void setShutdownExecutor(ExecutorService executorService) {
        this.shutdownExecutor = executorService;
    }

    public ChannelManager(ConsumerWorkService consumerWorkService, int i, ThreadFactory threadFactory2) {
        this.monitor = new Object();
        this._channelMap = new HashMap();
        this.shutdownSet = new HashSet();
        i = i == 0 ? 65535 : i;
        this._channelMax = i;
        this.channelNumberAllocator = new IntAllocator(1, i);
        this.workService = consumerWorkService;
        this.threadFactory = threadFactory2;
    }

    public ChannelN createChannel(AMQConnection aMQConnection, int i) throws IOException {
        synchronized (this.monitor) {
            if (!this.channelNumberAllocator.reserve(i)) {
                return null;
            }
            ChannelN addNewChannel = addNewChannel(aMQConnection, i);
            addNewChannel.open();
            return addNewChannel;
        }
    }
}
