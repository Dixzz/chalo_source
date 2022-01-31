package defpackage;

import android.text.TextUtils;
import com.google.android.gms.internal.p000firebaseauthapi.zzvx;
import com.google.android.gms.internal.p000firebaseauthapi.zzvz;
import com.google.android.gms.internal.p000firebaseauthapi.zzwg;
import com.google.android.gms.internal.p000firebaseauthapi.zzwm;
import com.google.android.gms.internal.p000firebaseauthapi.zzwo;
import com.google.firebase.auth.zze;
import java.util.List;

/* renamed from: nz2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class nz2 implements e63<zzvx> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e63 f2624a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ Boolean d;
    public final /* synthetic */ zze e;
    public final /* synthetic */ t43 f;
    public final /* synthetic */ zzwg g;

    public nz2(e63 e63, String str, String str2, Boolean bool, zze zze, t43 t43, zzwg zzwg) {
        this.f2624a = e63;
        this.b = str;
        this.c = str2;
        this.d = bool;
        this.e = zze;
        this.f = t43;
        this.g = zzwg;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.e63
    public final void c(zzvx zzvx) {
        List<zzvz> list = zzvx.f.f;
        if (list == null || list.isEmpty()) {
            this.f2624a.zza("No users.");
            return;
        }
        int i = 0;
        zzvz zzvz = list.get(0);
        zzwo zzwo = zzvz.k;
        List<zzwm> list2 = zzwo != null ? zzwo.f : null;
        if (list2 != null && !list2.isEmpty()) {
            if (!TextUtils.isEmpty(this.b)) {
                while (true) {
                    if (i >= list2.size()) {
                        break;
                    } else if (list2.get(i).i.equals(this.b)) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
            list2.get(i).j = this.c;
        }
        zzvz.p = this.d.booleanValue();
        zzvz.q = this.e;
        this.f.a(this.g, zzvz);
    }

    @Override // defpackage.e63
    public final void zza(String str) {
        this.f2624a.zza(str);
    }
}
