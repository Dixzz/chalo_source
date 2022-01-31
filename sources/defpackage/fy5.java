package defpackage;

import android.net.TrafficStats;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: fy5  reason: default package */
/* compiled from: AirshipThreadFactory */
public class fy5 implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    public static final fy5 f1188a = new fy5("UrbanAirship");
    public static final AtomicInteger b = new AtomicInteger(1);

    /* renamed from: fy5$a */
    /* compiled from: AirshipThreadFactory */
    public class a implements Runnable {
        public final /* synthetic */ Runnable f;

        public a(fy5 fy5, Runnable runnable) {
            this.f = runnable;
        }

        public void run() {
            TrafficStats.setThreadStatsTag(11797);
            Runnable runnable = this.f;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public fy5(String str) {
    }

    public Thread newThread(Runnable runnable) {
        a aVar = new a(this, runnable);
        StringBuilder k0 = hj1.k0("UrbanAirship", "#");
        k0.append(b.getAndIncrement());
        Thread thread = new Thread(aVar, k0.toString());
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (thread.getPriority() != 5) {
            thread.setPriority(5);
        }
        return thread;
    }
}
