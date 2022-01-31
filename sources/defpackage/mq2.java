package defpackage;

import java.security.GeneralSecurityException;

/* renamed from: mq2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class mq2 extends fo2<yt2> {
    public mq2() {
        super(yt2.class, new lq2(zn2.class));
    }

    @Override // defpackage.fo2
    public final String a() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey";
    }

    @Override // defpackage.fo2
    public final wu2 b() {
        return wu2.ASYMMETRIC_PUBLIC;
    }

    /* Return type fixed from 'bm2' to match base method */
    @Override // defpackage.fo2
    public final /* bridge */ /* synthetic */ yt2 c(g93 g93) throws ma3 {
        return yt2.w(g93, s93.a());
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [bm2] */
    @Override // defpackage.fo2
    public final /* bridge */ /* synthetic */ void d(yt2 yt2) throws GeneralSecurityException {
        yt2 yt22 = yt2;
        mx2.b(yt22.s(), 0);
        gj1.Z0(yt22.t());
    }
}
