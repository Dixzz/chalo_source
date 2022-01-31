package defpackage;

/* renamed from: xa6  reason: default package */
/* compiled from: JobSupport.kt */
public final class xa6 extends tc6 implements wa6 {
    public final ya6 j;

    public xa6(ya6 ya6) {
        this.j = ya6;
    }

    @Override // defpackage.wa6
    public boolean f(Throwable th) {
        return w().B(th);
    }

    @Override // defpackage.wa6
    public rc6 getParent() {
        return w();
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
        this.j.k(w());
    }
}
