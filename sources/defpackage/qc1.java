package defpackage;

import android.content.Intent;
import android.view.View;
import app.zophop.models.Stop;
import app.zophop.models.TransitMode;
import app.zophop.models.http_response.TripSummary;
import app.zophop.ui.activities.RouteDetailsActivity;
import app.zophop.ui.activities.TripActivity;
import java.util.Objects;
import server.zophop.logging.LoggingConstants;

/* renamed from: qc1  reason: default package */
/* compiled from: NearbyStopActivityCard */
public class qc1 implements View.OnClickListener {
    public final /* synthetic */ Stop f;
    public final /* synthetic */ TripSummary g;
    public final /* synthetic */ pc1 h;

    public qc1(pc1 pc1, Stop stop, TripSummary tripSummary) {
        this.h = pc1;
        this.f = stop;
        this.g = tripSummary;
    }

    public void onClick(View view) {
        pc1 pc1 = this.h;
        Stop stop = this.f;
        String routeId = this.g.getRouteId();
        String routeName = this.g.getRouteName();
        String name = this.g.getFirstStop().getName();
        String name2 = this.g.getLastStop().getName();
        int i = pc1.y;
        Objects.requireNonNull(pc1);
        ed1 ed1 = new ed1("nearby stops activity card route clicked", Long.MIN_VALUE);
        ed1.a("stopId", stop.getId());
        ed1.a("stopName", stop.getName());
        ed1.a("routeName", routeName);
        ed1.a(LoggingConstants.ROUTE_ID, routeId);
        hj1.p(ed1, "fromName", name, "toName", name2).g(ed1);
        TransitMode transitMode = this.h.getMode();
        if (transitMode.equals(TransitMode.bus) || this.g.isFrequencyTrip()) {
            RouteDetailsActivity.w0(this.h.f, this.g.getRouteId(), this.g.getFirstStop(), this.g.getLastStop(), transitMode, "Nearby stops activity card");
            ui1.r0(" route details", "nearby stops", transitMode.toString());
            return;
        }
        Intent intent = new Intent(this.h.f, TripActivity.class);
        intent.putExtra("trip_id", this.g.getTripId());
        intent.putExtra("stop_id", this.h.getStop().getId());
        intent.putExtra(LoggingConstants.ROUTE_ID, this.g.getRouteId());
        intent.putExtra("transit_mode", transitMode.toString());
        intent.putExtra("routeName", this.g.getRouteName());
        intent.putExtra("source", "Nearby stops activity card");
        this.h.f.startActivity(intent);
        ui1.r0("trip activity", "nearby stops", transitMode.toString());
    }
}
