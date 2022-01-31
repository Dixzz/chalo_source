package defpackage;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: sq  reason: default package */
/* compiled from: WorkerWrapper */
public class sq implements Runnable {
    public static final String y = tp.e("WorkerWrapper");
    public Context f;
    public String g;
    public List<iq> h;
    public WorkerParameters.a i;
    public rs j;
    public ListenableWorker k;
    public ListenableWorker.a l = new ListenableWorker.a.C0002a();
    public kp m;
    public pt n;
    public xr o;
    public WorkDatabase p;
    public ss q;
    public ds r;
    public vs s;
    public List<String> t;
    public String u;
    public ot<Boolean> v = new ot<>();
    public gy4<ListenableWorker.a> w = null;
    public volatile boolean x;

    /* renamed from: sq$a */
    /* compiled from: WorkerWrapper */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Context f3242a;
        public xr b;
        public pt c;
        public kp d;
        public WorkDatabase e;
        public String f;
        public List<iq> g;
        public WorkerParameters.a h = new WorkerParameters.a();

        public a(Context context, kp kpVar, pt ptVar, xr xrVar, WorkDatabase workDatabase, String str) {
            this.f3242a = context.getApplicationContext();
            this.c = ptVar;
            this.b = xrVar;
            this.d = kpVar;
            this.e = workDatabase;
            this.f = str;
        }
    }

    public sq(a aVar) {
        this.f = aVar.f3242a;
        this.n = aVar.c;
        this.o = aVar.b;
        this.g = aVar.f;
        this.h = aVar.g;
        this.i = aVar.h;
        this.k = null;
        this.m = aVar.d;
        WorkDatabase workDatabase = aVar.e;
        this.p = workDatabase;
        this.q = workDatabase.f();
        this.r = this.p.a();
        this.s = this.p.g();
    }

    public final void a(ListenableWorker.a aVar) {
        if (aVar instanceof ListenableWorker.a.c) {
            tp.c().d(y, String.format("Worker result SUCCESS for %s", this.u), new Throwable[0]);
            if (this.j.c()) {
                e();
                return;
            }
            this.p.beginTransaction();
            try {
                ss ssVar = this.q;
                ((ts) ssVar).p(zp.SUCCEEDED, this.g);
                np npVar = ((ListenableWorker.a.c) this.l).f260a;
                ((ts) this.q).n(this.g, npVar);
                long currentTimeMillis = System.currentTimeMillis();
                Iterator it = ((ArrayList) ((es) this.r).a(this.g)).iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    if (((ts) this.q).g(str) == zp.BLOCKED && ((es) this.r).b(str)) {
                        tp.c().d(y, String.format("Setting status to enqueued for %s", str), new Throwable[0]);
                        ss ssVar2 = this.q;
                        ((ts) ssVar2).p(zp.ENQUEUED, str);
                        ((ts) this.q).o(str, currentTimeMillis);
                    }
                }
                this.p.setTransactionSuccessful();
            } finally {
                this.p.endTransaction();
                f(false);
            }
        } else if (aVar instanceof ListenableWorker.a.b) {
            tp.c().d(y, String.format("Worker result RETRY for %s", this.u), new Throwable[0]);
            d();
        } else {
            tp.c().d(y, String.format("Worker result FAILURE for %s", this.u), new Throwable[0]);
            if (this.j.c()) {
                e();
            } else {
                h();
            }
        }
    }

    public final void b(String str) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (!linkedList.isEmpty()) {
            String str2 = (String) linkedList.remove();
            if (((ts) this.q).g(str2) != zp.CANCELLED) {
                ss ssVar = this.q;
                ((ts) ssVar).p(zp.FAILED, str2);
            }
            linkedList.addAll(((es) this.r).a(str2));
        }
    }

    public void c() {
        if (!i()) {
            this.p.beginTransaction();
            try {
                zp g2 = ((ts) this.q).g(this.g);
                ((qs) this.p.e()).a(this.g);
                if (g2 == null) {
                    f(false);
                } else if (g2 == zp.RUNNING) {
                    a(this.l);
                } else if (!g2.isFinished()) {
                    d();
                }
                this.p.setTransactionSuccessful();
            } finally {
                this.p.endTransaction();
            }
        }
        List<iq> list = this.h;
        if (list != null) {
            for (iq iqVar : list) {
                iqVar.e(this.g);
            }
            jq.a(this.m, this.p, this.h);
        }
    }

    public final void d() {
        this.p.beginTransaction();
        try {
            ss ssVar = this.q;
            ((ts) ssVar).p(zp.ENQUEUED, this.g);
            ((ts) this.q).o(this.g, System.currentTimeMillis());
            ((ts) this.q).l(this.g, -1);
            this.p.setTransactionSuccessful();
        } finally {
            this.p.endTransaction();
            f(true);
        }
    }

    public final void e() {
        this.p.beginTransaction();
        try {
            ((ts) this.q).o(this.g, System.currentTimeMillis());
            ss ssVar = this.q;
            ((ts) ssVar).p(zp.ENQUEUED, this.g);
            ((ts) this.q).m(this.g);
            ((ts) this.q).l(this.g, -1);
            this.p.setTransactionSuccessful();
        } finally {
            this.p.endTransaction();
            f(false);
        }
    }

    /* JADX INFO: finally extract failed */
    public final void f(boolean z) {
        ListenableWorker listenableWorker;
        this.p.beginTransaction();
        try {
            if (((ArrayList) ((ts) this.p.f()).c()).isEmpty()) {
                ct.a(this.f, RescheduleReceiver.class, false);
            }
            if (z) {
                ((ts) this.q).p(zp.ENQUEUED, this.g);
                ((ts) this.q).l(this.g, -1);
            }
            if (!(this.j == null || (listenableWorker = this.k) == null || !listenableWorker.a())) {
                xr xrVar = this.o;
                String str = this.g;
                hq hqVar = (hq) xrVar;
                synchronized (hqVar.o) {
                    hqVar.j.remove(str);
                    hqVar.g();
                }
            }
            this.p.setTransactionSuccessful();
            this.p.endTransaction();
            this.v.j(Boolean.valueOf(z));
        } catch (Throwable th) {
            this.p.endTransaction();
            throw th;
        }
    }

    public final void g() {
        zp g2 = ((ts) this.q).g(this.g);
        if (g2 == zp.RUNNING) {
            tp.c().a(y, String.format("Status for %s is RUNNING;not doing any work and rescheduling for later execution", this.g), new Throwable[0]);
            f(true);
            return;
        }
        tp.c().a(y, String.format("Status for %s is %s; not doing any work", this.g, g2), new Throwable[0]);
        f(false);
    }

    public void h() {
        this.p.beginTransaction();
        try {
            b(this.g);
            ((ts) this.q).n(this.g, ((ListenableWorker.a.C0002a) this.l).f259a);
            this.p.setTransactionSuccessful();
        } finally {
            this.p.endTransaction();
            f(false);
        }
    }

    public final boolean i() {
        if (!this.x) {
            return false;
        }
        tp.c().a(y, String.format("Work interrupted for %s", this.u), new Throwable[0]);
        zp g2 = ((ts) this.q).g(this.g);
        if (g2 == null) {
            f(false);
        } else {
            f(!g2.isFinished());
        }
        return true;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00bf, code lost:
        if ((r0.b == r3 && r0.k > 0) != false) goto L_0x00c1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
        // Method dump skipped, instructions count: 714
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.sq.run():void");
    }
}
