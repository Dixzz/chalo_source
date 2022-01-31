package defpackage;

import com.google.android.gms.internal.p000firebaseauthapi.zznc;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import defpackage.d42;
import java.util.Objects;

/* renamed from: u33  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class u33 extends d63<Void, PhoneAuthProvider.OnVerificationStateChangedCallbacks> {
    public final zznc t;

    public u33(PhoneMultiFactorInfo phoneMultiFactorInfo, String str, String str2, long j, boolean z, boolean z2, String str3, String str4, boolean z3) {
        super(8);
        Objects.requireNonNull(phoneMultiFactorInfo, "null reference");
        gj1.j(str);
        this.t = new zznc(phoneMultiFactorInfo, str, str2, j, z, z2, str3, str4, z3);
    }

    @Override // defpackage.d63
    public final void a() {
    }

    @Override // defpackage.c13
    public final String zza() {
        return "startMfaSignInWithPhoneNumber";
    }

    @Override // defpackage.c13
    public final d42<u43, Void> zzb() {
        d42.a builder = d42.builder();
        builder.f784a = new t33(this);
        return builder.a();
    }
}
