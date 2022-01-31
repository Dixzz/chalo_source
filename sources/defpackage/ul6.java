package defpackage;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import defpackage.il6;
import defpackage.yl6;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;

/* renamed from: ul6  reason: default package */
/* compiled from: AndroidSocketAdapter.kt */
public class ul6 implements zl6 {
    public static final yl6.a f = new tl6("com.google.android.gms.org.conscrypt");
    public static final a g;

    /* renamed from: a  reason: collision with root package name */
    public final Method f3524a;
    public final Method b;
    public final Method c;
    public final Method d;
    public final Class<? super SSLSocket> e;

    /* renamed from: ul6$a */
    /* compiled from: AndroidSocketAdapter.kt */
    public static final class a {
        public a(j86 j86) {
        }
    }

    static {
        a aVar = new a(null);
        g = aVar;
        Objects.requireNonNull(aVar);
        n86.f("com.google.android.gms.org.conscrypt", RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME);
    }

    public ul6(Class<? super SSLSocket> cls) {
        n86.f(cls, "sslSocketClass");
        this.e = cls;
        Method declaredMethod = cls.getDeclaredMethod("setUseSessionTickets", Boolean.TYPE);
        n86.b(declaredMethod, "sslSocketClass.getDeclar…:class.javaPrimitiveType)");
        this.f3524a = declaredMethod;
        this.b = cls.getMethod("setHostname", String.class);
        this.c = cls.getMethod("getAlpnSelectedProtocol", new Class[0]);
        this.d = cls.getMethod("setAlpnProtocols", byte[].class);
    }

    @Override // defpackage.zl6
    public boolean a(SSLSocket sSLSocket) {
        n86.f(sSLSocket, "sslSocket");
        return this.e.isInstance(sSLSocket);
    }

    @Override // defpackage.zl6
    public boolean b() {
        il6.a aVar = il6.g;
        return il6.f;
    }

    @Override // defpackage.zl6
    public String c(SSLSocket sSLSocket) {
        n86.f(sSLSocket, "sslSocket");
        if (!a(sSLSocket)) {
            return null;
        }
        try {
            byte[] bArr = (byte[]) this.c.invoke(sSLSocket, new Object[0]);
            if (bArr == null) {
                return null;
            }
            Charset charset = StandardCharsets.UTF_8;
            n86.b(charset, "StandardCharsets.UTF_8");
            return new String(bArr, charset);
        } catch (NullPointerException e2) {
            if (n86.a(e2.getMessage(), "ssl == null")) {
                return null;
            }
            throw e2;
        } catch (IllegalAccessException e3) {
            throw new AssertionError(e3);
        } catch (InvocationTargetException e4) {
            throw new AssertionError(e4);
        }
    }

    @Override // defpackage.zl6
    public void d(SSLSocket sSLSocket, String str, List<? extends ii6> list) {
        n86.f(sSLSocket, "sslSocket");
        n86.f(list, "protocols");
        if (a(sSLSocket)) {
            try {
                this.f3524a.invoke(sSLSocket, Boolean.TRUE);
                if (str != null) {
                    this.b.invoke(sSLSocket, str);
                }
                this.d.invoke(sSLSocket, ol6.c.b(list));
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            } catch (InvocationTargetException e3) {
                throw new AssertionError(e3);
            }
        }
    }
}
