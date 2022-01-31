package defpackage;

import com.google.android.gms.internal.p000firebaseauthapi.zzmi;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.internal.zzg;
import defpackage.d42;

/* renamed from: b33  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class b33 extends d63<Void, zzg> {
    public final zzmi t;
    public final String u;

    public b33(String str, ActionCodeSettings actionCodeSettings, String str2, String str3) {
        super(4);
        gj1.i(str, "email cannot be null or empty");
        this.t = new zzmi(str, actionCodeSettings, str2);
        this.u = str3;
    }

    @Override // defpackage.d63
    public final void a() {
        g(null);
    }

    @Override // defpackage.c13
    public final String zza() {
        return this.u;
    }

    @Override // defpackage.c13
    public final d42<u43, Void> zzb() {
        d42.a builder = d42.builder();
        builder.f784a = new a33(this);
        return builder.a();
    }
}
