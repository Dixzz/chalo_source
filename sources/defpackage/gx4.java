package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* renamed from: gx4  reason: default package */
public abstract class gx4<StateT> {

    /* renamed from: a  reason: collision with root package name */
    public final nv4 f1313a;
    public final IntentFilter b;
    public final Context c;
    public final Set<ex4<StateT>> d = new HashSet();
    public fx4 e = null;
    public volatile boolean f = false;

    public gx4(nv4 nv4, IntentFilter intentFilter, Context context) {
        this.f1313a = nv4;
        this.b = intentFilter;
        Context applicationContext = context.getApplicationContext();
        this.c = applicationContext != null ? applicationContext : context;
    }

    public abstract void a(Context context, Intent intent);

    public final void b() {
        fx4 fx4;
        if ((this.f || !this.d.isEmpty()) && this.e == null) {
            fx4 fx42 = new fx4(this);
            this.e = fx42;
            this.c.registerReceiver(fx42, this.b);
        }
        if (!this.f && this.d.isEmpty() && (fx4 = this.e) != null) {
            this.c.unregisterReceiver(fx4);
            this.e = null;
        }
    }

    public final synchronized void c(StateT statet) {
        Iterator it = new HashSet(this.d).iterator();
        while (it.hasNext()) {
            ((ex4) it.next()).a(statet);
        }
    }
}
