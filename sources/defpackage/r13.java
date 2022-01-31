package defpackage;

import com.google.android.gms.internal.p000firebaseauthapi.zzlw;
import com.google.firebase.auth.SignInMethodQueryResult;
import com.google.firebase.auth.internal.zzaj;
import com.google.firebase.auth.internal.zzg;
import defpackage.d42;

/* renamed from: r13  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class r13 extends d63<SignInMethodQueryResult, zzg> {
    public final zzlw t;

    public r13(String str, String str2) {
        super(3);
        gj1.i(str, "email cannot be null or empty");
        this.t = new zzlw(str, str2);
    }

    @Override // defpackage.d63
    public final void a() {
        zzaj zzaj = new zzaj(this.k.k);
        this.q = true;
        this.s.a(zzaj, null);
    }

    @Override // defpackage.c13
    public final String zza() {
        return "fetchSignInMethodsForEmail";
    }

    @Override // defpackage.c13
    public final d42<u43, SignInMethodQueryResult> zzb() {
        d42.a builder = d42.builder();
        builder.f784a = new q13(this);
        return builder.a();
    }
}
