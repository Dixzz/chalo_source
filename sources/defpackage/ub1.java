package defpackage;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;
import app.zophop.R;
import app.zophop.models.Favourites.BusFavourite;
import app.zophop.models.Favourites.BusFavouriteWithSubscription;
import app.zophop.models.Favourites.RouteStoreType;
import app.zophop.models.Route;
import app.zophop.models.Stop;
import app.zophop.models.TransitMode;
import app.zophop.ui.activities.PickStopActivity;
import app.zophop.ui.activities.SubscriptionActivity;
import app.zophop.ui.fragments.BusFrequencyActivity;
import com.google.gson.Gson;

/* renamed from: ub1  reason: default package */
/* compiled from: RouteOptionsHandler */
public class ub1 implements PopupMenu.OnMenuItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final Route f3483a;
    public final f80 b = xt.f3961a.r();
    public final ve c;
    public final Stop d;
    public final Stop e;
    public final boolean f;

    public ub1(ve veVar, Route route, Stop stop, Stop stop2, boolean z) {
        this.c = veVar;
        this.f3483a = route;
        this.d = stop;
        this.e = stop2;
        this.f = z;
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        String str;
        int itemId = menuItem.getItemId();
        boolean z = false;
        if (itemId != R.id.route_view_schedule) {
            switch (itemId) {
                case R.id.route_menu_add_fav:
                    f80 f80 = this.b;
                    String routeId = this.f3483a.getRouteId();
                    RouteStoreType routeStoreType = RouteStoreType.FAVORITE;
                    BusFavourite busFavourite = (BusFavourite) ((c80) f80).h(routeId, routeStoreType);
                    String routeName = this.f3483a.getRouteName();
                    String name = this.f3483a.getStopSequence().get(0).getName();
                    String name2 = this.f3483a.getStopSequence().get(this.f3483a.getStopSequence().size() - 1).getName();
                    if (busFavourite != null) {
                        if (((BusFavouriteWithSubscription) ((c80) this.b).h(this.f3483a.getRouteId(), RouteStoreType.SUBSCRIBED)) != null) {
                            lm0 a2 = lm0.a(this.c.getFragmentManager(), null, this.c.getString(R.string.subscription_removal_alert), this.c.getString(R.string.yes), this.c.getString(R.string.cab_no));
                            sb1 sb1 = new sb1(this, a2);
                            TextView textView = a2.i;
                            if (textView != null) {
                                textView.setOnClickListener(sb1);
                            } else {
                                a2.q = sb1;
                            }
                            tb1 tb1 = new tb1(this, a2);
                            TextView textView2 = a2.j;
                            if (textView2 != null) {
                                textView2.setOnClickListener(tb1);
                            } else {
                                a2.r = tb1;
                            }
                            z = true;
                        } else {
                            ((c80) this.b).r(busFavourite, routeStoreType);
                            Toast.makeText(this.c, (int) R.string.fav_removed, 1).show();
                            c80.q("route details screen", routeName, name, name2, TransitMode.bus, false);
                        }
                        str = "remove";
                    } else {
                        ((c80) this.b).c(this.f3483a.getRouteId(), routeName, name, name2, null, this.f3483a.getAgencyName());
                        Toast.makeText(this.c, (int) R.string.fav_added, 1).show();
                        TransitMode transitMode = TransitMode.bus;
                        c80.q("route details screen", routeName, name, name2, transitMode, true);
                        if (this.f3483a.getMode().equals(transitMode)) {
                            SubscriptionActivity.h0(this.c, this.f3483a);
                        }
                        str = "add";
                    }
                    ed1 l = hj1.l("route screen fav clicked", Long.MIN_VALUE, "type", str);
                    l.a("wasSubscribed", String.valueOf(z));
                    jz5.b().g(l);
                    break;
                case R.id.route_menu_checkin:
                    if (!ui1.V(this.c)) {
                        if (vn.K0(this.c)) {
                            if (!vn.J0(this.c)) {
                                new ah1(this.c, xt.f3961a.B().a()).b(this.c.getString(R.string.gps_not_available_toast));
                                break;
                            }
                        } else {
                            ve veVar = this.c;
                            Toast.makeText(veVar, veVar.getString(R.string.check_in_activity_failure_query_failed), 1).show();
                            break;
                        }
                    } else {
                        String name3 = this.f3483a.getMode().name();
                        String routeName2 = this.f3483a.getRouteName();
                        ed1 l2 = hj1.l("checkin initiated", Long.MIN_VALUE, "source", "route details screen");
                        if (name3 != null) {
                            l2.a("mode", name3);
                        }
                        if (routeName2 != null) {
                            l2.a("route", routeName2);
                        }
                        jz5.b().g(l2);
                        ui1.k0(this.c, this.f3483a, this.d, this.e);
                        break;
                    }
                    break;
                case R.id.route_menu_search_stops:
                    Intent intent = new Intent(this.c, PickStopActivity.class);
                    intent.putExtra("extra_mode", this.f3483a.getMode().toString());
                    intent.putExtra("stop_list_extra", new Gson().toJson(this.f3483a.getStopSequence()));
                    if (this.f3483a.getMode().equals(TransitMode.bus)) {
                        intent.putExtra("extra:search_copy", this.c.getString(R.string.type_stop_name));
                    } else {
                        intent.putExtra("extra:search_copy", this.c.getString(R.string.type_station_name));
                    }
                    this.c.startActivityForResult(intent, 1010);
                    jz5.b().g(new ed1("route screen search clicked", Long.MIN_VALUE));
                    break;
                case R.id.route_menu_share:
                    new j90().a(this.c, this.f3483a.getRouteId(), this.f3483a.getRouteName(), this.f3483a.getStopSequence().get(0).getName(), this.f3483a.getStopSequence().get(this.f3483a.getStopSequence().size() - 1).getName(), this.f3483a.getMode());
                    ui1.A0(this.f3483a.getRouteName(), this.f3483a.getMode());
                    break;
                case R.id.route_menu_subscribe:
                    SubscriptionActivity.h0(this.c, this.f3483a);
                    jz5.b().g(new ed1("route screen subscribe clicked", Long.MIN_VALUE));
                    break;
            }
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("busFrquency", new Gson().toJson(this.f3483a.getRouteTiming()));
            bundle.putString("fromStop", this.f3483a.getStopSequence().get(0).getName());
            Intent intent2 = new Intent(this.c, BusFrequencyActivity.class);
            intent2.putExtras(bundle);
            this.c.startActivity(intent2);
        }
        return true;
    }
}
