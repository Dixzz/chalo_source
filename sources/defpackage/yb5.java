package defpackage;

import android.annotation.SuppressLint;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;

@SuppressLint({"Assert"})
/* renamed from: yb5  reason: default package */
/* compiled from: Base64 */
public class yb5 {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f4029a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    public static final byte[] b = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
    public static final byte[] c = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
    public static final byte[] d = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
    public static final byte[] e = {45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122};
    public static final byte[] f = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    public static byte[] a(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        byte[] bArr3;
        if ((i4 & 16) == 16) {
            bArr3 = c;
        } else if ((i4 & 32) == 32) {
            bArr3 = e;
        } else {
            bArr3 = f4029a;
        }
        int i5 = 0;
        int i6 = (i2 > 1 ? (bArr[i + 1] << 24) >>> 16 : 0) | (i2 > 0 ? (bArr[i] << 24) >>> 8 : 0);
        if (i2 > 2) {
            i5 = (bArr[i + 2] << 24) >>> 24;
        }
        int i7 = i6 | i5;
        if (i2 == 1) {
            bArr2[i3] = bArr3[i7 >>> 18];
            bArr2[i3 + 1] = bArr3[(i7 >>> 12) & 63];
            bArr2[i3 + 2] = 61;
            bArr2[i3 + 3] = 61;
            return bArr2;
        } else if (i2 == 2) {
            bArr2[i3] = bArr3[i7 >>> 18];
            bArr2[i3 + 1] = bArr3[(i7 >>> 12) & 63];
            bArr2[i3 + 2] = bArr3[(i7 >>> 6) & 63];
            bArr2[i3 + 3] = 61;
            return bArr2;
        } else if (i2 != 3) {
            return bArr2;
        } else {
            bArr2[i3] = bArr3[i7 >>> 18];
            bArr2[i3 + 1] = bArr3[(i7 >>> 12) & 63];
            bArr2[i3 + 2] = bArr3[(i7 >>> 6) & 63];
            bArr2[i3 + 3] = bArr3[i7 & 63];
            return bArr2;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:14|15|16|17|18|19|(2:20|21)|22) */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:30|31|40|41|42|43|44|45|46) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x002f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0032 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:42:0x0056 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:44:0x0059 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String b(byte[] r17, int r18, int r19, int r20) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 274
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.yb5.b(byte[], int, int, int):java.lang.String");
    }

    public static final byte[] c(int i) {
        if ((i & 16) == 16) {
            return d;
        }
        if ((i & 32) == 32) {
            return f;
        }
        return b;
    }

    /* renamed from: yb5$a */
    /* compiled from: Base64 */
    public static class a extends FilterOutputStream {
        public boolean f;
        public int g;
        public byte[] h;
        public int i;
        public int j;
        public boolean k;
        public byte[] l;
        public int m;
        public byte[] n;

        public a(OutputStream outputStream, int i2) {
            super(outputStream);
            boolean z = true;
            this.k = (i2 & 8) != 0;
            z = (i2 & 1) == 0 ? false : z;
            this.f = z;
            int i3 = z ? 3 : 4;
            this.i = i3;
            this.h = new byte[i3];
            this.g = 0;
            this.j = 0;
            this.l = new byte[4];
            this.m = i2;
            this.n = yb5.c(i2);
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.io.FilterOutputStream, java.lang.AutoCloseable
        public void close() throws IOException {
            int i2 = this.g;
            if (i2 > 0) {
                if (this.f) {
                    OutputStream outputStream = ((FilterOutputStream) this).out;
                    byte[] bArr = this.l;
                    yb5.a(this.h, 0, i2, bArr, 0, this.m);
                    outputStream.write(bArr);
                    this.g = 0;
                } else {
                    throw new IOException("Base64 input not properly padded.");
                }
            }
            super.close();
            this.h = null;
            ((FilterOutputStream) this).out = null;
        }

        @Override // java.io.OutputStream, java.io.FilterOutputStream
        public void write(int i2) throws IOException {
            if (this.f) {
                byte[] bArr = this.h;
                int i3 = this.g;
                int i4 = i3 + 1;
                this.g = i4;
                bArr[i3] = (byte) i2;
                int i5 = this.i;
                if (i4 >= i5) {
                    OutputStream outputStream = ((FilterOutputStream) this).out;
                    byte[] bArr2 = this.l;
                    yb5.a(bArr, 0, i5, bArr2, 0, this.m);
                    outputStream.write(bArr2);
                    int i6 = this.j + 4;
                    this.j = i6;
                    if (this.k && i6 >= 76) {
                        ((FilterOutputStream) this).out.write(10);
                        this.j = 0;
                    }
                    this.g = 0;
                    return;
                }
                return;
            }
            byte[] bArr3 = this.n;
            int i7 = i2 & 127;
            if (bArr3[i7] > -5) {
                byte[] bArr4 = this.h;
                int i8 = this.g;
                int i9 = i8 + 1;
                this.g = i9;
                bArr4[i8] = (byte) i2;
                if (i9 >= this.i) {
                    byte[] bArr5 = this.l;
                    int i10 = this.m;
                    Objects.requireNonNull(bArr5, "Destination array was null.");
                    int i11 = 3;
                    if (3 >= bArr4.length) {
                        throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and still process four bytes.", Integer.valueOf(bArr4.length), 0));
                    } else if (2 < bArr5.length) {
                        byte[] c = yb5.c(i10);
                        if (bArr4[2] == 61) {
                            bArr5[0] = (byte) ((((c[bArr4[1]] & 255) << 12) | ((c[bArr4[0]] & 255) << 18)) >>> 16);
                            i11 = 1;
                        } else if (bArr4[3] == 61) {
                            int i12 = ((c[bArr4[2]] & 255) << 6) | ((c[bArr4[0]] & 255) << 18) | ((c[bArr4[1]] & 255) << 12);
                            bArr5[0] = (byte) (i12 >>> 16);
                            bArr5[1] = (byte) (i12 >>> 8);
                            i11 = 2;
                        } else {
                            int i13 = (c[bArr4[3]] & 255) | ((c[bArr4[0]] & 255) << 18) | ((c[bArr4[1]] & 255) << 12) | ((c[bArr4[2]] & 255) << 6);
                            bArr5[0] = (byte) (i13 >> 16);
                            bArr5[1] = (byte) (i13 >> 8);
                            bArr5[2] = (byte) i13;
                        }
                        ((FilterOutputStream) this).out.write(this.l, 0, i11);
                        this.g = 0;
                    } else {
                        throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", Integer.valueOf(bArr5.length), 0));
                    }
                }
            } else if (bArr3[i7] != -5) {
                throw new IOException("Invalid character in Base64 data.");
            }
        }

        @Override // java.io.OutputStream, java.io.FilterOutputStream
        public void write(byte[] bArr, int i2, int i3) throws IOException {
            for (int i4 = 0; i4 < i3; i4++) {
                write(bArr[i2 + i4]);
            }
        }
    }
}
