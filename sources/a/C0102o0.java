package a;

import j$.util.function.D;
import java.util.function.LongFunction;

/* renamed from: a.o0 */
public final /* synthetic */ class C0102o0 implements D {

    /* renamed from: a */
    final /* synthetic */ LongFunction f76a;

    private /* synthetic */ C0102o0(LongFunction longFunction) {
        this.f76a = longFunction;
    }

    public static /* synthetic */ D a(LongFunction longFunction) {
        if (longFunction == null) {
            return null;
        }
        return longFunction instanceof C0104p0 ? ((C0104p0) longFunction).f78a : new C0102o0(longFunction);
    }

    @Override // j$.util.function.D
    public /* synthetic */ Object apply(long j) {
        return this.f76a.apply(j);
    }
}
