package j$.util.function;

import java.util.Objects;

/* renamed from: j$.util.function.a  reason: case insensitive filesystem */
public final /* synthetic */ class C0124a implements BiConsumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BiConsumer f1665a;
    public final /* synthetic */ BiConsumer b;

    public /* synthetic */ C0124a(BiConsumer biConsumer, BiConsumer biConsumer2) {
        this.f1665a = biConsumer;
        this.b = biConsumer2;
    }

    @Override // j$.util.function.BiConsumer
    public BiConsumer a(BiConsumer biConsumer) {
        Objects.requireNonNull(biConsumer);
        return new C0124a(this, biConsumer);
    }

    @Override // j$.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        BiConsumer biConsumer = this.f1665a;
        BiConsumer biConsumer2 = this.b;
        biConsumer.accept(obj, obj2);
        biConsumer2.accept(obj, obj2);
    }
}
