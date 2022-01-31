package app.zophop.features;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import app.zophop.R;
import app.zophop.models.Favourites.Favourite;
import app.zophop.models.Favourites.RouteStoreType;
import app.zophop.models.Stop;
import app.zophop.models.TimeInterval;
import app.zophop.models.TransitMode;
import app.zophop.models.http_response.SummaryResponse;
import app.zophop.models.http_response.TripSummary;
import app.zophop.models.mTicketing.ProductDiscountsObject;
import app.zophop.pubsub.eventbus.events.SummaryResponseEvent;
import app.zophop.ui.activities.HomeActivity;
import app.zophop.ui.activities.NearbyStopsActivity;
import app.zophop.ui.activities.TripsSchedulesDirectionActivity;
import com.google.firebase.appindexing.Indexable;
import com.google.firebase.perf.util.Constants;
import com.google.gson.Gson;
import com.razorpay.AnalyticsConstants;
import defpackage.i10;
import defpackage.xt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

public class GeoFenceService extends a5 {
    public static final /* synthetic */ int p = 0;
    public sf1 m;
    public String n = null;
    public String o;

    public GeoFenceService() {
        jz5 b = jz5.b();
        b.k(this, b.e, false, 0);
    }

    public static void f(GeoFenceService geoFenceService, Stop stop, SummaryResponseEvent summaryResponseEvent, List list) {
        String str;
        f5 f5Var;
        boolean z;
        f5 f5Var2;
        String str2;
        Objects.requireNonNull(geoFenceService);
        TransitMode mode = stop.getMode();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Intent(geoFenceService, HomeActivity.class));
        String name = GeoFenceService.class.getName();
        Float f = NearbyStopsActivity.Y;
        Intent intent = new Intent(geoFenceService, NearbyStopsActivity.class);
        intent.putExtra("nearby:mode", mode.toString());
        intent.putExtra("nearby:summary_response", new Gson().toJson(summaryResponseEvent));
        intent.putExtra("nearby:toggle", "true");
        if (!TextUtils.isEmpty(name)) {
            intent.putExtra("source", name);
        }
        arrayList.add(intent);
        String id = stop.getId();
        String name2 = stop.getName();
        TransitMode mode2 = stop.getMode();
        String name3 = GeoFenceService.class.getName();
        int i = TripsSchedulesDirectionActivity.M;
        Intent intent2 = new Intent(geoFenceService, TripsSchedulesDirectionActivity.class);
        intent2.putExtra("stop_id", id);
        intent2.putExtra("stop_name", name2);
        intent2.putExtra("extra_direction", (String) null);
        intent2.putExtra("stop_distance", (String) null);
        intent2.putExtra("mode", mode2.name());
        if (!TextUtils.isEmpty(name3)) {
            intent2.putExtra("source", name3);
        }
        arrayList.add(intent2);
        if (!arrayList.isEmpty()) {
            Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[arrayList.size()]);
            char c = 0;
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            PendingIntent activities = PendingIntent.getActivities(geoFenceService, 0, intentArr, 134217728, null);
            f5 f5Var3 = new f5(geoFenceService, null);
            int i2 = 1;
            f5Var3.i(16, true);
            f5Var3.g = activities;
            g5 g5Var = new g5();
            String string = geoFenceService.getString(R.string.next_trips);
            Iterator it = list.iterator();
            int i3 = 0;
            while (true) {
                if (!it.hasNext()) {
                    str = string;
                    f5Var = f5Var3;
                    i2 = 0;
                    break;
                }
                Pair pair = (Pair) it.next();
                if (i3 == 3) {
                    str = string;
                    f5Var = f5Var3;
                    break;
                }
                if (((i10) pair.second).d.equals(i10.a.ESTIMATED) || ((i10) pair.second).f1460a == Integer.MAX_VALUE) {
                    StringBuilder sb = new StringBuilder();
                    String string2 = geoFenceService.getString(R.string.to);
                    Object[] objArr = new Object[i2];
                    objArr[c] = ((TripSummary) pair.first).getLastStop().getName();
                    sb.append(String.format(string2, objArr));
                    sb.append(" : ");
                    TripSummary tripSummary = (TripSummary) pair.first;
                    int N = ui1.N();
                    StringBuilder sb2 = new StringBuilder();
                    if (tripSummary.isFrequencyTrip()) {
                        Pair<TimeInterval, Integer> z2 = ui1.z(N, tripSummary.getFrequencyList());
                        if (z2 == null) {
                            str2 = string;
                            f5Var2 = f5Var3;
                            sb2.append(geoFenceService.getString(R.string.no_more_trips_today));
                        } else if (((TimeInterval) z2.first).containsTime(N)) {
                            sb2.append(geoFenceService.getString(R.string.every));
                            sb2.append(z2.second);
                            sb2.append(" min");
                            str2 = string;
                            f5Var2 = f5Var3;
                        } else {
                            sb2.append(geoFenceService.getString(R.string.after));
                            str2 = string;
                            f5Var2 = f5Var3;
                            sb2.append(jh1.g((long) ((Integer) ((Pair) ((TimeInterval) z2.first)).first).intValue()).replace("am", "AM").replace("pm", "PM"));
                        }
                    } else {
                        str2 = string;
                        f5Var2 = f5Var3;
                        sb2.append(jh1.g((long) tripSummary.getArrivalTime()).replace("am", "AM").replace("pm", "PM"));
                    }
                    sb.append(sb2.toString());
                    g5Var.d(sb.toString());
                } else {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(((TripSummary) pair.first).getRouteName());
                    sb3.append(" ");
                    sb3.append(ii1.d((long) (((i10) pair.second).f1460a * Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL), geoFenceService));
                    sb3.append(" ");
                    String string3 = geoFenceService.getString(R.string.to);
                    Object[] objArr2 = new Object[i2];
                    objArr2[c] = ((TripSummary) pair.first).getLastStop().getName();
                    sb3.append(String.format(string3, objArr2));
                    g5Var.d(sb3.toString());
                    if (i3 == 0) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(ii1.d((long) (((i10) pair.second).f1460a * Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL), geoFenceService));
                        sb4.append(" ");
                        String string4 = geoFenceService.getString(R.string.to);
                        Object[] objArr3 = new Object[i2];
                        objArr3[c] = ((TripSummary) pair.first).getLastStop().getName();
                        sb4.append(String.format(string4, objArr3));
                        string = sb4.toString();
                        f5Var2 = f5Var3;
                        i3++;
                        f5Var3 = f5Var2;
                        i2 = 1;
                        c = 0;
                    } else {
                        str2 = string;
                        f5Var2 = f5Var3;
                    }
                }
                string = str2;
                i3++;
                f5Var3 = f5Var2;
                i2 = 1;
                c = 0;
            }
            int b = q5.b(geoFenceService, R.color.orange_primary);
            Resources resources = geoFenceService.getResources();
            int ordinal = mode.ordinal();
            f5Var.j(BitmapFactory.decodeResource(resources, ordinal != 1 ? ordinal != 2 ? ordinal != 3 ? ordinal != 5 ? R.drawable.train_notification : R.drawable.ferry_notification : R.drawable.monorail_notification : R.drawable.metro_notification : R.drawable.bus_notification));
            f5Var.v.icon = R.drawable.logo_notification;
            f5Var.q = b;
            f5Var.g(String.format(geoFenceService.getString(R.string.from_stop), stop.getName()));
            f5Var.f(str);
            f5Var.l(g5Var);
            if (i2 != 0) {
                g5Var.c = f5.d(geoFenceService.getString(stop.getMode().equals(TransitMode.bus) ? R.string.geofence_notif_summary_text : R.string.more));
                g5Var.d = true;
            }
            NotificationManager notificationManager = (NotificationManager) geoFenceService.getSystemService("notification");
            f5Var.h(4);
            int i4 = Build.VERSION.SDK_INT;
            if (i4 >= 26) {
                f5Var.t = "chaloNotificationChannel";
            }
            Notification b2 = f5Var.b();
            if (i4 >= 26) {
                NotificationChannel notificationChannel = new NotificationChannel("chaloNotificationChannel", "NewGroup", 4);
                int i5 = jc5.b(geoFenceService.getApplicationContext()).w;
                if (i5 == 2 || i5 == -1) {
                    z = true;
                    notificationChannel.enableVibration(true);
                } else {
                    z = true;
                }
                if (i5 == 4 || i5 == -1) {
                    notificationChannel.enableLights(z);
                    notificationChannel.setLightColor(-1);
                }
                notificationManager.createNotificationChannel(notificationChannel);
            }
            notificationManager.notify(0, b2);
            geoFenceService.m.put("nearby_last_shown", String.valueOf(System.currentTimeMillis()));
            h(true, stop.getName(), stop.getId(), mode.name());
            return;
        }
        throw new IllegalStateException("No intents added to TaskStackBuilder; cannot getPendingIntent");
    }

    public static void h(boolean z, String str, String str2, String str3) {
        ed1 l = hj1.l(z ? "nearby station notification delivered" : "nearby station notification clicked", Long.MIN_VALUE, "stopId", str2);
        hj1.p(l, "stopName", str, "stopMode", str3).g(l);
    }

    @Override // defpackage.a5
    public void d(Intent intent) {
        try {
            jz5.b().g(new ed1("geofence alert received", Long.MIN_VALUE));
            if (i()) {
                f34 a2 = f34.a(intent);
                int i = a2.f1068a;
                if (!(i != -1)) {
                    List<c34> list = a2.c;
                    if (list.size() > 0) {
                        this.o = list.get(0).e().split(ProductDiscountsObject.KEY_DELIMITER)[1];
                        this.n = xt.f3961a.c0().f(this.o);
                        return;
                    }
                    g(null, "zero geofences");
                    return;
                }
                g(null, String.valueOf(i));
                String.valueOf(a2.f1068a);
            }
        } catch (Throwable th) {
            b00 b00 = b00.f358a;
            b00.a().b(th);
        }
    }

    public final void g(String str, String str2) {
        ed1 l = hj1.l("geofence processing status", Long.MIN_VALUE, "stopId", str);
        l.a("isError", Boolean.valueOf(str2 != null));
        l.a("error", str2);
        jz5.b().g(l);
    }

    public final boolean i() {
        long j;
        String optString = this.m.h.optString("nearby_last_shown", null);
        if (optString == null) {
            j = 0;
        } else {
            j = Long.parseLong(optString);
        }
        xt.t1 t1Var = xt.f3961a;
        long parseLong = t1Var.l().h.has("key_app_open_time_in_millis") ? Long.parseLong(t1Var.l().h.optString("key_app_open_time_in_millis", null)) : System.currentTimeMillis();
        long currentTimeMillis = System.currentTimeMillis();
        List<Favourite> f = t1Var.r().f(RouteStoreType.SUBSCRIBED);
        boolean b = t1Var.t().b("isGeofenceFeatureEnabled");
        boolean z = true;
        boolean z2 = !t1Var.v().f;
        boolean z3 = Long.compare(currentTimeMillis - j, (Long.parseLong(t1Var.t().f("geofenceNotificationIntervalInMin")) * 60) * 1000) > 0;
        boolean z4 = Long.compare(currentTimeMillis - parseLong, ((Long.parseLong(t1Var.t().f("geofenceAppInactiveThresholdInHrs")) * 60) * 60) * 1000) > 0;
        boolean z5 = ((ArrayList) f).size() == 0;
        ed1 ed1 = new ed1("geofence alert status", Long.MIN_VALUE);
        ed1.a(Constants.ENABLE_DISABLE, Boolean.valueOf(b));
        ed1.a("isBackground", Boolean.valueOf(z2));
        ed1.a("lastShownGTT", Boolean.valueOf(z3));
        ed1.a("lastAppOpenGTT", Boolean.valueOf(z4));
        ed1.a("hasNoSubscriptions", Boolean.valueOf(z5));
        if (!b || !z2 || !z3 || !z4 || !z5) {
            z = false;
        }
        hj1.d(z, ed1, "status", ed1);
        return z;
    }

    @Override // defpackage.a5
    public void onCreate() {
        super.onCreate();
        this.m = new sf1(getSharedPreferences("notif:preferences", 0), AnalyticsConstants.PREFERENCES);
    }

    public void onEvent(SummaryResponseEvent summaryResponseEvent) {
        String str = this.n;
        if (str != null && str.equals(summaryResponseEvent.getRequestId())) {
            if (summaryResponseEvent.getResponseType().equals(SummaryResponseEvent.ResponseType.SUCCESS)) {
                SummaryResponse summaryResponse = summaryResponseEvent.getSummaryResponseList().get(0);
                if (summaryResponse.getStop().getMode().equals(TransitMode.bus)) {
                    xt.t1 t1Var = xt.f3961a;
                    if (!xt.p) {
                        t1Var.N().d(summaryResponse.getStop().getId()).addListenerForSingleValueEvent(new v10(this, summaryResponse, summaryResponseEvent));
                        return;
                    }
                    String id = summaryResponse.getStop().getId();
                    String lowerCase = t1Var.k().d().getDisplayName().toLowerCase();
                    Uri.Builder builder = new Uri.Builder();
                    builder.encodedPath(ut.q).appendEncodedPath("stop").appendEncodedPath(lowerCase).appendEncodedPath(id);
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
                    xt.f3961a.S().a(new e70(0, uri, new w10(this, summaryResponse, summaryResponseEvent), new x10(this, summaryResponse), new JSONObject().toString()));
                    return;
                }
                return;
            }
            g(this.o, "no summary response");
        }
    }
}
