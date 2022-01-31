package defpackage;

import com.google.android.gms.internal.p000firebaseauthapi.zzmo;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.internal.zzg;
import com.google.firebase.auth.internal.zzr;
import com.google.firebase.auth.internal.zzx;
import defpackage.d42;

/* renamed from: f33  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class f33 extends d63<AuthResult, zzg> {
    public final zzmo t;

    public f33(String str) {
        super(2);
        this.t = new zzmo(str);
    }

    @Override // defpackage.d63
    public final void a() {
        zzx e = p43.e(this.c, this.j);
        this.e.zza(this.i, e);
        zzr zzr = new zzr(e);
        this.q = true;
        this.s.a(zzr, null);
    }

    @Override // defpackage.c13
    public final String zza() {
        return "signInAnonymously";
    }

    @Override // defpackage.c13
    public final d42<u43, AuthResult> zzb() {
        d42.a builder = d42.builder();
        builder.f784a = new e33(this);
        return builder.a();
    }
}
