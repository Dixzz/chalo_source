package defpackage;

import defpackage.nk6;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: xk6  reason: default package */
/* compiled from: Http2Reader.kt */
public final class xk6 implements Closeable {
    public static final Logger j;
    public static final xk6 k = null;
    public final a f;
    public final nk6.a g;
    public final ym6 h;
    public final boolean i;

    /* renamed from: xk6$a */
    /* compiled from: Http2Reader.kt */
    public static final class a implements qn6 {
        public int f;
        public int g;
        public int h;
        public int i;
        public int j;
        public final ym6 k;

        public a(ym6 ym6) {
            n86.f(ym6, "source");
            this.k = ym6;
        }

        @Override // java.io.Closeable, defpackage.qn6, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        @Override // defpackage.qn6
        public long read(vm6 vm6, long j2) throws IOException {
            int i2;
            int readInt;
            n86.f(vm6, "sink");
            do {
                int i3 = this.i;
                if (i3 == 0) {
                    this.k.d((long) this.j);
                    this.j = 0;
                    if ((this.g & 4) != 0) {
                        return -1;
                    }
                    i2 = this.h;
                    int s = vi6.s(this.k);
                    this.i = s;
                    this.f = s;
                    int readByte = this.k.readByte() & 255;
                    this.g = this.k.readByte() & 255;
                    xk6 xk6 = xk6.k;
                    Logger logger = xk6.j;
                    if (logger.isLoggable(Level.FINE)) {
                        logger.fine(ok6.e.b(true, this.h, this.f, readByte, this.g));
                    }
                    readInt = this.k.readInt() & Integer.MAX_VALUE;
                    this.h = readInt;
                    if (readByte != 9) {
                        throw new IOException(readByte + " != TYPE_CONTINUATION");
                    }
                } else {
                    long read = this.k.read(vm6, Math.min(j2, (long) i3));
                    if (read == -1) {
                        return -1;
                    }
                    this.i -= (int) read;
                    return read;
                }
            } while (readInt == i2);
            throw new IOException("TYPE_CONTINUATION streamId changed");
        }

        @Override // defpackage.qn6
        public rn6 timeout() {
            return this.k.timeout();
        }
    }

    /* renamed from: xk6$b */
    /* compiled from: Http2Reader.kt */
    public interface b {
        void a();

        void c(boolean z, dl6 dl6);

        void d(boolean z, int i, int i2, List<mk6> list);

        void f(int i, long j);

        void g(boolean z, int i, ym6 ym6, int i2) throws IOException;

        void h(boolean z, int i, int i2);

        void i(int i, int i2, int i3, boolean z);

        void j(int i, lk6 lk6);

        void k(int i, int i2, List<mk6> list) throws IOException;

        void l(int i, lk6 lk6, zm6 zm6);
    }

    static {
        Logger logger = Logger.getLogger(ok6.class.getName());
        n86.b(logger, "Logger.getLogger(Http2::class.java.name)");
        j = logger;
    }

    public xk6(ym6 ym6, boolean z) {
        n86.f(ym6, "source");
        this.h = ym6;
        this.i = z;
        a aVar = new a(ym6);
        this.f = aVar;
        this.g = new nk6.a(aVar, 4096, 0, 4);
    }

