package defpackage;

import java.security.GeneralSecurityException;

/* renamed from: fq2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class fq2 extends fo2<gw2> {
    public fq2() {
        super(gw2.class, new dq2(vn2.class));
    }

    @Override // defpackage.fo2
    public final String a() {
        return "type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key";
    }

    @Override // defpackage.fo2
    public final wu2 b() {
        return wu2.SYMMETRIC;
    }

    /* Return type fixed from 'bm2' to match base method */
    @Override // defpackage.fo2
    public final /* bridge */ /* synthetic */ gw2 c(g93 g93) throws ma3 {
        return gw2.u(g93, s93.a());
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [bm2] */
    @Override // defpackage.fo2
    public final /* bridge */ /* synthetic */ void d(gw2 gw2) throws GeneralSecurityException {
        gw2 gw22 = gw2;
        mx2.b(gw22.s(), 0);
        if (gw22.t().e() != 32) {
            throw new GeneralSecurityException("invalid XChaCha20Poly1305Key: incorrect key length");
        }
    }

    /* Return type fixed from 'do2<iw2, gw2>' to match base method */
    @Override // defpackage.fo2
    public final do2<?, gw2> g() {
        return new eq2(this, iw2.class);
    }
}
