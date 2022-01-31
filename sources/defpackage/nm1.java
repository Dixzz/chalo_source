package defpackage;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: nm1  reason: default package */
/* compiled from: ExifOrientationStream */
public final class nm1 extends FilterInputStream {
    public static final byte[] h;
    public static final int i;
    public static final int j;
    public final byte f;
    public int g;

    static {
        byte[] bArr = {-1, -31, 0, 28, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};
        h = bArr;
        int length = bArr.length;
        i = length;
        j = length + 2;
    }

    public nm1(InputStream inputStream, int i2) {
        super(inputStream);
        if (i2 < -1 || i2 > 8) {
            throw new IllegalArgumentException(hj1.I("Cannot add invalid orientation: ", i2));
        }
        this.f = (byte) i2;
    }

    public void mark(int i2) {
        throw new UnsupportedOperationException();
    }

    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i2;
        int i3;
        int i4 = this.g;
        if (i4 < 2 || i4 > (i3 = j)) {
            i2 = super.read();
        } else if (i4 == i3) {
            i2 = this.f;
        } else {
            i2 = h[i4 - 2] & 255;
        }
        if (i2 != -1) {
            this.g++;
        }
        return i2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j2) throws IOException {
        long skip = super.skip(j2);
        if (skip > 0) {
            this.g = (int) (((long) this.g) + skip);
        }
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int i4;
        int i5 = this.g;
        int i6 = j;
        if (i5 > i6) {
            i4 = super.read(bArr, i2, i3);
        } else if (i5 == i6) {
            bArr[i2] = this.f;
            i4 = 1;
        } else if (i5 < 2) {
            i4 = super.read(bArr, i2, 2 - i5);
        } else {
            int min = Math.min(i6 - i5, i3);
            System.arraycopy(h, this.g - 2, bArr, i2, min);
            i4 = min;
        }
        if (i4 > 0) {
            this.g += i4;
        }
        return i4;
    }
}
