package app.zophop.alarm;

import android.content.Intent;

public class AlarmBootService extends a5 {
    public static final /* synthetic */ int m = 0;

    @Override // defpackage.a5
    public void d(Intent intent) {
        jz5.b().i(hj1.l("boot completed event", Long.MIN_VALUE, "src", "AlarmBootService"));
        SubscriberAlarm.c(this);
    }
}
