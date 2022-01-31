package defpackage;

import java.io.IOException;
import java.io.InputStream;

/* renamed from: gn6  reason: default package */
/* compiled from: JvmOkio.kt */
public final class gn6 implements qn6 {
    public final InputStream f;
    public final rn6 g;

    public gn6(InputStream inputStream, rn6 rn6) {
        n86.f(inputStream, "input");
        n86.f(rn6, "timeout");
        this.f = inputStream;
        this.g = rn6;
    }

    @Override // java.io.Closeable, defpackage.qn6, java.lang.AutoCloseable
    public void close() {
        this.f.close();
    }

    @Override // defpackage.qn6
    public long read(vm6 vm6, long j) {
        n86.f(vm6, "sink");
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i == 0) {
            return 0;
        }
        if (i >= 0) {
            try {
                this.g.f();
                ln6 r = vm6.r(1);
                int read = this.f.read(r.f2245a, r.c, (int) Math.min(j, (long) (8192 - r.c)));
                if (read != -1) {
                    r.c += read;
                    long j2 = (long) read;
                    vm6.g += j2;
                    return j2;
                } else if (r.b != r.c) {
                    return -1;
                } else {
                    vm6.f = r.a();
                    mn6.a(r);
                    return -1;
                }
            } catch (AssertionError e) {
                if (ec6.s(e)) {
                    throw new IOException(e);
                }
                throw e;
            }
        } else {
            throw new IllegalArgumentException(hj1.M("byteCount < 0: ", j).toString());
        }
    }

    @Override // defpackage.qn6
    public rn6 timeout() {
        return this.g;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("source(");
        i0.append(this.f);
        i0.append(')');
        return i0.toString();
    }
}
