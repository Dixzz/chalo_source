package defpackage;

import com.freshchat.consumer.sdk.beans.config.DefaultRefreshIntervals;
import com.google.firebase.perf.FirebasePerformance;
import com.razorpay.BaseConstants;
import defpackage.om6;
import defpackage.r46;
import defpackage.zm6;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/* renamed from: km6  reason: default package */
/* compiled from: RealWebSocket.kt */
public final class km6 implements ri6, om6.a {
    public static final List<ii6> z = hd3.c2(ii6.HTTP_1_1);

    /* renamed from: a  reason: collision with root package name */
    public final String f2081a;
    public ih6 b;
    public fj6 c;
    public om6 d;
    public pm6 e;
    public hj6 f;
    public String g;
    public c h;
    public final ArrayDeque<zm6> i;
    public final ArrayDeque<Object> j;
    public long k;
    public boolean l;
    public int m;
    public String n;
    public boolean o;
    public int p;
    public int q;
    public int r;
    public boolean s;
    public final ji6 t;
    public final si6 u;
    public final Random v;
    public final long w;
    public mm6 x = null;
    public long y;

    /* renamed from: km6$a */
    /* compiled from: RealWebSocket.kt */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f2082a;
        public final zm6 b;
        public final long c;

        public a(int i, zm6 zm6, long j) {
            this.f2082a = i;
            this.b = zm6;
            this.c = j;
        }
    }

    /* renamed from: km6$b */
    /* compiled from: RealWebSocket.kt */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f2083a;
        public final zm6 b;

        public b(int i, zm6 zm6) {
            n86.f(zm6, "data");
            this.f2083a = i;
            this.b = zm6;
        }
    }

    /* renamed from: km6$c */
    /* compiled from: RealWebSocket.kt */
    public static abstract class c implements Closeable {
        public final boolean f;
        public final ym6 g;
        public final xm6 h;

        public c(boolean z, ym6 ym6, xm6 xm6) {
            n86.f(ym6, "source");
            n86.f(xm6, "sink");
            this.f = z;
            this.g = ym6;
            this.h = xm6;
        }
    }

    /* renamed from: km6$d */
    /* compiled from: RealWebSocket.kt */
    public final class d extends fj6 {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public d() {
            super(hj1.a0(new StringBuilder(), km6.this.g, " writer"), false, 2);
        }

        @Override // defpackage.fj6
        public long a() {
            try {
                if (km6.this.m()) {
                    return 0;
                }
                return -1;
            } catch (IOException e2) {
                km6.this.h(e2, null);
                return -1;
            }
        }
    }

    /* renamed from: km6$e */
    /* compiled from: TaskQueue.kt */
    public static final class e extends fj6 {
        public final /* synthetic */ long e;
        public final /* synthetic */ km6 f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(String str, String str2, long j, km6 km6, String str3, c cVar, mm6 mm6) {
            super(str2, true);
            this.e = j;
            this.f = km6;
        }

        @Override // defpackage.fj6
        public long a() {
            km6 km6 = this.f;
            synchronized (km6) {
                if (!km6.o) {
                    pm6 pm6 = km6.e;
                    if (pm6 != null) {
                        int i = km6.s ? km6.p : -1;
                        km6.p++;
                        km6.s = true;
                        if (i != -1) {
                            StringBuilder i0 = hj1.i0("sent ping but didn't receive pong within ");
                            i0.append(km6.w);
                            i0.append("ms (after ");
                            i0.append(i - 1);
                            i0.append(" successful ping/pongs)");
                            km6.h(new SocketTimeoutException(i0.toString()), null);
                        } else {
                            try {
                                zm6 zm6 = zm6.i;
                                n86.f(zm6, "payload");
                                pm6.c(9, zm6);
                            } catch (IOException e2) {
                                km6.h(e2, null);
                            }
                        }
                    }
                }
            }
            return this.e;
        }
    }

    /* renamed from: km6$f */
    /* compiled from: TaskQueue.kt */
    public static final class f extends fj6 {
        public final /* synthetic */ km6 e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(String str, boolean z, String str2, boolean z2, km6 km6, pm6 pm6, zm6 zm6, y86 y86, w86 w86, y86 y862, y86 y863, y86 y864, y86 y865) {
            super(str2, z2);
            this.e = km6;
        }

        @Override // defpackage.fj6
        public long a() {
            ih6 ih6 = this.e.b;
            if (ih6 != null) {
                ih6.cancel();
                return -1;
            }
            n86.k();
            throw null;
        }
    }

    public km6(ij6 ij6, ji6 ji6, si6 si6, Random random, long j2, mm6 mm6, long j3) {
        n86.f(ij6, "taskRunner");
        n86.f(ji6, "originalRequest");
        n86.f(si6, "listener");
        n86.f(random, "random");
        this.t = ji6;
        this.u = si6;
        this.v = random;
        this.w = j2;
        this.y = j3;
        this.f = ij6.f();
        this.i = new ArrayDeque<>();
        this.j = new ArrayDeque<>();
        this.m = -1;
        if (n86.a(FirebasePerformance.HttpMethod.GET, ji6.c)) {
            zm6.a aVar = zm6.j;
            byte[] bArr = new byte[16];
            random.nextBytes(bArr);
            this.f2081a = zm6.a.d(aVar, bArr, 0, 0, 3).a();
            return;
        }
        StringBuilder i0 = hj1.i0("Request must be GET: ");
        i0.append(ji6.c);
        throw new IllegalArgumentException(i0.toString().toString());
    }

    @Override // defpackage.ri6
    public boolean a(zm6 zm6) {
        n86.f(zm6, "bytes");
        return l(zm6, 2);
    }

    @Override // defpackage.om6.a
    public void b(zm6 zm6) throws IOException {
        n86.f(zm6, "bytes");
        r46.a aVar = (r46.a) this.u;
        Objects.requireNonNull(aVar);
        c56.a(new o46(aVar, zm6));
    }

    @Override // defpackage.om6.a
    public void c(String str) throws IOException {
        n86.f(str, "text");
        r46.a aVar = (r46.a) this.u;
        Objects.requireNonNull(aVar);
        c56.a(new n46(aVar, str));
    }

    @Override // defpackage.ri6
    public boolean close(int i2, String str) {
        String str2;
        synchronized (this) {
            zm6 zm6 = null;
            if (i2 < 1000 || i2 >= 5000) {
                str2 = "Code must be in range [1000,5000): " + i2;
            } else if ((1004 > i2 || 1006 < i2) && (1015 > i2 || 2999 < i2)) {
                str2 = null;
            } else {
                str2 = "Code " + i2 + " is reserved and may not be used.";
            }
            if (str2 == null) {
                if (str != null) {
                    zm6 = zm6.j.c(str);
                    if (!(((long) zm6.g()) <= 123)) {
                        throw new IllegalArgumentException(("reason.size() > 123: " + str).toString());
                    }
                }
                if (this.o || this.l) {
                    return false;
                }
                this.l = true;
                this.j.add(new a(i2, zm6, DefaultRefreshIntervals.ACTIVE_CONV_MAX_FETCH_INTERVAL));
                k();
                return true;
            } else if (str2 == null) {
                n86.k();
                throw null;
            } else {
                throw new IllegalArgumentException(str2.toString());
            }
        }
    }

    @Override // defpackage.om6.a
    public synchronized void d(zm6 zm6) {
        n86.f(zm6, "payload");
        if (!this.o) {
            if (!this.l || !this.j.isEmpty()) {
                this.i.add(zm6);
                k();
                this.q++;
            }
        }
    }

    @Override // defpackage.om6.a
    public synchronized void e(zm6 zm6) {
        n86.f(zm6, "payload");
        this.r++;
        this.s = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [km6$c, pm6, om6] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.io.Closeable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // defpackage.om6.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void f(int r5, java.lang.String r6) {
        /*
        // Method dump skipped, instructions count: 222
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.km6.f(int, java.lang.String):void");
    }

    public final void g(ni6 ni6, lj6 lj6) throws IOException {
        n86.f(ni6, "response");
        if (ni6.j == 101) {
            String c2 = ni6.c(ni6, "Connection", null, 2);
            if (ea6.f("Upgrade", c2, true)) {
                String c3 = ni6.c(ni6, "Upgrade", null, 2);
                if (ea6.f("websocket", c3, true)) {
                    String c4 = ni6.c(ni6, "Sec-WebSocket-Accept", null, 2);
                    zm6.a aVar = zm6.j;
                    String a2 = aVar.c(this.f2081a + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").c("SHA-1").a();
                    if (!n86.a(a2, c4)) {
                        throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + a2 + "' but was '" + c4 + '\'');
                    } else if (lj6 == null) {
                        throw new ProtocolException("Web Socket exchange missing: bad interceptor?");
                    }
                } else {
                    throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + c3 + '\'');
                }
            } else {
                throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + c2 + '\'');
            }
        } else {
            StringBuilder i0 = hj1.i0("Expected HTTP 101 response but was '");
            i0.append(ni6.j);
            i0.append(' ');
            throw new ProtocolException(hj1.Z(i0, ni6.i, '\''));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r0 = (defpackage.r46.a) r4.u;
        java.util.Objects.requireNonNull(r0);
        defpackage.c56.a(new defpackage.q46(r0, r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0041, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0063, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0064, code lost:
        if (r6 != null) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0066, code lost:
        r0 = defpackage.vi6.f3652a;
        defpackage.n86.f(r6, "$this$closeQuietly");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0073, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0074, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0075, code lost:
        if (r1 != null) goto L_0x0077;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0077, code lost:
        r6 = defpackage.vi6.f3652a;
        defpackage.n86.f(r1, "$this$closeQuietly");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0084, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0085, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0086, code lost:
        if (r2 != null) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0088, code lost:
        r6 = defpackage.vi6.f3652a;
        defpackage.n86.f(r2, "$this$closeQuietly");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0093, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0094, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0095, code lost:
        throw r5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void h(java.lang.Exception r5, defpackage.ni6 r6) {
        /*
        // Method dump skipped, instructions count: 153
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.km6.h(java.lang.Exception, ni6):void");
    }

    public final void i(String str, c cVar) throws IOException {
        boolean z2;
        boolean z3;
        n86.f(str, "name");
        n86.f(cVar, "streams");
        mm6 mm6 = this.x;
        if (mm6 != null) {
            synchronized (this) {
                this.g = str;
                this.h = cVar;
                boolean z4 = cVar.f;
                xm6 xm6 = cVar.h;
                Random random = this.v;
                boolean z5 = mm6.f2408a;
                if (z4) {
                    z2 = mm6.c;
                } else {
                    z2 = mm6.e;
                }
                this.e = new pm6(z4, xm6, random, z5, z2, this.y);
                this.c = new d();
                long j2 = this.w;
                if (j2 != 0) {
                    long nanos = TimeUnit.MILLISECONDS.toNanos(j2);
                    String str2 = str + " ping";
                    this.f.c(new e(str2, str2, nanos, this, str, cVar, mm6), nanos);
                }
                if (!this.j.isEmpty()) {
                    k();
                }
            }
            boolean z6 = cVar.f;
            ym6 ym6 = cVar.g;
            boolean z7 = mm6.f2408a;
            if (!z6) {
                z3 = mm6.c;
            } else {
                z3 = mm6.e;
            }
            this.d = new om6(z6, ym6, this, z7, z3);
            return;
        }
        n86.k();
        throw null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00f3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void j() throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 316
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.km6.j():void");
    }

    public final void k() {
        byte[] bArr = vi6.f3652a;
        fj6 fj6 = this.c;
        if (fj6 != null) {
            this.f.c(fj6, 0);
        }
    }

    public final synchronized boolean l(zm6 zm6, int i2) {
        if (!this.o) {
            if (!this.l) {
                if (this.k + ((long) zm6.g()) > 16777216) {
                    close(BaseConstants.SMS_CONSENT_REQUEST, null);
                    return false;
                }
                this.k += (long) zm6.g();
                this.j.add(new b(i2, zm6));
                k();
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x01c3, code lost:
        throw r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x01d1, code lost:
        throw new defpackage.p56("null cannot be cast to non-null type okhttp3.internal.ws.RealWebSocket.Close");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x01dd, code lost:
        throw new java.lang.AssertionError();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x01de, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x01e0, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x01e1, code lost:
        r3 = r22;
        r2 = r23;
        r1 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x01e7, code lost:
        r1 = r1.f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x01eb, code lost:
        if (r1 != null) goto L_0x01ed;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x01ed, code lost:
        r4 = defpackage.vi6.f3652a;
        defpackage.n86.f(r1, "$this$closeQuietly");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x01fa, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x01fc, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x01fd, code lost:
        r1 = r2.f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0201, code lost:
        if (r1 != null) goto L_0x0203;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0203, code lost:
        r2 = defpackage.vi6.f3652a;
        defpackage.n86.f(r1, "$this$closeQuietly");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0210, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0212, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x0213, code lost:
        r1 = r3.f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x0217, code lost:
        if (r1 != null) goto L_0x0219;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x0219, code lost:
        r2 = defpackage.vi6.f3652a;
        defpackage.n86.f(r1, "$this$closeQuietly");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x0224, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0226, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x0227, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00f3, code lost:
        if (r20 == null) goto L_0x0108;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00f7, code lost:
        if (r21 == null) goto L_0x0104;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        defpackage.n86.f(r20, "payload");
        r21.c(10, r20);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0104, code lost:
        defpackage.n86.k();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0107, code lost:
        throw r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0108, code lost:
        r0 = r0.f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x010e, code lost:
        if ((r0 instanceof defpackage.km6.b) == false) goto L_0x013d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0110, code lost:
        if (r0 == null) goto L_0x0135;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0112, code lost:
        r0 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0114, code lost:
        if (r21 == null) goto L_0x0131;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0116, code lost:
        r21.e(r0.f2083a, r0.b);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x011d, code lost:
        monitor-enter(r27);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        r27.k -= (long) r0.b.g();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x012a, code lost:
        monitor-exit(r27);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x012b, code lost:
        r1 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0131, code lost:
        defpackage.n86.k();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0134, code lost:
        throw r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x013c, code lost:
        throw new defpackage.p56("null cannot be cast to non-null type okhttp3.internal.ws.RealWebSocket.Message");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x013f, code lost:
        if ((r0 instanceof defpackage.km6.a) == false) goto L_0x01d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0141, code lost:
        if (r0 == null) goto L_0x01c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0143, code lost:
        r0 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0145, code lost:
        if (r21 == null) goto L_0x01ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0147, code lost:
        r21.a(r0.f2082a, r0.b);
        r1 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0154, code lost:
        if (r1.f == null) goto L_0x0172;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0156, code lost:
        r0 = r27.u;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x015e, code lost:
        if (r25.f == null) goto L_0x016e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0160, code lost:
        r0 = (defpackage.r46.a) r0;
        java.util.Objects.requireNonNull(r0);
        defpackage.c56.a(new defpackage.p46(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x016e, code lost:
        defpackage.n86.k();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0171, code lost:
        throw r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0172, code lost:
        r1 = r1.f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0177, code lost:
        if (r1 == null) goto L_0x0187;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0179, code lost:
        r2 = defpackage.vi6.f3652a;
        defpackage.n86.f(r1, "$this$closeQuietly");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0184, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0186, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01b4, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x01b5, code lost:
        r3 = r22;
        r2 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01ba, code lost:
        r3 = r22;
        r2 = r23;
        r1 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:?, code lost:
        defpackage.n86.k();
     */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x01ed  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0203  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0219  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01a5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean m() throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 555
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.km6.m():boolean");
    }

    @Override // defpackage.ri6
    public boolean send(String str) {
        n86.f(str, "text");
        return l(zm6.j.c(str), 1);
    }
}
