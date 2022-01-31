package defpackage;

/* renamed from: pf6  reason: default package */
/* compiled from: Scopes.kt */
public final class pf6 implements mb6 {
    public final m66 f;

    public pf6(m66 m66) {
        this.f = m66;
    }

    @Override // defpackage.mb6
    public m66 n() {
        return this.f;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("CoroutineScope(coroutineContext=");
        i0.append(this.f);
        i0.append(')');
        return i0.toString();
    }
}
