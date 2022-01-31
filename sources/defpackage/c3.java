package defpackage;

import defpackage.d3;
import java.util.Arrays;

/* renamed from: c3  reason: default package */
/* compiled from: ArrayLinkedVariables */
public class c3 implements d3.a {

    /* renamed from: a  reason: collision with root package name */
    public int f511a = 0;
    public final d3 b;
    public final e3 c;
    public int d = 8;
    public int[] e = new int[8];
    public int[] f = new int[8];
    public float[] g = new float[8];
    public int h = -1;
    public int i = -1;
    public boolean j = false;

    public c3(d3 d3Var, e3 e3Var) {
        this.b = d3Var;
        this.c = e3Var;
    }

    @Override // defpackage.d3.a
    public int a() {
        return this.f511a;
    }

    @Override // defpackage.d3.a
    public i3 b(int i2) {
        int i3 = this.h;
        int i4 = 0;
        while (i3 != -1 && i4 < this.f511a) {
            if (i4 == i2) {
                return this.c.d[this.e[i3]];
            }
            i3 = this.f[i3];
            i4++;
        }
        return null;
    }

    @Override // defpackage.d3.a
    public void c() {
        int i2 = this.h;
        int i3 = 0;
        while (i2 != -1 && i3 < this.f511a) {
            float[] fArr = this.g;
            fArr[i2] = fArr[i2] * -1.0f;
            i2 = this.f[i2];
            i3++;
        }
    }

    @Override // defpackage.d3.a
    public final void clear() {
        int i2 = this.h;
        int i3 = 0;
        while (i2 != -1 && i3 < this.f511a) {
            i3 i3Var = this.c.d[this.e[i2]];
            if (i3Var != null) {
                i3Var.b(this.b);
            }
            i2 = this.f[i2];
            i3++;
        }
        this.h = -1;
        this.i = -1;
        this.j = false;
        this.f511a = 0;
    }

    @Override // defpackage.d3.a
    public float d(int i2) {
        int i3 = this.h;
        int i4 = 0;
        while (i3 != -1 && i4 < this.f511a) {
            if (i4 == i2) {
                return this.g[i3];
            }
            i3 = this.f[i3];
            i4++;
        }
        return 0.0f;
    }

    @Override // defpackage.d3.a
    public void e(i3 i3Var, float f2, boolean z) {
        if (f2 <= -0.001f || f2 >= 0.001f) {
            int i2 = this.h;
            if (i2 == -1) {
                this.h = 0;
                this.g[0] = f2;
                this.e[0] = i3Var.b;
                this.f[0] = -1;
                i3Var.l++;
                i3Var.a(this.b);
                this.f511a++;
                if (!this.j) {
                    int i3 = this.i + 1;
                    this.i = i3;
                    int[] iArr = this.e;
                    if (i3 >= iArr.length) {
                        this.j = true;
                        this.i = iArr.length - 1;
                        return;
                    }
                    return;
                }
                return;
            }
            int i4 = 0;
            int i5 = -1;
            while (i2 != -1 && i4 < this.f511a) {
                int[] iArr2 = this.e;
                int i6 = iArr2[i2];
                int i7 = i3Var.b;
                if (i6 == i7) {
                    float[] fArr = this.g;
                    float f3 = fArr[i2] + f2;
                    if (f3 > -0.001f && f3 < 0.001f) {
                        f3 = 0.0f;
                    }
                    fArr[i2] = f3;
                    if (f3 == 0.0f) {
                        if (i2 == this.h) {
                            this.h = this.f[i2];
                        } else {
                            int[] iArr3 = this.f;
                            iArr3[i5] = iArr3[i2];
                        }
                        if (z) {
                            i3Var.b(this.b);
                        }
                        if (this.j) {
                            this.i = i2;
                        }
                        i3Var.l--;
                        this.f511a--;
                        return;
                    }
                    return;
                }
                if (iArr2[i2] < i7) {
                    i5 = i2;
                }
                i2 = this.f[i2];
                i4++;
            }
            int i8 = this.i;
            int i9 = i8 + 1;
            if (this.j) {
                int[] iArr4 = this.e;
                if (iArr4[i8] != -1) {
                    i8 = iArr4.length;
                }
            } else {
                i8 = i9;
            }
            int[] iArr5 = this.e;
            if (i8 >= iArr5.length && this.f511a < iArr5.length) {
                int i10 = 0;
                while (true) {
                    int[] iArr6 = this.e;
                    if (i10 >= iArr6.length) {
                        break;
                    } else if (iArr6[i10] == -1) {
                        i8 = i10;
                        break;
                    } else {
                        i10++;
                    }
                }
            }
            int[] iArr7 = this.e;
            if (i8 >= iArr7.length) {
                i8 = iArr7.length;
                int i11 = this.d * 2;
                this.d = i11;
                this.j = false;
                this.i = i8 - 1;
                this.g = Arrays.copyOf(this.g, i11);
                this.e = Arrays.copyOf(this.e, this.d);
                this.f = Arrays.copyOf(this.f, this.d);
            }
            this.e[i8] = i3Var.b;
            this.g[i8] = f2;
            if (i5 != -1) {
                int[] iArr8 = this.f;
                iArr8[i8] = iArr8[i5];
                iArr8[i5] = i8;
            } else {
                this.f[i8] = this.h;
                this.h = i8;
            }
            i3Var.l++;
            i3Var.a(this.b);
            this.f511a++;
            if (!this.j) {
                this.i++;
            }
            int i12 = this.i;
            int[] iArr9 = this.e;
            if (i12 >= iArr9.length) {
                this.j = true;
                this.i = iArr9.length - 1;
            }
        }
    }

