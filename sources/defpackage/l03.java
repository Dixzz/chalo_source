package defpackage;

import com.google.android.gms.internal.p000firebaseauthapi.zzvx;
import com.google.android.gms.internal.p000firebaseauthapi.zzvz;
import com.google.android.gms.internal.p000firebaseauthapi.zzwg;
import java.util.List;

/* renamed from: l03  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class l03 implements e63<zzvx> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e63 f2146a;
    public final /* synthetic */ zzwg b;
    public final /* synthetic */ m03 c;

    public l03(m03 m03, e63 e63, zzwg zzwg) {
        this.c = m03;
        this.f2146a = e63;
        this.b = zzwg;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.e63
    public final void c(zzvx zzvx) {
        List<zzvz> list = zzvx.f.f;
        if (list == null || list.isEmpty()) {
            this.f2146a.zza("No users");
        } else {
            this.c.f2302a.a(this.b, list.get(0));
        }
    }

    @Override // defpackage.e63
    public final void zza(String str) {
        this.f2146a.zza(str);
    }
}
