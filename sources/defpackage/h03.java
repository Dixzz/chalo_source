package defpackage;

import com.google.android.gms.internal.p000firebaseauthapi.zzwg;
import com.google.firebase.auth.internal.zzai;

/* renamed from: h03  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class h03 implements e63<c73> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ i03 f1324a;

    public h03(i03 i03) {
        this.f1324a = i03;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.e63
    public final void c(c73 c73) {
        c73 c732 = c73;
        zzwg zzwg = new zzwg(c732.g, c732.f, Long.valueOf(gj1.P0(c732.f)), "Bearer");
        i03 i03 = this.f1324a;
        i03.c.f(zzwg, null, null, Boolean.FALSE, null, i03.b, this);
    }

    @Override // defpackage.e63
    public final void zza(String str) {
        this.f1324a.b.d(zzai.zza(str));
    }
}
