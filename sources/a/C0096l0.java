package a;

import j$.util.function.B;
import java.util.function.LongBinaryOperator;

/* renamed from: a.l0 */
public final /* synthetic */ class C0096l0 implements LongBinaryOperator {

    /* renamed from: a */
    final /* synthetic */ B f70a;

    private /* synthetic */ C0096l0(B b) {
        this.f70a = b;
    }

    public static /* synthetic */ LongBinaryOperator a(B b) {
        if (b == null) {
            return null;
        }
        return b instanceof C0094k0 ? ((C0094k0) b).f68a : new C0096l0(b);
    }

    public /* synthetic */ long applyAsLong(long j, long j2) {
        return this.f70a.applyAsLong(j, j2);
    }
}
