package defpackage;

import android.view.View;
import app.zophop.models.RouteInfo;
import app.zophop.models.TransitMode;
import app.zophop.ui.activities.RouteDetailsActivity;

/* renamed from: zi0  reason: default package */
/* compiled from: FavoriteListAdapter */
public class zi0 implements View.OnClickListener {
    public final /* synthetic */ RouteInfo f;
    public final /* synthetic */ bj0 g;

    public zi0(bj0 bj0, RouteInfo routeInfo) {
        this.g = bj0;
        this.f = routeInfo;
    }

    public void onClick(View view) {
        if (ui1.e0()) {
            bj0.b(this.g, this.f.getAgencyName(), this.f.getRouteName(), this.f.getFirstStopName(), "stop based trip planning");
        } else {
            bj0.b(this.g, this.f.getAgencyName(), this.f.getRouteName(), this.f.getFirstStopName(), "universal search");
        }
        RouteDetailsActivity.w0(this.g.g, this.f.getRouteId(), null, null, TransitMode.bus, "popular routes");
    }
}
