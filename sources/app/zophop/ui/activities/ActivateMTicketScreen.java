package app.zophop.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import app.zophop.R;
import app.zophop.models.mTicketing.MTicket;
import app.zophop.models.mTicketing.UserProfile;
import com.rabbitmq.client.ConnectionFactory;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;

public class ActivateMTicketScreen extends au {
    public TextView A;
    public LinearLayout B;
    public MTicket k;
    public boolean l;
    public String m;
    public String n;
    public String o;
    public String p;
    public TextView q;
    public boolean r;
    public LinearLayout s;
    public TextView t;
    public TextView u;
    public ProgressBar v;
    public ImageView w;
    public ImageView x;
    public TextView y;
    public TextView z;

    public static void h0(Context context, MTicket mTicket, String str, boolean z2) {
        Intent intent = new Intent(context, ActivateMTicketScreen.class);
        intent.putExtra("mticket_info", mTicket);
        intent.putExtra("src", str);
        intent.putExtra("shouldLaunchNew", z2);
        if (z2) {
            intent.setFlags(268468224);
        }
        context.startActivity(intent);
    }

    @Override // defpackage.tf1
    public void e(Bundle bundle) {
        setContentView(R.layout.activity_activate_mticket);
        getIntent().getStringExtra("src");
        this.k = (MTicket) getIntent().getParcelableExtra("mticket_info");
        this.l = getIntent().getBooleanExtra("shouldLaunchNew", false);
        if (bundle != null) {
            this.k = (MTicket) bundle.getParcelable("mticket_info");
        }
        this.s = (LinearLayout) findViewById(R.id.profile_info);
        this.v = (ProgressBar) findViewById(R.id.pass_profile_pic_progressbar);
        this.w = (ImageView) findViewById(R.id.profile_pic);
        this.x = (ImageView) findViewById(R.id.profile_pic);
        this.y = (TextView) findViewById(R.id.profile_name);
        this.z = (TextView) findViewById(R.id.gender);
        this.A = (TextView) findViewById(R.id.dob);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        String string = getString(R.string.tag_text_ticket_type);
        x supportActionBar = getSupportActionBar();
        Objects.requireNonNull(supportActionBar);
        supportActionBar.z(string);
        getSupportActionBar().o(true);
        UserProfile userProfile = this.k.get_userProfile();
        if (userProfile == null) {
            this.s.setVisibility(8);
        } else {
            this.m = userProfile.getProfilePhoto();
            this.n = userProfile.getFirstName() + " " + userProfile.getLastName();
            this.o = getString(userProfile.getGender().getResId());
            this.p = userProfile.getDateOfBirth();
            if (this.m != null) {
                this.v.setVisibility(0);
                i0(this.m);
            }
            this.y.setText(this.n);
            this.z.setText(this.o);
            String str = this.p;
            if (str.charAt(2) != '/') {
                StringBuilder sb = new StringBuilder();
                hj1.M0(this.p, 8, 10, sb, ConnectionFactory.DEFAULT_VHOST);
                hj1.M0(this.p, 5, 7, sb, ConnectionFactory.DEFAULT_VHOST);
                sb.append(this.p.substring(0, 4));
                str = sb.toString();
            }
            this.A.setText(ui1.w(str));
            this.x.setOnClickListener(new pb0(this));
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.activate_mticket_bottomsheet);
        this.B = linearLayout;
        this.q = (TextView) linearLayout.findViewById(R.id.activate_btn);
        this.t = (TextView) this.B.findViewById(R.id.activation_title);
        this.u = (TextView) this.B.findViewById(R.id.activation_text);
        this.t.setText(getResources().getString(R.string.activate_screen_bottomsheet_title));
        this.u.setText(String.format(getString(R.string.mticket_activation_text), vn.O(this, vn.y(this.k.getMTicketConfiguration().getId()))));
        this.q.setText(getResources().getString(R.string.btn_txt_activate));
        this.q.setEnabled(true);
        this.q.setOnClickListener(new nb0(this));
        ui1.x0(this, (TextView) findViewById(R.id.route_name), this.k.getUpTripRouteStopsInfo().getRouteName(), this.k.getUpTripRouteStopsInfo().getSpecialFeatures(), this.k.getUpTripRouteStopsInfo().get_spf());
        ((TextView) findViewById(R.id.tv_start_stop)).setText(this.k.getUpTripRouteStopsInfo().getStartStopName());
        ((TextView) findViewById(R.id.tv_end_stop)).setText(this.k.getUpTripRouteStopsInfo().getEndStopName());
        ((TextView) findViewById(R.id.tv_passenger_total_fare)).setVisibility(8);
        TextView textView = (TextView) findViewById(R.id.tv_passenger_details);
        StringBuilder sb2 = new StringBuilder();
        Iterator p0 = hj1.p0(this.k);
        boolean z2 = false;
        while (p0.hasNext()) {
            String str2 = (String) p0.next();
            if (z2) {
                sb2.append(", ");
            }
            sb2.append(this.k.getPassengerDetails().get(str2).getPassengerCount());
            sb2.append(" ");
            sb2.append(xt.f3961a.c().F(str2));
            z2 = true;
        }
        textView.setText(sb2.toString());
        String string2 = getString(R.string.mticket_booking_valid_till);
        String replace = jh1.f(this.k.getExpirationTime()).replace(",", "on");
        ((TextView) findViewById(R.id.tv_mticket_validity_time)).setText(string2 + " " + replace);
        getSharedPreferences("scanStartedTime", 0);
        ed1 ed1 = new ed1("mticket activate screen opened", Long.MIN_VALUE);
        if (getIntent().hasExtra("src")) {
            ed1.a("source", getIntent().getStringExtra("src"));
        }
        jz5.b().g(ed1);
        if (!this.r) {
            vn.b1(this);
            this.r = true;
        }
    }

