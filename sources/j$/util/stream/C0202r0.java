package j$.util.stream;

import j$.util.function.BiConsumer;
import j$.util.function.C0128e;
import j$.util.function.Consumer;
import java.util.Objects;

/* renamed from: j$.util.stream.r0  reason: case insensitive filesystem */
public final /* synthetic */ class C0202r0 implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BiConsumer f1820a;
    public final /* synthetic */ Object b;

    public /* synthetic */ C0202r0(BiConsumer biConsumer, Object obj) {
        this.f1820a = biConsumer;
        this.b = obj;
    }

    @Override // j$.util.function.Consumer
    public final void accept(Object obj) {
        this.f1820a.accept(this.b, obj);
    }

    @Override // j$.util.function.Consumer
    public Consumer f(Consumer consumer) {
        Objects.requireNonNull(consumer);
        return new C0128e(this, consumer);
    }
}
