package defpackage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* renamed from: zi6  reason: default package */
/* compiled from: CacheInterceptor.kt */
public final class zi6 implements qn6 {
    public boolean f;
    public final /* synthetic */ ym6 g;
    public final /* synthetic */ aj6 h;
    public final /* synthetic */ xm6 i;

    public zi6(ym6 ym6, aj6 aj6, xm6 xm6) {
        this.g = ym6;
        this.h = aj6;
        this.i = xm6;
    }

    @Override // java.io.Closeable, defpackage.qn6, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.f && !vi6.h(this, 100, TimeUnit.MILLISECONDS)) {
            this.f = true;
            this.h.abort();
        }
        this.g.close();
    }

    @Override // defpackage.qn6
    public long read(vm6 vm6, long j) throws IOException {
        n86.f(vm6, "sink");
        try {
            long read = this.g.read(vm6, j);
            if (read == -1) {
                if (!this.f) {
                    this.f = true;
                    this.i.close();
                }
                return -1;
            }
            vm6.c(this.i.b(), vm6.g - read, read);
            this.i.b0();
            return read;
        } catch (IOException e) {
            if (!this.f) {
                this.f = true;
                this.h.abort();
            }
            throw e;
        }
    }

    @Override // defpackage.qn6
    public rn6 timeout() {
        return this.g.timeout();
    }
}
