package defpackage;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p000firebaseauthapi.zzmy;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.internal.zzg;
import com.google.firebase.auth.internal.zzr;
import com.google.firebase.auth.internal.zzx;
import defpackage.d42;

/* renamed from: v23  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class v23 extends d63<AuthResult, zzg> {
    public final zzmy t;

    public v23(PhoneAuthCredential phoneAuthCredential, String str) {
        super(2);
        gj1.l(phoneAuthCredential, "credential cannot be null");
        phoneAuthCredential.zzf(false);
        this.t = new zzmy(phoneAuthCredential, str);
    }

    @Override // defpackage.d63
    public final void a() {
        zzx e = p43.e(this.c, this.j);
        if (this.d.getUid().equalsIgnoreCase(e.getUid())) {
            this.e.zza(this.i, e);
            zzr zzr = new zzr(e);
            this.q = true;
            this.s.a(zzr, null);
            return;
        }
        Status status = new Status(FirebaseError.ERROR_USER_MISMATCH, null);
        this.q = true;
        this.s.a(null, status);
    }

    @Override // defpackage.c13
    public final String zza() {
        return "reauthenticateWithPhoneCredentialWithData";
    }

    @Override // defpackage.c13
    public final d42<u43, AuthResult> zzb() {
        d42.a builder = d42.builder();
        builder.f784a = new u23(this);
        return builder.a();
    }
}
