package j$.util.stream;

import j$.time.chrono.b;
import j$.util.function.B;
import j$.util.function.C;
import j$.util.function.C0128e;
import j$.util.function.C0131h;
import j$.util.function.Consumer;
import j$.util.q;
import j$.util.stream.A2;
import java.util.Objects;

/* renamed from: j$.util.stream.t2  reason: case insensitive filesystem */
class C0212t2 implements AbstractC0216u2<Long, q, C0212t2>, A2.g {

    /* renamed from: a  reason: collision with root package name */
    private boolean f1827a;
    private long b;
    final /* synthetic */ B c;

    C0212t2(B b2) {
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
        if (this.f1827a) {
            this.f1827a = false;
        } else {
            j = this.c.applyAsLong(this.b, j);
        }
        this.b = j;
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
        return this.f1827a ? q.a() : q.d(this.b);
    }

    @Override // j$.util.stream.AbstractC0216u2
    public void i(AbstractC0216u2 u2Var) {
        C0212t2 t2Var = (C0212t2) u2Var;
        if (!t2Var.f1827a) {
            accept(t2Var.b);
        }
    }

    @Override // j$.util.stream.A2
    public void m() {
    }

    @Override // j$.util.stream.A2
    public void n(long j) {
        this.f1827a = true;
        this.b = 0;
    }

    @Override // j$.util.stream.A2
    public /* synthetic */ boolean p() {
        return false;
    }
}
