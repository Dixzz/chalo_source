package defpackage;

import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;
import com.google.android.gms.measurement.internal.zzaq;
import java.util.Objects;

/* renamed from: ze4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-sdk@@18.0.0 */
public final class ze4 implements Runnable {
    public final /* synthetic */ g24 f;
    public final /* synthetic */ zzaq g;
    public final /* synthetic */ String h;
    public final /* synthetic */ AppMeasurementDynamiteService i;

    public ze4(AppMeasurementDynamiteService appMeasurementDynamiteService, g24 g24, zzaq zzaq, String str) {
        this.i = appMeasurementDynamiteService;
        this.f = g24;
        this.g = zzaq;
        this.h = str;
    }

    public final void run() {
        re4 x = this.i.f.x();
        g24 g24 = this.f;
        zzaq zzaq = this.g;
        String str = this.h;
        x.b();
        x.s();
        ug4 h2 = x.h();
        Objects.requireNonNull(h2);
        if (r22.b.c(h2.f3331a.f3627a, u22.GOOGLE_PLAY_SERVICES_VERSION_CODE) != 0) {
            x.g().i.a("Not bundling data. Service unavailable or out of date");
            x.h().O(g24, new byte[0]);
            return;
        }
        x.y(new df4(x, zzaq, str, g24));
    }
}
