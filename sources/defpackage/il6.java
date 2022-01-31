package defpackage;

import android.net.http.X509TrustManagerExtensions;
import android.os.Build;
import android.security.NetworkSecurityPolicy;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import defpackage.am6;
import defpackage.ul6;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

/* renamed from: il6  reason: default package */
/* compiled from: AndroidPlatform.kt */
public final class il6 extends ol6 {
    public static final boolean f;
    public static final a g = new a(null);
    public final List<zl6> d;
    public final wl6 e;

    /* renamed from: il6$a */
    /* compiled from: AndroidPlatform.kt */
    public static final class a {
        public a(j86 j86) {
        }
    }

    /* renamed from: il6$b */
    /* compiled from: AndroidPlatform.kt */
    public static final class b implements gm6 {

        /* renamed from: a  reason: collision with root package name */
        public final X509TrustManager f1534a;
        public final Method b;

        public b(X509TrustManager x509TrustManager, Method method) {
            n86.f(x509TrustManager, "trustManager");
            n86.f(method, "findByIssuerAndSignatureMethod");
            this.f1534a = x509TrustManager;
            this.b = method;
        }

        @Override // defpackage.gm6
        public X509Certificate a(X509Certificate x509Certificate) {
            n86.f(x509Certificate, "cert");
            try {
                Object invoke = this.b.invoke(this.f1534a, x509Certificate);
                if (invoke != null) {
                    return ((TrustAnchor) invoke).getTrustedCert();
                }
                throw new p56("null cannot be cast to non-null type java.security.cert.TrustAnchor");
            } catch (IllegalAccessException e) {
                throw new AssertionError("unable to get issues and signature", e);
            } catch (InvocationTargetException unused) {
                return null;
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return n86.a(this.f1534a, bVar.f1534a) && n86.a(this.b, bVar.b);
        }

        public int hashCode() {
            X509TrustManager x509TrustManager = this.f1534a;
            int i = 0;
            int hashCode = (x509TrustManager != null ? x509TrustManager.hashCode() : 0) * 31;
            Method method = this.b;
            if (method != null) {
                i = method.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            StringBuilder i0 = hj1.i0("CustomTrustRootIndex(trustManager=");
            i0.append(this.f1534a);
            i0.append(", findByIssuerAndSignatureMethod=");
            i0.append(this.b);
            i0.append(")");
            return i0.toString();
        }
    }

    static {
        boolean z = false;
        if (ol6.c.c() && Build.VERSION.SDK_INT < 30) {
            z = true;
        }
        f = z;
    }

    public il6() {
        am6 am6;
        Method method;
        Method method2;
        zl6[] zl6Arr = new zl6[4];
        am6.a aVar = am6.h;
        n86.f("com.android.org.conscrypt", RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME);
        Method method3 = null;
        try {
            Class<?> cls = Class.forName("com.android.org.conscrypt.OpenSSLSocketImpl");
            Class<?> cls2 = Class.forName("com.android.org.conscrypt" + ".OpenSSLSocketFactoryImpl");
            Class<?> cls3 = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
            n86.b(cls3, "paramsClass");
            am6 = new am6(cls, cls2, cls3);
        } catch (Exception e2) {
            ol6.f2709a.i("unable to load android socket classes", 5, e2);
            am6 = null;
        }
        zl6Arr[0] = am6;
        ul6.a aVar2 = ul6.g;
        zl6Arr[1] = new yl6(ul6.f);
        zl6Arr[2] = new yl6(xl6.f3941a);
        zl6Arr[3] = new yl6(vl6.f3663a);
        List n = y56.n(zl6Arr);
        ArrayList arrayList = new ArrayList();
        Iterator it = ((ArrayList) n).iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (((zl6) next).b()) {
                arrayList.add(next);
            }
        }
        this.d = arrayList;
        try {
            Class<?> cls4 = Class.forName("dalvik.system.CloseGuard");
            Method method4 = cls4.getMethod("get", new Class[0]);
            method = cls4.getMethod("open", String.class);
            method2 = cls4.getMethod("warnIfOpen", new Class[0]);
            method3 = method4;
        } catch (Exception unused) {
            method2 = null;
            method = null;
        }
        this.e = new wl6(method3, method, method2);
    }

