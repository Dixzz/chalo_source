package defpackage;

import android.view.View;
import android.widget.PopupMenu;
import app.zophop.R;
import app.zophop.models.Favourites.BusFavourite;
import app.zophop.models.Favourites.BusFavouriteWithSubscription;
import app.zophop.models.Favourites.RouteStoreType;
import app.zophop.models.TransitMode;
import app.zophop.service.LocationTrackingService;
import app.zophop.ui.activities.RouteDetailsActivity;
import app.zophop.ui.utils.FrequencyRouteHelper;
import java.util.Objects;

/* renamed from: l61  reason: default package */
/* compiled from: FrequencyRouteHelper */
public class l61 implements View.OnClickListener {
    public final /* synthetic */ FrequencyRouteHelper f;

    public l61(FrequencyRouteHelper frequencyRouteHelper) {
        this.f = frequencyRouteHelper;
    }

    public void onClick(View view) {
        Objects.requireNonNull(this.f);
        jz5.b().g(new ed1("route screen menu clicked", Long.MIN_VALUE));
        FrequencyRouteHelper frequencyRouteHelper = this.f;
        ub1 ub1 = new ub1(frequencyRouteHelper.h, frequencyRouteHelper.f, frequencyRouteHelper.o, frequencyRouteHelper.p, frequencyRouteHelper.x);
        FrequencyRouteHelper frequencyRouteHelper2 = this.f;
        if (frequencyRouteHelper2.v == null) {
            frequencyRouteHelper2.v = new PopupMenu(this.f.h, view);
            this.f.v.inflate(R.menu.menu_route);
        }
        PopupMenu popupMenu = this.f.v;
        if (ub1.f3483a.getMode().equals(TransitMode.bus)) {
            boolean z = true;
            if (((BusFavourite) ((c80) ub1.b).h(ub1.f3483a.getRouteId(), RouteStoreType.FAVORITE)) != null) {
                popupMenu.getMenu().findItem(R.id.route_menu_add_fav).setTitle(R.string.trip_screen_menu_remove_fav);
            } else {
                popupMenu.getMenu().findItem(R.id.route_menu_add_fav).setTitle(R.string.trip_screen_menu_fav);
            }
            if (((BusFavouriteWithSubscription) ((c80) ub1.b).h(ub1.f3483a.getRouteId(), RouteStoreType.SUBSCRIBED)) == null) {
                z = false;
            }
            if (z) {
                popupMenu.getMenu().findItem(R.id.route_menu_subscribe).setTitle(R.string.unsubscribe);
            } else {
                popupMenu.getMenu().findItem(R.id.route_menu_subscribe).setTitle(R.string.subscribe);
            }
            if (RouteDetailsActivity.D0() || (!ub1.f3483a.isLive() && !ub1.f)) {
                popupMenu.getMenu().findItem(R.id.route_menu_subscribe).setVisible(false);
            }
            if (!ui1.f0(ub1.f3483a)) {
                popupMenu.getMenu().findItem(R.id.route_view_schedule).setVisible(false);
            }
        } else {
            popupMenu.getMenu().findItem(R.id.route_view_schedule).setVisible(false);
            popupMenu.getMenu().findItem(R.id.route_menu_add_fav).setVisible(false);
            popupMenu.getMenu().findItem(R.id.route_menu_subscribe).setVisible(false);
        }
        if (LocationTrackingService.l) {
            popupMenu.getMenu().findItem(R.id.route_menu_checkin).setVisible(false);
        }
        this.f.v.setOnMenuItemClickListener(ub1);
        this.f.v.show();
    }
}
