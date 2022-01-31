package j$.util.stream;

import j$.time.chrono.b;
import j$.util.function.C0128e;
import j$.util.function.C0130g;
import j$.util.function.Consumer;
import j$.util.function.w;
import j$.util.stream.A2;
import java.util.Objects;

/* renamed from: j$.util.stream.e  reason: case insensitive filesystem */
public final /* synthetic */ class C0150e implements A2.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ w f1781a;

    public /* synthetic */ C0150e(w wVar) {
        this.f1781a = wVar;
    }

    @Override // j$.util.stream.A2
    public /* synthetic */ void accept(double d) {
        b.c(this);
        throw null;
    }

    @Override // j$.util.stream.A2.f, j$.util.function.w, j$.util.stream.A2
    public final void accept(int i) {
        this.f1781a.accept(i);
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
    }

    @Override // j$.util.stream.A2
    public /* synthetic */ boolean p() {
        return false;
    }
}
