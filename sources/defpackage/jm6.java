package defpackage;

import java.io.Closeable;
import java.io.IOException;
import java.util.zip.Inflater;

/* renamed from: jm6  reason: default package */
/* compiled from: MessageInflater.kt */
public final class jm6 implements Closeable {
    public final vm6 f;
    public final Inflater g;
    public final fn6 h;
    public final boolean i;

    public jm6(boolean z) {
        this.i = z;
        vm6 vm6 = new vm6();
        this.f = vm6;
        Inflater inflater = new Inflater(true);
        this.g = inflater;
        this.h = new fn6((qn6) vm6, inflater);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.h.close();
    }
}
