package defpackage;

import android.view.View;
import app.zophop.ui.activities.TripPlanningStopBasedActivity;

/* renamed from: wg0  reason: default package */
/* compiled from: TripPlanningStopBasedActivity */
public class wg0 implements View.OnClickListener {
    public final /* synthetic */ TripPlanningStopBasedActivity f;

    public wg0(TripPlanningStopBasedActivity tripPlanningStopBasedActivity) {
        this.f = tripPlanningStopBasedActivity;
    }

    public void onClick(View view) {
        if (!this.f.isFinishing()) {
            new sm0().show(this.f.getFragmentManager(), "");
        }
    }
}
