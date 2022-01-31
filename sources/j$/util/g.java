package j$.util;

import j$.util.function.C;
import j$.util.function.C0131h;
import j$.util.function.Consumer;
import java.util.Objects;

public final /* synthetic */ class g implements C {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Consumer f1678a;

    public /* synthetic */ g(Consumer consumer) {
        this.f1678a = consumer;
    }

    @Override // j$.util.function.C
    public final void accept(long j) {
        this.f1678a.accept(Long.valueOf(j));
    }

    @Override // j$.util.function.C
    public C g(C c) {
        Objects.requireNonNull(c);
        return new C0131h(this, c);
    }
}
