package defpackage;

import java.io.OutputStream;

/* renamed from: in6  reason: default package */
/* compiled from: JvmOkio.kt */
public final class in6 implements on6 {
    public final OutputStream f;
    public final rn6 g;

    public in6(OutputStream outputStream, rn6 rn6) {
        n86.f(outputStream, "out");
        n86.f(rn6, "timeout");
        this.f = outputStream;
        this.g = rn6;
    }

    @Override // defpackage.on6, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f.close();
    }

    @Override // defpackage.on6, java.io.Flushable
    public void flush() {
        this.f.flush();
    }

    @Override // defpackage.on6
    public void s0(vm6 vm6, long j) {
        n86.f(vm6, "source");
        ec6.l(vm6.g, 0, j);
        while (j > 0) {
            this.g.f();
            ln6 ln6 = vm6.f;
            if (ln6 != null) {
                int min = (int) Math.min(j, (long) (ln6.c - ln6.b));
                this.f.write(ln6.f2245a, ln6.b, min);
                int i = ln6.b + min;
                ln6.b = i;
                long j2 = (long) min;
                j -= j2;
                vm6.g -= j2;
                if (i == ln6.c) {
                    vm6.f = ln6.a();
                    mn6.a(ln6);
                }
            } else {
                n86.k();
                throw null;
            }
        }
    }

    @Override // defpackage.on6
    public rn6 timeout() {
        return this.g;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("sink(");
        i0.append(this.f);
        i0.append(')');
        return i0.toString();
    }
}
