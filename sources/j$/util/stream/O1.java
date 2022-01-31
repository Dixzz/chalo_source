package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.J;
import java.util.Objects;

/* access modifiers changed from: package-private */
public final class O1<T> implements g3<T, Boolean> {

    /* renamed from: a  reason: collision with root package name */
    private final U2 f1723a;
    final N1 b;
    final J c;

    O1(U2 u2, N1 n1, J j) {
        this.f1723a = u2;
        this.b = n1;
        this.c = j;
    }

    @Override // j$.util.stream.g3
    public int b() {
        return T2.u | T2.r;
    }

    @Override // j$.util.stream.g3
    public Object c(T1 t1, Spliterator spliterator) {
        return (Boolean) new P1(this, t1, spliterator).invoke();
    }

    @Override // j$.util.stream.g3
    public Object d(T1 t1, Spliterator spliterator) {
        M1 m1 = (M1) this.c.get();
        AbstractC0164h1 h1Var = (AbstractC0164h1) t1;
        Objects.requireNonNull(m1);
        h1Var.m0(h1Var.u0(m1), spliterator);
        return Boolean.valueOf(m1.b);
    }
}
