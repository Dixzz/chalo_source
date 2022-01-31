package defpackage;

import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.perf.util.Constants;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Objects;

/* renamed from: kn6  reason: default package */
/* compiled from: RealBufferedSource.kt */
public final class kn6 implements ym6 {
    public final vm6 f = new vm6();
    public boolean g;
    public final qn6 h;

    public kn6(qn6 qn6) {
        n86.f(qn6, "source");
        this.h = qn6;
    }

    @Override // defpackage.ym6
    public String G0() {
        return c0(Long.MAX_VALUE);
    }

    @Override // defpackage.ym6
    public byte[] I0(long j) {
        if (g(j)) {
            return this.f.I0(j);
        }
        throw new EOFException();
    }

    @Override // defpackage.ym6
    public byte[] O() {
        this.f.t0(this.h);
        return this.f.O();
    }

    @Override // defpackage.ym6
    public boolean R() {
        if (!(!this.g)) {
            throw new IllegalStateException("closed".toString());
        } else if (!this.f.R() || this.h.read(this.f, (long) RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST) != -1) {
            return false;
        } else {
            return true;
        }
    }

    @Override // defpackage.ym6
    public long X0(on6 on6) {
        n86.f(on6, "sink");
        long j = 0;
        while (this.h.read(this.f, (long) RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST) != -1) {
            long a2 = this.f.a();
            if (a2 > 0) {
                j += a2;
                ((vm6) on6).s0(this.f, a2);
            }
        }
        vm6 vm6 = this.f;
        long j2 = vm6.g;
        if (j2 <= 0) {
            return j;
        }
        long j3 = j + j2;
        ((vm6) on6).s0(vm6, j2);
        return j3;
    }

    @Override // defpackage.ym6
    public void Y(vm6 vm6, long j) {
        n86.f(vm6, "sink");
        try {
            if (g(j)) {
                this.f.Y(vm6, j);
                return;
            }
            throw new EOFException();
        } catch (EOFException e) {
            vm6.t0(this.f);
            throw e;
        }
    }

