package defpackage;

import java.security.GeneralSecurityException;

/* renamed from: kq2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class kq2 extends so2<vt2, yt2> {
    public kq2() {
        super(vt2.class, new iq2(yn2.class));
    }

    public static final void h(vt2 vt2) throws GeneralSecurityException {
        if (vt2.u().e() != 0) {
            mx2.b(vt2.s(), 0);
            gj1.Z0(vt2.t().t());
            return;
        }
        throw new GeneralSecurityException("invalid ECIES private key");
    }

    @Override // defpackage.fo2
    public final String a() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey";
    }

    @Override // defpackage.fo2
    public final wu2 b() {
        return wu2.ASYMMETRIC_PRIVATE;
    }

    @Override // defpackage.fo2
    public final /* bridge */ /* synthetic */ bm2 c(g93 g93) throws ma3 {
        return vt2.v(g93, s93.a());
    }

    @Override // defpackage.fo2
    public final /* bridge */ /* synthetic */ void d(bm2 bm2) throws GeneralSecurityException {
        h((vt2) bm2);
    }

    @Override // defpackage.fo2
    public final do2<pt2, vt2> g() {
        return new jq2(this, pt2.class);
    }
}
