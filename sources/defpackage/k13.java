package defpackage;

import com.google.android.gms.internal.p000firebaseauthapi.zzlk;
import com.google.firebase.auth.internal.zzg;
import defpackage.d42;

/* renamed from: k13  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class k13 extends d63<Void, zzg> {
    public final zzlk t;

    public k13(String str, String str2, String str3) {
        super(4);
        gj1.i(str, "code cannot be null or empty");
        gj1.i(str2, "new password cannot be null or empty");
        this.t = new zzlk(str, str2, str3);
    }

    @Override // defpackage.d63
    public final void a() {
        g(null);
    }

    @Override // defpackage.c13
    public final String zza() {
        return "confirmPasswordReset";
    }

    @Override // defpackage.c13
    public final d42<u43, Void> zzb() {
        d42.a builder = d42.builder();
        builder.f784a = new j13(this);
        return builder.a();
    }
}
