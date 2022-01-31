package j$.util.stream;

import j$.time.chrono.b;
import j$.util.function.C0128e;
import j$.util.function.C0129f;
import j$.util.function.Consumer;
import j$.util.function.q;
import j$.util.stream.A2;
import java.util.Objects;

/* renamed from: j$.util.stream.l0  reason: case insensitive filesystem */
public final /* synthetic */ class C0179l0 implements A2.e {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ q f1805a;

    public /* synthetic */ C0179l0(q qVar) {
        this.f1805a = qVar;
    }

    @Override // j$.util.function.q, j$.util.stream.A2.e, j$.util.stream.A2
    public final void accept(double d) {
        this.f1805a.accept(d);
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
    }

    @Override // j$.util.stream.A2
    public /* synthetic */ boolean p() {
        return false;
    }
}
