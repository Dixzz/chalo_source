package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import android.os.PowerManager;
import android.util.SparseArray;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class AppMeasurementService extends Service implements uf4 {
    public qf4<AppMeasurementService> f;

    @Override // defpackage.uf4
    public final void a(JobParameters jobParameters, boolean z) {
        throw new UnsupportedOperationException();
    }

    @Override // defpackage.uf4
    public final void b(Intent intent) {
        SparseArray<PowerManager.WakeLock> sparseArray = jg.f1920a;
        int intExtra = intent.getIntExtra("androidx.contentpager.content.wakelockid", 0);
        if (intExtra != 0) {
            SparseArray<PowerManager.WakeLock> sparseArray2 = jg.f1920a;
            synchronized (sparseArray2) {
                PowerManager.WakeLock wakeLock = sparseArray2.get(intExtra);
                if (wakeLock != null) {
                    wakeLock.release();
                    sparseArray2.remove(intExtra);
                }
            }
        }
    }

    public final qf4<AppMeasurementService> c() {
        if (this.f == null) {
            this.f = new qf4<>(this);
        }
        return this.f;
    }

    @Override // defpackage.uf4
    public final boolean j(int i) {
        return stopSelfResult(i);
    }

    public final IBinder onBind(Intent intent) {
        qf4<AppMeasurementService> c = c();
        Objects.requireNonNull(c);
        if (intent == null) {
            c.b().f.a("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new ac4(lg4.b(c.f2940a));
        }
        c.b().i.b("onBind received unknown action", action);
        return null;
    }

    public final void onCreate() {
        super.onCreate();
        vb4.b(c().f2940a, null, null).g().n.a("Local AppMeasurementService is starting up");
    }

    public final void onDestroy() {
        vb4.b(c().f2940a, null, null).g().n.a("Local AppMeasurementService is shutting down");
        super.onDestroy();
    }

    public final void onRebind(Intent intent) {
        c().c(intent);
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        qf4<AppMeasurementService> c = c();
        ra4 g = vb4.b(c.f2940a, null, null).g();
        if (intent == null) {
            g.i.a("AppMeasurementService started with null intent");
            return 2;
        }
        String action = intent.getAction();
        g.n.c("Local AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(action)) {
            return 2;
        }
        tf4 tf4 = new tf4(c, i2, g, intent);
        lg4 b = lg4.b(c.f2940a);
        b.f().u(new vf4(b, tf4));
        return 2;
    }

    public final boolean onUnbind(Intent intent) {
        c().a(intent);
        return true;
    }
}
