package app.zophop.ui.activities;

import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import app.zophop.R;
import butterknife.ButterKnife;

public class MTicketBookingSummary$$ViewInjector {
    public static void inject(ButterKnife.Finder finder, MTicketBookingSummary mTicketBookingSummary, Object obj) {
        mTicketBookingSummary._tvValidityBanner = (TextView) finder.findRequiredView(obj, R.id.tv_mticket_validity_banner, "field '_tvValidityBanner'");
        mTicketBookingSummary._bookAgainBtn = (CardView) finder.findRequiredView(obj, R.id.add_info_btn, "field '_bookAgainBtn'");
        mTicketBookingSummary._btnBookMTicket = (TextView) finder.findRequiredView(obj, R.id.btn_mticket_book_again, "field '_btnBookMTicket'");
        mTicketBookingSummary._btnViewTripReceipt = (CardView) finder.findRequiredView(obj, R.id.btn_view_mticket_trip_receipt, "field '_btnViewTripReceipt'");
        mTicketBookingSummary._tvPassengerTotalFare = (TextView) finder.findRequiredView(obj, R.id.tv_passenger_total_fare, "field '_tvPassengerTotalFare'");
        mTicketBookingSummary._tvBookingId = (TextView) finder.findRequiredView(obj, R.id.tv_booking_id, "field '_tvBookingId'");
        mTicketBookingSummary._passBookingDate = (TextView) finder.findRequiredView(obj, R.id.passBookingDate, "field '_passBookingDate'");
        mTicketBookingSummary._expiryImage = (ImageView) finder.findRequiredView(obj, R.id.expiryImage, "field '_expiryImage'");
        mTicketBookingSummary._ticketStatus = (TextView) finder.findRequiredView(obj, R.id.passExpiryDetails, "field '_ticketStatus'");
    }

    public static void reset(MTicketBookingSummary mTicketBookingSummary) {
        mTicketBookingSummary._tvValidityBanner = null;
        mTicketBookingSummary._bookAgainBtn = null;
        mTicketBookingSummary._btnBookMTicket = null;
        mTicketBookingSummary._btnViewTripReceipt = null;
        mTicketBookingSummary._tvPassengerTotalFare = null;
        mTicketBookingSummary._tvBookingId = null;
        mTicketBookingSummary._passBookingDate = null;
        mTicketBookingSummary._expiryImage = null;
        mTicketBookingSummary._ticketStatus = null;
    }
}
