package j$.util.stream;

import j$.util.function.C0129f;
import j$.util.function.q;
import j$.util.stream.AbstractC0196p1;
import java.util.Objects;

/* renamed from: j$.util.stream.o  reason: case insensitive filesystem */
public final /* synthetic */ class C0190o implements q {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AbstractC0196p1.d.a f1813a;

    public /* synthetic */ C0190o(AbstractC0196p1.d.a aVar) {
        this.f1813a = aVar;
    }

    @Override // j$.util.function.q
    public final void accept(double d) {
        this.f1813a.f1689a.accept(d);
    }

    @Override // j$.util.function.q
    public q k(q qVar) {
        Objects.requireNonNull(qVar);
        return new C0129f(this, qVar);
    }
}
