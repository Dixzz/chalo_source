package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import com.google.firebase.appindexing.Indexable;
import defpackage.ij6;
import defpackage.rc6;
import defpackage.zd6;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.logging.Logger;

/* renamed from: ec6  reason: default package */
/* compiled from: EventLoop.kt */
public final class ec6 {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    public static Context f957a;

    public static final void A(k66<? super s56> k66, k66<?> k662) {
        try {
            rf6.b(hd3.B1(k66), s56.f3190a, null, 2);
        } catch (Throwable th) {
            ((ka6) k662).resumeWith(hd3.Z(th));
        }
    }

    public static void B(w76 w76, Object obj, k66 k66, s76 s76, int i) {
        int i2 = i & 4;
        try {
            rf6.a(hd3.B1(hd3.Y(w76, obj, k66)), s56.f3190a, null);
        } catch (Throwable th) {
            k66.resumeWith(hd3.Z(th));
        }
    }

    public static final <T, R> Object C(bg6<? super T> bg6, R r, w76<? super R, ? super k66<? super T>, ? extends Object> w76) {
        Object obj;
        Object P;
        if (w76 != null) {
            try {
                b96.b(w76, 2);
                obj = w76.invoke(r, bg6);
            } catch (Throwable th) {
                obj = new eb6(th, false, 2);
            }
            p66 p66 = p66.COROUTINE_SUSPENDED;
            if (obj == p66 || (P = bg6.P(obj)) == xc6.b) {
                return p66;
            }
            if (!(P instanceof eb6)) {
                return xc6.a(P);
            }
            throw ((eb6) P).f955a;
        }
        throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
    }