    @Override // defpackage.d3.a
    public final float f(i3 i3Var) {
        int i2 = this.h;
        int i3 = 0;
        while (i2 != -1 && i3 < this.f511a) {
            if (this.e[i2] == i3Var.b) {
                return this.g[i2];
            }
            i2 = this.f[i2];
            i3++;
        }
        return 0.0f;
    }

    @Override // defpackage.d3.a
    public boolean g(i3 i3Var) {
        int i2 = this.h;
        if (i2 == -1) {
            return false;
        }
        int i3 = 0;
        while (i2 != -1 && i3 < this.f511a) {
            if (this.e[i2] == i3Var.b) {
                return true;
            }
            i2 = this.f[i2];
            i3++;
        }
        return false;
    }

    @Override // defpackage.d3.a
    public float h(d3 d3Var, boolean z) {
        float f2 = f(d3Var.f781a);
        j(d3Var.f781a, z);
        d3.a aVar = d3Var.d;
        int a2 = aVar.a();
        for (int i2 = 0; i2 < a2; i2++) {
            i3 b2 = aVar.b(i2);
            e(b2, aVar.f(b2) * f2, z);
        }
        return f2;
    }

    @Override // defpackage.d3.a
    public final void i(i3 i3Var, float f2) {
        if (f2 == 0.0f) {
            j(i3Var, true);
            return;
        }
        int i2 = this.h;
        if (i2 == -1) {
            this.h = 0;
            this.g[0] = f2;
            this.e[0] = i3Var.b;
            this.f[0] = -1;
            i3Var.l++;
            i3Var.a(this.b);
            this.f511a++;
            if (!this.j) {
                int i3 = this.i + 1;
                this.i = i3;
                int[] iArr = this.e;
                if (i3 >= iArr.length) {
                    this.j = true;
                    this.i = iArr.length - 1;
                    return;
                }
                return;
            }
            return;
        }
        int i4 = 0;
        int i5 = -1;
        while (i2 != -1 && i4 < this.f511a) {
            int[] iArr2 = this.e;
            int i6 = iArr2[i2];
            int i7 = i3Var.b;
            if (i6 == i7) {
                this.g[i2] = f2;
                return;
            }
            if (iArr2[i2] < i7) {
                i5 = i2;
            }
            i2 = this.f[i2];
            i4++;
        }
        int i8 = this.i;
        int i9 = i8 + 1;
        if (this.j) {
            int[] iArr3 = this.e;
            if (iArr3[i8] != -1) {
                i8 = iArr3.length;
            }
        } else {
            i8 = i9;
        }
        int[] iArr4 = this.e;
        if (i8 >= iArr4.length && this.f511a < iArr4.length) {
            int i10 = 0;
            while (true) {
                int[] iArr5 = this.e;
                if (i10 >= iArr5.length) {
                    break;
                } else if (iArr5[i10] == -1) {
                    i8 = i10;
                    break;
                } else {
                    i10++;
                }
            }
        }
        int[] iArr6 = this.e;
        if (i8 >= iArr6.length) {
            i8 = iArr6.length;
            int i11 = this.d * 2;
            this.d = i11;
            this.j = false;
            this.i = i8 - 1;
            this.g = Arrays.copyOf(this.g, i11);
            this.e = Arrays.copyOf(this.e, this.d);
            this.f = Arrays.copyOf(this.f, this.d);
        }
        this.e[i8] = i3Var.b;
        this.g[i8] = f2;
        if (i5 != -1) {
            int[] iArr7 = this.f;
            iArr7[i8] = iArr7[i5];
            iArr7[i5] = i8;
        } else {
            this.f[i8] = this.h;
            this.h = i8;
        }
        i3Var.l++;
        i3Var.a(this.b);
        int i12 = this.f511a + 1;
        this.f511a = i12;
        if (!this.j) {
            this.i++;
        }
        int[] iArr8 = this.e;
        if (i12 >= iArr8.length) {
            this.j = true;
        }
        if (this.i >= iArr8.length) {
            this.j = true;
            this.i = iArr8.length - 1;
        }
    }

    @Override // defpackage.d3.a
    public final float j(i3 i3Var, boolean z) {
        int i2 = this.h;
        if (i2 == -1) {
            return 0.0f;
        }
        int i3 = 0;
        int i4 = -1;
        while (i2 != -1 && i3 < this.f511a) {
            if (this.e[i2] == i3Var.b) {
                if (i2 == this.h) {
                    this.h = this.f[i2];
                } else {
                    int[] iArr = this.f;
                    iArr[i4] = iArr[i2];
                }
                if (z) {
                    i3Var.b(this.b);
                }
                i3Var.l--;
                this.f511a--;
                this.e[i2] = -1;
                if (this.j) {
                    this.i = i2;
                }
                return this.g[i2];
            }
            i3++;
            i4 = i2;
            i2 = this.f[i2];
        }
        return 0.0f;
    }

    @Override // defpackage.d3.a
    public void k(float f2) {
        int i2 = this.h;
        int i3 = 0;
        while (i2 != -1 && i3 < this.f511a) {
            float[] fArr = this.g;
            fArr[i2] = fArr[i2] / f2;
            i2 = this.f[i2];
            i3++;
        }
    }

    public String toString() {
        int i2 = this.h;
        String str = "";
        int i3 = 0;
        while (i2 != -1 && i3 < this.f511a) {
            StringBuilder i0 = hj1.i0(hj1.S(str, " -> "));
            i0.append(this.g[i2]);
            i0.append(" : ");
            StringBuilder i02 = hj1.i0(i0.toString());
            i02.append(this.c.d[this.e[i2]]);
            str = i02.toString();
            i2 = this.f[i2];
            i3++;
        }
        return str;
    }
}
