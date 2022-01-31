package defpackage;

/* renamed from: qi6  reason: default package */
/* compiled from: TlsVersion.kt */
public enum qi6 {
    TLS_1_3("TLSv1.3"),
    TLS_1_2("TLSv1.2"),
    TLS_1_1("TLSv1.1"),
    TLS_1_0("TLSv1"),
    SSL_3_0("SSLv3");
    
    public static final a Companion = new a(null);
    private final String javaName;

    /* renamed from: qi6$a */
    /* compiled from: TlsVersion.kt */
    public static final class a {
        public a(j86 j86) {
        }

        public final qi6 a(String str) {
            n86.f(str, "javaName");
            int hashCode = str.hashCode();
            if (hashCode != 79201641) {
                if (hashCode != 79923350) {
                    switch (hashCode) {
                        case -503070503:
                            if (str.equals("TLSv1.1")) {
                                return qi6.TLS_1_1;
                            }
                            break;
                        case -503070502:
                            if (str.equals("TLSv1.2")) {
                                return qi6.TLS_1_2;
                            }
                            break;
                        case -503070501:
                            if (str.equals("TLSv1.3")) {
                                return qi6.TLS_1_3;
                            }
                            break;
                    }
                } else if (str.equals("TLSv1")) {
                    return qi6.TLS_1_0;
                }
            } else if (str.equals("SSLv3")) {
                return qi6.SSL_3_0;
            }
            throw new IllegalArgumentException(hj1.S("Unexpected TLS version: ", str));
        }
    }

    private qi6(String str) {
        this.javaName = str;
    }

    public static final qi6 forJavaName(String str) {
        return Companion.a(str);
    }

    /* renamed from: -deprecated_javaName  reason: not valid java name */
    public final String m30deprecated_javaName() {
        return this.javaName;
    }

    public final String javaName() {
        return this.javaName;
    }
}
