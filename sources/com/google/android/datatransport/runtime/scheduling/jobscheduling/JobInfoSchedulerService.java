package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Base64;
import defpackage.cv1;
import defpackage.jv1;

public class JobInfoSchedulerService extends JobService {
    public boolean onStartJob(JobParameters jobParameters) {
        String string = jobParameters.getExtras().getString("backendName");
        String string2 = jobParameters.getExtras().getString("extras");
        int i = jobParameters.getExtras().getInt("priority");
        int i2 = jobParameters.getExtras().getInt("attemptNumber");
        nv1.b(getApplicationContext());
        jv1.a a2 = jv1.a();
        a2.b(string);
        a2.c(oy1.b(i));
        if (string2 != null) {
            ((cv1.b) a2).b = Base64.decode(string2, 0);
        }
        ax1 ax1 = nv1.a().d;
        ax1.e.execute(new rw1(ax1, a2.a(), i2, new pw1(this, jobParameters)));
        return true;
    }

    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
