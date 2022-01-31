package com.google.firebase.remoteconfig.internal;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ConfigCacheClient {
    private static final Executor DIRECT_EXECUTOR = ConfigCacheClient$$Lambda$4.lambdaFactory$();
    public static final long DISK_READ_TIMEOUT_IN_SECONDS = 5;
    private static final Map<String, ConfigCacheClient> clientInstances = new HashMap();
    private yi4<ConfigContainer> cachedContainerTask = null;
    private final ExecutorService executorService;
    private final ConfigStorageClient storageClient;

    public static class AwaitListener<TResult> implements vi4<TResult>, ui4, si4 {
        private final CountDownLatch latch;

        private AwaitListener() {
            this.latch = new CountDownLatch(1);
        }

        public void await() throws InterruptedException {
            this.latch.await();
        }

        @Override // defpackage.si4
        public void onCanceled() {
            this.latch.countDown();
        }

        @Override // defpackage.ui4
        public void onFailure(Exception exc) {
            this.latch.countDown();
        }

        @Override // defpackage.vi4
        public void onSuccess(TResult tresult) {
            this.latch.countDown();
        }

        public boolean await(long j, TimeUnit timeUnit) throws InterruptedException {
            return this.latch.await(j, timeUnit);
        }
    }

    private ConfigCacheClient(ExecutorService executorService2, ConfigStorageClient configStorageClient) {
        this.executorService = executorService2;
        this.storageClient = configStorageClient;
    }

    private static <TResult> TResult await(yi4<TResult> yi4, long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        AwaitListener awaitListener = new AwaitListener();
        Executor executor = DIRECT_EXECUTOR;
        yi4.g(executor, awaitListener);
        yi4.e(executor, awaitListener);
        yi4.a(executor, awaitListener);
        if (!awaitListener.await(j, timeUnit)) {
            throw new TimeoutException("Task await timed out.");
        } else if (yi4.q()) {
            return yi4.m();
        } else {
            throw new ExecutionException(yi4.l());
        }
    }

    public static synchronized void clearInstancesForTest() {
        synchronized (ConfigCacheClient.class) {
            clientInstances.clear();
        }
    }

    public static synchronized ConfigCacheClient getInstance(ExecutorService executorService2, ConfigStorageClient configStorageClient) {
        ConfigCacheClient configCacheClient;
        synchronized (ConfigCacheClient.class) {
            String fileName = configStorageClient.getFileName();
            Map<String, ConfigCacheClient> map = clientInstances;
            if (!map.containsKey(fileName)) {
                map.put(fileName, new ConfigCacheClient(executorService2, configStorageClient));
            }
            configCacheClient = map.get(fileName);
        }
        return configCacheClient;
    }

    public static /* synthetic */ yi4 lambda$put$1(ConfigCacheClient configCacheClient, boolean z, ConfigContainer configContainer, Void r3) throws Exception {
        if (z) {
            configCacheClient.updateInMemoryConfigContainer(configContainer);
        }
        return hd3.W0(configContainer);
    }

    private synchronized void updateInMemoryConfigContainer(ConfigContainer configContainer) {
        this.cachedContainerTask = hd3.W0(configContainer);
    }

    public void clear() {
        synchronized (this) {
            this.cachedContainerTask = hd3.W0(null);
        }
        this.storageClient.clear();
    }

    public synchronized yi4<ConfigContainer> get() {
        yi4<ConfigContainer> yi4 = this.cachedContainerTask;
        if (yi4 == null || (yi4.p() && !this.cachedContainerTask.q())) {
            ExecutorService executorService2 = this.executorService;
            ConfigStorageClient configStorageClient = this.storageClient;
            configStorageClient.getClass();
            this.cachedContainerTask = hd3.A(executorService2, ConfigCacheClient$$Lambda$3.lambdaFactory$(configStorageClient));
        }
        return this.cachedContainerTask;
    }

    public ConfigContainer getBlocking() {
        return getBlocking(5);
    }

    public synchronized yi4<ConfigContainer> getCachedContainerTask() {
        return this.cachedContainerTask;
    }

    public yi4<ConfigContainer> put(ConfigContainer configContainer) {
        return put(configContainer, true);
    }

    public ConfigContainer getBlocking(long j) {
        synchronized (this) {
            yi4<ConfigContainer> yi4 = this.cachedContainerTask;
            if (yi4 == null || !yi4.q()) {
                try {
                    return (ConfigContainer) await(get(), j, TimeUnit.SECONDS);
                } catch (InterruptedException | ExecutionException | TimeoutException unused) {
                    return null;
                }
            } else {
                return this.cachedContainerTask.m();
            }
        }
    }

    public yi4<ConfigContainer> put(ConfigContainer configContainer, boolean z) {
        return hd3.A(this.executorService, ConfigCacheClient$$Lambda$1.lambdaFactory$(this, configContainer)).s(this.executorService, ConfigCacheClient$$Lambda$2.lambdaFactory$(this, z, configContainer));
    }
}
