package a;

import j$.util.function.x;
import java.util.function.IntFunction;

/* renamed from: a.a0 */
public final /* synthetic */ class C0074a0 implements x {

    /* renamed from: a */
    final /* synthetic */ IntFunction f54a;

    private /* synthetic */ C0074a0(IntFunction intFunction) {
        this.f54a = intFunction;
    }

    public static /* synthetic */ x a(IntFunction intFunction) {
        if (intFunction == null) {
            return null;
        }
        return intFunction instanceof C0076b0 ? ((C0076b0) intFunction).f55a : new C0074a0(intFunction);
    }

    @Override // j$.util.function.x
    public /* synthetic */ Object apply(int i) {
        return this.f54a.apply(i);
    }
}
