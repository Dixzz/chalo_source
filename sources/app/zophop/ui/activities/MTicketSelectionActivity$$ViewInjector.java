package app.zophop.ui.activities;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import app.zophop.R;
import butterknife.ButterKnife;

public class MTicketSelectionActivity$$ViewInjector {
    public static void inject(ButterKnife.Finder finder, MTicketSelectionActivity mTicketSelectionActivity, Object obj) {
        mTicketSelectionActivity._btnBookMTicket = (TextView) finder.findRequiredView(obj, R.id.btn_mticket_pay, "field '_btnBookMTicket'");
        mTicketSelectionActivity.partnerText = (TextView) finder.findRequiredView(obj, R.id.partner_text_id, "field 'partnerText'");
        mTicketSelectionActivity.agencyText = (TextView) finder.findRequiredView(obj, R.id.agency_text_id, "field 'agencyText'");
        mTicketSelectionActivity._fareBreakUpContainer = (LinearLayout) finder.findRequiredView(obj, R.id.fare_breakup_container, "field '_fareBreakUpContainer'");
        mTicketSelectionActivity._passengerDetailsLayout = (LinearLayout) finder.findRequiredView(obj, R.id.mticket_passenger_details, "field '_passengerDetailsLayout'");
        mTicketSelectionActivity._mTicketPassengerDetails = (LinearLayout) finder.findRequiredView(obj, R.id.passenger_fare_details, "field '_mTicketPassengerDetails'");
        mTicketSelectionActivity._mTicketTripInfoContainer = (RelativeLayout) finder.findRequiredView(obj, R.id.mticket_trip_info_container, "field '_mTicketTripInfoContainer'");
        mTicketSelectionActivity._passengerDetailsLayoutTitle = (TextView) finder.findRequiredView(obj, R.id.mticket_passenger_details_title, "field '_passengerDetailsLayoutTitle'");
        mTicketSelectionActivity._freeRideCouponContainer = (LinearLayout) finder.findRequiredView(obj, R.id.free_ride_coupon_container, "field '_freeRideCouponContainer'");
        mTicketSelectionActivity._tvTermsConditions = (TextView) finder.findRequiredView(obj, R.id.tv_terms_conditions, "field '_tvTermsConditions'");
        mTicketSelectionActivity._collapseRouteDetailsButton = (ImageView) finder.findRequiredView(obj, R.id.collapse_button, "field '_collapseRouteDetailsButton'");
        mTicketSelectionActivity._routeStopDetailsLayout = (ConstraintLayout) finder.findRequiredView(obj, R.id.stop_details_layout, "field '_routeStopDetailsLayout'");
    }

    public static void reset(MTicketSelectionActivity mTicketSelectionActivity) {
        mTicketSelectionActivity._btnBookMTicket = null;
        mTicketSelectionActivity.partnerText = null;
        mTicketSelectionActivity.agencyText = null;
        mTicketSelectionActivity._fareBreakUpContainer = null;
        mTicketSelectionActivity._passengerDetailsLayout = null;
        mTicketSelectionActivity._mTicketPassengerDetails = null;
        mTicketSelectionActivity._mTicketTripInfoContainer = null;
        mTicketSelectionActivity._passengerDetailsLayoutTitle = null;
        mTicketSelectionActivity._freeRideCouponContainer = null;
        mTicketSelectionActivity._tvTermsConditions = null;
        mTicketSelectionActivity._collapseRouteDetailsButton = null;
        mTicketSelectionActivity._routeStopDetailsLayout = null;
    }
}
