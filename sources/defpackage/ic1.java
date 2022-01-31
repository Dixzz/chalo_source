package defpackage;

import android.view.View;
import android.widget.PopupWindow;
import app.zophop.models.Favourites.Favourite;
import app.zophop.models.Favourites.RouteStoreType;
import app.zophop.models.Favourites.StopBasedTripFavourite;
import app.zophop.models.Favourites.TripFavourite;

/* renamed from: ic1  reason: default package */
/* compiled from: FavoriteCard */
public class ic1 implements View.OnClickListener {
    public final /* synthetic */ RouteStoreType f;
    public final /* synthetic */ PopupWindow g;
    public final /* synthetic */ gc1 h;

    public ic1(gc1 gc1, RouteStoreType routeStoreType, PopupWindow popupWindow) {
        this.h = gc1;
        this.f = routeStoreType;
        this.g = popupWindow;
    }

    public void onClick(View view) {
        Favourite favourite = this.h.f;
        if (favourite instanceof TripFavourite) {
            xt.f3961a.i0().e(this.h.f.getId());
        } else if (favourite instanceof StopBasedTripFavourite) {
            xt.f3961a.i0().f(this.h.f.getId());
        } else {
            xt.f3961a.r().r(this.h.f, this.f);
        }
        gc1 gc1 = this.h;
        ci1<Favourite> ci1 = gc1.i;
        if (ci1 != null) {
            ci1.a(gc1.f);
        }
        this.g.dismiss();
    }
}
