package defpackage;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p000firebaseauthapi.zzli;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.internal.zzg;
import com.google.firebase.auth.internal.zzo;
import defpackage.d42;

/* renamed from: m43  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class m43 extends d63<String, zzg> {
    public final zzli t;

    public m43(String str, String str2) {
        super(4);
        gj1.i(str, "code cannot be null or empty");
        this.t = new zzli(str, str2);
    }

    @Override // defpackage.d63
    public final void a() {
        if (new zzo(this.l).getOperation() != 0) {
            Status status = new Status(FirebaseError.ERROR_INTERNAL_ERROR, null);
            this.q = true;
            this.s.a(null, status);
            return;
        }
        g(this.l.f);
    }

    @Override // defpackage.c13
    public final String zza() {
        return "verifyPasswordResetCode";
    }

    @Override // defpackage.c13
    public final d42<u43, String> zzb() {
        d42.a builder = d42.builder();
        builder.f784a = new l43(this);
        return builder.a();
    }
}
