package a;

import j$.util.function.z;
import java.util.function.IntToLongFunction;

/* renamed from: a.h0 */
public final /* synthetic */ class C0088h0 implements IntToLongFunction {

    /* renamed from: a */
    final /* synthetic */ z f62a;

    private /* synthetic */ C0088h0(z zVar) {
        this.f62a = zVar;
    }

    public static /* synthetic */ IntToLongFunction a(z zVar) {
        if (zVar == null) {
            return null;
        }
        return zVar instanceof C0086g0 ? ((C0086g0) zVar).f60a : new C0088h0(zVar);
    }

    public /* synthetic */ long applyAsLong(int i) {
        return this.f62a.applyAsLong(i);
    }
}
