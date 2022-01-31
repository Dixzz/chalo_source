package j$.util.stream;

import j$.util.function.BiConsumer;
import j$.util.function.C0124a;
import java.util.Objects;

public final /* synthetic */ class N implements BiConsumer {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ N f1718a = new N();

    private /* synthetic */ N() {
    }

    @Override // j$.util.function.BiConsumer
    public BiConsumer a(BiConsumer biConsumer) {
        Objects.requireNonNull(biConsumer);
        return new C0124a(this, biConsumer);
    }

    @Override // j$.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        long[] jArr = (long[]) obj;
        long[] jArr2 = (long[]) obj2;
        jArr[0] = jArr[0] + jArr2[0];
        jArr[1] = jArr[1] + jArr2[1];
    }
}
