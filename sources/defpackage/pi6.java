package defpackage;

import java.net.InetSocketAddress;
import java.net.Proxy;

/* renamed from: pi6  reason: default package */
/* compiled from: Route.kt */
public final class pi6 {

    /* renamed from: a  reason: collision with root package name */
    public final dh6 f2809a;
    public final Proxy b;
    public final InetSocketAddress c;

    public pi6(dh6 dh6, Proxy proxy, InetSocketAddress inetSocketAddress) {
        n86.f(dh6, "address");
        n86.f(proxy, "proxy");
        n86.f(inetSocketAddress, "socketAddress");
        this.f2809a = dh6;
        this.b = proxy;
        this.c = inetSocketAddress;
    }

    public final boolean a() {
        return this.f2809a.f != null && this.b.type() == Proxy.Type.HTTP;
    }

    public boolean equals(Object obj) {
        if (obj instanceof pi6) {
            pi6 pi6 = (pi6) obj;
            return n86.a(pi6.f2809a, this.f2809a) && n86.a(pi6.b, this.b) && n86.a(pi6.c, this.c);
        }
    }

    public int hashCode() {
        int hashCode = this.b.hashCode();
        return this.c.hashCode() + ((hashCode + ((this.f2809a.hashCode() + 527) * 31)) * 31);
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("Route{");
        i0.append(this.c);
        i0.append('}');
        return i0.toString();
    }
}
