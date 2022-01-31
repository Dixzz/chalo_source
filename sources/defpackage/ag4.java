package defpackage;

import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;

/* renamed from: ag4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-sdk@@18.0.0 */
public final class ag4 implements Runnable {
    public final /* synthetic */ g24 f;
    public final /* synthetic */ String g;
    public final /* synthetic */ String h;
    public final /* synthetic */ AppMeasurementDynamiteService i;

    public ag4(AppMeasurementDynamiteService appMeasurementDynamiteService, g24 g24, String str, String str2) {
        this.i = appMeasurementDynamiteService;
        this.f = g24;
        this.g = str;
        this.h = str2;
    }

    public final void run() {
        re4 x = this.i.f.x();
        g24 g24 = this.f;
        String str = this.g;
        String str2 = this.h;
        x.b();
        x.s();
        x.y(new jf4(x, str, str2, x.H(false), g24));
    }
}
