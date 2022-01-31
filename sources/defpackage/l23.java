package defpackage;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p000firebaseauthapi.zzmw;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.internal.zzg;
import com.google.firebase.auth.internal.zzx;
import defpackage.d42;

/* renamed from: l23  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class l23 extends d63<Void, zzg> {
    public final zzmw t;

    public l23(EmailAuthCredential emailAuthCredential) {
        super(2);
        gj1.l(emailAuthCredential, "Credential cannot be null");
        this.t = new zzmw(emailAuthCredential);
    }

    @Override // defpackage.d63
    public final void a() {
        zzx e = p43.e(this.c, this.j);
        if (this.d.getUid().equalsIgnoreCase(e.getUid())) {
            this.e.zza(this.i, e);
            g(null);
            return;
        }
        Status status = new Status(FirebaseError.ERROR_USER_MISMATCH, null);
        this.q = true;
        this.s.a(null, status);
    }

    @Override // defpackage.c13
    public final String zza() {
        return "reauthenticateWithEmailLink";
    }

    @Override // defpackage.c13
    public final d42<u43, Void> zzb() {
        d42.a builder = d42.builder();
        builder.f784a = new k23(this);
        return builder.a();
    }
}
