package defpackage;

import android.content.Intent;
import app.zophop.models.http_response.TripSummary;
import app.zophop.ui.activities.TripActivity;
import app.zophop.ui.activities.TripSchedulesActivity;
import server.zophop.logging.LoggingConstants;

/* renamed from: xg0  reason: default package */
/* compiled from: TripSchedulesActivity */
public class xg0 implements ci1<TripSummary> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TripSchedulesActivity f3925a;

    public xg0(TripSchedulesActivity tripSchedulesActivity) {
        this.f3925a = tripSchedulesActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.ci1
    public void a(TripSummary tripSummary) {
        TripSummary tripSummary2 = tripSummary;
        tripSummary2.getTripId();
        tripSummary2.getRouteId();
        Intent intent = new Intent(this.f3925a, TripActivity.class);
        intent.putExtra("trip_id", tripSummary2.getTripId());
        intent.putExtra("stop_id", this.f3925a.m);
        intent.putExtra("end_stop_id", this.f3925a.o);
        intent.putExtra(LoggingConstants.ROUTE_ID, tripSummary2.getRouteId());
        intent.putExtra("routeName", tripSummary2.getRouteName());
        intent.putExtra("transit_mode", this.f3925a.p);
        intent.putExtra("source", "tripSchedulesScreen");
        this.f3925a.startActivity(intent);
    }
}
