package j$.util.stream;

import j$.util.function.BiConsumer;
import j$.util.function.C0124a;
import java.util.Objects;

/* renamed from: j$.util.stream.v  reason: case insensitive filesystem */
public final /* synthetic */ class C0217v implements BiConsumer {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ C0217v f1831a = new C0217v();

    private /* synthetic */ C0217v() {
    }

    @Override // j$.util.function.BiConsumer
    public BiConsumer a(BiConsumer biConsumer) {
        Objects.requireNonNull(biConsumer);
        return new C0124a(this, biConsumer);
    }

    @Override // j$.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        double[] dArr = (double[]) obj;
        double[] dArr2 = (double[]) obj2;
        C0188n1.b(dArr, dArr2[0]);
        C0188n1.b(dArr, dArr2[1]);
        dArr[2] = dArr[2] + dArr2[2];
        dArr[3] = dArr[3] + dArr2[3];
    }
}
