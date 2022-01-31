package defpackage;

import android.app.job.JobParameters;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;

/* renamed from: pw1  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class pw1 implements Runnable {
    public final /* synthetic */ JobInfoSchedulerService f;
    public final /* synthetic */ JobParameters g;

    public /* synthetic */ pw1(JobInfoSchedulerService jobInfoSchedulerService, JobParameters jobParameters) {
        this.f = jobInfoSchedulerService;
        this.g = jobParameters;
    }

    public final void run() {
        this.f.jobFinished(this.g, false);
    }
}
