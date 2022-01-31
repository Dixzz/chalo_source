package defpackage;

import android.content.Intent;

/* renamed from: tf4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final /* synthetic */ class tf4 implements Runnable {
    public final qf4 f;
    public final int g;
    public final ra4 h;
    public final Intent i;

    public tf4(qf4 qf4, int i2, ra4 ra4, Intent intent) {
        this.f = qf4;
        this.g = i2;
        this.h = ra4;
        this.i = intent;
    }

    public final void run() {
        qf4 qf4 = this.f;
        int i2 = this.g;
        ra4 ra4 = this.h;
        Intent intent = this.i;
        if (qf4.f2940a.j(i2)) {
            ra4.n.b("Local AppMeasurementService processed last upload request. StartId", Integer.valueOf(i2));
            qf4.b().n.a("Completed wakeful intent.");
            qf4.f2940a.b(intent);
        }
    }
}
