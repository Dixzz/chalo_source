package j$.util.stream;

import j$.time.chrono.b;
import j$.util.function.C0128e;
import j$.util.function.C0129f;
import j$.util.function.Consumer;
import j$.util.function.G;
import j$.util.function.J;
import j$.util.function.n;
import j$.util.function.q;
import j$.util.stream.A2;
import java.util.Objects;

/* renamed from: j$.util.stream.b2  reason: case insensitive filesystem */
class C0141b2 extends AbstractC0220v2<R> implements AbstractC0216u2<Double, R, C0141b2>, A2.e {
    final /* synthetic */ J b;
    final /* synthetic */ G c;
    final /* synthetic */ n d;

    C0141b2(J j, G g, n nVar) {
        this.b = j;
        this.c = g;
        this.d = nVar;
    }

    @Override // j$.util.function.q, j$.util.stream.A2.e, j$.util.stream.A2
    public void accept(double d2) {
        this.c.accept(this.f1833a, d2);
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

    /* renamed from: b */
    public /* synthetic */ void accept(Double d2) {
        Q1.a(this, d2);
    }

    @Override // j$.util.function.Consumer
    public Consumer f(Consumer consumer) {
        Objects.requireNonNull(consumer);
        return new C0128e(this, consumer);
    }

    @Override // j$.util.stream.AbstractC0216u2
    public void i(AbstractC0216u2 u2Var) {
        this.f1833a = this.d.apply(this.f1833a, ((C0141b2) u2Var).f1833a);
    }

    @Override // j$.util.function.q
    public q k(q qVar) {
        Objects.requireNonNull(qVar);
        return new C0129f(this, qVar);
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
