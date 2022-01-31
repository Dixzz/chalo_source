package app.zophop.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import app.zophop.R;
import app.zophop.models.LastRideInfo;
import app.zophop.models.mTicketing.MPass;
import app.zophop.models.mTicketing.ProductConfiguration;
import app.zophop.models.mTicketing.ProductDiscountsObject;
import app.zophop.models.mTicketing.RideDetails;
import app.zophop.models.mTicketing.UserProfile;
import app.zophop.room.ProductRepository;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.rabbitmq.client.ConnectionFactory;
import defpackage.xt;
import java.util.HashMap;
import java.util.Objects;

public class ActivatePassScreen extends au {
    public static MPass K;
    public TextView A;
    public LinearLayout B;
    public TextView C;
    public ProgressBar D;
    public ImageView E;
    public ImageView F;
    public TextView G;
    public TextView H;
    public TextView I;
    public LinearLayout J;
    public String k;
    public int l;
    public long m;
    public long n;
    public LinearLayout o;
    public LinearLayout p;
    public RideDetails q;
    public ProductRepository r;
    public String s;
    public String t;
    public String u;
    public String v;
    public String w;
    public boolean x;
    public boolean y;
    public ImageView z;

    public static void h0(ActivatePassScreen activatePassScreen) {
        ProductConfiguration m0;
        Objects.requireNonNull(activatePassScreen);
        xt.t1 t1Var = xt.f3961a;
        t1Var.c().R(K, t1Var.L().j());
        MPass mPass = K;
        if (!(mPass == null || (m0 = vn.m0(mPass.getConfigId())) == null)) {
            LastRideInfo lastRideInfo = new LastRideInfo();
            lastRideInfo.setBookingId(mPass.getBookingPassId());
            lastRideInfo.setActivationTimeStamp(ui1.Q());
            lastRideInfo.setActivationDuration(m0.getProductActiveDuration());
            lastRideInfo.setProductType(m0.getProductType());
            t1Var.s().a(lastRideInfo);
        }
        if (!ui1.B0() || K.getTone() == null) {
            MPass mPass2 = K;
            String str = activatePassScreen.w;
            ActivePassScreen.F = mPass2;
            Intent intent = new Intent(activatePassScreen, ActivePassScreen.class);
            intent.putExtra("src", str);
            intent.putExtra("shouldLaunchNew", true);
            activatePassScreen.startActivity(intent);
        } else {
            ValidationScreen.k0(activatePassScreen, K, activatePassScreen.w, true);
        }
        zz zzVar = new zz("pass activated", new HashMap());
        zzVar.a("date", jh1.c(ui1.Q()));
        zzVar.a("time", jh1.g(ui1.Q()));
        ui1.l0(zzVar);
        ed1 ed1 = new ed1("pass activated", Long.MIN_VALUE);
        ed1.a("passId", K.getBookingPassId());
        ed1.a("passengerType", activatePassScreen.k);
        if (t1Var.B().h() != null) {
            LatLng h = t1Var.B().h();
            ed1.a("long", hj1.U(hj1.f0(ed1, "lat", hj1.U(new StringBuilder(), h.latitude, "")), h.longitude, ""));
        }
        if (!TextUtils.isEmpty(activatePassScreen.w)) {
            ed1.a("source", activatePassScreen.w);
        }
        ed1.a("name", K.getUserProfile().getFirstName());
        ed1.a("phone", K.getUserProfile().getPhone());
        ed1.a("time", jh1.g(ui1.Q()));
        ed1.a("date", jh1.c(ui1.Q()));
        ed1.a("startDate", jh1.c(K.getStartingTime()));
        ed1.a("numDays", K.getNoOfDays() + "");
        ed1.a("productType", K.getNoOfDays() + "");
        jz5.b().g(ed1);
        activatePassScreen.finish();
    }

    public static void i0(Context context, MPass mPass, String str, boolean z2) {
        K = mPass;
        Intent N0 = hj1.N0(context, ActivatePassScreen.class, "src", str);
        N0.putExtra("shouldLaunchNew", z2);
        if (z2) {
            N0.setFlags(268468224);
        }
        context.startActivity(N0);
    }

