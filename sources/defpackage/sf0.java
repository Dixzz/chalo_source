package defpackage;

import android.view.View;
import android.widget.Toast;
import app.zophop.R;
import app.zophop.alarm.SubscriberAlarm;
import app.zophop.models.Favourites.BusFavourite;
import app.zophop.models.Favourites.BusFavouriteWithSubscription;
import app.zophop.models.Favourites.RouteStoreType;
import app.zophop.models.Stop;
import app.zophop.pubsub.eventbus.events.SubscriptionEvent;
import app.zophop.ui.activities.SubscriptionActivity;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import org.json.JSONException;

/* renamed from: sf0  reason: default package */
/* compiled from: SubscriptionActivity */
public class sf0 implements View.OnClickListener {
    public final /* synthetic */ SubscriptionActivity f;

    public sf0(SubscriptionActivity subscriptionActivity) {
        this.f = subscriptionActivity;
    }

    public void onClick(View view) {
        int nextInt;
        SubscriptionActivity subscriptionActivity = this.f;
        if (subscriptionActivity.m != null) {
            f80 f80 = subscriptionActivity.l;
            String str = subscriptionActivity.t;
            RouteStoreType routeStoreType = RouteStoreType.FAVORITE;
            ((c80) f80).h(str, routeStoreType);
            ((c80) subscriptionActivity.l).c(subscriptionActivity.t, subscriptionActivity.u, subscriptionActivity.v, subscriptionActivity.w, null, subscriptionActivity.k.getAgencyName());
            BusFavourite busFavourite = (BusFavourite) ((c80) subscriptionActivity.l).h(subscriptionActivity.t, routeStoreType);
            subscriptionActivity.p = busFavourite;
            f80 f802 = subscriptionActivity.l;
            Stop stop = subscriptionActivity.m;
            int i = subscriptionActivity.n;
            int i2 = subscriptionActivity.o;
            c80 c80 = (c80) f802;
            Objects.requireNonNull(c80);
            try {
                String id = busFavourite.getId();
                String routeId = busFavourite.getRouteId();
                List<String> list = busFavourite.get_spfList();
                RouteStoreType routeStoreType2 = RouteStoreType.SUBSCRIBED;
                BusFavouriteWithSubscription busFavouriteWithSubscription = (BusFavouriteWithSubscription) c80.h(routeId, routeStoreType2);
                if (busFavouriteWithSubscription != null) {
                    nextInt = busFavouriteWithSubscription.getAlarmCode();
                } else {
                    nextInt = new Random().nextInt(Integer.MAX_VALUE);
                }
                String routeName = busFavourite.getRouteName();
                String startStopName = busFavourite.getStartStopName();
                String endStopName = busFavourite.getEndStopName();
                long time = busFavourite.getTime();
                int accessCount = busFavourite.getAccessCount();
                BusFavouriteWithSubscription busFavouriteWithSubscription2 = new BusFavouriteWithSubscription(routeId, routeName, startStopName, endStopName, id, time, routeStoreType2, stop, (i * 60) + i2, nextInt, busFavourite.getAgency(), list, busFavourite.is_isFreeRideAvailable());
                for (int i3 = 0; i3 < accessCount; i3++) {
                    c80.n(busFavouriteWithSubscription2);
                }
                c80.d.j(c80.i(busFavouriteWithSubscription2), c80.f.d(busFavouriteWithSubscription2).toString());
            } catch (JSONException unused) {
            }
            SubscriberAlarm.e(subscriptionActivity, (BusFavouriteWithSubscription) ((c80) subscriptionActivity.l).h(subscriptionActivity.p.getRouteId(), RouteStoreType.SUBSCRIBED), true);
            ed1 ed1 = new ed1("route subscribed", Long.MIN_VALUE);
            ed1.a("stopName", subscriptionActivity.m.getName());
            ed1.a("routeName", subscriptionActivity.p.getRouteName());
            ed1.a("hour", subscriptionActivity.n + "");
            ed1.a("mode", subscriptionActivity.x.toString());
            ed1.a("minute", subscriptionActivity.o + "");
            jz5.b().g(ed1);
            ui1.t0("routeSubscribed");
            jz5.b().i(new SubscriptionEvent(subscriptionActivity.t, true));
            subscriptionActivity.finish();
            return;
        }
        Toast.makeText(subscriptionActivity, subscriptionActivity.getString(R.string.please_select_stop), 1).show();
    }
}
