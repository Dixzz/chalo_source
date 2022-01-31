package app.zophop.ui.activities;

import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import app.zophop.R;
import app.zophop.models.mTicketing.superPass.SuperPassConstants;
import app.zophop.models.mTicketing.superPass.SuperPassSubType;

/* compiled from: SuperPassBookingSuccessActivity.kt */
public final class SuperPassBookingSuccessActivity extends tl0<gw> {
    public static final /* synthetic */ int n = 0;
    public String k;
    public SuperPassSubType l;
    public boolean m = true;

    @Override // defpackage.ol0
    public qo g0() {
        View inflate = getLayoutInflater().inflate(R.layout.activity_super_pass_booking_success, (ViewGroup) null, false);
        int i = R.id.btn_see_booking_details;
        TextView textView = (TextView) inflate.findViewById(R.id.btn_see_booking_details);
        if (textView != null) {
            i = R.id.btn_use_later;
            TextView textView2 = (TextView) inflate.findViewById(R.id.btn_use_later);
            if (textView2 != null) {
                i = R.id.btn_use_pass;
                TextView textView3 = (TextView) inflate.findViewById(R.id.btn_use_pass);
                if (textView3 != null) {
                    i = R.id.toolbar;
                    Toolbar toolbar = (Toolbar) inflate.findViewById(R.id.toolbar);
                    if (toolbar != null) {
                        gw gwVar = new gw((LinearLayout) inflate, textView, textView2, textView3, toolbar);
                        n86.d(gwVar, "inflate(layoutInflater)");
                        return gwVar;
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
        String stringExtra2 = getIntent().getStringExtra("arg_superPassId");
        n86.c(stringExtra2);
        n86.d(stringExtra2, "intent.getStringExtra(ARG_SUPER_PASS_ID)!!");
        n86.e(stringExtra2, "<set-?>");
        this.k = stringExtra2;
        SuperPassSubType.Companion companion = SuperPassSubType.Companion;
        String stringExtra3 = getIntent().getStringExtra("arg_superPassSubType");
        n86.c(stringExtra3);
        n86.d(stringExtra3, "intent.getStringExtra(ARG_SUPER_PASS_SUB_TYPE)!!");
        SuperPassSubType fromString = companion.fromString(stringExtra3);
        n86.e(fromString, "<set-?>");
        this.l = fromString;
        this.m = getIntent().getBooleanExtra("arg_canActivate", true);
        ed1 ed1 = new ed1("booking success screen open", Long.MIN_VALUE);
        s0(ed1);
        ui1.m0(ed1);
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        ed1 ed1 = new ed1("booking success back btn clicked", Long.MIN_VALUE);
        s0(ed1);
        ui1.m0(ed1);
        Intent intent = new Intent(this, HomeActivity.class);
        intent.setFlags(268468224);
        startActivity(intent);
    }

    @Override // defpackage.tl0
    public void p0() {
        ((gw) f0()).b.setOnClickListener(new ja0(this));
        ((gw) f0()).d.setOnClickListener(new ka0(this));
        ((gw) f0()).c.setOnClickListener(new ia0(this));
    }

    @Override // defpackage.tl0
    public void q0() {
    }

    @Override // defpackage.tl0
    public void r0() {
        if (this.m) {
            TextView textView = ((gw) f0()).b;
            n86.d(textView, "viewBinding.btnSeeBookingDetails");
            textView.setVisibility(0);
            ((gw) f0()).d.setText(getResources().getString(R.string.use_ticket));
            ((gw) f0()).c.setText(getResources().getString(R.string.later_caps));
            return;
        }
        TextView textView2 = ((gw) f0()).b;
        n86.d(textView2, "viewBinding.btnSeeBookingDetails");
        textView2.setVisibility(8);
        ((gw) f0()).d.setText(getResources().getString(R.string.see_booking_details_caps));
        ((gw) f0()).c.setText(getResources().getString(R.string.done));
    }

    public final void s0(ed1 ed1) {
        ed1.a("source", "booking success screen");
        ed1.a("isSuperPass", Boolean.TRUE);
        ed1.a("productType", SuperPassConstants.PRODUCT_TYPE_SUPER_PASS);
        ed1.a("productSubType", t0().toString());
    }

    public final SuperPassSubType t0() {
        SuperPassSubType superPassSubType = this.l;
        if (superPassSubType != null) {
            return superPassSubType;
        }
        n86.l("superPassSubType");
        throw null;
    }

    public final void u0() {
        String str = this.k;
        if (str != null) {
            SuperPassSubType t0 = t0();
            n86.e(str, "lSuperPassId");
            n86.e(t0, "lSuperPassSubType");
            n86.e("sourceSuperPassBookingSuccessActivity", "lSource");
            n86.e(this, "lContext");
            Intent intent = new Intent(this, SuperPassBookingSummaryActivity.class);
            intent.putExtra("arg_superPassId", str);
            intent.putExtra("arg_superPassSubType", (Parcelable) t0);
            intent.putExtra("arg_source", "sourceSuperPassBookingSuccessActivity");
            intent.putExtra("arg_startDestination", "startDestinationSummaryScreen");
            startActivity(intent);
            return;
        }
        n86.l("superPassId");
        throw null;
    }
}
