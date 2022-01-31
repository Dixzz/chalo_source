package a;

import java.util.function.BiConsumer;

/* renamed from: a.y */
public final /* synthetic */ class C0120y implements BiConsumer {

    /* renamed from: a */
    final /* synthetic */ j$.util.function.BiConsumer f95a;

    private /* synthetic */ C0120y(j$.util.function.BiConsumer biConsumer) {
        this.f95a = biConsumer;
    }

    public static /* synthetic */ BiConsumer a(j$.util.function.BiConsumer biConsumer) {
        if (biConsumer == null) {
            return null;
        }
        return biConsumer instanceof C0118x ? ((C0118x) biConsumer).f93a : new C0120y(biConsumer);
    }

    @Override // java.util.function.BiConsumer
    public /* synthetic */ void accept(Object obj, Object obj2) {
        this.f95a.accept(obj, obj2);
    }

    @Override // java.util.function.BiConsumer
    public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
        return a(this.f95a.a(C0118x.b(biConsumer)));
    }
}
