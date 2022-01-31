package defpackage;

import android.view.View;
import app.zophop.ui.activities.TripPlanningStopBasedActivity;

/* renamed from: vg0  reason: default package */
/* compiled from: TripPlanningStopBasedActivity */
public class vg0 implements View.OnClickListener {
    public final /* synthetic */ TripPlanningStopBasedActivity f;

    public vg0(TripPlanningStopBasedActivity tripPlanningStopBasedActivity) {
        this.f = tripPlanningStopBasedActivity;
    }

    public void onClick(View view) {
        jz5.b().g(hj1.l("tripPlanner time change", Long.MIN_VALUE, "source", "trip planner activity"));
        new nn0().show(this.f.getFragmentManager(), "timePicker");
    }
}
