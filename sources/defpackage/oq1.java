package defpackage;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: oq1  reason: default package */
/* compiled from: RecyclableBufferedInputStream */
public class oq1 extends FilterInputStream {
    public volatile byte[] f;
    public int g;
    public int h;
    public int i = -1;
    public int j;
    public final xn1 k;

    /* renamed from: oq1$a */
    /* compiled from: RecyclableBufferedInputStream */
    public static class a extends IOException {
        public a(String str) {
            super(str);
        }
    }

    public oq1(InputStream inputStream, xn1 xn1) {
        super(inputStream);
        this.k = xn1;
        this.f = (byte[]) xn1.d(65536, byte[].class);
    }

    public static IOException e() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    public final int a(InputStream inputStream, byte[] bArr) throws IOException {
        int i2;
        int i3 = this.i;
        if (i3 == -1 || this.j - i3 >= (i2 = this.h)) {
            int read = inputStream.read(bArr);
            if (read > 0) {
                this.i = -1;
                this.j = 0;
                this.g = read;
            }
            return read;
        }
        if (i3 == 0 && i2 > bArr.length && this.g == bArr.length) {
            int length = bArr.length * 2;
            if (length <= i2) {
                i2 = length;
            }
            byte[] bArr2 = (byte[]) this.k.d(i2, byte[].class);
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            this.f = bArr2;
            this.k.c(bArr, byte[].class);
            bArr = bArr2;
        } else if (i3 > 0) {
            System.arraycopy(bArr, i3, bArr, 0, bArr.length - i3);
        }
        int i4 = this.j - this.i;
        this.j = i4;
        this.i = 0;
        this.g = 0;
        int read2 = inputStream.read(bArr, i4, bArr.length - i4);
        int i5 = this.j;
        if (read2 > 0) {
            i5 += read2;
        }
        this.g = i5;
        return read2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        InputStream inputStream;
        inputStream = ((FilterInputStream) this).in;
        if (this.f == null || inputStream == null) {
            e();
            throw null;
        }
        return (this.g - this.j) + inputStream.available();
    }

    public synchronized void c() {
        if (this.f != null) {
            this.k.c(this.f, byte[].class);
            this.f = null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
    public void close() throws IOException {
        if (this.f != null) {
            this.k.c(this.f, byte[].class);
            this.f = null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        ((FilterInputStream) this).in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    public synchronized void mark(int i2) {
        this.h = Math.max(this.h, i2);
        this.i = this.j;
    }

    public boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        byte[] bArr = this.f;
        InputStream inputStream = ((FilterInputStream) this).in;
        if (bArr == null || inputStream == null) {
            e();
            throw null;
        } else if (this.j >= this.g && a(inputStream, bArr) == -1) {
            return -1;
        } else {
            if (bArr == this.f || (bArr = this.f) != null) {
                int i2 = this.g;
                int i3 = this.j;
                if (i2 - i3 <= 0) {
                    return -1;
                }
                this.j = i3 + 1;
                return bArr[i3] & 255;
            }
            e();
            throw null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        if (this.f != null) {
            int i2 = this.i;
            if (-1 != i2) {
                this.j = i2;
            } else {
                throw new a("Mark has been invalidated, pos: " + this.j + " markLimit: " + this.h);
            }
        } else {
            throw new IOException("Stream is closed");
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j2) throws IOException {
        byte[] bArr = this.f;
        InputStream inputStream = ((FilterInputStream) this).in;
        if (bArr == null) {
            e();
            throw null;
        } else if (j2 < 1) {
            return 0;
        } else {
            if (inputStream != null) {
                int i2 = this.g;
                int i3 = this.j;
                if (((long) (i2 - i3)) >= j2) {
                    this.j = (int) (((long) i3) + j2);
                    return j2;
                }
                long j3 = (long) (i2 - i3);
                this.j = i2;
                if (this.i == -1 || j2 > ((long) this.h)) {
                    return j3 + inputStream.skip(j2 - j3);
                } else if (a(inputStream, bArr) == -1) {
                    return j3;
                } else {
                    int i4 = this.g;
                    int i5 = this.j;
                    long j4 = j2 - j3;
                    if (((long) (i4 - i5)) >= j4) {
                        this.j = (int) (((long) i5) + j4);
                        return j2;
                    }
                    long j5 = (j3 + ((long) i4)) - ((long) i5);
                    this.j = i4;
                    return j5;
                }
            } else {
                e();
                throw null;
            }
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i2, int i3) throws IOException {
        int i4;
        int i5;
        byte[] bArr2 = this.f;
        if (bArr2 == null) {
            e();
            throw null;
        } else if (i3 == 0) {
            return 0;
        } else {
            InputStream inputStream = ((FilterInputStream) this).in;
            if (inputStream != null) {
                int i6 = this.j;
                int i7 = this.g;
                if (i6 < i7) {
                    int i8 = i7 - i6 >= i3 ? i3 : i7 - i6;
                    System.arraycopy(bArr2, i6, bArr, i2, i8);
                    this.j += i8;
                    if (i8 == i3 || inputStream.available() == 0) {
                        return i8;
                    }
                    i2 += i8;
                    i4 = i3 - i8;
                } else {
                    i4 = i3;
                }
                while (true) {
                    int i9 = -1;
                    if (this.i == -1 && i4 >= bArr2.length) {
                        i5 = inputStream.read(bArr, i2, i4);
                        if (i5 == -1) {
                            if (i4 != i3) {
                                i9 = i3 - i4;
                            }
                            return i9;
                        }
                    } else if (a(inputStream, bArr2) == -1) {
                        if (i4 != i3) {
                            i9 = i3 - i4;
                        }
                        return i9;
                    } else if (bArr2 == this.f || (bArr2 = this.f) != null) {
                        int i10 = this.g;
                        int i11 = this.j;
                        i5 = i10 - i11 >= i4 ? i4 : i10 - i11;
                        System.arraycopy(bArr2, i11, bArr, i2, i5);
                        this.j += i5;
                    } else {
                        e();
                        throw null;
                    }
                    i4 -= i5;
                    if (i4 == 0) {
                        return i3;
                    }
                    if (inputStream.available() == 0) {
                        return i3 - i4;
                    }
                    i2 += i5;
                }
            } else {
                e();
                throw null;
            }
        }
    }
}
