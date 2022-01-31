package app.zophop.scanPay;

import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import app.zophop.R;
import app.zophop.models.ScanPayTicket;
import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;
import app.zophop.pubsub.eventbus.events.BookingTransactionEvent;
import app.zophop.pubsub.eventbus.events.RazorPayOrderData;
import app.zophop.ui.activities.CheckoutActivity;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.razorpay.AnalyticsConstants;
import defpackage.xt;
import java.util.ArrayList;

public class ScanPayPaymentActivity extends au {
    public static final /* synthetic */ int s = 0;
    @InjectView(R.id.amount_value)
    public EditText _amountValEditText;
    @InjectView(R.id.discount_fare)
    public TextView _discountAmount;
    @InjectView(R.id.discount_section)
    public LinearLayout _discountSection;
    @InjectView(R.id.final_fare)
    public TextView _finalFare;
    @InjectView(R.id.announcement)
    public TextView _offerAnnouncement;
    @InjectView(R.id.pay_btn)
    public TextView _payBtn;
    @InjectView(R.id.terms_layout)
    public TextView _termsLayout;
    public int k = 0;
    public int l = 0;
    public Handler m;
    public ScanPayTicket n;
    public String o;
    public String p;
    public DialogFragment q;
    public String r;

    @Override // defpackage.tf1
    public void e(Bundle bundle) {
        setContentView(R.layout.amount_activity);
        ButterKnife.inject(this);
        jz5 b = jz5.b();
        b.k(this, b.e, false, 0);
        j0("scan pay payment screen open", null);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().o(true);
        getSupportActionBar().y(R.string.title_payment_activity);
        this.o = getIntent().getStringExtra("busNo");
        this.p = getIntent().getStringExtra("agency");
        String stringExtra = getIntent().getStringExtra(FirebaseAnalytics.Param.DISCOUNT);
        this.r = getIntent().getStringExtra("version");
        if (!TextUtils.isEmpty(stringExtra)) {
            if (stringExtra.contains("f")) {
                this.l = Integer.parseInt(stringExtra.substring(0, stringExtra.length() - 1));
                TextView textView = this._offerAnnouncement;
                String string = getString(R.string.announcement);
                textView.setText(String.format(string, ui1.H() + this.l));
            } else {
                this.k = Integer.parseInt(stringExtra);
                this._offerAnnouncement.setText(String.format(getString(R.string.announcement), hj1.X(new StringBuilder(), this.k, "%")));
            }
        }
        this._offerAnnouncement.setVisibility((this.l == 0 && this.k == 0) ? 8 : 0);
        this.m = new u80(this);
        this._amountValEditText.addTextChangedListener(new t80(this));
        this._payBtn.setOnClickListener(new r80(this));
        this._termsLayout.setOnClickListener(new s80(this));
        fv0 fv0 = (fv0) getFragmentManager().findFragmentByTag("loader_tag");
        this.q = fv0;
        if (fv0 == null) {
            fv0 T = vn.T(null, getString(R.string.loading_pass), false, false);
            this.q = T;
            T.setRetainInstance(true);
        }
        if (this._amountValEditText.getText().toString().length() == 0) {
            this._payBtn.setVisibility(8);
        } else {
            this._payBtn.setVisibility(0);
        }
    }

    public final void h0() {
        DialogFragment dialogFragment = this.q;
        if (dialogFragment != null) {
            dialogFragment.dismiss();
        }
    }

    public final float i0(String str) {
        double parseDouble = Double.parseDouble(str);
        int i = this.l;
        if (i != 0) {
            return (float) i;
        }
        int i2 = this.k;
        if (i2 != 0) {
            return (float) (((double) (((float) i2) / 100.0f)) * parseDouble);
        }
        return 0.0f;
    }

    public final void j0(String str, String str2) {
        ed1 ed1 = new ed1(str, Long.MIN_VALUE);
        if (!TextUtils.isEmpty(str2)) {
            ed1.a("source", str2);
        }
        jz5.b().g(ed1);
    }

