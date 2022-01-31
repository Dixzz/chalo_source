package defpackage;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* renamed from: q62  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public abstract class q62 {

    /* renamed from: a  reason: collision with root package name */
    public final int f2904a;

    public q62(int i) {
        this.f2904a = i;
    }

    public static /* synthetic */ Status e(RemoteException remoteException) {
        return new Status(19, remoteException.getClass().getSimpleName() + ": " + remoteException.getLocalizedMessage());
    }

    public abstract void a(Status status);

    public abstract void b(Exception exc);

    public abstract void c(f42 f42, boolean z);

    public abstract void d(p52<?> p52) throws DeadObjectException;
}
