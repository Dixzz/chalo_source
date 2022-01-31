package j$.util.stream;

import j$.time.chrono.b;
import j$.util.Optional;
import j$.util.function.C0128e;
import j$.util.function.Consumer;
import j$.util.function.n;
import java.util.Objects;

/* renamed from: j$.util.stream.f2  reason: case insensitive filesystem */
class C0157f2 implements AbstractC0216u2<T, Optional<T>, C0157f2> {

    /* renamed from: a  reason: collision with root package name */
    private boolean f1787a;
    private Object b;
    final /* synthetic */ n c;

    C0157f2(n nVar) {
        this.c = nVar;
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

    @Override // j$.util.stream.A2
    public /* synthetic */ void accept(long j) {
        b.b(this);
        throw null;
    }

    @Override // j$.util.function.Consumer
    public void accept(Object obj) {
        if (this.f1787a) {
            this.f1787a = false;
        } else {
            obj = this.c.apply(this.b, obj);
        }
        this.b = obj;
    }

    @Override // j$.util.function.Consumer
    public Consumer f(Consumer consumer) {
        Objects.requireNonNull(consumer);
        return new C0128e(this, consumer);
    }

    @Override // j$.util.function.J
    public Object get() {
        return this.f1787a ? Optional.a() : Optional.d(this.b);
    }

    @Override // j$.util.stream.AbstractC0216u2
    public void i(AbstractC0216u2 u2Var) {
        C0157f2 f2Var = (C0157f2) u2Var;
        if (!f2Var.f1787a) {
            accept(f2Var.b);
        }
    }

    @Override // j$.util.stream.A2
    public void m() {
    }

    @Override // j$.util.stream.A2
    public void n(long j) {
        this.f1787a = true;
        this.b = null;
    }

    @Override // j$.util.stream.A2
    public /* synthetic */ boolean p() {
        return false;
    }
}
