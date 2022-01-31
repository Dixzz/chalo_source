package com.google.firebase.messaging;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.google.firebase.iid.GmsRpc;
import com.google.firebase.installations.FirebaseInstallationsApi;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
public class TopicsSubscriber {
    private static final long MAX_DELAY_SEC = TimeUnit.HOURS.toSeconds(8);
    private final Context context;
    private final FirebaseInstallationsApi firebaseInstallationsApi;
    private final FirebaseMessaging firebaseMessaging;
    private final Metadata metadata;
    private final Map<String, ArrayDeque<zi4<Void>>> pendingOperations = new n2();
    private final GmsRpc rpc;
    private final TopicsStore store;
    private final ScheduledExecutorService syncExecutor;
    private boolean syncScheduledOrRunning = false;

    private TopicsSubscriber(FirebaseMessaging firebaseMessaging2, FirebaseInstallationsApi firebaseInstallationsApi2, Metadata metadata2, TopicsStore topicsStore, GmsRpc gmsRpc, Context context2, ScheduledExecutorService scheduledExecutorService) {
        this.firebaseMessaging = firebaseMessaging2;
        this.firebaseInstallationsApi = firebaseInstallationsApi2;
        this.metadata = metadata2;
        this.store = topicsStore;
        this.rpc = gmsRpc;
        this.context = context2;
        this.syncExecutor = scheduledExecutorService;
    }

    private void addToPendingOperations(TopicOperation topicOperation, zi4<Void> zi4) {
        ArrayDeque<zi4<Void>> arrayDeque;
        synchronized (this.pendingOperations) {
            String serialize = topicOperation.serialize();
            if (this.pendingOperations.containsKey(serialize)) {
                arrayDeque = this.pendingOperations.get(serialize);
            } else {
                ArrayDeque<zi4<Void>> arrayDeque2 = new ArrayDeque<>();
                this.pendingOperations.put(serialize, arrayDeque2);
                arrayDeque = arrayDeque2;
            }
            arrayDeque.add(zi4);
        }
    }

