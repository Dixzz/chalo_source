package defpackage;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;

/* renamed from: gc3  reason: default package */
public final class gc3 implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public volatile od3 f1239a;
    public volatile boolean b;
    public final /* synthetic */ ec3 c;

    public gc3(ec3 ec3) {
        this.c = ec3;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        od3 od3;
        gj1.h("AnalyticsServiceConnection.onServiceConnected");
        synchronized (this) {
            if (iBinder == null) {
                try {
                    this.c.V("Service connected with null binder");
                } finally {
                    notifyAll();
                }
            } else {
                od3 od32 = null;
                try {
                    String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                    if ("com.google.android.gms.analytics.internal.IAnalyticsService".equals(interfaceDescriptor)) {
                        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
                        if (queryLocalInterface instanceof od3) {
                            od3 = (od3) queryLocalInterface;
                        } else {
                            od3 = new pd3(iBinder);
                        }
                        od32 = od3;
                        this.c.M("Bound to IAnalyticsService interface");
                    } else {
                        this.c.L("Got binder with a wrong descriptor", interfaceDescriptor);
                    }
                } catch (RemoteException unused) {
                    this.c.V("Service connect failed to get IAnalyticsService");
                }
                if (od32 == null) {
                    try {
                        za2 b2 = za2.b();
                        ec3 ec3 = this.c;
                        b2.c(ec3.f.f146a, ec3.h);
                    } catch (IllegalArgumentException unused2) {
                    }
                } else if (!this.b) {
                    this.c.T("onServiceConnected received after the timeout limit");
                    this.c.w().b(new hc3(this, od32));
                } else {
                    this.f1239a = od32;
                }
                notifyAll();
            }
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        gj1.h("AnalyticsServiceConnection.onServiceDisconnected");
        this.c.w().b(new ic3(this, componentName));
    }
}
