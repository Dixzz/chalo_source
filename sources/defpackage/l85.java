package defpackage;

/* renamed from: l85  reason: default package */
/* compiled from: ModulusGF */
public final class l85 {
    public static final l85 e = new l85(929, 3);

    /* renamed from: a  reason: collision with root package name */
    public final int[] f2186a;
    public final int[] b;
    public final m85 c;
    public final m85 d;

    public l85(int i, int i2) {
        this.f2186a = new int[i];
        this.b = new int[i];
        int i3 = 1;
        for (int i4 = 0; i4 < i; i4++) {
            this.f2186a[i4] = i3;
            i3 = (i3 * i2) % i;
        }
        for (int i5 = 0; i5 < i - 1; i5++) {
            this.b[this.f2186a[i5]] = i5;
        }
        this.c = new m85(this, new int[]{0});
        this.d = new m85(this, new int[]{1});
    }

    public int a(int i, int i2) {
        return (i + i2) % 929;
    }

    public m85 b(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        } else if (i2 == 0) {
            return this.c;
        } else {
            int[] iArr = new int[(i + 1)];
            iArr[0] = i2;
            return new m85(this, iArr);
        }
    }

    public int c(int i) {
        if (i != 0) {
            return this.f2186a[(929 - this.b[i]) - 1];
        }
        throw new ArithmeticException();
    }

    public int d(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return 0;
        }
        int[] iArr = this.f2186a;
        int[] iArr2 = this.b;
        return iArr[(iArr2[i] + iArr2[i2]) % 928];
    }

    public int e(int i, int i2) {
        return ((i + 929) - i2) % 929;
    }
}
