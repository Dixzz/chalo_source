package app.zophop.ui.activities;

import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import app.zophop.R;
import butterknife.ButterKnife;

public class MTicketTripInfoActivity$$ViewInjector {
    public static void inject(ButterKnife.Finder finder, MTicketTripInfoActivity mTicketTripInfoActivity, Object obj) {
        mTicketTripInfoActivity._routeInfoLayout = finder.findRequiredView(obj, R.id.route_number, "field '_routeInfoLayout'");
        mTicketTripInfoActivity._fromStationLayout = finder.findRequiredView(obj, R.id.from_station, "field '_fromStationLayout'");
        mTicketTripInfoActivity._toStationLayout = finder.findRequiredView(obj, R.id.to_station, "field '_toStationLayout'");
        mTicketTripInfoActivity._paymentButton = (Button) finder.findRequiredView(obj, R.id.btn_mticket_pay, "field '_paymentButton'");
        mTicketTripInfoActivity.partnerText = (TextView) finder.findRequiredView(obj, R.id.partner_text_id, "field 'partnerText'");
        mTicketTripInfoActivity.agencyText = (TextView) finder.findRequiredView(obj, R.id.agency_text_id, "field 'agencyText'");
        mTicketTripInfoActivity._mTicketTripInfoContainer = (RelativeLayout) finder.findRequiredView(obj, R.id.mticket_trip_info_container, "field '_mTicketTripInfoContainer'");
        mTicketTripInfoActivity._tvFreeRideInfoBanner = (TextView) finder.findRequiredView(obj, R.id.free_ride_info_banner, "field '_tvFreeRideInfoBanner'");
        LinearLayout linearLayout = (LinearLayout) finder.findRequiredView(obj, R.id.recent_booking_container, "field '_recentBookingContainer'");
    }

    public static void reset(MTicketTripInfoActivity mTicketTripInfoActivity) {
        mTicketTripInfoActivity._routeInfoLayout = null;
        mTicketTripInfoActivity._fromStationLayout = null;
        mTicketTripInfoActivity._toStationLayout = null;
        mTicketTripInfoActivity._paymentButton = null;
        mTicketTripInfoActivity.partnerText = null;
        mTicketTripInfoActivity.agencyText = null;
        mTicketTripInfoActivity._mTicketTripInfoContainer = null;
        mTicketTripInfoActivity._tvFreeRideInfoBanner = null;
    }
}
