package defpackage;

import com.google.android.gms.common.ConnectionResult;
import defpackage.x22;

/* renamed from: r52  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class r52 implements Runnable {
    public final /* synthetic */ ConnectionResult f;
    public final /* synthetic */ s52 g;

    public r52(s52 s52, ConnectionResult connectionResult) {
        this.g = s52;
        this.f = connectionResult;
    }

    public final void run() {
        c82 c82;
        s52 s52 = this.g;
        p52<?> p52 = s52.f.j.get(s52.b);
        if (p52 != null) {
            if (this.f.m1()) {
                s52 s522 = this.g;
                s522.e = true;
                if (s522.f3187a.requiresSignIn()) {
                    s52 s523 = this.g;
                    if (s523.e && (c82 = s523.c) != null) {
                        s523.f3187a.getRemoteService(c82, s523.d);
                        return;
                    }
                    return;
                }
                try {
                    x22.f fVar = this.g.f3187a;
                    fVar.getRemoteService(null, fVar.getScopesForConnectionlessNonSignIn());
                } catch (SecurityException unused) {
                    this.g.f3187a.disconnect("Failed to get service from broker.");
                    p52.n(new ConnectionResult(10), null);
                }
            } else {
                p52.n(this.f, null);
            }
        }
    }
}
