package j$.util.stream;

import j$.time.chrono.b;
import j$.util.function.C0128e;
import j$.util.function.Consumer;
import java.util.Objects;

public final /* synthetic */ class N0 implements A2 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Consumer f1719a;

    public /* synthetic */ N0(Consumer consumer) {
        this.f1719a = consumer;
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
    public final void accept(Object obj) {
        this.f1719a.accept(obj);
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
    public /* synthetic */ boolean p() {
        return false;
    }
}
