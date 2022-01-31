package defpackage;

import android.os.RemoteException;
import com.google.android.gms.maps.model.RuntimeRemoteException;

/* renamed from: j44  reason: default package */
public final class j44 {

    /* renamed from: a  reason: collision with root package name */
    public final o44 f1874a;

    public j44(o44 o44) {
        this.f1874a = o44;
    }

    public final void a(boolean z) {
        try {
            this.f1874a.k0(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void b(boolean z) {
        try {
            this.f1874a.g2(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void c(boolean z) {
        try {
            this.f1874a.j0(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void d(boolean z) {
        try {
            this.f1874a.A1(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
