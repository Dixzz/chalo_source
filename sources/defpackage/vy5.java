package defpackage;

import com.urbanairship.json.JsonValue;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: vy5  reason: default package */
/* compiled from: IvyVersionMatcher */
public class vy5 implements dk5<String>, cu5 {
    public static final String h;
    public static final String i;
    public static final String j;
    public static final Pattern k;
    public static final Pattern l = Pattern.compile("^([0-9]+)(\\.[0-9]+)?(\\.[0-9]+)?$");
    public static final Pattern m = Pattern.compile("^(.*)\\+$");
    public final dk5<String> f;
    public final String g;

    /* renamed from: vy5$a */
    /* compiled from: IvyVersionMatcher */
    public static class a implements Comparable<a> {
        public final int[] f = {0, 0, 0};

        public a(String str) {
            String[] split = str.split("\\.");
            int i = 0;
            while (i < 3 && split.length > i) {
                this.f[i] = Integer.parseInt(split[i]);
                i++;
            }
        }

        /* renamed from: a */
        public int compareTo(a aVar) {
            for (int i = 0; i < 3; i++) {
                int i2 = this.f[i] - aVar.f[i];
                if (i2 != 0) {
                    return i2 > 0 ? 1 : -1;
                }
            }
            return 0;
        }
    }

    static {
        Locale locale = Locale.US;
        String format = String.format(locale, "([\\%s\\%s\\%s])", "[", "]", "(");
        h = format;
        String format2 = String.format(locale, "([\\%s\\%s\\%s])", "]", "[", ")");
        i = format2;
        String format3 = String.format(locale, "^(%s(%s)?)%s((%s)?%s)", format, "([0-9]+)(\\.[0-9]+)?(\\.[0-9]+)?", ",", "([0-9]+)(\\.[0-9]+)?(\\.[0-9]+)?", format2);
        j = format3;
        k = Pattern.compile(format3);
    }

    public vy5(dk5<String> dk5, String str) {
        this.f = dk5;
        this.g = str;
    }

    public static vy5 c(String str) {
        uy5 uy5;
        dk5 dk5;
        a aVar;
        String str2;
        a aVar2;
        String str3;
        String replaceAll = str.replaceAll("\\s", "");
        ty5 ty5 = null;
        if (!l.matcher(replaceAll).matches()) {
            uy5 = null;
        } else {
            uy5 = new uy5(replaceAll);
        }
        if (uy5 != null) {
            return new vy5(uy5, replaceAll);
        }
        Matcher matcher = m.matcher(replaceAll);
        if (!matcher.matches()) {
            dk5 = null;
        } else if ("+".equals(replaceAll)) {
            dk5 = new ry5();
        } else {
            dk5 = new sy5(matcher.groupCount() >= 1 ? matcher.group(1) : null);
        }
        if (dk5 != null) {
            return new vy5(dk5, replaceAll);
        }
        Matcher matcher2 = k.matcher(replaceAll);
        if (matcher2.matches()) {
            String group = matcher2.groupCount() >= 7 ? matcher2.group(7) : null;
            if (!hd3.G1(group)) {
                str2 = group.substring(group.length() - 1);
                aVar = group.length() > 1 ? new a(group.substring(0, group.length() - 1)) : null;
            } else {
                str2 = null;
                aVar = null;
            }
            String group2 = matcher2.groupCount() >= 1 ? matcher2.group(1) : null;
            if (!hd3.G1(group2)) {
                str3 = group2.substring(0, 1);
                aVar2 = group2.length() > 1 ? new a(group2.substring(1)) : null;
            } else {
                str3 = null;
                aVar2 = null;
            }
            if ((!")".equals(str2) || aVar == null) && (!"(".equals(str3) || aVar2 == null)) {
                ty5 = new ty5(str2, aVar, str3, aVar2);
            }
        }
        if (ty5 != null) {
            return new vy5(ty5, replaceAll);
        }
        throw new IllegalArgumentException(hj1.S("Invalid constraint: ", replaceAll));
    }

    /* renamed from: a */
    public boolean apply(String str) {
        if (str == null) {
            return false;
        }
        return this.f.apply(str.trim());
    }

    @Override // defpackage.cu5
    public JsonValue b() {
        return JsonValue.x(this.g);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || vy5.class != obj.getClass()) {
            return false;
        }
        String str = this.g;
        String str2 = ((vy5) obj).g;
        if (str != null) {
            return str.equals(str2);
        }
        if (str2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.g;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }
}
