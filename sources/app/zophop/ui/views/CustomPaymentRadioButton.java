package app.zophop.ui.views;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import app.zophop.R;
import butterknife.InjectView;

public class CustomPaymentRadioButton extends RelativeLayout implements View.OnClickListener {
    @InjectView(R.id.payment_description)
    public TextView _paymentDescription;
    @InjectView(R.id.payment_type)
    public TextView _paymentType;
    @InjectView(R.id.pass_radio_button)
    public RadioButton _radioButton;

    public String getPaymentDescription() {
        return this._paymentDescription.getText().toString();
    }

    public String getPaymentTitle() {
        return this._paymentType.getText().toString();
    }

    public void onClick(View view) {
        if (!this._radioButton.isChecked()) {
            LinearLayout linearLayout = (LinearLayout) getParent();
            if (linearLayout != null) {
                int childCount = linearLayout.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    if (linearLayout.getChildAt(i).findViewById(R.id.pass_radio_button) instanceof RadioButton) {
                        ((RadioButton) linearLayout.getChildAt(i).findViewById(R.id.pass_radio_button)).setChecked(false);
                    }
                }
            }
            setChecked(true);
        }
    }

    public void setChecked(boolean z) {
        this._radioButton.setChecked(z);
    }
}
