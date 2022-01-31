package defpackage;

import java.io.IOException;
import java.io.InputStream;

/* renamed from: cw4  reason: default package */
public final class cw4 extends bw4 {
    public final bw4 f;
    public final long g;
    public final long h;

    public cw4(bw4 bw4, long j, long j2) {
        this.f = bw4;
        long e = e(j);
        this.g = e;
        this.h = e(e + j2);
    }

    @Override // defpackage.bw4
    public final long a() {
        return this.h - this.g;
    }

    @Override // defpackage.bw4
    public final InputStream c(long j, long j2) throws IOException {
        long e = e(this.g);
        return this.f.c(e, e(j2 + e) - e);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
    }

    public final long e(long j) {
        if (j < 0) {
            return 0;
        }
        return j > this.f.a() ? this.f.a() : j;
    }
}
