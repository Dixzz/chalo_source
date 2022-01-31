package defpackage;

/* renamed from: t6  reason: default package */
/* compiled from: CancellationSignal */
public final class t6 {

    /* renamed from: a  reason: collision with root package name */
    public boolean f3312a;
    public a b;
    public boolean c;

    /* renamed from: t6$a */
    /* compiled from: CancellationSignal */
    public interface a {
        void a();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r0.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0016, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0017, code lost:
        monitor-enter(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r2.c = false;
        notifyAll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x001e, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0022, code lost:
        monitor-enter(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r2.c = false;
        notifyAll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0028, code lost:
        monitor-exit(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0029, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0010, code lost:
        if (r0 == null) goto L_0x0022;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a() {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.f3312a     // Catch:{ all -> 0x002d }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r2)     // Catch:{ all -> 0x002d }
            return
        L_0x0007:
            r0 = 1
            r2.f3312a = r0     // Catch:{ all -> 0x002d }
            r2.c = r0     // Catch:{ all -> 0x002d }
            t6$a r0 = r2.b     // Catch:{ all -> 0x002d }
            monitor-exit(r2)     // Catch:{ all -> 0x002d }
            r1 = 0
            if (r0 == 0) goto L_0x0022
            r0.a()     // Catch:{ all -> 0x0016 }
            goto L_0x0022
        L_0x0016:
            r0 = move-exception
            monitor-enter(r2)
            r2.c = r1     // Catch:{ all -> 0x001f }
            r2.notifyAll()     // Catch:{ all -> 0x001f }
            monitor-exit(r2)     // Catch:{ all -> 0x001f }
            throw r0
        L_0x001f:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        L_0x0022:
            monitor-enter(r2)
            r2.c = r1     // Catch:{ all -> 0x002a }
            r2.notifyAll()     // Catch:{ all -> 0x002a }
            monitor-exit(r2)     // Catch:{ all -> 0x002a }
            return
        L_0x002a:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x002a }
            throw r0
        L_0x002d:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.t6.a():void");
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:1:0x0001 */
    /* JADX WARNING: Removed duplicated region for block: B:1:0x0001 A[LOOP:0: B:1:0x0001->B:20:0x0001, LOOP_START, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(defpackage.t6.a r2) {
        /*
            r1 = this;
            monitor-enter(r1)
        L_0x0001:
            boolean r0 = r1.c     // Catch:{ all -> 0x001c }
            if (r0 == 0) goto L_0x0009
            r1.wait()     // Catch:{ InterruptedException -> 0x0001 }
            goto L_0x0001
        L_0x0009:
            t6$a r0 = r1.b
            if (r0 != r2) goto L_0x000f
            monitor-exit(r1)
            return
        L_0x000f:
            r1.b = r2
            boolean r0 = r1.f3312a
            if (r0 == 0) goto L_0x001a
            monitor-exit(r1)
            r2.a()
            return
        L_0x001a:
            monitor-exit(r1)
            return
        L_0x001c:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.t6.b(t6$a):void");
    }
}
