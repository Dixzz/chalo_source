package defpackage;

import java.io.OutputStream;

/* renamed from: lb3  reason: default package */
/* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
public final class lb3 extends OutputStream {
    public long f = 0;

    @Override // java.io.OutputStream
    public final void write(int i) {
        this.f++;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) {
        this.f += (long) bArr.length;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i, int i2) {
        int length;
        int i3;
        if (i < 0 || i > (length = bArr.length) || i2 < 0 || (i3 = i + i2) > length || i3 < 0) {
            throw new IndexOutOfBoundsException();
        }
        this.f += (long) i2;
    }
}
