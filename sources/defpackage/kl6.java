package defpackage;

import java.security.KeyStore;
import java.security.Provider;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import org.conscrypt.Conscrypt;
import org.conscrypt.ConscryptHostnameVerifier;

/* renamed from: kl6  reason: default package */
/* compiled from: ConscryptPlatform.kt */
public final class kl6 extends ol6 {
    public static final boolean e;
    public static final a f;
    public final Provider d;

    /* renamed from: kl6$a */
    /* compiled from: ConscryptPlatform.kt */
    public static final class a {
        public a(j86 j86) {
        }

        public final boolean a(int i, int i2, int i3) {
            Conscrypt.Version version = Conscrypt.version();
            if (version.major() != i) {
                if (version.major() > i) {
                    return true;
                }
                return false;
            } else if (version.minor() != i2) {
                if (version.minor() > i2) {
                    return true;
                }
                return false;
            } else if (version.patch() >= i3) {
                return true;
            } else {
                return false;
            }
        }
    }

    /* renamed from: kl6$b */
    /* compiled from: ConscryptPlatform.kt */
    public static final class b implements ConscryptHostnameVerifier {

        /* renamed from: a  reason: collision with root package name */
        public static final b f2076a = new b();
    }

    static {
        a aVar = new a(null);
        f = aVar;
        boolean z = false;
        try {
            Class.forName("org.conscrypt.Conscrypt$Version", false, aVar.getClass().getClassLoader());
            if (Conscrypt.isAvailable() && aVar.a(2, 1, 0)) {
                z = true;
            }
        } catch (ClassNotFoundException | NoClassDefFoundError unused) {
        }
        e = z;
    }

    public kl6() {
        Provider build = Conscrypt.newProviderBuilder().provideTrustManager(true).build();
        n86.b(build, "Conscrypt.newProviderBui…rustManager(true).build()");
        this.d = build;
    }

    @Override // defpackage.ol6
    public void d(SSLSocket sSLSocket, String str, List<ii6> list) {
        n86.f(sSLSocket, "sslSocket");
        n86.f(list, "protocols");
        if (Conscrypt.isConscrypt(sSLSocket)) {
            Conscrypt.setUseSessionTickets(sSLSocket, true);
            n86.f(list, "protocols");
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = list.iterator();
            while (true) {
                boolean z = false;
                if (!it.hasNext()) {
                    break;
                }
                T next = it.next();
                if (next != ii6.HTTP_1_0) {
                    z = true;
                }
                if (z) {
                    arrayList.add(next);
                }
            }
            ArrayList arrayList2 = new ArrayList(hd3.I(arrayList, 10));
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                arrayList2.add(((ii6) it2.next()).toString());
            }
            Object[] array = arrayList2.toArray(new String[0]);
            if (array != null) {
                Conscrypt.setApplicationProtocols(sSLSocket, (String[]) array);
                return;
            }
            throw new p56("null cannot be cast to non-null type kotlin.Array<T>");
        }
        n86.f(sSLSocket, "sslSocket");
        n86.f(list, "protocols");
    }

    @Override // defpackage.ol6
    public String f(SSLSocket sSLSocket) {
        n86.f(sSLSocket, "sslSocket");
        if (Conscrypt.isConscrypt(sSLSocket)) {
            return Conscrypt.getApplicationProtocol(sSLSocket);
        }
        super.f(sSLSocket);
        return null;
    }

    @Override // defpackage.ol6
    public SSLContext l() {
        SSLContext instance = SSLContext.getInstance("TLS", this.d);
        n86.b(instance, "SSLContext.getInstance(\"TLS\", provider)");
        return instance;
    }

    @Override // defpackage.ol6
    public SSLSocketFactory m(X509TrustManager x509TrustManager) {
        n86.f(x509TrustManager, "trustManager");
        SSLContext instance = SSLContext.getInstance("TLS", this.d);
        n86.b(instance, "SSLContext.getInstance(\"TLS\", provider)");
        instance.init(null, new TrustManager[]{x509TrustManager}, null);
        SSLSocketFactory socketFactory = instance.getSocketFactory();
        Conscrypt.setUseEngineSocket(socketFactory, true);
        n86.b(socketFactory, "newSSLContext().apply {\n…ineSocket(it, true)\n    }");
        return socketFactory;
    }

    @Override // defpackage.ol6
    public X509TrustManager n() {
        TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        instance.init((KeyStore) null);
        n86.b(instance, "TrustManagerFactory.getI…(null as KeyStore?)\n    }");
        TrustManager[] trustManagers = instance.getTrustManagers();
        if (trustManagers != null) {
            boolean z = true;
            if (trustManagers.length != 1 || !(trustManagers[0] instanceof X509TrustManager)) {
                z = false;
            }
            if (z) {
                TrustManager trustManager = trustManagers[0];
                if (trustManager != null) {
                    X509TrustManager x509TrustManager = (X509TrustManager) trustManager;
                    Conscrypt.setHostnameVerifier(x509TrustManager, b.f2076a);
                    return x509TrustManager;
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
}
