package defpackage;

import java.io.Closeable;
import java.io.IOException;

/* renamed from: qn6  reason: default package */
/* compiled from: Source.kt */
public interface qn6 extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    long read(vm6 vm6, long j) throws IOException;

    rn6 timeout();
}
