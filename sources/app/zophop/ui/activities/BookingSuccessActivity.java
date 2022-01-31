package app.zophop.ui.activities;

import android.content.Intent;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import app.zophop.R;

public class BookingSuccessActivity extends fe0 {
    public static final /* synthetic */ int t = 0;
    public TextView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public TextView q;
    public TextView r;
    public TextView s;

    @Override // defpackage.fe0
    public void init() {
        i0();
    }

    @Override // defpackage.fe0
    public void j0() {
        setContentView(R.layout.payment_success_dialog);
        this.m = (TextView) findViewById(R.id.use_ticket);
        this.n = (TextView) findViewById(R.id.use_later);
        this.o = (TextView) findViewById(R.id.see_booking_details);
        this.p = (TextView) findViewById(R.id.activate_tkt_title);
        this.q = (TextView) findViewById(R.id.conductor_verification_title);
        this.r = (TextView) findViewById(R.id.activate_tkt_desc);
        this.s = (TextView) findViewById(R.id.conductor_verification_desc);
        if (ui1.B0()) {
            this.p.setText(R.string.booking_succ_activate_tkt_title);
            this.q.setText(R.string.booking_succ_conductor_verif_title);
            this.r.setText(getResources().getString(R.string.booking_succ_activate_tkt_desc));
            this.s.setText(getResources().getString(R.string.booking_succ_conductor_verif_desc));
        }
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().o(true);
        getSupportActionBar().t(R.drawable.ic_arrow_back_black_24dp);
        getSupportActionBar().z("");
        this.m.setOnClickListener(new pc0(this));
        this.n.setOnClickListener(new oc0(this));
        this.o.setOnClickListener(new nc0(this));
        k0("booking success screen open");
    }

    public final void k0(String str) {
        jz5.b().g(hj1.l(str, Long.MIN_VALUE, "source", "booking success screen"));
    }

    @Override // androidx.activity.ComponentActivity, defpackage.wt
    public void onBackPressed() {
        if (!xt.f3961a.G().d(getFragmentManager(), "transactionCompleteScreen", BookingSuccessActivity.class.getSimpleName())) {
            super.onBackPressed();
            k0("booking success back pressed");
            Intent intent = new Intent(this, HomeActivity.class);
            intent.setFlags(268468224);
            startActivity(intent);
        }
    }

    @Override // defpackage.wt
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    @Override // defpackage.ve, defpackage.au, defpackage.tf1
    public void onPause() {
        xt.f3961a.G().n();
        super.onPause();
    }

    @Override // defpackage.ve, defpackage.au, defpackage.tf1
    public void onResume() {
        super.onResume();
        xt.f3961a.G().h("transactionCompleteScreen", getFragmentManager(), BookingSuccessActivity.class.getSimpleName());
    }

    public void onUserInteraction() {
        super.onUserInteraction();
        xt.f3961a.G().k();
    }
}
