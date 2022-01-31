package defpackage;

import android.view.MotionEvent;
import android.view.View;
import app.zophop.ui.activities.TripPlanningStopBasedActivity;

/* renamed from: ug0  reason: default package */
/* compiled from: TripPlanningStopBasedActivity */
public class ug0 implements View.OnTouchListener {
    public final /* synthetic */ TripPlanningStopBasedActivity f;

    public ug0(TripPlanningStopBasedActivity tripPlanningStopBasedActivity) {
        this.f = tripPlanningStopBasedActivity;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        TripPlanningStopBasedActivity tripPlanningStopBasedActivity = this.f;
        tripPlanningStopBasedActivity.x = true;
        tripPlanningStopBasedActivity.w = false;
        bj0 bj0 = tripPlanningStopBasedActivity.u;
        if (bj0 != null) {
            bj0.q = false;
        }
        tk0 tk0 = tripPlanningStopBasedActivity.t;
        if (tk0 != null) {
            tk0.l = false;
        }
        if (!TripPlanningStopBasedActivity.j0(tripPlanningStopBasedActivity, tripPlanningStopBasedActivity._inputTo)) {
            this.f._clearToStopImageView.setVisibility(0);
            this.f._clearFromStopImageView.setVisibility(8);
            TripPlanningStopBasedActivity tripPlanningStopBasedActivity2 = this.f;
            String obj = tripPlanningStopBasedActivity2._inputTo.getText().toString();
            TripPlanningStopBasedActivity tripPlanningStopBasedActivity3 = this.f;
            TripPlanningStopBasedActivity.h0(tripPlanningStopBasedActivity2, obj, tripPlanningStopBasedActivity3._toStopLoadingSpinner, tripPlanningStopBasedActivity3._clearToStopImageView, false);
        } else {
            TripPlanningStopBasedActivity tripPlanningStopBasedActivity4 = this.f;
            tripPlanningStopBasedActivity4.v0(tripPlanningStopBasedActivity4._clearToStopImageView, tripPlanningStopBasedActivity4._toStopLoadingSpinner);
        }
        return false;
    }
}