    public long a(byte b, long j, long j2) {
        boolean z = true;
        if (!this.g) {
            if (0 > j || j2 < j) {
                z = false;
            }
            if (z) {
                while (j < j2) {
                    long f2 = this.f.f(b, j, j2);
                    if (f2 != -1) {
                        return f2;
                    }
                    vm6 vm6 = this.f;
                    long j3 = vm6.g;
                    if (j3 >= j2 || this.h.read(vm6, (long) RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST) == -1) {
                        return -1;
                    }
                    j = Math.max(j, j3);
                }
                return -1;
            }
            throw new IllegalArgumentException(("fromIndex=" + j + " toIndex=" + j2).toString());
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // defpackage.ym6
    public vm6 b() {
        return this.f;
    }

    public boolean c(long j, zm6 zm6) {
        n86.f(zm6, "bytes");
        int g2 = zm6.g();
        n86.f(zm6, "bytes");
        if (!this.g) {
            if (j >= 0 && g2 >= 0 && zm6.g() - 0 >= g2) {
                for (int i = 0; i < g2; i++) {
                    long j2 = ((long) i) + j;
                    if (g(1 + j2) && this.f.e(j2) == zm6.j(0 + i)) {
                    }
                }
                return true;
            }
            return false;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // defpackage.ym6
    public String c0(long j) {
        if (j >= 0) {
            long j2 = j == Long.MAX_VALUE ? Long.MAX_VALUE : j + 1;
            byte b = (byte) 10;
            long a2 = a(b, 0, j2);
            if (a2 != -1) {
                return sn6.a(this.f, a2);
            }
            if (j2 < Long.MAX_VALUE && g(j2) && this.f.e(j2 - 1) == ((byte) 13) && g(1 + j2) && this.f.e(j2) == b) {
                return sn6.a(this.f, j2);
            }
            vm6 vm6 = new vm6();
            vm6 vm62 = this.f;
            vm62.c(vm6, 0, Math.min((long) 32, vm62.g));
            throw new EOFException("\\n not found: limit=" + Math.min(this.f.g, j) + " content=" + vm6.v0().h() + "…");
        }
        throw new IllegalArgumentException(hj1.M("limit < 0: ", j).toString());
    }

    @Override // java.io.Closeable, defpackage.qn6, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() {
        if (!this.g) {
            this.g = true;
            this.h.close();
            vm6 vm6 = this.f;
            vm6.d(vm6.g);
        }
    }

    @Override // defpackage.ym6
    public void d(long j) {
        if (!this.g) {
            while (j > 0) {
                vm6 vm6 = this.f;
                if (vm6.g == 0 && this.h.read(vm6, (long) RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST) == -1) {
                    throw new EOFException();
                }
                long min = Math.min(j, this.f.g);
                this.f.d(min);
                j -= min;
            }
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    public long e() {
        int i;
        e1(1);
        long j = 0;
        while (true) {
            long j2 = j + 1;
            if (!g(j2)) {
                break;
            }
            byte e = this.f.e(j);
            if ((e >= ((byte) 48) && e <= ((byte) 57)) || (j == 0 && e == ((byte) 45))) {
                j = j2;
            } else if (i == 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("Expected leading [0-9] or '-' character but was 0x");
                hd3.F(16);
                hd3.F(16);
                String num = Integer.toString(e, 16);
                n86.b(num, "java.lang.Integer.toStri…(this, checkRadix(radix))");
                sb.append(num);
                throw new NumberFormatException(sb.toString());
            }
        }
        return this.f.k();
    }

    @Override // defpackage.ym6
    public void e1(long j) {
        if (!g(j)) {
            throw new EOFException();
        }
    }

    public int f() {
        e1(4);
        int readInt = this.f.readInt();
        return ((readInt & Constants.MAX_HOST_LENGTH) << 24) | ((-16777216 & readInt) >>> 24) | ((16711680 & readInt) >>> 8) | ((65280 & readInt) << 8);
    }

    public boolean g(long j) {
        vm6 vm6;
        if (!(j >= 0)) {
            throw new IllegalArgumentException(hj1.M("byteCount < 0: ", j).toString());
        } else if (!this.g) {
            do {
                vm6 = this.f;
                if (vm6.g >= j) {
                    return true;
                }
            } while (this.h.read(vm6, (long) RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST) != -1);
            return false;
        } else {
            throw new IllegalStateException("closed".toString());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003a  */
    @Override // defpackage.ym6
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long h1() {
        /*
        // Method dump skipped, instructions count: 105
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.kn6.h1():long");
    }

    public boolean isOpen() {
        return !this.g;
    }

    @Override // defpackage.ym6
    public InputStream j1() {
        return new a(this);
    }

    @Override // defpackage.ym6
    public int k1(hn6 hn6) {
        n86.f(hn6, "options");
        if (!this.g) {
            while (true) {
                int b = sn6.b(this.f, hn6, true);
                if (b == -2) {
                    if (this.h.read(this.f, (long) RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST) == -1) {
                        break;
                    }
                } else if (b != -1) {
                    this.f.d((long) hn6.f[b].g());
                    return b;
                }
            }
            return -1;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // defpackage.ym6
    public String p0(Charset charset) {
        n86.f(charset, "charset");
        this.f.t0(this.h);
        vm6 vm6 = this.f;
        Objects.requireNonNull(vm6);
        n86.f(charset, "charset");
        return vm6.m(vm6.g, charset);
    }

    @Override // defpackage.qn6
    public long read(vm6 vm6, long j) {
        n86.f(vm6, "sink");
        if (!(j >= 0)) {
            throw new IllegalArgumentException(hj1.M("byteCount < 0: ", j).toString());
        } else if (!this.g) {
            vm6 vm62 = this.f;
            if (vm62.g == 0 && this.h.read(vm62, (long) RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST) == -1) {
                return -1;
            }
            return this.f.read(vm6, Math.min(j, this.f.g));
        } else {
            throw new IllegalStateException("closed".toString());
        }
    }

    @Override // defpackage.ym6
    public byte readByte() {
        e1(1);
        return this.f.readByte();
    }

    @Override // defpackage.ym6
    public void readFully(byte[] bArr) {
        n86.f(bArr, "sink");
        try {
            e1((long) bArr.length);
            this.f.readFully(bArr);
        } catch (EOFException e) {
            int i = 0;
            while (true) {
                vm6 vm6 = this.f;
                long j = vm6.g;
                if (j > 0) {
                    int i2 = vm6.i(bArr, i, (int) j);
                    if (i2 != -1) {
                        i += i2;
                    } else {
                        throw new AssertionError();
                    }
                } else {
                    throw e;
                }
            }
        }
    }

    @Override // defpackage.ym6
    public int readInt() {
        e1(4);
        return this.f.readInt();
    }

    @Override // defpackage.ym6
    public long readLong() {
        e1(8);
        return this.f.readLong();
    }

    @Override // defpackage.ym6
    public short readShort() {
        e1(2);
        return this.f.readShort();
    }

    @Override // defpackage.qn6
    public rn6 timeout() {
        return this.h.timeout();
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("buffer(");
        i0.append(this.h);
        i0.append(')');
        return i0.toString();
    }

    @Override // defpackage.ym6
    public zm6 v(long j) {
        if (g(j)) {
            return this.f.v(j);
        }
        throw new EOFException();
    }

    @Override // defpackage.ym6
    public zm6 v0() {
        this.f.t0(this.h);
        return this.f.v0();
    }

    /* renamed from: kn6$a */
    /* compiled from: RealBufferedSource.kt */
    public static final class a extends InputStream {
        public final /* synthetic */ kn6 f;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public a(kn6 kn6) {
            this.f = kn6;
        }

        @Override // java.io.InputStream
        public int available() {
            kn6 kn6 = this.f;
            if (!kn6.g) {
                return (int) Math.min(kn6.f.g, (long) Integer.MAX_VALUE);
            }
            throw new IOException("closed");
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
        public void close() {
            this.f.close();
        }

        @Override // java.io.InputStream
        public int read() {
            kn6 kn6 = this.f;
            if (!kn6.g) {
                vm6 vm6 = kn6.f;
                if (vm6.g == 0 && kn6.h.read(vm6, (long) RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST) == -1) {
                    return -1;
                }
                return this.f.f.readByte() & 255;
            }
            throw new IOException("closed");
        }

        public String toString() {
            return this.f + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            n86.f(bArr, "data");
            if (!this.f.g) {
                ec6.l((long) bArr.length, (long) i, (long) i2);
                kn6 kn6 = this.f;
                vm6 vm6 = kn6.f;
                if (vm6.g == 0 && kn6.h.read(vm6, (long) RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST) == -1) {
                    return -1;
                }
                return this.f.f.i(bArr, i, i2);
            }
            throw new IOException("closed");
        }
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        n86.f(byteBuffer, "sink");
        vm6 vm6 = this.f;
        if (vm6.g == 0 && this.h.read(vm6, (long) RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST) == -1) {
            return -1;
        }
        return this.f.read(byteBuffer);
    }
}
