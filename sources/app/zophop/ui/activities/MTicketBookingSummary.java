package app.zophop.ui.activities;

import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import app.zophop.R;
import app.zophop.models.Route;
import app.zophop.models.TransitMode;
import app.zophop.models.mTicketing.MTicket;
import app.zophop.models.mTicketing.ProductConfiguration;
import app.zophop.models.mTicketing.UserProfile;
import app.zophop.pubsub.eventbus.events.LiveRouteDetailsEvent;
import butterknife.ButterKnife;
import butterknife.InjectView;
import defpackage.xm0;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MTicketBookingSummary extends wt {
    public static final /* synthetic */ int n = 0;
    @InjectView(R.id.add_info_btn)
    public CardView _bookAgainBtn;
    @InjectView(R.id.btn_mticket_book_again)
    public TextView _btnBookMTicket;
    @InjectView(R.id.btn_view_mticket_trip_receipt)
    public CardView _btnViewTripReceipt;
    @InjectView(R.id.expiryImage)
    public ImageView _expiryImage;
    @InjectView(R.id.passBookingDate)
    public TextView _passBookingDate;
    @InjectView(R.id.passExpiryDetails)
    public TextView _ticketStatus;
    @InjectView(R.id.tv_booking_id)
    public TextView _tvBookingId;
    @InjectView(R.id.tv_passenger_total_fare)
    public TextView _tvPassengerTotalFare;
    @InjectView(R.id.tv_mticket_validity_banner)
    public TextView _tvValidityBanner;
    public MTicket l;
    public DialogFragment m;

    public class a implements View.OnClickListener {
        public final /* synthetic */ lm0 f;

        public a(MTicketBookingSummary mTicketBookingSummary, lm0 lm0) {
            this.f = lm0;
        }

        public void onClick(View view) {
            this.f.dismiss();
        }
    }

    public class b implements View.OnClickListener {
        public final /* synthetic */ lm0 f;

        public b(lm0 lm0) {
            this.f = lm0;
        }

        public void onClick(View view) {
            this.f.dismiss();
            jz5.b().o(this);
            Intent intent = new Intent(MTicketBookingSummary.this, MTicketTripInfoActivity.class);
            intent.putExtra("src", "booking summary mticket buy again");
            MTicketBookingSummary.this.startActivity(intent);
            MTicketBookingSummary.this.finish();
        }
    }

    public class c implements xm0.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f298a;
        public final /* synthetic */ Route b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ MTicket e;
        public final /* synthetic */ ProductConfiguration f;

        public c(String str, Route route, boolean z, Context context, MTicket mTicket, ProductConfiguration productConfiguration) {
            this.f298a = str;
            this.b = route;
            this.c = z;
            this.d = context;
            this.e = mTicket;
            this.f = productConfiguration;
        }

        @Override // defpackage.xm0.a
        public void a() {
            HashMap hashMap = new HashMap();
            hashMap.put("reason for disabled product dialog popup", this.f298a);
            hashMap.put("route name", this.b.getRouteId());
            int i = MTicketBookingSummary.n;
            ed1 ed1 = new ed1("recent product error dialog rendered mTicket", Long.MIN_VALUE);
            for (Map.Entry entry : hashMap.entrySet()) {
                ed1.a((String) entry.getKey(), entry.getValue());
            }
            jz5.b().g(ed1);
        }

        @Override // defpackage.xm0.a
        public void b() {
            if (this.c) {
                jz5.b().o(this);
                MTicketSelectionActivity.v0(this.d, this.b, this.e, TransitMode.bus, "booking summary mticket buy again", this.f.getProductId());
                MTicketBookingSummary.this.finish();
            }
        }
    }

    public static void i0(Context context, MTicket mTicket, String str) {
        Intent intent = new Intent(context, MTicketBookingSummary.class);
        intent.putExtra("extraMTicket", mTicket);
        intent.putExtra("src", str);
        context.startActivity(intent);
    }

    @Override // defpackage.tf1
    public void e(Bundle bundle) {
        this.l = (MTicket) getIntent().getParcelableExtra("extraMTicket");
        setContentView(R.layout.mticket_booking_summary_screen);
        ButterKnife.inject(this);
        this._tvPassengerTotalFare.setVisibility(8);
        boolean z = false;
        if (this.l.isMTicketExpired()) {
            this._bookAgainBtn.setVisibility(0);
            this._btnBookMTicket.setVisibility(0);
            this._btnBookMTicket.setText(getResources().getString(R.string.btn_txt_book_again));
        }
        fv0 fv0 = (fv0) getFragmentManager().findFragmentByTag("loader_tag");
        this.m = fv0;
        if (fv0 == null) {
            fv0 T = vn.T(null, getString(R.string.loading), false, false);
            this.m = T;
            T.setRetainInstance(true);
        }
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().o(true);
        MTicket mTicket = this.l;
        if (mTicket == null || mTicket.getMTicketConfiguration() == null) {
            getSupportActionBar().y(R.string.title_activity_mticket_details);
        } else {
            String id = this.l.getMTicketConfiguration().getId();
            if (!TextUtils.isEmpty(id)) {
                ProductConfiguration m0 = vn.m0(id);
                if (m0 != null) {
                    String productName = m0.getProductName();
                    if (TextUtils.isEmpty(productName)) {
                        getSupportActionBar().y(R.string.title_activity_mticket_details);
                    } else {
                        getSupportActionBar().z(productName);
                    }
                }
            } else {
                getSupportActionBar().y(R.string.title_activity_mticket_details);
            }
        }
        if (this.l.isMTicketExpired()) {
            this._btnBookMTicket.setOnClickListener(new he0(this));
        }
        this._btnViewTripReceipt.setOnClickListener(new ie0(this, this));
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.l.getStatus()) && this.l.getStatus().equals("FAILED")) {
            this._tvValidityBanner.setVisibility(8);
            this._expiryImage.setImageDrawable(getResources().getDrawable(R.drawable.payment_failed_ticket_summary));
            this._ticketStatus.setText(getResources().getString(R.string.failed));
        } else if (!TextUtils.isEmpty(this.l.getStatus()) && this.l.getStatus().equals("PENDING")) {
            this._tvValidityBanner.setVisibility(8);
            this._expiryImage.setImageDrawable(getResources().getDrawable(R.drawable.pending_ticket_summary));
            this._ticketStatus.setText(getResources().getString(R.string.processing));
        } else if (!this.l.isMTicketExpired()) {
            sb.append(getString(R.string.mticket_banner_valid_till));
            sb.append(" ");
            sb.append(jh1.f(this.l.getMTicketExpirationTime()).replace(",", "on"));
            this._expiryImage.setImageDrawable(getResources().getDrawable(R.drawable.active_ticket_summary));
            this._tvValidityBanner.setText(sb.toString());
            this._ticketStatus.setText(getResources().getString(R.string.ticket_active_status));
        } else {
            sb.append(getString(R.string.mticket_banner_expired_on));
            sb.append(" ");
            String replace = jh1.f(this.l.getMTicketUsedTime()).replace(",", "on");
            this._expiryImage.setImageDrawable(getResources().getDrawable(R.drawable.expired_ticket_summary));
            sb.append(replace);
            this._tvValidityBanner.setText(sb.toString());
            this._ticketStatus.setText(getResources().getString(R.string.ticket_expired_status));
        }
        this._tvBookingId.setText(this.l.getMTicketId());
        this._passBookingDate.setText(jh1.d(this.l.getBookingTime()));
        if (this.l.getPaymentMode() != null) {
            findViewById(R.id.payment_mode_container).setVisibility(0);
            ((TextView) findViewById(R.id.paymentMode)).setText(this.l.getPaymentMode());
        }
        ui1.x0(this, (TextView) findViewById(R.id.route_name), this.l.getUpTripRouteStopsInfo().getRouteName(), this.l.getUpTripRouteStopsInfo().getSpecialFeatures(), this.l.getUpTripRouteStopsInfo().get_spf());
        ((TextView) findViewById(R.id.tv_start_stop)).setText(this.l.getUpTripRouteStopsInfo().getStartStopName());
        ((TextView) findViewById(R.id.tv_end_stop)).setText(this.l.getUpTripRouteStopsInfo().getEndStopName());
        TextView textView = (TextView) findViewById(R.id.tv_passenger_details);
        StringBuilder sb2 = new StringBuilder();
        Iterator p0 = hj1.p0(this.l);
        boolean z2 = false;
        while (p0.hasNext()) {
            String str = (String) p0.next();
            if (z2) {
                sb2.append(", ");
            }
            sb2.append(this.l.getPassengerDetails().get(str).getPassengerCount());
            sb2.append(" ");
            sb2.append(xt.f3961a.c().F(str));
            z2 = true;
        }
        textView.setText(sb2.toString());
        ((LinearLayout) findViewById(R.id.fare_details)).addView(new za1(this, this.l));
        ed1 ed1 = new ed1("mticket summary details screen opened", Long.MIN_VALUE);
        if (this.l.getMTicketId() != null) {
            z = true;
        }
        ed1.a("ticketBooked", String.valueOf(z));
        if (getIntent().hasExtra("src")) {
            ed1.a("source", getIntent().getStringExtra("src"));
        }
        jz5.b().g(ed1);
    }

    public final void h0(String str, String str2, MTicket mTicket, String str3, boolean z, Context context, Route route, ProductConfiguration productConfiguration) {
        xm0.a(getFragmentManager(), context, new c(str3, route, z, context, mTicket, productConfiguration), MTicketBookingSummary.class.getSimpleName(), str2, str, false);
    }

    @Override // defpackage.tf1
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.report_problem_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void onEvent(LiveRouteDetailsEvent liveRouteDetailsEvent) {
        Route route;
        if (this.m.isVisible()) {
            this.m.dismiss();
        }
        jz5.b().m(liveRouteDetailsEvent);
        if (liveRouteDetailsEvent.getResponseType() == null) {
            Toast.makeText(this, getString(R.string.toast_generic_error_message), 0).show();
        } else if (!liveRouteDetailsEvent.getResponseType().equals(ad1.SUCCESS)) {
            Toast.makeText(this, getString(R.string.toast_generic_error_message), 0).show();
        } else if (this.l != null && liveRouteDetailsEvent.getRouteId().equals(this.l.getUpTripRouteStopsInfo().getRouteId()) && (route = liveRouteDetailsEvent.getRoute()) != null) {
            if (route.isMTicketEnabled()) {
                ProductConfiguration w0 = vn.w0(xt.f3961a.c().j0(this.l.getAgency().toLowerCase()));
                if (w0 == null) {
                    h0(getString(R.string.recent_products_not_available_dialog_title), getString(R.string.recent_products_not_available_dialog_copy), this.l, "product permanently disabled", false, this, null, null);
                    return;
                }
                Map i = vn.i(w0, this);
                if (i != null) {
                    h0((String) i.get("keyDialogTitle"), (String) i.get("keyDialogCopy"), this.l, (String) i.get("keyDialogReason"), false, this, route, w0);
                    return;
                }
                jz5.b().o(this);
                MTicketSelectionActivity.v0(this, route, this.l, TransitMode.bus, "booking summary mticket buy again", w0.getProductId());
                finish();
                return;
            }
            lm0 a2 = lm0.a(getFragmentManager(), getResources().getString(R.string.title_dialog_mticket_disabled_route), getResources().getString(R.string.msg_dialog_mticket_disabled_route, route.getRouteName()), getResources().getString(R.string.continue_dialog_mticket_disabled_route), getResources().getString(R.string.cancel_dialog_mticket_disabled_route));
            a aVar = new a(this, a2);
            TextView textView = a2.j;
            if (textView != null) {
                textView.setOnClickListener(aVar);
            } else {
                a2.r = aVar;
            }
            b bVar = new b(a2);
            TextView textView2 = a2.i;
            if (textView2 != null) {
                textView2.setOnClickListener(bVar);
            } else {
                a2.q = bVar;
            }
        }
    }

    @Override // defpackage.wt
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.report_problem_menu) {
            return false;
        }
        y20 R = xt.f3961a.R();
        HashMap hashMap = new HashMap();
        MTicket mTicket = this.l;
        if (mTicket != null) {
            if (mTicket.getCityName() != null) {
                hashMap.put("userPropertyCity", this.l.getCityName());
            }
            if (this.l.get_userProfile() != null) {
                UserProfile userProfile = this.l.get_userProfile();
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
            if (this.l.getAgency() != null) {
                hashMap.put("userPropertyAgencyName", this.l.getAgency());
            }
            if (this.l.getUpTripRouteStopsInfo() != null) {
                if (this.l.getUpTripRouteStopsInfo().getRouteId() != null) {
                    hashMap.put("userPropertyRouteId", this.l.getUpTripRouteStopsInfo().getRouteId());
                }
                if (this.l.getUpTripRouteStopsInfo().getRouteName() != null) {
                    hashMap.put("userPropertyRouteName", this.l.getUpTripRouteStopsInfo().getRouteName());
                }
            }
            if (this.l.getMTicketId() != null) {
                hashMap.put("userPropertyMTicketId", this.l.getMTicketId());
            }
            if (this.l.getOrderId() != null) {
                hashMap.put("userPropertyOrderId", this.l.getOrderId());
            }
        }
        R.b(this, "historyScreen", "mticketBookingSummaryScreen", hashMap, false);
        ed1 l2 = hj1.l("report problem clicked v2", Long.MIN_VALUE, "type", "otherTicketingProblemsV2");
        hj1.K0(l2, "problemSource", "mticketBookingSummaryScreen", l2);
        return true;
    }

    @Override // defpackage.f0, defpackage.ve, defpackage.au
    public void onStart() {
        super.onStart();
        jz5 b2 = jz5.b();
        b2.k(this, b2.e, true, 0);
    }

    @Override // defpackage.f0, defpackage.ve, defpackage.au
    public void onStop() {
        super.onStop();
        jz5.b().o(this);
    }
}
