package defpackage;

import android.text.TextUtils;
import com.google.android.gms.internal.p000firebaseauthapi.zznq;
import com.google.android.gms.internal.p000firebaseauthapi.zzwg;
import com.google.firebase.auth.internal.zzai;

/* renamed from: iz2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class iz2 implements e63<m83> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ t43 f1586a;
    public final /* synthetic */ y03 b;

    public iz2(y03 y03, t43 t43) {
        this.b = y03;
        this.f1586a = t43;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.e63
    public final void c(m83 m83) {
        m83 m832 = m83;
        if (!TextUtils.isEmpty(m832.j)) {
            this.f1586a.e(new zznq(m832.j, m832.i, null));
            return;
        }
        this.b.f(new zzwg(m832.g, m832.f, Long.valueOf(m832.h), "Bearer"), null, null, Boolean.FALSE, null, this.f1586a, this);
    }

    @Override // defpackage.e63
    public final void zza(String str) {
        this.f1586a.d(zzai.zza(str));
    }
}
