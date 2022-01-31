package defpackage;

/* renamed from: fd6  reason: default package */
/* compiled from: CancellableContinuation.kt */
public final class fd6 extends ma6 {
    public final uf6 f;

    public fd6(uf6 uf6) {
        this.f = uf6;
    }

    @Override // defpackage.qa6
    public void a(Throwable th) {
        this.f.s();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.s76
    public s56 invoke(Throwable th) {
        this.f.s();
        return s56.f3190a;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("RemoveOnCancel[");
        i0.append(this.f);
        i0.append(']');
        return i0.toString();
    }
}
