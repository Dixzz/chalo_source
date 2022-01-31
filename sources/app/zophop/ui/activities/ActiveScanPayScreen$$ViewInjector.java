package app.zophop.ui.activities;

import android.widget.ImageView;
import android.widget.TextView;
import app.zophop.R;
import butterknife.ButterKnife;

public class ActiveScanPayScreen$$ViewInjector {
    public static void inject(ButterKnife.Finder finder, ActiveScanPayScreen activeScanPayScreen, Object obj) {
        activeScanPayScreen._qrCodeImageView = (ImageView) finder.findRequiredView(obj, R.id.scan_pay_qr_code, "field '_qrCodeImageView'");
        activeScanPayScreen._btnTapQrCode = (TextView) finder.findRequiredView(obj, R.id.btn_tap_qr_code, "field '_btnTapQrCode'");
        activeScanPayScreen._actualFare = (TextView) finder.findRequiredView(obj, R.id.actual_fare_val, "field '_actualFare'");
        activeScanPayScreen._amountPaid = (TextView) finder.findRequiredView(obj, R.id.amount_paid_val, "field '_amountPaid'");
        activeScanPayScreen._busInfo = (TextView) finder.findRequiredView(obj, R.id.bus_info, "field '_busInfo'");
        activeScanPayScreen._validity = (TextView) finder.findRequiredView(obj, R.id.validity, "field '_validity'");
        activeScanPayScreen._bookingId = (TextView) finder.findRequiredView(obj, R.id.tv_booking_id, "field '_bookingId'");
    }

    public static void reset(ActiveScanPayScreen activeScanPayScreen) {
        activeScanPayScreen._qrCodeImageView = null;
        activeScanPayScreen._btnTapQrCode = null;
        activeScanPayScreen._actualFare = null;
        activeScanPayScreen._amountPaid = null;
        activeScanPayScreen._busInfo = null;
        activeScanPayScreen._validity = null;
        activeScanPayScreen._bookingId = null;
    }
}
