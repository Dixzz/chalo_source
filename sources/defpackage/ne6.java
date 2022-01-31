package defpackage;

import defpackage.uf6;

/* renamed from: ne6  reason: default package */
/* compiled from: AbstractChannel.kt */
public class ne6<E> extends le6 {
    public final E i;
    public final ra6<s56> j;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: ra6<? super s56> */
    /* JADX WARN: Multi-variable type inference failed */
    public ne6(E e, ra6<? super s56> ra6) {
        this.i = e;
        this.j = ra6;
    }

    @Override // defpackage.uf6
    public String toString() {
        return getClass().getSimpleName() + '@' + hd3.l1(this) + '(' + ((Object) this.i) + ')';
    }

    @Override // defpackage.le6
    public void v() {
        this.j.s(ta6.f3328a);
    }

    @Override // defpackage.le6
    public E w() {
        return this.i;
    }

    @Override // defpackage.le6
    public void x(ce6<?> ce6) {
        this.j.resumeWith(hd3.Z(ce6.B()));
    }

    @Override // defpackage.le6
    public dg6 y(uf6.b bVar) {
        if (this.j.d(s56.f3190a, null) == null) {
            return null;
        }
        return ta6.f3328a;
    }
}
