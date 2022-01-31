package defpackage;

import defpackage.vm6;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;

/* renamed from: om6  reason: default package */
/* compiled from: WebSocketReader.kt */
public final class om6 implements Closeable {
    public boolean f;
    public int g;
    public long h;
    public boolean i;
    public boolean j;
    public boolean k;
    public final vm6 l = new vm6();
    public final vm6 m = new vm6();
    public jm6 n;
    public final byte[] o;
    public final vm6.a p;
    public final boolean q;
    public final ym6 r;
    public final a s;
    public final boolean t;
    public final boolean u;

    /* renamed from: om6$a */
    /* compiled from: WebSocketReader.kt */
    public interface a {
        void b(zm6 zm6) throws IOException;

        void c(String str) throws IOException;

        void d(zm6 zm6);

        void e(zm6 zm6);

        void f(int i, String str);
    }

    public om6(boolean z, ym6 ym6, a aVar, boolean z2, boolean z3) {
        n86.f(ym6, "source");
        n86.f(aVar, "frameCallback");
        this.q = z;
        this.r = ym6;
        this.s = aVar;
        this.t = z2;
        this.u = z3;
        vm6.a aVar2 = null;
        this.o = z ? null : new byte[4];
        this.p = !z ? new vm6.a() : aVar2;
    }

    public final void a() throws IOException {
        String str;
        long j2 = this.h;
        String str2 = null;
        if (j2 > 0) {
            this.r.Y(this.l, j2);
            if (!this.q) {
                vm6 vm6 = this.l;
                vm6.a aVar = this.p;
                if (aVar != null) {
                    vm6.j(aVar);
                    this.p.c(0);
                    vm6.a aVar2 = this.p;
                    byte[] bArr = this.o;
                    if (bArr != null) {
                        nm6.a(aVar2, bArr);
                        this.p.close();
                    } else {
                        n86.k();
                        throw null;
                    }
                } else {
                    n86.k();
                    throw null;
                }
            }
        }
        switch (this.g) {
            case 8:
                short s2 = 1005;
                vm6 vm62 = this.l;
                long j3 = vm62.g;
                if (j3 != 1) {
                    if (j3 != 0) {
                        s2 = vm62.readShort();
                        str = this.l.o();
                        if (s2 < 1000 || s2 >= 5000) {
                            str2 = hj1.I("Code must be in range [1000,5000): ", s2);
                        } else if ((1004 <= s2 && 1006 >= s2) || (1015 <= s2 && 2999 >= s2)) {
                            str2 = hj1.J("Code ", s2, " is reserved and may not be used.");
                        }
                        if (str2 != null) {
                            throw new ProtocolException(str2);
                        }
                    } else {
                        str = "";
                    }
                    this.s.f(s2, str);
                    this.f = true;
                    return;
                }
                throw new ProtocolException("Malformed close payload length of 1.");
            case 9:
                this.s.d(this.l.v0());
                return;
            case 10:
                this.s.e(this.l.v0());
                return;
            default:
                StringBuilder i0 = hj1.i0("Unknown control opcode: ");
                i0.append(vi6.w(this.g));
                throw new ProtocolException(i0.toString());
        }
    }

    /* JADX INFO: finally extract failed */
    public final void c() throws IOException, ProtocolException {
        if (!this.f) {
            long h2 = this.r.timeout().h();
            this.r.timeout().b();
            try {
                byte readByte = this.r.readByte();
                byte[] bArr = vi6.f3652a;
                int i2 = readByte & 255;
                this.r.timeout().g(h2, TimeUnit.NANOSECONDS);
                int i3 = i2 & 15;
                this.g = i3;
                boolean z = false;
                boolean z2 = (i2 & 128) != 0;
                this.i = z2;
                boolean z3 = (i2 & 8) != 0;
                this.j = z3;
                if (!z3 || z2) {
                    boolean z4 = (i2 & 64) != 0;
                    if (i3 == 1 || i3 == 2) {
                        if (!z4) {
                            this.k = false;
                        } else if (this.t) {
                            this.k = true;
                        } else {
                            throw new ProtocolException("Unexpected rsv1 flag");
                        }
                    } else if (z4) {
                        throw new ProtocolException("Unexpected rsv1 flag");
                    }
                    if (!((i2 & 32) != 0)) {
                        if (!((i2 & 16) != 0)) {
                            int readByte2 = this.r.readByte() & 255;
                            if ((readByte2 & 128) != 0) {
                                z = true;
                            }
                            if (z == this.q) {
                                throw new ProtocolException(this.q ? "Server-sent frames must not be masked." : "Client-sent frames must be masked.");
                            }
                            long j2 = (long) (readByte2 & 127);
                            this.h = j2;
                            if (j2 == ((long) 126)) {
                                this.h = (long) (this.r.readShort() & 65535);
                            } else if (j2 == ((long) 127)) {
                                long readLong = this.r.readLong();
                                this.h = readLong;
                                if (readLong < 0) {
                                    StringBuilder i0 = hj1.i0("Frame length 0x");
                                    String hexString = Long.toHexString(this.h);
                                    n86.b(hexString, "java.lang.Long.toHexString(this)");
                                    i0.append(hexString);
                                    i0.append(" > 0x7FFFFFFFFFFFFFFF");
                                    throw new ProtocolException(i0.toString());
                                }
                            }
                            if (this.j && this.h > 125) {
                                throw new ProtocolException("Control frame must be less than 125B.");
                            } else if (z) {
                                ym6 ym6 = this.r;
                                byte[] bArr2 = this.o;
                                if (bArr2 != null) {
                                    ym6.readFully(bArr2);
                                } else {
                                    n86.k();
                                    throw null;
                                }
                            }
                        } else {
                            throw new ProtocolException("Unexpected rsv3 flag");
                        }
                    } else {
                        throw new ProtocolException("Unexpected rsv2 flag");
                    }
                } else {
                    throw new ProtocolException("Control frames must be final.");
                }
            } catch (Throwable th) {
                this.r.timeout().g(h2, TimeUnit.NANOSECONDS);
                throw th;
            }
        } else {
            throw new IOException("closed");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        jm6 jm6 = this.n;
        if (jm6 != null) {
            jm6.h.close();
        }
    }
}
