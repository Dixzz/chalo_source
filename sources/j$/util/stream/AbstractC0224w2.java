package j$.util.stream;

import j$.util.Spliterator;
import j$.util.stream.AbstractC0216u2;
import java.util.Objects;

/* access modifiers changed from: package-private */
/* renamed from: j$.util.stream.w2  reason: case insensitive filesystem */
public abstract class AbstractC0224w2<T, R, S extends AbstractC0216u2<T, R, S>> implements g3<T, R> {

    /* renamed from: a  reason: collision with root package name */
    private final U2 f1837a;

    AbstractC0224w2(U2 u2) {
        this.f1837a = u2;
    }

    public abstract AbstractC0216u2 a();

    @Override // j$.util.stream.g3
    public /* synthetic */ int b() {
        return 0;
    }

    @Override // j$.util.stream.g3
    public Object c(T1 t1, Spliterator spliterator) {
        return ((AbstractC0216u2) new C0228x2(this, t1, spliterator).invoke()).get();
    }

    @Override // j$.util.stream.g3
    public Object d(T1 t1, Spliterator spliterator) {
        AbstractC0216u2 a2 = a();
        AbstractC0164h1 h1Var = (AbstractC0164h1) t1;
        Objects.requireNonNull(a2);
        h1Var.m0(h1Var.u0(a2), spliterator);
        return a2.get();
    }
}
