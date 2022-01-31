package defpackage;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p000firebaseauthapi.zzmq;
import com.google.android.gms.internal.p000firebaseauthapi.zzxg;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.internal.zzg;
import com.google.firebase.auth.internal.zzh;
import com.google.firebase.auth.internal.zzr;
import com.google.firebase.auth.internal.zzx;
import defpackage.d42;

/* renamed from: j23  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class j23 extends d63<AuthResult, zzg> {
    public final zzmq t;

    public j23(AuthCredential authCredential, String str) {
        super(2);
        gj1.l(authCredential, "credential cannot be null");
        zzxg zza = zzh.zza(authCredential, str);
        zza.o = false;
        this.t = new zzmq(zza);
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
        return "reauthenticateWithCredentialWithData";
    }

    @Override // defpackage.c13
    public final d42<u43, AuthResult> zzb() {
        d42.a builder = d42.builder();
        builder.f784a = new i23(this);
        return builder.a();
    }
}
