package defpackage;

import com.google.android.gms.internal.p000firebaseauthapi.zzwg;
import com.google.firebase.auth.internal.zzai;

/* renamed from: uz2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class uz2 implements e63<o83> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ t43 f3573a;
    public final /* synthetic */ y03 b;

    public uz2(y03 y03, t43 t43) {
        this.b = y03;
        this.f3573a = t43;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.e63
    public final void c(o83 o83) {
        o83 o832 = o83;
        this.b.f(new zzwg(o832.g, o832.f, Long.valueOf(o832.h), "Bearer"), null, null, Boolean.valueOf(o832.i), null, this.f3573a, this);
    }

    @Override // defpackage.e63
    public final void zza(String str) {
        this.f3573a.d(zzai.zza(str));
    }
}
