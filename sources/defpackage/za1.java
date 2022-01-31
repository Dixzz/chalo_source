package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import app.zophop.R;
import app.zophop.models.mTicketing.MTicket;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: za1  reason: default package */
/* compiled from: MTicketFareDetailsView */
public class za1 extends LinearLayout {
    public final Context f;
    public final MTicket g;

    public za1(Context context, MTicket mTicket) {
        super(context);
        setOrientation(1);
        this.f = context;
        this.g = mTicket;
        Iterator p0 = hj1.p0(mTicket);
        while (p0.hasNext()) {
            String str = (String) p0.next();
            int passengerCount = this.g.getPassengerDetails().get(str).getPassengerCount();
            double fare = this.g.getPassengerDetails().get(str).getFare();
            View inflate = LayoutInflater.from(this.f).inflate(R.layout.mticket_fare_details_item, (ViewGroup) this, false);
            ((TextView) inflate.findViewById(R.id.tv_passenger_count)).setText(passengerCount + " " + "X" + " " + vn.M(fare));
            ((TextView) inflate.findViewById(R.id.tv_passenger_type)).setText(xt.f3961a.c().F(str));
            ((TextView) inflate.findViewById(R.id.tv_passenger_fare)).setText(vn.M(((double) passengerCount) * fare));
            addView(inflate);
        }
        View inflate2 = LayoutInflater.from(this.f).inflate(R.layout.mticket_fare_details_item, (ViewGroup) this, false);
        hj1.x0(inflate2, R.id.passenger_fare_details_item, 8, R.id.passenger_total_fare_details_item, 0);
        LinearLayout linearLayout = (LinearLayout) inflate2.findViewById(R.id.detailed_fare_breakage);
        ((TextView) inflate2.findViewById(R.id.tv_total_fare)).setText(vn.M(this.g.getTotalFare()));
        HashMap hashMap = new HashMap();
        if (this.g.getTotalDiscountAmount() != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            inflate2.findViewById(R.id.passenger_discount_fare_details_item).setVisibility(0);
            ((TextView) inflate2.findViewById(R.id.tv_discount_fare)).setText(getContext().getString(R.string.txt_minus) + " " + vn.M(this.g.getTotalDiscountAmount()));
        } else {
            inflate2.findViewById(R.id.passenger_discount_fare_details_item).setVisibility(8);
        }
        Iterator p02 = hj1.p0(this.g);
        while (p02.hasNext()) {
            String str2 = (String) p02.next();
            Map<String, Double> map = this.g.getPassengerDetails().get(str2).get_addMap();
            int passengerCount2 = this.g.getPassengerDetails().get(str2).getPassengerCount();
            if (map != null) {
                for (String str3 : map.keySet()) {
                    if (hashMap.containsKey(str3)) {
                        double doubleValue = ((Double) hashMap.get(str3)).doubleValue();
                        hashMap.remove(str3);
                        hashMap.put(str3, Double.valueOf(map.get(str3).doubleValue() + doubleValue));
                    } else {
                        hashMap.put(str3, Double.valueOf(map.get(str3).doubleValue() * ((double) passengerCount2)));
                    }
                }
            }
            Map<String, Double> map2 = this.g.getPassengerDetails().get(str2).get_subMap();
            if (map2 != null) {
                for (String str4 : map2.keySet()) {
                    if (hashMap.containsKey(str4)) {
                        hashMap.remove(str4);
                        hashMap.put(str4, Double.valueOf(((Double) hashMap.get(str4)).doubleValue() - map2.get(str4).doubleValue()));
                    } else {
                        hashMap.put(str4, Double.valueOf(map2.get(str4).doubleValue() * -1.0d * ((double) passengerCount2)));
                    }
                }
            }
        }
        for (String str5 : hashMap.keySet()) {
            ya1 ya1 = new ya1(this.f, str5, ((Double) hashMap.get(str5)).doubleValue());
            ya1.setVisibility(0);
            linearLayout.addView(ya1);
        }
        addView(inflate2);
    }
}
