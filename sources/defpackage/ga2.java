package defpackage;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;

/* renamed from: ga2  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class ga2 implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public final int f1231a;
    public final /* synthetic */ w72 b;

    public ga2(w72 w72, int i) {
        this.b = w72;
        this.f1231a = i;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        e82 e82;
        if (iBinder == null) {
            w72.zzc(this.b, 16);
            return;
        }
        synchronized (this.b.zzq) {
            w72 w72 = this.b;
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof e82)) {
                e82 = new w92(iBinder);
            } else {
                e82 = (e82) queryLocalInterface;
            }
            w72.zzr = e82;
        }
        this.b.zzb(0, null, this.f1231a);
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.b.zzq) {
            this.b.zzr = null;
        }
        Handler handler = this.b.zzb;
        handler.sendMessage(handler.obtainMessage(6, this.f1231a, 1));
    }
}
