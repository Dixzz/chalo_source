package defpackage;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import app.zophop.ui.activities.TripSchedulesActivity;
import zophop.models.Leg;

/* renamed from: vc1  reason: default package */
/* compiled from: OfflineSchedulerCard */
public class vc1 implements View.OnClickListener {
    public final /* synthetic */ Leg f;
    public final /* synthetic */ wc1 g;

    public vc1(wc1 wc1, Leg leg) {
        this.g = wc1;
        this.f = leg;
    }

    public void onClick(View view) {
        wc1 wc1 = this.g;
        Leg leg = this.f;
        Context context = wc1.f;
        String stop_name = leg.first_stop.getStop_name();
        String stop_id = leg.first_stop.getStop_id();
        String stop_name2 = leg.last_stop.getStop_name();
        String stop_id2 = leg.last_stop.getStop_id();
        String str = leg.mode.toString();
        int i = TripSchedulesActivity.u;
        Intent N0 = hj1.N0(context, TripSchedulesActivity.class, "extra_first_stop_name", stop_name);
        N0.putExtra("extra_first_stop_id", stop_id);
        N0.putExtra("extra_last_stop_name", stop_name2);
        N0.putExtra("extra_last_stop_id", stop_id2);
        N0.putExtra("extra_mode", str);
        context.startActivity(N0);
        wc1.b("train schedules", leg.mode);
    }
}
