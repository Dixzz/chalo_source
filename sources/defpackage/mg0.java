package defpackage;

import android.text.Editable;
import android.text.TextWatcher;
import app.zophop.ui.activities.TripPlanningStopBasedActivity;

/* renamed from: mg0  reason: default package */
/* compiled from: TripPlanningStopBasedActivity */
public class mg0 implements TextWatcher {
    public final /* synthetic */ TripPlanningStopBasedActivity f;

    public mg0(TripPlanningStopBasedActivity tripPlanningStopBasedActivity) {
        this.f = tripPlanningStopBasedActivity;
    }

    public void afterTextChanged(Editable editable) {
        TripPlanningStopBasedActivity tripPlanningStopBasedActivity = this.f;
        if (tripPlanningStopBasedActivity.x) {
            TripPlanningStopBasedActivity.i0(tripPlanningStopBasedActivity, false);
            TripPlanningStopBasedActivity tripPlanningStopBasedActivity2 = this.f;
            String obj = editable.toString();
            TripPlanningStopBasedActivity tripPlanningStopBasedActivity3 = this.f;
            TripPlanningStopBasedActivity.h0(tripPlanningStopBasedActivity2, obj, tripPlanningStopBasedActivity3._toStopLoadingSpinner, tripPlanningStopBasedActivity3._clearToStopImageView, false);
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
