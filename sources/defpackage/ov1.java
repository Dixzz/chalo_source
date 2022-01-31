package defpackage;

import java.io.Closeable;
import java.io.IOException;
import javax.inject.Singleton;

@Singleton
/* renamed from: ov1  reason: default package */
/* compiled from: TransportRuntimeComponent */
public abstract class ov1 implements Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        ((dv1) this).k.get().close();
    }
}
