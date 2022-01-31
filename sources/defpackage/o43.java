package defpackage;

import com.google.android.gms.internal.p000firebaseauthapi.zzmk;
import com.google.android.gms.internal.p000firebaseauthapi.zzwt;
import com.google.firebase.auth.PhoneAuthProvider;
import defpackage.d42;
import java.util.Objects;

/* renamed from: o43  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class o43 extends d63<Void, PhoneAuthProvider.OnVerificationStateChangedCallbacks> {
    public final zzmk t;

    public o43(zzwt zzwt) {
        super(8);
        Objects.requireNonNull(zzwt, "null reference");
        this.t = new zzmk(zzwt);
    }

    @Override // defpackage.d63
    public final void a() {
    }

    @Override // defpackage.c13
    public final String zza() {
        return "verifyPhoneNumber";
    }

    @Override // defpackage.c13
    public final d42<u43, Void> zzb() {
        d42.a builder = d42.builder();
        builder.f784a = new n43(this);
        return builder.a();
    }
}
