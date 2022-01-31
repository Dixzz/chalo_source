package app.zophop.ui.utils;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import app.zophop.R;
import app.zophop.models.Route;
import app.zophop.models.Stop;
import app.zophop.models.Trip;
import app.zophop.models.mTicketing.ProductDiscountsObject;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.google.gson.Gson;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;
import defpackage.wd1;

public class FrequencyRouteHelper implements wd1.a {
    public static float B = 0.499f;
    public Route A;
    @InjectView(R.id.back_button_card)
    public CardView _backButtonCard;
    @InjectView(R.id.route_screen_back_v19)
    public ImageView _backButtonV19;
    @InjectView(R.id.route_header_back)
    public View _headerBackView;
    @InjectView(R.id.route_screen_options_container)
    public View _optionsMenu;
    @InjectView(R.id.sliding_layout)
    public SlidingUpPanelLayout _panelLayout;
    @InjectView(R.id.product_discount_card)
    public CardView _productDiscountCard;
    @InjectView(R.id.route_lists_container)
    public RelativeLayout _routeInfoContainer;
    @InjectView(R.id.bus_route_viewpager)
    public View _routeViewPager;
    @InjectView(R.id.txtRouteInfo)
    public TextView _route_info;
    @InjectView(R.id.towards_container)
    public View _towardsContainer;
    public final Route f;
    public Trip g;
    public final ve h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public final Stop o;
    public final Stop p;
    public final String q;
    public final String r;
    public final String s;
    public final String t;
    public final String u;
    public PopupMenu v;
    public boolean w;
    public boolean x;
    public boolean y;
    public ProductDiscountsObject z;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            FrequencyRouteHelper.this.a(false);
            SlidingUpPanelLayout.PanelState panelState = FrequencyRouteHelper.this._panelLayout.getPanelState();
            SlidingUpPanelLayout.PanelState panelState2 = SlidingUpPanelLayout.PanelState.EXPANDED;
            if (panelState.equals(panelState2)) {
                FrequencyRouteHelper.this._panelLayout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
            } else {
                FrequencyRouteHelper.this._panelLayout.setPanelState(panelState2);
            }
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            FrequencyRouteHelper.this._productDiscountCard.setClickable(false);
            String bookingType = FrequencyRouteHelper.this.z.getBookingType();
            int version = FrequencyRouteHelper.this.z.getVersion();
            ed1 ed1 = new ed1("discounts card clicked", Long.MIN_VALUE);
            ed1.a("productType", bookingType);
            ed1.a("version", Integer.valueOf(version));
            jz5.b().g(ed1);
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(FrequencyRouteHelper.this.z.getAction()));
                if (FrequencyRouteHelper.this.A != null) {
                    intent.putExtra("route_extra", new Gson().toJson(FrequencyRouteHelper.this.A));
                }
                FrequencyRouteHelper.this.h.startActivity(intent);
            } catch (Exception e) {
                e.getMessage();
                b00 b00 = b00.f358a;
                b00.a().b(e);
            }
        }
    }

    public interface c {
    }

    public FrequencyRouteHelper(ve veVar, Route route, Stop stop, Stop stop2) {
        this.h = veVar;
        this.f = route;
        this.o = stop;
        this.p = stop2;
        this.q = stop.getId();
        this.r = stop2.getId();
        this.s = route.getRouteId();
        this.t = route.getRouteName();
        this.u = stop.getId();
        B = Float.parseFloat(xt.f3961a.t().f("routeScreenSlidingPanelAnchorPoint"));
    }

    public final void a(boolean z2) {
        ProductDiscountsObject productDiscountsObject;
        if (!z2 || !this.y || (productDiscountsObject = this.z) == null || productDiscountsObject.getText() == null) {
            this._productDiscountCard.setVisibility(8);
            return;
        }
        this._productDiscountCard.setVisibility(0);
        ((TextView) this._productDiscountCard.findViewById(R.id.discount_text)).setText(vn.j(this.z.getText(), this.z.getHighlight(), this.h.getResources().getColor(R.color.orange_primary), false));
        if (this.z.getAction() != null) {
            this._productDiscountCard.setClickable(true);
            this._productDiscountCard.setOnClickListener(new b());
        } else {
            this._productDiscountCard.setClickable(false);
        }
        ImageView imageView = (ImageView) this._productDiscountCard.findViewById(R.id.discount_icon);
        if (this.z.isShowDiscountImage()) {
            imageView.setVisibility(0);
            if (this.z.getImageUrl() != null) {
                ml1<Drawable> p2 = gl1.g(this.h).p(this.z.getImageUrl());
                p2.a(new rs1().j(R.drawable.discount_route));
                p2.e(imageView);
                return;
            }
            return;
        }
        imageView.setVisibility(8);
    }

    public void b(boolean z2) {
        if (z2) {
            int measuredHeight = this._panelLayout.getMeasuredHeight() - this._towardsContainer.getMeasuredHeight();
            this._routeViewPager.setPadding(0, 0, 0, ((int) ((1.0f - B) * ((float) measuredHeight))) + 1);
        } else {
            this._routeViewPager.setPadding(0, 0, 0, 0);
            this._routeViewPager.setPadding(0, 0, 0, 0);
        }
        this._routeInfoContainer.invalidate();
    }

    @Override // defpackage.wd1.a
    public void b0() {
        this._panelLayout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
    }

    public void c() {
        this._panelLayout.c(new j61(this, this.h.getResources().getDimensionPixelSize(R.dimen.route_back_arrow_max_size)));
    }

    @Override // defpackage.wd1.a
    public void c0() {
        this._panelLayout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
    }

    public void d() {
        Bundle bundle;
        Fragment fragment;
        ButterKnife.inject(this, this.h);
        FragmentTransaction beginTransaction = this.h.getFragmentManager().beginTransaction();
        Gson gson = new Gson();
        if (this.g == null) {
            bundle = new Bundle();
            bundle.putString("busRoute", gson.toJson(this.f));
            bundle.putString("fromStop", this.j);
            bundle.putString("toStop", this.i);
            bundle.putString("streamInfo", this.k);
            bundle.putString("triggerOrigin", this.n);
            String str = this.l;
            if (str != null) {
                bundle.putString("triggerStop", str);
            }
            String str2 = this.m;
            if (str2 != null) {
                bundle.putString("triggerStop", str2);
            }
            bundle.putBoolean("isBoardingStopBasedOnLocation", this.w);
        } else {
            bundle = new Bundle();
            bundle.putString("extra_trip", gson.toJson(this.g));
            bundle.putString("stop_id", this.q);
            bundle.putString("end_stop_id", this.r);
            bundle.putString("routeid", this.s);
            bundle.putString("route_name", this.t);
            bundle.putString("trigger_origin", this.u);
        }
        if (this.g == null) {
            fragment = new mt0();
            fragment.setArguments(bundle);
        } else {
            fragment = new tw0();
            fragment.setArguments(bundle);
        }
        beginTransaction.add(R.id.bus_route_viewpager, fragment, "bus route fragment").commit();
        this._panelLayout.setAnchorPoint(B);
        this._route_info.setVisibility(8);
        this._towardsContainer.setOnClickListener(new a());
        this._backButtonCard.setVisibility(0);
        this._backButtonV19.setVisibility(8);
        this._backButtonCard.setCardElevation((float) this.h.getResources().getDimensionPixelOffset(R.dimen.back_button_elevation));
        this._backButtonCard.setOnClickListener(new m61(this));
        this._optionsMenu.setOnClickListener(new l61(this));
        this._panelLayout.getViewTreeObserver().addOnGlobalLayoutListener(new k61(this));
    }

    public FrequencyRouteHelper(ve veVar, Trip trip, String str, Stop stop, Stop stop2, String str2) {
        this.h = veVar;
        this.g = trip;
        this.f = ui1.G(trip, str, "");
        this.o = stop;
        this.p = stop2;
        this.q = stop.getId();
        this.r = stop2.getId();
        this.s = trip.get_routeId();
        this.t = str;
        this.u = str2;
        B = Float.parseFloat(xt.f3961a.t().f("routeScreenSlidingPanelAnchorPoint"));
    }
}
