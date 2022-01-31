package defpackage;

import com.google.firebase.perf.util.Constants;
import defpackage.nk6;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: zk6  reason: default package */
/* compiled from: Http2Writer.kt */
public final class zk6 implements Closeable {
    public static final Logger l = Logger.getLogger(ok6.class.getName());
    public final vm6 f;
    public int g = 16384;
    public boolean h;
    public final nk6.b i;
    public final xm6 j;
    public final boolean k;

    public zk6(xm6 xm6, boolean z) {
        n86.f(xm6, "sink");
        this.j = xm6;
        this.k = z;
        vm6 vm6 = new vm6();
        this.f = vm6;
        this.i = new nk6.b(0, false, vm6, 3);
    }

    public final synchronized void a(dl6 dl6) throws IOException {
        n86.f(dl6, "peerSettings");
        if (!this.h) {
            int i2 = this.g;
            int i3 = dl6.f855a;
            if ((i3 & 32) != 0) {
                i2 = dl6.b[5];
            }
            this.g = i2;
            int i4 = i3 & 2;
            int i5 = -1;
            if ((i4 != 0 ? dl6.b[1] : -1) != -1) {
                nk6.b bVar = this.i;
                if (i4 != 0) {
                    i5 = dl6.b[1];
                }
                bVar.h = i5;
                int min = Math.min(i5, 16384);
                int i6 = bVar.c;
                if (i6 != min) {
                    if (min < i6) {
                        bVar.f2571a = Math.min(bVar.f2571a, min);
                    }
                    bVar.b = true;
                    bVar.c = min;
                    int i7 = bVar.g;
                    if (min < i7) {
                        if (min == 0) {
                            bVar.a();
                        } else {
                            bVar.b(i7 - min);
                        }
                    }
                }
            }
            e(0, 0, 4, 1);
            this.j.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void c(boolean z, int i2, vm6 vm6, int i3) throws IOException {
        if (!this.h) {
            e(i2, i3, 0, z ? 1 : 0);
            if (i3 > 0) {
                xm6 xm6 = this.j;
                if (vm6 != null) {
                    xm6.s0(vm6, (long) i3);
                } else {
                    n86.k();
                    throw null;
                }
            }
        } else {
            throw new IOException("closed");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.h = true;
        this.j.close();
    }

    public final void e(int i2, int i3, int i4, int i5) throws IOException {
        Logger logger = l;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(ok6.e.b(false, i2, i3, i4, i5));
        }
        boolean z = true;
        if (i3 <= this.g) {
            if ((((int) 2147483648L) & i2) != 0) {
                z = false;
            }
            if (z) {
                xm6 xm6 = this.j;
                byte[] bArr = vi6.f3652a;
                n86.f(xm6, "$this$writeMedium");
                xm6.S((i3 >>> 16) & Constants.MAX_HOST_LENGTH);
                xm6.S((i3 >>> 8) & Constants.MAX_HOST_LENGTH);
                xm6.S(i3 & Constants.MAX_HOST_LENGTH);
                this.j.S(i4 & Constants.MAX_HOST_LENGTH);
                this.j.S(i5 & Constants.MAX_HOST_LENGTH);
                this.j.H(i2 & Integer.MAX_VALUE);
                return;
            }
            throw new IllegalArgumentException(hj1.I("reserved bit set: ", i2).toString());
        }
        StringBuilder i0 = hj1.i0("FRAME_SIZE_ERROR length > ");
        i0.append(this.g);
        i0.append(": ");
        i0.append(i3);
        throw new IllegalArgumentException(i0.toString().toString());
    }

    public final synchronized void f(int i2, lk6 lk6, byte[] bArr) throws IOException {
        n86.f(lk6, "errorCode");
        n86.f(bArr, "debugData");
        if (!this.h) {
            boolean z = false;
            if (lk6.getHttpCode() != -1) {
                e(0, bArr.length + 8, 7, 0);
                this.j.H(i2);
                this.j.H(lk6.getHttpCode());
                if (bArr.length == 0) {
                    z = true;
                }
                if (!z) {
                    this.j.N0(bArr);
                }
                this.j.flush();
            } else {
                throw new IllegalArgumentException("errorCode.httpCode == -1".toString());
            }
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void flush() throws IOException {
        if (!this.h) {
            this.j.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void g(boolean z, int i2, List<mk6> list) throws IOException {
        n86.f(list, "headerBlock");
        if (!this.h) {
            this.i.e(list);
            long j2 = this.f.g;
            long min = Math.min((long) this.g, j2);
            int i3 = (j2 > min ? 1 : (j2 == min ? 0 : -1));
            int i4 = i3 == 0 ? 4 : 0;
            if (z) {
                i4 |= 1;
            }
            e(i2, (int) min, 1, i4);
            this.j.s0(this.f, min);
            if (i3 > 0) {
                k(i2, j2 - min);
            }
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void h(boolean z, int i2, int i3) throws IOException {
        if (!this.h) {
            e(0, 8, 6, z ? 1 : 0);
            this.j.H(i2);
            this.j.H(i3);
            this.j.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void i(int i2, lk6 lk6) throws IOException {
        n86.f(lk6, "errorCode");
        if (!this.h) {
            if (lk6.getHttpCode() != -1) {
                e(i2, 4, 3, 0);
                this.j.H(lk6.getHttpCode());
                this.j.flush();
            } else {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void j(int i2, long j2) throws IOException {
        if (!this.h) {
            if (j2 != 0 && j2 <= 2147483647L) {
                e(i2, 4, 8, 0);
                this.j.H((int) j2);
                this.j.flush();
            } else {
                throw new IllegalArgumentException(("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: " + j2).toString());
            }
        } else {
            throw new IOException("closed");
        }
    }

    public final void k(int i2, long j2) throws IOException {
        while (j2 > 0) {
            long min = Math.min((long) this.g, j2);
            j2 -= min;
            e(i2, (int) min, 9, j2 == 0 ? 4 : 0);
            this.j.s0(this.f, min);
        }
    }
}
