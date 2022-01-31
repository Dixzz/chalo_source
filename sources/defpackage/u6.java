package defpackage;

import android.os.Build;
import android.os.LocaleList;
import java.util.Locale;

/* renamed from: u6  reason: default package */
/* compiled from: LocaleListCompat */
public final class u6 {
    public static final u6 b = a(new Locale[0]);

    /* renamed from: a  reason: collision with root package name */
    public w6 f3457a;

    public u6(w6 w6Var) {
        this.f3457a = w6Var;
    }

    public static u6 a(Locale... localeArr) {
        if (Build.VERSION.SDK_INT >= 24) {
            return new u6(new x6(new LocaleList(localeArr)));
        }
        return new u6(new v6(localeArr));
    }

    public static Locale b(String str) {
        if (str.contains("-")) {
            String[] split = str.split("-", -1);
            if (split.length > 2) {
                return new Locale(split[0], split[1], split[2]);
            }
            if (split.length > 1) {
                return new Locale(split[0], split[1]);
            }
            if (split.length == 1) {
                return new Locale(split[0]);
            }
        } else if (!str.contains("_")) {
            return new Locale(str);
        } else {
            String[] split2 = str.split("_", -1);
            if (split2.length > 2) {
                return new Locale(split2[0], split2[1], split2[2]);
            }
            if (split2.length > 1) {
                return new Locale(split2[0], split2[1]);
            }
            if (split2.length == 1) {
                return new Locale(split2[0]);
            }
        }
        throw new IllegalArgumentException(hj1.T("Can not parse language tag: [", str, "]"));
    }

    public Locale c(int i) {
        return this.f3457a.get(i);
    }

    public boolean equals(Object obj) {
        return (obj instanceof u6) && this.f3457a.equals(((u6) obj).f3457a);
    }

    public int hashCode() {
        return this.f3457a.hashCode();
    }

    public String toString() {
        return this.f3457a.toString();
    }
}
