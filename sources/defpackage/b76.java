package defpackage;

/* renamed from: b76  reason: default package */
/* compiled from: ContinuationImpl.kt */
public abstract class b76 extends w66 implements k86<Object> {
    private final int arity;

    public b76(int i, k66<Object> k66) {
        super(k66);
        this.arity = i;
    }

    @Override // defpackage.k86
    public int getArity() {
        return this.arity;
    }

    @Override // defpackage.u66
    public String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        String a2 = z86.f4146a.a(this);
        n86.d(a2, "Reflection.renderLambdaToString(this)");
        return a2;
    }

    public b76(int i) {
        this(i, null);
    }
}
