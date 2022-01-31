package defpackage;

import com.freshchat.consumer.sdk.beans.config.DefaultRefreshIntervals;
import com.rabbitmq.client.AlreadyClosedException;
import java.util.Objects;
import java.util.TimerTask;

/* renamed from: ae1  reason: default package */
/* compiled from: RabbitQueue */
public class ae1 extends TimerTask {
    public final /* synthetic */ ce1 f;

    public ae1(ce1 ce1) {
        this.f = ce1;
    }

    public void run() {
        long currentTimeMillis = System.currentTimeMillis();
        ce1 ce1 = this.f;
        if (ce1.g != null && currentTimeMillis - ce1.l > DefaultRefreshIntervals.ACTIVE_CONV_MAX_FETCH_INTERVAL && ce1.e.isEmpty()) {
            this.f.f.shutdown();
            ce1 ce12 = this.f;
            Objects.requireNonNull(ce12);
            try {
                ce12.g.close();
                ce12.d();
            } catch (AlreadyClosedException unused) {
                ce12.d();
            } catch (Exception unused2) {
                ce12.d();
            }
        }
    }
}
