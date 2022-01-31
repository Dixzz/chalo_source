package defpackage;

import app.zophop.models.mTicketing.ProductDiscountsObject;
import com.google.firebase.analytics.FirebaseAnalytics;
import defpackage.hn6;
import defpackage.mi6;
import defpackage.zm6;
import j$.util.DesugarTimeZone;
import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/* renamed from: vi6  reason: default package */
/* compiled from: Util.kt */
public final class vi6 {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f3652a;
    public static final ci6 b = ci6.g.c(new String[0]);
    public static final oi6 c;
    public static final hn6 d;
    public static final TimeZone e;
    public static final ca6 f = new ca6("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
    public static final String g;

    static {
        int i;
        byte[] bArr = new byte[0];
        f3652a = bArr;
        c = oi6.Companion.d(bArr, null);
        mi6.a.d(mi6.Companion, bArr, null, 0, 0, 7);
        hn6.a aVar = hn6.h;
        zm6.a aVar2 = zm6.j;
        int i2 = 1;
        zm6[] zm6Arr = {aVar2.b("efbbbf"), aVar2.b("feff"), aVar2.b("fffe"), aVar2.b("0000ffff"), aVar2.b("ffff0000")};
        n86.f(zm6Arr, "byteStrings");
        n86.e(zm6Arr, "$this$toMutableList");
        n86.e(zm6Arr, "$this$asCollection");
        ArrayList arrayList = new ArrayList(new w56(zm6Arr, false));
        hd3.T2(arrayList);
        ArrayList arrayList2 = new ArrayList(5);
        for (int i3 = 0; i3 < 5; i3++) {
            zm6 zm6 = zm6Arr[i3];
            arrayList2.add(-1);
        }
        Object[] array = arrayList2.toArray(new Integer[0]);
        if (array != null) {
            Integer[] numArr = (Integer[]) array;
            Integer[] numArr2 = (Integer[]) Arrays.copyOf(numArr, numArr.length);
            n86.e(numArr2, "elements");
            ArrayList arrayList3 = numArr2.length == 0 ? new ArrayList() : new ArrayList(new w56(numArr2, true));
            int i4 = 0;
            int i5 = 0;
            while (i4 < 5) {
                zm6 zm62 = zm6Arr[i4];
                int i6 = i5 + 1;
                int size = arrayList.size();
                n86.e(arrayList, "$this$binarySearch");
                int size2 = arrayList.size();
                if (size < 0) {
                    throw new IllegalArgumentException("fromIndex (" + 0 + ") is greater than toIndex (" + size + ").");
                } else if (size <= size2) {
                    int i7 = size - 1;
                    int i8 = 0;
                    while (true) {
                        if (i8 > i7) {
                            i = -(i8 + 1);
                            break;
                        }
                        i = (i8 + i7) >>> i2;
                        int K = hd3.K((Comparable) arrayList.get(i), zm62);
                        if (K >= 0) {
                            if (K <= 0) {
                                break;
                            }
                            i7 = i - 1;
                        } else {
                            i8 = i + 1;
                        }
                        i2 = 1;
                    }
                    arrayList3.set(i, Integer.valueOf(i5));
                    i4++;
                    i5 = i6;
                    i2 = 1;
                } else {
                    throw new IndexOutOfBoundsException("toIndex (" + size + ") is greater than size (" + size2 + ").");
                }
            }
            if (((zm6) arrayList.get(0)).g() > 0) {
                int i9 = 0;
                while (i9 < arrayList.size()) {
                    zm6 zm63 = (zm6) arrayList.get(i9);
                    int i10 = i9 + 1;
                    int i11 = i10;
                    while (i11 < arrayList.size()) {
                        zm6 zm64 = (zm6) arrayList.get(i11);
                        Objects.requireNonNull(zm64);
                        n86.f(zm63, "prefix");
                        if (!zm64.k(0, zm63, 0, zm63.g())) {
                            continue;
                            break;
                        }
                        if (!(zm64.g() != zm63.g())) {
                            throw new IllegalArgumentException(("duplicate option: " + zm64).toString());
                        } else if (((Number) arrayList3.get(i11)).intValue() > ((Number) arrayList3.get(i9)).intValue()) {
                            arrayList.remove(i11);
                            arrayList3.remove(i11);
                        } else {
                            i11++;
                        }
                    }
                    i9 = i10;
                }
                vm6 vm6 = new vm6();
                aVar.a(0, vm6, 0, arrayList, 0, arrayList.size(), arrayList3);
                int[] iArr = new int[((int) aVar.b(vm6))];
                int i12 = 0;
                while (!vm6.R()) {
                    iArr[i12] = vm6.readInt();
                    i12++;
                }
                Object[] copyOf = Arrays.copyOf(zm6Arr, 5);
                n86.b(copyOf, "java.util.Arrays.copyOf(this, size)");
                d = new hn6((zm6[]) copyOf, iArr, null);
                TimeZone timeZone = DesugarTimeZone.getTimeZone("GMT");
                if (timeZone != null) {
                    e = timeZone;
                    String name = hi6.class.getName();
                    n86.b(name, "OkHttpClient::class.java.name");
                    String w = ea6.w(name, "okhttp3.");
                    n86.e(w, "$this$removeSuffix");
                    n86.e("Client", "suffix");
                    if (ea6.d(w, "Client", false, 2)) {
                        w = w.substring(0, w.length() - "Client".length());
                        n86.d(w, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    }
                    g = w;
                    return;
                }
                n86.k();
                throw null;
            }
            throw new IllegalArgumentException("the empty byte string is not a supported option".toString());
        }
        throw new p56("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public static final String A(String str, int i, int i2) {
        n86.f(str, "$this$trimSubstring");
        int n = n(str, i, i2);
        String substring = str.substring(n, o(str, n, i2));
        n86.b(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static final Throwable B(Exception exc, List<? extends Exception> list) {
        n86.f(exc, "$this$withSuppressed");
        n86.f(list, "suppressed");
        if (list.size() > 1) {
            System.out.println(list);
        }
        for (Exception exc2 : list) {
            exc.addSuppressed(exc2);
        }
        return exc;
    }

    public static final boolean a(di6 di6, di6 di62) {
        n86.f(di6, "$this$canReuseConnectionFor");
        n86.f(di62, "other");
        return n86.a(di6.e, di62.e) && di6.f == di62.f && n86.a(di6.b, di62.b);
    }

    public static final void b(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static final void c(Closeable closeable) {
        n86.f(closeable, "$this$closeQuietly");
        try {
            closeable.close();
        } catch (RuntimeException e2) {
            throw e2;
        } catch (Exception unused) {
        }
    }

    public static final void d(Socket socket) {
        n86.f(socket, "$this$closeQuietly");
        try {
            socket.close();
        } catch (AssertionError e2) {
            throw e2;
        } catch (RuntimeException e3) {
            throw e3;
        } catch (Exception unused) {
        }
    }

    public static final int e(String str, char c2, int i, int i2) {
        n86.f(str, "$this$delimiterOffset");
        while (i < i2) {
            if (str.charAt(i) == c2) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static final int f(String str, String str2, int i, int i2) {
        n86.f(str, "$this$delimiterOffset");
        n86.f(str2, "delimiters");
        while (i < i2) {
            if (ea6.b(str2, str.charAt(i), false, 2)) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static /* synthetic */ int g(String str, char c2, int i, int i2, int i3) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = str.length();
        }
        return e(str, c2, i, i2);
    }

    public static final boolean h(qn6 qn6, int i, TimeUnit timeUnit) {
        n86.f(qn6, "$this$discard");
        n86.f(timeUnit, "timeUnit");
        try {
            return u(qn6, i, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static final String i(String str, Object... objArr) {
        n86.f(str, "format");
        n86.f(objArr, "args");
        Locale locale = Locale.US;
        n86.b(locale, "Locale.US");
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
        String format = String.format(locale, str, Arrays.copyOf(copyOf, copyOf.length));
        n86.b(format, "java.lang.String.format(locale, format, *args)");
        return format;
    }

    public static final boolean j(String[] strArr, String[] strArr2, Comparator<? super String> comparator) {
        n86.f(strArr, "$this$hasIntersection");
        n86.f(comparator, "comparator");
        if (!(strArr.length == 0) && strArr2 != null) {
            if (!(strArr2.length == 0)) {
                for (String str : strArr) {
                    for (String str2 : strArr2) {
                        if (comparator.compare(str, str2) == 0) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static final long k(ni6 ni6) {
        n86.f(ni6, "$this$headersContentLength");
        String b2 = ni6.l.b("Content-Length");
        if (b2 != null) {
            n86.f(b2, "$this$toLongOrDefault");
            try {
                return Long.parseLong(b2);
            } catch (NumberFormatException unused) {
            }
        }
        return -1;
    }

    @SafeVarargs
    public static final <T> List<T> l(T... tArr) {
        n86.f(tArr, "elements");
        Object[] objArr = (Object[]) tArr.clone();
        List<T> unmodifiableList = Collections.unmodifiableList(Arrays.asList(Arrays.copyOf(objArr, objArr.length)));
        n86.b(unmodifiableList, "Collections.unmodifiable…sList(*elements.clone()))");
        return unmodifiableList;
    }

    public static final int m(String str) {
        n86.f(str, "$this$indexOfControlOrNonAscii");
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt <= 31 || charAt >= 127) {
                return i;
            }
        }
        return -1;
    }

    public static final int n(String str, int i, int i2) {
        n86.f(str, "$this$indexOfFirstNonAsciiWhitespace");
        while (i < i2) {
            char charAt = str.charAt(i);
            if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static final int o(String str, int i, int i2) {
        n86.f(str, "$this$indexOfLastNonAsciiWhitespace");
        int i3 = i2 - 1;
        if (i3 >= i) {
            while (true) {
                char charAt = str.charAt(i3);
                if (charAt == '\t' || charAt == '\n' || charAt == '\f' || charAt == '\r' || charAt == ' ') {
                    if (i3 == i) {
                        break;
                    }
                    i3--;
                } else {
                    return i3 + 1;
                }
            }
        }
        return i;
    }

    public static final String[] p(String[] strArr, String[] strArr2, Comparator<? super String> comparator) {
        n86.f(strArr, "$this$intersect");
        n86.f(strArr2, "other");
        n86.f(comparator, "comparator");
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = strArr2.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                } else if (comparator.compare(str, strArr2[i]) == 0) {
                    arrayList.add(str);
                    break;
                } else {
                    i++;
                }
            }
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new p56("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public static final int q(char c2) {
        if ('0' <= c2 && '9' >= c2) {
            return c2 - '0';
        }
        char c3 = 'a';
        if ('a' > c2 || 'f' < c2) {
            c3 = 'A';
            if ('A' > c2 || 'F' < c2) {
                return -1;
            }
        }
        return (c2 - c3) + 10;
    }

    public static final Charset r(ym6 ym6, Charset charset) throws IOException {
        Charset charset2;
        n86.f(ym6, "$this$readBomAsCharset");
        n86.f(charset, ProductDiscountsObject.KEY_PRODUCT_TYPE_DEFAULT);
        int k1 = ym6.k1(d);
        if (k1 == -1) {
            return charset;
        }
        if (k1 == 0) {
            Charset charset3 = StandardCharsets.UTF_8;
            n86.b(charset3, "UTF_8");
            return charset3;
        } else if (k1 == 1) {
            Charset charset4 = StandardCharsets.UTF_16BE;
            n86.b(charset4, "UTF_16BE");
            return charset4;
        } else if (k1 != 2) {
            if (k1 == 3) {
                aa6 aa6 = aa6.d;
                charset2 = aa6.c;
                if (charset2 == null) {
                    charset2 = Charset.forName("UTF-32BE");
                    n86.d(charset2, "Charset.forName(\"UTF-32BE\")");
                    aa6.c = charset2;
                }
            } else if (k1 == 4) {
                aa6 aa62 = aa6.d;
                charset2 = aa6.b;
                if (charset2 == null) {
                    charset2 = Charset.forName("UTF-32LE");
                    n86.d(charset2, "Charset.forName(\"UTF-32LE\")");
                    aa6.b = charset2;
                }
            } else {
                throw new AssertionError();
            }
            return charset2;
        } else {
            Charset charset5 = StandardCharsets.UTF_16LE;
            n86.b(charset5, "UTF_16LE");
            return charset5;
        }
    }

    public static final int s(ym6 ym6) throws IOException {
        n86.f(ym6, "$this$readMedium");
        return (ym6.readByte() & 255) | ((ym6.readByte() & 255) << 16) | ((ym6.readByte() & 255) << 8);
    }

    public static final int t(vm6 vm6, byte b2) {
        n86.f(vm6, "$this$skipAll");
        int i = 0;
        while (!vm6.R() && vm6.e(0) == b2) {
            i++;
            vm6.readByte();
        }
        return i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0053, code lost:
        if (r5 == Long.MAX_VALUE) goto L_0x0072;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0070, code lost:
        if (r5 != Long.MAX_VALUE) goto L_0x007a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0072, code lost:
        r11.timeout().a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007a, code lost:
        r11.timeout().d(r0 + r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0082, code lost:
        return r12;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean u(defpackage.qn6 r11, int r12, java.util.concurrent.TimeUnit r13) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 131
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vi6.u(qn6, int, java.util.concurrent.TimeUnit):boolean");
    }

    public static final ci6 v(List<mk6> list) {
        n86.f(list, "$this$toHeaders");
        ArrayList arrayList = new ArrayList(20);
        for (mk6 mk6 : list) {
            zm6 zm6 = mk6.b;
            zm6 zm62 = mk6.c;
            String p = zm6.p();
            String p2 = zm62.p();
            n86.f(p, "name");
            n86.f(p2, FirebaseAnalytics.Param.VALUE);
            arrayList.add(p);
            arrayList.add(ea6.K(p2).toString());
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return new ci6((String[]) array, null);
        }
        throw new p56("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public static final String w(int i) {
        String hexString = Integer.toHexString(i);
        n86.b(hexString, "Integer.toHexString(this)");
        return hexString;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String x(defpackage.di6 r4, boolean r5) {
        /*
        // Method dump skipped, instructions count: 112
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vi6.x(di6, boolean):java.lang.String");
    }

    public static final <T> List<T> y(List<? extends T> list) {
        n86.f(list, "$this$toImmutableList");
        List<T> unmodifiableList = Collections.unmodifiableList(y56.B(list));
        n86.b(unmodifiableList, "Collections.unmodifiableList(toMutableList())");
        return unmodifiableList;
    }

    public static final int z(String str, int i) {
        if (str != null) {
            try {
                long parseLong = Long.parseLong(str);
                if (parseLong > ((long) Integer.MAX_VALUE)) {
                    return Integer.MAX_VALUE;
                }
                if (parseLong < 0) {
                    return 0;
                }
                return (int) parseLong;
            } catch (NumberFormatException unused) {
            }
        }
        return i;
    }
}
