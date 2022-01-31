package defpackage;

import java.io.OutputStream;

/* renamed from: wm6  reason: default package */
/* compiled from: Buffer.kt */
public final class wm6 extends OutputStream {
    public final /* synthetic */ vm6 f;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    public wm6(vm6 vm6) {
        this.f = vm6;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
    }

    public String toString() {
        return this.f + ".outputStream()";
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        this.f.A(i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        n86.f(bArr, "data");
        this.f.x(bArr, i, i2);
    }
}
