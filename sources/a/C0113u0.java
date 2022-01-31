package a;

import java.util.function.LongToIntFunction;

/* renamed from: a.u0 */
public final /* synthetic */ class C0113u0 {

    /* renamed from: a */
    final /* synthetic */ LongToIntFunction f88a;

    private /* synthetic */ C0113u0(LongToIntFunction longToIntFunction) {
        this.f88a = longToIntFunction;
    }

    public static /* synthetic */ C0113u0 b(LongToIntFunction longToIntFunction) {
        if (longToIntFunction == null) {
            return null;
        }
        return longToIntFunction instanceof C0115v0 ? ((C0115v0) longToIntFunction).f90a : new C0113u0(longToIntFunction);
    }

    public int a(long j) {
        return this.f88a.applyAsInt(j);
    }
}
