package defpackage;

/* renamed from: h85  reason: default package */
/* compiled from: DetectionResultRowIndicatorColumn */
public final class h85 extends g85 {
    public final boolean c;

    public h85(c85 c85, boolean z) {
        super(c85);
        this.c = z;
    }

    public a85 c() {
        d85[] d85Arr = this.b;
        b85 b85 = new b85();
        b85 b852 = new b85();
        b85 b853 = new b85();
        b85 b854 = new b85();
        for (d85 d85 : d85Arr) {
            if (d85 != null) {
                d85.b();
                int i = d85.d % 30;
                int i2 = d85.e;
                if (!this.c) {
                    i2 += 2;
                }
                int i3 = i2 % 3;
                if (i3 == 0) {
                    b852.b((i * 3) + 1);
                } else if (i3 == 1) {
                    b854.b(i / 3);
                    b853.b(i % 3);
                } else if (i3 == 2) {
                    b85.b(i + 1);
                }
            }
        }
        if (b85.a().length == 0 || b852.a().length == 0 || b853.a().length == 0 || b854.a().length == 0 || b85.a()[0] <= 0 || b852.a()[0] + b853.a()[0] < 3 || b852.a()[0] + b853.a()[0] > 90) {
            return null;
        }
        a85 a85 = new a85(b85.a()[0], b852.a()[0], b853.a()[0], b854.a()[0]);
        d(d85Arr, a85);
        return a85;
    }

    public final void d(d85[] d85Arr, a85 a85) {
        for (int i = 0; i < d85Arr.length; i++) {
            d85 d85 = d85Arr[i];
            if (d85Arr[i] != null) {
                int i2 = d85.d % 30;
                int i3 = d85.e;
                if (i3 > a85.e) {
                    d85Arr[i] = null;
                } else {
                    if (!this.c) {
                        i3 += 2;
                    }
                    int i4 = i3 % 3;
                    if (i4 != 0) {
                        if (i4 != 1) {
                            if (i4 == 2 && i2 + 1 != a85.f135a) {
                                d85Arr[i] = null;
                            }
                        } else if (i2 / 3 != a85.b || i2 % 3 != a85.d) {
                            d85Arr[i] = null;
                        }
                    } else if ((i2 * 3) + 1 != a85.c) {
                        d85Arr[i] = null;
                    }
                }
            }
        }
    }

    @Override // defpackage.g85
    public String toString() {
        return "IsLeft: " + this.c + '\n' + super.toString();
    }
}
