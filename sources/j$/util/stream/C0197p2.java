package j$.util.stream;

import j$.time.chrono.b;
import j$.util.function.C0128e;
import j$.util.function.C0130g;
import j$.util.function.Consumer;
import j$.util.function.H;
import j$.util.function.J;
import j$.util.function.n;
import j$.util.function.w;
import j$.util.stream.A2;
import java.util.Objects;

/* renamed from: j$.util.stream.p2  reason: case insensitive filesystem */
class C0197p2 extends AbstractC0220v2<R> implements AbstractC0216u2<Integer, R, C0197p2>, A2.f {
    final /* synthetic */ J b;
    final /* synthetic */ H c;
    final /* synthetic */ n d;

    C0197p2(J j, H h, n nVar) {
        this.b = j;
        this.c = h;
        this.d = nVar;
    }

    @Override // j$.util.stream.A2
    public /* synthetic */ void accept(double d2) {
        b.c(this);
        throw null;
    }

    @Override // j$.util.stream.A2.f, j$.util.function.w, j$.util.stream.A2
    public void accept(int i) {
        this.c.accept(this.f1833a, i);
    }

    @Override // j$.util.stream.A2
    public /* synthetic */ void accept(long j) {
        b.b(this);
        throw null;
    }

    /* renamed from: b */
    public /* synthetic */ void accept(Integer num) {
        Q1.b(this, num);
    }

    @Override // j$.util.function.Consumer
    public Consumer f(Consumer consumer) {
        Objects.requireNonNull(consumer);
        return new C0128e(this, consumer);
    }

    @Override // j$.util.stream.AbstractC0216u2
    public void i(AbstractC0216u2 u2Var) {
        this.f1833a = this.d.apply(this.f1833a, ((C0197p2) u2Var).f1833a);
    }

    @Override // j$.util.function.w
    public w l(w wVar) {
        Objects.requireNonNull(wVar);
        return new C0130g(this, wVar);
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
