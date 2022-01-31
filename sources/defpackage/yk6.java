package defpackage;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.Objects;

/* renamed from: yk6  reason: default package */
/* compiled from: Http2Stream.kt */
public final class yk6 {

    /* renamed from: a  reason: collision with root package name */
    public long f4064a;
    public long b;
    public long c;
    public long d;
    public final ArrayDeque<ci6> e;
    public boolean f;
    public final b g;
    public final a h;
    public final c i = new c();
    public final c j = new c();
    public lk6 k;
    public IOException l;
    public final int m;
    public final pk6 n;

    /* renamed from: yk6$a */
    /* compiled from: Http2Stream.kt */
    public final class a implements on6 {
        public final vm6 f = new vm6();
        public boolean g;
        public boolean h;

        public a(boolean z) {
            this.h = z;
        }

        /* JADX INFO: finally extract failed */
        public final void a(boolean z) throws IOException {
            long min;
            boolean z2;
            synchronized (yk6.this) {
                yk6.this.j.i();
                while (true) {
                    try {
                        yk6 yk6 = yk6.this;
                        if (yk6.c < yk6.d || this.h || this.g || yk6.f() != null) {
                            yk6.this.j.m();
                            yk6.this.b();
                            yk6 yk62 = yk6.this;
                            min = Math.min(yk62.d - yk62.c, this.f.g);
                            yk6 yk63 = yk6.this;
                            yk63.c += min;
                        } else {
                            yk6.this.l();
                        }
                    } catch (Throwable th) {
                        yk6.this.j.m();
                        throw th;
                    }
                }
                yk6.this.j.m();
                yk6.this.b();
                yk6 yk622 = yk6.this;
                min = Math.min(yk622.d - yk622.c, this.f.g);
                yk6 yk632 = yk6.this;
                yk632.c += min;
                z2 = z && min == this.f.g && yk632.f() == null;
            }
            yk6.this.j.i();
            try {
                yk6 yk64 = yk6.this;
                yk64.n.j(yk64.m, z2, this.f, min);
            } finally {
                yk6.this.j.m();
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0019, code lost:
            r0 = r14.i;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x001f, code lost:
            if (r0.h.h != false) goto L_0x0047;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0029, code lost:
            if (r14.f.g <= 0) goto L_0x002c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x002b, code lost:
            r2 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x002c, code lost:
            if (r2 == false) goto L_0x003a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0034, code lost:
            if (r14.f.g <= 0) goto L_0x0047;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0036, code lost:
            a(true);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x003a, code lost:
            if (r1 == false) goto L_0x0047;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x003c, code lost:
            r0.n.j(r0.m, true, null, 0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0047, code lost:
            r0 = r14.i;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0049, code lost:
            monitor-enter(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
            r14.g = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x004c, code lost:
            monitor-exit(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x004d, code lost:
            r14.i.n.E.flush();
            r14.i.a();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x005b, code lost:
            return;
         */
        @Override // defpackage.on6, java.io.Closeable, java.lang.AutoCloseable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void close() throws java.io.IOException {
            /*
                r14 = this;
                yk6 r0 = defpackage.yk6.this
                byte[] r1 = defpackage.vi6.f3652a
                monitor-enter(r0)
                boolean r1 = r14.g     // Catch:{ all -> 0x005f }
                if (r1 == 0) goto L_0x000b
                monitor-exit(r0)
                return
            L_0x000b:
                yk6 r1 = defpackage.yk6.this
                lk6 r1 = r1.f()
                r2 = 0
                r3 = 1
                if (r1 != 0) goto L_0x0017
                r1 = 1
                goto L_0x0018
            L_0x0017:
                r1 = 0
            L_0x0018:
                monitor-exit(r0)
                yk6 r0 = defpackage.yk6.this
                yk6$a r4 = r0.h
                boolean r4 = r4.h
                if (r4 != 0) goto L_0x0047
                vm6 r4 = r14.f
                long r4 = r4.g
                r6 = 0
                int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r8 <= 0) goto L_0x002c
                r2 = 1
            L_0x002c:
                if (r2 == 0) goto L_0x003a
            L_0x002e:
                vm6 r0 = r14.f
                long r0 = r0.g
                int r2 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
                if (r2 <= 0) goto L_0x0047
                r14.a(r3)
                goto L_0x002e
            L_0x003a:
                if (r1 == 0) goto L_0x0047
                pk6 r8 = r0.n
                int r9 = r0.m
                r10 = 1
                r11 = 0
                r12 = 0
                r8.j(r9, r10, r11, r12)
            L_0x0047:
                yk6 r0 = defpackage.yk6.this
                monitor-enter(r0)
                r14.g = r3     // Catch:{ all -> 0x005c }
                monitor-exit(r0)
                yk6 r0 = defpackage.yk6.this
                pk6 r0 = r0.n
                zk6 r0 = r0.E
                r0.flush()
                yk6 r0 = defpackage.yk6.this
                r0.a()
                return
            L_0x005c:
                r1 = move-exception
                monitor-exit(r0)
                throw r1
            L_0x005f:
                r1 = move-exception
                monitor-exit(r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.yk6.a.close():void");
        }

        @Override // defpackage.on6, java.io.Flushable
        public void flush() throws IOException {
            yk6 yk6 = yk6.this;
            byte[] bArr = vi6.f3652a;
            synchronized (yk6) {
                yk6.this.b();
            }
            while (this.f.g > 0) {
                a(false);
                yk6.this.n.E.flush();
            }
        }

        @Override // defpackage.on6
        public void s0(vm6 vm6, long j) throws IOException {
            n86.f(vm6, "source");
            byte[] bArr = vi6.f3652a;
            this.f.s0(vm6, j);
            while (this.f.g >= 16384) {
                a(false);
            }
        }

        @Override // defpackage.on6
        public rn6 timeout() {
            return yk6.this.j;
        }
    }

    /* renamed from: yk6$b */
    /* compiled from: Http2Stream.kt */
    public final class b implements qn6 {
        public final vm6 f = new vm6();
        public final vm6 g = new vm6();
        public boolean h;
        public final long i;
        public boolean j;

        public b(long j2, boolean z) {
            this.i = j2;
            this.j = z;
        }

        public final void a(long j2) {
            yk6 yk6 = yk6.this;
            byte[] bArr = vi6.f3652a;
            yk6.n.i(j2);
        }

        @Override // java.io.Closeable, defpackage.qn6, java.lang.AutoCloseable
        public void close() throws IOException {
            long j2;
            synchronized (yk6.this) {
                this.h = true;
                vm6 vm6 = this.g;
                j2 = vm6.g;
                vm6.d(j2);
                yk6 yk6 = yk6.this;
                if (yk6 != null) {
                    yk6.notifyAll();
                } else {
                    throw new p56("null cannot be cast to non-null type java.lang.Object");
                }
            }
            if (j2 > 0) {
                a(j2);
            }
            yk6.this.a();
        }

        @Override // defpackage.qn6
        public long read(vm6 vm6, long j2) throws IOException {
            Throwable th;
            long j3;
            boolean z;
            long j4;
            n86.f(vm6, "sink");
            long j5 = 0;
            if (j2 >= 0) {
                while (true) {
                    synchronized (yk6.this) {
                        yk6.this.i.i();
                        try {
                            th = null;
                            if (yk6.this.f() != null) {
                                Throwable th2 = yk6.this.l;
                                if (th2 == null) {
                                    lk6 f2 = yk6.this.f();
                                    if (f2 != null) {
                                        th2 = new el6(f2);
                                    } else {
                                        n86.k();
                                        throw null;
                                    }
                                }
                                th = th2;
                            }
                            if (!this.h) {
                                vm6 vm62 = this.g;
                                long j6 = vm62.g;
                                if (j6 > j5) {
                                    j4 = vm62.read(vm6, Math.min(j2, j6));
                                    yk6 yk6 = yk6.this;
                                    long j7 = yk6.f4064a + j4;
                                    yk6.f4064a = j7;
                                    long j8 = j7 - yk6.b;
                                    if (th == null && j8 >= ((long) (yk6.n.x.a() / 2))) {
                                        yk6 yk62 = yk6.this;
                                        yk62.n.m(yk62.m, j8);
                                        yk6 yk63 = yk6.this;
                                        yk63.b = yk63.f4064a;
                                    }
                                } else if (this.j || th != null) {
                                    j4 = -1;
                                } else {
                                    yk6.this.l();
                                    z = true;
                                    j3 = -1;
                                }
                                j3 = j4;
                                z = false;
                            } else {
                                throw new IOException("stream closed");
                            }
                        } finally {
                            yk6.this.i.m();
                        }
                    }
                    if (z) {
                        j5 = 0;
                    } else if (j3 != -1) {
                        a(j3);
                        return j3;
                    } else if (th == null) {
                        return -1;
                    } else {
                        throw th;
                    }
                }
            } else {
                throw new IllegalArgumentException(hj1.M("byteCount < 0: ", j2).toString());
            }
        }

        @Override // defpackage.qn6
        public rn6 timeout() {
            return yk6.this.i;
        }
    }

    /* renamed from: yk6$c */
    /* compiled from: Http2Stream.kt */
    public final class c extends rm6 {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public c() {
        }

        @Override // defpackage.rm6
        public IOException k(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // defpackage.rm6
        public void l() {
            yk6.this.e(lk6.CANCEL);
            pk6 pk6 = yk6.this.n;
            synchronized (pk6) {
                long j = pk6.u;
                long j2 = pk6.t;
                if (j >= j2) {
                    pk6.t = j2 + 1;
                    pk6.w = System.nanoTime() + ((long) 1000000000);
                    hj6 hj6 = pk6.n;
                    String a0 = hj1.a0(new StringBuilder(), pk6.i, " ping");
                    hj6.c(new vk6(a0, true, a0, true, pk6), 0);
                }
            }
        }

        public final void m() throws IOException {
            if (j()) {
                throw new SocketTimeoutException("timeout");
            }
        }
    }

    public yk6(int i2, pk6 pk6, boolean z, boolean z2, ci6 ci6) {
        n86.f(pk6, "connection");
        this.m = i2;
        this.n = pk6;
        this.d = (long) pk6.y.a();
        ArrayDeque<ci6> arrayDeque = new ArrayDeque<>();
        this.e = arrayDeque;
        this.g = new b((long) pk6.x.a(), z2);
        this.h = new a(z);
        if (ci6 != null) {
            if (!h()) {
                arrayDeque.add(ci6);
                return;
            }
            throw new IllegalStateException("locally-initiated streams shouldn't have headers yet".toString());
        } else if (!h()) {
            throw new IllegalStateException("remotely-initiated streams should have headers".toString());
        }
    }

    public final void a() throws IOException {
        boolean z;
        boolean i2;
        byte[] bArr = vi6.f3652a;
        synchronized (this) {
            b bVar = this.g;
            if (!bVar.j && bVar.h) {
                a aVar = this.h;
                if (aVar.h || aVar.g) {
                    z = true;
                    i2 = i();
                }
            }
            z = false;
            i2 = i();
        }
        if (z) {
            c(lk6.CANCEL, null);
        } else if (!i2) {
            this.n.g(this.m);
        }
    }

    public final void b() throws IOException {
        a aVar = this.h;
        if (aVar.g) {
            throw new IOException("stream closed");
        } else if (aVar.h) {
            throw new IOException("stream finished");
        } else if (this.k != null) {
            Throwable th = this.l;
            if (th == null) {
                lk6 lk6 = this.k;
                if (lk6 == null) {
                    n86.k();
                    throw null;
                }
                th = new el6(lk6);
            }
            throw th;
        }
    }

    public final void c(lk6 lk6, IOException iOException) throws IOException {
        n86.f(lk6, "rstStatusCode");
        if (d(lk6, iOException)) {
            pk6 pk6 = this.n;
            int i2 = this.m;
            Objects.requireNonNull(pk6);
            n86.f(lk6, "statusCode");
            pk6.E.i(i2, lk6);
        }
    }

    public final boolean d(lk6 lk6, IOException iOException) {
        byte[] bArr = vi6.f3652a;
        synchronized (this) {
            if (this.k != null) {
                return false;
            }
            if (this.g.j && this.h.h) {
                return false;
            }
            this.k = lk6;
            this.l = iOException;
            notifyAll();
            this.n.g(this.m);
            return true;
        }
    }

    public final void e(lk6 lk6) {
        n86.f(lk6, "errorCode");
        if (d(lk6, null)) {
            this.n.l(this.m, lk6);
        }
    }

    public final synchronized lk6 f() {
        return this.k;
    }

    public final on6 g() {
        synchronized (this) {
            if (!(this.f || h())) {
                throw new IllegalStateException("reply before requesting the sink".toString());
            }
        }
        return this.h;
    }

    public final boolean h() {
        if (this.n.f == ((this.m & 1) == 1)) {
            return true;
        }
        return false;
    }

    public final synchronized boolean i() {
        if (this.k != null) {
            return false;
        }
        b bVar = this.g;
        if (bVar.j || bVar.h) {
            a aVar = this.h;
            if ((aVar.h || aVar.g) && this.f) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void j(defpackage.ci6 r3, boolean r4) {
        /*
            r2 = this;
            java.lang.String r0 = "headers"
            defpackage.n86.f(r3, r0)
            byte[] r0 = defpackage.vi6.f3652a
            monitor-enter(r2)
            boolean r0 = r2.f     // Catch:{ all -> 0x0035 }
            r1 = 1
            if (r0 == 0) goto L_0x0016
            if (r4 != 0) goto L_0x0010
            goto L_0x0016
        L_0x0010:
            yk6$b r3 = r2.g     // Catch:{ all -> 0x0035 }
            java.util.Objects.requireNonNull(r3)     // Catch:{ all -> 0x0035 }
            goto L_0x001d
        L_0x0016:
            r2.f = r1     // Catch:{ all -> 0x0035 }
            java.util.ArrayDeque<ci6> r0 = r2.e     // Catch:{ all -> 0x0035 }
            r0.add(r3)     // Catch:{ all -> 0x0035 }
        L_0x001d:
            if (r4 == 0) goto L_0x0023
            yk6$b r3 = r2.g     // Catch:{ all -> 0x0035 }
            r3.j = r1     // Catch:{ all -> 0x0035 }
        L_0x0023:
            boolean r3 = r2.i()     // Catch:{ all -> 0x0035 }
            r2.notifyAll()     // Catch:{ all -> 0x0035 }
            monitor-exit(r2)
            if (r3 != 0) goto L_0x0034
            pk6 r3 = r2.n
            int r4 = r2.m
            r3.g(r4)
        L_0x0034:
            return
        L_0x0035:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.yk6.j(ci6, boolean):void");
    }

    public final synchronized void k(lk6 lk6) {
        n86.f(lk6, "errorCode");
        if (this.k == null) {
            this.k = lk6;
            notifyAll();
        }
    }

    public final void l() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }
}
