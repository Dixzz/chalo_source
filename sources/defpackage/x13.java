package defpackage;

import android.text.TextUtils;
import com.google.android.gms.internal.p000firebaseauthapi.zzlu;
import com.google.android.gms.internal.p000firebaseauthapi.zzwg;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.internal.zzay;
import com.google.firebase.auth.internal.zzg;
import defpackage.d42;
import java.util.Objects;

/* renamed from: x13  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class x13 extends d63<GetTokenResult, zzg> {
    public final zzlu t;

    public x13(String str) {
        super(1);
        gj1.i(str, "refresh token cannot be null");
        this.t = new zzlu(str);
    }

    @Override // defpackage.d63
    public final void a() {
        if (TextUtils.isEmpty(this.i.f)) {
            zzwg zzwg = this.i;
            String str = this.t.f;
            Objects.requireNonNull(zzwg);
            gj1.j(str);
            zzwg.f = str;
        }
        this.e.zza(this.i, this.d);
        g(zzay.zza(this.i.g));
    }

    @Override // defpackage.c13
    public final String zza() {
        return "getAccessToken";
    }

    @Override // defpackage.c13
    public final d42<u43, GetTokenResult> zzb() {
        d42.a builder = d42.builder();
        builder.f784a = new w13(this);
        return builder.a();
    }
}
