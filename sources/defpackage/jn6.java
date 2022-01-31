package defpackage;

import androidx.recyclerview.widget.RecyclerView;
import java.nio.ByteBuffer;

/* renamed from: jn6  reason: default package */
/* compiled from: RealBufferedSink.kt */
public final class jn6 implements xm6 {
    public final vm6 f = new vm6();
    public boolean g;
    public final on6 h;

    public jn6(on6 on6) {
        n86.f(on6, "sink");
        this.h = on6;
    }

    @Override // defpackage.xm6
    public xm6 B() {
        if (!this.g) {
            vm6 vm6 = this.f;
            long j = vm6.g;
            if (j > 0) {
                this.h.s0(vm6, j);
            }
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // defpackage.xm6
    public xm6 C(int i) {
        if (!this.g) {
            this.f.K(i);
            b0();
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // defpackage.xm6
    public xm6 H(int i) {
        if (!this.g) {
            this.f.J(i);
            b0();
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // defpackage.xm6
    public xm6 N0(byte[] bArr) {
        n86.f(bArr, "source");
        if (!this.g) {
            this.f.w(bArr);
            b0();
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // defpackage.xm6
    public xm6 P0(zm6 zm6) {
        n86.f(zm6, "byteString");
        if (!this.g) {
            this.f.t(zm6);
            b0();
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // defpackage.xm6
    public xm6 S(int i) {
        if (!this.g) {
            this.f.A(i);
            b0();
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // defpackage.xm6
    public vm6 b() {
        return this.f;
    }

    @Override // defpackage.xm6
    public xm6 b0() {
        if (!this.g) {
            long a2 = this.f.a();
            if (a2 > 0) {
                this.h.s0(this.f, a2);
            }
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // defpackage.on6, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() {
        if (!this.g) {
            Throwable th = null;
            try {
                vm6 vm6 = this.f;
                long j = vm6.g;
                if (j > 0) {
                    this.h.s0(vm6, j);
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.h.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            this.g = true;
            if (th != null) {
                throw th;
            }
        }
    }

    @Override // defpackage.xm6
    public xm6 f1(long j) {
        if (!this.g) {
            this.f.f1(j);
            b0();
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // defpackage.xm6, defpackage.on6, java.io.Flushable
    public void flush() {
        if (!this.g) {
            vm6 vm6 = this.f;
            long j = vm6.g;
            if (j > 0) {
                this.h.s0(vm6, j);
            }
            this.h.flush();
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    public boolean isOpen() {
        return !this.g;
    }

    @Override // defpackage.xm6
    public xm6 k0(String str) {
        n86.f(str, "string");
        if (!this.g) {
            this.f.P(str);
            return b0();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // defpackage.xm6
    public xm6 r0(byte[] bArr, int i, int i2) {
        n86.f(bArr, "source");
        if (!this.g) {
            this.f.x(bArr, i, i2);
            b0();
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // defpackage.on6
    public void s0(vm6 vm6, long j) {
        n86.f(vm6, "source");
        if (!this.g) {
            this.f.s0(vm6, j);
            b0();
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // defpackage.xm6
    public long t0(qn6 qn6) {
        n86.f(qn6, "source");
        long j = 0;
        while (true) {
            long read = ((gn6) qn6).read(this.f, (long) RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST);
            if (read == -1) {
                return j;
            }
            j += read;
            b0();
        }
    }

    @Override // defpackage.on6
    public rn6 timeout() {
        return this.h.timeout();
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("buffer(");
        i0.append(this.h);
        i0.append(')');
        return i0.toString();
    }

    @Override // defpackage.xm6
    public xm6 u0(long j) {
        if (!this.g) {
            this.f.u0(j);
            return b0();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) {
        n86.f(byteBuffer, "source");
        if (!this.g) {
            int write = this.f.write(byteBuffer);
            b0();
            return write;
        }
        throw new IllegalStateException("closed".toString());
    }
}
