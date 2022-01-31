package defpackage;

import defpackage.nh6;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;

/* renamed from: qh6  reason: default package */
/* compiled from: ConnectionSpec.kt */
public final class qh6 {
    public static final nh6[] e;
    public static final nh6[] f;
    public static final qh6 g;
    public static final qh6 h = new qh6(false, false, null, null);

    /* renamed from: a  reason: collision with root package name */
    public final boolean f2945a;
    public final boolean b;
    public final String[] c;
    public final String[] d;

    /* renamed from: qh6$a */
    /* compiled from: ConnectionSpec.kt */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f2946a;
        public String[] b;
        public String[] c;
        public boolean d;

        public a(boolean z) {
            this.f2946a = z;
        }

        public final qh6 a() {
            return new qh6(this.f2946a, this.d, this.b, this.c);
        }

        public final a b(String... strArr) {
            n86.f(strArr, "cipherSuites");
            if (this.f2946a) {
                if (!(strArr.length == 0)) {
                    Object clone = strArr.clone();
                    if (clone != null) {
                        this.b = (String[]) clone;
                        return this;
                    }
                    throw new p56("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
                }
                throw new IllegalArgumentException("At least one cipher suite is required".toString());
            }
            throw new IllegalArgumentException("no cipher suites for cleartext connections".toString());
        }

        public final a c(nh6... nh6Arr) {
            n86.f(nh6Arr, "cipherSuites");
            if (this.f2946a) {
                ArrayList arrayList = new ArrayList(nh6Arr.length);
                for (nh6 nh6 : nh6Arr) {
                    arrayList.add(nh6.f2554a);
                }
                Object[] array = arrayList.toArray(new String[0]);
                if (array != null) {
                    String[] strArr = (String[]) array;
                    b((String[]) Arrays.copyOf(strArr, strArr.length));
                    return this;
                }
                throw new p56("null cannot be cast to non-null type kotlin.Array<T>");
            }
            throw new IllegalArgumentException("no cipher suites for cleartext connections".toString());
        }

        public final a d(boolean z) {
            if (this.f2946a) {
                this.d = z;
                return this;
            }
            throw new IllegalArgumentException("no TLS extensions for cleartext connections".toString());
        }

        public final a e(String... strArr) {
            n86.f(strArr, "tlsVersions");
            if (this.f2946a) {
                if (!(strArr.length == 0)) {
                    Object clone = strArr.clone();
                    if (clone != null) {
                        this.c = (String[]) clone;
                        return this;
                    }
                    throw new p56("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
                }
                throw new IllegalArgumentException("At least one TLS version is required".toString());
            }
            throw new IllegalArgumentException("no TLS versions for cleartext connections".toString());
        }

        public final a f(qi6... qi6Arr) {
            n86.f(qi6Arr, "tlsVersions");
            if (this.f2946a) {
                ArrayList arrayList = new ArrayList(qi6Arr.length);
                for (qi6 qi6 : qi6Arr) {
                    arrayList.add(qi6.javaName());
                }
                Object[] array = arrayList.toArray(new String[0]);
                if (array != null) {
                    String[] strArr = (String[]) array;
                    e((String[]) Arrays.copyOf(strArr, strArr.length));
                    return this;
                }
                throw new p56("null cannot be cast to non-null type kotlin.Array<T>");
            }
            throw new IllegalArgumentException("no TLS versions for cleartext connections".toString());
        }

        public a(qh6 qh6) {
            n86.f(qh6, "connectionSpec");
            this.f2946a = qh6.f2945a;
            this.b = qh6.c;
            this.c = qh6.d;
            this.d = qh6.b;
        }
    }

    static {
        nh6 nh6 = nh6.q;
        nh6 nh62 = nh6.r;
        nh6 nh63 = nh6.s;
        nh6 nh64 = nh6.k;
        nh6 nh65 = nh6.m;
        nh6 nh66 = nh6.l;
        nh6 nh67 = nh6.n;
        nh6 nh68 = nh6.p;
        nh6 nh69 = nh6.o;
        nh6[] nh6Arr = {nh6, nh62, nh63, nh64, nh65, nh66, nh67, nh68, nh69};
        e = nh6Arr;
        nh6[] nh6Arr2 = {nh6, nh62, nh63, nh64, nh65, nh66, nh67, nh68, nh69, nh6.i, nh6.j, nh6.g, nh6.h, nh6.e, nh6.f, nh6.d};
        f = nh6Arr2;
        a aVar = new a(true);
        aVar.c((nh6[]) Arrays.copyOf(nh6Arr, nh6Arr.length));
        qi6 qi6 = qi6.TLS_1_3;
        qi6 qi62 = qi6.TLS_1_2;
        aVar.f(qi6, qi62);
        aVar.d(true);
        aVar.a();
        a aVar2 = new a(true);
        aVar2.c((nh6[]) Arrays.copyOf(nh6Arr2, nh6Arr2.length));
        aVar2.f(qi6, qi62);
        aVar2.d(true);
        g = aVar2.a();
        a aVar3 = new a(true);
        aVar3.c((nh6[]) Arrays.copyOf(nh6Arr2, nh6Arr2.length));
        aVar3.f(qi6, qi62, qi6.TLS_1_1, qi6.TLS_1_0);
        aVar3.d(true);
        aVar3.a();
    }

    public qh6(boolean z, boolean z2, String[] strArr, String[] strArr2) {
        this.f2945a = z;
        this.b = z2;
        this.c = strArr;
        this.d = strArr2;
    }

    public final List<nh6> a() {
        String[] strArr = this.c;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(nh6.t.b(str));
        }
        return y56.y(arrayList);
    }

