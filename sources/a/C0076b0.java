package a;

import j$.util.function.x;
import java.util.function.IntFunction;

/* renamed from: a.b0 */
public final /* synthetic */ class C0076b0 implements IntFunction {

    /* renamed from: a */
    final /* synthetic */ x f55a;

    private /* synthetic */ C0076b0(x xVar) {
        this.f55a = xVar;
    }

    public static /* synthetic */ IntFunction a(x xVar) {
        if (xVar == null) {
            return null;
        }
        return xVar instanceof C0074a0 ? ((C0074a0) xVar).f54a : new C0076b0(xVar);
    }

    @Override // java.util.function.IntFunction
    public /* synthetic */ Object apply(int i) {
        return this.f55a.apply(i);
    }
}
