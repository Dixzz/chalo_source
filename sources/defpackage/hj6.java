package defpackage;

import defpackage.ij6;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;
import server.zophop.Constants;

/* renamed from: hj6  reason: default package */
/* compiled from: TaskQueue.kt */
public final class hj6 {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1381a;
    public fj6 b;
    public final List<fj6> c = new ArrayList();
    public boolean d;
    public final ij6 e;
    public final String f;

    public hj6(ij6 ij6, String str) {
        n86.f(ij6, "taskRunner");
        n86.f(str, "name");
        this.e = ij6;
        this.f = str;
    }

    public static /* synthetic */ void d(hj6 hj6, fj6 fj6, long j, int i) {
        if ((i & 2) != 0) {
            j = 0;
        }
        hj6.c(fj6, j);
    }

    public final void a() {
        byte[] bArr = vi6.f3652a;
        synchronized (this.e) {
            if (b()) {
                this.e.e(this);
            }
        }
    }

    public final boolean b() {
        fj6 fj6 = this.b;
        if (fj6 != null) {
            if (fj6 == null) {
                n86.k();
                throw null;
            } else if (fj6.d) {
                this.d = true;
            }
        }
        boolean z = false;
        for (int size = this.c.size() - 1; size >= 0; size--) {
            if (this.c.get(size).d) {
                fj6 fj62 = this.c.get(size);
                Objects.requireNonNull(ij6.j);
                if (ij6.i.isLoggable(Level.FINE)) {
                    ec6.c(fj62, this, "canceled");
                }
                this.c.remove(size);
                z = true;
            }
        }
        return z;
    }

    public final void c(fj6 fj6, long j) {
        n86.f(fj6, "task");
        synchronized (this.e) {
            if (!this.f1381a) {
                if (e(fj6, j, false)) {
                    this.e.e(this);
                }
            } else if (fj6.d) {
                Objects.requireNonNull(ij6.j);
                if (ij6.i.isLoggable(Level.FINE)) {
                    ec6.c(fj6, this, "schedule canceled (queue is shutdown)");
                }
            } else {
                Objects.requireNonNull(ij6.j);
                if (ij6.i.isLoggable(Level.FINE)) {
                    ec6.c(fj6, this, "schedule failed (queue is shutdown)");
                }
                throw new RejectedExecutionException();
            }
        }
    }

    public final boolean e(fj6 fj6, long j, boolean z) {
        String str;
        n86.f(fj6, "task");
        n86.f(this, Constants.QUEUE);
        hj6 hj6 = fj6.f1131a;
        if (hj6 != this) {
            if (hj6 == null) {
                fj6.f1131a = this;
            } else {
                throw new IllegalStateException("task is in multiple queues".toString());
            }
        }
        long c2 = this.e.g.c();
        long j2 = c2 + j;
        int indexOf = this.c.indexOf(fj6);
        if (indexOf != -1) {
            if (fj6.b <= j2) {
                ij6.b bVar = ij6.j;
                if (ij6.i.isLoggable(Level.FINE)) {
                    ec6.c(fj6, this, "already scheduled");
                }
                return false;
            }
            this.c.remove(indexOf);
        }
        fj6.b = j2;
        ij6.b bVar2 = ij6.j;
        if (ij6.i.isLoggable(Level.FINE)) {
            if (z) {
                StringBuilder i0 = hj1.i0("run again after ");
                i0.append(ec6.o(j2 - c2));
                str = i0.toString();
            } else {
                StringBuilder i02 = hj1.i0("scheduled after ");
                i02.append(ec6.o(j2 - c2));
                str = i02.toString();
            }
            ec6.c(fj6, this, str);
        }
        Iterator<fj6> it = this.c.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            if (it.next().b - c2 > j) {
                break;
            }
            i++;
        }
        if (i == -1) {
            i = this.c.size();
        }
        this.c.add(i, fj6);
        if (i == 0) {
            return true;
        }
        return false;
    }

    public final void f() {
        byte[] bArr = vi6.f3652a;
        synchronized (this.e) {
            this.f1381a = true;
            if (b()) {
                this.e.e(this);
            }
        }
    }

    public String toString() {
        return this.f;
    }
}
