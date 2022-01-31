package defpackage;

import java.io.Closeable;
import java.io.IOException;
import java.util.zip.Deflater;

/* renamed from: hm6  reason: default package */
/* compiled from: MessageDeflater.kt */
public final class hm6 implements Closeable {
    public final vm6 f;
    public final Deflater g;
    public final an6 h;
    public final boolean i;

    public hm6(boolean z) {
        this.i = z;
        vm6 vm6 = new vm6();
        this.f = vm6;
        Deflater deflater = new Deflater(-1, true);
        this.g = deflater;
        this.h = new an6(vm6, deflater);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.h.close();
    }
}
