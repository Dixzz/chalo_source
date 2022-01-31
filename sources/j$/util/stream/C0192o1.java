package j$.util.stream;

import j$.util.Spliterator;
import j$.util.concurrent.ConcurrentHashMap;
import j$.util.function.x;
import j$.util.stream.A2;
import j$.util.stream.AbstractC0223w1;
import j$.util.stream.AbstractC0232y2;
import j$.util.stream.S1;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* access modifiers changed from: package-private */
/* renamed from: j$.util.stream.o1  reason: case insensitive filesystem */
public class C0192o1 extends AbstractC0232y2.l<T, T> {

    /* renamed from: j$.util.stream.o1$a */
    class a extends A2.d<T, T> {
        boolean b;
        Object c;

        a(C0192o1 o1Var, A2 a2) {
            super(a2);
        }

        @Override // j$.util.function.Consumer
        public void accept(Object obj) {
            if (obj != null) {
                Object obj2 = this.c;
                if (obj2 == null || !obj.equals(obj2)) {
                    A2 a2 = this.f1692a;
                    this.c = obj;
                    a2.accept(obj);
                }
            } else if (!this.b) {
                this.b = true;
                A2 a22 = this.f1692a;
                this.c = null;
                a22.accept((Object) null);
            }
        }

        @Override // j$.util.stream.A2.d, j$.util.stream.A2
        public void m() {
            this.b = false;
            this.c = null;
            this.f1692a.m();
        }

        @Override // j$.util.stream.A2.d, j$.util.stream.A2
        public void n(long j) {
            this.b = false;
            this.c = null;
            this.f1692a.n(-1);
        }
    }

    /* renamed from: j$.util.stream.o1$b */
    class b extends A2.d<T, T> {
        Set b;

        b(C0192o1 o1Var, A2 a2) {
            super(a2);
        }

        @Override // j$.util.function.Consumer
        public void accept(Object obj) {
            if (!this.b.contains(obj)) {
                this.b.add(obj);
                this.f1692a.accept(obj);
            }
        }

        @Override // j$.util.stream.A2.d, j$.util.stream.A2
        public void m() {
            this.b = null;
            this.f1692a.m();
        }

        @Override // j$.util.stream.A2.d, j$.util.stream.A2
        public void n(long j) {
            this.b = new HashSet();
            this.f1692a.n(-1);
        }
    }

    C0192o1(AbstractC0164h1 h1Var, U2 u2, int i) {
        super(h1Var, u2, i);
    }

    /* access modifiers changed from: package-private */
    @Override // j$.util.stream.AbstractC0164h1
    public R1 D0(T1 t1, Spliterator spliterator, x xVar) {
        if (T2.DISTINCT.n(t1.r0())) {
            return t1.o0(spliterator, false, xVar);
        }
        if (T2.ORDERED.n(t1.r0())) {
            return K0(t1, spliterator);
        }
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        new AbstractC0223w1.d(new C0182m(atomicBoolean, concurrentHashMap), false).c(t1, spliterator);
        Set keySet = concurrentHashMap.keySet();
        if (atomicBoolean.get()) {
            HashSet hashSet = new HashSet(keySet);
            hashSet.add(null);
            keySet = hashSet;
        }
        return new S1.d(keySet);
    }

    /* access modifiers changed from: package-private */
    @Override // j$.util.stream.AbstractC0164h1
    public Spliterator E0(T1 t1, Spliterator spliterator) {
        return T2.DISTINCT.n(t1.r0()) ? t1.v0(spliterator) : T2.ORDERED.n(t1.r0()) ? ((S1.d) K0(t1, spliterator)).spliterator() : new Y2(t1.v0(spliterator));
    }

    /* access modifiers changed from: package-private */
    @Override // j$.util.stream.AbstractC0164h1
    public A2 G0(int i, A2 a2) {
        Objects.requireNonNull(a2);
        if (T2.DISTINCT.n(i)) {
            return a2;
        }
        return T2.SORTED.n(i) ? new a(this, a2) : new b(this, a2);
    }

    /* access modifiers changed from: package-private */
    public R1 K0(T1 t1, Spliterator spliterator) {
        A a2 = A.f1687a;
        M0 m0 = M0.f1716a;
        return new S1.d((Collection) new C0169i2(U2.REFERENCE, C0166i.f1795a, m0, a2).c(t1, spliterator));
    }
}
