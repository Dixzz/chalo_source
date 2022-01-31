package defpackage;

import android.view.ViewTreeObserver;
import app.zophop.R;
import app.zophop.ui.activities.TripDetailsActivity;

/* renamed from: zf0  reason: default package */
/* compiled from: TripDetailsActivity */
public class zf0 implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ TripDetailsActivity f;

    /* renamed from: zf0$a */
    /* compiled from: TripDetailsActivity */
    public class a implements Runnable {
        public a() {
        }

        public void run() {
            TripDetailsActivity tripDetailsActivity = zf0.this.f;
            tripDetailsActivity._panelLayout.setPanelHeight(tripDetailsActivity.getResources().getDimensionPixelOffset(R.dimen.route_subscribe_button_height));
            TripDetailsActivity tripDetailsActivity2 = zf0.this.f;
            tripDetailsActivity2._panelLayout.setScrollableView(tripDetailsActivity2._listView);
        }
    }

    public zf0(TripDetailsActivity tripDetailsActivity) {
        this.f = tripDetailsActivity;
    }

    public void onGlobalLayout() {
        this.f._panelLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        this.f._panelLayout.postDelayed(new a(), 500);
    }
}
