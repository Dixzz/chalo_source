package defpackage;

import defpackage.r46;
import java.util.Objects;
import java.util.logging.Logger;

/* renamed from: o46  reason: default package */
/* compiled from: WebSocket */
public class o46 implements Runnable {
    public final /* synthetic */ zm6 f;
    public final /* synthetic */ r46.a g;

    public o46(r46.a aVar, zm6 zm6) {
        this.g = aVar;
        this.f = zm6;
    }

    public void run() {
        r46 r46 = this.g.f3041a;
        byte[] o = this.f.o();
        Logger logger = r46.o;
        Objects.requireNonNull(r46);
        r46.j(t46.b(o));
    }
}
