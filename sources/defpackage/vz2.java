package defpackage;

import com.google.android.gms.internal.p000firebaseauthapi.zzwg;
import com.google.firebase.auth.internal.zzai;

/* renamed from: vz2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class vz2 implements e63<zzwg> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f3695a;
    public final /* synthetic */ String b;
    public final /* synthetic */ t43 c;
    public final /* synthetic */ y03 d;

    public vz2(y03 y03, String str, String str2, t43 t43) {
        this.d = y03;
        this.f3695a = str;
        this.b = str2;
        this.c = t43;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.e63
    public final void c(zzwg zzwg) {
        zzwg zzwg2 = zzwg;
        x73 x73 = new x73();
        String str = zzwg2.g;
        gj1.j(str);
        x73.f = str;
        x73.b(this.f3695a);
        x73.c(this.b);
        y03.c(this.d, this.c, zzwg2, x73, this);
    }

    @Override // defpackage.e63
    public final void zza(String str) {
        this.c.d(zzai.zza(str));
    }
}
