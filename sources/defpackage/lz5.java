package defpackage;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* renamed from: lz5  reason: default package */
/* compiled from: HandlerPoster */
public final class lz5 extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final oz5 f2299a = new oz5();
    public final int b;
    public final jz5 c;
    public boolean d;

    public lz5(jz5 jz5, Looper looper, int i) {
        super(looper);
        this.c = jz5;
        this.b = i;
    }

    public void handleMessage(Message message) {
        boolean z = false;
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            do {
                nz5 b2 = this.f2299a.b();
                if (b2 == null) {
                    synchronized (this) {
                        b2 = this.f2299a.b();
                        if (b2 == null) {
                            this.d = z;
                            this.d = z;
                            return;
                        }
                    }
                }
                this.c.d(b2);
            } while (SystemClock.uptimeMillis() - uptimeMillis < ((long) this.b));
            if (sendMessage(obtainMessage())) {
                z = true;
                return;
            }
            throw new kz5("Could not send handler message");
        } finally {
            this.d = z;
        }
    }
}
