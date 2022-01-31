package defpackage;

import android.os.Bundle;

/* renamed from: e64  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class e64 {
    public static final e64 c = new e64(null, null);

    /* renamed from: a  reason: collision with root package name */
    public final Boolean f931a;
    public final Boolean b;

    public e64(Boolean bool, Boolean bool2) {
        this.f931a = bool;
        this.b = bool2;
    }

    public static int a(Boolean bool) {
        if (bool == null) {
            return 0;
        }
        return bool.booleanValue() ? 1 : 2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
        if (r9 != '1') goto L_0x0033;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static defpackage.e64 b(java.lang.String r9) {
        /*
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            r2 = 0
            if (r9 == 0) goto L_0x0036
            int r3 = r9.length()
            r4 = 49
            r5 = 48
            r6 = 3
            if (r3 < r6) goto L_0x0020
            r3 = 2
            char r3 = r9.charAt(r3)
            if (r3 == r5) goto L_0x001e
            if (r3 == r4) goto L_0x001c
            goto L_0x0020
        L_0x001c:
            r3 = r0
            goto L_0x0021
        L_0x001e:
            r3 = r1
            goto L_0x0021
        L_0x0020:
            r3 = r2
        L_0x0021:
            int r7 = r9.length()
            r8 = 4
            if (r7 < r8) goto L_0x0033
            char r9 = r9.charAt(r6)
            if (r9 == r5) goto L_0x0031
            if (r9 == r4) goto L_0x0034
            goto L_0x0033
        L_0x0031:
            r0 = r1
            goto L_0x0034
        L_0x0033:
            r0 = r2
        L_0x0034:
            r2 = r3
            goto L_0x0037
        L_0x0036:
            r0 = r2
        L_0x0037:
            e64 r9 = new e64
            r9.<init>(r2, r0)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.e64.b(java.lang.String):e64");
    }

    public static Boolean c(Boolean bool, Boolean bool2) {
        if (bool == null) {
            return bool2;
        }
        if (bool2 == null) {
            return bool;
        }
        return Boolean.valueOf(bool.booleanValue() && bool2.booleanValue());
    }

    public static boolean e(int i, int i2) {
        return i <= i2;
    }

    public static e64 g(Bundle bundle) {
        if (bundle == null) {
            return c;
        }
        return new e64(i(bundle.getString("ad_storage")), i(bundle.getString("analytics_storage")));
    }

    public static Boolean i(String str) {
        if (str == null) {
            return null;
        }
        if (str.equals("granted")) {
            return Boolean.TRUE;
        }
        if (str.equals("denied")) {
            return Boolean.FALSE;
        }
        return null;
    }

    public final String d() {
        char c2;
        StringBuilder sb = new StringBuilder("G1");
        Boolean bool = this.f931a;
        char c3 = '0';
        if (bool == null) {
            c2 = '-';
        } else {
            c2 = bool.booleanValue() ? '1' : '0';
        }
        sb.append(c2);
        Boolean bool2 = this.b;
        if (bool2 == null) {
            c3 = '-';
        } else if (bool2.booleanValue()) {
            c3 = '1';
        }
        sb.append(c3);
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof e64)) {
            return false;
        }
        e64 e64 = (e64) obj;
        if (a(this.f931a) == a(e64.f931a) && a(this.b) == a(e64.b)) {
            return true;
        }
        return false;
    }

    public final boolean f(e64 e64) {
        Boolean bool = this.f931a;
        Boolean bool2 = Boolean.FALSE;
        if (bool != bool2 || e64.f931a == bool2) {
            return this.b == bool2 && e64.b != bool2;
        }
        return true;
    }

    public final e64 h(e64 e64) {
        return new e64(c(this.f931a, e64.f931a), c(this.b, e64.b));
    }

    public final int hashCode() {
        return a(this.b) + ((a(this.f931a) + 527) * 31);
    }

    public final boolean j() {
        Boolean bool = this.f931a;
        return bool == null || bool.booleanValue();
    }

    public final boolean k() {
        Boolean bool = this.b;
        return bool == null || bool.booleanValue();
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("ConsentSettings: ");
        sb.append("adStorage=");
        Boolean bool = this.f931a;
        String str2 = "granted";
        if (bool == null) {
            sb.append("uninitialized");
        } else {
            if (bool.booleanValue()) {
                str = str2;
            } else {
                str = "denied";
            }
            sb.append(str);
        }
        sb.append(", analyticsStorage=");
        Boolean bool2 = this.b;
        if (bool2 == null) {
            sb.append("uninitialized");
        } else {
            if (!bool2.booleanValue()) {
                str2 = "denied";
            }
            sb.append(str2);
        }
        return sb.toString();
    }
}
