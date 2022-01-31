package defpackage;

/* renamed from: rw1  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class rw1 implements Runnable {
    public final /* synthetic */ ax1 f;
    public final /* synthetic */ jv1 g;
    public final /* synthetic */ int h;
    public final /* synthetic */ Runnable i;

    public /* synthetic */ rw1(ax1 ax1, jv1 jv1, int i2, Runnable runnable) {
        this.f = ax1;
        this.g = jv1;
        this.h = i2;
        this.i = runnable;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:12|13) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0045, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r0.d.a(r1, r2 + 1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0051, code lost:
        r3.run();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0054, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0047 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r8 = this;
            ax1 r0 = r8.f
            jv1 r1 = r8.g
            int r2 = r8.h
            java.lang.Runnable r3 = r8.i
            java.util.Objects.requireNonNull(r0)
            r4 = 1
            iy1 r5 = r0.f     // Catch:{ hy1 -> 0x0047 }
            xx1 r6 = r0.c     // Catch:{ hy1 -> 0x0047 }
            java.util.Objects.requireNonNull(r6)     // Catch:{ hy1 -> 0x0047 }
            ow1 r7 = new ow1     // Catch:{ hy1 -> 0x0047 }
            r7.<init>(r6)     // Catch:{ hy1 -> 0x0047 }
            r5.a(r7)     // Catch:{ hy1 -> 0x0047 }
            android.content.Context r5 = r0.f344a     // Catch:{ hy1 -> 0x0047 }
            java.lang.String r6 = "connectivity"
            java.lang.Object r5 = r5.getSystemService(r6)     // Catch:{ hy1 -> 0x0047 }
            android.net.ConnectivityManager r5 = (android.net.ConnectivityManager) r5     // Catch:{ hy1 -> 0x0047 }
            android.net.NetworkInfo r5 = r5.getActiveNetworkInfo()     // Catch:{ hy1 -> 0x0047 }
            if (r5 == 0) goto L_0x0033
            boolean r5 = r5.isConnected()     // Catch:{ hy1 -> 0x0047 }
            if (r5 == 0) goto L_0x0033
            r5 = 1
            goto L_0x0034
        L_0x0033:
            r5 = 0
        L_0x0034:
            if (r5 != 0) goto L_0x0041
            iy1 r5 = r0.f     // Catch:{ hy1 -> 0x0047 }
            tw1 r6 = new tw1     // Catch:{ hy1 -> 0x0047 }
            r6.<init>(r0, r1, r2)     // Catch:{ hy1 -> 0x0047 }
            r5.a(r6)     // Catch:{ hy1 -> 0x0047 }
            goto L_0x004d
        L_0x0041:
            r0.a(r1, r2)     // Catch:{ hy1 -> 0x0047 }
            goto L_0x004d
        L_0x0045:
            r0 = move-exception
            goto L_0x0051
        L_0x0047:
            ex1 r0 = r0.d     // Catch:{ all -> 0x0045 }
            int r2 = r2 + r4
            r0.a(r1, r2)     // Catch:{ all -> 0x0045 }
        L_0x004d:
            r3.run()
            return
        L_0x0051:
            r3.run()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.rw1.run():void");
    }
}
