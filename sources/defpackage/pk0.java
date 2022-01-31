package defpackage;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import app.zophop.models.Stop;
import app.zophop.models.TransitMode;
import app.zophop.ui.activities.RouteDetailsActivity;
import app.zophop.ui.activities.TripActivity;
import server.zophop.logging.LoggingConstants;
import zophop.models.Leg;
import zophop.models.LegMode;

/* renamed from: pk0  reason: default package */
/* compiled from: TripDetailsAdapter */
public class pk0 implements View.OnClickListener {
    public final /* synthetic */ Leg f;
    public final /* synthetic */ ok0 g;

    public pk0(ok0 ok0, Leg leg) {
        this.g = ok0;
        this.f = leg;
    }

    public void onClick(View view) {
        Stop l = vn.l(this.f.first_stop);
        Stop l2 = vn.l(this.f.last_stop);
        TransitMode transitMode = TransitMode.getTransitMode(this.f.mode.toString());
        if (transitMode.equals(TransitMode.bus) || transitMode.equals(TransitMode.metro) || transitMode.equals(TransitMode.monorail) || transitMode.equals(TransitMode.ferry)) {
            Context context = this.g.f;
            Intent r0 = RouteDetailsActivity.r0(context, this.f.route_id, l, l2, transitMode, "trip details screen");
            r0.putExtra("isBoardingStopBasedOnLocation", false);
            context.startActivity(r0);
        } else if (this.f.mode.equals(LegMode.RAILWAY)) {
            Intent intent = new Intent(this.g.f, TripActivity.class);
            intent.putExtra("trip_id", this.f.trip_id);
            intent.putExtra("stop_id", l.getId());
            intent.putExtra("end_stop_id", l2.getId());
            intent.putExtra(LoggingConstants.ROUTE_ID, this.f.route_id);
            intent.putExtra("transit_mode", transitMode.toString());
            intent.putExtra("routeName", this.f.route_name);
            intent.putExtra("source", "trip details activity");
            this.g.f.startActivity(intent);
        }
    }
}
