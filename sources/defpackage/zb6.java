package defpackage;

/* renamed from: zb6  reason: default package */
/* compiled from: CancellableContinuation.kt */
public final class zb6 extends pa6 {
    public final yb6 f;

    public zb6(yb6 yb6) {
        this.f = yb6;
    }

    @Override // defpackage.qa6
    public void a(Throwable th) {
        this.f.h();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.s76
    public s56 invoke(Throwable th) {
        this.f.h();
        return s56.f3190a;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("DisposeOnCancel[");
        i0.append(this.f);
        i0.append(']');
        return i0.toString();
    }
}
