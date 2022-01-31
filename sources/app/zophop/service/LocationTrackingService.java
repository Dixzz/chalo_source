package app.zophop.service;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import app.zophop.R;
import app.zophop.models.RouteWithoutTimings;
import app.zophop.models.Stop;
import app.zophop.pubsub.eventbus.events.CheckInDestinationUpdated;
import app.zophop.pubsub.eventbus.events.CheckedinEvent;
import app.zophop.pubsub.eventbus.events.DestinationEvent;
import app.zophop.pubsub.eventbus.events.ETAEvent;
import app.zophop.pubsub.eventbus.events.LocationTrackingEvent;
import app.zophop.ui.activities.EndTripActivity;
import app.zophop.ui.activities.HomeActivity;
import com.google.android.gms.location.LocationRequest;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.appindexing.Indexable;
import com.google.firebase.database.ValueEventListener;
import defpackage.h20;
import defpackage.xt;
import java.util.HashMap;
import java.util.Objects;
import server.zophop.logging.LoggingConstants;
import server.zophop.models.StreamStatus;

public class LocationTrackingService extends Service {
    public static String k;
    public static boolean l;
    public static RouteWithoutTimings m;
    public static Stop n;
    public static Stop o;
    public static v80 p;
    public static boolean q;
    public static Stop r;
    public je1 f;
    public g34 g;
    public boolean h;
    public h20 i;
    public ValueEventListener j;

    public static void b() {
        if (l) {
            LocationTrackingEvent locationTrackingEvent = new LocationTrackingEvent(LocationTrackingEvent.ACTION.STOP);
            locationTrackingEvent.setDistanceCovered(p.j);
            locationTrackingEvent.setTotalTime(p.b());
            String str = k;
            if (str != null) {
                locationTrackingEvent.setStreamId(str);
            }
            jz5.b().i(locationTrackingEvent);
        }
    }

