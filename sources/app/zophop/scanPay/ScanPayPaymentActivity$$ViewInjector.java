package app.zophop.scanPay;

import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import app.zophop.R;
import butterknife.ButterKnife;

public class ScanPayPaymentActivity$$ViewInjector {
    public static void inject(ButterKnife.Finder finder, ScanPayPaymentActivity scanPayPaymentActivity, Object obj) {
        scanPayPaymentActivity._amountValEditText = (EditText) finder.findRequiredView(obj, R.id.amount_value, "field '_amountValEditText'");
        scanPayPaymentActivity._discountSection = (LinearLayout) finder.findRequiredView(obj, R.id.discount_section, "field '_discountSection'");
        scanPayPaymentActivity._discountAmount = (TextView) finder.findRequiredView(obj, R.id.discount_fare, "field '_discountAmount'");
        scanPayPaymentActivity._finalFare = (TextView) finder.findRequiredView(obj, R.id.final_fare, "field '_finalFare'");
        scanPayPaymentActivity._payBtn = (TextView) finder.findRequiredView(obj, R.id.pay_btn, "field '_payBtn'");
        scanPayPaymentActivity._termsLayout = (TextView) finder.findRequiredView(obj, R.id.terms_layout, "field '_termsLayout'");
        scanPayPaymentActivity._offerAnnouncement = (TextView) finder.findRequiredView(obj, R.id.announcement, "field '_offerAnnouncement'");
    }

    public static void reset(ScanPayPaymentActivity scanPayPaymentActivity) {
        scanPayPaymentActivity._amountValEditText = null;
        scanPayPaymentActivity._discountSection = null;
        scanPayPaymentActivity._discountAmount = null;
        scanPayPaymentActivity._finalFare = null;
        scanPayPaymentActivity._payBtn = null;
        scanPayPaymentActivity._termsLayout = null;
        scanPayPaymentActivity._offerAnnouncement = null;
    }
}
