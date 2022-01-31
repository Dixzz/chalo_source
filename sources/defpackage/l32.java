package defpackage;

import android.os.DeadObjectException;
import android.os.RemoteException;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import defpackage.f32;
import defpackage.x22;
import defpackage.x22.b;

/* renamed from: l32  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public abstract class l32<R extends f32, A extends x22.b> extends BasePendingResult<R> implements m32<R> {
    public final x22.c<A> o;
    public final x22<?> p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l32(@RecentlyNonNull x22<?> x22, @RecentlyNonNull a32 a32) {
        super(a32);
        gj1.l(a32, "GoogleApiClient must not be null");
        gj1.l(x22, "Api must not be null");
        this.o = x22.b;
        this.p = x22;
    }

    public abstract void l(@RecentlyNonNull A a2) throws RemoteException;

    public final void m(@RecentlyNonNull A a2) throws DeadObjectException {
        try {
            l(a2);
        } catch (DeadObjectException e) {
            n(new Status(8, e.getLocalizedMessage(), null));
            throw e;
        } catch (RemoteException e2) {
            n(new Status(8, e2.getLocalizedMessage(), null));
        }
    }

    public final void n(@RecentlyNonNull Status status) {
        gj1.c(!status.m1(), "Failed result must not be success");
        setResult(d(status));
    }
}
