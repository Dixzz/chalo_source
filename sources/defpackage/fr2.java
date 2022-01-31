package defpackage;

import java.security.GeneralSecurityException;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: fr2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class fr2 extends eo2<lo2, mu2> {
    public fr2(Class cls) {
        super(cls);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.eo2
    public final /* bridge */ /* synthetic */ lo2 a(mu2 mu2) throws GeneralSecurityException {
        mu2 mu22 = mu2;
        ju2 s = mu22.t().s();
        SecretKeySpec secretKeySpec = new SecretKeySpec(mu22.u().C(), "HMAC");
        int t = mu22.t().t();
        ju2 ju2 = ju2.UNKNOWN_HASH;
        int ordinal = s.ordinal();
        if (ordinal == 1) {
            return new jx2(new ix2("HMACSHA1", secretKeySpec), t);
        }
        if (ordinal == 3) {
            return new jx2(new ix2("HMACSHA256", secretKeySpec), t);
        }
        if (ordinal == 4) {
            return new jx2(new ix2("HMACSHA512", secretKeySpec), t);
        }
        throw new GeneralSecurityException("unknown hash");
    }
}
