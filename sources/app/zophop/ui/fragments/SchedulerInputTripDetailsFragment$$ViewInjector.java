package app.zophop.ui.fragments;

import android.widget.ListView;
import android.widget.RelativeLayout;
import app.zophop.R;
import app.zophop.utilities.external.loader_view.LoadingSpinnerView;
import butterknife.ButterKnife;

public class SchedulerInputTripDetailsFragment$$ViewInjector {
    public static void inject(ButterKnife.Finder finder, SchedulerInputTripDetailsFragment schedulerInputTripDetailsFragment, Object obj) {
        schedulerInputTripDetailsFragment._tripList = (ListView) finder.findRequiredView(obj, R.id.trip_list, "field '_tripList'");
        schedulerInputTripDetailsFragment._infoLayout = (RelativeLayout) finder.findRequiredView(obj, R.id.scheduler_cards, "field '_infoLayout'");
        schedulerInputTripDetailsFragment._loaderView = (LoadingSpinnerView) finder.findRequiredView(obj, R.id.loading_spinner, "field '_loaderView'");
    }

    public static void reset(SchedulerInputTripDetailsFragment schedulerInputTripDetailsFragment) {
        schedulerInputTripDetailsFragment._tripList = null;
        schedulerInputTripDetailsFragment._infoLayout = null;
        schedulerInputTripDetailsFragment._loaderView = null;
    }
}
