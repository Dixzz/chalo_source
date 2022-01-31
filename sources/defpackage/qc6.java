package defpackage;

/* renamed from: qc6  reason: default package */
/* compiled from: JobSupport.kt */
public final class qc6 extends vc6 {
    public final s76<Throwable, s56> j;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: s76<? super java.lang.Throwable, s56> */
    /* JADX WARN: Multi-variable type inference failed */
    public qc6(s76<? super Throwable, s56> s76) {
        this.j = s76;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.s76
    public s56 invoke(Throwable th) {
        this.j.invoke(th);
        return s56.f3190a;
    }

    @Override // defpackage.gb6
    public void v(Throwable th) {
        this.j.invoke(th);
    }
}
