package defpackage;

import android.view.View;
import app.zophop.models.Favourites.RouteStoreType;
import app.zophop.models.RouteInfo;
import app.zophop.ui.activities.RouteDetailsActivity;
import app.zophop.ui.activities.UniversalPickerActivity;

/* renamed from: zk0  reason: default package */
/* compiled from: UniversalSearchAdapter */
public class zk0 implements View.OnClickListener {
    public final /* synthetic */ RouteInfo f;
    public final /* synthetic */ wk0 g;

    public zk0(wk0 wk0, RouteInfo routeInfo) {
        this.g = wk0;
        this.f = routeInfo;
    }

    public void onClick(View view) {
        wk0 wk0 = this.g;
        RouteInfo routeInfo = this.f;
        RouteDetailsActivity.w0(wk0.f, routeInfo.getRouteId(), null, null, routeInfo.getTransitMode(), "pick route location");
        UniversalPickerActivity.k0(routeInfo.getAgencyName(), routeInfo.getRouteName(), routeInfo.getFirstStopName(), wk0.h, vn.K0(wk0.f), false, routeInfo.isFreeRide());
        c80 r = xt.f3961a.r();
        String routeId = routeInfo.getRouteId();
        RouteStoreType routeStoreType = RouteStoreType.RECENT;
        if (r.p(routeId, routeStoreType)) {
            r.e(r.h(routeInfo.getRouteId(), routeStoreType));
        } else {
            r.d(routeInfo.getRouteId(), routeInfo.getRouteName(), routeInfo.getFirstStopName(), routeInfo.getLastStopName(), null, routeInfo.getAgencyName(), routeInfo.get_updateSpecialFeaturesList(), routeInfo.isFreeRide(), routeInfo.getTransitMode());
        }
        ui1.t0("schedulerUsed");
    }
}
