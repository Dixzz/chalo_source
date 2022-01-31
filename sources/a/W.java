package a;

import j$.util.function.v;
import java.util.function.IntBinaryOperator;

public final /* synthetic */ class W implements v {

    /* renamed from: a */
    final /* synthetic */ IntBinaryOperator f46a;

    private /* synthetic */ W(IntBinaryOperator intBinaryOperator) {
        this.f46a = intBinaryOperator;
    }

    public static /* synthetic */ v a(IntBinaryOperator intBinaryOperator) {
        if (intBinaryOperator == null) {
            return null;
        }
        return intBinaryOperator instanceof X ? ((X) intBinaryOperator).f48a : new W(intBinaryOperator);
    }

    @Override // j$.util.function.v
    public /* synthetic */ int applyAsInt(int i, int i2) {
        return this.f46a.applyAsInt(i, i2);
    }
}
