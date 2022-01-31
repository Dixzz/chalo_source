package a;

import j$.util.function.z;
import java.util.function.IntToLongFunction;

/* renamed from: a.g0 */
public final /* synthetic */ class C0086g0 implements z {

    /* renamed from: a */
    final /* synthetic */ IntToLongFunction f60a;

    private /* synthetic */ C0086g0(IntToLongFunction intToLongFunction) {
        this.f60a = intToLongFunction;
    }

    public static /* synthetic */ z a(IntToLongFunction intToLongFunction) {
        if (intToLongFunction == null) {
            return null;
        }
        return intToLongFunction instanceof C0088h0 ? ((C0088h0) intToLongFunction).f62a : new C0086g0(intToLongFunction);
    }

    @Override // j$.util.function.z
    public /* synthetic */ long applyAsLong(int i) {
        return this.f60a.applyAsLong(i);
    }
}
