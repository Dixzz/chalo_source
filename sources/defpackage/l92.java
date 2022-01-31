package defpackage;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import defpackage.a32;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* renamed from: l92  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class l92 implements Handler.Callback {
    @NotOnlyInitialized

    /* renamed from: a  reason: collision with root package name */
    public final k92 f2190a;
    public final ArrayList<a32.b> b = new ArrayList<>();
    public final ArrayList<a32.b> c = new ArrayList<>();
    public final ArrayList<a32.c> d = new ArrayList<>();
    public volatile boolean e = false;
    public final AtomicInteger f = new AtomicInteger(0);
    public boolean g = false;
    public final Handler h;
    public final Object i = new Object();

    public l92(Looper looper, k92 k92) {
        this.f2190a = k92;
        this.h = new ve2(looper, this);
    }

    public final void a() {
        this.e = false;
        this.f.incrementAndGet();
    }

    public final void b(a32.b bVar) {
        Objects.requireNonNull(bVar, "null reference");
        synchronized (this.i) {
            if (this.b.contains(bVar)) {
                String.valueOf(bVar).length();
            } else {
                this.b.add(bVar);
            }
        }
        if (this.f2190a.isConnected()) {
            Handler handler = this.h;
            handler.sendMessage(handler.obtainMessage(1, bVar));
        }
    }

    public final void c(a32.c cVar) {
        Objects.requireNonNull(cVar, "null reference");
        synchronized (this.i) {
            if (this.d.contains(cVar)) {
                String.valueOf(cVar).length();
            } else {
                this.d.add(cVar);
            }
        }
    }

    public final boolean handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == 1) {
            a32.b bVar = (a32.b) message.obj;
            synchronized (this.i) {
                if (this.e && this.f2190a.isConnected() && this.b.contains(bVar)) {
                    bVar.L(null);
                }
            }
            return true;
        }
        Log.wtf("GmsClientEvents", hj1.v(45, "Don't know how to handle message: ", i2), new Exception());
        return false;
    }
}
