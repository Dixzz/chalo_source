package defpackage;

import com.google.android.gms.internal.p000firebaseauthapi.zzms;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.internal.zzg;
import com.google.firebase.auth.internal.zzr;
import com.google.firebase.auth.internal.zzx;
import defpackage.d42;

/* renamed from: j33  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class j33 extends d63<AuthResult, zzg> {
    public final zzms t;

    public j33(String str, String str2) {
        super(2);
        gj1.i(str, "token cannot be null or empty");
        this.t = new zzms(str, str2);
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
        return "signInWithCustomToken";
    }

    @Override // defpackage.c13
    public final d42<u43, AuthResult> zzb() {
        d42.a builder = d42.builder();
        builder.f784a = new i33(this);
        return builder.a();
    }
}
