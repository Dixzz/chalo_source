package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import com.google.firebase.messaging.WithinAppServiceBinder;
import java.util.concurrent.ExecutorService;

@SuppressLint({"UnwrappedWakefulBroadcastReceiver"})
/* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
public abstract class EnhancedIntentService extends Service {
    private Binder binder;
    public final ExecutorService executor = FcmExecutors.newIntentHandleExecutor();
    private int lastStartId;
    private final Object lock = new Object();
    private int runningTasks = 0;

    private void finishTask(Intent intent) {
        if (intent != null) {
            WakeLockHolder.completeWakefulIntent(intent);
        }
        synchronized (this.lock) {
            int i = this.runningTasks - 1;
            this.runningTasks = i;
            if (i == 0) {
                stopSelfResultHook(this.lastStartId);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private yi4<Void> processIntent(Intent intent) {
        if (handleIntentOnMainThread(intent)) {
            return hd3.W0(null);
        }
        zi4 zi4 = new zi4();
        this.executor.execute(new EnhancedIntentService$$Lambda$0(this, intent, zi4));
        return zi4.f4178a;
    }

    public Intent getStartCommandIntent(Intent intent) {
        return intent;
    }

    public abstract void handleIntent(Intent intent);

    public boolean handleIntentOnMainThread(Intent intent) {
        return false;
    }

    public final /* synthetic */ void lambda$onStartCommand$1$EnhancedIntentService(Intent intent, yi4 yi4) {
        finishTask(intent);
    }

    public final void lambda$processIntent$0$EnhancedIntentService(Intent intent, zi4 zi4) {
        try {
            handleIntent(intent);
        } finally {
            zi4.f4178a.t(null);
        }
    }

    public final synchronized IBinder onBind(Intent intent) {
        Log.isLoggable("EnhancedIntentService", 3);
        if (this.binder == null) {
            this.binder = new WithinAppServiceBinder(new WithinAppServiceBinder.IntentHandler() {
                /* class com.google.firebase.messaging.EnhancedIntentService.AnonymousClass1 */

                @Override // com.google.firebase.messaging.WithinAppServiceBinder.IntentHandler
                public yi4<Void> handle(Intent intent) {
                    return EnhancedIntentService.this.processIntent(intent);
                }
            });
        }
        return this.binder;
    }

    public void onDestroy() {
        this.executor.shutdown();
        super.onDestroy();
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        synchronized (this.lock) {
            this.lastStartId = i2;
            this.runningTasks++;
        }
        Intent startCommandIntent = getStartCommandIntent(intent);
        if (startCommandIntent == null) {
            finishTask(intent);
            return 2;
        }
        yi4<Void> processIntent = processIntent(startCommandIntent);
        if (processIntent.p()) {
            finishTask(intent);
            return 2;
        }
        processIntent.c(EnhancedIntentService$$Lambda$1.$instance, new EnhancedIntentService$$Lambda$2(this, intent));
        return 3;
    }

    public boolean stopSelfResultHook(int i) {
        return stopSelfResult(i);
    }
}
