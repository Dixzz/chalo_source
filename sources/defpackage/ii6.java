package defpackage;

import java.io.IOException;

/* renamed from: ii6  reason: default package */
/* compiled from: Protocol.kt */
public enum ii6 {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2"),
    H2_PRIOR_KNOWLEDGE("h2_prior_knowledge"),
    QUIC("quic");
    
    public static final a Companion = new a(null);
    private final String protocol;

    /* renamed from: ii6$a */
    /* compiled from: Protocol.kt */
    public static final class a {
        public a(j86 j86) {
        }

        public final ii6 a(String str) throws IOException {
            n86.f(str, "protocol");
            ii6 ii6 = ii6.HTTP_1_0;
            if (!n86.a(str, ii6.protocol)) {
                ii6 = ii6.HTTP_1_1;
                if (!n86.a(str, ii6.protocol)) {
                    ii6 = ii6.H2_PRIOR_KNOWLEDGE;
                    if (!n86.a(str, ii6.protocol)) {
                        ii6 = ii6.HTTP_2;
                        if (!n86.a(str, ii6.protocol)) {
                            ii6 = ii6.SPDY_3;
                            if (!n86.a(str, ii6.protocol)) {
                                ii6 = ii6.QUIC;
                                if (!n86.a(str, ii6.protocol)) {
                                    throw new IOException(hj1.S("Unexpected protocol: ", str));
                                }
                            }
                        }
                    }
                }
            }
            return ii6;
        }
    }

    private ii6(String str) {
        this.protocol = str;
    }

    public static final ii6 get(String str) throws IOException {
        return Companion.a(str);
    }

    public String toString() {
        return this.protocol;
    }
}
