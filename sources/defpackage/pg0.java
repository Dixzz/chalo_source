package defpackage;

import app.zophop.models.Favourites.BusFavourite;
import app.zophop.models.Favourites.Favourite;
import app.zophop.models.TransitMode;
import app.zophop.ui.activities.RouteDetailsActivity;
import app.zophop.ui.activities.TripPlanningStopBasedActivity;

/* renamed from: pg0  reason: default package */
/* compiled from: TripPlanningStopBasedActivity */
public class pg0 implements ci1<Favourite> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TripPlanningStopBasedActivity f2802a;

    public pg0(TripPlanningStopBasedActivity tripPlanningStopBasedActivity) {
        this.f2802a = tripPlanningStopBasedActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.ci1
    public void a(Favourite favourite) {
        RouteDetailsActivity.w0(this.f2802a, ((BusFavourite) favourite).getRouteId(), null, null, TransitMode.bus, "favoriteScreen");
    }
}
