package defpackage;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;

/* renamed from: jq2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class jq2 extends do2<pt2, vt2> {
    public jq2(kq2 kq2, Class cls) {
        super(cls);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [bm2] */
    @Override // defpackage.do2
    public final /* bridge */ /* synthetic */ void a(pt2 pt2) throws GeneralSecurityException {
        gj1.Z0(pt2.s());
    }

    /* Return type fixed from 'bm2' to match base method */
    @Override // defpackage.do2
    public final /* bridge */ /* synthetic */ pt2 b(g93 g93) throws ma3 {
        return pt2.t(g93, s93.a());
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [bm2] */
    @Override // defpackage.do2
    public final vt2 c(pt2 pt2) throws GeneralSecurityException {
        pt2 pt22 = pt2;
        ECParameterSpec V1 = gj1.V1(gj1.A1(pt22.s().s().s()));
        KeyPairGenerator a2 = yw2.h.a("EC");
        a2.initialize(V1);
        KeyPair generateKeyPair = a2.generateKeyPair();
        ECPrivateKey eCPrivateKey = (ECPrivateKey) generateKeyPair.getPrivate();
        ECPoint w = ((ECPublicKey) generateKeyPair.getPublic()).getW();
        xt2 x = yt2.x();
        if (x.h) {
            x.a();
            x.h = false;
        }
        ((yt2) x.g).zzb = 0;
        st2 s = pt22.s();
        if (x.h) {
            x.a();
            x.h = false;
        }
        yt2.B((yt2) x.g, s);
        g93 B = g93.B(w.getAffineX().toByteArray());
        if (x.h) {
            x.a();
            x.h = false;
        }
        yt2.C((yt2) x.g, B);
        g93 B2 = g93.B(w.getAffineY().toByteArray());
        if (x.h) {
            x.a();
            x.h = false;
        }
        yt2.D((yt2) x.g, B2);
        yt2 yt2 = (yt2) x.c();
        ut2 w2 = vt2.w();
        if (w2.h) {
            w2.a();
            w2.h = false;
        }
        ((vt2) w2.g).zzb = 0;
        if (w2.h) {
            w2.a();
            w2.h = false;
        }
        vt2.z((vt2) w2.g, yt2);
        g93 B3 = g93.B(eCPrivateKey.getS().toByteArray());
        if (w2.h) {
            w2.a();
            w2.h = false;
        }
        vt2.A((vt2) w2.g, B3);
        return (vt2) w2.c();
    }
}
