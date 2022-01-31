package defpackage;

/* renamed from: de  reason: default package */
/* compiled from: Utf8 */
public final class de {

    /* renamed from: a  reason: collision with root package name */
    public static final a f823a = ((!(ce.h && ce.g) || qb.a()) ? new b() : new d());

    /* renamed from: de$a */
    /* compiled from: Utf8 */
    public static abstract class a {
        public abstract String a(byte[] bArr, int i, int i2) throws nc;

        public abstract int b(CharSequence charSequence, byte[] bArr, int i, int i2);

        public abstract int c(int i, byte[] bArr, int i2, int i3);
    }

    /* renamed from: de$b */
    /* compiled from: Utf8 */
    public static final class b extends a {
        @Override // defpackage.de.a
        public String a(byte[] bArr, int i, int i2) throws nc {
            if ((i | i2 | ((bArr.length - i) - i2)) >= 0) {
                int i3 = i + i2;
                char[] cArr = new char[i2];
                int i4 = 0;
                while (i < i3) {
                    byte b = bArr[i];
                    if (!h.b(b)) {
                        break;
                    }
                    i++;
                    cArr[i4] = (char) b;
                    i4++;
                }
                int i5 = i4;
                while (i < i3) {
                    int i6 = i + 1;
                    byte b2 = bArr[i];
                    if (h.b(b2)) {
                        int i7 = i5 + 1;
                        cArr[i5] = (char) b2;
                        i = i6;
                        while (true) {
                            i5 = i7;
                            if (i >= i3) {
                                break;
                            }
                            byte b3 = bArr[i];
                            if (!h.b(b3)) {
                                break;
                            }
                            i++;
                            i7 = i5 + 1;
                            cArr[i5] = (char) b3;
                        }
                    } else {
                        if (!(b2 < -32)) {
                            if (b2 < -16) {
                                if (i6 < i3 - 1) {
                                    int i8 = i6 + 1;
                                    h.d(b2, bArr[i6], bArr[i8], cArr, i5);
                                    i = i8 + 1;
                                    i5++;
                                } else {
                                    throw nc.b();
                                }
                            } else if (i6 < i3 - 2) {
                                int i9 = i6 + 1;
                                byte b4 = bArr[i6];
                                int i10 = i9 + 1;
                                h.a(b2, b4, bArr[i9], bArr[i10], cArr, i5);
                                i5 = i5 + 1 + 1;
                                i = i10 + 1;
                            } else {
                                throw nc.b();
                            }
                        } else if (i6 < i3) {
                            h.c(b2, bArr[i6], cArr, i5);
                            i = i6 + 1;
                            i5++;
                        } else {
                            throw nc.b();
                        }
                    }
                }
                return new String(cArr, 0, i5);
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
        }

        @Override // defpackage.de.a
        public int b(CharSequence charSequence, byte[] bArr, int i, int i2) {
            int i3;
            int i4;
            int i5;
            char charAt;
            int length = charSequence.length();
            int i6 = i2 + i;
            int i7 = 0;
            while (i7 < length && (i5 = i7 + i) < i6 && (charAt = charSequence.charAt(i7)) < 128) {
                bArr[i5] = (byte) charAt;
                i7++;
            }
            if (i7 == length) {
                return i + length;
            }
            int i8 = i + i7;
            while (i7 < length) {
                char charAt2 = charSequence.charAt(i7);
                if (charAt2 < 128 && i8 < i6) {
                    i4 = i8 + 1;
                    bArr[i8] = (byte) charAt2;
                } else if (charAt2 < 2048 && i8 <= i6 - 2) {
                    int i9 = i8 + 1;
                    bArr[i8] = (byte) ((charAt2 >>> 6) | 960);
                    i8 = i9 + 1;
                    bArr[i9] = (byte) ((charAt2 & '?') | 128);
                    i7++;
                } else if ((charAt2 < 55296 || 57343 < charAt2) && i8 <= i6 - 3) {
                    int i10 = i8 + 1;
                    bArr[i8] = (byte) ((charAt2 >>> '\f') | 480);
                    int i11 = i10 + 1;
                    bArr[i10] = (byte) (((charAt2 >>> 6) & 63) | 128);
                    i4 = i11 + 1;
                    bArr[i11] = (byte) ((charAt2 & '?') | 128);
                } else if (i8 <= i6 - 4) {
                    int i12 = i7 + 1;
                    if (i12 != charSequence.length()) {
                        char charAt3 = charSequence.charAt(i12);
                        if (Character.isSurrogatePair(charAt2, charAt3)) {
                            int codePoint = Character.toCodePoint(charAt2, charAt3);
                            int i13 = i8 + 1;
                            bArr[i8] = (byte) ((codePoint >>> 18) | 240);
                            int i14 = i13 + 1;
                            bArr[i13] = (byte) (((codePoint >>> 12) & 63) | 128);
                            int i15 = i14 + 1;
                            bArr[i14] = (byte) (((codePoint >>> 6) & 63) | 128);
                            i8 = i15 + 1;
                            bArr[i15] = (byte) ((codePoint & 63) | 128);
                            i7 = i12;
                            i7++;
                        } else {
                            i7 = i12;
                        }
                    }
                    throw new c(i7 - 1, length);
                } else if (55296 > charAt2 || charAt2 > 57343 || ((i3 = i7 + 1) != charSequence.length() && Character.isSurrogatePair(charAt2, charSequence.charAt(i3)))) {
                    throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + i8);
                } else {
                    throw new c(i7, length);
                }
                i8 = i4;
                i7++;
            }
            return i8;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0047, code lost:
            if (r13[r14] > -65) goto L_0x0049;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x0082, code lost:
            if (r13[r14] > -65) goto L_0x0084;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x001c, code lost:
            if (r13[r14] > -65) goto L_0x0022;
         */
        @Override // defpackage.de.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int c(int r12, byte[] r13, int r14, int r15) {
            /*
            // Method dump skipped, instructions count: 242
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.de.b.c(int, byte[], int, int):int");
        }
    }

    /* renamed from: de$c */
    /* compiled from: Utf8 */
    public static class c extends IllegalArgumentException {
        public c(int i, int i2) {
            super(hj1.L("Unpaired surrogate at index ", i, " of ", i2));
        }
    }

    /* renamed from: de$d */
    /* compiled from: Utf8 */
    public static final class d extends a {
        public static int d(byte[] bArr, int i, long j, int i2) {
            if (i2 == 0) {
                a aVar = de.f823a;
                if (i > -12) {
                    return -1;
                }
                return i;
            } else if (i2 == 1) {
                return de.a(i, ce.g(bArr, j));
            } else {
                if (i2 == 2) {
                    return de.e(i, ce.g(bArr, j), ce.g(bArr, j + 1));
                }
                throw new AssertionError();
            }
        }

        @Override // defpackage.de.a
        public String a(byte[] bArr, int i, int i2) throws nc {
            if ((i | i2 | ((bArr.length - i) - i2)) >= 0) {
                int i3 = i + i2;
                char[] cArr = new char[i2];
                int i4 = 0;
                while (i < i3) {
                    byte g = ce.g(bArr, (long) i);
                    if (!h.b(g)) {
                        break;
                    }
                    i++;
                    cArr[i4] = (char) g;
                    i4++;
                }
                int i5 = i4;
                while (i < i3) {
                    int i6 = i + 1;
                    byte g2 = ce.g(bArr, (long) i);
                    if (h.b(g2)) {
                        int i7 = i5 + 1;
                        cArr[i5] = (char) g2;
                        i = i6;
                        while (true) {
                            i5 = i7;
                            if (i >= i3) {
                                break;
                            }
                            byte g3 = ce.g(bArr, (long) i);
                            if (!h.b(g3)) {
                                break;
                            }
                            i++;
                            i7 = i5 + 1;
                            cArr[i5] = (char) g3;
                        }
                    } else {
                        if (!(g2 < -32)) {
                            if (g2 < -16) {
                                if (i6 < i3 - 1) {
                                    int i8 = i6 + 1;
                                    h.d(g2, ce.g(bArr, (long) i6), ce.g(bArr, (long) i8), cArr, i5);
                                    i = i8 + 1;
                                    i5++;
                                } else {
                                    throw nc.b();
                                }
                            } else if (i6 < i3 - 2) {
                                int i9 = i6 + 1;
                                int i10 = i9 + 1;
                                h.a(g2, ce.g(bArr, (long) i6), ce.g(bArr, (long) i9), ce.g(bArr, (long) i10), cArr, i5);
                                i5 = i5 + 1 + 1;
                                i = i10 + 1;
                            } else {
                                throw nc.b();
                            }
                        } else if (i6 < i3) {
                            h.c(g2, ce.g(bArr, (long) i6), cArr, i5);
                            i = i6 + 1;
                            i5++;
                        } else {
                            throw nc.b();
                        }
                    }
                }
                return new String(cArr, 0, i5);
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x0031  */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x0033 A[LOOP:1: B:13:0x0033->B:38:0x00ec, LOOP_START, PHI: r2 r3 r4 r11 
          PHI: (r2v3 int) = (r2v2 int), (r2v5 int) binds: [B:10:0x002f, B:38:0x00ec] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r3v2 char) = (r3v1 char), (r3v3 char) binds: [B:10:0x002f, B:38:0x00ec] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r4v3 long) = (r4v2 long), (r4v4 long) binds: [B:10:0x002f, B:38:0x00ec] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r11v3 long) = (r11v2 long), (r11v4 long) binds: [B:10:0x002f, B:38:0x00ec] A[DONT_GENERATE, DONT_INLINE]] */
        @Override // defpackage.de.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int b(java.lang.CharSequence r19, byte[] r20, int r21, int r22) {
            /*
            // Method dump skipped, instructions count: 335
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.de.d.b(java.lang.CharSequence, byte[], int, int):int");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0036, code lost:
            if (defpackage.ce.g(r25, r8) > -65) goto L_0x003d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0067, code lost:
            if (defpackage.ce.g(r25, r8) > -65) goto L_0x0069;
         */
        @Override // defpackage.de.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int c(int r24, byte[] r25, int r26, int r27) {
            /*
            // Method dump skipped, instructions count: 374
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.de.d.c(int, byte[], int, int):int");
        }
    }

    public static int a(int i, int i2) {
        if (i > -12 || i2 > -65) {
            return -1;
        }
        return i ^ (i2 << 8);
    }

    public static int b(byte[] bArr, int i, int i2) {
        byte b2 = bArr[i - 1];
        int i3 = i2 - i;
        int i4 = -1;
        if (i3 == 0) {
            if (b2 > -12) {
                b2 = -1;
            }
            return b2;
        } else if (i3 == 1) {
            byte b3 = bArr[i];
            if (b2 <= -12 && b3 <= -65) {
                i4 = b2 ^ (b3 << 8);
            }
            return i4;
        } else if (i3 == 2) {
            return e(b2, bArr[i], bArr[i + 1]);
        } else {
            throw new AssertionError();
        }
    }

    public static int c(CharSequence charSequence, byte[] bArr, int i, int i2) {
        return f823a.b(charSequence, bArr, i, i2);
    }

    public static int d(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        int i2 = 0;
        while (i2 < length && charSequence.charAt(i2) < 128) {
            i2++;
        }
        int i3 = length;
        while (true) {
            if (i2 >= length) {
                break;
            }
            char charAt = charSequence.charAt(i2);
            if (charAt < 2048) {
                i3 += (127 - charAt) >>> 31;
                i2++;
            } else {
                int length2 = charSequence.length();
                while (i2 < length2) {
                    char charAt2 = charSequence.charAt(i2);
                    if (charAt2 < 2048) {
                        i += (127 - charAt2) >>> 31;
                    } else {
                        i += 2;
                        if (55296 <= charAt2 && charAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i2) >= 65536) {
                                i2++;
                            } else {
                                throw new c(i2, length2);
                            }
                        }
                    }
                    i2++;
                }
                i3 += i;
            }
        }
        if (i3 >= length) {
            return i3;
        }
        StringBuilder i0 = hj1.i0("UTF-8 length does not fit in int: ");
        i0.append(((long) i3) + 4294967296L);
        throw new IllegalArgumentException(i0.toString());
    }

    public static int e(int i, int i2, int i3) {
        if (i > -12 || i2 > -65 || i3 > -65) {
            return -1;
        }
        return (i ^ (i2 << 8)) ^ (i3 << 16);
    }
}
