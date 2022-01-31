package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;

/* renamed from: cc6  reason: default package */
/* compiled from: EventLoop.common.kt */
public abstract class cc6 extends dc6 implements tb6 {
    public static final /* synthetic */ AtomicReferenceFieldUpdater j = AtomicReferenceFieldUpdater.newUpdater(cc6.class, Object.class, "_queue");
    public static final /* synthetic */ AtomicReferenceFieldUpdater k = AtomicReferenceFieldUpdater.newUpdater(cc6.class, Object.class, "_delayed");
    private volatile /* synthetic */ Object _delayed = null;
    private volatile /* synthetic */ int _isCompleted = 0;
    private volatile /* synthetic */ Object _queue = null;

    /* renamed from: cc6$a */
    /* compiled from: EventLoop.common.kt */
    public final class a extends b {
        public final ra6<s56> i;

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: ra6<? super s56> */
        /* JADX WARN: Multi-variable type inference failed */
        public a(long j2, ra6<? super s56> ra6) {
            super(j2);
            this.i = ra6;
        }

        public void run() {
            this.i.m(cc6.this, s56.f3190a);
        }

        @Override // defpackage.cc6.b
        public String toString() {
            return n86.j(super.toString(), this.i);
        }
    }

    /* renamed from: cc6$b */
    /* compiled from: EventLoop.common.kt */
    public static abstract class b implements Runnable, Comparable<b>, yb6, hg6 {
        public long f;
        public Object g;
        public int h = -1;

        public b(long j) {
            this.f = j;
        }

        @Override // defpackage.hg6
        public void a(gg6<?> gg6) {
            if (this.g != fc6.f1114a) {
                this.g = gg6;
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        @Override // defpackage.hg6
        public gg6<?> c() {
            Object obj = this.g;
            if (obj instanceof gg6) {
                return (gg6) obj;
            }
            return null;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // java.lang.Comparable
        public int compareTo(b bVar) {
            int i = ((this.f - bVar.f) > 0 ? 1 : ((this.f - bVar.f) == 0 ? 0 : -1));
            if (i > 0) {
                return 1;
            }
            return i < 0 ? -1 : 0;
        }

        @Override // defpackage.hg6
        public void g(int i) {
            this.h = i;
        }

        @Override // defpackage.hg6
        public int getIndex() {
            return this.h;
        }

        @Override // defpackage.yb6
        public final synchronized void h() {
            Object obj = this.g;
            dg6 dg6 = fc6.f1114a;
            if (obj != dg6) {
                c cVar = obj instanceof c ? (c) obj : null;
                if (cVar != null) {
                    synchronized (cVar) {
                        if (c() != null) {
                            cVar.d(getIndex());
                        }
                    }
                }
                this.g = dg6;
            }
        }

        public String toString() {
            StringBuilder i0 = hj1.i0("Delayed[nanos=");
            i0.append(this.f);
            i0.append(']');
            return i0.toString();
        }
    }

    /* renamed from: cc6$c */
    /* compiled from: EventLoop.common.kt */
    public static final class c extends gg6<b> {
        public long b;

        public c(long j) {
            this.b = j;
        }
    }

    public final void P(Runnable runnable) {
        if (T(runnable)) {
            Thread M = M();
            if (Thread.currentThread() != M) {
                LockSupport.unpark(M);
                return;
            }
            return;
        }
        pb6.l.P(runnable);
    }

    public final boolean T(Runnable runnable) {
        while (true) {
            Object obj = this._queue;
            if (this._isCompleted != 0) {
                return false;
            }
            if (obj == null) {
                if (j.compareAndSet(this, null, runnable)) {
                    return true;
                }
            } else if (obj instanceof wf6) {
                wf6 wf6 = (wf6) obj;
                int a2 = wf6.a(runnable);
                if (a2 == 0) {
                    return true;
                }
                if (a2 == 1) {
                    j.compareAndSet(this, obj, wf6.e());
                } else if (a2 == 2) {
                    return false;
                }
            } else if (obj == fc6.b) {
                return false;
            } else {
                wf6 wf62 = new wf6(8, true);
                wf62.a((Runnable) obj);
                wf62.a(runnable);
                if (j.compareAndSet(this, obj, wf62)) {
                    return true;
                }
            }
        }
    }

    public boolean V() {
        lf6<vb6<?>> lf6 = this.i;
        if (!(lf6 == null || lf6.b == lf6.c)) {
            return false;
        }
        c cVar = (c) this._delayed;
        if (cVar != null && !cVar.c()) {
            return false;
        }
        Object obj = this._queue;
        if (obj == null) {
            return true;
        }
        if (obj instanceof wf6) {
            return ((wf6) obj).d();
        }
        if (obj == fc6.b) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0052, code lost:
        r8 = null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0052 A[EDGE_INSN: B:80:0x0052->B:32:0x0052 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:90:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long X() {
        /*
        // Method dump skipped, instructions count: 218
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.cc6.X():long");
    }

    public final void Z() {
        this._queue = null;
        this._delayed = null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x007d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a0(long r13, defpackage.cc6.b r15) {
        /*
        // Method dump skipped, instructions count: 169
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.cc6.a0(long, cc6$b):void");
    }

    @Override // defpackage.tb6
    public void g(long j2, ra6<? super s56> ra6) {
        long j3 = 0;
        if (j2 > 0) {
            j3 = j2 >= 9223372036854L ? Long.MAX_VALUE : 1000000 * j2;
        }
        if (j3 < 4611686018427387903L) {
            long nanoTime = System.nanoTime();
            a aVar = new a(j3 + nanoTime, ra6);
            ra6.g(new zb6(aVar));
            a0(nanoTime, aVar);
        }
    }

    @Override // defpackage.kb6
    public final void m(m66 m66, Runnable runnable) {
        P(runnable);
    }

    @Override // defpackage.bc6
    public void shutdown() {
        md6 md6 = md6.f2360a;
        md6.b.set(null);
        this._isCompleted = 1;
        dg6 dg6 = fc6.b;
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                if (j.compareAndSet(this, null, dg6)) {
                    break;
                }
            } else if (obj instanceof wf6) {
                ((wf6) obj).b();
                break;
            } else if (obj == dg6) {
                break;
            } else {
                wf6 wf6 = new wf6(8, true);
                wf6.a((Runnable) obj);
                if (j.compareAndSet(this, obj, wf6)) {
                    break;
                }
            }
        }
        do {
        } while (X() <= 0);
        long nanoTime = System.nanoTime();
        while (true) {
            c cVar = (c) this._delayed;
            b bVar = cVar == null ? null : (b) cVar.e();
            if (bVar != null) {
                pb6.l.a0(nanoTime, bVar);
            } else {
                return;
            }
        }
    }
}
