package defpackage;

import android.os.IBinder;
import android.os.RemoteException;

/* renamed from: y12  reason: default package */
/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
public final /* synthetic */ class y12 implements Runnable {
    public final t12 f;
    public final IBinder g;

    public y12(t12 t12, IBinder iBinder) {
        this.f = t12;
        this.g = iBinder;
    }

    public final void run() {
        t12 t12 = this.f;
        IBinder iBinder = this.g;
        synchronized (t12) {
            if (iBinder == null) {
                t12.a(0, "Null service connection");
                return;
            }
            try {
                t12.c = new c22(iBinder);
                t12.f3294a = 2;
                t12.f.b.execute(new x12(t12));
            } catch (RemoteException e) {
                t12.a(0, e.getMessage());
            }
        }
    }
}
