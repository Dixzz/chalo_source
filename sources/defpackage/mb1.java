package defpackage;

import android.view.View;
import android.widget.LinearLayout;
import app.zophop.R;

/* renamed from: mb1  reason: default package */
/* compiled from: PopularRouteCard */
public class mb1 extends LinearLayout {
    public static final /* synthetic */ int f = 0;

    private View getRecentDivider() {
        View view = new View(null);
        view.setBackgroundColor(getResources().getColor(R.color.black));
        view.setAlpha(0.12f);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) getResources().getDimension(R.dimen.home_screen_favorite_card_divider)));
        return view;
    }
}
