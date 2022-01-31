package j$.util.function;

import java.util.Objects;

/* renamed from: j$.util.function.e  reason: case insensitive filesystem */
public final /* synthetic */ class C0128e implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Consumer f1669a;
    public final /* synthetic */ Consumer b;

    public /* synthetic */ C0128e(Consumer consumer, Consumer consumer2) {
        this.f1669a = consumer;
        this.b = consumer2;
    }

    @Override // j$.util.function.Consumer
    public final void accept(Object obj) {
        Consumer consumer = this.f1669a;
        Consumer consumer2 = this.b;
        consumer.accept(obj);
        consumer2.accept(obj);
    }

    @Override // j$.util.function.Consumer
    public Consumer f(Consumer consumer) {
        Objects.requireNonNull(consumer);
        return new C0128e(this, consumer);
    }
}
