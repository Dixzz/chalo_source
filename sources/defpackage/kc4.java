package defpackage;

import com.google.android.gms.measurement.internal.zzap;
import com.google.android.gms.measurement.internal.zzaq;
import com.google.android.gms.measurement.internal.zzn;
import com.google.firebase.messaging.Constants;
import java.util.Objects;

/* renamed from: kc4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class kc4 implements Runnable {
    public final /* synthetic */ zzaq f;
    public final /* synthetic */ zzn g;
    public final /* synthetic */ ac4 h;

    public kc4(ac4 ac4, zzaq zzaq, zzn zzn) {
        this.h = ac4;
        this.f = zzaq;
        this.g = zzn;
    }

    public final void run() {
        zzap zzap;
        ac4 ac4 = this.h;
        zzaq zzaq = this.f;
        Objects.requireNonNull(ac4);
        boolean z = false;
        if (!(!Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN.equals(zzaq.f) || (zzap = zzaq.g) == null || zzap.f.size() == 0)) {
            String string = zzaq.g.f.getString("_cis");
            if ("referrer broadcast".equals(string) || "referrer API".equals(string)) {
                z = true;
            }
        }
        if (z) {
            ac4.f.g().l.b("Event has been filtered ", zzaq.toString());
            zzaq = new zzaq("_cmpx", zzaq.g, zzaq.h, zzaq.i);
        }
        this.h.f.R();
        this.h.f.j(zzaq, this.g);
    }
}
