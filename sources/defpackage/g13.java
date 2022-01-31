package defpackage;

import com.google.android.gms.internal.p000firebaseauthapi.zzlc;
import com.google.firebase.auth.internal.zzg;
import defpackage.d42;

/* renamed from: g13  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class g13 extends d63<Void, zzg> {
    public final zzlc t;

    public g13(String str, String str2) {
        super(7);
        gj1.i(str, "code cannot be null or empty");
        this.t = new zzlc(str, str2);
    }

    @Override // defpackage.d63
    public final void a() {
        g(null);
    }

    @Override // defpackage.c13
    public final String zza() {
        return "applyActionCode";
    }

    @Override // defpackage.c13
    public final d42<u43, Void> zzb() {
        d42.a builder = d42.builder();
        builder.f784a = new f13(this);
        return builder.a();
    }
}
