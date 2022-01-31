package defpackage;

import com.google.firebase.perf.util.Constants;
import defpackage.ak6;
import java.text.DateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* renamed from: rh6  reason: default package */
/* compiled from: Cookie.kt */
public final class rh6 {
    public static final Pattern j = Pattern.compile("(\\d{2,4})[^\\d]*");
    public static final Pattern k = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    public static final Pattern l = Pattern.compile("(\\d{1,2})[^\\d]*");
    public static final Pattern m = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
    public static final rh6 n = null;

    /* renamed from: a  reason: collision with root package name */
    public final String f3082a;
    public final String b;
    public final long c;
    public final String d;
    public final String e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;

    public rh6(String str, String str2, long j2, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4, j86 j86) {
        this.f3082a = str;
        this.b = str2;
        this.c = j2;
        this.d = str3;
        this.e = str4;
        this.f = z;
        this.g = z2;
        this.h = z3;
        this.i = z4;
    }

    public static final int a(String str, int i2, int i3, boolean z) {
        while (i2 < i3) {
            char charAt = str.charAt(i2);
            if (((charAt < ' ' && charAt != '\t') || charAt >= 127 || ('0' <= charAt && '9' >= charAt) || (('a' <= charAt && 'z' >= charAt) || (('A' <= charAt && 'Z' >= charAt) || charAt == ':'))) == (!z)) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static final long b(String str, int i2, int i3) {
        int a2 = a(str, i2, i3, false);
        Matcher matcher = m.matcher(str);
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        int i7 = -1;
        int i8 = -1;
        int i9 = -1;
        while (a2 < i3) {
            int a3 = a(str, a2 + 1, i3, true);
            matcher.region(a2, a3);
            if (i5 == -1 && matcher.usePattern(m).matches()) {
                String group = matcher.group(1);
                n86.b(group, "matcher.group(1)");
                int parseInt = Integer.parseInt(group);
                String group2 = matcher.group(2);
                n86.b(group2, "matcher.group(2)");
                int parseInt2 = Integer.parseInt(group2);
                String group3 = matcher.group(3);
                n86.b(group3, "matcher.group(3)");
                i9 = Integer.parseInt(group3);
                i8 = parseInt2;
                i5 = parseInt;
            } else if (i6 != -1 || !matcher.usePattern(l).matches()) {
                if (i7 == -1) {
                    Pattern pattern = k;
                    if (matcher.usePattern(pattern).matches()) {
                        String group4 = matcher.group(1);
                        n86.b(group4, "matcher.group(1)");
                        Locale locale = Locale.US;
                        n86.b(locale, "Locale.US");
                        String lowerCase = group4.toLowerCase(locale);
                        n86.b(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                        String pattern2 = pattern.pattern();
                        n86.b(pattern2, "MONTH_PATTERN.pattern()");
                        i7 = ea6.n(pattern2, lowerCase, 0, false, 6) / 4;
                    }
                }
                if (i4 == -1 && matcher.usePattern(j).matches()) {
                    String group5 = matcher.group(1);
                    n86.b(group5, "matcher.group(1)");
                    i4 = Integer.parseInt(group5);
                }
            } else {
                String group6 = matcher.group(1);
                n86.b(group6, "matcher.group(1)");
                i6 = Integer.parseInt(group6);
            }
            a2 = a(str, a3 + 1, i3, false);
        }
        if (70 <= i4 && 99 >= i4) {
            i4 += 1900;
        }
        if (i4 >= 0 && 69 >= i4) {
            i4 += Constants.MAX_URL_LENGTH;
        }
        if (i4 >= 1601) {
            if (i7 != -1) {
                if (1 <= i6 && 31 >= i6) {
                    if (i5 >= 0 && 23 >= i5) {
                        if (i8 >= 0 && 59 >= i8) {
                            if (i9 >= 0 && 59 >= i9) {
                                GregorianCalendar gregorianCalendar = new GregorianCalendar(vi6.e);
                                gregorianCalendar.setLenient(false);
                                gregorianCalendar.set(1, i4);
                                gregorianCalendar.set(2, i7 - 1);
                                gregorianCalendar.set(5, i6);
                                gregorianCalendar.set(11, i5);
                                gregorianCalendar.set(12, i8);
                                gregorianCalendar.set(13, i9);
                                gregorianCalendar.set(14, 0);
                                return gregorianCalendar.getTimeInMillis();
                            }
                            throw new IllegalArgumentException("Failed requirement.".toString());
                        }
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public static final long c(String str) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong <= 0) {
                return Long.MIN_VALUE;
            }
            return parseLong;
        } catch (NumberFormatException e2) {
            n86.e("-?\\d+", "pattern");
            Pattern compile = Pattern.compile("-?\\d+");
            n86.d(compile, "Pattern.compile(pattern)");
            n86.e(compile, "nativePattern");
            n86.e(str, "input");
            if (!compile.matcher(str).matches()) {
                throw e2;
            } else if (ea6.G(str, "-", false, 2)) {
                return Long.MIN_VALUE;
            } else {
                return Long.MAX_VALUE;
            }
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof rh6) {
            rh6 rh6 = (rh6) obj;
            return n86.a(rh6.f3082a, this.f3082a) && n86.a(rh6.b, this.b) && rh6.c == this.c && n86.a(rh6.d, this.d) && n86.a(rh6.e, this.e) && rh6.f == this.f && rh6.g == this.g && rh6.h == this.h && rh6.i == this.i;
        }
    }

    @IgnoreJRERequirement
    public int hashCode() {
        int r0 = hj1.r0(this.b, hj1.r0(this.f3082a, 527, 31), 31);
        int r02 = hj1.r0(this.e, hj1.r0(this.d, (d.a(this.c) + r0) * 31, 31), 31);
        int a2 = b.a(this.g);
        int a3 = b.a(this.h);
        return b.a(this.i) + ((a3 + ((a2 + ((b.a(this.f) + r02) * 31)) * 31)) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f3082a);
        sb.append('=');
        sb.append(this.b);
        if (this.h) {
            if (this.c == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                Date date = new Date(this.c);
                ak6.a aVar = ak6.f176a;
                n86.f(date, "$this$toHttpDateString");
                String format = ((DateFormat) ak6.f176a.get()).format(date);
                n86.b(format, "STANDARD_DATE_FORMAT.get().format(this)");
                sb.append(format);
            }
        }
        if (!this.i) {
            sb.append("; domain=");
            sb.append(this.d);
        }
        sb.append("; path=");
        sb.append(this.e);
        if (this.f) {
            sb.append("; secure");
        }
        if (this.g) {
            sb.append("; httponly");
        }
        String sb2 = sb.toString();
        n86.b(sb2, "toString()");
        return sb2;
    }
}
