package defpackage;

import defpackage.r46;
import java.util.logging.Logger;

/* renamed from: q46  reason: default package */
/* compiled from: WebSocket */
public class q46 implements Runnable {
    public final /* synthetic */ Throwable f;
    public final /* synthetic */ r46.a g;

    public q46(r46.a aVar, Throwable th) {
        this.g = aVar;
        this.f = th;
    }

    public void run() {
        Logger logger = r46.o;
        this.g.f3041a.i("websocket error", (Exception) this.f);
    }
}
