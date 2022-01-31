package defpackage;

import com.rabbitmq.client.LongString;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/* renamed from: is4  reason: default package */
public final class is4 extends FilterInputStream {
    public final ot4 f = new ot4();
    public byte[] g = new byte[4096];
    public long h;
    public boolean i = false;
    public boolean j = false;

    public is4(InputStream inputStream) {
        super(inputStream);
    }

    public final gu4 a() throws IOException {
        byte[] bArr;
        if (this.h > 0) {
            do {
                bArr = this.g;
            } while (read(bArr, 0, bArr.length) != -1);
        }
        if (this.i || this.j) {
            return new gu4(null, -1, -1, false, false, null);
        }
        if (!c(30)) {
            this.i = true;
            return this.f.b();
        }
        gu4 b = this.f.b();
        if (b.e) {
            this.j = true;
            return b;
        } else if (b.b != LongString.MAX_LENGTH) {
            int i2 = this.f.f - 30;
            long j2 = (long) i2;
            int length = this.g.length;
            if (j2 > ((long) length)) {
                do {
                    length += length;
                } while (((long) length) < j2);
                this.g = Arrays.copyOf(this.g, length);
            }
            if (!c(i2)) {
                this.i = true;
                return this.f.b();
            }
            gu4 b2 = this.f.b();
            this.h = b2.b;
            return b2;
        } else {
            throw new os4("Files bigger than 4GiB are not supported.");
        }
    }

    public final boolean c(int i2) throws IOException {
        int e = e(this.g, 0, i2);
        if (e != i2) {
            int i3 = i2 - e;
            if (e(this.g, e, i3) != i3) {
                this.f.a(this.g, 0, e);
                return false;
            }
        }
        this.f.a(this.g, 0, i2);
        return true;
    }

    public final int e(byte[] bArr, int i2, int i3) throws IOException {
        return Math.max(0, super.read(bArr, i2, i3));
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i2, int i3) throws IOException {
        long j2 = this.h;
        if (j2 <= 0 || this.i) {
            return -1;
        }
        int max = Math.max(0, super.read(bArr, i2, (int) Math.min(j2, (long) i3)));
        this.h -= (long) max;
        if (max != 0) {
            return max;
        }
        this.i = true;
        return 0;
    }
}
