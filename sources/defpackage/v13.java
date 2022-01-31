package defpackage;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p000firebaseauthapi.zzls;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneMultiFactorAssertion;
import com.google.firebase.auth.internal.zzg;
import com.google.firebase.auth.internal.zzr;
import com.google.firebase.auth.internal.zzx;
import defpackage.d42;
import java.util.Objects;

/* renamed from: v13  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class v13 extends d63<AuthResult, zzg> {
    public final zzls t;

    public v13(PhoneMultiFactorAssertion phoneMultiFactorAssertion, String str) {
        super(2);
        Objects.requireNonNull(phoneMultiFactorAssertion, "null reference");
        gj1.j(str);
        this.t = new zzls(phoneMultiFactorAssertion.zza(), str);
    }

    @Override // defpackage.d63
    public final void a() {
        zzx e = p43.e(this.c, this.j);
        FirebaseUser firebaseUser = this.d;
        if (firebaseUser == null || firebaseUser.getUid().equalsIgnoreCase(e.getUid())) {
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
        return "finalizeMfaSignIn";
    }

    @Override // defpackage.c13
    public final d42<u43, AuthResult> zzb() {
        d42.a builder = d42.builder();
        builder.f784a = new u13(this);
        return builder.a();
    }
}
