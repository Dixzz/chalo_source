package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.cloudmessaging.CloudMessage;
import com.google.firebase.messaging.FcmBroadcastProcessor;
import com.google.firebase.messaging.MessagingAnalytics;
import java.util.concurrent.ExecutionException;

/* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
public final class FirebaseInstanceIdReceiver extends n12 {
    @Override // defpackage.n12
    public final int onMessageReceive(Context context, CloudMessage cloudMessage) {
        try {
            return ((Integer) hd3.u(new FcmBroadcastProcessor(context).process(cloudMessage.f))).intValue();
        } catch (InterruptedException | ExecutionException unused) {
            return 500;
        }
    }

    @Override // defpackage.n12
    public final void onNotificationDismissed(Context context, Bundle bundle) {
        Intent putExtras = new Intent("com.google.firebase.messaging.NOTIFICATION_DISMISS").putExtras(bundle);
        if (MessagingAnalytics.shouldUploadScionMetrics(putExtras)) {
            MessagingAnalytics.logNotificationDismiss(putExtras);
        }
    }
}
