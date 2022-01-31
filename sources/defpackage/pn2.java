package defpackage;

/* renamed from: pn2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class pn2 extends mn2 {
    public static int d(byte[] bArr, int i, long j, int i2) {
        if (i2 == 0) {
            mn2 mn2 = qn2.f2965a;
            if (i > -12) {
                return -1;
            }
            return i;
        } else if (i2 == 1) {
            byte v = ln2.v(bArr, j);
            mn2 mn22 = qn2.f2965a;
            if (i > -12 || v > -65) {
                return -1;
            }
            return i ^ (v << 8);
        } else if (i2 == 2) {
            return qn2.e(i, ln2.v(bArr, j), ln2.v(bArr, j + 1));
        } else {
            throw new AssertionError();
        }
    }

    @Override // defpackage.mn2
    public final int a(int i, byte[] bArr, int i2, int i3) {
        int i4;
        long j;
        int length = bArr.length;
        if ((i2 | i3 | (length - i3)) >= 0) {
            long j2 = (long) i2;
            int i5 = (int) (((long) i3) - j2);
            if (i5 >= 16) {
                long j3 = j2;
                i4 = 0;
                while (true) {
                    if (i4 >= i5) {
                        i4 = i5;
                        break;
                    }
                    long j4 = j3 + 1;
                    if (ln2.v(bArr, j3) < 0) {
                        break;
                    }
                    i4++;
                    j3 = j4;
                }
            } else {
                i4 = 0;
            }
            int i6 = i5 - i4;
            long j5 = j2 + ((long) i4);
            while (true) {
                byte b = 0;
                while (true) {
                    if (i6 <= 0) {
                        break;
                    }
                    long j6 = j5 + 1;
                    b = ln2.v(bArr, j5);
                    if (b < 0) {
                        j5 = j6;
                        break;
                    }
                    i6--;
                    j5 = j6;
                }
                if (i6 == 0) {
                    return 0;
                }
                int i7 = i6 - 1;
                if (b >= -32) {
                    if (b >= -16) {
                        if (i7 >= 3) {
                            i6 = i7 - 3;
                            long j7 = j5 + 1;
                            byte v = ln2.v(bArr, j5);
                            if (v > -65) {
                                break;
                            }
                            if ((((v + 112) + (b << 28)) >> 30) != 0) {
                                break;
                            }
                            long j8 = j7 + 1;
                            if (ln2.v(bArr, j7) > -65) {
                                break;
                            }
                            j = j8 + 1;
                            if (ln2.v(bArr, j8) > -65) {
                                break;
                            }
                        } else {
                            return d(bArr, b, j5, i7);
                        }
                    } else if (i7 >= 2) {
                        i6 = i7 - 2;
                        long j9 = j5 + 1;
                        byte v2 = ln2.v(bArr, j5);
                        if (v2 > -65 || ((b == -32 && v2 < -96) || (b == -19 && v2 >= -96))) {
                            break;
                        }
                        j5 = j9 + 1;
                        if (ln2.v(bArr, j9) > -65) {
                            break;
                        }
                    } else {
                        return d(bArr, b, j5, i7);
                    }
                } else if (i7 != 0) {
                    i6 = i7 - 1;
                    if (b < -62) {
                        break;
                    }
                    j = j5 + 1;
                    if (ln2.v(bArr, j5) > -65) {
                        break;
                    }
                } else {
                    return b;
                }
                j5 = j;
            }
            return -1;
        }
        throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", Integer.valueOf(length), Integer.valueOf(i2), Integer.valueOf(i3)));
    }

    @Override // defpackage.mn2
    public final String b(byte[] bArr, int i, int i2) throws ma3 {
        int length = bArr.length;
        if ((i | i2 | ((length - i) - i2)) >= 0) {
            int i3 = i + i2;
            char[] cArr = new char[i2];
            int i4 = 0;
            while (i < i3) {
                byte v = ln2.v(bArr, (long) i);
                if (!gj1.f1(v)) {
                    break;
                }
                i++;
                cArr[i4] = (char) v;
                i4++;
            }
            while (i < i3) {
                int i5 = i + 1;
                byte v2 = ln2.v(bArr, (long) i);
                if (gj1.f1(v2)) {
                    int i6 = i4 + 1;
                    cArr[i4] = (char) v2;
                    i = i5;
                    while (true) {
                        i4 = i6;
                        if (i >= i3) {
                            break;
                        }
                        byte v3 = ln2.v(bArr, (long) i);
                        if (!gj1.f1(v3)) {
                            break;
                        }
                        i++;
                        i6 = i4 + 1;
                        cArr[i4] = (char) v3;
                    }
                } else {
                    if (!(v2 < -32)) {
                        if (v2 < -16) {
                            if (i5 < i3 - 1) {
                                int i7 = i5 + 1;
                                gj1.W1(v2, ln2.v(bArr, (long) i5), ln2.v(bArr, (long) i7), cArr, i4);
                                i = i7 + 1;
                                i4++;
                            } else {
                                throw ma3.g();
                            }
                        } else if (i5 < i3 - 2) {
                            int i8 = i5 + 1;
                            int i9 = i8 + 1;
                            gj1.Z1(v2, ln2.v(bArr, (long) i5), ln2.v(bArr, (long) i8), ln2.v(bArr, (long) i9), cArr, i4);
                            i4 += 2;
                            i = i9 + 1;
                        } else {
                            throw ma3.g();
                        }
                    } else if (i5 < i3) {
                        gj1.G1(v2, ln2.v(bArr, (long) i5), cArr, i4);
                        i = i5 + 1;
                        i4++;
                    } else {
                        throw ma3.g();
                    }
                }
            }
            return new String(cArr, 0, i4);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(i), Integer.valueOf(i2)));
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0031 A[LOOP:1: B:11:0x0031->B:36:0x00f6, LOOP_START, PHI: r2 r3 r4 r11 
      PHI: (r2v3 int) = (r2v2 int), (r2v5 int) binds: [B:10:0x002f, B:36:0x00f6] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r3v2 char) = (r3v1 char), (r3v3 char) binds: [B:10:0x002f, B:36:0x00f6] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r4v3 long) = (r4v2 long), (r4v5 long) binds: [B:10:0x002f, B:36:0x00f6] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r11v3 long) = (r11v2 long), (r11v4 long) binds: [B:10:0x002f, B:36:0x00f6] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0141  */
    @Override // defpackage.mn2
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int c(java.lang.CharSequence r23, byte[] r24, int r25, int r26) {
        /*
        // Method dump skipped, instructions count: 360
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.pn2.c(java.lang.CharSequence, byte[], int, int):int");
    }
}
