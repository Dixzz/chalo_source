package defpackage;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zav;
import com.google.android.gms.signin.internal.zak;
import java.util.Objects;

/* renamed from: r42  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class r42 extends f52 {
    public final /* synthetic */ v42 b;
    public final /* synthetic */ zak c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public r42(e52 e52, v42 v42, zak zak) {
        super(e52);
        this.b = v42;
        this.c = zak;
    }

    @Override // defpackage.f52
    public final void a() {
        v42 v42 = this.b;
        zak zak = this.c;
        boolean z = false;
        if (v42.p(0)) {
            ConnectionResult connectionResult = zak.g;
            if (connectionResult.m1()) {
                zav zav = zak.h;
                Objects.requireNonNull(zav, "null reference");
                connectionResult = zav.h;
                if (!connectionResult.m1()) {
                    String valueOf = String.valueOf(connectionResult);
                    Log.wtf("GACConnecting", hj1.a0(new StringBuilder(valueOf.length() + 48), "Sign-in succeeded with resolve account failure: ", valueOf), new Exception());
                    v42.m(connectionResult);
                    return;
                }
                v42.n = true;
                c82 l1 = zav.l1();
                Objects.requireNonNull(l1, "null reference");
                v42.o = l1;
                v42.p = zav.i;
                v42.q = zav.j;
            } else {
                if (v42.l && !connectionResult.l1()) {
                    z = true;
                }
                if (z) {
                    v42.l();
                }
                v42.m(connectionResult);
                return;
            }
            v42.i();
        }
    }
}
