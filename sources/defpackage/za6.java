package defpackage;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: za6  reason: default package */
/* compiled from: CommonPool.kt */
public final class za6 extends hc6 {
    public static final za6 g = new za6();
    public static final int h;
    private static volatile Executor pool;

    static {
        String str;
        int i;
        try {
            str = System.getProperty("kotlinx.coroutines.default.parallelism");
        } catch (Throwable unused) {
            str = null;
        }
        if (str == null) {
            i = -1;
        } else {
            Integer J = ea6.J(str);
            if (J == null || J.intValue() < 1) {
                throw new IllegalStateException(n86.j("Expected positive number in kotlinx.coroutines.default.parallelism, but has ", str).toString());
            }
            i = J.intValue();
        }
        h = i;
    }

    public final ExecutorService D() {
        return Executors.newFixedThreadPool(J(), new ja6(new AtomicInteger()));
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x006d A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.concurrent.ExecutorService E() {
        /*
        // Method dump skipped, instructions count: 154
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.za6.E():java.util.concurrent.ExecutorService");
    }

    public final int J() {
        Integer valueOf = Integer.valueOf(h);
        if (!(valueOf.intValue() > 0)) {
            valueOf = null;
        }
        if (valueOf != null) {
            return valueOf.intValue();
        }
        int availableProcessors = Runtime.getRuntime().availableProcessors() - 1;
        if (availableProcessors < 1) {
            return 1;
        }
        return availableProcessors;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Close cannot be invoked on CommonPool".toString());
    }

    @Override // defpackage.kb6
    public void m(m66 m66, Runnable runnable) {
        try {
            Executor executor = pool;
            if (executor == null) {
                synchronized (this) {
                    executor = pool;
                    if (executor == null) {
                        executor = E();
                        pool = executor;
                    }
                }
            }
            executor.execute(runnable);
        } catch (RejectedExecutionException unused) {
            pb6.l.P(runnable);
        }
    }

    @Override // defpackage.kb6
    public String toString() {
        return "CommonPool";
    }
}
