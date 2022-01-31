package defpackage;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemjob.SystemJobService;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

/* renamed from: dr  reason: default package */
/* compiled from: SystemJobScheduler */
public class dr implements iq {
    public static final String j = tp.e("SystemJobScheduler");
    public final Context f;
    public final JobScheduler g;
    public final pq h;
    public final cr i;

    public dr(Context context, pq pqVar) {
        cr crVar = new cr(context);
        this.f = context;
        this.h = pqVar;
        this.g = (JobScheduler) context.getSystemService("jobscheduler");
        this.i = crVar;
    }

    public static void b(JobScheduler jobScheduler, int i2) {
        try {
            jobScheduler.cancel(i2);
        } catch (Throwable th) {
            tp.c().b(j, String.format(Locale.getDefault(), "Exception while trying to cancel job (%d)", Integer.valueOf(i2)), th);
        }
    }

    public static List<Integer> d(Context context, JobScheduler jobScheduler, String str) {
        List<JobInfo> f2 = f(context, jobScheduler);
        if (f2 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(2);
        for (JobInfo jobInfo : f2) {
            if (str.equals(g(jobInfo))) {
                arrayList.add(Integer.valueOf(jobInfo.getId()));
            }
        }
        return arrayList;
    }

    public static List<JobInfo> f(Context context, JobScheduler jobScheduler) {
        List<JobInfo> list;
        try {
            list = jobScheduler.getAllPendingJobs();
        } catch (Throwable th) {
            tp.c().b(j, "getAllPendingJobs() is not reliable on this device.", th);
            list = null;
        }
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        ComponentName componentName = new ComponentName(context, SystemJobService.class);
        for (JobInfo jobInfo : list) {
            if (componentName.equals(jobInfo.getService())) {
                arrayList.add(jobInfo);
            }
        }
        return arrayList;
    }

    public static String g(JobInfo jobInfo) {
        PersistableBundle extras = jobInfo.getExtras();
        if (extras == null) {
            return null;
        }
        try {
            if (extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                return extras.getString("EXTRA_WORK_SPEC_ID");
            }
            return null;
        } catch (NullPointerException unused) {
            return null;
        }
    }

    /* JADX INFO: finally extract failed */
    @Override // defpackage.iq
    public void a(rs... rsVarArr) {
        int i2;
        List<Integer> d;
        int i3;
        WorkDatabase workDatabase = this.h.c;
        bt btVar = new bt(workDatabase);
        for (rs rsVar : rsVarArr) {
            workDatabase.beginTransaction();
            try {
                rs i4 = ((ts) workDatabase.f()).i(rsVar.f3122a);
                if (i4 == null) {
                    tp.c().f(j, "Skipping scheduling " + rsVar.f3122a + " because it's no longer in the DB", new Throwable[0]);
                    workDatabase.setTransactionSuccessful();
                } else if (i4.b != zp.ENQUEUED) {
                    tp.c().f(j, "Skipping scheduling " + rsVar.f3122a + " because it is no longer enqueued", new Throwable[0]);
                    workDatabase.setTransactionSuccessful();
                } else {
                    is a2 = ((ks) workDatabase.c()).a(rsVar.f3122a);
                    if (a2 != null) {
                        i2 = a2.b;
                    } else {
                        Objects.requireNonNull(this.h.b);
                        i2 = btVar.b(0, this.h.b.g);
                    }
                    if (a2 == null) {
                        ((ks) this.h.c.c()).b(new is(rsVar.f3122a, i2));
                    }
                    h(rsVar, i2);
                    if (Build.VERSION.SDK_INT == 23 && (d = d(this.f, this.g, rsVar.f3122a)) != null) {
                        int indexOf = d.indexOf(Integer.valueOf(i2));
                        if (indexOf >= 0) {
                            d.remove(indexOf);
                        }
                        if (!d.isEmpty()) {
                            i3 = d.get(0).intValue();
                        } else {
                            Objects.requireNonNull(this.h.b);
                            i3 = btVar.b(0, this.h.b.g);
                        }
                        h(rsVar, i3);
                    }
                    workDatabase.setTransactionSuccessful();
                }
                workDatabase.endTransaction();
            } catch (Throwable th) {
                workDatabase.endTransaction();
                throw th;
            }
        }
    }

    @Override // defpackage.iq
    public boolean c() {
        return true;
    }

    @Override // defpackage.iq
    public void e(String str) {
        List<Integer> d = d(this.f, this.g, str);
        if (!(d == null || d.isEmpty())) {
            for (Integer num : d) {
                b(this.g, num.intValue());
            }
            ((ks) this.h.c.c()).c(str);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0027, code lost:
        if (r3 < 26) goto L_0x002e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void h(defpackage.rs r18, int r19) {
        /*
        // Method dump skipped, instructions count: 415
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.dr.h(rs, int):void");
    }
}
