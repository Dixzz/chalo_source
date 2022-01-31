package defpackage;

import android.content.Context;
import android.content.Intent;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.foreground.SystemForegroundService;
import defpackage.sq;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;

/* renamed from: hq  reason: default package */
/* compiled from: Processor */
public class hq implements fq, xr {
    public static final String p = tp.e("Processor");
    public Context f;
    public kp g;
    public pt h;
    public WorkDatabase i;
    public Map<String, sq> j = new HashMap();
    public Map<String, sq> k = new HashMap();
    public List<iq> l;
    public Set<String> m;
    public final List<fq> n;
    public final Object o;

    /* renamed from: hq$a */
    /* compiled from: Processor */
    public static class a implements Runnable {
        public fq f;
        public String g;
        public gy4<Boolean> h;

        public a(fq fqVar, String str, gy4<Boolean> gy4) {
            this.f = fqVar;
            this.g = str;
            this.h = gy4;
        }

        public void run() {
            boolean z;
            try {
                z = this.h.get().booleanValue();
            } catch (InterruptedException | ExecutionException unused) {
                z = true;
            }
            this.f.d(this.g, z);
        }
    }

    public hq(Context context, kp kpVar, pt ptVar, WorkDatabase workDatabase, List<iq> list) {
        this.f = context;
        this.g = kpVar;
        this.h = ptVar;
        this.i = workDatabase;
        this.l = list;
        this.m = new HashSet();
        this.n = new ArrayList();
        this.o = new Object();
    }

    public static boolean b(String str, sq sqVar) {
        boolean z;
        if (sqVar != null) {
            sqVar.x = true;
            sqVar.i();
            gy4<ListenableWorker.a> gy4 = sqVar.w;
            if (gy4 != null) {
                z = gy4.isDone();
                sqVar.w.cancel(true);
            } else {
                z = false;
            }
            ListenableWorker listenableWorker = sqVar.k;
            if (listenableWorker == null || z) {
                tp.c().a(sq.y, String.format("WorkSpec %s is already done. Not interrupting.", sqVar.j), new Throwable[0]);
            } else {
                listenableWorker.h = true;
                listenableWorker.c();
            }
            tp.c().a(p, String.format("WorkerWrapper interrupted for %s", str), new Throwable[0]);
            return true;
        }
        tp.c().a(p, String.format("WorkerWrapper could not be found for %s", str), new Throwable[0]);
        return false;
    }

    public void a(fq fqVar) {
        synchronized (this.o) {
            this.n.add(fqVar);
        }
    }

    public boolean c(String str) {
        boolean z;
        synchronized (this.o) {
            if (!this.k.containsKey(str)) {
                if (!this.j.containsKey(str)) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    @Override // defpackage.fq
    public void d(String str, boolean z) {
        synchronized (this.o) {
            this.k.remove(str);
            tp.c().a(p, String.format("%s %s executed; reschedule = %s", getClass().getSimpleName(), str, Boolean.valueOf(z)), new Throwable[0]);
            for (fq fqVar : this.n) {
                fqVar.d(str, z);
            }
        }
    }

    public void e(fq fqVar) {
        synchronized (this.o) {
            this.n.remove(fqVar);
        }
    }

    public boolean f(String str, WorkerParameters.a aVar) {
        synchronized (this.o) {
            if (c(str)) {
                tp.c().a(p, String.format("Work %s is already enqueued for processing", str), new Throwable[0]);
                return false;
            }
            sq.a aVar2 = new sq.a(this.f, this.g, this.h, this, this.i, str);
            aVar2.g = this.l;
            if (aVar != null) {
                aVar2.h = aVar;
            }
            sq sqVar = new sq(aVar2);
            ot<Boolean> otVar = sqVar.v;
            otVar.c(new a(this, str, otVar), ((qt) this.h).c);
            this.k.put(str, sqVar);
            ((qt) this.h).f2987a.execute(sqVar);
            tp.c().a(p, String.format("%s: processing %s", hq.class.getSimpleName(), str), new Throwable[0]);
            return true;
        }
    }

    public final void g() {
        synchronized (this.o) {
            if (!(!this.j.isEmpty())) {
                Context context = this.f;
                String str = zr.p;
                Intent intent = new Intent(context, SystemForegroundService.class);
                intent.setAction("ACTION_STOP_FOREGROUND");
                try {
                    this.f.startService(intent);
                } catch (Throwable th) {
                    tp.c().b(p, "Unable to stop foreground service", th);
                }
            }
        }
    }

    public boolean h(String str) {
        boolean b;
        synchronized (this.o) {
            tp.c().a(p, String.format("Processor stopping foreground work %s", str), new Throwable[0]);
            b = b(str, this.j.remove(str));
        }
        return b;
    }

    public boolean i(String str) {
        boolean b;
        synchronized (this.o) {
            tp.c().a(p, String.format("Processor stopping background work %s", str), new Throwable[0]);
            b = b(str, this.k.remove(str));
        }
        return b;
    }
}
