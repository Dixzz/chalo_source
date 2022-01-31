package j$.util.stream;

import j$.time.chrono.b;
import j$.util.function.C0128e;
import j$.util.function.Consumer;
import java.util.Objects;

abstract class M1<T> implements A2<T> {

    /* renamed from: a  reason: collision with root package name */
    boolean f1717a;
    boolean b;

    M1(N1 n1) {
        this.b = !n1.b;
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
    public Consumer f(Consumer consumer) {
        Objects.requireNonNull(consumer);
        return new C0128e(this, consumer);
    }

    @Override // j$.util.stream.A2
    public void m() {
    }

    @Override // j$.util.stream.A2
    public void n(long j) {
    }

    @Override // j$.util.stream.A2
    public boolean p() {
        return this.f1717a;
    }
}
