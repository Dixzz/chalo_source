package defpackage;

import java.security.GeneralSecurityException;

/* renamed from: vp2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class vp2 extends fo2<et2> {
    public vp2() {
        super(et2.class, new tp2(vn2.class));
    }

    @Override // defpackage.fo2
    public final String a() {
        return "type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key";
    }

    @Override // defpackage.fo2
    public final wu2 b() {
        return wu2.SYMMETRIC;
    }

    /* Return type fixed from 'bm2' to match base method */
    @Override // defpackage.fo2
    public final /* bridge */ /* synthetic */ et2 c(g93 g93) throws ma3 {
        return et2.u(g93, s93.a());
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [bm2] */
    @Override // defpackage.fo2
    public final /* bridge */ /* synthetic */ void d(et2 et2) throws GeneralSecurityException {
        et2 et22 = et2;
        mx2.b(et22.s(), 0);
        if (et22.t().e() != 32) {
            throw new GeneralSecurityException("invalid ChaCha20Poly1305Key: incorrect key length");
        }
    }

    /* Return type fixed from 'do2<gt2, et2>' to match base method */
    @Override // defpackage.fo2
    public final do2<?, et2> g() {
        return new up2(this, gt2.class);
    }
}
