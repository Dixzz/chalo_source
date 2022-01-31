package defpackage;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;

/* renamed from: xi6  reason: default package */
/* compiled from: JavaNetAuthenticator.kt */
public final class xi6 implements fh6 {
    public final wh6 b;

    public xi6(wh6 wh6, int i) {
        wh6 wh62 = (i & 1) != 0 ? wh6.f3784a : null;
        n86.f(wh62, "defaultDns");
        this.b = wh62;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x01b3  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01b9  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01e5  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x020f  */
    @Override // defpackage.fh6
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public defpackage.ji6 a(defpackage.pi6 r22, defpackage.ni6 r23) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 541
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xi6.a(pi6, ni6):ji6");
    }

    public final InetAddress b(Proxy proxy, di6 di6, wh6 wh6) throws IOException {
        Proxy.Type type = proxy.type();
        if (type != null && wi6.f3788a[type.ordinal()] == 1) {
            return (InetAddress) y56.h(wh6.a(di6.e));
        }
        SocketAddress address = proxy.address();
        if (address != null) {
            InetAddress address2 = ((InetSocketAddress) address).getAddress();
            n86.b(address2, "(address() as InetSocketAddress).address");
            return address2;
        }
        throw new p56("null cannot be cast to non-null type java.net.InetSocketAddress");
    }
}
