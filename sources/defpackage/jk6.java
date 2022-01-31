package defpackage;

import defpackage.ni6;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* renamed from: jk6  reason: default package */
/* compiled from: Http1ExchangeCodec.kt */
public final class jk6 implements bk6 {

    /* renamed from: a  reason: collision with root package name */
    public int f1951a;
    public final ik6 b;
    public ci6 c;
    public final hi6 d;
    public final sj6 e;
    public final ym6 f;
    public final xm6 g;

    /* renamed from: jk6$a */
    /* compiled from: Http1ExchangeCodec.kt */
    public abstract class a implements qn6 {
        public final dn6 f;
        public boolean g;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public a() {
            this.f = new dn6(jk6.this.f.timeout());
        }

        public final void a() {
            jk6 jk6 = jk6.this;
            int i = jk6.f1951a;
            if (i != 6) {
                if (i == 5) {
                    jk6.h(jk6, this.f);
                    jk6.this.f1951a = 6;
                    return;
                }
                StringBuilder i0 = hj1.i0("state: ");
                i0.append(jk6.this.f1951a);
                throw new IllegalStateException(i0.toString());
            }
        }

        @Override // defpackage.qn6
        public long read(vm6 vm6, long j) {
            n86.f(vm6, "sink");
            try {
                return jk6.this.f.read(vm6, j);
            } catch (IOException e) {
                jk6.this.e.l();
                a();
                throw e;
            }
        }

        @Override // defpackage.qn6
        public rn6 timeout() {
            return this.f;
        }
    }

    /* renamed from: jk6$b */
    /* compiled from: Http1ExchangeCodec.kt */
    public final class b implements on6 {
        public final dn6 f;
        public boolean g;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public b() {
            this.f = new dn6(jk6.this.g.timeout());
        }

        @Override // defpackage.on6, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() {
            if (!this.g) {
                this.g = true;
                jk6.this.g.k0("0\r\n\r\n");
                jk6.h(jk6.this, this.f);
                jk6.this.f1951a = 3;
            }
        }

        @Override // defpackage.on6, java.io.Flushable
        public synchronized void flush() {
            if (!this.g) {
                jk6.this.g.flush();
            }
        }

        @Override // defpackage.on6
        public void s0(vm6 vm6, long j) {
            n86.f(vm6, "source");
            if (!(!this.g)) {
                throw new IllegalStateException("closed".toString());
            } else if (j != 0) {
                jk6.this.g.u0(j);
                jk6.this.g.k0("\r\n");
                jk6.this.g.s0(vm6, j);
                jk6.this.g.k0("\r\n");
            }
        }

