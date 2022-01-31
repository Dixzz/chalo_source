package defpackage;

import android.content.Context;
import android.util.Log;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.concurrent.GuardedBy;

/* renamed from: s12  reason: default package */
/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
public final class s12 {
    @GuardedBy("MessengerIpcClient.class")
    public static s12 e;

    /* renamed from: a  reason: collision with root package name */
    public final Context f3167a;
    public final ScheduledExecutorService b;
    @GuardedBy("this")
    public t12 c = new t12(this, null);
    @GuardedBy("this")
    public int d = 1;

    public s12(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.b = scheduledExecutorService;
        this.f3167a = context.getApplicationContext();
    }

    public static synchronized s12 a(Context context) {
        s12 s12;
        synchronized (s12.class) {
            if (e == null) {
                e = new s12(context, Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1, new jb2("MessengerIpcClient"))));
            }
            s12 = e;
        }
        return s12;
    }

    public final synchronized <T> yi4<T> b(e22<T> e22) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String.valueOf(e22).length();
        }
        if (!this.c.b(e22)) {
            t12 t12 = new t12(this, null);
            this.c = t12;
            t12.b(e22);
        }
        return e22.b.f4178a;
    }
}
