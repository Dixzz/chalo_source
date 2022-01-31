package defpackage;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import app.zophop.models.Stop;
import app.zophop.models.TransitMode;
import app.zophop.models.http_response.TripSummary;
import app.zophop.ui.activities.RouteDetailsActivity;
import com.google.android.gms.maps.model.LatLng;
import java.util.Objects;
import server.zophop.logging.LoggingConstants;

/* renamed from: sc1  reason: default package */
/* compiled from: NearbyStopTripCard */
public class sc1 implements View.OnClickListener {
    public final /* synthetic */ Stop f;
    public final /* synthetic */ TripSummary g;
    public final /* synthetic */ rc1 h;

    public sc1(rc1 rc1, Stop stop, TripSummary tripSummary) {
        this.h = rc1;
        this.f = stop;
        this.g = tripSummary;
    }

    public void onClick(View view) {
        rc1 rc1 = this.h;
        Stop stop = this.f;
        String routeId = this.g.getRouteId();
        String routeName = this.g.getRouteName();
        String name = this.g.getFirstStop().getName();
        String name2 = this.g.getLastStop().getName();
        LatLng latLng = rc1.s;
        Objects.requireNonNull(rc1);
        ed1 ed1 = new ed1("nearby stops card route clicked", Long.MIN_VALUE);
        ed1.a("stopId", stop.getId());
        ed1.a("stopName", stop.getName());
        ed1.a("routeName", routeName);
        ed1.a(LoggingConstants.ROUTE_ID, routeId);
        hj1.p(ed1, "fromName", name, "toName", name2).g(ed1);
        Context context = this.h.f;
        String routeId2 = this.g.getRouteId();
        Stop firstStop = this.g.getFirstStop();
        Stop lastStop = this.g.getLastStop();
        TransitMode transitMode = TransitMode.bus;
        String name3 = this.f.getName();
        String id = this.f.getId();
        Intent r0 = RouteDetailsActivity.r0(context, routeId2, firstStop, lastStop, transitMode, "Nearby stop trip card");
        r0.putExtra("extra_trigger_stop", name3);
        r0.putExtra("extra_trigger_stop_id", id);
        context.startActivity(r0);
    }
}
