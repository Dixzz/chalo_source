package com.mixpanel.android.mpmetrics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.Map;
import org.json.JSONObject;

public class MixpanelPushNotificationDismissedReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action != null && action.equals("com.mixpanel.push_notification_dismissed")) {
            Map<String, Map<Context, nc5>> map = nc5.o;
            nc5.u(context, intent, "$push_notification_dismissed", new JSONObject());
        }
    }
}
