package j$.util.stream;

import j$.util.function.BiConsumer;
import j$.util.function.C0124a;
import j$.util.l;
import java.util.Objects;

/* renamed from: j$.util.stream.k0  reason: case insensitive filesystem */
public final /* synthetic */ class C0175k0 implements BiConsumer {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ C0175k0 f1802a = new C0175k0();

    private /* synthetic */ C0175k0() {
    }

    @Override // j$.util.function.BiConsumer
    public BiConsumer a(BiConsumer biConsumer) {
        Objects.requireNonNull(biConsumer);
        return new C0124a(this, biConsumer);
    }

    @Override // j$.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        ((l) obj).b((l) obj2);
    }
}
