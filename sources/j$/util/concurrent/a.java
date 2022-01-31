package j$.util.concurrent;

import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.C0124a;
import java.util.Objects;
import java.util.concurrent.ConcurrentMap;

public final /* synthetic */ class a implements BiConsumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ConcurrentMap f1660a;
    public final /* synthetic */ BiFunction b;

    public /* synthetic */ a(ConcurrentMap concurrentMap, BiFunction biFunction) {
        this.f1660a = concurrentMap;
        this.b = biFunction;
    }

    @Override // j$.util.function.BiConsumer
    public BiConsumer a(BiConsumer biConsumer) {
        Objects.requireNonNull(biConsumer);
        return new C0124a(this, biConsumer);
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x000e  */
    @Override // j$.util.function.BiConsumer
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void accept(java.lang.Object r4, java.lang.Object r5) {
        /*
            r3 = this;
            java.util.concurrent.ConcurrentMap r0 = r3.f1660a
            j$.util.function.BiFunction r1 = r3.b
        L_0x0004:
            java.lang.Object r2 = r1.apply(r4, r5)
            boolean r5 = r0.replace(r4, r5, r2)
            if (r5 != 0) goto L_0x0014
            java.lang.Object r5 = r0.get(r4)
            if (r5 != 0) goto L_0x0004
        L_0x0014:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.a.accept(java.lang.Object, java.lang.Object):void");
    }
}
