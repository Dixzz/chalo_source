package defpackage;

import com.crashlytics.android.answers.AnswersPreferenceManager;
import com.razorpay.AnalyticsConstants;
import defpackage.ol6;
import defpackage.pk6;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: sj6  reason: default package */
/* compiled from: RealConnection.kt */
public final class sj6 extends pk6.c implements oh6 {
    public Socket b;
    public Socket c;
    public bi6 d;
    public ii6 e;
    public pk6 f;
    public ym6 g;
    public xm6 h;
    public boolean i;
    public boolean j;
    public int k;
    public int l;
    public int m;
    public int n = 1;
    public final List<Reference<nj6>> o = new ArrayList();
    public long p = Long.MAX_VALUE;
    public final pi6 q;

    public sj6(tj6 tj6, pi6 pi6) {
        n86.f(tj6, "connectionPool");
        n86.f(pi6, "route");
        this.q = pi6;
    }

    @Override // defpackage.pk6.c
    public synchronized void a(pk6 pk6, dl6 dl6) {
        n86.f(pk6, "connection");
        n86.f(dl6, AnswersPreferenceManager.PREF_STORE_NAME);
        this.n = (dl6.f855a & 16) != 0 ? dl6.b[4] : Integer.MAX_VALUE;
    }

    @Override // defpackage.pk6.c
    public void b(yk6 yk6) throws IOException {
        n86.f(yk6, "stream");
        yk6.c(lk6.REFUSED_STREAM, null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x015c A[EDGE_INSN: B:79:0x015c->B:71:0x015c ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(int r17, int r18, int r19, int r20, boolean r21, defpackage.ih6 r22, defpackage.xh6 r23) {
        /*
        // Method dump skipped, instructions count: 374
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.sj6.c(int, int, int, int, boolean, ih6, xh6):void");
    }

    public final void d(hi6 hi6, pi6 pi6, IOException iOException) {
        n86.f(hi6, "client");
        n86.f(pi6, "failedRoute");
        n86.f(iOException, AnalyticsConstants.FAILURE);
        if (pi6.b.type() != Proxy.Type.DIRECT) {
            dh6 dh6 = pi6.f2809a;
            dh6.k.connectFailed(dh6.f839a.j(), pi6.b.address(), iOException);
        }
        uj6 uj6 = hi6.I;
        synchronized (uj6) {
            n86.f(pi6, "failedRoute");
            uj6.f3514a.add(pi6);
        }
    }

    public final void e(int i2, int i3, ih6 ih6, xh6 xh6) throws IOException {
        Socket socket;
        int i4;
        pi6 pi6 = this.q;
        Proxy proxy = pi6.b;
        dh6 dh6 = pi6.f2809a;
        Proxy.Type type = proxy.type();
        if (type != null && ((i4 = oj6.f2700a[type.ordinal()]) == 1 || i4 == 2)) {
            socket = dh6.e.createSocket();
            if (socket == null) {
                n86.k();
                throw null;
            }
        } else {
            socket = new Socket(proxy);
        }
        this.b = socket;
        InetSocketAddress inetSocketAddress = this.q.c;
        Objects.requireNonNull(xh6);
        n86.f(ih6, AnalyticsConstants.CALL);
        n86.f(inetSocketAddress, "inetSocketAddress");
        n86.f(proxy, "proxy");
        socket.setSoTimeout(i3);
        try {
            ol6.a aVar = ol6.c;
            ol6.f2709a.e(socket, this.q.c, i2);
            try {
                qn6 z = ec6.z(socket);
                n86.f(z, "$this$buffer");
                this.g = new kn6(z);
                on6 w = ec6.w(socket);
                n86.f(w, "$this$buffer");
                this.h = new jn6(w);
            } catch (NullPointerException e2) {
                if (n86.a(e2.getMessage(), "throw with null exception")) {
                    throw new IOException(e2);
                }
            }
        } catch (ConnectException e3) {
            StringBuilder i0 = hj1.i0("Failed to connect to ");
            i0.append(this.q.c);
            ConnectException connectException = new ConnectException(i0.toString());
            connectException.initCause(e3);
            throw connectException;
        }
    }

    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Throwable, hi6] */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void f(int r20, int r21, int r22, defpackage.ih6 r23, defpackage.xh6 r24) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 444
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.sj6.f(int, int, int, ih6, xh6):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:0x01a0  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01a9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void g(defpackage.kj6 r12, int r13, defpackage.ih6 r14, defpackage.xh6 r15) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 429
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.sj6.g(kj6, int, ih6, xh6):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00d4, code lost:
        if (r8 == false) goto L_0x00d8;
     */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00db A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00dc A[SYNTHETIC, Splitter:B:57:0x00dc] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean h(defpackage.dh6 r7, java.util.List<defpackage.pi6> r8) {
        /*
        // Method dump skipped, instructions count: 265
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.sj6.h(dh6, java.util.List):boolean");
    }

    /* JADX INFO: finally extract failed */
    public final boolean i(boolean z) {
        long j2;
        byte[] bArr = vi6.f3652a;
        long nanoTime = System.nanoTime();
        Socket socket = this.b;
        if (socket != null) {
            Socket socket2 = this.c;
            if (socket2 != null) {
                ym6 ym6 = this.g;
                if (ym6 == null) {
                    n86.k();
                    throw null;
                } else if (socket.isClosed() || socket2.isClosed() || socket2.isInputShutdown() || socket2.isOutputShutdown()) {
                    return false;
                } else {
                    pk6 pk6 = this.f;
                    if (pk6 != null) {
                        synchronized (pk6) {
                            if (pk6.l) {
                                return false;
                            }
                            if (pk6.u >= pk6.t || nanoTime < pk6.w) {
                                return true;
                            }
                            return false;
                        }
                    }
                    synchronized (this) {
                        j2 = nanoTime - this.p;
                    }
                    if (j2 < 10000000000L || !z) {
                        return true;
                    }
                    n86.f(socket2, "$this$isHealthy");
                    n86.f(ym6, "source");
                    try {
                        int soTimeout = socket2.getSoTimeout();
                        try {
                            socket2.setSoTimeout(1);
                            boolean z2 = !ym6.R();
                            socket2.setSoTimeout(soTimeout);
                            return z2;
                        } catch (Throwable th) {
                            socket2.setSoTimeout(soTimeout);
                            throw th;
                        }
                    } catch (SocketTimeoutException unused) {
                        return true;
                    } catch (IOException unused2) {
                        return false;
                    }
                }
            } else {
                n86.k();
                throw null;
            }
        } else {
            n86.k();
            throw null;
        }
    }

    public final boolean j() {
        return this.f != null;
    }

    public final bk6 k(hi6 hi6, ek6 ek6) throws SocketException {
        n86.f(hi6, "client");
        n86.f(ek6, "chain");
        Socket socket = this.c;
        if (socket != null) {
            ym6 ym6 = this.g;
            if (ym6 != null) {
                xm6 xm6 = this.h;
                if (xm6 != null) {
                    pk6 pk6 = this.f;
                    if (pk6 != null) {
                        return new wk6(hi6, this, ek6, pk6);
                    }
                    socket.setSoTimeout(ek6.h);
                    rn6 timeout = ym6.timeout();
                    long j2 = (long) ek6.h;
                    TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                    timeout.g(j2, timeUnit);
                    xm6.timeout().g((long) ek6.i, timeUnit);
                    return new jk6(hi6, this, ym6, xm6);
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

    public final synchronized void l() {
        this.i = true;
    }

    public Socket m() {
        Socket socket = this.c;
        if (socket != null) {
            return socket;
        }
        n86.k();
        throw null;
    }

    public final void n(int i2) throws IOException {
        String str;
        Socket socket = this.c;
        if (socket != null) {
            ym6 ym6 = this.g;
            if (ym6 != null) {
                xm6 xm6 = this.h;
                if (xm6 != null) {
                    socket.setSoTimeout(0);
                    ij6 ij6 = ij6.h;
                    pk6.b bVar = new pk6.b(true, ij6);
                    String str2 = this.q.f2809a.f839a.e;
                    n86.f(socket, "socket");
                    n86.f(str2, "peerName");
                    n86.f(ym6, "source");
                    n86.f(xm6, "sink");
                    bVar.f2817a = socket;
                    if (bVar.h) {
                        str = vi6.g + ' ' + str2;
                    } else {
                        str = hj1.S("MockWebServer ", str2);
                    }
                    bVar.b = str;
                    bVar.c = ym6;
                    bVar.d = xm6;
                    n86.f(this, "listener");
                    bVar.e = this;
                    bVar.g = i2;
                    pk6 pk6 = new pk6(bVar);
                    this.f = pk6;
                    pk6 pk62 = pk6.I;
                    dl6 dl6 = pk6.H;
                    this.n = (dl6.f855a & 16) != 0 ? dl6.b[4] : Integer.MAX_VALUE;
                    n86.f(ij6, "taskRunner");
                    zk6 zk6 = pk6.E;
                    synchronized (zk6) {
                        if (zk6.h) {
                            throw new IOException("closed");
                        } else if (zk6.k) {
                            Logger logger = zk6.l;
                            if (logger.isLoggable(Level.FINE)) {
                                logger.fine(vi6.i(">> CONNECTION " + ok6.f2707a.h(), new Object[0]));
                            }
                            zk6.j.P0(ok6.f2707a);
                            zk6.j.flush();
                        }
                    }
                    zk6 zk62 = pk6.E;
                    dl6 dl62 = pk6.x;
                    synchronized (zk62) {
                        n86.f(dl62, AnswersPreferenceManager.PREF_STORE_NAME);
                        if (!zk62.h) {
                            zk62.e(0, Integer.bitCount(dl62.f855a) * 6, 4, 0);
                            int i3 = 0;
                            while (i3 < 10) {
                                if (((1 << i3) & dl62.f855a) != 0) {
                                    zk62.j.C(i3 != 4 ? i3 != 7 ? i3 : 4 : 3);
                                    zk62.j.H(dl62.b[i3]);
                                }
                                i3++;
                            }
                            zk62.j.flush();
                        } else {
                            throw new IOException("closed");
                        }
                    }
                    int a2 = pk6.x.a();
                    if (a2 != 65535) {
                        pk6.E.j(0, (long) (a2 - 65535));
                    }
                    hj6 f2 = ij6.f();
                    String str3 = pk6.i;
                    f2.c(new gj6(pk6.F, str3, true, str3, true), 0);
                    return;
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

    public String toString() {
        Object obj;
        StringBuilder i0 = hj1.i0("Connection{");
        i0.append(this.q.f2809a.f839a.e);
        i0.append(':');
        i0.append(this.q.f2809a.f839a.f);
        i0.append(',');
        i0.append(" proxy=");
        i0.append(this.q.b);
        i0.append(" hostAddress=");
        i0.append(this.q.c);
        i0.append(" cipherSuite=");
        bi6 bi6 = this.d;
        if (bi6 == null || (obj = bi6.c) == null) {
            obj = "none";
        }
        i0.append(obj);
        i0.append(" protocol=");
        i0.append(this.e);
        i0.append('}');
        return i0.toString();
    }
}
