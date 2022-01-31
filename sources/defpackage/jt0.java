package defpackage;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import app.zophop.R;
import app.zophop.models.ScanPayTicket;
import app.zophop.models.mTicketing.MPass;
import app.zophop.models.mTicketing.MTicket;
import app.zophop.models.mTicketing.ProductConfiguration;
import app.zophop.models.mTicketing.ProductDiscountsObject;
import app.zophop.models.mTicketing.RideDetails;
import app.zophop.models.mTicketing.UserProfile;
import app.zophop.room.ProductRepository;
import com.rabbitmq.client.ConnectionFactory;
import java.text.DecimalFormat;
import java.util.Iterator;

/* renamed from: jt0  reason: default package */
/* compiled from: BottomSheetFragment */
public class jt0 extends hl4 {
    public MTicket f;
    public MPass g;
    public ScanPayTicket h;
    public View i;
    public ProgressBar j;
    public ImageView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public TextView o;
    public RelativeLayout p;
    public LinearLayout q;
    public LinearLayout r;
    public LinearLayout s;
    public String t;
    public String u;
    public String v;
    public String w;
    public UserProfile x;
    public RideDetails y;

    /* renamed from: jt0$a */
    /* compiled from: BottomSheetFragment */
    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            jt0.this.dismiss();
        }
    }

    public final void d(Bitmap bitmap) {
        this.k.setImageBitmap(bitmap);
    }

    @Override // defpackage.ue, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.f = (MTicket) getArguments().getParcelable("mticket_info");
            this.g = (MPass) getArguments().getParcelable("mpass_info");
            this.h = (ScanPayTicket) getArguments().getParcelable("scanPay_info");
        }
        MTicket mTicket = this.f;
        if (mTicket != null) {
            this.x = mTicket.get_userProfile();
            return;
        }
        MPass mPass = this.g;
        if (mPass != null) {
            this.x = mPass.getUserProfile();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.bottom_sheet_ticket, viewGroup, false);
        this.i = inflate;
        inflate.findViewById(R.id.dismiss_btn).setOnClickListener(new a());
        this.j = (ProgressBar) this.i.findViewById(R.id.pass_profile_pic_progressbar);
        this.k = (ImageView) this.i.findViewById(R.id.profile_pic);
        this.l = (TextView) this.i.findViewById(R.id.profile_name);
        this.m = (TextView) this.i.findViewById(R.id.gender);
        this.n = (TextView) this.i.findViewById(R.id.dob);
        this.s = (LinearLayout) this.i.findViewById(R.id.route_container);
        this.o = (TextView) this.i.findViewById(R.id.amount_paid_val);
        this.p = (RelativeLayout) this.i.findViewById(R.id.scan_pay_container);
        this.q = (LinearLayout) this.i.findViewById(R.id.mticket_route_details);
        this.r = (LinearLayout) this.i.findViewById(R.id.passenger_count);
        return this.i;
    }

    @Override // defpackage.ue, androidx.fragment.app.Fragment
    public void onStart() {
        long j2;
        super.onStart();
        if (this.f != null) {
            ((TextView) this.i.findViewById(R.id.productName)).setText(vn.E(c(), this.f.getMTicketConfiguration().getId()));
            this.i.findViewById(R.id.route_stop_details_layout).setVisibility(0);
            this.q.setVisibility(0);
            ui1.x0(c(), (TextView) this.i.findViewById(R.id.route_name), this.f.getUpTripRouteStopsInfo().getRouteName(), this.f.getUpTripRouteStopsInfo().getSpecialFeatures(), this.f.getUpTripRouteStopsInfo().get_spf());
            ((TextView) this.i.findViewById(R.id.tv_start_stop)).setText(this.f.getUpTripRouteStopsInfo().getStartStopName());
            ((TextView) this.i.findViewById(R.id.tv_end_stop)).setText(this.f.getUpTripRouteStopsInfo().getEndStopName());
            this.i.findViewById(R.id.mticket_passenger_details).setVisibility(0);
            this.r.setVisibility(0);
            ((TextView) this.i.findViewById(R.id.tv_passenger_total_fare)).setVisibility(8);
            TextView textView = (TextView) this.i.findViewById(R.id.tv_passenger_details);
            StringBuilder sb = new StringBuilder();
            Iterator p0 = hj1.p0(this.f);
            boolean z = false;
            while (p0.hasNext()) {
                String str = (String) p0.next();
                if (z) {
                    sb.append(", ");
                }
                sb.append(this.f.getPassengerDetails().get(str).getPassengerCount());
                sb.append(" ");
                sb.append(xt.f3961a.c().F(str));
                z = true;
            }
            textView.setText(sb.toString());
        } else if (this.g != null) {
            ((TextView) this.i.findViewById(R.id.productName)).setText(vn.E(c(), this.g.getConfigId()));
        } else if (this.h != null) {
            ((TextView) this.i.findViewById(R.id.productName)).setText("Ticket");
            this.p.setVisibility(0);
            double d = this.h.get_discountedFare();
            DecimalFormat decimalFormat = new DecimalFormat("0.00");
            TextView textView2 = this.o;
            textView2.setText(ui1.H() + decimalFormat.format(d));
        }
        TextView textView3 = (TextView) this.i.findViewById(R.id.validity);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getString(R.string.mticket_booking_valid_till));
        sb2.append(" ");
        MTicket mTicket = this.f;
        if (mTicket != null) {
            j2 = mTicket.getMTicketExpirationTime();
        } else {
            MPass mPass = this.g;
            if (mPass != null) {
                j2 = mPass.getExpiryTime();
            } else {
                ScanPayTicket scanPayTicket = this.h;
                j2 = scanPayTicket != null ? scanPayTicket.get_expirationTime() : 0;
            }
        }
        sb2.append(jh1.f(j2));
        textView3.setText(sb2.toString().replace(",", getString(R.string.on)));
        if (this.x != null) {
            this.i.findViewById(R.id.profile_info_layout).setVisibility(0);
            this.t = this.x.getProfilePhoto();
            this.u = this.x.getFirstName() + " " + this.x.getLastName();
            this.v = getString(this.x.getGender().getResId());
            this.w = this.x.getDateOfBirth();
            if (this.t != null) {
                this.j.setVisibility(0);
                String str2 = this.t;
                ml1<Bitmap> j3 = gl1.g(c()).j();
                j3.m = str2;
                j3.p = true;
                j3.a(new rs1().q(50000));
                j3.f(new kt0(this, 0));
            }
            this.l.setText(this.u);
            this.m.setText(this.v);
            String str3 = this.w;
            if (str3.charAt(2) != '/') {
                StringBuilder sb3 = new StringBuilder();
                hj1.M0(this.w, 8, 10, sb3, ConnectionFactory.DEFAULT_VHOST);
                hj1.M0(this.w, 5, 7, sb3, ConnectionFactory.DEFAULT_VHOST);
                sb3.append(this.w.substring(0, 4));
                str3 = sb3.toString();
            }
            this.n.setText(ui1.w(str3));
        }
        MPass mPass2 = this.g;
        if (mPass2 == null || mPass2.getRouteStopsInfo() == null) {
            this.s.setVisibility(8);
            ((LinearLayout) this.i.findViewById(R.id.route_container_padding_layout)).setVisibility(8);
        } else {
            ((LinearLayout) this.i.findViewById(R.id.route_container_padding_layout)).setVisibility(0);
            this.s.setVisibility(0);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.g.getRouteStopsInfo().getRouteName());
            int i2 = 0;
            while (this.g.getSpecialFeatures() != null && i2 < this.g.getSpecialFeatures().size()) {
                if (this.g.getSpecialFeatures().contains("AC") || this.g.getSpecialFeatures().contains("FAST")) {
                    d71.b(c(), spannableStringBuilder, this.g.getSpecialFeatures().get(i2), true, R.color.real_time_fetching_string_color, hj1.V(this.g), R.color.white);
                } else {
                    d71.b(c(), spannableStringBuilder, this.g.getSpecialFeatures().get(i2), true, R.color.spf, hj1.V(this.g), R.color.black_87);
                }
                i2++;
            }
            ((TextView) this.s.findViewById(R.id.route_number)).setText(spannableStringBuilder);
            this.s.findViewById(R.id.edit_route_pass).setVisibility(8);
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(this.g.getRouteStopsInfo().getStartStopName() + " ");
            spannableStringBuilder2.append((CharSequence) ProductDiscountsObject.KEY_DELIMITER);
            Drawable drawable = getResources().getDrawable(R.drawable.direction_route);
            drawable.setBounds(0, 0, getResources().getDimensionPixelSize(R.dimen.route_bidirectional_icon_size), getResources().getDimensionPixelSize(R.dimen.route_bidirectional_icon_size));
            spannableStringBuilder2.setSpan(new ImageSpan(drawable, 1), spannableStringBuilder2.length() - 1, spannableStringBuilder2.length(), 17);
            spannableStringBuilder2.append((CharSequence) (" " + this.g.getRouteStopsInfo().getEndStopName()));
            ((TextView) this.s.findViewById(R.id.route_details)).setText(spannableStringBuilder2);
        }
        MPass mPass3 = this.g;
        if (mPass3 != null && mPass3.get_productType() != null && this.g.get_productType().equals("superSaver")) {
            this.y = new ProductRepository(c()).fetchRidedetails(this.g.getBookingPassId());
            this.i.findViewById(R.id.trip_details).setVisibility(0);
            this.i.findViewById(R.id.max_fare_divider).setVisibility(0);
            this.i.findViewById(R.id.max_fare_info).setVisibility(0);
            ((TextView) this.i.findViewById(R.id.max_fare_info).findViewById(R.id.trip_heading)).setText(getString(R.string.maxFareCopy));
            ((TextView) this.i.findViewById(R.id.trip_details).findViewById(R.id.trip_heading)).setText(getString(R.string.trips_remaining));
            TextView textView4 = (TextView) this.i.findViewById(R.id.max_fare_info).findViewById(R.id.trip_count);
            StringBuilder i0 = hj1.i0("Upto ");
            i0.append(ui1.H());
            hj1.T0(i0, this.g.get_maxTripsPrice() == -1 ? this.g.get_grouping().get_maxPricePerRide() : this.g.get_maxTripsPrice(), textView4);
            ((TextView) this.i.findViewById(R.id.trip_details).findViewById(R.id.trip_count)).setText(String.valueOf(this.g.get_maxTrips() - vn.B0(this.y, this.g.getPunches())));
            ProductConfiguration m0 = vn.m0(this.g.getConfigId());
            if (m0 != null && m0.shouldHideSubCategorySelection()) {
                this.i.findViewById(R.id.max_fare_divider).setVisibility(8);
                this.i.findViewById(R.id.max_fare_info).setVisibility(8);
            }
        }
    }
}
