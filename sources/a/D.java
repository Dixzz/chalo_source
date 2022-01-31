package a;

import j$.util.function.Consumer;

public final /* synthetic */ class D implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ java.util.function.Consumer f9a;

    private /* synthetic */ D(java.util.function.Consumer consumer) {
        this.f9a = consumer;
    }

    public static /* synthetic */ Consumer b(java.util.function.Consumer consumer) {
        if (consumer == null) {
            return null;
        }
        return consumer instanceof E ? ((E) consumer).f11a : new D(consumer);
    }

    @Override // j$.util.function.Consumer
    public /* synthetic */ void accept(Object obj) {
        this.f9a.accept(obj);
    }

    @Override // j$.util.function.Consumer
    public /* synthetic */ Consumer f(Consumer consumer) {
        return b(this.f9a.andThen(E.a(consumer)));
    }
}
