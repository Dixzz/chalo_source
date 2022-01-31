package app.zophop.alarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.razorpay.BaseConstants;

public class AlarmBootReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
            int i = AlarmBootService.m;
            a5.a(context, AlarmBootService.class, BaseConstants.SMS_CONSENT_REQUEST, intent);
        }
    }
}
