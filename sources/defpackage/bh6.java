package defpackage;

import defpackage.uf6;

/* renamed from: bh6  reason: default package */
/* compiled from: LockFreeLinkedList.kt */
public final class bh6 extends uf6.a {
    public final /* synthetic */ zg6 d;
    public final /* synthetic */ Object e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public bh6(uf6 uf6, zg6 zg6, Object obj) {
        super(uf6);
        this.d = zg6;
        this.e = obj;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.nf6
    public Object c(uf6 uf6) {
        if (this.d._state == this.e) {
            return null;
        }
        return tf6.f3349a;
    }
}
