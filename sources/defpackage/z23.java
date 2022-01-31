package defpackage;

import com.google.android.gms.internal.p000firebaseauthapi.zzmg;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.internal.zzg;
import defpackage.d42;

/* renamed from: z23  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class z23 extends d63<Void, zzg> {
    public final zzmg t;

    public z23(String str, ActionCodeSettings actionCodeSettings) {
        super(6);
        gj1.i(str, "token cannot be null or empty");
        this.t = new zzmg(str, actionCodeSettings);
    }

    @Override // defpackage.d63
    public final void a() {
        g(null);
    }

    @Override // defpackage.c13
    public final String zza() {
        return "sendEmailVerification";
    }

    @Override // defpackage.c13
    public final d42<u43, Void> zzb() {
        d42.a builder = d42.builder();
        builder.f784a = new y23(this);
        return builder.a();
    }
}
