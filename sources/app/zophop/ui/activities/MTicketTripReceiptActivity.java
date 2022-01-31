package app.zophop.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import app.zophop.R;
import app.zophop.models.City;
import app.zophop.models.mTicketing.MTicket;
import app.zophop.models.mTicketing.MTicketPassengerInfo;
import app.zophop.models.mTicketing.MTicketTripReceipt;
import app.zophop.models.mTicketing.UserProfile;
import com.google.android.material.textview.MaterialTextView;
import defpackage.xt;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: MTicketTripReceiptActivity.kt */
public final class MTicketTripReceiptActivity extends tl0<bw> {
    public static final /* synthetic */ int l = 0;
    public t81 k;

    /* compiled from: ActivityViewModelLazy.kt */
    public static final class a extends o86 implements h76<gi> {
        public final /* synthetic */ ComponentActivity f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ComponentActivity componentActivity) {
            super(0);
            this.f = componentActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public gi invoke() {
            gi viewModelStore = this.f.getViewModelStore();
            n86.d(viewModelStore, "viewModelStore");
            return viewModelStore;
        }
    }

    /* compiled from: MTicketTripReceiptActivity.kt */
    public static final class b extends o86 implements h76<ci> {
        public final /* synthetic */ MTicketTripReceiptActivity f;
        public final /* synthetic */ String g;
        public final /* synthetic */ MTicket h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(MTicketTripReceiptActivity mTicketTripReceiptActivity, String str, MTicket mTicket) {
            super(0);
            this.f = mTicketTripReceiptActivity;
            this.g = str;
            this.h = mTicket;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public ci invoke() {
            return new xh(this.f.getApplication(), this.f, h.j(new m56("keySource", this.g), new m56("keyMTicket", this.h)));
        }
    }

    public static final void t0(String str, MTicket mTicket, Context context) {
        n86.e(str, "lSource");
        n86.e(mTicket, "lMTicket");
        n86.e(context, "lContext");
        Intent intent = new Intent(context, MTicketTripReceiptActivity.class);
        intent.putExtra("arg_source", str);
        intent.putExtra("arg_mTicket", mTicket);
        context.startActivity(intent);
    }

