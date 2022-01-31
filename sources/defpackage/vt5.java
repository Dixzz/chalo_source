package defpackage;

import android.content.Context;
import app.zophop.models.mTicketing.ProductDiscountsObject;
import com.urbanairship.job.AirshipWorker;
import defpackage.lp;
import defpackage.vp;
import java.util.Collections;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* renamed from: vt5  reason: default package */
/* compiled from: WorkManagerScheduler */
public class vt5 implements tt5 {
    public static vp a(rt5 rt5) {
        vp.a aVar = new vp.a(AirshipWorker.class);
        aVar.c.add("airship");
        HashMap hashMap = new HashMap();
        hashMap.put("action", rt5.b);
        hashMap.put("extras", rt5.f3129a.toString());
        hashMap.put("component", rt5.c);
        hashMap.put("network_required", Boolean.valueOf(rt5.d));
        hashMap.put("initial_delay", Long.valueOf(rt5.e));
        hashMap.put("conflict_strategy", Integer.valueOf(rt5.f));
        np npVar = new np(hashMap);
        np.c(npVar);
        aVar.b.e = npVar;
        lp.a aVar2 = new lp.a();
        aVar2.f2252a = rt5.d ? up.CONNECTED : up.NOT_REQUIRED;
        lp lpVar = new lp(aVar2);
        rs rsVar = aVar.b;
        rsVar.j = lpVar;
        long j = rt5.e;
        if (j > 0) {
            rsVar.g = TimeUnit.MILLISECONDS.toMillis(j);
            if (Long.MAX_VALUE - System.currentTimeMillis() <= aVar.b.g) {
                throw new IllegalArgumentException("The given initial delay is too large and will cause an overflow!");
            }
        }
        return (vp) aVar.a();
    }

    public void b(Context context, rt5 rt5) throws ut5 {
        op opVar;
        try {
            vp a2 = a(rt5);
            int i = rt5.f;
            if (i == 0) {
                opVar = op.REPLACE;
            } else if (i != 1) {
                opVar = op.KEEP;
            } else {
                opVar = op.APPEND_OR_REPLACE;
            }
            pq a3 = pq.a(context);
            Objects.requireNonNull(a3);
            new kq(a3, rt5.c + ProductDiscountsObject.KEY_DELIMITER + rt5.b, opVar, Collections.singletonList(a2), null).a();
        } catch (Exception e) {
            throw new ut5("Failed to schedule job", e);
        }
    }
}
