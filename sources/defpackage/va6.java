package defpackage;

/* renamed from: va6  reason: default package */
/* compiled from: JobSupport.kt */
public final class va6 extends tc6 {
    public final sa6<?> j;

    public va6(sa6<?> sa6) {
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
        sa6<?> sa6 = this.j;
        Throwable t = sa6.t(w());
        boolean z = false;
        if ((sa6.h == 2) && sa6.x()) {
            z = ((qf6) sa6.i).n(t);
        }
        if (!z) {
            sa6.o(t);
            sa6.q();
        }
    }
}
