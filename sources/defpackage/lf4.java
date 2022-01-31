package defpackage;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import defpackage.w72;

/* renamed from: lf4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class lf4 implements ServiceConnection, w72.a, w72.b {

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f2209a;
    public volatile sa4 b;
    public final /* synthetic */ re4 c;

    public lf4(re4 re4) {
        this.c = re4;
    }

    @Override // defpackage.w72.a
    public final void C(int i) {
        gj1.h("MeasurementServiceConnection.onConnectionSuspended");
        this.c.g().m.a("Service connection suspended");
        this.c.f().u(new pf4(this));
    }

    @Override // defpackage.w72.b
    public final void F(ConnectionResult connectionResult) {
        gj1.h("MeasurementServiceConnection.onConnectionFailed");
        vb4 vb4 = this.c.f3331a;
        ra4 ra4 = vb4.i;
        ra4 ra42 = (ra4 == null || !ra4.k()) ? null : vb4.i;
        if (ra42 != null) {
            ra42.i.b("Service connection failed", connectionResult);
        }
        synchronized (this) {
            this.f2209a = false;
            this.b = null;
        }
        this.c.f().u(new of4(this));
    }

    @Override // defpackage.w72.a
    public final void L(Bundle bundle) {
        gj1.h("MeasurementServiceConnection.onConnected");
        synchronized (this) {
            try {
                this.c.f().u(new mf4(this, (ja4) this.b.getService()));
            } catch (DeadObjectException | IllegalStateException unused) {
                this.b = null;
                this.f2209a = false;
            }
        }
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        ja4 ja4;
        gj1.h("MeasurementServiceConnection.onServiceConnected");
        synchronized (this) {
            if (iBinder == null) {
                this.f2209a = false;
                this.c.g().f.a("Service connected with null binder");
                return;
            }
            ja4 ja42 = null;
            try {
                String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(interfaceDescriptor)) {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    if (queryLocalInterface instanceof ja4) {
                        ja4 = (ja4) queryLocalInterface;
                    } else {
                        ja4 = new la4(iBinder);
                    }
                    ja42 = ja4;
                    this.c.g().n.a("Bound to IMeasurementService interface");
                } else {
                    this.c.g().f.b("Got binder with a wrong descriptor", interfaceDescriptor);
                }
            } catch (RemoteException unused) {
                this.c.g().f.a("Service connect failed to get IMeasurementService");
            }
            if (ja42 == null) {
                this.f2209a = false;
                try {
                    za2 b2 = za2.b();
                    re4 re4 = this.c;
                    b2.c(re4.f3331a.f3627a, re4.c);
                } catch (IllegalArgumentException unused2) {
                }
            } else {
                this.c.f().u(new kf4(this, ja42));
            }
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        gj1.h("MeasurementServiceConnection.onServiceDisconnected");
        this.c.g().m.a("Service disconnected");
        this.c.f().u(new nf4(this, componentName));
    }
}
