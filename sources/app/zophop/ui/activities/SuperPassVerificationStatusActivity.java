package app.zophop.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import app.zophop.R;
import app.zophop.models.mTicketing.MPassVerificationTimingDetails;
import app.zophop.models.mTicketing.superPass.SuperPassApplication;
import com.google.gson.Gson;

/* compiled from: SuperPassVerificationStatusActivity.kt */
public final class SuperPassVerificationStatusActivity extends tl0<jw> {
    public static final /* synthetic */ int m = 0;
    public String k;
    public SuperPassApplication l;

    public static final void v0(Context context, SuperPassApplication superPassApplication, String str) {
        n86.e(context, "lContext");
        n86.e(str, "lSource");
        if (superPassApplication != null) {
            Intent N0 = hj1.N0(context, SuperPassVerificationStatusActivity.class, "arg_super_pass_application_string", new Gson().toJson(superPassApplication).toString());
            N0.putExtra("arg_source", str);
            context.startActivity(N0);
        }
    }

    @Override // defpackage.ol0
    public qo g0() {
        View inflate = getLayoutInflater().inflate(R.layout.activity_super_pass_verification_status, (ViewGroup) null, false);
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
                                jw jwVar = new jw((LinearLayout) inflate, textView, textView2, scrollView, toolbar, textView3, textView4);
                                n86.d(jwVar, "inflate(layoutInflater)");
                                return jwVar;
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
        Object fromJson = new Gson().fromJson(getIntent().getStringExtra("arg_super_pass_application_string"), SuperPassApplication.class);
        n86.d(fromJson, "Gson().fromJson(lSuperPa…sApplication::class.java)");
        SuperPassApplication superPassApplication = (SuperPassApplication) fromJson;
        n86.e(superPassApplication, "<set-?>");
        this.l = superPassApplication;
        ed1 ed1 = new ed1("mPass verification status activity open", Long.MIN_VALUE);
        ed1.a("source", t0());
        ui1.m0(ed1);
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        ed1 ed1 = new ed1("superPass verification status back btn clicked", Long.MIN_VALUE);
        s0(ed1);
        ui1.m0(ed1);
        if (n86.a(t0(), "sourceSuperPassPurchaseFragment")) {
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
        ((jw) f0()).c.setOnClickListener(new ta0(this));
        ((jw) f0()).b.setOnClickListener(new sa0(this));
    }

    @Override // defpackage.tl0
    public void q0() {
    }

    @Override // defpackage.tl0
    public void r0() {
        Toolbar toolbar = ((jw) f0()).d;
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
            ((jw) f0()).f.setText(C.getVerificationTimeRequired());
        }
        if (C.getVerificationOfficeTimings().length() <= 0) {
            z = false;
        }
        if (z) {
            ((jw) f0()).e.setText(C.getVerificationOfficeTimings());
        }
    }

    public final void s0(ed1 ed1) {
        ed1.a("passengerType", u0().getCategoryId());
        ed1.a("fareMappingId", Integer.valueOf(u0().getFareMappingId()));
        ed1.a("productId", u0().getConfigId());
        ed1.a("productName", u0().getPassName());
        ed1.a("startDate", jh1.c(u0().getPassStartDate()));
        ed1.a("isSuperPass", Boolean.TRUE);
    }

    public final String t0() {
        String str = this.k;
        if (str != null) {
            return str;
        }
        n86.l("source");
        throw null;
    }

    public final SuperPassApplication u0() {
        SuperPassApplication superPassApplication = this.l;
        if (superPassApplication != null) {
            return superPassApplication;
        }
        n86.l("superPassApplication");
        throw null;
    }
}
