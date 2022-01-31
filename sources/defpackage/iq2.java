package defpackage;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.interfaces.ECPrivateKey;
import java.security.spec.ECPrivateKeySpec;

/* renamed from: iq2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class iq2 extends eo2<yn2, vt2> {
    public iq2(Class cls) {
        super(cls);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.eo2
    public final /* bridge */ /* synthetic */ yn2 a(vt2 vt2) throws GeneralSecurityException {
        vt2 vt22 = vt2;
        st2 t = vt22.t().t();
        bu2 s = t.s();
        int A1 = gj1.A1(s.s());
        byte[] C = vt22.u().C();
        return new uw2((ECPrivateKey) yw2.i.a("EC").generatePrivate(new ECPrivateKeySpec(new BigInteger(1, C), gj1.V1(A1))), s.u().C(), gj1.s1(s.t()), gj1.K1(t.u()), new uq2(t.t().s()));
    }
}
