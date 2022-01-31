package app.zophop.ui.views;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import app.zophop.R;
import app.zophop.models.mTicketing.BookingItem;
import app.zophop.models.mTicketing.BookingItemType;
import app.zophop.models.mTicketing.MPass;
import app.zophop.models.mTicketing.MTicket;
import app.zophop.models.mTicketing.ProductConfiguration;
import app.zophop.models.mTicketing.RouteStopsInfo;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Iterator;

public class RecentProductItemView extends LinearLayout {
    @InjectView(R.id.tv_end_stop)
    public TextView _endStop;
    @InjectView(R.id.fare)
    public TextView _fare;
    @InjectView(R.id.mpass_linearlayout)
    public LinearLayout _mpassLinearLayout;
    @InjectView(R.id.route_details_mpass)
    public TextView _mpassRouteDetails;
    @InjectView(R.id.mpass_route_name)
    public TextView _mpassRouteNumber;
    @InjectView(R.id.mticket_constraintlayout)
    public ConstraintLayout _mticketConstraintLayout;
    @InjectView(R.id.mticket_route_name_layout)
    public LinearLayout _mticketRouteNamelayout;
    @InjectView(R.id.mticket_route_name)
    public TextView _mticketRouteNumber;
    @InjectView(R.id.pass_type_title)
    public TextView _passType;
    @InjectView(R.id.passenger_details)
    public TextView _passengerDetails;
    @InjectView(R.id.tv_start_stop)
    public TextView _startStop;
    public Context f;
    public BookingItem g;

    public RecentProductItemView(Context context, BookingItem bookingItem) {
        super(context);
        this.f = context;
        this.g = bookingItem;
        LayoutInflater.from(getContext()).inflate(R.layout.recent_product_item, (ViewGroup) this, true);
        ButterKnife.inject(this, this);
        int i = 8;
        if (this.g.getBookingItemType() == BookingItemType.MAGIC_PASS) {
            this._mticketConstraintLayout.setVisibility(8);
            this._mticketRouteNamelayout.setVisibility(8);
            MPass magicPass = this.g.getMagicPass();
            ProductConfiguration m0 = vn.m0(magicPass.getConfigId());
            this._passType.setText(!TextUtils.isEmpty(magicPass.get_productName()) ? magicPass.get_productName() : m0 != null ? m0.getProductName() : "Pass");
            this._fare.setText(vn.M(magicPass.getFare()));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(ui1.j(magicPass.getNoOfDays() + ""));
            if (magicPass.getSpecialFeatures() == null || magicPass.getSpecialFeatures().size() == 0 || magicPass.getRouteStopsInfo() != null) {
                spannableStringBuilder.append((CharSequence) ",");
                spannableStringBuilder.append((CharSequence) " ");
            } else {
                spannableStringBuilder.append((CharSequence) ",");
                spannableStringBuilder.append((CharSequence) ui1.J(this.f, magicPass.getSpecialFeatures()));
                spannableStringBuilder.append((CharSequence) " ");
                spannableStringBuilder.append((CharSequence) " ");
            }
            if (magicPass.get_productType() == null || !magicPass.get_productType().equals("superSaver")) {
                spannableStringBuilder.append((CharSequence) xt.f3961a.c().F(magicPass.getPassengerType()));
                spannableStringBuilder.append((CharSequence) " Category");
            } else if (magicPass.get_grouping() != null) {
                StringBuilder i0 = hj1.i0("Upto ");
                i0.append(ui1.H());
                i0.append(magicPass.get_maxTripsPrice() == -1 ? magicPass.get_grouping().get_maxPricePerRide() : magicPass.get_maxTripsPrice());
                spannableStringBuilder.append((CharSequence) i0.toString());
            }
            this._passengerDetails.setText(spannableStringBuilder);
            if (magicPass.getRouteStopsInfo() != null) {
                RouteStopsInfo routeStopsInfo = magicPass.getRouteStopsInfo();
                this._mpassRouteDetails.setText(routeStopsInfo.getStartStopName() + " - " + routeStopsInfo.getEndStopName());
                this._mpassRouteNumber.setText(routeStopsInfo.getRouteName());
                findViewById(R.id.route_pass_special_info).setVisibility(magicPass.getSpecialFeatures() != null ? 0 : i);
                ((TextView) findViewById(R.id.route_pass_special_info)).setText(new SpannableStringBuilder(ui1.J(this.f, magicPass.getSpecialFeatures())));
                return;
            }
            this._mpassLinearLayout.setVisibility(8);
        } else if (this.g.getBookingItemType() == BookingItemType.MTICKET) {
            MTicket mTicket = this.g.getMTicket();
            this._mpassLinearLayout.setVisibility(8);
            this._startStop.setText(mTicket.getUpTripRouteStopsInfo().getStartStopName());
            this._endStop.setText(mTicket.getUpTripRouteStopsInfo().getEndStopName());
            double totalFare = mTicket.getTotalFare();
            if (totalFare != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                this._fare.setText(vn.M(totalFare));
            } else {
                this._fare.setVisibility(8);
            }
            this._passType.setText(R.string.tag_text_ticket_type);
            StringBuilder sb = new StringBuilder();
            Boolean bool = Boolean.FALSE;
            Iterator p0 = hj1.p0(mTicket);
            while (p0.hasNext()) {
                String str = (String) p0.next();
                if (bool.booleanValue()) {
                    sb.append(",");
                }
                sb.append(mTicket.getPassengerDetails().get(str).getPassengerCount());
                sb.append(" ");
                sb.append(xt.f3961a.c().F(str));
                bool = Boolean.TRUE;
            }
            this._passengerDetails.setText(sb.toString());
            ui1.x0(this.f, this._mticketRouteNumber, mTicket.getUpTripRouteStopsInfo().getRouteName(), mTicket.getUpTripRouteStopsInfo().getSpecialFeatures(), mTicket.getUpTripRouteStopsInfo().get_spf());
        }
    }
}
