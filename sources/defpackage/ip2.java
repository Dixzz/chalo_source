package defpackage;

import java.security.GeneralSecurityException;

/* renamed from: ip2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class ip2 extends fo2<bs2> {
    public ip2() {
        super(bs2.class, new gp2(fx2.class));
    }

    public static final void h(bs2 bs2) throws GeneralSecurityException {
        mx2.b(bs2.s(), 0);
        mx2.a(bs2.u().e());
        i(bs2.t());
    }

    public static final void i(hs2 hs2) throws GeneralSecurityException {
        if (hs2.s() < 12 || hs2.s() > 16) {
            throw new GeneralSecurityException("invalid IV size");
        }
    }

    @Override // defpackage.fo2
    public final String a() {
        return "type.googleapis.com/google.crypto.tink.AesCtrKey";
    }

    @Override // defpackage.fo2
    public final wu2 b() {
        return wu2.SYMMETRIC;
    }

    /* Return type fixed from 'bm2' to match base method */
    @Override // defpackage.fo2
    public final /* bridge */ /* synthetic */ bs2 c(g93 g93) throws ma3 {
        return bs2.v(g93, s93.a());
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [bm2] */
    @Override // defpackage.fo2
    public final /* bridge */ /* synthetic */ void d(bs2 bs2) throws GeneralSecurityException {
        h(bs2);
    }

    /* Return type fixed from 'do2<es2, bs2>' to match base method */
    @Override // defpackage.fo2
    public final do2<?, bs2> g() {
        return new hp2(this, es2.class);
    }
}
