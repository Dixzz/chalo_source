package app.zophop.ui.views;

import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import app.zophop.R;
import butterknife.ButterKnife;

public class RecentProductItemView$$ViewInjector {
    public static void inject(ButterKnife.Finder finder, RecentProductItemView recentProductItemView, Object obj) {
        recentProductItemView._passType = (TextView) finder.findRequiredView(obj, R.id.pass_type_title, "field '_passType'");
        recentProductItemView._fare = (TextView) finder.findRequiredView(obj, R.id.fare, "field '_fare'");
        recentProductItemView._mpassLinearLayout = (LinearLayout) finder.findRequiredView(obj, R.id.mpass_linearlayout, "field '_mpassLinearLayout'");
        recentProductItemView._mticketConstraintLayout = (ConstraintLayout) finder.findRequiredView(obj, R.id.mticket_constraintlayout, "field '_mticketConstraintLayout'");
        recentProductItemView._mticketRouteNamelayout = (LinearLayout) finder.findRequiredView(obj, R.id.mticket_route_name_layout, "field '_mticketRouteNamelayout'");
        recentProductItemView._mpassRouteNumber = (TextView) finder.findRequiredView(obj, R.id.mpass_route_name, "field '_mpassRouteNumber'");
        recentProductItemView._mpassRouteDetails = (TextView) finder.findRequiredView(obj, R.id.route_details_mpass, "field '_mpassRouteDetails'");
        recentProductItemView._mticketRouteNumber = (TextView) finder.findRequiredView(obj, R.id.mticket_route_name, "field '_mticketRouteNumber'");
        recentProductItemView._startStop = (TextView) finder.findRequiredView(obj, R.id.tv_start_stop, "field '_startStop'");
        recentProductItemView._endStop = (TextView) finder.findRequiredView(obj, R.id.tv_end_stop, "field '_endStop'");
        recentProductItemView._passengerDetails = (TextView) finder.findRequiredView(obj, R.id.passenger_details, "field '_passengerDetails'");
    }

    public static void reset(RecentProductItemView recentProductItemView) {
        recentProductItemView._passType = null;
        recentProductItemView._fare = null;
        recentProductItemView._mpassLinearLayout = null;
        recentProductItemView._mticketConstraintLayout = null;
        recentProductItemView._mticketRouteNamelayout = null;
        recentProductItemView._mpassRouteNumber = null;
        recentProductItemView._mpassRouteDetails = null;
        recentProductItemView._mticketRouteNumber = null;
        recentProductItemView._startStop = null;
        recentProductItemView._endStop = null;
        recentProductItemView._passengerDetails = null;
    }
}
