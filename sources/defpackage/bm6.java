package defpackage;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.List;

/* renamed from: bm6  reason: default package */
/* compiled from: NullProxySelector.kt */
public final class bm6 extends ProxySelector {

    /* renamed from: a  reason: collision with root package name */
    public static final bm6 f451a = new bm6();

    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
    }

    @Override // java.net.ProxySelector
    public List<Proxy> select(URI uri) {
        if (uri != null) {
            return hd3.c2(Proxy.NO_PROXY);
        }
        throw new IllegalArgumentException("uri must not be null".toString());
    }
}
