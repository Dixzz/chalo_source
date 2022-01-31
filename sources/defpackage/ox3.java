package defpackage;

/* renamed from: ox3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class ox3 extends nx3 {
    public static int d(byte[] bArr, int i, long j, int i2) {
        if (i2 == 0) {
            nx3 nx3 = lx3.f2290a;
            if (i > -12) {
                return -1;
            }
            return i;
        } else if (i2 == 1) {
            byte a2 = kx3.a(bArr, j);
            nx3 nx32 = lx3.f2290a;
            if (i > -12 || a2 > -65) {
                return -1;
            }
            return i ^ (a2 << 8);
        } else if (i2 == 2) {
            return lx3.c(i, kx3.a(bArr, j), kx3.a(bArr, j + 1));
        } else {
            throw new AssertionError();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0061, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00b6, code lost:
        return -1;
     */
    @Override // defpackage.nx3
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(int r16, byte[] r17, int r18, int r19) {
        /*
        // Method dump skipped, instructions count: 217
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ox3.a(int, byte[], int, int):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0033 A[LOOP:1: B:13:0x0033->B:38:0x00fb, LOOP_START, PHI: r2 r3 r4 r11 
      PHI: (r2v4 int) = (r2v3 int), (r2v6 int) binds: [B:10:0x002f, B:38:0x00fb] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r3v3 char) = (r3v2 char), (r3v4 char) binds: [B:10:0x002f, B:38:0x00fb] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r4v3 long) = (r4v2 long), (r4v5 long) binds: [B:10:0x002f, B:38:0x00fb] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r11v3 long) = (r11v2 long), (r11v4 long) binds: [B:10:0x002f, B:38:0x00fb] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // defpackage.nx3
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int b(java.lang.CharSequence r23, byte[] r24, int r25, int r26) {
        /*
        // Method dump skipped, instructions count: 362
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ox3.b(java.lang.CharSequence, byte[], int, int):int");
    }

    @Override // defpackage.nx3
    public final String c(byte[] bArr, int i, int i2) throws cv3 {
        if ((i | i2 | ((bArr.length - i) - i2)) >= 0) {
            int i3 = i + i2;
            char[] cArr = new char[i2];
            int i4 = 0;
            while (i < i3) {
                byte a2 = kx3.a(bArr, (long) i);
                if (!hd3.R3(a2)) {
                    break;
                }
                i++;
                cArr[i4] = (char) a2;
                i4++;
            }
            int i5 = i4;
            while (i < i3) {
                int i6 = i + 1;
                byte a3 = kx3.a(bArr, (long) i);
                if (hd3.R3(a3)) {
                    int i7 = i5 + 1;
                    cArr[i5] = (char) a3;
                    i = i6;
                    while (true) {
                        i5 = i7;
                        if (i >= i3) {
                            break;
                        }
                        byte a4 = kx3.a(bArr, (long) i);
                        if (!hd3.R3(a4)) {
                            break;
                        }
                        i++;
                        i7 = i5 + 1;
                        cArr[i5] = (char) a4;
                    }
                } else {
                    if (!(a3 < -32)) {
                        if (a3 < -16) {
                            if (i6 < i3 - 1) {
                                int i8 = i6 + 1;
                                hd3.J3(a3, kx3.a(bArr, (long) i6), kx3.a(bArr, (long) i8), cArr, i5);
                                i = i8 + 1;
                                i5++;
                            } else {
                                throw cv3.e();
                            }
                        } else if (i6 < i3 - 2) {
                            int i9 = i6 + 1;
                            int i10 = i9 + 1;
                            hd3.I3(a3, kx3.a(bArr, (long) i6), kx3.a(bArr, (long) i9), kx3.a(bArr, (long) i10), cArr, i5);
                            i5 = i5 + 1 + 1;
                            i = i10 + 1;
                        } else {
                            throw cv3.e();
                        }
                    } else if (i6 < i3) {
                        hd3.K3(a3, kx3.a(bArr, (long) i6), cArr, i5);
                        i = i6 + 1;
                        i5++;
                    } else {
                        throw cv3.e();
                    }
                }
            }
            return new String(cArr, 0, i5);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
    }
}
