package defpackage;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* renamed from: x50  reason: default package */
/* compiled from: UrlPollFeature */
public class x50 implements r20 {

    /* renamed from: a  reason: collision with root package name */
    public final ScheduledExecutorService f3886a = Executors.newScheduledThreadPool(1);
    public final Map<String, ScheduledFuture> b;
    public final xj1 c;

    public x50(xj1 xj1) {
        this.c = xj1;
        this.b = new HashMap();
    }

    @Override // defpackage.r20
    public void a(String str, long j, ji1<JSONObject, String> ji1) {
        b(str);
        this.b.put(str, this.f3886a.scheduleAtFixedRate(new w50(this, ji1, str), j, j, TimeUnit.MILLISECONDS));
    }

    @Override // defpackage.r20
    public void b(String str) {
        ScheduledFuture scheduledFuture = this.b.get(str);
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
    }
}
