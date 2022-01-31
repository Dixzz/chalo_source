package defpackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Objects;

/* renamed from: nt4  reason: default package */
public final class nt4 extends InputStream {
    public final Enumeration<File> f;
    public InputStream g;

    public nt4(Enumeration<File> enumeration) throws IOException {
        this.f = enumeration;
        a();
    }

    public final void a() throws IOException {
        InputStream inputStream = this.g;
        if (inputStream != null) {
            inputStream.close();
        }
        this.g = this.f.hasMoreElements() ? new FileInputStream(this.f.nextElement()) : null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
    public final void close() throws IOException {
        super.close();
        InputStream inputStream = this.g;
        if (inputStream != null) {
            inputStream.close();
            this.g = null;
        }
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        while (true) {
            InputStream inputStream = this.g;
            if (inputStream == null) {
                return -1;
            }
            int read = inputStream.read();
            if (read != -1) {
                return read;
            }
            a();
        }
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.g == null) {
            return -1;
        }
        Objects.requireNonNull(bArr);
        if (i < 0 || i2 < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException();
        } else if (i2 == 0) {
            return 0;
        } else {
            do {
                int read = this.g.read(bArr, i, i2);
                if (read > 0) {
                    return read;
                }
                a();
            } while (this.g != null);
            return -1;
        }
    }
}
