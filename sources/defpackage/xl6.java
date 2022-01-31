package defpackage;

import defpackage.kl6;
import defpackage.yl6;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.SSLSocket;
import org.conscrypt.Conscrypt;

/* renamed from: xl6  reason: default package */
/* compiled from: ConscryptSocketAdapter.kt */
public final class xl6 implements zl6 {

    /* renamed from: a  reason: collision with root package name */
    public static final yl6.a f3941a = new a();

    /* renamed from: xl6$a */
    /* compiled from: ConscryptSocketAdapter.kt */
    public static final class a implements yl6.a {
        @Override // defpackage.yl6.a
        public boolean a(SSLSocket sSLSocket) {
            n86.f(sSLSocket, "sslSocket");
            kl6.a aVar = kl6.f;
            return kl6.e && Conscrypt.isConscrypt(sSLSocket);
        }

        @Override // defpackage.yl6.a
        public zl6 b(SSLSocket sSLSocket) {
            n86.f(sSLSocket, "sslSocket");
            return new xl6();
        }
    }

    @Override // defpackage.zl6
    public boolean a(SSLSocket sSLSocket) {
        n86.f(sSLSocket, "sslSocket");
        return Conscrypt.isConscrypt(sSLSocket);
    }

    @Override // defpackage.zl6
    public boolean b() {
        kl6.a aVar = kl6.f;
        return kl6.e;
    }

    @Override // defpackage.zl6
    public String c(SSLSocket sSLSocket) {
        n86.f(sSLSocket, "sslSocket");
        if (a(sSLSocket)) {
            return Conscrypt.getApplicationProtocol(sSLSocket);
        }
        return null;
    }

    @Override // defpackage.zl6
    public void d(SSLSocket sSLSocket, String str, List<? extends ii6> list) {
        n86.f(sSLSocket, "sslSocket");
        n86.f(list, "protocols");
        if (a(sSLSocket)) {
            Conscrypt.setUseSessionTickets(sSLSocket, true);
            Object[] array = ((ArrayList) ol6.c.a(list)).toArray(new String[0]);
            if (array != null) {
                Conscrypt.setApplicationProtocols(sSLSocket, (String[]) array);
                return;
            }
            throw new p56("null cannot be cast to non-null type kotlin.Array<T>");
        }
    }
}
