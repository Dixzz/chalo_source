package defpackage;

import java.security.GeneralSecurityException;

/* renamed from: cq2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class cq2 extends fo2<xv2> {
    public cq2() {
        super(xv2.class, new aq2(vn2.class));
    }

    @Override // defpackage.fo2
    public final String a() {
        return "type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey";
    }

    @Override // defpackage.fo2
    public final wu2 b() {
        return wu2.REMOTE;
    }

    /* Return type fixed from 'bm2' to match base method */
    @Override // defpackage.fo2
    public final /* bridge */ /* synthetic */ xv2 c(g93 g93) throws ma3 {
        return xv2.u(g93, s93.a());
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [bm2] */
    @Override // defpackage.fo2
    public final /* bridge */ /* synthetic */ void d(xv2 xv2) throws GeneralSecurityException {
        mx2.b(xv2.s(), 0);
    }

    /* Return type fixed from 'do2<zv2, xv2>' to match base method */
    @Override // defpackage.fo2
    public final do2<?, xv2> g() {
        return new bq2(this, zv2.class);
    }
}
