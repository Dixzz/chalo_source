package j$.util.stream;

import j$.util.Comparator;
import j$.util.Spliterator;
import j$.util.function.x;
import j$.util.stream.AbstractC0232y2;
import j$.util.stream.S1;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

final class M2<T> extends AbstractC0232y2.l<T, T> {
    private final boolean l;
    private final Comparator m;

    M2(AbstractC0164h1 h1Var) {
        super(h1Var, U2.REFERENCE, T2.q | T2.o);
        this.l = true;
        this.m = Comparator.CC.a();
    }

    M2(AbstractC0164h1 h1Var, java.util.Comparator comparator) {
        super(h1Var, U2.REFERENCE, T2.q | T2.p);
        this.l = false;
        Objects.requireNonNull(comparator);
        this.m = comparator;
    }

    @Override // j$.util.stream.AbstractC0164h1
    public R1 D0(T1 t1, Spliterator spliterator, x xVar) {
        if (T2.SORTED.n(t1.r0()) && this.l) {
            return t1.o0(spliterator, false, xVar);
        }
        Object[] q = t1.o0(spliterator, true, xVar).q(xVar);
        Arrays.sort(q, this.m);
        return new S1.c(q);
    }

    @Override // j$.util.stream.AbstractC0164h1
    public A2 G0(int i, A2 a2) {
        Objects.requireNonNull(a2);
        if (!T2.SORTED.n(i) || !this.l) {
            return T2.SIZED.n(i) ? new R2(a2, this.m) : new N2(a2, this.m);
        }
        return a2;
    }
}
