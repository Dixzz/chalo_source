package defpackage;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;

/* renamed from: mb4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class mb4 implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public final String f2351a;
    public final /* synthetic */ nb4 b;

    public mb4(nb4 nb4, String str) {
        this.b = nb4;
        this.f2351a = str;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        bs3 bs3;
        if (iBinder == null) {
            this.b.f2532a.g().i.a("Install Referrer connection returned with null binder");
            return;
        }
        try {
            int i = bt3.f;
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
            if (queryLocalInterface instanceof bs3) {
                bs3 = (bs3) queryLocalInterface;
            } else {
                bs3 = new at3(iBinder);
            }
            if (bs3 == null) {
                this.b.f2532a.g().i.a("Install Referrer Service implementation was not found");
                return;
            }
            this.b.f2532a.g().n.a("Install Referrer Service connected");
            this.b.f2532a.f().u(new pb4(this, bs3, this));
        } catch (Exception e) {
            this.b.f2532a.g().i.b("Exception occurred while calling Install Referrer API", e);
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.b.f2532a.g().n.a("Install Referrer Service disconnected");
    }
}