    public final boolean a(boolean z, b bVar) throws IOException {
        int readInt;
        n86.f(bVar, "handler");
        int i2 = 0;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        try {
            this.h.e1(9);
            int s = vi6.s(this.h);
            if (s <= 16384) {
                int readByte = this.h.readByte() & 255;
                int readByte2 = this.h.readByte() & 255;
                int readInt2 = this.h.readInt() & Integer.MAX_VALUE;
                Logger logger = j;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(ok6.e.b(true, readInt2, s, readByte, readByte2));
                }
                if (!z || readByte == 4) {
                    switch (readByte) {
                        case 0:
                            if (readInt2 != 0) {
                                boolean z3 = (readByte2 & 1) != 0;
                                if (!((readByte2 & 32) != 0)) {
                                    int i5 = readByte2 & 8;
                                    if (i5 != 0) {
                                        byte readByte3 = this.h.readByte();
                                        byte[] bArr = vi6.f3652a;
                                        i2 = readByte3 & 255;
                                    }
                                    if (i5 != 0) {
                                        s--;
                                    }
                                    if (i2 <= s) {
                                        bVar.g(z3, readInt2, this.h, s - i2);
                                        this.h.d((long) i2);
                                        break;
                                    } else {
                                        throw new IOException(hj1.L("PROTOCOL_ERROR padding ", i2, " > remaining length ", s));
                                    }
                                } else {
                                    throw new IOException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA");
                                }
                            } else {
                                throw new IOException("PROTOCOL_ERROR: TYPE_DATA streamId == 0");
                            }
                        case 1:
                            if (readInt2 != 0) {
                                boolean z4 = (readByte2 & 1) != 0;
                                int i6 = readByte2 & 8;
                                if (i6 != 0) {
                                    byte readByte4 = this.h.readByte();
                                    byte[] bArr2 = vi6.f3652a;
                                    i4 = readByte4 & 255;
                                }
                                if ((readByte2 & 32) != 0) {
                                    f(bVar, readInt2);
                                    s -= 5;
                                }
                                if (i6 != 0) {
                                    s--;
                                }
                                if (i4 <= s) {
                                    bVar.d(z4, readInt2, -1, e(s - i4, i4, readByte2, readInt2));
                                    break;
                                } else {
                                    throw new IOException(hj1.L("PROTOCOL_ERROR padding ", i4, " > remaining length ", s));
                                }
                            } else {
                                throw new IOException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0");
                            }
                        case 2:
                            if (s != 5) {
                                throw new IOException(hj1.J("TYPE_PRIORITY length: ", s, " != 5"));
                            } else if (readInt2 != 0) {
                                f(bVar, readInt2);
                                break;
                            } else {
                                throw new IOException("TYPE_PRIORITY streamId == 0");
                            }
                        case 3:
                            if (s != 4) {
                                throw new IOException(hj1.J("TYPE_RST_STREAM length: ", s, " != 4"));
                            } else if (readInt2 != 0) {
                                int readInt3 = this.h.readInt();
                                lk6 a2 = lk6.Companion.a(readInt3);
                                if (a2 != null) {
                                    bVar.j(readInt2, a2);
                                    break;
                                } else {
                                    throw new IOException(hj1.I("TYPE_RST_STREAM unexpected error code: ", readInt3));
                                }
                            } else {
                                throw new IOException("TYPE_RST_STREAM streamId == 0");
                            }
                        case 4:
                            if (readInt2 != 0) {
                                throw new IOException("TYPE_SETTINGS streamId != 0");
                            } else if ((readByte2 & 1) != 0) {
                                if (s == 0) {
                                    bVar.a();
                                    break;
                                } else {
                                    throw new IOException("FRAME_SIZE_ERROR ack frame should be empty!");
                                }
                            } else if (s % 6 == 0) {
                                dl6 dl6 = new dl6();
                                i96 d = l96.d(l96.e(0, s), 6);
                                int i7 = d.f;
                                int i8 = d.g;
                                int i9 = d.h;
                                if (i9 < 0 ? i7 >= i8 : i7 <= i8) {
                                    while (true) {
                                        short readShort = this.h.readShort();
                                        byte[] bArr3 = vi6.f3652a;
                                        int i10 = readShort & 65535;
                                        readInt = this.h.readInt();
                                        if (i10 != 2) {
                                            if (i10 == 3) {
                                                i10 = 4;
                                            } else if (i10 == 4) {
                                                i10 = 7;
                                                if (readInt < 0) {
                                                    throw new IOException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1");
                                                }
                                            } else if (i10 == 5 && (readInt < 16384 || readInt > 16777215)) {
                                            }
                                        } else if (!(readInt == 0 || readInt == 1)) {
                                            throw new IOException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1");
                                        }
                                        dl6.c(i10, readInt);
                                        if (i7 != i8) {
                                            i7 += i9;
                                        }
                                    }
                                    throw new IOException(hj1.I("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: ", readInt));
                                }
                                bVar.c(false, dl6);
                                break;
                            } else {
                                throw new IOException(hj1.I("TYPE_SETTINGS length % 6 != 0: ", s));
                            }
                        case 5:
                            if (readInt2 != 0) {
                                int i11 = readByte2 & 8;
                                if (i11 != 0) {
                                    byte readByte5 = this.h.readByte();
                                    byte[] bArr4 = vi6.f3652a;
                                    i3 = readByte5 & 255;
                                }
                                int readInt4 = this.h.readInt() & Integer.MAX_VALUE;
                                int i12 = s - 4;
                                if (i11 != 0) {
                                    i12--;
                                }
                                if (i3 <= i12) {
                                    bVar.k(readInt2, readInt4, e(i12 - i3, i3, readByte2, readInt2));
                                    break;
                                } else {
                                    throw new IOException(hj1.L("PROTOCOL_ERROR padding ", i3, " > remaining length ", i12));
                                }
                            } else {
                                throw new IOException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0");
                            }
                        case 6:
                            if (s != 8) {
                                throw new IOException(hj1.I("TYPE_PING length != 8: ", s));
                            } else if (readInt2 == 0) {
                                int readInt5 = this.h.readInt();
                                int readInt6 = this.h.readInt();
                                if ((readByte2 & 1) != 0) {
                                    z2 = true;
                                }
                                bVar.h(z2, readInt5, readInt6);
                                break;
                            } else {
                                throw new IOException("TYPE_PING streamId != 0");
                            }
                        case 7:
                            if (s < 8) {
                                throw new IOException(hj1.I("TYPE_GOAWAY length < 8: ", s));
                            } else if (readInt2 == 0) {
                                int readInt7 = this.h.readInt();
                                int readInt8 = this.h.readInt();
                                int i13 = s - 8;
                                lk6 a3 = lk6.Companion.a(readInt8);
                                if (a3 != null) {
                                    zm6 zm6 = zm6.i;
                                    if (i13 > 0) {
                                        zm6 = this.h.v((long) i13);
                                    }
                                    bVar.l(readInt7, a3, zm6);
                                    break;
                                } else {
                                    throw new IOException(hj1.I("TYPE_GOAWAY unexpected error code: ", readInt8));
                                }
                            } else {
                                throw new IOException("TYPE_GOAWAY streamId != 0");
                            }
                        case 8:
                            if (s == 4) {
                                int readInt9 = this.h.readInt();
                                byte[] bArr5 = vi6.f3652a;
                                long j2 = ((long) readInt9) & 2147483647L;
                                if (j2 != 0) {
                                    bVar.f(readInt2, j2);
                                    break;
                                } else {
                                    throw new IOException("windowSizeIncrement was 0");
                                }
                            } else {
                                throw new IOException(hj1.I("TYPE_WINDOW_UPDATE length !=4: ", s));
                            }
                        default:
                            this.h.d((long) s);
                            break;
                    }
                    return true;
                }
                StringBuilder i0 = hj1.i0("Expected a SETTINGS frame but was ");
                i0.append(ok6.e.a(readByte));
                throw new IOException(i0.toString());
            }
            throw new IOException(hj1.I("FRAME_SIZE_ERROR: ", s));
        } catch (EOFException unused) {
            return false;
        }
    }

    public final void c(b bVar) throws IOException {
        n86.f(bVar, "handler");
        if (!this.i) {
            ym6 ym6 = this.h;
            zm6 zm6 = ok6.f2707a;
            zm6 v = ym6.v((long) zm6.g());
            Logger logger = j;
            if (logger.isLoggable(Level.FINE)) {
                StringBuilder i0 = hj1.i0("<< CONNECTION ");
                i0.append(v.h());
                logger.fine(vi6.i(i0.toString(), new Object[0]));
            }
            if (!n86.a(zm6, v)) {
                StringBuilder i02 = hj1.i0("Expected a connection header but was ");
                i02.append(v.p());
                throw new IOException(i02.toString());
            }
        } else if (!a(true, bVar)) {
            throw new IOException("Required SETTINGS preface not received");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.h.close();
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<defpackage.mk6> e(int r2, int r3, int r4, int r5) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 328
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xk6.e(int, int, int, int):java.util.List");
    }

    public final void f(b bVar, int i2) throws IOException {
        int readInt = this.h.readInt();
        boolean z = (readInt & ((int) 2147483648L)) != 0;
        byte readByte = this.h.readByte();
        byte[] bArr = vi6.f3652a;
        bVar.i(i2, readInt & Integer.MAX_VALUE, (readByte & 255) + 1, z);
    }
}
