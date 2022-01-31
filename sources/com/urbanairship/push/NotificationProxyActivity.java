package com.urbanairship.push;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import com.urbanairship.Autopilot;
import com.urbanairship.UAirship;

public class NotificationProxyActivity extends Activity {

    public class a implements kk5<Boolean> {
        public a(NotificationProxyActivity notificationProxyActivity) {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.kk5
        public void a(Boolean bool) {
            yj5.h("Finished processing notification intent with result %s.", bool);
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Autopilot.d((Application) getApplicationContext(), false);
        if (UAirship.v || UAirship.u) {
            Intent intent = getIntent();
            if (intent == null || intent.getAction() == null) {
                finish();
                return;
            }
            yj5.h("Received intent: %s", intent.getAction());
            new rv5(this, intent).b().b(new a(this));
            finish();
            return;
        }
        yj5.c("NotificationProxyActivity - unable to receive intent, takeOff not called.", new Object[0]);
        finish();
    }
}
