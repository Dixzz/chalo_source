package defpackage;

import com.google.firebase.auth.internal.zzg;
import defpackage.d42;

/* renamed from: c43  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class c43 extends d63<Void, zzg> {
    public final String t;

    public c43(String str) {
        super(2);
        gj1.i(str, "email cannot be null or empty");
        this.t = str;
    }

    @Override // defpackage.d63
    public final void a() {
        this.e.zza(this.i, p43.e(this.c, this.j));
        g(null);
    }

    @Override // defpackage.c13
    public final String zza() {
        return "updateEmail";
    }

    @Override // defpackage.c13
    public final d42<u43, Void> zzb() {
        d42.a builder = d42.builder();
        builder.f784a = new b43(this);
        return builder.a();
    }
}
