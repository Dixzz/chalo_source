package defpackage;

import defpackage.di6;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* renamed from: dh6  reason: default package */
/* compiled from: Address.kt */
public final class dh6 {

    /* renamed from: a  reason: collision with root package name */
    public final di6 f839a;
    public final List<ii6> b;
    public final List<qh6> c;
    public final wh6 d;
    public final SocketFactory e;
    public final SSLSocketFactory f;
    public final HostnameVerifier g;
    public final kh6 h;
    public final fh6 i;
    public final Proxy j;
    public final ProxySelector k;

    public dh6(String str, int i2, wh6 wh6, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, kh6 kh6, fh6 fh6, Proxy proxy, List<? extends ii6> list, List<qh6> list2, ProxySelector proxySelector) {
        n86.f(str, "uriHost");
        n86.f(wh6, "dns");
        n86.f(socketFactory, "socketFactory");
        n86.f(fh6, "proxyAuthenticator");
        n86.f(list, "protocols");
        n86.f(list2, "connectionSpecs");
        n86.f(proxySelector, "proxySelector");
        this.d = wh6;
        this.e = socketFactory;
        this.f = sSLSocketFactory;
        this.g = hostnameVerifier;
        this.h = kh6;
        this.i = fh6;
        this.j = proxy;
        this.k = proxySelector;
        di6.a aVar = new di6.a();
        String str2 = sSLSocketFactory != null ? "https" : "http";
        n86.f(str2, "scheme");
        boolean z = true;
        if (ea6.f(str2, "http", true)) {
            aVar.f843a = "http";
        } else if (ea6.f(str2, "https", true)) {
            aVar.f843a = "https";
        } else {
            throw new IllegalArgumentException(hj1.S("unexpected scheme: ", str2));
        }
        n86.f(str, "host");
        String H = ec6.H(di6.b.d(di6.l, str, 0, 0, false, 7));
        if (H != null) {
            aVar.d = H;
            if ((1 > i2 || 65535 < i2) ? false : z) {
                aVar.e = i2;
                this.f839a = aVar.c();
                this.b = vi6.y(list);
                this.c = vi6.y(list2);
                return;
            }
            throw new IllegalArgumentException(hj1.I("unexpected port: ", i2).toString());
        }
        throw new IllegalArgumentException(hj1.S("unexpected host: ", str));
    }

    public final boolean a(dh6 dh6) {
        n86.f(dh6, "that");
        return n86.a(this.d, dh6.d) && n86.a(this.i, dh6.i) && n86.a(this.b, dh6.b) && n86.a(this.c, dh6.c) && n86.a(this.k, dh6.k) && n86.a(this.j, dh6.j) && n86.a(this.f, dh6.f) && n86.a(this.g, dh6.g) && n86.a(this.h, dh6.h) && this.f839a.f == dh6.f839a.f;
    }

    public boolean equals(Object obj) {
        if (obj instanceof dh6) {
            dh6 dh6 = (dh6) obj;
            return n86.a(this.f839a, dh6.f839a) && a(dh6);
        }
    }

    public int hashCode() {
        int hashCode = this.d.hashCode();
        int hashCode2 = this.i.hashCode();
        int hashCode3 = this.b.hashCode();
        int hashCode4 = this.c.hashCode();
        int hashCode5 = this.k.hashCode();
        int hashCode6 = Objects.hashCode(this.j);
        int hashCode7 = Objects.hashCode(this.f);
        int hashCode8 = Objects.hashCode(this.g);
        return Objects.hashCode(this.h) + ((hashCode8 + ((hashCode7 + ((hashCode6 + ((hashCode5 + ((hashCode4 + ((hashCode3 + ((hashCode2 + ((hashCode + ((this.f839a.hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public String toString() {
        Object obj;
        StringBuilder sb;
        StringBuilder i0 = hj1.i0("Address{");
        i0.append(this.f839a.e);
        i0.append(':');
        i0.append(this.f839a.f);
        i0.append(", ");
        if (this.j != null) {
            sb = hj1.i0("proxy=");
            obj = this.j;
        } else {
            sb = hj1.i0("proxySelector=");
            obj = this.k;
        }
        sb.append(obj);
        i0.append(sb.toString());
        i0.append("}");
        return i0.toString();
    }
}
