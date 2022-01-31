package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import android.util.Log;
import com.google.firebase.iid.ServiceStarter;
import com.google.firebase.messaging.Constants;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
public class FcmBroadcastProcessor {
    @GuardedBy("lock")
    private static WithinAppServiceConnection fcmServiceConn;
    private static final Object lock = new Object();
    private final Context context;
    private final Executor executor;

    public FcmBroadcastProcessor(Context context2) {
        this.context = context2;
        this.executor = FcmBroadcastProcessor$$Lambda$0.$instance;
    }

    public FcmBroadcastProcessor(Context context2, ExecutorService executorService) {
        this.context = context2;
        this.executor = executorService;
    }

    private static yi4<Integer> bindToMessagingService(Context context2, Intent intent) {
        Log.isLoggable(Constants.TAG, 3);
        return getServiceConnection(context2, ServiceStarter.ACTION_MESSAGING_EVENT).sendIntent(intent).i(FcmBroadcastProcessor$$Lambda$3.$instance, FcmBroadcastProcessor$$Lambda$4.$instance);
    }

    private static WithinAppServiceConnection getServiceConnection(Context context2, String str) {
        WithinAppServiceConnection withinAppServiceConnection;
        synchronized (lock) {
            if (fcmServiceConn == null) {
                fcmServiceConn = new WithinAppServiceConnection(context2, ServiceStarter.ACTION_MESSAGING_EVENT);
            }
            withinAppServiceConnection = fcmServiceConn;
        }
        return withinAppServiceConnection;
    }

    public static final /* synthetic */ Integer lambda$bindToMessagingService$3$FcmBroadcastProcessor(yi4 yi4) throws Exception {
        return -1;
    }

    public static final /* synthetic */ yi4 lambda$startMessagingService$2$FcmBroadcastProcessor(Context context2, Intent intent, yi4 yi4) throws Exception {
        return (!gj1.N() || ((Integer) yi4.m()).intValue() != 402) ? yi4 : bindToMessagingService(context2, intent).i(FcmBroadcastProcessor$$Lambda$5.$instance, FcmBroadcastProcessor$$Lambda$6.$instance);
    }

    public static void reset() {
        synchronized (lock) {
            fcmServiceConn = null;
        }
    }

    public yi4<Integer> process(Intent intent) {
        String stringExtra = intent.getStringExtra("gcm.rawData64");
        if (stringExtra != null) {
            intent.putExtra(Constants.MessagePayloadKeys.RAW_DATA, Base64.decode(stringExtra, 0));
            intent.removeExtra("gcm.rawData64");
        }
        return startMessagingService(this.context, intent);
    }

    @SuppressLint({"InlinedApi"})
    public yi4<Integer> startMessagingService(Context context2, Intent intent) {
        boolean z = false;
        if (gj1.N() && context2.getApplicationInfo().targetSdkVersion >= 26) {
            z = true;
        }
        int flags = intent.getFlags() & 268435456;
        if (!z || flags != 0) {
            return hd3.A(this.executor, new FcmBroadcastProcessor$$Lambda$1(context2, intent)).k(this.executor, new FcmBroadcastProcessor$$Lambda$2(context2, intent));
        }
        return bindToMessagingService(context2, intent);
    }
}
