package j$.util.stream;

import j$.util.function.C;
import j$.util.function.C0131h;
import java.util.Objects;

public final /* synthetic */ class K0 implements C {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ A2 f1712a;

    public /* synthetic */ K0(A2 a2) {
        this.f1712a = a2;
    }

    @Override // j$.util.function.C
    public final void accept(long j) {
        this.f1712a.accept(j);
    }

    @Override // j$.util.function.C
    public C g(C c) {
        Objects.requireNonNull(c);
        return new C0131h(this, c);
    }
}
