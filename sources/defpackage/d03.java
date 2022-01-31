package defpackage;

import android.text.TextUtils;
import com.google.android.gms.internal.p000firebaseauthapi.zzwg;
import com.google.firebase.auth.internal.zzai;

/* renamed from: d03  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class d03 implements e63<q83> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e03 f773a;

    public d03(e03 e03) {
        this.f773a = e03;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.e63
    public final void c(q83 q83) {
        q83 q832 = q83;
        if (TextUtils.isEmpty(q832.f) || TextUtils.isEmpty(q832.g)) {
            this.f773a.b.d(zzai.zza("INTERNAL_SUCCESS_SIGN_OUT"));
            return;
        }
        zzwg zzwg = new zzwg(q832.g, q832.f, Long.valueOf(gj1.P0(q832.f)), "Bearer");
        e03 e03 = this.f773a;
        e03.c.f(zzwg, null, null, Boolean.FALSE, null, e03.b, this);
    }

    @Override // defpackage.e63
    public final void zza(String str) {
        this.f773a.b.d(zzai.zza(str));
    }
}
