package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* renamed from: uf6  reason: default package */
/* compiled from: LockFreeLinkedList.kt */
public class uf6 {
    public static final /* synthetic */ AtomicReferenceFieldUpdater f = AtomicReferenceFieldUpdater.newUpdater(uf6.class, Object.class, "_next");
    public static final /* synthetic */ AtomicReferenceFieldUpdater g = AtomicReferenceFieldUpdater.newUpdater(uf6.class, Object.class, "_prev");
    public static final /* synthetic */ AtomicReferenceFieldUpdater h = AtomicReferenceFieldUpdater.newUpdater(uf6.class, Object.class, "_removedRef");
    public volatile /* synthetic */ Object _next = this;
    public volatile /* synthetic */ Object _prev = this;
    private volatile /* synthetic */ Object _removedRef = null;

    /* renamed from: uf6$a */
    /* compiled from: LockFreeLinkedList.kt */
    public static abstract class a extends nf6<uf6> {
        public final uf6 b;
        public uf6 c;

        public a(uf6 uf6) {
            this.b = uf6;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // defpackage.nf6
        public void b(uf6 uf6, Object obj) {
            uf6 uf62 = uf6;
            boolean z = obj == null;
            uf6 uf63 = z ? this.b : this.c;
            if (uf63 != null && uf6.f.compareAndSet(uf62, this, uf63) && z) {
                uf6 uf64 = this.b;
                uf6 uf65 = this.c;
                n86.c(uf65);
                uf64.l(uf65);
            }
        }
    }

    /* renamed from: uf6$b */
    /* compiled from: LockFreeLinkedList.kt */
    public static final class b extends zf6 {
    }

    public final boolean j(uf6 uf6, uf6 uf62) {
        g.lazySet(uf6, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f;
        atomicReferenceFieldUpdater.lazySet(uf6, uf62);
        if (!atomicReferenceFieldUpdater.compareAndSet(this, uf62, uf6)) {
            return false;
        }
        uf6.l(uf62);
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003c, code lost:
        if (defpackage.uf6.f.compareAndSet(r2, r1, ((defpackage.ag6) r3).f162a) != false) goto L_0x003f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final defpackage.uf6 k(defpackage.zf6 r7) {
        /*
            r6 = this;
        L_0x0000:
            java.lang.Object r7 = r6._prev
            uf6 r7 = (defpackage.uf6) r7
            r0 = 0
            r1 = r7
        L_0x0006:
            r2 = r0
        L_0x0007:
            java.lang.Object r3 = r1._next
            if (r3 != r6) goto L_0x0018
            if (r7 != r1) goto L_0x000e
            return r1
        L_0x000e:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = defpackage.uf6.g
            boolean r7 = r0.compareAndSet(r6, r7, r1)
            if (r7 != 0) goto L_0x0017
            goto L_0x0000
        L_0x0017:
            return r1
        L_0x0018:
            boolean r4 = r6.r()
            if (r4 == 0) goto L_0x001f
            return r0
        L_0x001f:
            if (r3 != 0) goto L_0x0022
            return r1
        L_0x0022:
            boolean r4 = r3 instanceof defpackage.zf6
            if (r4 == 0) goto L_0x002c
            zf6 r3 = (defpackage.zf6) r3
            r3.a(r1)
            goto L_0x0000
        L_0x002c:
            boolean r4 = r3 instanceof defpackage.ag6
            if (r4 == 0) goto L_0x0046
            if (r2 == 0) goto L_0x0041
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = defpackage.uf6.f
            ag6 r3 = (defpackage.ag6) r3
            uf6 r3 = r3.f162a
            boolean r1 = r4.compareAndSet(r2, r1, r3)
            if (r1 != 0) goto L_0x003f
            goto L_0x0000
        L_0x003f:
            r1 = r2
            goto L_0x0006
        L_0x0041:
            java.lang.Object r1 = r1._prev
            uf6 r1 = (defpackage.uf6) r1
            goto L_0x0007
        L_0x0046:
            r2 = r3
            uf6 r2 = (defpackage.uf6) r2
            r5 = r2
            r2 = r1
            r1 = r5
            goto L_0x0007
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.uf6.k(zf6):uf6");
    }

    public final void l(uf6 uf6) {
        uf6 uf62;
        do {
            uf62 = (uf6) uf6._prev;
            if (m() != uf6) {
                return;
            }
        } while (!g.compareAndSet(uf6, uf62, this));
        if (r()) {
            uf6.k(null);
        }
    }

    public final Object m() {
        while (true) {
            Object obj = this._next;
            if (!(obj instanceof zf6)) {
                return obj;
            }
            ((zf6) obj).a(this);
        }
    }

    public final uf6 n() {
        Object m = m();
        uf6 uf6 = null;
        ag6 ag6 = m instanceof ag6 ? (ag6) m : null;
        if (ag6 != null) {
            uf6 = ag6.f162a;
        }
        return uf6 == null ? (uf6) m : uf6;
    }

    public final uf6 o() {
        uf6 k = k(null);
        if (k == null) {
            Object obj = this._prev;
            while (true) {
                k = (uf6) obj;
                if (!k.r()) {
                    break;
                }
                obj = k._prev;
            }
        }
        return k;
    }

    public final void p() {
        ((ag6) m()).f162a.k(null);
    }

    public final void q() {
        uf6 uf6 = this;
        while (true) {
            Object m = uf6.m();
            if (!(m instanceof ag6)) {
                uf6.k(null);
                return;
            }
            uf6 = ((ag6) m).f162a;
        }
    }

    public boolean r() {
        return m() instanceof ag6;
    }

    public boolean s() {
        return t() == null;
    }

    public final uf6 t() {
        Object m;
        uf6 uf6;
        ag6 ag6;
        do {
            m = m();
            if (m instanceof ag6) {
                return ((ag6) m).f162a;
            }
            if (m == this) {
                return (uf6) m;
            }
            uf6 = (uf6) m;
            ag6 = (ag6) uf6._removedRef;
            if (ag6 == null) {
                ag6 = new ag6(uf6);
                h.lazySet(uf6, ag6);
            }
        } while (!f.compareAndSet(this, m, ag6));
        uf6.k(null);
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append((Object) getClass().getSimpleName());
        sb.append('@');
        sb.append((Object) Integer.toHexString(System.identityHashCode(this)));
        return sb.toString();
    }

    public final int u(uf6 uf6, uf6 uf62, a aVar) {
        g.lazySet(uf6, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f;
        atomicReferenceFieldUpdater.lazySet(uf6, uf62);
        aVar.c = uf62;
        if (!atomicReferenceFieldUpdater.compareAndSet(this, uf62, aVar)) {
            return 0;
        }
        return aVar.a(this) == null ? 1 : 2;
    }
}
