package com.urbanairship.automation.alarms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import defpackage.wn5;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class AlarmOperationReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (intent != null && "com.urbanairship.automation.alarms.ALARM_FIRED".equals(intent.getAction())) {
            wn5 c = wn5.c(context);
            Objects.requireNonNull(c);
            yj5.h("Alarm fired", new Object[0]);
            Objects.requireNonNull(c.c);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            synchronized (c.b) {
                Iterator it = new ArrayList(c.b).iterator();
                while (it.hasNext()) {
                    wn5.d dVar = (wn5.d) it.next();
                    if (dVar.b <= elapsedRealtime) {
                        dVar.f3810a.run();
                        c.b.remove(dVar);
                    }
                }
                c.b();
            }
        }
    }
}
