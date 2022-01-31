package j$.util.stream;

import j$.util.stream.A2;
import java.util.Comparator;

abstract class F2<T> extends A2.d<T, T> {
    protected final Comparator b;
    protected boolean c;

    F2(A2 a2, Comparator comparator) {
        super(a2);
        this.b = comparator;
    }

    @Override // j$.util.stream.A2.d, j$.util.stream.A2
    public final boolean p() {
        this.c = true;
        return false;
    }
}
