package defpackage;

import com.google.android.gms.internal.p000firebaseauthapi.zzvx;
import com.google.android.gms.internal.p000firebaseauthapi.zzvz;
import com.google.android.gms.internal.p000firebaseauthapi.zzwg;
import java.util.List;

/* renamed from: lz2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class lz2 implements e63<zzvx> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e63 f2298a;
    public final /* synthetic */ t43 b;
    public final /* synthetic */ zzwg c;
    public final /* synthetic */ x73 d;
    public final /* synthetic */ y03 e;

    public lz2(y03 y03, e63 e63, t43 t43, zzwg zzwg, x73 x73) {
        this.e = y03;
        this.f2298a = e63;
        this.b = t43;
        this.c = zzwg;
        this.d = x73;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.e63
    public final void c(zzvx zzvx) {
        List<zzvz> list = zzvx.f.f;
        if (list == null || list.isEmpty()) {
            this.f2298a.zza("No users");
        } else {
            y03.d(this.e, this.b, this.c, list.get(0), this.d, this.f2298a);
        }
    }

    @Override // defpackage.e63
    public final void zza(String str) {
        this.f2298a.zza(str);
    }
}
