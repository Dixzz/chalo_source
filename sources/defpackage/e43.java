package defpackage;

import com.google.firebase.auth.internal.zzg;
import defpackage.d42;

/* renamed from: e43  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class e43 extends d63<Void, zzg> {
    public final String t;

    public e43(String str) {
        super(2);
        gj1.i(str, "password cannot be null or empty");
        this.t = str;
    }

    @Override // defpackage.d63
    public final void a() {
        this.e.zza(this.i, p43.e(this.c, this.j));
        g(null);
    }

    @Override // defpackage.c13
    public final String zza() {
        return "updatePassword";
    }

    @Override // defpackage.c13
    public final d42<u43, Void> zzb() {
        d42.a builder = d42.builder();
        builder.f784a = new d43(this);
        return builder.a();
    }
}
