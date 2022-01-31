package defpackage;

import android.view.MotionEvent;
import android.view.View;
import app.zophop.ui.activities.TripPlanningStopBasedActivity;

/* renamed from: tg0  reason: default package */
/* compiled from: TripPlanningStopBasedActivity */
public class tg0 implements View.OnTouchListener {
    public final /* synthetic */ TripPlanningStopBasedActivity f;

    public tg0(TripPlanningStopBasedActivity tripPlanningStopBasedActivity) {
        this.f = tripPlanningStopBasedActivity;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        TripPlanningStopBasedActivity tripPlanningStopBasedActivity = this.f;
        tripPlanningStopBasedActivity.w = true;
        tripPlanningStopBasedActivity.x = false;
        bj0 bj0 = tripPlanningStopBasedActivity.u;
        if (bj0 != null) {
            bj0.q = true;
        }
        tk0 tk0 = tripPlanningStopBasedActivity.t;
        if (tk0 != null) {
            tk0.l = true;
        }
        if (!TripPlanningStopBasedActivity.j0(tripPlanningStopBasedActivity, tripPlanningStopBasedActivity._inputFrom)) {
            this.f._clearFromStopImageView.setVisibility(0);
            this.f._clearToStopImageView.setVisibility(8);
            TripPlanningStopBasedActivity tripPlanningStopBasedActivity2 = this.f;
            String obj = tripPlanningStopBasedActivity2._inputFrom.getText().toString();
            TripPlanningStopBasedActivity tripPlanningStopBasedActivity3 = this.f;
            TripPlanningStopBasedActivity.h0(tripPlanningStopBasedActivity2, obj, tripPlanningStopBasedActivity3._fromStopLoadingSpinner, tripPlanningStopBasedActivity3._clearFromStopImageView, true);
        } else {
            TripPlanningStopBasedActivity tripPlanningStopBasedActivity4 = this.f;
            tripPlanningStopBasedActivity4.v0(tripPlanningStopBasedActivity4._clearFromStopImageView, tripPlanningStopBasedActivity4._fromStopLoadingSpinner);
        }
        return false;
    }
}
