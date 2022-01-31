package defpackage;

import android.content.Context;
import android.content.ServiceConnection;
import androidx.annotation.RecentlyNonNull;

/* renamed from: a82  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public abstract class a82 {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f133a = new Object();
    public static a82 b;

    @RecentlyNonNull
    public static a82 a(@RecentlyNonNull Context context) {
        synchronized (f133a) {
            if (b == null) {
                b = new pa2(context.getApplicationContext());
            }
        }
        return b;
    }

    public final void b(@RecentlyNonNull String str, @RecentlyNonNull String str2, int i, @RecentlyNonNull ServiceConnection serviceConnection, @RecentlyNonNull String str3, boolean z) {
        ma2 ma2 = new ma2(str, str2, i, z);
        pa2 pa2 = (pa2) this;
        gj1.l(serviceConnection, "ServiceConnection must not be null");
        synchronized (pa2.c) {
            na2 na2 = pa2.c.get(ma2);
            if (na2 == null) {
                String valueOf = String.valueOf(ma2);
                StringBuilder sb = new StringBuilder(valueOf.length() + 50);
                sb.append("Nonexistent connection status for service config: ");
                sb.append(valueOf);
                throw new IllegalStateException(sb.toString());
            } else if (na2.f2529a.containsKey(serviceConnection)) {
                na2.f2529a.remove(serviceConnection);
                if (na2.f2529a.isEmpty()) {
                    pa2.e.sendMessageDelayed(pa2.e.obtainMessage(0, ma2), pa2.g);
                }
            } else {
                String valueOf2 = String.valueOf(ma2);
                StringBuilder sb2 = new StringBuilder(valueOf2.length() + 76);
                sb2.append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=");
                sb2.append(valueOf2);
                throw new IllegalStateException(sb2.toString());
            }
        }
    }

    public abstract boolean c(ma2 ma2, ServiceConnection serviceConnection, String str);
}
