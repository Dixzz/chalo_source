package defpackage;

import java.security.GeneralSecurityException;

/* renamed from: hr2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class hr2 extends fo2<mu2> {
    public hr2() {
        super(mu2.class, new fr2(lo2.class));
    }

    public static final void h(mu2 mu2) throws GeneralSecurityException {
        mx2.b(mu2.s(), 0);
        if (mu2.u().e() >= 16) {
            i(mu2.t());
            return;
        }
        throw new GeneralSecurityException("key too short");
    }

    public static void i(su2 su2) throws GeneralSecurityException {
        if (su2.t() >= 10) {
            ju2 ju2 = ju2.UNKNOWN_HASH;
            int ordinal = su2.s().ordinal();
            if (ordinal != 1) {
                if (ordinal != 3) {
                    if (ordinal != 4) {
                        throw new GeneralSecurityException("unknown hash type");
                    } else if (su2.t() > 64) {
                        throw new GeneralSecurityException("tag size too big");
                    }
                } else if (su2.t() > 32) {
                    throw new GeneralSecurityException("tag size too big");
                }
            } else if (su2.t() > 20) {
                throw new GeneralSecurityException("tag size too big");
            }
        } else {
            throw new GeneralSecurityException("tag size too small");
        }
    }

    @Override // defpackage.fo2
    public final String a() {
        return "type.googleapis.com/google.crypto.tink.HmacKey";
    }

    @Override // defpackage.fo2
    public final wu2 b() {
        return wu2.SYMMETRIC;
    }

    /* Return type fixed from 'bm2' to match base method */
    @Override // defpackage.fo2
    public final /* bridge */ /* synthetic */ mu2 c(g93 g93) throws ma3 {
        return mu2.v(g93, s93.a());
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [bm2] */
    @Override // defpackage.fo2
    public final /* bridge */ /* synthetic */ void d(mu2 mu2) throws GeneralSecurityException {
        h(mu2);
    }

    /* Return type fixed from 'do2<pu2, mu2>' to match base method */
    @Override // defpackage.fo2
    public final do2<?, mu2> g() {
        return new gr2(this, pu2.class);
    }
}
