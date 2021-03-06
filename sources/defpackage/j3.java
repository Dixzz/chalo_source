package defpackage;

import defpackage.d3;
import java.util.Arrays;

/* renamed from: j3  reason: default package */
/* compiled from: SolverVariableValues */
public class j3 implements d3.a {

    /* renamed from: a  reason: collision with root package name */
    public int f1867a = 16;
    public int[] b = new int[16];
    public int[] c = new int[16];
    public int[] d = new int[16];
    public float[] e = new float[16];
    public int[] f = new int[16];
    public int[] g = new int[16];
    public int h = 0;
    public int i = -1;
    public final d3 j;
    public final e3 k;

    public j3(d3 d3Var, e3 e3Var) {
        this.j = d3Var;
        this.k = e3Var;
        clear();
    }

    @Override // defpackage.d3.a
    public int a() {
        return this.h;
    }

    @Override // defpackage.d3.a
    public i3 b(int i2) {
        int i3 = this.h;
        if (i3 == 0) {
            return null;
        }
        int i4 = this.i;
        for (int i5 = 0; i5 < i3; i5++) {
            if (i5 == i2 && i4 != -1) {
                return this.k.d[this.d[i4]];
            }
            i4 = this.g[i4];
            if (i4 == -1) {
                break;
            }
        }
        return null;
    }

    @Override // defpackage.d3.a
    public void c() {
        int i2 = this.h;
        int i3 = this.i;
        for (int i4 = 0; i4 < i2; i4++) {
            float[] fArr = this.e;
            fArr[i3] = fArr[i3] * -1.0f;
            i3 = this.g[i3];
            if (i3 == -1) {
                return;
            }
        }
    }

    @Override // defpackage.d3.a
    public void clear() {
        int i2 = this.h;
        for (int i3 = 0; i3 < i2; i3++) {
            i3 b2 = b(i3);
            if (b2 != null) {
                b2.b(this.j);
            }
        }
        for (int i4 = 0; i4 < this.f1867a; i4++) {
            this.d[i4] = -1;
            this.c[i4] = -1;
        }
        for (int i5 = 0; i5 < 16; i5++) {
            this.b[i5] = -1;
        }
        this.h = 0;
        this.i = -1;
    }

    @Override // defpackage.d3.a
    public float d(int i2) {
        int i3 = this.h;
        int i4 = this.i;
        for (int i5 = 0; i5 < i3; i5++) {
            if (i5 == i2) {
                return this.e[i4];
            }
            i4 = this.g[i4];
            if (i4 == -1) {
                return 0.0f;
            }
        }
        return 0.0f;
    }

    @Override // defpackage.d3.a
    public void e(i3 i3Var, float f2, boolean z) {
        if (f2 <= -0.001f || f2 >= 0.001f) {
            int n = n(i3Var);
            if (n == -1) {
                i(i3Var, f2);
                return;
            }
            float[] fArr = this.e;
            fArr[n] = fArr[n] + f2;
            if (fArr[n] > -0.001f && fArr[n] < 0.001f) {
                fArr[n] = 0.0f;
                j(i3Var, z);
            }
        }
    }

    @Override // defpackage.d3.a
    public float f(i3 i3Var) {
        int n = n(i3Var);
        if (n != -1) {
            return this.e[n];
        }
        return 0.0f;
    }

    @Override // defpackage.d3.a
    public boolean g(i3 i3Var) {
        return n(i3Var) != -1;
    }

