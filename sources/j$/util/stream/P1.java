package j$.util.stream;

import j$.util.Spliterator;

final class P1<P_IN, P_OUT> extends AbstractC0168i1<P_IN, P_OUT, Boolean, P1<P_IN, P_OUT>> {
    private final O1 j;

    P1(O1 o1, T1 t1, Spliterator spliterator) {
        super(t1, spliterator);
        this.j = o1;
    }

    P1(P1 p1, Spliterator spliterator) {
        super(p1, spliterator);
        this.j = p1.j;
    }

    /* access modifiers changed from: protected */
    @Override // j$.util.stream.AbstractC0176k1
    public Object a() {
        T1 t1 = this.f1803a;
        M1 m1 = (M1) this.j.c.get();
        t1.t0(m1, this.b);
        boolean z = m1.b;
        if (z != this.j.b.b) {
            return null;
        }
        l(Boolean.valueOf(z));
        return null;
    }

    /* access modifiers changed from: protected */
    @Override // j$.util.stream.AbstractC0176k1
    public AbstractC0176k1 f(Spliterator spliterator) {
        return new P1(this, spliterator);
    }

    /* access modifiers changed from: protected */
    @Override // j$.util.stream.AbstractC0168i1
    public Object k() {
        return Boolean.valueOf(!this.j.b.b);
    }
}
