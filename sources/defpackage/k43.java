package defpackage;

import com.google.android.gms.internal.p000firebaseauthapi.zznm;
import com.google.firebase.auth.ActionCodeSettings;
import defpackage.d42;
import java.util.Objects;

/* renamed from: k43  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class k43 extends d63<Void, Void> {
    public final zznm t;

    public k43(String str, String str2, ActionCodeSettings actionCodeSettings) {
        super(6);
        gj1.j(str);
        gj1.j(str2);
        Objects.requireNonNull(actionCodeSettings, "null reference");
        this.t = new zznm(str, str2, actionCodeSettings);
    }

    @Override // defpackage.d63
    public final void a() {
        g(null);
    }

    @Override // defpackage.c13
    public final String zza() {
        return "verifyBeforeUpdateEmail";
    }

    @Override // defpackage.c13
    public final d42<u43, Void> zzb() {
        d42.a builder = d42.builder();
        builder.f784a = new j43(this);
        return builder.a();
    }
}
