package defpackage;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zav;
import com.google.android.gms.signin.internal.zak;
import java.util.Objects;
import java.util.Set;

/* renamed from: g62  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class g62 implements Runnable {
    public final /* synthetic */ zak f;
    public final /* synthetic */ i62 g;

    public g62(i62 i62, zak zak) {
        this.g = i62;
        this.f = zak;
    }

    public final void run() {
        i62 i62 = this.g;
        zak zak = this.f;
        ConnectionResult connectionResult = zak.g;
        if (connectionResult.m1()) {
            zav zav = zak.h;
            Objects.requireNonNull(zav, "null reference");
            connectionResult = zav.h;
            if (!connectionResult.m1()) {
                String valueOf = String.valueOf(connectionResult);
                Log.wtf("SignInCoordinator", hj1.a0(new StringBuilder(valueOf.length() + 48), "Sign-in succeeded with resolve account failure: ", valueOf), new Exception());
            } else {
                h62 h62 = i62.l;
                c82 l1 = zav.l1();
                Set<Scope> set = i62.i;
                s52 s52 = (s52) h62;
                Objects.requireNonNull(s52);
                if (l1 == null || set == null) {
                    Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
                    s52.b(new ConnectionResult(4));
                    i62.k.disconnect();
                }
                s52.c = l1;
                s52.d = set;
                if (s52.e) {
                    s52.f3187a.getRemoteService(l1, set);
                }
                i62.k.disconnect();
            }
        }
        ((s52) i62.l).b(connectionResult);
        i62.k.disconnect();
    }
}
