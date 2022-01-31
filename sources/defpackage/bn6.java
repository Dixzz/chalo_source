package defpackage;

import java.io.IOException;

/* renamed from: bn6  reason: default package */
/* compiled from: ForwardingSink.kt */
public abstract class bn6 implements on6 {
    public final on6 f;

    public bn6(on6 on6) {
        n86.f(on6, "delegate");
        this.f = on6;
    }

    @Override // defpackage.on6, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f.close();
    }

    @Override // defpackage.on6, java.io.Flushable
    public void flush() throws IOException {
        this.f.flush();
    }

    @Override // defpackage.on6
    public void s0(vm6 vm6, long j) throws IOException {
        n86.f(vm6, "source");
        this.f.s0(vm6, j);
    }

    @Override // defpackage.on6
    public rn6 timeout() {
        return this.f.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.f + ')';
    }
}
