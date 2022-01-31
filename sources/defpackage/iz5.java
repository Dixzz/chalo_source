package defpackage;

/* renamed from: iz5  reason: default package */
/* compiled from: BackgroundPoster */
public final class iz5 implements Runnable {
    public final oz5 f = new oz5();
    public volatile boolean g;
    public final jz5 h;

    public iz5(jz5 jz5) {
        this.h = jz5;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:28|29|30|31) */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0032, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        java.lang.Thread.currentThread().getName();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x003d, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x003e, code lost:
        r4.g = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0040, code lost:
        throw r1;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x0034 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r4 = this;
        L_0x0000:
            r0 = 0
            oz5 r1 = r4.f     // Catch:{ InterruptedException -> 0x0034 }
            r2 = 1000(0x3e8, float:1.401E-42)
            monitor-enter(r1)     // Catch:{ InterruptedException -> 0x0034 }
            nz5 r3 = r1.f2751a     // Catch:{ all -> 0x002f }
            if (r3 != 0) goto L_0x000e
            long r2 = (long) r2     // Catch:{ all -> 0x002f }
            r1.wait(r2)     // Catch:{ all -> 0x002f }
        L_0x000e:
            nz5 r2 = r1.b()     // Catch:{ all -> 0x002f }
            monitor-exit(r1)
            if (r2 != 0) goto L_0x0029
            monitor-enter(r4)
            oz5 r1 = r4.f     // Catch:{ all -> 0x0026 }
            nz5 r2 = r1.b()     // Catch:{ all -> 0x0026 }
            if (r2 != 0) goto L_0x0024
            r4.g = r0     // Catch:{ all -> 0x0026 }
            monitor-exit(r4)     // Catch:{ all -> 0x0026 }
            r4.g = r0
            return
        L_0x0024:
            monitor-exit(r4)
            goto L_0x0029
        L_0x0026:
            r1 = move-exception
            monitor-exit(r4)
            throw r1
        L_0x0029:
            jz5 r1 = r4.h
            r1.d(r2)
            goto L_0x0000
        L_0x002f:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        L_0x0032:
            r1 = move-exception
            goto L_0x003e
        L_0x0034:
            java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0032 }
            r1.getName()     // Catch:{ all -> 0x0032 }
            r4.g = r0
            return
        L_0x003e:
            r4.g = r0
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.iz5.run():void");
    }
}
