package defpackage;

/* renamed from: v75  reason: default package */
/* compiled from: GeneralAppIdDecoder */
public final class v75 {

    /* renamed from: a  reason: collision with root package name */
    public final e45 f3614a;
    public final p75 b = new p75();
    public final StringBuilder c = new StringBuilder();

    public v75(e45 e45) {
        this.f3614a = e45;
    }

    public static int d(e45 e45, int i, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            if (e45.e(i + i4)) {
                i3 |= 1 << ((i2 - i4) - 1);
            }
        }
        return i3;
    }

    public String a(StringBuilder sb, int i) throws a35, v25 {
        String str = null;
        while (true) {
            r75 b2 = b(i, str);
            String a2 = u75.a(b2.b);
            if (a2 != null) {
                sb.append(a2);
            }
            String valueOf = b2.d ? String.valueOf(b2.c) : null;
            int i2 = b2.f3317a;
            if (i == i2) {
                return sb.toString();
            }
            i = i2;
            str = valueOf;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005b, code lost:
        if (r1 >= 63) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0180, code lost:
        if (r1 >= 253) goto L_0x0184;
     */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x02cd  */
    /* JADX WARNING: Removed duplicated region for block: B:202:0x0391  */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x03b0  */
    /* JADX WARNING: Removed duplicated region for block: B:225:0x00ed A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x0255 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:228:0x036b A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0187  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public defpackage.r75 b(int r17, java.lang.String r18) throws defpackage.v25 {
        /*
        // Method dump skipped, instructions count: 1048
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.v75.b(int, java.lang.String):r75");
    }

    public int c(int i, int i2) {
        return d(this.f3614a, i, i2);
    }

    public final boolean e(int i) {
        int i2 = i + 3;
        if (i2 > this.f3614a.g) {
            return false;
        }
        while (i < i2) {
            if (this.f3614a.e(i)) {
                return false;
            }
            i++;
        }
        return true;
    }

    public final boolean f(int i) {
        if (i + 1 > this.f3614a.g) {
            return false;
        }
        for (int i2 = 0; i2 < 5; i2++) {
            int i3 = i2 + i;
            e45 e45 = this.f3614a;
            if (i3 >= e45.g) {
                return true;
            }
            if (i2 == 2) {
                if (!e45.e(i + 2)) {
                    return false;
                }
            } else if (e45.e(i3)) {
                return false;
            }
        }
        return true;
    }
}
