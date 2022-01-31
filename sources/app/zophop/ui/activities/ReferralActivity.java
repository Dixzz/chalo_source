package app.zophop.ui.activities;

import android.app.DialogFragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import app.zophop.R;
import app.zophop.pubsub.eventbus.events.ReferralTrackingFailureEvent;
import app.zophop.pubsub.eventbus.events.ReferralTrackingSuccessEvent;
import java.util.Objects;

public class ReferralActivity extends wt {
    public EditText l;
    public TextView m;
    public DialogFragment n;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            ReferralActivity referralActivity = ReferralActivity.this;
            String upperCase = referralActivity.l.getText().toString().toUpperCase();
            Objects.requireNonNull(referralActivity);
            ed1 ed1 = new ed1("referral button click", Long.MIN_VALUE);
            ed1.a("referralCode", upperCase);
            jz5.b().g(ed1);
            ReferralActivity referralActivity2 = ReferralActivity.this;
            String obj = referralActivity2.l.getText().toString();
            Objects.requireNonNull(referralActivity2);
            if (!TextUtils.isEmpty(obj) && obj.length() == 6) {
                ReferralActivity referralActivity3 = ReferralActivity.this;
                referralActivity3.n.show(referralActivity3.getFragmentManager(), "LOADER");
                ReferralActivity.this.m.setVisibility(8);
                xt.K.getValue().a(xt.f3961a.L().getUserId(), null, ReferralActivity.this.l.getText().toString().toUpperCase());
                return;
            }
            ReferralActivity.this.m.setText(R.string.invalid_referral_code);
            ReferralActivity.this.m.setVisibility(0);
        }
    }

    @Override // defpackage.tf1
    public void e(Bundle bundle) {
        setContentView(R.layout.referral_tracking);
        setSupportActionBar((Toolbar) findViewById(R.id.referral_tracking_toolbar));
        getSupportActionBar().y(R.string.referral_toolbar_title);
        getSupportActionBar().o(true);
        this.l = (EditText) findViewById(R.id.referral_code);
        TextView textView = (TextView) findViewById(R.id.error);
        this.m = textView;
        textView.setVisibility(8);
        this.n = vn.T(null, getString(R.string.loading), false, false);
        ((Button) findViewById(R.id.done)).setOnClickListener(new a());
    }

    public void onEvent(ReferralTrackingSuccessEvent referralTrackingSuccessEvent) {
        jz5.b().m(referralTrackingSuccessEvent);
        String referralCode = referralTrackingSuccessEvent.getReferralCode();
        ed1 ed1 = new ed1("referral successful", Long.MIN_VALUE);
        ed1.a("userId", xt.f3961a.L().getUserId());
        ed1.a("referralCode", referralCode);
        jz5.b().g(ed1);
        DialogFragment dialogFragment = this.n;
        if (dialogFragment != null && dialogFragment.isVisible()) {
            this.n.dismiss();
        }
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(this).edit();
        edit.putBoolean("referral_success", true);
        edit.commit();
        Intent intent = new Intent(this, PassStatusActivity.class);
        intent.putExtra("src", "referralActivity");
        startActivity(intent);
    }

    @Override // defpackage.f0, defpackage.ve, defpackage.au
    public void onStart() {
        super.onStart();
        jz5 b = jz5.b();
        b.k(this, b.e, true, 0);
    }

    @Override // defpackage.f0, defpackage.ve, defpackage.au
    public void onStop() {
        super.onStop();
        jz5.b().o(this);
    }

    public void onEvent(ReferralTrackingFailureEvent referralTrackingFailureEvent) {
        jz5.b().m(referralTrackingFailureEvent);
        DialogFragment dialogFragment = this.n;
        if (dialogFragment != null && dialogFragment.isVisible()) {
            this.n.dismiss();
        }
        String errorMessage = referralTrackingFailureEvent.getErrorMessage();
        String errorCode = referralTrackingFailureEvent.getErrorCode();
        String referralCode = referralTrackingFailureEvent.getReferralCode();
        ed1 ed1 = new ed1("referral failed", Long.MIN_VALUE);
        ed1.a("userId", xt.f3961a.L().getUserId());
        ed1.a("errorCode", errorCode);
        hj1.K0(ed1, "referralCode", referralCode, ed1);
        this.m.setVisibility(0);
        this.m.setText(errorMessage);
    }
}
