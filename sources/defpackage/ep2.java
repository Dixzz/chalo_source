package defpackage;

import java.security.GeneralSecurityException;

/* renamed from: ep2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class ep2 extends do2<yr2, vr2> {
    public ep2(fp2 fp2, Class cls) {
        super(cls);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [bm2] */
    @Override // defpackage.do2
    public final void a(yr2 yr2) throws GeneralSecurityException {
        yr2 yr22 = yr2;
        new ip2();
        es2 s = yr22.s();
        mx2.a(s.t());
        ip2.i(s.s());
        new hr2().g().a(yr22.t());
        mx2.a(yr22.s().t());
    }

    /* Return type fixed from 'bm2' to match base method */
    @Override // defpackage.do2
    public final /* bridge */ /* synthetic */ yr2 b(g93 g93) throws ma3 {
        return yr2.u(g93, s93.a());
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [bm2] */
    @Override // defpackage.do2
    public final vr2 c(yr2 yr2) throws GeneralSecurityException {
        yr2 yr22 = yr2;
        new ip2();
        bs2 d = hp2.d(yr22.s());
        mu2 c = new hr2().g().c(yr22.t());
        ur2 w = vr2.w();
        if (w.h) {
            w.a();
            w.h = false;
        }
        vr2.z((vr2) w.g, d);
        mu2 mu2 = c;
        if (w.h) {
            w.a();
            w.h = false;
        }
        vr2.A((vr2) w.g, mu2);
        if (w.h) {
            w.a();
            w.h = false;
        }
        ((vr2) w.g).zzb = 0;
        return (vr2) w.c();
    }
}
