package defpackage;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: p06  reason: default package */
/* compiled from: QueueFile */
public class p06 implements Closeable {
    public static final Logger l = Logger.getLogger(p06.class.getName());
    public final RandomAccessFile f;
    public int g;
    public int h;
    public b i;
    public b j;
    public final byte[] k = new byte[16];

    /* renamed from: p06$a */
    /* compiled from: QueueFile */
    public class a implements d {

        /* renamed from: a  reason: collision with root package name */
        public boolean f2755a = true;
        public final /* synthetic */ StringBuilder b;

        public a(p06 p06, StringBuilder sb) {
            this.b = sb;
        }

        @Override // defpackage.p06.d
        public void read(InputStream inputStream, int i) throws IOException {
            if (this.f2755a) {
                this.f2755a = false;
            } else {
                this.b.append(", ");
            }
            this.b.append(i);
        }
    }

    /* renamed from: p06$b */
    /* compiled from: QueueFile */
    public static class b {
        public static final b c = new b(0, 0);

        /* renamed from: a  reason: collision with root package name */
        public final int f2756a;
        public final int b;

        public b(int i, int i2) {
            this.f2756a = i;
            this.b = i2;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(b.class.getSimpleName());
            sb.append("[");
            sb.append("position = ");
            sb.append(this.f2756a);
            sb.append(", length = ");
            return hj1.X(sb, this.b, "]");
        }
    }

    /* renamed from: p06$d */
    /* compiled from: QueueFile */
    public interface d {
        void read(InputStream inputStream, int i) throws IOException;
    }

