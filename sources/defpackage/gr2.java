package defpackage;

import java.security.GeneralSecurityException;

/* renamed from: gr2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class gr2 extends do2<pu2, mu2> {
    public gr2(hr2 hr2, Class cls) {
        super(cls);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [bm2] */
    @Override // defpackage.do2
    public final /* synthetic */ void a(pu2 pu2) throws GeneralSecurityException {
        pu2 pu22 = pu2;
        if (pu22.t() >= 16) {
            hr2.i(pu22.s());
            return;
        }
        throw new GeneralSecurityException("key too short");
    }

    /* Return type fixed from 'bm2' to match base method */
    @Override // defpackage.do2
    public final /* bridge */ /* synthetic */ pu2 b(g93 g93) throws ma3 {
        return pu2.u(g93, s93.a());
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [bm2] */
    @Override // defpackage.do2
    public final mu2 c(pu2 pu2) throws GeneralSecurityException {
        pu2 pu22 = pu2;
        lu2 w = mu2.w();
        if (w.h) {
            w.a();
            w.h = false;
        }
        ((mu2) w.g).zzb = 0;
        su2 s = pu22.s();
        if (w.h) {
            w.a();
            w.h = false;
        }
        mu2.A((mu2) w.g, s);
        byte[] a2 = lx2.a(pu22.t());
        g93 A = g93.A(a2, 0, a2.length);
        if (w.h) {
            w.a();
            w.h = false;
        }
        mu2.B((mu2) w.g, A);
        return (mu2) w.c();
    }
}
