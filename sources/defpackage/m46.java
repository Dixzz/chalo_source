package defpackage;

import defpackage.i46;
import defpackage.r46;
import java.util.Map;
import java.util.Objects;

/* renamed from: m46  reason: default package */
/* compiled from: WebSocket */
public class m46 implements Runnable {
    public final /* synthetic */ Map f;
    public final /* synthetic */ r46.a g;

    public m46(r46.a aVar, Map map) {
        this.g = aVar;
        this.f = map;
    }

    public void run() {
        this.g.f3041a.a("responseHeaders", this.f);
        r46 r46 = this.g.f3041a;
        Objects.requireNonNull(r46);
        r46.k = i46.d.OPEN;
        r46.b = true;
        r46.a("open", new Object[0]);
    }
}
