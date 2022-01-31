package defpackage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: n93  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public abstract class n93 extends y83 {
    public static final Logger b = Logger.getLogger(n93.class.getName());
    public static final boolean c = ln2.g;

    /* renamed from: a  reason: collision with root package name */
    public o93 f2524a;

    public n93() {
    }

    public /* synthetic */ n93(j93 j93) {
    }

    public static int B(int i) {
        return b(i << 3);
    }

    public static int C(int i) {
        if (i >= 0) {
            return b(i);
        }
        return 10;
    }

    public static int b(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        return (i & -268435456) == 0 ? 4 : 5;
    }

    public static int c(long j) {
        int i;
        if ((-128 & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if ((-34359738368L & j) != 0) {
            j >>>= 28;
            i = 6;
        } else {
            i = 2;
        }
        if ((-2097152 & j) != 0) {
            i += 2;
            j >>>= 14;
        }
        return (j & -16384) != 0 ? i + 1 : i;
    }

    public static int d(String str) {
        int i;
        try {
            i = qn2.b(str);
        } catch (on2 unused) {
            i = str.getBytes(ka3.f2038a).length;
        }
        return b(i) + i;
    }

    public static int e(g93 g93) {
        int e = g93.e();
        return b(e) + e;
    }

    public static int f(bm2 bm2, mm2 mm2) {
        s83 s83 = (s83) bm2;
        int b2 = s83.b();
        if (b2 == -1) {
            b2 = mm2.f(s83);
            s83.c(b2);
        }
        return b(b2) + b2;
    }

    public static int g(int i) {
        return (i >> 31) ^ (i + i);
    }

    public static long h(long j) {
        return (j >> 63) ^ (j + j);
    }

    @Deprecated
    public static int j(int i, bm2 bm2, mm2 mm2) {
        int b2 = b(i << 3);
        int i2 = b2 + b2;
        s83 s83 = (s83) bm2;
        int b3 = s83.b();
        if (b3 == -1) {
            b3 = mm2.f(s83);
            s83.c(b3);
        }
        return i2 + b3;
    }

    public abstract void A(long j) throws IOException;

    public final void i(String str, on2 on2) throws IOException {
        b.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) on2);
        byte[] bytes = str.getBytes(ka3.f2038a);
        try {
            int length = bytes.length;
            x(length);
            a(bytes, 0, length);
        } catch (IndexOutOfBoundsException e) {
            throw new l93(e);
        } catch (l93 e2) {
            throw e2;
        }
    }

    public abstract void k(int i, int i2) throws IOException;

    public abstract void l(int i, int i2) throws IOException;

    public abstract void m(int i, int i2) throws IOException;

    public abstract void n(int i, int i2) throws IOException;

    public abstract void o(int i, long j) throws IOException;

    public abstract int p();

    public abstract void q(int i, long j) throws IOException;

    public abstract void r(int i, boolean z) throws IOException;

    public abstract void s(int i, String str) throws IOException;

    public abstract void t(int i, g93 g93) throws IOException;

    public abstract void u(int i, bm2 bm2, mm2 mm2) throws IOException;

    public abstract void v(byte b2) throws IOException;

    public abstract void w(int i) throws IOException;

    public abstract void x(int i) throws IOException;

    public abstract void y(int i) throws IOException;

    public abstract void z(long j) throws IOException;
}
