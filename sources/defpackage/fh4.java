package defpackage;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import defpackage.hq3;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* renamed from: fh4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public abstract class fh4 {

    /* renamed from: a  reason: collision with root package name */
    public String f1123a;
    public int b;
    public Boolean c;
    public Boolean d;
    public Long e;
    public Long f;

    public fh4(String str, int i) {
        this.f1123a = str;
        this.b = i;
    }

    public static Boolean b(long j, fq3 fq3) {
        try {
            return f(new BigDecimal(j), fq3, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static Boolean c(Boolean bool, boolean z) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() != z);
    }

    public static Boolean d(String str, fq3 fq3) {
        if (!rg4.O(str)) {
            return null;
        }
        try {
            return f(new BigDecimal(str), fq3, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static Boolean e(String str, hq3 hq3, ra4 ra4) {
        String str2;
        List<String> list;
        Objects.requireNonNull(hq3, "null reference");
        if (str == null || !hq3.t() || hq3.u() == hq3.b.UNKNOWN_MATCH_TYPE) {
            return null;
        }
        hq3.b u = hq3.u();
        hq3.b bVar = hq3.b.IN_LIST;
        if (u == bVar) {
            if (hq3.A() == 0) {
                return null;
            }
        } else if (!hq3.v()) {
            return null;
        }
        hq3.b u2 = hq3.u();
        boolean y = hq3.y();
        if (y || u2 == hq3.b.REGEXP || u2 == bVar) {
            str2 = hq3.w();
        } else {
            str2 = hq3.w().toUpperCase(Locale.ENGLISH);
        }
        if (hq3.A() == 0) {
            list = null;
        } else {
            list = hq3.z();
            if (!y) {
                ArrayList arrayList = new ArrayList(list.size());
                for (String str3 : list) {
                    arrayList.add(str3.toUpperCase(Locale.ENGLISH));
                }
                list = Collections.unmodifiableList(arrayList);
            }
        }
        hq3.b bVar2 = hq3.b.REGEXP;
        String str4 = u2 == bVar2 ? str2 : null;
        if (u2 == hq3.b.IN_LIST) {
            if (list == null || list.size() == 0) {
                return null;
            }
        } else if (str2 == null) {
            return null;
        }
        if (!y && u2 != bVar2) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (bh4.f432a[u2.ordinal()]) {
            case 1:
                try {
                    return Boolean.valueOf(Pattern.compile(str4, y ? 0 : 66).matcher(str).matches());
                } catch (PatternSyntaxException unused) {
                    if (ra4 == null) {
                        return null;
                    }
                    ra4.i.b("Invalid regular expression in REGEXP audience filter. expression", str4);
                    return null;
                }
            case 2:
                return Boolean.valueOf(str.startsWith(str2));
            case 3:
                return Boolean.valueOf(str.endsWith(str2));
            case 4:
                return Boolean.valueOf(str.contains(str2));
            case 5:
                return Boolean.valueOf(str.equals(str2));
            case 6:
                return Boolean.valueOf(list.contains(str));
            default:
                return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0082, code lost:
        if (r3 != null) goto L_0x0084;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Boolean f(java.math.BigDecimal r9, defpackage.fq3 r10, double r11) {
        /*
        // Method dump skipped, instructions count: 270
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.fh4.f(java.math.BigDecimal, fq3, double):java.lang.Boolean");
    }

    public abstract int a();

    public abstract boolean g();

    public abstract boolean h();
}
