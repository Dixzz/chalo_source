package androidx.work.impl.foreground;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.work.impl.WorkDatabase;
import defpackage.zr;
import java.util.Objects;
import java.util.UUID;

public class SystemForegroundService extends ih implements zr.a {
    public static final String k = tp.e("SystemFgService");
    public Handler g;
    public boolean h;
    public zr i;
    public NotificationManager j;

    public class a implements Runnable {
        public final /* synthetic */ int f;
        public final /* synthetic */ Notification g;
        public final /* synthetic */ int h;

        public a(int i2, Notification notification, int i3) {
            this.f = i2;
            this.g = notification;
            this.h = i3;
        }

        public void run() {
            if (Build.VERSION.SDK_INT >= 29) {
                SystemForegroundService.this.startForeground(this.f, this.g, this.h);
            } else {
                SystemForegroundService.this.startForeground(this.f, this.g);
            }
        }
    }

    public final void a() {
        this.g = new Handler(Looper.getMainLooper());
        this.j = (NotificationManager) getApplicationContext().getSystemService("notification");
        zr zrVar = new zr(getApplicationContext());
        this.i = zrVar;
        if (zrVar.o != null) {
            tp.c().b(zr.p, "A callback already exists.", new Throwable[0]);
        } else {
            zrVar.o = this;
        }
    }

    public void b(int i2, int i3, Notification notification) {
        this.g.post(new a(i2, notification, i3));
    }

    @Override // defpackage.ih
    public void onCreate() {
        super.onCreate();
        a();
    }

    @Override // defpackage.ih
    public void onDestroy() {
        super.onDestroy();
        this.i.c();
    }

    @Override // defpackage.ih
    public int onStartCommand(Intent intent, int i2, int i3) {
        super.onStartCommand(intent, i2, i3);
        if (this.h) {
            tp.c().d(k, "Re-initializing SystemForegroundService after a request to shut-down.", new Throwable[0]);
            this.i.c();
            a();
            this.h = false;
        }
        if (intent == null) {
            return 3;
        }
        zr zrVar = this.i;
        Objects.requireNonNull(zrVar);
        String action = intent.getAction();
        if ("ACTION_START_FOREGROUND".equals(action)) {
            tp.c().d(zr.p, String.format("Started foreground service %s", intent), new Throwable[0]);
            String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
            WorkDatabase workDatabase = zrVar.g.c;
            pt ptVar = zrVar.h;
            ((qt) ptVar).f2987a.execute(new yr(zrVar, workDatabase, stringExtra));
            zrVar.a(intent);
            return 3;
        } else if ("ACTION_NOTIFY".equals(action)) {
            zrVar.a(intent);
            return 3;
        } else if ("ACTION_CANCEL_WORK".equals(action)) {
            tp.c().d(zr.p, String.format("Stopping foreground work for %s", intent), new Throwable[0]);
            String stringExtra2 = intent.getStringExtra("KEY_WORKSPEC_ID");
            if (stringExtra2 == null || TextUtils.isEmpty(stringExtra2)) {
                return 3;
            }
            pq pqVar = zrVar.g;
            UUID fromString = UUID.fromString(stringExtra2);
            Objects.requireNonNull(pqVar);
            ((qt) pqVar.d).f2987a.execute(new xs(pqVar, fromString));
            return 3;
        } else if (!"ACTION_STOP_FOREGROUND".equals(action)) {
            return 3;
        } else {
            tp.c().d(zr.p, "Stopping foreground service", new Throwable[0]);
            zr.a aVar = zrVar.o;
            if (aVar == null) {
                return 3;
            }
            SystemForegroundService systemForegroundService = (SystemForegroundService) aVar;
            systemForegroundService.h = true;
            tp.c().a(k, "All commands completed.", new Throwable[0]);
            if (Build.VERSION.SDK_INT >= 26) {
                systemForegroundService.stopForeground(true);
            }
            systemForegroundService.stopSelf();
            return 3;
        }
    }
}
