package defpackage;

import android.view.View;
import app.zophop.ui.activities.TripPlanningActivity;

/* renamed from: fg0  reason: default package */
/* compiled from: TripPlanningActivity */
public class fg0 implements View.OnClickListener {
    public final /* synthetic */ TripPlanningActivity f;

    public fg0(TripPlanningActivity tripPlanningActivity) {
        this.f = tripPlanningActivity;
    }

    public void onClick(View view) {
        jz5.b().g(hj1.l("tripPlanner time change", Long.MIN_VALUE, "source", "trip planner activity"));
        new nn0().show(this.f.getFragmentManager(), "timePicker");
    }
}
