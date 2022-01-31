package defpackage;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Build;
import androidx.work.R;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import androidx.work.impl.background.systemjob.SystemJobService;
import androidx.work.impl.utils.ForceStopRunnable;
import defpackage.kp;
import defpackage.nq;
import defpackage.tp;
import defpackage.wl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: pq  reason: default package */
/* compiled from: WorkManagerImpl */
public class pq extends aq {
    public static final String k = tp.e("WorkManagerImpl");
    public static pq l = null;
    public static pq m = null;
    public static final Object n = new Object();

    /* renamed from: a  reason: collision with root package name */
    public Context f2838a;
    public kp b;
    public WorkDatabase c;
    public pt d;
    public List<iq> e;
    public hq f;
    public dt g;
    public boolean h;
    public BroadcastReceiver.PendingResult i;
    public volatile st j;

    public pq(Context context, kp kpVar, pt ptVar) {
        wl.a aVar;
        iq iqVar;
        boolean z = context.getResources().getBoolean(R.bool.workmanager_test_configuration);
        Context applicationContext = context.getApplicationContext();
        ft ftVar = ((qt) ptVar).f2987a;
        int i2 = WorkDatabase.b;
        iq iqVar2 = null;
        if (z) {
            aVar = new wl.a(applicationContext, WorkDatabase.class, null);
            aVar.h = true;
        } else {
            String str = oq.f2723a;
            aVar = h.C(applicationContext, WorkDatabase.class, "androidx.work.workdb");
            aVar.g = new lq(applicationContext);
        }
        aVar.e = ftVar;
        mq mqVar = new mq();
        if (aVar.d == null) {
            aVar.d = new ArrayList<>();
        }
        aVar.d.add(mqVar);
        aVar.a(nq.f2592a);
        aVar.a(new nq.g(applicationContext, 2, 3));
        aVar.a(nq.b);
        aVar.a(nq.c);
        aVar.a(new nq.g(applicationContext, 5, 6));
        aVar.a(nq.d);
        aVar.a(nq.e);
        aVar.a(nq.f);
        aVar.a(new nq.h(applicationContext));
        aVar.a(new nq.g(applicationContext, 10, 11));
        aVar.j = false;
        aVar.k = true;
        WorkDatabase workDatabase = (WorkDatabase) aVar.b();
        int i3 = Build.VERSION.SDK_INT;
        Context applicationContext2 = context.getApplicationContext();
        tp.a aVar2 = new tp.a(kpVar.f);
        synchronized (tp.class) {
            tp.f3386a = aVar2;
        }
        iq[] iqVarArr = new iq[2];
        String str2 = jq.f1968a;
        if (i3 >= 23) {
            iqVar = new dr(applicationContext2, this);
            ct.a(applicationContext2, SystemJobService.class, true);
            tp.c().a(jq.f1968a, "Created SystemJobScheduler and enabled SystemJobService", new Throwable[0]);
        } else {
            try {
                iq iqVar3 = (iq) Class.forName("androidx.work.impl.background.gcm.GcmScheduler").getConstructor(Context.class).newInstance(applicationContext2);
                tp.c().a(jq.f1968a, String.format("Created %s", "androidx.work.impl.background.gcm.GcmScheduler"), new Throwable[0]);
                iqVar2 = iqVar3;
            } catch (Throwable th) {
                tp.c().a(jq.f1968a, "Unable to create GCM Scheduler", th);
            }
            if (iqVar2 == null) {
                iqVar = new br(applicationContext2);
                ct.a(applicationContext2, SystemAlarmService.class, true);
                tp.c().a(jq.f1968a, "Created SystemAlarmScheduler", new Throwable[0]);
            } else {
                iqVar = iqVar2;
            }
        }
        iqVarArr[0] = iqVar;
        iqVarArr[1] = new vq(applicationContext2, kpVar, ptVar, this);
        List<iq> asList = Arrays.asList(iqVarArr);
        hq hqVar = new hq(context, kpVar, ptVar, workDatabase, asList);
        Context applicationContext3 = context.getApplicationContext();
        this.f2838a = applicationContext3;
        this.b = kpVar;
        this.d = ptVar;
        this.c = workDatabase;
        this.e = asList;
        this.f = hqVar;
        this.g = new dt(workDatabase);
        this.h = false;
        if (i3 < 24 || !applicationContext3.isDeviceProtectedStorage()) {
            pt ptVar2 = this.d;
            ((qt) ptVar2).f2987a.execute(new ForceStopRunnable(applicationContext3, this));
            return;
        }
        throw new IllegalStateException("Cannot initialize WorkManager in direct boot mode");
    }

    public static pq a(Context context) {
        pq pqVar;
        Object obj = n;
        synchronized (obj) {
            synchronized (obj) {
                pqVar = l;
                if (pqVar == null) {
                    pqVar = m;
                }
            }
            return pqVar;
        }
        if (pqVar == null) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext instanceof kp.b) {
                b(applicationContext, ((kp.b) applicationContext).a());
                pqVar = a(applicationContext);
            } else {
                throw new IllegalStateException("WorkManager is not initialized properly.  You have explicitly disabled WorkManagerInitializer in your manifest, have not manually called WorkManager#initialize at this point, and your Application does not implement Configuration.Provider.");
            }
        }
        return pqVar;
    }

    public static void b(Context context, kp kpVar) {
        synchronized (n) {
            pq pqVar = l;
            if (pqVar != null) {
                if (m != null) {
                    throw new IllegalStateException("WorkManager is already initialized.  Did you try to initialize it manually without disabling WorkManagerInitializer? See WorkManager#initialize(Context, Configuration) or the class level Javadoc for more information.");
                }
            }
            if (pqVar == null) {
                Context applicationContext = context.getApplicationContext();
                if (m == null) {
                    m = new pq(applicationContext, kpVar, new qt(kpVar.b));
                }
                l = m;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public void c() {
        List<JobInfo> f2;
        if (Build.VERSION.SDK_INT >= 23) {
            Context context = this.f2838a;
            String str = dr.j;
            JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
            if (!(jobScheduler == null || (f2 = dr.f(context, jobScheduler)) == null || f2.isEmpty())) {
                for (JobInfo jobInfo : f2) {
                    dr.b(jobScheduler, jobInfo.getId());
                }
            }
        }
        ts tsVar = (ts) this.c.f();
        tsVar.f3404a.assertNotSuspendingTransaction();
        sm acquire = tsVar.i.acquire();
        tsVar.f3404a.beginTransaction();
        try {
            acquire.F();
            tsVar.f3404a.setTransactionSuccessful();
            tsVar.f3404a.endTransaction();
            tsVar.i.release(acquire);
            jq.a(this.b, this.c, this.e);
        } catch (Throwable th) {
            tsVar.f3404a.endTransaction();
            tsVar.i.release(acquire);
            throw th;
        }
    }

    public void d(String str) {
        pt ptVar = this.d;
        ((qt) ptVar).f2987a.execute(new ht(this, str, false));
    }

    public final void e() {
        try {
            this.j = (st) Class.forName("androidx.work.multiprocess.RemoteWorkManagerClient").getConstructor(Context.class, pq.class).newInstance(this.f2838a, this);
        } catch (Throwable th) {
            tp.c().a(k, "Unable to initialize multi-process support", th);
        }
    }
}
