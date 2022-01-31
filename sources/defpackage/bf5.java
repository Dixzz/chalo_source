package defpackage;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: bf5  reason: default package */
/* compiled from: MarkableInputStream */
public final class bf5 extends InputStream {
    public final InputStream f;
    public long g;
    public long h;
    public long i;
    public long j = -1;
    public boolean k = true;
    public int l = -1;

    public bf5(InputStream inputStream) {
        this.f = !inputStream.markSupported() ? new BufferedInputStream(inputStream, 4096) : inputStream;
        this.l = 1024;
    }

    public void a(long j2) throws IOException {
        if (this.g > this.i || j2 < this.h) {
            throw new IOException("Cannot reset");
        }
        this.f.reset();
        e(this.h, j2);
        this.g = j2;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.f.available();
    }

    public final void c(long j2) {
        try {
            long j3 = this.h;
            long j4 = this.g;
            if (j3 >= j4 || j4 > this.i) {
                this.h = j4;
                this.f.mark((int) (j2 - j4));
            } else {
                this.f.reset();
                this.f.mark((int) (j2 - this.h));
                e(this.h, this.g);
            }
            this.i = j2;
        } catch (IOException e) {
            throw new IllegalStateException("Unable to mark: " + e);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
    public void close() throws IOException {
        this.f.close();
    }

    public final void e(long j2, long j3) throws IOException {
        while (j2 < j3) {
            long skip = this.f.skip(j3 - j2);
            if (skip == 0) {
                if (read() != -1) {
                    skip = 1;
                } else {
                    return;
                }
            }
            j2 += skip;
        }
    }

    public void mark(int i2) {
        long j2 = this.g + ((long) i2);
        if (this.i < j2) {
            c(j2);
        }
        this.j = this.g;
    }

    public boolean markSupported() {
        return this.f.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (!this.k) {
            long j2 = this.i;
            if (this.g + 1 > j2) {
                c(j2 + ((long) this.l));
            }
        }
        int read = this.f.read();
        if (read != -1) {
            this.g++;
        }
        return read;
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        a(this.j);
    }

    @Override // java.io.InputStream
    public long skip(long j2) throws IOException {
        if (!this.k) {
            long j3 = this.g;
            if (j3 + j2 > this.i) {
                c(j3 + j2 + ((long) this.l));
            }
        }
        long skip = this.f.skip(j2);
        this.g += skip;
        return skip;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        if (!this.k) {
            long j2 = this.g;
            if (((long) bArr.length) + j2 > this.i) {
                c(j2 + ((long) bArr.length) + ((long) this.l));
            }
        }
        int read = this.f.read(bArr);
        if (read != -1) {
            this.g += (long) read;
        }
        return read;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        if (!this.k) {
            long j2 = this.g;
            long j3 = (long) i3;
            if (j2 + j3 > this.i) {
                c(j2 + j3 + ((long) this.l));
            }
        }
        int read = this.f.read(bArr, i2, i3);
        if (read != -1) {
            this.g += (long) read;
        }
        return read;
    }
}
