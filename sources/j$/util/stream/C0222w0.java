package j$.util.stream;

import j$.util.function.BiConsumer;
import j$.util.function.C0124a;
import j$.util.n;
import java.util.Objects;

/* renamed from: j$.util.stream.w0  reason: case insensitive filesystem */
public final /* synthetic */ class C0222w0 implements BiConsumer {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ C0222w0 f1835a = new C0222w0();

    private /* synthetic */ C0222w0() {
    }

    @Override // j$.util.function.BiConsumer
    public BiConsumer a(BiConsumer biConsumer) {
        Objects.requireNonNull(biConsumer);
        return new C0124a(this, biConsumer);
    }

    @Override // j$.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        ((n) obj).b((n) obj2);
    }
}
