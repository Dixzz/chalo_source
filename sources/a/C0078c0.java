package a;

import j$.util.function.y;
import java.util.function.IntPredicate;

/* renamed from: a.c0 */
public final /* synthetic */ class C0078c0 implements y {

    /* renamed from: a */
    final /* synthetic */ IntPredicate f56a;

    private /* synthetic */ C0078c0(IntPredicate intPredicate) {
        this.f56a = intPredicate;
    }

    public static /* synthetic */ y a(IntPredicate intPredicate) {
        if (intPredicate == null) {
            return null;
        }
        return intPredicate instanceof C0080d0 ? ((C0080d0) intPredicate).f57a : new C0078c0(intPredicate);
    }

    public /* synthetic */ boolean b(int i) {
        return this.f56a.test(i);
    }
}
