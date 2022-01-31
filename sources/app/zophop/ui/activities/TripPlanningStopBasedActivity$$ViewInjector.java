package app.zophop.ui.activities;

import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import app.zophop.R;
import app.zophop.ui.views.collapse_on_scroll.CollapseOnScrollViewPager;
import app.zophop.utilities.external.loader_view.LoadingSpinnerView;
import app.zophop.utilities.ui.views.sliding_tabs.HorizontalTabScrollWithViewPager;
import butterknife.ButterKnife;

public class TripPlanningStopBasedActivity$$ViewInjector {
    public static void inject(ButterKnife.Finder finder, TripPlanningStopBasedActivity tripPlanningStopBasedActivity, Object obj) {
        tripPlanningStopBasedActivity._pages = (ViewPager) finder.findRequiredView(obj, R.id.pages, "field '_pages'");
        finder.findRequiredView(obj, R.id.header, "field '_inputForm'");
        tripPlanningStopBasedActivity._tabs = (HorizontalTabScrollWithViewPager) finder.findRequiredView(obj, R.id.tabs, "field '_tabs'");
        LinearLayout linearLayout = (LinearLayout) finder.findRequiredView(obj, R.id.preferences_layout, "field '_preferencesLayout'");
        tripPlanningStopBasedActivity._inputFrom = (EditText) finder.findRequiredView(obj, R.id.input_from, "field '_inputFrom'");
        tripPlanningStopBasedActivity._inputTo = (EditText) finder.findRequiredView(obj, R.id.input_to, "field '_inputTo'");
        tripPlanningStopBasedActivity._fromStopLoadingSpinner = (LoadingSpinnerView) finder.findRequiredView(obj, R.id.from_location_loading_spinner, "field '_fromStopLoadingSpinner'");
        tripPlanningStopBasedActivity._toStopLoadingSpinner = (LoadingSpinnerView) finder.findRequiredView(obj, R.id.to_location_loading_spinner, "field '_toStopLoadingSpinner'");
        tripPlanningStopBasedActivity._clearFromStopImageView = (ImageView) finder.findRequiredView(obj, R.id.clear_from_location, "field '_clearFromStopImageView'");
        tripPlanningStopBasedActivity._clearToStopImageView = (ImageView) finder.findRequiredView(obj, R.id.clear_to_location, "field '_clearToStopImageView'");
        tripPlanningStopBasedActivity._shadowAboveStopResultsListView = finder.findRequiredView(obj, R.id.shadow_above_stop_picker_results, "field '_shadowAboveStopResultsListView'");
        tripPlanningStopBasedActivity._stopResultsListView = (ListView) finder.findRequiredView(obj, R.id.stop_results_list_view, "field '_stopResultsListView'");
        tripPlanningStopBasedActivity._timeView = (TextView) finder.findRequiredView(obj, R.id.scheduler_time, "field '_timeView'");
        tripPlanningStopBasedActivity._swapPlannerButton = (ImageButton) finder.findRequiredView(obj, R.id.swap_planner_button, "field '_swapPlannerButton'");
        tripPlanningStopBasedActivity._timeContainer = (RelativeLayout) finder.findRequiredView(obj, R.id.time_container, "field '_timeContainer'");
        tripPlanningStopBasedActivity._stopPickerResultsContainer = (FrameLayout) finder.findRequiredView(obj, R.id.stop_picker_results_container, "field '_stopPickerResultsContainer'");
        tripPlanningStopBasedActivity._collaspeScrollView = (CollapseOnScrollViewPager) finder.findRequiredView(obj, R.id.collpase_view, "field '_collaspeScrollView'");
        tripPlanningStopBasedActivity._preferenceHook = (RelativeLayout) finder.findRequiredView(obj, R.id.preference_hook, "field '_preferenceHook'");
    }

    public static void reset(TripPlanningStopBasedActivity tripPlanningStopBasedActivity) {
        tripPlanningStopBasedActivity._pages = null;
        tripPlanningStopBasedActivity._tabs = null;
        tripPlanningStopBasedActivity._inputFrom = null;
        tripPlanningStopBasedActivity._inputTo = null;
        tripPlanningStopBasedActivity._fromStopLoadingSpinner = null;
        tripPlanningStopBasedActivity._toStopLoadingSpinner = null;
        tripPlanningStopBasedActivity._clearFromStopImageView = null;
        tripPlanningStopBasedActivity._clearToStopImageView = null;
        tripPlanningStopBasedActivity._shadowAboveStopResultsListView = null;
        tripPlanningStopBasedActivity._stopResultsListView = null;
        tripPlanningStopBasedActivity._timeView = null;
        tripPlanningStopBasedActivity._swapPlannerButton = null;
        tripPlanningStopBasedActivity._timeContainer = null;
        tripPlanningStopBasedActivity._stopPickerResultsContainer = null;
        tripPlanningStopBasedActivity._collaspeScrollView = null;
        tripPlanningStopBasedActivity._preferenceHook = null;
    }
}
