package a;

import j$.util.function.v;
import java.util.function.IntBinaryOperator;

public final /* synthetic */ class X implements IntBinaryOperator {

    /* renamed from: a */
    final /* synthetic */ v f48a;

    private /* synthetic */ X(v vVar) {
        this.f48a = vVar;
    }

    public static /* synthetic */ IntBinaryOperator a(v vVar) {
        if (vVar == null) {
            return null;
        }
        return vVar instanceof W ? ((W) vVar).f46a : new X(vVar);
    }

    public /* synthetic */ int applyAsInt(int i, int i2) {
        return this.f48a.applyAsInt(i, i2);
    }
}
