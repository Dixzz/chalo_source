package defpackage;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: fi6  reason: default package */
/* compiled from: MediaType.kt */
public final class fi6 {
    public static final Pattern d = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    public static final Pattern e = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
    public static final a f = null;

    /* renamed from: a  reason: collision with root package name */
    public final String f1129a;
    public final String b;
    public final String[] c;

    /* renamed from: fi6$a */
    /* compiled from: MediaType.kt */
    public static final class a {
        public static final fi6 a(String str) {
            n86.f(str, "$this$toMediaType");
            Matcher matcher = fi6.d.matcher(str);
            if (matcher.lookingAt()) {
                String group = matcher.group(1);
                n86.b(group, "typeSubtype.group(1)");
                Locale locale = Locale.US;
                n86.b(locale, "Locale.US");
                String lowerCase = group.toLowerCase(locale);
                n86.b(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                String group2 = matcher.group(2);
                n86.b(group2, "typeSubtype.group(2)");
                n86.b(locale, "Locale.US");
                String lowerCase2 = group2.toLowerCase(locale);
                n86.b(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
                ArrayList arrayList = new ArrayList();
                Matcher matcher2 = fi6.e.matcher(str);
                int end = matcher.end();
                while (end < str.length()) {
                    matcher2.region(end, str.length());
                    if (matcher2.lookingAt()) {
                        String group3 = matcher2.group(1);
                        if (group3 == null) {
                            end = matcher2.end();
                        } else {
                            String group4 = matcher2.group(2);
                            if (group4 == null) {
                                group4 = matcher2.group(3);
                            } else if (ea6.G(group4, "'", false, 2) && ea6.e(group4, "'", false, 2) && group4.length() > 2) {
                                group4 = group4.substring(1, group4.length() - 1);
                                n86.b(group4, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                            }
                            arrayList.add(group3);
                            arrayList.add(group4);
                            end = matcher2.end();
                        }
                    } else {
                        StringBuilder i0 = hj1.i0("Parameter is not formatted correctly: \"");
                        String substring = str.substring(end);
                        n86.b(substring, "(this as java.lang.String).substring(startIndex)");
                        i0.append(substring);
                        i0.append("\" for: \"");
                        i0.append(str);
                        i0.append('\"');
                        throw new IllegalArgumentException(i0.toString().toString());
                    }
                }
                Object[] array = arrayList.toArray(new String[0]);
                if (array != null) {
                    return new fi6(str, lowerCase, lowerCase2, (String[]) array, null);
                }
                throw new p56("null cannot be cast to non-null type kotlin.Array<T>");
            }
            throw new IllegalArgumentException(("No subtype found for: \"" + str + '\"').toString());
        }

        public static final fi6 b(String str) {
            n86.f(str, "$this$toMediaTypeOrNull");
            try {
                return a(str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
    }

    public fi6(String str, String str2, String str3, String[] strArr, j86 j86) {
        this.f1129a = str;
        this.b = str2;
        this.c = strArr;
    }

    public static final fi6 b(String str) {
        return a.a(str);
    }

    public final Charset a(Charset charset) {
        String str;
        n86.f("charset", "name");
        String[] strArr = this.c;
        n86.e(strArr, "$this$indices");
        n86.e(strArr, "$this$lastIndex");
        i96 d2 = l96.d(new k96(0, strArr.length - 1), 2);
        int i = d2.f;
        int i2 = d2.g;
        int i3 = d2.h;
        if (i3 < 0 ? i >= i2 : i <= i2) {
            while (true) {
                if (!ea6.f(this.c[i], "charset", true)) {
                    if (i == i2) {
                        break;
                    }
                    i += i3;
                } else {
                    str = this.c[i + 1];
                    break;
                }
            }
        }
        str = null;
        if (str == null) {
            return charset;
        }
        try {
            return Charset.forName(str);
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof fi6) && n86.a(((fi6) obj).f1129a, this.f1129a);
    }

    public int hashCode() {
        return this.f1129a.hashCode();
    }

    public String toString() {
        return this.f1129a;
    }
}
