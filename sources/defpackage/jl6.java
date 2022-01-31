package defpackage;

import java.security.KeyStore;
import java.security.Provider;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import org.bouncycastle.jsse.BCSSLParameters;
import org.bouncycastle.jsse.BCSSLSocket;
import org.bouncycastle.jsse.provider.BouncyCastleJsseProvider;

/* renamed from: jl6  reason: default package */
/* compiled from: BouncyCastlePlatform.kt */
public final class jl6 extends ol6 {
    public static final boolean e;
    public static final a f;
    public final Provider d = new BouncyCastleJsseProvider();

    /* renamed from: jl6$a */
    /* compiled from: BouncyCastlePlatform.kt */
    public static final class a {
        public a(j86 j86) {
        }
    }

    static {
        a aVar = new a(null);
        f = aVar;
        boolean z = false;
        try {
            Class.forName("org.bouncycastle.jsse.provider.BouncyCastleJsseProvider", false, aVar.getClass().getClassLoader());
            z = true;
        } catch (ClassNotFoundException unused) {
        }
        e = z;
    }

    @Override // defpackage.ol6
    public void d(SSLSocket sSLSocket, String str, List<ii6> list) {
        n86.f(sSLSocket, "sslSocket");
        n86.f(list, "protocols");
        if (sSLSocket instanceof BCSSLSocket) {
            BCSSLSocket bCSSLSocket = (BCSSLSocket) sSLSocket;
            BCSSLParameters parameters = bCSSLSocket.getParameters();
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
            n86.b(parameters, "sslParameters");
            Object[] array = arrayList2.toArray(new String[0]);
            if (array != null) {
                parameters.setApplicationProtocols((String[]) array);
                bCSSLSocket.setParameters(parameters);
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
        if (sSLSocket instanceof BCSSLSocket) {
            String applicationProtocol = ((BCSSLSocket) sSLSocket).getApplicationProtocol();
            if (applicationProtocol != null && !n86.a(applicationProtocol, "")) {
                return applicationProtocol;
            }
        } else {
            super.f(sSLSocket);
        }
        return null;
    }

    @Override // defpackage.ol6
    public SSLContext l() {
        SSLContext instance = SSLContext.getInstance("TLS", this.d);
        n86.b(instance, "SSLContext.getInstance(\"TLS\", provider)");
        return instance;
    }

    @Override // defpackage.ol6
    public X509TrustManager n() {
        TrustManagerFactory instance = TrustManagerFactory.getInstance("PKIX", "BCJSSE");
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
}
