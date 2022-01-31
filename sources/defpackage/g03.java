package defpackage;

import com.google.android.gms.internal.p000firebaseauthapi.zzwg;
import com.google.android.gms.internal.p000firebaseauthapi.zzxk;
import com.google.firebase.auth.internal.zzai;

/* renamed from: g03  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class g03 implements e63<zzxk> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ t43 f1197a;
    public final /* synthetic */ y03 b;

    public g03(y03 y03, t43 t43) {
        this.b = y03;
        this.f1197a = t43;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.e63
    public final void c(zzxk zzxk) {
        zzxk zzxk2 = zzxk;
        this.b.f(new zzwg(zzxk2.g, zzxk2.f, Long.valueOf(zzxk2.h), "Bearer"), null, null, Boolean.valueOf(zzxk2.i), null, this.f1197a, this);
    }

    @Override // defpackage.e63
    public final void zza(String str) {
        this.f1197a.d(zzai.zza(str));
    }
}
