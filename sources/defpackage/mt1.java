package defpackage;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Queue;

/* renamed from: mt1  reason: default package */
/* compiled from: ExceptionCatchingInputStream */
public class mt1 extends InputStream {
    public static final Queue<mt1> h = new ArrayDeque(0);
    public InputStream f;
    public IOException g;

    static {
        char[] cArr = rt1.f3126a;
    }

    public void a() {
        this.g = null;
        this.f = null;
        Queue<mt1> queue = h;
        synchronized (queue) {
            queue.offer(this);
        }
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.f.available();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
    public void close() throws IOException {
        this.f.close();
    }

    public void mark(int i) {
        this.f.mark(i);
    }

    public boolean markSupported() {
        return this.f.markSupported();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        try {
            return this.f.read(bArr);
        } catch (IOException e) {
            this.g = e;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        this.f.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        try {
            return this.f.skip(j);
        } catch (IOException e) {
            this.g = e;
            return 0;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        try {
            return this.f.read(bArr, i, i2);
        } catch (IOException e) {
            this.g = e;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        try {
            return this.f.read();
        } catch (IOException e) {
            this.g = e;
            return -1;
        }
    }
}
