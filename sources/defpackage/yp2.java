package defpackage;

import java.security.GeneralSecurityException;

/* renamed from: yp2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class yp2 extends fo2<sv2> {
    public yp2() {
        super(sv2.class, new wp2(vn2.class));
    }

    @Override // defpackage.fo2
    public final String a() {
        return "type.googleapis.com/google.crypto.tink.KmsAeadKey";
    }

    @Override // defpackage.fo2
    public final wu2 b() {
        return wu2.REMOTE;
    }

    /* Return type fixed from 'bm2' to match base method */
    @Override // defpackage.fo2
    public final /* bridge */ /* synthetic */ sv2 c(g93 g93) throws ma3 {
        return sv2.u(g93, s93.a());
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [bm2] */
    @Override // defpackage.fo2
    public final /* bridge */ /* synthetic */ void d(sv2 sv2) throws GeneralSecurityException {
        mx2.b(sv2.s(), 0);
    }

    /* Return type fixed from 'do2<uv2, sv2>' to match base method */
    @Override // defpackage.fo2
    public final do2<?, sv2> g() {
        return new xp2(this, uv2.class);
    }
}
