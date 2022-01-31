package defpackage;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import app.zophop.ui.activities.TripPlanningStopBasedActivity;
import app.zophop.utilities.external.loader_view.LoadingSpinnerView;
import java.util.Objects;

/* renamed from: kg0  reason: default package */
/* compiled from: TripPlanningStopBasedActivity */
public class kg0 implements View.OnClickListener {
    public final /* synthetic */ ImageView f;
    public final /* synthetic */ EditText g;
    public final /* synthetic */ LoadingSpinnerView h;
    public final /* synthetic */ TripPlanningStopBasedActivity i;

    public kg0(TripPlanningStopBasedActivity tripPlanningStopBasedActivity, ImageView imageView, EditText editText, LoadingSpinnerView loadingSpinnerView) {
        this.i = tripPlanningStopBasedActivity;
        this.f = imageView;
        this.g = editText;
        this.h = loadingSpinnerView;
    }

    public void onClick(View view) {
        TripPlanningStopBasedActivity tripPlanningStopBasedActivity = this.i;
        ImageView imageView = this.f;
        EditText editText = this.g;
        LoadingSpinnerView loadingSpinnerView = this.h;
        String str = TripPlanningStopBasedActivity.z;
        Objects.requireNonNull(tripPlanningStopBasedActivity);
        editText.setText((CharSequence) null);
        imageView.setVisibility(8);
        loadingSpinnerView.setVisibility(8);
        if (imageView.equals(tripPlanningStopBasedActivity._clearFromStopImageView)) {
            tripPlanningStopBasedActivity.o = null;
        } else {
            tripPlanningStopBasedActivity.p = null;
        }
        tripPlanningStopBasedActivity.t.a();
        tk0 tk0 = tripPlanningStopBasedActivity.t;
        z61 z61 = tk0.g;
        z61.f4136a = false;
        z61.i();
        z61 z612 = tk0.g;
        z612.h = false;
        z612.i();
        bj0 bj0 = tripPlanningStopBasedActivity.u;
        bj0.l();
        bj0.notifyDataSetChanged();
        tripPlanningStopBasedActivity._stopResultsListView.setAdapter((ListAdapter) tripPlanningStopBasedActivity.u);
    }
}
