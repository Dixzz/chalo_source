package defpackage;

import android.app.Activity;
import android.view.View;
import app.zophop.models.Favourites.RecentTrips;
import app.zophop.ui.activities.TripPlanningActivity;
import com.google.android.gms.maps.model.LatLng;

/* renamed from: aj0  reason: default package */
/* compiled from: FavoriteListAdapter */
public class aj0 implements View.OnClickListener {
    public final /* synthetic */ RecentTrips f;
    public final /* synthetic */ bj0 g;

    public aj0(bj0 bj0, RecentTrips recentTrips) {
        this.g = bj0;
        this.f = recentTrips;
    }

    public void onClick(View view) {
        xt.f3961a.X().c(this.f);
        TripPlanningActivity.m0((Activity) this.g.g, this.f.getFromLocation(), this.f.getToLocation(), true);
        LatLng latLng = this.f.getToLocation().f2368a;
        wk0.e(this.f.getFromLocation().c, this.f.getToLocation().c, null);
    }
}
