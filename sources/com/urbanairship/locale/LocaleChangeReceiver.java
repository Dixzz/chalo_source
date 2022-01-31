package com.urbanairship.locale;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.urbanairship.Autopilot;
import com.urbanairship.UAirship;
import java.util.Locale;

public class LocaleChangeReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (intent != null && "android.intent.action.LOCALE_CHANGED".equals(intent.getAction())) {
            if (UAirship.v || UAirship.u) {
                Autopilot.d((Application) context.getApplicationContext(), false);
                ku5 ku5 = UAirship.l().r;
                synchronized (ku5) {
                    ku5.b = h.N(ku5.f2123a.getResources().getConfiguration()).c(0);
                    yj5.a("Device Locale changed. Locale: %s.", ku5.b);
                    if (ku5.b() == null) {
                        Locale locale = ku5.b;
                        for (ju5 ju5 : ku5.c) {
                            ju5.a(locale);
                        }
                    }
                }
                return;
            }
            yj5.c("LocaleChangedReceiver - unable to receive intent, takeOff not called.", new Object[0]);
        }
    }
}