        @Override // defpackage.on6
        public rn6 timeout() {
            return this.f;
        }
    }

    /* renamed from: jk6$c */
    /* compiled from: Http1ExchangeCodec.kt */
    public final class c extends a {
        public long i = -1;
        public boolean j = true;
        public final di6 k;
        public final /* synthetic */ jk6 l;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(jk6 jk6, di6 di6) {
            super();
            n86.f(di6, "url");
            this.l = jk6;
            this.k = di6;
        }

        @Override // java.io.Closeable, defpackage.qn6, java.lang.AutoCloseable
        public void close() {
            if (!this.g) {
                if (this.j && !vi6.h(this, 100, TimeUnit.MILLISECONDS)) {
                    this.l.e.l();
                    a();
                }
                this.g = true;
            }
        }

        @Override // defpackage.jk6.a, defpackage.qn6
        public long read(vm6 vm6, long j2) {
            n86.f(vm6, "sink");
            boolean z = true;
            if (!(j2 >= 0)) {
                throw new IllegalArgumentException(hj1.M("byteCount < 0: ", j2).toString());
            } else if (!(!this.g)) {
                throw new IllegalStateException("closed".toString());
            } else if (!this.j) {
                return -1;
            } else {
                long j3 = this.i;
                if (j3 == 0 || j3 == -1) {
                    if (j3 != -1) {
                        this.l.f.G0();
                    }
                    try {
                        this.i = this.l.f.h1();
                        String G0 = this.l.f.G0();
                        if (G0 != null) {
                            String obj = ea6.K(G0).toString();
                            if (this.i >= 0) {
                                if (obj.length() <= 0) {
                                    z = false;
                                }
                                if (!z || ea6.G(obj, ";", false, 2)) {
                                    if (this.i == 0) {
                                        this.j = false;
                                        jk6 jk6 = this.l;
                                        jk6.c = jk6.b.a();
                                        jk6 jk62 = this.l;
                                        hi6 hi6 = jk62.d;
                                        if (hi6 != null) {
                                            th6 th6 = hi6.o;
                                            di6 di6 = this.k;
                                            ci6 ci6 = jk62.c;
                                            if (ci6 != null) {
                                                ck6.d(th6, di6, ci6);
                                                a();
                                            } else {
                                                n86.k();
                                                throw null;
                                            }
                                        } else {
                                            n86.k();
                                            throw null;
                                        }
                                    }
                                    if (!this.j) {
                                        return -1;
                                    }
                                }
                            }
                            throw new ProtocolException("expected chunk size and optional extensions" + " but was \"" + this.i + obj + '\"');
                        }
                        throw new p56("null cannot be cast to non-null type kotlin.CharSequence");
                    } catch (NumberFormatException e) {
                        throw new ProtocolException(e.getMessage());
                    }
                }
                long read = super.read(vm6, Math.min(j2, this.i));
                if (read != -1) {
                    this.i -= read;
                    return read;
                }
                this.l.e.l();
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                a();
                throw protocolException;
            }
        }
    }

    /* renamed from: jk6$d */
    /* compiled from: Http1ExchangeCodec.kt */
    public final class d extends a {
        public long i;

        public d(long j2) {
            super();
            this.i = j2;
            if (j2 == 0) {
                a();
            }
        }

        @Override // java.io.Closeable, defpackage.qn6, java.lang.AutoCloseable
        public void close() {
            if (!this.g) {
                if (this.i != 0 && !vi6.h(this, 100, TimeUnit.MILLISECONDS)) {
                    jk6.this.e.l();
                    a();
                }
                this.g = true;
            }
        }

        @Override // defpackage.jk6.a, defpackage.qn6
        public long read(vm6 vm6, long j2) {
            n86.f(vm6, "sink");
            if (!(j2 >= 0)) {
                throw new IllegalArgumentException(hj1.M("byteCount < 0: ", j2).toString());
            } else if (!this.g) {
                long j3 = this.i;
                if (j3 == 0) {
                    return -1;
                }
                long read = super.read(vm6, Math.min(j3, j2));
                if (read != -1) {
                    long j4 = this.i - read;
                    this.i = j4;
                    if (j4 == 0) {
                        a();
                    }
                    return read;
                }
                jk6.this.e.l();
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                a();
                throw protocolException;
            } else {
                throw new IllegalStateException("closed".toString());
            }
        }
    }

    /* renamed from: jk6$e */
    /* compiled from: Http1ExchangeCodec.kt */
    public final class e implements on6 {
        public final dn6 f;
        public boolean g;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public e() {
            this.f = new dn6(jk6.this.g.timeout());
        }

        @Override // defpackage.on6, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (!this.g) {
                this.g = true;
                jk6.h(jk6.this, this.f);
                jk6.this.f1951a = 3;
            }
        }

        @Override // defpackage.on6, java.io.Flushable
        public void flush() {
            if (!this.g) {
                jk6.this.g.flush();
            }
        }

        @Override // defpackage.on6
        public void s0(vm6 vm6, long j) {
            n86.f(vm6, "source");
            if (!this.g) {
                vi6.b(vm6.g, 0, j);
                jk6.this.g.s0(vm6, j);
                return;
            }
            throw new IllegalStateException("closed".toString());
        }

        @Override // defpackage.on6
        public rn6 timeout() {
            return this.f;
        }
    }

    /* renamed from: jk6$f */
    /* compiled from: Http1ExchangeCodec.kt */
    public final class f extends a {
        public boolean i;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public f(jk6 jk6) {
            super();
        }

        @Override // java.io.Closeable, defpackage.qn6, java.lang.AutoCloseable
        public void close() {
            if (!this.g) {
                if (!this.i) {
                    a();
                }
                this.g = true;
            }
        }

        @Override // defpackage.jk6.a, defpackage.qn6
        public long read(vm6 vm6, long j) {
            n86.f(vm6, "sink");
            if (!(j >= 0)) {
                throw new IllegalArgumentException(hj1.M("byteCount < 0: ", j).toString());
            } else if (!(!this.g)) {
                throw new IllegalStateException("closed".toString());
            } else if (this.i) {
                return -1;
            } else {
                long read = super.read(vm6, j);
                if (read != -1) {
                    return read;
                }
                this.i = true;
                a();
                return -1;
            }
        }
    }

    public jk6(hi6 hi6, sj6 sj6, ym6 ym6, xm6 xm6) {
        n86.f(sj6, "connection");
        n86.f(ym6, "source");
        n86.f(xm6, "sink");
        this.d = hi6;
        this.e = sj6;
        this.f = ym6;
        this.g = xm6;
        this.b = new ik6(ym6);
    }

    public static final void h(jk6 jk6, dn6 dn6) {
        Objects.requireNonNull(jk6);
        rn6 rn6 = dn6.e;
        rn6 rn62 = rn6.d;
        n86.f(rn62, "delegate");
        dn6.e = rn62;
        rn6.a();
        rn6.b();
    }

    @Override // defpackage.bk6
    public void a() {
        this.g.flush();
    }

    @Override // defpackage.bk6
    public void b(ji6 ji6) {
        n86.f(ji6, "request");
        Proxy.Type type = this.e.q.b.type();
        n86.b(type, "connection.route().proxy.type()");
        n86.f(ji6, "request");
        n86.f(type, "proxyType");
        StringBuilder sb = new StringBuilder();
        sb.append(ji6.c);
        sb.append(' ');
        di6 di6 = ji6.b;
        if (!di6.f842a && type == Proxy.Type.HTTP) {
            sb.append(di6);
        } else {
            n86.f(di6, "url");
            String b2 = di6.b();
            String d2 = di6.d();
            if (d2 != null) {
                b2 = b2 + '?' + d2;
            }
            sb.append(b2);
        }
        sb.append(" HTTP/1.1");
        String sb2 = sb.toString();
        n86.b(sb2, "StringBuilder().apply(builderAction).toString()");
        j(ji6.d, sb2);
    }

    @Override // defpackage.bk6
    public qn6 c(ni6 ni6) {
        n86.f(ni6, "response");
        if (!ck6.a(ni6)) {
            return i(0);
        }
        boolean z = true;
        if (ea6.f("chunked", ni6.c(ni6, "Transfer-Encoding", null, 2), true)) {
            di6 di6 = ni6.g.b;
            if (this.f1951a != 4) {
                z = false;
            }
            if (z) {
                this.f1951a = 5;
                return new c(this, di6);
            }
            StringBuilder i0 = hj1.i0("state: ");
            i0.append(this.f1951a);
            throw new IllegalStateException(i0.toString().toString());
        }
        long k = vi6.k(ni6);
        if (k != -1) {
            return i(k);
        }
        if (this.f1951a != 4) {
            z = false;
        }
        if (z) {
            this.f1951a = 5;
            this.e.l();
            return new f(this);
        }
        StringBuilder i02 = hj1.i0("state: ");
        i02.append(this.f1951a);
        throw new IllegalStateException(i02.toString().toString());
    }

    @Override // defpackage.bk6
    public void cancel() {
        Socket socket = this.e.b;
        if (socket != null) {
            vi6.d(socket);
        }
    }

    @Override // defpackage.bk6
    public ni6.a d(boolean z) {
        int i = this.f1951a;
        boolean z2 = true;
        if (!(i == 1 || i == 3)) {
            z2 = false;
        }
        if (z2) {
            try {
                hk6 a2 = hk6.a(this.b.b());
                ni6.a aVar = new ni6.a();
                aVar.f(a2.f1386a);
                aVar.c = a2.b;
                aVar.e(a2.c);
                aVar.d(this.b.a());
                if (z && a2.b == 100) {
                    return null;
                }
                if (a2.b == 100) {
                    this.f1951a = 3;
                    return aVar;
                }
                this.f1951a = 4;
                return aVar;
            } catch (EOFException e2) {
                throw new IOException(hj1.S("unexpected end of stream on ", this.e.q.f2809a.f839a.i()), e2);
            }
        } else {
            StringBuilder i0 = hj1.i0("state: ");
            i0.append(this.f1951a);
            throw new IllegalStateException(i0.toString().toString());
        }
    }

    @Override // defpackage.bk6
    public void e() {
        this.g.flush();
    }

    @Override // defpackage.bk6
    public long f(ni6 ni6) {
        n86.f(ni6, "response");
        if (!ck6.a(ni6)) {
            return 0;
        }
        if (ea6.f("chunked", ni6.c(ni6, "Transfer-Encoding", null, 2), true)) {
            return -1;
        }
        return vi6.k(ni6);
    }

    @Override // defpackage.bk6
    public on6 g(ji6 ji6, long j) {
        n86.f(ji6, "request");
        mi6 mi6 = ji6.e;
        if (mi6 == null || !mi6.isDuplex()) {
            boolean z = true;
            if (ea6.f("chunked", ji6.b("Transfer-Encoding"), true)) {
                if (this.f1951a != 1) {
                    z = false;
                }
                if (z) {
                    this.f1951a = 2;
                    return new b();
                }
                StringBuilder i0 = hj1.i0("state: ");
                i0.append(this.f1951a);
                throw new IllegalStateException(i0.toString().toString());
            } else if (j != -1) {
                if (this.f1951a != 1) {
                    z = false;
                }
                if (z) {
                    this.f1951a = 2;
                    return new e();
                }
                StringBuilder i02 = hj1.i0("state: ");
                i02.append(this.f1951a);
                throw new IllegalStateException(i02.toString().toString());
            } else {
                throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
            }
        } else {
            throw new ProtocolException("Duplex connections are not supported for HTTP/1");
        }
    }

    @Override // defpackage.bk6
    public sj6 getConnection() {
        return this.e;
    }

    public final qn6 i(long j) {
        if (this.f1951a == 4) {
            this.f1951a = 5;
            return new d(j);
        }
        StringBuilder i0 = hj1.i0("state: ");
        i0.append(this.f1951a);
        throw new IllegalStateException(i0.toString().toString());
    }

    public final void j(ci6 ci6, String str) {
        n86.f(ci6, "headers");
        n86.f(str, "requestLine");
        if (this.f1951a == 0) {
            this.g.k0(str).k0("\r\n");
            int size = ci6.size();
            for (int i = 0; i < size; i++) {
                this.g.k0(ci6.d(i)).k0(": ").k0(ci6.n(i)).k0("\r\n");
            }
            this.g.k0("\r\n");
            this.f1951a = 1;
            return;
        }
        StringBuilder i0 = hj1.i0("state: ");
        i0.append(this.f1951a);
        throw new IllegalStateException(i0.toString().toString());
    }
}
