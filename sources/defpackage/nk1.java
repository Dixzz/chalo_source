package defpackage;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* renamed from: nk1  reason: default package */
/* compiled from: PoolingByteArrayOutputStream */
public class nk1 extends ByteArrayOutputStream {
    public final hk1 f;

    public nk1(hk1 hk1, int i) {
        this.f = hk1;
        ((ByteArrayOutputStream) this).buf = hk1.a(Math.max(i, 256));
    }

    public final void a(int i) {
        int i2 = ((ByteArrayOutputStream) this).count;
        if (i2 + i > ((ByteArrayOutputStream) this).buf.length) {
            byte[] a2 = this.f.a((i2 + i) * 2);
            System.arraycopy(((ByteArrayOutputStream) this).buf, 0, a2, 0, ((ByteArrayOutputStream) this).count);
            this.f.b(((ByteArrayOutputStream) this).buf);
            ((ByteArrayOutputStream) this).buf = a2;
        }
    }

    @Override // java.io.OutputStream, java.io.ByteArrayOutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f.b(((ByteArrayOutputStream) this).buf);
        ((ByteArrayOutputStream) this).buf = null;
        super.close();
    }

    @Override // java.lang.Object
    public void finalize() {
        this.f.b(((ByteArrayOutputStream) this).buf);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) {
        a(i2);
        super.write(bArr, i, i2);
    }

    @Override // java.io.OutputStream, java.io.ByteArrayOutputStream
    public synchronized void write(int i) {
        a(1);
        super.write(i);
    }
}
