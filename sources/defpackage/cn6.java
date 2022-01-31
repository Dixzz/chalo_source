package defpackage;

import java.io.IOException;

/* renamed from: cn6  reason: default package */
/* compiled from: ForwardingSource.kt */
public abstract class cn6 implements qn6 {
    private final qn6 delegate;

    public cn6(qn6 qn6) {
        n86.f(qn6, "delegate");
        this.delegate = qn6;
    }

    /* renamed from: -deprecated_delegate  reason: not valid java name */
    public final qn6 m0deprecated_delegate() {
        return this.delegate;
    }

    @Override // java.io.Closeable, defpackage.qn6, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    public final qn6 delegate() {
        return this.delegate;
    }

    @Override // defpackage.qn6
    public long read(vm6 vm6, long j) throws IOException {
        n86.f(vm6, "sink");
        return this.delegate.read(vm6, j);
    }

    @Override // defpackage.qn6
    public rn6 timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.delegate + ')';
    }
}
