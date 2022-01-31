package j$.util.stream;

import j$.time.chrono.b;
import j$.util.function.C0128e;
import j$.util.function.C0129f;
import j$.util.function.Consumer;
import j$.util.function.p;
import j$.util.function.q;
import j$.util.stream.A2;
import java.util.Objects;

class X1 implements AbstractC0216u2<Double, Double, X1>, A2.e {

    /* renamed from: a  reason: collision with root package name */
    private double f1758a;
    final /* synthetic */ double b;
    final /* synthetic */ p c;

    X1(double d, p pVar) {
        this.b = d;
        this.c = pVar;
    }

    @Override // j$.util.function.q, j$.util.stream.A2.e, j$.util.stream.A2
    public void accept(double d) {
        this.f1758a = this.c.applyAsDouble(this.f1758a, d);
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
    public /* synthetic */ void accept(Double d) {
        Q1.a(this, d);
    }

    @Override // j$.util.function.Consumer
    public Consumer f(Consumer consumer) {
        Objects.requireNonNull(consumer);
        return new C0128e(this, consumer);
    }

    @Override // j$.util.function.J
    public Object get() {
        return Double.valueOf(this.f1758a);
    }

    @Override // j$.util.stream.AbstractC0216u2
    public void i(AbstractC0216u2 u2Var) {
        accept(((X1) u2Var).f1758a);
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
        this.f1758a = this.b;
    }

    @Override // j$.util.stream.A2
    public /* synthetic */ boolean p() {
        return false;
    }
}
