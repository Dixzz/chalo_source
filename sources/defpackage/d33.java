package defpackage;

import com.google.android.gms.internal.p000firebaseauthapi.zzmm;
import com.google.firebase.auth.internal.zzg;
import defpackage.d42;

/* renamed from: d33  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class d33 extends d63<Void, zzg> {
    public final zzmm t;

    public d33(String str) {
        super(9);
        this.t = new zzmm(str);
    }

    @Override // defpackage.d63
    public final void a() {
        g(null);
    }

    @Override // defpackage.c13
    public final String zza() {
        return "setFirebaseUIVersion";
    }

    @Override // defpackage.c13
    public final d42<u43, Void> zzb() {
        d42.a builder = d42.builder();
        builder.f784a = new c33(this);
        return builder.a();
    }
}
