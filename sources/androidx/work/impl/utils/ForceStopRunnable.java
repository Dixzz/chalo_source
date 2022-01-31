package androidx.work.impl.utils;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteAccessPermException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteTableLockedException;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.impl.WorkDatabase;
import defpackage.tp;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class ForceStopRunnable implements Runnable {
    public static final String i = tp.e("ForceStopRunnable");
    public static final long j = TimeUnit.DAYS.toMillis(3650);
    public final Context f;
    public final pq g;
    public int h = 0;

    public static class BroadcastReceiver extends android.content.BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        public static final String f269a = tp.e("ForceStopRunnable$Rcvr");

        public void onReceive(Context context, Intent intent) {
            if (intent != null && "ACTION_FORCE_STOP_RESCHEDULE".equals(intent.getAction())) {
                int i = ((tp.a) tp.c()).b;
                ForceStopRunnable.c(context);
            }
        }
    }

    public ForceStopRunnable(Context context, pq pqVar) {
        this.f = context.getApplicationContext();
        this.g = pqVar;
    }

    public static PendingIntent b(Context context, int i2) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, BroadcastReceiver.class));
        intent.setAction("ACTION_FORCE_STOP_RESCHEDULE");
        return PendingIntent.getBroadcast(context, -1, intent, i2);
    }

    public static void c(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        PendingIntent b = b(context, 134217728);
        long currentTimeMillis = System.currentTimeMillis() + j;
        if (alarmManager != null) {
            alarmManager.setExact(0, currentTimeMillis, b);
        }
    }

    public void a() {
        boolean z;
        boolean z2;
        if (Build.VERSION.SDK_INT >= 23) {
            Context context = this.f;
            pq pqVar = this.g;
            String str = dr.j;
            JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
            List<JobInfo> f2 = dr.f(context, jobScheduler);
            ks ksVar = (ks) pqVar.c.c();
            Objects.requireNonNull(ksVar);
            yl e = yl.e("SELECT DISTINCT work_spec_id FROM SystemIdInfo", 0);
            ksVar.f2112a.assertNotSuspendingTransaction();
            Cursor b = hm.b(ksVar.f2112a, e, false, null);
            try {
                ArrayList arrayList = new ArrayList(b.getCount());
                while (b.moveToNext()) {
                    arrayList.add(b.getString(0));
                }
                HashSet hashSet = new HashSet(f2 != null ? f2.size() : 0);
                if (f2 != null && !f2.isEmpty()) {
                    for (JobInfo jobInfo : f2) {
                        String g2 = dr.g(jobInfo);
                        if (!TextUtils.isEmpty(g2)) {
                            hashSet.add(g2);
                        } else {
                            dr.b(jobScheduler, jobInfo.getId());
                        }
                    }
                }
                Iterator it = arrayList.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (!hashSet.contains((String) it.next())) {
                            tp.c().a(dr.j, "Reconciling jobs", new Throwable[0]);
                            z = true;
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
                if (z) {
                    WorkDatabase workDatabase = pqVar.c;
                    workDatabase.beginTransaction();
                    try {
                        ss f3 = workDatabase.f();
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            ((ts) f3).l((String) it2.next(), -1);
                        }
                        workDatabase.setTransactionSuccessful();
                    } finally {
                        workDatabase.endTransaction();
                    }
                }
            } finally {
                b.close();
                e.f();
            }
        } else {
            z = false;
        }
        WorkDatabase workDatabase2 = this.g.c;
        ss f4 = workDatabase2.f();
        ps e2 = workDatabase2.e();
        workDatabase2.beginTransaction();
        ts tsVar = (ts) f4;
        try {
            ArrayList arrayList2 = (ArrayList) tsVar.e();
            boolean z3 = !arrayList2.isEmpty();
            if (z3) {
                Iterator it3 = arrayList2.iterator();
                while (it3.hasNext()) {
                    rs rsVar = (rs) it3.next();
                    tsVar.p(zp.ENQUEUED, rsVar.f3122a);
                    tsVar.l(rsVar.f3122a, -1);
                }
            }
            ((qs) e2).b();
            workDatabase2.setTransactionSuccessful();
            boolean z4 = z3 || z;
            Long a2 = ((hs) this.g.g.f885a.b()).a("reschedule_needed");
            if (a2 != null && a2.longValue() == 1) {
                tp.c().a(i, "Rescheduling Workers.", new Throwable[0]);
                this.g.c();
                dt dtVar = this.g.g;
                Objects.requireNonNull(dtVar);
                ((hs) dtVar.f885a.b()).b(new fs("reschedule_needed", false));
            } else {
                if (b(this.f, 536870912) == null) {
                    c(this.f);
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    tp.c().a(i, "Application was force-stopped, rescheduling.", new Throwable[0]);
                    this.g.c();
                } else if (z4) {
                    tp.c().a(i, "Found unfinished work, scheduling it.", new Throwable[0]);
                    pq pqVar2 = this.g;
                    jq.a(pqVar2.b, pqVar2.c, pqVar2.e);
                }
            }
            pq pqVar3 = this.g;
            Objects.requireNonNull(pqVar3);
            synchronized (pq.n) {
                pqVar3.h = true;
                BroadcastReceiver.PendingResult pendingResult = pqVar3.i;
                if (pendingResult != null) {
                    pendingResult.finish();
                    pqVar3.i = null;
                }
            }
        } finally {
            workDatabase2.endTransaction();
        }
    }

    public void run() {
        boolean z;
        String str;
        File file;
        pq pqVar = this.g;
        if (pqVar.j == null) {
            synchronized (pq.n) {
                if (pqVar.j == null) {
                    pqVar.e();
                    if (pqVar.j == null) {
                        Objects.requireNonNull(pqVar.b);
                        if (!TextUtils.isEmpty(null)) {
                            throw new IllegalStateException("Invalid multiprocess configuration. Define an `implementation` dependency on :work:work-multiprocess library");
                        }
                    }
                }
            }
        }
        if (pqVar.j == null) {
            z = true;
        } else {
            tp c = tp.c();
            String str2 = i;
            c.a(str2, "Found a remote implementation for WorkManager", new Throwable[0]);
            z = et.a(this.f, this.g.b);
            tp.c().a(str2, String.format("Is default app process = %s", Boolean.valueOf(z)), new Throwable[0]);
        }
        if (z) {
            while (true) {
                Context context = this.f;
                String str3 = oq.f2723a;
                File databasePath = context.getDatabasePath("androidx.work.workdb");
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 23 && databasePath.exists()) {
                    tp.c().a(oq.f2723a, "Migrating WorkDatabase to the no-backup directory", new Throwable[0]);
                    HashMap hashMap = new HashMap();
                    if (i2 >= 23) {
                        File databasePath2 = context.getDatabasePath("androidx.work.workdb");
                        if (i2 < 23) {
                            file = context.getDatabasePath("androidx.work.workdb");
                        } else {
                            file = new File(context.getNoBackupFilesDir(), "androidx.work.workdb");
                        }
                        hashMap.put(databasePath2, file);
                        String[] strArr = oq.b;
                        for (String str4 : strArr) {
                            hashMap.put(new File(databasePath2.getPath() + str4), new File(file.getPath() + str4));
                        }
                    }
                    for (File file2 : hashMap.keySet()) {
                        File file3 = (File) hashMap.get(file2);
                        if (file2.exists() && file3 != null) {
                            if (file3.exists()) {
                                tp.c().f(oq.f2723a, String.format("Over-writing contents of %s", file3), new Throwable[0]);
                            }
                            if (file2.renameTo(file3)) {
                                str = String.format("Migrated %s to %s", file2, file3);
                            } else {
                                str = String.format("Renaming %s to %s failed", file2, file3);
                            }
                            tp.c().a(oq.f2723a, str, new Throwable[0]);
                        }
                    }
                }
                tp.c().a(i, "Performing cleanup operations.", new Throwable[0]);
                try {
                    a();
                    return;
                } catch (SQLiteAccessPermException | SQLiteCantOpenDatabaseException | SQLiteConstraintException | SQLiteDatabaseCorruptException | SQLiteDatabaseLockedException | SQLiteTableLockedException e) {
                    int i3 = this.h + 1;
                    this.h = i3;
                    if (i3 >= 3) {
                        tp.c().b(i, "The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e);
                        IllegalStateException illegalStateException = new IllegalStateException("The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e);
                        Objects.requireNonNull(this.g.b);
                        throw illegalStateException;
                    }
                    tp.c().a(i, String.format("Retrying after %s", Long.valueOf(((long) i3) * 300)), e);
                    try {
                        Thread.sleep(((long) this.h) * 300);
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }
    }
}
