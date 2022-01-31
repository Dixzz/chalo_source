package app.zophop.ui.views;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import app.zophop.R;
import butterknife.ButterKnife;
import com.google.android.flexbox.FlexboxLayout;

public class SummaryView$$ViewInjector {
    public static void inject(ButterKnife.Finder finder, SummaryView summaryView, Object obj) {
        summaryView._durationText = (TextView) finder.findRequiredView(obj, R.id.duration, "field '_durationText'");
        summaryView._fareDurationTagsLayout = (LinearLayout) finder.findRequiredView(obj, R.id.fare_duration_tags_layout, "field '_fareDurationTagsLayout'");
        summaryView._fareText = (TextView) finder.findRequiredView(obj, R.id.fare_range, "field '_fareText'");
        summaryView._modeSequenceText = (TextView) finder.findRequiredView(obj, R.id.mode_sequence, "field '_modeSequenceText'");
        summaryView._seatOccupancyIconStopBasedTripPlannerResultsSingleLeg = (ImageView) finder.findRequiredView(obj, R.id.seat_occupancy_icon_stopbased_tripplanner_results_single_leg, "field '_seatOccupancyIconStopBasedTripPlannerResultsSingleLeg'");
        summaryView._etaStopBasedTripPlannerResultsSingleLeg = (TextView) finder.findRequiredView(obj, R.id.eta_stopbased_tripplanner_results_single_leg, "field '_etaStopBasedTripPlannerResultsSingleLeg'");
        summaryView._via = (TextView) finder.findRequiredView(obj, R.id.via, "field '_via'");
        summaryView._realTime = (TextView) finder.findRequiredView(obj, R.id.summary_real_time, "field '_realTime'");
        summaryView._changes = (TextView) finder.findRequiredView(obj, R.id.number_of_changes, "field '_changes'");
        summaryView._bookButton = (TextView) finder.findRequiredView(obj, R.id.book_button, "field '_bookButton'");
        summaryView._modeInfoContainer = finder.findRequiredView(obj, R.id.mode_info_container, "field '_modeInfoContainer'");
        summaryView._moreDetailsView = (TextView) finder.findRequiredView(obj, R.id.more_details_text_view, "field '_moreDetailsView'");
        summaryView._cheapestView = (TextView) finder.findRequiredView(obj, R.id.cheapest, "field '_cheapestView'");
        summaryView._fastestView = (TextView) finder.findRequiredView(obj, R.id.fastest, "field '_fastestView'");
        summaryView._fromView = (TextView) finder.findRequiredView(obj, R.id.from, "field '_fromView'");
        summaryView._seatOccupancyIcon = (ImageView) finder.findRequiredView(obj, R.id.seat_occupancy_icon_tripplanner_results, "field '_seatOccupancyIcon'");
        summaryView._modeSequenceContainer = (FlexboxLayout) finder.findRequiredView(obj, R.id.mode_sequence_container, "field '_modeSequenceContainer'");
    }

    public static void reset(SummaryView summaryView) {
        summaryView._durationText = null;
        summaryView._fareDurationTagsLayout = null;
        summaryView._fareText = null;
        summaryView._modeSequenceText = null;
        summaryView._seatOccupancyIconStopBasedTripPlannerResultsSingleLeg = null;
        summaryView._etaStopBasedTripPlannerResultsSingleLeg = null;
        summaryView._via = null;
        summaryView._realTime = null;
        summaryView._changes = null;
        summaryView._bookButton = null;
        summaryView._modeInfoContainer = null;
        summaryView._moreDetailsView = null;
        summaryView._cheapestView = null;
        summaryView._fastestView = null;
        summaryView._fromView = null;
        summaryView._seatOccupancyIcon = null;
        summaryView._modeSequenceContainer = null;
    }
}
