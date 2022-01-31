package defpackage;

import java.net.Proxy;
import java.net.URI;
import java.util.List;

/* renamed from: xj6  reason: default package */
/* compiled from: RouteSelector.kt */
public final class xj6 extends o86 implements h76<List<? extends Proxy>> {
    public final /* synthetic */ wj6 f;
    public final /* synthetic */ Proxy g;
    public final /* synthetic */ di6 h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public xj6(wj6 wj6, Proxy proxy, di6 di6) {
        super(0);
        this.f = wj6;
        this.g = proxy;
        this.h = di6;
    }

    /* renamed from: a */
    public final List<Proxy> invoke() {
        Proxy proxy = this.g;
        if (proxy != null) {
            return hd3.c2(proxy);
        }
        URI j = this.h.j();
        if (j.getHost() == null) {
            return vi6.l(Proxy.NO_PROXY);
        }
        List<Proxy> select = this.f.e.k.select(j);
        if (!(select == null || select.isEmpty())) {
            return vi6.y(select);
        }
        return vi6.l(Proxy.NO_PROXY);
    }
}
