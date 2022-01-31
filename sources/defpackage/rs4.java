package defpackage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: rs4  reason: default package */
public final class rs4 extends OutputStream {
    public final ot4 f = new ot4();
    public final File g;
    public final bu4 h;
    public long i;
    public long j;
    public FileOutputStream k;
    public gu4 l;

    public rs4(File file, bu4 bu4) {
        this.g = file;
        this.h = bu4;
    }

    @Override // java.io.OutputStream
    public final void write(int i2) throws IOException {
        write(new byte[]{(byte) i2});
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i2, int i3) throws IOException {
        int i4;
        while (i3 > 0) {
            if (this.i == 0 && this.j == 0) {
                int a2 = this.f.a(bArr, i2, i3);
                if (a2 != -1) {
                    i2 += a2;
                    i3 -= a2;
                    gu4 b = this.f.b();
                    this.l = b;
                    if (b.e) {
                        this.i = 0;
                        bu4 bu4 = this.h;
                        byte[] bArr2 = b.f;
                        bu4.k(bArr2, bArr2.length);
                        this.j = (long) this.l.f.length;
                    } else if (!b.b() || this.l.a()) {
                        byte[] bArr3 = this.l.f;
                        this.h.k(bArr3, bArr3.length);
                        this.i = this.l.b;
                    } else {
                        this.h.f(this.l.f);
                        File file = new File(this.g, this.l.f1305a);
                        file.getParentFile().mkdirs();
                        this.i = this.l.b;
                        this.k = new FileOutputStream(file);
                    }
                } else {
                    return;
                }
            }
            if (!this.l.a()) {
                gu4 gu4 = this.l;
                if (gu4.e) {
                    this.h.h(this.j, bArr, i2, i3);
                    this.j += (long) i3;
                    i4 = i3;
                } else if (gu4.b()) {
                    i4 = (int) Math.min((long) i3, this.i);
                    this.k.write(bArr, i2, i4);
                    long j2 = this.i - ((long) i4);
                    this.i = j2;
                    if (j2 == 0) {
                        this.k.close();
                    }
                } else {
                    i4 = (int) Math.min((long) i3, this.i);
                    gu4 gu42 = this.l;
                    int length = gu42.f.length;
                    this.h.h((((long) length) + gu42.b) - this.i, bArr, i2, i4);
                    this.i -= (long) i4;
                }
                i2 += i4;
                i3 -= i4;
            }
        }
    }
}
