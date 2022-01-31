package com.urbanairship.push;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.urbanairship.Autopilot;
import com.urbanairship.UAirship;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class NotificationProxyReceiver extends BroadcastReceiver {

    public class a implements Runnable {
        public final /* synthetic */ Future f;
        public final /* synthetic */ BroadcastReceiver.PendingResult g;

        public a(NotificationProxyReceiver notificationProxyReceiver, Future future, BroadcastReceiver.PendingResult pendingResult) {
            this.f = future;
            this.g = pendingResult;
        }

        public void run() {
            try {
                yj5.h("Finished processing notification intent with result %s.", (Boolean) this.f.get(9, TimeUnit.SECONDS));
            } catch (InterruptedException | ExecutionException e) {
                yj5.e(e, "NotificationProxyReceiver - Exception when processing notification intent.", new Object[0]);
                Thread.currentThread().interrupt();
            } catch (TimeoutException unused) {
                yj5.c("NotificationProxyReceiver - Application took too long to process notification intent.", new Object[0]);
            }
            this.g.finish();
        }
    }

    public void onReceive(Context context, Intent intent) {
        Autopilot.d((Application) context.getApplicationContext(), false);
        if (!UAirship.v && !UAirship.u) {
            yj5.c("NotificationProxyReceiver - unable to receive intent, takeOff not called.", new Object[0]);
        } else if (intent != null && intent.getAction() != null) {
            yj5.h("Received intent: %s", intent.getAction());
            BroadcastReceiver.PendingResult goAsync = goAsync();
            pj5.f2814a.execute(new a(this, new rv5(context, intent).b(), goAsync));
        }
    }
}
