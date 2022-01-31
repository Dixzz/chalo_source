package defpackage;

import java.util.concurrent.TimeUnit;

/* renamed from: hh6  reason: default package */
/* compiled from: CacheControl.kt */
public final class hh6 {
    public static final hh6 n;
    public static final b o = new b(null);

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1374a;
    public final boolean b;
    public final int c;
    public final int d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final int h;
    public final int i;
    public final boolean j;
    public final boolean k;
    public final boolean l;
    public String m;

    /* renamed from: hh6$a */
    /* compiled from: CacheControl.kt */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1375a;
        public boolean b;
        public int c = -1;
        public boolean d;

        public final hh6 a() {
            return new hh6(this.f1375a, this.b, -1, -1, false, false, false, this.c, -1, this.d, false, false, null, null);
        }
    }

    /* renamed from: hh6$b */
    /* compiled from: CacheControl.kt */
    public static final class b {
        public b(j86 j86) {
        }

        public final int a(String str, String str2, int i) {
            int length = str.length();
            while (i < length) {
                if (ea6.b(str2, str.charAt(i), false, 2)) {
                    return i;
                }
                i++;
            }
            return str.length();
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x004a  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x00ee  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x00f2  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final defpackage.hh6 b(defpackage.ci6 r27) {
            /*
            // Method dump skipped, instructions count: 424
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.hh6.b.b(ci6):hh6");
        }
    }

    static {
        a aVar = new a();
        aVar.f1375a = true;
        aVar.a();
        a aVar2 = new a();
        aVar2.d = true;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        n86.f(timeUnit, "timeUnit");
        int i2 = Integer.MAX_VALUE;
        long j2 = (long) Integer.MAX_VALUE;
        long seconds = timeUnit.toSeconds(j2);
        if (seconds <= j2) {
            i2 = (int) seconds;
        }
        aVar2.c = i2;
        n = aVar2.a();
    }

    public hh6(boolean z, boolean z2, int i2, int i3, boolean z3, boolean z4, boolean z5, int i4, int i5, boolean z6, boolean z7, boolean z8, String str, j86 j86) {
        this.f1374a = z;
        this.b = z2;
        this.c = i2;
        this.d = i3;
        this.e = z3;
        this.f = z4;
        this.g = z5;
        this.h = i4;
        this.i = i5;
        this.j = z6;
        this.k = z7;
        this.l = z8;
        this.m = str;
    }

    public String toString() {
        String str = this.m;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        if (this.f1374a) {
            sb.append("no-cache, ");
        }
        if (this.b) {
            sb.append("no-store, ");
        }
        if (this.c != -1) {
            sb.append("max-age=");
            sb.append(this.c);
            sb.append(", ");
        }
        if (this.d != -1) {
            sb.append("s-maxage=");
            sb.append(this.d);
            sb.append(", ");
        }
        if (this.e) {
            sb.append("private, ");
        }
        if (this.f) {
            sb.append("public, ");
        }
        if (this.g) {
            sb.append("must-revalidate, ");
        }
        if (this.h != -1) {
            sb.append("max-stale=");
            sb.append(this.h);
            sb.append(", ");
        }
        if (this.i != -1) {
            sb.append("min-fresh=");
            sb.append(this.i);
            sb.append(", ");
        }
        if (this.j) {
            sb.append("only-if-cached, ");
        }
        if (this.k) {
            sb.append("no-transform, ");
        }
        if (this.l) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        String sb2 = sb.toString();
        n86.b(sb2, "StringBuilder().apply(builderAction).toString()");
        this.m = sb2;
        return sb2;
    }
}
