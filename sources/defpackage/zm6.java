package defpackage;

import java.io.Serializable;
import java.security.MessageDigest;
import java.util.Arrays;

/* renamed from: zm6  reason: default package */
/* compiled from: ByteString.kt */
public class zm6 implements Serializable, Comparable<zm6> {
    public static final zm6 i = new zm6(new byte[0]);
    public static final a j = new a(null);
    public transient int f;
    public transient String g;
    public final byte[] h;

    /* renamed from: zm6$a */
    /* compiled from: ByteString.kt */
    public static final class a {
        public a(j86 j86) {
        }

        public static zm6 d(a aVar, byte[] bArr, int i, int i2, int i3) {
            if ((i3 & 1) != 0) {
                i = 0;
            }
            if ((i3 & 2) != 0) {
                i2 = bArr.length;
            }
            n86.f(bArr, "$this$toByteString");
            ec6.l((long) bArr.length, (long) i, (long) i2);
            return new zm6(y56.e(bArr, i, i2 + i));
        }

        public final zm6 a(String str) {
            int i;
            int i2;
            n86.f(str, "$this$decodeBase64");
            byte[] bArr = qm6.f2962a;
            n86.f(str, "$this$decodeBase64ToArray");
            int length = str.length();
            while (length > 0 && ((r7 = str.charAt(length - 1)) == '=' || r7 == '\n' || r7 == '\r' || r7 == ' ' || r7 == '\t')) {
                length = i2;
            }
            int i3 = (int) ((((long) length) * 6) / 8);
            byte[] bArr2 = new byte[i3];
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            while (true) {
                if (i4 < length) {
                    char charAt = str.charAt(i4);
                    if ('A' <= charAt && 'Z' >= charAt) {
                        i = charAt - 'A';
                    } else if ('a' <= charAt && 'z' >= charAt) {
                        i = charAt - 'G';
                    } else if ('0' <= charAt && '9' >= charAt) {
                        i = charAt + 4;
                    } else if (charAt == '+' || charAt == '-') {
                        i = 62;
                    } else if (charAt == '/' || charAt == '_') {
                        i = 63;
                    } else {
                        if (!(charAt == '\n' || charAt == '\r' || charAt == ' ' || charAt == '\t')) {
                            break;
                        }
                        i4++;
                    }
                    i6 = (i6 << 6) | i;
                    i5++;
                    if (i5 % 4 == 0) {
                        int i8 = i7 + 1;
                        bArr2[i7] = (byte) (i6 >> 16);
                        int i9 = i8 + 1;
                        bArr2[i8] = (byte) (i6 >> 8);
                        bArr2[i9] = (byte) i6;
                        i7 = i9 + 1;
                    }
                    i4++;
                } else {
                    int i10 = i5 % 4;
                    if (i10 != 1) {
                        if (i10 == 2) {
                            bArr2[i7] = (byte) ((i6 << 12) >> 16);
                            i7++;
                        } else if (i10 == 3) {
                            int i11 = i6 << 6;
                            int i12 = i7 + 1;
                            bArr2[i7] = (byte) (i11 >> 16);
                            i7 = i12 + 1;
                            bArr2[i12] = (byte) (i11 >> 8);
                        }
                        if (i7 != i3) {
                            bArr2 = Arrays.copyOf(bArr2, i7);
                            n86.b(bArr2, "java.util.Arrays.copyOf(this, newSize)");
                        }
                    }
                }
            }
            bArr2 = null;
            if (bArr2 != null) {
                return new zm6(bArr2);
            }
            return null;
        }

        public final zm6 b(String str) {
            n86.f(str, "$this$decodeHex");
            if (str.length() % 2 == 0) {
                int length = str.length() / 2;
                byte[] bArr = new byte[length];
                for (int i = 0; i < length; i++) {
                    int i2 = i * 2;
                    bArr[i] = (byte) (tn6.a(str.charAt(i2 + 1)) + (tn6.a(str.charAt(i2)) << 4));
                }
                return new zm6(bArr);
            }
            throw new IllegalArgumentException(hj1.S("Unexpected hex string: ", str).toString());
        }

        public final zm6 c(String str) {
            n86.f(str, "$this$encodeUtf8");
            n86.f(str, "$this$asUtf8ToByteArray");
            byte[] bytes = str.getBytes(aa6.f144a);
            n86.b(bytes, "(this as java.lang.String).getBytes(charset)");
            zm6 zm6 = new zm6(bytes);
            zm6.g = str;
            return zm6;
        }
    }

