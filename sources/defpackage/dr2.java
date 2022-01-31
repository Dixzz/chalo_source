package defpackage;

import java.security.GeneralSecurityException;

/* renamed from: dr2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class dr2 extends do2<qr2, or2> {
    public dr2(Class cls) {
        super(cls);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [bm2] */
    @Override // defpackage.do2
    public final void a(qr2 qr2) throws GeneralSecurityException {
        qr2 qr22 = qr2;
        er2.h(qr22.t());
        if (qr22.s() != 32) {
            throw new GeneralSecurityException("AesCmacKey size wrong, must be 32 bytes");
        }
    }

    /* Return type fixed from 'bm2' to match base method */
    @Override // defpackage.do2
    public final /* bridge */ /* synthetic */ qr2 b(g93 g93) throws ma3 {
        return qr2.u(g93, s93.a());
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [bm2] */
    @Override // defpackage.do2
    public final or2 c(qr2 qr2) throws GeneralSecurityException {
        qr2 qr22 = qr2;
        nr2 w = or2.w();
        if (w.h) {
            w.a();
            w.h = false;
        }
        ((or2) w.g).zzb = 0;
        byte[] a2 = lx2.a(qr22.s());
        g93 A = g93.A(a2, 0, a2.length);
        if (w.h) {
            w.a();
            w.h = false;
        }
        or2.z((or2) w.g, A);
        sr2 t = qr22.t();
        if (w.h) {
            w.a();
            w.h = false;
        }
        or2.A((or2) w.g, t);
        return (or2) w.c();
    }
}
