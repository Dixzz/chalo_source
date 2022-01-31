package com.google.firebase.messaging;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.google.firebase.iid.ServiceStarter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
public class WithinAppServiceConnection implements ServiceConnection {
    private WithinAppServiceBinder binder;
    private boolean connectionInProgress;
    private final Intent connectionIntent;
    private final Context context;
    private final Queue<BindRequest> intentQueue;
    private final ScheduledExecutorService scheduledExecutorService;

    /* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
    public static class BindRequest {
        public final Intent intent;
        private final zi4<Void> taskCompletionSource = new zi4<>();

        public BindRequest(Intent intent2) {
            this.intent = intent2;
        }

        public void arrangeTimeout(ScheduledExecutorService scheduledExecutorService) {
            getTask().c(scheduledExecutorService, new WithinAppServiceConnection$BindRequest$$Lambda$1(scheduledExecutorService.schedule(new WithinAppServiceConnection$BindRequest$$Lambda$0(this), 9000, TimeUnit.MILLISECONDS)));
        }

        public void finish() {
            this.taskCompletionSource.b(null);
        }

        public yi4<Void> getTask() {
            return this.taskCompletionSource.f4178a;
        }

        public final /* synthetic */ void lambda$arrangeTimeout$0$WithinAppServiceConnection$BindRequest() {
            String.valueOf(this.intent.getAction()).length();
            finish();
        }
    }

    public WithinAppServiceConnection(Context context2, String str) {
        this(context2, ServiceStarter.ACTION_MESSAGING_EVENT, new ScheduledThreadPoolExecutor(0, new jb2("Firebase-FirebaseInstanceIdServiceConnection")));
    }

    private void finishAllInQueue() {
        while (!this.intentQueue.isEmpty()) {
            this.intentQueue.poll().finish();
        }
    }

    private synchronized void flushQueue() {
        Log.isLoggable(Constants.TAG, 3);
        while (!this.intentQueue.isEmpty()) {
            Log.isLoggable(Constants.TAG, 3);
            WithinAppServiceBinder withinAppServiceBinder = this.binder;
            if (withinAppServiceBinder == null || !withinAppServiceBinder.isBinderAlive()) {
                startConnectionIfNeeded();
                return;
            }
            Log.isLoggable(Constants.TAG, 3);
            this.binder.send(this.intentQueue.poll());
        }
    }

    private void startConnectionIfNeeded() {
        Log.isLoggable(Constants.TAG, 3);
        if (!this.connectionInProgress) {
            this.connectionInProgress = true;
            try {
                if (za2.b().a(this.context, this.connectionIntent, this, 65)) {
                    return;
                }
            } catch (SecurityException unused) {
            }
            this.connectionInProgress = false;
            finishAllInQueue();
        }
    }

    public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable(Constants.TAG, 3)) {
            String.valueOf(componentName).length();
        }
        this.connectionInProgress = false;
        if (!(iBinder instanceof WithinAppServiceBinder)) {
            String.valueOf(iBinder).length();
            finishAllInQueue();
            return;
        }
        this.binder = (WithinAppServiceBinder) iBinder;
        flushQueue();
    }

    public void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable(Constants.TAG, 3)) {
            String.valueOf(componentName).length();
        }
        flushQueue();
    }

    public synchronized yi4<Void> sendIntent(Intent intent) {
        BindRequest bindRequest;
        Log.isLoggable(Constants.TAG, 3);
        bindRequest = new BindRequest(intent);
        bindRequest.arrangeTimeout(this.scheduledExecutorService);
        this.intentQueue.add(bindRequest);
        flushQueue();
        return bindRequest.getTask();
    }

    public WithinAppServiceConnection(Context context2, String str, ScheduledExecutorService scheduledExecutorService2) {
        this.intentQueue = new ArrayDeque();
        this.connectionInProgress = false;
        Context applicationContext = context2.getApplicationContext();
        this.context = applicationContext;
        this.connectionIntent = new Intent(ServiceStarter.ACTION_MESSAGING_EVENT).setPackage(applicationContext.getPackageName());
        this.scheduledExecutorService = scheduledExecutorService2;
    }
}
