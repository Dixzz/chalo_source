package defpackage;

import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* renamed from: n06  reason: default package */
/* compiled from: ExecutorUtils */
public final class n06 extends i06 {
    public final /* synthetic */ String f;
    public final /* synthetic */ ExecutorService g;
    public final /* synthetic */ long h;
    public final /* synthetic */ TimeUnit i;

    public n06(String str, ExecutorService executorService, long j, TimeUnit timeUnit) {
        this.f = str;
        this.g = executorService;
        this.h = j;
        this.i = timeUnit;
    }

    @Override // defpackage.i06
    public void onRun() {
        try {
            this.g.shutdown();
            if (!this.g.awaitTermination(this.h, this.i)) {
                this.g.shutdownNow();
            }
        } catch (InterruptedException unused) {
            String.format(Locale.US, "Interrupted while waiting for %s to shut down. Requesting immediate shutdown.", this.f);
            this.g.shutdownNow();
        }
    }
}
