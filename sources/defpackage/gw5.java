package defpackage;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

/* renamed from: gw5  reason: default package */
/* compiled from: NotificationChannelRegistry */
public class gw5 implements Runnable {
    public final /* synthetic */ String f;
    public final /* synthetic */ ck5 g;
    public final /* synthetic */ hw5 h;

    public gw5(hw5 hw5, String str, ck5 ck5) {
        this.h = hw5;
        this.f = str;
        this.g = ck5;
    }

    public void run() {
        fw5 fw5;
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = this.h.d.getNotificationChannel(this.f);
            if (notificationChannel != null) {
                fw5 = new fw5(notificationChannel);
            } else {
                fw5 m = this.h.f1437a.m(this.f);
                if (m == null) {
                    m = hw5.a(this.h, this.f);
                }
                fw5 = m;
                if (fw5 != null) {
                    NotificationManager notificationManager = this.h.d;
                    NotificationChannel notificationChannel2 = new NotificationChannel(fw5.l, fw5.m, fw5.o);
                    notificationChannel2.setBypassDnd(fw5.f);
                    notificationChannel2.setShowBadge(fw5.g);
                    notificationChannel2.enableLights(fw5.h);
                    notificationChannel2.enableVibration(fw5.i);
                    notificationChannel2.setDescription(fw5.j);
                    notificationChannel2.setGroup(fw5.k);
                    notificationChannel2.setLightColor(fw5.p);
                    notificationChannel2.setVibrationPattern(fw5.r);
                    notificationChannel2.setLockscreenVisibility(fw5.q);
                    notificationChannel2.setSound(fw5.n, Notification.AUDIO_ATTRIBUTES_DEFAULT);
                    notificationManager.createNotificationChannel(notificationChannel2);
                }
            }
        } else {
            fw5 = this.h.f1437a.m(this.f);
            if (fw5 == null) {
                fw5 = hw5.a(this.h, this.f);
            }
        }
        this.g.d(fw5);
    }
}
