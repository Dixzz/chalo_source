package defpackage;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/* renamed from: ab3  reason: default package */
/* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
public final class ab3 extends FilterInputStream {
    public long f;
    public long g = -1;

    public ab3(InputStream inputStream) {
        super(inputStream);
        Objects.requireNonNull(inputStream);
        this.f = 1048577;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int available() throws IOException {
        return (int) Math.min((long) ((FilterInputStream) this).in.available(), this.f);
    }

    public final synchronized void mark(int i) {
        ((FilterInputStream) this).in.mark(i);
        this.g = this.f;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        if (this.f == 0) {
            return -1;
        }
        int read = ((FilterInputStream) this).in.read();
        if (read != -1) {
            this.f--;
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void reset() throws IOException {
        if (!((FilterInputStream) this).in.markSupported()) {
            throw new IOException("Mark not supported");
        } else if (this.g != -1) {
            ((FilterInputStream) this).in.reset();
            this.f = this.g;
        } else {
            throw new IOException("Mark not set");
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j) throws IOException {
        long skip = ((FilterInputStream) this).in.skip(Math.min(j, this.f));
        this.f -= skip;
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        long j = this.f;
        if (j == 0) {
            return -1;
        }
        int read = ((FilterInputStream) this).in.read(bArr, i, (int) Math.min((long) i2, j));
        if (read != -1) {
            this.f -= (long) read;
        }
        return read;
    }
}
