package defpackage;

import com.google.android.gms.internal.p000firebaseauthapi.zzmy;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.internal.zzg;
import com.google.firebase.auth.internal.zzr;
import com.google.firebase.auth.internal.zzx;
import defpackage.d42;
import java.util.Objects;

/* renamed from: p33  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class p33 extends d63<AuthResult, zzg> {
    public final zzmy t;

    public p33(PhoneAuthCredential phoneAuthCredential, String str) {
        super(2);
        Objects.requireNonNull(phoneAuthCredential, "null reference");
        this.t = new zzmy(phoneAuthCredential, str);
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
        return "signInWithPhoneNumber";
    }

    @Override // defpackage.c13
    public final d42<u43, AuthResult> zzb() {
        d42.a builder = d42.builder();
        builder.f784a = new o33(this);
        return builder.a();
    }
}
