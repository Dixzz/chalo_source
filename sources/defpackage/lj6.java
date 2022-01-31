package defpackage;

import com.razorpay.AnalyticsConstants;
import defpackage.km6;
import defpackage.ni6;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Socket;
import java.net.SocketException;
import java.util.Objects;

/* renamed from: lj6  reason: default package */
/* compiled from: Exchange.kt */
public final class lj6 {

    /* renamed from: a  reason: collision with root package name */
    public boolean f2229a;
    public final sj6 b;
    public final nj6 c;
    public final xh6 d;
    public final mj6 e;
    public final bk6 f;

    /* renamed from: lj6$a */
    /* compiled from: Exchange.kt */
    public final class a extends bn6 {
        public boolean g;
        public long h;
        public boolean i;
        public final long j;
        public final /* synthetic */ lj6 k;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(lj6 lj6, on6 on6, long j2) {
            super(on6);
            n86.f(on6, "delegate");
            this.k = lj6;
            this.j = j2;
        }

        public final <E extends IOException> E a(E e) {
            if (this.g) {
                return e;
            }
            this.g = true;
            return (E) this.k.a(this.h, false, true, e);
        }

        @Override // defpackage.on6, java.io.Closeable, defpackage.bn6, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!this.i) {
                this.i = true;
                long j2 = this.j;
                if (j2 == -1 || this.h == j2) {
                    try {
                        super.close();
                        a(null);
                    } catch (IOException e) {
                        throw a(e);
                    }
                } else {
                    throw new ProtocolException("unexpected end of stream");
                }
            }
        }

        @Override // defpackage.on6, defpackage.bn6, java.io.Flushable
        public void flush() throws IOException {
            try {
                super.flush();
            } catch (IOException e) {
                throw a(e);
            }
        }

        @Override // defpackage.on6, defpackage.bn6
        public void s0(vm6 vm6, long j2) throws IOException {
            n86.f(vm6, "source");
            if (!this.i) {
                long j3 = this.j;
                if (j3 == -1 || this.h + j2 <= j3) {
                    try {
                        super.s0(vm6, j2);
                        this.h += j2;
                    } catch (IOException e) {
                        throw a(e);
                    }
                } else {
                    StringBuilder i0 = hj1.i0("expected ");
                    i0.append(this.j);
                    i0.append(" bytes but received ");
                    i0.append(this.h + j2);
                    throw new ProtocolException(i0.toString());
                }
            } else {
                throw new IllegalStateException("closed".toString());
            }
        }
    }

    /* renamed from: lj6$b */
    /* compiled from: Exchange.kt */
    public final class b extends cn6 {
        public long f;
        public boolean g = true;
        public boolean h;
        public boolean i;
        public final long j;
        public final /* synthetic */ lj6 k;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(lj6 lj6, qn6 qn6, long j2) {
            super(qn6);
            n86.f(qn6, "delegate");
            this.k = lj6;
            this.j = j2;
            if (j2 == 0) {
                a(null);
            }
        }

        public final <E extends IOException> E a(E e) {
            if (this.h) {
                return e;
            }
            this.h = true;
            if (e == null && this.g) {
                this.g = false;
                lj6 lj6 = this.k;
                xh6 xh6 = lj6.d;
                nj6 nj6 = lj6.c;
                Objects.requireNonNull(xh6);
                n86.f(nj6, AnalyticsConstants.CALL);
            }
            return (E) this.k.a(this.f, true, false, e);
        }

        @Override // java.io.Closeable, defpackage.qn6, defpackage.cn6, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!this.i) {
                this.i = true;
                try {
                    super.close();
                    a(null);
                } catch (IOException e) {
                    throw a(e);
                }
            }
        }

        @Override // defpackage.qn6, defpackage.cn6
        public long read(vm6 vm6, long j2) throws IOException {
            n86.f(vm6, "sink");
            if (!this.i) {
                try {
                    long read = delegate().read(vm6, j2);
                    if (this.g) {
                        this.g = false;
                        lj6 lj6 = this.k;
                        xh6 xh6 = lj6.d;
                        nj6 nj6 = lj6.c;
                        Objects.requireNonNull(xh6);
                        n86.f(nj6, AnalyticsConstants.CALL);
                    }
                    if (read == -1) {
                        a(null);
                        return -1;
                    }
                    long j3 = this.f + read;
                    long j4 = this.j;
                    if (j4 != -1) {
                        if (j3 > j4) {
                            throw new ProtocolException("expected " + this.j + " bytes but received " + j3);
                        }
                    }
                    this.f = j3;
                    if (j3 == j4) {
                        a(null);
                    }
                    return read;
                } catch (IOException e) {
                    throw a(e);
                }
            } else {
                throw new IllegalStateException("closed".toString());
            }
        }
    }

    public lj6(nj6 nj6, xh6 xh6, mj6 mj6, bk6 bk6) {
        n86.f(nj6, AnalyticsConstants.CALL);
        n86.f(xh6, "eventListener");
        n86.f(mj6, "finder");
        n86.f(bk6, "codec");
        this.c = nj6;
        this.d = xh6;
        this.e = mj6;
        this.f = bk6;
        this.b = bk6.getConnection();
    }

    public final <E extends IOException> E a(long j, boolean z, boolean z2, E e2) {
        if (e2 != null) {
            g(e2);
        }
        if (z2) {
            if (e2 != null) {
                xh6 xh6 = this.d;
                nj6 nj6 = this.c;
                Objects.requireNonNull(xh6);
                n86.f(nj6, AnalyticsConstants.CALL);
                n86.f(e2, "ioe");
            } else {
                xh6 xh62 = this.d;
                nj6 nj62 = this.c;
                Objects.requireNonNull(xh62);
                n86.f(nj62, AnalyticsConstants.CALL);
            }
        }
        if (z) {
            if (e2 != null) {
                xh6 xh63 = this.d;
                nj6 nj63 = this.c;
                Objects.requireNonNull(xh63);
                n86.f(nj63, AnalyticsConstants.CALL);
                n86.f(e2, "ioe");
            } else {
                xh6 xh64 = this.d;
                nj6 nj64 = this.c;
                Objects.requireNonNull(xh64);
                n86.f(nj64, AnalyticsConstants.CALL);
            }
        }
        return (E) this.c.g(this, z2, z, e2);
    }

    public final on6 b(ji6 ji6, boolean z) throws IOException {
        n86.f(ji6, "request");
        this.f2229a = z;
        mi6 mi6 = ji6.e;
        if (mi6 != null) {
            long contentLength = mi6.contentLength();
            xh6 xh6 = this.d;
            nj6 nj6 = this.c;
            Objects.requireNonNull(xh6);
            n86.f(nj6, AnalyticsConstants.CALL);
            return new a(this, this.f.g(ji6, contentLength), contentLength);
        }
        n86.k();
        throw null;
    }

    public final void c() throws IOException {
        try {
            this.f.e();
        } catch (IOException e2) {
            xh6 xh6 = this.d;
            nj6 nj6 = this.c;
            Objects.requireNonNull(xh6);
            n86.f(nj6, AnalyticsConstants.CALL);
            n86.f(e2, "ioe");
            g(e2);
            throw e2;
        }
    }

    public final km6.c d() throws SocketException {
        this.c.j();
        sj6 connection = this.f.getConnection();
        Objects.requireNonNull(connection);
        n86.f(this, "exchange");
        Socket socket = connection.c;
        if (socket != null) {
            ym6 ym6 = connection.g;
            if (ym6 != null) {
                xm6 xm6 = connection.h;
                if (xm6 != null) {
                    socket.setSoTimeout(0);
                    connection.l();
                    return new rj6(this, ym6, xm6, true, ym6, xm6);
                }
                n86.k();
                throw null;
            }
            n86.k();
            throw null;
        }
        n86.k();
        throw null;
    }

    public final ni6.a e(boolean z) throws IOException {
        try {
            ni6.a d2 = this.f.d(z);
            if (d2 != null) {
                n86.f(this, "deferredTrailers");
                d2.m = this;
            }
            return d2;
        } catch (IOException e2) {
            xh6 xh6 = this.d;
            nj6 nj6 = this.c;
            Objects.requireNonNull(xh6);
            n86.f(nj6, AnalyticsConstants.CALL);
            n86.f(e2, "ioe");
            g(e2);
            throw e2;
        }
    }

    public final void f() {
        xh6 xh6 = this.d;
        nj6 nj6 = this.c;
        Objects.requireNonNull(xh6);
        n86.f(nj6, AnalyticsConstants.CALL);
    }

    public final void g(IOException iOException) {
        this.e.c(iOException);
        sj6 connection = this.f.getConnection();
        nj6 nj6 = this.c;
        synchronized (connection) {
            n86.f(nj6, AnalyticsConstants.CALL);
            if (iOException instanceof el6) {
                if (((el6) iOException).f == lk6.REFUSED_STREAM) {
                    int i = connection.m + 1;
                    connection.m = i;
                    if (i > 1) {
                        connection.i = true;
                        connection.k++;
                    }
                } else if (((el6) iOException).f != lk6.CANCEL || !nj6.r) {
                    connection.i = true;
                    connection.k++;
                }
            } else if (!connection.j() || (iOException instanceof kk6)) {
                connection.i = true;
                if (connection.l == 0) {
                    connection.d(nj6.u, connection.q, iOException);
                    connection.k++;
                }
            }
        }
    }
}
