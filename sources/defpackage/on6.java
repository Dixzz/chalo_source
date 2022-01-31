package defpackage;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

/* renamed from: on6  reason: default package */
/* compiled from: Sink.kt */
public interface on6 extends Closeable, Flushable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    @Override // java.io.Flushable
    void flush() throws IOException;

    void s0(vm6 vm6, long j) throws IOException;

    rn6 timeout();
}
