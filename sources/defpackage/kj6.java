package defpackage;

import com.google.firebase.analytics.FirebaseAnalytics;
import defpackage.nh6;
import defpackage.qh6;
import java.io.IOException;
import java.net.UnknownServiceException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* renamed from: kj6  reason: default package */
/* compiled from: ConnectionSpecSelector.kt */
public final class kj6 {

    /* renamed from: a  reason: collision with root package name */
    public int f2068a;
    public boolean b;
    public boolean c;
    public final List<qh6> d;

    public kj6(List<qh6> list) {
        n86.f(list, "connectionSpecs");
        this.d = list;
    }

    public final qh6 a(SSLSocket sSLSocket) throws IOException {
        qh6 qh6;
        boolean z;
        String[] strArr;
        String[] strArr2;
        n86.f(sSLSocket, "sslSocket");
        int i = this.f2068a;
        int size = this.d.size();
        while (true) {
            if (i >= size) {
                qh6 = null;
                break;
            }
            qh6 = this.d.get(i);
            if (qh6.b(sSLSocket)) {
                this.f2068a = i + 1;
                break;
            }
            i++;
        }
        if (qh6 == null) {
            StringBuilder i0 = hj1.i0("Unable to find acceptable protocols. isFallback=");
            i0.append(this.c);
            i0.append(',');
            i0.append(" modes=");
            i0.append(this.d);
            i0.append(',');
            i0.append(" supported protocols=");
            String[] enabledProtocols = sSLSocket.getEnabledProtocols();
            if (enabledProtocols == null) {
                n86.k();
                throw null;
            }
            String arrays = Arrays.toString(enabledProtocols);
            n86.b(arrays, "java.util.Arrays.toString(this)");
            i0.append(arrays);
            throw new UnknownServiceException(i0.toString());
        }
        int i2 = this.f2068a;
        int size2 = this.d.size();
        while (true) {
            if (i2 >= size2) {
                z = false;
                break;
            } else if (this.d.get(i2).b(sSLSocket)) {
                z = true;
                break;
            } else {
                i2++;
            }
        }
        this.b = z;
        boolean z2 = this.c;
        n86.f(sSLSocket, "sslSocket");
        if (qh6.c != null) {
            String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
            n86.b(enabledCipherSuites, "sslSocket.enabledCipherSuites");
            String[] strArr3 = qh6.c;
            nh6.b bVar = nh6.t;
            Comparator<String> comparator = nh6.b;
            strArr = vi6.p(enabledCipherSuites, strArr3, nh6.b);
        } else {
            strArr = sSLSocket.getEnabledCipherSuites();
        }
        if (qh6.d != null) {
            String[] enabledProtocols2 = sSLSocket.getEnabledProtocols();
            n86.b(enabledProtocols2, "sslSocket.enabledProtocols");
            strArr2 = vi6.p(enabledProtocols2, qh6.d, f66.f);
        } else {
            strArr2 = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        n86.b(supportedCipherSuites, "supportedCipherSuites");
        nh6.b bVar2 = nh6.t;
        Comparator<String> comparator2 = nh6.b;
        Comparator<String> comparator3 = nh6.b;
        byte[] bArr = vi6.f3652a;
        n86.f(supportedCipherSuites, "$this$indexOf");
        n86.f("TLS_FALLBACK_SCSV", FirebaseAnalytics.Param.VALUE);
        n86.f(comparator3, "comparator");
        int length = supportedCipherSuites.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                i3 = -1;
                break;
            }
            if (((nh6.a) comparator3).compare(supportedCipherSuites[i3], "TLS_FALLBACK_SCSV") == 0) {
                break;
            }
            i3++;
        }
        if (z2 && i3 != -1) {
            n86.b(strArr, "cipherSuitesIntersection");
            String str = supportedCipherSuites[i3];
            n86.b(str, "supportedCipherSuites[indexOfFallbackScsv]");
            n86.f(strArr, "$this$concat");
            n86.f(str, FirebaseAnalytics.Param.VALUE);
            Object[] copyOf = Arrays.copyOf(strArr, strArr.length + 1);
            n86.b(copyOf, "java.util.Arrays.copyOf(this, newSize)");
            strArr = (String[]) copyOf;
            n86.e(strArr, "$this$lastIndex");
            strArr[strArr.length - 1] = str;
        }
        qh6.a aVar = new qh6.a(qh6);
        n86.b(strArr, "cipherSuitesIntersection");
        aVar.b((String[]) Arrays.copyOf(strArr, strArr.length));
        n86.b(strArr2, "tlsVersionsIntersection");
        aVar.e((String[]) Arrays.copyOf(strArr2, strArr2.length));
        qh6 a2 = aVar.a();
        if (a2.c() != null) {
            sSLSocket.setEnabledProtocols(a2.d);
        }
        if (a2.a() != null) {
            sSLSocket.setEnabledCipherSuites(a2.c);
        }
        return qh6;
    }
}
