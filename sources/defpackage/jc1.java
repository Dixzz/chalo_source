package defpackage;

import android.view.View;
import android.widget.PopupWindow;
import app.zophop.models.Favourites.Favourite;
import app.zophop.models.Favourites.RouteStoreType;
import defpackage.xt;

/* renamed from: jc1  reason: default package */
/* compiled from: FavoriteCard */
public class jc1 implements View.OnClickListener {
    public final /* synthetic */ PopupWindow f;
    public final /* synthetic */ gc1 g;

    public jc1(gc1 gc1, PopupWindow popupWindow) {
        this.g = gc1;
        this.f = popupWindow;
    }

    public void onClick(View view) {
        xt.t1 t1Var = xt.f3961a;
        c80 r = t1Var.r();
        Favourite favourite = this.g.f;
        r.r(favourite, favourite.getRouteStoreType());
        t1Var.r().a(this.g.f, RouteStoreType.FAVORITE);
        gc1 gc1 = this.g;
        ci1<Favourite> ci1 = gc1.j;
        if (ci1 != null) {
            ci1.a(gc1.f);
        }
        this.f.dismiss();
    }
}
