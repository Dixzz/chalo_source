package defpackage;

import android.content.Intent;
import android.view.View;
import app.zophop.models.Stop;
import app.zophop.models.TransitMode;
import app.zophop.ui.activities.RouteDetailsActivity;
import app.zophop.ui.activities.TripActivity;
import java.util.Objects;
import server.zophop.logging.LoggingConstants;
import zophop.models.Leg;
import zophop.models.LegMode;
import zophop.models.TripAndArrivalInfoTuple;

/* renamed from: uc1  reason: default package */
/* compiled from: OfflineSchedulerCard */
public class uc1 implements View.OnClickListener {
    public final /* synthetic */ TripAndArrivalInfoTuple f;
    public final /* synthetic */ Leg g;
    public final /* synthetic */ wc1 h;

    public uc1(wc1 wc1, TripAndArrivalInfoTuple tripAndArrivalInfoTuple, Leg leg) {
        this.h = wc1;
        this.f = tripAndArrivalInfoTuple;
        this.g = leg;
    }

    public void onClick(View view) {
        boolean isFrequencyTrip = this.f.getTrip().isFrequencyTrip();
        String route_id = this.f.getTrip().getRoute_id();
        String trip_id = this.f.getTrip().getTrip_id();
        String route_name = this.f.getTrip().getRoute_name();
        if (isFrequencyTrip) {
            wc1 wc1 = this.h;
            Stop l = vn.l(this.g.first_stop);
            Stop l2 = vn.l(this.g.last_stop);
            Leg leg = this.g;
            int i = wc1.j;
            Objects.requireNonNull(wc1);
            RouteDetailsActivity.w0(wc1.f, route_id, l, l2, TransitMode.getTransitMode(leg.mode.name().toLowerCase()), "schedulesDescriptionScreen");
            wc1.b(" route details", leg.mode);
            return;
        }
        wc1 wc12 = this.h;
        String stop_id = this.g.first_stop.getStop_id();
        String stop_id2 = this.g.last_stop.getStop_id();
        LegMode legMode = this.g.mode;
        int i2 = wc1.j;
        Objects.requireNonNull(wc12);
        Intent intent = new Intent(wc12.f, TripActivity.class);
        intent.putExtra("trip_id", trip_id);
        intent.putExtra("stop_id", stop_id);
        intent.putExtra("end_stop_id", stop_id2);
        intent.putExtra(LoggingConstants.ROUTE_ID, route_id);
        intent.putExtra("routeName", route_name);
        intent.putExtra("transit_mode", TransitMode.getTransitMode(legMode.toString()).toString());
        intent.putExtra("source", "schedulesDescriptionScreen");
        wc12.f.startActivity(intent);
        wc12.b("trip activity", legMode);
    }
}
