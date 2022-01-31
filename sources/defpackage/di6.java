package defpackage;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* renamed from: di6  reason: default package */
/* compiled from: HttpUrl.kt */
public final class di6 {
    public static final char[] k = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public static final b l = new b(null);

    /* renamed from: a  reason: collision with root package name */
    public final boolean f842a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final int f;
    public final List<String> g;
    public final List<String> h;
    public final String i;
    public final String j;

    /* renamed from: di6$a */
    /* compiled from: HttpUrl.kt */
    public static final class a {
        public static final C0018a i = new C0018a(null);

        /* renamed from: a  reason: collision with root package name */
        public String f843a;
        public String b = "";
        public String c = "";
        public String d;
        public int e = -1;
        public final List<String> f;
        public List<String> g;
        public String h;

        /* renamed from: di6$a$a  reason: collision with other inner class name */
        /* compiled from: HttpUrl.kt */
        public static final class C0018a {
            public C0018a(j86 j86) {
            }
        }

        public a() {
            ArrayList arrayList = new ArrayList();
            this.f = arrayList;
            arrayList.add("");
        }

        public final a a(String str, String str2) {
            n86.f(str, "encodedName");
            if (this.g == null) {
                this.g = new ArrayList();
            }
            List<String> list = this.g;
            String str3 = null;
            if (list != null) {
                b bVar = di6.l;
                list.add(b.a(bVar, str, 0, 0, " \"'<>#&=", true, false, true, false, null, 211));
                List<String> list2 = this.g;
                if (list2 != null) {
                    if (str2 != null) {
                        str3 = b.a(bVar, str2, 0, 0, " \"'<>#&=", true, false, true, false, null, 211);
                    }
                    list2.add(str3);
                    return this;
                }
                n86.k();
                throw null;
            }
            n86.k();
            throw null;
        }

        public final a b(String str, String str2) {
            n86.f(str, "name");
            if (this.g == null) {
                this.g = new ArrayList();
            }
            List<String> list = this.g;
            String str3 = null;
            if (list != null) {
                b bVar = di6.l;
                list.add(b.a(bVar, str, 0, 0, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, false, null, 219));
                List<String> list2 = this.g;
                if (list2 != null) {
                    if (str2 != null) {
                        str3 = b.a(bVar, str2, 0, 0, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, false, null, 219);
                    }
                    list2.add(str3);
                    return this;
                }
                n86.k();
                throw null;
            }
            n86.k();
            throw null;
        }

        public final di6 c() {
            ArrayList arrayList;
            ArrayList arrayList2;
            String str;
            b bVar = di6.l;
            String str2 = this.f843a;
            if (str2 != null) {
                String d2 = b.d(bVar, this.b, 0, 0, false, 7);
                String d3 = b.d(bVar, this.c, 0, 0, false, 7);
                String str3 = this.d;
                if (str3 != null) {
                    int d4 = d();
                    List<String> list = this.f;
                    ArrayList arrayList3 = new ArrayList(hd3.I(list, 10));
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList3.add(b.d(bVar, it.next(), 0, 0, false, 7));
                    }
                    List<String> list2 = this.g;
                    if (list2 != null) {
                        ArrayList arrayList4 = new ArrayList(hd3.I(list2, 10));
                        for (T t : list2) {
                            if (t != null) {
                                arrayList2 = arrayList4;
                                str = b.d(bVar, t, 0, 0, true, 3);
                            } else {
                                arrayList2 = arrayList4;
                                str = null;
                            }
                            arrayList2.add(str);
                            arrayList4 = arrayList2;
                        }
                        arrayList = arrayList4;
                    } else {
                        arrayList = null;
                    }
                    String str4 = this.h;
                    return new di6(str2, d2, d3, str3, d4, arrayList3, arrayList, str4 != null ? b.d(bVar, str4, 0, 0, false, 7) : null, toString());
                }
                throw new IllegalStateException("host == null");
            }
            throw new IllegalStateException("scheme == null");
        }

        public final int d() {
            int i2 = this.e;
            if (i2 != -1) {
                return i2;
            }
            String str = this.f843a;
            if (str != null) {
                n86.f(str, "scheme");
                int hashCode = str.hashCode();
                if (hashCode != 3213448) {
                    if (hashCode == 99617003 && str.equals("https")) {
                        return 443;
                    }
                } else if (str.equals("http")) {
                    return 80;
                }
                return -1;
            }
            n86.k();
            throw null;
        }