    /* JADX INFO: finally extract failed */
    public p06(File file) throws IOException {
        if (!file.exists()) {
            File file2 = new File(file.getPath() + ".tmp");
            RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rwd");
            try {
                randomAccessFile.setLength(4096);
                randomAccessFile.seek(0);
                byte[] bArr = new byte[16];
                int[] iArr = {4096, 0, 0, 0};
                int i2 = 0;
                for (int i3 = 0; i3 < 4; i3++) {
                    q(bArr, i2, iArr[i3]);
                    i2 += 4;
                }
                randomAccessFile.write(bArr);
                randomAccessFile.close();
                if (!file2.renameTo(file)) {
                    throw new IOException("Rename failed!");
                }
            } catch (Throwable th) {
                randomAccessFile.close();
                throw th;
            }
        }
        RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "rwd");
        this.f = randomAccessFile2;
        randomAccessFile2.seek(0);
        randomAccessFile2.readFully(this.k);
        int j2 = j(this.k, 0);
        this.g = j2;
        if (((long) j2) <= randomAccessFile2.length()) {
            this.h = j(this.k, 4);
            int j3 = j(this.k, 8);
            int j4 = j(this.k, 12);
            this.i = i(j3);
            this.j = i(j4);
            return;
        }
        StringBuilder i0 = hj1.i0("File is truncated. Expected length: ");
        i0.append(this.g);
        i0.append(", Actual length: ");
        i0.append(randomAccessFile2.length());
        throw new IOException(i0.toString());
    }

    public static int a(p06 p06, int i2) {
        int i3 = p06.g;
        return i2 < i3 ? i2 : (i2 + 16) - i3;
    }

    public static int j(byte[] bArr, int i2) {
        return ((bArr[i2] & 255) << 24) + ((bArr[i2 + 1] & 255) << 16) + ((bArr[i2 + 2] & 255) << 8) + (bArr[i2 + 3] & 255);
    }

    public static void q(byte[] bArr, int i2, int i3) {
        bArr[i2] = (byte) (i3 >> 24);
        bArr[i2 + 1] = (byte) (i3 >> 16);
        bArr[i2 + 2] = (byte) (i3 >> 8);
        bArr[i2 + 3] = (byte) i3;
    }

    public void c(byte[] bArr) throws IOException {
        int i2;
        int length = bArr.length;
        synchronized (this) {
            if ((0 | length) >= 0) {
                if (length <= bArr.length - 0) {
                    f(length);
                    boolean h2 = h();
                    if (h2) {
                        i2 = 16;
                    } else {
                        b bVar = this.j;
                        i2 = o(bVar.f2756a + 4 + bVar.b);
                    }
                    b bVar2 = new b(i2, length);
                    q(this.k, 0, length);
                    m(bVar2.f2756a, this.k, 0, 4);
                    m(bVar2.f2756a + 4, bArr, 0, length);
                    p(this.g, this.h + 1, h2 ? bVar2.f2756a : this.i.f2756a, bVar2.f2756a);
                    this.j = bVar2;
                    this.h++;
                    if (h2) {
                        this.i = bVar2;
                    }
                }
            }
            throw new IndexOutOfBoundsException();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.f.close();
    }

    public synchronized void e() throws IOException {
        p(4096, 0, 0, 0);
        this.h = 0;
        b bVar = b.c;
        this.i = bVar;
        this.j = bVar;
        if (this.g > 4096) {
            this.f.setLength((long) 4096);
            this.f.getChannel().force(true);
        }
        this.g = 4096;
    }

    public final void f(int i2) throws IOException {
        int i3 = i2 + 4;
        int n = this.g - n();
        if (n < i3) {
            int i4 = this.g;
            do {
                n += i4;
                i4 <<= 1;
            } while (n < i3);
            this.f.setLength((long) i4);
            this.f.getChannel().force(true);
            b bVar = this.j;
            int o = o(bVar.f2756a + 4 + bVar.b);
            if (o < this.i.f2756a) {
                FileChannel channel = this.f.getChannel();
                channel.position((long) this.g);
                long j2 = (long) (o - 4);
                if (channel.transferTo(16, j2, channel) != j2) {
                    throw new AssertionError("Copied insufficient number of bytes!");
                }
            }
            int i5 = this.j.f2756a;
            int i6 = this.i.f2756a;
            if (i5 < i6) {
                int i7 = (this.g + i5) - 16;
                p(i4, this.h, i6, i7);
                this.j = new b(i7, this.j.b);
            } else {
                p(i4, this.h, i6, i5);
            }
            this.g = i4;
        }
    }

    public synchronized void g(d dVar) throws IOException {
        int i2 = this.i.f2756a;
        for (int i3 = 0; i3 < this.h; i3++) {
            b i4 = i(i2);
            dVar.read(new c(i4, null), i4.b);
            i2 = o(i4.f2756a + 4 + i4.b);
        }
    }

    public synchronized boolean h() {
        return this.h == 0;
    }

    public final b i(int i2) throws IOException {
        if (i2 == 0) {
            return b.c;
        }
        this.f.seek((long) i2);
        return new b(i2, this.f.readInt());
    }

    public synchronized void k() throws IOException {
        if (h()) {
            throw new NoSuchElementException();
        } else if (this.h == 1) {
            e();
        } else {
            b bVar = this.i;
            int o = o(bVar.f2756a + 4 + bVar.b);
            l(o, this.k, 0, 4);
            int j2 = j(this.k, 0);
            p(this.g, this.h - 1, o, this.j.f2756a);
            this.h--;
            this.i = new b(o, j2);
        }
    }

    public final void l(int i2, byte[] bArr, int i3, int i4) throws IOException {
        int i5 = this.g;
        if (i2 >= i5) {
            i2 = (i2 + 16) - i5;
        }
        if (i2 + i4 <= i5) {
            this.f.seek((long) i2);
            this.f.readFully(bArr, i3, i4);
            return;
        }
        int i6 = i5 - i2;
        this.f.seek((long) i2);
        this.f.readFully(bArr, i3, i6);
        this.f.seek(16);
        this.f.readFully(bArr, i3 + i6, i4 - i6);
    }

    public final void m(int i2, byte[] bArr, int i3, int i4) throws IOException {
        int i5 = this.g;
        if (i2 >= i5) {
            i2 = (i2 + 16) - i5;
        }
        if (i2 + i4 <= i5) {
            this.f.seek((long) i2);
            this.f.write(bArr, i3, i4);
            return;
        }
        int i6 = i5 - i2;
        this.f.seek((long) i2);
        this.f.write(bArr, i3, i6);
        this.f.seek(16);
        this.f.write(bArr, i3 + i6, i4 - i6);
    }

    public int n() {
        if (this.h == 0) {
            return 16;
        }
        b bVar = this.j;
        int i2 = bVar.f2756a;
        int i3 = this.i.f2756a;
        if (i2 >= i3) {
            return (i2 - i3) + 4 + bVar.b + 16;
        }
        return (((i2 + 4) + bVar.b) + this.g) - i3;
    }

    public final int o(int i2) {
        int i3 = this.g;
        return i2 < i3 ? i2 : (i2 + 16) - i3;
    }

    public final void p(int i2, int i3, int i4, int i5) throws IOException {
        byte[] bArr = this.k;
        int[] iArr = {i2, i3, i4, i5};
        int i6 = 0;
        for (int i7 = 0; i7 < 4; i7++) {
            q(bArr, i6, iArr[i7]);
            i6 += 4;
        }
        this.f.seek(0);
        this.f.write(this.k);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(p06.class.getSimpleName());
        sb.append('[');
        sb.append("fileLength=");
        sb.append(this.g);
        sb.append(", size=");
        sb.append(this.h);
        sb.append(", first=");
        sb.append(this.i);
        sb.append(", last=");
        sb.append(this.j);
        sb.append(", element lengths=[");
        try {
            g(new a(this, sb));
        } catch (IOException e) {
            l.log(Level.WARNING, "read error", (Throwable) e);
        }
        sb.append("]]");
        return sb.toString();
    }

    /* renamed from: p06$c */
    /* compiled from: QueueFile */
    public final class c extends InputStream {
        public int f;
        public int g;

        public c(b bVar, a aVar) {
            int i = bVar.f2756a + 4;
            int i2 = p06.this.g;
            this.f = i >= i2 ? (i + 16) - i2 : i;
            this.g = bVar.b;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            Objects.requireNonNull(bArr, "buffer");
            if ((i | i2) < 0 || i2 > bArr.length - i) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i3 = this.g;
            if (i3 <= 0) {
                return -1;
            }
            if (i2 > i3) {
                i2 = i3;
            }
            p06.this.l(this.f, bArr, i, i2);
            this.f = p06.a(p06.this, this.f + i2);
            this.g -= i2;
            return i2;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            if (this.g == 0) {
                return -1;
            }
            p06.this.f.seek((long) this.f);
            int read = p06.this.f.read();
            this.f = p06.a(p06.this, this.f + 1);
            this.g--;
            return read;
        }
    }
}
