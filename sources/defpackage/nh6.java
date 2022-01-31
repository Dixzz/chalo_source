package defpackage;

import com.google.firebase.perf.util.Constants;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: nh6  reason: default package */
/* compiled from: CipherSuite.kt */
public final class nh6 {
    public static final Comparator<String> b = new a();
    public static final Map<String, nh6> c = new LinkedHashMap();
    public static final nh6 d;
    public static final nh6 e;
    public static final nh6 f;
    public static final nh6 g;
    public static final nh6 h;
    public static final nh6 i;
    public static final nh6 j;
    public static final nh6 k;
    public static final nh6 l;
    public static final nh6 m;
    public static final nh6 n;
    public static final nh6 o;
    public static final nh6 p;
    public static final nh6 q;
    public static final nh6 r;
    public static final nh6 s;
    public static final b t;

    /* renamed from: a  reason: collision with root package name */
    public final String f2554a;

    /* renamed from: nh6$a */
    /* compiled from: CipherSuite.kt */
    public static final class a implements Comparator<String>, j$.util.Comparator {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // j$.util.Comparator, java.util.Comparator
        public int compare(String str, String str2) {
            String str3 = str;
            String str4 = str2;
            n86.f(str3, "a");
            n86.f(str4, "b");
            int min = Math.min(str3.length(), str4.length());
            int i = 4;
            while (true) {
                if (i < min) {
                    char charAt = str3.charAt(i);
                    char charAt2 = str4.charAt(i);
                    if (charAt == charAt2) {
                        i++;
                    } else if (charAt < charAt2) {
                        return -1;
                    }
                } else {
                    int length = str3.length();
                    int length2 = str4.length();
                    if (length == length2) {
                        return 0;
                    }
                    if (length < length2) {
                        return -1;
                    }
                }
            }
            return 1;
        }

        /* Return type fixed from 'java.util.Comparator' to match base method */
        @Override // j$.util.Comparator, java.util.Comparator
        public /* synthetic */ Comparator<String> reversed() {
            return Comparator.CC.$default$reversed(this);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function) {
            return Comparator.CC.$default$thenComparing(this, function);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, function, comparator);
        }

