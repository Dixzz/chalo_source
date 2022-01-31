package defpackage;

import java.security.GeneralSecurityException;

/* renamed from: up2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class up2 extends do2<gt2, et2> {
    public up2(vp2 vp2, Class cls) {
        super(cls);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [bm2] */
    @Override // defpackage.do2
    public final /* bridge */ /* synthetic */ void a(gt2 gt2) throws GeneralSecurityException {
    }

    /* Return type fixed from 'bm2' to match base method */
    @Override // defpackage.do2
    public final /* bridge */ /* synthetic */ gt2 b(g93 g93) throws ma3 {
        return gt2.s(g93, s93.a());
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [bm2] */
    @Override // defpackage.do2
    public final et2 c(gt2 gt2) throws GeneralSecurityException {
        dt2 v = et2.v();
        if (v.h) {
            v.a();
            v.h = false;
        }
        ((et2) v.g).zzb = 0;
        byte[] a2 = lx2.a(32);
        g93 A = g93.A(a2, 0, a2.length);
        if (v.h) {
            v.a();
            v.h = false;
        }
        et2.y((et2) v.g, A);
        return (et2) v.c();
    }
}
