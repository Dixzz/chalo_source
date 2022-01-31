package j$.util.stream;

import j$.time.chrono.b;
import j$.util.function.C;
import j$.util.function.C0128e;
import j$.util.function.C0131h;
import j$.util.function.Consumer;
import j$.util.function.I;
import j$.util.function.J;
import j$.util.function.n;
import j$.util.stream.A2;
import java.util.Objects;

class V1 extends AbstractC0220v2<R> implements AbstractC0216u2<Long, R, V1>, A2.g {
    final /* synthetic */ J b;
    final /* synthetic */ I c;
    final /* synthetic */ n d;

    V1(J j, I i, n nVar) {
        this.b = j;
        this.c = i;
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

    @Override // j$.util.function.C, j$.util.stream.A2.g, j$.util.stream.A2
    public void accept(long j) {
        this.c.accept(this.f1833a, j);
    }

    /* renamed from: b */
    public /* synthetic */ void accept(Long l) {
        Q1.c(this, l);
    }

    @Override // j$.util.function.Consumer
    public Consumer f(Consumer consumer) {
        Objects.requireNonNull(consumer);
        return new C0128e(this, consumer);
    }

    @Override // j$.util.function.C
    public C g(C c2) {
        Objects.requireNonNull(c2);
        return new C0131h(this, c2);
    }

    @Override // j$.util.stream.AbstractC0216u2
    public void i(AbstractC0216u2 u2Var) {
        this.f1833a = this.d.apply(this.f1833a, ((V1) u2Var).f1833a);
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