    public final void k0() {
        if (!this.q.isVisible()) {
            this.q.show(getFragmentManager(), "loader_tag");
        }
    }

    @Override // androidx.activity.ComponentActivity, defpackage.ve
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 123) {
            if (i2 == -1) {
                ScanPayTicket scanPayTicket = this.n;
                xt.t1 t1Var = xt.f3961a;
                scanPayTicket.set_userId(t1Var.L().getUserId());
                k0();
                t1Var.c().p0(this.n, this.r);
                return;
            }
            h0();
        } else if (i == 12345 && i2 == -1) {
            k0();
        }
    }

    @Override // defpackage.tf1
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_scan_pay, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override // defpackage.f0, defpackage.ve, defpackage.au
    public void onDestroy() {
        super.onDestroy();
        jz5.b().o(this);
    }

    public void onEvent(BookingTransactionEvent bookingTransactionEvent) {
        jz5.b().m(bookingTransactionEvent);
        h0();
        ad1 responseType = bookingTransactionEvent.getResponseType();
        ad1 ad1 = ad1.SUCCESS;
        boolean z = true;
        if (responseType.equals(ad1)) {
            ScanPayTicket scanPayTicket = bookingTransactionEvent.getBookingTransaction().get_scanPayTicket();
            this.n = scanPayTicket;
            ed1 ed1 = new ed1("scan pay response received", Long.MIN_VALUE);
            ed1.a("passBookingId", scanPayTicket.get_transactionId());
            ed1.a(SuperPassJsonKeys.FARE, this.n.get_fare() + "");
            ed1.a("startDate", jh1.c(this.n.get_bookingTime()));
            if (bookingTransactionEvent.getResponseType() != ad1) {
                z = false;
            }
            ed1.a("response", String.valueOf(z));
            ed1.a(SuperPassJsonKeys.ORDER_ID, bookingTransactionEvent.getRazorPayOrderData().get_orderId());
            jz5.b().g(ed1);
            RazorPayOrderData razorPayOrderData = bookingTransactionEvent.getRazorPayOrderData();
            Bundle bundle = new Bundle();
            bundle.putString("currency", "INR");
            bundle.putString(AnalyticsConstants.ORDER_ID, razorPayOrderData.get_orderId());
            bundle.putString(AnalyticsConstants.AMOUNT, ((int) razorPayOrderData.get_amount()) + "");
            bundle.putParcelable("scanPayInfo", this.n);
            bundle.putString(AnalyticsConstants.MERCHANT_KEY, razorPayOrderData.getMerchantKey());
            bundle.putParcelableArrayList("card_details", (ArrayList) this.n.get_cardDetails());
            bundle.putBoolean("lpEligible", bookingTransactionEvent.getBookingTransaction().isLpEligible());
            bundle.putString("eligibilityResponseId", bookingTransactionEvent.getBookingTransaction().getLpId());
            Intent intent = new Intent(this, CheckoutActivity.class);
            intent.addFlags(67108864);
            intent.putExtra("src", "Confirm Pass Screen");
            intent.putExtras(bundle);
            startActivityForResult(intent, 12345);
            return;
        }
        h0();
        if (!TextUtils.isEmpty(bookingTransactionEvent.getErrorMessage())) {
            Toast.makeText(this, bookingTransactionEvent.getErrorMessage(), 1).show();
        } else {
            Toast.makeText(this, "something went wrong", 1).show();
        }
        DialogFragment dialogFragment = this.q;
        if (dialogFragment != null && dialogFragment.isVisible()) {
            this.q.dismiss();
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
            return true;
        } else if (menuItem.getItemId() != R.id.menu_scan_pay_info) {
            return false;
        } else {
            new jn0().show(getSupportFragmentManager(), "d");
            j0("scan pay dialog open", "payment screen menu");
            return false;
        }
    }
}
