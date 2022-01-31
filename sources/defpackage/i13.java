package defpackage;

import com.google.android.gms.internal.p000firebaseauthapi.zzli;
import com.google.firebase.auth.ActionCodeResult;
import com.google.firebase.auth.internal.zzg;
import com.google.firebase.auth.internal.zzo;
import defpackage.d42;

/* renamed from: i13  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class i13 extends d63<ActionCodeResult, zzg> {
    public final zzli t;

    public i13(String str, String str2) {
        super(4);
        gj1.i(str, "code cannot be null or empty");
        this.t = new zzli(str, str2);
    }

    @Override // defpackage.d63
    public final void a() {
        zzo zzo = new zzo(this.l);
        this.q = true;
        this.s.a(zzo, null);
    }

    @Override // defpackage.c13
    public final String zza() {
        return "checkActionCode";
    }

    @Override // defpackage.c13
    public final d42<u43, ActionCodeResult> zzb() {
        d42.a builder = d42.builder();
        builder.f784a = new h13(this);
        return builder.a();
    }
}
