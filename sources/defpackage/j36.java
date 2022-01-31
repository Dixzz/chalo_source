package defpackage;

import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: j36  reason: default package */
/* compiled from: Socket */
public class j36 implements Runnable {
    public final /* synthetic */ e36 f;

    public j36(e36 e36) {
        this.f = e36;
    }

    public void run() {
        if (this.f.b) {
            Logger logger = e36.k;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(String.format("performing disconnect (%s)", this.f.d));
            }
            e36.g(this.f, new a56(1));
        }
        this.f.i();
        if (this.f.b) {
            this.f.k("io client disconnect");
        }
    }
}
