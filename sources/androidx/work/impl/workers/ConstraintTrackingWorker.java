package androidx.work.impl.workers;

import android.content.Context;
import android.text.TextUtils;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import java.util.Collections;
import java.util.List;

public class ConstraintTrackingWorker extends ListenableWorker implements gr {
    public static final String o = tp.e("ConstraintTrkngWrkr");
    public WorkerParameters j;
    public final Object k = new Object();
    public volatile boolean l = false;
    public ot<ListenableWorker.a> m = new ot<>();
    public ListenableWorker n;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            ConstraintTrackingWorker constraintTrackingWorker = ConstraintTrackingWorker.this;
            String b = constraintTrackingWorker.g.b.b("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME");
            if (TextUtils.isEmpty(b)) {
                tp.c().b(ConstraintTrackingWorker.o, "No worker to delegate to.", new Throwable[0]);
                constraintTrackingWorker.g();
                return;
            }
            ListenableWorker a2 = constraintTrackingWorker.g.d.a(constraintTrackingWorker.f, b, constraintTrackingWorker.j);
            constraintTrackingWorker.n = a2;
            if (a2 == null) {
                tp.c().a(ConstraintTrackingWorker.o, "No worker to delegate to.", new Throwable[0]);
                constraintTrackingWorker.g();
                return;
            }
            rs i = ((ts) pq.a(constraintTrackingWorker.f).c.f()).i(constraintTrackingWorker.g.f261a.toString());
            if (i == null) {
                constraintTrackingWorker.g();
                return;
            }
            Context context = constraintTrackingWorker.f;
            hr hrVar = new hr(context, pq.a(context).d, constraintTrackingWorker);
            hrVar.b(Collections.singletonList(i));
            if (hrVar.a(constraintTrackingWorker.g.f261a.toString())) {
                tp.c().a(ConstraintTrackingWorker.o, String.format("Constraints met for delegate %s", b), new Throwable[0]);
                try {
                    gy4<ListenableWorker.a> d = constraintTrackingWorker.n.d();
                    d.c(new rt(constraintTrackingWorker, d), constraintTrackingWorker.g.c);
                } catch (Throwable th) {
                    tp c = tp.c();
                    String str = ConstraintTrackingWorker.o;
                    c.a(str, String.format("Delegated worker %s threw exception in startWork.", b), th);
                    synchronized (constraintTrackingWorker.k) {
                        if (constraintTrackingWorker.l) {
                            tp.c().a(str, "Constraints were unmet, Retrying.", new Throwable[0]);
                            constraintTrackingWorker.h();
                        } else {
                            constraintTrackingWorker.g();
                        }
                    }
                }
            } else {
                tp.c().a(ConstraintTrackingWorker.o, String.format("Constraints not met for delegate %s. Requesting retry.", b), new Throwable[0]);
                constraintTrackingWorker.h();
            }
        }
    }

    public ConstraintTrackingWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.j = workerParameters;
    }

    @Override // androidx.work.ListenableWorker
    public boolean a() {
        ListenableWorker listenableWorker = this.n;
        return listenableWorker != null && listenableWorker.a();
    }

    @Override // defpackage.gr
    public void b(List<String> list) {
        tp.c().a(o, String.format("Constraints changed for %s", list), new Throwable[0]);
        synchronized (this.k) {
            this.l = true;
        }
    }

    @Override // androidx.work.ListenableWorker
    public void c() {
        ListenableWorker listenableWorker = this.n;
        if (listenableWorker != null && !listenableWorker.h) {
            this.n.e();
        }
    }

    @Override // androidx.work.ListenableWorker
    public gy4<ListenableWorker.a> d() {
        this.g.c.execute(new a());
        return this.m;
    }

    @Override // defpackage.gr
    public void f(List<String> list) {
    }

    public void g() {
        this.m.j(new ListenableWorker.a.C0002a());
    }

    public void h() {
        this.m.j(new ListenableWorker.a.b());
    }
}
