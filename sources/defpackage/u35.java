package defpackage;

import java.util.Objects;

/* renamed from: u35  reason: default package */
/* compiled from: State */
public final class u35 {
    public static final u35 e = new u35(v35.b, 0, 0, 0);

    /* renamed from: a  reason: collision with root package name */
    public final int f3446a;
    public final v35 b;
    public final int c;
    public final int d;

    public u35(v35 v35, int i, int i2, int i3) {
        this.b = v35;
        this.f3446a = i;
        this.c = i2;
        this.d = i3;
    }

    public u35 a(int i) {
        v35 v35 = this.b;
        int i2 = this.f3446a;
        int i3 = this.d;
        if (i2 == 4 || i2 == 2) {
            int i4 = s35.c[i2][0];
            int i5 = 65535 & i4;
            int i6 = i4 >> 16;
            Objects.requireNonNull(v35);
            i3 += i6;
            v35 = new t35(v35, i5, i6);
            i2 = 0;
        }
        int i7 = this.c;
        int i8 = (i7 == 0 || i7 == 31) ? 18 : i7 == 62 ? 9 : 8;
        int i9 = i7 + 1;
        u35 u35 = new u35(v35, i2, i9, i3 + i8);
        return i9 == 2078 ? u35.b(i + 1) : u35;
    }

    public u35 b(int i) {
        int i2 = this.c;
        if (i2 == 0) {
            return this;
        }
        v35 v35 = this.b;
        Objects.requireNonNull(v35);
        return new u35(new p35(v35, i - i2, i2), this.f3446a, 0, this.d);
    }

    public boolean c(u35 u35) {
        int i;
        int i2 = this.d + (s35.c[this.f3446a][u35.f3446a] >> 16);
        int i3 = u35.c;
        if (i3 > 0 && ((i = this.c) == 0 || i > i3)) {
            i2 += 10;
        }
        return i2 <= u35.d;
    }

    public u35 d(int i, int i2) {
        int i3 = this.d;
        v35 v35 = this.b;
        int i4 = this.f3446a;
        if (i != i4) {
            int i5 = s35.c[i4][i];
            int i6 = 65535 & i5;
            int i7 = i5 >> 16;
            Objects.requireNonNull(v35);
            i3 += i7;
            v35 = new t35(v35, i6, i7);
        }
        int i8 = i == 2 ? 4 : 5;
        Objects.requireNonNull(v35);
        return new u35(new t35(v35, i2, i8), i, 0, i3 + i8);
    }

    public u35 e(int i, int i2) {
        v35 v35 = this.b;
        int i3 = this.f3446a;
        int i4 = i3 == 2 ? 4 : 5;
        int i5 = s35.e[i3][i];
        Objects.requireNonNull(v35);
        return new u35(new t35(new t35(v35, i5, i4), i2, 5), this.f3446a, 0, this.d + i4 + 5);
    }

    public String toString() {
        return String.format("%s bits=%d bytes=%d", s35.b[this.f3446a], Integer.valueOf(this.d), Integer.valueOf(this.c));
    }
}
