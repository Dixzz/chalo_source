package com.google.android.gms.analytics;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;

@TargetApi(24)
public final class AnalyticsJobService extends JobService implements de3 {
    public zd3<AnalyticsJobService> f;

    @Override // defpackage.de3
    @TargetApi(24)
    public final void a(JobParameters jobParameters, boolean z) {
        jobFinished(jobParameters, false);
    }

    @Override // defpackage.de3
    public final boolean b(int i) {
        return stopSelfResult(i);
    }

    public final zd3<AnalyticsJobService> c() {
        if (this.f == null) {
            this.f = new zd3<>(this);
        }
        return this.f;
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

    public final boolean onStartJob(JobParameters jobParameters) {
        zd3<AnalyticsJobService> c = c();
        sd3 c2 = ac3.b(c.b).c();
        String string = jobParameters.getExtras().getString("action");
        c2.k("Local AnalyticsJobService called. action", string);
        if (!"com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(string)) {
            return true;
        }
        c.b(new be3(c, c2, jobParameters));
        return true;
    }

    public final boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
