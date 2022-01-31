package defpackage;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* renamed from: wf6  reason: default package */
/* compiled from: LockFreeTaskQueue.kt */
public final class wf6<E> {
    public static final a e = new a(null);
    public static final /* synthetic */ AtomicReferenceFieldUpdater f = AtomicReferenceFieldUpdater.newUpdater(wf6.class, Object.class, "_next");
    public static final /* synthetic */ AtomicLongFieldUpdater g = AtomicLongFieldUpdater.newUpdater(wf6.class, "_state");
    public static final dg6 h = new dg6("REMOVE_FROZEN");
    private volatile /* synthetic */ Object _next = null;
    private volatile /* synthetic */ long _state = 0;

    /* renamed from: a  reason: collision with root package name */
    public final int f3773a;
    public final boolean b;
    public final int c;
    public /* synthetic */ AtomicReferenceArray d;

    /* renamed from: wf6$a */
    /* compiled from: LockFreeTaskQueue.kt */
    public static final class a {
        public a(j86 j86) {
        }
    }

    /* renamed from: wf6$b */
    /* compiled from: LockFreeTaskQueue.kt */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f3774a;

        public b(int i) {
            this.f3774a = i;
        }
    }

    public wf6(int i, boolean z) {
        this.f3773a = i;
        this.b = z;
        int i2 = i - 1;
        this.c = i2;
        this.d = new AtomicReferenceArray(i);
        boolean z2 = false;
        if (i2 <= 1073741823) {
            if (!((i & i2) == 0 ? true : z2)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final int a(E e2) {
        while (true) {
            long j = this._state;
            if ((3458764513820540928L & j) != 0) {
                return (2305843009213693952L & j) != 0 ? 2 : 1;
            }
            int i = (int) ((1073741823 & j) >> 0);
            int i2 = (int) ((1152921503533105152L & j) >> 30);
            int i3 = this.c;
            if (((i2 + 2) & i3) == (i & i3)) {
                return 1;
            }
            if (!this.b && this.d.get(i2 & i3) != null) {
                int i4 = this.f3773a;
                if (i4 < 1024 || ((i2 - i) & 1073741823) > (i4 >> 1)) {
                    return 1;
                }
            } else if (g.compareAndSet(this, j, (-1152921503533105153L & j) | (((long) ((i2 + 1) & 1073741823)) << 30))) {
                this.d.set(i2 & i3, e2);
                wf6<E> wf6 = this;
                while ((wf6._state & 1152921504606846976L) != 0) {
                    wf6 = wf6.e();
                    Object obj = wf6.d.get(wf6.c & i2);
                    if (!(obj instanceof b) || ((b) obj).f3774a != i2) {
                        wf6 = null;
                        continue;
                    } else {
                        wf6.d.set(wf6.c & i2, e2);
                        continue;
                    }
                    if (wf6 == null) {
                        break;
                    }
                }
                return 0;
            }
        }
        return 1;
    }

    public final boolean b() {
        long j;
        do {
            j = this._state;
            if ((j & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j) != 0) {
                return false;
            }
        } while (!g.compareAndSet(this, j, j | 2305843009213693952L));
        return true;
    }

    public final int c() {
        long j = this._state;
        return 1073741823 & (((int) ((j & 1152921503533105152L) >> 30)) - ((int) ((1073741823 & j) >> 0)));
    }

    public final boolean d() {
        long j = this._state;
        return ((int) ((1073741823 & j) >> 0)) == ((int) ((j & 1152921503533105152L) >> 30));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v2, resolved type: java.util.concurrent.atomic.AtomicReferenceArray */
    /* JADX WARN: Multi-variable type inference failed */
    public final wf6<E> e() {
        long j;
        while (true) {
            j = this._state;
            if ((j & 1152921504606846976L) == 0) {
                long j2 = j | 1152921504606846976L;
                if (g.compareAndSet(this, j, j2)) {
                    j = j2;
                    break;
                }
            } else {
                break;
            }
        }
        while (true) {
            wf6<E> wf6 = (wf6) this._next;
            if (wf6 != null) {
                return wf6;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f;
            wf6 wf62 = new wf6(this.f3773a * 2, this.b);
            int i = (int) ((1073741823 & j) >> 0);
            int i2 = (int) ((1152921503533105152L & j) >> 30);
            while (true) {
                int i3 = this.c;
                int i4 = i & i3;
                if (i4 == (i3 & i2)) {
                    break;
                }
                Object obj = this.d.get(i4);
                if (obj == null) {
                    obj = new b(i);
                }
                wf62.d.set(wf62.c & i, obj);
                i++;
            }
            wf62._state = -1152921504606846977L & j;
            atomicReferenceFieldUpdater.compareAndSet(this, null, wf62);
        }
    }

    public final Object f() {
        while (true) {
            long j = this._state;
            if ((j & 1152921504606846976L) != 0) {
                return h;
            }
            int i = (int) ((j & 1073741823) >> 0);
            int i2 = this.c;
            int i3 = ((int) ((1152921503533105152L & j) >> 30)) & i2;
            int i4 = i2 & i;
            if (i3 == i4) {
                return null;
            }
            Object obj = this.d.get(i4);
            if (obj == null) {
                if (this.b) {
                    return null;
                }
            } else if (obj instanceof b) {
                return null;
            } else {
                long j2 = ((long) ((i + 1) & 1073741823)) << 0;
                if (g.compareAndSet(this, j, (j & -1073741824) | j2)) {
                    this.d.set(this.c & i, null);
                    return obj;
                } else if (this.b) {
                    wf6<E> wf6 = this;
                    while (true) {
                        long j3 = wf6._state;
                        int i5 = (int) ((j3 & 1073741823) >> 0);
                        if ((j3 & 1152921504606846976L) != 0) {
                            wf6 = wf6.e();
                        } else if (g.compareAndSet(wf6, j3, (j3 & -1073741824) | j2)) {
                            wf6.d.set(wf6.c & i5, null);
                            wf6 = null;
                        } else {
                            continue;
                        }
                        if (wf6 == null) {
                            return obj;
                        }
                    }
                }
            }
        }
    }
}
