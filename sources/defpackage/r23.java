package defpackage;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p000firebaseauthapi.zzmu;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.internal.zzg;
import com.google.firebase.auth.internal.zzr;
import com.google.firebase.auth.internal.zzx;
import defpackage.d42;

/* renamed from: r23  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class r23 extends d63<AuthResult, zzg> {
    public final zzmu t;

    public r23(String str, String str2, String str3) {
        super(2);
        gj1.i(str, "email cannot be null or empty");
        gj1.i(str2, "password cannot be null or empty");
        this.t = new zzmu(str, str2, str3);
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
        return "reauthenticateWithEmailPasswordWithData";
    }

    @Override // defpackage.c13
    public final d42<u43, AuthResult> zzb() {
        d42.a builder = d42.builder();
        builder.f784a = new q23(this);
        return builder.a();
    }
}
