package defpackage;

import android.content.Intent;
import android.view.View;
import app.zophop.R;
import app.zophop.ui.activities.PickLocationActivity;
import app.zophop.ui.activities.TripPlanningActivity;
import java.util.Objects;

/* renamed from: ig0  reason: default package */
/* compiled from: TripPlanningActivity */
public class ig0 implements View.OnClickListener {
    public final /* synthetic */ int f;
    public final /* synthetic */ TripPlanningActivity g;

    public ig0(TripPlanningActivity tripPlanningActivity, int i) {
        this.g = tripPlanningActivity;
        this.f = i;
    }

    public void onClick(View view) {
        String str;
        if (this.f == 0) {
            str = this.g.getString(R.string.enter_origin_location);
        } else {
            str = this.g.getString(R.string.enter_destination_location);
        }
        TripPlanningActivity tripPlanningActivity = this.g;
        int i = this.f;
        int i2 = TripPlanningActivity.B;
        Objects.requireNonNull(tripPlanningActivity);
        Intent intent = new Intent(tripPlanningActivity, PickLocationActivity.class);
        intent.putExtra("extra:search_copy", str);
        intent.putExtra("extra:show_extra_locations", "true");
        intent.putExtra("extra:show_locations", false);
        intent.putExtra("extra:source", "tripPlanner");
        tripPlanningActivity.startActivityForResult(intent, i);
    }
}
