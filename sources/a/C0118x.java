package a;

import j$.util.function.BiConsumer;

/* renamed from: a.x */
public final /* synthetic */ class C0118x implements BiConsumer {

    /* renamed from: a */
    final /* synthetic */ java.util.function.BiConsumer f93a;

    private /* synthetic */ C0118x(java.util.function.BiConsumer biConsumer) {
        this.f93a = biConsumer;
    }

    public static /* synthetic */ BiConsumer b(java.util.function.BiConsumer biConsumer) {
        if (biConsumer == null) {
            return null;
        }
        return biConsumer instanceof C0120y ? ((C0120y) biConsumer).f95a : new C0118x(biConsumer);
    }

    @Override // j$.util.function.BiConsumer
    public /* synthetic */ BiConsumer a(BiConsumer biConsumer) {
        return b(this.f93a.andThen(C0120y.a(biConsumer)));
    }

    @Override // j$.util.function.BiConsumer
    public /* synthetic */ void accept(Object obj, Object obj2) {
        this.f93a.accept(obj, obj2);
    }
}
