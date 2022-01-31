package defpackage;

import java.security.GeneralSecurityException;

/* renamed from: er2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class er2 extends fo2<or2> {
    public er2() {
        super(or2.class, new cr2(lo2.class));
    }

    public static void h(sr2 sr2) throws GeneralSecurityException {
        if (sr2.s() < 10) {
            throw new GeneralSecurityException("tag size too short");
        } else if (sr2.s() > 16) {
            throw new GeneralSecurityException("tag size too long");
        }
    }

    @Override // defpackage.fo2
    public final String a() {
        return "type.googleapis.com/google.crypto.tink.AesCmacKey";
    }

    @Override // defpackage.fo2
    public final wu2 b() {
        return wu2.SYMMETRIC;
    }

    /* Return type fixed from 'bm2' to match base method */
    @Override // defpackage.fo2
    public final /* bridge */ /* synthetic */ or2 c(g93 g93) throws ma3 {
        return or2.v(g93, s93.a());
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [bm2] */
    @Override // defpackage.fo2
    public final void d(or2 or2) throws GeneralSecurityException {
        or2 or22 = or2;
        mx2.b(or22.s(), 0);
        if (or22.t().e() == 32) {
            h(or22.u());
            return;
        }
        throw new GeneralSecurityException("AesCmacKey size wrong, must be 32 bytes");
    }

    /* Return type fixed from 'do2<qr2, or2>' to match base method */
    @Override // defpackage.fo2
    public final do2<?, or2> g() {
        return new dr2(qr2.class);
    }
}
