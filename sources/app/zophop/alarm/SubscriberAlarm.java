package app.zophop.alarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import app.zophop.models.Favourites.BusFavourite;
import app.zophop.models.Favourites.BusFavouriteWithSubscription;
import app.zophop.models.Favourites.Favourite;
import app.zophop.models.Favourites.RouteStoreType;
import com.google.firebase.appindexing.Indexable;
import defpackage.xt;
import j$.util.DesugarTimeZone;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import org.json.JSONException;

public class SubscriberAlarm extends BroadcastReceiver {
    public static void a(Context context, BusFavouriteWithSubscription busFavouriteWithSubscription) {
        ((AlarmManager) context.getSystemService("alarm")).cancel(PendingIntent.getBroadcast(context, busFavouriteWithSubscription.getAlarmCode(), new Intent(context, SubscriberAlarm.class), 0));
    }

    public static void b(Context context) {
        xt.t1 t1Var = xt.f3961a;
        if (t1Var.k().d() != null) {
            Iterator it = ((ArrayList) t1Var.r().f(RouteStoreType.SUBSCRIBED)).iterator();
            while (it.hasNext()) {
                a(context, (BusFavouriteWithSubscription) ((Favourite) it.next()));
            }
        }
    }

    public static void c(Context context) {
        xt.t1 t1Var = xt.f3961a;
        if (t1Var.k().d() != null) {
            Iterator it = ((ArrayList) t1Var.r().f(RouteStoreType.SUBSCRIBED)).iterator();
            while (it.hasNext()) {
                e(context, (BusFavouriteWithSubscription) ((Favourite) it.next()), true);
            }
        }
    }

    public static void d(Context context, Favourite favourite) {
        BusFavouriteWithSubscription busFavouriteWithSubscription;
        if ((favourite instanceof BusFavourite) && (busFavouriteWithSubscription = (BusFavouriteWithSubscription) xt.f3961a.r().h(((BusFavourite) favourite).getRouteId(), RouteStoreType.SUBSCRIBED)) != null) {
            a(context, busFavouriteWithSubscription);
        }
    }

    public static void e(Context context, BusFavouriteWithSubscription busFavouriteWithSubscription, boolean z) {
        try {
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            Intent intent = new Intent(context, SubscriberAlarm.class);
            intent.putExtra("SUBSCRIBED_ROUTE", new mv().d(busFavouriteWithSubscription).toString());
            PendingIntent broadcast = PendingIntent.getBroadcast(context, busFavouriteWithSubscription.getAlarmCode(), intent, 268435456);
            Calendar instance = Calendar.getInstance(DesugarTimeZone.getTimeZone("Asia/Calcutta"));
            instance.setTimeInMillis(System.currentTimeMillis());
            if (z) {
                if (busFavouriteWithSubscription.getSubscribedMinute() + (busFavouriteWithSubscription.getSubscribedHour() * 60) < instance.get(12) + (instance.get(11) * 60)) {
                    instance.add(5, 1);
                }
            }
            instance.set(11, busFavouriteWithSubscription.getSubscribedHour());
            instance.set(12, busFavouriteWithSubscription.getSubscribedMinute());
            alarmManager.setInexactRepeating(0, instance.getTimeInMillis(), 86400000, broadcast);
            context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, AlarmBootReceiver.class), 1, 1);
        } catch (JSONException unused) {
        }
    }

    public void onReceive(Context context, Intent intent) {
        int i = SubscriberService.q;
        a5.a(context, SubscriberService.class, Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL, intent);
    }
}
