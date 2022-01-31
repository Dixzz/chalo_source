package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import java.util.Objects;

public class RescheduleReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public static final String f267a = tp.e("RescheduleReceiver");

    public void onReceive(Context context, Intent intent) {
        tp.c().a(f267a, String.format("Received intent %s", intent), new Throwable[0]);
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                pq a2 = pq.a(context);
                BroadcastReceiver.PendingResult goAsync = goAsync();
                Objects.requireNonNull(a2);
                synchronized (pq.n) {
                    a2.i = goAsync;
                    if (a2.h) {
                        goAsync.finish();
                        a2.i = null;
                    }
                }
            } catch (IllegalStateException e) {
                tp.c().b(f267a, "Cannot reschedule jobs. WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().", e);
            }
        } else {
            String str = xq.i;
            Intent intent2 = new Intent(context, SystemAlarmService.class);
            intent2.setAction("ACTION_RESCHEDULE");
            context.startService(intent2);
        }
    }
}
