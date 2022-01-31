package defpackage;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import app.zophop.R;
import app.zophop.alarm.SubscriberAlarm;
import app.zophop.models.Favourites.BusFavourite;
import app.zophop.models.Favourites.Favourite;
import app.zophop.models.Favourites.RailFavourite;
import app.zophop.models.Favourites.RecentTrips;
import app.zophop.models.Favourites.RouteStoreType;
import app.zophop.models.Favourites.StopFavourite;
import app.zophop.models.RouteInfo;
import app.zophop.models.Stop;
import app.zophop.models.TransitMode;
import app.zophop.ui.activities.TripPlanningActivity;
import app.zophop.ui.activities.TripPlanningStopBasedActivity;
import app.zophop.ui.activities.UniversalPickerActivity;
import com.google.firebase.messaging.Constants;
import defpackage.xt;
import io.github.inflationx.calligraphy3.CalligraphyUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* renamed from: bj0  reason: default package */
/* compiled from: FavoriteListAdapter */
public class bj0 extends BaseAdapter {
    public final List<k> f;
    public final Context g;
    public final LayoutInflater h;
    public final TransitMode i;
    public final xh1 j;
    public final f80 k;
    public final ci1<Favourite> l;
    public final String m;
    public final RouteStoreType n;
    public final ci1<Stop> o;
    public final ci1<Stop> p;
    public boolean q;
    public final ci1<Favourite> r = new b();
    public final ci1<Favourite> s = new c();

    /* renamed from: bj0$a */
    /* compiled from: FavoriteListAdapter */
    public class a implements View.OnClickListener {
        public final /* synthetic */ rg1 f;
        public final /* synthetic */ View.OnClickListener g;

        public a(rg1 rg1, View.OnClickListener onClickListener) {
            this.f = rg1;
            this.g = onClickListener;
        }

        public void onClick(View view) {
            bj0 bj0 = bj0.this;
            ImageView settingsIconView = this.f.getSettingsIconView();
            View.OnClickListener onClickListener = this.g;
            int dimensionPixelSize = bj0.g.getResources().getDimensionPixelSize(R.dimen.favorite_edit_pop_up_width);
            View inflate = LayoutInflater.from(bj0.g).inflate(R.layout.fav_pop_up, (ViewGroup) null, false);
            PopupWindow popupWindow = new PopupWindow(bj0.g);
            popupWindow.setContentView(inflate);
            popupWindow.setWidth(dimensionPixelSize);
            popupWindow.setHeight(-2);
            popupWindow.setFocusable(true);
            popupWindow.setBackgroundDrawable(new BitmapDrawable());
            popupWindow.showAsDropDown(settingsIconView, 0, 0);
            inflate.setOnClickListener(new cj0(bj0, onClickListener, settingsIconView, popupWindow));
        }
    }

    /* renamed from: bj0$b */
    /* compiled from: FavoriteListAdapter */
    public class b implements ci1<Favourite> {
        public b() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.ci1
        public void a(Favourite favourite) {
            Favourite favourite2 = favourite;
            bj0 bj0 = bj0.this;
            Objects.requireNonNull(bj0);
            ed1 ed1 = new ed1("favorite clicked", Long.MAX_VALUE);
            ed1.a("mode", favourite2.getMode().name());
            ed1.a("source", bj0.m);
            if (favourite2 instanceof RailFavourite) {
                RailFavourite railFavourite = (RailFavourite) favourite2;
                ed1.a(Constants.MessagePayloadKeys.FROM, railFavourite.getFromStop().getName());
                ed1.a("to", railFavourite.getToStop().getName());
            } else {
                BusFavourite busFavourite = (BusFavourite) favourite2;
                ed1.a("route", busFavourite.getRouteName());
                ed1.a(Constants.MessagePayloadKeys.FROM, busFavourite.getStartStopName());
                ed1.a("to", busFavourite.getEndStopName());
            }
            jz5.b().g(ed1);
            ((c80) bj0.this.k).n(favourite2);
            ci1<Favourite> ci1 = bj0.this.l;
            if (ci1 != null) {
                ci1.a(favourite2);
            }
        }
    }

