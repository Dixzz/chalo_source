package app.zophop.ui.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import app.zophop.R;
import app.zophop.models.mTicketing.MPass;
import app.zophop.models.mTicketing.ProductConfiguration;
import app.zophop.models.mTicketing.ProductDiscountsObject;
import app.zophop.models.mTicketing.RideDetails;
import app.zophop.models.mTicketing.UserProfile;
import app.zophop.room.ProductRepository;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.rabbitmq.client.ConnectionFactory;
import defpackage.ut;
import java.util.Calendar;
import java.util.HashMap;

public class ActivePassScreen extends au implements Animation.AnimationListener {
    public static MPass F;
    public View A;
    public View B;
    public boolean C;
    public boolean D;
    public RideDetails E;
    @InjectView(R.id.bottom_layout)
    public ImageView _bottomLayout;
    @InjectView(R.id.agency_text_id)
    public TextView _brandingView;
    @InjectView(R.id.dob)
    public TextView _dobView;
    @InjectView(R.id.dual_logo)
    public RelativeLayout _dualLogo;
    @InjectView(R.id.pass_extension_active_pass_screen)
    public LinearLayout _passExtensionBanner;
    @InjectView(R.id.gender)
    public TextView _profileDetailsView;
    @InjectView(R.id.profile_name)
    public TextView _profileNameView;
    @InjectView(R.id.profile_pic)
    public ImageView _profilePicView;
    @InjectView(R.id.pass_profile_pic_progressbar)
    public ProgressBar _profilePictureLoader;
    @InjectView(R.id.pass_qr_code)
    public ImageView _qrCodeImageView;
    @InjectView(R.id.route_container)
    public LinearLayout _routeContainer;
    @InjectView(R.id.tap_qr_code)
    public TextView _tapText;
    public Animation k;
    public Animation l;
    public boolean m;
    public ImageView n;
    public int o;
    public long p;
    public long q;
    public String r;
    public String s;
    public String t;
    public String u;
    public String v;
    public Handler w;
    public Runnable x;
    public Runnable y;
    public Handler z;

    public class a implements Runnable {
        public final z25 f = new z25();
        public final /* synthetic */ boolean g;
        public final /* synthetic */ ImageView h;
        public final /* synthetic */ int i;

        public a(ActivePassScreen activePassScreen, boolean z, ImageView imageView, int i2) {
            this.g = z;
            this.h = imageView;
            this.i = i2;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:6:0x0022 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:8:0x002d */
        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: java.lang.String */
        /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: java.lang.String */
        /* JADX DEBUG: Multi-variable search result rejected for r2v6, resolved type: java.lang.StringBuilder */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v14, types: [f45] */
        /* JADX WARN: Type inference failed for: r0v15, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v17, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v18 */
        /* JADX WARN: Type inference failed for: r0v19 */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x004d */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            // Method dump skipped, instructions count: 232
            */
            throw new UnsupportedOperationException("Method not decompiled: app.zophop.ui.activities.ActivePassScreen.a.run():void");
        }
    }

