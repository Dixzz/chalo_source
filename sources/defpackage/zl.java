package defpackage;

import android.annotation.SuppressLint;
import androidx.lifecycle.LiveData;
import defpackage.ul;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: zl  reason: default package */
/* compiled from: RoomTrackingLiveData */
public class zl<T> extends LiveData<T> {
    public final wl l;
    public final boolean m;
    public final Callable<T> n;
    public final tl o;
    public final ul.c p;
    public final AtomicBoolean q = new AtomicBoolean(true);
    public final AtomicBoolean r = new AtomicBoolean(false);
    public final AtomicBoolean s = new AtomicBoolean(false);
    public final Runnable t = new a();
    public final Runnable u = new b();

    /* renamed from: zl$a */
    /* compiled from: RoomTrackingLiveData */
    public class a implements Runnable {
        public a() {
        }

        public void run() {
            boolean z;
            if (zl.this.s.compareAndSet(false, true)) {
                ul invalidationTracker = zl.this.l.getInvalidationTracker();
                ul.c cVar = zl.this.p;
                Objects.requireNonNull(invalidationTracker);
                invalidationTracker.a(new ul.e(invalidationTracker, cVar));
            }
            do {
                if (zl.this.r.compareAndSet(false, true)) {
                    T t = null;
                    z = false;
                    while (zl.this.q.compareAndSet(true, false)) {
                        try {
                            try {
                                t = zl.this.n.call();
                                z = true;
                            } catch (Exception e) {
                                throw new RuntimeException("Exception while computing database live data.", e);
                            }
                        } finally {
                            zl.this.r.set(false);
                        }
                    }
                    if (z) {
                        zl.this.j(t);
                    }
                } else {
                    z = false;
                }
                if (!z) {
                    return;
                }
            } while (zl.this.q.get());
        }
    }

    /* renamed from: zl$b */
    /* compiled from: RoomTrackingLiveData */
    public class b implements Runnable {
        public b() {
        }

        public void run() {
            Executor executor;
            boolean e = zl.this.e();
            if (zl.this.q.compareAndSet(false, true) && e) {
                zl zlVar = zl.this;
                if (zlVar.m) {
                    executor = zlVar.l.getTransactionExecutor();
                } else {
                    executor = zlVar.l.getQueryExecutor();
                }
                executor.execute(zl.this.t);
            }
        }
    }

    /* renamed from: zl$c */
    /* compiled from: RoomTrackingLiveData */
    public class c extends ul.c {
        public c(String[] strArr) {
            super(strArr);
        }

        @Override // defpackage.ul.c
        public void a(Set<String> set) {
            c2 d = c2.d();
            Runnable runnable = zl.this.u;
            if (d.b()) {
                runnable.run();
            } else {
                d.c(runnable);
            }
        }
    }

    @SuppressLint({"RestrictedApi"})
    public zl(wl wlVar, tl tlVar, boolean z, Callable<T> callable, String[] strArr) {
        this.l = wlVar;
        this.m = z;
        this.n = callable;
        this.o = tlVar;
        this.p = new c(strArr);
    }

    @Override // androidx.lifecycle.LiveData
    public void h() {
        Executor executor;
        this.o.f3372a.add(this);
        if (this.m) {
            executor = this.l.getTransactionExecutor();
        } else {
            executor = this.l.getQueryExecutor();
        }
        executor.execute(this.t);
    }

    @Override // androidx.lifecycle.LiveData
    public void i() {
        this.o.f3372a.remove(this);
    }
}
