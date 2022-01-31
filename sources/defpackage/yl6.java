package defpackage;

import java.util.List;
import javax.net.ssl.SSLSocket;

/* renamed from: yl6  reason: default package */
/* compiled from: DeferredSocketAdapter.kt */
public final class yl6 implements zl6 {

    /* renamed from: a  reason: collision with root package name */
    public zl6 f4066a;
    public final a b;

    /* renamed from: yl6$a */
    /* compiled from: DeferredSocketAdapter.kt */
    public interface a {
        boolean a(SSLSocket sSLSocket);

        zl6 b(SSLSocket sSLSocket);
    }

    public yl6(a aVar) {
        n86.f(aVar, "socketAdapterFactory");
        this.b = aVar;
    }

    @Override // defpackage.zl6
    public boolean a(SSLSocket sSLSocket) {
        n86.f(sSLSocket, "sslSocket");
        return this.b.a(sSLSocket);
    }

    @Override // defpackage.zl6
    public boolean b() {
        return true;
    }

    @Override // defpackage.zl6
    public String c(SSLSocket sSLSocket) {
        n86.f(sSLSocket, "sslSocket");
        zl6 e = e(sSLSocket);
        if (e != null) {
            return e.c(sSLSocket);
        }
        return null;
    }

    @Override // defpackage.zl6
    public void d(SSLSocket sSLSocket, String str, List<? extends ii6> list) {
        n86.f(sSLSocket, "sslSocket");
        n86.f(list, "protocols");
        zl6 e = e(sSLSocket);
        if (e != null) {
            e.d(sSLSocket, str, list);
        }
    }

    public final synchronized zl6 e(SSLSocket sSLSocket) {
        if (this.f4066a == null && this.b.a(sSLSocket)) {
            this.f4066a = this.b.b(sSLSocket);
        }
        return this.f4066a;
    }
}
