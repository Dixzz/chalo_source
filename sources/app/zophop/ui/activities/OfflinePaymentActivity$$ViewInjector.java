package app.zophop.ui.activities;

import android.widget.TextView;
import app.zophop.R;
import butterknife.ButterKnife;

public class OfflinePaymentActivity$$ViewInjector {
    public static void inject(ButterKnife.Finder finder, OfflinePaymentActivity offlinePaymentActivity, Object obj) {
        offlinePaymentActivity._changePaymentMode = (TextView) finder.findRequiredView(obj, R.id.change_payment_mode, "field '_changePaymentMode'");
    }

    public static void reset(OfflinePaymentActivity offlinePaymentActivity) {
        offlinePaymentActivity._changePaymentMode = null;
    }
}
