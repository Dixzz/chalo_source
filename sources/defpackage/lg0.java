package defpackage;

import android.text.Editable;
import android.text.TextWatcher;
import app.zophop.ui.activities.TripPlanningStopBasedActivity;

/* renamed from: lg0  reason: default package */
/* compiled from: TripPlanningStopBasedActivity */
public class lg0 implements TextWatcher {
    public final /* synthetic */ TripPlanningStopBasedActivity f;

    public lg0(TripPlanningStopBasedActivity tripPlanningStopBasedActivity) {
        this.f = tripPlanningStopBasedActivity;
    }

    public void afterTextChanged(Editable editable) {
        TripPlanningStopBasedActivity tripPlanningStopBasedActivity = this.f;
        if (tripPlanningStopBasedActivity.w) {
            TripPlanningStopBasedActivity.i0(tripPlanningStopBasedActivity, true);
            TripPlanningStopBasedActivity tripPlanningStopBasedActivity2 = this.f;
            String obj = editable.toString();
            TripPlanningStopBasedActivity tripPlanningStopBasedActivity3 = this.f;
            TripPlanningStopBasedActivity.h0(tripPlanningStopBasedActivity2, obj, tripPlanningStopBasedActivity3._fromStopLoadingSpinner, tripPlanningStopBasedActivity3._clearFromStopImageView, true);
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
