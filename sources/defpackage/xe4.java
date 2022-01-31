package defpackage;

import android.os.RemoteException;

/* renamed from: xe4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class xe4 implements Runnable {
    public final /* synthetic */ je4 f;
    public final /* synthetic */ re4 g;

    public xe4(re4 re4, je4 je4) {
        this.g = re4;
        this.f = je4;
    }

    public final void run() {
        re4 re4 = this.g;
        ja4 ja4 = re4.d;
        if (ja4 == null) {
            re4.g().f.a("Failed to send current screen to service");
            return;
        }
        try {
            je4 je4 = this.f;
            if (je4 == null) {
                ja4.l1(0, null, null, re4.f3331a.f3627a.getPackageName());
            } else {
                ja4.l1(je4.c, je4.f1911a, je4.b, re4.f3331a.f3627a.getPackageName());
            }
            this.g.E();
        } catch (RemoteException e) {
            this.g.g().f.b("Failed to send current screen to the service", e);
        }
    }
}
