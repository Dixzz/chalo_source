package defpackage;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* renamed from: wv4  reason: default package */
public final class wv4 implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ xv4 f3843a;

    public /* synthetic */ wv4(xv4 xv4) {
        this.f3843a = xv4;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f3843a.b.b(4, "ServiceConnectionImpl.onServiceConnected(%s)", new Object[]{componentName});
        this.f3843a.c(new uv4(this, iBinder));
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.f3843a.b.b(4, "ServiceConnectionImpl.onServiceDisconnected(%s)", new Object[]{componentName});
        this.f3843a.c(new vv4(this));
    }
}
