package defpackage;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import app.zophop.R;
import app.zophop.alarm.SubscriberService;
import app.zophop.models.Favourites.BusFavouriteWithSubscription;
import app.zophop.ui.activities.HomeActivity;
import app.zophop.ui.activities.RouteDetailsActivity;
import com.google.firebase.appindexing.Indexable;
import defpackage.ii1;
import java.util.ArrayList;
import java.util.List;

/* renamed from: cv  reason: default package */
/* compiled from: SubscriberService */
public class cv implements ji1<j10, String> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SubscriberService f754a;

    public cv(SubscriberService subscriberService) {
        this.f754a = subscriberService;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.ji1
    public void a(String str) {
        SubscriberService.f(this.f754a, str);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.ji1
    public void onSuccess(j10 j10) {
        j10 j102 = j10;
        if (x61.s(j102.a())) {
            ii1.a.EnumC0027a aVar = ii1.a.EnumC0027a.SUCCESS;
            int a2 = j102.a();
            List<i10> c = j102.c();
            ArrayList arrayList = new ArrayList(2);
            if (!(c == null || c.size() == 0 || !x61.s(a2))) {
                int i = 2;
                for (int i2 = 0; i2 < c.size(); i2++) {
                    int i3 = c.get(i2).f1460a;
                    if (i > 0 && i3 != -1 && x61.s(i3)) {
                        i--;
                        arrayList.add(Integer.valueOf(i3));
                    }
                }
            }
            if (arrayList.size() != 0) {
                SubscriberService subscriberService = this.f754a;
                int hashCode = subscriberService.p.hashCode();
                BusFavouriteWithSubscription busFavouriteWithSubscription = subscriberService.p;
                Intent r0 = RouteDetailsActivity.r0(subscriberService, busFavouriteWithSubscription.getRouteId(), busFavouriteWithSubscription.getSubscribedStop(), null, busFavouriteWithSubscription.getMode(), "subscription notificaiton");
                r0.putExtra("isBoardingStopBasedOnLocation", false);
                r0.putExtra("extraNotificationId", hashCode);
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(new Intent(subscriberService, HomeActivity.class));
                arrayList2.add(r0);
                int alarmCode = busFavouriteWithSubscription.getAlarmCode();
                if (!arrayList2.isEmpty()) {
                    Intent[] intentArr = (Intent[]) arrayList2.toArray(new Intent[arrayList2.size()]);
                    intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
                    PendingIntent activities = PendingIntent.getActivities(subscriberService, alarmCode, intentArr, 0, null);
                    int b = q5.b(subscriberService, R.color.orange_primary);
                    f5 f5Var = new f5(subscriberService, null);
                    f5Var.i(16, true);
                    f5Var.v.icon = R.drawable.logo_notification;
                    f5Var.q = b;
                    f5Var.g = activities;
                    f5Var.j = 2;
                    f5Var.g(String.format(subscriberService.getString(R.string.route_towards), busFavouriteWithSubscription.getRouteName(), busFavouriteWithSubscription.getEndStopName()));
                    f5Var.i(16, true);
                    StringBuilder sb = new StringBuilder();
                    for (int i4 = 0; i4 < Math.min(arrayList.size(), 2); i4++) {
                        if (i4 != 0) {
                            sb.append(" & ");
                        }
                        sb.append(ii1.d((long) (((Integer) arrayList.get(i4)).intValue() * Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL), subscriberService));
                    }
                    f5Var.f(String.format(subscriberService.getString(R.string.subscribe_notification_body_with_eta), sb.toString(), busFavouriteWithSubscription.getSubscribedStop().getName()));
                    f5Var.m(busFavouriteWithSubscription.getSubscribedStop().getName());
                    f5Var.a(R.drawable.notification_track_bus, subscriberService.getString(R.string.notification_action_track_bus), activities);
                    int i5 = Build.VERSION.SDK_INT;
                    if (i5 >= 26) {
                        f5Var.t = "myChannel";
                    }
                    Notification b2 = f5Var.b();
                    NotificationManager notificationManager = (NotificationManager) subscriberService.getSystemService("notification");
                    if (i5 >= 26) {
                        NotificationChannel notificationChannel = new NotificationChannel("myChannel", "NewGroup", 4);
                        int i6 = jc5.b(subscriberService.getApplicationContext()).w;
                        if (i6 == 2 || i6 == -1) {
                            notificationChannel.enableVibration(true);
                        }
                        if (i6 == 4 || i6 == -1) {
                            notificationChannel.enableLights(true);
                            notificationChannel.setLightColor(-1);
                        }
                        notificationManager.createNotificationChannel(notificationChannel);
                    }
                    notificationManager.notify(hashCode, b2);
                    this.f754a.j(arrayList.size(), true, null);
                    return;
                }
                throw new IllegalStateException("No intents added to TaskStackBuilder; cannot getPendingIntent");
            }
            SubscriberService.f(this.f754a, "no etas");
            return;
        }
        SubscriberService.f(this.f754a, "no etas (has est)");
    }
}
