package defpackage;

import com.google.android.gms.internal.p000firebaseauthapi.zzwg;
import com.google.firebase.auth.internal.zzai;

/* renamed from: u03  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class u03 implements e63<zzwg> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f3440a;
    public final /* synthetic */ t43 b;
    public final /* synthetic */ y03 c;

    public u03(y03 y03, String str, t43 t43) {
        this.c = y03;
        this.f3440a = str;
        this.b = t43;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.e63
    public final void c(zzwg zzwg) {
        zzwg zzwg2 = zzwg;
        x73 x73 = new x73();
        String str = zzwg2.g;
        gj1.j(str);
        x73.f = str;
        x73.b(this.f3440a);
        y03.c(this.c, this.b, zzwg2, x73, this);
    }

    @Override // defpackage.e63
    public final void zza(String str) {
        this.b.d(zzai.zza(str));
    }
}
