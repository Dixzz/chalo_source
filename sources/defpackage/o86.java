package defpackage;

import java.io.Serializable;

/* renamed from: o86  reason: default package */
/* compiled from: Lambda.kt */
public abstract class o86<R> implements k86<R>, Serializable {
    private final int arity;

    public o86(int i) {
        this.arity = i;
    }

    @Override // defpackage.k86
    public int getArity() {
        return this.arity;
    }

    public String toString() {
        String a2 = z86.f4146a.a(this);
        n86.d(a2, "Reflection.renderLambdaToString(this)");
        return a2;
    }
}
