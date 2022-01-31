package app.zophop.ui.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.api.Status;

public class SMSBroadcastReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        Bundle extras;
        if ("com.google.android.gms.auth.api.phone.SMS_RETRIEVED".equals(intent.getAction()) && (extras = intent.getExtras()) != null && ((Status) extras.get("com.google.android.gms.auth.api.phone.EXTRA_STATUS")).g == 0) {
            String str = (String) extras.get("com.google.android.gms.auth.api.phone.EXTRA_SMS_MESSAGE");
        }
    }
}
