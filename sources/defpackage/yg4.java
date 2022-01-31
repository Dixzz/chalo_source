package defpackage;

import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;

/* renamed from: yg4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-sdk@@18.0.0 */
public final class yg4 implements Runnable {
    public final /* synthetic */ g24 f;
    public final /* synthetic */ AppMeasurementDynamiteService g;

    public yg4(AppMeasurementDynamiteService appMeasurementDynamiteService, g24 g24) {
        this.g = appMeasurementDynamiteService;
        this.f = g24;
    }

    public final void run() {
        this.g.f.t().N(this.f, this.g.f.B());
    }
}
