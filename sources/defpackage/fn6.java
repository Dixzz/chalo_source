package defpackage;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* renamed from: fn6  reason: default package */
/* compiled from: InflaterSource.kt */
public final class fn6 implements qn6 {
    public int f;
    public boolean g;
    public final ym6 h;
    public final Inflater i;

    public fn6(qn6 qn6, Inflater inflater) {
        n86.f(qn6, "source");
        n86.f(inflater, "inflater");
        n86.f(qn6, "$this$buffer");
        kn6 kn6 = new kn6(qn6);
        n86.f(kn6, "source");
        n86.f(inflater, "inflater");
        this.h = kn6;
        this.i = inflater;
    }

    public final long a(vm6 vm6, long j) throws IOException {
        n86.f(vm6, "sink");
        int i2 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(hj1.M("byteCount < 0: ", j).toString());
        } else if (!(!this.g)) {
            throw new IllegalStateException("closed".toString());
        } else if (i2 == 0) {
            return 0;
        } else {
            try {
                ln6 r = vm6.r(1);
                int min = (int) Math.min(j, (long) (8192 - r.c));
                c();
                int inflate = this.i.inflate(r.f2245a, r.c, min);
                int i3 = this.f;
                if (i3 != 0) {
                    int remaining = i3 - this.i.getRemaining();
                    this.f -= remaining;
                    this.h.d((long) remaining);
                }
                if (inflate > 0) {
                    r.c += inflate;
                    long j2 = (long) inflate;
                    vm6.g += j2;
                    return j2;
                }
                if (r.b == r.c) {
                    vm6.f = r.a();
                    mn6.a(r);
                }
                return 0;
            } catch (DataFormatException e) {
                throw new IOException(e);
            }
        }
    }

    public final boolean c() throws IOException {
        if (!this.i.needsInput()) {
            return false;
        }
        if (this.h.R()) {
            return true;
        }
        ln6 ln6 = this.h.b().f;
        if (ln6 != null) {
            int i2 = ln6.c;
            int i3 = ln6.b;
            int i4 = i2 - i3;
            this.f = i4;
            this.i.setInput(ln6.f2245a, i3, i4);
            return false;
        }
        n86.k();
        throw null;
    }

    @Override // java.io.Closeable, defpackage.qn6, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.g) {
            this.i.end();
            this.g = true;
            this.h.close();
        }
    }

    @Override // defpackage.qn6
    public long read(vm6 vm6, long j) throws IOException {
        n86.f(vm6, "sink");
        do {
            long a2 = a(vm6, j);
            if (a2 > 0) {
                return a2;
            }
            if (this.i.finished() || this.i.needsDictionary()) {
                return -1;
            }
        } while (!this.h.R());
        throw new EOFException("source exhausted prematurely");
    }

    @Override // defpackage.qn6
    public rn6 timeout() {
        return this.h.timeout();
    }

    public fn6(ym6 ym6, Inflater inflater) {
        n86.f(ym6, "source");
        n86.f(inflater, "inflater");
        this.h = ym6;
        this.i = inflater;
    }
}
