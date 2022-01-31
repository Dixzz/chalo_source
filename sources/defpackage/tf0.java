package defpackage;

import android.view.View;
import app.zophop.alarm.SubscriberAlarm;
import app.zophop.models.Favourites.BusFavouriteWithSubscription;
import app.zophop.models.Favourites.RouteStoreType;
import app.zophop.pubsub.eventbus.events.SubscriptionEvent;
import app.zophop.ui.activities.SubscriptionActivity;

/* renamed from: tf0  reason: default package */
/* compiled from: SubscriptionActivity */
public class tf0 implements View.OnClickListener {
    public final /* synthetic */ SubscriptionActivity f;

    public tf0(SubscriptionActivity subscriptionActivity) {
        this.f = subscriptionActivity;
    }

    public void onClick(View view) {
        SubscriptionActivity subscriptionActivity = this.f;
        BusFavouriteWithSubscription busFavouriteWithSubscription = subscriptionActivity.q;
        if (busFavouriteWithSubscription != null) {
            ((c80) subscriptionActivity.l).r(busFavouriteWithSubscription, RouteStoreType.SUBSCRIBED);
            SubscriberAlarm.a(subscriptionActivity, subscriptionActivity.q);
            SubscriptionActivity.j0(subscriptionActivity.q);
            jz5.b().i(new SubscriptionEvent(subscriptionActivity.t, false));
        }
        subscriptionActivity.finish();
    }
}
