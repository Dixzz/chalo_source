package com.google.android.gms.analytics;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;

public final class AnalyticsService extends Service implements de3 {
    public zd3<AnalyticsService> f;

    @Override // defpackage.de3
    public final void a(JobParameters jobParameters, boolean z) {
        throw new UnsupportedOperationException();
    }

    @Override // defpackage.de3
    public final boolean b(int i) {
        return stopSelfResult(i);
    }

    public final zd3<AnalyticsService> c() {
        if (this.f == null) {
            this.f = new zd3<>(this);
        }
        return this.f;
    }

    public final IBinder onBind(Intent intent) {
        c();
        return null;
    }

    public final void onCreate() {
        super.onCreate();
        ac3.b(c().b).c().M("Local AnalyticsService is starting up");
    }

    public final void onDestroy() {
        ac3.b(c().b).c().M("Local AnalyticsService is shutting down");
        super.onDestroy();
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        c().a(intent, i2);
        return 2;
    }
}
