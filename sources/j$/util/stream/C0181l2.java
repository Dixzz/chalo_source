package j$.util.stream;

import j$.time.chrono.b;
import j$.util.function.C0128e;
import j$.util.function.C0130g;
import j$.util.function.Consumer;
import j$.util.function.v;
import j$.util.function.w;
import j$.util.stream.A2;
import java.util.Objects;

/* renamed from: j$.util.stream.l2  reason: case insensitive filesystem */
class C0181l2 implements AbstractC0216u2<Integer, Integer, C0181l2>, A2.f {

    /* renamed from: a  reason: collision with root package name */
    private int f1806a;
    final /* synthetic */ int b;
    final /* synthetic */ v c;

    C0181l2(int i, v vVar) {
        this.b = i;
        this.c = vVar;
    }

    @Override // j$.util.stream.A2
    public /* synthetic */ void accept(double d) {
        b.c(this);
        throw null;
    }

    @Override // j$.util.stream.A2.f, j$.util.function.w, j$.util.stream.A2
    public void accept(int i) {
        this.f1806a = this.c.applyAsInt(this.f1806a, i);
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

    @Override // j$.util.function.J
    public Object get() {
        return Integer.valueOf(this.f1806a);
    }

    @Override // j$.util.stream.AbstractC0216u2
    public void i(AbstractC0216u2 u2Var) {
        accept(((C0181l2) u2Var).f1806a);
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
        this.f1806a = this.b;
    }

    @Override // j$.util.stream.A2
    public /* synthetic */ boolean p() {
        return false;
    }
}
