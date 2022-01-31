package defpackage;

import java.io.IOException;
import java.io.InputStream;

/* renamed from: cs4  reason: default package */
public final class cs4 extends InputStream {
    public final InputStream f;
    public long g;

    public cs4(InputStream inputStream, long j) {
        this.f = inputStream;
        this.g = j;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
    public final void close() throws IOException {
        super.close();
        this.f.close();
        this.g = 0;
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        long j = this.g;
        if (j <= 0) {
            return -1;
        }
        this.g = j - 1;
        return this.f.read();
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        long j = this.g;
        if (j <= 0) {
            return -1;
        }
        int read = this.f.read(bArr, i, (int) Math.min((long) i2, j));
        if (read != -1) {
            this.g -= (long) read;
        }
        return read;
    }
}
