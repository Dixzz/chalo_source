package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.x;
import j$.util.stream.AbstractC0235z1;
import j$.util.stream.R1;
import j$.util.stream.S1;
import java.util.Arrays;
import java.util.Objects;

final class K2 extends AbstractC0235z1.j<Integer> {
    K2(AbstractC0164h1 h1Var) {
        super(h1Var, U2.INT_VALUE, T2.q | T2.o);
    }

    @Override // j$.util.stream.AbstractC0164h1
    public R1 D0(T1 t1, Spliterator spliterator, x xVar) {
        if (T2.SORTED.n(t1.r0())) {
            return t1.o0(spliterator, false, xVar);
        }
        int[] iArr = (int[]) ((R1.c) t1.o0(spliterator, true, xVar)).e();
        Arrays.sort(iArr);
        return new S1.l(iArr);
    }

    @Override // j$.util.stream.AbstractC0164h1
    public A2 G0(int i, A2 a2) {
        Objects.requireNonNull(a2);
        if (T2.SORTED.n(i)) {
            return a2;
        }
        return T2.SIZED.n(i) ? new P2(a2) : new H2(a2);
    }
}
