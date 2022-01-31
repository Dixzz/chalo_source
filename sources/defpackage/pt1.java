package defpackage;

import androidx.appcompat.widget.RtlSpacingHelper;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: pt1  reason: default package */
/* compiled from: MarkEnforcingInputStream */
public class pt1 extends FilterInputStream {
    public int f = RtlSpacingHelper.UNDEFINED;

    public pt1(InputStream inputStream) {
        super(inputStream);
    }

    public final long a(long j) {
        int i = this.f;
        if (i == 0) {
            return -1;
        }
        return (i == Integer.MIN_VALUE || j <= ((long) i)) ? j : (long) i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        int i = this.f;
        if (i == Integer.MIN_VALUE) {
            return super.available();
        }
        return Math.min(i, super.available());
    }

    public final void c(long j) {
        int i = this.f;
        if (i != Integer.MIN_VALUE && j != -1) {
            this.f = (int) (((long) i) - j);
        }
    }

    public void mark(int i) {
        super.mark(i);
        this.f = i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (a(1) == -1) {
            return -1;
        }
        int read = super.read();
        c(1);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        super.reset();
        this.f = RtlSpacingHelper.UNDEFINED;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        long a2 = a(j);
        if (a2 == -1) {
            return -1;
        }
        long skip = super.skip(a2);
        c(skip);
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int a2 = (int) a((long) i2);
        if (a2 == -1) {
            return -1;
        }
        int read = super.read(bArr, i, a2);
        c((long) read);
        return read;
    }
}
