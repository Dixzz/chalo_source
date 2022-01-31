package defpackage;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import androidx.work.impl.WorkDatabase;

/* renamed from: wq  reason: default package */
/* compiled from: Alarms */
public class wq {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3825a = tp.e("Alarms");

    public static void a(Context context, String str, int i) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        PendingIntent service = PendingIntent.getService(context, i, xq.b(context, str), 536870912);
        if (service != null && alarmManager != null) {
            tp.c().a(f3825a, String.format("Cancelling existing alarm with (workSpecId, systemId) (%s, %s)", str, Integer.valueOf(i)), new Throwable[0]);
            alarmManager.cancel(service);
        }
    }

    public static void b(Context context, pq pqVar, String str, long j) {
        int intValue;
        WorkDatabase workDatabase = pqVar.c;
        ks ksVar = (ks) workDatabase.c();
        is a2 = ksVar.a(str);
        if (a2 != null) {
            a(context, str, a2.b);
            c(context, str, a2.b, j);
            return;
        }
        synchronized (bt.class) {
            workDatabase.beginTransaction();
            try {
                Long a3 = ((hs) workDatabase.b()).a("next_alarm_manager_id");
                int i = 0;
                intValue = a3 != null ? a3.intValue() : 0;
                if (intValue != Integer.MAX_VALUE) {
                    i = intValue + 1;
                }
                ((hs) workDatabase.b()).b(new fs("next_alarm_manager_id", (long) i));
                workDatabase.setTransactionSuccessful();
            } finally {
                workDatabase.endTransaction();
            }
        }
        ksVar.b(new is(str, intValue));
        c(context, str, intValue, j);
    }

    public static void c(Context context, String str, int i, long j) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        PendingIntent service = PendingIntent.getService(context, i, xq.b(context, str), 134217728);
        if (alarmManager != null) {
            alarmManager.setExact(0, j, service);
        }
    }
}
