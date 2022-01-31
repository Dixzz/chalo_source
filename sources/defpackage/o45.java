package defpackage;

/* renamed from: o45  reason: default package */
/* compiled from: WhiteRectangleDetector */
public final class o45 {

    /* renamed from: a  reason: collision with root package name */
    public final f45 f2651a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;

    public o45(f45 f45, int i, int i2, int i3) throws a35 {
        this.f2651a = f45;
        int i4 = f45.g;
        this.b = i4;
        int i5 = f45.f;
        this.c = i5;
        int i6 = i / 2;
        int i7 = i2 - i6;
        this.d = i7;
        int i8 = i2 + i6;
        this.e = i8;
        int i9 = i3 - i6;
        this.g = i9;
        int i10 = i3 + i6;
        this.f = i10;
        if (i9 < 0 || i7 < 0 || i10 >= i4 || i8 >= i5) {
            throw a35.h;
        }
    }

    public final boolean a(int i, int i2, int i3, boolean z) {
        if (z) {
            while (i <= i2) {
                if (this.f2651a.b(i, i3)) {
                    return true;
                }
                i++;
            }
            return false;
        }
        while (i <= i2) {
            if (this.f2651a.b(i3, i)) {
                return true;
            }
            i++;
        }
        return false;
    }

    public g35[] b() throws a35 {
        boolean z;
        int i = this.d;
        int i2 = this.e;
        int i3 = this.g;
        int i4 = this.f;
        boolean z2 = true;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        while (true) {
            if (!z2) {
                z = false;
                break;
            }
            boolean z8 = true;
            boolean z9 = false;
            while (true) {
                if ((z8 || !z3) && i2 < this.c) {
                    z8 = a(i3, i4, i2, false);
                    if (z8) {
                        i2++;
                        z3 = true;
                        z9 = true;
                    } else if (!z3) {
                        i2++;
                    }
                }
            }
            if (i2 >= this.c) {
                break;
            }
            boolean z10 = true;
            while (true) {
                if ((z10 || !z4) && i4 < this.b) {
                    z10 = a(i, i2, i4, true);
                    if (z10) {
                        i4++;
                        z4 = true;
                        z9 = true;
                    } else if (!z4) {
                        i4++;
                    }
                }
            }
            if (i4 >= this.b) {
                break;
            }
            boolean z11 = true;
            while (true) {
                if ((z11 || !z5) && i >= 0) {
                    z11 = a(i3, i4, i, false);
                    if (z11) {
                        i--;
                        z5 = true;
                        z9 = true;
                    } else if (!z5) {
                        i--;
                    }
                }
            }
            if (i < 0) {
                break;
            }
            z2 = z9;
            boolean z12 = true;
            while (true) {
                if ((z12 || !z7) && i3 >= 0) {
                    z12 = a(i, i2, i3, true);
                    if (z12) {
                        i3--;
                        z2 = true;
                        z7 = true;
                    } else if (!z7) {
                        i3--;
                    }
                }
            }
            if (i3 < 0) {
                break;
            } else if (z2) {
                z6 = true;
            }
        }
        z = true;
        if (z || !z6) {
            throw a35.h;
        }
        int i5 = i2 - i;
        g35 g35 = null;
        g35 g352 = null;
        int i6 = 1;
        while (g352 == null && i6 < i5) {
            g352 = c((float) i, (float) (i4 - i6), (float) (i + i6), (float) i4);
            i6++;
        }
        if (g352 != null) {
            g35 g353 = null;
            int i7 = 1;
            while (g353 == null && i7 < i5) {
                g353 = c((float) i, (float) (i3 + i7), (float) (i + i7), (float) i3);
                i7++;
            }
            if (g353 != null) {
                g35 g354 = null;
                int i8 = 1;
                while (g354 == null && i8 < i5) {
                    g354 = c((float) i2, (float) (i3 + i8), (float) (i2 - i8), (float) i3);
                    i8++;
                }
                if (g354 != null) {
                    int i9 = 1;
                    while (g35 == null && i9 < i5) {
                        g35 = c((float) i2, (float) (i4 - i9), (float) (i2 - i9), (float) i4);
                        i9++;
                    }
                    if (g35 != null) {
                        float f2 = g35.f1210a;
                        float f3 = g35.b;
                        float f4 = g352.f1210a;
                        float f5 = g352.b;
                        float f6 = g354.f1210a;
                        float f7 = g354.b;
                        float f8 = g353.f1210a;
                        float f9 = g353.b;
                        if (f2 < ((float) this.c) / 2.0f) {
                            return new g35[]{new g35(f8 - 1.0f, f9 + 1.0f), new g35(f4 + 1.0f, f5 + 1.0f), new g35(f6 - 1.0f, f7 - 1.0f), new g35(f2 + 1.0f, f3 - 1.0f)};
                        }
                        return new g35[]{new g35(f8 + 1.0f, f9 + 1.0f), new g35(f4 + 1.0f, f5 - 1.0f), new g35(f6 - 1.0f, f7 + 1.0f), new g35(f2 - 1.0f, f3 - 1.0f)};
                    }
                    throw a35.h;
                }
                throw a35.h;
            }
            throw a35.h;
        }
        throw a35.h;
    }

    public final g35 c(float f2, float f3, float f4, float f5) {
        int I2 = hd3.I2(hd3.G0(f2, f3, f4, f5));
        float f6 = (float) I2;
        float f7 = (f4 - f2) / f6;
        float f8 = (f5 - f3) / f6;
        for (int i = 0; i < I2; i++) {
            float f9 = (float) i;
            int I22 = hd3.I2((f9 * f7) + f2);
            int I23 = hd3.I2((f9 * f8) + f3);
            if (this.f2651a.b(I22, I23)) {
                return new g35((float) I22, (float) I23);
            }
        }
        return null;
    }
}
