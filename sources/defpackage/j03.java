package defpackage;

import com.google.android.gms.internal.p000firebaseauthapi.zzwg;
import com.google.firebase.auth.internal.zzai;

/* renamed from: j03  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class j03 implements e63<e73> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ t43 f1859a;
    public final /* synthetic */ y03 b;

    public j03(y03 y03, t43 t43) {
        this.b = y03;
        this.f1859a = t43;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.e63
    public final void c(e73 e73) {
        e73 e732 = e73;
        this.b.f(new zzwg(e732.g, e732.f, Long.valueOf(gj1.P0(e732.f)), "Bearer"), null, null, Boolean.FALSE, null, this.f1859a, this);
    }

    @Override // defpackage.e63
    public final void zza(String str) {
        this.f1859a.d(zzai.zza(str));
    }
}
