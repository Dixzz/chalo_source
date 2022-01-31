package defpackage;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* renamed from: am6  reason: default package */
/* compiled from: StandardAndroidSocketAdapter.kt */
public final class am6 extends ul6 {
    public static final a h = new a(null);

    /* renamed from: am6$a */
    /* compiled from: StandardAndroidSocketAdapter.kt */
    public static final class a {
        public a(j86 j86) {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public am6(Class<? super SSLSocket> cls, Class<? super SSLSocketFactory> cls2, Class<?> cls3) {
        super(cls);
        n86.f(cls, "sslSocketClass");
        n86.f(cls2, "sslSocketFactoryClass");
        n86.f(cls3, "paramClass");
    }
}
