package defpackage;

import com.freshchat.consumer.sdk.beans.config.DefaultRefreshIntervals;
import defpackage.bz5;

/* renamed from: cz5  reason: default package */
/* compiled from: RetryingExecutor */
public class cz5 implements Runnable {
    public final /* synthetic */ bz5.c f;
    public final /* synthetic */ long g;
    public final /* synthetic */ bz5 h;

    /* renamed from: cz5$a */
    /* compiled from: RetryingExecutor */
    public class a implements Runnable {
        public a() {
        }

        public void run() {
            cz5 cz5 = cz5.this;
            bz5 bz5 = cz5.h;
            bz5.g.execute(new cz5(bz5, cz5.f, Math.min(cz5.g * 2, (long) DefaultRefreshIntervals.RESPONSE_TIME_EXPECTATIONS_FETCH_INTERVAL)));
        }
    }

    public cz5(bz5 bz5, bz5.c cVar, long j) {
        this.h = bz5;
        this.f = cVar;
        this.g = j;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001a, code lost:
        if (r7.f.run() != 1) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        r0 = r7.h;
        r0.f.postAtTime(new defpackage.cz5.a(r7), r0.g, android.os.SystemClock.uptimeMillis() + r7.g);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r7 = this;
            bz5 r0 = r7.h
            java.util.List<java.lang.Runnable> r0 = r0.i
            monitor-enter(r0)
            bz5 r1 = r7.h     // Catch:{ all -> 0x0032 }
            boolean r2 = r1.h     // Catch:{ all -> 0x0032 }
            if (r2 == 0) goto L_0x0012
            java.util.List<java.lang.Runnable> r1 = r1.i     // Catch:{ all -> 0x0032 }
            r1.add(r7)     // Catch:{ all -> 0x0032 }
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            return
        L_0x0012:
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            bz5$c r0 = r7.f
            int r0 = r0.run()
            r1 = 1
            if (r0 != r1) goto L_0x0031
            bz5 r0 = r7.h
            android.os.Handler r1 = r0.f
            cz5$a r2 = new cz5$a
            r2.<init>()
            java.util.concurrent.Executor r0 = r0.g
            long r3 = android.os.SystemClock.uptimeMillis()
            long r5 = r7.g
            long r3 = r3 + r5
            r1.postAtTime(r2, r0, r3)
        L_0x0031:
            return
        L_0x0032:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.cz5.run():void");
    }
}
