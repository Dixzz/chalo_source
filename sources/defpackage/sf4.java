package defpackage;

import android.app.job.JobParameters;
import java.util.Objects;

/* renamed from: sf4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final /* synthetic */ class sf4 implements Runnable {
    public final qf4 f;
    public final ra4 g;
    public final JobParameters h;

    public sf4(qf4 qf4, ra4 ra4, JobParameters jobParameters) {
        this.f = qf4;
        this.g = ra4;
        this.h = jobParameters;
    }

    public final void run() {
        qf4 qf4 = this.f;
        ra4 ra4 = this.g;
        JobParameters jobParameters = this.h;
        Objects.requireNonNull(qf4);
        ra4.n.a("AppMeasurementJobService processed last upload request.");
        qf4.f2940a.a(jobParameters, false);
    }
}
