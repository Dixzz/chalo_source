package defpackage;

/* renamed from: l55  reason: default package */
/* compiled from: SymbolInfo */
public class l55 {
    public static l55[] i = {new l55(false, 3, 5, 8, 8, 1), new l55(false, 5, 7, 10, 10, 1), new l55(true, 5, 7, 16, 6, 1), new l55(false, 8, 10, 12, 12, 1), new l55(true, 10, 11, 14, 6, 2), new l55(false, 12, 12, 14, 14, 1), new l55(true, 16, 14, 24, 10, 1), new l55(false, 18, 14, 16, 16, 1), new l55(false, 22, 18, 18, 18, 1), new l55(true, 22, 18, 16, 10, 2), new l55(false, 30, 20, 20, 20, 1), new l55(true, 32, 24, 16, 14, 2), new l55(false, 36, 24, 22, 22, 1), new l55(false, 44, 28, 24, 24, 1), new l55(true, 49, 28, 22, 14, 2), new l55(false, 62, 36, 14, 14, 4), new l55(false, 86, 42, 16, 16, 4), new l55(false, 114, 48, 18, 18, 4), new l55(false, 144, 56, 20, 20, 4), new l55(false, 174, 68, 22, 22, 4), new l55(false, 204, 84, 24, 24, 4, 102, 42), new l55(false, 280, 112, 14, 14, 16, 140, 56), new l55(false, 368, 144, 16, 16, 16, 92, 36), new l55(false, 456, 192, 18, 18, 16, 114, 48), new l55(false, 576, 224, 20, 20, 16, 144, 56), new l55(false, 696, 272, 22, 22, 16, 174, 68), new l55(false, 816, 336, 24, 24, 16, 136, 56), new l55(false, 1050, 408, 18, 18, 36, 175, 68), new l55(false, 1304, 496, 20, 20, 36, 163, 62), new f55()};

    /* renamed from: a  reason: collision with root package name */
    public final boolean f2178a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;

    public l55(boolean z, int i2, int i3, int i4, int i5, int i6) {
        this(z, i2, i3, i4, i5, i6, i2, i3);
    }

    public static l55 i(int i2, m55 m55, t25 t25, t25 t252, boolean z) {
        l55[] l55Arr = i;
        for (l55 l55 : l55Arr) {
            if ((m55 != m55.FORCE_SQUARE || !l55.f2178a) && ((m55 != m55.FORCE_RECTANGLE || l55.f2178a) && ((t25 == null || (l55.g() >= 0 && l55.f() >= 0)) && ((t252 == null || (l55.g() <= 0 && l55.f() <= 0)) && i2 <= l55.b)))) {
                return l55;
            }
        }
        if (!z) {
            return null;
        }
        throw new IllegalArgumentException("Can't find a symbol arrangement that matches the message. Data codewords: ".concat(String.valueOf(i2)));
    }

    public int a(int i2) {
        return this.g;
    }

    public final int b() {
        int i2 = this.f;
        int i3 = 1;
        if (i2 != 1) {
            i3 = 2;
            if (!(i2 == 2 || i2 == 4)) {
                if (i2 == 16) {
                    return 4;
                }
                if (i2 == 36) {
                    return 6;
                }
                throw new IllegalStateException("Cannot handle this number of data regions");
            }
        }
        return i3;
    }

    public int c() {
        return this.b / this.g;
    }

    public final int d() {
        return h() * this.e;
    }

    public final int e() {
        return b() * this.d;
    }

    public final int f() {
        return d() + (h() << 1);
    }

    public final int g() {
        return e() + (b() << 1);
    }

    public final int h() {
        int i2 = this.f;
        if (i2 == 1 || i2 == 2) {
            return 1;
        }
        if (i2 == 4) {
            return 2;
        }
        if (i2 == 16) {
            return 4;
        }
        if (i2 == 36) {
            return 6;
        }
        throw new IllegalStateException("Cannot handle this number of data regions");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2178a ? "Rectangular Symbol:" : "Square Symbol:");
        sb.append(" data region ");
        sb.append(this.d);
        sb.append('x');
        sb.append(this.e);
        sb.append(", symbol size ");
        sb.append(g());
        sb.append('x');
        sb.append(f());
        sb.append(", symbol data size ");
        sb.append(e());
        sb.append('x');
        sb.append(d());
        sb.append(", codewords ");
        sb.append(this.b);
        sb.append('+');
        sb.append(this.c);
        return sb.toString();
    }

    public l55(boolean z, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.f2178a = z;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
        this.f = i6;
        this.g = i7;
        this.h = i8;
    }
}
