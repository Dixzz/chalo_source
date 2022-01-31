package app.zophop.ui.activities;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import app.zophop.LockingScrollView;
import app.zophop.R;
import butterknife.ButterKnife;
import java.util.Objects;

public class ActiveMTicketScreen$$ViewInjector {
    public static void inject(ButterKnife.Finder finder, ActiveMTicketScreen activeMTicketScreen, Object obj) {
        TextView textView = (TextView) finder.findRequiredView(obj, R.id.edit_route_stop_details_mticket, "field '_tvEditRouteStopDetails'");
        Objects.requireNonNull(activeMTicketScreen);
        TextView textView2 = (TextView) finder.findRequiredView(obj, R.id.edit_booking_details_mticket, "field '_tvEditBookingDetails'");
        TextView textView3 = (TextView) finder.findRequiredView(obj, R.id.tv_passenger_total_fare, "field '_tvPassengerTotalFare'");
        activeMTicketScreen._qrCodeImageView = (ImageView) finder.findRequiredView(obj, R.id.mticket_qr_code, "field '_qrCodeImageView'");
        LockingScrollView lockingScrollView = (LockingScrollView) finder.findRequiredView(obj, R.id.main_layout, "field '_mainLayout'");
        activeMTicketScreen._btnTapQrCode = (TextView) finder.findRequiredView(obj, R.id.btn_tap_qr_code, "field '_btnTapQrCode'");
        LinearLayout linearLayout = (LinearLayout) finder.findRequiredView(obj, R.id.visible_content, "field '_visibleContent'");
        finder.findRequiredView(obj, R.id.margin_placeholder, "field '_marginPlaceholder'");
        activeMTicketScreen._partnerId = (TextView) finder.findRequiredView(obj, R.id.partner_text_id, "field '_partnerId'");
        activeMTicketScreen._agencyId = (TextView) finder.findRequiredView(obj, R.id.agency_text_id, "field '_agencyId'");
    }

    public static void reset(ActiveMTicketScreen activeMTicketScreen) {
        Objects.requireNonNull(activeMTicketScreen);
        activeMTicketScreen._qrCodeImageView = null;
        activeMTicketScreen._btnTapQrCode = null;
        activeMTicketScreen._partnerId = null;
        activeMTicketScreen._agencyId = null;
    }
}
