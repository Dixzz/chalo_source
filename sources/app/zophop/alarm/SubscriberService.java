package app.zophop.alarm;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import app.zophop.R;
import app.zophop.models.Favourites.BusFavouriteWithSubscription;
import app.zophop.models.Route;
import app.zophop.models.Stop;
import app.zophop.pubsub.eventbus.events.RouteDetailsEvent;
import app.zophop.ui.activities.HomeActivity;
import app.zophop.ui.activities.RouteDetailsActivity;
import defpackage.xt;
import j$.util.DesugarTimeZone;
import java.util.ArrayList;
import java.util.Calendar;
import org.json.JSONException;
import org.json.JSONObject;
import server.zophop.logging.LoggingConstants;

public class SubscriberService extends a5 {
    public static final /* synthetic */ int q = 0;
    public String m;
    public Stop n;
    public boolean o;
    public BusFavouriteWithSubscription p;

    public SubscriberService() {
        jz5 b = jz5.b();
        b.k(this, b.e, false, 0);
    }

    public static void f(SubscriberService subscriberService, String str) {
        subscriberService.g(subscriberService.getString(R.string.no_bus_notification));
        subscriberService.j(0, true, str);
    }

    @Override // defpackage.a5
    public void d(Intent intent) {
        try {
            BusFavouriteWithSubscription p2 = new mv().p(intent.getStringExtra("SUBSCRIBED_ROUTE"));
            this.p = p2;
            this.n = p2.getSubscribedStop();
            this.m = this.p.getRouteId();
        } catch (Exception e) {
            k(e.getMessage());
        }
        if (this.p == null) {
            k("no bus favourite");
        } else if (h() > 20) {
            k("time diff gtt");
        } else if (vn.K0(this)) {
            i(xt.f3961a.t().b("streamInfoInSubscriptionNotification"));
        } else {
            g(getString(R.string.no_internet_live_notification));
            j(0, false, null);
        }
    }