    public final void a(int i2, Stop stop) {
        String str;
        int i3 = Build.VERSION.SDK_INT;
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        if (notificationManager != null && i3 >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel("myChannel", "NewGroup", 4);
            int i4 = jc5.b(getApplicationContext()).w;
            if (i4 == 2 || i4 == -1) {
                notificationChannel.enableVibration(true);
            }
            if (i4 == 4 || i4 == -1) {
                notificationChannel.enableLights(true);
                notificationChannel.setLightColor(-1);
            }
            notificationManager.createNotificationChannel(notificationChannel);
        }
        Context applicationContext = getApplicationContext();
        Stop stop2 = o;
        Intent intent = new Intent(applicationContext, HomeActivity.class);
        intent.setFlags(603979776);
        String name = EndTripActivity.a.END_TRIP.name();
        Intent intent2 = new Intent(applicationContext, EndTripActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("real_Action", name);
        intent2.putExtras(bundle);
        intent2.setAction(name);
        PendingIntent activity = PendingIntent.getActivity(applicationContext, 1, intent2, 0);
        PendingIntent activity2 = PendingIntent.getActivity(applicationContext, 0, intent, 0);
        int b = q5.b(applicationContext, R.color.orange_primary);
        f5 f5Var = new f5(applicationContext, null);
        f5Var.v.icon = R.drawable.eta_notification;
        f5Var.q = b;
        String name2 = stop2.getName();
        if (i2 == 18000) {
            str = applicationContext.getString(R.string.you_are_not_moving);
        } else if (i2 == -1) {
            str = applicationContext.getString(R.string.please_wait_eta_fetching);
        } else {
            String k2 = jh1.k((long) (i2 * Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL));
            if ("<1 min".equals(k2)) {
                str = applicationContext.getString(R.string.get_ready_step_out);
            } else {
                StringBuilder k0 = hj1.k0(k2, " ");
                k0.append(String.format(applicationContext.getString(R.string.to).toLowerCase(), name2));
                str = k0.toString();
            }
        }
        f5Var.g(str);
        if (stop != null) {
            f5Var.f(applicationContext.getString(R.string.next) + stop.getName());
        }
        f5Var.g = activity2;
        f5Var.a(R.drawable.endtrip_notification_white, applicationContext.getString(R.string.end_trip), activity);
        if (i3 >= 26) {
            f5Var.t = "myChannel";
        }
        f5Var.i(2, true);
        f5Var.j = 2;
        startForeground(1, f5Var.b());
    }

    public final void c(String str, String str2, String str3, long j2) {
        ed1 ed1 = new ed1(str, Long.MIN_VALUE);
        if (str2 != null) {
            ed1.a("source", str2);
        }
        if (str3 != null) {
            ed1.a("reason", str3);
        }
        Stop stop = n;
        if (stop != null) {
            ed1.a(FirebaseAnalytics.Param.ORIGIN, stop.getName());
        }
        ed1.a(FirebaseAnalytics.Param.DESTINATION, o.getName());
        ed1.a("route", m.getRouteName());
        ed1.a("mode", m.getMode().name());
        ed1.a("duration", j2 + "");
        jz5.b().g(ed1);
    }

    public final void d(CheckedinEvent.STATE state, CheckedinEvent.STOP_SOURCE stop_source) {
        CheckedinEvent checkedinEvent = new CheckedinEvent();
        checkedinEvent.state = state;
        checkedinEvent.startStop = n;
        checkedinEvent.destinationStop = o;
        checkedinEvent.route = m;
        if (stop_source != null) {
            checkedinEvent.stopSource = stop_source;
        }
        jz5.b().i(checkedinEvent);
    }

    public final LocationRequest e(int i2) {
        LocationRequest locationRequest = new LocationRequest();
        locationRequest.m1(100);
        long j2 = (long) (i2 * Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL);
        locationRequest.l1(j2);
        LocationRequest.n1(j2);
        locationRequest.i = true;
        locationRequest.h = j2;
        locationRequest.l = 1.0f;
        return locationRequest;
    }

    public final void f(CheckedinEvent.STOP_SOURCE stop_source) {
        if (l) {
            stopForeground(true);
            String str = k;
            if (str != null) {
                if (this.j != null) {
                    ((z30) this.i).b.child(str).child("status").removeEventListener(this.j);
                }
                h20 h20 = this.i;
                String str2 = k;
                z30 z30 = (z30) h20;
                Objects.requireNonNull(z30);
                String str3 = h20.a.STATUS_CHANGED.toString();
                String C = hj1.C(xt.f3961a);
                StreamStatus streamStatus = StreamStatus.CLOSED;
                HashMap n0 = hj1.n0("city", C, "streamId", str2);
                n0.put(LoggingConstants.STREAM_STATUS, streamStatus.toString());
                z30.a(str3, n0);
            }
            k = null;
            l = false;
            this.f.d(this.g);
            p = null;
            jz5.b().l(ETAEvent.class);
            jz5.b().l(DestinationEvent.class);
            d(CheckedinEvent.STATE.STOP, stop_source);
        }
        stopSelf();
    }

    public final void g() {
        int indexOf;
        int a2 = p.a();
        Stop stop = p.i;
        if (stop == null && k == null && (indexOf = m.getStopSequence().indexOf(n) + 1) < m.getStopSequence().size()) {
            stop = m.getStopSequence().get(indexOf);
        }
        r = stop;
        a(a2, stop);
        Stop stop2 = r;
        ETAEvent eTAEvent = new ETAEvent();
        eTAEvent.eta = a2;
        eTAEvent.nextStop = stop2;
        eTAEvent.destination = o;
        eTAEvent.origin = n;
        jz5.b().i(eTAEvent);
        Stop stop3 = r;
        if (q && stop3 != null && !stop3.equals(stop3)) {
            i80 f0 = xt.f3961a.f0();
            StringBuilder i0 = hj1.i0("Next Stop ");
            i0.append(stop3.getName());
            f0.a(i0.toString());
        }
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        xt.t1 t1Var = xt.f3961a;
        this.f = t1Var.B();
        this.i = t1Var.N();
        q = t1Var.f0().isConnected();
        jz5 b = jz5.b();
        b.k(this, b.e, true, 0);
    }

    public void onDestroy() {
        super.onDestroy();
        jz5.b().o(this);
    }

    public void onEvent(LocationTrackingEvent locationTrackingEvent) {
        LocationTrackingEvent.ACTION action = locationTrackingEvent.getAction();
        if (action.equals(LocationTrackingEvent.ACTION.START)) {
            m = locationTrackingEvent.getRouteWithoutTimings();
            n = locationTrackingEvent.getOrigin();
            o = locationTrackingEvent.getDestination();
            int indexOf = m.getStopSequence().indexOf(n) + 1;
            if (indexOf >= m.getStopSequence().size()) {
                indexOf--;
            }
            r = m.getStopSequence().get(indexOf);
            this.h = locationTrackingEvent.isVerified();
            if (!l) {
                c("checkin started", "client", null, 0);
                p = new v80(getApplicationContext(), m, o, this.h);
                l = true;
                LocationRequest e = e(4);
                d(CheckedinEvent.STATE.START, null);
                w80 w80 = new w80(this);
                this.g = w80;
                this.f.b(e, w80);
            }
        } else if (action.equals(LocationTrackingEvent.ACTION.STOP)) {
            long b = p.b();
            f(CheckedinEvent.STOP_SOURCE.USER);
            c("checkin closed", "client", "user action", b);
        }
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        return 2;
    }

    public void onTaskRemoved(Intent intent) {
    }

    public void onEvent(CheckInDestinationUpdated checkInDestinationUpdated) {
        Stop updatedDestination = checkInDestinationUpdated.getUpdatedDestination();
        o = updatedDestination;
        v80 v80 = p;
        v80.g = updatedDestination;
        a(v80.a(), o);
        String str = k;
        if (str != null) {
            h20 h20 = this.i;
            Stop stop = o;
            int a2 = p.a();
            z30 z30 = (z30) h20;
            Objects.requireNonNull(z30);
            HashMap hashMap = new HashMap();
            hashMap.put("streamId", str);
            hashMap.put("destinationStopId", stop.getId());
            hashMap.put("destinationEta", Integer.valueOf(a2));
            z30.a(h20.a.UPDATE_DESTINATION.toString(), hashMap);
        }
        g();
        c("checkin destination updated", "client", null, p.b());
    }
}
