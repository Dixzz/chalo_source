package defpackage;

/* renamed from: f85  reason: default package */
/* compiled from: DetectionResult */
public final class f85 {

    /* renamed from: a  reason: collision with root package name */
    public final a85 f1102a;
    public final g85[] b;
    public c85 c;
    public final int d;

    public f85(a85 a85, c85 c85) {
        this.f1102a = a85;
        int i = a85.f135a;
        this.d = i;
        this.c = c85;
        this.b = new g85[(i + 2)];
    }

    public static int b(int i, int i2, d85 d85) {
        if (d85.a()) {
            return i2;
        }
        if (!(i != -1 && d85.c == (i % 3) * 3)) {
            return i2 + 1;
        }
        d85.e = i;
        return 0;
    }

    public final void a(g85 g85) {
        g35 g35;
        g35 g352;
        int i;
        if (g85 != null) {
            h85 h85 = (h85) g85;
            a85 a85 = this.f1102a;
            d85[] d85Arr = h85.b;
            for (d85 d85 : d85Arr) {
                if (d85 != null) {
                    d85.b();
                }
            }
            h85.d(d85Arr, a85);
            c85 c85 = h85.f1226a;
            boolean z = h85.c;
            if (z) {
                g35 = c85.b;
            } else {
                g35 = c85.d;
            }
            if (z) {
                g352 = c85.c;
            } else {
                g352 = c85.e;
            }
            int b2 = h85.b((int) g35.b);
            int b3 = h85.b((int) g352.b);
            int i2 = -1;
            int i3 = 0;
            int i4 = 1;
            while (b2 < b3) {
                if (d85Arr[b2] != null) {
                    d85 d852 = d85Arr[b2];
                    int i5 = d852.e;
                    int i6 = i5 - i2;
                    if (i6 == 0) {
                        i3++;
                    } else {
                        if (i6 == 1) {
                            int max = Math.max(i4, i3);
                            i = d852.e;
                            i4 = max;
                        } else if (i6 < 0 || i5 >= a85.e || i6 > b2) {
                            d85Arr[b2] = null;
                        } else {
                            if (i4 > 2) {
                                i6 *= i4 - 2;
                            }
                            boolean z2 = i6 >= b2;
                            for (int i7 = 1; i7 <= i6 && !z2; i7++) {
                                z2 = d85Arr[b2 - i7] != null;
                            }
                            if (z2) {
                                d85Arr[b2] = null;
                            } else {
                                i = d852.e;
                            }
                        }
                        i2 = i;
                        i3 = 1;
                    }
                }
                b2++;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0076, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x007b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x007c, code lost:
        r1.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x007f, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toString() {
        /*
        // Method dump skipped, instructions count: 128
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.f85.toString():java.lang.String");
    }
}
