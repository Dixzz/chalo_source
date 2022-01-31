package defpackage;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* renamed from: m62  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public abstract class m62<T> extends c62 {
    public final zi4<T> b;

    public m62(int i, zi4<T> zi4) {
        super(i);
        this.b = zi4;
    }

    @Override // defpackage.q62
    public final void a(Status status) {
        this.b.a(new y22(status));
    }

    @Override // defpackage.q62
    public final void b(Exception exc) {
        this.b.a(exc);
    }

    @Override // defpackage.q62
    public final void d(p52<?> p52) throws DeadObjectException {
        try {
            h(p52);
        } catch (DeadObjectException e) {
            this.b.a(new y22(q62.e(e)));
            throw e;
        } catch (RemoteException e2) {
            this.b.a(new y22(q62.e(e2)));
        } catch (RuntimeException e3) {
            this.b.a(e3);
        }
    }

    public abstract void h(p52<?> p52) throws RemoteException;
}
