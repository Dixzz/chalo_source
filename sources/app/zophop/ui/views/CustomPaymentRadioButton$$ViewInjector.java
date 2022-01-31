package app.zophop.ui.views;

import android.widget.RadioButton;
import android.widget.TextView;
import app.zophop.R;
import butterknife.ButterKnife;

public class CustomPaymentRadioButton$$ViewInjector {
    public static void inject(ButterKnife.Finder finder, CustomPaymentRadioButton customPaymentRadioButton, Object obj) {
        customPaymentRadioButton._radioButton = (RadioButton) finder.findRequiredView(obj, R.id.pass_radio_button, "field '_radioButton'");
        customPaymentRadioButton._paymentType = (TextView) finder.findRequiredView(obj, R.id.payment_type, "field '_paymentType'");
        customPaymentRadioButton._paymentDescription = (TextView) finder.findRequiredView(obj, R.id.payment_description, "field '_paymentDescription'");
    }

    public static void reset(CustomPaymentRadioButton customPaymentRadioButton) {
        customPaymentRadioButton._radioButton = null;
        customPaymentRadioButton._paymentType = null;
        customPaymentRadioButton._paymentDescription = null;
    }
}
