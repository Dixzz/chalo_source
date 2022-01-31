package com.google.android.gms.measurement;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.util.SparseArray;
import com.freshchat.consumer.sdk.beans.config.DefaultRefreshIntervals;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class AppMeasurementReceiver extends jg implements rb4 {
    public ob4 c;

    public final void onReceive(Context context, Intent intent) {
        if (this.c == null) {
            this.c = new ob4(this);
        }
        ob4 ob4 = this.c;
        Objects.requireNonNull(ob4);
        ra4 g = vb4.b(context, null, null).g();
        if (intent == null) {
            g.i.a("Receiver called with null intent");
            return;
        }
        String action = intent.getAction();
        g.n.b("Local receiver got", action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            Intent className = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
            className.setAction("com.google.android.gms.measurement.UPLOAD");
            g.n.a("Starting wakeful intent.");
            Objects.requireNonNull((AppMeasurementReceiver) ob4.f2675a);
            SparseArray<PowerManager.WakeLock> sparseArray = jg.f1920a;
            synchronized (sparseArray) {
                int i = jg.b;
                int i2 = i + 1;
                jg.b = i2;
                if (i2 <= 0) {
                    jg.b = 1;
                }
                className.putExtra("androidx.contentpager.content.wakelockid", i);
                ComponentName startService = context.startService(className);
                if (startService != null) {
                    PowerManager.WakeLock newWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "androidx.core:wake:" + startService.flattenToShortString());
                    newWakeLock.setReferenceCounted(false);
                    newWakeLock.acquire(DefaultRefreshIntervals.ACTIVE_CONV_MAX_FETCH_INTERVAL);
                    sparseArray.put(i, newWakeLock);
                }
            }
        } else if ("com.android.vending.INSTALL_REFERRER".equals(action)) {
            g.i.a("Install Referrer Broadcasts are deprecated");
        }
    }
}
