package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

/* renamed from: ml6  reason: default package */
/* compiled from: Jdk9Platform.kt */
public class ml6 extends ol6 {
    public static final boolean d;
    public static final a e = new a(null);

    /* renamed from: ml6$a */
    /* compiled from: Jdk9Platform.kt */
    public static final class a {
        public a(j86 j86) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001e, code lost:
        if (r1.intValue() >= 9) goto L_0x002c;
     */
    static {
        /*
            ml6$a r0 = new ml6$a
            r1 = 0
            r0.<init>(r1)
            defpackage.ml6.e = r0
            java.lang.String r0 = "java.specification.version"
            java.lang.String r0 = java.lang.System.getProperty(r0)
            if (r0 == 0) goto L_0x0014
            java.lang.Integer r1 = defpackage.ea6.J(r0)
        L_0x0014:
            r0 = 1
            r2 = 0
            if (r1 == 0) goto L_0x0023
            int r1 = r1.intValue()
            r3 = 9
            if (r1 < r3) goto L_0x0021
            goto L_0x002c
        L_0x0021:
            r0 = 0
            goto L_0x002c
        L_0x0023:
            java.lang.Class<javax.net.ssl.SSLSocket> r1 = javax.net.ssl.SSLSocket.class
            java.lang.String r3 = "getApplicationProtocol"
            java.lang.Class[] r4 = new java.lang.Class[r2]     // Catch:{ NoSuchMethodException -> 0x0021 }
            r1.getMethod(r3, r4)     // Catch:{ NoSuchMethodException -> 0x0021 }
        L_0x002c:
            defpackage.ml6.d = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ml6.<clinit>():void");
    }

    @Override // defpackage.ol6
    public void d(SSLSocket sSLSocket, String str, List<ii6> list) {
        n86.f(sSLSocket, "sslSocket");
        n86.f(list, "protocols");
        SSLParameters sSLParameters = sSLSocket.getSSLParameters();
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
        n86.b(sSLParameters, "sslParameters");
        Object[] array = arrayList2.toArray(new String[0]);
        if (array != null) {
            sSLParameters.setApplicationProtocols((String[]) array);
            sSLSocket.setSSLParameters(sSLParameters);
            return;
        }
        throw new p56("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @Override // defpackage.ol6
    public String f(SSLSocket sSLSocket) {
        n86.f(sSLSocket, "sslSocket");
        try {
            String applicationProtocol = sSLSocket.getApplicationProtocol();
            if (applicationProtocol != null) {
                if (n86.a(applicationProtocol, "")) {
                    return null;
                }
                return applicationProtocol;
            }
        } catch (UnsupportedOperationException unused) {
        }
        return null;
    }
}
