package defpackage;

import android.annotation.SuppressLint;
import android.net.ssl.SSLSockets;
import android.os.Build;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

@SuppressLint({"NewApi"})
/* renamed from: pl6  reason: default package */
/* compiled from: Android10SocketAdapter.kt */
public final class pl6 implements zl6 {
    @Override // defpackage.zl6
    public boolean a(SSLSocket sSLSocket) {
        n86.f(sSLSocket, "sslSocket");
        return SSLSockets.isSupportedSocket(sSLSocket);
    }

    @Override // defpackage.zl6
    public boolean b() {
        return ol6.c.c() && Build.VERSION.SDK_INT >= 29;
    }

    @Override // defpackage.zl6
    @SuppressLint({"NewApi"})
    public String c(SSLSocket sSLSocket) {
        n86.f(sSLSocket, "sslSocket");
        String applicationProtocol = sSLSocket.getApplicationProtocol();
        if (applicationProtocol != null && !n86.a(applicationProtocol, "")) {
            return applicationProtocol;
        }
        return null;
    }

    @Override // defpackage.zl6
    @SuppressLint({"NewApi"})
    public void d(SSLSocket sSLSocket, String str, List<? extends ii6> list) {
        n86.f(sSLSocket, "sslSocket");
        n86.f(list, "protocols");
        try {
            SSLSockets.setUseSessionTickets(sSLSocket, true);
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            n86.b(sSLParameters, "sslParameters");
            Object[] array = ((ArrayList) ol6.c.a(list)).toArray(new String[0]);
            if (array != null) {
                sSLParameters.setApplicationProtocols((String[]) array);
                sSLSocket.setSSLParameters(sSLParameters);
                return;
            }
            throw new p56("null cannot be cast to non-null type kotlin.Array<T>");
        } catch (IllegalArgumentException e) {
            throw new IOException("Android internal error", e);
        }
    }
}
