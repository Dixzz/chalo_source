package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* renamed from: he1  reason: default package */
/* compiled from: GPSToggleReciever */
public class he1 extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().matches("android.location.MODE_CHANGED") || intent.getAction().matches("android.location.PROVIDER_CHANGED_ACTION")) {
            jz5.b().i(new pd1());
        }
    }
}
