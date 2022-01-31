package defpackage;

import com.google.android.gms.internal.p000firebaseauthapi.zzna;
import com.google.firebase.auth.internal.zzag;
import com.google.firebase.auth.internal.zzg;
import defpackage.d42;
import java.util.Objects;

/* renamed from: s33  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class s33 extends d63<Void, zzg> {
    public final zzna t;

    public s33(zzag zzag, String str, String str2, long j, boolean z, boolean z2, String str3, String str4, boolean z3) {
        super(8);
        Objects.requireNonNull(zzag, "null reference");
        gj1.j(str);
        this.t = new zzna(zzag.zzc(), str, str2, j, z, z2, str3, str4, z3);
    }

    @Override // defpackage.d63
    public final void a() {
    }

    @Override // defpackage.c13
    public final String zza() {
        return "startMfaEnrollmentWithPhoneNumber";
    }

    @Override // defpackage.c13
    public final d42<u43, Void> zzb() {
        d42.a builder = d42.builder();
        builder.f784a = new r33(this);
        return builder.a();
    }
}
