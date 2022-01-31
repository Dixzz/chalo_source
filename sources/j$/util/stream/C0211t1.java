package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.J;
import j$.util.function.Predicate;
import java.util.Objects;

/* renamed from: j$.util.stream.t1  reason: case insensitive filesystem */
final class C0211t1<T, O> implements g3<T, O> {

    /* renamed from: a  reason: collision with root package name */
    private final U2 f1826a;
    final boolean b;
    final Object c;
    final Predicate d;
    final J e;

    C0211t1(boolean z, U2 u2, Object obj, Predicate predicate, J j) {
        this.b = z;
        this.f1826a = u2;
        this.c = obj;
        this.d = predicate;
        this.e = j;
    }

    @Override // j$.util.stream.g3
    public int b() {
        return T2.u | (this.b ? 0 : T2.r);
    }

    @Override // j$.util.stream.g3
    public Object c(T1 t1, Spliterator spliterator) {
        return new C0219v1(this, t1, spliterator).invoke();
    }

    @Override // j$.util.stream.g3
    public Object d(T1 t1, Spliterator spliterator) {
        h3 h3Var = (h3) this.e.get();
        AbstractC0164h1 h1Var = (AbstractC0164h1) t1;
        Objects.requireNonNull(h3Var);
        h1Var.m0(h1Var.u0(h3Var), spliterator);
        Object obj = h3Var.get();
        return obj != null ? obj : this.c;
    }
}