        public final a e(String str) {
            List<String> list;
            if (str != null) {
                b bVar = di6.l;
                list = bVar.e(b.a(bVar, str, 0, 0, " \"'<>#", true, false, true, false, null, 211));
            } else {
                list = null;
            }
            this.g = list;
            return this;
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:57)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:15)
            */
        /* JADX WARNING: Removed duplicated region for block: B:135:0x030a  */
        /* JADX WARNING: Removed duplicated region for block: B:220:0x03d4 A[SYNTHETIC] */
        public final defpackage.di6.a f(defpackage.di6 r27, java.lang.String r28) {
            /*
            // Method dump skipped, instructions count: 1112
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.di6.a.f(di6, java.lang.String):di6$a");
        }

        public final a g(String str) {
            n86.f(str, "password");
            this.c = b.a(di6.l, str, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251);
            return this;
        }

        public final a h(String str) {
            n86.f(str, "username");
            this.b = b.a(di6.l, str, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251);
            return this;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0033, code lost:
            if ((r10.c.length() > 0) != false) goto L_0x0035;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x00b7, code lost:
            if (r1 != r6) goto L_0x00be;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String toString() {
            /*
            // Method dump skipped, instructions count: 344
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.di6.a.toString():java.lang.String");
        }
    }

    /* renamed from: di6$b */
    /* compiled from: HttpUrl.kt */
    public static final class b {
        public b(j86 j86) {
        }

        public static String a(b bVar, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset, int i3) {
            int i4 = (i3 & 1) != 0 ? 0 : i;
            int length = (i3 & 2) != 0 ? str.length() : i2;
            boolean z5 = (i3 & 8) != 0 ? false : z;
            boolean z6 = (i3 & 16) != 0 ? false : z2;
            boolean z7 = (i3 & 32) != 0 ? false : z3;
            boolean z8 = (i3 & 64) != 0 ? false : z4;
            int i5 = 128;
            Charset charset2 = (i3 & 128) != 0 ? null : charset;
            n86.f(str, "$this$canonicalize");
            n86.f(str2, "encodeSet");
            int i6 = i4;
            while (i6 < length) {
                int codePointAt = str.codePointAt(i6);
                int i7 = 32;
                int i8 = 2;
                if (codePointAt < 32 || codePointAt == 127 || ((codePointAt >= i5 && !z8) || ea6.b(str2, (char) codePointAt, false, 2) || ((codePointAt == 37 && (!z5 || (z6 && !bVar.c(str, i6, length)))) || (codePointAt == 43 && z7)))) {
                    vm6 vm6 = new vm6();
                    vm6.T(str, i4, i6);
                    vm6 vm62 = null;
                    while (i6 < length) {
                        int codePointAt2 = str.codePointAt(i6);
                        if (!z5 || !(codePointAt2 == 9 || codePointAt2 == 10 || codePointAt2 == 12 || codePointAt2 == 13)) {
                            if (codePointAt2 != 43 || !z7) {
                                if (codePointAt2 >= i7 && codePointAt2 != 127 && (codePointAt2 < 128 || z8)) {
                                    if (!ea6.b(str2, (char) codePointAt2, false, i8) && (codePointAt2 != 37 || (z5 && (!z6 || bVar.c(str, i6, length))))) {
                                        vm6.V(codePointAt2);
                                        i6 += Character.charCount(codePointAt2);
                                        i8 = 2;
                                        i7 = 32;
                                    }
                                }
                                if (vm62 == null) {
                                    vm62 = new vm6();
                                }
                                if (charset2 == null || n86.a(charset2, StandardCharsets.UTF_8)) {
                                    vm62.V(codePointAt2);
                                } else {
                                    vm62.M(str, i6, Character.charCount(codePointAt2) + i6, charset2);
                                }
                                while (!vm62.R()) {
                                    int readByte = vm62.readByte() & 255;
                                    vm6.A(37);
                                    char[] cArr = di6.k;
                                    vm6.A(cArr[(readByte >> 4) & 15]);
                                    vm6.A(cArr[readByte & 15]);
                                }
                                i6 += Character.charCount(codePointAt2);
                                i8 = 2;
                                i7 = 32;
                            } else {
                                vm6.P(z5 ? "+" : "%2B");
                            }
                        }
                        i6 += Character.charCount(codePointAt2);
                        i8 = 2;
                        i7 = 32;
                    }
                    return vm6.o();
                }
                i6 += Character.charCount(codePointAt);
                i5 = 128;
            }
            String substring = str.substring(i4, length);
            n86.b(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }

        public static String d(b bVar, String str, int i, int i2, boolean z, int i3) {
            int i4;
            if ((i3 & 1) != 0) {
                i = 0;
            }
            if ((i3 & 2) != 0) {
                i2 = str.length();
            }
            if ((i3 & 4) != 0) {
                z = false;
            }
            n86.f(str, "$this$percentDecode");
            int i5 = i;
            while (i5 < i2) {
                char charAt = str.charAt(i5);
                if (charAt == '%' || (charAt == '+' && z)) {
                    vm6 vm6 = new vm6();
                    vm6.T(str, i, i5);
                    while (i5 < i2) {
                        int codePointAt = str.codePointAt(i5);
                        if (codePointAt == 37 && (i4 = i5 + 2) < i2) {
                            int q = vi6.q(str.charAt(i5 + 1));
                            int q2 = vi6.q(str.charAt(i4));
                            if (!(q == -1 || q2 == -1)) {
                                vm6.A((q << 4) + q2);
                                i5 = Character.charCount(codePointAt) + i4;
                            }
                        } else if (codePointAt == 43 && z) {
                            vm6.A(32);
                            i5++;
                        }
                        vm6.V(codePointAt);
                        i5 += Character.charCount(codePointAt);
                    }
                    return vm6.o();
                }
                i5++;
            }
            String substring = str.substring(i, i2);
            n86.b(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }

        public final int b(String str) {
            n86.f(str, "scheme");
            int hashCode = str.hashCode();
            if (hashCode != 3213448) {
                if (hashCode == 99617003 && str.equals("https")) {
                    return 443;
                }
            } else if (str.equals("http")) {
                return 80;
            }
            return -1;
        }

        public final boolean c(String str, int i, int i2) {
            int i3 = i + 2;
            if (i3 >= i2 || str.charAt(i) != '%' || vi6.q(str.charAt(i + 1)) == -1 || vi6.q(str.charAt(i3)) == -1) {
                return false;
            }
            return true;
        }

        public final List<String> e(String str) {
            n86.f(str, "$this$toQueryNamesAndValues");
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (i <= str.length()) {
                int m = ea6.m(str, '&', i, false, 4);
                if (m == -1) {
                    m = str.length();
                }
                int m2 = ea6.m(str, '=', i, false, 4);
                if (m2 == -1 || m2 > m) {
                    String substring = str.substring(i, m);
                    n86.b(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    arrayList.add(substring);
                    arrayList.add(null);
                } else {
                    String substring2 = str.substring(i, m2);
                    n86.b(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    arrayList.add(substring2);
                    String substring3 = str.substring(m2 + 1, m);
                    n86.b(substring3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    arrayList.add(substring3);
                }
                i = m + 1;
            }
            return arrayList;
        }
    }

    public di6(String str, String str2, String str3, String str4, int i2, List<String> list, List<String> list2, String str5, String str6) {
        n86.f(str, "scheme");
        n86.f(str2, "username");
        n86.f(str3, "password");
        n86.f(str4, "host");
        n86.f(list, "pathSegments");
        n86.f(str6, "url");
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = i2;
        this.g = list;
        this.h = list2;
        this.i = str5;
        this.j = str6;
        this.f842a = n86.a(str, "https");
    }

    public static final di6 h(String str) {
        n86.f(str, "$this$toHttpUrlOrNull");
        try {
            n86.f(str, "$this$toHttpUrl");
            a aVar = new a();
            aVar.f(null, str);
            return aVar.c();
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public final String a() {
        if (this.d.length() == 0) {
            return "";
        }
        int m = ea6.m(this.j, ':', this.b.length() + 3, false, 4) + 1;
        int m2 = ea6.m(this.j, '@', 0, false, 6);
        String str = this.j;
        if (str != null) {
            String substring = str.substring(m, m2);
            n86.b(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }
        throw new p56("null cannot be cast to non-null type java.lang.String");
    }

    public final String b() {
        int m = ea6.m(this.j, '/', this.b.length() + 3, false, 4);
        String str = this.j;
        int f2 = vi6.f(str, "?#", m, str.length());
        String str2 = this.j;
        if (str2 != null) {
            String substring = str2.substring(m, f2);
            n86.b(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }
        throw new p56("null cannot be cast to non-null type java.lang.String");
    }

    public final List<String> c() {
        int m = ea6.m(this.j, '/', this.b.length() + 3, false, 4);
        String str = this.j;
        int f2 = vi6.f(str, "?#", m, str.length());
        ArrayList arrayList = new ArrayList();
        while (m < f2) {
            int i2 = m + 1;
            int e2 = vi6.e(this.j, '/', i2, f2);
            String str2 = this.j;
            if (str2 != null) {
                String substring = str2.substring(i2, e2);
                n86.b(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                arrayList.add(substring);
                m = e2;
            } else {
                throw new p56("null cannot be cast to non-null type java.lang.String");
            }
        }
        return arrayList;
    }

    public final String d() {
        if (this.h == null) {
            return null;
        }
        int m = ea6.m(this.j, '?', 0, false, 6) + 1;
        String str = this.j;
        int e2 = vi6.e(str, '#', m, str.length());
        String str2 = this.j;
        if (str2 != null) {
            String substring = str2.substring(m, e2);
            n86.b(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }
        throw new p56("null cannot be cast to non-null type java.lang.String");
    }

    public final String e() {
        if (this.c.length() == 0) {
            return "";
        }
        int length = this.b.length() + 3;
        String str = this.j;
        int f2 = vi6.f(str, ":@", length, str.length());
        String str2 = this.j;
        if (str2 != null) {
            String substring = str2.substring(length, f2);
            n86.b(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }
        throw new p56("null cannot be cast to non-null type java.lang.String");
    }

    public boolean equals(Object obj) {
        return (obj instanceof di6) && n86.a(((di6) obj).j, this.j);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0072  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final defpackage.di6.a f() {
        /*
        // Method dump skipped, instructions count: 150
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.di6.f():di6$a");
    }

    public final a g(String str) {
        n86.f(str, "link");
        try {
            a aVar = new a();
            aVar.f(this, str);
            return aVar;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public int hashCode() {
        return this.j.hashCode();
    }

    public final String i() {
        a g2 = g("/...");
        if (g2 != null) {
            g2.h("");
            g2.g("");
            return g2.c().j;
        }
        n86.k();
        throw null;
    }

    public final URI j() {
        String str;
        String str2;
        int i2;
        List<String> list;
        int i3;
        String str3;
        a f2 = f();
        b bVar = l;
        String str4 = f2.d;
        String str5 = "nativePattern.matcher(in…).replaceAll(replacement)";
        String str6 = "";
        String str7 = "nativePattern";
        String str8 = "Pattern.compile(pattern)";
        String str9 = "pattern";
        String str10 = null;
        if (str4 != null) {
            n86.e("[\"<>^`{|}]", str9);
            Pattern compile = Pattern.compile("[\"<>^`{|}]");
            n86.d(compile, str8);
            n86.e(compile, str7);
            n86.e(str4, "input");
            n86.e(str6, "replacement");
            str = compile.matcher(str4).replaceAll(str6);
            n86.d(str, str5);
        } else {
            str = null;
        }
        f2.d = str;
        int size = f2.f.size();
        int i4 = 0;
        while (i4 < size) {
            List<String> list2 = f2.f;
            list2.set(i4, b.a(bVar, list2.get(i4), 0, 0, "[]", true, true, false, false, null, 227));
            i4++;
            str6 = str6;
            size = size;
            str5 = str5;
            str9 = str9;
            str8 = str8;
            str7 = str7;
        }
        String str11 = str6;
        List<String> list3 = f2.g;
        if (list3 != null) {
            int size2 = list3.size();
            int i5 = 0;
            while (i5 < size2) {
                String str12 = list3.get(i5);
                if (str12 != null) {
                    i2 = size2;
                    str2 = str11;
                    list = list3;
                    str3 = b.a(bVar, str12, 0, 0, "\\^`{|}", true, true, true, false, null, 195);
                    i3 = i5;
                } else {
                    i2 = size2;
                    str2 = str11;
                    list = list3;
                    i3 = i5;
                    str3 = null;
                }
                list.set(i3, str3);
                i5 = i3 + 1;
                list3 = list;
                size2 = i2;
                str11 = str2;
            }
        }
        String str13 = f2.h;
        if (str13 != null) {
            str10 = b.a(bVar, str13, 0, 0, " \"#<>\\^`{|}", true, true, false, true, null, 163);
        }
        f2.h = str10;
        String aVar = f2.toString();
        try {
            return new URI(aVar);
        } catch (URISyntaxException e2) {
            try {
                n86.e("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", str9);
                Pattern compile2 = Pattern.compile("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]");
                n86.d(compile2, str8);
                n86.e(compile2, str7);
                n86.e(aVar, "input");
                n86.e(str11, "replacement");
                String replaceAll = compile2.matcher(aVar).replaceAll(str11);
                n86.d(replaceAll, str5);
                URI create = URI.create(replaceAll);
                n86.b(create, "URI.create(stripped)");
                return create;
            } catch (Exception unused) {
                throw new RuntimeException(e2);
            }
        }
    }

    public final URL k() {
        try {
            return new URL(this.j);
        } catch (MalformedURLException e2) {
            throw new RuntimeException(e2);
        }
    }

    public String toString() {
        return this.j;
    }
}
