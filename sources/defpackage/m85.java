package defpackage;

/* renamed from: m85  reason: default package */
/* compiled from: ModulusPoly */
public final class m85 {

    /* renamed from: a  reason: collision with root package name */
    public final l85 f2340a;
    public final int[] b;

    public m85(l85 l85, int[] iArr) {
        if (iArr.length != 0) {
            this.f2340a = l85;
            int length = iArr.length;
            if (length <= 1 || iArr[0] != 0) {
                this.b = iArr;
                return;
            }
            int i = 1;
            while (i < length && iArr[i] == 0) {
                i++;
            }
            if (i == length) {
                this.b = new int[]{0};
                return;
            }
            int[] iArr2 = new int[(length - i)];
            this.b = iArr2;
            System.arraycopy(iArr, i, iArr2, 0, iArr2.length);
            return;
        }
        throw new IllegalArgumentException();
    }

    public m85 a(m85 m85) {
        if (!this.f2340a.equals(m85.f2340a)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        } else if (e()) {
            return m85;
        } else {
            if (m85.e()) {
                return this;
            }
            int[] iArr = this.b;
            int[] iArr2 = m85.b;
            if (iArr.length <= iArr2.length) {
                iArr = iArr2;
                iArr2 = iArr;
            }
            int[] iArr3 = new int[iArr.length];
            int length = iArr.length - iArr2.length;
            System.arraycopy(iArr, 0, iArr3, 0, length);
            for (int i = length; i < iArr.length; i++) {
                iArr3[i] = this.f2340a.a(iArr2[i - length], iArr[i]);
            }
            return new m85(this.f2340a, iArr3);
        }
    }

    public int b(int i) {
        if (i == 0) {
            return c(0);
        }
        if (i == 1) {
            int i2 = 0;
            for (int i3 : this.b) {
                i2 = this.f2340a.a(i2, i3);
            }
            return i2;
        }
        int[] iArr = this.b;
        int i4 = iArr[0];
        int length = iArr.length;
        for (int i5 = 1; i5 < length; i5++) {
            l85 l85 = this.f2340a;
            i4 = l85.a(l85.d(i, i4), this.b[i5]);
        }
        return i4;
    }

    public int c(int i) {
        int[] iArr = this.b;
        return iArr[(iArr.length - 1) - i];
    }

    public int d() {
        return this.b.length - 1;
    }

    public boolean e() {
        return this.b[0] == 0;
    }

    public m85 f(int i) {
        if (i == 0) {
            return this.f2340a.c;
        }
        if (i == 1) {
            return this;
        }
        int length = this.b.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = this.f2340a.d(this.b[i2], i);
        }
        return new m85(this.f2340a, iArr);
    }

    public m85 g(m85 m85) {
        if (!this.f2340a.equals(m85.f2340a)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        } else if (e() || m85.e()) {
            return this.f2340a.c;
        } else {
            int[] iArr = this.b;
            int length = iArr.length;
            int[] iArr2 = m85.b;
            int length2 = iArr2.length;
            int[] iArr3 = new int[((length + length2) - 1)];
            for (int i = 0; i < length; i++) {
                int i2 = iArr[i];
                for (int i3 = 0; i3 < length2; i3++) {
                    int i4 = i + i3;
                    l85 l85 = this.f2340a;
                    iArr3[i4] = l85.a(iArr3[i4], l85.d(i2, iArr2[i3]));
                }
            }
            return new m85(this.f2340a, iArr3);
        }
    }

    public m85 h() {
        int length = this.b.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = this.f2340a.e(0, this.b[i]);
        }
        return new m85(this.f2340a, iArr);
    }

    public m85 i(m85 m85) {
        if (!this.f2340a.equals(m85.f2340a)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        } else if (m85.e()) {
            return this;
        } else {
            return a(m85.h());
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(d() * 8);
        for (int d = d(); d >= 0; d--) {
            int c = c(d);
            if (c != 0) {
                if (c < 0) {
                    sb.append(" - ");
                    c = -c;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (d == 0 || c != 1) {
                    sb.append(c);
                }
                if (d != 0) {
                    if (d == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(d);
                    }
                }
            }
        }
        return sb.toString();
    }
}
