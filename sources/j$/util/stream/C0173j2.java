package j$.util.stream;

import j$.time.chrono.b;
import j$.util.function.BiConsumer;
import j$.util.function.C0128e;
import j$.util.function.Consumer;
import j$.util.function.J;
import java.util.Objects;

/* renamed from: j$.util.stream.j2  reason: case insensitive filesystem */
class C0173j2 extends AbstractC0220v2<R> implements AbstractC0216u2<T, R, C0173j2> {
    final /* synthetic */ J b;
    final /* synthetic */ BiConsumer c;
    final /* synthetic */ BiConsumer d;

    C0173j2(J j, BiConsumer biConsumer, BiConsumer biConsumer2) {
        this.b = j;
        this.c = biConsumer;
        this.d = biConsumer2;
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
        this.c.accept(this.f1833a, obj);
    }

    @Override // j$.util.function.Consumer
    public Consumer f(Consumer consumer) {
        Objects.requireNonNull(consumer);
        return new C0128e(this, consumer);
    }

    @Override // j$.util.stream.AbstractC0216u2
    public void i(AbstractC0216u2 u2Var) {
        this.d.accept(this.f1833a, ((C0173j2) u2Var).f1833a);
    }

    @Override // j$.util.stream.A2
    public void m() {
    }

    @Override // j$.util.stream.A2
    public void n(long j) {
        this.f1833a = this.b.get();
    }

    @Override // j$.util.stream.A2
    public /* synthetic */ boolean p() {
        return false;
    }
}
