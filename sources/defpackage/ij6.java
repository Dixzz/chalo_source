package defpackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: ij6  reason: default package */
/* compiled from: TaskRunner.kt */
public final class ij6 {
    public static final ij6 h;
    public static final Logger i;
    public static final b j = new b(null);

    /* renamed from: a  reason: collision with root package name */
    public int f1523a = 10000;
    public boolean b;
    public long c;
    public final List<hj6> d = new ArrayList();
    public final List<hj6> e = new ArrayList();
    public final Runnable f = new d(this);
    public final a g;

    /* renamed from: ij6$a */
    /* compiled from: TaskRunner.kt */
    public interface a {
        void a(ij6 ij6);

        void b(ij6 ij6, long j);

        long c();

        void execute(Runnable runnable);
    }

    /* renamed from: ij6$b */
    /* compiled from: TaskRunner.kt */
    public static final class b {
        public b(j86 j86) {
        }
    }

    /* renamed from: ij6$c */
    /* compiled from: TaskRunner.kt */
    public static final class c implements a {

        /* renamed from: a  reason: collision with root package name */
        public final ThreadPoolExecutor f1524a;

        public c(ThreadFactory threadFactory) {
            n86.f(threadFactory, "threadFactory");
            this.f1524a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), threadFactory);
        }

        @Override // defpackage.ij6.a
        public void a(ij6 ij6) {
            n86.f(ij6, "taskRunner");
            ij6.notify();
        }

        @Override // defpackage.ij6.a
        public void b(ij6 ij6, long j) throws InterruptedException {
            n86.f(ij6, "taskRunner");
            long j2 = j / 1000000;
            long j3 = j - (1000000 * j2);
            if (j2 > 0 || j > 0) {
                ij6.wait(j2, (int) j3);
            }
        }

        @Override // defpackage.ij6.a
        public long c() {
            return System.nanoTime();
        }

        @Override // defpackage.ij6.a
        public void execute(Runnable runnable) {
            n86.f(runnable, "runnable");
            this.f1524a.execute(runnable);
        }
    }

    /* renamed from: ij6$d */
    /* compiled from: TaskRunner.kt */
    public static final class d implements Runnable {
        public final /* synthetic */ ij6 f;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public d(ij6 ij6) {
            this.f = ij6;
        }

        public void run() {
            fj6 c;
            while (true) {
                synchronized (this.f) {
                    c = this.f.c();
                }
                if (c != null) {
                    hj6 hj6 = c.f1131a;
                    if (hj6 != null) {
                        long j = -1;
                        b bVar = ij6.j;
                        boolean isLoggable = ij6.i.isLoggable(Level.FINE);
                        if (isLoggable) {
                            j = hj6.e.g.c();
                            ec6.c(c, hj6, "starting");
                        }
                        try {
                            ij6.a(this.f, c);
                            if (isLoggable) {
                                long c2 = hj6.e.g.c() - j;
                                StringBuilder i0 = hj1.i0("finished run in ");
                                i0.append(ec6.o(c2));
                                ec6.c(c, hj6, i0.toString());
                            }
                        } catch (Throwable th) {
                            if (isLoggable) {
                                long c3 = hj6.e.g.c() - j;
                                StringBuilder i02 = hj1.i0("failed a run in ");
                                i02.append(ec6.o(c3));
                                ec6.c(c, hj6, i02.toString());
                            }
                            throw th;
                        }
                    } else {
                        n86.k();
                        throw null;
                    }
                } else {
                    return;
                }
            }
        }
    }

    static {
        String str = vi6.g + " TaskRunner";
        n86.f(str, "name");
        h = new ij6(new c(new ui6(str, true)));
        Logger logger = Logger.getLogger(ij6.class.getName());
        n86.b(logger, "Logger.getLogger(TaskRunner::class.java.name)");
        i = logger;
    }

    public ij6(a aVar) {
        n86.f(aVar, "backend");
        this.g = aVar;
    }

    public static final void a(ij6 ij6, fj6 fj6) {
        Objects.requireNonNull(ij6);
        byte[] bArr = vi6.f3652a;
        Thread currentThread = Thread.currentThread();
        n86.b(currentThread, "currentThread");
        String name = currentThread.getName();
        currentThread.setName(fj6.c);
        try {
            long a2 = fj6.a();
            synchronized (ij6) {
                ij6.b(fj6, a2);
            }
            currentThread.setName(name);
        } catch (Throwable th) {
            synchronized (ij6) {
                ij6.b(fj6, -1);
                currentThread.setName(name);
                throw th;
            }
        }
    }

    public final void b(fj6 fj6, long j2) {
        byte[] bArr = vi6.f3652a;
        hj6 hj6 = fj6.f1131a;
        if (hj6 != null) {
            if (hj6.b == fj6) {
                boolean z = hj6.d;
                hj6.d = false;
                hj6.b = null;
                this.d.remove(hj6);
                if (j2 != -1 && !z && !hj6.f1381a) {
                    hj6.e(fj6, j2, true);
                }
                if (!hj6.c.isEmpty()) {
                    this.e.add(hj6);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Check failed.".toString());
        }
        n86.k();
        throw null;
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:38:0x00a6 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final defpackage.fj6 c() {
        /*
        // Method dump skipped, instructions count: 173
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ij6.c():fj6");
    }

    public final void d() {
        for (int size = this.d.size() - 1; size >= 0; size--) {
            this.d.get(size).b();
        }
        for (int size2 = this.e.size() - 1; size2 >= 0; size2--) {
            hj6 hj6 = this.e.get(size2);
            hj6.b();
            if (hj6.c.isEmpty()) {
                this.e.remove(size2);
            }
        }
    }

    public final void e(hj6 hj6) {
        n86.f(hj6, "taskQueue");
        byte[] bArr = vi6.f3652a;
        if (hj6.b == null) {
            if (!hj6.c.isEmpty()) {
                List<hj6> list = this.e;
                n86.f(list, "$this$addIfAbsent");
                if (!list.contains(hj6)) {
                    list.add(hj6);
                }
            } else {
                this.e.remove(hj6);
            }
        }
        if (this.b) {
            this.g.a(this);
        } else {
            this.g.execute(this.f);
        }
    }

    public final hj6 f() {
        int i2;
        synchronized (this) {
            i2 = this.f1523a;
            this.f1523a = i2 + 1;
        }
        StringBuilder sb = new StringBuilder();
        sb.append('Q');
        sb.append(i2);
        return new hj6(this, sb.toString());
    }
}
