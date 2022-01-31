package app.zophop.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import app.zophop.R;
import app.zophop.models.mTicketing.MPass;
import app.zophop.models.mTicketing.MPassVerificationTimingDetails;
import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;

/* compiled from: MPassVerificationStatusActivity.kt */
public final class MPassVerificationStatusActivity extends tl0<aw> {
    public static final /* synthetic */ int m = 0;
    public String k;
    public MPass l;

    public static final void v0(Context context, MPass mPass, String str) {
        n86.e(context, "lContext");
        n86.e(mPass, "lMPass");
        n86.e(str, "lSource");
        Intent intent = new Intent(context, MPassVerificationStatusActivity.class);
        intent.putExtra("mPass_info", mPass);
        intent.putExtra("arg_source", str);
        context.startActivity(intent);
    }

    @Override // defpackage.ol0
    public qo g0() {
        View inflate = getLayoutInflater().inflate(R.layout.activity_mpass_verification_status, (ViewGroup) null, false);
        int i = R.id.btn_details;
        TextView textView = (TextView) inflate.findViewById(R.id.btn_details);
        if (textView != null) {
            i = R.id.btn_ok;
            TextView textView2 = (TextView) inflate.findViewById(R.id.btn_ok);
            if (textView2 != null) {
                i = R.id.main_layout;
                ScrollView scrollView = (ScrollView) inflate.findViewById(R.id.main_layout);
                if (scrollView != null) {
                    i = R.id.toolbar;
                    Toolbar toolbar = (Toolbar) inflate.findViewById(R.id.toolbar);
                    if (toolbar != null) {
                        i = R.id.verification_office_timings;
                        TextView textView3 = (TextView) inflate.findViewById(R.id.verification_office_timings);
                        if (textView3 != null) {
                            i = R.id.verification_time_required;
                            TextView textView4 = (TextView) inflate.findViewById(R.id.verification_time_required);
                            if (textView4 != null) {
                                aw awVar = new aw((LinearLayout) inflate, textView, textView2, scrollView, toolbar, textView3, textView4);
                                n86.d(awVar, "inflate(layoutInflater)");
                                return awVar;
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // defpackage.ol0
    public void i0() {
    }

    @Override // defpackage.ol0
    public void m0() {
    }

    @Override // defpackage.tl0
    public void o0() {
        String stringExtra = getIntent().getStringExtra("arg_source");
        n86.c(stringExtra);
        n86.d(stringExtra, "intent.getStringExtra(ARG_SOURCE)!!");
        n86.e(stringExtra, "<set-?>");
        this.k = stringExtra;
        Parcelable parcelableExtra = getIntent().getParcelableExtra("mPass_info");
        n86.c(parcelableExtra);
        n86.d(parcelableExtra, "intent.getParcelableExtra(ARG_MPASS_INFO)!!");
        MPass mPass = (MPass) parcelableExtra;
        n86.e(mPass, "<set-?>");
        this.l = mPass;
        ed1 ed1 = new ed1("mPass verification status activity open", Long.MIN_VALUE);
        ed1.a("source", u0());
        ui1.m0(ed1);
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        if (n86.a(u0(), "sourceMPassPurchaseActivity")) {
            Intent intent = new Intent(this, HomeActivity.class);
            intent.setFlags(268468224);
            startActivity(intent);
            return;
        }
        super.onBackPressed();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        n86.e(menuItem, "item");
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    @Override // defpackage.tl0
    public void p0() {
        ((aw) f0()).c.setOnClickListener(new y90(this));
        ((aw) f0()).b.setOnClickListener(new x90(this));
    }

    @Override // defpackage.tl0
    public void q0() {
    }

    @Override // defpackage.tl0
    public void r0() {
        Toolbar toolbar = ((aw) f0()).d;
        n86.d(toolbar, "viewBinding.toolbar");
        setSupportActionBar(toolbar);
        x supportActionBar = getSupportActionBar();
        boolean z = true;
        if (supportActionBar != null) {
            supportActionBar.o(true);
        }
        x supportActionBar2 = getSupportActionBar();
        if (supportActionBar2 != null) {
            supportActionBar2.t(R.drawable.ic_arrow_back_black_24dp);
        }
        x supportActionBar3 = getSupportActionBar();
        if (supportActionBar3 != null) {
            supportActionBar3.z(new String());
        }
        MPassVerificationTimingDetails C = ui1.C();
        if (C.getVerificationOfficeTimings().length() > 0) {
            ((aw) f0()).f.setText(C.getVerificationTimeRequired());
        }
        if (C.getVerificationOfficeTimings().length() <= 0) {
            z = false;
        }
        if (z) {
            ((aw) f0()).e.setText(C.getVerificationOfficeTimings());
        }
    }

    public final void s0(ed1 ed1) {
        ed1.a("passengerType", t0().getPassengerType());
        ed1.a(SuperPassJsonKeys.FARE, String.valueOf(t0().getFare()));
        ed1.a("noOfDays", String.valueOf(t0().getNoOfDays()));
        ed1.a("startDate", jh1.c(t0().getStartingTime()));
    }

    public final MPass t0() {
        MPass mPass = this.l;
        if (mPass != null) {
            return mPass;
        }
        n86.l("mPass");
        throw null;
    }

    public final String u0() {
        String str = this.k;
        if (str != null) {
            return str;
        }
        n86.l("source");
        throw null;
    }
}