    @Override // defpackage.tf1
    public void e(Bundle bundle) {
        setContentView(R.layout.activity_activate_pass);
        this.o = (LinearLayout) findViewById(R.id.route_container);
        this.p = (LinearLayout) findViewById(R.id.pass_extension_activate_pass_screen);
        TextView textView = (TextView) findViewById(R.id.trip_count);
        this.B = (LinearLayout) findViewById(R.id.profile_info);
        this.D = (ProgressBar) findViewById(R.id.pass_profile_pic_progressbar);
        this.E = (ImageView) findViewById(R.id.profile_pic);
        this.F = (ImageView) findViewById(R.id.profile_pic);
        this.G = (TextView) findViewById(R.id.profile_name);
        this.H = (TextView) findViewById(R.id.gender);
        this.I = (TextView) findViewById(R.id.dob);
        this.w = getIntent().getStringExtra("src");
        this.x = getIntent().getBooleanExtra("shouldLaunchNew", false);
        if (bundle != null) {
            K = ov.r(bundle.getString("magic_pass_info"));
        }
        UserProfile userProfile = K.getUserProfile();
        if (userProfile == null) {
            this.B.setVisibility(8);
        } else {
            this.s = userProfile.getProfilePhoto();
            this.t = userProfile.getFirstName() + " " + userProfile.getLastName();
            this.u = getString(userProfile.getGender().getResId());
            this.v = userProfile.getDateOfBirth();
            if (this.s != null) {
                this.D.setVisibility(0);
                j0(this.s);
            }
            this.G.setText(this.t);
            this.H.setText(this.u);
            String str = this.v;
            if (str.charAt(2) != '/') {
                StringBuilder sb = new StringBuilder();
                hj1.M0(this.v, 8, 10, sb, ConnectionFactory.DEFAULT_VHOST);
                hj1.M0(this.v, 5, 7, sb, ConnectionFactory.DEFAULT_VHOST);
                sb.append(this.v.substring(0, 4));
                str = sb.toString();
            }
            this.I.setText(ui1.w(str));
            this.F.setOnClickListener(new sb0(this));
        }
        ProductRepository productRepository = new ProductRepository(this);
        this.r = productRepository;
        this.q = productRepository.fetchRidedetails(K.getBookingPassId());
        this.k = K.getPassengerType();
        K.getFare();
        this.l = K.getNoOfDays();
        this.n = K.getStartingTime();
        this.m = K.getExpiryTime();
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.activate_pass_bottomsheet);
        this.J = linearLayout;
        this.C = (TextView) linearLayout.findViewById(R.id.activation_title);
        this.A = (TextView) this.J.findViewById(R.id.activation_text);
        TextView textView2 = (TextView) this.J.findViewById(R.id.activate_btn);
        this.C.setText(getResources().getString(R.string.activate_screen_bottomsheet_title));
        this.A.setText(getResources().getString(R.string.mpass_activation_text));
        textView2.setText(getResources().getString(R.string.btn_txt_activate));
        BottomSheetBehavior H2 = BottomSheetBehavior.H(this.J);
        tb0 tb0 = new tb0(this, H2);
        if (!H2.I.contains(tb0)) {
            H2.I.add(tb0);
        }
        H2.M(3);
        textView2.setOnClickListener(new ub0(this));
        if (ui1.Q() < this.n) {
            Toast.makeText(this, "Your pass is not active yet.Please check the start date.", 0).show();
            textView2.setEnabled(false);
        } else {
            textView2.setEnabled(true);
        }
        this.z = (ImageView) findViewById(R.id.activate_refresh);
        if (K.get_productType() != null && K.get_productType().equals("superSaver")) {
            this.A.setText(String.format(getString(R.string.ride_based_pass_activation_text), vn.O(this, vn.y(K.getConfigId()))));
            this.z.setVisibility(vn.K0(this) ? 8 : 0);
            if (K.get_maxTrips() == 0) {
                MPass mPass = K;
                mPass.set_maxTrips(vn.n0(mPass.getConfigId(), K.get_productCategory(), ((long) (K.getNoOfDays() * 24 * 60 * 60)) * 1000).getMaxRides());
                int maxRidesPerDay = vn.n0(K.getConfigId(), K.get_productCategory(), ((long) (K.getNoOfDays() * 24 * 60 * 60)) * 1000).getMaxRidesPerDay();
                MPass mPass2 = K;
                if (maxRidesPerDay == -1) {
                    maxRidesPerDay = mPass2.get_maxTripsPerDay();
                }
                mPass2.set_maxTripsPerDay(maxRidesPerDay);
                if (K.get_maxTripsPerDay() == -1) {
                    ((TextView) findViewById(R.id.trip_details).findViewById(R.id.trip_count)).setText(String.format(getString(R.string.tripCountDetailsActivateScreenNoDailyLimit, new Object[]{Integer.valueOf(K.get_maxTrips())}), new Object[0]));
                } else {
                    ((TextView) findViewById(R.id.trip_details).findViewById(R.id.trip_count)).setText(String.format(getString(R.string.tripCountDetailsActivateScreen, new Object[]{Integer.valueOf(K.get_maxTrips()), Integer.valueOf(K.get_maxTripsPerDay())}), new Object[0]));
                }
            } else if (K.get_maxTripsPerDay() == -1) {
                ((TextView) findViewById(R.id.trip_details).findViewById(R.id.trip_count)).setText(String.format(getString(R.string.tripCountDetailsActivateScreenNoDailyLimit, new Object[]{Integer.valueOf(K.get_maxTrips() - vn.B0(this.q, K.getPunches()))}), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.trip_details).findViewById(R.id.trip_count)).setText(String.format(getString(R.string.tripCountDetailsActivateScreen, new Object[]{Integer.valueOf(K.get_maxTrips() - vn.B0(this.q, K.getPunches())), Integer.valueOf(K.get_maxTripsPerDay() - vn.J(this.q))}), new Object[0]));
            }
            findViewById(R.id.trip_details).setVisibility(0);
            findViewById(R.id.max_fare_divider).setVisibility(0);
            findViewById(R.id.max_fare_info).setVisibility(0);
            ((TextView) findViewById(R.id.max_fare_info).findViewById(R.id.trip_heading)).setText(getString(R.string.maxFareCopy));
            ((TextView) findViewById(R.id.trip_details).findViewById(R.id.trip_heading)).setText(getString(R.string.trips_remaining));
            TextView textView3 = (TextView) findViewById(R.id.max_fare_info).findViewById(R.id.trip_count);
            StringBuilder i0 = hj1.i0("Upto ");
            i0.append(ui1.H());
            hj1.T0(i0, K.get_maxTripsPrice() == -1 ? K.get_grouping().get_maxPricePerRide() : K.get_maxTripsPrice(), textView3);
            ProductConfiguration m0 = vn.m0(K.getConfigId());
            if (m0 != null && m0.shouldHideSubCategorySelection()) {
                findViewById(R.id.max_fare_info).setVisibility(8);
            }
        }
        if (K.getRouteStopsInfo() != null) {
            this.o.setVisibility(0);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(K.getRouteStopsInfo().getRouteName());
            int i = 0;
            while (K.getSpecialFeatures() != null && i < K.getSpecialFeatures().size()) {
                if (K.getSpecialFeatures().contains("AC") || K.getSpecialFeatures().contains("FAST")) {
                    d71.b(this, spannableStringBuilder, K.getSpecialFeatures().get(i), true, R.color.real_time_fetching_string_color, hj1.V(K), R.color.white);
                } else {
                    d71.b(this, spannableStringBuilder, K.getSpecialFeatures().get(i), true, R.color.spf, hj1.V(K), R.color.black_87);
                }
                i++;
            }
            ((TextView) this.o.findViewById(R.id.route_number)).setText(spannableStringBuilder);
            this.o.findViewById(R.id.edit_route_pass).setVisibility(8);
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(K.getRouteStopsInfo().getStartStopName() + " ");
            spannableStringBuilder2.append((CharSequence) ProductDiscountsObject.KEY_DELIMITER);
            Drawable drawable = getResources().getDrawable(R.drawable.direction_route);
            drawable.setBounds(0, 0, getResources().getDimensionPixelSize(R.dimen.route_bidirectional_icon_size), getResources().getDimensionPixelSize(R.dimen.route_bidirectional_icon_size));
            spannableStringBuilder2.setSpan(new ImageSpan(drawable, 1), spannableStringBuilder2.length() - 1, spannableStringBuilder2.length(), 17);
            spannableStringBuilder2.append((CharSequence) (" " + K.getRouteStopsInfo().getEndStopName()));
            ((TextView) this.o.findViewById(R.id.route_details)).setText(spannableStringBuilder2);
        } else {
            this.o.setVisibility(8);
        }
        String string = getString(R.string.mticket_booking_valid_till);
        String replace = jh1.f(this.m).replace(",", "on");
        ((TextView) findViewById(R.id.tv_mticket_validity_time)).setText(string + " " + replace);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        ProductConfiguration m02 = vn.m0(K.getConfigId());
        String productName = m02 != null ? m02.getProductName() : "Pass";
        if (!TextUtils.isEmpty(K.get_productName())) {
            productName = K.get_productName();
        }
        getSupportActionBar().z(new SpannableStringBuilder(productName).append((CharSequence) ui1.J(this, K.getSpecialFeatures())).toString().trim());
        getSupportActionBar().o(true);
        this.z.setOnClickListener(new qb0(this));
        if (!this.y) {
            vn.b1(this);
            this.y = true;
        }
        if ((jh1.a(this.l) + this.n) - 1000 < this.m) {
            this.p.setVisibility(0);
            TextView textView4 = (TextView) this.p.findViewById(R.id.pass_extension_textview);
            String j0 = ui1.j0();
            if (j0 != null) {
                textView4.setText(j0);
            } else {
                this.p.setVisibility(8);
            }
        }
    }

    public final void j0(String str) {
        ml1<Bitmap> j = gl1.g(this).j();
        j.m = str;
        j.p = true;
        j.a(new rs1().q(50000));
        j.f(new rb0(this));
    }

    public final void k0(String str, View view) {
        ZoomedImageViewActivity.h0(this, (ImageView) view, str, null);
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        if (!this.x) {
            super.onBackPressed();
            return;
        }
        Intent intent = new Intent(this, HomeActivity.class);
        intent.setFlags(268468224);
        startActivity(intent);
    }

    @Override // defpackage.tf1
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.report_problem_view_summary, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            onBackPressed();
            return false;
        } else if (itemId == R.id.report_problem) {
            y20 R = xt.f3961a.R();
            HashMap hashMap = new HashMap();
            MPass mPass = K;
            if (mPass != null) {
                if (mPass.get_cityName() != null) {
                    hashMap.put("userPropertyCity", K.get_cityName());
                }
                if (K.getUserProfile() != null) {
                    UserProfile userProfile = K.getUserProfile();
                    String firstName = userProfile.getFirstName();
                    String lastName = userProfile.getLastName();
                    if (firstName != null) {
                        if (lastName != null) {
                            firstName = hj1.T(firstName, " ", lastName);
                        }
                        hashMap.put("userPropertyUserName", firstName);
                    } else if (lastName != null) {
                        hashMap.put("userPropertyUserName", lastName);
                    }
                    if (userProfile.getPhone() != null) {
                        hashMap.put("userPropertyPhoneNo", userProfile.getPhone());
                    }
                    if (userProfile.getUserId() != null) {
                        hashMap.put("userPropertyUserID", userProfile.getUserId());
                    }
                }
                if (K.getAgency() != null) {
                    hashMap.put("userPropertyAgencyName", K.getAgency());
                }
                if (K.getRouteStopsInfo() != null) {
                    if (K.getRouteStopsInfo().getRouteId() != null) {
                        hashMap.put("userPropertyRouteId", K.getRouteStopsInfo().getRouteId());
                    }
                    if (K.getRouteStopsInfo().getRouteName() != null) {
                        hashMap.put("userPropertyRouteName", K.getRouteStopsInfo().getRouteName());
                    }
                }
                if (K.getBookingPassId() != null) {
                    hashMap.put("userPropertyMPassId", K.getBookingPassId());
                }
                if (K.getOrderId() != null) {
                    hashMap.put("userPropertyOrderId", K.getOrderId());
                }
            }
            R.b(this, "transactionRelatedScreen", "activatePassScreen", hashMap, false);
            ed1 l2 = hj1.l("report problem clicked v2", Long.MIN_VALUE, "type", "activationScreenTicketingProblemsV2");
            hj1.K0(l2, "problemSource", "activatePassScreen", l2);
            return true;
        } else if (itemId != R.id.view_summary) {
            return false;
        } else {
            Intent intent = new Intent(this, BookingSummaryMagicPassActivity.class);
            intent.putExtra("magic_pass_info", K);
            startActivity(intent);
            BookingSummaryMagicPassActivity.p = "history screen";
            return true;
        }
    }

    public void onRestoreInstanceState(Bundle bundle) {
        if (bundle != null) {
            K = ov.r(bundle.getString("magic_pass_info"));
        }
        super.onRestoreInstanceState(bundle);
    }

    @Override // androidx.activity.ComponentActivity, defpackage.y4
    public void onSaveInstanceState(Bundle bundle) {
        MPass mPass = K;
        if (mPass != null) {
            bundle.putString("magic_pass_info", ov.f(mPass));
        }
        super.onSaveInstanceState(bundle);
    }
}
