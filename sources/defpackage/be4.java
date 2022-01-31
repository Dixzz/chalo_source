package defpackage;

import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;

/* renamed from: be4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-sdk@@18.0.0 */
public final class be4 implements Runnable {
    public final /* synthetic */ g24 f;
    public final /* synthetic */ String g;
    public final /* synthetic */ String h;
    public final /* synthetic */ boolean i;
    public final /* synthetic */ AppMeasurementDynamiteService j;

    public be4(AppMeasurementDynamiteService appMeasurementDynamiteService, g24 g24, String str, String str2, boolean z) {
        this.j = appMeasurementDynamiteService;
        this.f = g24;
        this.g = str;
        this.h = str2;
        this.i = z;
    }

    public final void run() {
        re4 x = this.j.f.x();
        g24 g24 = this.f;
        String str = this.g;
        String str2 = this.h;
        boolean z = this.i;
        x.b();
        x.s();
        x.y(new te4(x, str, str2, z, x.H(false), g24));
    }
}
