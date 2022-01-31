package defpackage;

import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.internal.zzg;
import defpackage.d42;

/* renamed from: i43  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class i43 extends d63<Void, zzg> {
    public final UserProfileChangeRequest t;

    public i43(UserProfileChangeRequest userProfileChangeRequest) {
        super(2);
        gj1.l(userProfileChangeRequest, "request cannot be null");
        this.t = userProfileChangeRequest;
    }

    @Override // defpackage.d63
    public final void a() {
        this.e.zza(this.i, p43.e(this.c, this.j));
        g(null);
    }

    @Override // defpackage.c13
    public final String zza() {
        return "updateProfile";
    }

    @Override // defpackage.c13
    public final d42<u43, Void> zzb() {
        d42.a builder = d42.builder();
        builder.f784a = new h43(this);
        return builder.a();
    }
}
