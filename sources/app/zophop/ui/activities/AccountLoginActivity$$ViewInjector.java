package app.zophop.ui.activities;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import app.zophop.R;
import butterknife.ButterKnife;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class AccountLoginActivity$$ViewInjector {
    public static void inject(ButterKnife.Finder finder, AccountLoginActivity accountLoginActivity, Object obj) {
        accountLoginActivity._mobileTextInput = (EditText) finder.findRequiredView(obj, R.id.mobile_no, "field '_mobileTextInput'");
        accountLoginActivity._continue = (Button) finder.findRequiredView(obj, R.id.login_continue, "field '_continue'");
        accountLoginActivity._verifyLogin = (Button) finder.findRequiredView(obj, R.id.verify_login, "field '_verifyLogin'");
        accountLoginActivity._otpVerification = (TextInputEditText) finder.findRequiredView(obj, R.id.otp_verification, "field '_otpVerification'");
        accountLoginActivity._otpLayout = (TextInputLayout) finder.findRequiredView(obj, R.id.otp_layout, "field '_otpLayout'");
        accountLoginActivity._toolbar = (Toolbar) finder.findRequiredView(obj, R.id.toolbar, "field '_toolbar'");
        accountLoginActivity._resendSmsView = (TextView) finder.findRequiredView(obj, R.id.resend_sms, "field '_resendSmsView'");
        accountLoginActivity._errorView = (TextView) finder.findRequiredView(obj, R.id.error, "field '_errorView'");
        accountLoginActivity._loginTruecallerScrollview = (ScrollView) finder.findRequiredView(obj, R.id.login_truecaller_scrollview, "field '_loginTruecallerScrollview'");
    }

    public static void reset(AccountLoginActivity accountLoginActivity) {
        accountLoginActivity._mobileTextInput = null;
        accountLoginActivity._continue = null;
        accountLoginActivity._verifyLogin = null;
        accountLoginActivity._otpVerification = null;
        accountLoginActivity._otpLayout = null;
        accountLoginActivity._toolbar = null;
        accountLoginActivity._resendSmsView = null;
        accountLoginActivity._errorView = null;
        accountLoginActivity._loginTruecallerScrollview = null;
    }
}