    public static final long D(String str, long j, long j2, long j3) {
        Long l;
        int i;
        boolean z;
        boolean z2;
        String E = E(str);
        if (E == null) {
            return j;
        }
        n86.e(E, "$this$toLongOrNull");
        n86.e(E, "$this$toLongOrNull");
        hd3.F(10);
        int length = E.length();
        if (length != 0) {
            char charAt = E.charAt(0);
            long j4 = -9223372036854775807L;
            if (n86.g(charAt, 48) >= 0) {
                z = false;
                i = 0;
            } else if (length != 1) {
                if (charAt == '-') {
                    j4 = Long.MIN_VALUE;
                    z = true;
                } else if (charAt == '+') {
                    z = false;
                }
                i = 1;
            }
            long j5 = 0;
            long j6 = -256204778801521550L;
            while (true) {
                if (i < length) {
                    int digit = Character.digit((int) E.charAt(i), 10);
                    if (digit < 0) {
                        break;
                    }
                    if (j5 < j6) {
                        if (j6 != -256204778801521550L) {
                            break;
                        }
                        z2 = z;
                        j6 = j4 / ((long) 10);
                        if (j5 < j6) {
                            break;
                        }
                    } else {
                        z2 = z;
                    }
                    long j7 = j5 * ((long) 10);
                    long j8 = (long) digit;
                    if (j7 < j4 + j8) {
                        break;
                    }
                    j5 = j7 - j8;
                    i++;
                    z = z2;
                } else {
                    l = z ? Long.valueOf(j5) : Long.valueOf(-j5);
                }
            }
        }
        l = null;
        if (l != null) {
            long longValue = l.longValue();
            if (j2 <= longValue && longValue <= j3) {
                return longValue;
            }
            throw new IllegalStateException(("System property '" + str + "' should be in range " + j2 + ".." + j3 + ", but is '" + longValue + '\'').toString());
        }
        throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + E + '\'').toString());
    }

    public static final String E(String str) {
        int i = eg6.f971a;
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            return null;
        }
    }

    public static int F(String str, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 1;
        }
        if ((i4 & 8) != 0) {
            i3 = Integer.MAX_VALUE;
        }
        return (int) D(str, (long) i, (long) i2, (long) i3);
    }

    public static /* synthetic */ long G(String str, long j, long j2, long j3, int i, Object obj) {
        if ((i & 4) != 0) {
            j2 = 1;
        }
        if ((i & 8) != 0) {
            j3 = Long.MAX_VALUE;
        }
        return D(str, j, j2, j3);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0106, code lost:
        r1 = 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String H(java.lang.String r9) {
        /*
        // Method dump skipped, instructions count: 268
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ec6.H(java.lang.String):java.lang.String");
    }

    public static final String I(byte b) {
        char[] cArr = tn6.f3381a;
        return new String(new char[]{cArr[(b >> 4) & 15], cArr[b & 15]});
    }

    public static zd6 a(int i, yd6 yd6, s76 s76, int i2) {
        boolean z = false;
        if ((i2 & 1) != 0) {
            i = 0;
        }
        yd6 yd62 = (i2 & 2) != 0 ? yd6.SUSPEND : null;
        int i3 = i2 & 4;
        int i4 = 1;
        if (i == -2) {
            if (yd62 == yd6.SUSPEND) {
                Objects.requireNonNull(zd6.f4162a);
                i4 = zd6.a.b;
            }
            return new xd6(i4, yd62, null);
        } else if (i == -1) {
            if (yd62 == yd6.SUSPEND) {
                z = true;
            }
            if (z) {
                return new fe6(null);
            }
            throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
        } else if (i != 0) {
            if (i == Integer.MAX_VALUE) {
                return new ge6(null);
            }
            if (i == 1 && yd62 == yd6.DROP_OLDEST) {
                return new fe6(null);
            }
            return new xd6(i, yd62, null);
        } else if (yd62 == yd6.SUSPEND) {
            return new ke6(null);
        } else {
            return new xd6(1, yd62, null);
        }
    }

    public static cb6 b(rc6 rc6, int i) {
        int i2 = i & 1;
        return new kd6(null);
    }

    public static final void c(fj6 fj6, hj6 hj6, String str) {
        ij6.b bVar = ij6.j;
        Logger logger = ij6.i;
        StringBuilder sb = new StringBuilder();
        sb.append(hj6.f);
        sb.append(' ');
        String format = String.format("%-22s", Arrays.copyOf(new Object[]{str}, 1));
        n86.b(format, "java.lang.String.format(format, *args)");
        sb.append(format);
        sb.append(": ");
        sb.append(fj6.c);
        logger.fine(sb.toString());
    }

    public static final on6 d(File file) throws FileNotFoundException {
        n86.f(file, "$this$appendingSink");
        FileOutputStream fileOutputStream = new FileOutputStream(file, true);
        n86.f(fileOutputStream, "$this$sink");
        return new in6(fileOutputStream, new rn6());
    }

    public static final boolean e(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        n86.f(bArr, "a");
        n86.f(bArr2, "b");
        for (int i4 = 0; i4 < i3; i4++) {
            if (bArr[i4 + i] != bArr2[i4 + i2]) {
                return false;
            }
        }
        return true;
    }

    public static final xm6 f(on6 on6) {
        n86.f(on6, "$this$buffer");
        return new jn6(on6);
    }

    public static final ym6 g(qn6 qn6) {
        n86.f(qn6, "$this$buffer");
        return new kn6(qn6);
    }

    public static final <E> jg6 h(s76<? super E, s56> s76, E e, jg6 jg6) {
        try {
            s76.invoke(e);
        } catch (Throwable th) {
            if (jg6 == null || jg6.getCause() == th) {
                return new jg6(n86.j("Exception in undelivered element handler for ", e), th);
            }
            hd3.l(jg6, th);
        }
        return jg6;
    }

    public static void i(m66 m66, CancellationException cancellationException, int i, Object obj) {
        int i2 = i & 1;
        int i3 = rc6.e;
        rc6 rc6 = (rc6) m66.get(rc6.a.f);
        if (rc6 != null) {
            rc6.c(null);
        }
    }

    public static /* synthetic */ void j(rc6 rc6, CancellationException cancellationException, int i, Object obj) {
        int i2 = i & 1;
        rc6.c(null);
    }

    public static final void k(ie6<?> ie6, Throwable th) {
        CancellationException cancellationException = null;
        if (th != null) {
            if (th instanceof CancellationException) {
                cancellationException = (CancellationException) th;
            }
            if (cancellationException == null) {
                cancellationException = new CancellationException("Channel was consumed, consumer had failed");
                cancellationException.initCause(th);
            }
        }
        ie6.c(cancellationException);
    }

    public static final void l(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException("size=" + j + " offset=" + j2 + " byteCount=" + j3);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0082, code lost:
        if ((r14 - r9) != 0) goto L_0x0085;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.net.InetAddress m(java.lang.String r16, int r17, int r18) {
        /*
        // Method dump skipped, instructions count: 238
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ec6.m(java.lang.String, int, int):java.net.InetAddress");
    }

    public static final void n(m66 m66) {
        int i = rc6.e;
        rc6 rc6 = (rc6) m66.get(rc6.a.f);
        if (rc6 != null && !rc6.a()) {
            throw rc6.j();
        }
    }

    public static final String o(long j) {
        String str;
        if (j <= ((long) -999500000)) {
            str = ((j - ((long) 500000000)) / ((long) 1000000000)) + " s ";
        } else if (j <= ((long) -999500)) {
            str = ((j - ((long) 500000)) / ((long) 1000000)) + " ms";
        } else if (j <= 0) {
            str = ((j - ((long) 500)) / ((long) Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL)) + " µs";
        } else if (j < ((long) 999500)) {
            str = ((j + ((long) 500)) / ((long) Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL)) + " µs";
        } else if (j < ((long) 999500000)) {
            str = ((j + ((long) 500000)) / ((long) 1000000)) + " ms";
        } else {
            str = ((j + ((long) 500000000)) / ((long) 1000000000)) + " s ";
        }
        String format = String.format("%6s", Arrays.copyOf(new Object[]{str}, 1));
        n86.b(format, "java.lang.String.format(format, *args)");
        return format;
    }

    public static BufferedReader p(String str) throws FileNotFoundException {
        return new BufferedReader(new FileReader(str));
    }

    public static HashMap<String, Integer> q(String str) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        String[] split = str.split(",");
        for (int i = 0; i < split.length; i++) {
            hashMap.put(split[i], Integer.valueOf(i));
        }
        return hashMap;
    }

    public static /* synthetic */ yb6 r(rc6 rc6, boolean z, boolean z2, s76 s76, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        return rc6.i(z, z2, s76);
    }

    public static final boolean s(AssertionError assertionError) {
        n86.f(assertionError, "$this$isAndroidGetsocknameError");
        if (assertionError.getCause() == null) {
            return false;
        }
        String message = assertionError.getMessage();
        return message != null ? ea6.c(message, "getsockname failed", false, 2) : false;
    }

    public static boolean t(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static final Object u(Object obj, E e) {
        if (obj == null) {
            return e;
        }
        if (obj instanceof ArrayList) {
            ((ArrayList) obj).add(e);
            return obj;
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(obj);
        arrayList.add(e);
        return arrayList;
    }

    public static final int v(nn6 nn6, int i) {
        int i2;
        n86.f(nn6, "$this$segment");
        int[] iArr = nn6.l;
        int i3 = i + 1;
        int length = nn6.k.length;
        n86.f(iArr, "$this$binarySearch");
        int i4 = length - 1;
        int i5 = 0;
        while (true) {
            if (i5 <= i4) {
                i2 = (i5 + i4) >>> 1;
                int i6 = iArr[i2];
                if (i6 >= i3) {
                    if (i6 <= i3) {
                        break;
                    }
                    i4 = i2 - 1;
                } else {
                    i5 = i2 + 1;
                }
            } else {
                i2 = (-i5) - 1;
                break;
            }
        }
        return i2 >= 0 ? i2 : ~i2;
    }

    public static final on6 w(Socket socket) throws IOException {
        n86.f(socket, "$this$sink");
        pn6 pn6 = new pn6(socket);
        OutputStream outputStream = socket.getOutputStream();
        n86.b(outputStream, "getOutputStream()");
        in6 in6 = new in6(outputStream, pn6);
        n86.f(in6, "sink");
        return new sm6(pn6, in6);
    }

    public static on6 x(File file, boolean z, int i, Object obj) throws FileNotFoundException {
        if ((i & 1) != 0) {
            z = false;
        }
        n86.f(file, "$this$sink");
        FileOutputStream fileOutputStream = new FileOutputStream(file, z);
        n86.f(fileOutputStream, "$this$sink");
        return new in6(fileOutputStream, new rn6());
    }

    public static final qn6 y(InputStream inputStream) {
        n86.f(inputStream, "$this$source");
        return new gn6(inputStream, new rn6());
    }

    public static final qn6 z(Socket socket) throws IOException {
        n86.f(socket, "$this$source");
        pn6 pn6 = new pn6(socket);
        InputStream inputStream = socket.getInputStream();
        n86.b(inputStream, "getInputStream()");
        gn6 gn6 = new gn6(inputStream, pn6);
        n86.f(gn6, "source");
        return new tm6(pn6, gn6);
    }
}