    public zm6(byte[] bArr) {
        n86.f(bArr, "data");
        this.h = bArr;
    }

    public static final zm6 f(String str) {
        n86.f(str, "$this$encodeUtf8");
        n86.f(str, "$this$asUtf8ToByteArray");
        byte[] bytes = str.getBytes(aa6.f144a);
        n86.b(bytes, "(this as java.lang.String).getBytes(charset)");
        zm6 zm6 = new zm6(bytes);
        zm6.g = str;
        return zm6;
    }

    public String a() {
        byte[] bArr = this.h;
        byte[] bArr2 = qm6.f2962a;
        byte[] bArr3 = qm6.f2962a;
        n86.f(bArr, "$this$encodeBase64");
        n86.f(bArr3, "map");
        byte[] bArr4 = new byte[(((bArr.length + 2) / 3) * 4)];
        int length = bArr.length - (bArr.length % 3);
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int i4 = i2 + 1;
            byte b = bArr[i2];
            int i5 = i4 + 1;
            byte b2 = bArr[i4];
            int i6 = i5 + 1;
            byte b3 = bArr[i5];
            int i7 = i3 + 1;
            bArr4[i3] = bArr3[(b & 255) >> 2];
            int i8 = i7 + 1;
            bArr4[i7] = bArr3[((b & 3) << 4) | ((b2 & 255) >> 4)];
            int i9 = i8 + 1;
            bArr4[i8] = bArr3[((b2 & 15) << 2) | ((b3 & 255) >> 6)];
            i3 = i9 + 1;
            bArr4[i9] = bArr3[b3 & 63];
            i2 = i6;
        }
        int length2 = bArr.length - length;
        if (length2 == 1) {
            byte b4 = bArr[i2];
            int i10 = i3 + 1;
            bArr4[i3] = bArr3[(b4 & 255) >> 2];
            int i11 = i10 + 1;
            bArr4[i10] = bArr3[(b4 & 3) << 4];
            byte b5 = (byte) 61;
            bArr4[i11] = b5;
            bArr4[i11 + 1] = b5;
        } else if (length2 == 2) {
            int i12 = i2 + 1;
            byte b6 = bArr[i2];
            byte b7 = bArr[i12];
            int i13 = i3 + 1;
            bArr4[i3] = bArr3[(b6 & 255) >> 2];
            int i14 = i13 + 1;
            bArr4[i13] = bArr3[((b6 & 3) << 4) | ((b7 & 255) >> 4)];
            bArr4[i14] = bArr3[(b7 & 15) << 2];
            bArr4[i14 + 1] = (byte) 61;
        }
        n86.f(bArr4, "$this$toUtf8String");
        return new String(bArr4, aa6.f144a);
    }

    public zm6 c(String str) {
        n86.f(str, "algorithm");
        byte[] digest = MessageDigest.getInstance(str).digest(this.h);
        n86.b(digest, "MessageDigest.getInstance(algorithm).digest(data)");
        return new zm6(digest);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0030 A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0032 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    @Override // java.lang.Comparable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int compareTo(defpackage.zm6 r8) {
        /*
            r7 = this;
            zm6 r8 = (defpackage.zm6) r8
            java.lang.String r0 = "other"
            defpackage.n86.f(r8, r0)
            int r0 = r7.g()
            int r1 = r8.g()
            int r2 = java.lang.Math.min(r0, r1)
            r3 = 0
            r4 = 0
        L_0x0015:
            if (r4 >= r2) goto L_0x002b
            byte r5 = r7.j(r4)
            r5 = r5 & 255(0xff, float:3.57E-43)
            byte r6 = r8.j(r4)
            r6 = r6 & 255(0xff, float:3.57E-43)
            if (r5 != r6) goto L_0x0028
            int r4 = r4 + 1
            goto L_0x0015
        L_0x0028:
            if (r5 >= r6) goto L_0x0032
            goto L_0x0030
        L_0x002b:
            if (r0 != r1) goto L_0x002e
            goto L_0x0033
        L_0x002e:
            if (r0 >= r1) goto L_0x0032
        L_0x0030:
            r3 = -1
            goto L_0x0033
        L_0x0032:
            r3 = 1
        L_0x0033:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.zm6.compareTo(java.lang.Object):int");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zm6) {
            zm6 zm6 = (zm6) obj;
            int g2 = zm6.g();
            byte[] bArr = this.h;
            if (g2 != bArr.length || !zm6.l(0, bArr, 0, bArr.length)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int g() {
        return this.h.length;
    }

    public String h() {
        byte[] bArr = this.h;
        char[] cArr = new char[(bArr.length * 2)];
        int i2 = 0;
        for (byte b : bArr) {
            int i3 = i2 + 1;
            char[] cArr2 = tn6.f3381a;
            cArr[i2] = cArr2[(b >> 4) & 15];
            i2 = i3 + 1;
            cArr[i3] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    public int hashCode() {
        int i2 = this.f;
        if (i2 != 0) {
            return i2;
        }
        int hashCode = Arrays.hashCode(this.h);
        this.f = hashCode;
        return hashCode;
    }

    public byte[] i() {
        return this.h;
    }

    public byte j(int i2) {
        return this.h[i2];
    }

    public boolean k(int i2, zm6 zm6, int i3, int i4) {
        n86.f(zm6, "other");
        return zm6.l(i3, this.h, i2, i4);
    }

    public boolean l(int i2, byte[] bArr, int i3, int i4) {
        n86.f(bArr, "other");
        if (i2 >= 0) {
            byte[] bArr2 = this.h;
            return i2 <= bArr2.length - i4 && i3 >= 0 && i3 <= bArr.length - i4 && ec6.e(bArr2, i2, bArr, i3, i4);
        }
    }

    public zm6 m() {
        byte b;
        int i2 = 0;
        while (true) {
            byte[] bArr = this.h;
            if (i2 >= bArr.length) {
                return this;
            }
            byte b2 = bArr[i2];
            byte b3 = (byte) 65;
            if (b2 < b3 || b2 > (b = (byte) 90)) {
                i2++;
            } else {
                byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
                n86.b(copyOf, "java.util.Arrays.copyOf(this, size)");
                copyOf[i2] = (byte) (b2 + 32);
                for (int i3 = i2 + 1; i3 < copyOf.length; i3++) {
                    byte b4 = copyOf[i3];
                    if (b4 >= b3 && b4 <= b) {
                        copyOf[i3] = (byte) (b4 + 32);
                    }
                }
                return new zm6(copyOf);
            }
        }
    }

    public byte[] o() {
        byte[] bArr = this.h;
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        n86.b(copyOf, "java.util.Arrays.copyOf(this, size)");
        return copyOf;
    }

    public String p() {
        String str = this.g;
        if (str != null) {
            return str;
        }
        byte[] i2 = i();
        n86.f(i2, "$this$toUtf8String");
        String str2 = new String(i2, aa6.f144a);
        this.g = str2;
        return str2;
    }

    public void q(vm6 vm6, int i2, int i3) {
        n86.f(vm6, "buffer");
        n86.f(this, "$this$commonWrite");
        n86.f(vm6, "buffer");
        vm6.x(this.h, i2, i3);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0120, code lost:
        if (r4 == 64) goto L_0x01ef;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x015e, code lost:
        if (r4 == 64) goto L_0x01ef;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0171, code lost:
        if (r4 == 64) goto L_0x01ef;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x0182, code lost:
        if (r4 == 64) goto L_0x01ef;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x0191, code lost:
        if (r4 == 64) goto L_0x01ef;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x01a7, code lost:
        if (r4 == 64) goto L_0x01ef;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x01af, code lost:
        if (r4 == 64) goto L_0x01ef;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x01b6, code lost:
        if (r4 == 64) goto L_0x01ef;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x01eb, code lost:
        if (r4 == 64) goto L_0x01ef;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x01ee, code lost:
        r5 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0089, code lost:
        if (r4 == 64) goto L_0x01ef;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x009a, code lost:
        if (r4 == 64) goto L_0x01ef;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00a5, code lost:
        if (r4 == 64) goto L_0x01ef;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x00e3, code lost:
        if (r4 == 64) goto L_0x01ef;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x00f6, code lost:
        if (r4 == 64) goto L_0x01ef;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0105, code lost:
        if (r4 == 64) goto L_0x01ef;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0117, code lost:
        if (r4 == 64) goto L_0x01ef;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toString() {
        /*
        // Method dump skipped, instructions count: 703
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.zm6.toString():java.lang.String");
    }
}
