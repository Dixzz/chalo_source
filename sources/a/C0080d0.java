package a;

import j$.util.function.y;
import java.util.function.IntPredicate;

/* renamed from: a.d0 */
public final /* synthetic */ class C0080d0 implements IntPredicate {

    /* renamed from: a */
    final /* synthetic */ y f57a;

    private /* synthetic */ C0080d0(y yVar) {
        this.f57a = yVar;
    }

    public static /* synthetic */ IntPredicate a(y yVar) {
        if (yVar == null) {
            return null;
        }
        return yVar instanceof C0078c0 ? ((C0078c0) yVar).f56a : new C0080d0(yVar);
    }

    public /* synthetic */ IntPredicate and(IntPredicate intPredicate) {
        return a(C0078c0.a(((C0078c0) this.f57a).f56a.and(a(C0078c0.a(intPredicate)))));
    }

    public /* synthetic */ IntPredicate negate() {
        return a(C0078c0.a(((C0078c0) this.f57a).f56a.negate()));
    }

    public /* synthetic */ IntPredicate or(IntPredicate intPredicate) {
        return a(C0078c0.a(((C0078c0) this.f57a).f56a.or(a(C0078c0.a(intPredicate)))));
    }

    public /* synthetic */ boolean test(int i) {
        return ((C0078c0) this.f57a).f56a.test(i);
    }
}
