package androidx.work.impl.background.systemjob;

import android.app.Application;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.PersistableBundle;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class SystemJobService extends JobService implements fq {
    public static final String h = tp.e("SystemJobService");
    public pq f;
    public final Map<String, JobParameters> g = new HashMap();

    public static String a(JobParameters jobParameters) {
        try {
            PersistableBundle extras = jobParameters.getExtras();
            if (extras == null || !extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                return null;
            }
            return extras.getString("EXTRA_WORK_SPEC_ID");
        } catch (NullPointerException unused) {
            return null;
        }
    }

    @Override // defpackage.fq
    public void d(String str, boolean z) {
        JobParameters remove;
        tp.c().a(h, String.format("%s executed on JobScheduler", str), new Throwable[0]);
        synchronized (this.g) {
            remove = this.g.remove(str);
        }
        if (remove != null) {
            jobFinished(remove, z);
        }
    }

    public void onCreate() {
        super.onCreate();
        try {
            pq a2 = pq.a(getApplicationContext());
            this.f = a2;
            a2.f.a(this);
        } catch (IllegalStateException unused) {
            if (Application.class.equals(getApplication().getClass())) {
                tp.c().f(h, "Could not find WorkManager instance; this may be because an auto-backup is in progress. Ignoring JobScheduler commands for now. Please make sure that you are initializing WorkManager if you have manually disabled WorkManagerInitializer.", new Throwable[0]);
                return;
            }
            throw new IllegalStateException("WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().");
        }
    }

    public void onDestroy() {
        super.onDestroy();
        pq pqVar = this.f;
        if (pqVar != null) {
            pqVar.f.e(this);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006c, code lost:
        r2 = null;
        r3 = android.os.Build.VERSION.SDK_INT;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0071, code lost:
        if (r3 < 24) goto L_0x009f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0073, code lost:
        r2 = new androidx.work.WorkerParameters.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x007c, code lost:
        if (r9.getTriggeredContentUris() == null) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007e, code lost:
        r2.b = java.util.Arrays.asList(r9.getTriggeredContentUris());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x008c, code lost:
        if (r9.getTriggeredContentAuthorities() == null) goto L_0x0098;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x008e, code lost:
        r2.f262a = java.util.Arrays.asList(r9.getTriggeredContentAuthorities());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x009a, code lost:
        if (r3 < 28) goto L_0x009f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x009c, code lost:
        r9.getNetwork();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x009f, code lost:
        r9 = r8.f;
        r3 = r9.d;
        ((defpackage.qt) r3).f2987a.execute(new defpackage.gt(r9, r0, r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00af, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onStartJob(android.app.job.JobParameters r9) {
        /*
        // Method dump skipped, instructions count: 179
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.background.systemjob.SystemJobService.onStartJob(android.app.job.JobParameters):boolean");
    }

    public boolean onStopJob(JobParameters jobParameters) {
        boolean contains;
        if (this.f == null) {
            tp.c().a(h, "WorkManager is not initialized; requesting retry.", new Throwable[0]);
            return true;
        }
        String a2 = a(jobParameters);
        if (TextUtils.isEmpty(a2)) {
            tp.c().b(h, "WorkSpec id not found!", new Throwable[0]);
            return false;
        }
        tp.c().a(h, String.format("onStopJob for %s", a2), new Throwable[0]);
        synchronized (this.g) {
            this.g.remove(a2);
        }
        this.f.d(a2);
        hq hqVar = this.f.f;
        synchronized (hqVar.o) {
            contains = hqVar.m.contains(a2);
        }
        return !contains;
    }
}
