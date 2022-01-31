package defpackage;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* renamed from: ol6  reason: default package */
/* compiled from: Platform.kt */
public class ol6 {

    /* renamed from: a  reason: collision with root package name */
    public static volatile ol6 f2709a;
    public static final Logger b = Logger.getLogger(hi6.class.getName());
    public static final a c;

    /* renamed from: ol6$a */
    /* compiled from: Platform.kt */
    public static final class a {
        public a(j86 j86) {
        }

        public final List<String> a(List<? extends ii6> list) {
            n86.f(list, "protocols");
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                T next = it.next();
                if (next != ii6.HTTP_1_0) {
                    arrayList.add(next);
                }
            }
            ArrayList arrayList2 = new ArrayList(hd3.I(arrayList, 10));
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                arrayList2.add(((ii6) it2.next()).toString());
            }
            return arrayList2;
        }

        public final byte[] b(List<? extends ii6> list) {
            n86.f(list, "protocols");
            vm6 vm6 = new vm6();
            Iterator it = ((ArrayList) a(list)).iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                vm6.A(str.length());
                vm6.P(str);
            }
            return vm6.O();
        }

        public final boolean c() {
            return n86.a("Dalvik", System.getProperty("java.vm.name"));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00b0, code lost:
        if (r0 != null) goto L_0x0192;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00d6, code lost:
        if (r0 != null) goto L_0x0192;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00fc, code lost:
        if (r0 != null) goto L_0x0192;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0124, code lost:
        if (java.lang.Integer.parseInt(r0) >= 9) goto L_0x0189;
     */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x018b  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x018d  */
    static {
        /*
        // Method dump skipped, instructions count: 417
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ol6.<clinit>():void");
    }

    public static /* synthetic */ void j(ol6 ol6, String str, int i, Throwable th, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 4;
        }
        int i3 = i2 & 4;
        ol6.i(str, i, null);
    }

    public void a(SSLSocket sSLSocket) {
        n86.f(sSLSocket, "sslSocket");
    }

    public em6 b(X509TrustManager x509TrustManager) {
        n86.f(x509TrustManager, "trustManager");
        return new cm6(c(x509TrustManager));
    }

    public gm6 c(X509TrustManager x509TrustManager) {
        n86.f(x509TrustManager, "trustManager");
        X509Certificate[] acceptedIssuers = x509TrustManager.getAcceptedIssuers();
        n86.b(acceptedIssuers, "trustManager.acceptedIssuers");
        return new dm6((X509Certificate[]) Arrays.copyOf(acceptedIssuers, acceptedIssuers.length));
    }

    public void d(SSLSocket sSLSocket, String str, List<ii6> list) {
        n86.f(sSLSocket, "sslSocket");
        n86.f(list, "protocols");
    }

    public void e(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        n86.f(socket, "socket");
        n86.f(inetSocketAddress, "address");
        socket.connect(inetSocketAddress, i);
    }

    public String f(SSLSocket sSLSocket) {
        n86.f(sSLSocket, "sslSocket");
        return null;
    }

    public Object g(String str) {
        n86.f(str, "closer");
        if (b.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    public boolean h(String str) {
        n86.f(str, "hostname");
        return true;
    }

    public void i(String str, int i, Throwable th) {
        n86.f(str, "message");
        b.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public void k(String str, Object obj) {
        n86.f(str, "message");
        if (obj == null) {
            str = hj1.S(str, " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);");
        }
        i(str, 5, (Throwable) obj);
    }

    public SSLContext l() {
        SSLContext instance = SSLContext.getInstance("TLS");
        n86.b(instance, "SSLContext.getInstance(\"TLS\")");
        return instance;
    }

    public SSLSocketFactory m(X509TrustManager x509TrustManager) {
        n86.f(x509TrustManager, "trustManager");
        try {
            SSLContext l = l();
            l.init(null, new TrustManager[]{x509TrustManager}, null);
            SSLSocketFactory socketFactory = l.getSocketFactory();
            n86.b(socketFactory, "newSSLContext().apply {\n…ll)\n      }.socketFactory");
            return socketFactory;
        } catch (GeneralSecurityException e) {
            throw new AssertionError("No System TLS: " + e, e);
        }
    }

    public X509TrustManager n() {
        TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        instance.init((KeyStore) null);
        n86.b(instance, "factory");
        TrustManager[] trustManagers = instance.getTrustManagers();
        if (trustManagers != null) {
            boolean z = true;
            if (trustManagers.length != 1 || !(trustManagers[0] instanceof X509TrustManager)) {
                z = false;
            }
            if (z) {
                TrustManager trustManager = trustManagers[0];
                if (trustManager != null) {
                    return (X509TrustManager) trustManager;
                }
                throw new p56("null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
            }
            StringBuilder i0 = hj1.i0("Unexpected default trust managers: ");
            String arrays = Arrays.toString(trustManagers);
            n86.b(arrays, "java.util.Arrays.toString(this)");
            i0.append(arrays);
            throw new IllegalStateException(i0.toString().toString());
        }
        n86.k();
        throw null;
    }

    public String toString() {
        String simpleName = getClass().getSimpleName();
        n86.b(simpleName, "javaClass.simpleName");
        return simpleName;
    }
}
