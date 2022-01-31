package defpackage;

import android.view.View;
import android.widget.PopupWindow;
import app.zophop.models.Favourites.Favourite;

/* renamed from: hc1  reason: default package */
/* compiled from: FavoriteCard */
public class hc1 implements View.OnClickListener {
    public final /* synthetic */ PopupWindow f;
    public final /* synthetic */ gc1 g;

    public hc1(gc1 gc1, PopupWindow popupWindow) {
        this.g = gc1;
        this.f = popupWindow;
    }

    public void onClick(View view) {
        gc1 gc1 = this.g;
        ci1<Favourite> ci1 = gc1.g;
        if (ci1 != null) {
            ci1.a(gc1.f);
        }
        this.f.dismiss();
    }
}
