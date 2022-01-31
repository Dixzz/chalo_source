package defpackage;

import android.os.Bundle;
import com.urbanairship.actions.ActionValue;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/* renamed from: sv5  reason: default package */
/* compiled from: NotificationIntentProcessor */
public class sv5 implements Runnable {
    public final /* synthetic */ Map f;
    public final /* synthetic */ Bundle g;
    public final /* synthetic */ int h;
    public final /* synthetic */ Runnable i;

    /* renamed from: sv5$a */
    /* compiled from: NotificationIntentProcessor */
    public class a implements pk5 {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f3262a;

        public a(sv5 sv5, CountDownLatch countDownLatch) {
            this.f3262a = countDownLatch;
        }

        @Override // defpackage.pk5
        public void a(ok5 ok5, rk5 rk5) {
            this.f3262a.countDown();
        }
    }

    public sv5(rv5 rv5, Map map, Bundle bundle, int i2, Runnable runnable) {
        this.f = map;
        this.g = bundle;
        this.h = i2;
        this.i = runnable;
    }

    public void run() {
        CountDownLatch countDownLatch = new CountDownLatch(this.f.size());
        for (Map.Entry entry : this.f.entrySet()) {
            tk5 a2 = tk5.a((String) entry.getKey());
            a2.d = this.g;
            a2.f = this.h;
            a2.c = (ActionValue) entry.getValue();
            a2.c(null, new a(this, countDownLatch));
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            yj5.e(e, "Failed to wait for actions", new Object[0]);
            Thread.currentThread().interrupt();
        }
        this.i.run();
    }
}
