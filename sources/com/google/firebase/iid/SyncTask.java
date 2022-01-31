package com.google.firebase.iid;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.PowerManager;
import android.util.Log;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-iid@@21.1.0 */
public class SyncTask implements Runnable {
    private final FirebaseInstanceId iid;
    private final long nextDelaySeconds;
    public ExecutorService processorExecutor = FirebaseIidExecutors.newCachedSingleThreadExecutor();
    private final PowerManager.WakeLock syncWakeLock;

    /* compiled from: com.google.firebase:firebase-iid@@21.1.0 */
    public static class ConnectivityChangeReceiver extends BroadcastReceiver {
        @Nullable
        private SyncTask task;

        public ConnectivityChangeReceiver(SyncTask syncTask) {
            this.task = syncTask;
        }

        public void onReceive(Context context, Intent intent) {
            SyncTask syncTask = this.task;
            if (syncTask != null && syncTask.isDeviceConnected()) {
                FirebaseInstanceId.isDebugLogEnabled();
                this.task.iid.enqueueTaskWithDelaySeconds(this.task, 0);
                this.task.getContext().unregisterReceiver(this);
                this.task = null;
            }
        }

        public void registerReceiver() {
            FirebaseInstanceId.isDebugLogEnabled();
            this.task.getContext().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }

    public SyncTask(FirebaseInstanceId firebaseInstanceId, long j) {
        this.iid = firebaseInstanceId;
        this.nextDelaySeconds = j;
        PowerManager.WakeLock newWakeLock = ((PowerManager) getContext().getSystemService("power")).newWakeLock(1, "fiid-sync");
        this.syncWakeLock = newWakeLock;
        newWakeLock.setReferenceCounted(false);
    }

    public Context getContext() {
        return this.iid.getApp().getApplicationContext();
    }

    public boolean isDeviceConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getContext().getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public boolean maybeRefreshToken() throws IOException {
        if (!this.iid.tokenNeedsRefresh(this.iid.getTokenWithoutTriggeringSync())) {
            return true;
        }
        try {
            if (this.iid.blockingGetMasterToken() == null) {
                return false;
            }
            Log.isLoggable("FirebaseInstanceId", 3);
            return true;
        } catch (IOException e) {
            if (GmsRpc.isErrorMessageForRetryableError(e.getMessage())) {
                String.valueOf(e.getMessage()).length();
                return false;
            } else if (e.getMessage() == null) {
                return false;
            } else {
                throw e;
            }
        } catch (SecurityException unused) {
            return false;
        }
    }

    @SuppressLint({"Wakelock"})
    public void run() {
        if (ServiceStarter.getInstance().hasWakeLockPermission(getContext())) {
            this.syncWakeLock.acquire();
        }
        try {
            this.iid.setSyncScheduledOrRunning(true);
            if (!this.iid.isGmsCorePresent()) {
                this.iid.setSyncScheduledOrRunning(false);
                if (!ServiceStarter.getInstance().hasWakeLockPermission(getContext())) {
                    return;
                }
            } else if (!ServiceStarter.getInstance().hasAccessNetworkStatePermission(getContext()) || isDeviceConnected()) {
                if (maybeRefreshToken()) {
                    this.iid.setSyncScheduledOrRunning(false);
                } else {
                    this.iid.syncWithDelaySecondsInternal(this.nextDelaySeconds);
                }
                if (!ServiceStarter.getInstance().hasWakeLockPermission(getContext())) {
                    return;
                }
            } else {
                new ConnectivityChangeReceiver(this).registerReceiver();
                if (!ServiceStarter.getInstance().hasWakeLockPermission(getContext())) {
                    return;
                }
            }
        } catch (IOException e) {
            String.valueOf(e.getMessage()).length();
            this.iid.setSyncScheduledOrRunning(false);
            if (!ServiceStarter.getInstance().hasWakeLockPermission(getContext())) {
                return;
            }
        } catch (Throwable th) {
            if (ServiceStarter.getInstance().hasWakeLockPermission(getContext())) {
                this.syncWakeLock.release();
            }
            throw th;
        }
        this.syncWakeLock.release();
    }
}
