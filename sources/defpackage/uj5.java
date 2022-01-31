package defpackage;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* renamed from: uj5  reason: default package */
/* compiled from: CancelableOperation */
public class uj5 implements tj5, Runnable {
    public boolean f;
    public boolean g;
    public boolean h;
    public final Handler i;
    public final Runnable j;
    public final List<tj5> k;
    public final List<Runnable> l;

    /* renamed from: uj5$a */
    /* compiled from: CancelableOperation */
    public class a implements Runnable {
        public a() {
        }

        public void run() {
            synchronized (uj5.this) {
                if (!uj5.this.c()) {
                    uj5.this.d();
                    uj5 uj5 = uj5.this;
                    uj5.f = true;
                    for (Runnable runnable : uj5.l) {
                        runnable.run();
                    }
                    uj5.this.k.clear();
                    uj5.this.l.clear();
                }
            }
        }
    }

    /* renamed from: uj5$b */
    /* compiled from: CancelableOperation */
    public class b implements Runnable {
        public b() {
        }

        public void run() {
            Objects.requireNonNull(uj5.this);
        }
    }

    public uj5() {
        this(null);
    }

    public uj5 a(Runnable runnable) {
        synchronized (this) {
            if (this.f) {
                runnable.run();
            } else {
                this.l.add(runnable);
            }
        }
        return this;
    }

    public final boolean b() {
        boolean z;
        synchronized (this) {
            z = this.h;
        }
        return z;
    }

    public final boolean c() {
        boolean z;
        synchronized (this) {
            if (!this.f) {
                if (!this.h) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    @Override // defpackage.tj5
    public final boolean cancel() {
        return cancel(false);
    }

    public void d() {
    }

    public final void run() {
        synchronized (this) {
            if (!c()) {
                if (!this.g) {
                    this.g = true;
                    this.i.post(this.j);
                }
            }
        }
    }

    public uj5(Looper looper) {
        Handler handler;
        this.f = false;
        this.g = false;
        this.h = false;
        this.k = new ArrayList();
        this.l = new ArrayList();
        if (looper != null) {
            this.i = new Handler(looper);
        } else {
            if (Looper.myLooper() == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            this.i = handler;
        }
        this.j = new a();
    }

    @Override // defpackage.tj5
    public final boolean cancel(boolean z) {
        synchronized (this) {
            if (c()) {
                return false;
            }
            this.h = true;
            this.i.removeCallbacks(this.j);
            this.i.post(new b());
            for (tj5 tj5 : this.k) {
                tj5.cancel(z);
            }
            this.k.clear();
            this.l.clear();
            return true;
        }
    }
}
