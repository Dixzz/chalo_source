package defpackage;

import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.internal.zzg;
import defpackage.d42;
import java.util.Objects;

/* renamed from: g43  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class g43 extends d63<Void, zzg> {
    public final PhoneAuthCredential t;

    public g43(PhoneAuthCredential phoneAuthCredential) {
        super(2);
        Objects.requireNonNull(phoneAuthCredential, "null reference");
        this.t = phoneAuthCredential;
    }

    @Override // defpackage.d63
    public final void a() {
        this.e.zza(this.i, p43.e(this.c, this.j));
        g(null);
    }

    @Override // defpackage.c13
    public final String zza() {
        return "updatePhoneNumber";
    }

    @Override // defpackage.c13
    public final d42<u43, Void> zzb() {
        d42.a builder = d42.builder();
        builder.f784a = new f43(this);
        return builder.a();
    }
}
