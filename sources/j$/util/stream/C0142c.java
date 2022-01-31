package j$.util.stream;

import j$.util.function.C0130g;
import j$.util.function.w;
import java.util.Objects;

/* renamed from: j$.util.stream.c  reason: case insensitive filesystem */
public final /* synthetic */ class C0142c implements w {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ A2 f1772a;

    public /* synthetic */ C0142c(A2 a2) {
        this.f1772a = a2;
    }

    @Override // j$.util.function.w
    public final void accept(int i) {
        this.f1772a.accept(i);
    }

    @Override // j$.util.function.w
    public w l(w wVar) {
        Objects.requireNonNull(wVar);
        return new C0130g(this, wVar);
    }
}
