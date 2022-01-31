package defpackage;

import app.zophop.models.Favourites.Favourite;
import app.zophop.models.Favourites.RouteStoreType;
import app.zophop.models.Favourites.StopFavourite;
import app.zophop.models.Stop;
import java.util.List;

/* renamed from: h80  reason: default package */
/* compiled from: IStopRecentStore */
public interface h80 {
    void a(Stop stop);

    void b(Favourite favourite);

    List<StopFavourite> c(RouteStoreType routeStoreType);

    void d(Stop stop);

    void e(Favourite favourite);
}
