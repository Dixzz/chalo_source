package j$.util.stream;

import j$.util.function.BiConsumer;
import j$.util.function.C0124a;
import java.util.LinkedHashSet;
import java.util.Objects;

/* renamed from: j$.util.stream.i  reason: case insensitive filesystem */
public final /* synthetic */ class C0166i implements BiConsumer {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ C0166i f1795a = new C0166i();

    private /* synthetic */ C0166i() {
    }

    @Override // j$.util.function.BiConsumer
    public BiConsumer a(BiConsumer biConsumer) {
        Objects.requireNonNull(biConsumer);
        return new C0124a(this, biConsumer);
    }

    @Override // j$.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        ((LinkedHashSet) obj).addAll((LinkedHashSet) obj2);
    }
}