        /* Return type fixed from 'java.util.Comparator' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.Comparator] */
        @Override // j$.util.Comparator, java.util.Comparator
        public /* synthetic */ java.util.Comparator<String> thenComparing(java.util.Comparator<? super String> comparator) {
            return Comparator.CC.$default$thenComparing(this, comparator);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
            return Comparator.CC.$default$thenComparingDouble(this, toDoubleFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
            return Comparator.CC.$default$thenComparingInt(this, toIntFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
            return Comparator.CC.$default$thenComparingLong(this, toLongFunction);
        }
    }

    /* renamed from: nh6$b */
    /* compiled from: CipherSuite.kt */
    public static final class b {
        public b(j86 j86) {
        }

        public static final nh6 a(b bVar, String str, int i) {
            nh6 nh6 = new nh6(str, null);
            nh6.c.put(str, nh6);
            return nh6;
        }

        public final synchronized nh6 b(String str) {
            nh6 nh6;
            n86.f(str, "javaName");
            Map<String, nh6> map = nh6.c;
            nh6 = map.get(str);
            if (nh6 == null) {
                nh6 = map.get(c(str));
                if (nh6 == null) {
                    nh6 = new nh6(str, null);
                }
                map.put(str, nh6);
            }
            return nh6;
        }

        public final String c(String str) {
            if (ea6.G(str, "TLS_", false, 2)) {
                StringBuilder i0 = hj1.i0("SSL_");
                String substring = str.substring(4);
                n86.b(substring, "(this as java.lang.String).substring(startIndex)");
                i0.append(substring);
                return i0.toString();
            } else if (!ea6.G(str, "SSL_", false, 2)) {
                return str;
            } else {
                StringBuilder i02 = hj1.i0("TLS_");
                String substring2 = str.substring(4);
                n86.b(substring2, "(this as java.lang.String).substring(startIndex)");
                i02.append(substring2);
                return i02.toString();
            }
        }
    }

    static {
        b bVar = new b(null);
        t = bVar;
        b.a(bVar, "SSL_RSA_WITH_NULL_MD5", 1);
        b.a(bVar, "SSL_RSA_WITH_NULL_SHA", 2);
        b.a(bVar, "SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);
        b.a(bVar, "SSL_RSA_WITH_RC4_128_MD5", 4);
        b.a(bVar, "SSL_RSA_WITH_RC4_128_SHA", 5);
        b.a(bVar, "SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);
        b.a(bVar, "SSL_RSA_WITH_DES_CBC_SHA", 9);
        d = b.a(bVar, "SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);
        b.a(bVar, "SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);
        b.a(bVar, "SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);
        b.a(bVar, "SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);
        b.a(bVar, "SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);
        b.a(bVar, "SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);
        b.a(bVar, "SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);
        b.a(bVar, "SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);
        b.a(bVar, "SSL_DH_anon_WITH_RC4_128_MD5", 24);
        b.a(bVar, "SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);
        b.a(bVar, "SSL_DH_anon_WITH_DES_CBC_SHA", 26);
        b.a(bVar, "SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);
        b.a(bVar, "TLS_KRB5_WITH_DES_CBC_SHA", 30);
        b.a(bVar, "TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);
        b.a(bVar, "TLS_KRB5_WITH_RC4_128_SHA", 32);
        b.a(bVar, "TLS_KRB5_WITH_DES_CBC_MD5", 34);
        b.a(bVar, "TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);
        b.a(bVar, "TLS_KRB5_WITH_RC4_128_MD5", 36);
        b.a(bVar, "TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);
        b.a(bVar, "TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);
        b.a(bVar, "TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);
        b.a(bVar, "TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);
        e = b.a(bVar, "TLS_RSA_WITH_AES_128_CBC_SHA", 47);
        b.a(bVar, "TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);
        b.a(bVar, "TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);
        b.a(bVar, "TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);
        f = b.a(bVar, "TLS_RSA_WITH_AES_256_CBC_SHA", 53);
        b.a(bVar, "TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);
        b.a(bVar, "TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);
        b.a(bVar, "TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);
        b.a(bVar, "TLS_RSA_WITH_NULL_SHA256", 59);
        b.a(bVar, "TLS_RSA_WITH_AES_128_CBC_SHA256", 60);
        b.a(bVar, "TLS_RSA_WITH_AES_256_CBC_SHA256", 61);
        b.a(bVar, "TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);
        b.a(bVar, "TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);
        b.a(bVar, "TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);
        b.a(bVar, "TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);
        b.a(bVar, "TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);
        b.a(bVar, "TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);
        b.a(bVar, "TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);
        b.a(bVar, "TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);
        b.a(bVar, "TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);
        b.a(bVar, "TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", 132);
        b.a(bVar, "TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", 135);
        b.a(bVar, "TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", 136);
        b.a(bVar, "TLS_PSK_WITH_RC4_128_SHA", 138);
        b.a(bVar, "TLS_PSK_WITH_3DES_EDE_CBC_SHA", 139);
        b.a(bVar, "TLS_PSK_WITH_AES_128_CBC_SHA", 140);
        b.a(bVar, "TLS_PSK_WITH_AES_256_CBC_SHA", 141);
        b.a(bVar, "TLS_RSA_WITH_SEED_CBC_SHA", 150);
        g = b.a(bVar, "TLS_RSA_WITH_AES_128_GCM_SHA256", 156);
        h = b.a(bVar, "TLS_RSA_WITH_AES_256_GCM_SHA384", 157);
        b.a(bVar, "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", 158);
        b.a(bVar, "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", 159);
        b.a(bVar, "TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", 162);
        b.a(bVar, "TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", 163);
        b.a(bVar, "TLS_DH_anon_WITH_AES_128_GCM_SHA256", 166);
        b.a(bVar, "TLS_DH_anon_WITH_AES_256_GCM_SHA384", 167);
        b.a(bVar, "TLS_EMPTY_RENEGOTIATION_INFO_SCSV", Constants.MAX_HOST_LENGTH);
        b.a(bVar, "TLS_FALLBACK_SCSV", 22016);
        b.a(bVar, "TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);
        b.a(bVar, "TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154);
        b.a(bVar, "TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);
        b.a(bVar, "TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);
        b.a(bVar, "TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157);
        b.a(bVar, "TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);
        b.a(bVar, "TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);
        b.a(bVar, "TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);
        b.a(bVar, "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);
        b.a(bVar, "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);
        b.a(bVar, "TLS_ECDH_RSA_WITH_NULL_SHA", 49163);
        b.a(bVar, "TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);
        b.a(bVar, "TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);
        b.a(bVar, "TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);
        b.a(bVar, "TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);
        b.a(bVar, "TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);
        b.a(bVar, "TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);
        b.a(bVar, "TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);
        i = b.a(bVar, "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);
        j = b.a(bVar, "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);
        b.a(bVar, "TLS_ECDH_anon_WITH_NULL_SHA", 49173);
        b.a(bVar, "TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);
        b.a(bVar, "TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);
        b.a(bVar, "TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176);
        b.a(bVar, "TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177);
        b.a(bVar, "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);
        b.a(bVar, "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);
        b.a(bVar, "TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);
        b.a(bVar, "TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);
        b.a(bVar, "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);
        b.a(bVar, "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);
        b.a(bVar, "TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);
        b.a(bVar, "TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);
        k = b.a(bVar, "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);
        l = b.a(bVar, "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);
        b.a(bVar, "TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);
        b.a(bVar, "TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);
        m = b.a(bVar, "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);
        n = b.a(bVar, "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);
        b.a(bVar, "TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);
        b.a(bVar, "TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);
        b.a(bVar, "TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);
        b.a(bVar, "TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);
        o = b.a(bVar, "TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);
        p = b.a(bVar, "TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);
        b.a(bVar, "TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52394);
        b.a(bVar, "TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256", 52396);
        q = b.a(bVar, "TLS_AES_128_GCM_SHA256", 4865);
        r = b.a(bVar, "TLS_AES_256_GCM_SHA384", 4866);
        s = b.a(bVar, "TLS_CHACHA20_POLY1305_SHA256", 4867);
        b.a(bVar, "TLS_AES_128_CCM_SHA256", 4868);
        b.a(bVar, "TLS_AES_128_CCM_8_SHA256", 4869);
    }

    public nh6(String str, j86 j86) {
        this.f2554a = str;
    }

    public String toString() {
        return this.f2554a;
    }
}
