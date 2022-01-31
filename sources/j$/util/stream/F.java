package j$.util.stream;

import j$.util.function.C0130g;
import j$.util.function.w;
import j$.util.stream.AbstractC0235z1;
import java.util.Objects;

public final /* synthetic */ class F implements w {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AbstractC0235z1.g.a f1701a;

    public /* synthetic */ F(AbstractC0235z1.g.a aVar) {
        this.f1701a = aVar;
    }

    @Override // j$.util.function.w
    public final void accept(int i) {
        this.f1701a.f1690a.accept(i);
    }

    @Override // j$.util.function.w
    public w l(w wVar) {
        Objects.requireNonNull(wVar);
        return new C0130g(this, wVar);
    }
}
