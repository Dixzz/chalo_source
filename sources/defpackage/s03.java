package defpackage;

import com.google.android.gms.internal.p000firebaseauthapi.zzwg;
import com.google.firebase.auth.internal.zzai;

/* renamed from: s03  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class s03 implements e63<a83> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ t43 f3158a;
    public final /* synthetic */ y03 b;

    public s03(y03 y03, t43 t43) {
        this.b = y03;
        this.f3158a = t43;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.e63
    public final void c(a83 a83) {
        a83 a832 = a83;
        this.b.f(new zzwg(a832.g, a832.f, Long.valueOf(a832.h), "Bearer"), null, null, Boolean.TRUE, null, this.f3158a, this);
    }

    @Override // defpackage.e63
    public final void zza(String str) {
        this.f3158a.d(zzai.zza(str));
    }
}
