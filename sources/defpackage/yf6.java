package defpackage;

/* renamed from: yf6  reason: default package */
/* compiled from: OnUndeliveredElement.kt */
public final class yf6 extends o86 implements s76<Throwable, s56> {
    public final /* synthetic */ s76<E, s56> f;
    public final /* synthetic */ E g;
    public final /* synthetic */ m66 h;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: s76<? super E, s56> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public yf6(s76<? super E, s56> s76, E e, m66 m66) {
        super(1);
        this.f = s76;
        this.g = e;
        this.h = m66;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.s76
    public s56 invoke(Throwable th) {
        s76<E, s56> s76 = this.f;
        E e = this.g;
        m66 m66 = this.h;
        jg6 h2 = ec6.h(s76, e, null);
        if (h2 != null) {
            hd3.x1(m66, h2);
        }
        return s56.f3190a;
    }
}
