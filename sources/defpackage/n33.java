package defpackage;

import com.google.android.gms.internal.p000firebaseauthapi.zzmw;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.internal.zzg;
import com.google.firebase.auth.internal.zzr;
import com.google.firebase.auth.internal.zzx;
import defpackage.d42;

/* renamed from: n33  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class n33 extends d63<AuthResult, zzg> {
    public final zzmw t;

    public n33(EmailAuthCredential emailAuthCredential) {
        super(2);
        gj1.l(emailAuthCredential, "credential cannot be null");
        this.t = new zzmw(emailAuthCredential);
    }

    @Override // defpackage.d63
    public final void a() {
        zzx e = p43.e(this.c, this.j);
        this.e.zza(this.i, e);
        zzr zzr = new zzr(e);
        this.q = true;
        this.s.a(zzr, null);
    }

    @Override // defpackage.c13
    public final String zza() {
        return "sendSignInLinkToEmail";
    }

    @Override // defpackage.c13
    public final d42<u43, AuthResult> zzb() {
        d42.a builder = d42.builder();
        builder.f784a = new m33(this);
        return builder.a();
    }
}
