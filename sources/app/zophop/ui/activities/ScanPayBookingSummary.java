package app.zophop.ui.activities;

import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import app.zophop.R;
import app.zophop.models.ScanPayTicket;
import butterknife.ButterKnife;
import butterknife.InjectView;

public class ScanPayBookingSummary extends wt {
    @InjectView(R.id.actual_price_val_sec)
    public TextView _actualVal;
    @InjectView(R.id.amount_paid_price_val_sec)
    public TextView _amountPaidVal;
    @InjectView(R.id.amount_paid_val)
    public TextView _amountVal;
    @InjectView(R.id.bus_info)
    public TextView _busInfo;
    @InjectView(R.id.discount_price_val_sec)
    public TextView _discountVal;
    @InjectView(R.id.expiryImage)
    public ImageView _expiryImage;
    @InjectView(R.id.payment_date_val_sec)
    public TextView _paymentDate;
    @InjectView(R.id.payment_id_val_sec)
    public TextView _paymentId;
    @InjectView(R.id.passExpiryDetails)
    public TextView _ticketStatus;
    @InjectView(R.id.tv_mticket_validity_banner)
    public TextView _tvValidityBanner;
    public ScanPayTicket l;
    public DialogFragment m;

    public static void h0(Context context, ScanPayTicket scanPayTicket, String str) {
        Intent intent = new Intent(context, ScanPayBookingSummary.class);
        intent.putExtra("scanPayInfo", scanPayTicket);
        intent.putExtra("src", str);
        context.startActivity(intent);
    }

    @Override // defpackage.tf1
    public void e(Bundle bundle) {
        this.l = (ScanPayTicket) getIntent().getParcelableExtra("scanPayInfo");
        setContentView(R.layout.activity_scan_pay_details);
        ButterKnife.inject(this);
        fv0 fv0 = (fv0) getFragmentManager().findFragmentByTag("loader_tag");
        this.m = fv0;
        boolean z = false;
        if (fv0 == null) {
            fv0 T = vn.T(null, getString(R.string.loading), false, false);
            this.m = T;
            T.setRetainInstance(true);
        }
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().o(true);
        getSupportActionBar().y(R.string.title_activity_mticket_details);
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.l.get_status()) && this.l.get_status().equals("FAILED")) {
            this._expiryImage.setImageDrawable(getResources().getDrawable(R.drawable.payment_failed_pass_summary));
            this._ticketStatus.setText(getResources().getString(R.string.failed));
            this._tvValidityBanner.setVisibility(8);
        } else if (!TextUtils.isEmpty(this.l.get_status()) && this.l.get_status().equals("PENDING")) {
            this._expiryImage.setImageDrawable(getResources().getDrawable(R.drawable.pending_pass_summary));
            this._ticketStatus.setText(getResources().getString(R.string.processing));
            this._tvValidityBanner.setVisibility(8);
        } else if (!this.l.isScanPayTicketExpired()) {
            sb.append(getString(R.string.mticket_banner_valid_till));
            sb.append(" ");
            String f = jh1.f(this.l.get_expirationTime());
            this._expiryImage.setImageDrawable(getResources().getDrawable(R.drawable.active_pass_summary));
            sb.append(f.replace(",", "on"));
            this._tvValidityBanner.setText(sb.toString());
            this._ticketStatus.setText(getResources().getString(R.string.ticket_active_status));
        } else {
            sb.append(getString(R.string.mticket_banner_expired_on));
            sb.append(" ");
            this._expiryImage.setImageDrawable(getResources().getDrawable(R.drawable.expired_pass_summary));
            sb.append(jh1.f(this.l.get_expirationTime()).replace(",", "on"));
            this._ticketStatus.setText(getResources().getString(R.string.ticket_expired_status));
            this._tvValidityBanner.setText(sb.toString());
        }
        TextView textView = this._amountVal;
        textView.setText(ui1.H() + this.l.get_discountedFare());
        TextView textView2 = this._busInfo;
        StringBuilder i0 = hj1.i0(" ");
        i0.append(this.l.get_bookingDetails().getBusInfo());
        textView2.append(i0.toString());
        TextView textView3 = this._actualVal;
        textView3.setText(ui1.H() + this.l.get_fare());
        Double valueOf = Double.valueOf(this.l.get_fare() - this.l.get_discountedFare());
        TextView textView4 = this._discountVal;
        textView4.setText(ui1.H() + valueOf);
        TextView textView5 = this._amountPaidVal;
        textView5.setText(ui1.H() + this.l.get_discountedFare());
        this._paymentId.setText(this.l.get_transactionId());
        this._paymentDate.setText(jh1.d(this.l.get_bookingTime()));
        ed1 ed1 = new ed1("scan and pay summary details screen opened", Long.MIN_VALUE);
        if (this.l.get_transactionId() != null) {
            z = true;
        }
        ed1.a("ticketBooked", String.valueOf(z));
        if (getIntent().hasExtra("src")) {
            ed1.a("source", getIntent().getStringExtra("src"));
        }
        jz5.b().g(ed1);
    }

    @Override // defpackage.f0, defpackage.ve, defpackage.au
    public void onStart() {
        super.onStart();
    }

    @Override // defpackage.f0, defpackage.ve, defpackage.au
    public void onStop() {
        super.onStop();
    }
}
