package defpackage;

import com.razorpay.AnalyticsConstants;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* renamed from: ll6  reason: default package */
/* compiled from: Jdk8WithJettyBootPlatform.kt */
public final class ll6 extends ol6 {
    public final Method d;
    public final Method e;
    public final Method f;
    public final Class<?> g;
    public final Class<?> h;

    /* renamed from: ll6$a */
    /* compiled from: Jdk8WithJettyBootPlatform.kt */
    public static final class a implements InvocationHandler {

        /* renamed from: a  reason: collision with root package name */
        public boolean f2236a;
        public String b;
        public final List<String> c;

        public a(List<String> list) {
            n86.f(list, "protocols");
            this.c = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            n86.f(obj, "proxy");
            n86.f(method, "method");
            if (objArr == null) {
                objArr = new Object[0];
            }
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (n86.a(name, "supports") && n86.a(Boolean.TYPE, returnType)) {
                return Boolean.TRUE;
            }
            if (!n86.a(name, "unsupported") || !n86.a(Void.TYPE, returnType)) {
                if (n86.a(name, "protocols")) {
                    if (objArr.length == 0) {
                        return this.c;
                    }
                }
                if ((n86.a(name, "selectProtocol") || n86.a(name, "select")) && n86.a(String.class, returnType) && objArr.length == 1 && (objArr[0] instanceof List)) {
                    Object obj2 = objArr[0];
                    if (obj2 != null) {
                        List list = (List) obj2;
                        int size = list.size();
                        if (size >= 0) {
                            int i = 0;
                            while (true) {
                                Object obj3 = list.get(i);
                                if (obj3 != null) {
                                    String str = (String) obj3;
                                    if (!this.c.contains(str)) {
                                        if (i == size) {
                                            break;
                                        }
                                        i++;
                                    } else {
                                        this.b = str;
                                        return str;
                                    }
                                } else {
                                    throw new p56("null cannot be cast to non-null type kotlin.String");
                                }
                            }
                        }
                        String str2 = this.c.get(0);
                        this.b = str2;
                        return str2;
                    }
                    throw new p56("null cannot be cast to non-null type kotlin.collections.List<*>");
                } else if ((!n86.a(name, "protocolSelected") && !n86.a(name, AnalyticsConstants.SELECTED)) || objArr.length != 1) {
                    return method.invoke(this, Arrays.copyOf(objArr, objArr.length));
                } else {
                    Object obj4 = objArr[0];
                    if (obj4 != null) {
                        this.b = (String) obj4;
                        return null;
                    }
                    throw new p56("null cannot be cast to non-null type kotlin.String");
                }
            } else {
                this.f2236a = true;
                return null;
            }
        }
    }

    public ll6(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        n86.f(method, "putMethod");
        n86.f(method2, "getMethod");
        n86.f(method3, "removeMethod");
        n86.f(cls, "clientProviderClass");
        n86.f(cls2, "serverProviderClass");
        this.d = method;
        this.e = method2;
        this.f = method3;
        this.g = cls;
        this.h = cls2;
    }

    @Override // defpackage.ol6
    public void a(SSLSocket sSLSocket) {
        n86.f(sSLSocket, "sslSocket");
        try {
            this.f.invoke(null, sSLSocket);
        } catch (IllegalAccessException e2) {
            throw new AssertionError("failed to remove ALPN", e2);
        } catch (InvocationTargetException e3) {
            throw new AssertionError("failed to remove ALPN", e3);
        }
    }

    @Override // defpackage.ol6
    public void d(SSLSocket sSLSocket, String str, List<? extends ii6> list) {
        n86.f(sSLSocket, "sslSocket");
        n86.f(list, "protocols");
        n86.f(list, "protocols");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            boolean z = true;
            if (!it.hasNext()) {
                break;
            }
            T next = it.next();
            if (next == ii6.HTTP_1_0) {
                z = false;
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
        try {
            Object newProxyInstance = Proxy.newProxyInstance(ol6.class.getClassLoader(), new Class[]{this.g, this.h}, new a(arrayList2));
            this.d.invoke(null, sSLSocket, newProxyInstance);
        } catch (InvocationTargetException e2) {
            throw new AssertionError("failed to set ALPN", e2);
        } catch (IllegalAccessException e3) {
            throw new AssertionError("failed to set ALPN", e3);
        }
    }

    @Override // defpackage.ol6
    public String f(SSLSocket sSLSocket) {
        n86.f(sSLSocket, "sslSocket");
        try {
            InvocationHandler invocationHandler = Proxy.getInvocationHandler(this.e.invoke(null, sSLSocket));
            if (invocationHandler != null) {
                a aVar = (a) invocationHandler;
                boolean z = aVar.f2236a;
                if (!z && aVar.b == null) {
                    ol6.j(this, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", 0, null, 6, null);
                    return null;
                } else if (z) {
                    return null;
                } else {
                    return aVar.b;
                }
            } else {
                throw new p56("null cannot be cast to non-null type okhttp3.internal.platform.Jdk8WithJettyBootPlatform.AlpnProvider");
            }
        } catch (InvocationTargetException e2) {
            throw new AssertionError("failed to get ALPN selected protocol", e2);
        } catch (IllegalAccessException e3) {
            throw new AssertionError("failed to get ALPN selected protocol", e3);
        }
    }
}
