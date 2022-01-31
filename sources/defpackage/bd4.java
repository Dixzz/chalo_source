package defpackage;

import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;

/* renamed from: bd4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-sdk@@18.0.0 */
public final class bd4 implements Runnable {
    public final /* synthetic */ g24 f;
    public final /* synthetic */ AppMeasurementDynamiteService g;

    public bd4(AppMeasurementDynamiteService appMeasurementDynamiteService, g24 g24) {
        this.g = appMeasurementDynamiteService;
        this.f = g24;
    }

    public final void run() {
        re4 x = this.g.f.x();
        g24 g24 = this.f;
        x.b();
        x.s();
        x.y(new ve4(x, x.H(false), g24));
    }
}
