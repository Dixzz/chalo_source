package defpackage;

/* renamed from: oe6  reason: default package */
/* compiled from: AbstractChannel.kt */
public final class oe6<E> extends ne6<E> {
    public final s76<E, s56> k;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: s76<? super E, s56> */
    /* JADX WARN: Multi-variable type inference failed */
    public oe6(E e, ra6<? super s56> ra6, s76<? super E, s56> s76) {
        super(e, ra6);
        this.k = s76;
    }

    @Override // defpackage.uf6
    public boolean s() {
        if (!super.s()) {
            return false;
        }
        z();
        return true;
    }

    @Override // defpackage.le6
    public void z() {
        s76<E, s56> s76 = this.k;
        E e = this.i;
        m66 context = this.j.getContext();
        jg6 h = ec6.h(s76, e, null);
        if (h != null) {
            hd3.x1(context, h);
        }
    }
}