    public final boolean b(SSLSocket sSLSocket) {
        n86.f(sSLSocket, "socket");
        if (!this.f2945a) {
            return false;
        }
        String[] strArr = this.d;
        if (strArr != null && !vi6.j(strArr, sSLSocket.getEnabledProtocols(), f66.f)) {
            return false;
        }
        String[] strArr2 = this.c;
        if (strArr2 == null) {
            return true;
        }
        String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        nh6.b bVar = nh6.t;
        Comparator<String> comparator = nh6.b;
        if (!vi6.j(strArr2, enabledCipherSuites, nh6.b)) {
            return false;
        }
        return true;
    }

    public final List<qi6> c() {
        String[] strArr = this.d;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(qi6.Companion.a(str));
        }
        return y56.y(arrayList);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof qh6)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        boolean z = this.f2945a;
        qh6 qh6 = (qh6) obj;
        if (z != qh6.f2945a) {
            return false;
        }
        return !z || (Arrays.equals(this.c, qh6.c) && Arrays.equals(this.d, qh6.d) && this.b == qh6.b);
    }

    public int hashCode() {
        if (!this.f2945a) {
            return 17;
        }
        String[] strArr = this.c;
        int i = 0;
        int hashCode = (527 + (strArr != null ? Arrays.hashCode(strArr) : 0)) * 31;
        String[] strArr2 = this.d;
        if (strArr2 != null) {
            i = Arrays.hashCode(strArr2);
        }
        return ((hashCode + i) * 31) + (!this.b ? 1 : 0);
    }

    public String toString() {
        if (!this.f2945a) {
            return "ConnectionSpec()";
        }
        StringBuilder k0 = hj1.k0("ConnectionSpec(", "cipherSuites=");
        k0.append(Objects.toString(a(), "[all enabled]"));
        k0.append(", ");
        k0.append("tlsVersions=");
        k0.append(Objects.toString(c(), "[all enabled]"));
        k0.append(", ");
        k0.append("supportsTlsExtensions=");
        k0.append(this.b);
        k0.append(')');
        return k0.toString();
    }
}
