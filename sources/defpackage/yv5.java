package defpackage;

import android.content.Context;
import com.urbanairship.push.PushMessage;
import com.urbanairship.push.PushProvider;
import defpackage.nv5;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* renamed from: yv5  reason: default package */
/* compiled from: PushProviderBridge */
public class yv5 {

    /* renamed from: a  reason: collision with root package name */
    public final Class<? extends PushProvider> f4089a;
    public final PushMessage b;
    public long c;

    public yv5(Class cls, PushMessage pushMessage, wv5 wv5) {
        this.f4089a = cls;
        this.b = pushMessage;
    }

    public void a(Context context, Runnable runnable) {
        nv5.b bVar = new nv5.b(context);
        bVar.b = this.b;
        String cls = this.f4089a.toString();
        bVar.c = cls;
        ExecutorService executorService = vv5.y;
        hd3.E(cls, "Provider class missing");
        hd3.E(bVar.b, "Push Message missing");
        Future<?> submit = executorService.submit(new nv5(bVar, null));
        try {
            long j = this.c;
            if (j > 0) {
                submit.get(j, TimeUnit.MILLISECONDS);
            } else {
                submit.get();
            }
        } catch (TimeoutException unused) {
            yj5.c("Application took too long to process push. App may get closed.", new Object[0]);
        } catch (Exception e) {
            yj5.e(e, "Failed to wait for notification", new Object[0]);
        }
        ((xv5) runnable).f.countDown();
    }
}