    @Override // defpackage.d3.a
    public float h(d3 d3Var, boolean z) {
        float f2 = f(d3Var.f781a);
        j(d3Var.f781a, z);
        j3 j3Var = (j3) d3Var.d;
        int i2 = j3Var.h;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            int[] iArr = j3Var.d;
            if (iArr[i4] != -1) {
                e(this.k.d[iArr[i4]], j3Var.e[i4] * f2, z);
                i3++;
            }
            i4++;
        }
        return f2;
    }

    @Override // defpackage.d3.a
    public void i(i3 i3Var, float f2) {
        if (f2 <= -0.001f || f2 >= 0.001f) {
            int i2 = 0;
            if (this.h == 0) {
                m(0, i3Var, f2);
                l(i3Var, 0);
                this.i = 0;
                return;
            }
            int n = n(i3Var);
            if (n != -1) {
                this.e[n] = f2;
                return;
            }
            int i3 = this.h + 1;
            int i4 = this.f1867a;
            if (i3 >= i4) {
                int i5 = i4 * 2;
                this.d = Arrays.copyOf(this.d, i5);
                this.e = Arrays.copyOf(this.e, i5);
                this.f = Arrays.copyOf(this.f, i5);
                this.g = Arrays.copyOf(this.g, i5);
                this.c = Arrays.copyOf(this.c, i5);
                for (int i6 = this.f1867a; i6 < i5; i6++) {
                    this.d[i6] = -1;
                    this.c[i6] = -1;
                }
                this.f1867a = i5;
            }
            int i7 = this.h;
            int i8 = this.i;
            int i9 = -1;
            for (int i10 = 0; i10 < i7; i10++) {
                int[] iArr = this.d;
                int i11 = iArr[i8];
                int i12 = i3Var.b;
                if (i11 == i12) {
                    this.e[i8] = f2;
                    return;
                }
                if (iArr[i8] < i12) {
                    i9 = i8;
                }
                i8 = this.g[i8];
                if (i8 == -1) {
                    break;
                }
            }
            while (true) {
                if (i2 >= this.f1867a) {
                    i2 = -1;
                    break;
                } else if (this.d[i2] == -1) {
                    break;
                } else {
                    i2++;
                }
            }
            m(i2, i3Var, f2);
            if (i9 != -1) {
                this.f[i2] = i9;
                int[] iArr2 = this.g;
                iArr2[i2] = iArr2[i9];
                iArr2[i9] = i2;
            } else {
                this.f[i2] = -1;
                if (this.h > 0) {
                    this.g[i2] = this.i;
                    this.i = i2;
                } else {
                    this.g[i2] = -1;
                }
            }
            int[] iArr3 = this.g;
            if (iArr3[i2] != -1) {
                this.f[iArr3[i2]] = i2;
            }
            l(i3Var, i2);
            return;
        }
        j(i3Var, true);
    }

    @Override // defpackage.d3.a
    public float j(i3 i3Var, boolean z) {
        int[] iArr;
        int n = n(i3Var);
        if (n == -1) {
            return 0.0f;
        }
        int i2 = i3Var.b;
        int i3 = i2 % 16;
        int[] iArr2 = this.b;
        int i4 = iArr2[i3];
        if (i4 != -1) {
            if (this.d[i4] == i2) {
                int[] iArr3 = this.c;
                iArr2[i3] = iArr3[i4];
                iArr3[i4] = -1;
            } else {
                while (true) {
                    iArr = this.c;
                    if (iArr[i4] == -1 || this.d[iArr[i4]] == i2) {
                        int i5 = iArr[i4];
                    } else {
                        i4 = iArr[i4];
                    }
                }
                int i52 = iArr[i4];
                if (i52 != -1 && this.d[i52] == i2) {
                    iArr[i4] = iArr[i52];
                    iArr[i52] = -1;
                }
            }
        }
        float f2 = this.e[n];
        if (this.i == n) {
            this.i = this.g[n];
        }
        this.d[n] = -1;
        int[] iArr4 = this.f;
        if (iArr4[n] != -1) {
            int[] iArr5 = this.g;
            iArr5[iArr4[n]] = iArr5[n];
        }
        int[] iArr6 = this.g;
        if (iArr6[n] != -1) {
            iArr4[iArr6[n]] = iArr4[n];
        }
        this.h--;
        i3Var.l--;
        if (z) {
            i3Var.b(this.j);
        }
        return f2;
    }

    @Override // defpackage.d3.a
    public void k(float f2) {
        int i2 = this.h;
        int i3 = this.i;
        for (int i4 = 0; i4 < i2; i4++) {
            float[] fArr = this.e;
            fArr[i3] = fArr[i3] / f2;
            i3 = this.g[i3];
            if (i3 == -1) {
                return;
            }
        }
    }

    public final void l(i3 i3Var, int i2) {
        int[] iArr;
        int i3 = i3Var.b % 16;
        int[] iArr2 = this.b;
        int i4 = iArr2[i3];
        if (i4 == -1) {
            iArr2[i3] = i2;
        } else {
            while (true) {
                iArr = this.c;
                if (iArr[i4] == -1) {
                    break;
                }
                i4 = iArr[i4];
            }
            iArr[i4] = i2;
        }
        this.c[i2] = -1;
    }

    public final void m(int i2, i3 i3Var, float f2) {
        this.d[i2] = i3Var.b;
        this.e[i2] = f2;
        this.f[i2] = -1;
        this.g[i2] = -1;
        i3Var.a(this.j);
        i3Var.l++;
        this.h++;
    }

    public int n(i3 i3Var) {
        int[] iArr;
        if (this.h == 0) {
            return -1;
        }
        int i2 = i3Var.b;
        int i3 = this.b[i2 % 16];
        if (i3 == -1) {
            return -1;
        }
        if (this.d[i3] == i2) {
            return i3;
        }
        while (true) {
            iArr = this.c;
            if (iArr[i3] != -1 && this.d[iArr[i3]] != i2) {
                i3 = iArr[i3];
            }
        }
        if (iArr[i3] != -1 && this.d[iArr[i3]] == i2) {
            return iArr[i3];
        }
        return -1;
    }

    public String toString() {
        String str;
        String str2;
        String str3 = hashCode() + " { ";
        int i2 = this.h;
        for (int i3 = 0; i3 < i2; i3++) {
            i3 b2 = b(i3);
            if (b2 != null) {
                String str4 = str3 + b2 + " = " + d(i3) + " ";
                int n = n(b2);
                String S = hj1.S(str4, "[p: ");
                if (this.f[n] != -1) {
                    StringBuilder i0 = hj1.i0(S);
                    i0.append(this.k.d[this.d[this.f[n]]]);
                    str = i0.toString();
                } else {
                    str = hj1.S(S, "none");
                }
                String S2 = hj1.S(str, ", n: ");
                if (this.g[n] != -1) {
                    StringBuilder i02 = hj1.i0(S2);
                    i02.append(this.k.d[this.d[this.g[n]]]);
                    str2 = i02.toString();
                } else {
                    str2 = hj1.S(S2, "none");
                }
                str3 = hj1.S(str2, "]");
            }
        }
        return hj1.S(str3, " }");
    }
}