    @Override // defpackage.ol6
    public em6 b(X509TrustManager x509TrustManager) {
        X509TrustManagerExtensions x509TrustManagerExtensions;
        n86.f(x509TrustManager, "trustManager");
        n86.f(x509TrustManager, "trustManager");
        ql6 ql6 = null;
        try {
            x509TrustManagerExtensions = new X509TrustManagerExtensions(x509TrustManager);
        } catch (IllegalArgumentException unused) {
            x509TrustManagerExtensions = null;
        }
        if (x509TrustManagerExtensions != null) {
            ql6 = new ql6(x509TrustManager, x509TrustManagerExtensions);
        }
        return ql6 != null ? ql6 : super.b(x509TrustManager);
    }

    @Override // defpackage.ol6
    public gm6 c(X509TrustManager x509TrustManager) {
        n86.f(x509TrustManager, "trustManager");
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            n86.b(declaredMethod, "method");
            declaredMethod.setAccessible(true);
            return new b(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.c(x509TrustManager);
        }
    }

    @Override // defpackage.ol6
    public void d(SSLSocket sSLSocket, String str, List<ii6> list) {
        T t;
        n86.f(sSLSocket, "sslSocket");
        n86.f(list, "protocols");
        Iterator<T> it = this.d.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (t.a(sSLSocket)) {
                break;
            }
        }
        T t2 = t;
        if (t2 != null) {
            t2.d(sSLSocket, str, list);
        }
    }

    @Override // defpackage.ol6
    public void e(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        n86.f(socket, "socket");
        n86.f(inetSocketAddress, "address");
        try {
            socket.connect(inetSocketAddress, i);
        } catch (ClassCastException e2) {
            if (Build.VERSION.SDK_INT == 26) {
                throw new IOException("Exception in connect", e2);
            }
            throw e2;
        }
    }

    @Override // defpackage.ol6
    public String f(SSLSocket sSLSocket) {
        T t;
        n86.f(sSLSocket, "sslSocket");
        Iterator<T> it = this.d.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (t.a(sSLSocket)) {
                break;
            }
        }
        T t2 = t;
        if (t2 != null) {
            return t2.c(sSLSocket);
        }
        return null;
    }

    @Override // defpackage.ol6
    public Object g(String str) {
        n86.f(str, "closer");
        wl6 wl6 = this.e;
        Objects.requireNonNull(wl6);
        n86.f(str, "closer");
        Method method = wl6.f3801a;
        if (method == null) {
            return null;
        }
        try {
            Object invoke = method.invoke(null, new Object[0]);
            Method method2 = wl6.b;
            if (method2 != null) {
                method2.invoke(invoke, str);
                return invoke;
            }
            n86.k();
            throw null;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // defpackage.ol6
    public boolean h(String str) {
        n86.f(str, "hostname");
        int i = Build.VERSION.SDK_INT;
        if (i >= 24) {
            return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(str);
        }
        if (i < 23) {
            return true;
        }
        NetworkSecurityPolicy instance = NetworkSecurityPolicy.getInstance();
        n86.b(instance, "NetworkSecurityPolicy.getInstance()");
        return instance.isCleartextTrafficPermitted();
    }

    @Override // defpackage.ol6
    public void k(String str, Object obj) {
        n86.f(str, "message");
        wl6 wl6 = this.e;
        Objects.requireNonNull(wl6);
        boolean z = false;
        if (obj != null) {
            try {
                Method method = wl6.c;
                if (method != null) {
                    method.invoke(obj, new Object[0]);
                    z = true;
                } else {
                    n86.k();
                    throw null;
                }
            } catch (Exception unused) {
            }
        }
        if (!z) {
            ol6.j(this, str, 5, null, 4, null);
        }
    }
}
