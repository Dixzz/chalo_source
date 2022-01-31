package defpackage;

import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;

/* renamed from: xg4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-sdk@@18.0.0 */
public final class xg4 implements Runnable {
    public final /* synthetic */ AppMeasurementDynamiteService.a f;
    public final /* synthetic */ AppMeasurementDynamiteService g;

    public xg4(AppMeasurementDynamiteService appMeasurementDynamiteService, AppMeasurementDynamiteService.a aVar) {
        this.g = appMeasurementDynamiteService;
        this.f = aVar;
    }

    public final void run() {
        this.g.f.s().A(this.f);
    }
}
