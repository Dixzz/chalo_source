package j$.util.stream;

import j$.time.chrono.b;
import j$.util.function.C;
import j$.util.function.C0128e;
import j$.util.function.C0131h;
import j$.util.function.Consumer;
import j$.util.stream.A2;
import j$.util.stream.S2;
import java.util.Objects;

/* renamed from: j$.util.stream.n0  reason: case insensitive filesystem */
public final /* synthetic */ class C0187n0 implements A2.g {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ S2.d f1811a;

    public /* synthetic */ C0187n0(S2.d dVar) {
        this.f1811a = dVar;
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
    public final void accept(long j) {
        this.f1811a.accept(j);
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
    public C g(C c) {
        Objects.requireNonNull(c);
        return new C0131h(this, c);
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
