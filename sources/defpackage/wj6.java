package defpackage;

import app.zophop.models.mTicketing.ProductDiscountsObject;
import com.razorpay.AnalyticsConstants;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/* renamed from: wj6  reason: default package */
/* compiled from: RouteSelector.kt */
public final class wj6 {

    /* renamed from: a  reason: collision with root package name */
    public List<? extends Proxy> f3793a;
    public int b;
    public List<? extends InetSocketAddress> c;
    public final List<pi6> d = new ArrayList();
    public final dh6 e;
    public final uj6 f;
    public final ih6 g;
    public final xh6 h;

    /* renamed from: wj6$a */
    /* compiled from: RouteSelector.kt */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public int f3794a;
        public final List<pi6> b;

        public a(List<pi6> list) {
            n86.f(list, ProductDiscountsObject.KEY_ROUTES);
            this.b = list;
        }

        public final boolean a() {
            return this.f3794a < this.b.size();
        }

        public final pi6 b() {
            if (a()) {
                List<pi6> list = this.b;
                int i = this.f3794a;
                this.f3794a = i + 1;
                return list.get(i);
            }
            throw new NoSuchElementException();
        }
    }

    public wj6(dh6 dh6, uj6 uj6, ih6 ih6, xh6 xh6) {
        n86.f(dh6, "address");
        n86.f(uj6, "routeDatabase");
        n86.f(ih6, AnalyticsConstants.CALL);
        n86.f(xh6, "eventListener");
        this.e = dh6;
        this.f = uj6;
        this.g = ih6;
        this.h = xh6;
        b66 b66 = b66.f;
        this.f3793a = b66;
        this.c = b66;
        di6 di6 = dh6.f839a;
        xj6 xj6 = new xj6(this, dh6.j, di6);
        n86.f(ih6, AnalyticsConstants.CALL);
        n86.f(di6, "url");
        List<Proxy> a2 = xj6.invoke();
        this.f3793a = a2;
        this.b = 0;
        n86.f(ih6, AnalyticsConstants.CALL);
        n86.f(di6, "url");
        n86.f(a2, "proxies");
    }

    public final boolean a() {
        return b() || (this.d.isEmpty() ^ true);
    }

    public final boolean b() {
        return this.b < this.f3793a.size();
    }
}
