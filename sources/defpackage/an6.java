package defpackage;

import java.io.IOException;
import java.util.zip.Deflater;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* renamed from: an6  reason: default package */
/* compiled from: DeflaterSink.kt */
public final class an6 implements on6 {
    public boolean f;
    public final xm6 g;
    public final Deflater h;

    public an6(on6 on6, Deflater deflater) {
        n86.f(on6, "sink");
        n86.f(deflater, "deflater");
        n86.f(on6, "$this$buffer");
        jn6 jn6 = new jn6(on6);
        n86.f(jn6, "sink");
        n86.f(deflater, "deflater");
        this.g = jn6;
        this.h = deflater;
    }

    @IgnoreJRERequirement
    public final void a(boolean z) {
        ln6 r;
        int i;
        vm6 b = this.g.b();
        while (true) {
            r = b.r(1);
            if (z) {
                Deflater deflater = this.h;
                byte[] bArr = r.f2245a;
                int i2 = r.c;
                i = deflater.deflate(bArr, i2, 8192 - i2, 2);
            } else {
                Deflater deflater2 = this.h;
                byte[] bArr2 = r.f2245a;
                int i3 = r.c;
                i = deflater2.deflate(bArr2, i3, 8192 - i3);
            }
            if (i > 0) {
                r.c += i;
                b.g += (long) i;
                this.g.b0();
            } else if (this.h.needsInput()) {
                break;
            }
        }
        if (r.b == r.c) {
            b.f = r.a();
            mn6.a(r);
        }
    }

    @Override // defpackage.on6, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.f) {
            Throwable th = null;
            try {
                this.h.finish();
                a(false);
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.h.end();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            try {
                this.g.close();
            } catch (Throwable th4) {
                if (th == null) {
                    th = th4;
                }
            }
            this.f = true;
            if (th != null) {
                throw th;
            }
        }
    }

    @Override // defpackage.on6, java.io.Flushable
    public void flush() throws IOException {
        a(true);
        this.g.flush();
    }

    @Override // defpackage.on6
    public void s0(vm6 vm6, long j) throws IOException {
        n86.f(vm6, "source");
        ec6.l(vm6.g, 0, j);
        while (j > 0) {
            ln6 ln6 = vm6.f;
            if (ln6 != null) {
                int min = (int) Math.min(j, (long) (ln6.c - ln6.b));
                this.h.setInput(ln6.f2245a, ln6.b, min);
                a(false);
                long j2 = (long) min;
                vm6.g -= j2;
                int i = ln6.b + min;
                ln6.b = i;
                if (i == ln6.c) {
                    vm6.f = ln6.a();
                    mn6.a(ln6);
                }
                j -= j2;
            } else {
                n86.k();
                throw null;
            }
        }
    }

    @Override // defpackage.on6
    public rn6 timeout() {
        return this.g.timeout();
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("DeflaterSink(");
        i0.append(this.g);
        i0.append(')');
        return i0.toString();
    }
}
