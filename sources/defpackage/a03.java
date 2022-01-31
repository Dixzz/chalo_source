package defpackage;

import com.google.android.gms.internal.p000firebaseauthapi.zzwg;
import com.google.firebase.auth.internal.zzai;

/* renamed from: a03  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class a03 implements e63<zzwg> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ t43 f99a;
    public final /* synthetic */ y03 b;

    public a03(y03 y03, t43 t43) {
        this.b = y03;
        this.f99a = t43;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.e63
    public final void c(zzwg zzwg) {
        zzwg zzwg2 = zzwg;
        x73 x73 = new x73();
        String str = zzwg2.g;
        gj1.j(str);
        x73.f = str;
        x73.b(null);
        x73.c(null);
        y03.c(this.b, this.f99a, zzwg2, x73, this);
    }

    @Override // defpackage.e63
    public final void zza(String str) {
        this.f99a.d(zzai.zza(str));
    }
}
