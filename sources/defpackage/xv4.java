package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IInterface;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: xv4  reason: default package */
public final class xv4<T extends IInterface> {
    public static final Map<String, Handler> l = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    public final Context f3969a;
    public final nv4 b;
    public final String c;
    public final List<ov4> d = new ArrayList();
    public boolean e;
    public final Intent f;
    public final tv4<T> g;
    public final WeakReference<sv4> h;
    public final IBinder.DeathRecipient i = new pv4(this);
    public ServiceConnection j;
    public T k;

    public xv4(Context context, nv4 nv4, String str, Intent intent, tv4<T> tv4) {
        this.f3969a = context;
        this.b = nv4;
        this.c = str;
        this.f = intent;
        this.g = tv4;
        this.h = new WeakReference<>(null);
    }

    public final void a(ov4 ov4) {
        c(new qv4(this, ov4.f, ov4));
    }

    public final void b() {
        c(new rv4(this));
    }

    public final void c(ov4 ov4) {
        Handler handler;
        Map<String, Handler> map = l;
        synchronized (map) {
            if (!map.containsKey(this.c)) {
                HandlerThread handlerThread = new HandlerThread(this.c, 10);
                handlerThread.start();
                map.put(this.c, new Handler(handlerThread.getLooper()));
            }
            handler = map.get(this.c);
        }
        handler.post(ov4);
    }
}
