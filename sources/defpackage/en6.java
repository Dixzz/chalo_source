package defpackage;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* renamed from: en6  reason: default package */
/* compiled from: GzipSource.kt */
public final class en6 implements qn6 {
    public byte f;
    public final kn6 g;
    public final Inflater h;
    public final fn6 i;
    public final CRC32 j = new CRC32();

    public en6(qn6 qn6) {
        n86.f(qn6, "source");
        kn6 kn6 = new kn6(qn6);
        this.g = kn6;
        Inflater inflater = new Inflater(true);
        this.h = inflater;
        this.i = new fn6((ym6) kn6, inflater);
    }

    public final void a(String str, int i2, int i3) {
        if (i3 != i2) {
            String format = String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(new Object[]{str, Integer.valueOf(i3), Integer.valueOf(i2)}, 3));
            n86.b(format, "java.lang.String.format(this, *args)");
            throw new IOException(format);
        }
    }

    public final void c(vm6 vm6, long j2, long j3) {
        ln6 ln6 = vm6.f;
        if (ln6 != null) {
            do {
                int i2 = ln6.c;
                int i3 = ln6.b;
                if (j2 >= ((long) (i2 - i3))) {
                    j2 -= (long) (i2 - i3);
                    ln6 = ln6.f;
                } else {
                    while (j3 > 0) {
                        int i4 = (int) (((long) ln6.b) + j2);
                        int min = (int) Math.min((long) (ln6.c - i4), j3);
                        this.j.update(ln6.f2245a, i4, min);
                        j3 -= (long) min;
                        ln6 = ln6.f;
                        if (ln6 != null) {
                            j2 = 0;
                        } else {
                            n86.k();
                            throw null;
                        }
                    }
                    return;
                }
            } while (ln6 != null);
            n86.k();
            throw null;
        }
        n86.k();
        throw null;
    }

    @Override // java.io.Closeable, defpackage.qn6, java.lang.AutoCloseable
    public void close() throws IOException {
        this.i.close();
    }

    @Override // defpackage.qn6
    public long read(vm6 vm6, long j2) throws IOException {
        long j3;
        n86.f(vm6, "sink");
        boolean z = false;
        int i2 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(hj1.M("byteCount < 0: ", j2).toString());
        } else if (i2 == 0) {
            return 0;
        } else {
            if (this.f == 0) {
                this.g.e1(10);
                byte e = this.g.f.e(3);
                boolean z2 = ((e >> 1) & 1) == 1;
                if (z2) {
                    c(this.g.f, 0, 10);
                }
                a("ID1ID2", 8075, this.g.readShort());
                this.g.d(8);
                if (((e >> 2) & 1) == 1) {
                    this.g.e1(2);
                    if (z2) {
                        c(this.g.f, 0, 2);
                    }
                    long l = (long) this.g.f.l();
                    this.g.e1(l);
                    if (z2) {
                        j3 = l;
                        c(this.g.f, 0, l);
                    } else {
                        j3 = l;
                    }
                    this.g.d(j3);
                }
                if (((e >> 3) & 1) == 1) {
                    long a2 = this.g.a((byte) 0, 0, Long.MAX_VALUE);
                    if (a2 != -1) {
                        if (z2) {
                            c(this.g.f, 0, a2 + 1);
                        }
                        this.g.d(a2 + 1);
                    } else {
                        throw new EOFException();
                    }
                }
                if (((e >> 4) & 1) == 1) {
                    z = true;
                }
                if (z) {
                    long a3 = this.g.a((byte) 0, 0, Long.MAX_VALUE);
                    if (a3 != -1) {
                        if (z2) {
                            c(this.g.f, 0, a3 + 1);
                        }
                        this.g.d(a3 + 1);
                    } else {
                        throw new EOFException();
                    }
                }
                if (z2) {
                    kn6 kn6 = this.g;
                    kn6.e1(2);
                    a("FHCRC", kn6.f.l(), (short) ((int) this.j.getValue()));
                    this.j.reset();
                }
                this.f = 1;
            }
            if (this.f == 1) {
                long j4 = vm6.g;
                long read = this.i.read(vm6, j2);
                if (read != -1) {
                    c(vm6, j4, read);
                    return read;
                }
                this.f = 2;
            }
            if (this.f == 2) {
                a("CRC", this.g.f(), (int) this.j.getValue());
                a("ISIZE", this.g.f(), (int) this.h.getBytesWritten());
                this.f = 3;
                if (!this.g.R()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1;
        }
    }

    @Override // defpackage.qn6
    public rn6 timeout() {
        return this.g.timeout();
    }
}
