package defpackage;

import android.view.View;
import app.zophop.models.Stop;
import app.zophop.ui.activities.SubscriptionActivity;
import j$.util.DesugarTimeZone;
import java.util.Calendar;
import server.zophop.logging.LoggingConstants;

/* renamed from: rf0  reason: default package */
/* compiled from: SubscriptionActivity */
public class rf0 implements View.OnClickListener {
    public final /* synthetic */ SubscriptionActivity f;

    public rf0(SubscriptionActivity subscriptionActivity) {
        this.f = subscriptionActivity;
    }

    public void onClick(View view) {
        SubscriptionActivity subscriptionActivity = this.f;
        ed1 ed1 = new ed1("route subscribe time picker clicked", Long.MIN_VALUE);
        Stop stop = subscriptionActivity.m;
        if (stop != null) {
            ed1.a("stopId", stop.getId());
        }
        String str = subscriptionActivity.t;
        if (str != null) {
            ed1.a(LoggingConstants.ROUTE_ID, str);
        }
        long currentTimeMillis = System.currentTimeMillis();
        Calendar instance = Calendar.getInstance(DesugarTimeZone.getTimeZone("gmt"));
        instance.setTimeInMillis(currentTimeMillis + 19800000);
        int i = instance.get(11);
        int i2 = instance.get(12);
        ed1.a("hour", Integer.valueOf(i));
        ed1.a("minute", Integer.valueOf(i2));
        jz5.b().g(ed1);
        new nn0().show(this.f.getFragmentManager(), "timePicker");
    }
}
