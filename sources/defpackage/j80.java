package defpackage;

import app.zophop.models.Favourites.Favourite;
import app.zophop.models.Favourites.StopBasedTripFavourite;
import app.zophop.models.Favourites.TripFavourite;
import java.util.List;

/* renamed from: j80  reason: default package */
/* compiled from: ITripsRecentStore */
public interface j80 {
    void a(StopBasedTripFavourite stopBasedTripFavourite);

    void b(Favourite favourite);

    List<TripFavourite> c();

    List<StopBasedTripFavourite> d();

    void e(String str);

    void f(String str);

    void g(TripFavourite tripFavourite);
}
