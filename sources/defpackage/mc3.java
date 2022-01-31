package defpackage;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.os.PersistableBundle;
import android.os.SystemClock;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* renamed from: mc3  reason: default package */
public final class mc3 extends yb3 {
    public boolean h;
    public final jc3 i;
    public final ud3 j;
    public final td3 k;
    public final ec3 l;
    public long m = Long.MIN_VALUE;
    public final cd3 n;
    public final cd3 o;
    public final ee3 p;
    public long q;
    public boolean r;

    public mc3(ac3 ac3, cc3 cc3) {
        super(ac3);
        this.k = new td3(ac3);
        this.i = new jc3(ac3);
        this.j = new ud3(ac3);
        this.l = new ec3(ac3);
        this.p = new ee3(this.f.c);
        this.n = new nc3(this, ac3);
        this.o = new oc3(this, ac3);
    }

    @Override // defpackage.yb3
    public final void a0() {
        this.i.Z();
        this.j.Z();
        this.l.Z();
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x004c A[LOOP:1: B:16:0x004c->B:24:?, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0048 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void i0() {
        /*
        // Method dump skipped, instructions count: 132
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.mc3.i0():void");
    }

    public final void j0(gd3 gd3) {
        long j2;
        long j3 = this.q;
        jz1.c();
        g0();
        long j0 = E().j0();
        if (j0 != 0) {
            Objects.requireNonNull((db2) this.f.c);
            j2 = Math.abs(System.currentTimeMillis() - j0);
        } else {
            j2 = -1;
        }
        o("Dispatching local hits. Elapsed time since last dispatch (ms)", Long.valueOf(j2));
        m0();
        try {
            o0();
            E().m0();
            q0();
            if (gd3 != null) {
                gd3.a(null);
            }
            if (this.q != j3) {
                this.k.b();
            }
        } catch (Exception e) {
            L("Local dispatch failed", e);
            E().m0();
            q0();
            if (gd3 != null) {
                gd3.a(e);
            }
        }
    }

    public final void m0() {
        od3 od3;
        if (!this.r && id3.f1506a.f1906a.booleanValue() && !this.l.j0()) {
            if (this.p.b(id3.B.f1906a.longValue())) {
                this.p.a();
                M("Connecting to service");
                ec3 ec3 = this.l;
                Objects.requireNonNull(ec3);
                jz1.c();
                ec3.g0();
                boolean z = true;
                if (ec3.i == null) {
                    gc3 gc3 = ec3.h;
                    Objects.requireNonNull(gc3);
                    jz1.c();
                    Intent intent = new Intent("com.google.android.gms.analytics.service.START");
                    intent.setComponent(new ComponentName("com.google.android.gms", "com.google.android.gms.analytics.service.AnalyticsService"));
                    Context context = gc3.c.f.f146a;
                    intent.putExtra("app_package_name", context.getPackageName());
                    za2 b = za2.b();
                    synchronized (gc3) {
                        od3 = null;
                        gc3.f1239a = null;
                        gc3.b = true;
                        boolean a2 = b.a(context, intent, gc3.c.h, 129);
                        gc3.c.k("Bind to service requested", Boolean.valueOf(a2));
                        if (!a2) {
                            gc3.b = false;
                        } else {
                            try {
                                gc3.wait(id3.A.f1906a.longValue());
                            } catch (InterruptedException unused) {
                                gc3.c.T("Wait for service connect was interrupted");
                            }
                            gc3.b = false;
                            od3 od32 = gc3.f1239a;
                            gc3.f1239a = null;
                            if (od32 == null) {
                                gc3.c.V("Successfully bound to service but never got onServiceConnected callback");
                            }
                            od3 = od32;
                        }
                    }
                    if (od3 != null) {
                        ec3.i = od3;
                        ec3.o0();
                    } else {
                        z = false;
                    }
                }
                if (z) {
                    M("Connected to service");
                    this.p.b = 0;
                    i0();
                }
            }
        }
    }

    public final boolean o0() {
        jz1.c();
        g0();
        M("Dispatching a batch of local hits");
        boolean z = !this.l.j0();
        boolean z2 = !this.j.x0();
        if (!z || !z2) {
            long max = (long) Math.max(ad3.c(), id3.i.f1906a.intValue());
            ArrayList arrayList = new ArrayList();
            long j2 = 0;
            while (true) {
                try {
                    jc3 jc3 = this.i;
                    jc3.g0();
                    jc3.i0().beginTransaction();
                    arrayList.clear();
                    try {
                        List<nd3> x0 = this.i.x0(max);
                        ArrayList arrayList2 = (ArrayList) x0;
                        if (arrayList2.isEmpty()) {
                            M("Store is empty, nothing to dispatch");
                            x0();
                            try {
                                this.i.setTransactionSuccessful();
                                this.i.endTransaction();
                                return false;
                            } catch (SQLiteException e) {
                                L("Failed to commit local dispatch transaction", e);
                                x0();
                                return false;
                            }
                        } else {
                            k("Hits loaded from store. count", Integer.valueOf(arrayList2.size()));
                            Iterator it = arrayList2.iterator();
                            while (it.hasNext()) {
                                if (((nd3) it.next()).c == j2) {
                                    K("Database contains successfully uploaded hit", Long.valueOf(j2), Integer.valueOf(arrayList2.size()));
                                    x0();
                                    try {
                                        return false;
                                    } catch (SQLiteException e2) {
                                        L("Failed to commit local dispatch transaction", e2);
                                        x0();
                                        return false;
                                    }
                                }
                            }
                            if (this.l.j0()) {
                                M("Service connected, sending hits to the service");
                                while (!arrayList2.isEmpty()) {
                                    nd3 nd3 = (nd3) arrayList2.get(0);
                                    if (!this.l.m0(nd3)) {
                                        break;
                                    }
                                    j2 = Math.max(j2, nd3.c);
                                    arrayList2.remove(nd3);
                                    o("Hit sent do device AnalyticsService for delivery", nd3);
                                    try {
                                        this.i.A0(nd3.c);
                                        arrayList.add(Long.valueOf(nd3.c));
                                    } catch (SQLiteException e3) {
                                        L("Failed to remove hit that was send for delivery", e3);
                                        x0();
                                        try {
                                            this.i.setTransactionSuccessful();
                                            this.i.endTransaction();
                                            return false;
                                        } catch (SQLiteException e4) {
                                            L("Failed to commit local dispatch transaction", e4);
                                            x0();
                                            return false;
                                        }
                                    }
                                }
                            }
                            if (this.j.x0()) {
                                List<Long> w0 = this.j.w0(x0);
                                for (Long l2 : w0) {
                                    j2 = Math.max(j2, l2.longValue());
                                }
                                try {
                                    this.i.o0(w0);
                                    arrayList.addAll(w0);
                                } catch (SQLiteException e5) {
                                    L("Failed to remove successfully uploaded hits", e5);
                                    x0();
                                    try {
                                        this.i.setTransactionSuccessful();
                                        this.i.endTransaction();
                                        return false;
                                    } catch (SQLiteException e6) {
                                        L("Failed to commit local dispatch transaction", e6);
                                        x0();
                                        return false;
                                    }
                                }
                            }
                            if (arrayList.isEmpty()) {
                                try {
                                    this.i.setTransactionSuccessful();
                                    this.i.endTransaction();
                                    return false;
                                } catch (SQLiteException e7) {
                                    L("Failed to commit local dispatch transaction", e7);
                                    x0();
                                    return false;
                                }
                            } else {
                                try {
                                    this.i.setTransactionSuccessful();
                                    this.i.endTransaction();
                                } catch (SQLiteException e8) {
                                    L("Failed to commit local dispatch transaction", e8);
                                    x0();
                                    return false;
                                }
                            }
                        }
                    } catch (SQLiteException e9) {
                        J("Failed to read hits from persisted store", e9);
                        x0();
                        try {
                            this.i.setTransactionSuccessful();
                            this.i.endTransaction();
                            return false;
                        } catch (SQLiteException e10) {
                            L("Failed to commit local dispatch transaction", e10);
                            x0();
                            return false;
                        }
                    }
                } finally {
                    try {
                        this.i.setTransactionSuccessful();
                        this.i.endTransaction();
                    } catch (SQLiteException e11) {
                        L("Failed to commit local dispatch transaction", e11);
                        x0();
                        return false;
                    }
                }
            }
        } else {
            M("No network or service available. Will retry later");
            return false;
        }
    }

    public final void q0() {
        long j2;
        long j3;
        jz1.c();
        g0();
        boolean z = true;
        long j4 = 0;
        if (!(!this.r && y0() > 0)) {
            this.k.a();
            x0();
        } else if (this.i.j0()) {
            this.k.a();
            x0();
        } else {
            if (!id3.y.f1906a.booleanValue()) {
                td3 td3 = this.k;
                td3.f3337a.c();
                td3.f3337a.e();
                if (!td3.b) {
                    Context context = td3.f3337a.f146a;
                    context.registerReceiver(td3, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                    IntentFilter intentFilter = new IntentFilter("com.google.analytics.RADIO_POWERED");
                    intentFilter.addCategory(context.getPackageName());
                    context.registerReceiver(td3, intentFilter);
                    td3.c = td3.c();
                    td3.f3337a.c().k("Registering connectivity change receiver. Network connected", Boolean.valueOf(td3.c));
                    td3.b = true;
                }
                td3 td32 = this.k;
                if (!td32.b) {
                    td32.f3337a.c().T("Connectivity unknown. Receiver not registered");
                }
                z = td32.c;
            }
            if (z) {
                w0();
                long y0 = y0();
                long j0 = E().j0();
                if (j0 != 0) {
                    Objects.requireNonNull((db2) this.f.c);
                    j2 = y0 - Math.abs(System.currentTimeMillis() - j0);
                    if (j2 <= 0) {
                        j2 = Math.min(id3.e.f1906a.longValue(), y0);
                    }
                } else {
                    j2 = Math.min(id3.e.f1906a.longValue(), y0);
                }
                k("Dispatch scheduled (ms)", Long.valueOf(j2));
                if (this.n.d()) {
                    cd3 cd3 = this.n;
                    if (cd3.c == 0) {
                        j3 = 0;
                    } else {
                        Objects.requireNonNull((db2) cd3.f551a.c);
                        j3 = Math.abs(System.currentTimeMillis() - cd3.c);
                    }
                    long max = Math.max(1L, j2 + j3);
                    cd3 cd32 = this.n;
                    if (cd32.d()) {
                        if (max < 0) {
                            cd32.a();
                            return;
                        }
                        Objects.requireNonNull((db2) cd32.f551a.c);
                        long abs = max - Math.abs(System.currentTimeMillis() - cd32.c);
                        if (abs >= 0) {
                            j4 = abs;
                        }
                        cd32.b().removeCallbacks(cd32.b);
                        if (!cd32.b().postDelayed(cd32.b, j4)) {
                            cd32.f551a.c().L("Failed to adjust delayed post. time", Long.valueOf(j4));
                            return;
                        }
                        return;
                    }
                    return;
                }
                this.n.e(j2);
                return;
            }
            x0();
            w0();
        }
    }

    public final void w0() {
        long j2;
        ac3 ac3 = this.f;
        ac3.a(ac3.h);
        fd3 fd3 = ac3.h;
        if (fd3.h && !fd3.i) {
            jz1.c();
            g0();
            try {
                jc3 jc3 = this.i;
                Objects.requireNonNull(jc3);
                jz1.c();
                jc3.g0();
                j2 = jc3.q0(jc3.l, null);
            } catch (SQLiteException e) {
                L("Failed to get min/max hit times from local store", e);
                j2 = 0;
            }
            if (j2 != 0) {
                Objects.requireNonNull((db2) this.f.c);
                if (Math.abs(System.currentTimeMillis() - j2) <= id3.g.f1906a.longValue()) {
                    k("Dispatch alarm scheduled (ms)", Long.valueOf(ad3.b()));
                    fd3.g0();
                    gj1.o(fd3.h, "Receiver not registered");
                    long b = ad3.b();
                    if (b > 0) {
                        fd3.i0();
                        Objects.requireNonNull((db2) fd3.f.c);
                        long elapsedRealtime = SystemClock.elapsedRealtime() + b;
                        fd3.i = true;
                        id3.E.f1906a.booleanValue();
                        if (Build.VERSION.SDK_INT >= 24) {
                            fd3.M("Scheduling upload with JobScheduler");
                            Context context = fd3.f.f146a;
                            ComponentName componentName = new ComponentName(context, "com.google.android.gms.analytics.AnalyticsJobService");
                            int j0 = fd3.j0();
                            PersistableBundle persistableBundle = new PersistableBundle();
                            persistableBundle.putString("action", "com.google.android.gms.analytics.ANALYTICS_DISPATCH");
                            JobInfo build = new JobInfo.Builder(j0, componentName).setMinimumLatency(b).setOverrideDeadline(b << 1).setExtras(persistableBundle).build();
                            fd3.k("Scheduling job. JobID", Integer.valueOf(j0));
                            Method method = ke3.f2048a;
                            JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
                            if (ke3.f2048a != null) {
                                Objects.requireNonNull((le3) ke3.c);
                            }
                            jobScheduler.schedule(build);
                            return;
                        }
                        fd3.M("Scheduling upload with AlarmManager");
                        fd3.j.setInexactRepeating(2, elapsedRealtime, b, fd3.m0());
                    }
                }
            }
        }
    }

    public final void x0() {
        if (this.n.d()) {
            M("All hits dispatched or no network/service. Going to power save mode");
        }
        this.n.a();
        ac3 ac3 = this.f;
        ac3.a(ac3.h);
        fd3 fd3 = ac3.h;
        if (fd3.i) {
            fd3.i0();
        }
    }

    public final long y0() {
        long j2 = this.m;
        if (j2 != Long.MIN_VALUE) {
            return j2;
        }
        long longValue = id3.d.f1906a.longValue();
        je3 D = D();
        D.g0();
        if (!D.j) {
            return longValue;
        }
        je3 D2 = D();
        D2.g0();
        return ((long) D2.k) * 1000;
    }

    public final boolean z0(String str) {
        return ob2.a(this.f.f146a).f2531a.checkCallingOrSelfPermission(str) == 0;
    }
}
