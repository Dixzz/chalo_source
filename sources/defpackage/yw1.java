package defpackage;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import android.util.Base64;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import com.rabbitmq.client.StringRpcServer;
import defpackage.zw1;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;
import java.util.zip.Adler32;

/* renamed from: yw1  reason: default package */
/* compiled from: JobInfoScheduler */
public class yw1 implements ex1 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f4091a;
    public final xx1 b;
    public final zw1 c;

    public yw1(Context context, xx1 xx1, zw1 zw1) {
        this.f4091a = context;
        this.b = xx1;
        this.c = zw1;
    }

    @Override // defpackage.ex1
    public void a(jv1 jv1, int i) {
        b(jv1, i, false);
    }

    @Override // defpackage.ex1
    public void b(jv1 jv1, int i, boolean z) {
        boolean z2;
        ComponentName componentName = new ComponentName(this.f4091a, JobInfoSchedulerService.class);
        JobScheduler jobScheduler = (JobScheduler) this.f4091a.getSystemService("jobscheduler");
        Adler32 adler32 = new Adler32();
        adler32.update(this.f4091a.getPackageName().getBytes(Charset.forName(StringRpcServer.STRING_ENCODING)));
        adler32.update(jv1.b().getBytes(Charset.forName(StringRpcServer.STRING_ENCODING)));
        adler32.update(ByteBuffer.allocate(4).putInt(oy1.a(jv1.d())).array());
        if (jv1.c() != null) {
            adler32.update(jv1.c());
        }
        int value = (int) adler32.getValue();
        if (!z) {
            Iterator<JobInfo> it = jobScheduler.getAllPendingJobs().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                JobInfo next = it.next();
                int i2 = next.getExtras().getInt("attemptNumber");
                if (next.getId() == value) {
                    if (i2 >= i) {
                        z2 = true;
                    }
                }
            }
            z2 = false;
            if (z2) {
                gj1.C("JobInfoScheduler", "Upload for context %s is already scheduled. Returning...", jv1);
                return;
            }
        }
        long T0 = this.b.T0(jv1);
        zw1 zw1 = this.c;
        JobInfo.Builder builder = new JobInfo.Builder(value, componentName);
        bu1 d = jv1.d();
        builder.setMinimumLatency(zw1.b(d, T0, i));
        Set<zw1.b> c2 = zw1.c().get(d).c();
        if (c2.contains(zw1.b.NETWORK_UNMETERED)) {
            builder.setRequiredNetworkType(2);
        } else {
            builder.setRequiredNetworkType(1);
        }
        if (c2.contains(zw1.b.DEVICE_CHARGING)) {
            builder.setRequiresCharging(true);
        }
        if (c2.contains(zw1.b.DEVICE_IDLE)) {
            builder.setRequiresDeviceIdle(true);
        }
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putInt("attemptNumber", i);
        persistableBundle.putString("backendName", jv1.b());
        persistableBundle.putInt("priority", oy1.a(jv1.d()));
        if (jv1.c() != null) {
            persistableBundle.putString("extras", Base64.encodeToString(jv1.c(), 0));
        }
        builder.setExtras(persistableBundle);
        Object[] objArr = {jv1, Integer.valueOf(value), Long.valueOf(this.c.b(jv1.d(), T0, i)), Long.valueOf(T0), Integer.valueOf(i)};
        gj1.L("JobInfoScheduler");
        String.format("Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", objArr);
        jobScheduler.schedule(builder.build());
    }
}
