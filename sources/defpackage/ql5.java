package defpackage;

import android.content.Context;
import com.rabbitmq.client.ConnectionFactory;
import defpackage.rt5;
import java.util.concurrent.TimeUnit;

/* renamed from: ql5  reason: default package */
/* compiled from: EventManager */
public class ql5 {

    /* renamed from: a  reason: collision with root package name */
    public final hk5 f2960a;
    public final qt5 b;
    public final wl5 c;
    public final rl5 d;
    public final pl5 e;
    public final kq5 f;
    public final Object g = new Object();
    public final Object h = new Object();
    public boolean i;

    public ql5(Context context, hk5 hk5, kq5 kq5) {
        qt5 c2 = qt5.c(context);
        bm5 f2 = bm5.f(context);
        rl5 rl5 = new rl5(context);
        pl5 pl5 = new pl5(kq5);
        this.f2960a = hk5;
        this.f = kq5;
        this.b = c2;
        this.c = f2;
        this.d = rl5;
        this.e = pl5;
    }

    public final long a() {
        return Math.max((this.f2960a.e("com.urbanairship.analytics.LAST_SEND", 0) + ((long) this.f2960a.c("com.urbanairship.analytics.MIN_BATCH_INTERVAL", ConnectionFactory.DEFAULT_CONNECTION_TIMEOUT))) - System.currentTimeMillis(), 0L);
    }

    public void b(long j, TimeUnit timeUnit) {
        int i2;
        long millis = timeUnit.toMillis(j);
        yj5.h("Requesting to schedule event upload with delay %s ms.", Long.valueOf(millis));
        synchronized (this.h) {
            if (this.i) {
                long max = Math.max(System.currentTimeMillis() - this.f2960a.e("com.urbanairship.analytics.SCHEDULED_SEND_TIME", 0), 0L);
                if (max < millis) {
                    yj5.h("Event upload already scheduled for an earlier time.", new Object[0]);
                    millis = max;
                    i2 = 2;
                    yj5.h("Scheduling upload in %s ms.", Long.valueOf(millis));
                    rt5.b a2 = rt5.a();
                    a2.f3130a = "ACTION_SEND";
                    a2.c = true;
                    a2.b(fl5.class);
                    a2.d = TimeUnit.MILLISECONDS.toMillis(millis);
                    a2.f = i2;
                    this.b.a(a2.a());
                    this.f2960a.f("com.urbanairship.analytics.SCHEDULED_SEND_TIME").b(String.valueOf(System.currentTimeMillis() + millis));
                    this.i = true;
                }
            }
            i2 = 0;
            yj5.h("Scheduling upload in %s ms.", Long.valueOf(millis));
            rt5.b a22 = rt5.a();
            a22.f3130a = "ACTION_SEND";
            a22.c = true;
            a22.b(fl5.class);
            a22.d = TimeUnit.MILLISECONDS.toMillis(millis);
            a22.f = i2;
            this.b.a(a22.a());
            this.f2960a.f("com.urbanairship.analytics.SCHEDULED_SEND_TIME").b(String.valueOf(System.currentTimeMillis() + millis));
            this.i = true;
        }
    }
}
