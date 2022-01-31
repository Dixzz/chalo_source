package defpackage;

import com.razorpay.AnalyticsConstants;
import defpackage.ol6;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: nj6  reason: default package */
/* compiled from: RealCall.kt */
public final class nj6 implements ih6 {
    public final tj6 f;
    public final xh6 g;
    public final c h;
    public final AtomicBoolean i = new AtomicBoolean();
    public Object j;
    public mj6 k;
    public sj6 l;
    public boolean m;
    public lj6 n;
    public boolean o;
    public boolean p;
    public boolean q = true;
    public volatile boolean r;
    public volatile lj6 s;
    public volatile sj6 t;
    public final hi6 u;
    public final ji6 v;
    public final boolean w;

    /* renamed from: nj6$a */
    /* compiled from: RealCall.kt */
    public final class a implements Runnable {
        public volatile AtomicInteger f = new AtomicInteger(0);
        public final jh6 g;
        public final /* synthetic */ nj6 h;

        public a(nj6 nj6, jh6 jh6) {
            n86.f(jh6, "responseCallback");
            this.h = nj6;
            this.g = jh6;
        }

        public final String a() {
            return this.h.v.b.e;
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x0053 A[Catch:{ IOException -> 0x0076, all -> 0x004b, all -> 0x0074 }] */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0079 A[Catch:{ IOException -> 0x0076, all -> 0x004b, all -> 0x0074 }] */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0099 A[Catch:{ IOException -> 0x0076, all -> 0x004b, all -> 0x0074 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            // Method dump skipped, instructions count: 187
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.nj6.a.run():void");
        }
    }

    /* renamed from: nj6$b */
    /* compiled from: RealCall.kt */
    public static final class b extends WeakReference<nj6> {

        /* renamed from: a  reason: collision with root package name */
        public final Object f2567a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(nj6 nj6, Object obj) {
            super(nj6);
            n86.f(nj6, "referent");
            this.f2567a = obj;
        }
    }

    /* renamed from: nj6$c */
    /* compiled from: RealCall.kt */
    public static final class c extends rm6 {
        public final /* synthetic */ nj6 l;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public c(nj6 nj6) {
            this.l = nj6;
        }

        @Override // defpackage.rm6
        public void l() {
            this.l.cancel();
        }
    }

    public nj6(hi6 hi6, ji6 ji6, boolean z) {
        n86.f(hi6, "client");
        n86.f(ji6, "originalRequest");
        this.u = hi6;
        this.v = ji6;
        this.w = z;
        this.f = hi6.g.f2806a;
        this.g = hi6.j.a(this);
        c cVar = new c(this);
        cVar.g((long) hi6.C, TimeUnit.MILLISECONDS);
        this.h = cVar;
    }

    public static final String a(nj6 nj6) {
        StringBuilder sb = new StringBuilder();
        sb.append(nj6.r ? "canceled " : "");
        sb.append(nj6.w ? "web socket" : AnalyticsConstants.CALL);
        sb.append(" to ");
        sb.append(nj6.v.b.i());
        return sb.toString();
    }

    @Override // defpackage.ih6
    public void L(jh6 jh6) {
        a aVar;
        n86.f(jh6, "responseCallback");
        if (this.i.compareAndSet(false, true)) {
            d();
            uh6 uh6 = this.u.f;
            a aVar2 = new a(this, jh6);
            Objects.requireNonNull(uh6);
            n86.f(aVar2, AnalyticsConstants.CALL);
            synchronized (uh6) {
                uh6.b.add(aVar2);
                if (!aVar2.h.w) {
                    String a2 = aVar2.a();
                    Iterator<a> it = uh6.c.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            Iterator<a> it2 = uh6.b.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    aVar = null;
                                    break;
                                }
                                aVar = it2.next();
                                if (n86.a(aVar.a(), a2)) {
                                    break;
                                }
                            }
                        } else {
                            aVar = it.next();
                            if (n86.a(aVar.a(), a2)) {
                                break;
                            }
                        }
                    }
                    if (aVar != null) {
                        n86.f(aVar, "other");
                        aVar2.f = aVar.f;
                    }
                }
            }
            uh6.c();
            return;
        }
        throw new IllegalStateException("Already Executed".toString());
    }

    public final void b(sj6 sj6) {
        n86.f(sj6, "connection");
        byte[] bArr = vi6.f3652a;
        if (this.l == null) {
            this.l = sj6;
            sj6.o.add(new b(this, this.j));
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final <E extends IOException> E c(E e) {
        InterruptedIOException interruptedIOException;
        Socket i2;
        byte[] bArr = vi6.f3652a;
        sj6 sj6 = this.l;
        if (sj6 != null) {
            synchronized (sj6) {
                i2 = i();
            }
            if (this.l == null) {
                if (i2 != null) {
                    vi6.d(i2);
                }
                Objects.requireNonNull(this.g);
                n86.f(this, AnalyticsConstants.CALL);
                n86.f(sj6, "connection");
            } else {
                if (!(i2 == null)) {
                    throw new IllegalStateException("Check failed.".toString());
                }
            }
        }
        if (!this.m && this.h.j()) {
            InterruptedIOException interruptedIOException2 = new InterruptedIOException("timeout");
            interruptedIOException = interruptedIOException2;
            if (e != null) {
                interruptedIOException2.initCause(e);
                interruptedIOException = interruptedIOException2;
            }
        } else {
            interruptedIOException = e;
        }
        if (e != null) {
            xh6 xh6 = this.g;
            if (interruptedIOException != null) {
                Objects.requireNonNull(xh6);
                n86.f(this, AnalyticsConstants.CALL);
                n86.f(interruptedIOException, "ioe");
            } else {
                n86.k();
                throw null;
            }
        } else {
            Objects.requireNonNull(this.g);
            n86.f(this, AnalyticsConstants.CALL);
        }
        return interruptedIOException;
    }

    @Override // defpackage.ih6
    public void cancel() {
        Socket socket;
        if (!this.r) {
            this.r = true;
            lj6 lj6 = this.s;
            if (lj6 != null) {
                lj6.f.cancel();
            }
            sj6 sj6 = this.t;
            if (!(sj6 == null || (socket = sj6.b) == null)) {
                vi6.d(socket);
            }
            Objects.requireNonNull(this.g);
            n86.f(this, AnalyticsConstants.CALL);
        }
    }

    @Override // java.lang.Object
    public Object clone() {
        return new nj6(this.u, this.v, this.w);
    }

    public final void d() {
        ol6.a aVar = ol6.c;
        this.j = ol6.f2709a.g("response.body().close()");
        Objects.requireNonNull(this.g);
        n86.f(this, AnalyticsConstants.CALL);
    }

    public final void e(boolean z) {
        lj6 lj6;
        synchronized (this) {
            if (!this.q) {
                throw new IllegalStateException("released".toString());
            }
        }
        if (z && (lj6 = this.s) != null) {
            lj6.f.cancel();
            lj6.c.g(lj6, true, true, null);
        }
        this.n = null;
    }

    @Override // defpackage.ih6
    public ni6 execute() {
        uh6 uh6;
        if (this.i.compareAndSet(false, true)) {
            this.h.i();
            d();
            try {
                uh6 uh62 = this.u.f;
                synchronized (uh62) {
                    n86.f(this, AnalyticsConstants.CALL);
                    uh62.d.add(this);
                }
                return f();
            } finally {
                uh6 = this.u.f;
                Objects.requireNonNull(uh6);
                n86.f(this, AnalyticsConstants.CALL);
                uh6.a(uh6.d, this);
            }
        } else {
            throw new IllegalStateException("Already Executed".toString());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x007d, code lost:
        r2 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r0 = h(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0084, code lost:
        if (r0 == null) goto L_0x0086;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x008d, code lost:
        throw new defpackage.p56("null cannot be cast to non-null type kotlin.Throwable");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x008e, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x008f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0090, code lost:
        r2 = r0;
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0092, code lost:
        if (r0 == false) goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0094, code lost:
        h(null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0097, code lost:
        throw r2;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x007d A[ExcHandler: all (th java.lang.Throwable), Splitter:B:4:0x005d] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0094  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final defpackage.ni6 f() throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 152
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.nj6.f():ni6");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0023 A[Catch:{ all -> 0x0019 }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0027 A[Catch:{ all -> 0x0019 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <E extends java.io.IOException> E g(defpackage.lj6 r3, boolean r4, boolean r5, E r6) {
        /*
            r2 = this;
            java.lang.String r0 = "exchange"
            defpackage.n86.f(r3, r0)
            lj6 r0 = r2.s
            boolean r3 = defpackage.n86.a(r3, r0)
            r0 = 1
            r3 = r3 ^ r0
            if (r3 == 0) goto L_0x0010
            return r6
        L_0x0010:
            monitor-enter(r2)
            r3 = 0
            if (r4 == 0) goto L_0x001b
            boolean r1 = r2.o     // Catch:{ all -> 0x0019 }
            if (r1 != 0) goto L_0x0021
            goto L_0x001b
        L_0x0019:
            r3 = move-exception
            goto L_0x0042
        L_0x001b:
            if (r5 == 0) goto L_0x0044
            boolean r1 = r2.p     // Catch:{ all -> 0x0019 }
            if (r1 == 0) goto L_0x0044
        L_0x0021:
            if (r4 == 0) goto L_0x0025
            r2.o = r3     // Catch:{ all -> 0x0019 }
        L_0x0025:
            if (r5 == 0) goto L_0x0029
            r2.p = r3     // Catch:{ all -> 0x0019 }
        L_0x0029:
            boolean r4 = r2.o     // Catch:{ all -> 0x0019 }
            if (r4 != 0) goto L_0x0033
            boolean r5 = r2.p     // Catch:{ all -> 0x0019 }
            if (r5 != 0) goto L_0x0033
            r5 = 1
            goto L_0x0034
        L_0x0033:
            r5 = 0
        L_0x0034:
            if (r4 != 0) goto L_0x003f
            boolean r4 = r2.p     // Catch:{ all -> 0x0019 }
            if (r4 != 0) goto L_0x003f
            boolean r4 = r2.q     // Catch:{ all -> 0x0019 }
            if (r4 != 0) goto L_0x003f
            r3 = 1
        L_0x003f:
            r4 = r3
            r3 = r5
            goto L_0x0045
        L_0x0042:
            monitor-exit(r2)
            throw r3
        L_0x0044:
            r4 = 0
        L_0x0045:
            monitor-exit(r2)
            if (r3 == 0) goto L_0x005a
            r3 = 0
            r2.s = r3
            sj6 r3 = r2.l
            if (r3 == 0) goto L_0x005a
            monitor-enter(r3)
            int r5 = r3.l     // Catch:{ all -> 0x0057 }
            int r5 = r5 + r0
            r3.l = r5     // Catch:{ all -> 0x0057 }
            monitor-exit(r3)
            goto L_0x005a
        L_0x0057:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        L_0x005a:
            if (r4 == 0) goto L_0x0061
            java.io.IOException r3 = r2.c(r6)
            return r3
        L_0x0061:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.nj6.g(lj6, boolean, boolean, java.io.IOException):java.io.IOException");
    }

    public final IOException h(IOException iOException) {
        boolean z;
        synchronized (this) {
            z = false;
            if (this.q) {
                this.q = false;
                if (!this.o && !this.p) {
                    z = true;
                }
            }
        }
        return z ? c(iOException) : iOException;
    }

    public final Socket i() {
        sj6 sj6 = this.l;
        if (sj6 != null) {
            byte[] bArr = vi6.f3652a;
            List<Reference<nj6>> list = sj6.o;
            Iterator<Reference<nj6>> it = list.iterator();
            boolean z = false;
            int i2 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i2 = -1;
                    break;
                } else if (n86.a(it.next().get(), this)) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 != -1) {
                list.remove(i2);
                this.l = null;
                if (list.isEmpty()) {
                    sj6.p = System.nanoTime();
                    tj6 tj6 = this.f;
                    Objects.requireNonNull(tj6);
                    n86.f(sj6, "connection");
                    byte[] bArr2 = vi6.f3652a;
                    if (sj6.i || tj6.e == 0) {
                        sj6.i = true;
                        tj6.d.remove(sj6);
                        if (tj6.d.isEmpty()) {
                            tj6.b.a();
                        }
                        z = true;
                    } else {
                        hj6.d(tj6.b, tj6.c, 0, 2);
                    }
                    if (z) {
                        return sj6.m();
                    }
                }
                return null;
            }
            throw new IllegalStateException("Check failed.".toString());
        }
        n86.k();
        throw null;
    }

    @Override // defpackage.ih6
    public boolean isCanceled() {
        return this.r;
    }

    public final void j() {
        if (!this.m) {
            this.m = true;
            this.h.j();
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // defpackage.ih6
    public ji6 request() {
        return this.v;
    }
}
