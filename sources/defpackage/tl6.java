package defpackage;

import defpackage.ul6;
import defpackage.yl6;
import javax.net.ssl.SSLSocket;

/* renamed from: tl6  reason: default package */
/* compiled from: AndroidSocketAdapter.kt */
public final class tl6 implements yl6.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f3375a;

    public tl6(String str) {
        this.f3375a = str;
    }

    @Override // defpackage.yl6.a
    public boolean a(SSLSocket sSLSocket) {
        n86.f(sSLSocket, "sslSocket");
        String name = sSLSocket.getClass().getName();
        n86.b(name, "sslSocket.javaClass.name");
        return ea6.G(name, hj1.Z(new StringBuilder(), this.f3375a, '.'), false, 2);
    }

    @Override // defpackage.yl6.a
    public zl6 b(SSLSocket sSLSocket) {
        n86.f(sSLSocket, "sslSocket");
        ul6.a aVar = ul6.g;
        Class<?> cls = sSLSocket.getClass();
        Class<?> cls2 = cls;
        while (cls2 != null && (!n86.a(cls2.getSimpleName(), "OpenSSLSocketImpl"))) {
            cls2 = cls2.getSuperclass();
            if (cls2 == null) {
                throw new AssertionError("No OpenSSLSocketImpl superclass of socket of type " + cls);
            }
        }
        if (cls2 != null) {
            return new ul6(cls2);
        }
        n86.k();
        throw null;
    }
}
