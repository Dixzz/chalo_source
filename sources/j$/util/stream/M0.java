package j$.util.stream;

import j$.util.function.BiConsumer;
import j$.util.function.C0124a;
import java.util.LinkedHashSet;
import java.util.Objects;

public final /* synthetic */ class M0 implements BiConsumer {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ M0 f1716a = new M0();

    private /* synthetic */ M0() {
    }

    @Override // j$.util.function.BiConsumer
    public BiConsumer a(BiConsumer biConsumer) {
        Objects.requireNonNull(biConsumer);
        return new C0124a(this, biConsumer);
    }

    @Override // j$.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        ((LinkedHashSet) obj).add(obj2);
    }
}
