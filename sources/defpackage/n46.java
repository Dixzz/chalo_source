package defpackage;

import defpackage.r46;
import java.util.Objects;
import java.util.logging.Logger;

/* renamed from: n46  reason: default package */
/* compiled from: WebSocket */
public class n46 implements Runnable {
    public final /* synthetic */ String f;
    public final /* synthetic */ r46.a g;

    public n46(r46.a aVar, String str) {
        this.g = aVar;
        this.f = str;
    }

    public void run() {
        r46 r46 = this.g.f3041a;
        String str = this.f;
        Logger logger = r46.o;
        Objects.requireNonNull(r46);
        r46.j(t46.a(str, false));
    }
}
