package defpackage;

import com.google.android.gms.internal.p000firebaseauthapi.zzlq;
import com.google.firebase.auth.PhoneMultiFactorAssertion;
import com.google.firebase.auth.internal.zzg;
import defpackage.d42;
import java.util.Objects;

/* renamed from: t13  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class t13 extends d63<Void, zzg> {
    public final zzlq t;

    public t13(PhoneMultiFactorAssertion phoneMultiFactorAssertion, String str, String str2) {
        super(2);
        Objects.requireNonNull(phoneMultiFactorAssertion, "null reference");
        gj1.j(str);
        this.t = new zzlq(phoneMultiFactorAssertion.zza(), str, str2);
    }

    @Override // defpackage.d63
    public final void a() {
        this.e.zza(this.i, p43.e(this.c, this.j));
        g(null);
    }

    @Override // defpackage.c13
    public final String zza() {
        return "finalizeMfaEnrollment";
    }

    @Override // defpackage.c13
    public final d42<u43, Void> zzb() {
        d42.a builder = d42.builder();
        builder.f784a = new s13(this);
        return builder.a();
    }
}
