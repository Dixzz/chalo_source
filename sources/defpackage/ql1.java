package defpackage;

import androidx.recyclerview.widget.RecyclerView;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* renamed from: ql1  reason: default package */
/* compiled from: StrictLineReader */
public class ql1 implements Closeable {
    public final InputStream f;
    public final Charset g;
    public byte[] h;
    public int i;
    public int j;

    /* renamed from: ql1$a */
    /* compiled from: StrictLineReader */
    public class a extends ByteArrayOutputStream {
        public a(int i) {
            super(i);
        }

        public String toString() {
            int i = ((ByteArrayOutputStream) this).count;
            if (i > 0 && ((ByteArrayOutputStream) this).buf[i - 1] == 13) {
                i--;
            }
            try {
                return new String(((ByteArrayOutputStream) this).buf, 0, i, ql1.this.g.name());
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError(e);
            }
        }
    }

    public ql1(InputStream inputStream, Charset charset) {
        if (charset == null) {
            throw null;
        } else if (charset.equals(rl1.f3093a)) {
            this.f = inputStream;
            this.g = charset;
            this.h = new byte[RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST];
        } else {
            throw new IllegalArgumentException("Unsupported encoding");
        }
    }

    public final void a() throws IOException {
        InputStream inputStream = this.f;
        byte[] bArr = this.h;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.i = 0;
            this.j = read;
            return;
        }
        throw new EOFException();
    }

    public String c() throws IOException {
        int i2;
        byte[] bArr;
        int i3;
        synchronized (this.f) {
            if (this.h != null) {
                if (this.i >= this.j) {
                    a();
                }
                for (int i4 = this.i; i4 != this.j; i4++) {
                    byte[] bArr2 = this.h;
                    if (bArr2[i4] == 10) {
                        if (i4 != this.i) {
                            i3 = i4 - 1;
                            if (bArr2[i3] == 13) {
                                byte[] bArr3 = this.h;
                                int i5 = this.i;
                                String str = new String(bArr3, i5, i3 - i5, this.g.name());
                                this.i = i4 + 1;
                                return str;
                            }
                        }
                        i3 = i4;
                        byte[] bArr32 = this.h;
                        int i52 = this.i;
                        String str2 = new String(bArr32, i52, i3 - i52, this.g.name());
                        this.i = i4 + 1;
                        return str2;
                    }
                }
                a aVar = new a((this.j - this.i) + 80);
                loop1:
                while (true) {
                    byte[] bArr4 = this.h;
                    int i6 = this.i;
                    aVar.write(bArr4, i6, this.j - i6);
                    this.j = -1;
                    a();
                    i2 = this.i;
                    while (true) {
                        if (i2 != this.j) {
                            bArr = this.h;
                            if (bArr[i2] == 10) {
                                break loop1;
                            }
                            i2++;
                        }
                    }
                }
                int i7 = this.i;
                if (i2 != i7) {
                    aVar.write(bArr, i7, i2 - i7);
                }
                this.i = i2 + 1;
                return aVar.toString();
            }
            throw new IOException("LineReader is closed");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.f) {
            if (this.h != null) {
                this.h = null;
                this.f.close();
            }
        }
    }
}
