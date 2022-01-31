package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import app.zophop.R;
import app.zophop.models.mTicketing.MTicketPassengerInfo;
import app.zophop.models.mTicketing.ProductCategory;
import app.zophop.models.mTicketing.ProductConfiguration;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.HashMap;

/* renamed from: cb1  reason: default package */
/* compiled from: MTicketPassengerDetailsView */
public class cb1 extends LinearLayout {
    public final Context f;
    public final a g;
    public ProductConfiguration h;
    public HashMap<String, MTicketPassengerInfo> i;
    public int j = getCount();
    public boolean k;

    /* renamed from: cb1$a */
    /* compiled from: MTicketPassengerDetailsView */
    public interface a {
    }

    public cb1(Context context, a aVar, ProductConfiguration productConfiguration, HashMap<String, MTicketPassengerInfo> hashMap, boolean z) {
        super(context);
        setOrientation(1);
        this.f = context;
        this.h = productConfiguration;
        this.g = aVar;
        this.i = hashMap;
        this.k = z;
        a();
    }

    private int getCount() {
        int i2 = 0;
        for (ProductCategory productCategory : this.h.getProductCategoryList()) {
            if (b(productCategory.getCategoryId())) {
                i2++;
            }
        }
        return i2;
    }

    public final void a() {
        removeAllViews();
        for (ProductCategory productCategory : this.h.getProductCategoryList()) {
            String categoryId = productCategory.getCategoryId();
            if (b(categoryId)) {
                View inflate = LayoutInflater.from(this.f).inflate(R.layout.mticket_select_passenger_item, (ViewGroup) this, false);
                LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.passenger_type_fare_layout);
                TextView textView = (TextView) inflate.findViewById(R.id.tv_passenger_fare);
                TextView textView2 = (TextView) inflate.findViewById(R.id.tv_passenger_discount_fare);
                TextView textView3 = (TextView) inflate.findViewById(R.id.tv_passenger_discount_percent);
                TextView textView4 = (TextView) inflate.findViewById(R.id.tv_count);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_decrement);
                ImageView imageView2 = (ImageView) inflate.findViewById(R.id.iv_increment);
                ProductCategory k0 = vn.k0(this.h.getProductCategoryList(), categoryId);
                ((TextView) inflate.findViewById(R.id.tv_passenger_type)).setText(xt.f3961a.c().F(k0.getCategoryId()));
                textView4.setText(String.valueOf(this.i.get(categoryId).getPassengerCount()));
                ((TextView) inflate.findViewById(R.id.tv_passenger_description)).setVisibility(8);
                if (!this.k) {
                    imageView2.setImageResource(R.drawable.add_ticket_disabled);
                    imageView.setImageResource(R.drawable.remove_ticket_disabled);
                    textView4.setTextColor(this.f.getResources().getColor(R.color.black_30));
                    linearLayout.setVisibility(8);
                } else if (b(categoryId)) {
                    int categoryMaxIssueCount = k0.getCategoryMaxIssueCount();
                    int passengerCount = this.i.get(categoryId).getPassengerCount();
                    if (passengerCount < categoryMaxIssueCount) {
                        imageView2.setOnClickListener(new ab1(this, categoryId));
                    } else {
                        imageView2.setImageResource(R.drawable.add_ticket_disabled);
                    }
                    int i2 = 1;
                    if (this.j != 1) {
                        i2 = 0;
                    }
                    if (passengerCount > i2) {
                        imageView.setOnClickListener(new bb1(this, categoryId));
                    } else {
                        imageView.setImageResource(R.drawable.remove_ticket_disabled);
                    }
                    textView4.setTextColor(this.f.getResources().getColor(R.color.black_87));
                    linearLayout.setVisibility(0);
                    double fare = this.i.get(categoryId).getFare();
                    textView2.setText(vn.M(fare - ((this.i.get(categoryId).getDiscountPercentage() * fare) / 100.0d)));
                    if (this.i.get(categoryId).getDiscountPercentage() != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                        textView.setText(vn.M(this.i.get(categoryId).getFare()));
                        textView.setPaintFlags(textView2.getPaintFlags() | 16);
                        textView3.setText(vn.f0(this.f, this.i.get(categoryId).getDiscountPercentage()));
                    } else {
                        textView.setVisibility(8);
                        textView3.setVisibility(8);
                    }
                } else {
                    imageView2.setImageResource(R.drawable.add_ticket_disabled);
                    imageView.setImageResource(R.drawable.remove_ticket_disabled);
                    textView4.setTextColor(this.f.getResources().getColor(R.color.black_30));
                    linearLayout.setVisibility(0);
                    textView2.setText(vn.M(this.i.get(categoryId).getDiscountFare()));
                    if (this.i.get(categoryId).getDiscountPercentage() != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                        textView.setText(vn.M(this.i.get(categoryId).getFare()));
                        textView.setPaintFlags(textView2.getPaintFlags() | 16);
                        textView3.setText(vn.f0(this.f, this.i.get(categoryId).getDiscountPercentage()));
                    } else {
                        textView.setVisibility(8);
                        textView3.setVisibility(8);
                    }
                }
                addView(inflate);
            }
        }
    }

    public final boolean b(String str) {
        return vn.k0(this.h.getProductCategoryList(), str).isCategoryActive();
    }

    public void c(ProductConfiguration productConfiguration, HashMap<String, MTicketPassengerInfo> hashMap, boolean z) {
        this.h = productConfiguration;
        this.i = hashMap;
        this.k = z;
        this.j = getCount();
        a();
    }
}