    public final void g(String str) {
        BusFavouriteWithSubscription busFavouriteWithSubscription = this.p;
        Intent r0 = RouteDetailsActivity.r0(this, busFavouriteWithSubscription.getRouteId(), busFavouriteWithSubscription.getSubscribedStop(), null, busFavouriteWithSubscription.getMode(), "subscription notification");
        r0.putExtra("isBoardingStopBasedOnLocation", false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Intent(this, HomeActivity.class));
        arrayList.add(r0);
        int alarmCode = busFavouriteWithSubscription.getAlarmCode();
        if (!arrayList.isEmpty()) {
            Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[arrayList.size()]);
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            PendingIntent activities = PendingIntent.getActivities(this, alarmCode, intentArr, 0, null);
            int b = q5.b(this, R.color.orange_primary);
            f5 f5Var = new f5(this, null);
            f5Var.i(16, true);
            f5Var.v.icon = R.drawable.logo_notification;
            f5Var.q = b;
            f5Var.g = activities;
            f5Var.j = 2;
            f5Var.g(String.format(getString(R.string.route_towards), busFavouriteWithSubscription.getRouteName(), busFavouriteWithSubscription.getEndStopName()));
            f5Var.i(16, true);
            f5Var.f(str);
            int i = Build.VERSION.SDK_INT;
            if (i >= 26) {
                f5Var.t = "myChannel";
            }
            Notification b2 = f5Var.b();
            NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
            if (i >= 26) {
                NotificationChannel notificationChannel = new NotificationChannel("myChannel", "NewGroup", 4);
                int i2 = jc5.b(getApplicationContext()).w;
                if (i2 == 2 || i2 == -1) {
                    notificationChannel.enableVibration(true);
                }
                if (i2 == 4 || i2 == -1) {
                    notificationChannel.enableLights(true);
                    notificationChannel.setLightColor(-1);
                }
                notificationManager.createNotificationChannel(notificationChannel);
            }
            notificationManager.notify(b2.hashCode(), b2);
            return;
        }
        throw new IllegalStateException("No intents added to TaskStackBuilder; cannot getPendingIntent");
    }

    public final int h() {
        long currentTimeMillis = System.currentTimeMillis();
        Calendar instance = Calendar.getInstance(DesugarTimeZone.getTimeZone("gmt"));
        instance.setTimeInMillis(currentTimeMillis + 19800000);
        int i = (instance.get(11) * 60) + instance.get(12);
        int subscribedMinute = this.p.getSubscribedMinute() + (this.p.getSubscribedHour() * 60);
        return Math.min(Math.abs(i - subscribedMinute), (1440 - Math.max(i, subscribedMinute)) + Math.min(i, subscribedMinute));
    }

    public final void i(boolean z) {
        if (z) {
            xt.t1 t1Var = xt.f3961a;
            String B = hj1.B(t1Var);
            if (this.m == null || B == null || this.n == null) {
                k("null input");
                return;
            }
            this.o = false;
            t1Var.U().c(this.m, this.n.getMode(), B);
            return;
        }
        xt.f3961a.N().e(this.n, this.m, new cv(this));
    }

    public final void j(int i, boolean z, String str) {
        try {
            ed1 ed1 = new ed1("subscription notification delivered", Long.MIN_VALUE);
            BusFavouriteWithSubscription busFavouriteWithSubscription = this.p;
            if (busFavouriteWithSubscription != null) {
                ed1.a(LoggingConstants.ROUTE_ID, busFavouriteWithSubscription.getRouteId());
                ed1.a("routeName", this.p.getRouteName());
                ed1.a("stopId", this.p.getSubscribedStop().getId());
                ed1.a("stopName", this.p.getSubscribedStop().getName());
                ed1.a("timeDifference", Integer.valueOf(h()));
            }
            ed1.a("etaSize", Integer.valueOf(i));
            ed1.a("internetAvailable", Boolean.valueOf(z));
            if (str != null) {
                ed1.a("etaMessage", str);
            }
            jz5.b().g(ed1);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public final void k(String str) {
        try {
            ed1 ed1 = new ed1("subscription notification processing status", Long.MIN_VALUE);
            BusFavouriteWithSubscription busFavouriteWithSubscription = this.p;
            if (busFavouriteWithSubscription != null) {
                ed1.a(LoggingConstants.ROUTE_ID, busFavouriteWithSubscription.getRouteId());
                ed1.a("routeName", this.p.getRouteName());
                ed1.a("stopId", this.p.getSubscribedStop().getId());
                ed1.a("stopName", this.p.getSubscribedStop().getName());
                ed1.a("timeDifference", Integer.valueOf(h()));
            }
            ed1.a("status", str);
            jz5.b().g(ed1);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void onEvent(RouteDetailsEvent routeDetailsEvent) {
        jz5.b().m(routeDetailsEvent);
        if (routeDetailsEvent.getRouteId() != null && routeDetailsEvent.getRouteId().equals(this.m) && !this.o) {
            this.o = true;
            if (routeDetailsEvent.getResponseType().equals(ad1.SUCCESS)) {
                Route route = routeDetailsEvent.getRoute();
                if (route != null) {
                    xt.t1 t1Var = xt.f3961a;
                    if (!xt.p) {
                        t1Var.N().f(this.m).addListenerForSingleValueEvent(new dv(this, route));
                        return;
                    }
                    String routeId = route.getRouteId();
                    String lowerCase = t1Var.k().d().getDisplayName().toLowerCase();
                    Uri.Builder builder = new Uri.Builder();
                    builder.encodedPath(ut.q).appendEncodedPath("route").appendEncodedPath(lowerCase).appendEncodedPath(routeId);
                    JSONObject K0 = ui1.K0();
                    if (K0 != null) {
                        try {
                            K0.put("src", "appCrts");
                        } catch (JSONException e) {
                            b00 b00 = b00.f358a;
                            b00.a().b(e);
                        }
                        builder.appendQueryParameter("meta", K0.toString());
                    } else {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("src", "appCrts");
                            builder.appendQueryParameter("meta", jSONObject.toString());
                        } catch (JSONException e2) {
                            b00 b002 = b00.f358a;
                            b00.a().b(e2);
                        }
                    }
                    String uri = builder.build().toString();
                    xt.f3961a.S().a(new e70(0, uri, new ev(this, route), new fv(this), new JSONObject().toString()));
                    return;
                }
                k("route fetch no data");
                i(false);
                return;
            }
            k("route fetch fail");
            i(false);
        }
    }
}