    private static <T> T awaitTask(yi4<T> yi4) throws IOException {
        try {
            return (T) hd3.v(yi4, 30, TimeUnit.SECONDS);
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof IOException) {
                throw ((IOException) cause);
            } else if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else {
                throw new IOException(e);
            }
        } catch (InterruptedException | TimeoutException e2) {
            throw new IOException(GmsRpc.ERROR_SERVICE_NOT_AVAILABLE, e2);
        }
    }

    private void blockingSubscribeToTopic(String str) throws IOException {
        awaitTask(this.rpc.subscribeToTopic((String) awaitTask(this.firebaseInstallationsApi.getId()), this.firebaseMessaging.blockingGetToken(), str));
    }

    private void blockingUnsubscribeFromTopic(String str) throws IOException {
        awaitTask(this.rpc.unsubscribeFromTopic((String) awaitTask(this.firebaseInstallationsApi.getId()), this.firebaseMessaging.blockingGetToken(), str));
    }

    public static yi4<TopicsSubscriber> createInstance(FirebaseMessaging firebaseMessaging2, FirebaseInstallationsApi firebaseInstallationsApi2, Metadata metadata2, GmsRpc gmsRpc, Context context2, ScheduledExecutorService scheduledExecutorService) {
        return hd3.A(scheduledExecutorService, new TopicsSubscriber$$Lambda$0(context2, scheduledExecutorService, firebaseMessaging2, firebaseInstallationsApi2, metadata2, gmsRpc));
    }

    public static boolean isDebugLogEnabled() {
        if (Log.isLoggable(Constants.TAG, 3) || (Build.VERSION.SDK_INT == 23 && Log.isLoggable(Constants.TAG, 3))) {
            return true;
        }
        return false;
    }

    public static final /* synthetic */ TopicsSubscriber lambda$createInstance$0$TopicsSubscriber(Context context2, ScheduledExecutorService scheduledExecutorService, FirebaseMessaging firebaseMessaging2, FirebaseInstallationsApi firebaseInstallationsApi2, Metadata metadata2, GmsRpc gmsRpc) throws Exception {
        return new TopicsSubscriber(firebaseMessaging2, firebaseInstallationsApi2, metadata2, TopicsStore.getInstance(context2, scheduledExecutorService), gmsRpc, context2, scheduledExecutorService);
    }

    private void markCompletePendingOperation(TopicOperation topicOperation) {
        synchronized (this.pendingOperations) {
            try {
                String serialize = topicOperation.serialize();
                if (this.pendingOperations.containsKey(serialize)) {
                    ArrayDeque<zi4<Void>> arrayDeque = this.pendingOperations.get(serialize);
                    zi4<Void> poll = arrayDeque.poll();
                    if (poll != null) {
                        poll.f4178a.t(null);
                    }
                    if (arrayDeque.isEmpty()) {
                        this.pendingOperations.remove(serialize);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void startSync() {
        if (!isSyncScheduledOrRunning()) {
            syncWithDelaySecondsInternal(0);
        }
    }

    public boolean hasPendingOperation() {
        return this.store.getNextTopicOperation() != null;
    }

    public synchronized boolean isSyncScheduledOrRunning() {
        return this.syncScheduledOrRunning;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0053  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean performTopicOperation(com.google.firebase.messaging.TopicOperation r6) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 154
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.TopicsSubscriber.performTopicOperation(com.google.firebase.messaging.TopicOperation):boolean");
    }

    public void scheduleSyncTaskWithDelaySeconds(Runnable runnable, long j) {
        this.syncExecutor.schedule(runnable, j, TimeUnit.SECONDS);
    }

    public yi4<Void> scheduleTopicOperation(TopicOperation topicOperation) {
        this.store.addTopicOperation(topicOperation);
        zi4<Void> zi4 = new zi4<>();
        addToPendingOperations(topicOperation, zi4);
        return zi4.f4178a;
    }

    public synchronized void setSyncScheduledOrRunning(boolean z) {
        this.syncScheduledOrRunning = z;
    }

    public void startTopicsSyncIfNecessary() {
        if (hasPendingOperation()) {
            startSync();
        }
    }

    public yi4<Void> subscribeToTopic(String str) {
        yi4<Void> scheduleTopicOperation = scheduleTopicOperation(TopicOperation.subscribe(str));
        startTopicsSyncIfNecessary();
        return scheduleTopicOperation;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0017, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        if (performTopicOperation(r0) != false) goto L_0x0019;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean syncTopics() throws java.io.IOException {
        /*
            r2 = this;
        L_0x0000:
            monitor-enter(r2)
            com.google.firebase.messaging.TopicsStore r0 = r2.store     // Catch:{ all -> 0x0022 }
            com.google.firebase.messaging.TopicOperation r0 = r0.getNextTopicOperation()     // Catch:{ all -> 0x0022 }
            if (r0 != 0) goto L_0x0010
            boolean r0 = isDebugLogEnabled()     // Catch:{ all -> 0x0022 }
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            r0 = 1
            return r0
        L_0x0010:
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            boolean r1 = r2.performTopicOperation(r0)
            if (r1 != 0) goto L_0x0019
            r0 = 0
            return r0
        L_0x0019:
            com.google.firebase.messaging.TopicsStore r1 = r2.store
            r1.removeTopicOperation(r0)
            r2.markCompletePendingOperation(r0)
            goto L_0x0000
        L_0x0022:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.TopicsSubscriber.syncTopics():boolean");
    }

    public void syncWithDelaySecondsInternal(long j) {
        scheduleSyncTaskWithDelaySeconds(new TopicsSyncTask(this, this.context, this.metadata, Math.min(Math.max(30L, j + j), MAX_DELAY_SEC)), j);
        setSyncScheduledOrRunning(true);
    }

    public yi4<Void> unsubscribeFromTopic(String str) {
        yi4<Void> scheduleTopicOperation = scheduleTopicOperation(TopicOperation.unsubscribe(str));
        startTopicsSyncIfNecessary();
        return scheduleTopicOperation;
    }
}
