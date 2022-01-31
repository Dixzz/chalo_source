package com.google.android.gms.measurement;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;

@TargetApi(24)
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class AppMeasurementJobService extends JobService implements uf4 {
    public qf4<AppMeasurementJobService> f;

    @Override // defpackage.uf4
    @TargetApi(24)
    public final void a(JobParameters jobParameters, boolean z) {
        jobFinished(jobParameters, false);
    }

    @Override // defpackage.uf4
    public final void b(Intent intent) {
    }

    public final qf4<AppMeasurementJobService> c() {
        if (this.f == null) {
            this.f = new qf4<>(this);
        }
        return this.f;
    }

    @Override // defpackage.uf4
    public final boolean j(int i) {
        throw new UnsupportedOperationException();
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

    public final boolean onStartJob(JobParameters jobParameters) {
        qf4<AppMeasurementJobService> c = c();
        ra4 g = vb4.b(c.f2940a, null, null).g();
        String string = jobParameters.getExtras().getString("action");
        g.n.b("Local AppMeasurementJobService called. action", string);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(string)) {
            return true;
        }
        sf4 sf4 = new sf4(c, g, jobParameters);
        lg4 b = lg4.b(c.f2940a);
        b.f().u(new vf4(b, sf4));
        return true;
    }

    public final boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    public final boolean onUnbind(Intent intent) {
        c().a(intent);
        return true;
    }
}
