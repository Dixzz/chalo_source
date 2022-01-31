package defpackage;

import com.google.firebase.remoteconfig.internal.Personalization;
import java.util.Objects;

/* renamed from: q10  reason: default package */
/* compiled from: FirebasePollingRequestHandler */
public class q10 implements Runnable {
    public final /* synthetic */ String f;
    public final /* synthetic */ t10 g;

    public q10(t10 t10, String str) {
        this.g = t10;
        this.f = str;
    }

    public void run() {
        t10 t10 = this.g;
        String str = this.f;
        Objects.requireNonNull(t10);
        d70 d70 = new d70(str, null, new s10(t10, str), new r10(t10, str));
        d70.n = false;
        StringBuilder i0 = hj1.i0(Personalization.ANALYTICS_ORIGIN_PERSONALIZATION);
        i0.append(t10.c);
        d70.s = i0.toString();
        d70.q = new nj1(5000, 1, 0.25f);
        t10.f.a(d70);
        t10 t102 = this.g;
        t102.d.postDelayed(t102.b, xt.f3961a.t().c("firebasePollingFrequency"));
    }
}
