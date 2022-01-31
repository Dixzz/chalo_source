package j$.util.stream;

import j$.time.chrono.b;
import j$.util.function.B;
import j$.util.function.C;
import j$.util.function.C0128e;
import j$.util.function.C0131h;
import j$.util.function.Consumer;
import j$.util.stream.A2;
import java.util.Objects;

/* renamed from: j$.util.stream.r2  reason: case insensitive filesystem */
class C0204r2 implements AbstractC0216u2<Long, Long, C0204r2>, A2.g {

    /* renamed from: a  reason: collision with root package name */
    private long f1821a;
    final /* synthetic */ long b;
    final /* synthetic */ B c;

    C0204r2(long j, B b2) {
        this.b = j;
        this.c = b2;
    }

    @Override // j$.util.stream.A2
    public /* synthetic */ void accept(double d) {
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
        this.f1821a = this.c.applyAsLong(this.f1821a, j);
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

    @Override // j$.util.function.J
    public Object get() {
        return Long.valueOf(this.f1821a);
    }

    @Override // j$.util.stream.AbstractC0216u2
    public void i(AbstractC0216u2 u2Var) {
        accept(((C0204r2) u2Var).f1821a);
    }

    @Override // j$.util.stream.A2
    public void m() {
    }

    @Override // j$.util.stream.A2
    public void n(long j) {
        this.f1821a = this.b;
    }

    @Override // j$.util.stream.A2
    public /* synthetic */ boolean p() {
        return false;
    }
}
