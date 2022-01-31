package defpackage;

import android.annotation.SuppressLint;
import android.net.http.X509TrustManagerExtensions;
import android.os.Build;
import android.security.NetworkSecurityPolicy;
import defpackage.ul6;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

/* renamed from: hl6  reason: default package */
/* compiled from: Android10Platform.kt */
public final class hl6 extends ol6 {
    public static final boolean e = (ol6.c.c() && Build.VERSION.SDK_INT >= 29);
    public static final hl6 f = null;
    public final List<zl6> d;

    public hl6() {
        zl6[] zl6Arr = new zl6[4];
        zl6Arr[0] = n86.a("Dalvik", System.getProperty("java.vm.name")) && Build.VERSION.SDK_INT >= 29 ? new pl6() : null;
        ul6.a aVar = ul6.g;
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
    public void d(SSLSocket sSLSocket, String str, List<? extends ii6> list) {
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
    @SuppressLint({"NewApi"})
    public boolean h(String str) {
        n86.f(str, "hostname");
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(str);
    }
}
