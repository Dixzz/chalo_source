package defpackage;

import app.zophop.models.Favourites.BusFavourite;
import app.zophop.models.Favourites.Favourite;
import app.zophop.models.Favourites.RailFavourite;
import app.zophop.models.TransitMode;
import app.zophop.ui.activities.FavoriteListActivity;
import app.zophop.ui.activities.RouteDetailsActivity;
import app.zophop.ui.activities.SchedulerActivity;

/* renamed from: ae0  reason: default package */
/* compiled from: FavoriteListActivity */
public class ae0 implements ci1<Favourite> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FavoriteListActivity f154a;

    public ae0(FavoriteListActivity favoriteListActivity) {
        this.f154a = favoriteListActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.ci1
    public void a(Favourite favourite) {
        Favourite favourite2 = favourite;
        if (favourite2 instanceof RailFavourite) {
            SchedulerActivity.j0(this.f154a, favourite2, "favoriteScreen");
        } else {
            RouteDetailsActivity.w0(this.f154a, ((BusFavourite) favourite2).getRouteId(), null, null, TransitMode.bus, "favoriteScreen");
        }
    }
}
