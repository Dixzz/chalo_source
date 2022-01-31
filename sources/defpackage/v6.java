package defpackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* renamed from: v6  reason: default package */
/* compiled from: LocaleListCompatWrapper */
public final class v6 implements w6 {
    public static final Locale[] b = new Locale[0];
    public static final Locale c = new Locale("en", "XA");
    public static final Locale d = new Locale("ar", "XB");
    public static final Locale e = u6.b("en-Latn");

    /* renamed from: a  reason: collision with root package name */
    public final Locale[] f3605a;

    public v6(Locale... localeArr) {
        if (localeArr.length == 0) {
            this.f3605a = b;
            return;
        }
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        for (int i = 0; i < localeArr.length; i++) {
            Locale locale = localeArr[i];
            if (locale != null) {
                if (!hashSet.contains(locale)) {
                    Locale locale2 = (Locale) locale.clone();
                    arrayList.add(locale2);
                    locale2.getLanguage();
                    String country = locale2.getCountry();
                    if (country != null && !country.isEmpty()) {
                        locale2.getCountry();
                    }
                    int length = localeArr.length;
                    hashSet.add(locale2);
                }
            } else {
                throw new NullPointerException(hj1.J("list[", i, "] is null"));
            }
        }
        this.f3605a = (Locale[]) arrayList.toArray(new Locale[arrayList.size()]);
    }

    public static boolean d(Locale locale) {
        return c.equals(locale) || d.equals(locale);
    }

    @Override // defpackage.w6
    public Object a() {
        return null;
    }

    @Override // defpackage.w6
    public Locale b(String[] strArr) {
        List asList = Arrays.asList(strArr);
        Locale[] localeArr = this.f3605a;
        int i = 0;
        if (localeArr.length != 1) {
            if (localeArr.length == 0) {
                i = -1;
            } else {
                Iterator it = asList.iterator();
                int i2 = Integer.MAX_VALUE;
                while (true) {
                    if (it.hasNext()) {
                        int c2 = c(u6.b((String) it.next()));
                        if (c2 == 0) {
                            break;
                        } else if (c2 < i2) {
                            i2 = c2;
                        }
                    } else if (i2 != Integer.MAX_VALUE) {
                        i = i2;
                    }
                }
            }
        }
        if (i == -1) {
            return null;
        }
        return this.f3605a[i];
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.util.Locale] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0053, code lost:
        if (r3.equals(r2.getCountry()) == false) goto L_0x0056;
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int c(java.util.Locale r8) {
        /*
        // Method dump skipped, instructions count: 113
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.v6.c(java.util.Locale):int");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof v6)) {
            return false;
        }
        Locale[] localeArr = ((v6) obj).f3605a;
        if (this.f3605a.length != localeArr.length) {
            return false;
        }
        int i = 0;
        while (true) {
            Locale[] localeArr2 = this.f3605a;
            if (i >= localeArr2.length) {
                return true;
            }
            if (!localeArr2[i].equals(localeArr[i])) {
                return false;
            }
            i++;
        }
    }

    @Override // defpackage.w6
    public Locale get(int i) {
        if (i >= 0) {
            Locale[] localeArr = this.f3605a;
            if (i < localeArr.length) {
                return localeArr[i];
            }
        }
        return null;
    }

    public int hashCode() {
        int i = 1;
        int i2 = 0;
        while (true) {
            Locale[] localeArr = this.f3605a;
            if (i2 >= localeArr.length) {
                return i;
            }
            i = (i * 31) + localeArr[i2].hashCode();
            i2++;
        }
    }

    @Override // defpackage.w6
    public int size() {
        return this.f3605a.length;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("[");
        int i = 0;
        while (true) {
            Locale[] localeArr = this.f3605a;
            if (i < localeArr.length) {
                i0.append(localeArr[i]);
                if (i < this.f3605a.length - 1) {
                    i0.append(',');
                }
                i++;
            } else {
                i0.append("]");
                return i0.toString();
            }
        }
    }
}
