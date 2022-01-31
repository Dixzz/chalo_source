package defpackage;

import defpackage.vm6;
import java.io.Closeable;
import java.io.IOException;
import java.util.Random;

/* renamed from: pm6  reason: default package */
/* compiled from: WebSocketWriter.kt */
public final class pm6 implements Closeable {
    public final vm6 f = new vm6();
    public final vm6 g;
    public boolean h;
    public hm6 i;
    public final byte[] j;
    public final vm6.a k;
    public final boolean l;
    public final xm6 m;
    public final Random n;
    public final boolean o;
    public final boolean p;
    public final long q;

    public pm6(boolean z, xm6 xm6, Random random, boolean z2, boolean z3, long j2) {
        n86.f(xm6, "sink");
        n86.f(random, "random");
        this.l = z;
        this.m = xm6;
        this.n = random;
        this.o = z2;
        this.p = z3;
        this.q = j2;
        this.g = xm6.b();
        vm6.a aVar = null;
        this.j = z ? new byte[4] : null;
        this.k = z ? new vm6.a() : aVar;
    }

    public final void a(int i2, zm6 zm6) throws IOException {
        String str;
        zm6 zm62 = zm6.i;
        if (!(i2 == 0 && zm6 == null)) {
            if (i2 != 0) {
                if (i2 < 1000 || i2 >= 5000) {
                    str = hj1.I("Code must be in range [1000,5000): ", i2);
                } else {
                    str = ((1004 > i2 || 1006 < i2) && (1015 > i2 || 2999 < i2)) ? null : hj1.J("Code ", i2, " is reserved and may not be used.");
                }
                if (!(str == null)) {
                    if (str == null) {
                        n86.k();
                        throw null;
                    }
                    throw new IllegalArgumentException(str.toString());
                }
            }
            vm6 vm6 = new vm6();
            vm6.K(i2);
            if (zm6 != null) {
                vm6.t(zm6);
            }
            zm62 = vm6.v0();
        }
        try {
            c(8, zm62);
        } finally {
            this.h = true;
        }
    }

    public final void c(int i2, zm6 zm6) throws IOException {
        if (!this.h) {
            int g2 = zm6.g();
            if (((long) g2) <= 125) {
                this.g.A(i2 | 128);
                if (this.l) {
                    this.g.A(g2 | 128);
                    Random random = this.n;
                    byte[] bArr = this.j;
                    if (bArr != null) {
                        random.nextBytes(bArr);
                        this.g.w(this.j);
                        if (g2 > 0) {
                            vm6 vm6 = this.g;
                            long j2 = vm6.g;
                            vm6.t(zm6);
                            vm6 vm62 = this.g;
                            vm6.a aVar = this.k;
                            if (aVar != null) {
                                vm62.j(aVar);
                                this.k.c(j2);
                                nm6.a(this.k, this.j);
                                this.k.close();
                            } else {
                                n86.k();
                                throw null;
                            }
                        }
                    } else {
                        n86.k();
                        throw null;
                    }
                } else {
                    this.g.A(g2);
                    this.g.t(zm6);
                }
                this.m.flush();
                return;
            }
            throw new IllegalArgumentException("Payload size must be less than or equal to 125".toString());
        }
        throw new IOException("closed");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        hm6 hm6 = this.i;
        if (hm6 != null) {
            hm6.h.close();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0085, code lost:
        r15 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0086, code lost:
        defpackage.hd3.H(r8, r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0089, code lost:
        throw r15;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void e(int r14, defpackage.zm6 r15) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 409
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.pm6.e(int, zm6):void");
    }
}
