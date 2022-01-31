package defpackage;

import android.text.TextUtils;
import com.google.android.gms.internal.p000firebaseauthapi.zznq;
import com.google.firebase.auth.internal.zzai;

/* renamed from: r03  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class r03 implements e63<i83> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ t43 f3020a;
    public final /* synthetic */ y03 b;

    public r03(y03 y03, t43 t43) {
        this.b = y03;
        this.f3020a = t43;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.e63
    public final void c(i83 i83) {
        i83 i832 = i83;
        if (!(!TextUtils.isEmpty(i832.u))) {
            y03.b(this.b, i832, this.f3020a, this);
        } else {
            this.f3020a.e(new zznq(i832.u, i832.t, i832.a()));
        }
    }

    @Override // defpackage.e63
    public final void zza(String str) {
        this.f3020a.d(zzai.zza(str));
    }
}
