package com.google.android.play.core.assetpacks;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import java.util.Objects;

public class ExtractionForegroundService extends Service {
    public final nv4 f = new nv4("ExtractionForegroundService");
    public Context g;
    public ku4 h;
    public NotificationManager i;

    public final IBinder onBind(Intent intent) {
        return null;
    }

    public final void onCreate() {
        super.onCreate();
        ls4 h2 = mt4.h(getApplicationContext());
        Context context = h2.f2264a.f2606a;
        Objects.requireNonNull(context, "Cannot return null from a non-@Nullable @Provides method");
        this.g = context;
        this.h = h2.y.a();
        this.i = (NotificationManager) this.g.getSystemService("notification");
    }

    public final int onStartCommand(Intent intent, int i2, int i3) {
        int intExtra = intent.getIntExtra("action_type", 0);
        if (intExtra == 1) {
            synchronized (this) {
                String stringExtra = intent.getStringExtra("notification_title");
                String stringExtra2 = intent.getStringExtra("notification_subtext");
                long longExtra = intent.getLongExtra("notification_timeout", 1);
                PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("notification_on_click_intent");
                int i4 = Build.VERSION.SDK_INT;
                Notification.Builder timeoutAfter = i4 >= 26 ? new Notification.Builder(this.g, "playcore-assetpacks-service-notification-channel").setTimeoutAfter(longExtra) : new Notification.Builder(this.g).setPriority(-2);
                if (pendingIntent != null) {
                    timeoutAfter.setContentIntent(pendingIntent);
                }
                timeoutAfter.setSmallIcon(17301633).setOngoing(false).setContentTitle(stringExtra).setSubText(stringExtra2);
                timeoutAfter.setColor(intent.getIntExtra("notification_color", 0)).setVisibility(-1);
                Notification build = timeoutAfter.build();
                this.f.b(4, "Starting foreground installation service.", new Object[0]);
                this.h.a(true);
                if (i4 >= 26) {
                    String stringExtra3 = intent.getStringExtra("notification_channel_name");
                    synchronized (this) {
                        this.i.createNotificationChannel(new NotificationChannel("playcore-assetpacks-service-notification-channel", stringExtra3, 2));
                    }
                }
                startForeground(-1883842196, build);
            }
        } else if (intExtra == 2) {
            synchronized (this) {
                this.f.b(4, "Stopping service.", new Object[0]);
                this.h.a(false);
                stopForeground(true);
                stopSelf();
            }
        } else {
            this.f.b(6, "Unknown action type received: %d", new Object[]{Integer.valueOf(intExtra)});
        }
        return 2;
    }
}
