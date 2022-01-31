package defpackage;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: lt1  reason: default package */
/* compiled from: ContentLengthInputStream */
public final class lt1 extends FilterInputStream {
    public final long f;
    public int g;

    public lt1(InputStream inputStream, long j) {
        super(inputStream);
        this.f = j;
    }

    public final int a(int i) throws IOException {
        if (i >= 0) {
            this.g += i;
        } else if (this.f - ((long) this.g) > 0) {
            StringBuilder i0 = hj1.i0("Failed to read all expected data, expected: ");
            i0.append(this.f);
            i0.append(", but read: ");
            i0.append(this.g);
            throw new IOException(i0.toString());
        }
        return i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        return (int) Math.max(this.f - ((long) this.g), (long) ((FilterInputStream) this).in.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        int read;
        read = super.read();
        a(read >= 0 ? 1 : -1);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i, int i2) throws IOException {
        int read;
        read = super.read(bArr, i, i2);
        a(read);
        return read;
    }
}
