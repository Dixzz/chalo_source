package a;

import java.util.function.Consumer;

public final /* synthetic */ class E implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j$.util.function.Consumer f11a;

    private /* synthetic */ E(j$.util.function.Consumer consumer) {
        this.f11a = consumer;
    }

    public static /* synthetic */ Consumer a(j$.util.function.Consumer consumer) {
        if (consumer == null) {
            return null;
        }
        return consumer instanceof D ? ((D) consumer).f9a : new E(consumer);
    }

    @Override // java.util.function.Consumer
    public /* synthetic */ void accept(Object obj) {
        this.f11a.accept(obj);
    }

    @Override // java.util.function.Consumer
    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return a(this.f11a.f(D.b(consumer)));
    }
}
