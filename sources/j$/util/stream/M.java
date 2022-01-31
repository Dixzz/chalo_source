package j$.util.stream;

import j$.util.function.C0129f;
import j$.util.function.q;
import java.util.Objects;

public final /* synthetic */ class M implements q {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ A2 f1715a;

    public /* synthetic */ M(A2 a2) {
        this.f1715a = a2;
    }

    @Override // j$.util.function.q
    public final void accept(double d) {
        this.f1715a.accept(d);
    }

    @Override // j$.util.function.q
    public q k(q qVar) {
        Objects.requireNonNull(qVar);
        return new C0129f(this, qVar);
    }
}
