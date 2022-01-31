package defpackage;

import com.google.android.gms.internal.p000firebaseauthapi.zzxg;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.internal.zzg;
import com.google.firebase.auth.internal.zzh;
import com.google.firebase.auth.internal.zzr;
import com.google.firebase.auth.internal.zzx;
import defpackage.d42;

/* renamed from: b23  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class b23 extends d63<AuthResult, zzg> {
    public final zzxg t;

    public b23(AuthCredential authCredential) {
        super(2);
        gj1.l(authCredential, "credential cannot be null");
        this.t = zzh.zza(authCredential, null);
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
        return "linkFederatedCredential";
    }

    @Override // defpackage.c13
    public final d42<u43, AuthResult> zzb() {
        d42.a builder = d42.builder();
        builder.f784a = new a23(this);
        return builder.a();
    }
}
