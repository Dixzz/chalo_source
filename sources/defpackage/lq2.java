package defpackage;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;

/* renamed from: lq2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class lq2 extends eo2<zn2, yt2> {
    public lq2(Class cls) {
        super(cls);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.eo2
    public final zn2 a(yt2 yt2) throws GeneralSecurityException {
        yt2 yt22 = yt2;
        st2 t = yt22.t();
        bu2 s = t.s();
        int A1 = gj1.A1(s.s());
        byte[] C = yt22.u().C();
        byte[] C2 = yt22.v().C();
        ECParameterSpec V1 = gj1.V1(A1);
        ECPoint eCPoint = new ECPoint(new BigInteger(1, C), new BigInteger(1, C2));
        gj1.d1(eCPoint, V1.getCurve());
        return new vw2((ECPublicKey) yw2.i.a("EC").generatePublic(new ECPublicKeySpec(eCPoint, V1)), s.u().C(), gj1.s1(s.t()), gj1.K1(t.u()), new uq2(t.t().s()));
    }
}
