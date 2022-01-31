package defpackage;

import android.app.job.JobParameters;
import java.util.Objects;

/* renamed from: be3  reason: default package */
public final /* synthetic */ class be3 implements Runnable {
    public final zd3 f;
    public final sd3 g;
    public final JobParameters h;

    public be3(zd3 zd3, sd3 sd3, JobParameters jobParameters) {
        this.f = zd3;
        this.g = sd3;
        this.h = jobParameters;
    }

    public final void run() {
        zd3 zd3 = this.f;
        sd3 sd3 = this.g;
        JobParameters jobParameters = this.h;
        Objects.requireNonNull(zd3);
        sd3.M("AnalyticsJobService processed last dispatch request");
        zd3.b.a(jobParameters, false);
    }
}