    @Override // defpackage.ol0
    public qo g0() {
        View inflate = getLayoutInflater().inflate(R.layout.activity_mticket_trip_receipt, (ViewGroup) null, false);
        int i = R.id.conductor_id;
        MaterialTextView materialTextView = (MaterialTextView) inflate.findViewById(R.id.conductor_id);
        if (materialTextView != null) {
            i = R.id.conductor_id_title;
            MaterialTextView materialTextView2 = (MaterialTextView) inflate.findViewById(R.id.conductor_id_title);
            if (materialTextView2 != null) {
                i = R.id.conductor_info_layout;
                LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.conductor_info_layout);
                if (linearLayout != null) {
                    i = R.id.info_not_available_layout;
                    LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.info_not_available_layout);
                    if (linearLayout2 != null) {
                        i = R.id.main_layout;
                        ScrollView scrollView = (ScrollView) inflate.findViewById(R.id.main_layout);
                        if (scrollView != null) {
                            i = R.id.ticket_count;
                            MaterialTextView materialTextView3 = (MaterialTextView) inflate.findViewById(R.id.ticket_count);
                            if (materialTextView3 != null) {
                                i = R.id.ticket_count_layout;
                                LinearLayout linearLayout3 = (LinearLayout) inflate.findViewById(R.id.ticket_count_layout);
                                if (linearLayout3 != null) {
                                    i = R.id.ticket_count_title;
                                    MaterialTextView materialTextView4 = (MaterialTextView) inflate.findViewById(R.id.ticket_count_title);
                                    if (materialTextView4 != null) {
                                        i = R.id.toolbar;
                                        Toolbar toolbar = (Toolbar) inflate.findViewById(R.id.toolbar);
                                        if (toolbar != null) {
                                            i = R.id.trip_details;
                                            View findViewById = inflate.findViewById(R.id.trip_details);
                                            if (findViewById != null) {
                                                cz b2 = cz.b(findViewById);
                                                i = R.id.trip_details_layout;
                                                LinearLayout linearLayout4 = (LinearLayout) inflate.findViewById(R.id.trip_details_layout);
                                                if (linearLayout4 != null) {
                                                    i = R.id.used_on_details_layout;
                                                    LinearLayout linearLayout5 = (LinearLayout) inflate.findViewById(R.id.used_on_details_layout);
                                                    if (linearLayout5 != null) {
                                                        i = R.id.used_on_text;
                                                        MaterialTextView materialTextView5 = (MaterialTextView) inflate.findViewById(R.id.used_on_text);
                                                        if (materialTextView5 != null) {
                                                            i = R.id.used_on_title;
                                                            MaterialTextView materialTextView6 = (MaterialTextView) inflate.findViewById(R.id.used_on_title);
                                                            if (materialTextView6 != null) {
                                                                i = R.id.user_details;
                                                                View findViewById2 = inflate.findViewById(R.id.user_details);
                                                                if (findViewById2 != null) {
                                                                    pz b3 = pz.b(findViewById2);
                                                                    i = R.id.user_profile_layout;
                                                                    LinearLayout linearLayout6 = (LinearLayout) inflate.findViewById(R.id.user_profile_layout);
                                                                    if (linearLayout6 != null) {
                                                                        i = R.id.vehicle_info_layout;
                                                                        LinearLayout linearLayout7 = (LinearLayout) inflate.findViewById(R.id.vehicle_info_layout);
                                                                        if (linearLayout7 != null) {
                                                                            i = R.id.vehicle_no;
                                                                            MaterialTextView materialTextView7 = (MaterialTextView) inflate.findViewById(R.id.vehicle_no);
                                                                            if (materialTextView7 != null) {
                                                                                i = R.id.vehicle_no_title;
                                                                                MaterialTextView materialTextView8 = (MaterialTextView) inflate.findViewById(R.id.vehicle_no_title);
                                                                                if (materialTextView8 != null) {
                                                                                    bw bwVar = new bw((ConstraintLayout) inflate, materialTextView, materialTextView2, linearLayout, linearLayout2, scrollView, materialTextView3, linearLayout3, materialTextView4, toolbar, b2, linearLayout4, linearLayout5, materialTextView5, materialTextView6, b3, linearLayout6, linearLayout7, materialTextView7, materialTextView8);
                                                                                    n86.d(bwVar, "inflate(layoutInflater)");
                                                                                    return bwVar;
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
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
        t81 t81 = (t81) new ai(z86.a(t81.class), new a(this), new b(this, getIntent().getStringExtra("arg_source"), (MTicket) getIntent().getParcelableExtra("arg_mTicket"))).getValue();
        n86.e(t81, "<set-?>");
        this.k = t81;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.report_problem_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        n86.e(menuItem, "item");
        if (menuItem.getItemId() != R.id.report_problem_menu) {
            return false;
        }
        xt.t1 t1Var = xt.f3961a;
        y20 R = t1Var.R();
        HashMap hashMap = new HashMap();
        City d = t1Var.k().d();
        n86.c(d);
        String name = d.getName();
        n86.d(name, "DependencyFactory.cityProvider.currentCity!!.name");
        hashMap.put("userPropertyCity", name);
        UserProfile e = t1Var.L().e();
        if (e != null) {
            String fullName = e.getFullName();
            n86.d(fullName, "it.fullName");
            hashMap.put("userPropertyUserName", fullName);
            String phone = e.getPhone();
            n86.d(phone, "it.phone");
            hashMap.put("userPropertyPhoneNo", phone);
            String userId = e.getUserId();
            n86.d(userId, "it.userId");
            hashMap.put("userPropertyUserID", userId);
        }
        R.b(this, "historyScreen", "mTicketTripReceiptActivity", hashMap, false);
        ed1 l2 = hj1.l("report problem clicked v2", Long.MIN_VALUE, "type", "historyScreen");
        l2.a("problemSource", "mTicketTripReceiptActivity");
        ui1.m0(l2);
        return true;
    }

    @Override // defpackage.tl0
    public void p0() {
    }

    @Override // defpackage.tl0
    public void q0() {
    }

    @Override // defpackage.tl0
    public void r0() {
        Toolbar toolbar = ((bw) f0()).e;
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
        if (s0().f.get_userProfile() == null) {
            LinearLayout linearLayout = ((bw) f0()).k;
            n86.d(linearLayout, "viewBinding.userProfileLayout");
            linearLayout.setVisibility(8);
        } else {
            LinearLayout linearLayout2 = ((bw) f0()).k;
            n86.d(linearLayout2, "viewBinding.userProfileLayout");
            linearLayout2.setVisibility(0);
            UserProfile userProfile = s0().f.get_userProfile();
            pz pzVar = ((bw) f0()).j;
            pzVar.f.setText(userProfile.getFullName());
            pzVar.b.setText(userProfile.getDateOfBirth());
            pzVar.c.setText(getString(userProfile.getGender().getResId()));
            String profilePhoto = userProfile.getProfilePhoto();
            n86.d(profilePhoto, "lUserProfile.profilePhoto");
            if (profilePhoto.length() > 0) {
                ProgressBar progressBar = pzVar.d;
                n86.d(progressBar, "passProfilePicProgressbar");
                progressBar.setVisibility(0);
                ml1<Bitmap> j = gl1.g(this).j();
                j.h(userProfile.getProfilePhoto());
                j.a(new rs1().q(50000));
                j.f(new qe0(this, pzVar));
                pzVar.e.setOnClickListener(new z90(this, pzVar, userProfile));
            }
        }
        StringBuilder sb = new StringBuilder();
        Iterator p0 = hj1.p0(s0().f);
        boolean z2 = false;
        while (p0.hasNext()) {
            String str = (String) p0.next();
            if (z2) {
                sb.append(", ");
            }
            MTicketPassengerInfo mTicketPassengerInfo = s0().f.getPassengerDetails().get(str);
            sb.append(mTicketPassengerInfo == null ? "" : Integer.valueOf(mTicketPassengerInfo.getPassengerCount()));
            sb.append(" ");
            sb.append(xt.f3961a.c().F(str));
            z2 = true;
        }
        LinearLayout linearLayout3 = ((bw) f0()).g;
        n86.d(linearLayout3, "viewBinding.tripDetailsLayout");
        linearLayout3.setVisibility(0);
        cz czVar = ((bw) f0()).f;
        ui1.x0(this, czVar.b, s0().f.getUpTripRouteStopsInfo().getRouteName(), s0().f.getUpTripRouteStopsInfo().getSpecialFeatures(), s0().f.getUpTripRouteStopsInfo().get_spf());
        czVar.d.setText(s0().f.getUpTripRouteStopsInfo().getStartStopName());
        czVar.c.setText(s0().f.getUpTripRouteStopsInfo().getEndStopName());
        MTicketTripReceipt mticketTripReceipt = s0().f.getMticketTripReceipt();
        if (mticketTripReceipt == null) {
            LinearLayout linearLayout4 = ((bw) f0()).d;
            n86.d(linearLayout4, "viewBinding.infoNotAvailableLayout");
            linearLayout4.setVisibility(0);
            LinearLayout linearLayout5 = ((bw) f0()).l;
            n86.d(linearLayout5, "viewBinding.vehicleInfoLayout");
            linearLayout5.setVisibility(8);
            LinearLayout linearLayout6 = ((bw) f0()).c;
            n86.d(linearLayout6, "viewBinding.conductorInfoLayout");
            linearLayout6.setVisibility(8);
            LinearLayout linearLayout7 = ((bw) f0()).h;
            n86.d(linearLayout7, "viewBinding.usedOnDetailsLayout");
            linearLayout7.setVisibility(8);
            return;
        }
        LinearLayout linearLayout8 = ((bw) f0()).d;
        n86.d(linearLayout8, "viewBinding.infoNotAvailableLayout");
        linearLayout8.setVisibility(8);
        if (mticketTripReceipt.getVehicleNo().length() == 0) {
            LinearLayout linearLayout9 = ((bw) f0()).l;
            n86.d(linearLayout9, "viewBinding.vehicleInfoLayout");
            linearLayout9.setVisibility(8);
        } else {
            LinearLayout linearLayout10 = ((bw) f0()).l;
            n86.d(linearLayout10, "viewBinding.vehicleInfoLayout");
            linearLayout10.setVisibility(0);
            ((bw) f0()).m.setText(mticketTripReceipt.getVehicleNo());
        }
        if (mticketTripReceipt.getConductorId().length() != 0) {
            z = false;
        }
        if (z) {
            LinearLayout linearLayout11 = ((bw) f0()).c;
            n86.d(linearLayout11, "viewBinding.conductorInfoLayout");
            linearLayout11.setVisibility(8);
        } else {
            LinearLayout linearLayout12 = ((bw) f0()).c;
            n86.d(linearLayout12, "viewBinding.conductorInfoLayout");
            linearLayout12.setVisibility(0);
            ((bw) f0()).b.setText(mticketTripReceipt.getConductorId());
        }
        if (mticketTripReceipt.getActivationTimeStamp() == -1) {
            LinearLayout linearLayout13 = ((bw) f0()).h;
            n86.d(linearLayout13, "viewBinding.usedOnDetailsLayout");
            linearLayout13.setVisibility(8);
        } else {
            ((bw) f0()).i.setText(f71.f1097a.c(mticketTripReceipt.getActivationTimeStamp()));
        }
        ed1 ed1 = new ed1("mTicket Trip Receipt Screen Opened", Long.MIN_VALUE);
        ed1.a("source", s0().e);
        if (s0().f.getMticketTripReceipt() != null) {
            ed1.a("isTripReceiptAvailable", Boolean.TRUE);
            gi1.c(ed1, s0().f.getMticketTripReceipt());
        } else {
            ed1.a("isTripReceiptAvailable", Boolean.FALSE);
        }
        gi1.f1265a.b(ed1, s0().f);
        ui1.m0(ed1);
    }

    public final t81 s0() {
        t81 t81 = this.k;
        if (t81 != null) {
            return t81;
        }
        n86.l("viewModel");
        throw null;
    }
}
