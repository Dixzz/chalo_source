package defpackage;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.cloudmessaging.CloudMessage;
import com.google.firebase.messaging.Constants;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* renamed from: n12  reason: default package */
/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
public abstract class n12 extends BroadcastReceiver {
    private final ExecutorService zza;

    public n12() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new jb2("firebase-iid-executor"));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.zza = Executors.unconfigurableExecutorService(threadPoolExecutor);
    }

    private final int zza(Context context, Intent intent) {
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("pending_intent");
        if (pendingIntent != null) {
            try {
                pendingIntent.send();
            } catch (PendingIntent.CanceledException unused) {
            }
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            extras.remove("pending_intent");
        } else {
            extras = new Bundle();
        }
        if ("com.google.firebase.messaging.NOTIFICATION_OPEN".equals(intent.getAction())) {
            onNotificationOpen(context, extras);
            return -1;
        } else if (!"com.google.firebase.messaging.NOTIFICATION_DISMISS".equals(intent.getAction())) {
            return 500;
        } else {
            onNotificationDismissed(context, extras);
            return -1;
        }
    }

    private final int zzb(Context context, Intent intent) {
        yi4 yi4;
        int i;
        if (intent.getExtras() == null) {
            return 500;
        }
        String stringExtra = intent.getStringExtra(Constants.MessagePayloadKeys.MSGID);
        if (TextUtils.isEmpty(stringExtra)) {
            yi4 = hd3.W0(null);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString(Constants.MessagePayloadKeys.MSGID, stringExtra);
            s12 a2 = s12.a(context);
            synchronized (a2) {
                i = a2.d;
                a2.d = i + 1;
            }
            yi4 = a2.b(new b22(i, bundle));
        }
        int onMessageReceive = onMessageReceive(context, new CloudMessage(intent));
        try {
            hd3.v(yi4, TimeUnit.SECONDS.toMillis(1), TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            String.valueOf(e).length();
        }
        return onMessageReceive;
    }

    public Executor getBroadcastExecutor() {
        return this.zza;
    }

    public abstract int onMessageReceive(Context context, CloudMessage cloudMessage);

    public abstract void onNotificationDismissed(Context context, Bundle bundle);

    public void onNotificationOpen(Context context, Bundle bundle) {
    }

    public final void onReceive(Context context, Intent intent) {
        if (intent != null) {
            getBroadcastExecutor().execute(new r12(this, intent, context, isOrderedBroadcast(), goAsync()));
        }
    }

    public final /* synthetic */ void zza(Intent intent, Context context, boolean z, BroadcastReceiver.PendingResult pendingResult) {
        int i;
        try {
            Parcelable parcelableExtra = intent.getParcelableExtra("wrapped_intent");
            Intent intent2 = parcelableExtra instanceof Intent ? (Intent) parcelableExtra : null;
            if (intent2 != null) {
                i = zza(context, intent2);
            } else {
                i = zzb(context, intent);
            }
            if (z) {
                pendingResult.setResultCode(i);
            }
        } finally {
            pendingResult.finish();
        }
    }
}
