package defpackage;

/* renamed from: oc6  reason: default package */
/* compiled from: CancellableContinuationImpl.kt */
public final class oc6 extends pa6 {
    public final s76<Throwable, s56> f;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: s76<? super java.lang.Throwable, s56> */
    /* JADX WARN: Multi-variable type inference failed */
    public oc6(s76<? super Throwable, s56> s76) {
        this.f = s76;
    }

    @Override // defpackage.qa6
    public void a(Throwable th) {
        this.f.invoke(th);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.s76
    public s56 invoke(Throwable th) {
        this.f.invoke(th);
        return s56.f3190a;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("InvokeOnCancel[");
        i0.append(hd3.e1(this.f));
        i0.append('@');
        i0.append(hd3.l1(this));
        i0.append(']');
        return i0.toString();
    }
}