    public final void i0(String str) {
        ml1<Bitmap> j = gl1.g(this).j();
        j.m = str;
        j.p = true;
        j.a(new rs1().q(50000));
        j.f(new ob0(this));
    }

    public final void j0(String str, View view) {
        ZoomedImageViewActivity.h0(this, (ImageView) view, str, null);
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        if (!this.l) {
            super.onBackPressed();
            return;
        }
        Intent intent = new Intent(this, HomeActivity.class);
        intent.setFlags(268468224);
        startActivity(intent);
    }

    @Override // defpackage.tf1
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.report_problem_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            onBackPressed();
            return false;
        } else if (itemId != R.id.report_problem_menu) {
            return false;
        } else {
            y20 R = xt.f3961a.R();
            HashMap hashMap = new HashMap();
            MTicket mTicket = this.k;
            if (mTicket != null) {
                if (mTicket.getCityName() != null) {
                    hashMap.put("userPropertyCity", this.k.getCityName());
                }
                if (this.k.get_userProfile() != null) {
                    UserProfile userProfile = this.k.get_userProfile();
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
                if (this.k.getAgency() != null) {
                    hashMap.put("userPropertyAgencyName", this.k.getAgency());
                }
                if (this.k.getUpTripRouteStopsInfo() != null) {
                    if (this.k.getUpTripRouteStopsInfo().getRouteId() != null) {
                        hashMap.put("userPropertyRouteId", this.k.getUpTripRouteStopsInfo().getRouteId());
                    }
                    if (this.k.getUpTripRouteStopsInfo().getRouteName() != null) {
                        hashMap.put("userPropertyRouteName", this.k.getUpTripRouteStopsInfo().getRouteName());
                    }
                }
                if (this.k.getMTicketId() != null) {
                    hashMap.put("userPropertyMTicketId", this.k.getMTicketId());
                }
                if (this.k.getOrderId() != null) {
                    hashMap.put("userPropertyOrderId", this.k.getOrderId());
                }
            }
            R.b(this, "transactionRelatedScreen", "activateMticketScreen", hashMap, false);
            ed1 l2 = hj1.l("report problem clicked v2", Long.MIN_VALUE, "type", "activationScreenTicketingProblemsV2");
            hj1.K0(l2, "problemSource", "activeMticketScreen", l2);
            return true;
        }
    }

    public void onRestoreInstanceState(Bundle bundle) {
        if (bundle != null) {
            this.k = (MTicket) bundle.getParcelable("mticket_info");
        }
        super.onRestoreInstanceState(bundle);
    }

    @Override // androidx.activity.ComponentActivity, defpackage.y4
    public void onSaveInstanceState(Bundle bundle) {
        MTicket mTicket = this.k;
        if (mTicket != null) {
            bundle.putParcelable("mticket_info", mTicket);
        }
        super.onSaveInstanceState(bundle);
    }
}
