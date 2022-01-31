package defpackage;

import android.view.View;
import app.zophop.models.Stop;
import app.zophop.ui.activities.TripPlanningStopBasedActivity;
import java.util.Objects;

/* renamed from: vk0  reason: default package */
/* compiled from: TripPlannerStopBasedResultsAdapter */
public class vk0 implements View.OnClickListener {
    public final /* synthetic */ Stop f;
    public final /* synthetic */ tk0 g;

    public vk0(tk0 tk0, Stop stop) {
        this.g = tk0;
        this.f = stop;
    }

    public void onClick(View view) {
        tk0 tk0 = this.g;
        Stop stop = this.f;
        Objects.requireNonNull(tk0);
        ed1 ed1 = new ed1("stopBased tripPlanner stop clicked", Long.MIN_VALUE);
        ed1.a("stop", stop.getName());
        ed1.a("stopId", stop.getId());
        TripPlanningStopBasedActivity.w0(ed1, "stop", true, tk0.h, false, false);
        xt.f3961a.b0().d(stop);
        if (tk0.l) {
            tk0.i.a(stop);
        } else {
            tk0.j.a(stop);
        }
    }
}
