package j$.util;

import j$.util.function.C0129f;
import j$.util.function.Consumer;
import j$.util.function.q;
import java.util.Objects;

public final /* synthetic */ class j implements q {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Consumer f1681a;

    public /* synthetic */ j(Consumer consumer) {
        this.f1681a = consumer;
    }

    @Override // j$.util.function.q
    public final void accept(double d) {
        this.f1681a.accept(Double.valueOf(d));
    }

    @Override // j$.util.function.q
    public q k(q qVar) {
        Objects.requireNonNull(qVar);
        return new C0129f(this, qVar);
    }
}
