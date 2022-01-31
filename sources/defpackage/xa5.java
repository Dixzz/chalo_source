package defpackage;

import java.net.InetSocketAddress;

/* renamed from: xa5  reason: default package */
/* compiled from: WebSocketAdapter */
public abstract class xa5 implements za5 {
    public String a(wa5 wa5) throws hb5 {
        InetSocketAddress g = ((ya5) wa5).g();
        if (g != null) {
            StringBuffer stringBuffer = new StringBuffer(90);
            stringBuffer.append("<cross-domain-policy><allow-access-from domain=\"*\" to-ports=\"");
            stringBuffer.append(g.getPort());
            stringBuffer.append("\" /></cross-domain-policy>\u0000");
            return stringBuffer.toString();
        }
        throw new jb5("socket not bound");
    }
}
