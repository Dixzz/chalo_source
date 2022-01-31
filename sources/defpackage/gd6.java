package defpackage;

/* renamed from: gd6  reason: default package */
/* compiled from: JobSupport.kt */
public final class gd6<T> extends vc6 {
    public final sa6<T> j;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: sa6<? super T> */
    /* JADX WARN: Multi-variable type inference failed */
    public gd6(sa6<? super T> sa6) {
        this.j = sa6;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.s76
    public /* bridge */ /* synthetic */ s56 invoke(Throwable th) {
        v(th);
        return s56.f3190a;
    }

    @Override // defpackage.gb6
    public void v(Throwable th) {
        Object J = w().J();
        if (J instanceof eb6) {
            this.j.resumeWith(hd3.Z(((eb6) J).f955a));
        } else {
            this.j.resumeWith(xc6.a(J));
        }
    }
}
