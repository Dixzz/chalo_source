package defpackage;

import android.os.IBinder;
import android.os.RemoteException;

/* renamed from: pv4  reason: default package */
public final /* synthetic */ class pv4 implements IBinder.DeathRecipient {

    /* renamed from: a  reason: collision with root package name */
    public final xv4 f2859a;

    public pv4(xv4 xv4) {
        this.f2859a = xv4;
    }

    public final void binderDied() {
        xv4 xv4 = this.f2859a;
        xv4.b.b(4, "reportBinderDeath", new Object[0]);
        sv4 sv4 = xv4.h.get();
        if (sv4 == null) {
            xv4.b.b(4, "%s : Binder has died.", new Object[]{xv4.c});
            for (ov4 ov4 : xv4.d) {
                ay4<?> ay4 = ov4.f;
                if (ay4 != null) {
                    ay4.a(new RemoteException(String.valueOf(xv4.c).concat(" : Binder has died.")));
                }
            }
            xv4.d.clear();
            return;
        }
        xv4.b.b(4, "calling onBinderDied", new Object[0]);
        sv4.a();
    }
}
