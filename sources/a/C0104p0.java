package a;

import j$.util.function.D;
import java.util.function.LongFunction;

/* renamed from: a.p0 */
public final /* synthetic */ class C0104p0 implements LongFunction {

    /* renamed from: a */
    final /* synthetic */ D f78a;

    private /* synthetic */ C0104p0(D d) {
        this.f78a = d;
    }

    public static /* synthetic */ LongFunction a(D d) {
        if (d == null) {
            return null;
        }
        return d instanceof C0102o0 ? ((C0102o0) d).f76a : new C0104p0(d);
    }

    @Override // java.util.function.LongFunction
    public /* synthetic */ Object apply(long j) {
        return this.f78a.apply(j);
    }
}
