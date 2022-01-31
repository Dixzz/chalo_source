package j$.util.stream;

import j$.time.chrono.b;
import j$.util.function.BiFunction;
import j$.util.function.C0128e;
import j$.util.function.Consumer;
import j$.util.function.n;
import java.util.Objects;

/* renamed from: j$.util.stream.d2  reason: case insensitive filesystem */
class C0149d2 extends AbstractC0220v2<U> implements AbstractC0216u2<T, U, C0149d2> {
    final /* synthetic */ Object b;
    final /* synthetic */ BiFunction c;
    final /* synthetic */ n d;

    C0149d2(Object obj, BiFunction biFunction, n nVar) {
        this.b = obj;
        this.c = biFunction;
        this.d = nVar;
    }

    @Override // j$.util.stream.A2
    public /* synthetic */ void accept(double d2) {
        b.c(this);
        throw null;
    }

    @Override // j$.util.stream.A2
    public /* synthetic */ void accept(int i) {
        b.a(this);
        throw null;
    }

    @Override // j$.util.stream.A2
    public /* synthetic */ void accept(long j) {
        b.b(this);
        throw null;
    }

    @Override // j$.util.function.Consumer
    public void accept(Object obj) {
        this.f1833a = this.c.apply(this.f1833a, obj);
    }

    @Override // j$.util.function.Consumer
    public Consumer f(Consumer consumer) {
        Objects.requireNonNull(consumer);
        return new C0128e(this, consumer);
    }

    @Override // j$.util.stream.AbstractC0216u2
    public void i(AbstractC0216u2 u2Var) {
        this.f1833a = this.d.apply(this.f1833a, ((C0149d2) u2Var).f1833a);
    }

    @Override // j$.util.stream.A2
    public void m() {
    }

    @Override // j$.util.stream.A2
    public void n(long j) {
        this.f1833a = this.b;
    }

    @Override // j$.util.stream.A2
    public /* synthetic */ boolean p() {
        return false;
    }
}