    @Override // defpackage.tf1
    public void e(Bundle bundle) {
        int i;
        this.B = getLayoutInflater().inflate(R.layout.activity_active_pass_screen, (ViewGroup) null);
        this.A = getLayoutInflater().inflate(R.layout.activity_zoomed_qr_code, (ViewGroup) null);
        setContentView(this.B);
        ut.a aVar = ut.f3552a;
        getWindow().setFlags(RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST, RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST);
        ButterKnife.inject(this);
        this.w = new Handler();
        TextView textView = (TextView) findViewById(R.id.time_container);
        Runnable runnable = this.x;
        if (runnable != null) {
            this.w.removeCallbacks(runnable);
        }
        gc0 gc0 = new gc0(this, textView);
        this.x = gc0;
        this.w.post(gc0);
        this._profilePicView.setOnClickListener(new hc0(this));
        this.v = getIntent().getStringExtra("src");
        this.C = getIntent().getBooleanExtra("shouldLaunchNew", false);
        if (bundle != null) {
            F = ov.r(bundle.getString("magic_pass_info"));
        }
        i0();
        F.getPassengerType();
        F.getFare();
        this.o = F.getNoOfDays();
        this.q = F.getStartingTime();
        this.p = F.getExpiryTime();
        UserProfile userProfile = F.getUserProfile();
        this.r = userProfile.getProfilePhoto();
        this.s = userProfile.getFirstName() + " " + userProfile.getLastName();
        this.t = getString(userProfile.getGender().getResId());
        this.u = userProfile.getDateOfBirth();
        if (this.r != null) {
            this._profilePictureLoader.setVisibility(0);
            String str = this.r;
            ml1<Bitmap> j = gl1.g(this).j();
            j.m = str;
            j.p = true;
            j.a(new rs1().q(50000));
            j.f(new fc0(this, 0));
        }
        if ((jh1.a(this.o) + this.q) - 1000 < this.p) {
            this._passExtensionBanner.setVisibility(0);
            TextView textView2 = (TextView) this._passExtensionBanner.findViewById(R.id.pass_extension_textview);
            String j0 = ui1.j0();
            if (j0 != null) {
                textView2.setText(j0);
            } else {
                this._passExtensionBanner.setVisibility(8);
            }
        }
        ed1 ed1 = new ed1("pass active screen open", Long.MIN_VALUE);
        if (!TextUtils.isEmpty(this.v)) {
            ed1.a("source", this.v);
        }
        try {
            i = Settings.System.getInt(getContentResolver(), "screen_brightness");
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
            b00 b00 = b00.f358a;
            b00.a().b(e);
            i = -1;
        }
        ed1.a("screen brightness", Integer.valueOf(i));
        jz5.b().g(ed1);
        ProductConfiguration m0 = vn.m0(F.getConfigId());
        String productName = m0 != null ? m0.getProductName() : "Pass";
        Calendar.getInstance().get(1);
        if (!TextUtils.isEmpty(F.get_productName())) {
            productName = F.get_productName();
        }
        new SpannableStringBuilder(productName).append((CharSequence) ui1.J(this, F.getSpecialFeatures()));
        ui1.j(String.valueOf(this.o));
        this._profileNameView.setText(this.s);
        this._profileDetailsView.setText(this.t);
        String str2 = this.u;
        if (str2.charAt(2) != '/') {
            StringBuilder sb = new StringBuilder();
            hj1.M0(this.u, 8, 10, sb, ConnectionFactory.DEFAULT_VHOST);
            hj1.M0(this.u, 5, 7, sb, ConnectionFactory.DEFAULT_VHOST);
            sb.append(this.u.substring(0, 4));
            str2 = sb.toString();
        }
        this._dobView.setText(ui1.w(str2));
        this.E = new ProductRepository(this).fetchRidedetails(F.getBookingPassId());
        if (F.get_productType() != null && F.get_productType().equals("superSaver")) {
            findViewById(R.id.trip_details).setVisibility(0);
            findViewById(R.id.max_fare_divider).setVisibility(0);
            findViewById(R.id.max_fare_info).setVisibility(0);
            ((TextView) findViewById(R.id.max_fare_info).findViewById(R.id.trip_heading)).setText(getString(R.string.maxFareCopy));
            ((TextView) findViewById(R.id.trip_details).findViewById(R.id.trip_heading)).setText(getString(R.string.trips_remaining));
            TextView textView3 = (TextView) findViewById(R.id.max_fare_info).findViewById(R.id.trip_count);
            StringBuilder i0 = hj1.i0("Upto ");
            i0.append(ui1.H());
            i0.append(F.get_maxTripsPrice() == -1 ? F.get_grouping().get_maxPricePerRide() : F.get_maxTripsPrice());
            textView3.setText(i0.toString());
            ((TextView) findViewById(R.id.trip_details).findViewById(R.id.trip_count)).setText(String.valueOf(F.get_maxTrips() - vn.B0(this.E, F.getPunches())));
            ProductConfiguration m02 = vn.m0(F.getConfigId());
            if (m02 != null && m02.shouldHideSubCategorySelection()) {
                findViewById(R.id.max_fare_divider).setVisibility(8);
                findViewById(R.id.max_fare_info).setVisibility(8);
            }
        }
        ((TextView) findViewById(R.id.pass_validity_time)).setText((getString(R.string.mticket_booking_valid_till) + " " + jh1.f(this.p)).replace(",", "on"));
        if (F.getRouteStopsInfo() != null) {
            this.k = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in_route_pass);
        } else {
            this.k = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in_route_pass);
        }
        this.l = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_out);
        this.k.setAnimationListener(this);
        this.n = (ImageView) findViewById(R.id.profile_pic);
        this.k.setAnimationListener(this);
        this._tapText.setOnClickListener(new ec0(this, (ImageView) this.B.findViewById(R.id.pass_qr_code)));
        this._qrCodeImageView.setOnClickListener(new ec0(this, null));
        h0(this._qrCodeImageView, false);
        this._brandingView.getText().toString();
        if (F.getRouteStopsInfo() != null) {
            ((LinearLayout) findViewById(R.id.route_container_padding_layout)).setVisibility(0);
            ((LinearLayout) findViewById(R.id.profile_info_padding_layout)).setVisibility(0);
            this._routeContainer.setVisibility(0);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(F.getRouteStopsInfo().getRouteName());
            int i2 = 0;
            while (F.getSpecialFeatures() != null && i2 < F.getSpecialFeatures().size()) {
                if (F.getSpecialFeatures().contains("AC") || F.getSpecialFeatures().contains("FAST")) {
                    d71.b(this, spannableStringBuilder, F.getSpecialFeatures().get(i2), true, R.color.real_time_fetching_string_color, hj1.V(F), R.color.white);
                } else {
                    d71.b(this, spannableStringBuilder, F.getSpecialFeatures().get(i2), true, R.color.spf, hj1.V(F), R.color.black_87);
                }
                i2++;
            }
            ((TextView) this._routeContainer.findViewById(R.id.route_number)).setText(spannableStringBuilder);
            this._routeContainer.findViewById(R.id.edit_route_pass).setVisibility(8);
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(F.getRouteStopsInfo().getStartStopName() + " ");
            spannableStringBuilder2.append((CharSequence) ProductDiscountsObject.KEY_DELIMITER);
            Drawable drawable = getResources().getDrawable(R.drawable.direction_route);
            drawable.setBounds(0, 0, getResources().getDimensionPixelSize(R.dimen.route_bidirectional_icon_size), getResources().getDimensionPixelSize(R.dimen.route_bidirectional_icon_size));
            spannableStringBuilder2.setSpan(new ImageSpan(drawable, 1), spannableStringBuilder2.length() - 1, spannableStringBuilder2.length(), 17);
            spannableStringBuilder2.append((CharSequence) (" " + F.getRouteStopsInfo().getEndStopName()));
            ((TextView) this._routeContainer.findViewById(R.id.route_details)).setText(spannableStringBuilder2);
        } else {
            this._routeContainer.setVisibility(8);
            ((LinearLayout) findViewById(R.id.route_container_padding_layout)).setVisibility(8);
        }
        String B2 = hj1.B(xt.f3961a);
        TextView textView4 = (TextView) findViewById(R.id.agency_text_id);
        if (!vn.Y0(F.getConfigId())) {
            this._bottomLayout.setVisibility(8);
            this._dualLogo.setVisibility(8);
            textView4.setVisibility(8);
        } else if (B2.equalsIgnoreCase("indore")) {
            this._bottomLayout.setImageResource(R.drawable.aictsl_logo_grey);
            this._bottomLayout.setVisibility(0);
            this._dualLogo.setVisibility(8);
            textView4.setVisibility(8);
        } else if (B2.equalsIgnoreCase("jabalpur")) {
            ((ImageView) this._dualLogo.findViewById(R.id.left_logo)).setImageResource(R.drawable.jabalpur_logo_1);
            ((ImageView) this._dualLogo.findViewById(R.id.right_logo)).setImageResource(R.drawable.jabalpur_logo_2);
            this._bottomLayout.setVisibility(8);
            this._dualLogo.setVisibility(0);
        } else if (B2.equalsIgnoreCase("bhopal")) {
            ((ImageView) this._dualLogo.findViewById(R.id.left_logo)).setImageResource(R.drawable.bhopal_logo_1);
            ((ImageView) this._dualLogo.findViewById(R.id.right_logo)).setImageResource(R.drawable.bhopal_logo_2);
            this._bottomLayout.setVisibility(8);
            this._dualLogo.setVisibility(0);
        } else {
            this._bottomLayout.setVisibility(8);
            this._dualLogo.setVisibility(8);
            textView4.setVisibility(0);
            textView4.setText(getString(R.string.agency_text) + " " + F.getAgency().toUpperCase());
        }
        if (!this.D) {
            vn.b1(this);
            this.D = true;
        }
    }

    public final void h0(ImageView imageView, boolean z2) {
        new a(this, z2, imageView, (int) ((float) getResources().getDisplayMetrics().widthPixels)).run();
    }

    public final void i0() {
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().o(true);
        ProductConfiguration m0 = vn.m0(F.getConfigId());
        String productName = m0 != null ? m0.getProductName() : "Pass";
        if (!TextUtils.isEmpty(F.get_productName())) {
            productName = F.get_productName();
        }
        getSupportActionBar().z(new SpannableStringBuilder(productName).append((CharSequence) ui1.J(this, F.getSpecialFeatures())).toString().trim());
    }

    public final void j0(Bitmap bitmap) {
        this.n.setImageBitmap(bitmap);
    }

    public final void k0(float f) {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (attributes != null && attributes.screenBrightness != f) {
            attributes.screenBrightness = f;
            getWindow().setAttributes(attributes);
        }
    }

    public final void l0(String str, View view) {
        ZoomedImageViewActivity.h0(this, (ImageView) view, str, null);
    }

    public void onAnimationEnd(Animation animation) {
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        if (this.m) {
            k0(-1.0f);
            this.m = false;
            setContentView(this.B);
            i0();
            this._qrCodeImageView.startAnimation(this.l);
        } else if (!xt.f3961a.G().d(getFragmentManager(), "activePassScreen", ActivePassScreen.class.getSimpleName())) {
            if (!this.C) {
                super.onBackPressed();
                return;
            }
            Intent intent = new Intent(this, HomeActivity.class);
            intent.setFlags(268468224);
            startActivity(intent);
        }
    }

    @Override // defpackage.tf1
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.report_problem_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override // defpackage.f0, defpackage.ve, defpackage.au
    public void onDestroy() {
        super.onDestroy();
        this.w.removeCallbacks(this.x);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            if (this.m || !(getIntent() == null || this.v == null)) {
                onBackPressed();
                return true;
            }
            Intent intent = new Intent(this, HomeActivity.class);
            intent.setFlags(268468224);
            startActivity(intent);
            return true;
        } else if (itemId != R.id.report_problem_menu) {
            return false;
        } else {
            y20 R = xt.f3961a.R();
            HashMap hashMap = new HashMap();
            MPass mPass = F;
            if (mPass != null) {
                if (mPass.get_cityName() != null) {
                    hashMap.put("userPropertyCity", F.get_cityName());
                }
                if (F.getUserProfile() != null) {
                    UserProfile userProfile = F.getUserProfile();
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
                if (F.getAgency() != null) {
                    hashMap.put("userPropertyAgencyName", F.getAgency());
                }
                if (F.getRouteStopsInfo() != null) {
                    if (F.getRouteStopsInfo().getRouteId() != null) {
                        hashMap.put("userPropertyRouteId", F.getRouteStopsInfo().getRouteId());
                    }
                    if (F.getRouteStopsInfo().getRouteName() != null) {
                        hashMap.put("userPropertyRouteName", F.getRouteStopsInfo().getRouteName());
                    }
                }
                if (F.getBookingPassId() != null) {
                    hashMap.put("userPropertyMPassId", F.getBookingPassId());
                }
                if (F.getOrderId() != null) {
                    hashMap.put("userPropertyOrderId", F.getOrderId());
                }
            }
            R.b(this, "transactionRelatedScreen", "activePassScreen", hashMap, false);
            ed1 l2 = hj1.l("report problem clicked v2", Long.MIN_VALUE, "type", "qrCodeScreenTicketingProblemsV2");
            hj1.K0(l2, "problemSource", "activePassScreen", l2);
            return true;
        }
    }

    @Override // defpackage.ve, defpackage.au, defpackage.tf1
    public void onPause() {
        xt.f3961a.G().n();
        super.onPause();
    }

    public void onRestoreInstanceState(Bundle bundle) {
        if (bundle != null) {
            F = ov.r(bundle.getString("magic_pass_info"));
        }
        super.onRestoreInstanceState(bundle);
    }

    @Override // defpackage.ve, defpackage.au, defpackage.tf1
    public void onResume() {
        super.onResume();
        xt.f3961a.G().h("activePassScreen", getFragmentManager(), ActivePassScreen.class.getSimpleName());
    }

    @Override // androidx.activity.ComponentActivity, defpackage.y4
    public void onSaveInstanceState(Bundle bundle) {
        MPass mPass = F;
        if (mPass != null) {
            bundle.putString("magic_pass_info", ov.f(mPass));
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // defpackage.f0, defpackage.ve, defpackage.au
    public void onStart() {
        super.onStart();
        if (this.z == null) {
            this.z = new Handler();
        }
        dc0 dc0 = new dc0(this, xt.f3961a.c().x(vn.y(F.getConfigId()), F.getBookingPassId()));
        this.y = dc0;
        this.z.post(dc0);
    }

    @Override // defpackage.f0, defpackage.ve, defpackage.au
    public void onStop() {
        super.onStop();
        this.z.removeCallbacks(this.y);
    }

    public void onUserInteraction() {
        super.onUserInteraction();
        xt.f3961a.G().k();
    }
}
