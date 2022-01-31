package j$.util.function;

import java.util.Objects;

/* renamed from: j$.util.function.g  reason: case insensitive filesystem */
public final /* synthetic */ class C0130g implements w {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ w f1671a;
    public final /* synthetic */ w b;

    public /* synthetic */ C0130g(w wVar, w wVar2) {
        this.f1671a = wVar;
        this.b = wVar2;
    }

    @Override // j$.util.function.w
    public final void accept(int i) {
        w wVar = this.f1671a;
        w wVar2 = this.b;
        wVar.accept(i);
        wVar2.accept(i);
    }

    @Override // j$.util.function.w
    public w l(w wVar) {
        Objects.requireNonNull(wVar);
        return new C0130g(this, wVar);
    }
}
