package defpackage;

import java.security.GeneralSecurityException;

/* renamed from: lp2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class lp2 extends fo2<ks2> {
    public lp2() {
        super(ks2.class, new jp2(vn2.class));
    }

    @Override // defpackage.fo2
    public final String a() {
        return "type.googleapis.com/google.crypto.tink.AesEaxKey";
    }

    @Override // defpackage.fo2
    public final wu2 b() {
        return wu2.SYMMETRIC;
    }

    /* Return type fixed from 'bm2' to match base method */
    @Override // defpackage.fo2
    public final /* bridge */ /* synthetic */ ks2 c(g93 g93) throws ma3 {
        return ks2.v(g93, s93.a());
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [bm2] */
    @Override // defpackage.fo2
    public final /* bridge */ /* synthetic */ void d(ks2 ks2) throws GeneralSecurityException {
        ks2 ks22 = ks2;
        mx2.b(ks22.s(), 0);
        mx2.a(ks22.u().e());
        if (ks22.t().s() != 12 && ks22.t().s() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }

    /* Return type fixed from 'do2<ns2, ks2>' to match base method */
    @Override // defpackage.fo2
    public final do2<?, ks2> g() {
        return new kp2(this, ns2.class);
    }
}
