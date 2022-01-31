package defpackage;

import android.net.TrafficStats;
import android.os.HandlerThread;

/* renamed from: ey5  reason: default package */
/* compiled from: AirshipHandlerThread */
public class ey5 extends HandlerThread {
    public ey5(String str) {
        super(str);
    }

    public void run() {
        TrafficStats.setThreadStatsTag(11797);
        super.run();
    }
}
