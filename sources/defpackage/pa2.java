package defpackage;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import com.freshchat.consumer.sdk.beans.config.DefaultRefreshIntervals;
import java.util.HashMap;
import javax.annotation.concurrent.GuardedBy;

/* renamed from: pa2  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class pa2 extends a82 {
    @GuardedBy("connectionStatus")
    public final HashMap<ma2, na2> c = new HashMap<>();
    public final Context d;
    public final Handler e;
    public final za2 f;
    public final long g;
    public final long h;

    public pa2(Context context) {
        this.d = context.getApplicationContext();
        this.e = new jl2(context.getMainLooper(), new oa2(this));
        this.f = za2.b();
        this.g = 5000;
        this.h = DefaultRefreshIntervals.RESPONSE_TIME_EXPECTATIONS_FETCH_INTERVAL;
    }

    @Override // defpackage.a82
    public final boolean c(ma2 ma2, ServiceConnection serviceConnection, String str) {
        boolean z;
        gj1.l(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.c) {
            na2 na2 = this.c.get(ma2);
            if (na2 == null) {
                na2 = new na2(this, ma2);
                na2.f2529a.put(serviceConnection, serviceConnection);
                na2.a(str);
                this.c.put(ma2, na2);
            } else {
                this.e.removeMessages(0, ma2);
                if (!na2.f2529a.containsKey(serviceConnection)) {
                    na2.f2529a.put(serviceConnection, serviceConnection);
                    int i = na2.b;
                    if (i == 1) {
                        ((ga2) serviceConnection).onServiceConnected(na2.f, na2.d);
                    } else if (i == 2) {
                        na2.a(str);
                    }
                } else {
                    String valueOf = String.valueOf(ma2);
                    StringBuilder sb = new StringBuilder(valueOf.length() + 81);
                    sb.append("Trying to bind a GmsServiceConnection that was already connected before.  config=");
                    sb.append(valueOf);
                    throw new IllegalStateException(sb.toString());
                }
            }
            z = na2.c;
        }
        return z;
    }
}
