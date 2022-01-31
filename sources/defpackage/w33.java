package defpackage;

import com.google.android.gms.internal.p000firebaseauthapi.zzne;
import com.google.firebase.auth.internal.zzg;
import defpackage.d42;
import java.util.Objects;

/* renamed from: w33  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class w33 extends d63<Void, zzg> {
    public final zzne t;

    public w33(String str, String str2) {
        super(2);
        gj1.j(str);
        Objects.requireNonNull(str2, "null reference");
        this.t = new zzne(str, str2);
    }

    @Override // defpackage.d63
    public final void a() {
        this.e.zza(this.i, p43.e(this.c, this.j));
        g(null);
    }

    @Override // defpackage.c13
    public final String zza() {
        return "unenrollMfa";
    }

    @Override // defpackage.c13
    public final d42<u43, Void> zzb() {
        d42.a builder = d42.builder();
        builder.f784a = new v33(this);
        return builder.a();
    }
}
