package defpackage;

import android.text.TextUtils;
import com.google.android.gms.internal.p000firebaseauthapi.zznq;
import com.google.android.gms.internal.p000firebaseauthapi.zzwg;
import com.google.firebase.auth.internal.zzai;

/* renamed from: kz2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class kz2 implements e63<a73> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ t43 f2141a;
    public final /* synthetic */ y03 b;

    public kz2(y03 y03, t43 t43) {
        this.b = y03;
        this.f2141a = t43;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.e63
    public final void c(a73 a73) {
        a73 a732 = a73;
        if (!TextUtils.isEmpty(a732.k)) {
            this.f2141a.e(new zznq(a732.k, a732.j, null));
            return;
        }
        this.b.f(new zzwg(a732.g, a732.f, Long.valueOf(a732.i), "Bearer"), null, null, Boolean.valueOf(a732.h), null, this.f2141a, this);
    }

    @Override // defpackage.e63
    public final void zza(String str) {
        this.f2141a.d(zzai.zza(str));
    }
}
