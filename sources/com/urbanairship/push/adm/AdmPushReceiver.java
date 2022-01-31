package com.urbanairship.push.adm;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.urbanairship.Autopilot;
import com.urbanairship.push.PushMessage;
import defpackage.nv5;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import server.zophop.Constants;

public class AdmPushReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        Autopilot.d((Application) context.getApplicationContext(), false);
        if (intent != null && intent.getExtras() != null && "com.amazon.device.messaging.intent.RECEIVE".equals(intent.getAction())) {
            boolean isOrderedBroadcast = isOrderedBroadcast();
            BroadcastReceiver.PendingResult goAsync = goAsync();
            PushMessage pushMessage = new PushMessage(intent.getExtras());
            yj5.h("Received push.", new Object[0]);
            nv5.b bVar = new nv5.b(context);
            bVar.b = pushMessage;
            String cls = AdmPushProvider.class.toString();
            bVar.c = cls;
            ExecutorService executorService = vv5.y;
            hd3.E(cls, "Provider class missing");
            hd3.E(bVar.b, "Push Message missing");
            try {
                executorService.submit(new nv5(bVar, null)).get(Constants.THRESHOLD_TIMESTAMP, TimeUnit.MILLISECONDS);
            } catch (TimeoutException unused) {
                yj5.c("Application took too long to process push. App may get closed.", new Object[0]);
            } catch (Exception e) {
                yj5.e(e, "Failed to wait for notification", new Object[0]);
            }
            if (goAsync != null) {
                if (isOrderedBroadcast) {
                    goAsync.setResultCode(-1);
                }
                goAsync.finish();
            }
        } else if (isOrderedBroadcast()) {
            setResultCode(-1);
        }
    }
}
