package app.zophop.ui.activities;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import app.zophop.R;
import butterknife.ButterKnife;

public class BookingSummaryMagicPassActivity$$ViewInjector {
    public static void inject(ButterKnife.Finder finder, BookingSummaryMagicPassActivity bookingSummaryMagicPassActivity, Object obj) {
        bookingSummaryMagicPassActivity._progressBar = (ProgressBar) finder.findRequiredView(obj, R.id.profile_pic_progressbar, "field '_progressBar'");
        bookingSummaryMagicPassActivity._profilePicView = (ImageView) finder.findRequiredView(obj, R.id.userProfilePic, "field '_profilePicView'");
        bookingSummaryMagicPassActivity._passTypeView = (TextView) finder.findRequiredView(obj, R.id.pass_type, "field '_passTypeView'");
        bookingSummaryMagicPassActivity._maxRidePrice = (TextView) finder.findRequiredView(obj, R.id.max_ride_price, "field '_maxRidePrice'");
        bookingSummaryMagicPassActivity._passExpiryDetails = (TextView) finder.findRequiredView(obj, R.id.passExpiryDetails, "field '_passExpiryDetails'");
        bookingSummaryMagicPassActivity._passBookingDate = (TextView) finder.findRequiredView(obj, R.id.passBookingDate, "field '_passBookingDate'");
        bookingSummaryMagicPassActivity._passFare = (TextView) finder.findRequiredView(obj, R.id.passFare, "field '_passFare'");
        bookingSummaryMagicPassActivity._passUserName = (TextView) finder.findRequiredView(obj, R.id.user_name, "field '_passUserName'");
        bookingSummaryMagicPassActivity._userDetails = (TextView) finder.findRequiredView(obj, R.id.user_details, "field '_userDetails'");
        bookingSummaryMagicPassActivity._dobView = (TextView) finder.findRequiredView(obj, R.id.dob, "field '_dobView'");
        bookingSummaryMagicPassActivity._bookingIdView = (TextView) finder.findRequiredView(obj, R.id.passBookingId, "field '_bookingIdView'");
        bookingSummaryMagicPassActivity._passBookingDetails = (TextView) finder.findRequiredView(obj, R.id.passBookingDetails, "field '_passBookingDetails'");
        bookingSummaryMagicPassActivity._durationDetails = (TextView) finder.findRequiredView(obj, R.id.durationDetails, "field '_durationDetails'");
        bookingSummaryMagicPassActivity._routeContainer = (LinearLayout) finder.findRequiredView(obj, R.id.route_container, "field '_routeContainer'");
        bookingSummaryMagicPassActivity._routeCardView = (CardView) finder.findRequiredView(obj, R.id.route_card_view, "field '_routeCardView'");
    }

    public static void reset(BookingSummaryMagicPassActivity bookingSummaryMagicPassActivity) {
        bookingSummaryMagicPassActivity._progressBar = null;
        bookingSummaryMagicPassActivity._profilePicView = null;
        bookingSummaryMagicPassActivity._passTypeView = null;
        bookingSummaryMagicPassActivity._maxRidePrice = null;
        bookingSummaryMagicPassActivity._passExpiryDetails = null;
        bookingSummaryMagicPassActivity._passBookingDate = null;
        bookingSummaryMagicPassActivity._passFare = null;
        bookingSummaryMagicPassActivity._passUserName = null;
        bookingSummaryMagicPassActivity._userDetails = null;
        bookingSummaryMagicPassActivity._dobView = null;
        bookingSummaryMagicPassActivity._bookingIdView = null;
        bookingSummaryMagicPassActivity._passBookingDetails = null;
        bookingSummaryMagicPassActivity._durationDetails = null;
        bookingSummaryMagicPassActivity._routeContainer = null;
        bookingSummaryMagicPassActivity._routeCardView = null;
    }
}
