package a;

import java.util.function.LongToDoubleFunction;

/* renamed from: a.s0 */
public final /* synthetic */ class C0109s0 {

    /* renamed from: a */
    final /* synthetic */ LongToDoubleFunction f84a;

    private /* synthetic */ C0109s0(LongToDoubleFunction longToDoubleFunction) {
        this.f84a = longToDoubleFunction;
    }

    public static /* synthetic */ C0109s0 b(LongToDoubleFunction longToDoubleFunction) {
        if (longToDoubleFunction == null) {
            return null;
        }
        return longToDoubleFunction instanceof C0111t0 ? ((C0111t0) longToDoubleFunction).f86a : new C0109s0(longToDoubleFunction);
    }

    public double a(long j) {
        return this.f84a.applyAsDouble(j);
    }
}
