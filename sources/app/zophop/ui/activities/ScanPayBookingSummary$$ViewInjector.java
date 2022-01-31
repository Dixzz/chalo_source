package app.zophop.ui.activities;

import android.widget.ImageView;
import android.widget.TextView;
import app.zophop.R;
import butterknife.ButterKnife;

public class ScanPayBookingSummary$$ViewInjector {
    public static void inject(ButterKnife.Finder finder, ScanPayBookingSummary scanPayBookingSummary, Object obj) {
        scanPayBookingSummary._tvValidityBanner = (TextView) finder.findRequiredView(obj, R.id.tv_mticket_validity_banner, "field '_tvValidityBanner'");
        scanPayBookingSummary._amountVal = (TextView) finder.findRequiredView(obj, R.id.amount_paid_val, "field '_amountVal'");
        scanPayBookingSummary._busInfo = (TextView) finder.findRequiredView(obj, R.id.bus_info, "field '_busInfo'");
        scanPayBookingSummary._actualVal = (TextView) finder.findRequiredView(obj, R.id.actual_price_val_sec, "field '_actualVal'");
        scanPayBookingSummary._discountVal = (TextView) finder.findRequiredView(obj, R.id.discount_price_val_sec, "field '_discountVal'");
        scanPayBookingSummary._amountPaidVal = (TextView) finder.findRequiredView(obj, R.id.amount_paid_price_val_sec, "field '_amountPaidVal'");
        scanPayBookingSummary._paymentId = (TextView) finder.findRequiredView(obj, R.id.payment_id_val_sec, "field '_paymentId'");
        TextView textView = (TextView) finder.findRequiredView(obj, R.id.payment_mode_val_sec, "field '_paymentMode'");
        scanPayBookingSummary._paymentDate = (TextView) finder.findRequiredView(obj, R.id.payment_date_val_sec, "field '_paymentDate'");
        scanPayBookingSummary._expiryImage = (ImageView) finder.findRequiredView(obj, R.id.expiryImage, "field '_expiryImage'");
        scanPayBookingSummary._ticketStatus = (TextView) finder.findRequiredView(obj, R.id.passExpiryDetails, "field '_ticketStatus'");
    }

    public static void reset(ScanPayBookingSummary scanPayBookingSummary) {
        scanPayBookingSummary._tvValidityBanner = null;
        scanPayBookingSummary._amountVal = null;
        scanPayBookingSummary._busInfo = null;
        scanPayBookingSummary._actualVal = null;
        scanPayBookingSummary._discountVal = null;
        scanPayBookingSummary._amountPaidVal = null;
        scanPayBookingSummary._paymentId = null;
        scanPayBookingSummary._paymentDate = null;
        scanPayBookingSummary._expiryImage = null;
        scanPayBookingSummary._ticketStatus = null;
    }
}
