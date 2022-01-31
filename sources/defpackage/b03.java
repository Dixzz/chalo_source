package defpackage;

import com.google.android.gms.internal.p000firebaseauthapi.zzvx;
import com.google.android.gms.internal.p000firebaseauthapi.zzvz;
import com.google.android.gms.internal.p000firebaseauthapi.zzwg;
import com.google.firebase.auth.internal.zzai;
import java.util.List;

/* renamed from: b03  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class b03 implements e63<zzvx> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e63 f360a;
    public final /* synthetic */ zzwg b;
    public final /* synthetic */ c03 c;

    public b03(c03 c03, e63 e63, zzwg zzwg) {
        this.c = c03;
        this.f360a = e63;
        this.b = zzwg;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.e63
    public final void c(zzvx zzvx) {
        List<zzvz> list = zzvx.f.f;
        if (list == null || list.isEmpty()) {
            this.f360a.zza("No users.");
            return;
        }
        zzvz zzvz = list.get(0);
        x73 x73 = new x73();
        String str = this.b.g;
        gj1.j(str);
        x73.f = str;
        String str2 = this.c.f499a;
        gj1.j(str2);
        x73.m.g.add(str2);
        c03 c03 = this.c;
        y03.d(c03.c, c03.b, this.b, zzvz, x73, this.f360a);
    }

    @Override // defpackage.e63
    public final void zza(String str) {
        this.c.b.d(zzai.zza(str));
    }
}
