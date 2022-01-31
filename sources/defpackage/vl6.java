package defpackage;

import defpackage.jl6;
import defpackage.yl6;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.SSLSocket;
import org.bouncycastle.jsse.BCSSLParameters;
import org.bouncycastle.jsse.BCSSLSocket;

/* renamed from: vl6  reason: default package */
/* compiled from: BouncyCastleSocketAdapter.kt */
public final class vl6 implements zl6 {

    /* renamed from: a  reason: collision with root package name */
    public static final yl6.a f3663a = new a();

    /* renamed from: vl6$a */
    /* compiled from: BouncyCastleSocketAdapter.kt */
    public static final class a implements yl6.a {
        @Override // defpackage.yl6.a
        public boolean a(SSLSocket sSLSocket) {
            n86.f(sSLSocket, "sslSocket");
            jl6.a aVar = jl6.f;
            return jl6.e && (sSLSocket instanceof BCSSLSocket);
        }

        @Override // defpackage.yl6.a
        public zl6 b(SSLSocket sSLSocket) {
            n86.f(sSLSocket, "sslSocket");
            return new vl6();
        }
    }

    @Override // defpackage.zl6
    public boolean a(SSLSocket sSLSocket) {
        n86.f(sSLSocket, "sslSocket");
        return sSLSocket instanceof BCSSLSocket;
    }

    @Override // defpackage.zl6
    public boolean b() {
        jl6.a aVar = jl6.f;
        return jl6.e;
    }

    @Override // defpackage.zl6
    public String c(SSLSocket sSLSocket) {
        n86.f(sSLSocket, "sslSocket");
        String applicationProtocol = ((BCSSLSocket) sSLSocket).getApplicationProtocol();
        if (applicationProtocol != null && !n86.a(applicationProtocol, "")) {
            return applicationProtocol;
        }
        return null;
    }

    @Override // defpackage.zl6
    public void d(SSLSocket sSLSocket, String str, List<? extends ii6> list) {
        n86.f(sSLSocket, "sslSocket");
        n86.f(list, "protocols");
        if (a(sSLSocket)) {
            BCSSLSocket bCSSLSocket = (BCSSLSocket) sSLSocket;
            BCSSLParameters parameters = bCSSLSocket.getParameters();
            n86.b(parameters, "sslParameters");
            Object[] array = ((ArrayList) ol6.c.a(list)).toArray(new String[0]);
            if (array != null) {
                parameters.setApplicationProtocols((String[]) array);
                bCSSLSocket.setParameters(parameters);
                return;
            }
            throw new p56("null cannot be cast to non-null type kotlin.Array<T>");
        }
    }
}