    /* renamed from: bj0$c */
    /* compiled from: FavoriteListAdapter */
    public class c implements ci1<Favourite> {
        public c() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.ci1
        public void a(Favourite favourite) {
            Favourite favourite2 = favourite;
            Toast.makeText(bj0.this.g, (int) R.string.fav_removed, 1).show();
            SubscriberAlarm.d(bj0.this.g, favourite2);
            bj0 bj0 = bj0.this;
            ((c80) bj0.k).r(favourite2, bj0.n);
            bj0 bj02 = bj0.this;
            bj02.l();
            bj02.notifyDataSetChanged();
            Objects.requireNonNull(bj0.this);
        }
    }

    /* renamed from: bj0$d */
    /* compiled from: FavoriteListAdapter */
    public class d implements View.OnClickListener {
        public final /* synthetic */ ImageView f;
        public final /* synthetic */ mf1 g;

        public d(ImageView imageView, mf1 mf1) {
            this.f = imageView;
            this.g = mf1;
        }

        public void onClick(View view) {
            bj0 bj0 = bj0.this;
            ImageView imageView = this.f;
            mf1 mf1 = this.g;
            View inflate = bj0.h.inflate(R.layout.favorite_edit_pop_up, (ViewGroup) null, false);
            Context context = bj0.g;
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.favorite_edit_pop_up_width);
            PopupWindow popupWindow = new PopupWindow(context);
            popupWindow.setContentView(inflate);
            popupWindow.setWidth(dimensionPixelSize);
            popupWindow.setHeight(-2);
            popupWindow.setFocusable(true);
            popupWindow.setBackgroundDrawable(new BitmapDrawable());
            popupWindow.setSoftInputMode(3);
            popupWindow.showAsDropDown(imageView, 0, 0);
            inflate.findViewById(R.id.remove).setOnClickListener(new fj0(bj0, mf1, popupWindow));
            inflate.findViewById(R.id.edit).setOnClickListener(new gj0(bj0, popupWindow, mf1));
        }
    }

    /* renamed from: bj0$e */
    /* compiled from: FavoriteListAdapter */
    public class e implements View.OnClickListener {
        public final /* synthetic */ mf1 f;

        public e(bj0 bj0, mf1 mf1) {
            this.f = mf1;
        }

        public void onClick(View view) {
            xt.f3961a.Y().l(this.f);
        }
    }

    /* renamed from: bj0$f */
    /* compiled from: FavoriteListAdapter */
    public class f implements View.OnClickListener {
        public final /* synthetic */ BusFavourite f;

        public f(BusFavourite busFavourite) {
            this.f = busFavourite;
        }

        public void onClick(View view) {
            xt.f3961a.r().e(this.f);
            bj0.this.r.a(this.f);
        }
    }

    /* renamed from: bj0$g */
    /* compiled from: FavoriteListAdapter */
    public class g implements View.OnClickListener {
        public final /* synthetic */ RouteInfo f;

        public g(bj0 bj0, RouteInfo routeInfo) {
            this.f = routeInfo;
        }

        public void onClick(View view) {
            xt.t1 t1Var = xt.f3961a;
            c80 r = t1Var.r();
            String routeId = this.f.getRouteId();
            RouteStoreType routeStoreType = RouteStoreType.RECENT;
            t1Var.r().r(r.h(routeId, routeStoreType), routeStoreType);
        }
    }

    /* renamed from: bj0$h */
    /* compiled from: FavoriteListAdapter */
    public class h implements View.OnClickListener {
        public final /* synthetic */ StopFavourite f;
        public final /* synthetic */ Stop g;

        public h(StopFavourite stopFavourite, Stop stop) {
            this.f = stopFavourite;
            this.g = stop;
        }

        public void onClick(View view) {
            ci1<Stop> ci1;
            xt.f3961a.b0().b(this.f);
            if (ui1.e0()) {
                bj0 bj0 = bj0.this;
                ci1<Stop> ci12 = bj0.o;
                if (!(ci12 == null || (ci1 = bj0.p) == null)) {
                    if (bj0.q) {
                        ci12.a(this.g);
                    } else {
                        ci1.a(this.g);
                    }
                }
                bj0.a(bj0.this, this.g, "stop based trip planning");
                return;
            }
            TripPlanningActivity.m0((Activity) bj0.this.g, null, new mf1(this.g.getName(), this.g.getLatLong()), false);
            bj0.a(bj0.this, this.g, "universal search");
        }
    }

    /* renamed from: bj0$i */
    /* compiled from: FavoriteListAdapter */
    public class i implements View.OnClickListener {
        public final /* synthetic */ Stop f;

        public i(bj0 bj0, Stop stop) {
            this.f = stop;
        }

        public void onClick(View view) {
            xt.f3961a.b0().a(this.f);
        }
    }

    /* renamed from: bj0$j */
    /* compiled from: FavoriteListAdapter */
    public enum j {
        HOME,
        WORK,
        FAVORITE,
        RECENT
    }

    /* renamed from: bj0$l */
    /* compiled from: FavoriteListAdapter */
    public enum l {
        SET_HOME,
        SET_WORK,
        FAVORITE_LOCATION,
        RECENT_LOCATION,
        FAVORITE_LOCATION_STRING,
        FAVORITE_ROUTE_STRING,
        FAVORITE_RECENT_STRING,
        FAVORITE_ROUTE,
        DIVIDER,
        CARD_DIVIDER,
        FAVORITE_ITEM_STOP,
        RECENT_TRIP,
        POPULAR_ROUTE_TITLE,
        POPULAR_ROUTE
    }

    public bj0(Context context, TransitMode transitMode, ci1<Favourite> ci1, xh1 xh1, ci1<Stop> ci12, ci1<Stop> ci13, RouteStoreType routeStoreType, String str) {
        this.g = context;
        this.h = LayoutInflater.from(context);
        this.i = transitMode;
        this.l = ci1;
        this.k = xt.f3961a.r();
        this.j = xh1;
        this.o = ci12;
        this.p = ci13;
        this.f = new ArrayList();
        this.m = str;
        this.n = routeStoreType;
        l();
    }

    public static void a(bj0 bj0, Stop stop, String str) {
        Objects.requireNonNull(bj0);
        if (str.equalsIgnoreCase("stop based trip planning")) {
            ed1 ed1 = new ed1("stopBased tripPlanner recent stop clicked", Long.MIN_VALUE);
            ed1.a("stop name", stop.getName());
            ed1.a("stop id", stop.getId());
            ed1.a("source", str);
            TripPlanningStopBasedActivity.w0(ed1, "stop", vn.K0(bj0.g), null, true, false);
            return;
        }
        ed1 ed12 = new ed1("universal item clicked", Long.MIN_VALUE);
        ed12.a("stop name", stop.getName());
        ed12.a("stop id", stop.getId());
        ed12.a("source", str);
        UniversalPickerActivity.l0(ed12, "stop", vn.K0(bj0.g), null, true, false);
    }

    public static void b(bj0 bj0, String str, String str2, String str3, String str4) {
        Objects.requireNonNull(bj0);
        if (str4.equalsIgnoreCase("stop based trip planning")) {
            ed1 l2 = hj1.l("stopBased tripPlanner recent stop clicked", Long.MIN_VALUE, "agency", str);
            l2.a("route name", str2);
            l2.a("origin stop", str3);
            l2.a("source", str4);
            TripPlanningStopBasedActivity.w0(l2, "stop", vn.K0(bj0.g), null, true, false);
            return;
        }
        ed1 l3 = hj1.l("universal item clicked", Long.MIN_VALUE, "agency", str);
        l3.a("route name", str2);
        l3.a("origin stop", str3);
        l3.a("source", str4);
        UniversalPickerActivity.l0(l3, "route", vn.K0(bj0.g), null, false, true);
    }

    public int c(j jVar) {
        int ordinal = jVar.ordinal();
        if (ordinal == 0) {
            return R.drawable.favorite_home;
        }
        if (ordinal != 1) {
            return ordinal != 2 ? R.drawable.location_search : R.drawable.favorite_added;
        }
        return R.drawable.favorite_work;
    }

    public rg1 d(mf1 mf1) {
        rg1 rg1 = new rg1(this.g);
        ImageView settingsIconView = rg1.getSettingsIconView();
        settingsIconView.setOnClickListener(new d(settingsIconView, mf1));
        rg1.setBackgroundResource(R.drawable.item_selector);
        return rg1;
    }

    public final View e(mf1 mf1) {
        CharSequence charSequence;
        CharSequence charSequence2;
        rg1 d2 = d(mf1);
        String str = mf1.c;
        CharSequence charSequence3 = mf1.b;
        if (this.n.equals(RouteStoreType.RECENT)) {
            int indexOf = str.indexOf(",");
            if (indexOf != -1) {
                charSequence = str.substring(0, indexOf).trim();
                charSequence2 = str.substring(indexOf + 1).trim();
            } else {
                charSequence = str.trim();
                charSequence2 = null;
            }
            d2.b(charSequence, charSequence2, c(j.RECENT), R.drawable.favorite_overflow);
            ((LinearLayout.LayoutParams) d2.getSettingsIconView().getLayoutParams()).gravity = 48;
            j(d2, new e(this, mf1));
        } else {
            d2.b(str, charSequence3, c(j.FAVORITE), R.drawable.favorite_overflow);
            d2.getSettingsIconView().setPadding(this.g.getResources().getDimensionPixelSize(R.dimen.favorite_overflow_side_padding), this.g.getResources().getDimensionPixelSize(R.dimen.favorite_overflow_top_padding), this.g.getResources().getDimensionPixelSize(R.dimen.favorite_overflow_side_padding), this.g.getResources().getDimensionPixelSize(R.dimen.favorite_empty_list_top_padding));
            k(d2.findViewById(R.id.settings_icon));
        }
        d2.setOnClickListener(new ej0(this, mf1));
        return d2;
    }

    public View f(ViewGroup viewGroup, mf1 mf1, l lVar) {
        String str;
        int i2;
        rg1 d2 = d(mf1);
        String str2 = mf1.b;
        if (lVar.equals(l.SET_HOME)) {
            str = this.g.getString(R.string.saved_destination_dialog_home);
            i2 = c(j.HOME);
        } else {
            str = this.g.getString(R.string.saved_destination_dialog_work);
            i2 = c(j.WORK);
        }
        if (mf1.b == null || mf1.f2368a == null) {
            View inflate = this.h.inflate(R.layout.favorite_list_recent, viewGroup, false);
            TextView textView = (TextView) inflate.findViewById(R.id.item_description);
            textView.setCompoundDrawablesWithIntrinsicBounds(i2, 0, 0, 0);
            textView.setPadding(this.g.getResources().getDimensionPixelSize(R.dimen.favorite_set_homework_left_padding), this.g.getResources().getDimensionPixelSize(R.dimen.favorite_set_homework_top_padding), 0, this.g.getResources().getDimensionPixelSize(R.dimen.favorite_set_homework_top_padding));
            inflate.setAlpha(0.15f);
            i(textView, this.g.getString(R.string.favorite_saving_data));
            return inflate;
        }
        d2.b(str, str2, i2, R.drawable.favorite_overflow);
        d2.getSettingsIconView().setPadding(this.g.getResources().getDimensionPixelSize(R.dimen.favorite_overflow_side_padding), this.g.getResources().getDimensionPixelSize(R.dimen.favorite_overflow_top_padding), this.g.getResources().getDimensionPixelSize(R.dimen.favorite_overflow_side_padding), this.g.getResources().getDimensionPixelSize(R.dimen.favorite_empty_list_top_padding));
        i(d2.getTitleView(), str);
        d2.setOnClickListener(new ej0(this, mf1));
        k(d2.findViewById(R.id.settings_icon));
        return d2;
    }

    public View g(ViewGroup viewGroup, l lVar) {
        String str;
        int i2;
        View inflate = this.h.inflate(R.layout.favorite_list_recent, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.item_description);
        if (lVar.equals(l.SET_HOME)) {
            str = this.g.getString(R.string.favorite_set_home);
            i2 = c(j.HOME);
            inflate.setOnClickListener(new dj0(this, 0));
        } else {
            str = this.g.getString(R.string.favorite_set_work);
            i2 = c(j.WORK);
            inflate.setOnClickListener(new dj0(this, 1));
        }
        i(textView, str);
        textView.setCompoundDrawablesWithIntrinsicBounds(i2, 0, 0, 0);
        textView.setPadding(this.g.getResources().getDimensionPixelSize(R.dimen.favorite_set_homework_left_padding), this.g.getResources().getDimensionPixelSize(R.dimen.favorite_set_homework_top_padding), 0, this.g.getResources().getDimensionPixelSize(R.dimen.favorite_set_homework_top_padding));
        return inflate;
    }

    public int getCount() {
        return this.f.size();
    }

    public Object getItem(int i2) {
        return this.f.get(i2);
    }

    public long getItemId(int i2) {
        return 0;
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        k kVar = this.f.get(i2);
        int i3 = 0;
        String str = null;
        switch (this.f.get(i2).f438a.ordinal()) {
            case 0:
                mf1 mf1 = kVar.c;
                if (mf1 == null) {
                    return g(viewGroup, l.SET_HOME);
                }
                return f(viewGroup, mf1, l.SET_HOME);
            case 1:
                mf1 mf12 = kVar.c;
                if (mf12 == null) {
                    return g(viewGroup, l.SET_WORK);
                }
                return f(viewGroup, mf12, l.SET_WORK);
            case 2:
                return e(kVar.c);
            case 3:
                return e(kVar.d.f2797a);
            case 4:
                return h(viewGroup, this.g.getString(R.string.Locations));
            case 5:
                return h(viewGroup, this.g.getString(R.string.Routes));
            case 6:
                TextView textView = (TextView) this.h.inflate(R.layout.universal_recent_view, viewGroup, false);
                textView.setText(this.g.getString(R.string.Recent_searches));
                return textView;
            case 7:
                if (this.n.equals(RouteStoreType.RECENT)) {
                    BusFavourite busFavourite = (BusFavourite) kVar.b;
                    RouteInfo routeInfo = new RouteInfo(busFavourite.getRouteId(), TransitMode.bus, busFavourite.getRouteName(), busFavourite.getStartStopName(), busFavourite.getEndStopName(), busFavourite.getEndStopName(), busFavourite.getAgency(), new ArrayList(), busFavourite.get_spfList(), null, false, false, false, false, "");
                    Context context = this.g;
                    boolean Y = ui1.Y();
                    rg1 rg1 = new rg1(context);
                    CharSequence j2 = vn.j(routeInfo.getRouteName(), null, context.getResources().getColor(R.color.view_schedule_color), false);
                    String str2 = routeInfo.getFirstStopName() + " - " + routeInfo.getLastStopName();
                    if (routeInfo.getAgencyName() != null) {
                        str = routeInfo.getAgencyName().toUpperCase();
                    }
                    rg1.c(j2, str2, R.drawable.bus_route_location_search, null, ui1.d0(routeInfo.getSpecialFeatures()), routeInfo.get_updateSpecialFeaturesList(), Y);
                    if (!ui1.Y()) {
                        TextView textView2 = (TextView) rg1.findViewById(R.id.bus_agency_name);
                        textView2.setVisibility(0);
                        textView2.setText(str);
                    }
                    CalligraphyUtils.applyFontToTextView(context, (TextView) rg1.findViewById(R.id.title), context.getString(R.string.font_medium));
                    rg1.setOnClickListener(new f(busFavourite));
                    rg1.setBackgroundResource(R.drawable.item_selector);
                    j(rg1, new g(this, routeInfo));
                    ((LinearLayout.LayoutParams) rg1.getSettingsIconView().getLayoutParams()).gravity = 48;
                    return rg1;
                }
                gc1 gc1 = new gc1(this.g);
                gc1.c(kVar.b);
                gc1.setFavoriteRemovedListener(this.s);
                gc1.setClickListener(this.r);
                return gc1;
            case 8:
            default:
                return null;
            case 9:
                View view2 = new View(this.g);
                view2.setBackgroundColor(this.g.getResources().getColor(R.color.black));
                view2.setAlpha(0.12f);
                view2.setLayoutParams(new AbsListView.LayoutParams(-1, (int) this.g.getResources().getDimension(R.dimen.home_screen_favorite_card_divider)));
                return view2;
            case 10:
                StopFavourite stopFavourite = (StopFavourite) kVar.b;
                Stop stop = stopFavourite.getStop();
                rg1 c2 = mk0.c(null, stop, this.g, stop.getMode(), null);
                c2.setBackgroundResource(R.drawable.item_selector);
                c2.setOnClickListener(new h(stopFavourite, stop));
                j(c2, new i(this, stop));
                return c2;
            case 11:
                RecentTrips recentTrips = kVar.e;
                View inflate = LayoutInflater.from(this.g).inflate(R.layout.trip_planner_universal_search, (ViewGroup) null, false);
                wk0.g(this.g, (TextView) inflate.findViewById(R.id.from_location), recentTrips.getFromLocation().c);
                wk0.g(this.g, (TextView) inflate.findViewById(R.id.to_location), recentTrips.getToLocation().c);
                inflate.setOnClickListener(new aj0(this, recentTrips));
                return inflate;
            case 12:
                TextView textView3 = (TextView) this.h.inflate(R.layout.universal_recent_view, viewGroup, false);
                textView3.setText(this.g.getString(R.string.popular_routes));
                return textView3;
            case 13:
                RouteInfo routeInfo2 = kVar.f;
                View inflate2 = this.h.inflate(R.layout.popular_routes, (ViewGroup) null, false);
                Context context2 = this.g;
                zi0 zi0 = new zi0(this, routeInfo2);
                int i4 = mb1.f;
                TextView textView4 = (TextView) inflate2.findViewById(R.id.route_name);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) new SpannableString(routeInfo2.getRouteName()));
                if (ui1.d0(routeInfo2.getSpecialFeatures())) {
                    d71.b(context2, spannableStringBuilder, "AC", true, R.color.real_time_fetching_string_color, routeInfo2.getRouteName().length(), R.color.white);
                }
                List<String> list = routeInfo2.get_updateSpecialFeaturesList();
                while (list != null && i3 < list.size()) {
                    d71.b(context2, spannableStringBuilder, list.get(i3), true, R.color.spf, routeInfo2.getRouteName().length(), R.color.black_87);
                    i3++;
                    list = list;
                }
                if (ui1.Y()) {
                    inflate2.findViewById(R.id.to_stop).setVisibility(8);
                } else {
                    d71.a(context2, spannableStringBuilder, routeInfo2.getAgencyName().toUpperCase(), true, routeInfo2.getRouteName().length());
                }
                ((TextView) inflate2.findViewById(R.id.to_stop)).setText(routeInfo2.getFirstStopName() + " - " + routeInfo2.getLastStopName());
                textView4.setText(spannableStringBuilder);
                inflate2.setOnClickListener(zi0);
                return inflate2;
        }
    }

    public int getViewTypeCount() {
        l.values();
        return 14;
    }

    public final View h(ViewGroup viewGroup, String str) {
        View inflate = this.h.inflate(R.layout.favorite_list_recent, viewGroup, false);
        SpannableStringBuilder f2 = hj1.f(str);
        f2.setSpan(vn.N(this.g, wg1.NOTOSANS_MEDIUM), 0, f2.length(), 17);
        f2.setSpan(new AbsoluteSizeSpan(16, true), 0, f2.length(), 17);
        f2.setSpan(new ForegroundColorSpan(this.g.getResources().getColor(R.color.black_60)), 0, f2.length(), 17);
        ((TextView) inflate.findViewById(R.id.item_description)).setText(f2);
        inflate.setBackgroundColor(this.g.getResources().getColor(R.color.new_activity_color));
        inflate.setClickable(false);
        return inflate;
    }

    public boolean hasStableIds() {
        return false;
    }

    public void i(TextView textView, String str) {
        SpannableStringBuilder f2 = hj1.f(str);
        f2.setSpan(vn.N(this.g, wg1.NOTOSANS_MEDIUM), 0, f2.length(), 17);
        f2.setSpan(new AbsoluteSizeSpan(18, true), 0, f2.length(), 17);
        textView.setText(f2);
    }

    public boolean isEnabled(int i2) {
        int ordinal = this.f.get(i2).f438a.ordinal();
        if (ordinal != 0 && ordinal != 1) {
            return (ordinal == 4 || ordinal == 5 || ordinal == 6 || ordinal == 9 || ordinal == 12) ? false : true;
        }
        mf1 mf1 = this.f.get(i2).c;
        if (mf1 == null) {
            return true;
        }
        if (mf1.f2368a == null || mf1.b == null) {
            return false;
        }
        return true;
    }

    public final void j(rg1 rg1, View.OnClickListener onClickListener) {
        rg1.getSettingsIconView().setVisibility(0);
        rg1.getSettingsIconView().setImageResource(R.drawable.favorite_overflow);
        rg1.getSettingsIconView().setOnClickListener(new a(rg1, onClickListener));
    }

    public final void k(View view) {
        view.setPadding(this.g.getResources().getDimensionPixelSize(R.dimen.favorites_settings_icon_left_padding), view.getPaddingTop(), this.g.getResources().getDimensionPixelSize(R.dimen.favorites_settings_icon_right_padding), view.getPaddingBottom());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r5v16. Raw type applied. Possible types: java.util.List<app.zophop.models.Favourites.Favourite>, java.util.List */
    /* JADX WARN: Type inference failed for: r4v22, types: [c80] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void l() {
        /*
        // Method dump skipped, instructions count: 564
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.bj0.l():void");
    }

    /* renamed from: bj0$k */
    /* compiled from: FavoriteListAdapter */
    public static class k {

        /* renamed from: a  reason: collision with root package name */
        public final l f438a;
        public Favourite b;
        public mf1 c;
        public pf1 d;
        public RecentTrips e;
        public RouteInfo f;

        public k(l lVar, Favourite favourite) {
            this.f438a = lVar;
            this.b = favourite;
            this.c = null;
        }

        public k(l lVar, mf1 mf1) {
            this.f438a = lVar;
            this.c = mf1;
            this.b = null;
        }

        public k(l lVar, pf1 pf1) {
            this.f438a = lVar;
            this.d = pf1;
            this.b = null;
        }

        public k(l lVar, RecentTrips recentTrips) {
            this.c = null;
            this.d = null;
            this.f438a = lVar;
            this.e = recentTrips;
        }

        public k(l lVar, RouteInfo routeInfo) {
            this.f438a = lVar;
            this.f = routeInfo;
        }
    }
}
