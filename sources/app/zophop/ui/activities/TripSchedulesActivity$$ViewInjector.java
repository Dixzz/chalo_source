package app.zophop.ui.activities;

import android.widget.ListView;
import app.zophop.R;
import app.zophop.ui.views.summary_card.LoaderView;
import butterknife.ButterKnife;

public class TripSchedulesActivity$$ViewInjector {
    public static void inject(ButterKnife.Finder finder, TripSchedulesActivity tripSchedulesActivity, Object obj) {
        tripSchedulesActivity._trainSchedulesView = (ListView) finder.findRequiredView(obj, R.id.trips, "field '_trainSchedulesView'");
        tripSchedulesActivity._loader = (LoaderView) finder.findRequiredView(obj, R.id.loader, "field '_loader'");
    }

    public static void reset(TripSchedulesActivity tripSchedulesActivity) {
        tripSchedulesActivity._trainSchedulesView = null;
        tripSchedulesActivity._loader = null;
    }
}
