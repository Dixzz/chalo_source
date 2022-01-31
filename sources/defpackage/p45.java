package defpackage;

/* renamed from: p45  reason: default package */
/* compiled from: GenericGF */
public final class p45 {
    public static final p45 h = new p45(4201, 4096, 1);
    public static final p45 i = new p45(1033, 1024, 1);
    public static final p45 j;
    public static final p45 k = new p45(19, 16, 1);
    public static final p45 l = new p45(285, 256, 0);
    public static final p45 m;
    public static final p45 n;
    public static final p45 o;

    /* renamed from: a  reason: collision with root package name */
    public final int[] f2767a;
    public final int[] b;
    public final q45 c;
    public final q45 d;
    public final int e;
    public final int f;
    public final int g;

    static {
        p45 p45 = new p45(67, 64, 1);
        j = p45;
        p45 p452 = new p45(301, 256, 1);
        m = p452;
        n = p452;
        o = p45;
    }

    public p45(int i2, int i3, int i4) {
        this.f = i2;
        this.e = i3;
        this.g = i4;
        this.f2767a = new int[i3];
        this.b = new int[i3];
        int i5 = 1;
        for (int i6 = 0; i6 < i3; i6++) {
            this.f2767a[i6] = i5;
            i5 <<= 1;
            if (i5 >= i3) {
                i5 = (i5 ^ i2) & (i3 - 1);
            }
        }
        for (int i7 = 0; i7 < i3 - 1; i7++) {
            this.b[this.f2767a[i7]] = i7;
        }
        this.c = new q45(this, new int[]{0});
        this.d = new q45(this, new int[]{1});
    }

    public q45 a(int i2, int i3) {
        if (i2 < 0) {
            throw new IllegalArgumentException();
        } else if (i3 == 0) {
            return this.c;
        } else {
            int[] iArr = new int[(i2 + 1)];
            iArr[0] = i3;
            return new q45(this, iArr);
        }
    }

    public int b(int i2) {
        if (i2 != 0) {
            return this.f2767a[(this.e - this.b[i2]) - 1];
        }
        throw new ArithmeticException();
    }

    public int c(int i2, int i3) {
        if (i2 == 0 || i3 == 0) {
            return 0;
        }
        int[] iArr = this.f2767a;
        int[] iArr2 = this.b;
        return iArr[(iArr2[i2] + iArr2[i3]) % (this.e - 1)];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GF(0x");
        sb.append(Integer.toHexString(this.f));
        sb.append(',');
        return hj1.W(sb, this.e, ')');
    }
}
