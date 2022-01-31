package defpackage;

import android.view.View;
import android.widget.Toast;
import app.zophop.R;
import app.zophop.alarm.SubscriberAlarm;
import app.zophop.models.Favourites.BusFavourite;
import app.zophop.models.Favourites.BusFavouriteWithSubscription;
import app.zophop.models.Favourites.RouteStoreType;
import app.zophop.models.TransitMode;
import app.zophop.pubsub.eventbus.events.SubscriptionEvent;
import app.zophop.ui.activities.SubscriptionActivity;

/* renamed from: sb1  reason: default package */
/* compiled from: RouteOptionsHandler */
public class sb1 implements View.OnClickListener {
    public final /* synthetic */ lm0 f;
    public final /* synthetic */ ub1 g;

    public sb1(ub1 ub1, lm0 lm0) {
        this.g = ub1;
        this.f = lm0;
    }

    public void onClick(View view) {
        ub1 ub1 = this.g;
        f80 f80 = ub1.b;
        String routeId = ub1.f3483a.getRouteId();
        RouteStoreType routeStoreType = RouteStoreType.FAVORITE;
        BusFavouriteWithSubscription busFavouriteWithSubscription = (BusFavouriteWithSubscription) ((c80) ub1.b).h(ub1.f3483a.getRouteId(), RouteStoreType.SUBSCRIBED);
        String routeName = ub1.f3483a.getRouteName();
        String name = ub1.f3483a.getStopSequence().get(0).getName();
        String name2 = ub1.f3483a.getStopSequence().get(ub1.f3483a.getStopSequence().size() - 1).getName();
        ((c80) ub1.b).r((BusFavourite) ((c80) f80).h(routeId, routeStoreType), routeStoreType);
        SubscriberAlarm.a(ub1.c, busFavouriteWithSubscription);
        c80.q("route details screen", routeName, name, name2, TransitMode.bus, false);
        SubscriptionActivity.j0(busFavouriteWithSubscription);
        jz5.b().i(new SubscriptionEvent(ub1.f3483a.getRouteId(), false));
        Toast.makeText(ub1.c, (int) R.string.fav_removed, 1).show();
        this.f.dismiss();
    }
}
