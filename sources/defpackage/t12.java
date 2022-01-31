package defpackage;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import android.os.Messenger;
import android.util.Log;
import android.util.SparseArray;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

/* renamed from: t12  reason: default package */
/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
public final class t12 implements ServiceConnection {
    @GuardedBy("this")

    /* renamed from: a  reason: collision with root package name */
    public int f3294a = 0;
    public final Messenger b = new Messenger(new fl2(Looper.getMainLooper(), new w12(this)));
    public c22 c;
    @GuardedBy("this")
    public final Queue<e22<?>> d = new ArrayDeque();
    @GuardedBy("this")
    public final SparseArray<e22<?>> e = new SparseArray<>();
    public final /* synthetic */ s12 f;

    public t12(s12 s12, u12 u12) {
        this.f = s12;
    }

    public final synchronized void a(int i, String str) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                "Disconnected: ".concat(valueOf);
            } else {
                new String("Disconnected: ");
            }
        }
        int i2 = this.f3294a;
        if (i2 == 0) {
            throw new IllegalStateException();
        } else if (i2 == 1 || i2 == 2) {
            Log.isLoggable("MessengerIpcClient", 2);
            this.f3294a = 4;
            za2.b().c(this.f.f3167a, this);
            d22 d22 = new d22(i, str);
            for (e22<?> e22 : this.d) {
                e22.b(d22);
            }
            this.d.clear();
            for (int i3 = 0; i3 < this.e.size(); i3++) {
                this.e.valueAt(i3).b(d22);
            }
            this.e.clear();
        } else if (i2 == 3) {
            this.f3294a = 4;
        } else if (i2 != 4) {
            int i4 = this.f3294a;
            StringBuilder sb = new StringBuilder(26);
            sb.append("Unknown state: ");
            sb.append(i4);
            throw new IllegalStateException(sb.toString());
        }
    }

    public final synchronized boolean b(e22<?> e22) {
        int i = this.f3294a;
        if (i == 0) {
            this.d.add(e22);
            gj1.n(this.f3294a == 0);
            this.f3294a = 1;
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            if (!za2.b().a(this.f.f3167a, intent, this, 1)) {
                a(0, "Unable to bind to service");
            } else {
                this.f.b.schedule(new v12(this), 30, TimeUnit.SECONDS);
            }
            return true;
        } else if (i == 1) {
            this.d.add(e22);
            return true;
        } else if (i != 2) {
            if (i != 3) {
                if (i != 4) {
                    int i2 = this.f3294a;
                    StringBuilder sb = new StringBuilder(26);
                    sb.append("Unknown state: ");
                    sb.append(i2);
                    throw new IllegalStateException(sb.toString());
                }
            }
            return false;
        } else {
            this.d.add(e22);
            this.f.b.execute(new x12(this));
            return true;
        }
    }

    public final synchronized void c() {
        if (this.f3294a == 2 && this.d.isEmpty() && this.e.size() == 0) {
            Log.isLoggable("MessengerIpcClient", 2);
            this.f3294a = 3;
            za2.b().c(this.f.f3167a, this);
        }
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Log.isLoggable("MessengerIpcClient", 2);
        this.f.b.execute(new y12(this, iBinder));
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        Log.isLoggable("MessengerIpcClient", 2);
        this.f.b.execute(new a22(this));
    }
}
