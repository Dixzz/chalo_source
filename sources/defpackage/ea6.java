package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ea6 */
public class ea6 extends da6 {

    /* renamed from: ea6$a */
    public static final class a extends o86 implements s76<String, String> {
        public static final a f = new a();

        public a() {
            super(1);
        }

        @Override // defpackage.s76
        public String invoke(String str) {
            String str2 = str;
            n86.e(str2, "line");
            return str2;
        }
    }

    /* renamed from: ea6$b */
    public static final class b extends o86 implements s76<String, String> {
        public final /* synthetic */ String f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(String str) {
            super(1);
            this.f = str;
        }

        @Override // defpackage.s76
        public String invoke(String str) {
            String str2 = str;
            n86.e(str2, "line");
            return hj1.a0(new StringBuilder(), this.f, str2);
        }
    }

    public static List A(CharSequence charSequence, char[] cArr, boolean z, int i, int i2) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        n86.e(charSequence, "$this$split");
        n86.e(cArr, "delimiters");
        if (cArr.length == 1) {
            return z(charSequence, String.valueOf(cArr[0]), z, i);
        }
        y(i);
        ba6 ba6 = new ba6(charSequence, 0, i, new fa6(cArr, z));
        n86.e(ba6, "$this$asIterable");
        y96 y96 = new y96(ba6);
        ArrayList arrayList = new ArrayList(hd3.I(y96, 10));
        Iterator it = y96.iterator();
        while (it.hasNext()) {
            arrayList.add(H(charSequence, (k96) it.next()));
        }
        return arrayList;
    }

    public static List B(CharSequence charSequence, String[] strArr, boolean z, int i, int i2) {
        boolean z2 = false;
        boolean z3 = (i2 & 2) != 0 ? false : z;
        int i3 = (i2 & 4) != 0 ? 0 : i;
        n86.e(charSequence, "$this$split");
        n86.e(strArr, "delimiters");
        if (strArr.length == 1) {
            String str = strArr[0];
            if (str.length() == 0) {
                z2 = true;
            }
            if (!z2) {
                return z(charSequence, str, z3, i3);
            }
        }
        w96 t = t(charSequence, strArr, 0, z3, i3, 2);
        n86.e(t, "$this$asIterable");
        y96 y96 = new y96(t);
        ArrayList arrayList = new ArrayList(hd3.I(y96, 10));
        Iterator it = y96.iterator();
        while (it.hasNext()) {
            arrayList.add(H(charSequence, (k96) it.next()));
        }
        return arrayList;
    }

    public static final boolean C(String str, String str2, int i, boolean z) {
        n86.e(str, "$this$startsWith");
        n86.e(str2, "prefix");
        if (!z) {
            return str.startsWith(str2, i);
        }
        return u(str, i, str2, 0, str2.length(), z);
    }

    public static final boolean D(String str, String str2, boolean z) {
        n86.e(str, "$this$startsWith");
        n86.e(str2, "prefix");
        if (!z) {
            return str.startsWith(str2);
        }
        return u(str, 0, str2, 0, str2.length(), z);
    }

    public static boolean E(CharSequence charSequence, CharSequence charSequence2, boolean z, int i) {
        boolean z2 = (i & 2) != 0 ? false : z;
        n86.e(charSequence, "$this$startsWith");
        n86.e(charSequence2, "prefix");
        if (z2 || !(charSequence2 instanceof String)) {
            return v(charSequence, 0, charSequence2, 0, charSequence2.length(), z2);
        }
        return G((String) charSequence, (String) charSequence2, false, 2);
    }

    public static /* synthetic */ boolean F(String str, String str2, int i, boolean z, int i2) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return C(str, str2, i, z);
    }

    public static /* synthetic */ boolean G(String str, String str2, boolean z, int i) {
        if ((i & 2) != 0) {
            z = false;
        }
        return D(str, str2, z);
    }

    public static final String H(CharSequence charSequence, k96 k96) {
        n86.e(charSequence, "$this$substring");
        n86.e(k96, "range");
        return charSequence.subSequence(Integer.valueOf(k96.f).intValue(), Integer.valueOf(k96.g).intValue() + 1).toString();
    }

    public static final String I(String str, char c, String str2) {
        n86.e(str, "$this$substringAfterLast");
        n86.e(str2, "missingDelimiterValue");
        int q = q(str, c, 0, false, 6);
        if (q == -1) {
            return str2;
        }
        String substring = str.substring(q + 1, str.length());
        n86.d(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0067  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Integer J(java.lang.String r11) {
        /*
        // Method dump skipped, instructions count: 110
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ea6.J(java.lang.String):java.lang.Integer");
    }

    public static final CharSequence K(CharSequence charSequence) {
        n86.e(charSequence, "$this$trim");
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean T1 = hd3.T1(charSequence.charAt(!z ? i : length));
            if (!z) {
                if (!T1) {
                    z = true;
                } else {
                    i++;
                }
            } else if (!T1) {
                break;
            } else {
                length--;
            }
        }
        return charSequence.subSequence(i, length + 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v10, types: [java.lang.String] */
    public static final String L(String str) {
        Comparable comparable;
        n86.e(str, "$this$trimIndent");
        n86.e(str, "$this$replaceIndent");
        n86.e("", "newIndent");
        List<String> s = s(str);
        ArrayList arrayList = new ArrayList();
        for (T t : s) {
            if (!p(t)) {
                arrayList.add(t);
            }
        }
        ArrayList arrayList2 = new ArrayList(hd3.I(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (true) {
            int i = 0;
            if (!it.hasNext()) {
                break;
            }
            String str2 = (String) it.next();
            int length = str2.length();
            while (true) {
                if (i >= length) {
                    i = -1;
                    break;
                } else if (!hd3.T1(str2.charAt(i))) {
                    break;
                } else {
                    i++;
                }
            }
            if (i == -1) {
                i = str2.length();
            }
            arrayList2.add(Integer.valueOf(i));
        }
        n86.e(arrayList2, "$this$minOrNull");
        Iterator it2 = arrayList2.iterator();
        if (!it2.hasNext()) {
            comparable = null;
        } else {
            comparable = (Comparable) it2.next();
            while (it2.hasNext()) {
                Comparable comparable2 = (Comparable) it2.next();
                if (comparable.compareTo(comparable2) > 0) {
                    comparable = comparable2;
                }
            }
        }
        Integer num = (Integer) comparable;
        int intValue = num != null ? num.intValue() : 0;
        int size = (s.size() * 0) + str.length();
        s76<String, String> h = h("");
        int j = y56.j(s);
        ArrayList arrayList3 = new ArrayList();
        int i2 = 0;
        for (T t2 : s) {
            int i3 = i2 + 1;
            if (i2 >= 0) {
                T t3 = t2;
                if ((i2 == 0 || i2 == j) && p(t3)) {
                    t3 = null;
                } else {
                    n86.e(t3, "$this$drop");
                    if (intValue >= 0) {
                        int length2 = t3.length();
                        if (intValue <= length2) {
                            length2 = intValue;
                        }
                        String substring = t3.substring(length2);
                        n86.d(substring, "(this as java.lang.String).substring(startIndex)");
                        String invoke = h.invoke(substring);
                        if (invoke != 0) {
                            t3 = invoke;
                        }
                    } else {
                        throw new IllegalArgumentException(hj1.J("Requested character count ", intValue, " is less than zero.").toString());
                    }
                }
                if (t3 != null) {
                    arrayList3.add(t3);
                }
                i2 = i3;
            } else {
                y56.w();
                throw null;
            }
        }
        StringBuilder sb = new StringBuilder(size);
        y56.l(arrayList3, sb, "\n", null, null, 0, null, null, 124);
        String sb2 = sb.toString();
        n86.d(sb2, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return sb2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.lang.String] */
    public static String M(String str, String str2, int i) {
        String str3;
        String invoke;
        String str4 = (i & 1) != 0 ? "|" : null;
        n86.e(str, "$this$trimMargin");
        n86.e(str4, "marginPrefix");
        n86.e(str, "$this$replaceIndentByMargin");
        n86.e("", "newIndent");
        n86.e(str4, "marginPrefix");
        if (!p(str4)) {
            List<String> s = s(str);
            int size = (s.size() * 0) + str.length();
            s76<String, String> h = h("");
            int j = y56.j(s);
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            for (T t : s) {
                int i3 = i2 + 1;
                if (i2 >= 0) {
                    T t2 = t;
                    if ((i2 == 0 || i2 == j) && p(t2)) {
                        t2 = null;
                    } else {
                        int length = t2.length();
                        int i4 = 0;
                        while (true) {
                            if (i4 >= length) {
                                i4 = -1;
                                break;
                            } else if (!hd3.T1(t2.charAt(i4))) {
                                break;
                            } else {
                                i4++;
                            }
                        }
                        if (i4 != -1 && F(t2, str4, i4, false, 4)) {
                            str3 = t2.substring(str4.length() + i4);
                            n86.d(str3, "(this as java.lang.String).substring(startIndex)");
                        } else {
                            str3 = null;
                        }
                        if (!(str3 == null || (invoke = h.invoke(str3)) == 0)) {
                            t2 = invoke;
                        }
                    }
                    if (t2 != null) {
                        arrayList.add(t2);
                    }
                    i2 = i3;
                } else {
                    y56.w();
                    throw null;
                }
            }
            StringBuilder sb = new StringBuilder(size);
            y56.l(arrayList, sb, "\n", null, null, 0, null, null, 124);
            String sb2 = sb.toString();
            n86.d(sb2, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
            return sb2;
        }
        throw new IllegalArgumentException("marginPrefix must be non-blank string.".toString());
    }

    public static final boolean a(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        n86.e(charSequence, "$this$contains");
        n86.e(charSequence2, "other");
        if (charSequence2 instanceof String) {
            if (n(charSequence, (String) charSequence2, 0, z, 2) >= 0) {
                return true;
            }
        } else if (l(charSequence, charSequence2, 0, charSequence.length(), z, false, 16) >= 0) {
            return true;
        }
        return false;
    }

    public static boolean b(CharSequence charSequence, char c, boolean z, int i) {
        if ((i & 2) != 0) {
            z = false;
        }
        n86.e(charSequence, "$this$contains");
        if (m(charSequence, c, 0, z, 2) >= 0) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean c(CharSequence charSequence, CharSequence charSequence2, boolean z, int i) {
        if ((i & 2) != 0) {
            z = false;
        }
        return a(charSequence, charSequence2, z);
    }

    public static boolean d(CharSequence charSequence, CharSequence charSequence2, boolean z, int i) {
        boolean z2 = (i & 2) != 0 ? false : z;
        n86.e(charSequence, "$this$endsWith");
        n86.e(charSequence2, "suffix");
        if (z2 || !(charSequence2 instanceof String)) {
            return v(charSequence, charSequence.length() - charSequence2.length(), charSequence2, 0, charSequence2.length(), z2);
        }
        return e((String) charSequence, (String) charSequence2, false, 2);
    }

    public static boolean e(String str, String str2, boolean z, int i) {
        if ((i & 2) != 0) {
            z = false;
        }
        n86.e(str, "$this$endsWith");
        n86.e(str2, "suffix");
        if (!z) {
            return str.endsWith(str2);
        }
        return u(str, str.length() - str2.length(), str2, 0, str2.length(), true);
    }

    public static final boolean f(String str, String str2, boolean z) {
        if (str == null) {
            return str2 == null;
        }
        if (!z) {
            return str.equals(str2);
        }
        return str.equalsIgnoreCase(str2);
    }

    public static /* synthetic */ boolean g(String str, String str2, boolean z, int i) {
        if ((i & 2) != 0) {
            z = false;
        }
        return f(str, str2, z);
    }

    public static final s76<String, String> h(String str) {
        if (str.length() == 0) {
            return a.f;
        }
        return new b(str);
    }

    public static final int i(CharSequence charSequence) {
        n86.e(charSequence, "$this$lastIndex");
        return charSequence.length() - 1;
    }

    public static final int j(CharSequence charSequence, String str, int i, boolean z) {
        n86.e(charSequence, "$this$indexOf");
        n86.e(str, "string");
        if (z || !(charSequence instanceof String)) {
            return l(charSequence, str, i, charSequence.length(), z, false, 16);
        }
        return ((String) charSequence).indexOf(str, i);
    }

    public static final int k(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2) {
        i96 i96;
        if (!z2) {
            if (i < 0) {
                i = 0;
            }
            int length = charSequence.length();
            if (i2 > length) {
                i2 = length;
            }
            i96 = new k96(i, i2);
        } else {
            int i3 = i(charSequence);
            if (i > i3) {
                i = i3;
            }
            if (i2 < 0) {
                i2 = 0;
            }
            i96 = l96.c(i, i2);
        }
        if (!(charSequence instanceof String) || !(charSequence2 instanceof String)) {
            int i4 = i96.f;
            int i5 = i96.g;
            int i6 = i96.h;
            if (i6 >= 0) {
                if (i4 > i5) {
                    return -1;
                }
            } else if (i4 < i5) {
                return -1;
            }
            while (!v(charSequence2, 0, charSequence, i4, charSequence2.length(), z)) {
                if (i4 == i5) {
                    return -1;
                }
                i4 += i6;
            }
            return i4;
        }
        int i7 = i96.f;
        int i8 = i96.g;
        int i9 = i96.h;
        if (i9 >= 0) {
            if (i7 > i8) {
                return -1;
            }
        } else if (i7 < i8) {
            return -1;
        }
        while (!u((String) charSequence2, 0, (String) charSequence, i7, charSequence2.length(), z)) {
            if (i7 == i8) {
                return -1;
            }
            i7 += i9;
        }
        return i7;
    }

    public static /* synthetic */ int l(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2, int i3) {
        return k(charSequence, charSequence2, i, i2, z, (i3 & 16) != 0 ? false : z2);
    }

    public static int m(CharSequence charSequence, char c, int i, boolean z, int i2) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        n86.e(charSequence, "$this$indexOf");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(c, i);
        }
        return o(charSequence, new char[]{c}, i, z);
    }

    public static /* synthetic */ int n(CharSequence charSequence, String str, int i, boolean z, int i2) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return j(charSequence, str, i, z);
    }

    public static final int o(CharSequence charSequence, char[] cArr, int i, boolean z) {
        boolean z2;
        n86.e(charSequence, "$this$indexOfAny");
        n86.e(cArr, "chars");
        if (z || cArr.length != 1 || !(charSequence instanceof String)) {
            if (i < 0) {
                i = 0;
            }
            int i2 = i(charSequence);
            if (i > i2) {
                return -1;
            }
            while (true) {
                char charAt = charSequence.charAt(i);
                int length = cArr.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        z2 = false;
                        break;
                    } else if (hd3.P0(cArr[i3], charAt, z)) {
                        z2 = true;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (z2) {
                    return i;
                }
                if (i == i2) {
                    return -1;
                }
                i++;
            }
        } else {
            return ((String) charSequence).indexOf(hd3.R2(cArr), i);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x004d A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean p(java.lang.CharSequence r4) {
        /*
            java.lang.String r0 = "$this$isBlank"
            defpackage.n86.e(r4, r0)
            int r0 = r4.length()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x004e
            java.lang.String r0 = "$this$indices"
            defpackage.n86.e(r4, r0)
            k96 r0 = new k96
            int r3 = r4.length()
            int r3 = r3 + -1
            r0.<init>(r2, r3)
            boolean r3 = r0 instanceof java.util.Collection
            if (r3 == 0) goto L_0x002b
            r3 = r0
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x002b
            goto L_0x0049
        L_0x002b:
            java.util.Iterator r0 = r0.iterator()
        L_0x002f:
            r3 = r0
            j96 r3 = (defpackage.j96) r3
            boolean r3 = r3.g
            if (r3 == 0) goto L_0x0049
            r3 = r0
            e66 r3 = (defpackage.e66) r3
            int r3 = r3.a()
            char r3 = r4.charAt(r3)
            boolean r3 = defpackage.hd3.T1(r3)
            if (r3 != 0) goto L_0x002f
            r4 = 0
            goto L_0x004a
        L_0x0049:
            r4 = 1
        L_0x004a:
            if (r4 == 0) goto L_0x004d
            goto L_0x004e
        L_0x004d:
            r1 = 0
        L_0x004e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ea6.p(java.lang.CharSequence):boolean");
    }

    public static int q(CharSequence charSequence, char c, int i, boolean z, int i2) {
        boolean z2;
        if ((i2 & 2) != 0) {
            i = i(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        n86.e(charSequence, "$this$lastIndexOf");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(c, i);
        }
        char[] cArr = {c};
        n86.e(charSequence, "$this$lastIndexOfAny");
        n86.e(cArr, "chars");
        if (z || !(charSequence instanceof String)) {
            int i3 = i(charSequence);
            if (i > i3) {
                i = i3;
            }
            while (i >= 0) {
                char charAt = charSequence.charAt(i);
                int i4 = 0;
                while (true) {
                    if (i4 >= 1) {
                        z2 = false;
                        break;
                    } else if (hd3.P0(cArr[i4], charAt, z)) {
                        z2 = true;
                        break;
                    } else {
                        i4++;
                    }
                }
                if (z2) {
                    return i;
                }
                i--;
            }
            return -1;
        }
        return ((String) charSequence).lastIndexOf(hd3.R2(cArr), i);
    }

    public static int r(CharSequence charSequence, String str, int i, boolean z, int i2) {
        if ((i2 & 2) != 0) {
            i = i(charSequence);
        }
        boolean z2 = (i2 & 4) != 0 ? false : z;
        n86.e(charSequence, "$this$lastIndexOf");
        n86.e(str, "string");
        if (z2 || !(charSequence instanceof String)) {
            return k(charSequence, str, i, 0, z2, true);
        }
        return ((String) charSequence).lastIndexOf(str, i);
    }

    public static final List<String> s(CharSequence charSequence) {
        n86.e(charSequence, "$this$lines");
        n86.e(charSequence, "$this$lineSequence");
        String[] strArr = {"\r\n", "\n", "\r"};
        n86.e(charSequence, "$this$splitToSequence");
        n86.e(strArr, "delimiters");
        w96 t = t(charSequence, strArr, 0, false, 0, 2);
        ha6 ha6 = new ha6(charSequence);
        n86.e(t, "$this$map");
        n86.e(ha6, "transform");
        return hd3.b3(new z96(t, ha6));
    }

    public static w96 t(CharSequence charSequence, String[] strArr, int i, boolean z, int i2, int i3) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        y(i2);
        return new ba6(charSequence, i, i2, new ga6(y56.a(strArr), z));
    }

    public static final boolean u(String str, int i, String str2, int i2, int i3, boolean z) {
        n86.e(str, "$this$regionMatches");
        n86.e(str2, "other");
        if (!z) {
            return str.regionMatches(i, str2, i2, i3);
        }
        return str.regionMatches(z, i, str2, i2, i3);
    }

    public static final boolean v(CharSequence charSequence, int i, CharSequence charSequence2, int i2, int i3, boolean z) {
        n86.e(charSequence, "$this$regionMatchesImpl");
        n86.e(charSequence2, "other");
        if (i2 < 0 || i < 0 || i > charSequence.length() - i3 || i2 > charSequence2.length() - i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!hd3.P0(charSequence.charAt(i + i4), charSequence2.charAt(i2 + i4), z)) {
                return false;
            }
        }
        return true;
    }

    public static final String w(String str, CharSequence charSequence) {
        n86.e(str, "$this$removePrefix");
        n86.e(charSequence, "prefix");
        if (!E(str, charSequence, false, 2)) {
            return str;
        }
        String substring = str.substring(charSequence.length());
        n86.d(substring, "(this as java.lang.String).substring(startIndex)");
        return substring;
    }

    public static String x(String str, String str2, String str3, boolean z, int i) {
        int i2 = 0;
        if ((i & 4) != 0) {
            z = false;
        }
        n86.e(str, "$this$replace");
        n86.e(str2, "oldValue");
        n86.e(str3, "newValue");
        int j = j(str, str2, 0, z);
        if (j < 0) {
            return str;
        }
        int length = str2.length();
        int i3 = 1;
        if (length >= 1) {
            i3 = length;
        }
        int length2 = str3.length() + (str.length() - length);
        if (length2 >= 0) {
            StringBuilder sb = new StringBuilder(length2);
            do {
                sb.append((CharSequence) str, i2, j);
                sb.append(str3);
                i2 = j + length;
                if (j >= str.length()) {
                    break;
                }
                j = j(str, str2, j + i3, z);
            } while (j > 0);
            sb.append((CharSequence) str, i2, str.length());
            String sb2 = sb.toString();
            n86.d(sb2, "stringBuilder.append(this, i, length).toString()");
            return sb2;
        }
        throw new OutOfMemoryError();
    }

    public static final void y(int i) {
        if (!(i >= 0)) {
            throw new IllegalArgumentException(hj1.I("Limit must be non-negative, but was ", i).toString());
        }
    }

    public static final List<String> z(CharSequence charSequence, String str, boolean z, int i) {
        y(i);
        int i2 = 0;
        int j = j(charSequence, str, 0, z);
        if (j != -1) {
            boolean z2 = true;
            if (i != 1) {
                if (i <= 0) {
                    z2 = false;
                }
                int i3 = 10;
                if (z2 && i <= 10) {
                    i3 = i;
                }
                ArrayList arrayList = new ArrayList(i3);
                do {
                    arrayList.add(charSequence.subSequence(i2, j).toString());
                    i2 = str.length() + j;
                    if (z2 && arrayList.size() == i - 1) {
                        break;
                    }
                    j = j(charSequence, str, i2, z);
                } while (j != -1);
                arrayList.add(charSequence.subSequence(i2, charSequence.length()).toString());
                return arrayList;
            }
        }
        return hd3.c2(charSequence.toString());
    }
}
