package defpackage;

import java.security.GeneralSecurityException;

/* renamed from: rp2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class rp2 extends do2<bt2, zs2> {
    public rp2(sp2 sp2, Class cls) {
        super(cls);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [bm2] */
    @Override // defpackage.do2
    public final /* bridge */ /* synthetic */ void a(bt2 bt2) throws GeneralSecurityException {
        mx2.a(bt2.s());
    }

    /* Return type fixed from 'bm2' to match base method */
    @Override // defpackage.do2
    public final /* bridge */ /* synthetic */ bt2 b(g93 g93) throws ma3 {
        return bt2.t(g93, s93.a());
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [bm2] */
    @Override // defpackage.do2
    public final zs2 c(bt2 bt2) throws GeneralSecurityException {
        ys2 v = zs2.v();
        byte[] a2 = lx2.a(bt2.s());
        g93 A = g93.A(a2, 0, a2.length);
        if (v.h) {
            v.a();
            v.h = false;
        }
        zs2.y((zs2) v.g, A);
        if (v.h) {
            v.a();
            v.h = false;
        }
        ((zs2) v.g).zzb = 0;
        return (zs2) v.c();
    }
}
