package j$.util;

import j$.util.function.C0130g;
import j$.util.function.Consumer;
import j$.util.function.w;
import java.util.Objects;

public final /* synthetic */ class h implements w {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Consumer f1679a;

    public /* synthetic */ h(Consumer consumer) {
        this.f1679a = consumer;
    }

    @Override // j$.util.function.w
    public final void accept(int i) {
        this.f1679a.accept(Integer.valueOf(i));
    }

    @Override // j$.util.function.w
    public w l(w wVar) {
        Objects.requireNonNull(wVar);
        return new C0130g(this, wVar);
    }
}
