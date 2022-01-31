package j$.util.stream;

import j$.util.function.C;
import j$.util.function.C0131h;
import j$.util.stream.D1;
import java.util.Objects;

public final /* synthetic */ class P implements C {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ D1.d.a f1724a;

    public /* synthetic */ P(D1.d.a aVar) {
        this.f1724a = aVar;
    }

    @Override // j$.util.function.C
    public final void accept(long j) {
        this.f1724a.f1691a.accept(j);
    }

    @Override // j$.util.function.C
    public C g(C c) {
        Objects.requireNonNull(c);
        return new C0131h(this, c);
    }
}
